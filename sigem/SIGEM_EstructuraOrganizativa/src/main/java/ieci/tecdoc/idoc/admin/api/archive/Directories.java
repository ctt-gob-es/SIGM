package ieci.tecdoc.idoc.admin.api.archive;

/**
 * Proporciona toda la funcionalidad necesaria para manejar �rbol de
 * directorios invesDoc. 
 */
public interface Directories
{
   /**
    * Obtiene informaci�n b�sica de directorios de un mismo padre
    * @param parentDirId Identificador del padre
    * @return La informaci�n mencionada
    * @throws Exception Errores
    * @see BasicDirectories
    */
   public BasicDirectories getChildrenFormDirectory(int dirId, String entidad) throws Exception;
   
}
   
