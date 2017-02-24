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

/**
 * Clase que recoge los c�digos de error referentes a operaciones con registros de salida.
 * 
 * @author jortizs
 */
public class RPOutputRegisterErrorCode
		extends ErrorCode {
	/** Constante de c�digo RPOR001: Error . */
	public static final RPOutputRegisterErrorCode ERROR = new RPOutputRegisterErrorCode(
			"RPOR001", "");
	/**
	 * Constante de c�digo RPOR002: Error en la carga de los registros de salida.
	 */
	public static final RPOutputRegisterErrorCode LOAD_OUTPUT_REGISTER_ERROR =
			new RPOutputRegisterErrorCode("RPOR002", "LOAD OUTPUT REGISTER ERROR");
	
	/**
	 * Constante de c�digo RPOR003: Error en la creaci�n de los registros de salida.
	 */
	public static final RPOutputRegisterErrorCode CREATE_OUTPUT_REGISTER_ERROR =
			new RPOutputRegisterErrorCode("RPOR003", "CREATE OUTPUT REGISTER ERROR");

	/**
	 * Constante de c�digo RPOR004: Error en la modificaci�n de los registros de salida.
	 */
	public static final RPOutputRegisterErrorCode UPDATE_OUTPUT_REGISTER_ERROR =
			new RPOutputRegisterErrorCode("RPOR004", "UPDATE OUTPUT REGISTER ERROR");	
	/**
	 * Constante de c�digo RPOR005: Error recogiendo de un registro de salida.
	 */
	public static final RPOutputRegisterErrorCode GET_OUTPUT_REGISTER_ERROR =
			new RPOutputRegisterErrorCode("RPOR005", "GET OUTPUT REGISTER ERROR");	
	
	/**
	 * Constructor con c�digo de error y mensaje.
	 * 
	 * @param code
	 *            C�digo interno del error.
	 * @param message
	 *            Mensaje descriptivo del error.
	 */
	protected RPOutputRegisterErrorCode(String code, String message) {
		super(code, message);
	}
}