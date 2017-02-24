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
 * Clase que recoge los c�digos de error referentes a operaciones con registros de
 * entrada.
 * 
 * @author jortizs
 */
public class RPInputRegisterErrorCode
		extends ErrorCode {
	/** Constante de c�digo RPIR001: Error en la obtenci�n del registro de entrada. */
	public static final RPInputRegisterErrorCode GET_INPUT_REGISTER_ERROR =
			new RPInputRegisterErrorCode("RPIR001", "GET INPUT REGISTER ERROR");
	/**
	 * Constante de c�digo RPIR002: Error en la obtenci�n del �ltimo registro de entrada
	 * del usuario.
	 */
	public static final RPInputRegisterErrorCode GET_LAST_INPUT_REGISTER_FOR_USER_ERROR =
			new RPInputRegisterErrorCode("RPIR002",
					"GET LAST INPUT REGISTER FOR USER ERROR");
	/**
	 * Constante de c�digo RPIR003: Error en la carga de los listados de registros de
	 * entrada del usuario.
	 */
	public static final RPInputRegisterErrorCode LOAD_INPUT_REGISTER_FOR_USER_ERROR =
			new RPInputRegisterErrorCode("RPIR003",
					"LOAD INPUT REGISTER FOR USER ERROR");
	/**
	 * Constante de c�digo RPIR004: Error en la navegaci�n entre los registros de entrada
	 * del usuario.
	 */
	public static final RPInputRegisterErrorCode NAVIGATE_INTO_INPUT_REGISTER_LIST_ERROR =
			new RPInputRegisterErrorCode("RPIR004",
					"NAVIGATE INTO INPUT REGISTER FOR USER ERROR");
	/**
	 * Constante de c�digo RPIR005: Error en la apertura de la consulta de registros de
	 * entrada
	 * del usuario.
	 */
	public static final RPInputRegisterErrorCode OPEN_REGISTER_QUERY_ERROR =
			new RPInputRegisterErrorCode("RPIR005",
					"OPEN INPUT REGISTER QUERY ERROR");
	/**
	 * Constante de c�digo RPIR006: Error en el cierre de la consulta de registros de
	 * entrada
	 * del usuario.
	 */
	public static final RPInputRegisterErrorCode CLOSE_REGISTER_QUERY_ERROR =
			new RPInputRegisterErrorCode("RPIR006",
					"CLOSE INPUT REGISTER QUERY ERROR");
	
	/**
	 * Constante de c�digo RPIR007: Error al rellenar los par�metros de la consulta de
	 * registros de entrada
	 * del usuario.
	 */
	public static final RPInputRegisterErrorCode LOAD_INPUT_REGISTER_ARGUMENTS_ERROR =
			new RPInputRegisterErrorCode("RPIR007",
					"LOAD INPUT REGISTER QUERY ERROR");
	
	/**
	 * Constante de c�digo RPIR008: Error en la marcar el formulario como s�lo lectura.
	 */
	public static final RPInputRegisterErrorCode LOCK_INPUT_REGISTER_ERROR =
			new RPInputRegisterErrorCode("RPIR008", "LOCK INPUT REGISTER ERROR");
	
	/**
	 * Constante de c�digo RPIR009: Error en la obtenci�n del hist�rico de registros de
	 * entrada.
	 */
	public static final RPInputRegisterErrorCode GET_HISTORICAL_INPUT_REGISTER_ERROR =
			new RPInputRegisterErrorCode("RPIR009",
					"GET HISTORICAL INPUT REGISTER ERROR");
	
	/**
	 * Constante de c�digo RPIR010: Error en la carga de los registros de entrada.
	 */
	public static final RPInputRegisterErrorCode LOAD_INPUT_REGISTER_ERROR =
			new RPInputRegisterErrorCode("RPIR010", "LOAD INPUT REGISTER ERROR");
	
	/**
	 * Constante de c�digo RPIR011: Error en la creaci�n de un nuevo registro de entrada.
	 */
	public static final RPInputRegisterErrorCode CREATE_INPUT_REGISTER_ERROR =
			new RPInputRegisterErrorCode("RPIR011",
					"CREATE INPUT REGISTER ERROR");
	
	/**
	 * Constante de c�digo RPIR012: Error en la modificaci�n de un nuevo registro de
	 * entrada.
	 */
	public static final RPInputRegisterErrorCode UPDATE_INPUT_REGISTER_ERROR =
			new RPInputRegisterErrorCode("RPIR012",
					"UPDATE INPUT REGISTER ERROR");


	/**
	 * Constructor con c�digo de error y mensaje.
	 * 
	 * @param code
	 *            C�digo interno del error.
	 * @param message
	 *            Mensaje descriptivo del error.
	 */
	protected RPInputRegisterErrorCode(String code, String message) {
		super(code, message);
	}
}