/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.sgm.registropresencial.errors;

import core.error.ErrorCode;
import core.log.ApplicationLogger;

/**
 * Clase base para el manejo del resto de excepciones.
 * 
 * @author jortizs
 */
public class RPBaseException
		extends Exception {
	private static final long serialVersionUID = 1L;
	
	protected ErrorCode code;
	
	/**
	 * Crea un nuevo RPBaseException.
	 * 
	 * @param code
	 *            C�digo de error.
	 */
	public RPBaseException(ErrorCode code) {
		super();
		this.code = code;
		notifyException();
	}
	
	/**
	 * Crea un nuevo RPBaseException.
	 * 
	 * @param code
	 *            C�digo de error.
	 * @param msg
	 *            Mensaje de error.
	 */
	public RPBaseException(ErrorCode code, String msg) {
		super(msg);
		this.code = code;
		notifyException();
	}
	
	/**
	 * Crea un nuevo RPBaseException.
	 * 
	 * @param code
	 *            C�digo de error.
	 * @param msg
	 *            Mensaje de error.
	 * @param cause
	 *            Excepcion que ha causado el error.
	 */
	public RPBaseException(ErrorCode code, String msg, Throwable cause) {
		super(msg, cause);
		this.code = code;
		notifyException();
	}
	
	/**
	 * Crea un nuevo RPBaseException.
	 * 
	 * @param code
	 *            C�digo de error.
	 * @param cause
	 *            Excepcion que ha causado el error.
	 */
	public RPBaseException(ErrorCode code, Throwable cause) {
		super(cause.getMessage(), cause);
		this.code = code;
		notifyException();
	}
	
	/**
	 * Retorna el codigo de error de la excepcion.
	 * 
	 * @return C�digo de error.
	 */
	public ErrorCode getCode() {
		return code;
	}
	
	/**
	 * Retorna el mensaje de la excepcion.
	 * 
	 * @return result El mensaje de excepci�n.
	 */
	public String getMessage() {
		String result = code.toString();
		String message = super.getMessage();
		if (message != null || !"".equals(message)) {
			result += ": " + message;
		}
		return result;
	}
	
	/**
	 * Retorna el mensaje de la excepcion.
	 * 
	 * @return El mensaje de excepci�n.
	 */
	public String getShortMessage() {
		return super.getMessage();
	}
	
	/**
	 * Notifica sobre la excepci�n ocurrida.
	 */
	private void notifyException() {
		notifyException(this);
	}
	
	/**
	 * Imprime traza de la excepcion.
	 * 
	 * @param throwable La excepci�n a notificar.
	 */
	public static void notifyException(Throwable throwable) {
		ApplicationLogger.error("Exception notified:");
		ApplicationLogger.error(throwable);
	}
}