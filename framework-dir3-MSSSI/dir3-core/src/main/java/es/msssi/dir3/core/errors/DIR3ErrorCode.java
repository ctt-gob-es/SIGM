/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.dir3.core.errors;

import core.error.ErrorCode;

/**
 * Clase que recoge los c�digos de error referentes a operaciones del dir3.
 * 
 * @author cmorenog
 */
public class DIR3ErrorCode extends ErrorCode {
    /** Constante de c�digo DIR001: Error obteniendo el n�mero de oficinas. */
    public static final DIR3ErrorCode GET_COUNT_OFFICE_ERROR = new DIR3ErrorCode(
	"DIR001", "GET COUNT OFFICE");
    /**
     * Constante de c�digo DIR002: Error obteniendo el n�mero de unidades
     * org�nicas.
     */
    public static final DIR3ErrorCode GET_COUNT_UNIT_ERROR = new DIR3ErrorCode(
	"DIR002", "GET COUNT UNIT");
    /**
     * Constante de c�digo DIR003: Error obteniendo el n�mero de
     * actualizaciones.
     */
    public static final DIR3ErrorCode GET_COUNT_UPDATE_ERROR = new DIR3ErrorCode(
	"DIR003", "GET COUNT UDPATE");
    /** Constante de c�digo DIR004: Error obteniendo una oficina. */
    public static final DIR3ErrorCode GET_OFFICE_ERROR = new DIR3ErrorCode(
	"DIR004", "GET OFFICE");
    /** Constante de c�digo DIR005: Error obteniendo una unidad. */
    public static final DIR3ErrorCode GET_UNIT_ERROR = new DIR3ErrorCode(
	"DIR005", "GET UNIT");
    /** Constante de c�digo DIR006: Error obteniendo una actualizaci�n. */
    public static final DIR3ErrorCode GET_UPDATE_ERROR = new DIR3ErrorCode(
	"DIR006", "GET UPDATE");
    /** Constante de c�digo DIR007: Error obteniendo la �ltima actualizaci�n. */
    public static final DIR3ErrorCode GET_LAST_UPDATE_ERROR = new DIR3ErrorCode(
	"DIR007", "GET LAST UPDATE");
    /** Constante de c�digo DIR008: Error obteniendo todas las oficinas. */
    public static final DIR3ErrorCode GET_ALL_OFFICES_ERROR = new DIR3ErrorCode(
	"DIR008", "GET ALL OFFICES");
    /**
     * Constante de c�digo DIR009: Error obteniendo todas las unidades
     * org�nicas.
     */
    public static final DIR3ErrorCode GET_ALL_UNITS_ERROR = new DIR3ErrorCode(
	"DIR009", "GET ALL UNITS");
    /** Constante de c�digo DIR010: Error obteniendo todas las actualizaciones. */
    public static final DIR3ErrorCode GET_ALL_UDPATES_ERROR = new DIR3ErrorCode(
	"DIR010", "GET ALL UDPATES");
    /** Constante de c�digo DIR011: Error en la b�squeda de oficinas. */
    public static final DIR3ErrorCode FIND_OFFICES_ERROR = new DIR3ErrorCode(
	"DIR011", "FIND OFFICES ERROR");
    /** Constante de c�digo DIR012: Error en la b�squeda de unidades org�nicas. */
    public static final DIR3ErrorCode FIND_UNITS_ERROR = new DIR3ErrorCode(
	"DIR012", "FIND UNIT ERROR");
    /** Constante de c�digo DIR013: Error en la b�squeda de actualizaciones. */
    public static final DIR3ErrorCode FIND_UPDATES_ERROR = new DIR3ErrorCode(
	"DIR013", "FIND UPDATE ERROR");
    /**
     * Constante de c�digo DIR014: Error comprobando la existencia de una
     * oficina.
     */
    public static final DIR3ErrorCode EXISTS_OFFICE_ERROR = new DIR3ErrorCode(
	"DIR014", "EXISTS OFFICE ERROR");
    /**
     * Constante de c�digo DIR015: Error comprobando la existencia de una unidad
     * org�nica.
     */
    public static final DIR3ErrorCode EXISTS_UNIT_ERROR = new DIR3ErrorCode(
	"DIR015", "EXISTS UNIT ERROR");
    /**
     * Constante de c�digo DIR016: Error comprobando la existencia de una
     * actualizaci�n.
     */
    public static final DIR3ErrorCode EXISTS_UPDATE_ERROR = new DIR3ErrorCode(
	"DIR016", "EXISTS UPDATE ERROR");
    /** Constante de c�digo DIR017: Error guardando una actualizaci�n. */
    public static final DIR3ErrorCode SAVE_UPDATE_ERROR = new DIR3ErrorCode(
	"DIR017", "SAVE UPDATE ERROR");
    /** Constante de c�digo DIR018: Error eliminando una actualizaci�n. */
    public static final DIR3ErrorCode DELETE_UPDATE_ERROR = new DIR3ErrorCode(
	"DIR018", "DELETE UPDATE ERROR");
    /** Constante de c�digo DIR019: Error modificando una actualizaci�n. */
    public static final DIR3ErrorCode UPDATE_UPDATE_ERROR = new DIR3ErrorCode(
	"DIR019", "UPDATE UPDATE ERROR");
    /** Constante de c�digo DIR020: Error convirtiendo xml a oficinas. */
    public static final DIR3ErrorCode CONVERT_XMLTOOFFICE_ERROR = new DIR3ErrorCode(
	"DIR020", "CONVERT XML TO OFFICE ERROR");
    /** Constante de c�digo DIR021: Error convirtiendo xml a oficinas. */
    public static final DIR3ErrorCode CONVERT_XMLTOSERVICES_ERROR = new DIR3ErrorCode(
	"DIR021", "CONVERT XML TO SERVICES ERROR");
    /** Constante de c�digo DIR022: Error convirtiendo xml a oficinas. */
    public static final DIR3ErrorCode CONVERT_XMLTOCONTACTS_ERROR = new DIR3ErrorCode(
	"DIR022", "CONVERT XML TO CONTACTS ERROR");
    /** Constante de c�digo DIR023: Error convirtiendo xml a relaciones sir. */
    public static final DIR3ErrorCode CONVERT_XMLTORELATIONSSIR_ERROR = new DIR3ErrorCode(
	"DIR023", "CONVERT XML TO RELATIONS SIR ERROR");
    /** Constante de c�digo DIR024: Error convirtiendo xml a relaciones. */
    public static final DIR3ErrorCode CONVERT_XMLTORELATIONS_ERROR = new DIR3ErrorCode(
	"DIR024", "CONVERT XML TO RELATIONS ERROR");
    /** Constante de c�digo DIR025: Error convirtiendo xml a relaciones. */
    public static final DIR3ErrorCode CONVERT_XMLTOHISTORIC_ERROR = new DIR3ErrorCode(
	"DIR025", "CONVERT XML TO HISTORIC ERROR");
    /** Constante de c�digo DIR026: Error convirtiendo xml a relaciones. */
    public static final DIR3ErrorCode CONVERT_XMLTOUNITS_ERROR = new DIR3ErrorCode(
	"DIR026", "CONVERT XML TO UNIST ERROR");
    /**
     * Constante de c�digo DIR027: Error obteniendo la �ltima actualizaci�n en
     * el servicio de actualizacion.
     */
    public static final DIR3ErrorCode GET_LAST_UPDATE_UPDATESERVICE_ERROR = new DIR3ErrorCode(
	"DIR027", "GET LAST UPDATE IN UPDATE SERVICE");
    /**
     * Constante de c�digo DIR028: Error recuperando el fichero de unidades
     * org�nicas.
     */
    public static final DIR3ErrorCode GET_FILE_UNIT_UPDATESERVICE_ERROR = new DIR3ErrorCode(
	"DIR028", "GET FILE UNIT UPDATE SERVICE ERROR");
    /**
     * Constante de c�digo DIR029: Error recuperando el fichero de oficinas
     * org�nicas.
     */
    public static final DIR3ErrorCode GET_FILE_OFFICE_UPDATESERVICE_ERROR = new DIR3ErrorCode(
	"DIR029", "GET FILE OFFICE UPDATE SERVICE ERROR");
    /**
     * Constante de c�digo DIR030: Error recuperando el fichero de oficinas
     * org�nicas.
     */
    public static final DIR3ErrorCode UNZIP_ERROR_MESSAGE = new DIR3ErrorCode(
	"DIR030", "UNZIP ERROR");
    /**
     * Constante de c�digo DIR031: Error recuperando el fichero de oficinas
     * org�nicas.
     */
    public static final DIR3ErrorCode IO_ERROR_MESSAGE = new DIR3ErrorCode(
	"DIR031", "IO ERROR");
    /**
     * Constante de c�digo DIR032: Error borrando una oficina.
     */
    public static final DIR3ErrorCode SAVE_OFFICE_ERROR = new DIR3ErrorCode(
	"DIR032", "SAVE OFFICE ERROR");
    /**
     * Constante de c�digo DIR033: Error guardando una oficina.
     */
    public static final DIR3ErrorCode UPDATE_OFFICE_ERROR_MESSAGE = new DIR3ErrorCode(
	"DIR033", "UPDATE OFFICE ERROR");
    /**
     * Constante de c�digo DIR034: Error guardando una oficina.
     */
    public static final DIR3ErrorCode INSERT_UNIT_ERROR = new DIR3ErrorCode(
	"DIR034", "INSERT UNIT ERROR");
    /**
     * Constante de c�digo DIR035: Error guardando una oficina.
     */
    public static final DIR3ErrorCode UPDATE_UNIT_ERROR = new DIR3ErrorCode(
	"DIR035", "UPDATE UNIT ERROR");
    /**
     * Constante de c�digo DIR036: Error insertando hist�nico de una unidad.
     */
    public static final DIR3ErrorCode INSERT_HISTORIES_UNIT_ERROR = new DIR3ErrorCode(
	"DIR036", "INSERT HISTORIES UNIT ERROR");
    /**
     * Constante de c�digo DIR037: Error insertando hist�nico de una oficina.
     */
    public static final DIR3ErrorCode INSERT_HISTORIES_OFFICE_ERROR = new DIR3ErrorCode(
	"DIR037", "INSERT HISTORIES OFFICE ERROR");
    /** Constante de c�digo DIR038: Error obteniendo una relaci�n. */
    public static final DIR3ErrorCode GET_RELATIONSHIP_ERROR = new DIR3ErrorCode(
	"DIR038", "GET RELATIONSHIP");
    /**
     * Constante de c�digo DIR039: Error comprobando la existencia de una
     * relaci�n.
     */
    public static final DIR3ErrorCode EXISTS_RELATIONSHIP_ERROR = new DIR3ErrorCode(
	"DIR039", "EXISTS RELATIONSHIP ERROR");
    /**
     * Constante de c�digo DIR040: Error insertando relaci�n.
     */
    public static final DIR3ErrorCode INSERT_RELATIONSHIP_ERROR = new DIR3ErrorCode(
	"DIR040", "INSERT RELATIONSHIP ERROR");
    /**
     * Constante de c�digo DIR041: Error modificando una relaci�n.
     */
    public static final DIR3ErrorCode UPDATE_RELATIONSHIP_ERROR = new DIR3ErrorCode(
	"DIR041", "UPDATE RELATIONSHIP ERROR");
    /**
     * Constante de c�digo DIR028: Error recuperando el fichero de unidades no 
     * org�nicas.
     */
    public static final DIR3ErrorCode GET_FILE_NOTORGUNIT_UPDATESERVICE_ERROR = new DIR3ErrorCode(
		"DIR042", "GET FILE NO ORG UNIT UPDATE SERVICE ERROR");
    /**
     * Constante de c�digo DIR043: Error borrando una relaci�n en registro.
     */
    public static final DIR3ErrorCode DELETE_RELATIONSHIPREGISTER_ERROR  = new DIR3ErrorCode(
		"DIR043", "DELETE REGISTER RELATIONSHIP ERROR");
    /**
     * Constructor con c�digo de error y mensaje.
     * 
     * @param code
     *            C�digo interno del error.
     * @param message
     *            Mensaje descriptivo del error.
     */
    protected DIR3ErrorCode(String code, String message) {
	super(code, message);
    }
}