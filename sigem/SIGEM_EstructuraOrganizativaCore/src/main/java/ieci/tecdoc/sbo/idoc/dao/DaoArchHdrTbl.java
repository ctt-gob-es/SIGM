
package ieci.tecdoc.sbo.idoc.dao;

import ieci.tecdoc.sbo.util.idoc8db.Idoc8DbAcsRec;
import ieci.tecdoc.sgm.base.dbex.DbColumnDef;
import ieci.tecdoc.sgm.base.dbex.DbConnection;
import ieci.tecdoc.sgm.base.dbex.DbDataType;
import ieci.tecdoc.sgm.base.dbex.DbIndexDef;
import ieci.tecdoc.sgm.base.dbex.DbSelectFns;
import ieci.tecdoc.sgm.base.dbex.DbTableFns;
import ieci.tecdoc.sgm.base.dbex.DbUtil;

public class DaoArchHdrTbl
{
   
   // **************************************************************************
   /* 
 *@SF-SEVILLA 
 *02-may-2006 / antmaria
 */
   private static final String TN = /*DbConnectionConfig.getSchema() +*/"IDOCARCHHDR";

   private static final DbColumnDef CD_ID = new DbColumnDef
   ("ID", DbDataType.LONG_INTEGER, false);

   private static final DbColumnDef CD_NAME = new DbColumnDef
   ("NAME", DbDataType.SHORT_TEXT, 32, false);
   
   private static final DbColumnDef CD_TBLPREFIX = new DbColumnDef
   ("TBLPREFIX", DbDataType.SHORT_TEXT, 16, false);
   
   private static final DbColumnDef CD_TYPE = new DbColumnDef
   ("TYPE", DbDataType.LONG_INTEGER, false); 
   
   private static final DbColumnDef CD_FLAGS = new DbColumnDef
   ("FLAGS", DbDataType.LONG_INTEGER, false); 
   
   private static final DbColumnDef CD_REMS = new DbColumnDef
   ("REMARKS", DbDataType.SHORT_TEXT, 254, true); 
   
   private static final DbColumnDef CD_ACCESSTYPE = new DbColumnDef
   ("ACCESSTYPE", DbDataType.LONG_INTEGER, false); 
   
   private static final DbColumnDef CD_ACSID = new DbColumnDef
   ("ACSID", DbDataType.LONG_INTEGER, false); 
   
   private static final DbColumnDef CD_CRTUSRID = new DbColumnDef
   ("CRTRID", DbDataType.LONG_INTEGER, false);

   private static final DbColumnDef CD_CRTTS = new DbColumnDef
   ("CRTNDATE", DbDataType.DATE_TIME, false);

   private static final DbColumnDef CD_UPDUSRID = new DbColumnDef
   ("UPDRID", DbDataType.LONG_INTEGER, true);

   private static final DbColumnDef CD_UPDTS = new DbColumnDef
   ("UPDDATE", DbDataType.DATE_TIME, true);
  
   private static final DbColumnDef[] ACD = 
   {CD_ID, CD_NAME, CD_TBLPREFIX, CD_TYPE, CD_FLAGS, CD_REMS, CD_ACCESSTYPE, CD_ACSID,
    CD_CRTUSRID, CD_CRTTS, CD_UPDUSRID, CD_UPDTS};  
   
   private static final String ACN = DbUtil.getColumnNames(ACD);   
   
   private static final String ACSCN = DbUtil.getColumnNames
  (CD_ACCESSTYPE, CD_ACSID);
   
   private static final int ARCH_TYPE_STANDARD = 0;
   
   // **************************************************************************

   private DaoArchHdrTbl()
   {
   }
   
   private static String getDefaultQual(int id)
   {
      return "WHERE " + CD_ID.getName() + "= " + id;
   }   
      
   // **************************************************************************
      
   protected static String getColName(DbColumnDef colDef, boolean qualified)
   {
      String colName = colDef.getName();
      
      if (qualified)
         colName =  TN + "." + colName;
      
      return colName;
   }
   
   public static String getTblName()
   {      
      return TN;
   }
   
   public static String getIdColName(boolean qualified)
   {
      return getColName(CD_ID, qualified);
   }
   
   public static String getNameColName(boolean qualified)
   {
      return getColName(CD_NAME, qualified);
   }
   
   public static String getTblPrefixColName(boolean qualified)
   {
      return getColName(CD_TBLPREFIX, qualified);
   }
   
   public static String getTypeColName(boolean qualified)
   {
      return getColName(CD_TYPE, qualified);
   }
   
   public static String getFlagsColName(boolean qualified)
   {
      return getColName(CD_FLAGS, qualified);
   }
   
   public static String getRemarksColName(boolean qualified)
   {
      return getColName(CD_REMS, qualified);
   }
   
   public static String getAccessTypeColName(boolean qualified)
   {
      return getColName(CD_ACCESSTYPE, qualified);
   }
   
   public static String getAcsIdColName(boolean qualified)
   {
      return getColName(CD_ACSID, qualified);
   }
   
   public static String getCrtUserIdColName(boolean qualified)
   {
      return getColName(CD_CRTUSRID, qualified);
   }
   
   public static String getCrtTSColName(boolean qualified)
   {
      return getColName(CD_CRTTS, qualified);
   }
   
   public static String getUpdUserIdColName(boolean qualified)
   {
      return getColName(CD_UPDUSRID, qualified);
   }
   
   public static String getUpdTSColName(boolean qualified)
   {
      return getColName(CD_UPDTS, qualified);
   }
   
   // **************************************************************************
   
   public static void selectChildrenRows(DbConnection dbConn, int parentDirId, DaoOutputRows rows) 
                                        throws Exception
   {  
      
      String inText, qual;
      String joinStmt;
      
      joinStmt = DaoDATNodeTbl.getSelectStatementTextChildrenArchNodes(parentDirId);               
      
      qual = "WHERE EXISTS(" + joinStmt + " ) AND " +
             CD_TYPE.getName() + "=" + ARCH_TYPE_STANDARD + 
             " ORDER BY " + CD_NAME.getName();
      
      DbSelectFns.select(dbConn, TN, rows.getColumnNames(), qual, false, rows);
            
   }
   
   public static void selectRow(DbConnection dbConn, int id, DaoOutputRow row) throws Exception 
   { 
      DbSelectFns.select(dbConn, TN, row.getColumnNames(), getDefaultQual(id), row);
   }
   
   public static String selectName(DbConnection dbConn, int id) throws Exception
   { 
      String name;
      
      name = DbSelectFns.selectShortText(dbConn, TN, CD_NAME.getName(),
                                         getDefaultQual(id));

      return name;
   }
   
   public static String selectTblPrefix(DbConnection dbConn, int id) throws Exception
   { 
      String name;
      
      name = DbSelectFns.selectShortText(dbConn, TN, CD_TBLPREFIX.getName(),
                                         getDefaultQual(id));

      return name;
   }
   
   public static Idoc8DbAcsRec selectAcsInfo(DbConnection dbConn, int id)
                               throws Exception
   {
      
      Idoc8DbAcsRec rec = new Idoc8DbAcsRec();  

      DbSelectFns.select(dbConn, TN, ACSCN, getDefaultQual(id), rec);

      return rec;
      
   } 
   
// **************************************************************************
   
   public static void createTable(DbConnection dbConn) throws Exception
   {
      String indexName,indexName2;
      String colNamesIndex,colNamesIndex2;
      DbIndexDef indexDef, indexDef2;
      
      indexName = TN + "1";
      colNamesIndex = "ID";
      indexName2 = TN + "2";
      colNamesIndex2 = "TYPE";
      
      indexDef= new DbIndexDef(indexName,colNamesIndex,true);
      indexDef2= new DbIndexDef(indexName2,colNamesIndex2,false);
      
      DbTableFns.createTable(dbConn, TN,ACD);
      
      DbTableFns.createIndex(dbConn, TN,indexDef);
      DbTableFns.createIndex(dbConn, TN,indexDef2);      
   }
   
   public static void dropTable(DbConnection dbConn) throws Exception
   {
      String idxName, idxName2;
      
      idxName = TN + "1";
      idxName2 = TN + "2";
      
      dropIndex(dbConn, TN,idxName);
      dropIndex(dbConn, TN,idxName2);
      DbTableFns.dropTable(dbConn, TN);
   }
   
   private static void dropIndex(DbConnection dbConn, String tblName, String indexName)
   {
      try
      {
         DbTableFns.dropIndex(dbConn, tblName,indexName);
      }
      catch(Exception e)
      {
         
      }
   }
   
   
} // class
