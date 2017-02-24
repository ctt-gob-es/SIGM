
package ieci.tecdoc.sbo.idoc.folder.base;

/**
 * Definici�n de c�digos y mensajes de error para las carpetas
 * 
 * @author
 *
 */

public final class FolderBaseError
{
   /** Prefijo identificador del paquete */
   private static final String EC_PREFIX = "IECI_TECDOC_OBJDS_FOLDER_BASE_";   
   
   // **************************************************************************
       
   /** C�digo de error de par�metro inv�lido */
   public static final String  EC_INVALID_PARAM  = 
   EC_PREFIX +  "INVALID_PARAM";

   /** Mensaje de error de par�metro inv�lido */
   public static final String  EM_INVALID_PARAM  = 
   "Invalid parameter";
   
   // **************************************************************************

   /** C�digo de error de documento no encontrada */
   public static final String  EC_NOT_FOUND  = 
   EC_PREFIX +  "NOT_FOUND";

   /** Mensaje de error de carpeta no encontrada */
   public static final String  EM_NOT_FOUND  = 
   "Not found";
   
   // **************************************************************************

   /** C�digo de error de campo multivalor */
   public static final String  EC_FIELD_IS_MULT  = 
   EC_PREFIX +  "FIELD_IS_MULT";

   /** Mensaje de error de campo multivalor */
   public static final String  EM_FIELD_IS_MULT  = 
   "Field is multivalue";
   
   // **************************************************************************

   /** C�digo de error de campo no multivalor */
   public static final String  EC_FIELD_IS_NOT_MULT  = 
   EC_PREFIX +  "FIELD_IS_NOT_MULT";

   /** Mensaje de error de campo no multivalor */
   public static final String  EM_FIELD_IS_NOT_MULT  = 
   "Field is not multivalue";
   
   // **************************************************************************
   
   /** C�digo de error de valor inv�lido */
   public static final String  EC_INVALID_VALUE  = 
   EC_PREFIX +  "INVALID_VALUE";
   
   /** Mensaje de error de valor inv�lido */
   public static final String  EM_INVALID_VALUE  = 
   "Invalid value";
   
   // **************************************************************************
   
   /** C�digo de error de padre inv�lido */
   public static final String  EC_INVALID_PARENT  = 
   EC_PREFIX +  "INVALID_PARENT";
   
   /** Mensaje de error de padre inv�lido */
   public static final String  EM_INVALID_PARENT = 
   "Invalid parent";
   
   // **************************************************************************
   
   /** C�digo de error de nombre inv�lido*/
   public static final String  EC_INVALID_NAME  = 
   EC_PREFIX +  "INVALID_NAME";
   
   /** Mensaje de error de nombre inv�lido*/
   public static final String  EM_INVALID_NAME = 
   "Invalid name";
   
  // **************************************************************************
   
   /** C�digo de error de nombre ya existente */
   public static final String  EC_NAME_ALREADY_EXISTS  = 
   EC_PREFIX +  "NAME_ALREADY_EXISTS";
   
   /** Mensaje de error de nombre ya existente */
   public static final String  EM_NAME_ALREADY_EXISTS = 
   "Name already exists";
   
  // **************************************************************************
   
   /** C�digo de error de clasificador con hijos */
   public static final String  EC_DIVIDER_HAS_CHILDREN  = 
   EC_PREFIX +  "DIVIDER_HAS_CHILDREN";
   
   /** Mensaje de error de clasificador con hijos */
   public static final String  EM_DIVIDER_HAS_CHILDREN = 
   "Divider has children";
   
    // **************************************************************************
   
   /** C�digo de error de nodo no eliminado */
   public static final String  EC_NO_REMOVE_NODE = 
   EC_PREFIX +  "NO_REMOVE_NODE";
   
   /** Mensaje de error de nodo no eliminado */
   public static final String  EM_NO_REMOVE_NODE = 
   "No remove node";
   
      
   // **************************************************************************

   private FolderBaseError()
   {
   }
   
} // class
