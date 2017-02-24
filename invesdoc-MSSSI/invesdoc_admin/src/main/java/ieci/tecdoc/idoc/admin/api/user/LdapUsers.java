
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

   public void loadLite() throws Exception 
   {
      _usersImpl.load(false);
   }

   /**
    * Carga la lista de usuarios con toda su informaci�n.
    * 
    * @throws Exception Si se produce alg�n error en la carga de los usuarios.
    */

   public void loadFull() throws Exception 
   {
      _usersImpl.load(true);
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