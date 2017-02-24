package es.ieci.tecdoc.fwktd.dir3.services.impl;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipException;

import javax.naming.NamingException;
import javax.xml.namespace.QName;

import org.apache.log4j.Logger;

import es.ieci.tecdoc.fwktd.dir3.exception.ObtencionFicheroActualizacionDCOException;
import es.ieci.tecdoc.fwktd.dir3.services.ServicioObtenerActualizacionesDCO;
import es.ieci.tecdoc.fwktd.dir3.util.Base64Utils;
import es.ieci.tecdoc.fwktd.dir3.util.ZipUtils;
import es.map.directorio.manager.impl.SC02UNIncrementalDatosBasicosService;
import es.map.directorio.manager.impl.SC12OFIncrementalDatosBasicosService;
import es.map.directorio.manager.impl.wsexport.RespuestaWS;

/**
 * Implementaci�n del servicio de obtenci�n del fichero de actualizaci�n mediante los WS
 * del DCO.
 * 
 */
public class ServicioObtenerActualizacionesDCOWSClientImpl implements
		ServicioObtenerActualizacionesDCO {
	
	/**
	 * Servicio para llamar al WS SC02UNIncrementalDatosBasicos - Actualizaci�n de
	 * Unidades Organicas
	 */
	protected SC02UNIncrementalDatosBasicosService servicioIncrementalUnidades;
	
	/**
	 * URL Servicio para llamar al WS SC02UNIncrementalDatosBasicos - Actualizaci�n de
	 * Unidades Organicas
	 */
	protected String servicioIncrementalUnidadesURL;
	
	/**
	 * Servicio para llamar al WS SC12OFIncrementalDatosBasicos - Actualizaci�n de
	 * Oficinas
	 */
	protected SC12OFIncrementalDatosBasicosService servicioIncrementalOficinas;
	
	/**
	 * URL Servicio para llamar al WS SC12OFIncrementalDatosBasicos - Actualizaci�n de
	 * Oficinas
	 */
	protected String servicioIncrementalOficinasURL;
	
	/**
	 * Directorio para dejar los ficheros
	 */
	protected String tempFilesDir;
	/**
	 * Login del servicio del DCO proporcionado por el ministerio
	 */
	protected String login;
	/**
	 * Password del servicio del DCO proporcionada por el ministerio
	 */
	protected String pass;
	/**
	 * Formato en el que obtener las actualizaciones
	 */
	protected String fileFormat;
	/**
	 * Tipo de consulta para las oficinas
	 */
	protected String oficinasQueryType;
	/**
	 * Tipo de consulta para las unidades organicas
	 */
	protected String unidadesQueryType;
	
	private final String INCREMENTAL_OFICINAS_FILE_NAME =
			"datosBasicosOficinaIncremental.xml";
	private final String INCREMENTAL_UORGANICAS_FILE_NAME =
			"datosBasicosUOrganicaIncremental.xml";
	
	private static final Logger logger = Logger
			.getLogger(ServicioObtenerActualizacionesDCOWSClientImpl.class);
	
	/**
	 * Contructor por defecto que carga la configuracion del servicio
	 * 
	 * @throws MalformedURLException
	 * @throws NamingException
	 */
	public void initServices() throws MalformedURLException {
		if (servicioIncrementalUnidades == null) {
			URL wsdlLocationIU = new URL(servicioIncrementalUnidadesURL);
			QName serviceNameIU =
					new QName("http://impl.manager.directorio.map.es",
							"SC02UN_IncrementalDatosBasicosService");
			servicioIncrementalUnidades =
					new SC02UNIncrementalDatosBasicosService(wsdlLocationIU,
							serviceNameIU);
		}
		if (servicioIncrementalOficinas == null) {
			URL wsdlLocationVOF = new URL(servicioIncrementalOficinasURL);
			QName serviceNameVOF =
					new QName("http://impl.manager.directorio.map.es",
							"SC12OF_IncrementalDatosBasicosService");
			servicioIncrementalOficinas =
					new SC12OFIncrementalDatosBasicosService(wsdlLocationVOF,
							serviceNameVOF);
		}
	}
	
	/**
	 * Obtiene el fichero para actualizar las oficinas.
	 * Retorna el path al fichero xml
	 * 
	 * @param fechaUltimaActualizacion
	 *            - Fecha de �ltima actualizaci�n
	 * @return nombre del fichero de actualizaci�n de Oficinas
	 * 
	 */
	public String
			getFicheroActualizarOficinasDCO(Date fechaUltimaActualizacion) {
		String finalFileName = null;
		
		try {
			initServices();
			if (null == fechaUltimaActualizacion) {
				logger.error("ServicioActualizacionDCOWSClientImpl::getFicheroActualizarOficinasDCO - Error la fecha de �ltima actualizaci�n es nula");
				throw new Exception("No hay fecha de �ltima actualizaci�n");
			}
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			File tempZipFile =
					File.createTempFile("dec", "zip", new File(
							getTempFilesDir()));
			
			RespuestaWS respuesta =
					getServicioIncrementalOficinas()
							.getSC12OFIncrementalDatosBasicos()
							.exportar(
									getLogin(),
									getPass(),
									getFileFormat(),
									getOficinasQueryType(),
									dateFormat.format(fechaUltimaActualizacion),
									dateFormat.format(Calendar.getInstance()
											.getTime()), "", "", "", "", "",
									"", "", "", "", "", "", "", "", "", "", "");
			
			Base64Utils.getInstance().decodeToFile(respuesta.getFichero(),
					tempZipFile.getAbsolutePath());
			List<String> filesUnzipped =
					ZipUtils.getInstance().unzipFile(
							tempZipFile.getAbsolutePath(), getTempFilesDir());
			
			Iterator<String> itr = filesUnzipped.listIterator();
			String fileName;
			while (itr.hasNext()) {
				fileName = itr.next();
				if (fileName.endsWith(INCREMENTAL_OFICINAS_FILE_NAME)) {
					finalFileName = fileName;
				}
			}
		}
		catch (ZipException zipEx) {
			logger.error(
					"ServicioActualizacionDCOWSClientImpl::getFicheroActualizarOficinasDCO - Error al descomprimir el fichero retornado por el DCO.",
					zipEx);
			
		}
		catch (IOException ioEx) {
			logger.error(
					"ServicioActualizacionDCOWSClientImpl::getFicheroActualizarOficinasDCO - Error al crear los ficheros temporales.",
					ioEx);
			
		}
		catch (Exception e) {
			logger.error("Error inesperado", e);
		}
		
		if (finalFileName == null) {
			StringBuffer sb = new StringBuffer();
			sb.append(
					"El proceso ha finalizado sin errores pero no se encuentra el fichero esperado con nombre: ")
					.append(INCREMENTAL_OFICINAS_FILE_NAME);
			
			throw new ObtencionFicheroActualizacionDCOException(sb.toString());
		}
		return finalFileName;
	}
	
	/**
	 * Retorna el path al fichero xml
	 * 
	 * @param fechaUltimaActualizacion
	 *            - Fecha de �ltima actualizaci�n
	 * @return nombre del fichero de actualizaci�n de Unidades
	 */
	public String
			getFicheroActualizarUnidadesDCO(Date fechaUltimaActualizacion) {
		String finalFileName = null;
		
		try {
			initServices();
			if (null == fechaUltimaActualizacion) {
				logger.error("ServicioActualizacionDCOWSClientImpl::getFicheroActualizarUnidadesDCO - Error la fecha de �ltima actualizaci�n es nula");
				throw new Exception("No hay fecha de �ltima actualizaci�n");
			}
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			File tempZipFile =
					File.createTempFile("dec", "zip", new File(
							getTempFilesDir()));
			
			RespuestaWS respuesta =
					getServicioIncrementalUnidades()
							.getSC02UNIncrementalDatosBasicos()
							.exportar(
									getLogin(),
									getPass(),
									getFileFormat(),
									getUnidadesQueryType(),
									dateFormat.format(fechaUltimaActualizacion),
									dateFormat.format(Calendar.getInstance()
											.getTime()), "", "", "", "", "",
									"", "", "", "");
			
			Base64Utils.getInstance().decodeToFile(respuesta.getFichero(),
					tempZipFile.getAbsolutePath());
			List<String> filesUnzipped =
					ZipUtils.getInstance().unzipFile(
							tempZipFile.getAbsolutePath(), getTempFilesDir());
			
			Iterator<String> itr = filesUnzipped.listIterator();
			String fileName;
			while (itr.hasNext()) {
				fileName = itr.next();
				if (fileName.endsWith(INCREMENTAL_UORGANICAS_FILE_NAME)) {
					finalFileName = fileName;
				}
			}
		}
		catch (ZipException zipEx) {
			logger.error(
					"ServicioActualizacionDCOWSClientImpl::getFicheroActualizarUnidadesDCO - Error al descomprimir el fichero retornado por el DCO.",
					zipEx);
			
		}
		catch (IOException ioEx) {
			logger.error(
					"ServicioActualizacionDCOWSClientImpl::getFicheroActualizarUnidadesDCO - Error al crear los ficheros temporales.",
					ioEx);
			
		}
		catch (Exception e) {
			logger.error("Error inesperado", e);
		}
		
		if (finalFileName == null) {
			StringBuffer sb = new StringBuffer();
			sb.append(
					"El proceso ha finalizado sin errores pero no se encuentra el fichero esperado con nombre: ")
					.append(INCREMENTAL_UORGANICAS_FILE_NAME);
			
			throw new ObtencionFicheroActualizacionDCOException(sb.toString());
		}
		return finalFileName;
	}
	
	/**
	 * Obtiene el valor del par�metro servicioIncrementalUnidades.
	 * 
	 * @return servicioIncrementalUnidades valor del campo a obtener.
	 */
	public SC02UNIncrementalDatosBasicosService
			getServicioIncrementalUnidades() {
		return servicioIncrementalUnidades;
	}
	
	/**
	 * Guarda el valor del par�metro servicioIncrementalUnidades.
	 * 
	 * @param servicioIncrementalUnidades
	 *            valor del campo a guardar.
	 */
	public void setServicioIncrementalUnidades(
			SC02UNIncrementalDatosBasicosService servicioIncrementalUnidades) {
		this.servicioIncrementalUnidades = servicioIncrementalUnidades;
	}
	
	/**
	 * Obtiene el valor del par�metro servicioIncrementalOficinas.
	 * 
	 * @return servicioIncrementalOficinas valor del campo a obtener.
	 */
	public SC12OFIncrementalDatosBasicosService
			getServicioIncrementalOficinas() {
		return servicioIncrementalOficinas;
	}
	
	/**
	 * Guarda el valor del par�metro servicioIncrementalOficinas.
	 * 
	 * @param servicioIncrementalOficinas
	 *            valor del campo a guardar.
	 */
	public void setServicioIncrementalOficinas(
			SC12OFIncrementalDatosBasicosService servicioIncrementalOficinas) {
		this.servicioIncrementalOficinas = servicioIncrementalOficinas;
	}
	
	/**
	 * Obtiene el valor del par�metro servicioIncrementalUnidadesURL.
	 * 
	 * @return servicioIncrementalUnidadesURL valor del campo a obtener.
	 */
	public String getServicioIncrementalUnidadesURL() {
		return servicioIncrementalUnidadesURL;
	}
	
	/**
	 * Guarda el valor del par�metro servicioIncrementalUnidadesURL.
	 * 
	 * @param servicioIncrementalUnidadesURL
	 *            valor del campo a guardar.
	 */
	public void setServicioIncrementalUnidadesURL(
			String servicioIncrementalUnidadesURL) {
		this.servicioIncrementalUnidadesURL = servicioIncrementalUnidadesURL;
	}
	
	/**
	 * Obtiene el valor del par�metro servicioIncrementalOficinasURL.
	 * 
	 * @return servicioIncrementalOficinasURL valor del campo a obtener.
	 */
	public String getServicioIncrementalOficinasURL() {
		return servicioIncrementalOficinasURL;
	}
	
	/**
	 * Guarda el valor del par�metro servicioIncrementalOficinasURL.
	 * 
	 * @param servicioIncrementalOficinasURL
	 *            valor del campo a guardar.
	 */
	public void setServicioIncrementalOficinasURL(
			String servicioIncrementalOficinasURL) {
		this.servicioIncrementalOficinasURL = servicioIncrementalOficinasURL;
	}
	
	/**
	 * Obtiene el valor del par�metro tempFilesDir.
	 * 
	 * @return tempFilesDir valor del campo a obtener.
	 */
	public String getTempFilesDir() {
		return tempFilesDir;
	}
	
	/**
	 * Guarda el valor del par�metro tempFilesDir.
	 * 
	 * @param tempFilesDir
	 *            valor del campo a guardar.
	 */
	public void setTempFilesDir(String tempFilesDir) {
		this.tempFilesDir = tempFilesDir;
	}
	
	/**
	 * Obtiene el valor del par�metro login.
	 * 
	 * @return login valor del campo a obtener.
	 */
	public String getLogin() {
		return login;
	}
	
	/**
	 * Guarda el valor del par�metro login.
	 * 
	 * @param login
	 *            valor del campo a guardar.
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	
	/**
	 * Obtiene el valor del par�metro pass.
	 * 
	 * @return pass valor del campo a obtener.
	 */
	public String getPass() {
		return pass;
	}
	
	/**
	 * Guarda el valor del par�metro pass.
	 * 
	 * @param pass
	 *            valor del campo a guardar.
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	/**
	 * Obtiene el valor del par�metro fileFormat.
	 * 
	 * @return fileFormat valor del campo a obtener.
	 */
	public String getFileFormat() {
		return fileFormat;
	}
	
	/**
	 * Guarda el valor del par�metro fileFormat.
	 * 
	 * @param fileFormat
	 *            valor del campo a guardar.
	 */
	public void setFileFormat(String fileFormat) {
		this.fileFormat = fileFormat;
	}
	
	/**
	 * Obtiene el valor del par�metro oficinasQueryType.
	 * 
	 * @return oficinasQueryType valor del campo a obtener.
	 */
	public String getOficinasQueryType() {
		return oficinasQueryType;
	}
	
	/**
	 * Guarda el valor del par�metro oficinasQueryType.
	 * 
	 * @param oficinasQueryType
	 *            valor del campo a guardar.
	 */
	public void setOficinasQueryType(String oficinasQueryType) {
		this.oficinasQueryType = oficinasQueryType;
	}
	
	/**
	 * Obtiene el valor del par�metro unidadesQueryType.
	 * 
	 * @return unidadesQueryType valor del campo a obtener.
	 */
	public String getUnidadesQueryType() {
		return unidadesQueryType;
	}
	
	/**
	 * Guarda el valor del par�metro unidadesQueryType.
	 * 
	 * @param unidadesQueryType
	 *            valor del campo a guardar.
	 */
	public void setUnidadesQueryType(String unidadesQueryType) {
		this.unidadesQueryType = unidadesQueryType;
	}
	
}
