package ieci.tecdoc.sbo.idoc.vldtable.std;

import ieci.tecdoc.core.db.DBSessionManager;
import ieci.tecdoc.core.dyndao.DynDaoRs;
import ieci.tecdoc.core.dyndao.DynDaoRec;

import ieci.tecdoc.core.search.SearchOpr;
import ieci.tecdoc.sbo.idoc.vldtable.base.*;
import ieci.tecdoc.sgm.base.dbex.DbConnection;

import java.util.ArrayList;
import org.apache.log4j.Logger;

public class VldMdoVldTable
{

   private static Logger logger = Logger.getLogger(VldMdoVldTable.class);

   private VldMdoVldTable()
   {
   }

   // TODO Podr�a sobrar este m�todo, s�lo se le llama desde el VldBnoManagerEx
   public static VldTblSearchResults executeQuery(VldTblToken vldToken, String entidad)
            throws Exception
   {
      return executeQuery(vldToken, null, -1, entidad);
   }

   public static VldTblSearchResults executeQuery(VldTblToken vldToken,
            String hierarchicalDbTableName, int parentPk, String entidad) throws Exception
   {
      VldTblSearchResults searchResults = new VldTblSearchResults();
      DynDaoRec record = null;

      /*
       * Del vldToken saco la informacion de la tabla especifica obtengo los
       * campos y los formatos recubro la tabla dinamica y llamo
       * 
       * Relleno el array de resultados con las pk's devuelvo
       *  
       */
      VldDaoVTblCtlgData vldtblData = new VldDaoVTblCtlgData();

      if (parentPk != -1)
      {
         String aux = vldToken.getVInfo().restoreInfo().getWhere();
         StringBuffer where = new StringBuffer(aux == null ? "" : aux.trim());
         if (where.length() > 0)
         {
            where.append(" AND ");
         }
         where.append(" IDOCID IN (SELECT ");
         where.append(hierarchicalDbTableName);
         where.append(".IDOCCHILDKEY FROM ");
         where.append(hierarchicalDbTableName);
         where.append(" WHERE ");
         where.append(hierarchicalDbTableName);
         where.append(".IDOCPARENTKEY = ");
         where.append(parentPk);
         where.append(")");
         vldtblData.setDefaultQual(where.toString());
      }
      else
         vldtblData.setDefaultQual(vldToken.getVInfo().restoreInfo().getWhere());

      vldtblData.setOrderBy(vldToken.getVInfo().restoreInfo().getOrdeyBy());

      vldtblData.createColsDef(vldToken.getBInfo().getInfo(),
               vldToken.getBInfo().getName());
      if (logger.isDebugEnabled())
               logger.debug("vldToken.getBInfo().getInfo()  : "
                        + vldToken.getBInfo().getInfo() + "  |  "
                        + vldToken.getBInfo().getName());

      DynDaoRs resultSet = vldtblData.selectData(entidad);

      String primaryKeyColName = vldToken.getVInfo().restoreInfo().getPkColName();
      if (logger.isDebugEnabled())
               logger.debug("primaryKeyColName  : " + primaryKeyColName);

      for (int i = 0; i < resultSet.count(); i++)
      {

         record = resultSet.getRecord(i);
         searchResults.addtVldTblSearchResult(record.getColData(primaryKeyColName));

      }
      return searchResults;
   }


   public static VldTblSearchResults executeQuery(VldTblToken vldToken,
            VldTblSearchQuery searchQuery, String entidad) throws Exception
   {

      VldTblSearchResults searchResults = new VldTblSearchResults();
      DynDaoRs resultSet = null;

      /*
       * Del vldToken saco la informacion de la tabla especifica obtengo los
       * campos y los formatos recubro la tabla dinamica y llamo
       * 
       * Relleno el array de resultados con las pk's devuelvo
       *  
       */
      DbConnection dbConn=new DbConnection();
      try{
      	  dbConn.open(DBSessionManager.getSession(entidad));
	      VldDaoVTblCtlgData vldtblData = new VldDaoVTblCtlgData();
	
	      vldtblData.createColsDef(vldToken.getBInfo().getInfo(),
	               vldToken.getBInfo().getName());
	      if (logger.isDebugEnabled())
	               logger.debug("searchQuery.getSqlQual()  : "
	                        + searchQuery.getSqlQual(dbConn.getEngine()));
	
	      resultSet = vldtblData.selectByVal(searchQuery.getSqlQual(dbConn.getEngine()), entidad);
	
	      String primaryKeyColName = vldToken.getVInfo().restoreInfo().getPkColName();
	      if (logger.isDebugEnabled())
	               logger.debug("primaryKeyColName  : " + primaryKeyColName);
	
	      for (int i = 0; i < resultSet.count(); i++)
	      {
	
	         DynDaoRec record = resultSet.getRecord(i);
	         searchResults.addtVldTblSearchResult(record.getColData(primaryKeyColName));
	
	      }
      }catch (Exception e) {
	    	  throw e;
		}finally{
			dbConn.close();
		}
      return searchResults;
   }

   public static VldTblSearchResults executeQuery(VldTblToken vldToken, VldTblSearchQuery searchQuery,
            String hierarchicalDbTableName, int parentPk, String entidad)
            throws Exception
   {
      VldTblSearchResults searchResults = new VldTblSearchResults();
      DynDaoRec record = null;
      StringBuffer where = new StringBuffer ();

      /*
       * Del vldToken saco la informacion de la tabla especifica obtengo los
       * campos y los formatos recubro la tabla dinamica y llamo
       * 
       * Relleno el array de resultados con las pk's devuelvo
       *  
       */
      VldDaoVTblCtlgData vldtblData = new VldDaoVTblCtlgData();

      if (parentPk != -1)
      {
         String aux = vldToken.getVInfo().restoreInfo().getWhere();
         //where = new StringBuffer(" AND ");
         where = new StringBuffer("");
         if (aux != null && aux.trim().length() > 0)
         {
            where.append(aux.trim());       
            where.append(" AND ");
         }
         
         where.append(" IDOCID IN (SELECT ");
         where.append(hierarchicalDbTableName);
         where.append(".IDOCCHILDKEY FROM ");
         where.append(hierarchicalDbTableName);
         where.append(" WHERE ");
         where.append(hierarchicalDbTableName);
         where.append(".IDOCPARENTKEY = ");
         where.append(parentPk);
         where.append(")");                 
         vldtblData.setDefaultQual(where.toString());
      }
      else
         vldtblData.setDefaultQual(vldToken.getVInfo().restoreInfo().getWhere());

      vldtblData.setOrderBy(vldToken.getVInfo().restoreInfo().getOrdeyBy());

      vldtblData.createColsDef(vldToken.getBInfo().getInfo(),
               vldToken.getBInfo().getName());
      if (logger.isDebugEnabled())
               logger.debug("vldToken.getBInfo().getInfo()  : "
                        + vldToken.getBInfo().getInfo() + "  |  "
                        + vldToken.getBInfo().getName());

      //DynDaoRs resultSet = vldtblData.selectData();
      DbConnection dbConn=new DbConnection();
      DynDaoRs  resultSet=null;
      try{
      	dbConn.open(DBSessionManager.getSession(entidad));
      	resultSet = vldtblData.selectByVal(searchQuery.getSqlQual(dbConn.getEngine()), entidad);
      }catch (Exception e) {
    	  throw e;
	  }finally{
		  dbConn.close();
	  }
      String primaryKeyColName = vldToken.getVInfo().restoreInfo().getPkColName();
      if (logger.isDebugEnabled())
               logger.debug("primaryKeyColName  : " + primaryKeyColName);

      for (int i = 0; i < resultSet.count(); i++)
      {

         record = resultSet.getRecord(i);
         searchResults.addtVldTblSearchResult(record.getColData(primaryKeyColName));

      }
      return searchResults;
   }
   
   
   public static VldTblData getValue(VldTblToken vldToken, int pkValue, String entidad)
            throws Exception
   {
      VldTblData dataResult = null;

      /*
       * Del vldToken saco la informacion de la tabla especifica obtengo los
       * campos y los formatos recubro la tabla dinamica y llamo
       * 
       * Relleno el array de resultados con las pk's devuelvo
       *  
       */
      String primaryKeyColName = vldToken.getVInfo().restoreInfo().getPkColName();
      VldDaoVTblCtlgData vldtblData = new VldDaoVTblCtlgData();

      vldtblData.createColsDef(vldToken.getBInfo().getInfo(),
               vldToken.getBInfo().getName());
      vldtblData.setPkColName(primaryKeyColName);

      DynDaoRec record = vldtblData.selectDataByPk(pkValue, entidad);

      int tableType = vldToken.getVInfo().getType();

      if (logger.isDebugEnabled())
               logger.debug("primaryKeyColName | tableType : "
                        + primaryKeyColName + " | " + tableType);

      VldTblVInfo vInfo = vldToken.getVInfo().restoreInfo();

      VldTblData vldData = null;

      switch (tableType)
      {
         case VldTblUtil.VLD_TBL_SIMPLE:
            VldTblDataSimple vldDataSimple = new VldTblDataSimple();
            vldDataSimple.setPkValue(pkValue);
            VldTblVInfoSimple vInfoSimple = (VldTblVInfoSimple) vInfo;
            vldDataSimple.setColValue(record.getColData(vInfoSimple.getDocColName()));
            vldData = vldDataSimple;
            break;
         case VldTblUtil.VLD_TBL_SUST:
            VldTblDataSust vldDataSust = new VldTblDataSust();
            vldDataSust.setPkValue(pkValue);
            VldTblVInfoSust vInfoSust = (VldTblVInfoSust) vInfo;
            vldDataSust.setColValue(record.getColData(vInfoSust.getDocColName()));
            vldDataSust.setSustColValue(record.getColData(vInfoSust.getSustDocColName()));
            vldData = vldDataSust;
            break;
         case VldTblUtil.VLD_TBL_ID:
            VldTblDataId vldDataId = new VldTblDataId();
            vldDataId.setPkValue(pkValue);
            VldTblVInfoID vInfoId = (VldTblVInfoID) vInfo;
            vldDataId.setColValue(record.getColData(vInfoId.getDocColName()));
            vldDataId.setUserColValue(record.getColData(vInfoId.getUserColName()));
            vldData = vldDataId;
            break;
      }
      if (logger.isDebugEnabled()) logger.debug("vldData : " + vldData);

      return vldData;

   }

   public static VldTblToken loadValidationTable(DbConnection dbConn, int vldTblId) throws Exception
   {
      VldTblTokenVInfo vInfo = loadVTblInfo(dbConn, vldTblId);
      VldTblTokenBInfo bInfo = loadBTblInfo(dbConn, vInfo.getBTblId());

      VldTblToken vldToken = new VldTblToken(bInfo, vInfo);

      return vldToken;

   }

   public static Object mapValue(int tableID, int vldTblType, Object value,
            int fromMappingTo, String entidad) throws Exception
   {
      Object returnValue = null;
      DynDaoRs resultSet = null;
      VldTblToken vldToken = null;
      VldDaoVTblCtlgData vldtblData = null;
      ArrayList vals = null;
      VldTblSearchCondition searchCondition = null;
      VldTblSearchQuery searchQuery = null;
      String whereColName = null;
      String qual = null;

      DbConnection dbConn=new DbConnection();
      try{
      	 dbConn.open(DBSessionManager.getSession(entidad));
         vldToken = loadValidationTable(dbConn, tableID);
         vldtblData = new VldDaoVTblCtlgData();

         vldtblData.createColsDef(vldToken.getBInfo().getInfo(),
                  vldToken.getBInfo().getName());

         vals = new ArrayList();
         vals.add(value);

         whereColName = generateWhereColName(vldToken, fromMappingTo);
         searchCondition = new VldTblSearchCondition(vldToken, whereColName,
                  SearchOpr.EQUAL, vals);
         searchQuery = new VldTblSearchQuery();
         searchQuery.setSearchCondition(searchCondition);
         qual = searchQuery.getSqlQual(dbConn.getEngine());

         resultSet = vldtblData.selectByVal(qual, entidad);
         for (int i = 0; i < resultSet.count(); i++)
         {
            DynDaoRec record = resultSet.getRecord(i);
            returnValue = record.getColData(generateReturnColName(vldToken,
                     vldTblType, fromMappingTo));
         }
      }
      catch (Exception e)
      {
         return null;
      }finally{
    	  dbConn.close();
      }
      return returnValue;
   }

   private static String generateWhereColName(VldTblToken vldToken,
            int fromMappingTo) throws Exception
   {
      VldTblTokenVInfo vInfo = vldToken.getVInfo();
      int vldType = vInfo.getType();
      boolean isDbColWhere = true;
      String colName = null;

      if (vldType == VldTblUtil.VLD_TBL_SIMPLE)
      {
         isDbColWhere = true;
      }
      else
      {
         if (fromMappingTo == VldTblUtil.MAP_FROM_VALUE_TO_SUST)
            isDbColWhere = true;
         else if (fromMappingTo == VldTblUtil.MAP_FROM_SUST_TO_VALUE)
            isDbColWhere = false;
         else if (fromMappingTo == VldTblUtil.MAP_FROM_ID_TO_VALUE)
            isDbColWhere = true;
         else if (fromMappingTo == VldTblUtil.MAP_FROM_VALUE_TO_ID)
                  isDbColWhere = false;
      }

      colName = getDataColName(vInfo, isDbColWhere);

      return colName;
   }

   private static String generateReturnColName(VldTblToken vldToken,
            int tableType, int fromMappingTo) throws Exception
   {
      switch (tableType)
      {
         case VldTblUtil.VLD_TBL_SIMPLE:
            return vldToken.getVInfo().restoreInfo().getPkColName();
         case VldTblUtil.VLD_TBL_SUST:
            if (fromMappingTo == VldTblUtil.MAP_FROM_VALUE_TO_SUST)
            {
               return ((VldTblVInfoSust) vldToken.getVInfo().restoreInfo()).getSustDocColName();
            }
            else if (fromMappingTo == VldTblUtil.MAP_FROM_SUST_TO_VALUE) { return ((VldTblVInfoSust) vldToken.getVInfo().restoreInfo()).getDocColName(); }
         case VldTblUtil.VLD_TBL_ID:
            if (fromMappingTo == VldTblUtil.MAP_FROM_ID_TO_VALUE)
            {
               return ((VldTblVInfoID) vldToken.getVInfo().restoreInfo()).getUserColName();
            }
            else if (fromMappingTo == VldTblUtil.MAP_FROM_VALUE_TO_ID) { return ((VldTblVInfoID) vldToken.getVInfo().restoreInfo()).getDocColName(); }
      }
      return null;
   }

   /**
    * @param vldTblId
    * @param vldTblType
    * @param data
    * @param isDbData
    * @return
    */
   public static int getVldDataPK(DbConnection dbConn, int vldTblId, Object data, boolean isDbData, String entidad)
            throws Exception
   {
      String colName = null;
      VldTblToken token = null;
      VldTblSearchQuery query = null;
      VldTblSearchCondition condition = null;
      VldTblSearchResults rs = null;
      int pk = -1;

      token = loadValidationTable(dbConn, vldTblId);

      colName = getDataColName(token.getVInfo(), isDbData);

      query = new VldTblSearchQuery();
      condition = new VldTblSearchCondition(token, colName, SearchOpr.EQUAL,
               data);

      query.setSearchCondition(condition);

      rs = executeQuery(token, query, entidad);

      if (rs.count() == 0)
         pk = -1;
      else
         pk = ((Number) rs.getVldTblSearchResults().get(0)).intValue();

      //query.
      return pk;
   }

   private static VldTblTokenBInfo loadBTblInfo(DbConnection dbConn, int bTblId) throws Exception
   {
      VldTblTokenBInfo bInfo = null;
      VldDaoBTblCtlgRecA daoBRecA = VldDaoBTblCtlgTbl.selectRow(dbConn, bTblId);

      bInfo = new VldTblTokenBInfo(daoBRecA.m_def, daoBRecA.m_name);

      return bInfo;

   }

   private static VldTblTokenVInfo loadVTblInfo(DbConnection dbConn, int vTblId) throws Exception
   {
      VldTblTokenVInfo vInfo = null;
      VldDaoVTblCtglRecA daoVRec = VldDaoVTblCtlgTbl.selectRow(dbConn, vTblId);

      vInfo = new VldTblTokenVInfo(daoVRec.m_info, daoVRec.m_type,
               daoVRec.m_name, vTblId, daoVRec.m_btblId);

      return vInfo;

   }

   private static String getDataColName(VldTblTokenVInfo vInfo,
            boolean isDbColWhere) throws Exception
   {
      VldTblVInfoSust vInfoSust = null;
      VldTblVInfoID vInfoId = null;
      String colName = null;
      int vldTblType = vInfo.getType();

      switch (vldTblType)
      {
         case VldTblUtil.VLD_TBL_SIMPLE:

            colName = vInfo.restoreInfo().getDocColName();
            break;

         case VldTblUtil.VLD_TBL_SUST:

            vInfoSust = (VldTblVInfoSust) vInfo.restoreInfo();

            if (isDbColWhere)
            {
               colName = vInfoSust.getDocColName();
            }
            else
            {
               colName = vInfoSust.getSustDocColName();
            }

            break;

         case VldTblUtil.VLD_TBL_ID:

            vInfoId = (VldTblVInfoID) vInfo.restoreInfo();

            if (isDbColWhere)
            {
               colName = vInfoId.getDocColName();
            }
            else
            {
               colName = vInfoId.getUserColName();
            }

            break;

      }
      return colName;
   }

   
   public static boolean checkHierarchicalValidation (int parent, int child, String tableName, String entidad) throws Exception
   {
      boolean rc = false;
      
      VldDaoHierarchicalVldTbl vldDaoHierarchicalVldTbl = new VldDaoHierarchicalVldTbl (tableName);
      rc = vldDaoHierarchicalVldTbl.existRow (parent, child, entidad);
      
      return rc;
   }
   
} // class
