package ieci.tecdoc.idoc.admin.api.archive;

/**
 * Proporciona toda la funcionalidad necesaria para manejar archivadores invesDoc. 
 */
public interface Archives
{
   /**
    * Obtiene informaci�n b�sica de archivadores de un mismo padre
    * @param parentDirId Identificador del padre
    * @return La informaci�n mencionada
    * @throws Exception Errores
    * @see BasicArchives
    */
   public BasicArchives getArchivesByDirectory(int parentDirId, String entidad) throws Exception;
   
}
