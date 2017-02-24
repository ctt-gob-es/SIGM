package ieci.tecdoc.idoc.admin.api.system;

import ieci.tecdoc.sbo.config.CfgFtsConfig;
import ieci.tecdoc.sbo.config.CfgLdapConfig;

/**
 * Proporciona toda la funcionalidad necesaria para configuraci�n del sistema. 
 */

public interface SystemCfg
{
    
    
    
    public void updateMisc() throws Exception;
    
    /**
     * Abre la Conexi�n a la base de datos
     * @throws Exception Si se produce alg�n error
     */
    public void connectDataBase()throws Exception;
    
    public CfgFtsConfig getFtsConfig() throws Exception;
    
    public CfgLdapConfig getLdapConfig()throws Exception;
   /**
    * Obtiene si existe o no configuraci�n de motor documental
    * 
    * @return  true / false
    * @throws Exception
    */
   public boolean hasFtsConfig() throws Exception;
   
   
   /**
    * Obtiene el nombre ra�z del �rbol de archivadores
    * 
    * @return El nombre mencionado
    * @throws Exception
    */
   public String getRootNameArchs() throws Exception;
   
   
   public void setRootNameArchs(String rootName) throws Exception;
   
   /**
    * Inicializa la fuente de datos invesDoc
    * 
    * @throws Exception
    */
   public void initDataBase() throws Exception;
   
   /**
    * Desbloquea al usuario Syssuperuser
    * 
    * @throws Exception
    */
   public void unLockSyssuperuser() throws Exception;
   
   /**
    * Cierra la conexi�n a la Base de datos
    * @throws Exception Si se produce alg�n error
    */
   public void closeDataBase()throws Exception;
   
   /**
    * Determina si el SYSSUPERUSER est� bloqueado o no
    * @return true si SYSSUPERUSER est� bloqueado
    */
   public boolean isLockSyssuperuser();
   
   
   /**
    * Inicializa las tablas principales de W@rda. Se necesita una conexi�n abierta a BD
    * @throws Exception Si se produce alg�n error en la creaci�n
    */
   public void setupDocDb() throws Exception;
   
   /**
    * Inicializa las tablas de usuarios de W@rda. Se necesita una conexi�n abierta a BD
    * @throws Exception Si se produce alg�n error en la creaci�n
    */
   public void setupUserDb() throws Exception;
   
   /**
    * Inicializa las tablas de vol�menes de W@rda. Se necesita una conexi�n abierta a BD
    * @throws Exception Si se produce alg�n error en la creaci�n
    */
   public void setupVolDb() throws Exception;
}
