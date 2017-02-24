package ieci.tecdoc.idoc.admin.api.user;

import ieci.tecdoc.idoc.admin.internal.UsersImpl;


/**
 * Maneja la lista de usuarios invesDoc.
 */
public class Users
{
	/**
    * Construye un objeto de la clase.
    *  
    */

   public Users()
   {
      _usersImpl = new UsersImpl();
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
    * Carga la lista de usuarios con su informaci�n b�sica, seg�n un departamento.
    * 
    * @param deptId Identificador del departamento.
    * @throws Exception Si se produce alg�n error en la carga de los usuarios.
    */

   public void loadByDept(int deptId) throws Exception 
   {
      _usersImpl.loadByDept(deptId);
   }
   
   /**
    * Carga la lista de usuarios con su informaci�n b�sica, seg�n un grupo.
    * 
    * @param groupId Identificador del grupo.
    * @throws Exception Si se produce alg�n error en la carga de los usuarios.
    */

   public void loadByGroup(int groupId) throws Exception 
   {
      _usersImpl.loadByGroup(groupId);
   }

   /**
    * Carga la lista de usuarios con su informaci�n b�sica, cuyo nombre 
    * contenga el texto del par�metro subName.
    * 
    * @param subName texto que tiene que contener el nombre de usuario.
    * @throws Exception Si se produce alg�n error en la carga de los usuarios.
    */

   public void loadBySubName(String subName) throws Exception 
   {
      _usersImpl.loadBySubName(subName);
   }

   /**
    * Devuelve un usuario de la lista.
    * 
    * @param index Indice del usuario que se desea recuperar.
    * 
    * @return El usuario mencionado.
    */

   public User getUser(int index) 
   {
      return _usersImpl.get(index);
   }
   
   /**
    * Obtiene la informaci�n de la lista de usuarios en formato XML.
    *  
    * @return La lista de usuarios mencionada.
    */

   /**
    * mueve el usuario al departamento indicado.
    * @param userId Identificador de usuario.
    * @param dstDeptId Identificador del departamento destino.
    */
   public void moveUser(int userId, int dstDeptId) throws Exception
   {
      _usersImpl.moveUser(userId,dstDeptId);
   }
   
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


   private UsersImpl _usersImpl;
}
