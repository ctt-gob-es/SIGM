package ieci.tecdoc.sgm.core.services.telematico;

/**
 * Bean con las propiedades de un n�mero de secuencia de registro.
 * 
 * @author IECISA
 *
 */
public class RegistroDocumento
{
   public RegistroDocumento()
   {
     registryNumber = null;
     code = null;
     guid = null;
   }
   
   /**
     * Devuelve el identificador �nico de documento.
     * @return String Identificador �nico de documento.
     */
   public String getGuid(){
     return guid;
   }
  
   /**
     * Establece identificador �nico de documento.
     * @param guid Identificador �nico de documento.
     */   
   public void setGuid(String guid){
     this.guid = guid;
   }
  
   /**
    * Devuelve el n�mero del registro al que pertenece el documento.
    * @return String Identificador �nico de documento.
    */
    public String getRegistryNumber(){
      return registryNumber;
    }
   
    /**
      * Establece el n�mero del registro al que pertenece el documento.
      * @param registryNumber Identificador �nico del registro.
      */   
    public void setRegistryNumber(String registryNumber){
      this.registryNumber = registryNumber;
    } 

    /**
     * Devuelve c�digo de documento.
     * @return String Identificador �nico de documento.
     */
   public String getCode(){
     return code;
   }
  
   /**
     * Establece c�digo de documento.
     * @param code Identificador �nico de documento.
     */   
   public void setCode(String code){
     this.code = code;
   }

   protected String guid;
   protected String registryNumber;
   protected String code;

   
}