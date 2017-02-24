
package ieci.tecdoc.sbo.idoc.api;

import ieci.tecdoc.core.db.DbConnection;
import ieci.tecdoc.core.db.DbConnectionConfig;
import ieci.tecdoc.sbo.config.CfgMdoConfig;
import ieci.tecdoc.sbo.idoc.folder.base.FolderTokenFlds;
import ieci.tecdoc.sbo.idoc.folder.search.FolderSearchResult;
import ieci.tecdoc.sbo.idoc.api.FolderSearchQueryObject;
import ieci.tecdoc.sbo.idoc.folder.search.FolderMdoSearch;

/**
 * Gestor de b�squedas de carpetas
 */


public final class FolderSearch
{
   /** 
    * Configuraci�n de la base de datos donde se encuentra el modelo
    * de datos de invesdoc
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
   public FolderSearch() throws Exception
   {
      m_dbConnConfig = null;
      m_configDir    = null;   
   }
   
   /**
    * Construtor
    * @param configDir configuraci�n de la base de datos invesdoc
    * @throws Exception
    */
   public FolderSearch(String configDir) throws Exception
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
    * corresponder� con la base de datos invesdoc.
    * @param dbConnConfig Configuraci�n de base de datos
    * @throws Exception
    */
   public void setConnectionConfig(DbConnectionConfig dbConnConfig)
               throws Exception
   {
      m_dbConnConfig = dbConnConfig;
   }
   
   /**
    * Realiza una b�squeda de carpetas dentro de un archivador. 
    * @param acs este par�metro es opcional.
    * Contiene informaci�n del usuario invesdoc que realiza la b�squeda. Si es
    * pasado este par�metro, s�lo se obtienen carpetas que, adem�s de cumplir los filtros de la
    * b�squeda, sean visibles para el usuario invesdoc al cual se refiere el par�metro acs.
    * @param arch este par�metro contiene informaci�n del archivador sobre el cual se van a buscar 
    * carpetas. 
    * @param query contiene los filtros que se van a aplicar a la b�squeda
    * @return referencia a un objeto de tipo FolderSearchResult que cotiene los resultados de la 
    * b�squeda
    * @throws Exception si se produce alg�n error en la b�squeda de carpetas
    * @see AcsAccessObject
    * @see ArchiveObject
    * @see FolderSearchQueryObject
    * @see FolderSearchResult 
    */
   public FolderSearchResult executeQuery(AcsAccessObject acs,
                                          ArchiveObject arch,
                                          FolderSearchQueryObject query)
                             throws Exception
   {
      
      FolderSearchResult rs = null;
      
      try
      {
         
         DbConnection.open(getDbConfig());   
         
         if (acs == null)
            rs = FolderMdoSearch.executeQuery(null,
                                              arch.getArchiveToken(),
                                              query.getFolderSearchQuery());
         else
            rs = FolderMdoSearch.executeQuery(acs.getAccessToken(),
                                              arch.getArchiveToken(),
                                              query.getFolderSearchQuery());

         DbConnection.close();
         
         return rs;
                                          
      }
      catch (Exception e)
      {
         DbConnection.ensureClose(e);  
         return null;
      }   
            
   }

   /**
    * Realiza una b�squeda de carpetas dentro de un archivador. 
    * @param acs este par�metro es opcional.
    * Contiene informaci�n del usuario invesdoc que realiza la b�squeda. Si es
    * pasado este par�metro, s�lo se obtienen carpetas que, adem�s de cumplir los filtros de la
    * b�squeda, sean visibles para el usuario invesdoc al cual se refiere el par�metro acs.
    * @param arch este par�metro contiene informaci�n del archivador sobre el cual se van a buscar 
    * carpetas. 
    * @param qual condici�n sql que define los filtros de b�squeda de carpetas
    * @return referencia a un objeto de tipo FolderSearchResult que cotiene los resultados de la 
    * b�squeda
    * @throws Exception si se produce alg�n error en la b�squeda de carpetas
    * @see AcsAccessObject
    * @see ArchiveObject
    * @see FolderSearchResult 
    */
   public FolderSearchResult executeQuery(AcsAccessObject acs,
                                          ArchiveObject arch,
                                          String qual)
                             throws Exception
   {
      
      FolderSearchResult rs = null;
      
      try
      {
         
         DbConnection.open(getDbConfig());   
         
         if (acs == null)
            rs = FolderMdoSearch.executeQuery(null,
                                              arch.getArchiveToken(),
                                              qual);
         else
            rs = FolderMdoSearch.executeQuery(acs.getAccessToken(),
                                              arch.getArchiveToken(),
                                              qual);

         DbConnection.close();
         
         return rs;
                                          
      }
      catch (Exception e)
      {
         DbConnection.ensureClose(e);  
         return null;
      }   
            
   }
   
   /**
    * Devuelve los valores de los campos asociados a la carpeta i-�sima de una colecci�n de 
    * carpetas obtenida como resultado de una b�squeda dentro de un archivador.
    * @param arch este par�metro contiene informaci�n del archivador al cual pertenece
    * la carpeta
    * @param rs resultado de una b�squeda de carpetas sobre un archivador
    * @param idx �ndice i�simo de la carpeta sobre la cual obtener los valores de sus campos 
    * @return referencia a un objeto de tipo FolderFieldObjects que contiene los valores de los
    * campos de la carpeta
    * @throws Exception si se produce alg�n error en la obtenci�n de los valores de los campos
    * de una carpeta
    * @see FolderFieldObjects
    */
   public FolderFieldObjects getFolderValues(ArchiveObject arch, FolderSearchResult rs,
                                             int idx)
                             throws Exception
   {
      FolderTokenFlds    values = null;
      FolderFieldObjects flds = null;
      
      try
      {
         
         DbConnection.open(getDbConfig());            

         values = FolderMdoSearch.getFolderValues(arch.getArchiveToken(), rs, idx);

         DbConnection.close();

         flds = new FolderFieldObjects(values);
         
         return flds;
                                          
      }
      catch (Exception e)
      {
         DbConnection.ensureClose(e);  
         return null;
      }   
   }
   
} // class
