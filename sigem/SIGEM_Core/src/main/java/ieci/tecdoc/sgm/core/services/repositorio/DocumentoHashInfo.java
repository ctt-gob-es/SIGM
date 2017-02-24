/**
 * @author Jos� Antonio Nogales Rinc�n
 * 
 * Fecha de creaci�n: 19-mar-2007
 */

package ieci.tecdoc.sgm.core.services.repositorio;

/**
 * Clase que almacena informaci�n relacionada con los documentos
 *
 */
public class DocumentoHashInfo {

   /**
    * Construye un objeto de la clase.
    */
   public DocumentoHashInfo() {
      super();
   }

   /**
    * Construye un objeto de la clase a partir de la ruta del documento
    * y la extensi�n.
    */
   public DocumentoHashInfo(String path, String extension){
     super();
     this.extension = extension;
     this.path = path;
  }
   
   /**
    * Devuelve el hash o resumen de un documento
    * @return String Hash o resumen de un documento
    */
   public String getHash() {

      return hash;
   }

   /**
    * Establece el hash o resumen de un documento
    * @param hash Hash o resumen de un documento
    */
   public void setHash(String hash) {
      this.hash = hash;
   }

   /**
    * Devuelve la localizaci�n del documento
    * @return String Localizaci�n del documento
    */
   public String getPath() {
      return path;
   }

   /**
    * Establece la localizaci�n del documento
    * @param path Localizaci�n del documento
    */
   public void setPath(String path){

      this.path = path;
   }

   /**
    * Devuelve la extensi�n del documento
    * @return String Extensi�n del documento
    */
   public String getExtension() {
      return extension;
   }

   /**
    * Establece la extensi�n del documento
    * @param extension Extensi�n del documento
    */
   public void setExtension(String extension) {
      this.extension = extension;
   }

   /**
    * Devuelve el GUID de un documento
    * @return StringGUID de un documento
    */
   public String getGuid() {
      return guid;
   }

   /**
    * Establece el GUID de un documento
    * @param guid GUID de un documento
    */
   public void setGuid(String guid) {
      this.guid = guid;
   }

   private String guid;
   private String path;
   private String extension;
   private String hash;
}