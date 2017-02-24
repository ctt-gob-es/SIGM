
package ieci.tecdoc.sbo.idoc.api;

import ieci.tecdoc.core.db.DbConnection;
import ieci.tecdoc.sbo.config.CfgMdoConfig;
import ieci.tecdoc.sbo.acs.base.AcsAccessToken;
import ieci.tecdoc.core.db.DbConnectionConfig;
import ieci.tecdoc.sbo.idoc.login.LoginManager;
import ieci.tecdoc.sbo.idoc.login.LoginMethod;

/**
 * Gestor de acceso. Esta clase proporciona la funcionalidad
 * b�sica para establecer una sesi�n. Esta sesi�n puede establecerse
 * contra diferentes sistemas:
 * <li> Est�ndar: los usuarios se encuentran registrados en el sistema invesdoc
 * <li> Ldap: los usuarios se encuentran registrados en un directorio
 * <li> SSOLdap: Single Sign On
 */

public final class Login
{
   /** 
    * Configuraci�n de la base de datos donde se encuentra los usuarios 
    * invesdoc.
    */
   DbConnectionConfig m_dbConnConfig;
   
   /** 
    * Directorio donde se encuentra el fichero con la configuraci�n de
    * la base de datos invesdoc
    */
   String             m_configDir;
   
   /**
    * Constructor
    * @throws Exception
    */
   public Login() throws Exception
   {
      m_dbConnConfig = null;
      m_configDir    = null;
   }
   
   /**
    * Construtor
    * @param configDir configuraci�n de la base de datos invesdoc
    * @throws Exception
    */
   public Login(String configDir) throws Exception
   {      
      m_dbConnConfig = null;
      m_configDir    = configDir;          
   }

   /**
    * Devuelve la configuraci�n de la base de datos donde se encuentran
    * usuarios invesdoc. 
    * @return
    * @throws Exception
    */
   private DbConnectionConfig getDbConfig() throws Exception
   {
      if (m_dbConnConfig == null)
      {
         if (m_configDir == null)
         {
            m_dbConnConfig = CfgMdoConfig.getDbConfig();
         }
         else
         {
            m_dbConnConfig = CfgMdoConfig.getDbConfig(m_configDir);
         }
      }
      
      return  m_dbConnConfig;
   }
   
   /**
    * Establece una configuraci�n de base de datos. Esta configuraci�n
    * corresponder� con la de la base de datos donde se encuentren los
    * usuarios invesdoc.
    * @param dbConnConfig Configuraci�n de base de datos
    * @throws Exception
    */
   public void setConnectionConfig(DbConnectionConfig dbConnConfig)
               throws Exception
   {
      m_dbConnConfig = dbConnConfig;
   }
   
   /**
    * Devuelve el m�todo bajo el cual se establece la sesi�n. 
    * @return M�todo bajo el cual se establece la sesi�n. Los m�todos vienen
    * definidos en la clase LoginMethod:
    * <li> LoginMethod.STANDARD
    * <li> LoginMethod.LDAP
    * <li> LoginMethod.SSO_LDAP
    * @throws Exception
    * @see LoginMethod
    */
   public int getLoginMethod() throws Exception
   {
      int login = 0;
      
      try
      {
         
         DbConnection.open(getDbConfig());		        

         login = LoginManager.getLoginMethod();

         DbConnection.close();
         
         return login;
                                          
      }
      catch (Exception e)
      {
         DbConnection.ensureClose(e);  
         return login;
      }
            
   }   
   
   /**
    * Lleva a cabo el establecimiento de sesi�n est�ndar
    * @param name nombre del usuario
    * @param pwd contrase�a del usuario
    * @param cntsTriesNum n�mero de intentos en el establecimiento de sesi�n
    * @return referencia a un objeto de tipo AcsAccessObject que contiene informaci�n
    * b�sica del usuario
    * @throws Exception si se produce un error en el establecimiento de la sesi�n
    * @see AcsAccessObject
    */
   public AcsAccessObject doLoginStd(String name, String pwd,
												int cntsTriesNum) 
								 throws Exception
   {
      
      AcsAccessToken  accessToken = null;
      AcsAccessObject acs         = null; 
      
      try
      {
         
         DbConnection.open(getDbConfig());		        

         accessToken = LoginManager.doLoginStd(name, pwd, cntsTriesNum);

         DbConnection.close();

         acs = new AcsAccessObject(accessToken);
         
         return acs;
                                          
      }
      catch (Exception e)
      {
         DbConnection.ensureClose(e);  
         return null;
      }
            
   }
   
   /**
    * Lleva a cabo el establecimiento de sesi�n contra directorio ldap. 
    * @param name - nombre del usuario
    * @param pwd - contrase�a del usuario
    * @param cntsTriesNum - n�mero de intentos en el establecimiento de sesi�n
    * @return referencia a un objeto de tipo AcsAccessObject que contiene informaci�n
    * b�sica del usuario
    * @throws Exception - si se produce un error en el establecimiento de la sesi�n
    * @see AcsAccessObject
    */
   public AcsAccessObject doLoginLdap(String name, String pwd,
												  int cntsTriesNum) throws Exception
   {
      
      AcsAccessToken  accessToken = null; 
      AcsAccessObject acs         = null; 
      
      try
      {
         
         DbConnection.open(getDbConfig());		        

         accessToken = LoginManager.doLoginLdap(name, pwd, cntsTriesNum);

         DbConnection.close();

         acs = new AcsAccessObject(accessToken);
         
         return acs;
                                          
      }
      catch (Exception e)
      {
         DbConnection.ensureClose(e);  
         return null;
      }     
            
   }
   
   /**
    * Lleva a cabo el establecimiento de sesi�n Single Sign On. 
    * @param name - nombre del usuario
    * @return referencia a un objeto de tipo AcsAccessObject que contiene informaci�n
    * b�sica del usuario
    * @throws Exception - si se produce un error en el establecimiento de la sesi�n
    * @see AcsAccessObject
    */

   public AcsAccessObject doSsoLoginLdap(String name)
								  throws Exception
   {
      
      AcsAccessToken  accessToken = null; 
      AcsAccessObject acs         = null; 
      
      try
      {
         
         DbConnection.open(getDbConfig());		        

         accessToken = LoginManager.doSsoLoginLdap(name);

         DbConnection.close();

         acs = new AcsAccessObject(accessToken);
         
         return acs;
                                          
      }
      catch (Exception e)
      {
         DbConnection.ensureClose(e);  
         return null;
      }       
            
   }
   
   /**
    * Lleva a cabo el establecimiento de sesi�n con pool de usuarios
    * de un grupo
    * @return referencia a un objeto de tipo AcsAccessObject que contiene informaci�n
    * b�sica del usuario
    * @throws Exception si se produce un error en el establecimiento de la sesi�n
    * @see AcsAccessObject
    */
   public AcsAccessObject doDirectLoginStd(int groupId) 
								 throws Exception
   {
      
      AcsAccessToken  accessToken = null;
      AcsAccessObject acs         = null; 
      
      try
      {
         
         DbConnection.open(getDbConfig());		        

         accessToken = LoginManager.doDirectLoginStd(groupId);

         DbConnection.close();

         acs = new AcsAccessObject(accessToken);
         
         return acs;
                                          
      }
      catch (Exception e)
      {
         DbConnection.ensureClose(e);  
         return null;
      }
            
   }
   
   /**
    * Lleva a cabo el establecimiento de sesi�n con pool de usuarios
    * de un grupo
    * @return referencia a un objeto de tipo AcsAccessObject que contiene informaci�n
    * b�sica del usuario
    * @throws Exception si se produce un error en el establecimiento de la sesi�n
    * @see AcsAccessObject
    */
   public AcsAccessObject doDirectLoginStd() 
								 throws Exception
   {
      
      AcsAccessToken  accessToken = null;
      AcsAccessObject acs         = null; 
      
      try
      {
         
         DbConnection.open(getDbConfig());		        

         accessToken = LoginManager.doDirectLoginStd();

         DbConnection.close();

         acs = new AcsAccessObject(accessToken);
         
         return acs;
                                          
      }
      catch (Exception e)
      {
         DbConnection.ensureClose(e);  
         return null;
      }
            
   }
   
   /**
    * Lleva a cabo la liberaci�n del usario de un pool de usuarios
    * de un grupo
    *  
    * @throws Exception si se produce un error en el establecimiento de la sesi�n
    * 
    */
   public void doDirectLogoutStd(int userId,int groupId) 
					throws Exception
   {
            
      try
      {
         
         DbConnection.open(getDbConfig());		        

         LoginManager.doDirectLogoutStd(userId, groupId);

         DbConnection.close();

                                          
      }
      catch (Exception e)
      {
         DbConnection.ensureClose(e); 
         
      }
            
   }
   
   /**
    * Lleva a cabo la liberaci�n del usario de un pool de usuarios
    * de un grupo
    *  
    * @throws Exception si se produce un error en el establecimiento de la sesi�n
    * 
    */
   public void doDirectLogoutStd(int userId) 
					throws Exception
   {
            
      try
      {
         
         DbConnection.open(getDbConfig());		        

         LoginManager.doDirectLogoutStd(userId);

         DbConnection.close();

                                          
      }
      catch (Exception e)
      {
         DbConnection.ensureClose(e); 
         
      }
            
   }
   
   
   
} // class
