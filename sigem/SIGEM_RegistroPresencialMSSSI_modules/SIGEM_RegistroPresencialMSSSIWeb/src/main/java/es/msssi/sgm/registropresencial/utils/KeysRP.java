/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.sgm.registropresencial.utils;

/**
 * Variables est�ticas �tiles para la aplicaci�n.
 * 
 * @author cmorenog
 * */
public class KeysRP {
    /**
     * Constante correspondiente al nombre de la variable de sesi�n que contiene
     * informaci�n sobre la aplicaci�n.
     */
    public static final String J_SESSIONINF = "J_SESSIONINF";
    /**
     * Constante correspondiente al nombre de la variable de sesi�n que contiene
     * los permisos de usuario.
     */
    public static final String J_PERMSUSER = "J_PERMSUSER";
    /**
     * Constante correspondiente al nombre de la variable de sesi�n que contiene
     * el valor de si est� habilitado el intercambio registral.
     */
    public static final String J_ENABLEDINTREGISTRAL = "J_ENABLEDINTREGISTRAL";
    /**
     * Constante correspondiente al nombre de la variable de sesi�n que contiene
     * el libro registral con el que se est� trabajando.
     */
    public static final String J_BOOK = "J_BOOK";
    /**
     * Constante correspondiente al nombre de la variable de sesi�n que contiene
     * par�metros del libro registral.
     */
    public static final String J_PARAMBOOK = "J_PARAMBOOK";
    /**
     * Constante correspondiente al nombre de la variable de distribuci�n del
     * archivo de propiedades que contiene el texto de que existe una entrada
     * nueva.
     */
    public static final String I18N_DISTRIBUTION_NEW_FOLDER_FOR_USER =
	"distribution.new.folder.for.user";
    /**
     * Constante correspondiente al nombre de la variable de distribuci�n del
     * archivo de propiedades que contiene el texto de que existen entradas
     * nuevas.
     */
    public static final String I18N_DISTRIBUTION_NEW_FOLDERS_FOR_USER =
	"distribution.new.folders.for.user";
    /**
     * Constante correspondiente al nombre de la variable de distribuci�n del
     * archivo de propiedades que contiene el texto de que existe una entrada
     * nueva rechazada.
     */
    public static final String I18N_DISTRIBUTION_NEW_FOLDER_REJECTED_FOR_USER =
	"distribution.new.folder.rejected.for.user";
    /**
     * Constante correspondiente al nombre de la variable de distribuci�n del
     * archivo de propiedades que contiene el texto de que existen entradas
     * nuevas rechazadas.
     */
    public static final String I18N_DISTRIBUTION_NEW_FOLDERS_REJECTED_FOR_USER =
	"distribution.new.folders.rejected.for.user";
    /**
     * Constante correspondiente al nombre de la variable de distribuci�n del
     * archivo de propiedades que contiene el texto del estado de un registro
     * distribuido.
     */
    public static final String I18N_BOOKUSECASE_DISTRIBUTIONHISTORY_MINUTA_DIST_STATE =
	"distributionhistory.minuta.dist.state.";
    /**
     * Constante correspondiente al nombre de la variable del archivo de
     * propiedades fld1label.
     */
    public static final String I18N_LABELFLD1 = "fld1label";
    /**
     * Constante correspondiente al nombre de la variable del archivo de
     * propiedades fld2label.
     */
    public static final String I18N_LABELFLD2 = "fld2label";
    /**
     * Constante correspondiente al nombre de la variable del archivo de
     * propiedades fld2labelDesde.
     */
    public static final String I18N_LABELFLD2DESDE = "fld2labelDesde";
    /**
     * Constante correspondiente al nombre de la variable del archivo de
     * propiedades fld2labelHasta.
     */
    public static final String I18N_LABELFLD2HASTA = "fld2labelHasta";
    /**
     * Constante correspondiente al nombre de la variable del archivo de
     * propiedades fld3label.
     */
    public static final String I18N_LABELFLD3 = "fld3label";
    /**
     * Constante correspondiente al nombre de la variable del archivo de
     * propiedades fld5label.
     */
    public static final String I18N_LABELFLD5 = "fld5label";
    /**
     * Constante correspondiente al nombre de la variable del archivo de
     * propiedades fld6label.
     */
    public static final String I18N_LABELFLD6 = "fld6label";
    /**
     * Constante correspondiente al nombre de la variable del archivo de
     * propiedades fld7label.
     */
    public static final String I18N_LABELFLD7 = "fld7label";
    /**
     * Constante correspondiente al nombre de la variable del archivo de
     * propiedades fld8label.
     */
    public static final String I18N_LABELFLD8 = "fld8label";
    /**
     * Constante correspondiente al nombre de la variable del archivo de
     * propiedades fld9label.
     */
    public static final String I18N_LABELFLD9 = "fld9label";
    /**
     * Constante correspondiente al nombre de la variable del archivo de
     * propiedades fld9label.
     */
    public static final String I18N_LABELFLD9D = "fld9labelD";

    /**
     * Constante correspondiente al nombre de la variable del archivo de
     * propiedades fld14label.
     */
    public static final String I18N_LABELFLD14 = "fld14label";
    /**
     * Constante correspondiente al nombre de la variable del archivo de
     * propiedades fld15label.
     */
    public static final String I18N_LABELFLD15 = "fld15label";
    /**
     * Constante correspondiente al nombre de la variable del archivo de
     * propiedades fld16label.
     */
    public static final String I18N_LABELFLD16 = "fld16label";
    /**
     * Constante correspondiente al nombre de la variable del archivo de
     * propiedades fld17label.
     */
    public static final String I18N_LABELFLD17 = "fld17label";

    /**
     * Constante correspondiente al literal de validaciones de fechas de
     * registro.
     */
    public static final String INPUT_REGISTER_DATE_LITERAL = "Fecha de registro";

    /**
     * Constante correspondiente al texto del campo diligencia de un informe.
     */
    public static final String REPORT_PROCEEEDING_TEXT =
	"De conformidad con lo establecido en el art. 70.3 de la ley 30/92,"
	    + " del 26 de noviembre, de R�gimen Jur�dico de las "
	    + " Administraciones P�blicas y del Prodecidimiento Administrativo Com�n"
	    + " se extiende el presente recibo a efectos de acreditaci�n de presentaci�n"
	    + " de documentos.";

    /**
     * Constante correspondiente al m�ximo de regsitros a mostrar en un informe.
     */
    public static final int REPORT_MAX_RESULTS = Integer.MAX_VALUE;

    /** Constante correspondiente al alias de la aplicaci�n que invoca a PFE. */
    public static final String PFE_APP_ALIAS = "SIGM";
    /**
     * Constante correspondiente al tipo de firma a realizar, attached o
     * detached.
     */
    public static final String PFE_ATTACHMENT_TYPE = "ATTACHED";
    /** Constante correspondiente al nombre del informe firmado. */
    public static final String PFE_SIGNED_DOC_NAME = "SignedReport.pdf";
    /** Constante correspondiente al formato de firma. */
    public static final String PFE_SIGN_TYPE = "PAdES_BASIC";
    /** Constante correspondiente a si se realiza una firma o varias. */
    public static final String PFE_MULTI_SIGN_TYPE = "SIMPLE";

    /** Constante que indica la extensi�n del fichero final. */
    public static final String REPORT_CERTIFICATE_EXTENSION_FILE = ".pdf";
    /** Constante que indica la extensi�n del archivo compresi�n de ficheros. */
    public static final String REPORT_CERTIFICATE_EXTENSION_ZIP = ".zip";
    /** Nombre de la plantilla de un acuse de recibo. */
    public static final String IR_REPORT_CERTIFICATE_TEMPLATE_NAME =
	"RPInputRegistersCertificatesReport.jasper";
    /** Nombre del informe final en formato PDF. */
    public static final String IR_REPORT_CERTIFICATE_NAME = "AcuseReciboRegistroEntrada";
    /** Nombre de la plantilla de informe de certificados. */
    public static final String IR_REPORT_ORIGIN_RELATIONS_TEMPLATE_NAME =
	"InputRegistersOriginRelationsReport.jasper";
    /** Nombre del informe final en formato PDF. */
    public static final String IR_REPORT_ORIGIN_RELATIONS_NAME =
	"InformeRelacionesOrigenRegistrosEntrada.pdf";
    /** Nombre de la plantilla de informe de certificados. */
    public static final String IR_REPORT_DESTINATION_RELATIONS_TEMPLATE_NAME =
	"InputRegistersDestinationRelationsReport.jasper";
    /** Nombre del informe final en formato PDF. */
    public static final String IR_REPORT_DESTINATION_RELATIONS_NAME =
	"InformeRelacionesDestinoRegistrosEntrada.pdf";
    /** Nombre de la plantilla de informe de certificados. */
    public static final String OR_REPORT_CERTIFICATE_TEMPLATE_NAME =
	"RPOutputRegistersCertificatesReport.jasper";
    /** Nombre del informe final en formato PDF. */
    public static final String OR_REPORT_CERTIFICATE_NAME = "AcuseReciboRegistroSalida";
    /** Nombre de la plantilla de informe de certificados. */
    public static final String OR_REPORT_ORIGIN_RELATIONS_TEMPLATE_NAME =
	"OutputRegistersOriginRelationsReport.jasper";
    /** Nombre del informe final en formato PDF. */
    public static final String OR_REPORT_ORIGIN_RELATIONS_NAME =
	"InformeRelacionesOrigenRegistrosSalida.pdf";
    /** Nombre de la plantilla de informe de certificados. */
    public static final String OR_REPORT_DESTINATION_RELATIONS_TEMPLATE_NAME =
	"OutputRegistersDestinationRelationsReport.jasper";
    /** Nombre del informe final en formato PDF. */
    public static final String OR_REPORT_DESTINATION_RELATIONS_NAME =
	"InformeRelacionesDestinoRegistrosSalida.pdf";

    /** Mime type PDF. */
    public static final String MIME_TYPE_PDF = "application/pdf";
    /** Mime type ZIP. */
    public static final String MIME_TYPE_ZIP = "application/zip";
    /** Nombre de la etiqueta final en formato PDF. */
    public static final String LABEL_NAME = "Etiquetas.pdf";
    /** Nombre de la plantilla de etiquetas. */
    public static final String LABEL_TEMPLATE_NAME =
	"label.jasper";
    public static final String I18N_VALIDATEDOCUMENT = "validateDocument";
    public static final String I18N_TYPEDOCUMENT = "typeDocument";
    public static final int NUM_REGISTERINFORM = 750;
}
