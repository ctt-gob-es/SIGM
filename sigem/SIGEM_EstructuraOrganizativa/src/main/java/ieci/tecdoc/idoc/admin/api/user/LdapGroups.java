
package ieci.tecdoc.idoc.admin.api.user;

import ieci.tecdoc.idoc.admin.internal.LdapGroupsImpl;

/**
 * Maneja la lista de grupos invesDoc relacionados con un servicio de 
 * directorio Ldap.
 */

public class LdapGroups 
{

   /**
    * Construye un objeto de la clase.
    *  
    */

   public LdapGroups()
   {
      _groupsImpl = new LdapGroupsImpl();
   }

   /**
    * Devuelve el n�mero de grupos.
    * 
    * @return El n�mero de grupo mencionado.
    */

   public int count() 
   {
      return _groupsImpl.count();
   }

   /**
    * Carga la lista de grupos con su informaci�n b�sica.
    * 
    * @throws Exception Si se produce alg�n error en la carga de los grupos.
    */

   public void loadLite(String entidad) throws Exception 
   {
      _groupsImpl.load(false, entidad);
   }

   /**
    * Carga la lista de grupos con toda su informaci�n.
    * 
    * @throws Exception Si se produce alg�n error en la carga de los grupos.
    */

   public void loadFull(String entidad) throws Exception 
   {
      _groupsImpl.load(true, entidad);
   }

   /**
    * Devuelve un grupo de la lista.
    * 
    * @param index Indice del grupo que se desea recuperar.
    * 
    * @return El grupo mencionado.
    */

   public LdapGroup getGroup(int index) 
   {
      return _groupsImpl.get(index);
   }
   
   /**
    * Obtiene la informaci�n de la lista de grupos en formato XML.
    *  
    * @return La lista de grupo mencionada.
    */

   public String toXML()
   {
      return _groupsImpl.toXML(true);
   }

   /**
    * Muestra una representaci�n de los valores de la clase en formato XML.
    *  
    * @return La representaci�n mencionada.
    */

	public String toString()
   {
      return _groupsImpl.toString();
   }


   private LdapGroupsImpl _groupsImpl;
}