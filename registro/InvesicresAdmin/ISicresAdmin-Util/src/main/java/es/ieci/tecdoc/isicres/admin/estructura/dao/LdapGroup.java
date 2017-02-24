
package es.ieci.tecdoc.isicres.admin.estructura.dao;


/**
 * Proporciona toda la funcionalidad necesaria para manejar grupos invesDoc
 * relacionados con un servicio de directorio Ldap.
 */

public interface LdapGroup
{

   /**
    * Permite crear un grupo a partir de uno en un servidor Ldap.
    *
    * @param guid guid del grupo ldap.
    * @param Dn  Dn del grupo ldap.
    * @return El grupo.
    * @throws Exception Si se ha producido alg�n error en la creaci�n
    */

   public void createGroup(String guid, String Dn,String entidad)
               throws Exception;

   /**
    * Permite crear un grupo a partir de uno en un servidor Ldap.
    *
    * @param guid guid del grupo ldap.
    * @param Dn  Dn del grupo ldap.
    * @param type Tipo del grupo
    * @return El grupo.
    * @throws Exception Si se ha producido alg�n error en la creaci�n
    */

   public void createGroup(String guid, String Dn, int type, String entidad)
               throws Exception;

   /**
    * Permite crear un grupo a partir de uno existente en un servidor Ldap.
    *
    * @param root Dn del nodo ra�z a partir del cual buscar.
    * @param attr Atributo de b�squeda (t�picamente cn).
    * @param value Valor del atributo de b�squeda (t�picamente el nombre del
    * grupo).
    * @return El grupo que cumple los criterios de b�squeda.
    * @throws Exception Si se ha producido alg�n error en la creaci�n (por
    * ejemplo, el grupo no existe en el servidor Ldap).
    */

   public void createFromLdapGroup(String root, String attr, String value, String entidad)
               throws Exception;

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
    * @param groupGuid Identificador del grupo ldap.
    * @throws Exception Si se produce alg�n error al leer la informaci�n del
    * grupo.
    */

   public void loadFromGuid(String groupGuid, String entidad) throws Exception;

   /**
	 * Carga un grupo invesDoc partir del identificador de un departamento
	 * invesdoc
	 *
	 * @param deptId
	 * @param entidad
	 * @throws Exception
	 */
   public void loadFromDeptId(int deptId, String entidad) throws Exception;

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
    * Devuelve el identificador �nico del grupo.
    *
    * @return El identificador mencionado.
    */

   public String getGuid();

   /**
    * Devuelve el nombre completo del grupo.
    *
    * @return El nombre mencionado.
    */

   public String getFullName();

   /**
    * Devuelve el identificador del grupo.
    *
    * @return El identificador mencionado.
    */

   public int getId();

   /**
    * Establece el nombre completo del grupo.
    *
    * @param fullName El nombre completo del grupo.
    */

   public void setFullName(String fullName);

   /**
    * Devuelve la lista de permisos del grupo.
    *
    * @return La lista mencionada.
    */

   public Permissions getPermissions();

   /**
    * Obtiene la informaci�n del grupo Ldap en formato XML.
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