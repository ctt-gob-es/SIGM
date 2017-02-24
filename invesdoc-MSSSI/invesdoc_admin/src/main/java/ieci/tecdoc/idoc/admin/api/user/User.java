package ieci.tecdoc.idoc.admin.api.user;

import java.util.ArrayList;
import java.util.Date;
import ieci.tecdoc.core.db.DbConnectionConfig;

/**
 * Proporciona toda la funcionalidad necesaria para manejar usuarios invesDoc.
 */
public interface User
{

	/**
    * Establece la configuraci�n de la conexi�n de base de datos
    * 
    * @param dbConnConfig Configuraci�n de la conexi�n de base de datos
    * @throws Exception
    */
	 
   public void setConnectionConfig(DbConnectionConfig dbConnConfig) throws Exception;

	/**
    * Carga un usuario.
    * 
    * @param userId Identificador del usuario.
    * @throws Exception Si se produce alg�n error al leer la informaci�n del 
    * usuario.
    */

   public void load(int userId) throws Exception;
   
   /**
    * Carga un usuario.
    * 
    * @param userName Nombre del usuario.
    * @throws Exception Si se produce alg�n error al leer la informaci�n del 
    * usuario.
    */

   public void load(String userName) throws Exception;

   /**
    * Guarda el usuario. Se utiliza tanto para inserciones como para 
    * actualizaciones.
    * 
    * @throws Exception Si se produce alg�n error al guardar. Por ejemplo, 
    * el usuario ya existe.
    */

   public void store() throws Exception;

   /**
    * Elimina el usuario.
    * 
    * @throws Exception Si se produce alg�n error al eliminar.
    */

   public void delete() throws Exception;
   
   /**
    * Obtiene los identificadores de los departamentos a los que 
    * administra el usurario indicado.
    * 
    * @param userId  Identificador de usuario
    * @return Lista de enteros con los identificadores de departamento
    * @throws Exception Si se produce alg�n error.
    */
   public ArrayList getDeptsIdMgr(int userId) throws Exception;
   
   /**
    * Otiene los identificadores de los grupos a los que administra el
    * usuario especificado.
    * 
    * @param userId Identificador de usuario
    * @return  Lista de enteros con los identificadores de grupo 
    * @throws Exception Si se produce alg�n error.
    */
   public ArrayList getGroupsIdMgr(int userId) throws Exception;
   
   /**
    * Obtiene el identificador del usuario.
    * 
    * @return El identificador mencionado.
    */
   public int getId();
   
   /**
    * Obtiene el nombre del usuario.
    * 
    * @return El nombre mencionado.
    */
   public String getName();
   
   /**
    * Establece el nombre del usuario.
    * 
    * @param name El nombre del usuario.
    */
   public void setName(String name);
   
   /**
    * Establece la password del usuario.
    * 
    * @param password La password del usuario.
    */
   public void setPassword(String password);
   
   /**
    * Obtiene la obligatoriedad sobre la inicializaci�n de la contrase�a.
    * 
    * @return <code>true</code> si es obligatoria la inicializaci�n de la contrase�a.
    * 		  <code>false</code> si no es obligatoria la inicializaci�n de la contrase�a.
    */
   public boolean getPwdmbc();
   
   /**
    * Establece la obligatoriedad de la inicializaci�n de la contrase�a.
    * 
    * @param pwdmbc <code>true</code> si es obligatoria la inicializaci�n de la contrase�a.
    * 		  		  <code>false</code> si no es obligatoria la inicializaci�n de la contrase�a.
    */
   public void setPwdmbc(boolean pwdmbc);
   
   /**
    * Obtiene la informaci�n de comprobar la caducidad de la contrase�a.
    * 
    * @return <code>true</code> si se comprueba la caducidad de la contrase�a.
    * 		  <code>false</code> si no se comprueba.
    */
   public boolean getPwdvpcheck();
   
   /**
    * Establece la informaci�n de comprobar la caducidad de la contrase�a.
    * 
    * @param pwdvpcheck <code>true</code> si se comprueba la caducidad de la contrase�a.
    * 		  				<code>false</code> si no se comprueba.
    */
   public void setPwdvpcheck(boolean pwdvpcheck);
   
   /**
    * Obtiene la descripci�n del usuario.
    * 
    * @return El dato mencionado.
    */
   public String getDescription();
   
   /**
    * Establece la descripci�n del usuario.
    * 
    * @param description La descripci�n del usuario.
    */
   public void setDescription(String description);
   
   /**
    * Obtiene el identificador del departamento al que pertenece el usuario.
    * 
    * @return El identificador mencionado.
    */
   public int getDeptId();
   
   /**
    * Establece el identificador del departamento del usuario.
    * 
    * @param deptId El identificador del departamento.
    */
   public void setDeptId(int deptId);
   
   /**
    * Obtiene el estado del usuario.
    * 
    * @return El dato mencionado.
    */
   public int getState();
   
   /**
    * Establece el estado del usuario.
    * 
    * @param state El estado del usuario.
    */
   public void setState(int state);
   
   /**
    * Obtiene la lista de perfiles del usuario.
    * 
    * @return La lista mencionada. 
    */
   public UserProfiles getProfiles();

   /**
    * Obtiene la lista de permisos del usuario.
    * 
    * @return La lista mencionada.
    */
   public Permissions getPermissions();
   
   /**
	 * Obtiene el identificador del usuario que ha creado el usuario. 
	 * 
	 * @return El identificador mencionado.
	 */
	public int getCreatorId();
	
	/**
    * Obtiene la fecha de creaci�n del usuario.
    *
    * @return La fecha mencionada.
    */
   public Date getCreationDate();
   
   /**
    * Obtiene el identificador del usuario que ha actualizado el usuario.
    *
    * @return El identificador mencionado.
    */
   public int getUpdaterId();
   
   /**
    * Obtiene la fecha de actualizaci�n del usuario.
    *
    * @return La fecha mencionada.
    */
   public Date getUpdateDate();
   
   /**
    * Obtiene la fecha de la �ltima modificaci�n de la contrase�a.
    * Horas transcurridas desde 01-01-1971.
    * 
    * @return La fecha mencionada.
    */
   public double getPwdLastUpdTs();


   /**
    * Inicializa datos del Syssuperuser
    * 
    * @throws Exception
    */
   public void initSysSuperUser() throws Exception;
   
   /**
    * Obtiene la informaci�n del usuario en formato XML.
    *
    * @return La informaci�n mencionada.
    */

   public String toXML(); 

   /**
    * Muestra una representaci�n de los valores de la clase en formato XML.
    *  
    * @return La representaci�n mencionada.
    */

	public String toString();

}
