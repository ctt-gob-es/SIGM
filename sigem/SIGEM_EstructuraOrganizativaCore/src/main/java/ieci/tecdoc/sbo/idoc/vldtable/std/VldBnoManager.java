
package ieci.tecdoc.sbo.idoc.vldtable.std;

import java.util.HashMap;

import ieci.tecdoc.core.db.DBSessionManager;
import ieci.tecdoc.sbo.idoc.vldtable.base.*;
import ieci.tecdoc.sgm.base.dbex.DbConnection;


public final class VldBnoManager
{
   
   private static ThreadLocal m_cache = new ThreadLocal ();
   
   private VldBnoManager()
   {
   }
   
   public static VldTblToken loadValidationTable ( int tableId, String entidad ) throws Exception
   {
	   DbConnection dbConn=new DbConnection();
	   try{
	   	dbConn.open(DBSessionManager.getSession(entidad));

         VldTblToken vldToken = VldMdoVldTable.loadValidationTable(dbConn, tableId) ;

         return vldToken;
      }
      catch (Exception e){
         return null;
      }finally{
    	  dbConn.close();
      }
   }

   public static VldTblSearchResults executeQuery(VldTblToken vldToken, String entidad) throws Exception
   {
     return executeQuery (vldToken, null, -1, entidad);
   }
   
   public static VldTblSearchResults executeQuery(VldTblToken vldToken, String hierarchicalDbTableName, int parentPk, String entidad) throws Exception
   {
	   DbConnection dbConn=new DbConnection();
	   try{
	   	dbConn.open(DBSessionManager.getSession(entidad));

         VldTblSearchResults vldResults = VldMdoVldTable.executeQuery(vldToken, hierarchicalDbTableName, parentPk, entidad) ;

         return vldResults;
      }
      catch (Exception e){
         return null;
      }finally{
    	  dbConn.close();
      }
   }
   
   public static VldTblSearchResults executeQuery(VldTblToken vldToken, VldTblSearchQuery searchQuery, String entidad) throws Exception
   {
	   DbConnection dbConn=new DbConnection();
	   try{
	   	dbConn.open(DBSessionManager.getSession(entidad));

         VldTblSearchResults vldResults = VldMdoVldTable.executeQuery(vldToken,searchQuery, entidad) ;

         return vldResults;
      }
      catch (Exception e){
         return null;
      }finally{
    	  dbConn.close();
      }
   }

   public static VldTblSearchResults executeQuery(VldTblToken vldToken, VldTblSearchQuery searchQuery, String hierarchicalDbTableName, int parentPk, String entidad) throws Exception
   {
	   DbConnection dbConn=new DbConnection();
	   try{
	   	dbConn.open(DBSessionManager.getSession(entidad));

         VldTblSearchResults vldResults = VldMdoVldTable.executeQuery(vldToken, searchQuery, hierarchicalDbTableName, parentPk, entidad) ;

         return vldResults;
      }
      catch (Exception e){
         return null;
      }finally{
    	  dbConn.close();
      }
   }   
   
   public static VldTblData getValue(VldTblToken vldToken ,int pkValue, String entidad) throws Exception
   {
      
      GetValueKey key = new GetValueKey (vldToken.getVInfo ().getId (), pkValue);
      VldTblData vldData = (VldTblData) getCacheValue (key);
      if (vldData == null) 
      {
    	  DbConnection dbConn=new DbConnection();
    	  try{
    	  	dbConn.open(DBSessionManager.getSession(entidad));
	
	         vldData = VldMdoVldTable.getValue(vldToken, pkValue, entidad) ;
	
	         
	         setCacheValue (key, vldData);
	      }
	      catch (Exception e){
	         vldData = null;
	      }finally{
	    	  dbConn.close();
	      }
      }
      
      return vldData;
   }

   public static Object mapValue(int tableID ,int vldTblType, Object value,int fromMappingTo, String entidad) throws Exception
   {
      MapValueKey key = new MapValueKey (tableID, vldTblType, value, fromMappingTo);
      Object valueToReturn = getCacheValue (key);
      if (valueToReturn == null) 
      {
    	  DbConnection dbConn=new DbConnection();
    	  try{
    	  	dbConn.open(DBSessionManager.getSession(entidad));
	
	         valueToReturn = VldMdoVldTable.mapValue(tableID ,vldTblType ,value ,fromMappingTo, entidad) ;
	

	         setCacheValue (key, valueToReturn);
	      }
	      catch (Exception e){
	         //return null;
	         valueToReturn = null;
	      }finally{
	    	  dbConn.close();
	      }
      }
      return valueToReturn;
   }

   public static int getVldDataPK(int vldTblId, Object data ,boolean isDbData, String entidad) throws Exception
   {
      int pk = -1;
       
      GetVldDataPKKey key = new GetVldDataPKKey (vldTblId, data, isDbData);
      Integer iPk = (Integer) getCacheValue (key);
      if (iPk != null) {
         return iPk.intValue ();
      }
      
      DbConnection dbConn=new DbConnection();
      try{
      	dbConn.open(DBSessionManager.getSession(entidad));	

         pk = VldMdoVldTable.getVldDataPK(dbConn, vldTblId, data ,isDbData, entidad) ;
         
         setCacheValue (key, new Integer (pk));
         
         return pk;
      }
      catch (Exception e)
      {
         return -1;
      }finally{
    	  dbConn.close();
      }
   }
   
   public static boolean checkHierarchicalValidation (int parent, int child, String tableName, String entidad) throws Exception
   {
      boolean rc = false;
      
      DbConnection dbConn=new DbConnection();
      try{
      	dbConn.open(DBSessionManager.getSession(entidad));

         rc = VldMdoVldTable.checkHierarchicalValidation (parent, child, tableName, entidad);       
         
      }
      catch (Exception e)
      {
    	  throw e;
      }finally{
    	  dbConn.close();
      }
      
      return rc;
   }
   
   public static void clearCache () {
      m_cache.set (null);
   }
   
   private static Object getCacheValue (Object key) {
	   HashMap map = (HashMap) m_cache.get ();
	   Object value;
	   if (map != null)
	   {
	      value = map.get (key);
	   } 
	   else
	   {
	      value = null;
	   }

	   return value;
   }
   
   private static void setCacheValue (Object key, Object value) {
 	   HashMap map = (HashMap) m_cache.get ();

 	   if (map == null)
 	   {
 	      map = new HashMap ();
 	      m_cache.set (map);
 	   } 

 	   map.put (key, value);
    }   
   
   
   private static class GetValueKey {
      private int m_vldTblId, m_pkValue;
      
      private GetValueKey (int vldTblId, int pkValue) {
         this.m_pkValue = pkValue;
         this.m_vldTblId = vldTblId;
      }
      
      
      /* (non-Javadoc)
       * @see java.lang.Object#equals(java.lang.Object)
       */
      public boolean equals(Object obj)
      {
         if ( ! (obj instanceof GetValueKey)) {
            return false;
         }
         
         GetValueKey o2 = (GetValueKey) obj;
         
         return m_vldTblId == o2.m_vldTblId && m_pkValue == o2.m_pkValue;
      }
      
      /* (non-Javadoc)
       * @see java.lang.Object#hashCode()
       */
      public int hashCode()
      {
         return  (m_pkValue + "@" + m_vldTblId).hashCode (); 
      }
   }
   
   private static class MapValueKey {
      private int m_tableID, m_vldTblType, m_fromMappingTo;
      private Object m_value;
      
      private MapValueKey (int tableID ,int vldTblType, Object value,int fromMappingTo) {
         this.m_fromMappingTo = fromMappingTo;
         this.m_tableID = tableID;
         this.m_value = value;
         this.m_vldTblType = vldTblType;
      }
      
      /* (non-Javadoc)
       * @see java.lang.Object#equals(java.lang.Object)
       */
      public boolean equals(Object obj)
      {
         if ( ! (obj instanceof MapValueKey)) {
            return false;
         }
         
         MapValueKey o2 = (MapValueKey) obj;
         
         boolean eq = false;
         if (m_fromMappingTo == o2.m_fromMappingTo && m_tableID == o2.m_tableID && m_vldTblType == o2.m_vldTblType) 
         {
            if (m_value == null) 
            {
               if (o2.m_value == null)
               {
                  eq = true;
               }
            }
            else
            {
               eq = m_value.equals (o2.m_value);
            }
         }
         return eq;
      }
      
      /* (non-Javadoc)
       * @see java.lang.Object#hashCode()
       */
      public int hashCode()
      {
         return  (m_tableID + "@" + m_vldTblType + "@" + m_fromMappingTo + "@" + m_value).hashCode (); 
      }      
      
   }
   
   
   private static class GetVldDataPKKey {
      private int m_vldTblId;
      private Object m_data;
      private boolean m_isDbData;
      
      GetVldDataPKKey (int vldTblId, Object data ,boolean isDbData) {
         m_vldTblId = vldTblId;
         m_data = data;
         m_isDbData = isDbData;
      }
      
      /* (non-Javadoc)
       * @see java.lang.Object#equals(java.lang.Object)
       */
      public boolean equals(Object obj)
      {
         if ( ! (obj instanceof GetVldDataPKKey)) {
            return false;
         }
         
         GetVldDataPKKey o2 = (GetVldDataPKKey) obj;
         
         boolean eq = false;
         if (m_vldTblId == o2.m_vldTblId && m_isDbData == o2.m_isDbData) 
         {
            if (m_data == null) 
            {
               if (o2.m_data == null)
               {
                  eq = true;
               }
            }
            else
            {
               eq = m_data.equals (o2.m_data);
            }
         }
         return eq;
      }
      
      /* (non-Javadoc)
       * @see java.lang.Object#hashCode()
       */
      public int hashCode()
      {
         return  (m_vldTblId + "@" + m_isDbData + "@" + m_data).hashCode (); 
      }   
   }
   
} // class
