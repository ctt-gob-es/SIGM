package ieci.tecdoc.sbo.idoc.folder.search;

/**
 * Interfaz que representa una condici�n de b�squeda de carpetas dentro de un
 * archivador
 */
public interface FolderSearchCondition
{

   /**
    * Devuelve la condici�n sql que representa la condici�n de b�squeda de
    * carpetas dentro de un archivador
    * 
    * @param dbEngine
    *           tipo de base de datos:
    *           <li>DbEngine.SQLSERVER_STR
    *           <li>DbEngine.ORACLE_STR
    *           <li>DbEngine.MYSQL_STR
    * @return condici�n sql 
    * @throws Exception si se produce alg�n error en la obtenci�n de la condici�n sql
    */
   public String getSqlCondition(int dbEngine) throws Exception;

} // class
