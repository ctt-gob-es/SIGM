
package ieci.tecdoc.idoc.admin.internal;

import ieci.tecdoc.core.db.DbConnection;
import ieci.tecdoc.core.db.DbSelectFns;
import ieci.tecdoc.core.db.DbUpdateFns;
import ieci.tecdoc.core.db.DbUtil;
import ieci.tecdoc.core.ldap.LdapConnection;
import ieci.tecdoc.idoc.admin.api.ObjFactory;
import ieci.tecdoc.idoc.admin.api.system.SystemCfg;
import ieci.tecdoc.idoc.admin.api.user.User;
import ieci.tecdoc.idoc.admin.database.ArchivesTable;
import ieci.tecdoc.sbo.acs.std.AcsDaoGenPermTbl;
import ieci.tecdoc.sbo.acs.std.AcsDaoObjHdrTbl;
import ieci.tecdoc.sbo.acs.std.AcsDaoObjPermTbl;
import ieci.tecdoc.sbo.acs.std.AcsDaoUserTypeTbl;
import ieci.tecdoc.sbo.config.CfgDaoDbInfoTbl;
import ieci.tecdoc.sbo.config.CfgDbInfoMisc;
import ieci.tecdoc.sbo.config.CfgFtsConfig;
import ieci.tecdoc.sbo.config.CfgLdapConfig;
import ieci.tecdoc.sbo.config.CfgMdoConfig;
import ieci.tecdoc.sbo.fss.core.FssDaoActDirTbl;
import ieci.tecdoc.sbo.fss.core.FssDaoFileTbl;
import ieci.tecdoc.sbo.fss.core.FssDaoFtsTbl;
import ieci.tecdoc.sbo.fss.core.FssDaoListTbl;
import ieci.tecdoc.sbo.fss.core.FssDaoListVolTbl;
import ieci.tecdoc.sbo.fss.core.FssDaoNextIdTbl;
import ieci.tecdoc.sbo.fss.core.FssDaoRepTbl;
import ieci.tecdoc.sbo.fss.core.FssDaoVolTbl;
import ieci.tecdoc.sbo.idoc.dao.DaoAppEventTbl;
import ieci.tecdoc.sbo.idoc.dao.DaoArchDetTbl;
import ieci.tecdoc.sbo.idoc.dao.DaoArchHdrTbl;
import ieci.tecdoc.sbo.idoc.dao.DaoArchListTbl;
import ieci.tecdoc.sbo.idoc.dao.DaoAutoNumCtlgTbl;
import ieci.tecdoc.sbo.idoc.dao.DaoCompUsgTbl;
import ieci.tecdoc.sbo.idoc.dao.DaoDATNodeTbl;
import ieci.tecdoc.sbo.idoc.dao.DaoDbCtlgTbl;
import ieci.tecdoc.sbo.idoc.dao.DaoDefFmtTbl;
import ieci.tecdoc.sbo.idoc.dao.DaoDirTbl;
import ieci.tecdoc.sbo.idoc.dao.DaoFdrLinkTbl;
import ieci.tecdoc.sbo.idoc.dao.DaoFdrStatTbl;
import ieci.tecdoc.sbo.idoc.dao.DaoFiauxTblCtlg;
import ieci.tecdoc.sbo.idoc.dao.DaoFmtTbl;
import ieci.tecdoc.sbo.idoc.dao.DaoGlbDocHTbl;
import ieci.tecdoc.sbo.idoc.dao.DaoMacroTbl;
import ieci.tecdoc.sbo.idoc.dao.DaoNextIdTbl;
import ieci.tecdoc.sbo.idoc.dao.DaoPageAnnsTbl;
import ieci.tecdoc.sbo.idoc.dao.DaoPictTbl;
import ieci.tecdoc.sbo.idoc.dao.DaoPrefWFmtTbl;
import ieci.tecdoc.sbo.idoc.dao.DaoRptAuxTbl;
import ieci.tecdoc.sbo.idoc.dao.DaoRptTbl;
import ieci.tecdoc.sbo.idoc.dao.DaoSSNextIdTbl;
import ieci.tecdoc.sbo.idoc.dao.DaoSrvStateDetTbl;
import ieci.tecdoc.sbo.idoc.dao.DaoSrvStateHdrTbl;
import ieci.tecdoc.sbo.idoc.dao.DaoWMacroTbl;
import ieci.tecdoc.sbo.idoc.dao.DaoXNextIdTbl;
import ieci.tecdoc.sbo.idoc.vldtable.std.VldDaoBTblCtlgTbl;
import ieci.tecdoc.sbo.idoc.vldtable.std.VldDaoVTblCtlgTbl;
import ieci.tecdoc.sbo.sms.core.SmsDaoSessNextIdTbl;
import ieci.tecdoc.sbo.sms.core.SmsDaoSessTbl;
import ieci.tecdoc.sbo.uas.ldap.UasDaoLdapGroupTbl;
import ieci.tecdoc.sbo.uas.ldap.UasDaoLdapUserTbl;
import ieci.tecdoc.sbo.uas.std.UasDaoCurrCntTbl;
import ieci.tecdoc.sbo.uas.std.UasDaoDeptTbl;
import ieci.tecdoc.sbo.uas.std.UasDaoGURelTbl;
import ieci.tecdoc.sbo.uas.std.UasDaoGroupTbl;
import ieci.tecdoc.sbo.uas.std.UasDaoLicencesTbl;
import ieci.tecdoc.sbo.uas.std.UasDaoNextIdTbl;
import ieci.tecdoc.sbo.uas.std.UasDaoPwdsTbl;
import ieci.tecdoc.sbo.uas.std.UasDaoRemUserTbl;
import ieci.tecdoc.sbo.uas.std.UasDaoSysTbl;
import ieci.tecdoc.sbo.uas.std.UasDaoUserMapTbl;
import ieci.tecdoc.sbo.uas.std.UasDaoUserTbl;

import org.apache.log4j.Logger;
/**
 * Representa Informaci�n del sistema
 */
public class SystemCfgImpl implements SystemCfg
{
   
   private String drvClsName;
   private String url;
   private String user;
   private String pwd;
   private boolean isDefaultBDConnection = true;
   
   private CfgDbInfoMisc infoMisc;
   
   public SystemCfgImpl(String drvClsName,String url, String user, String pwd)
   {
       this.drvClsName = drvClsName;
       this.url = url;
       this.user = user;
       this.pwd = pwd ;
       isDefaultBDConnection = false;
       
   }
   
   public SystemCfgImpl(){
       
   }
   
   public void ldapConnectionTest() throws Exception
   {
       CfgLdapConfig ldapConfig = new CfgLdapConfig ();
       LdapConnection ldapConn = new LdapConnection();
   }

   public CfgLdapConfig getLdapConfig()throws Exception
   {
       CfgLdapConfig ldapConfig = null;
       if (this.infoMisc == null ) // A�n no est� inicializada
       {
           try{
               connectDataBase();
               infoMisc = CfgMdoConfig.loadDbInfoMisc();
               
               ldapConfig = infoMisc.getLdapConfig();    
	       }catch (Exception e){
	           throw e;
	       }
           finally {
               closeDataBase();    
           }
       }
       else
           ldapConfig = infoMisc.getLdapConfig();
       return ldapConfig;
       
   }
   
   public void updateMisc() throws Exception{
       if (infoMisc != null ){ // Se supone que se ha cargado la informaci�n antes.. pero bueno x si acaso.
           
           if (_logger.isDebugEnabled())
               _logger.debug("update");
           
           try{
               connectDataBase();
               // infoMisc = CfgMdoConfig.loadDbInfoMisc();
               //cfgFtsConfig = infoMisc.getFtsConfig();
               CfgMdoConfig.storeDbInfoMisc(infoMisc);
           }catch (Exception e){
               throw e;
           }
           finally {
               closeDataBase();    
           }
           
           
       }
   }
   public CfgFtsConfig getFtsConfig() throws Exception
   {
       CfgFtsConfig cfgFtsConfig = null;
       if (this.infoMisc == null ) // A�n no est� inicializada
       {
           try{
               connectDataBase();
               infoMisc = CfgMdoConfig.loadDbInfoMisc();
               cfgFtsConfig = infoMisc.getFtsConfig();
           }catch (Exception e){
               throw e;
           }
           finally {
               closeDataBase();    
           }
       }
       else
           cfgFtsConfig = infoMisc.getFtsConfig();
       
       return cfgFtsConfig;
   }
   
   /**
    * Abre la conexi�n a la base de datos, usando los siguientes par�metros
    * @param drvClsName Driver jdbc
    * @param url Cadena de conexi�n
    * @param user Nombre de usuario
    * @param pwd Contrase�a
    * @throws Exception
    */
   public void connectDataBase()throws Exception{
        try
        {
            if (isDefaultBDConnection)
                DbConnection.open(CfgMdoConfig.getDbConfig());
            else
                DbConnection.open(drvClsName,url,user,pwd);
        }
        catch(Exception e)
        {
           _logger.error(e);
           throw e;
        }
   }
   /**
    * Cierra la conexi�n a la Base de datos
    * @throws Exception Si se produce alg�n error
    */
   public void closeDataBase()throws Exception{
       if (_logger.isDebugEnabled()){
           _logger.debug("close DataBase");
       }
       try{
           DbConnection.close();    
       }
       catch (Exception e){
           _logger.error(e);
           throw e;
       }
        
   }
   
   /**
    * Determina si el SYSSUPERUSER est� bloqueado o no
    * @return true si SYSSUPERUSER est� bloqueado
    */
   public boolean isLockSyssuperuser()
   {
       boolean isLockSyssuperuser = false;
       try {
           String qual = "WHERE " + UasDaoUserTbl.CD_ID.getName() + " =0";
           int stat = DbSelectFns.selectLongInteger("IUSERUSERHDR","STAT",qual);
           if (stat > 0)
               isLockSyssuperuser = true;
       }catch (Exception e){
           _logger.debug(e);
       }
       return isLockSyssuperuser;
   }
   
   /**
    *  Inicializa el sistema invesDoc
    * 
    * @throws Exception Errores en la inicializaci�n
    */
   public void initDataBase() throws Exception
   {
      if (_logger.isDebugEnabled())
         _logger.debug("initDataBase");
                  
      try
      {
          if (isDefaultBDConnection)
              DbConnection.open(CfgMdoConfig.getDbConfig());
          else
              DbConnection.open(drvClsName,url,user,pwd);
         
         setupDocDb();
         setupUserDb();
         setupVolDb();         
      }
      catch(Exception e)
      {
         _logger.error(e);
         throw e;
      }
      finally
      {
         DbConnection.close();
      }      
   }
      
   /**
    * Obtiene si existe o no configuraci�n de motor documental
    * 
    * @return  true / false
    * @throws Exception
    */
   public boolean hasFtsConfig() throws Exception
   {
      boolean      has = false;
      CfgFtsConfig config;
      
      if (_logger.isDebugEnabled())
         _logger.debug("hasDbFtsConfig");
                  
      try
      {         
          if (isDefaultBDConnection)
              DbConnection.open(CfgMdoConfig.getDbConfig());
          else
              DbConnection.open(drvClsName,url,user,pwd);       
         
         config = CfgMdoConfig.loadDbFtsCfg(); 
         
         //HAY que controlar que el motor documental corresponde con la BD
         if (config.m_engine > 0)
            has = true;
      }
      catch(Exception e)
      {
         _logger.error(e);
         throw e;
      }
      finally
      {
         DbConnection.close();
      }      
      
      return has;
      
   }
   
   /**
    * Obtiene el nombre del sistema
    * @return Dicho nombre
    */
   public String getRootNameArchs() throws Exception
   {
      String rootName;
      
      if (_logger.isDebugEnabled())
         _logger.debug("getRootNameArchs");
                  
      try
      {         
          if (isDefaultBDConnection)
              DbConnection.open(CfgMdoConfig.getDbConfig());
          else
              DbConnection.open(drvClsName,url,user,pwd);       
         
         rootName = DbSelectFns.selectShortText(ArchivesTable.TN_IDOCDBINFO,
                                                ArchivesTable.CN_NAME,"");         
         
      }
      catch(Exception e)
      {
         _logger.error(e);
         throw e;
      }
      finally
      {
         DbConnection.close();
      }      
      
      return rootName;
   }
   
   public void setRootNameArchs(String root) throws Exception
   {
       try
       {         
           if (isDefaultBDConnection)
               DbConnection.open(CfgMdoConfig.getDbConfig());
           else
               DbConnection.open(drvClsName,url,user,pwd);       
           String stmtText = "UPDATE " + ArchivesTable.TN_IDOCDBINFO +" SET " +ArchivesTable.CN_NAME +" = '" + root + "'";
           DbUtil.executeStatement(stmtText);
          // rootName = DbSelectFns.selectShortText(ArchivesTable.TN_IDOCDBINFO,
                                                 //ArchivesTable.CN_NAME,"");         
          
       }
       catch(Exception e)
       {
          _logger.error(e);
          throw e;
       }
       finally
       {
          DbConnection.close();
       }
       
   }
   
   /**
    * Desbloquea el SYSSUPERUSER.
    * Se necesita una Conexi�n a BD abierta
    * @throws Exception Si se produce alg�n error
    */
   public void unLockSyssuperuser() throws Exception
   {
       /* Modificada para que no abra la bd con los valores de los ficheros de configuraci�n */
      int    colValue;
      String qual;
      
      try
      {
         colValue = 0;
         qual = "WHERE " + UasDaoUserTbl.CD_ID.getName() + " =0";
       
         DbUpdateFns.updateLongInteger(UasDaoUserTbl.TN,UasDaoUserTbl.CD_STAT.getName(),colValue,qual);
      }
      catch(Exception e)
      {
         _logger.error(e);
         throw e;
      }
   }
      
   //***************************************************************************
   

   /**
    * Inicializa las tablas principales de W@rda. Se necesita una conexi�n abierta a BD
    * @throws Exception Si se produce alg�n error en la creaci�n
    */
   public void setupDocDb() throws Exception
   {
      boolean commit = false;
		boolean inTrans = false;
		
		if (_logger.isDebugEnabled())
			_logger.debug("setupDocDb");
		
      try
      {
         /// crear tablas del sistema invesDoc
         createDocTbls();
         DbConnection.beginTransaction();
         inTrans = true;
         // realizar inicializaci�n de tablas
         initializeDocTbls();
         commit = true;
         
      }
      catch(Exception e)
      {
         _logger.error(e);
			throw e;
      }
      finally
      {
         if (inTrans)
            DbConnection.endTransaction(commit);
      }
   }
   
   /**
    * Inicializa las tablas de usuarios de W@rda. Se necesita una conexi�n abierta a BD
    * @throws Exception Si se produce alg�n error en la creaci�n
    */
   public void setupUserDb() throws Exception
   {
      boolean commit = false;
		boolean inTrans = false;
		
		if (_logger.isDebugEnabled())
			_logger.debug("setupUserDb");
		
      try
      {
         //crear tablas de usuario
         createUserTbls();
         DbConnection.beginTransaction();
         inTrans = true;
         // realizar inicializaci�n de tablas
         initializeUserTbls();
         commit = true;
      }
      catch(Exception e)
      {
         _logger.error(e);
         throw e;
      }
      finally
      {
         if (inTrans)
            DbConnection.endTransaction(commit);
      }
   }

   /**
    * Inicializa las tablas de vol�menes de W@rda. Se necesita una conexi�n abierta a BD
    * @throws Exception Si se produce alg�n error en la creaci�n
    */
   public void setupVolDb() throws Exception
   {
      boolean commit = false;
		boolean inTrans = false;
		
		if (_logger.isDebugEnabled())
			_logger.debug("setupVolDb");
		
      try
      {
         // crear tablas de vol�menes
         createVolTbls();
         DbConnection.beginTransaction();
         inTrans = true;
         // realizar inicializaci�n de tablas de vol�menes
         initializeVolTbls();
         commit = true;         
      }
      catch(Exception e)
      {
         _logger.error(e);
         throw e;
      }
      finally
      {
         if (inTrans)
            DbConnection.endTransaction(commit);
      }
   }
   

   private void initializeDocTbls() throws Exception
   {
      DaoNextIdTbl.initTblContentsNextId();
      CfgDaoDbInfoTbl.initTblContentsDbInfo();
      DaoSSNextIdTbl.initTblContentsSSNextId();
      SmsDaoSessNextIdTbl.initTblContentsNextId();
   }	
   
   
   private void createDocTbls() throws Exception
   {
      
      DaoNextIdTbl.createTable();
      DaoXNextIdTbl.createTable();  
      CfgDaoDbInfoTbl.createTable();      
      DaoDbCtlgTbl.createTable();     
      DaoDirTbl.createTable();
      DaoDATNodeTbl.createTable();
      DaoArchHdrTbl.createTable();
      DaoArchDetTbl.createTable();
      DaoFmtTbl.createTable();
      DaoDefFmtTbl.createTable();
      DaoPageAnnsTbl.createTable();
      DaoCompUsgTbl.createTable();
      VldDaoBTblCtlgTbl.createTable();
      VldDaoVTblCtlgTbl.createTable();
      DaoMacroTbl.createTable();
      DaoPictTbl.createTable();
      DaoFdrStatTbl.createTable();
      DaoRptTbl.createTable();
      DaoRptAuxTbl.createTable();
      DaoFdrLinkTbl.createTable();
      DaoFiauxTblCtlg.createTable();
      DaoGlbDocHTbl.createTable();
      DaoSSNextIdTbl.createTable();
      DaoSrvStateHdrTbl.createTable();
      DaoSrvStateDetTbl.createTable();
      DaoAppEventTbl.createTable();
      DaoAutoNumCtlgTbl.createTable();
      DaoWMacroTbl.createTable();
      DaoPrefWFmtTbl.createTable();
      SmsDaoSessTbl.createTable();     
      SmsDaoSessNextIdTbl.createTable();
      
   }
   
   private void initializeUserTbls() throws Exception
   {
      User usr = ObjFactory.createUser();
      
      UasDaoNextIdTbl.initTblContentsNextId();      
      UasDaoSysTbl.initContentsUserSysTbl();
      usr.initSysSuperUser();
      
   }	
   
   private void createUserTbls() throws Exception
   {
      UasDaoNextIdTbl.createTable();
      UasDaoUserTbl.createTable();
      AcsDaoUserTypeTbl.createTable();
      UasDaoDeptTbl.createTable();
      UasDaoGroupTbl.createTable();
      UasDaoGURelTbl.createTable();
      AcsDaoGenPermTbl.createTable();
      AcsDaoObjHdrTbl.createTable();
      AcsDaoObjPermTbl.createTable();
      UasDaoCurrCntTbl.createTable();
      UasDaoUserMapTbl.createTable();
      UasDaoRemUserTbl.createTable();
      UasDaoLdapUserTbl.createTable();
      UasDaoLdapGroupTbl.createTable();
      UasDaoLicencesTbl.createTable();
      UasDaoSysTbl.createTable();
      UasDaoPwdsTbl.createTable();
   }
   
   private void initializeVolTbls() throws Exception
   {
      FssDaoNextIdTbl.initTblContentsNextId();      
   }	
   
   private void createVolTbls() throws Exception
   {
      FssDaoNextIdTbl.createTable();
      FssDaoRepTbl.createTable();
      FssDaoVolTbl.createTable();
      FssDaoActDirTbl.createTable();
      FssDaoListTbl.createTable();
      FssDaoListVolTbl.createTable();
      FssDaoFileTbl.createTable();
      FssDaoFtsTbl.createTable();
      DaoArchListTbl.createTable();
   }
   
   private static final Logger _logger = Logger.getLogger(SystemCfgImpl.class);
}
