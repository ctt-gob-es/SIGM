/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.sgm.registropresencial.beans;

/**
 * Enumeral de los content-type disponibles para la descarga/visualizaci�n de
 * documentos.
 * 
 * @author cmorenog
 * 
 */
public enum ContentTypeEnum {
    TXT("text/plain"), RTF("application/rtf"), ODF("application/vnd.oasis.opendocument.formula"),
    PDF("application/pdf"), XML("application/xml"), XMLT("text/xml"), HTML("text/html"),
    HTM("text/html"), XHTML("application/xhtml+xml"), SHTML("text/html"), CSV("text/csv"), PPT(
	    "application/vnd.ms-powerpoint"), PPTX(
	    "application/vnd.openxmlformats-officedocument.presentationml.presentation"), DOC(
	    "application/msword"), DOCX(
	    "application/vnd.openxmlformats-officedocument.wordprocessingml.document"), XLS(
	    "application/vnd.ms-excel"), XLSX(
	    "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"),
    JPG("image/jpeg"), JPEG("image/jpeg"), JPE("image/jpeg"), PNG("image/png"), TIFF("image/tiff"),
    TIF("image/tiff"), GIF("image/gif"), BMP("image/bmp"), OTHER("application/download"),
    CSIG("application/pgp-signature"),XSIG("application/xml"),DSIG("application/xml"),
    SIG("application/pgp-signature"), ODT ("application/vnd.oasis.opendocument.text"),
    ODP ("application/vnd.oasis.opendocument.presentation"),
    ODS ("application/vnd.oasis.opendocument.spreadsheet"),
    ODG ("application/vnd.oasis.opendocument.graphics"),
    SVG ("image/svg+xml"), ZIP ("application/zip");

    /*
     * EXTENSIONES PARA ARCHIVOS DE AUDIO Y V�DEO AAC ("audio/x-aac") , MP3
     * ("audio/mpeg") , OGA ("audio/ogg") , MP4 ("audio/mp4") , MPEG-4
     * ("video/mp4") , H264 ("video/h264") , OGG ("video/ogg") , AVI
     * ("video/x-msvideo") , OGM ("video/x-ogm+ogg") , MKV ("video/x-matroska")
     * , ASF ("video/x-ms-asf") , FLV ("video/x-flv") , QT ("video/quicktime") ,
     * RM ("application/vnd.rn-realmedia");
     */
    private String type;

    /**
     * Constructor
     * 
     * @param type
     *            tipo de contenido
     */
    private ContentTypeEnum(String type) {
	this.type = type;
    }

    /**
     * Devuelve el contentType con el tipo
     * 
     * @return contentType
     */
    public String getContentType() {
	return type;
    }
}
