package es.ieci.tecdoc.fwktd.dir3.api.service.impl;

import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.ieci.tecdoc.fwktd.dir3.api.helper.XmlDcoToObject;
import es.ieci.tecdoc.fwktd.dir3.api.manager.DatosBasicosOficinaManager;
import es.ieci.tecdoc.fwktd.dir3.api.manager.DatosBasicosUnidadOrganicaManager;
import es.ieci.tecdoc.fwktd.dir3.api.manager.EstadoActualizacionDCOManager;
import es.ieci.tecdoc.fwktd.dir3.api.manager.GenerateScriptSQLManager;
import es.ieci.tecdoc.fwktd.dir3.api.vo.EstadoActualizacionDcoVO;
import es.ieci.tecdoc.fwktd.dir3.api.vo.oficina.OficinasVO;
import es.ieci.tecdoc.fwktd.dir3.api.vo.unidad.OrganismosVO;
import es.ieci.tecdoc.fwktd.dir3.core.service.ServicioActualizacionDirectorioComun;
import es.ieci.tecdoc.fwktd.dir3.services.ServicioObtenerActualizacionesDCO;

/**
 * Implementacion por defecto del servicio de actualizaci�n del DCO
 *
 */
public class ServicioActualizacionDirectorioComunImpl implements ServicioActualizacionDirectorioComun{

	/**
	 * Servicio para obtener los ficheros de actualizaci�n del DCO
	 */
	protected ServicioObtenerActualizacionesDCO servicioObtenerActualizacionesDCO;
	/**
	 * Manager para la gesti�n de oficinas
	 */
	protected DatosBasicosOficinaManager datosBasicosOficinaManager;
	/**
	 * Manager para la gesti�n de unidades org�nicas
	 */
	protected DatosBasicosUnidadOrganicaManager datosBasicosUnidadOrganicaManager;
	/**
	 * Manager para la gesti�n de unidades org�nicas
	 */
	protected EstadoActualizacionDCOManager estadoActualizacionDCOManager;

	protected GenerateScriptSQLManager generateScriptSQLOficinaManager;
	protected GenerateScriptSQLManager generateScriptSQLUnidadOrganicaManagerImpl;

	private static final Logger logger = LoggerFactory
			.getLogger(ServicioActualizacionDirectorioComunImpl.class);

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * es.ieci.tecdoc.fwktd.dir3.core.service.ServicioActualizacionDirectorioComun
	 * #actualizarDirectorioComun()
	 */
	public void actualizarDirectorioComun() {
		if(logger.isDebugEnabled()){
			logger.debug("Comienza la actualizaci�n del sistema");
		}

		//Obtenemos la fecha de la ultima actualizacion
		EstadoActualizacionDcoVO estadoActualizacion = estadoActualizacionDCOManager.getLastSuccessUpdate();
		if(logger.isDebugEnabled()){
			StringBuffer sb = new StringBuffer();
			sb.append("Los datos de la �ltima actualizaci�n son: ")
			  .append(estadoActualizacion);
			logger.debug(sb.toString());
		}

		//Obtenemos los ficheros con los datos
		String fileInicializarOficinas = getServicioObtenerActualizacionesDCO()
				.getFicheroActualizarOficinasDCO(
						estadoActualizacion.getFechaActualizacion());

		String fileInicializarUnidades = getServicioObtenerActualizacionesDCO()
				.getFicheroActualizarUnidadesDCO(
						estadoActualizacion.getFechaActualizacion());

		//Transformamos los datos de los ficheros a VOs
		OficinasVO oficinasDCO = XmlDcoToObject.getInstance().getOficinasFromXmlFile(fileInicializarOficinas);
		OrganismosVO organismosDCO = XmlDcoToObject.getInstance().getOrganismosFromXmlFile(fileInicializarUnidades);

		//Actualizamos los datos
		getDatosBasicosOficinaManager().updateDatosBasicosOficinas(oficinasDCO);
		getDatosBasicosUnidadOrganicaManager().updateDatosBasicosUnidadesOrganicas(organismosDCO);
		if(logger.isDebugEnabled()){
			logger.debug("Actualizados los datos de oficinas y organismos");
		}


		//Actualizamos la fecha de ultima actualizacion
		estadoActualizacion.setFechaActualizacion(Calendar.getInstance().getTime());
		getEstadoActualizacionDCOManager().update(estadoActualizacion);

		if(logger.isDebugEnabled()){
			logger.debug("Finaliza la actualizaci�n del sistema");
		}

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * es.ieci.tecdoc.fwktd.dir3.core.service.ServicioActualizacionDirectorioComun
	 * #generateScriptsActualizacionDirectorioComun()
	 */
	public void generateScriptsActualizacionDirectorioComun() {
		if(logger.isDebugEnabled()){
			logger.debug("Comienza la generaci�n de los script de actualizaci�n del sistema");
		}

		//Obtenemos la fecha de la ultima actualizacion
		Date lastDateUpdate = estadoActualizacionDCOManager.getLastSuccessUpdate().getFechaActualizacion();

		if(logger.isDebugEnabled()){
			StringBuffer sb = new StringBuffer();
			sb.append("La fecha de la ultima actualizaci�n es: ")
			  .append(lastDateUpdate.toString());
			logger.debug(sb.toString());
		}

		//Obtenemos los ficheros con los datos
		String fileInicializarOficinas = getServicioObtenerActualizacionesDCO().getFicheroActualizarOficinasDCO(lastDateUpdate);
		String fileInicializarUnidades = getServicioObtenerActualizacionesDCO().getFicheroActualizarUnidadesDCO(lastDateUpdate);

		//Generamos los script
		getGenerateScriptSQLOficinaManager().generateScriptActualizacion(fileInicializarOficinas);
		getGenerateScriptSQLUnidadOrganicaManagerImpl().generateScriptActualizacion(fileInicializarUnidades);
		if(logger.isDebugEnabled()){
			logger.debug("Finaliza la generaci�n de los script de actualizaci�n del sistema");
		}
	}

	public ServicioObtenerActualizacionesDCO getServicioObtenerActualizacionesDCO() {
		return servicioObtenerActualizacionesDCO;
	}

	public void setServicioObtenerActualizacionesDCO(
			ServicioObtenerActualizacionesDCO servicioObtenerActualizacionesDCO) {
		this.servicioObtenerActualizacionesDCO = servicioObtenerActualizacionesDCO;
	}

	public DatosBasicosOficinaManager getDatosBasicosOficinaManager() {
		return datosBasicosOficinaManager;
	}

	public void setDatosBasicosOficinaManager(
			DatosBasicosOficinaManager datosBasicosOficinaManager) {
		this.datosBasicosOficinaManager = datosBasicosOficinaManager;
	}

	public DatosBasicosUnidadOrganicaManager getDatosBasicosUnidadOrganicaManager() {
		return datosBasicosUnidadOrganicaManager;
	}

	public void setDatosBasicosUnidadOrganicaManager(
			DatosBasicosUnidadOrganicaManager datosBasicosUnidadOrganicaManager) {
		this.datosBasicosUnidadOrganicaManager = datosBasicosUnidadOrganicaManager;
	}

	public EstadoActualizacionDCOManager getEstadoActualizacionDCOManager() {
		return estadoActualizacionDCOManager;
	}

	public void setEstadoActualizacionDCOManager(
			EstadoActualizacionDCOManager estadoActualizacionDCOManager) {
		this.estadoActualizacionDCOManager = estadoActualizacionDCOManager;
	}

	public GenerateScriptSQLManager getGenerateScriptSQLOficinaManager() {
		return generateScriptSQLOficinaManager;
	}

	public void setGenerateScriptSQLOficinaManager(
			GenerateScriptSQLManager generateScriptSQLOficinaManager) {
		this.generateScriptSQLOficinaManager = generateScriptSQLOficinaManager;
	}

	public GenerateScriptSQLManager getGenerateScriptSQLUnidadOrganicaManagerImpl() {
		return generateScriptSQLUnidadOrganicaManagerImpl;
	}

	public void setGenerateScriptSQLUnidadOrganicaManagerImpl(
			GenerateScriptSQLManager generateScriptSQLUnidadOrganicaManagerImpl) {
		this.generateScriptSQLUnidadOrganicaManagerImpl = generateScriptSQLUnidadOrganicaManagerImpl;
	}

}
