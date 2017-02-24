
package es.ieci.tecdoc.isicres.admin.estructura.dao;

/**
 * Maneja los perfiles de un usuario. Cada permiso es una 
 * terna compuesta por: <br> [Identificador de usuario, Identificador de 
 * Producto, Perfil].
 * @see ISicresAdminUserDefsKeys 
 */

public interface UserProfile 
{
   /**
    * Devuelve el identificador del usuario.
    * 
    * @return El identificador mencionado.
    */

   public int getUserId();
   
   /**
    * Devuelve el identificador del producto al que se asigna el perfil.
    * 
    * @return El identificador mencionado.
    */

   public int getProduct();
   
   /**
    * Devuelve el perfil asignado al producto.
    * 
    * @return El perfil mencionado.
    */

   public int getProfile();
   
   /**
    * Establece el perfil asignado al producto.
    * 
    * @param profile El perfil mencionado.
    *  
    */

   public void setProfile(int profile); 

   /**
    * Obtiene la informaci�n del perfil del usuario en formato XML.
    *  
    * @param header Indica si hay que incluir la cabecera xml o no.
    * @return La informaci�n mencionada.
    */
   
   public void load(int idUsuario, int idProfile, String entidad) throws Exception;

   public boolean checkProfilesExists(String entidad) throws Exception;

   public void update(String entidad) throws Exception;

   public void insert(String entidad) throws Exception;

   public void store(String entidad) throws Exception;
   
   
   

   public String toXML(boolean header); 

   /**
    * Muestra una representaci�n de los valores de la clase en formato XML.
    *  
    * @return La representaci�n mencionada.
    */

	public String toString();

}