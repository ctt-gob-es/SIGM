package ieci.tecdoc.idoc.admin.api.system;

import ieci.tecdoc.sbo.config.CfgFtsConfig;
import ieci.tecdoc.sbo.config.CfgLdapConfig;

/**
 * Proporciona toda la funcionalidad necesaria para configuraci�n del sistema. 
 */

public interface SystemCfg
{
    
    
    
    public void updateMisc(String entidad) throws Exception;
    
    /**
     * Abre la Conexi�n a la base de datos
     * @throws Exception Si se produce alg�n error
     */
    //public void connectDataBase(String entidad)throws Exception;
    
    public CfgFtsConfig getFtsConfig(String entidad) throws Exception;
    
    public CfgLdapConfig getLdapConfig(String entidad)throws Exception;
   /**
    * Obtiene si existe o no configuraci�n de motor documental
    * 
    * @return  true / false
    * @throws Exception
    */
   public boolean hasFtsConfig(String entidad) throws Exception;
   
   
   /**
    * Obtiene el nombre ra�z del �rbol de archivadores
    * 
    * @return El nombre mencionado
    * @throws Exception
    */
   public String getRootNameArchs(String entidad) throws Exception;
   
   
   public void setRootNameArchs(String rootName, String entidad) throws Exception;
   
   /**
    * Inicializa la fuente de datos invesDoc
    * 
    * @throws Exception
    */
   public void initDataBase(String entidad) throws Exception;
   
   /**
    * Desbloquea al usuario Syssuperuser
    * 
    * @throws Exception
    */
   public void unLockSyssuperuser(String entidad) throws Exception;
   
   /**
    * Cierra la conexi�n a la Base de datos
    * @throws Exception Si se produce alg�n error
    */
   //public void closeDataBase()throws Exception;
   
   /**
    * Determina si el SYSSUPERUSER est� bloqueado o no
    * @return true si SYSSUPERUSER est� bloqueado
    */
   public boolean isLockSyssuperuser();
   
   
   /**
    * Inicializa las tablas principales del repositorio documental. Se necesita una 
    * conexi�n abierta a BD
    * 
    * @throws Exception Si se produce alg�n error en la creaci�n
    */
   public void setupDocDb(String entidad) throws Exception;
   
   /**
    * Inicializa las tablas de usuarios del repositorio documental. Se necesita una conexi�n abierta a BD
    * @throws Exception Si se produce alg�n error en la creaci�n
    */
   public void setupUserDb(String entidad) throws Exception;
   
   /**
    * Inicializa las tablas de vol�menes del repositorio documental. Se necesita una conexi�n abierta a BD
    * @throws Exception Si se produce alg�n error en la creaci�n
    */
   public void setupVolDb(String entidad) throws Exception;
}
