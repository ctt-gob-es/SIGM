package ieci.tecdoc.idoc.admin.api.user;

import ieci.tecdoc.idoc.admin.internal.BasicUsersImpl;
import ieci.tecdoc.idoc.admin.internal.GenericPermsImpl;

import java.util.Date;

/**
 * Proporciona toda la funcionalidad necesaria para manejar grupos invesDoc.
 */

public interface Group
{
	/**
    * Carga un grupo invesDoc.
    * 
    * @param groupId Identificador del grupo.
    * @throws Exception Si se produce alg�n error al leer la informaci�n del 
    * grupo.
    */

   public void load(int groupId, String entidad) throws Exception;
   
   /**
    * Carga un grupo invesDoc.
    * 
    * @param groupName Nombre del grupo.
    * @throws Exception Si se produce alg�n error al leer la informaci�n del 
    * grupo.
    */

   public void load(String  groupName, String entidad) throws Exception;

   /**
    * Guarda el grupo. Se utiliza tanto para inserciones como para 
    * actualizaciones.
    * 
    * @throws Exception Si se produce alg�n error al guardar. Por ejemplo, 
    * el grupo ya existe.
    */

   public void store(String entidad) throws Exception;

   /**
    * Elimina el grupo.
    * 
    * @throws Exception Si se produce alg�n error al eliminar.
    */

   public void delete(String entidad) throws Exception;
   
   /**
    * Obtiene el identificador de grupo.
    * 
    * @return El identificador mencionado.
    */
   public int getId();
   
   /**
    * Obtiene el nombre del grupo.
    *  
    * @return El nombre mencionado.
    */
   public String getName();
   
   /**
    * Obtiene la lista de usuarios (identificadores y nombres) que pueden ser
    * administradores de este grupo.
    * 
    * @return La lista mencionada. 
    */    
   public BasicUsers getAdminUsers(String entidad) throws Exception;
   
   /**
    * Establece el nombre del grupo.
    * 
    * @param name Nombre del grupo.
    */
   public void setName(String name);
   
   /**
    * Obtiene el identificador del administrador del gupo.
    * 
    * @return El identificador mencionado.
    */
   public int getManagerId();
   
   /**
    * Establece el identificador del administrador del gupo.
    * 
    * @param managerId El identificador del administrador.
    */
   public void setManagerId(int managerId);
   
   /**
    * Obtiene el identificador del tipo de grupo.
    * 
    * @return El identificador mencionado.
    */
   public int getType();
   
   /**
    * Obtiene la descripci�n del grupo.
    * 
    * @return El nombre mencionado.
    */
   public String getDescription();
   
   /**
    * Establece la descripci�n del grupo.
    * 
    * @param description La descripci�n del grupo.
    */
   public void setDescription(String description);
   
   /**
	 * Obtiene el identificador del usuario que ha creado el grupo. 
	 * 
	 * @return El identificador mencionado.
	 */
	public int getCreatorId();
	
	/**
    * Obtiene la fecha de creaci�n del grupo.
    *
    * @return La fecha mencionada.
    */
   public Date getCreationDate();
   
   /**
    * Obtiene el identificador del usuario que ha actualizado el grupo.
    *
    * @return El identificador mencionado.
    */
   public int getUpdaterId();
   
   /**
    * Obtiene la fecha de actualizaci�n del grupo.
    *
    * @return La fecha mencionada.
    */
   public Date getUpdateDate();
   
   public BasicUsersImpl get_adminUsers();

   public int get_userConnected();
   
   public GenericPermsImpl get_permsImpl();

   public Users get_users();
   
   /**
    * Devuelve la lista de permisos del grupo.
    * 
    * @return La lista mencionada.
    */
   
   public Permissions getPermissions();
   
   /**
    * Devuelve la lista de usuarios del grupo.
    * No es necesario cargar antes la clase Group.
    * 
    * @param id Identificador del grupo.
    * @return Los usuarios del grupo.
    */
   
   public Users getUsersByGroup(int id, String entidad) throws Exception;
   
   /**
    * Obtiene la informaci�n del grupo en formato XML.
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
