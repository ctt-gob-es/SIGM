package ieci.tecdoc.sgm.core.services.catalogo;

/**
 * Calse que implementa la intefaz TipoConector
 * @author x53492no
 *
 */
public class TipoConector
{
	/**
	 * Constructor de la clase TipoConectorImpl
	 *
	 */
  public TipoConector()
  {
     this.id = -1;
     this.description = null;
  }
  
  /**
   * Establece el identificador del tipo de conector.
   * @param int Identificador de tipo de conector.
   */   
  public void setId(int id)
  {
     this.id = id;
  }
  
  /**
   * Establece la descripci�n del tipo de conector.
   * @param description Descripci�n del tipo de conector.
   */   
  public void setDescription(String description)
  {
     this.description = description;
  }
  
  /**
   * Recupera el identificador del tipo de conector.
   * @return int identificador de tipo de conector.
   */   
  public int getId()
  {
     return id;
  }
  
  /**
   * Recupera la descripci�n del tipo de conector.
   * @return String descripci�n del tipo de conector.
   */   
  public String getDescription()
  {
     return description;
  }
  
    /**
     * Autenticaci�n con certificado digital.
     */
    public final static int CERTIFICATE_AUTH = 1;
    
    /**
     * Autenticaci�n con usuario Web de nivel 2.
     */
    public final static int WEB_USER_AUTH = 2;
    
    /**
     * Creaci�n de firma.
     */
    public final static int SIGNATURE_CREATE = 3;
    
    /**
     * Verificaci�n de firma.
     */
    public final static int SIGNATURE_VERIFY = 4;
    
    /**
     * Validaci�n del contenido de un documento.
     */
    public final static int DOCUMENT_VERIFY = 5;

    /**
     * Obtenci�n del certiricado.
     */
    public final static int CERTIFICATE_GET = 6;
    
    /**
     * Autenticaci�n con certificado digital v�a web.
     */
    public final static int CERTIFICATE_WEB_AUTH = 7;
   
    
  protected int id;
  protected String description;
}
