
package ieci.tecdoc.idoc.admin.api.user;

import ieci.tecdoc.idoc.admin.internal.LdapUsersImpl;

/**
 * Maneja la lista de usuarios invesDoc relacionados con un servicio de 
 * directorio Ldap.
 */

public class LdapUsers 
{

   /**
    * Construye un objeto de la clase.
    *  
    */

   public LdapUsers()
   {
      _usersImpl = new LdapUsersImpl();
   }

   /**
    * Devuelve el n�mero de usuarios.
    * 
    * @return El n�mero de usuarios mencionado.
    */

   public int count() 
   {
      return _usersImpl.count();
   }

   /**
    * Carga la lista de usuarios con su informaci�n b�sica.
    * 
    * @throws Exception Si se produce alg�n error en la carga de los usuarios.
    */

   public void loadLite(String entidad) throws Exception 
   {
      _usersImpl.load(false, entidad);
   }

   /**
    * Carga la lista de usuarios con toda su informaci�n.
    * 
    * @throws Exception Si se produce alg�n error en la carga de los usuarios.
    */

   public void loadFull(String entidad) throws Exception 
   {
      _usersImpl.load(true, entidad);
   }
   
   public void loadUsersLdapAssociated(int []idsUser, int idOfic, String entidad) throws Exception {
	  _usersImpl.loadUsersLdapAssociated(idsUser, idOfic, entidad);
   }
   
   public void loadByAplicacion(int aplicacion, int deptId[], boolean sinPermisos, boolean usuarios, boolean superusuarios, String entidad) throws Exception 
   {
      _usersImpl.loadByAplicacion(aplicacion, deptId, sinPermisos, usuarios, superusuarios, entidad);
   }
   
   public void loadByIdsUser(int aplicacion, int idsUser[],
			boolean superusers, String entidad) throws Exception {
		_usersImpl.loadByIdsUser(aplicacion, idsUser, superusers, entidad);
	}

   /**
    * Devuelve un usuario de la lista.
    * 
    * @param index Indice del usuario que se desea recuperar.
    * 
    * @return El usuario mencionado.
    */

   public LdapUser getUser(int index) 
   {
      return _usersImpl.get(index);
   }
   
   /**
    * Obtiene la informaci�n de la lista de usuarios en formato XML.
    *  
    * @return La lista de usuarios mencionada.
    */

   public String toXML()
   {
      return _usersImpl.toXML(true);
   }

   /**
    * Muestra una representaci�n de los valores de la clase en formato XML.
    *  
    * @return La representaci�n mencionada.
    */

	public String toString()
   {
      return _usersImpl.toString();
   }


   private LdapUsersImpl _usersImpl;
}