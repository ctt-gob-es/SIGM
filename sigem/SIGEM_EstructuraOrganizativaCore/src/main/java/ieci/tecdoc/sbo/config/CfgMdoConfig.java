
package ieci.tecdoc.sbo.config;

import ieci.tecdoc.core.db.DbConnectionConfig;
import ieci.tecdoc.sgm.base.dbex.DbConnection;

public final class CfgMdoConfig
{	

   private static final String IECI_DB_CFG_FILE_NAME = "IeciTd_DbConn_Cfg.xml";

   public CfgMdoConfig()
   {
   }

   //Debe existir una conexi�n a base de datos abierta

   
   public CfgLdapConfig loadDbLdapCfg(DbConnection dbConn) throws Exception
   {
      
      String        misc;
      CfgDbInfoMisc infoMisc = null;
      CfgDaoDbInfoTbl cfgDaoInfo=new CfgDaoDbInfoTbl();
      
      misc = cfgDaoInfo.selectMisc(dbConn);
      
      infoMisc = new CfgDbInfoMisc();
     
      infoMisc.restore(misc);
     
      return infoMisc.getLdapConfig();          
            
   } 
   
   public static DbConnectionConfig getDbConfig()throws Exception
   {
      DbConnectionConfig cfg = null;

      cfg =  CfgMdoDbConn.createConfigFromFile(IECI_DB_CFG_FILE_NAME);
      
      return cfg;   

   }

   public static DbConnectionConfig getDbConfig(String configDir)throws Exception
   {
      DbConnectionConfig cfg = null;

      cfg =  CfgMdoDbConn.createConfigFromFile(configDir, IECI_DB_CFG_FILE_NAME);
      
      return cfg;   

   }
   
   //Debe existir una conexi�n a base de datos abierta
   public static String getDbInfoName(DbConnection dbConn)throws Exception
   {

      String  name;
      CfgDaoDbInfoTbl cfgDaoInfo=new CfgDaoDbInfoTbl();   
      name =  cfgDaoInfo.selectName(dbConn);

      return name;       

   }
   
   //Debe existir una conexi�n a base de datos abierta
   public static CfgDbInfoMisc loadDbInfoMisc(DbConnection dbConn) throws Exception
   {
      String misc;
      CfgDbInfoMisc infoMisc = null;
      CfgDaoDbInfoTbl cfgDaoInfo=new CfgDaoDbInfoTbl();   
      misc = cfgDaoInfo.selectMisc(dbConn);
      
      infoMisc = new CfgDbInfoMisc();
      
      infoMisc.restore(misc);
      
      return infoMisc;
   }

   //Debe existir una conexi�n a base de datos abierta
   public static CfgFtsConfig loadDbFtsCfg(DbConnection dbConn) throws Exception
   {
      
      String        misc;
      CfgDbInfoMisc infoMisc = null;
      CfgDaoDbInfoTbl cfgDaoInfo=new CfgDaoDbInfoTbl();   
      misc = cfgDaoInfo.selectMisc(dbConn);
      
      infoMisc = new CfgDbInfoMisc(); 
     
      return infoMisc.restoreFtsInfo(misc);          
            
   } 
   
   public static void storeDbInfoMisc(CfgDbInfoMisc InfoMisc, DbConnection dbConn) throws Exception
   {
      String misc;
      
      misc = InfoMisc.persist();
      CfgDaoDbInfoTbl cfgDaoInfo=new CfgDaoDbInfoTbl();   
      CfgDaoDbInfoTbl.updateMisc(dbConn, misc);
   }
   
} // class
