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
 * Clase que recoge los c�digos de error referentes a operaciones con las
 * exportaciones a Excel y PDF.
 * 
 * @author jortizs
 */
public class RPExportErrorCode
		extends ErrorCode {
	/** Constante de c�digo RPE001: Error al obtener la imagen de la cabecera. */
	public static final RPExportErrorCode GET_HEADER_IMAGE_ERROR = new RPExportErrorCode(
			"RPE001", "ERROR GETTING HEADER IMAGE FOR EXCEL DOCUMENT");
	/** Constante de c�digo RPE002: Error al construir el documento PDF. */
	public static final RPExportErrorCode BUILD_PDF_DOCUMENT_ERROR =
			new RPExportErrorCode("RPE002", "ERROR BUILDING PDF DOCUMENT");
	/** Constante de c�digo RPE003: Error al exportar el documento PDF. */
	public static final RPExportErrorCode EXPORT_PDF_DOCUMENT_ERROR =
			new RPExportErrorCode("RPE003", "ERROR CONVERTING PDF DOCUMENT");
	/** Constante de c�digo RPE004: Error al exportar el documento Excel. */
	public static final RPExportErrorCode EXPORT_XLS_DOCUMENT_ERROR =
			new RPExportErrorCode("RPE004", "ERROR CONVERTING XLS DOCUMENT");
	
	/**
	 * Constructor con c�digo de error y mensaje.
	 * 
	 * @param code
	 *            C�digo interno del error.
	 * @param message
	 *            Mensaje descriptivo del error.
	 */
	protected RPExportErrorCode(String code, String message) {
		super(code, message);
	}
}