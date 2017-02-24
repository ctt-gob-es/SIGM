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

   public void loadByDept(int deptId, String entidad) throws Exception 
   {
      _usersImpl.loadByDept(deptId, entidad);
   }
   
   public void loadByIdsUser(int aplicacion, int idsUser[], boolean superusers, String entidad) throws Exception {
      _usersImpl.loadByIdsUser(aplicacion, idsUser, superusers, entidad);
   }
   
   public void loadUsersAsociation(int aplicacion, int deptId, boolean superusers, String entidad) throws Exception {
	  _usersImpl.loadUsersAsociation(aplicacion, deptId, superusers,entidad);
   }
   
   public void loadUsersAssociated(int []idsUser, int idOfic, String entidad) throws Exception {
		  _usersImpl.loadUsersAssociated(idsUser, idOfic, entidad);
   }
   
   /**
    * Carga la lista de usuarios con su informaci�n b�sica, seg�n un grupo.
    * 
    * @param groupId Identificador del grupo.
    * @throws Exception Si se produce alg�n error en la carga de los usuarios.
    */

   public void loadByGroup(int groupId, String entidad) throws Exception 
   {
      _usersImpl.loadByGroup(groupId, entidad);
   }

   /**
    * Carga la lista de usuarios con su informaci�n b�sica, cuyo nombre 
    * contenga el texto del par�metro subName.
    * 
    * @param subName texto que tiene que contener el nombre de usuario.
    * @throws Exception Si se produce alg�n error en la carga de los usuarios.
    */

   public void loadBySubName(String subName, String entidad) throws Exception 
   {
      _usersImpl.loadBySubName(subName, entidad);
   }

   public void loadByAplicacion(int aplicacion, int deptId[], boolean sinPermisos, boolean usuarios, boolean superusuarios, String entidad) throws Exception 
   {
      _usersImpl.loadByAplicacion(aplicacion, deptId, sinPermisos, usuarios, superusuarios, entidad);
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
   public void moveUser(int userId, int dstDeptId, String entidad) throws Exception
   {
      _usersImpl.moveUser(userId,dstDeptId, entidad);
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
