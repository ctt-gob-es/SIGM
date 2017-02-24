
package es.ieci.tecdoc.isicres.admin.estructura.dao;

/**
 * Mantiene el conjunto de perfiles de un usuario.
 */

public interface UserProfiles
{

	public void add(UserProfile profile);

	public UserProfile get(int index);

	public int count();

   /**
    * Devuelve un perfil de la lista a partir del identificador de producto.
    *
    * @param productId Identificador del producto cuyo perfil se desea.
    * @return El perfil mencionado.
    * @throws Exception Si el perfil para el producto solicitado no existe.
    */

   public UserProfile getProductProfile(int productId) throws Exception;

   /**
    * Obtiene la informaci�n de los perfiles de un usuario en formato XML.
    *
    * @param header Indica si hay que incluir la cabecera xml o no.
    * @return La informaci�n mencionada.
    */

   public String toXML(boolean header);

   /**
    * Muestra una representaci�n de los valores de la clase en formato XML.
    *
    * @return La representaci�n mencionada.
    */

	public String toString();

}