/*
 * Created on 12-sep-2005
 *
 */
package ieci.tecdoc.sbo.idoc.vldtable.std;


import ieci.tecdoc.core.db.DBSessionManager;
import ieci.tecdoc.sgm.base.dbex.DbColumnDef;
import ieci.tecdoc.sgm.base.dbex.DbConnection;
import ieci.tecdoc.sgm.base.dbex.DbDataType;
import ieci.tecdoc.sgm.base.dbex.DbSelectFns;
import ieci.tecdoc.sgm.base.dbex.DbUtil;
import ieci.tecdoc.sgm.base.dyndao.DynDaoRs;


/**
 * @author egonzalez
 */
public class VldDaoHierarchicalVldTbl
{
   
   
   private String TN = null;
   
   private static final DbColumnDef CD_PARENT = new DbColumnDef
   ("IDOCPARENTKEY", DbDataType.LONG_INTEGER, false);

   private static final DbColumnDef CD_CHILD = new DbColumnDef
   ("IDOCCHILDKEY", DbDataType.LONG_INTEGER, false);
   
   private static final DbColumnDef[] FIELDS =
   {CD_PARENT, CD_CHILD};   
   
   private static final String ACN = DbUtil.getColumnNames(FIELDS);
   
   public VldDaoHierarchicalVldTbl (String tn)
   {      
      TN = tn;
   }
   
   private String getDefaultQual(int parent, int child)
   {
      return "WHERE " + CD_PARENT.getName() + "= " + parent + " AND " 
      	+ CD_CHILD.getName() + "= " + child ;
   }
   
   protected String getColName(DbColumnDef colDef, boolean qualified)
   {
      String colName = colDef.getName();
      
      if (qualified)
         colName =  TN +  "." + colName;
      
      return colName;
   }   
   
   public String getTblName()
   {      
      return TN;
   }   
   
   public boolean existRow(int parent, int child, String entidad) throws Exception
   {

      boolean rc = false;
      
      DynDaoRs  rs  = new DynDaoRs(FIELDS);

      DbConnection dbConn=new DbConnection();
      try{
      	dbConn.open(DBSessionManager.getSession(entidad));
      	DbSelectFns.select(dbConn, TN, ACN,getDefaultQual(parent, child), false, rs);
      }catch(Exception e){
    		throw e;
    	}finally{
    		dbConn.close();
    	}
      return rs.count() > 0;

   }   
}

