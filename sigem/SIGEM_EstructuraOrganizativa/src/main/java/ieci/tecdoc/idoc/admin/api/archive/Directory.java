
package ieci.tecdoc.idoc.admin.api.archive;

import ieci.tecdoc.idoc.admin.api.user.BasicUsers;
import java.util.Date;

/**
 * Proporciona toda la funcionalidad necesaria para manejar directorios invesDoc. 
 */

public interface Directory 
{

   /**
    * Carga un directorio.
    * 
    * @param id Identificador del directorio.
    * @throws Exception Si se produce alg�n error al leer la informaci�n del 
    * directorio.
    */

   public void load(int id, String entidad) throws Exception;

   /**
    * Guarda el directorio. Se utiliza tanto para inserciones como para 
    * actualizaciones.
    * 
    * @throws Exception Si se produce alg�n error al guardar. Por ejemplo, 
    * el directorio ya existe.
    */

   public void store(String entidad) throws Exception;

   /**
    * Elimina el directorio.
    * 
    * @throws Exception Si se produce alg�n error al eliminar. Por ejemplo, 
    * el directorio tiene hijos.
    */

   public void delete(String entidad) throws Exception;

   /**
    * Indica si se est� trabajando con usuarios de un repositorio Ldap (true) o
    * no (false).
    *
    * @param ldap Si se trata de usuarios Ldap o no.
    */
    
   public void setLdap(boolean ldap);

   /**
    * Obtiene el nombre del directorio.
    *
    * @return El nombre mencionado.
    */
    
   public String getName();
   
   /**
    * Establece el nombre del directorio.
    *
    * @param name El nombre del directorio.
    */
    
   public void setName(String name);

   /**
    * Obtiene la descripci�n del directorio.
    *
    * @return La descripci�n mencionada.
    */
    
   public String getDescription();
   
   /**
    * Establece la descripci�n del directorio.
    *
    * @param description La descripci�n del directorio.
    */
    
   public void setDescription(String description);

   /**
    * Obtiene los flags del directorio.
    *
    * @return Los flags mencionados.
    */
    
   public int getFlags();

   /**
    * Establece los flags del directorio.
    *
    * @return Los flags mencionados.
    */
    
   public void setFlags(int flags);
   
   
   /**
    * Obtiene el tipo de acceso del directorio.
    *
    * @return El tipo de acceso mencionado.
    */
    
   public int getAccessType();
   
   /**
    * Establece el tipo de acceso del directorio.
    *
    * @param accessType El tipo de acceso.
    */
    
   public void setAccessType(int accessType);
   
   /**
    * Obtiene el identificador de acceso del directorio.
    *
    * @return El identificador mencionado.
    */
    
   public int getAcsId();
   
   /**
    * Obtiene el identificador del usuario que ha creado del directorio.
    *
    * @return El identificador mencionado.
    */
    
   public int getCreatorId();

   /**
    * Obtiene la fecha de creaci�n del directorio.
    *
    * @return La fecha mencionada.
    */
    
   public Date getCreationDate();
   
   /**
    * Obtiene el identificador del usuario que ha actualizado el directorio.
    *
    * @return El identificador mencionado.
    */
    
   public int getUpdaterId();

   /**
    * Obtiene la fecha de actualizaci�n del directorio.
    *
    * @return La fecha mencionada.
    */
    
   public Date getUpdateDate();

   /**
    * Obtiene el identificador del usuario administrador del directorio.
    *
    * @return El identificador mencionado.
    */
    
   public int getAdminUserId();

   /**
    * Obtiene la lista de usuarios (identificadores y nombres) que pueden ser
    * administradores de este directorio.
    * 
    * @return La lista mencionada. 
    */
    
   public BasicUsers getAdminUsers(String entidad) throws Exception;
    
   /**
    * Establece el identificador del usuario administrador del directorio.
    *
    * @param id El identificador mencionado.
    */
    
   public void setAdminUserId(int id);
    
   /**
    * Obtiene la informaci�n del directorio en formato XML.
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