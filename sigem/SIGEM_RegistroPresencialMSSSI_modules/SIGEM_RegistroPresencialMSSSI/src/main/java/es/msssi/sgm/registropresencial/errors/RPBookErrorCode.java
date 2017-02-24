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
 * Clase que recoge los c�digos de error referentes a operaciones con los libros.
 * 
 * @author jortizs
 */
public class RPBookErrorCode
		extends ErrorCode {
	/** Constante de c�digo RPB003: Error en la obtenci�n de los libros. */
	public static final RPBookErrorCode GET_BOOKS_ERROR = new RPBookErrorCode("RPB003",
			"GET BOOKS ERROR");
	/** Constante de c�digo RPB004: Error en la obtenci�n del libro. */
	public static final RPBookErrorCode GET_BOOK_ERROR = new RPBookErrorCode("RPB004",
			"GET BOOK ERROR");
	/** Constante de c�digo RPB005: Error al abrir el libro. */
	public static final RPBookErrorCode OPEN_BOOK_ERROR = new RPBookErrorCode("RPB005",
			"OPEN BOOK ERROR");
	/** Constante de c�digo RPB006: Error al cerrar el libro. */
	public static final RPBookErrorCode CLOSE_BOOK_ERROR = new RPBookErrorCode("RPB006",
			"CLOSE BOOK ERROR");
	/** Constante de c�digo RPB007: Error al obtener el hist�rico del libro. */
	public static final RPBookErrorCode GET_BOOK_HISTORICAL_ERROR = new RPBookErrorCode(
			"RPB007", "GET BOOK HISTORICAL ERROR");
	/** Constante de c�digo RPB008: Error al obtener los datos de sesi�n del libro. */
	public static final RPBookErrorCode GET_SESSION_BOOK_ERROR = new RPBookErrorCode(
			"RPB008", "GET SESSION BOOK ERROR");
	
	/**
	 * Constructor con c�digo de error y mensaje.
	 * 
	 * @param code
	 *            C�digo interno del error.
	 * @param message
	 *            Mensaje descriptivo del error.
	 */
	protected RPBookErrorCode(String code, String message) {
		super(code, message);
	}
}