package ieci.tecdoc.sgm.core.services.catalogo;


/**
 * Clase que implementa la interfaz Documento.
 * 
 * @author IECISA
 *
 */
public class Documento
{
	/**
	 * Constructor de la clase DocumentoImpl
	 *
	 */
   public Documento()
   {
      this.id = null;
      this.description = null;
      this.extension = null;
      this.signatureHook = null;
      this.validationHook = null;
   }
   
   /**
    * Establece el identificador del documento.
    * @param String Identificador de documento.
    */   
   public void setId(String id)
   {
      this.id = id;
   }
   
   /**
    * Establece la descripci�n del documento.
    * @param description Descripci�n del documento.
    */   
   public void setDescription(String description)
   {
      this.description = description;
   }
   
   /**
    * Establece la extensi�n del documento.
    * @param extension Extensi�n del documento.
    */   
   public void setExtension(String extension)
   {
      this.extension = extension;
   }
   
   /**
    * Conector de firma para el documento.
    * @param signatureHook Identificador del conector para la firma del documento.
    */   
   public void setSignatureHook(String signatureHook)
   {
      this.signatureHook = signatureHook;
   }
   
   /**
    * Establece el conector para la validaci�n del contenido del documento.
    * @param validationHook Identificador del conector de validaci�n de contenido.
    */   
   public void setValidationHook(String validationHook)
   {
      this.validationHook = validationHook;
   }
   
   /**
    * Recupera el identificador del documento.
    * @return String identificador de documento.
    */   
   public String getId()
   {
      return id;
   }
   
   /**
    * Recupera la descripci�n del documento.
    * @return String descripci�n del documento.
    */   
   public String getDescription()
   {
      return description;
   }
   
   /**
    * Recupera la extensi�n del documento.
    * @return String Extensi�n del documento.
    */   
   public String getExtension()
   {
      return extension;
   }
   
   /**
    * Recupera el identificador del conexi�n de firma del documento.
    * @return String Identificador del conector de firma del documento.
    */   
   public String getSignatureHook()
   {
      return signatureHook;
   }

   /**
    * Recupera el identificador del conector de validaci�n de contenido.
    * @retunr String identificdor del conector de validaci�n.
    */
   public String getValidationHook()
   {
      return validationHook;
   }
 
   
   protected String id;
   protected String description;
   protected String extension;
   protected String signatureHook;
   protected String validationHook;

}