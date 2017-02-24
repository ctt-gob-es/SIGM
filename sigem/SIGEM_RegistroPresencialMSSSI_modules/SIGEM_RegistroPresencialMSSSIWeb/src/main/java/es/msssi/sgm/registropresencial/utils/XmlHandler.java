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
 * Clase para construir xmls.
 * 
 * @author cmorenog
 */
public class XmlHandler {
    private String cabeceraDocumento = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>";
    private String nodoRaiz = null;
    private StringBuffer xml = new StringBuffer();

    /**
     * Constructor.
     */
    public XmlHandler() {
	xml = new StringBuffer(
	    cabeceraDocumento);
    }

    /**
     * Constructor.
     * 
     * @param nodoRaiz
     *            Nombre del nodo raiz.
     */
    public XmlHandler(String nodoRaiz) {
	xml = new StringBuffer(
	    cabeceraDocumento +
		"<" + nodoRaiz + ">");
	this.nodoRaiz = nodoRaiz;
    }

    /**
     * Constructor.
     * 
     * @param cabeceraDocumento
     *            Cabecera del documento.
     * @param nodoRaiz
     *            Nombre del nodo raiz.
     */
    public XmlHandler(String cabeceraDocumento, String nodoRaiz) {
	xml = new StringBuffer(
	    cabeceraDocumento +
		"<" + nodoRaiz + ">");
	this.nodoRaiz = nodoRaiz;
	this.cabeceraDocumento = cabeceraDocumento;
    }

    /**
     * A�adir un nodo al inicio del xml.
     * 
     * @param nodo
     *            Nombre del nodo.
     */
    public void addBeginXmlHandler(
	String nodo) {
	xml.append("<" +
	    nodo + ">");
    }

    /**
     * A�adir un nodo al final del xml.
     * 
     * @param nodo
     *            Nombre del nodo.
     */
    public void addEndXmlHandler(
	String nodo) {
	xml.append("</" +
	    nodo + ">");
    }

    /**
     * A�adir un nodo al xml.
     * 
     * @param key
     *            Nombre del nodo.
     * @param value
     *            valor del nodo.
     */
    public void addNode(
	String key, Object value) {
	xml.append("<" +
	    key + ">");
	xml.append("<![CDATA[" +
	    value + "]]>");
	xml.append("</" +
	    key + ">");
    }

    /**
     * Devuelve el xml en string.
     * 
     * @return string xml en tipo string.
     */
    public String getDomDocument() {
	if (nodoRaiz != null) {
	    xml.append("</" +
		nodoRaiz + ">");
	}
	return xml.toString();
    }

}