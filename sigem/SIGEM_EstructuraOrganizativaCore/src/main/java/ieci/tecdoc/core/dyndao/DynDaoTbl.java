
package ieci.tecdoc.core.dyndao;



import ieci.tecdoc.core.db.DBSessionManager;
import ieci.tecdoc.sgm.base.collections.IeciTdShortTextArrayList;
import ieci.tecdoc.sgm.base.dbex.DbColumnDef;
import ieci.tecdoc.sgm.base.dbex.DbConnection;
import ieci.tecdoc.sgm.base.dbex.DbInsertFns;
import ieci.tecdoc.sgm.base.dbex.DbSelectFns;
import ieci.tecdoc.sgm.base.dbex.DbUpdateFns;
import ieci.tecdoc.sgm.base.dbex.DbUtil;

public class DynDaoTbl
{
   
   // **************************************************************************
   
   protected String        m_tblName;
   protected DbColumnDef[] m_colsDef;      
   
      
   // **************************************************************************
   protected DynDaoTbl()
   {
      m_tblName = null;
      m_colsDef = null;
   }
   
   protected void init(String tblName, DbColumnDef[] colsDef)
   {
      m_tblName = tblName;
      m_colsDef = colsDef;
   }
   
   public DynDaoTbl(String tblName, DbColumnDef[] colsDef)
   {
      m_tblName = tblName;
      m_colsDef = colsDef;
   }
   
   public DbColumnDef[] getAllColumns()
   {
      return m_colsDef;
   }
   
  // ************************************************************************
   
   public void insertRow(DynDaoRec rec, String entidad) throws Exception
   {  
	   DbConnection dbConn=new DbConnection();
	   try{
	   	dbConn.open(DBSessionManager.getSession(entidad));
        DbInsertFns.insert(dbConn, m_tblName, DbUtil.getColumnNames(m_colsDef), rec);      
	   }catch(Exception e){
    	  throw e;
      }finally{
    	  dbConn.close();
      }
   }
   
   // ************************************************************************
   
   public void updateRow(DynDaoRec row, String qual, String entidad)
               throws Exception
   { 
	   DbConnection dbConn=new DbConnection();
	   try{
	   	  dbConn.open(DBSessionManager.getSession(entidad));
	      DbColumnDef[] updateColsDef  = row.getColumnsDef();
	      
	      DbUpdateFns.update(dbConn, m_tblName, DbUtil.getColumnNames(updateColsDef), 
	                         row, qual);
	   }catch(Exception e){
		   throw e;
	   }finally{
		   dbConn.close();
	   }
   }
   
   // ************************************************************************
      
   public DynDaoRec selectRow(IeciTdShortTextArrayList colNames, String qual, String entidad)
                      throws Exception
   {  
	   DbConnection dbConn=new DbConnection();
	   DynDaoRec    rec=null;
	   try{
	   	  dbConn.open(DBSessionManager.getSession(entidad));
	      DbColumnDef[] colsDef = getColsDef(colNames);
	      rec      = new DynDaoRec(colsDef);
	        
	      DbSelectFns.select(dbConn, m_tblName, DbUtil.getColumnNames(colsDef),
	                         qual, rec);
	   }catch(Exception e){
			throw e;
		}finally{
			dbConn.close();
		}
      return rec;
      
   }
   
   public void selectRow(String qual, DynDaoRec rec, String entidad)
                  throws Exception
   { 
	   DbConnection dbConn=new DbConnection();
	   try{
	   	  dbConn.open(DBSessionManager.getSession(entidad));
	      DbColumnDef[] selectColsDef  = rec.getColumnsDef();
	      
	      DbSelectFns.select(dbConn, m_tblName, DbUtil.getColumnNames(selectColsDef), 
	                         qual, rec);
	   }catch(Exception e){
			throw e;
		}finally{
			dbConn.close();
		}
   }
   
   public DynDaoRs selectRows(IeciTdShortTextArrayList colNames, String qual, String entidad)
                   throws Exception
   { 

      DbColumnDef[] colsDef = getColsDef(colNames);

      return selectRows(colsDef, qual, entidad);

   }

   public DynDaoRs selectRows(DbColumnDef[] selectColsDef, String qual, String entidad)
                   throws Exception
   { 

	   DbConnection dbConn=new DbConnection();
	   DynDaoRs  rs=null;
	   try{
	   	  dbConn.open(DBSessionManager.getSession(entidad));
	      rs = new DynDaoRs(selectColsDef);
	
	      DbSelectFns.select(dbConn, m_tblName, 
	                         DbUtil.getColumnNames(selectColsDef),
	                         qual, false, rs);
	   }catch(Exception e){
			throw e;
		}finally{
			dbConn.close();
		}
      return rs;

   }
   
   private DbColumnDef[] getColsDef(IeciTdShortTextArrayList colNames)
                         throws Exception
   {  
      int           i, j, numCols;
      DbColumnDef[] colDefs = new DbColumnDef[colNames.count()];
      DbColumnDef   colDef;
      String        colName;
      int           colIdx = 0;
      
      numCols = m_colsDef.length;
      
      for(i = 0; i < numCols; i++)
      {
         
         colName = colNames.get(i);
                  
         for(j = 0; j < numCols; j++)
         {
            colDef = m_colsDef[j];
            
            if (colDef.getName().equals(colName))
            {
               colDefs[colIdx] = new DbColumnDef(colName, colDef.getDataType(),
                                                 colDef.getMaxLen(), colDef.isNullable());
               colIdx = colIdx + 1;
               break;
            }
         }
         
      }
      
      return colDefs;
      
   }
      
} // class
