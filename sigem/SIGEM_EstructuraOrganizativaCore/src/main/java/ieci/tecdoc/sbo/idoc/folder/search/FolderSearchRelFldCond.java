
package ieci.tecdoc.sbo.idoc.folder.search;

import ieci.tecdoc.core.search.SearchConditionItem;
import ieci.tecdoc.sbo.idoc.archive.base.ArchiveTokenFld;
import ieci.tecdoc.sbo.idoc.dao.DaoUtil;
import ieci.tecdoc.sgm.base.dbex.DbConnection;

import java.util.ArrayList;

/**
 * Representa una condici�n de b�squeda de carpetas dentro de un archivador
 * para un campo de tipo relacional
 * 
 * @author
 * 
 * @see FolderSearchCondition
 */

public class FolderSearchRelFldCond implements FolderSearchCondition
                                              
{ 
   /**
    * Clase que construye la condici�n sql que representa la condici�n de b�squeda
    */
   SearchConditionItem m_condition;
   
   /**
    * Constructor
    * @param tblPrefix prefijo de la tabla que contiene las carpetas pertenecientes a un
    * archivador. El nombre de la tabla est� formado por un prefijo ('A' + idArch) y un
    * sufijo ('SF'), por ejemplo, A32SF, que corresponder�a con el nombre de la tabla
    * que contiene las carpetas del archivador con identificador 32.
    * @param fld referencia a un objeto de tipo ArchiveTokenFld que recoge informaci�n
    * de un campo del archivador
    * @param opr operador de b�squeda
    * @param vals valores de b�squeda
    * @throws Exception
    * @see ArchiveTokenFld
    */
   public FolderSearchRelFldCond(String tblPrefix, ArchiveTokenFld fld,
                                 String opr, ArrayList vals) throws Exception
   {
      String qualifiedColName;   
      int    dataType = FolderSearchUtil.convertFldTypeToSearchDataType(fld.getType());
      
      qualifiedColName = getQualifiedColName(tblPrefix, fld); 
      
      m_condition = new SearchConditionItem(qualifiedColName, opr, dataType,
                                            vals);
            
   } 

   /**
    * Devuelve la condici�n sql que representa la condici�n de b�squeda para un
    * determinado campo
    * @param dbEngine tipo de base de datos
    * @return  condici�n sql que representa la condici�n de b�squeda para un
    * determinado campo
    * @throws Exception 
    */
   public String getSqlCondition(DbConnection dbConn, int dbEngine) throws Exception
   {
      return m_condition.getSqlCondition(dbEngine);
   }
      
   /**
    * Devuelve el nombre de la columna en base de datos que representa el campo del archivador
    * @param tblPrefix prefijo de la tabla
    * @param fld referencia a un objeto de tipo ArchiveTokenFld que recoge informaci�n
    * de un campo del archivador
    * @return nombre de la columna en base de datos que representa el campo del archivador
    * @see ArchiveTokenFld
    */
   private String getQualifiedColName(String tblPrefix, ArchiveTokenFld fld)
   {
      
      String tblName = DaoUtil.getRelFldsTblName(tblPrefix);
      String qualColName;
     
      qualColName =  tblName + "." + fld.getColName();
      
      return qualColName;
      
   }   
   
} // class
