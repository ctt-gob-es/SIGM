
package ieci.tecdoc.sbo.sms.core;

import ieci.tecdoc.sgm.base.dbex.DbColumnDef;
import ieci.tecdoc.sgm.base.dbex.DbConnection;
import ieci.tecdoc.sgm.base.dbex.DbDataType;
import ieci.tecdoc.sgm.base.dbex.DbSelectFns;
import ieci.tecdoc.sgm.base.dbex.DbTableFns;
import ieci.tecdoc.sgm.base.dbex.DbUtil;


public final class SmsDaoSessNextIdTbl
{
   
   // **************************************************************************
	/* 
	 *@SF-SEVILLA 
	 *02-may-2006 / antmaria
	 */   
   private static final String TN ="ITDSMSNEXTID";

   private static final DbColumnDef CD_ID = new DbColumnDef
   ("CID", DbDataType.LONG_INTEGER, false);
   
   private static final DbColumnDef[] ACD = 
   {CD_ID};
     
   private static final String ACN = DbUtil.getColumnNames(ACD);   
   
   
   // **************************************************************************
   
   private SmsDaoSessNextIdTbl()
   {
   }
   
  // **************************************************************************
   public static void initTblContentsNextId(DbConnection dbConn) throws Exception
   {
      
      String stmtText;
      
      stmtText = "INSERT INTO " + TN + " VALUES( 1 )";            
      DbUtil.executeStatement(dbConn, stmtText);
      
   }
   
   public static void createTable(DbConnection dbConn) throws Exception
   {
      DbTableFns.createTable(dbConn, TN, ACD);
   }
   
   public static void dropTable(DbConnection dbConn) throws Exception
   {
      DbTableFns.dropTable(dbConn, TN);
   }
   
   // **************************************************************************  
   
   public static void incrementNextId(DbConnection dbConn, short incr) throws Exception
   {

      String stmtText;

      stmtText = "UPDATE " + TN + " SET " + CD_ID.getName() + "="
            + CD_ID.getName() + "+" + incr;

      DbUtil.executeStatement(dbConn, stmtText);

   }
   
   // **************************************************************************  
  
   public static int getNextId(DbConnection dbConn) throws Exception
   {

      int nextId;

      nextId = DbSelectFns.selectLongInteger(dbConn, TN, CD_ID.getName(), null);

      return nextId;

   }
} // class
