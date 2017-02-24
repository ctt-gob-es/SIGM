
package es.ieci.tecdoc.isicres.admin.estructura.beans;


/**
 * Proporciona las definiciones de todos los identificadores relativos a la
 * administraci�n de directorios y archivadores.
 */

public class ArchiveDefs 
{
   private ArchiveDefs()
   {
   }
   
    /**
    * Identificador de <I>Directorio Est�ndar</I>.
    */
   public static int DIR_TYPE_STANDARD = 0;

   /**
    * Identificador de <I>Directorio registro</I>.
    */
   public static int DIR_TYPE_SICRES = 1;
   
   /**
    * Identificador de <I>Archivador Est�ndar</I>
    */
   public static int ARCH_TYPE_STANDARD = 0;
   
   /**
    * Identificador de <I>Archivador registro entrada</I>
    */
   public static int ARCH_TYPE_SICRES_INPUT = 1;
   
   /**
    * Identificador de <I>Archivador registro salida</I>
    */
   public static int ARCH_TYPE_SICRES_OUTPUT = 2;
   
   /**
    * Identificador de flag de archivador <I> ninguno </I>
    */
   public static int ARCH_FLAG_NONE = 0;
   
   /**
    * Identificador de flag de archivador <I> B�squeda en contenido de fichero </I>
    */
   public static int ARCH_FLAG_FTSINCONTENTS = 1;
   
}