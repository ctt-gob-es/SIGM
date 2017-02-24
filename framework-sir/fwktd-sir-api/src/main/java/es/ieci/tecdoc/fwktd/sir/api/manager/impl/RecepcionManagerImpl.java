package es.ieci.tecdoc.fwktd.sir.api.manager.impl;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.ArrayUtils;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import es.ieci.tecdoc.fwktd.sir.api.manager.AnexoManager;
import es.ieci.tecdoc.fwktd.sir.api.manager.AsientoRegistralManager;
import es.ieci.tecdoc.fwktd.sir.api.manager.AuditoriaFicheroIntercambioManager;
import es.ieci.tecdoc.fwktd.sir.api.manager.AuditoriaMensajeManager;
import es.ieci.tecdoc.fwktd.sir.api.manager.CompresionManager;
import es.ieci.tecdoc.fwktd.sir.api.manager.FechaManager;
import es.ieci.tecdoc.fwktd.sir.api.manager.MensajeManager;
import es.ieci.tecdoc.fwktd.sir.api.manager.RecepcionManager;
import es.ieci.tecdoc.fwktd.sir.api.manager.SicresXMLManager;
import es.ieci.tecdoc.fwktd.sir.api.manager.TrazabilidadManager;
import es.ieci.tecdoc.fwktd.sir.api.types.BandejaEnum;
import es.ieci.tecdoc.fwktd.sir.api.types.EstadoTrazabilidadEnum;
import es.ieci.tecdoc.fwktd.sir.api.types.TipoFicheroEnum;
import es.ieci.tecdoc.fwktd.sir.api.types.TipoMensajeEnum;
import es.ieci.tecdoc.fwktd.sir.api.vo.FicheroIntercambioVO;
import es.ieci.tecdoc.fwktd.sir.api.vo.MensajeVO;
import es.ieci.tecdoc.fwktd.sir.core.exception.ValidacionException;
import es.ieci.tecdoc.fwktd.sir.core.types.ErroresEnum;
import es.ieci.tecdoc.fwktd.sir.core.types.EstadoAsientoRegistralEnum;
import es.ieci.tecdoc.fwktd.sir.core.types.TipoAnotacionEnum;
import es.ieci.tecdoc.fwktd.sir.core.vo.AsientoRegistralVO;
import es.ieci.tecdoc.fwktd.sir.core.vo.TrazabilidadVO;

/**
 * Implementaci�n del gestor de recepci�n de ficheros de intercambio seg�n la
 * normativa SICRES 3.0.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public class RecepcionManagerImpl implements RecepcionManager, Serializable {

    private static final Logger logger = LoggerFactory.getLogger(RecepcionManagerImpl.class);

    private static final String PATRON_FICHERO_DATOS_INTERCAMBIO = ".{21}_\\d{2}_\\d{8}_00_\\d{1,4}.[xX][mM][lL]";
    private static final String PATRON_MENSAJE = ".{21}_\\d{2}_\\d{8}.[xX][mM][lL]";

    /**
     * Gestor de asientos registrales.
     */
    private AsientoRegistralManager asientoRegistralManager = null;

    /**
     * Gestor de anexos.
     */
    private AnexoManager anexoManager = null;

	/**
	 * Gestor de XML de SICRES.
	 */
	private SicresXMLManager sicresXMLManager = null;

	/**
	 * Gestor de fechas.
	 */
	private FechaManager fechaManager = null;

    /**
     * Gestor de compresi�n/descompresi�n de ficheros.
     */
    private CompresionManager compresionManager = null;

    /**
     * Gestor de ficheros de datos de control.
     */
    private MensajeManager mensajeManager = null;

    /**
     * Gestor de auditor�a de mensajes.
     */
    private AuditoriaMensajeManager auditoriaMensajeManager = null;

    /**
     * Gestor de auditor�a de ficheros de datos de intercambio.
     */
    private AuditoriaFicheroIntercambioManager auditoriaFicheroIntercambioManager = null;
    
    /**
     * Gestor de trazabilidad.
     */
    private TrazabilidadManager trazabilidadManager = null;

    /**
     * Directorio temporal para construir el fichero de datos de control
     */
    private String directorioTemporal = null;

    /**
     * Directorio de ficheros recibidos
     */
    private String directorioRecibidos = null;

    /**
     * Directorio para el hist�rico de ficheros recibidos
     */
    private String directorioHistorico = null;

    /**
     * Directorio para los ficheros recibidos con errores
     */
    private String directorioFallidos = null;

    /**
     * Codificaci�n de los ficheros de datos
     */
    private String fileEncoding = null;

    /**
     * Constructor.
     */
    public RecepcionManagerImpl() {
        super();
    }

    public AsientoRegistralManager getAsientoRegistralManager() {
		return asientoRegistralManager;
	}

	public void setAsientoRegistralManager(
			AsientoRegistralManager asientoRegistralManager) {
		this.asientoRegistralManager = asientoRegistralManager;
	}

	public AnexoManager getAnexoManager() {
		return anexoManager;
	}

	public void setAnexoManager(AnexoManager anexoManager) {
		this.anexoManager = anexoManager;
	}

	public SicresXMLManager getSicresXMLManager() {
		return sicresXMLManager;
	}

	public void setSicresXMLManager(SicresXMLManager sicresXMLManager) {
		this.sicresXMLManager = sicresXMLManager;
	}

	public FechaManager getFechaManager() {
		return fechaManager;
	}

	public void setFechaManager(FechaManager fechaManager) {
		this.fechaManager = fechaManager;
	}

	public CompresionManager getCompresionManager() {
        return compresionManager;
    }

    public void setCompresionManager(CompresionManager compresionManager) {
        this.compresionManager = compresionManager;
    }

    public MensajeManager getMensajeManager() {
		return mensajeManager;
	}

	public AuditoriaMensajeManager getAuditoriaMensajeManager() {
		return auditoriaMensajeManager;
	}

	public void setAuditoriaMensajeManager(
			AuditoriaMensajeManager auditoriaMensajeManager) {
		this.auditoriaMensajeManager = auditoriaMensajeManager;
	}

	public AuditoriaFicheroIntercambioManager getAuditoriaFicheroIntercambioManager() {
		return auditoriaFicheroIntercambioManager;
	}

	public void setAuditoriaFicheroIntercambioManager(
			AuditoriaFicheroIntercambioManager auditoriaFicheroIntercambioManager) {
		this.auditoriaFicheroIntercambioManager = auditoriaFicheroIntercambioManager;
	}

	public void setMensajeManager(MensajeManager mensajeManager) {
		this.mensajeManager = mensajeManager;
	}

	public TrazabilidadManager getTrazabilidadManager() {
		return trazabilidadManager;
	}

	public void setTrazabilidadManager(TrazabilidadManager trazabilidadManager) {
		this.trazabilidadManager = trazabilidadManager;
	}

	public String getDirectorioTemporal() {
        return directorioTemporal;
    }

    public void setDirectorioTemporal(String directorioTemporal) {
        this.directorioTemporal = directorioTemporal;
    }

    public String getDirectorioRecibidos() {
        return directorioRecibidos;
    }

    public void setDirectorioRecibidos(String directorioRecibidos) {
        this.directorioRecibidos = directorioRecibidos;
    }

    public String getDirectorioHistorico() {
        return directorioHistorico;
    }

    public void setDirectorioHistorico(String directorioHistorico) {
        this.directorioHistorico = directorioHistorico;
    }

    public String getDirectorioFallidos() {
        return directorioFallidos;
    }

    public void setDirectorioFallidos(String directorioFallidos) {
        this.directorioFallidos = directorioFallidos;
    }

    public String getFileEncoding() {
		return fileEncoding;
	}

	public void setFileEncoding(String fileEncoding) {
		this.fileEncoding = fileEncoding;
	}

	/**
	 * {@inheritDoc}
	 * @see es.ieci.tecdoc.fwktd.sir.api.manager.RecepcionManager#recibirFicheroIntercambio(java.lang.String, java.util.List)
	 */
	public AsientoRegistralVO recibirFicheroIntercambio(String xmlFicheroIntercambio, List<byte[]> documentos) {

        logger.info("Recibiendo fichero de intercambio");
        logger.debug("Fichero de datos de intercambio: [{}]", xmlFicheroIntercambio);

        FicheroIntercambioVO ficheroIntercambio = null;
		AsientoRegistralVO asiento = null;

		try {
			logger.info("----------------------------------------");
			logger.info("----RECIBIENDO FICHERO INTERCAMBIO ----");
			logger.info("------------------------------------------");
	        Assert.hasText(xmlFicheroIntercambio, "'xmlFicheroIntercambio' must not be empty");

			// Cargar la informaci�n del asiento registral
	        ficheroIntercambio = getSicresXMLManager().parseXMLFicheroIntercambio(xmlFicheroIntercambio);

			// Cargar la informaci�n de los documentos
			if (CollectionUtils.isNotEmpty(documentos)) {
				if (ficheroIntercambio.countAnexos() == documentos.size()) {
					for (int i = 0; i < ficheroIntercambio.countAnexos(); i++) {
						ficheroIntercambio.setContenidoAnexo(i, documentos.get(i));
					}
				} else {
					logger.error("No coinciden los documentos anexos con los informados en el registro");
					throw new ValidacionException(ErroresEnum.ERROR_0045);
				}
			}
			logger.info("----------------------------------------");
			logger.info("----RECIBIENDO FICHERO INTERCAMBIO "+ficheroIntercambio.getIdentificadorIntercambio()+"----");
			logger.info("------------------------------------------");
			//logger.info("Fichero de intercambio parseado [{}]", ficheroIntercambio.getIdentificadorIntercambio());
			logger.debug("Informaci�n del fichero de intercambio parseado: {}", ficheroIntercambio);

			asiento = recibirFicheroIntercambio(ficheroIntercambio, xmlFicheroIntercambio);
			logger.info("Asiento recibido, enviando mensaje de control");

			// Enviar ACK
			enviarACK(ficheroIntercambio);

		} catch (RuntimeException e) {

			logger.error("Error al recibir el fichero de intercambio", e);

			// Obtener el c�digo de error
			String codigoError = ErroresEnum.ERROR_0063.getValue();
			
			// intentamos comprobar si debemos setear un c�digo de error de validaci�n
			if (e instanceof ValidacionException) {
				ErroresEnum errorValidacion = ((ValidacionException)e).getErrorValidacion();
				if (errorValidacion != null) {
					codigoError = errorValidacion.getValue();
				}
			}

			// intentamos enviar mensaje de error,
			try {
				// intentamos parsear el xml los campos necesarios para mensaje
				// de error
				if (ficheroIntercambio == null) {
					ficheroIntercambio = parserForError(xmlFicheroIntercambio);
				}
				//si el c�digo de error es el de duplicado, se vuelve a enviar un ACK
				// Enviar ACK
				if (ErroresEnum.ERROR_0205.getValue().equals(codigoError)){
					enviarACK(ficheroIntercambio);
				}else{
					// Enviar mensaje de error
					enviarMensajeError(ficheroIntercambio, codigoError, e.getMessage(),
						null);
				}

			} catch (RuntimeException ex) {
				// puede darse el caso de que se genere una excepcion al no
				// poder tener todos lo datos necesarios para generar el mensaje
				// de error
				logger.error("No se ha podido enviar el mensaje de error debido a una excepci�n producida, podr�a ser debido a la falta de campos requeridos para el env�o del mismo:",ex.getMessage());
			}
			throw e;
		}

        return asiento;
	}
	 
    /**
     * M�todo que parsea el xml sin validaciones de schema para poder generar mensajes de error en algun momento
     * @param xml
     * @return
     */
    private FicheroIntercambioVO  parserForError(String xml){

    	FicheroIntercambioVO result= new FicheroIntercambioVO();
    	es.ieci.tecdoc.fwktd.sir.api.schema.Fichero_Intercambio_SICRES_3 fichero_Intercambio_SICRES_3=null;
    	
    	Unmarshaller unmarshaller= new Unmarshaller(es.ieci.tecdoc.fwktd.sir.api.schema.Fichero_Intercambio_SICRES_3.class);
    	//desactivamos la validacion
    	unmarshaller.setValidation(false);
	    	
    	try {
			fichero_Intercambio_SICRES_3= (es.ieci.tecdoc.fwktd.sir.api.schema.Fichero_Intercambio_SICRES_3) unmarshaller.unmarshal(new StringReader(xml));
		} catch (MarshalException e) {
			logger.error("Imposible parsear el xml recibido:"+xml+" excepci�n "+e.getLocalizedMessage());
			throw new RuntimeException(e);
		} catch (ValidationException e) {
			logger.error("Imposible parsear el xml recibido:"+xml+" excepci�n "+e.getLocalizedMessage());
			throw new RuntimeException(e);
		}
    	result.setFicheroIntercambio(fichero_Intercambio_SICRES_3);
        return result ;
    }

	protected AsientoRegistralVO recibirFicheroIntercambio(FicheroIntercambioVO ficheroIntercambio, String xmlFicheroIntercambio) {

		if (logger.isInfoEnabled()){
			logger.info("Llamada a recibirFicheroIntercambio: [{}]", ToStringLoggerApiHelper.toStringLogger(ficheroIntercambio));
		}

		AsientoRegistralVO asiento = null;

        // Validar la informaci�n del fichero de intercambio
        try {
        	getSicresXMLManager().validarFicheroIntercambio(ficheroIntercambio);
		}catch (IllegalArgumentException e) {
		    logger.error("Se produjo un error de validacion del xml recibido:"+e.getMessage());
		    throw new ValidacionException(ErroresEnum.ERROR_0037,e, e.getMessage());
		}

        // Audita el fichero de datos de intercambio
    	getAuditoriaFicheroIntercambioManager().audita(ficheroIntercambio, xmlFicheroIntercambio, BandejaEnum.RECIBIDOS);

        // Comprobar el tipo de anotacion
        if (TipoAnotacionEnum.RECHAZO.equals(ficheroIntercambio.getTipoAnotacion())) {

            AsientoRegistralVO asientoExistente = getAsientoRegistralManager().getAsientoRegistral(
            		ficheroIntercambio.getCodigoEntidadRegistralDestino(), ficheroIntercambio.getIdentificadorIntercambio());
            if (asientoExistente != null) {

            	if (EstadoAsientoRegistralEnum.ENVIADO.equals(asientoExistente.getEstado())
            			|| EstadoAsientoRegistralEnum.ENVIADO_Y_ACK.equals(asientoExistente.getEstado())
            			|| EstadoAsientoRegistralEnum.ENVIADO_Y_ERROR.equals(asientoExistente.getEstado())
            			|| EstadoAsientoRegistralEnum.REENVIADO.equals(asientoExistente.getEstado())
            			|| EstadoAsientoRegistralEnum.REENVIADO_Y_ACK.equals(asientoExistente.getEstado())
            			|| EstadoAsientoRegistralEnum.REENVIADO_Y_ERROR.equals(asientoExistente.getEstado())
            			|| EstadoAsientoRegistralEnum.RECIBIDO.equals(asientoExistente.getEstado())
            			|| EstadoAsientoRegistralEnum.RECHAZADO.equals(asientoExistente.getEstado())) {

	                Date fechaActual = getFechaManager().getFechaActual();

	                asientoExistente.setEstado(EstadoAsientoRegistralEnum.DEVUELTO);
	                asientoExistente.setFechaEstado(fechaActual);
	                asientoExistente.setFechaRecepcion(fechaActual);
	                asientoExistente.setAplicacion(ficheroIntercambio.getAplicacionEmisora());
	                asientoExistente.setObservacionesApunte(ficheroIntercambio.getObservacionesApunte());
	                asientoExistente.setTipoAnotacion(ficheroIntercambio.getTipoAnotacion());
	                asientoExistente.setDescripcionTipoAnotacion(ficheroIntercambio.getDescripcionTipoAnotacion());

	                asiento = getAsientoRegistralManager().update(asientoExistente);

            	} else if (EstadoAsientoRegistralEnum.DEVUELTO.equals(asientoExistente.getEstado())) {
            		
                	logger.error("El asiento ya est� en estado DEVUELTO: {}", ficheroIntercambio.getIdentificadorIntercambio());
                	//insertarTrazabilidad(ficheroIntercambio, EstadoTrazabilidadEnum.ERROR, ErroresEnum.ERROR_0205);
                	throw new ValidacionException(ErroresEnum.ERROR_0205);
                	
            	} else {
                	logger.error("Se ha intentado devolver un asiento con estado incompatible [{}]: {}", ficheroIntercambio.getIdentificadorIntercambio(), asientoExistente.getEstado());
                	throw new ValidacionException(ErroresEnum.ERROR_0063);
            	}

            } else {
            	logger.error("Se ha intentado devolver un fichero de intercambio cuyo identificador de intercambio no existe: {}", ficheroIntercambio.getIdentificadorIntercambio());
            	throw new ValidacionException(ErroresEnum.ERROR_0063);
            }

        } else { // TipoAnotacionEnum.ENVIO, TipoAnotacionEnum.REENVIO

            // Comprobar si existe el asiento
            AsientoRegistralVO asientoExistente = getAsientoRegistralManager().getAsientoRegistral(
            		ficheroIntercambio.getCodigoEntidadRegistralDestino(), ficheroIntercambio.getIdentificadorIntercambio());
            if (asientoExistente != null) {
            	if (EstadoAsientoRegistralEnum.RECHAZADO.equals(asientoExistente.getEstado())
            			|| EstadoAsientoRegistralEnum.RECHAZADO_Y_ACK.equals(asientoExistente.getEstado())
            			|| EstadoAsientoRegistralEnum.RECHAZADO_Y_ERROR.equals(asientoExistente.getEstado())
            			|| EstadoAsientoRegistralEnum.ENVIADO.equals(asientoExistente.getEstado())
            			|| EstadoAsientoRegistralEnum.ENVIADO_Y_ACK.equals(asientoExistente.getEstado())
            			|| EstadoAsientoRegistralEnum.ENVIADO_Y_ERROR.equals(asientoExistente.getEstado())
            			|| EstadoAsientoRegistralEnum.REENVIADO_Y_ACK.equals(asientoExistente.getEstado())
            			//|| EstadoAsientoRegistralEnum.REENVIADO_Y_ERROR.equals(asientoExistente.getEstado())
            			) {

					// El asiento ya existe en local pero estaba rechazado
					// => Eliminarlo y crear uno nuevo con la informaci�n recibida
            		getAsientoRegistralManager().deleteAsientoRegistral(asientoExistente.getId());
            		
            		//SI ES UN ENVIO Y EL ASIENTO EXISTE Y ESTA EN ESTADO RECIBIDO
            	} else if (TipoAnotacionEnum.ENVIO.equals(ficheroIntercambio.getTipoAnotacion())
            		&& (EstadoAsientoRegistralEnum.RECIBIDO.equals(asientoExistente.getEstado())
            			|| EstadoAsientoRegistralEnum.VALIDADO.equals(asientoExistente.getEstado()))) {
            		
                	logger.error("El asiento ya est� en estado RECIBIDO: {}", ficheroIntercambio.getIdentificadorIntercambio());
                	//insertarTrazabilidad(ficheroIntercambio, EstadoTrazabilidadEnum.ERROR, ErroresEnum.ERROR_0205);
                	throw new ValidacionException(ErroresEnum.ERROR_0205);
                	//SI ES UN REENVIO Y EL ASIENTO EXISTE Y ESTA EN ESTADO RECIBIDO
            	}  else if (TipoAnotacionEnum.REENVIO.equals(ficheroIntercambio.getTipoAnotacion())
            		&& (EstadoAsientoRegistralEnum.RECIBIDO.equals(asientoExistente.getEstado())
            			|| EstadoAsientoRegistralEnum.VALIDADO.equals(asientoExistente.getEstado()))) {
            		
            	    	getAsientoRegistralManager().deleteAsientoRegistral(asientoExistente.getId());
                	
            	} else {
            		logger.error("Se ha intentado enviar/reenviar un asiento con estado incompatible [{}]: {}", ficheroIntercambio.getIdentificadorIntercambio(), asientoExistente.getEstado());
                	throw new ValidacionException(ErroresEnum.ERROR_0063);
                }
            }

            // Salvar el asiento registral
            asiento = getAsientoRegistralManager().saveAsientoRegistral(ficheroIntercambio);
        }

        logger.info("Fichero de intercambio recibido con �xito [{}]", ficheroIntercambio.getIdentificadorIntercambio());

        return asiento;
    }

	/**
	 * {@inheritDoc}
	 * @see es.ieci.tecdoc.fwktd.sir.api.manager.RecepcionManager#recibirMensaje(java.lang.String)
	 */
	public void recibirMensaje(String xmlMensaje) {

        logger.info("Recibiendo el mensaje: [{}]", xmlMensaje);

        // Cargar la informaci�n del mensaje
		MensajeVO mensaje = getSicresXMLManager().parseXMLMensaje(xmlMensaje);
		if (logger.isInfoEnabled()){
			logger.info("Mensaje parseado [{}]", mensaje.getIdentificadorIntercambio());
		}
		if (logger.isDebugEnabled()){
			logger.debug("Mensaje parseado: {}", ToStringLoggerApiHelper.toStringLogger(mensaje));
		}

        // Validar la informaci�n del mensaje
        getSicresXMLManager().validarMensaje(mensaje);

        // Audita el mensaje
    	getAuditoriaMensajeManager().audita(mensaje, xmlMensaje, BandejaEnum.RECIBIDOS);

        // Ejecutar acciones en funci�n del tipo de mensaje
        if (TipoMensajeEnum.ACK.equals(mensaje.getTipoMensaje())) {

            AsientoRegistralVO asiento = getAsientoRegistralManager().getAsientoRegistral(
            		mensaje.getCodigoEntidadRegistralDestino(), mensaje.getIdentificadorIntercambio());
            if (asiento != null) {

                if (EstadoAsientoRegistralEnum.ENVIADO.equals(asiento.getEstado())) {

                    // Actualizar el estado
                    asiento.setEstado(EstadoAsientoRegistralEnum.ENVIADO_Y_ACK);
                    asiento.setFechaEstado(getFechaManager().getFechaActual());
                    asiento.setNumeroReintentos(0);

                    getAsientoRegistralManager().update(asiento);

                } else if (EstadoAsientoRegistralEnum.REENVIADO.equals(asiento.getEstado())) {

                    // Actualizar el estado
                    asiento.setEstado(EstadoAsientoRegistralEnum.REENVIADO_Y_ACK);
                    asiento.setFechaEstado(getFechaManager().getFechaActual());
                    asiento.setNumeroReintentos(0);

                    getAsientoRegistralManager().update(asiento);

                } else if (EstadoAsientoRegistralEnum.RECHAZADO.equals(asiento.getEstado())) {

                    // Actualizar el estado
                    asiento.setEstado(EstadoAsientoRegistralEnum.RECHAZADO_Y_ACK);
                    asiento.setFechaEstado(getFechaManager().getFechaActual());
                    asiento.setNumeroReintentos(0);

                    getAsientoRegistralManager().update(asiento);

                } else if (EstadoAsientoRegistralEnum.ENVIADO_Y_ACK.equals(asiento.getEstado())
                		|| EstadoAsientoRegistralEnum.REENVIADO_Y_ACK.equals(asiento.getEstado())
                		|| EstadoAsientoRegistralEnum.RECHAZADO_Y_ACK.equals(asiento.getEstado())) {
                	
                	if (logger.isInfoEnabled()){
                		logger.info("Se ha recibido un mensaje duplicado: [{}]", ToStringLoggerApiHelper.toStringLogger(mensaje));
                	}
                	//insertarTrazabilidad(mensaje, EstadoTrazabilidadEnum.ERROR, ErroresEnum.ERROR_0206);
                	throw new ValidacionException(ErroresEnum.ERROR_0206);

                } else {
                    logger.error("Asiento registral [{}] no tiene el estado adecuado para recibir un ACK [{}]", asiento.getIdentificadorIntercambio(), asiento.getEstado());
                    throw new ValidacionException(ErroresEnum.ERROR_0044);
                }
            } else {
                logger.error("Asiento registral no encontrado para el mensaje: {}", ToStringLoggerApiHelper.toStringLogger(mensaje));
                throw new ValidacionException(ErroresEnum.ERROR_0044);
            }

        } else if (TipoMensajeEnum.CONFIRMACION.equals(mensaje.getTipoMensaje())) {

        	// Cambiar el estado del asiento a ACEPTADO

            AsientoRegistralVO asiento = getAsientoRegistralManager().getAsientoRegistral(
            		mensaje.getCodigoEntidadRegistralDestino(), mensaje.getIdentificadorIntercambio());
            if (asiento != null) {

            	if (EstadoAsientoRegistralEnum.ENVIADO.equals(asiento.getEstado())
            			|| EstadoAsientoRegistralEnum.ENVIADO_Y_ACK.equals(asiento.getEstado())
            			|| EstadoAsientoRegistralEnum.ENVIADO_Y_ERROR.equals(asiento.getEstado())
            			|| EstadoAsientoRegistralEnum.REENVIADO.equals(asiento.getEstado())
            			|| EstadoAsientoRegistralEnum.REENVIADO_Y_ACK.equals(asiento.getEstado())
            			|| EstadoAsientoRegistralEnum.REENVIADO_Y_ERROR.equals(asiento.getEstado())) {

	                // Actualizar la informaci�n del asiento registral
	                asiento.setEstado(EstadoAsientoRegistralEnum.ACEPTADO);
	                asiento.setFechaEstado(getFechaManager().getFechaActual());
	                asiento.setNumeroRegistro(mensaje.getNumeroRegistroEntradaDestino());
	                asiento.setFechaRegistro(mensaje.getFechaEntradaDestino());

	                getAsientoRegistralManager().update(asiento);

                } else if (EstadoAsientoRegistralEnum.ACEPTADO.equals(asiento.getEstado())) {
                	
                	if (logger.isInfoEnabled()){
                		logger.info("Se ha recibido un mensaje duplicado: [{}]", ToStringLoggerApiHelper.toStringLogger(mensaje));
                	}
                	
                	//insertarTrazabilidad(mensaje, EstadoTrazabilidadEnum.ERROR, ErroresEnum.ERROR_0206);
                	throw new ValidacionException(ErroresEnum.ERROR_0206);

            	} else {
                    logger.error("Asiento registral [{}] no tiene el estado adecuado para recibir una CONFIRMACI�N [{}]", asiento.getIdentificadorIntercambio(), asiento.getEstado());
                    throw new ValidacionException(ErroresEnum.ERROR_0044);
            	}

            } else {
                logger.error("Asiento registral no encontrado para el mensaje: {}", ToStringLoggerApiHelper.toStringLogger(mensaje));
                throw new ValidacionException(ErroresEnum.ERROR_0044);
            }

        } else if (TipoMensajeEnum.ERROR.equals(mensaje.getTipoMensaje())) {

			// Tratar el mensaje de error en funci�n del estado actual

            AsientoRegistralVO asiento = getAsientoRegistralManager().getAsientoRegistral(
            		mensaje.getCodigoEntidadRegistralDestino(), mensaje.getIdentificadorIntercambio());
            if (asiento != null) {

                if (EstadoAsientoRegistralEnum.ENVIADO.equals(asiento.getEstado())) {

                    // Actualizar la informaci�n del asiento
                    asiento.setEstado(EstadoAsientoRegistralEnum.ENVIADO_Y_ERROR);
                    asiento.setFechaEstado(getFechaManager().getFechaActual());
                    asiento.setNumeroReintentos(0);
                    asiento.setCodigoError(mensaje.getCodigoError());
                    asiento.setDescripcionError(mensaje.getDescripcionMensaje());

                    getAsientoRegistralManager().update(asiento);

                } else if (EstadoAsientoRegistralEnum.REENVIADO.equals(asiento.getEstado())) {

                    // Actualizar la informaci�n del asiento
                    asiento.setEstado(EstadoAsientoRegistralEnum.REENVIADO_Y_ERROR);
                    asiento.setFechaEstado(getFechaManager().getFechaActual());
                    asiento.setNumeroReintentos(0);
                    asiento.setCodigoError(mensaje.getCodigoError());
                    asiento.setDescripcionError(mensaje.getDescripcionMensaje());

                    getAsientoRegistralManager().update(asiento);

                } else if (EstadoAsientoRegistralEnum.RECHAZADO.equals(asiento.getEstado())) {

                    // Actualizar la informaci�n del asiento
                    asiento.setEstado(EstadoAsientoRegistralEnum.RECHAZADO_Y_ERROR);
                    asiento.setFechaEstado(getFechaManager().getFechaActual());
                    asiento.setNumeroReintentos(0);
                    asiento.setCodigoError(mensaje.getCodigoError());
                    asiento.setDescripcionError(mensaje.getDescripcionMensaje());

                    getAsientoRegistralManager().update(asiento);

                } else if (EstadoAsientoRegistralEnum.ENVIADO_Y_ERROR.equals(asiento.getEstado())
                		|| EstadoAsientoRegistralEnum.REENVIADO_Y_ERROR.equals(asiento.getEstado())
                		|| EstadoAsientoRegistralEnum.RECHAZADO_Y_ERROR.equals(asiento.getEstado())) {
                	
                	if (logger.isInfoEnabled()){
                		logger.info("Se ha recibido un mensaje duplicado: [{}]", ToStringLoggerApiHelper.toStringLogger(mensaje));
                	}
                	
                	//insertarTrazabilidad(mensaje, EstadoTrazabilidadEnum.ERROR, ErroresEnum.ERROR_0206);
                	throw new ValidacionException(ErroresEnum.ERROR_0206);
                	
                } else {
                    logger.error("Asiento registral [{}] no tiene el estado adecuado para recibir un ERROR [{}]", asiento.getIdentificadorIntercambio(), asiento.getEstado());
                    throw new ValidacionException(ErroresEnum.ERROR_0044);
                }
            } else {
                logger.error("Asiento registral no encontrado para el mensaje: {}", ToStringLoggerApiHelper.toStringLogger(mensaje));
                throw new ValidacionException(ErroresEnum.ERROR_0044);
            }

        } else {
            logger.error("Tipo de mensaje no soportado: [{}] {}", mensaje.getTipoMensaje(), ToStringLoggerApiHelper.toStringLogger(mensaje));
        	throw new ValidacionException(ErroresEnum.ERROR_0044);
        }

        logger.info("Mensaje recibido con �xito [{}]", mensaje.getIdentificadorIntercambio());
    }

	protected void insertarTrazabilidad(MensajeVO mensaje, EstadoTrazabilidadEnum estadoTrazabilidad,
			ErroresEnum error) {
		
		if (logger.isInfoEnabled()){
			logger.info(
					"Insertando la traza:  mensaje=[{}], estadoTrazabilidad=[{}], error=[{}]",
					new Object[] { ToStringLoggerApiHelper.toStringLogger(mensaje), estadoTrazabilidad, error });
		}
    	
    	TrazabilidadVO traza = new TrazabilidadVO();

	    traza.setCodigoIntercambio(mensaje.getIdentificadorIntercambio());
	    traza.setCodigoEntidadRegistralDestino(mensaje.getCodigoEntidadRegistralDestino());
	    traza.setCodigoEntidadRegistralOrigen(mensaje.getCodigoEntidadRegistralOrigen());
	    
	    traza.setCodigoError(error.getValue());
	    traza.setDescripcionErrorAlternativa(error.getName());
	    
	    traza.setCodigoEstado(estadoTrazabilidad.getValue());
	    traza.setCodigoNodo(null); // N/A
	    traza.setFechaAlta(new Date());
	    traza.setFechaModificacion(new Date());
	    traza.setMotivoRechazo(null); // N/A
	    traza.setNombreFicheroIntercambio("defecto");//traza.setNombreFicheroIntercambio(mensaje.getIdentificadorIntercambio());
	    traza.setRegistro(false); // Es un mensaje
	    //traza.setTamanyoDocs(); // N/A

	    try {
	    	
	    	// Insertar la traza
	    	trazabilidadManager.insertarTrazabilidad(traza);
	    	
	    } catch (RuntimeException e) {
	    	logger.error("Error al insertar la traza del mensaje", e);
	    }
	}
	
	protected void insertarTrazabilidad(FicheroIntercambioVO ficheroIntercambio, EstadoTrazabilidadEnum estadoTrazabilidad,
			ErroresEnum error) {
		
		if (logger.isInfoEnabled()){
			logger.info(
					"Insertando la traza:  ficheroIntercambio=[{}], estadoTrazabilidad=[{}], error=[{}]",
					new Object[] { ToStringLoggerApiHelper.toStringLogger(ficheroIntercambio), estadoTrazabilidad, error });
		}
    	
    	TrazabilidadVO traza = new TrazabilidadVO();

	    traza.setCodigoIntercambio(ficheroIntercambio.getIdentificadorIntercambio());
	    
	    traza.setCodigoEntidadRegistralDestino(ficheroIntercambio.getCodigoEntidadRegistralDestino());
	    traza.setDescripcionEntidadRegistralDestino(ficheroIntercambio.getDescripcionEntidadRegistralDestino());
	    traza.setCodigoEntidadRegistralOrigen(ficheroIntercambio.getCodigoEntidadRegistralOrigen());
	    traza.setDescripcionEntidadRegistralOrigen(ficheroIntercambio.getDescripcionEntidadRegistralOrigen());
	    
	    traza.setCodigoUnidadTramitacionDestino(ficheroIntercambio.getCodigoUnidadTramitacionDestino());
	    traza.setDescripcionUnidadTramitacionDestino(ficheroIntercambio.getDescripcionUnidadTramitacionDestino());
	    traza.setCodigoUnidadTramitacionOrigen(ficheroIntercambio.getCodigoUnidadTramitacionOrigen());
	    traza.setDescripcionUnidadTramitacionOrigen(ficheroIntercambio.getDescripcionUnidadTramitacionOrigen());
	    
	    traza.setCodigoError(error.getValue());
	    traza.setDescripcionErrorAlternativa(error.getName());
	    
	    traza.setCodigoEstado(estadoTrazabilidad.getValue());
	    traza.setCodigoNodo(null); // N/A
	    traza.setFechaAlta(new Date());
	    traza.setFechaModificacion(new Date());
	    traza.setMotivoRechazo(null); // N/A
	    traza.setNombreFicheroIntercambio("defecto");
	    traza.setRegistro(false); // Es un mensaje
	    //traza.setTamanyoDocs(); // N/A

	    try {
	    	
	    	// Insertar la traza
	    	trazabilidadManager.insertarTrazabilidad(traza);
	    	
	    } catch (RuntimeException e) {
	    	logger.error("Error al insertar la traza del mensaje", e);
	    }
	}
	
	/**
     * {@inheritDoc}
     *
     * @see es.ieci.tecdoc.fwktd.sir.api.manager.RecepcionManager#procesarFicherosRecibidos()
     */
    public void procesarFicherosRecibidos() {

        logger.info("Procesando los ficheros de datos recibidos");

        checkDirectory("directorioTemporal", getDirectorioTemporal());
        checkDirectory("directorioRecibidos", getDirectorioRecibidos());
        checkDirectory("directorioHistorico", getDirectorioHistorico());
        checkDirectory("directorioFallidos", getDirectorioFallidos());

        // Obtener la lista de ficheros recibidos
        logger.info("Obteniendo los ficheros recibidos: {}", getDirectorioRecibidos());
        File[] ficherosRecibidos = new File(getDirectorioRecibidos()).listFiles();
        if (ArrayUtils.isNotEmpty(ficherosRecibidos)) {

            logger.info("Se han encontrado {} fichero/s recibido/s", ficherosRecibidos.length);

            for (File ficheroRecibido : ficherosRecibidos) {
                recibirFichero(ficheroRecibido);
            }

        } else {
            logger.info("No se ha encontrado ning�n fichero recibido");
        }
    }

    private void checkDirectory(String name, String path) {
        Assert.hasText(path, "'" + name + "' must not be empty");
        Assert.isTrue(new File(path).isDirectory(), "'" + name + "' must be an existing directory");
    }

    private void recibirFichero(File fichero) {

        logger.info("Comprobando el fichero: {}", fichero.getName());

        // Comprobar que el fichero exista
        if (fichero.isFile()) {

            File dirDescomprimido = null;

            try {

                // Directorio temporal para descomprimir el fichero
                dirDescomprimido = descomprimirFichero(fichero);
                if (dirDescomprimido == null) {
                    return;
                }

                // Leer los ficheros descomprimidos
                File[] ficheros = dirDescomprimido.listFiles();
                Assert.isTrue(ArrayUtils.isNotEmpty(ficheros), "El fichero comprimido [" + fichero + "] est� vac�o");

                // Ordenar los ficheros por nombre
                if (ficheros.length > 1) {
                	Arrays.sort(ficheros);
                }

				// Averiguar el tipo de fichero a procesar
				TipoFicheroEnum tipoFichero = getTipoFichero(ficheros[0]);
				logger.info("Tipo de fichero [{}]: {}", ficheros[0].getName(), tipoFichero);
				Assert.isTrue(!TipoFicheroEnum.DESCONOCIDO.equals(tipoFichero), "No se reconoce el fichero [" + ficheros[0] + "]");

				logger.info("Leyendo el fichero XML [{}] con encoding [{}]", ficheros[0].getName(), getFileEncoding());

				// XML del fichero de datos
            	String xml = FileUtils.readFileToString(ficheros[0], getFileEncoding());
            	logger.debug("XML del mensaje:\n{}", xml);

            	// Procesar el fichero en funci�n de su tipo
            	if (TipoFicheroEnum.FICHERO_DATOS_INTERCAMBIO.equals(tipoFichero)) {

            		// Documentos anexados
	            	List<byte[]> documentos = new ArrayList<byte[]>();
	            	for (int i = 1; i < ficheros.length; i++) {
	            		documentos.add(FileUtils.readFileToByteArray(ficheros[i]));
	            	}

                	logger.info("N�mero de documentos: {}", documentos.size());

                	// Procesar el fichero de datos de intercambio
                	recibirFicheroIntercambio(xml, documentos);

            	} else { // TipoFicheroEnum.MENSAJE

                	// Procesar el mensaje
                	recibirMensaje(xml);
            	}

                // Mover el fichero al directorio de hist�rico
                moveFile(fichero, getDirectorioHistorico());

            } catch (Throwable e) {

                logger.error("Error al recibir el fichero [" + fichero.getName() + "]", e);

                // Mover el fichero al directorio de fallidos
                moveFile(fichero, getDirectorioFallidos());

            } finally {

                // Eliminar el directorio descomprimido
                if (dirDescomprimido != null) {
                    try {
                        FileUtils.deleteDirectory(dirDescomprimido);
                        logger.info("Directorio temporal [{}] eliminado", dirDescomprimido.getName());
                    } catch (IOException e) {
                        logger.warn("Error al eliminar el directorio con el fichero descomprimido [" + dirDescomprimido.getName() + "]", e);
                    }
                }
            }
        }
    }

    private TipoFicheroEnum getTipoFichero(File fichero) {

        if (Pattern.matches(PATRON_FICHERO_DATOS_INTERCAMBIO, fichero.getName())) {
            return TipoFicheroEnum.FICHERO_DATOS_INTERCAMBIO;
        } else if (Pattern.matches(PATRON_MENSAJE, fichero.getName())) {
            return TipoFicheroEnum.MENSAJE;
        }

        return TipoFicheroEnum.DESCONOCIDO;
    }

    private File descomprimirFichero(File fichero) {

        logger.info("Descomprimiendo el fichero: {}", fichero.getName());

        // Directorio temporal para descomprimir el fichero
        File dirDescomprimido = new File(getDirectorioTemporal(), fichero.getName());
        logger.info("Directorio temporal para el fichero: {}", dirDescomprimido.getName());

        // Comprobar si ya existe el directorio temporal (est� en uso)
        if (dirDescomprimido.isDirectory()) {
            logger.info("El fichero [{}] ya est� siendo procesado", fichero.getName());
            return null;
        }

        // Descomprimir el fichero
        getCompresionManager().descomprimirFichero(fichero, dirDescomprimido);

        return dirDescomprimido;
    }

    private void moveFile(File src, String destDir) {

        logger.info("Moviendo el fichero [{}] al directorio [{}]", src.getName(), destDir);

        try {
            FileUtils.moveFileToDirectory(src, new File(destDir), true);
            logger.info("Fichero [{}] movido al directorio: {}", src.getName(), destDir);
        } catch (IOException e) {
            logger.error("Error al mover el fichero [" + src.getName() + "] al directorio [" + destDir + "]", e);
        }
    }

    /**
     * Env�a un mensaje de control ACK.
     * @param asiento Informaci�n del asiento registral.
     */
    protected void enviarACK(FicheroIntercambioVO ficheroIntercambio) {

        MensajeVO mensaje = new MensajeVO();
        mensaje.setCodigoEntidadRegistralOrigen(ficheroIntercambio.getCodigoEntidadRegistralDestino());
        mensaje.setCodigoEntidadRegistralDestino(ficheroIntercambio.getCodigoEntidadRegistralOrigen());
        mensaje.setIdentificadorIntercambio(ficheroIntercambio.getIdentificadorIntercambio());
        mensaje.setTipoMensaje(TipoMensajeEnum.ACK);
        mensaje.setDescripcionMensaje(TipoMensajeEnum.ACK.getName());
        //mensaje.setNumeroRegistroEntradaDestino(ficheroIntercambio.getNumeroRegistro());
        //mensaje.setFechaEntradaDestino(ficheroIntercambio.getFechaRegistro());

        getMensajeManager().enviarMensaje(mensaje);

        logger.info("Mensaje de control (ACK) enviado");
    }

    /**
     * Env�a un mensaje de control de tipo ERROR.
     * @param ficheroIntercambio
     * @param codigoError
     * @param descError
     * @param identificadoresFicheros
     */
    protected void enviarMensajeError(FicheroIntercambioVO ficheroIntercambio, String codigoError, String descError, List<String> identificadoresFicheros) {

    	if (ficheroIntercambio != null) {
	        MensajeVO mensaje = new MensajeVO();
	        mensaje.setCodigoEntidadRegistralOrigen(ficheroIntercambio.getCodigoEntidadRegistralDestino());
	        mensaje.setCodigoEntidadRegistralDestino(ficheroIntercambio.getCodigoEntidadRegistralOrigen());
	        mensaje.setIdentificadorIntercambio(ficheroIntercambio.getIdentificadorIntercambio());
	        mensaje.setTipoMensaje(TipoMensajeEnum.ERROR);
	        //mensaje.setNumeroRegistroEntradaDestino(ficheroIntercambio.getNumeroRegistro());
	        //mensaje.setFechaEntradaDestino(ficheroIntercambio.getFechaRegistro());
	        mensaje.setCodigoError(codigoError);
	        mensaje.setDescripcionMensaje(descError);
	        mensaje.setIdentificadoresFicheros(identificadoresFicheros);
						
	        getMensajeManager().enviarMensaje(mensaje);

	        logger.info("Mensaje de control (ERROR) enviado");
    	}
    }
}
