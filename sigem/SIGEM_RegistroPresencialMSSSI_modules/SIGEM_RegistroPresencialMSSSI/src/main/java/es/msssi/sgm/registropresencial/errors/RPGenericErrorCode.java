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
 * Clase que recoge los c�digos de error gen�ricos de la aplicaci�n.
 * 
 * @author jortizs
 */
public class RPGenericErrorCode
		extends ErrorCode {
	/** Constante de c�digo RPG001: Error de validaci�n de par�metros. */
	public static final RPGenericErrorCode PARAMETER_VALIDATION_ERROR =
			new RPGenericErrorCode("RPG001", "PARAMETER VALIDATION ERROR");
	/** Constante de c�digo RPG002: Error de sesi�n. */
	public static final RPGenericErrorCode SESSION_ERROR =
			new RPGenericErrorCode("RPG002", "SESSION ERROR");
	/** Constante de c�digo RPG003: Error al obtener la propiedad. */
	public static final RPGenericErrorCode GET_PROPERTY_ERROR =
			new RPGenericErrorCode("RPG003", "GET PROPERTY ERROR");
	/** Constante de c�digo RPG004: Error al obtener los atributos. */
	public static final RPGenericErrorCode ATTRIBUTES_ERROR =
			new RPGenericErrorCode("RPG004", "GET ATTRIBUTES ERROR");
	/** Constante de c�digo RPG005: Error al abrir la bbdd. */
	public static final RPGenericErrorCode OPEN_SESSION_BD_ERROR_MESSAGE =
			new RPGenericErrorCode("RPG005", "OPEN SESSION BD ERROR");
	/** Constante de c�digo RPG006: Error al obtener el usuario. */
	public static final RPGenericErrorCode GET_USER_ERROR_MESSAGE =
			new RPGenericErrorCode("RPG006", "GET USER ERROR");
	
	
	/**
	 * Constructor con c�digo de error y mensaje.
	 * 
	 * @param code
	 *            C�digo interno del error.
	 * @param message
	 *            Mensaje descriptivo del error.
	 */
	protected RPGenericErrorCode(String code, String message) {
		super(code, message);
	}
}