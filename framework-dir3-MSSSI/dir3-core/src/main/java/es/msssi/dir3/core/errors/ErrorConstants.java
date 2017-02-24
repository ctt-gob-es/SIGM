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

/**
 * Clase que recoge las constantes de error, que se mostrar�n en las excepciones
 * y en el log.
 * 
 * @author cmorenog
 */
public class ErrorConstants {
    /** Mensaje de error para excepciones. */

    public static final String GET_COUNT_OFFICE_ERROR_MESSAGE =
	"Error recuperando el n�mero de oficinas";
    public static final String GET_COUNT_UNIT_ERROR_MESSAGE =
	"Error recuperando el n�mero de unidades org�nicas";
    public static final String GET_COUNT_UPDATE_ERROR_MESSAGE =
	"Error recuperando el n�mero de actualizaciones";
    public static final String GET_OFFICE_ERROR_MESSAGE = "Error recuperando una oficina";
    public static final String GET_UNIT_ERROR_MESSAGE = "Error recuperando una unidad org�nica";
    public static final String GET_UPDATE_ERROR_MESSAGE = "Error recuperando una actualizaci�n";
    public static final String GET_LAST_UPDATE_ERROR_MESSAGE =
	"Error recuperando la �ltima actualizaci�n actualizaci�n";
    public static final String GET_ALL_OFFICES_ERROR_MESSAGE =
	"Error recuperando todas las oficinas";
    public static final String GET_ALL_UNITS_ERROR_MESSAGE =
	"Error recuperando todas las unidades org�nicas";
    public static final String GET_ALL_UPDATES_ERROR_MESSAGE =
	"Error recuperando todas las actualizaciones";
    public static final String FIND_OFFICES_ERROR_MESSAGE = "Error en la b�squeda de oficinas";
    public static final String FIND_UNITS_ERROR_MESSAGE = "Error en la b�squeda de unidades";
    public static final String FIND_UPDATES_ERROR_MESSAGE =
	"Error en la b�squeda de actualizaciones";
    public static final String EXISTS_OFFICE_ERROR_MESSAGE =
	"Error comprobando la existencia de una oficina";
    public static final String EXISTS_UNIT_ERROR_MESSAGE =
	"Error comprobando la existencia de una unidad org�nica";
    public static final String EXISTS_UPDATE_ERROR_MESSAGE =
	"Error comprobando la existencia de una actualizaci�n";
    public static final String SAVE_UPDATE_ERROR_MESSAGE = "Error guardando una actualizaci�n";
    public static final String DELETE_UPDATE_ERROR_MESSAGE = "Error eliminando una actualizaci�n";
    public static final String UPDATE_UPDATE_ERROR_MESSAGE = "Error modificando una actualizaci�n";
    public static final String START_TRANSACTION_ERROR = "Error iniciando transacci�n";
    public static final String COMMIT_TRANSACTION_ERROR = "Error en el commit de la transacci�n";
    public static final String END_TRANSACTION_ERROR = "Error cerrando la transacci�n";
    public static final String CONVERT_XMLTOOFFICE_ERROR =
	"Error convirtiendo el xml en una lista de oficinas.";
    public static final String CONVERT_XMLTOSERVICES_ERROR =
	"Error convirtiendo el xml en una lista de servicios.";
    public static final String CONVERT_XMLTOCONTACTS_ERROR =
	"Error convirtiendo el xml en una lista de contactos.";
    public static final String CONVERT_XMLTORELATIONSSIR_ERROR =
	"Error convirtiendo el xml en una lista de relaciones sir.";
    public static final String CONVERT_XMLTORELATIONS_ERROR =
	"Error convirtiendo el xml en una lista de relaciones.";
    public static final String CONVERT_XMLTOHISTORIC_ERROR =
	"Error convirtiendo el xml en una lista de hist�ricos.";
    public static final String CONVERT_XMLTOUNITS_ERROR =
	"Error convirtiendo el xml en una lista de unidades org�nicas.";
    public static final String GET_FILE_UNIT_UPDATESERVICE_ERROR =
	"Error recuperando el fichero de unidades org�nicas.";
    public static final String GET_FILE_OFFICE_UPDATESERVICE_ERROR =
	"Error recuperando el fichero de oficinas.";
    public static final String UNZIP_ERROR_MESSAGE = "Error descomprimiendo un fichero.";
    public static final String IO_ERROR_MESSAGE = "Error leyendo un fichero.";
    public static final String SAVE_OFFICE_ERROR_MESSAGE = "Insertando una oficina.";
    public static final String UPDATE_OFFICE_ERROR_MESSAGE = "Modificando una oficina.";
    public static final String INSERT_UNIT_ERROR_MESSAGE = "Insertando una unidad org�nica.";
    public static final String UPDATE_UNIT_ERROR_MESSAGE = "Modificando una unidad org�nica.";
    public static final String INSERT_HISTORIES_UNIT_ERROR_MESSAGE =
	"Insertando el hist�rico de una unidad org�nica.";
    public static final String INSERT_HISTORIES_OFFICE_ERROR_MESSAGE =
	"Insertando el hist�rico de una oficina.";
    public static final String GET_RELATIONSHIP_ERROR_MESSAGE =
	"Error recuperando una relaci�n de oficina y unidad org�nica.";
    public static final String EXISTS_RELATIONSHIP_ERROR_MESSAGE =
	"Error comprobando la existencia de una relaci�n de oficina y unidad org�nica.";
    public static final String INSERT_RELATIONSHIP_ERROR_MESSAGE =
	"Error insertando una relaci�n de oficina y unidad org�nica.";
    public static final String UPDATE_RELATIONSHIP_ERROR_MESSAGE =
	"Error modificando una relaci�n de oficina y unidad org�nica.";
    public static final String INSERTUPDATE_OFFICE_ERROR_MESSAGE =
	"Error insertando o modificando la oficina:";
    public static final String INSERTUPDATE_UNIT_ERROR_MESSAGE =
	"Error insertando o modificando la unidad:";
    public static final String GET_FILE_NOTORGUNIT_UPDATESERVICE_ERROR =
	    "Error recuperando el fichero de unidades no org�nicas.";
    public static final String DELETE_RELATIONSHIPREGISTER_ERROR_MESSAGE = 
	    "Error borrando una relaci�n de oficina y unidad org�nica en registro.";
}