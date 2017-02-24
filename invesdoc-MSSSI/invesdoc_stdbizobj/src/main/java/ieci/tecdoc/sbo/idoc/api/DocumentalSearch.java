
package ieci.tecdoc.sbo.idoc.api;

import ieci.tecdoc.core.db.DbConnection;
import ieci.tecdoc.core.db.DbConnectionConfig;
import ieci.tecdoc.sbo.config.CfgMdoConfig;
import ieci.tecdoc.sbo.idoc.documental.search.DocumentalMdoSearch;
import ieci.tecdoc.sbo.idoc.documental.search.DocumentalSearchResult;


/**
 * Gestor de b�squedas documentales
 */


public final class DocumentalSearch
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
   public DocumentalSearch() throws Exception
   {
      m_dbConnConfig = null;
      m_configDir    = null;   
   }
   
   /**
    * Construtor
    * @param configDir configuraci�n de la base de datos invesdoc
    * @throws Exception
    */
   public DocumentalSearch(String configDir) throws Exception
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
    * Realiza una b�squeda documental
    * @param acs este par�metro es opcional.
    * Contiene informaci�n del usuario invesdoc que realiza la b�squeda. Si es
    * pasado este par�metro, s�lo se busca en los archivadores donde tenga permiso
    * y adem�s s�lo se obtienen carpetas que, adem�s de cumplir los filtros de la
    * b�squeda, sean visibles para el usuario invesdoc al cual se refiere el par�metro acs.
    * @param query contiene los filtros que se van a aplicar a la b�squeda
    * @return referencia a un objeto de tipo DocumentalSearchResult que cotiene los resultados de la 
    * b�squeda
    * @throws Exception si se produce alg�n error en la b�squeda de carpetas
    * @see AcsAccessObject
    * @see DocumentalSearchQueryObject
    * @see DocumentalSearchResult 
    */
   public DocumentalSearchResult executeQuery(AcsAccessObject acs,
                                          DocumentalSearchQueryObject query)
                             throws Exception
   {
      
      DocumentalSearchResult rs = null;

         
      if (acs == null)
         rs = DocumentalMdoSearch.executeQuery(null,
                  query.getDocumentalSearchQuery (), getDbConfig ());
      else
         rs = DocumentalMdoSearch.executeQuery(acs.getAccessToken(),
                  query.getDocumentalSearchQuery (), getDbConfig ());

      return rs;
                                          

            
   }

   
} // class
