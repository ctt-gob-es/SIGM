package ieci.tecdoc.sbo.idoc.documental.search;

import ieci.tecdoc.core.db.DbEngine;
import ieci.tecdoc.core.exception.IeciTdException;
import ieci.tecdoc.sbo.fss.core.FssDaoFtsTbl;
import ieci.tecdoc.sbo.fss.core.FssDaoVolVolTbl;
import ieci.tecdoc.sbo.idoc.folder.search.FolderSearchError;

import java.util.ArrayList;

/**
 * Clase que encapusula los filtros de b�squeda documental
 */

public final class DocumentalSearchQuery
{

   /**
    * Colecci�n de objetos de tipo String. Cada uno de estos
    * objetos representa una condici�n de b�squeda
    */
   private ArrayList m_ftsConditions;;
   
   /**
    * Contructor
    * @param arch - referencia a un objeto de tipo ArchiveToken que cotiene informaci�n
    * del archivador
    * @see ArchiveToken
    */
   public DocumentalSearchQuery ()
   {
      m_ftsConditions = new ArrayList();
   }

   /**
    * Devuelve la condici�n sql que se utilizar� como filtro en la b�squeda documental
    * @param dbEngine tipo de base de datos: 
    * <li> DbEngine.SQLSERVER_STR
    * <li> DbEngine.ORACLE_STR
    * <li> DbEngine.MYSQL_STR
    * @return condici�n sql 
    * @throws Exception - si se produce alg�n error en la obtenci�n de la condici�n sql
    */
   public String getFtsSqlQual (int dbEngine, int [] idVisibleArchs) throws Exception
   {

      StringBuffer sql = new StringBuffer ();

      if (dbEngine != DbEngine.ORACLE) {
         throw new IeciTdException(FolderSearchError.EC_INVALID_PARAM, 
                                   FolderSearchError.EM_INVALID_PARAM);    
      }


      /*
       * (CONTAINS (PATH, 'perro', 1) > 0)* AND EXTID1 IN (arch1, arch2, ...) 
       */
      String        ftsArchIdColName = FssDaoFtsTbl.getExtId1ColName(true);
      String        ftsPathColName   = FssDaoFtsTbl.getPathColName(true);

      if (idVisibleArchs != null && idVisibleArchs.length > 0) {
         sql.append(ftsArchIdColName).append( " IN (" );
         for (int i = 0; i < idVisibleArchs.length; i++) {
            if (i != 0) sql.append (',');
            sql.append (idVisibleArchs [i]);
         }
         sql.append (") ");
      }
      
      for (int i = 0; i < m_ftsConditions.size(); i++) {
         if (i != 0)
         {
            sql.append ("AND ");
         }
         else 
         {
            if (idVisibleArchs != null && idVisibleArchs.length > 0) {
               sql.append ("AND ");
            }
         }
         sql.append("CONTAINS (");
         sql.append(ftsPathColName);
         sql.append(", '" + m_ftsConditions.get (i) + "',1)>0 ");   
      } 

      if (sql.length() > 0) {
         sql.insert (0, "WHERE ");
      }
      
      return sql.toString();

   }

   
   /**
    * Devuelve la condici�n sql que se utilizar� como filtro en la b�squeda documental
    * para los ficheros que se guardan en la propia base de datos
    * @param dbEngine tipo de base de datos: 
    * <li> DbEngine.SQLSERVER_STR
    * <li> DbEngine.ORACLE_STR
    * <li> DbEngine.MYSQL_STR
    * @return condici�n sql 
    * @throws Exception - si se produce alg�n error en la obtenci�n de la condici�n sql
    */
   public String getDbSqlQual (int dbEngine, int [] idVisibleArchs) throws Exception
   {

      StringBuffer sql = new StringBuffer ();

      if (dbEngine != DbEngine.ORACLE) {
         throw new IeciTdException(FolderSearchError.EC_INVALID_PARAM, 
                                   FolderSearchError.EM_INVALID_PARAM);    
      }


      /*
       * (CONTAINS (PATH, 'perro', 1) > 0)* AND EXTID1 IN (arch1, arch2, ...) 
       */
      String        ftsArchIdColName = FssDaoVolVolTbl.CD_EXTID1.getName ();
      String        ftsPathColName   = FssDaoVolVolTbl.CD_FILEVAL.getName ();

      if (idVisibleArchs != null) {
         sql.append(ftsArchIdColName).append( " IN (" );
         for (int i = 0; i < idVisibleArchs.length; i++) {
            if (i != 0) sql.append (',');
            sql.append (idVisibleArchs [i]);
         }
         sql.append (") ");
      }
      
      for (int i = 0; i < m_ftsConditions.size(); i++) {
         if (i != 0)
         {
            sql.append ("AND ");
         }
         else 
         {
            if (idVisibleArchs != null && idVisibleArchs.length > 0) {
               sql.append ("AND ");
            }
         }
         sql.append("CONTAINS (");
         sql.append(ftsPathColName);
         sql.append(", '" + m_ftsConditions.get (i) + "',1)>0 ");   
      } 

      if (sql.length() > 0) {
         sql.insert (0, "WHERE ");
      }
      
      return sql.toString();

   }

   /**
    * A�ade una condici�n de b�squeda en contenido de documentos
    * @param condition expresi�n de b�squeda documental   
    */   
   public void addFTSSearchCondition(String condition) 
   {
      if (condition != null && ! "".equals (condition))
         m_ftsConditions.add (condition);
   }
 

} // class
