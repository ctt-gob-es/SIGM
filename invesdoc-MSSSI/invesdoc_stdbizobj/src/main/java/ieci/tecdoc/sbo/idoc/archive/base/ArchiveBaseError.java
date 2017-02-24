
package ieci.tecdoc.sbo.idoc.archive.base;

/**
 * Definici�n de c�digos y mensajes de error para los archivadores
 * 
 * @author
 *
 */
public final class ArchiveBaseError
{
   /** Prefijo identificador del paquete */
   private static final String EC_PREFIX = "IECI_TECDOC_IDOC_ARCHIVE_BASE";   
   
   // **************************************************************************
   
   /** C�digo de error de par�metro inv�lido */
   public static final String  EC_INVALID_PARAM  = 
   EC_PREFIX +  "INVALID_PARAM";

   /** Mensaje de error de par�metro inv�lido */
   public static final String  EM_INVALID_PARAM  = 
   "Invalid parameter";
   
   // **************************************************************************

   /** C�digo de error de archivador no encontrado */
   public static final String  EC_NOT_FOUND  = 
   EC_PREFIX +  "NOT_FOUND";

   /** Mensaje de error de archivador no encontrado */
   public static final String  EM_NOT_FOUND  = 
   "Not found";
      
   // **************************************************************************

   private ArchiveBaseError()
   {
   }
   
} // class
