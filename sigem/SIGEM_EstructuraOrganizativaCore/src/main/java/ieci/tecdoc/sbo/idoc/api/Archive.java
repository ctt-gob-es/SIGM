
package ieci.tecdoc.sbo.idoc.api;

import ieci.tecdoc.core.db.DBSessionManager;
import ieci.tecdoc.sbo.config.CfgMdoConfig;
import ieci.tecdoc.core.db.DbConnectionConfig;
import ieci.tecdoc.sbo.idoc.archive.std.ArchiveManager;
import ieci.tecdoc.sbo.idoc.archive.base.ArchiveToken;
import ieci.tecdoc.sgm.base.dbex.DbConnection;

/**
 * Esta clase act�a como una fachada para los archivadores. Proporciona un 
 * conjunto de m�todos sencillos para realizar operaciones sobre archivadores.
 * 
 * 
 * @author 
 *
 */

public final class Archive
{
   /** Configuraci�n de la conexi�n de base de datos */
   DbConnectionConfig m_dbConnConfig;
   
   /** Ruta donde se encuentra el fichero de configuraci�n de base de datos */
   String m_configDir;
   
   /**
    * Constructor
    * 
    * @throws Exception
    */
   public Archive() throws Exception
   {
      m_dbConnConfig = null;
      m_configDir    = null;
   }
   
   /**
    * Constructor 
    * 
    * @param configDir Ruta donde se encuentra el fichero de configuraci�n 
    * de base de datos
    * @throws Exception
    */
   public Archive(String configDir) throws Exception
   { 
      m_dbConnConfig = null;
      m_configDir    = configDir; 
   }

   
   /**
    * Establece la configuraci�n de la conexi�n de base de datos
    * 
    * @param dbConnConfig Configuraci�n de la conexi�n de base de datos
    * @throws Exception
    */
   public void setConnectionConfig(DbConnectionConfig dbConnConfig)
               throws Exception
   {
      m_dbConnConfig = dbConnConfig;
   }
     
   /**
    * Devuelve <tt>true</tt> si el usuario tiene permisos de acceso sobre 
    * el archivador
    * 
    * @param acs Objeto AcsAccessObject con los permisos del usuario. 
    * Si se recibe <tt>null</tt> no se chequean permisos
    * @param archId Identificador del archivador
    * @return <tt>true</tt> si el usuario tiene permisos de acceso sobre 
    * el archivador. <tt>false</tt> en caso contrario
    * @throws Exception
    */
   public boolean canLoadArchive(AcsAccessObject acs,
                                 int archId, String entidad) throws Exception
   {
      boolean can = false;
      
      DbConnection dbConn=new DbConnection();
      try
      {
         
         dbConn.open(DBSessionManager.getSession(entidad));		        

         can = ArchiveManager.canLoadArchive(dbConn, acs.getAccessToken(), archId);
         
         return can;
                                          
      }
      catch (Exception e)
      {
         return can;
      }finally{
    	  dbConn.close();
      }
            
   }

   /**
    * Crea un objeto ArchiveObject con la informaci�n de un archivador 
    * concreto. Antes de crearlo verifica si el usuario que trata de 
    * obtener dicho ArchiveObject tiene permisos sobre el archivador.  
    * 
    * @param acs Objeto AcsAccessObject con los permisos del usuario.
    * Si se recibe <tt>null</tt> no se chequean permisos
    * @param archId Identificador del archivador
    * @return ArchiveObject con la informaci�n del archivador.
    * @throws Exception arroja una IeciTdException en caso de que el
    * usuario no tenga permisos de acceso sobre el archivador
    */
   public ArchiveObject loadArchive(AcsAccessObject acs, int archId, String entidad)
							   throws Exception
   {
      
      ArchiveToken  token = null;
      ArchiveObject arch = null;
      
      DbConnection dbConn=new DbConnection();
      try
      {
         
         dbConn.open(DBSessionManager.getSession(entidad));
         
         if (acs == null)
            token = ArchiveManager.loadArchive(dbConn, null, archId);
         else
            token = ArchiveManager.loadArchive(dbConn, acs.getAccessToken(), archId);

         arch = new ArchiveObject(token);
         
         return arch;
                                          
      }
      catch (Exception e)
      {
         return null;
      }finally{
    	  dbConn.close();
      }
            
   }
   
   /**
    * Devuelve la conexi�n a base de datos. Si la conexi�n es nula la crea 
    * a trav�s del fichero de configuraci�n de base de datos. 
    * 
    * @return Conexi�n con la base de datos
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
   
} // class
