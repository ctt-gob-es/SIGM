
package ieci.tecdoc.sbo.idoc.folder.std;


import ieci.tecdoc.sbo.util.types.SboType;
import ieci.tecdoc.core.exception.IeciTdException;
import ieci.tecdoc.core.datetime.DateTimeUtil;
import ieci.tecdoc.core.db.DBSessionManager;
import ieci.tecdoc.sbo.idoc.dao.DaoDefs;
import ieci.tecdoc.sbo.idoc.dao.DaoFdrStatTbl;
import ieci.tecdoc.sbo.idoc.dao.DaoFdrStatRow;
import ieci.tecdoc.sgm.base.dbex.DbConnection;
import ieci.tecdoc.sgm.base.dbex.DbError;

public class FolderMdoLock
{
   
   private FolderMdoLock()
   {      
   }
   
   public static FolderLockInfo getLockInfo(DbConnection dbConn, int archId, int fdrId)
                                throws Exception
   {  
      FolderDaoStatInfoRow row      = null;       
      FolderLockInfo       lockInfo = null;  
      boolean              locked; 
      
      try
      {         
         row = selectFolderStatInfo(dbConn, archId, fdrId); 
         
         if (row.getStat() == DaoDefs.FDR_STAT_LOCKED)
            locked = true;
         else
            locked = false;
         
         lockInfo = new FolderLockInfo(locked, row.getUserId());        
      }
      catch (IeciTdException e)
      {
         if (e.getErrorCode().equals(DbError.EC_NOT_FOUND))
         {
            lockInfo = new FolderLockInfo(false, SboType.NULL_ID);
         }
         else
            throw e;
      }
      
      return lockInfo;    
   } 
   
   public static void lock(int archId, int fdrId, int userId, String entidad)
                      throws Exception
   {  
      FolderLockInfo lockInfo = null;
      DaoFdrStatRow  row      = null;  

      DbConnection dbConn=new DbConnection();
      try{
      	dbConn.open(DBSessionManager.getSession(entidad));
         dbConn.beginTransaction();

         //Se bloquea la tabla para que nadie la pueda modificar
         DaoFdrStatTbl.lockRow(dbConn, archId, fdrId);         
        
         //se averigua si la carpeta est� bloqueada
         lockInfo =  getLockInfo(dbConn, archId, fdrId);
         
         if (lockInfo.isLocked())
         {
            if (userId != lockInfo.getLockerId())
            {               
               throw new IeciTdException(FolderError.EC_FDR_ALREADY_LOCKED, 
                                         FolderError.EM_FDR_ALREADY_LOCKED);                
            }
            
         }
         else
         {
            row = fillStatRow(archId, fdrId, userId);
            DaoFdrStatTbl.insertRow(dbConn, row);
         }
         
         dbConn.endTransaction(true);

      }
      catch (Exception e)
      {
    	  throw e;
      }finally{
    	  dbConn.close();
      }
      
   } 
   
   public static void unlock(int archId, int fdrId, int userId, String entidad)
                      throws Exception
   {  
      
	   DbConnection dbConn=new DbConnection();
	   try{
	   	dbConn.open(DBSessionManager.getSession(entidad));

         dbConn.beginTransaction();
         
         DaoFdrStatTbl.deleteLockedRow(dbConn, archId, fdrId, userId);         
         
         dbConn.endTransaction(true);

      }
      catch (Exception e)
      {
    	  throw e;
      }
      
   }   
   
   private static DaoFdrStatRow fillStatRow(int archId, int fdrId, int userId)
                                throws Exception
   {

      DaoFdrStatRow rec = new DaoFdrStatRow();      

      rec.m_fdrId  = fdrId;
      rec.m_archId = archId;
      rec.m_stat   = DaoDefs.FDR_STAT_LOCKED;
	   rec.m_userId = userId;
	   rec.m_ts     = DateTimeUtil.getCurrentDateTime();	
	   rec.m_flags  = 0;	

      return rec;

   } 
   
   private static FolderDaoStatInfoRow selectFolderStatInfo(DbConnection dbConn, int archId, int fdrId)
                                      throws Exception
   {  
      FolderDaoStatInfoRow  row = new FolderDaoStatInfoRow();       
           
      DaoFdrStatTbl.selectRow(dbConn, archId, fdrId, row); 
      
      return row;    
   } 
   
   
} // class
