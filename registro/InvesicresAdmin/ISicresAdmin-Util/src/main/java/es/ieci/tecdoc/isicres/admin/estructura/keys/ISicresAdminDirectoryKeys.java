package es.ieci.tecdoc.isicres.admin.estructura.keys;

/**
 * Proporciona los c�digos de error espec�ficos del API de administraci�n de 
 * directorios.
 */

public class ISicresAdminDirectoryKeys 
{
   private ISicresAdminDirectoryKeys()
   {
   }
   
   /**
    * C�digo de error base.
    */
   private static final long EC_PREFIX = 3006000;

   /**
    * El directorio ya existe.
    */
   public static final long EC_DIR_EXITS = EC_PREFIX + 1;
   
   /**
    * El directorio no existe.
    */
   public static final long EC_DIR_NOT_EXITS = EC_PREFIX + 2;
   
   /**
    * El directorio no se puede eliminar. Tiene hijos.
    */
   public static final long EC_DIR_HAS_CHILDREN = EC_PREFIX + 3;
   
}