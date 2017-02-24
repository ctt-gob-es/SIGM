package ieci.tecdoc.sgm.core.services.catalogo;

/**
 * Especializaci�n de un documento para su inclusi�n en un procedimiento.
 * 
 * @author IECISA
 *
 */
public class DocumentoExtendido extends Documento
{
	/**
	 * Constructor de la clase DocumentoExtendido
	 *
	 */
   public DocumentoExtendido()
   {
      code = null;
      mandatory = false;
   }
   
   /**
    * Constructor de la clase DocumentoExtendido a partir de un objeto Documento
    * @param document Datos de inicializaci�n
    */
   public DocumentoExtendido(Documento document) {
      this.setId(document.getId());
      this.setDescription(document.getDescription());
      this.setExtension(document.getExtension());
      this.setSignatureHook(document.getSignatureHook());
      this.setValidationHook(document.getValidationHook());
      code = null;
      mandatory = false;
   }
   
   /**
    * Establece el c�digo del documento.
    * @param code C�digo del documento.
    */   
   public void setCode(String code)
   {
      this.code = code;
   }
   
   /**
    * Establece la obligatoriedad del documento.
    * @param mandatory Obligatoriedad.
    */   
   public void setMandatory(boolean mandatory)
   {
      this.mandatory = mandatory;
   }

   /**
    * Recupera el c�digo del documento.
    * @return String C�digo de documento.
    */
   public String getCode()
   {
      return code;      
   }
   
   /**
    * Indica la obligatoriedad de un documento.
    * @return boolean Obligatoriedad.
    */   
   public boolean isMandatory()
   {
      return mandatory;
   }

  
   protected String code;
   protected boolean mandatory;
}