
package ieci.tecdoc.core.xml.core;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.OutputKeys;

/** Permite efectuar transformaciones de una fuente xml.
* <br><br> El producto de una transformaci�n se denomina resultado. 
* Una transformaci�n puede utilizar o no instrucciones xsl. */

public final class XmlTransformer  
{  
      
   private Transformer m_transformer;
   private Source      m_source;
      
   /** Construye un objeto de la clase. */ 
   
   public XmlTransformer()
   {    
      m_transformer = null;
      m_source      = null;
   }
   
   /** Crea un transformador sin instrucciones xsl.
   * @throws Exception si se produce alg�n error. */ 
   
   public void create() throws Exception
   {
      
      TransformerFactory fry;
      
      fry           = TransformerFactory.newInstance();
      m_transformer = fry.newTransformer();
      
   }
   
   /** Crea un transformador con instrucciones xsl.
   * @param pathname Ruta de acceso y nombre del fichero xsl con las
   * instrucciones.
   * @throws Exception si se produce alg�n error. */ 
   
   public void createUsingXslFile(String pathname) throws Exception
   {
      
      TransformerFactory fry;
      StreamSource       xsl;
      
      fry           = TransformerFactory.newInstance();
      xsl           = new StreamSource(new File(pathname));
      m_transformer = fry.newTransformer(xsl);
      
   }
   
   /** Crea un transformador con instrucciones xsl.
   * @param text Texto xsl con las instrucciones.
   * @throws Exception si se produce alg�n error. */ 
   
   public void createUsingXslStringText(String text) throws Exception
   {
      
      TransformerFactory fry;
      StreamSource       xsl;
      
      fry           = TransformerFactory.newInstance();
      xsl           = new StreamSource(new StringReader(text));
      m_transformer = fry.newTransformer(xsl);
      
   }
   
   /** Crea un transformador con instrucciones xsl.
   * @param text Texto xsl, codificado en UTF-8, con las instrucciones.
   * @throws Exception si se produce alg�n error. */ 
   
   public void createUsingXslUtf8Text(byte[] text) throws Exception
   {
      
      TransformerFactory fry;
      StreamSource       xsl;
      
      fry           = TransformerFactory.newInstance();
      xsl           = new StreamSource(new ByteArrayInputStream(text));
      m_transformer = fry.newTransformer(xsl);
      
   }
   
   /** Crea un transformador con instrucciones xsl.
   * @param doc Documento xsl con las instrucciones.
   * @throws Exception si se produce alg�n error. */ 
   
   /* NO FUNCIONA
   public void createUsingXslDocument(XmlDocument doc) throws Exception
   {
      
      TransformerFactory fry;
      DOMSource          xsl;
      
      fry           = TransformerFactory.newInstance();
      xsl           = new DOMSource(doc.getDomDocument());
      m_transformer = fry.newTransformer(xsl);
      
   }
   */
   
   /** Establece la fuente de la transformaci�n.
   * @param pathname Ruta de acceso y nombre del fichero xml con la fuente. */
   
   public void setSourceFromXmlFile(String pathname)
   {
      m_source = new StreamSource(new File(pathname));
   }
   
   /** Establece la fuente de la transformaci�n.
   * @param text Texto xml con la fuente. */
   
   public void setSourceFromXmlStringText(String text)
   {
      m_source = new StreamSource(new StringReader(text));
   }
   
   /** Establece la fuente de la transformaci�n.
   * @param text Texto xml, codificado en UTF-8, con la fuente. */
   
   public void setSourceFromXmlUtf8Text(byte[] text)
   {
      m_source = new StreamSource(new ByteArrayInputStream(text));
   }
   
   /** Establece la fuente de la transformaci�n.
   * @param doc Documento xml con la fuente. */
   
   public void setSourceFromXmlDocument(XmlDocument doc)
   {
      m_source = new DOMSource(doc.getDomDocument());
   }
   
   /** Establece la fuente de la transformaci�n.
   * @param elem Elemento xml con la fuente. */
   
   public void setSourceFromXmlElement(XmlElement elem)
   {
      m_source = new DOMSource(elem.getDomElement());
   }
   
   /** Efect�a la transformaci�n.
   * @return Texto con el resultado de la transformaci�n.
   * @throws Exception si se produce alg�n error. */ 
   
   public String transformToStringText() throws Exception
   {
      
      StreamResult res;
      StringWriter resWriter;
      
      resWriter = new StringWriter();
      res       = new StreamResult(resWriter);
      
      m_transformer.transform(m_source, res);
      
      return resWriter.toString();
      
   }
   
   /** Efect�a la transformaci�n.
   * @return Texto, codificado en UTF-8, con el resultado de la transformaci�n.
   * @throws Exception si se produce alg�n error. */ 
   
   public byte[] transformToUtf8Text() throws Exception
   {
      
      StreamResult          res;
      ByteArrayOutputStream resStream;
            
      resStream = new ByteArrayOutputStream();
      res       = new StreamResult(resStream);
      
      m_transformer.transform(m_source, res);
      
      return resStream.toByteArray();
      
   }
   
   /** Efect�a la transformaci�n.
   * @param pathname Ruta de acceso y nombre del fichero en el que se
   * almacena el resultado de la transformaci�n.
   * @throws Exception si se produce alg�n error. */ 
   
   public void transformToFile(String pathname) throws Exception
   {
      
      StreamResult res;
      
      res = new StreamResult(new File(pathname));
      
      m_transformer.transform(m_source, res);
      
   }

   /** Permite especificar si en el resultado de una transformaci�n se omite
   * la declaraci�n Xml.
   * @param omit Especifica si omitir la declaraci�n xml. */
   
   public void setOmitXmlDeclarationInOutput(boolean omit)
   {
      
      String text;
      
      if (omit)
         text = "yes";
      else
         text = "no";
      
      m_transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, text);
      
   }

   /** Permite especificar que el resultado de una transformaci�n es xml. */
   
   public void setXmlOutputMethod()
   {
      m_transformer.setOutputProperty(OutputKeys.METHOD, "xml");      
   }
   
   /** Permite especificar que el resultado de una transformaci�n es html. */
   
   public void setHtmlOutputMethod()
   {
      m_transformer.setOutputProperty(OutputKeys.METHOD, "html");      
   }
      
   /** Efect�a la transformaci�n de una fuente xml sin utilizar
   * instrucciones xsl.
   * @param xmlDoc Documento xml con la fuente.
   * @param omitXmlHdr Especifica si omitir la cabecera xml en el resultado.
   * @return Texto xml con el resultado de la transformaci�n.
   * @throws Exception si se produce alg�n error. */ 
   
   public static String transformXmlDocumentToXmlStringText(XmlDocument xmlDoc,
                                                            boolean omitXmlHdr)
                        throws Exception
   {
      
      XmlTransformer transformer;
      
      transformer = new XmlTransformer();

      transformer.create();
      transformer.setSourceFromXmlDocument(xmlDoc);
      transformer.setOmitXmlDeclarationInOutput(omitXmlHdr);
      
      return transformer.transformToStringText();

   }
   
   /** Efect�a la transformaci�n de una fuente xml sin utilizar
   * instrucciones xsl.
   * @param xmlDoc Documento xml con la fuente.
   * @param omitXmlHdr Especifica si omitir la cabecera xml en el resultado.
   * @return Texto xml, codificado en UTF-8, con el resultado de la 
   * transformaci�n.
   * @throws Exception si se produce alg�n error. */ 
   
   public static byte[] transformXmlDocumentToXmlUtf8Text(XmlDocument xmlDoc,
                                                          boolean omitXmlHdr)
                        throws Exception
   {
      
      XmlTransformer transformer;
      
      transformer = new XmlTransformer();

      transformer.create();
      transformer.setSourceFromXmlDocument(xmlDoc);
      transformer.setOmitXmlDeclarationInOutput(omitXmlHdr);
      
      return transformer.transformToUtf8Text();

   }
   
   /** Efect�a la transformaci�n de una fuente xml sin utilizar
   * instrucciones xsl.
   * @param xmlDoc Documento xml con la fuente.
   * @param filePathName Ruta de acceso y nombre del fichero en el que se
   * almacena el resultado xml de la transformaci�n.
   * @throws Exception si se produce alg�n error. */ 
   
   public static void transformXmlDocumentToXmlFile(XmlDocument xmlDoc,
                                                    String filePathName)
                        throws Exception
   {
      
      XmlTransformer transformer;
      
      transformer = new XmlTransformer();

      transformer.create();
      transformer.setSourceFromXmlDocument(xmlDoc);
      
      transformer.transformToFile(filePathName);

   }
   
   /** Efect�a la transformaci�n de una fuente xml sin utilizar
   * instrucciones xsl.
   * @param xmlElem Elemento xml con la fuente.
   * @param omitXmlHdr Especifica si omitir la cabecera xml.
   * @return Texto xml con el resultado de la transformaci�n.
   * @throws Exception si se produce alg�n error. */ 
   
   public static String transformXmlElementToXmlStringText(XmlElement xmlElem,
                                                           boolean omitXmlHdr)
                        throws Exception
   {
      
      XmlTransformer transformer;
      
      transformer = new XmlTransformer();

      transformer.create();
      transformer.setSourceFromXmlElement(xmlElem);
      transformer.setOmitXmlDeclarationInOutput(omitXmlHdr);

      return transformer.transformToStringText();

   }
   
   /** Efect�a la transformaci�n de una fuente xml sin utilizar
   * instrucciones xsl.
   * @param xmlElem Elemento xml con la fuente.
   * @param omitXmlHdr Especifica si omitir la cabecera xml.
   * @return Texto xml, codificado en UTF-8, con el resultado de la 
   * transformaci�n.
   * @throws Exception si se produce alg�n error. */ 
   
   public static byte[] transformXmlElementToXmlUtf8Text(XmlElement xmlElem,
                                                         boolean omitXmlHdr)
                        throws Exception
   {
      
      XmlTransformer transformer;
      
      transformer = new XmlTransformer();

      transformer.create();
      transformer.setSourceFromXmlElement(xmlElem);
      transformer.setOmitXmlDeclarationInOutput(omitXmlHdr);

      return transformer.transformToUtf8Text();

   }

   /** Efect�a la transformaci�n de una fuente xml utilizando
   * instrucciones xsl.
   * @param xmlDoc Documento xml con la fuente.
   * @param xslFilePathName Ruta de acceso y nombre del fichero xsl con las 
   * instrucciones.
   * @return Texto html con el resultado de la transformaci�n.
   * @throws Exception si se produce alg�n error. */ 
   
   public static String transformXmlDocumentToHtmlStringTextUsingXslFile(
                        XmlDocument xmlDoc, String xslFilePathName)
                        throws Exception
   {
      
      XmlTransformer transformer;
      
      transformer = new XmlTransformer();

      transformer.createUsingXslFile(xslFilePathName);
      transformer.setSourceFromXmlDocument(xmlDoc);
      transformer.setHtmlOutputMethod();
      
      return transformer.transformToStringText();

   }

   /** Efect�a la transformaci�n de una fuente xml utilizando
   * instrucciones xsl.
   * @param xmlFilePathName Ruta de acceso y nombre del fichero xml con la
   * fuente.
   * @param xslFilePathName Ruta de acceso y nombre del fichero xsl con las 
   * instrucciones.
   * @return Texto html con el resultado de la transformaci�n.
   * @throws Exception si se produce alg�n error. */ 
   
   public static String transformXmlFileToHtmlStringTextUsingXslFile(
                        String xmlFilePathName, String xslFilePathName)
                        throws Exception
   {
      
      XmlTransformer transformer;
      
      transformer = new XmlTransformer();

      transformer.createUsingXslFile(xslFilePathName);
      transformer.setSourceFromXmlFile(xmlFilePathName);
      transformer.setHtmlOutputMethod();
      
      return transformer.transformToStringText();

   }

   /** Efect�a la transformaci�n de una fuente xml utilizando
   * instrucciones xsl.
   * @param xmlFilePathName Ruta de acceso y nombre del fichero xml con la
   * fuente.
   * @param xslFilePathName Ruta de acceso y nombre del fichero xsl con las 
   * instrucciones.
   * @return Texto html, codificado en UTF-8, con el resultado de la 
   * transformaci�n.
   * @throws Exception si se produce alg�n error. */ 
   
   public static byte[] transformXmlFileToHtmlUtf8TextUsingXslFile(
                        String xmlFilePathName, String xslFilePathName)
                        throws Exception
   {
      
      XmlTransformer transformer;
      
      transformer = new XmlTransformer();

      transformer.createUsingXslFile(xslFilePathName);
      transformer.setSourceFromXmlFile(xmlFilePathName);
      transformer.setHtmlOutputMethod();
      
      return transformer.transformToUtf8Text();

   }
   
} // class XmlTransformer
