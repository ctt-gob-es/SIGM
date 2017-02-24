package es.ieci.tecdoc.fwktd.sir.core.exception;

import es.ieci.tecdoc.fwktd.core.exception.ApplicationException;

/**
 * Excepci�n base del m�dulo de conexi�n con el SIR.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public class SIRException extends ApplicationException {

	private static final long serialVersionUID = 8519500820826284795L;

	/**
	 * Constructor de la clase.
	 *
	 * @param messageId
	 *            clave del mensaje en el fichero de recursos con los mensajes
	 *            internacionalizados para las excepciones
	 * @param params
	 *            par�metros para componer el mensaje con el del fichero de
	 *            recursos
	 * @param defaultMessage
	 *            mensaje a mostrar en caso de que no encuentre la clave del
	 *            mensaje
	 */
	public SIRException(String messageId, String[] params, String defaultMessage) {
		super(messageId, params, defaultMessage);
	}

	/**
	 * Obtiene el id del mensaje por defecto. Se utiliza para indicar la clave,
	 * en un fichero de recursos, de la que obtener el mensaje
	 * internacionalizado de la excepci�n.
	 *
	 * @return el id del mensaje internacionalizado de la excepci�n
	 */
	@Override
	public String getDefaultMessageId() {
		return "error.sir";
	}

}
