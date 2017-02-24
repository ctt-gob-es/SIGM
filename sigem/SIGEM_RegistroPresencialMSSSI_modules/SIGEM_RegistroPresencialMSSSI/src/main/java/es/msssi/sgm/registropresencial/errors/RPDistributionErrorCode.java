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
 * Clase que recoge los c�digos de error referentes a operaciones con distribuciones.
 * 
 * @author jortizs
 */
public class RPDistributionErrorCode
		extends ErrorCode {
	/** Constante de c�digo RPD001: Error en la obtenci�n de la distribuci�n. */
	public static final RPBookErrorCode GET_DISTRIBUTION_ERROR = new RPBookErrorCode(
			"RPD001", "GET DISTRIBUTION ERROR");
	/** Constante de c�digo RPD002: Error en el archivado. */
	public static final RPBookErrorCode ARC_DISTRIBUTION_ERROR = new RPBookErrorCode(
			"RPD002", "ARCHIVE DISTRIBUTION ERROR");
	/** Constante de c�digo RPD003: Error ACEP distribuci�n. */
	public static final RPBookErrorCode ACEPTAR_DISTRIBUTION_ERROR = new RPBookErrorCode(
			"RPD003", "ACCEPT DISTRIBUTION ERROR");
	/** Constante de c�digo RPD004: Error RECHAZAR distribuci�n. */
	public static final RPBookErrorCode RECHAZAR_DISTRIBUTION_ERROR = new RPBookErrorCode(
			"RPD004", "REJECT DISTRIBUTION ERROR");
	/** Constante de c�digo RPD005: Error CAMBIAR DESTINO distribuci�n. */
	public static final RPBookErrorCode CAMBIARDEST_DISTRIBUTION_ERROR = new RPBookErrorCode(
			"RPD005", "CHANGE DISTRIBUTION ERROR");
	/** Constante de c�digo RPD006: Error REDISTRIBUTION distribuci�n. */
	public static final RPBookErrorCode REDISTRIBUTION_DISTRIBUTION_ERROR = new RPBookErrorCode(
			"RPD006", "REDISTRIBUTION DISTRIBUTION ERROR");
	/** Constante de c�digo RPD007: Error obteniendo el n�mero de distribuciones. */
	public static final RPBookErrorCode GET_COUNT_DISTRIBUTION_ERROR = new RPBookErrorCode(
		"RPD007", "COUNT DISTRIBUTIONS ERROR");
	
	/**
	 * Constructor con c�digo de error y mensaje.
	 * 
	 * @param code
	 *            C�digo interno del error.
	 * @param message
	 *            Mensaje descriptivo del error.
	 */
	protected RPDistributionErrorCode(String code, String message) {
		super(code, message);
	}
}