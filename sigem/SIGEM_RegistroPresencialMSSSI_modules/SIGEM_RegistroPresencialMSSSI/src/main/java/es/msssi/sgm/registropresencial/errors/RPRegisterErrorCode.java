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
 * Clase que recoge los c�digos de error referentes a operaciones con registros.
 * 
 * @author jortizs
 */
public class RPRegisterErrorCode extends ErrorCode {
	/**
	 * Constante de c�digo RPRR001: Error abriendo un registro.
	 */
	public static final RPRegisterErrorCode OPEN_REGISTER_ERROR =
			new RPRegisterErrorCode("RPRR001", "OPEN REGISTER ERROR");
	/**
	 * Constante de c�digo RPRR002: Error cerrando un registro.
	 */
	public static final RPRegisterErrorCode CLOSE_REGISTER_ERROR =
			new RPRegisterErrorCode("RPRR002", "CLOSE REGISTER ERROR");
	/**
	 * Constante de c�digo RPRR003: Error en la obtenci�n del
	 * hist�rico de registros o del registro.
	 */
	public static final RPRegisterErrorCode GET_HISTORICAL_REGISTER_ERROR =
			new RPRegisterErrorCode("RPRR003", "GET HISTORICAL REGISTER ERROR");
	
	/**
	 * Constante de c�digo RPRR004: Error en la marcar el formulario como s�lo lectura.
	 */
	public static final RPRegisterErrorCode LOCK_REGISTER_ERROR =
			new RPRegisterErrorCode("RPRR004", "LOCK REGISTER ERROR");
	/**
	 * Constante de c�digo RPRR005: Error borrando una asociaci�n de un registro.
	 */
	public static final RPRegisterErrorCode DELETE_ASSOC_REGISTER_ERROR =
			new RPRegisterErrorCode("RPRR005", "DELETE ASSOCIATION REGISTER ERROR");
	/**
	 * Constante de c�digo RPRR006: Error asociando un registro.
	 */
	public static final RPRegisterErrorCode SAVE_ASSOC_REGISTER_ERROR =
			new RPRegisterErrorCode("RPRR006", "SAVE ASSOCIATION REGISTER ERROR");
	/**
	 * Constante de c�digo RPRR007: Error recuperando los documentos de un registro.
	 */
	public static final RPRegisterErrorCode GET_REGISTER_DOCUMENTS_ERROR =
			new RPRegisterErrorCode("RPRR007", "GET REGISTER DOCUMENTS ERROR");
	
	/**
	 * Constante de c�digo RPRR008: Error guardando los documentos de un registro.
	 */
	public static final RPRegisterErrorCode ADD_REGISTER_DOCUMENTS_ERROR =
			new RPRegisterErrorCode("RPRR008", "ADD REGISTER DOCUMENTS ERROR");
	
	/**
	 * Constante de c�digo RPRR009: No se puede mover el registro de libro.
	 */
	public static final RPRegisterErrorCode MOVE_REGISTER_ERROR =
			new RPRegisterErrorCode("RPRR009", "MOVE REGISTER ERROR");
	/**
	 * Constante de c�digo RPRR010: No se puede borrar el documento del registro.
	 */
	public static final RPRegisterErrorCode DELETE_REGISTER_DOCUMENTS_ERROR = 
			new RPRegisterErrorCode("RPRR010", "DETELE REGISTER DOCUMENT ERROR");
	/**
	 * Constante de c�digo RPRR011: No se puede modificar un documento del registro.
	 */
	public static final RPRegisterErrorCode UPDATE_REGISTER_DOCUMENTS_ERROR = 
			new RPRegisterErrorCode("RPRR011", "UPDATE REGISTER DOCUMENT ERROR");
	
	/**
	 * Constructor con c�digo de error y mensaje.
	 * 
	 * @param code
	 *            C�digo interno del error.
	 * @param message
	 *            Mensaje descriptivo del error.
	 */
	protected RPRegisterErrorCode(String code, String message) {
		super(code, message);
	}
}