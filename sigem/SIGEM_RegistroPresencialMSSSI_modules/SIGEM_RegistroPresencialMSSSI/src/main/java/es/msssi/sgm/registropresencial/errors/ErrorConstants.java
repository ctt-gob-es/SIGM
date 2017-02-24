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

/**
 * Clase que recoge las constantes de error, que se mostrar�n en las excepciones
 * y en el log.
 * 
 * @author jortizs
 */
public class ErrorConstants {
    /** Mensaje de error para excepciones de Faces: Conversion Error. */
    public static final String CONVERSION_ERROR_FACES_MESSAGE = "Conversion Error";

    /** Mensaje de error para asuntos: El asunto no existe. */
    public static final String ASUNT_DOES_NOT_EXISTS_MESSAGE = "El asunto no existe";
    /** Mensaje de error para organismos: El organismo no existe. */
    public static final String ORGANISM_DOES_NOT_EXISTS_MESSAGE = "El organismo no existe";
    /** Mensaje de error para grupos: El grupo no existe. */
    public static final String GROUP_DOES_NOT_EXISTS_MESSAGE = "El grupo no existe";
    /** Mensaje de error para usuarios: El usuario no existe. */
    public static final String USER_DOES_NOT_EXISTS_MESSAGE = "El usuario no existe";

    /**
     * Mensaje de error de manejo de libros: Error en la obtenci�n de los
     * libros.
     */
    public static final String GET_BOOKS_ERROR_MESSAGE = "Error en la obtenci�n de los libros";
    /** Mensaje de error de manejo de libros: Error en la obtenci�n del libro. */
    public static final String GET_BOOK_ERROR_MESSAGE = "Error en la obtenci�n del libro";
    /** Mensaje de error de manejo de libros: Error en la apertura del libro. */
    public static final String OPEN_BOOK_ERROR_MESSAGE = "Error en la apertura del libro";
    /** Mensaje de error de manejo de libros: Error en el cierre del libro. */
    public static final String CLOSE_BOOK_ERROR_MESSAGE = "Error en el cierre del libro";
    /**
     * Mensaje de error de manejo de libros: El libro no estaba cargado
     * previamente.
     */
    public static final String BOOK_NOT_PREVIOUSLY_LOADED_ERROR_MESSAGE =
	"El libro no estaba cargado previamente";
    /**
     * Mensaje de error de manejo de libros: No ha sido posible obtener la
     * informaci�n del libro.
     */
    public static final String GET_INFORMATION_BOOK_ERROR_MESSAGE =
	"No ha sido posible obtener la informaci�n del libro";
    /**
     * Mensaje de error de manejo de libros: Error al obtener los datos de
     * sesi�n del libro.
     */
    public static final String GET_SESSION_INFORMATION_BOOK_ERROR_MESSAGE =
	"Error al obtener los datos de sesi�n del libro";

    /**
     * Mensaje de error en tareas de exportaci�n: Error al obtener la imagen de
     * la cabecera.
     */
    public static final String GET_HEADER_IMAGE_ERROR_MESSAGE =
	"Error al obtener la imagen de la cabecera";
    /**
     * Mensaje de error en tareas de exportaci�n: Error al exportar a un
     * documento Excel.
     */
    public static final String EXCEL_DOCUMENT_EXPORT_ERROR_MESSAGE =
	"Error al exportar a un documento Excel";
    /**
     * Mensaje de error en tareas de exportaci�n: Error al escribir el documento
     * Excel en la respuesta.
     */
    public static final String WRITE_EXCEL_INTO_RESPONSE_ERROR_MESSAGE =
	"Error al escribir el documento Excel en la respuesta";
    /**
     * Mensaje de error en tareas de exportaci�n: Error al exportar a un
     * documento PDF.
     */
    public static final String PDF_DOCUMENT_EXPORT_ERROR_MESSAGE =
	"Error al exportar a un documento PDF";
    /**
     * Mensaje de error en tareas de exportaci�n: Error al escribir el documento
     * PDF en la respuesta.
     */
    public static final String WRITE_PDF_INTO_RESPONSE_ERROR_MESSAGE =
	"Error al escribir el documento PDF en la respuesta";

    /**
     * Mensaje de error en tareas con registros de entrada: Error en la creaci�n
     * de un nuevo registro de entrada.
     */
    public static final String CREATE_INPUT_REGISTER_ERROR_MESSAGE =
	"Error en la creaci�n de un nuevo registro de entrada";
    /**
     * Mensaje de error en tareas con registros de entrada: Error en la
     * modificaci�n de un nuevo registro de entrada.
     */
    public static final String UPDATE_INPUT_REGISTER_ERROR_MESSAGE =
	"Error en la modificaci�n de un nuevo registro de entrada";
    /**
     * Mensaje de error en tareas con registros de entrada: Error en el guardado
     * de un nuevo registro de entrada.
     */
    public static final String SAVE_INPUT_REGISTER_ERROR_MESSAGE =
	"Error en el guardado de un nuevo registro de entrada";
    /**
     * Mensaje de error en tareas con registros de entrada: Error en la copia de
     * un nuevo registro de entrada.
     */
    public static final String COPY_INPUT_REGISTER_ERROR_MESSAGE =
	"Error en la copia de un nuevo registro de entrada";
    /**
     * Mensaje de error en tareas con registros de entrada: Error al obtener el
     * registro de entrada.
     */
    public static final String GET_INPUT_REGISTER_ERROR_MESSAGE =
	"Error al obtener el registro de entrada";

    /**
     * Mensaje de error en tareas con registros de salida: Error al obtener el
     * registro de salida.
     */
    public static final String GET_OUTPUT_REGISTER_ERROR_MESSAGE =
	"Error al obtener el registro de salida";

    /**
     * Mensaje de error en tareas con registros de salida: Error en la creaci�n
     * de un nuevo registro de salida.
     */
    public static final String CREATE_OUTPUT_REGISTER_ERROR_MESSAGE =
	"Error en la creaci�n de un nuevo registro de salida";
    /**
     * Mensaje de error en tareas con registros de salida: Error en la
     * modificaci�n de un nuevo registro de salida.
     */
    public static final String UPDATE_OUTPUT_REGISTER_ERROR_MESSAGE =
	"Error en la modificaci�n de un nuevo registro de salida";
    /**
     * Mensaje de error en tareas con registros de salida: Error en el guardado
     * de un nuevo registro de salida.
     */
    public static final String SAVE_OUTPUT_REGISTER_ERROR_MESSAGE =
	"Error en el guardado de un nuevo registro de salida";
    /**
     * Mensaje de error en tareas con registros de salida: Error en la copia de
     * un nuevo registro de salida.
     */
    public static final String COPY_OUTPUT_REGISTER_ERROR_MESSAGE =
	"Error en la copia de un nuevo registro de salida";

    /**
     * Mensaje de error en tareas con registros: Error en la marcar el registro
     * de entrada como s�lo lectura.
     */
    public static final String LOCK_REGISTER_ERROR_MESSAGE =
	"Error en la marcar el registro de entrada como s�lo lectura";
    /**
     * Mensaje de error en tareas con registros de entrada: Error en la
     * obtenci�n de los registros de entrada.
     */
    public static final String GET_INPUT_REGISTERS_ERROR_MESSAGE =
	"Error en la obtenci�n de los registros de entrada";
    /**
     * Mensaje de error en tareas con registros de entrada: Error en la carga de
     * los registros de entrada.
     */
    public static final String LOAD_INPUT_REGISTER_ERROR_MESSAGE =
	"Error en la carga de los registros de entrada";

    /**
     * Mensaje de error en tareas con registros de salida: Error en la carga de
     * los registros de salida.
     */
    public static final String LOAD_OUTPUT_REGISTER_ERROR_MESSAGE =
	"Error en la carga de los registros de entrada";
    /**
     * Mensaje de error en tareas con registros de entrada: Error en la
     * obtenci�n del hist�rico de registros.
     */
    public static final String GET_HISTORICAL_REGISTER_ERROR_MESSAGE =
	"Error en la obtenci�n del hist�rico de registros";
    /**
     * Mensaje de error en tareas con registros de entrada: Error en la
     * obtenci�n del hist�rico de registros o del registro.
     */
    public static final String GET_HISTORICAL_OR_REGISTER_ERROR_MESSAGE =
	"Error en la obtenci�n del hist�rico de registros o del registro de entrada";
    /**
     * Mensaje de error en tareas con registros de entrada: Error en la b�squeda
     * de los registros del usuario.
     */
    public static final String NAVIGATE_TO_INPUT_REGISTERS_ROW_ERROR_MESSAGE =
	"Error en la b�squeda de los registros del usuario";
    /**
     * Mensaje de error en tareas con registros de salida: Error en la b�squeda
     * de los registros del usuario.
     */
    public static final String NAVIGATE_TO_OUTPUT_REGISTERS_ROW_ERROR_MESSAGE =
	"Error en la b�squeda de los registros del usuario";
    /**
     * Mensaje de error en tareas con registros de entrada: Error al obtener el
     * listado de oficinas de registro.
     */
    public static final String GET_INPUT_REGISTER_OFFICE_LIST_ERROR_MESSAGE =
	"Error al obtener el listado de oficinas de registro";
    /**
     * Mensaje de error en tareas con registros de entrada: Error al validar el
     * Id del registro de entrada.
     */
    public static final String VALIDATE_INPUT_REGISTER_ERROR_MESSAGE =
	"Error al validar el Id del registro de entrada";
    /**
     * Mensaje de error en tareas con registros de entrada: Se ha producido un
     * error en la validaci�n de la fecha de registro.
     */
    public static final String VALIDATE_INPUT_REGISTER_DATE_ERROR_MESSAGE =
	"Se ha producido un error en la validaci�n de la fecha de registro";
    /**
     * Mensaje de error en tareas con registros de entrada: La fecha de registro
     * no puede ser superior a la fecha actual ni inferior a 1970.
     */
    public static final String INPUT_REGISTER_DATE_RANGE_ERROR_MESSAGE =
	"La fecha de registro no puede ser superior a la fecha actual ni inferior a 1970";

    /**
     * Mensaje de error en tareas con consultas de registros de entrada: Error
     * en la apertura de la consulta de registros.
     */
    public static final String OPEN_INPUT_REGISTER_QUERY_ERROR_MESSAGE =
	"Error en la apertura de la consulta de registros de entrada";
    /**
     * Mensaje de error en tareas con consultas de registros de salida: Error en
     * la apertura de la consulta de registros.
     */
    public static final String OPEN_OUTPUT_REGISTER_QUERY_ERROR_MESSAGE =
	"Error en la apertura de la consulta de registros de salida";
    /**
     * Mensaje de error en tareas con consultas de registros de entrada: Error
     * en la carga de la consulta de registros.
     */
    public static final String LOAD_INPUT_REGISTER_QUERY_ERROR_MESSAGE =
	"Error en la carga de la consulta de registros";

    /**
     * Mensaje de error en tareas con consultas de registros de salida: Error en
     * la carga de la consulta de registros.
     */
    public static final String LOAD_OUTPUT_REGISTER_QUERY_ERROR_MESSAGE =
	"Error en la carga de la consulta de registros";

    /**
     * Mensaje de error en tareas con consultas de registros de entrada: Error
     * en el cierre de la consulta de registros.
     */
    public static final String CLOSE_INPUT_REGISTER_QUERY_ERROR_MESSAGE =
	"Error en el cierre de la consulta de registros de entrada";
    /**
     * Mensaje de error en tareas con consultas de registros de salida: Error en
     * el cierre de la consulta de registros.
     */
    public static final String CLOSE_OUTPUT_REGISTER_QUERY_ERROR_MESSAGE =
	"Error en el cierre de la consulta de registros de salida";
    /**
     * Mensaje de error en tareas con consultas de registros de entrada: Error
     * al rellenar los par�metros de la consulta.
     */
    public static final String FILL_QUERY_PARAMETERS_ERROR_MESSAGE =
	"Error al rellenar los par�metros de la consulta";

    /**
     * Mensaje de error en tareas con consultas de registros de entrada: Error
     * abriendo registros.
     */
    public static final String OPENR_INPUT_REGISTER_ERROR_MESSAGE =
	"Error abriendo registros de entrada";

    /**
     * Mensaje de error en tareas con consultas de registros de salida: Error
     * abriendo registros.
     */
    public static final String OPENR_OUTPUT_REGISTER_ERROR_MESSAGE =
	"Error abriendo registros de salida";

    /**
     * Mensaje de error en tareas con consultas de registros de entrada: Error
     * cerrando registros.
     */
    public static final String CLOSE_INPUT_REGISTER_ERROR_MESSAGE =
	"Error cerrando registros de entrada";

    /**
     * Mensaje de error en tareas con consultas de registros de salida: Error
     * cerrando registros.
     */
    public static final String CLOSE_OUTPUT_REGISTER_ERROR_MESSAGE =
	"Error cerrando registros de salida";

    /**
     * Mensaje de error en distribuciones: Error en la apertura de la consulta
     * de registros.
     */
    public static final String GET_DISTRIBUTION_ERROR_MESSAGE =
	"Error al obtener las distribuciones";
    /**
     * Mensaje de error en distribuciones: Error al obtener los resultados de la
     * b�squeda de distribuciones.
     */
    public static final String GET_DISTRIBUTION_RESULTS_ERROR_MESSAGE =
	"Error al obtener los resultados de la b�squeda de distribuciones";
    /**
     * Mensaje de error en distribuciones: Error al mostrar las alertas de
     * distribuci�n.
     */
    public static final String SHOW_DISTRIBUTION_ALERTS_ERROR_MESSAGE =
	"Error al mostrar las alertas de distribuci�n";
    /** Mensaje de error en distribuciones: Error al archivar distribuci�n. */
    public static final String ARCHIVE_DISTRIBUTION_ERROR_MESSAGE =
	"Error archivando la distribuci�n";
    /** Mensaje de error en distribuciones: Error al aceptar distribuci�n. */
    public static final String ACCEPT_DISTRIBUTION_ERROR_MESSAGE =
	"Error aceptando la distribuci�n";
    /** Mensaje de error en distribuciones: Error al rechazar distribuci�n. */
    public static final String REJECT_DISTRIBUTION_ERROR_MESSAGE =
	"Error rechazando la distribuci�n";
    /**
     * Mensaje de error en distribuciones: Error al cambiar destino
     * distribuci�n.
     */
    public static final String CHANGE_DISTRIBUTION_ERROR_MESSAGE =
	"Error cambiando el destino de la distribuci�n";
    /** Mensaje de error en distribuciones: Error redistribuyendo distribuci�n. */
    public static final String REDISTRIBUTION_DISTRIBUTION_ERROR_MESSAGE =
	"Error redistribuyendo la distribuci�n";

    /**
     * Mensaje de error en operaciones de sesi�n de usuario: Error en la
     * autenticaci�n del usuario.
     */
    public static final String AUTHENTICATION_ERROR_MESSAGE =
	"Error en la autenticaci�n del usuario";
    /**
     * Mensaje de error en operaciones de sesi�n de usuario: Error al cerrar la
     * sesi�n del usuario.
     */
    public static final String CLOSE_SESSION_ERROR_MESSAGE =
	"Error al cerrar la sesi�n del usuario";
    /**
     * Mensaje de error en operaciones de sesi�n de usuario: Error en la
     * validaci�n del usuario.
     */
    public static final String USER_VALIDATION_ERROR_MESSAGE = "Error en la validaci�n del usuario";

    /**
     * Mensaje de error en operaciones con oficinas: Error al obtener las
     * oficinas.
     */
    public static final String GET_OFFICES_ERROR_MESSAGE = "Error al obtener las oficinas";
    /**
     * Mensaje de error en operaciones con oficinas: Error al validar el c�digo
     * de oficina.
     */
    public static final String VALIDATION_OFFICE_CODE_ERROR_MESSAGE =
	"Error al validar el c�digo de oficina";

    /**
     * Mensaje de error en listados de datos: Error al obtener la informaci�n de
     * los listados.
     */
    public static final String GET_INFORMATION_LISTS_ERROR_MESSAGE =
	"Error al obtener la informaci�n de los listados";
    /**
     * Mensaje de error en listados de datos: Error al obtener la lista de tipos
     * de transporte.
     */
    public static final String GET_TRANSPORT_TYPES_LIST_ERROR_MESSAGE =
	"Error al obtener la lista de tipos de transporte";
    /**
     * Mensaje de error en listados de datos: Error al obtener la lista de
     * oficinas.
     */
    public static final String GET_OFFICES_LIST_ERROR_MESSAGE =
	"Error al obtener la lista de oficinas";
    /**
     * Mensaje de error en listados de datos: Error al obtener la lista de
     * asuntos por oficina.
     */
    public static final String GET_OFFICE_ASUNTS_LIST_ERROR_MESSAGE =
	"Error al obtener la lista de asuntos por oficina";
    /**
     * Mensaje de error en listados de datos: Error al obtener la lista de
     * organismos.
     */
    public static final String GET_ORGANISMS_LIST_ERROR_MESSAGE =
	"Error al obtener la lista de organismos";

    /** Mensaje de error gen�ricos: Error en la validaci�n de los par�metros. */
    public static final String PARAMETERS_VALIDATION_ERROR_MESSAGE =
	"Error en la validaci�n de los par�metros";
    /** Mensaje de error gen�ricos: Error en la sesi�n. */
    public static final String SESSION_ERROR_MESSAGE = "Error en la sesi�n";
    /** Mensaje de error gen�ricos: Error al obtener el listado de atributos. */
    public static final String ATTRIBUTES_ERROR_MESSAGE =
	"Error al obtener el listado de atributos";
    /** Mensaje de error gen�ricos: La tabla de datos est� vac�a. */
    public static final String NULL_DATA_TABLE_ERROR_MESSAGE = "La tabla de datos est� vac�a";
    /** Mensaje de error gen�ricos: Error al obtener los permisos. */
    public static final String GET_PERMISSIONS_ERROR_MESSAGE = "Error al obtener los permisos";
    /**
     * Mensaje de error gen�ricos: La p�gina a la que se intenta redireccionar
     * no existe.
     */
    public static final String NULL_PAGE_TO_REDIRECT_ERROR_MESSAGE =
	"La p�gina a la que se intenta redireccionar no existe";

    /** Mensaje de error de manejo de bbdd: Error al cerrar la sesi�n de bbdd. */
    public static final String CLOSE_SESSION_BD_ERROR_MESSAGE = "Error al cerrar la sesi�n";
    /** Mensaje de error de manejo de bbdd: Error al abrir la sesi�n de bbdd. */
    public static final String OPEN_SESSION_BD_ERROR_MESSAGE = "Error al abrir la sesi�n";
    /** Mensaje de error de usuarios: Error al recuperar el usuario. */
    public static final String GET_USER_ERROR_MESSAGE = "Error al recuperar el usuario";

    /**
     * Mensaje de error en generaci�n de informes: No hay datos para generar el
     * informe.
     */
    public static final String REPORT_DATA_ERROR = "No hay datos para generar el informe";

    /**
     * Mensaje de error en tareas con registros: Error mostrando registros
     * asociados.
     */
    public static final String GET_ASOC_REGISTER_ERROR_MESSAGE =
	"Error en la recuperaci�n de registros asociados";

    /**
     * Mensaje de error en tareas con registros de entrada: Error en la marcar
     * el registro de entrada como abierto.
     */
    public static final String OPEN_REGISTER_ERROR_MESSAGE = "Error al abrir un registro";

    /**
     * Mensaje de error en tareas con registros de entrada: Error en la marcar
     * el registro como cerrado.
     */
    public static final String CLOSED_REGISTER_ERROR_MESSAGE = "Error al cerrar un registro";

    /**
     * Mensaje de error en tareas con registros: Error eliminando asociaci�n.
     */
    public static final String DELETE_ASOC_REGISTER_ERROR_MESSAGE =
	"Error eliminando la asociaci�n de registros";
    /**
     * Mensaje de error en tareas con registros: Error asociando registros.
     */
    public static final String SAVE_ASOC_REGISTER_ERROR_MESSAGE = "Error asociando registros";

    /**
     * Mensaje de error en tareas con intercambio registral: Error recuperando
     * unidad de tramitaci�n por defecto.
     */
    public static final String SEARCH_DESTINATION_REG_INTERCHANGE_ERROR_MESSAGE =
	"Error recuperando unidad de tramitaci�n por defecto";

    /**
     * Mensaje de error en tareas con intercambio registral: Error enviando el
     * asiento registral.
     */
    public static final String SEND_REG_INTERCHANGE_ERROR_MESSAGE =
	"Error enviando el asiento registral";

    /**
     * Mensaje de error en tareas con intercambio registral: Error consultando
     * el hist�rico de entrada del intercambio registral.
     */
    public static final String GET_HIST_INPUT_REG_INTERCHANGE_ERROR_MESSAGE =
	"Error consultando el hist�rico de entrada del intercambio registral";

    /**
     * Mensaje de error en tareas con intercambio registral: Error consultando
     * el hist�rico de salida del intercambio registral.
     */
    public static final String GET_HIST_OUTPUT_REG_INTERCHANGE_ERROR_MESSAGE =
	"Error consultando el hist�rico de salida del intercambio registral";
    /**
     * Mensaje de error en tareas con intercambio registral: Error recuperando
     * la bandeja de entrada.
     */
    public static final String GET_INBOX_INTERCHANGE_ERROR_MESSAGE =
	"Error recuperando la bandeja de entrada del intercambio registral";

    /**
     * Mensaje de error en tareas con intercambio registral: Error recuperando
     * la bandeja de salida.
     */
    public static final String GET_OUTBOX_INTERCHANGE_ERROR_MESSAGE =
	"Error recuperando la bandeja de salida del intercambio registral";

    /**
     * Mensaje de error en tareas con intercambio registral: Error recuperando
     * el n�mero de registros pendientes en la bandeja de entrada.
     */
    public static final String GET_PENDING_INBOX_INTERCHANGE_ERROR_MESSAGE =
	"Error recuperando el n�mero de registros pendientes " +
	"en la bandeja de entrada del intercambio registral";

    /**
     * Mensaje de error en tareas con intercambio registral: Error aceptando
     * registros.
     */
    public static final String ACCEPT_INBOX_INTERCHANGE_ERROR_MESSAGE =
	"Error aceptando registros del intercambio registral";

    /**
     * Mensaje de error en tareas con intercambio registral: Error rechazando
     * registros.
     */
    public static final String REJECT_INBOX_INTERCHANGE_ERROR_MESSAGE =
	"Error rechazando registros del intercambio registral";

    /**
     * Mensaje de error en tareas con intercambio registral: Error recuperando
     * un asiento registral.
     */
    public static final String GET_INPUT_INTERCHANGE_ERROR_MESSAGE =
	"Error recuperando un asiento registral";
    /**
     * Mensaje de error en tareas con intercambio registral: Error reenviando un
     * asiento registral.
     */
    public static final String FORWARD_INBOX_INTERCHANGE_ERROR_MESSAGE =
	"Error reenviando un asiento registral";
    /**
     * Mensaje de error en tareas con intercambio registral: Error recuperando
     * la lista de entidades registrales.
     */
    public static final String GET_LIST_ENTID_REGISTER_ERROR_MESSAGE =
	"Error recuperando la lista de entidades registrales";
    /**
     * Mensaje de error en tareas con intercambio registral: Entidad registral
     * no existe.
     */
    public static final String ENTITY_DOES_NOT_EXISTS_MESSAGE = "La entidad registral no existe";
    /**
     * Mensaje de error en tareas con intercambio registral: Unidad Tramitadora
     * no existe.
     */
    public static final String UNID_DOES_NOT_EXISTS_MESSAGE = "La unidad tramitadora no existe";
    /**
     * Mensaje de error en tareas con intercambio registral: Error recuperando
     * la lista de unidades tramitadoras.
     */
    public static final String GET_LIST_UNID_REGISTER_ERROR_MESSAGE =
	"Error recuperando la lista de unidades tramitadoras";

    /**
     * Mensaje de error en tareas con registros: Error recuperando los
     * documentos de un registro.
     */
    public static final String GET_REGISTER_DOCUMENTS_ERROR_MESSAGE =
	"Error recuperando los documentos de un registro";

    /**
     * Mensaje de error en tareas con registros: Error descargando un fichero.
     */
    public static final String DOWNLOADFILE_ERROR_MESSAGE = "Error descargando un fichero";

    /**
     * Mensaje de error en tareas con registros: Error adjuntando un fichero.
     */
    public static final String UPLOADFILE_ERROR_MESSAGE = "Error adjuntando un fichero";
    /**
     * Mensaje de error en tareas de distribuci�n: Error contando el n�mero de
     * distribuciones.
     */
    public static final String GET_COUNT_DISTRIBUTION_ERROR_MESSAGE =
	"Error contand el n�mero de distribuciones de la b�squeda";
    
    /**
     * Mensaje de error en tareas con registros: Error iniciando transacci�n.
     */
    public static final String START_TRANSACTION_ERROR = "Error iniciando transacci�n";
    /**
     * Mensaje de error en tareas con registros: Error en el commit de la transacci�n.
     */
    public static final String COMMIT_TRANSACTION_ERROR = "Error en el commit de la transacci�n";
    /**
     * Mensaje de error en tareas con registros: Error cerrando la transacci�n.
     */
    public static final String END_TRANSACTION_ERROR = "Error cerrando la transacci�n";
    /**
     * Mensaje de error en tareas con registros: Error obteniendo la lista de CCAA.
     */
    public static final String GET_LIST_CCAA_MESSAGE = "Error obteniendo la lista de CCAA";
    /**
     * Mensaje de error en tareas con registros: Error obteniendo la lista de provincias.
     */
    public static final String GET_LIST_PROV_MESSAGE = "Error obteniendo la lista de provincias";
    /**
     * Mensaje de error en tareas con intercambio registral: Error recuperando
     * una unidad tramitadora.
     */
    public static final String GET_UNID_REGISTER_ERROR_MESSAGE =
	"Error recuperando una unidad tramitadora";
    /**
     * Mensaje de error en tareas con registros: Error recuperando
     * la lista de unidades .
     */
    public static final String GET_LIST_UNIT_REGISTER_ERROR_MESSAGE =
	"Error recuperando la lista de unidades org�nicas";
    
    public static final String WITHOUT_PERMITS_ERROR_MESSAGE =
    		"El usuario no tiene permisos para acceder a la aplicaci�n";

    public static final String CREATE_QRCODE_ERROR_MESSAGE =
	    "Error generando el c�digo QR de la etiqueta";
    /**
     * Mensaje de error en mover registro de libro.
     */
    public static final String MOVE_REGISTER_ERROR = "No se puede mover el registro de libro";
    /**
     * Mensaje de error en recuperar la direcci�n de la oficina.
     */
    public static final String GET_DIR_MESSAGE = "No se puede recuperar la direcci�n de la oficina";
    /**
     * Mensaje de error en recuperar los campos extendidos.
     */
    public static final String GET_EXTENDEDFIELDS_ERROR = "No se pueden recuperar los datos extendidos";
    /**
     * Mensaje de error en borrado de documento.
     */
    public static final String DELETE_REGISTER_DOCUMENTS_ERROR_MESSAGE = "No se puede borrar el documento.";
    /**
     * Mensaje de error recuperando un intercambio registral.
     */
    public static final String GET_INTERCHANGE_ERROR_MESSAGE = "Error recuperando un intercambio registral";
    /**
     * Mensaje de error actualizando DCO.
     */
    public static final String UPDATE_UNID_REGISTER_ERROR_MESSAGE = "Error actualizando DCO";
    /**
     * Mensaje de error cargando usuarios en SIGM.
     */
    public static final String INSERT_USERS_ERROR_MESSAGE = "Error cargando usuarios en SIGM";
    /**
     * Mensaje de error modificando un documento.
     */
    public static final String UPDATE_REGISTER_DOCUMENTS_ERROR_MESSAGE = "Error modificando un documento";
    /**
     * Mensaje de error recuperando estado de un registro.
     */
    public static final String GET_STATE_INPUT_REGISTER_ERROR_MESSAGE = "Error recuperando estado de un registro";
    
    /**
     * Mensaje de error al crear un usuario en bbdd.
     */
    public static final String INSERT_USER_ERROR = "Error al crear usuario en bbbdd";
    
    /**
     * Mensaje de error al consultar al existencia de usuario.
     */
    public static final String QUERY_EXIST_USER = "Error al consultar la existencia de usuario en bbbdd";           
    
}