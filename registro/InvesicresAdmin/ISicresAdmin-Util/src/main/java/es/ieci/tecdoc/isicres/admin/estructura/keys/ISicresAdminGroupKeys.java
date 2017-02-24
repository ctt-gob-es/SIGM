
package es.ieci.tecdoc.isicres.admin.estructura.keys;

/**
 * Proporciona los c�digos de error espec�ficos del API de administraci�n de 
 * grupos.
 */
 
public class ISicresAdminGroupKeys 
{
   private ISicresAdminGroupKeys()
   {
   }

   /**
    * C�digo de error base.
    */
   private static final long EC_PREFIX = 3002000;

   /**
    * El grupo ya existe. Por ejemplo, cuando se crea un grupo a partir
    * de un servicio de directorio Ldap que ha sido creado previamente.
    */
   public static final long EC_GROUP_EXITS = EC_PREFIX + 1;

   /**
    * El grupo no existe. Por ejemplo, cuando se intenta cargar un grupo
    * cuyo identificador no es v�lido.
    */
   public static final long EC_GROUP_NOT_EXITS = EC_PREFIX + 2;

   /**
    * El grupo no tiene permisos asignados.
    */
   public static final long EC_GROUP_NOT_PERMS = EC_PREFIX + 3;

   /**
    * El permiso del grupo para el producto solicitado no existe.
    */
   public static final long EC_GROUP_NOT_PERM_FOR_PRODUCT = EC_PREFIX + 4;
   
   /**
    * Ya existe un grupo con ese nombre.
    */
   public static final long EC_GROUP_EXIST_NAME = EC_PREFIX + 5;
   
   /**
    * No se permite introducir comillas en el texto.
    */
   public static final long EC_GROUP_DESC_EXIST_QUOTES = EC_PREFIX + 6;
   
}