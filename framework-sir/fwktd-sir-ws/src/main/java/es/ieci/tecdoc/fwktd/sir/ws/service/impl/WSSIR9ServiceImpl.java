package es.ieci.tecdoc.fwktd.sir.ws.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.ieci.tecdoc.fwktd.sir.core.types.ErroresEnum;
import es.ieci.tecdoc.fwktd.sir.ws.exception.ServiceException;
import es.ieci.tecdoc.fwktd.sir.ws.manager.EnvioManager;
import es.ieci.tecdoc.fwktd.sir.ws.service.wssir9.RespuestaWS;
import es.ieci.tecdoc.fwktd.sir.ws.service.wssir9.WS_SIR9_PortType;

/**
 * Implementaci�n del servicio de env�o de mensaje de datos de control (WS_SIR9)
 * en formato SICRES 3.0 a la aplicaci�n destino, desde su nodo distribuido
 * asociado.
 * 
 * @author Iecisa
 * @version $Revision$
 * 
 */
public class WSSIR9ServiceImpl implements WS_SIR9_PortType {

	/**
	 * Logger de la clase.
	 */
	private static final Logger logger = LoggerFactory.getLogger(WSSIR9ServiceImpl.class);

	/**
	 * Gestor de env�os de ficheros de intercambio y mensajes.
	 */
	protected EnvioManager envioManager = null;

	/**
	 * Constructor.
	 */
	public WSSIR9ServiceImpl() {
		super();
	}

	public EnvioManager getEnvioManager() {
		return envioManager;
	}

	public void setEnvioManager(EnvioManager envioManager) {
		this.envioManager = envioManager;
	}

	/**
	 * Env�a un mensaje de datos de control a la aplicaci�n.
	 * 
	 * @param mensaje
	 *            Fichero de mensaje SICRES 3.0 en formato String.
	 * @param firma
	 *            Firma del contenido del mensaje.
	 * @return C�digo y descripci�n del error producido durante la ejecuci�n. En
	 *         caso de que todo vaya correcto, devolver� "00" y "Exito".
	 */
	public RespuestaWS envioMensajeDatosControlAAplicacion(String mensaje,
			String firma) {

		RespuestaWS respuesta = null;

		logger.info("Llamada al servicio envioMensajeDatosControlAAplicacion");

		try {

			// Enviar el mensaje de datos de control a la aplicaci�n
			getEnvioManager().envioMensaje(mensaje, firma);

			respuesta = createRespuestaWS(ErroresEnum.OK);

		} catch (ServiceException e) {
			logger.error("Error en el env�o del mensaje de datos de control a la aplicaci�n", e);
			respuesta = createRespuestaWS(e.getError());
		} catch (Throwable e) {
			logger.error("Error en el env�o del mensaje de datos de control a la aplicaci�n", e);
			respuesta = createRespuestaWS(ErroresEnum.ERROR_INESPERADO);
		}

		logger.info(
				"Respuesta de envioFicherosAAplicacion: codigo=[{}], descripcion=[{}]",
				respuesta.getCodigo(), respuesta.getDescripcion());

		return respuesta;
	}

	/**
	 * Crea la respuesta de retorno del servicio.
	 *
	 * @param error
	 *            Informaci�n del error.
	 * @return Informaci�n de respuesta.
	 */
	protected static RespuestaWS createRespuestaWS(ErroresEnum error) {
		RespuestaWS respuesta = new RespuestaWS();
		respuesta.setCodigo(error.getValue());
		respuesta.setDescripcion(error.getName());
		return respuesta;
	}
}
