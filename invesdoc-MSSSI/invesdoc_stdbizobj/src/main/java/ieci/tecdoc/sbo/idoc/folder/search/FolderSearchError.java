
package ieci.tecdoc.sbo.idoc.folder.search;

/**
 * Recoge las descripciones de los errores m�s comunes en una b�squeda
 * @author
 */

public final class FolderSearchError
{
   
   private static final String EC_PREFIX = "IECI_TECDOC_IDOC_FOLDER_SEARCH_";   
   
   // **************************************************************************
        
   /**
    * C�digo: par�metro inv�lido
    */
   public static final String EC_INVALID_PARAM = 
   EC_PREFIX + "INVALID_PARAM"; 
   
   /**
    * Mensaje: par�metro inv�lido
    */
   public static final String EM_INVALID_PARAM =
   "Invalid Param";
   
   // **************************************************************************
   
   /**
    * C�digo: campo inv�lido
    */
   public static final String EC_INVALID_SEARCH_FLD = 
   EC_PREFIX + "INVALID_SEARCH_FLD"; 
   
   /**
    * Mensaje: campo inv�lido
    */   
   public static final String EM_INVALID_SEARCH_FLD =
   "Incorrect field to search ";

   // **************************************************************************
   
   /**
    * C�digo: operador inv�lido
    */   
   public static final String EC_INVALID_SEARCH_OPR = 
   EC_PREFIX + "INVALID_SEARCH_OPR"; 
   
   /**
    * Mensaje: operador inv�lido
    */   
   public static final String EM_INVALID_SEARCH_OPR =
   "Incorrect search operator";
   
   // **************************************************************************

   /**
    * C�digo: campo de ordenaci�n inv�lido
    */   
   public static final String EC_INVALID_SEARCH_ORDER_FLD = 
   EC_PREFIX + "INVALID_SEARCH_ORDER_FLD"; 
      
   /**
    * Mensaje: campo de ordenaci�n inv�lido
    */   
   public static final String EM_INVALID_SEARCH_ORDER_FLD =
   "Incorrect field to order the query ";
   
   // **************************************************************************

   /**
    * C�digo: no encontrado
    */   
   public static final String  EC_NOT_FOUND  = 
   EC_PREFIX +  "NOT_FOUND";

   /**
    * Mensaje: no encontrado
    */   
   public static final String  EM_NOT_FOUND  = 
   "Not found";
      
   // **************************************************************************

   /**
    * Constructor
    */
   private FolderSearchError()
   {
   }
   
} // class
