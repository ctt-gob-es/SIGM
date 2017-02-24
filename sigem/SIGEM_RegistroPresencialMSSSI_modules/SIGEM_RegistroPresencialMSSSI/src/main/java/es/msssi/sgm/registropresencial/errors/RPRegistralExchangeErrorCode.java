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
 * Clase que recoge los c�digos de error referentes a operaciones con los
 * libros.
 * 
 * @author jortizs
 */
public class RPRegistralExchangeErrorCode extends ErrorCode {
    /** Constante de c�digo RPER001: Error . */
    public static final RPRegistralExchangeErrorCode ERROR = new RPRegistralExchangeErrorCode(
	"RPER001", "");

    /**
     * Constante de c�digo RPER002: Error en la marcar el formulario como s�lo
     * lectura.
     */
    public static final RPRegistralExchangeErrorCode SEARCH_DESTINATION_REG_INTERCHANGE_ERROR_MESSAGE =
	new RPRegistralExchangeErrorCode(
	    "RPER002", "SEARCH_DESTINATION_REG_INTERCHANGE_ERROR_MESSAGE");

    /**
     * Constante de c�digo RPER003: Error en el env�o del asiento registral.
     */
    public static final RPRegistralExchangeErrorCode SEND_REG_INTERCHANGE_ERROR_MESSAGE =
	new RPRegistralExchangeErrorCode(
	    "RPER003", "SEND_REG_INTERCHANGE_ERROR_MESSAGE");

    /**
     * Constante de c�digo RPER004: Error consultando el hist�rico de entrada
     * del asiento registral.
     */
    public static final RPRegistralExchangeErrorCode GET_HIST_INPUT_REG_INTERCHANGE_ERROR_MESSAGE =
	new RPRegistralExchangeErrorCode(
	    "RPER004", "GET_HIST_INPUT_REG_INTERCHANGE_ERROR_MESSAGE");

    /**
     * Constante de c�digo RPER005: Error consultando el hist�rico de salida del
     * asiento registral.
     */
    public static final RPRegistralExchangeErrorCode GET_HIST_OUTPUT_REG_INTERCHANGE_ERROR_MESSAGE =
	new RPRegistralExchangeErrorCode(
	    "RPER005", "GET_HIST_OUTPUT_REG_INTERCHANGE_ERROR_MESSAGE");

    /**
     * Constante de c�digo RPER006: Error recuperando la bandeja de entrada del
     * asiento registral.
     */
    public static final RPRegistralExchangeErrorCode GET_INBOX_REG_INTERCHANGE_ERROR_MESSAGE =
	new RPRegistralExchangeErrorCode(
	    "RPER006", "GET_INBOX_REG_INTERCHANGE_ERROR_MESSAGE");

    /**
     * Constante de c�digo RPER007: Error recuperando la bandeja de salida del
     * asiento registral.
     */
    public static final RPRegistralExchangeErrorCode GET_OUTBOX_REG_INTERCHANGE_ERROR_MESSAGE =
	new RPRegistralExchangeErrorCode(
	    "RPER007", "GET_OUTBOX_REG_INTERCHANGE_ERROR_MESSAGE");

    /**
     * Constante de c�digo RPER008: Error aceptando registros del intercambio
     * registral.
     */
    public static final RPRegistralExchangeErrorCode ACCEPT_INBOX_REG_INTERCHANGE_ERROR_MESSAGE =
	new RPRegistralExchangeErrorCode(
	    "RPER008", "ACCEPT_INBOX_REG_INTERCHANGE_ERROR_MESSAGE");
    /**
     * Constante de c�digo RPER009: Error rechazando registros del intercambio
     * registral.
     */
    public static final RPRegistralExchangeErrorCode REJECT_INBOX_REG_INTERCHANGE_ERROR_MESSAGE =
	new RPRegistralExchangeErrorCode(
	    "RPER009", "REJECT_INBOX_REG_INTERCHANGE_ERROR_MESSAGE");

    /**
     * Constante de c�digo RPER010: Error recuperando un asiento registral.
     */
    public static final RPRegistralExchangeErrorCode GET_INPUT_REG_INTERCHANGE_ERROR_MESSAGE =
	new RPRegistralExchangeErrorCode(
	    "RPER010", "REJECT_INBOX_REG_INTERCHANGE_ERROR_MESSAGE");
    /**
     * Constante de c�digo RPER011: Error reenviando un asiento registral.
     */
    public static final RPRegistralExchangeErrorCode FORWARD_INBOX_REG_INTERCHANGE_ERROR_MESSAGE =
	new RPRegistralExchangeErrorCode(
	    "RPER011", "FORWARD_INBOX_REG_INTERCHANGE_ERROR_MESSAGE");
    /**
     * Constante de c�digo RPER012: Error recuperando lista de entidades
     * registrales.
     */
    public static final RPRegistralExchangeErrorCode GET_ENTITYLIST_REG_INTERCHANGE_ERROR_MESSAGE =
	new RPRegistralExchangeErrorCode(
	    "RPER012", "GET_ENTITYLIST_REG_INTERCHANGE_ERROR_MESSAGE");

    /**
     * Constante de c�digo RPER013: Error recuperando lista de unidades
     * tramitadoras.
     */
    public static final RPRegistralExchangeErrorCode GET_UNIDLIST_REG_INTERCHANGE_ERROR_MESSAGE =
	new RPRegistralExchangeErrorCode(
	    "RPER013", "GET_UNIDLIST_REG_INTERCHANGE_ERROR_MESSAGE");

    /**
     * Constante de c�digo RPER014: Error recuperando lista de unidades
     * tramitadoras.
     */
    public static final RPRegistralExchangeErrorCode DOWNLOADFILE_ERROR_MESSAGE =
	new RPRegistralExchangeErrorCode(
	    "RPER014", "DOWNLOADFILE_ERROR_MESSAGE");

    /**
     * Constante de c�digo RPER015: Error recuperando el n�mero de registros
     * pendientes en la bandeja de entrada.
     */
    public static final RPRegistralExchangeErrorCode GET_PENDING_INBOX_REG_INTERCHANGE_ERROR_MESSAGE =
	new RPRegistralExchangeErrorCode(
	    "RPER015", "GET_PENDING_INBOX_REG_INTERCHANGE_ERROR_MESSAGE");
    /**
     * Constante de c�digo RPER016: Error recuperando una unidad tramitadora.
     */
    public static final RPRegistralExchangeErrorCode GET_UNID_REG_INTERCHANGE_ERROR_MESSAGE =
	new RPRegistralExchangeErrorCode(
	    "RPER016", "GET_UNID_REG_INTERCHANGE_ERROR_MESSAGE");

    /**
     * Constructor con c�digo de error y mensaje.
     * 
     * @param code
     *            C�digo interno del error.
     * @param message
     *            Mensaje descriptivo del error.
     */
    protected RPRegistralExchangeErrorCode(String code, String message) {
	super(code, message);
    }
}