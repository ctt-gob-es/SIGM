
package es.ieci.tecdoc.isicres.admin.database;

import org.apache.log4j.Logger;

import es.ieci.tecdoc.isicres.admin.estructura.keys.ISicresAdminUserDefsKeys;
import es.ieci.tecdoc.isicres.admin.sbo.acs.base.AcsProduct;
import es.ieci.tecdoc.isicres.admin.sbo.acs.std.AcsDaoGenPermTbl;
import es.ieci.tecdoc.isicres.admin.sbo.acs.std.AcsDaoObjHdrTbl;
import es.ieci.tecdoc.isicres.admin.sbo.acs.std.AcsDaoObjPermTbl;
import es.ieci.tecdoc.isicres.admin.sbo.acs.std.AcsDaoUserTypeTbl;
import es.ieci.tecdoc.isicres.admin.sbo.uas.ldap.UasDaoLdapGroupTbl;
import es.ieci.tecdoc.isicres.admin.sbo.uas.ldap.UasDaoLdapUserTbl;
import es.ieci.tecdoc.isicres.admin.sbo.uas.std.UasDaoDeptTbl;

public class LdapUsersTable
{

   public LdapUsersTable()
   {
   }

   /////////////////////////////////////////////////////////////////////////
   //                            Quals                                    //
   /////////////////////////////////////////////////////////////////////////

   /**
    * Construye una expresi�n de b�squeda para extraer todos los usuarios.
    *
    * @param id El identificador de usuario.
    * @return La expresi�n mencionada.
    */

   public String getLoadBaseAllQual()
   {
      String qual;

      qual = "";

      return qual;
   }

   public String getLoadUsersAssociated(int []idsUser, int idOfic) {
	  StringBuffer sb = new StringBuffer();
      sb.append("WHERE ").append(UasDaoLdapUserTbl.TN).append(".").append(UasDaoLdapUserTbl.CD_ID.getName()).append(" IN(");
      for(int i=0; i< idsUser.length; i++){
    	  sb.append(idsUser[i]);
    	  if(i!=idsUser.length-1)
    		  sb.append(",");
      }
      sb.append(")");
      sb.append(" AND ").append(UasDaoLdapUserTbl.TN).append(".").append(UasDaoLdapUserTbl.CD_ID.getName()).append(" NOT IN( ");
      sb.append("SELECT iduser FROM scr_usrofic").append(" WHERE idofic").append("=").append(idOfic).append(")");

      if (_logger.isDebugEnabled())
         _logger.debug("getLoadUsersAsociation: " + sb.toString());

      return sb.toString();
   }

   public String getUserByAplicationTableNames() {
		return UasDaoLdapUserTbl.TN + ", " + UasDaoLdapGroupTbl.TN + ", "
				+ UasDaoDeptTbl.TN + ", " + AcsDaoUserTypeTbl.TN;
	}

   /**
	 * Construye una expresi�n de b�squeda para la tabla base de usuarios a
	 * partir del identificador.
	 *
	 * @param id
	 *            El identificador de usuario.
	 * @return La expresi�n mencionada.
	 */

   public String getLoadBaseQual(int id)
   {
      String qual;

      qual = "WHERE " + getBaseTableName() + "." +
             UasDaoLdapUserTbl.CD_ID.getName() + "=" + Integer.toString(id);

      if (_logger.isDebugEnabled())
         _logger.debug("getLoadBaseQual: " + qual);

      return qual;
   }

   /**
    * Construye una expresi�n de b�squeda para la tabla base de usuarios a
    * partir del identificador ldap.
    *
    * @param id El identificador de usuario ldap.
    * @return La expresi�n mencionada.
    */

   public String getLoadBaseQual(String guid)
   {
      String qual;

      qual = "WHERE " + getBaseTableName() + "." +
             UasDaoLdapUserTbl.CD_LDAPGUID.getName() + "='" + guid + "'";

      if (_logger.isDebugEnabled())
         _logger.debug("getLoadBaseQual: " + qual);

      return qual;
   }

   /**
    * Construye una expresi�n de b�squeda para la tabla de perfiles de usuarios
    * a partir del identificador.
    *
    * @param id El identificador de usuario.
    * @return La expresi�n mencionada.
    */

   public String getLoadProfilesQual(int id)
   {
      String qual;

      qual = "WHERE " + getProfilesTableName() + "." +
             AcsDaoUserTypeTbl.CD_USERID.getName() + "=" + Integer.toString(id);

      if (_logger.isDebugEnabled())
         _logger.debug("getLoadProfilesQual: " + qual);

      return qual;
   }

   /**
    * Construye una expresi�n de actualizaci�n para la tabla de perfiles de
    * usuarios.
    *
    * @param id El identificador de usuario.
    * @param productId El identificador de producto.
    * @return La expresi�n mencionada.
    */

   public String getUpdateProfilesQual(int id, int productId)
   {
      String qual;

      qual = "WHERE " + getProfilesTableName() + "." +
             AcsDaoUserTypeTbl.CD_USERID.getName() + "=" + Integer.toString(id) +
             " AND " + getProfilesTableName() + "." +
             AcsDaoUserTypeTbl.CD_PRODID.getName() + "=" +
             Integer.toString(productId);

      if (_logger.isDebugEnabled())
         _logger.debug("getUpdateProfilesQual: " + qual);

      return qual;
   }

   /**
    * Construye una expresi�n de b�squeda para la tabla de permisos de usuarios,
    * grupos o departamentos a partir del identificador y del destino.
    *
    * @param userId El identificador de objeto.
    * @param dest El destino (usuario, grupo, departamento).
    * @return La expresi�n mencionada.
    */

   public String getLoadPermsQual(int id, int dest)
   {
      String qual;

      qual = "WHERE " + getPermsTableName() + "." +
             AcsDaoGenPermTbl.CD_DSTID.getName() + "=" + Integer.toString(id) +
             " AND " + getPermsTableName() + "." +
             AcsDaoGenPermTbl.CD_DSTTYPE.getName() + "=" + Integer.toString(dest);

      if (_logger.isDebugEnabled())
         _logger.debug("getLoadPermsQual: " + qual);

      return qual;
   }

   /**
    * Construye una expresi�n de b�squeda para la tabla de permisos de usuarios
    * a partir del identificador, grupo o departamento.
    *
    * @param id El identificador de objeto.
    * @param dest El destino (usuario, grupo, departamento).
    * @param productId El identificador producto (iDoc, iFlow, iSicres).
    * @return La expresi�n mencionada.
    */

   public String getUpdatePermsQual(int id, int dest, int productId)
   {
      String qual;

      qual = "WHERE " + getPermsTableName() + "." +
             AcsDaoGenPermTbl.CD_DSTID.getName() + "=" +
             Integer.toString(id) + " AND " + getPermsTableName() + "." +
             AcsDaoGenPermTbl.CD_DSTTYPE.getName() + "=" +
             Integer.toString(dest) + " AND " + getPermsTableName() + "." +
             AcsDaoGenPermTbl.CD_PRODID.getName()
             + "=" + Integer.toString(productId);

      if (_logger.isDebugEnabled())
         _logger.debug("getUpdatePermsQual: " + qual);

      return qual;
   }

   /**
    * Construye una expresi�n de b�squeda para los directorios y archivadores
    * de los que es propietario el usuario.
    *
    * @param userId El identificador de usuario.
    * @param ownerType El tipo de propietario (usuario, grupo, departamento).
    * @param productId El identificador producto (iDoc, iFlow, iSicres).
    * @param objTypeDir El tipo de objeto directorio.
    * @param objTypeArch El tipo de objeto archivador.
    * @param extId2
    * @return La expresi�n mencionada.
    */

   public String getUpdateOwnerDirArchQual(int userId, int ownerType,
                                       int productId, int objTypeDir,
                                       int objTypeArch, int extId2)
   {
      String qual;

      qual = "WHERE " + getOwnershipTableName() + "." +
             AcsDaoObjHdrTbl.CD_OWNERTYPE.getName() + "=" +
             Integer.toString(ownerType) + " AND " + getOwnershipTableName() +
             "." + AcsDaoObjHdrTbl.CD_OWNERID.getName() + "=" +
             Integer.toString(userId) + " AND " + getOwnershipTableName() +
             "." + AcsDaoObjHdrTbl.CD_PRODID.getName()
             + "=" + Integer.toString(productId) + " AND (" +
             getOwnershipTableName() + "." + AcsDaoObjHdrTbl.CD_TYPE.getName() +
             "=" + Integer.toString(objTypeDir) + " OR (" +
             getOwnershipTableName() + "." + AcsDaoObjHdrTbl.CD_TYPE.getName() +
             "=" + Integer.toString(objTypeArch) + " AND " + getOwnershipTableName()
             + "." + AcsDaoObjHdrTbl.CD_EXTID2.getName() + "=" +
             Integer.toString(extId2) + "))";

      if (_logger.isDebugEnabled())
         _logger.debug("getUpdateOwnerArchQual: " + qual);

      return qual;
   }

   /**
    * Construye una expresi�n de b�squeda para todos los objetos de los que es
    * propietario el usuario, grupo o departamento.
    *
    * @param id El identificador de objeto.
    * @param ownerType El tipo de propietario (usuario, grupo, departamento).
    * archivador).
    * @return La expresi�n mencionada.
    */

   public String getUpdateOwnerQual(int id, int ownerType)
   {
      String qual;

      qual = "WHERE " + getOwnershipTableName() + "." +
             AcsDaoObjHdrTbl.CD_OWNERTYPE.getName() + "=" +
             Integer.toString(ownerType) + " AND " + getOwnershipTableName() +
             "." + AcsDaoObjHdrTbl.CD_OWNERID.getName() + "=" +
             Integer.toString(id);

      if (_logger.isDebugEnabled())
         _logger.debug("getUpdateOwnerQual: " + qual);

      return qual;
   }

   /**
    * Construye una expresi�n de b�squeda para el id del objeto.
    *
    * @param id El identificador de objeto.
    * @return La expresi�n mencionada.
    */

   public String getSelectOwnerQual(int id)
   {
      String qual;

      qual = "WHERE " + getOwnershipTableName() +
             "." + AcsDaoObjHdrTbl.CD_ID.getName() + "=" +
             Integer.toString(id);

      if (_logger.isDebugEnabled())
         _logger.debug("getSelectOwnerQual: " + qual);

      return qual;
   }


   /**
    * Construye una expresi�n de b�squeda para eliminar los permisos sobre
    * objetos de los que era propietario el usuario, grupo o departamento.
    *
    * @param id El identificador de objeto.
    * @param dest El destinatario (usuario, grupo, departamento).
    * @param perm Permiso a quitar.
    * @param productId El identificador producto (iDoc, iFlow, iSicres).
    * @return La expresi�n mencionada.
    */

   public String getDeleteObjPermQual(int id, int dest, int perm,
                                       int productId)
   {
      String qual;

      qual = "WHERE " + getObjPermsTableName() + "." +
             AcsDaoObjPermTbl.CD_DSTTYPE.getName() + "=" +
             Integer.toString(dest) + " AND " + getObjPermsTableName() +
             "." + AcsDaoObjPermTbl.CD_DSTID.getName() + "=" +
             Integer.toString(id) + " AND " + getObjPermsTableName() +
             "." + AcsDaoObjPermTbl.CD_PERM.getName()
             + "=" + Integer.toString(perm) + " AND EXISTS (SELECT " +
             getOwnershipTableName() + "." + AcsDaoObjHdrTbl.CD_ID.getName() +
             " FROM " + getOwnershipTableName() + " WHERE " +
             getOwnershipTableName() + "." + AcsDaoObjHdrTbl.CD_PRODID.getName()
             + "=" + Integer.toString(productId) + " AND " +
             getOwnershipTableName() + "." + AcsDaoObjHdrTbl.CD_ID.getName() +
             "=" + getObjPermsTableName() + "." +
             AcsDaoObjPermTbl.CD_OBJID.getName() + ")";

      if (_logger.isDebugEnabled())
         _logger.debug("getDeleteObjPermQual: " + qual);

      return qual;
   }

   /**
    * Construye una expresi�n de b�squeda para eliminar el usuario de la tabla
    * principal.
    *
    * @param userId El identificador de usuario.
    * @return La expresi�n mencionada.
    */

   public String getDeleteBaseQual(int userId)
   {
      String qual;

      qual = "WHERE " + getBaseTableName() + "." +
             UasDaoLdapUserTbl.CD_ID.getName() + "=" +
             Integer.toString(userId);

      if (_logger.isDebugEnabled())
         _logger.debug("getDeleteBaseQual: " + qual);

      return qual;
   }

   /**
    * Construye una expresi�n de b�squeda para eliminar un objeto de la tabla
    * de objetos.
    *
    * @param id El identificador del objeto.
    * @return La expresi�n mencionada.
    */

   public String getDeleteOwnershipById(int id)
   {
      String qual;

      qual = "WHERE " + getOwnershipTableName() + "." +
             AcsDaoObjHdrTbl.CD_ID.getName() + "=" +
             Integer.toString(id);

      if (_logger.isDebugEnabled())
         _logger.debug("getDeleteOwnershipById: " + qual);

      return qual;
   }

   /**
    * Construye una expresi�n de b�squeda para eliminar los perfiles del usuario.
    *
    * @param userId El identificador de usuario.
    * @return La expresi�n mencionada.
    */

   public String getDeleteProfilesQual(int userId)
   {
      String qual;

      qual = "WHERE " + getProfilesTableName() + "." +
             AcsDaoUserTypeTbl.CD_USERID.getName() + "=" +
             Integer.toString(userId);

      if (_logger.isDebugEnabled())
         _logger.debug("getDeleteProfilesQual: " + qual);

      return qual;
   }

   /**
    * Construye una expresi�n de b�squeda para eliminar los permisos del usuario
    * , grupo o departamento.
    *
    * @param id El identificador de usuario, grupo o departamento.
    * @param dest El destinatario (usuario, grupo, departamento).
    * @return La expresi�n mencionada.
    */

   public String getDeletePermsQual(int id, int dest)
   {
      String qual;

      qual = "WHERE " + getPermsTableName() + "." +
             AcsDaoGenPermTbl.CD_DSTTYPE.getName() + "=" +
             Integer.toString(dest) + " AND " + getPermsTableName() + "." +
             AcsDaoGenPermTbl.CD_DSTID.getName() + "=" +
             Integer.toString(id);

      if (_logger.isDebugEnabled())
         _logger.debug("getDeletePermsQual: " + qual);

      return qual;
   }

   /**
    * Construye una expresi�n de b�squeda para eliminar los permisos sobre
    * objetos del usuario, grupo o departamento.
    *
    * @param userId El identificador del objeto.
    * @param dest El destinatario (usuario, grupo, departamento).
    * @return La expresi�n mencionada.
    */

   public String getDeleteObjPermsQual(int id, int dest)
   {
      String qual;

      qual = "WHERE " + getObjPermsTableName() + "." +
             AcsDaoObjPermTbl.CD_DSTTYPE.getName() + "=" +
             Integer.toString(dest) + " AND " + getObjPermsTableName() + "." +
             AcsDaoObjPermTbl.CD_DSTID.getName() + "=" +
             Integer.toString(id);

      if (_logger.isDebugEnabled())
         _logger.debug("getDeleteObjPermsQual: " + qual);

      return qual;
   }

   /**
    * Construye una expresi�n de b�squeda para eliminar los permisos sobre
    * objetos a partir de un identificador de objeto.
    *
    * @param id El identificador del objeto.
    * @return La expresi�n mencionada.
    */

   public String getDeleteObjPermsByObjIdQual(int id)
   {
      String qual;

      qual = "WHERE " + getObjPermsTableName() + "." +
             AcsDaoObjPermTbl.CD_OBJID.getName() + "=" +
             Integer.toString(id);

      if (_logger.isDebugEnabled())
         _logger.debug("getDeleteObjPermsByObjIdQual: " + qual);

      return qual;
   }

   public String getDeleteObjPermQual(int dstType, int dstId, int typeObj,
                                           int id, int perm)
   {
      String qual;

      qual = "WHERE " + getObjPermsTableName() + "." + AcsDaoObjPermTbl.CD_DSTTYPE.getName() + "=" +
      		Integer.toString(dstType) + " AND " +
      		getObjPermsTableName() + "." + AcsDaoObjPermTbl.CD_DSTID.getName() + "=" +
      		Integer.toString(dstId) + " AND " +
      		getObjPermsTableName() + "." + AcsDaoObjPermTbl.CD_PERM.getName() + "=" +
      		Integer.toString(perm) + " AND EXISTS(SELECT " +
      		getOwnershipTableName() + "." + AcsDaoObjHdrTbl.CD_ID.getName() + " FROM " +
      		getOwnershipTableName() + " WHERE " +
      		getOwnershipTableName() + "." + AcsDaoObjHdrTbl.CD_PRODID.getName() + "=" +
      		Integer.toString(AcsProduct.IDOC) + " AND " +
      		getOwnershipTableName() + "." + AcsDaoObjHdrTbl.CD_TYPE.getName() + "=" +
      		Integer.toString(typeObj) + " AND " +
      		getOwnershipTableName() + "." + AcsDaoObjHdrTbl.CD_EXTID1.getName() + "=" +
      		Integer.toString(id) + " AND " +
      		getOwnershipTableName() + "." + AcsDaoObjHdrTbl.CD_ID.getName() + "=" +
      		getObjPermsTableName() + "." + AcsDaoObjPermTbl.CD_OBJID.getName() + ")";


      return qual;

   }

   public String getLoadObjPermsQual(int dstType,int dstId, int objType, int id)
   {
      String qual;

      qual = "WHERE " + getObjPermsTableName() + "." + AcsDaoObjPermTbl.CD_DSTTYPE.getName() + "=" +
				Integer.toString(dstType) + " AND " +
				getObjPermsTableName() + "." + AcsDaoObjPermTbl.CD_DSTID.getName() + "=" +
				Integer.toString(dstId) + " AND " +
				getObjPermsTableName() + "." + AcsDaoObjPermTbl.CD_OBJID.getName() + " IN (SELECT " +
				getOwnershipTableName() + "." + AcsDaoObjHdrTbl.CD_ID.getName() + " FROM " +
				getOwnershipTableName() + " WHERE " +
				getOwnershipTableName() + "." + AcsDaoObjHdrTbl.CD_TYPE.getName() + "=" +
				Integer.toString(objType) + " AND " +
				getOwnershipTableName() + "." + AcsDaoObjHdrTbl.CD_EXTID1.getName() + "=" +
				Integer.toString(id) + ")";


      return qual;
   }

   /**
    * Construye una expresi�n de b�squeda para buscar el propietario de un
    * objeto.
    *
    * @param id El identificador del objeto.
    * @return La expresi�n mencionada.
    */

   public String getLoadOwnerIdQual(int id)
   {
      String qual;

      qual = "WHERE " + getOwnershipTableName() + "." +
             AcsDaoObjHdrTbl.CD_ID.getName() + "=" +
             Integer.toString(id);

      if (_logger.isDebugEnabled())
         _logger.debug("getLoadOwnerIdQual: " + qual);

      return qual;
   }

   /**
    * Construye una expresi�n de b�squeda para obtener todos los usuarios
    * susceptibles de ser administradores de algo de invesDoc.
    *
    * @param id El identificador del objeto.
    * @return La expresi�n mencionada.
    */

   public String getLoadAminUsersQual(int productId)
   {
      String qual;

      qual = "WHERE " + getBaseTableName() + "." +
             UasDaoLdapUserTbl.CD_ID.getName() + " IN (SELECT " +
             getProfilesTableName() + "." + AcsDaoUserTypeTbl.CD_USERID.getName()
             + " FROM " + getProfilesTableName() + " WHERE (" +
             getProfilesTableName() + "." + AcsDaoUserTypeTbl.CD_TYPE.getName()
             + "=" + ISicresAdminUserDefsKeys.PROFILE_MANAGER + " OR " + getProfilesTableName()
             + "." + AcsDaoUserTypeTbl.CD_TYPE.getName() + "=" +
             ISicresAdminUserDefsKeys.PROFILE_SUPERUSER + ") AND (" + getProfilesTableName() +
             "." + AcsDaoUserTypeTbl.CD_PRODID.getName() + "=" +
             Integer.toString(productId) + " OR " + getProfilesTableName() + "."
             + AcsDaoUserTypeTbl.CD_PRODID.getName() + "=" +
             ISicresAdminUserDefsKeys.PRODUCT_SYSTEM + "))";

      if (_logger.isDebugEnabled())
         _logger.debug("getLoadAminUsersQual: " + qual);

      return qual;
   }


   /////////////////////////////////////////////////////////////////////////
   //                         Nombres de Tablas                           //
   /////////////////////////////////////////////////////////////////////////

   /**
    * Devuelve los nombres de todas las tablas de invesDoc involucradas en la
    * inserci�n de un nuevo usuario Ldap.
    *
    * @return Las tablas mencionadas.
    */

   public String getAllTableNames()
   {
      return getBaseTableName() + "," +
             getProfilesTableName() + "," +
             getPermsTableName();
   }

   public String getBaseTableNameWithPerfil() {
		return getBaseTableName() + ", " + getProfilesTableName();
	}


   /**
    * Devuelve el nombre tabla base invesDoc de usuario Ldap.
    *
    * @return Las tabla mencionada.
    */

   public String getBaseTableName()
   {
      return UasDaoLdapUserTbl.TN;
   }

   /**
    * Devuelve el nombre tabla de perfiles de un usuario Ldap.
    *
    * @return Las tabla mencionada.
    */

   public String getProfilesTableName()
   {
      return AcsDaoUserTypeTbl.TN;
   }

   /**
    * Devuelve el nombre tabla de permisos de un usuario Ldap.
    *
    * @return Las tabla mencionada.
    */

   public String getPermsTableName()
   {
      return AcsDaoGenPermTbl.TN;
   }

   /**
    * Devuelve el nombre de la tabla de propietarios de objetos.
    *
    * @return Las tabla mencionada.
    */

   public String getOwnershipTableName()
   {
      return AcsDaoObjHdrTbl.TN;
   }

   /**
    * Devuelve el nombre de la tabla de permisos sobre objetos.
    *
    * @return Las tabla mencionada.
    */

   public String getObjPermsTableName()
   {
      return AcsDaoObjPermTbl.TN;
   }

   /**
    * Devuelve el nombre de las tablas involucradas en la eliminaci�n de
    * permisos sobre objetos.
    *
    * @return Las tablas mencionadas.
    */

   public String getDeleteObjPermsTableNames()
   {
      return getOwnershipTableName() + "," + getObjPermsTableName();
   }

   /**
    * Devuelve el nombre de las tablas involucradas en la b�squeda de usuarios
    * administradores de objetos.
    *
    * @return Las tablas mencionadas.
    */

   public String getUserAdminTableNames()
   {
      return getBaseTableName() + "," + getProfilesTableName();
   }

   /////////////////////////////////////////////////////////////////////////
   //                         Nombres de Columnas                         //
   /////////////////////////////////////////////////////////////////////////

   /**
    * Devuelve todas las columnas de invesDoc involucradas en la inserci�n de un
    * nuevo usuario Ldap.
    *
    * @return Las columnas mencionadas.
    */

   public String getAllColumnNames()
   {
      String val;

      val = getBaseTableName() + "." +  UasDaoLdapUserTbl.CD_ID.getName() +
             "," + getBaseTableName() + "." +
             UasDaoLdapUserTbl.CD_LDAPGUID.getName() + "," +
             getBaseTableName() + "." + UasDaoLdapUserTbl.CD_LDAPFULLNAME.
             getName() + "," + getProfilesTableName() + "." +
             AcsDaoUserTypeTbl.CD_USERID.getName() + "," + getProfilesTableName() +
             "." + AcsDaoUserTypeTbl.CD_PRODID.getName() + "," +
             getProfilesTableName() + "." + AcsDaoUserTypeTbl.CD_TYPE.getName() +
             "," + getPermsTableName() + "." +
             AcsDaoGenPermTbl.CD_DSTTYPE.getName() + "," + getPermsTableName() +
             "." + AcsDaoGenPermTbl.CD_DSTID.getName() + "," +
             getPermsTableName() + "." + AcsDaoGenPermTbl.CD_PRODID.getName() +
             "," + getPermsTableName() + "." +
             AcsDaoGenPermTbl.CD_PERMS.getName();

      return val;
   }

   /**
    * Devuelve las columnas id y nombre de la tabla base de usuarios Ldap.
    *
    * @return Las columnas mencionadas.
    */

   public String getAdminUserColumnNames()
   {
      String val;

      val = getBaseTableName() + "." +  UasDaoLdapUserTbl.CD_ID.getName() +
            "," + getBaseTableName() + "." +
            UasDaoLdapUserTbl.CD_LDAPFULLNAME.getName();

      return val;
   }

   /**
    * Devuelve todas las columnas de invesDoc de la tabla base de usuarios Ldap
    * para su inserci�n.
    *
    * @return Las columnas mencionadas.
    */

   public String getInsertBaseColumnNames()
   {
      String val;
      /*
      val = getBaseTableName() + "." +  UasDaoLdapUserTbl.CD_ID.getName() +
             "," + getBaseTableName() + "." +
             UasDaoLdapUserTbl.CD_LDAPGUID.getName() + "," +
             getBaseTableName() + "." + UasDaoLdapUserTbl.CD_LDAPFULLNAME.
             getName();
      */
  	/*
  	 * @SF-SEVILLA Modificacion para compatibilidad con postgresql
  	 * 02-may-2006 / antmaria
  	 */
      val = UasDaoLdapUserTbl.CD_ID.getName() + "," +
      		UasDaoLdapUserTbl.CD_LDAPGUID.getName() + "," +
      		UasDaoLdapUserTbl.CD_LDAPFULLNAME.getName();
      return val;
   }

   /**
    * Devuelve la columna identificador de usuario.
    *
    * @return La columna mencionada.
    */

   public String getLoadBaseIdColumnName()
   {
      String val;

      val = getBaseTableName() + "." +
            UasDaoLdapUserTbl.CD_ID.getName();

      return val;
   }

   /**
    * Devuelve todas las columnas de invesDoc de la tabla base de usuarios Ldap
    * utilizadas en la carga de un usuario excepto el identificador.
    *
    * @return Las columnas mencionadas.
    */

   public String getLoadBaseColumnNames()
   {
      String val;

      val = getBaseTableName() + "." +
            UasDaoLdapUserTbl.CD_LDAPGUID.getName() + "," + getBaseTableName() +
            "." + UasDaoLdapUserTbl.CD_LDAPFULLNAME.getName();

      return val;
   }

   /**
    * Devuelve todas las columnas de invesDoc de la tabla base de usuarios Ldap
    * utilizadas en la carga de un usuario.
    *
    * @return Las columnas mencionadas.
    */

   public String getLoadBaseAllColumnNames()
   {
      String val;

      val = getBaseTableName() + "." +  UasDaoLdapUserTbl.CD_ID.getName() + ","
            + getBaseTableName() + "." + UasDaoLdapUserTbl.CD_LDAPGUID.getName()
            + "," + getBaseTableName() + "." +
            UasDaoLdapUserTbl.CD_LDAPFULLNAME.getName();

      return val;
   }

   public String getLoadBaseByAplicacion(int aplicacion, int deptId[],
			boolean sinPermisos, boolean usuarios, boolean superusuarios) {
		StringBuffer sb = new StringBuffer();
		sb.append("WHERE ").append(AcsDaoUserTypeTbl.TN).append(".").append(
				AcsDaoUserTypeTbl.CD_PRODID.getName()).append(" = ").append(
				aplicacion);
		sb.append(" AND ").append(AcsDaoUserTypeTbl.TN).append(".").append(
				AcsDaoUserTypeTbl.CD_USERID.getName()).append(" = ").append(
				UasDaoLdapUserTbl.TN).append(".").append(
				UasDaoLdapUserTbl.CD_ID.getName());
		sb.append(" AND ").append(UasDaoLdapGroupTbl.TN).append(".").append(
				UasDaoLdapGroupTbl.CD_ID.getName()).append(" = ").append(
				UasDaoDeptTbl.TN).append(".").append(
				UasDaoDeptTbl.CD_CRTRID.getName());
		if (sinPermisos || usuarios || superusuarios) {
			sb.append(" AND (");
		}
		if (sinPermisos) {
			sb.append(AcsDaoUserTypeTbl.TN).append(".").append(
					AcsDaoUserTypeTbl.CD_TYPE.getName()).append(" = 0");
			if (usuarios || superusuarios) {
				sb.append(" OR ");
			}
		}
		if (usuarios) {
			sb.append(AcsDaoUserTypeTbl.TN).append(".").append(
					AcsDaoUserTypeTbl.CD_TYPE.getName()).append(" = 1");
			if (superusuarios) {
				sb.append(" OR ");
			}
		}
		if (superusuarios) {
			sb.append(AcsDaoUserTypeTbl.TN).append(".").append(
					AcsDaoUserTypeTbl.CD_TYPE.getName()).append(" = 3");
		}
		if (sinPermisos || usuarios || superusuarios) {
			sb.append(")");
		}

		if (deptId.length > 0 && deptId[0] != -1) {
			sb.append(" AND ").append(UasDaoDeptTbl.TN).append(".").append(
					UasDaoDeptTbl.CD_ID.getName()).append(" IN(");
			for (int i = 0; i < deptId.length; i++) {
				sb.append(deptId[i]);
				if (i != deptId.length - 1)
					sb.append(",");
			}
			sb.append(")");
		}

		if (_logger.isDebugEnabled())
			_logger.debug("getLoadBaseByAplicacion: " + sb.toString());

		return sb.toString();
	}

   /**
    * Devuelve todas las columnas de invesDoc de la tabla de perfiles de
    * usuarios para su inserci�n.
    *
    * @return Las columnas mencionadas.
    */

   public String getInsertProfilesColumnNames()
   {
      String val;
      /*
      val = getProfilesTableName() + "." +
             AcsDaoUserTypeTbl.CD_USERID.getName() + "," + getProfilesTableName() +
             "." + AcsDaoUserTypeTbl.CD_PRODID.getName() + "," +
             getProfilesTableName() + "." + AcsDaoUserTypeTbl.CD_TYPE.getName();
      */
  	/*
  	 * @SF-SEVILLA Modificacion para compatibilidad con postgresql
  	 * 02-may-2006 / antmaria
  	 */
      val = AcsDaoUserTypeTbl.CD_USERID.getName()
      		+ "," + AcsDaoUserTypeTbl.CD_PRODID.getName()
      		+ "," + AcsDaoUserTypeTbl.CD_TYPE.getName();
      return val;
   }

   /**
    * Devuelve todas las columnas de invesDoc de la tabla de perfiles de
    * usuarios utilizadas en la carga de un usuario.
    *
    * @return Las columnas mencionadas.
    */

   public String getLoadProfilesColumnNames()
   {
      String val;

      val = getProfilesTableName() + "." + AcsDaoUserTypeTbl.CD_PRODID.getName() +
            "," + getProfilesTableName() + "." +
            AcsDaoUserTypeTbl.CD_TYPE.getName();

      return val;
   }

   public String getLoadObjPermColumnName()
   {
      String val;

      val = getObjPermsTableName() + "." + AcsDaoObjPermTbl.CD_PERM.getName();

      return val;
   }

   /**
    * Devuelve todas las columnas de invesDoc de la tabla de perfiles de
    * usuarios que se pueden actualizar.
    *
    * @return Las columnas mencionadas.
    */

   public String getUpdateProfilesColumnNames()
   {
      String val;

      // val = getProfilesTableName() + "." + AcsDaoUserTypeTbl.CD_TYPE.getName();
  	/*
  	 * @SF-SEVILLA Modificacion para compatibilidad con postgresql
  	 * 02-may-2006 / antmaria
  	 */
      val = AcsDaoUserTypeTbl.CD_TYPE.getName();

      return val;
   }

   /**
    * Devuelve todas las columnas de invesDoc de la tabla de permisos de
    * usuarios para su inserci�n.
    *
    * @return Las columnas mencionadas.
    */

   public String getInsertPermsColumnNames()
   {
      String val;
      /*
      val = getPermsTableName() + "." + AcsDaoGenPermTbl.CD_DSTTYPE.getName() +
            "," + getPermsTableName() + "." +
            AcsDaoGenPermTbl.CD_DSTID.getName() + "," + getPermsTableName() +
            "." + AcsDaoGenPermTbl.CD_PRODID.getName() + "," +
            getPermsTableName() + "." + AcsDaoGenPermTbl.CD_PERMS.getName();
      */
  	/*
  	 * @SF-SEVILLA Modificacion para compatibilidad con postgresql
  	 * 02-may-2006 / antmaria
  	 */
      val = AcsDaoGenPermTbl.CD_DSTTYPE.getName() +
      		"," + AcsDaoGenPermTbl.CD_DSTID.getName() +
      		"," + AcsDaoGenPermTbl.CD_PRODID.getName() +
      		"," + AcsDaoGenPermTbl.CD_PERMS.getName();
      return val;
   }

   /**
    * Devuelve todas las columnas de invesDoc de la tabla de permisos de
    * usuarios utilizadas en la carga de un usuario.
    *
    * @return Las columnas mencionadas.
    */

   public String getLoadPermsColumnNames()
   {
      String val;

      val = getPermsTableName() + "." + AcsDaoGenPermTbl.CD_DSTTYPE.getName() +
            "," + getPermsTableName() + "." +
            AcsDaoGenPermTbl.CD_PRODID.getName() + "," +
            getPermsTableName() + "." + AcsDaoGenPermTbl.CD_PERMS.getName();

      return val;
   }

   /**
    * Devuelve todas las columnas de invesDoc de la tabla de permisos que se
    * pueden actualizar.
    *
    * @return Las columnas mencionadas.
    */

   public String getUpdatePermsColumnNames()
   {
      String val;

      // val = getPermsTableName() + "." + AcsDaoGenPermTbl.CD_PERMS.getName();
      //    SUSTITUIDO POR:
  	/*
  	 * @SF-SEVILLA Modificacion para compatibilidad con postgresql
  	 * 02-may-2006 / antmaria
  	 */
      val = AcsDaoGenPermTbl.CD_PERMS.getName();

      return val;
   }

   public String getInsertObjPermsColumnNames()
   {
      String val;
      /*
      val = getObjPermsTableName() + "." + AcsDaoObjPermTbl.CD_DSTTYPE.getName() + "," +
            getObjPermsTableName() + "." + AcsDaoObjPermTbl.CD_DSTID.getName() + "," +
            getObjPermsTableName() + "." + AcsDaoObjPermTbl.CD_OBJID.getName() + "," +
            getObjPermsTableName() + "." + AcsDaoObjPermTbl.CD_PERM.getName();
      */
  	/*
  	 * @SF-SEVILLA Modificacion para compatibilidad con postgresql
  	 * 02-may-2006 / antmaria
  	 */
      val = AcsDaoObjPermTbl.CD_DSTTYPE.getName() + "," +
      		AcsDaoObjPermTbl.CD_DSTID.getName() + "," +
      		AcsDaoObjPermTbl.CD_OBJID.getName() + "," +
      		AcsDaoObjPermTbl.CD_PERM.getName();


      return val;
   }

   /**
    * Devuelve todas las columnas de invesDoc de la tabla de propietarios
    * de objetos.
    *
    * @return Las columnas mencionadas.
    */

   public String getAllOwnershipColumnNames()
   {
      String val;
      /*
      val = getOwnershipTableName() + "." + AcsDaoObjHdrTbl.CD_ID.getName() + "," +
            getOwnershipTableName() + "." + AcsDaoObjHdrTbl.CD_PRODID.getName() + "," +
            getOwnershipTableName() + "." + AcsDaoObjHdrTbl.CD_TYPE.getName() + "," +
            getOwnershipTableName() + "." + AcsDaoObjHdrTbl.CD_EXTID1.getName() + "," +
            getOwnershipTableName() + "." + AcsDaoObjHdrTbl.CD_EXTID2.getName() + "," +
            getOwnershipTableName() + "." + AcsDaoObjHdrTbl.CD_EXTID3.getName() + "," +
            getOwnershipTableName() + "." + AcsDaoObjHdrTbl.CD_OWNERTYPE.getName() + "," +
            getOwnershipTableName() + "." + AcsDaoObjHdrTbl.CD_OWNERID.getName() + "," +
            getOwnershipTableName() + "." + AcsDaoObjHdrTbl.CD_CRTUSRID.getName() + "," +
            getOwnershipTableName() + "." + AcsDaoObjHdrTbl.CD_CRTTS.getName() + "," +
            getOwnershipTableName() + "." + AcsDaoObjHdrTbl.CD_UPDUSRID.getName() + "," +
            getOwnershipTableName() + "." + AcsDaoObjHdrTbl.CD_UPDTS.getName();
      */
  	/*
  	 * @SF-SEVILLA Modificacion para compatibilidad con postgresql
  	 * 02-may-2006 / antmaria
  	 */
      val = AcsDaoObjHdrTbl.CD_ID.getName() +
      		"," + AcsDaoObjHdrTbl.CD_PRODID.getName() +
      		"," + AcsDaoObjHdrTbl.CD_TYPE.getName() +
      		"," + AcsDaoObjHdrTbl.CD_EXTID1.getName() +
      		"," + AcsDaoObjHdrTbl.CD_EXTID2.getName() +
      		"," + AcsDaoObjHdrTbl.CD_EXTID3.getName() +
      		"," + AcsDaoObjHdrTbl.CD_OWNERTYPE.getName() +
      		"," + AcsDaoObjHdrTbl.CD_OWNERID.getName() +
      		"," + AcsDaoObjHdrTbl.CD_CRTUSRID.getName() +
      		"," + AcsDaoObjHdrTbl.CD_CRTTS.getName() +
      		"," + AcsDaoObjHdrTbl.CD_UPDUSRID.getName() +
      		"," + AcsDaoObjHdrTbl.CD_UPDTS.getName();
      return val;
   }

   /**
    * Devuelve las columnas de invesDoc de la tabla de propietarios
    * de objetos que se actualizan con un usuario.
    *
    * @return Las columnas mencionadas.
    */

   public String getUpdateOwnershipColumnNames()
   {
      String val;
      /*
      val = getOwnershipTableName() + "." + AcsDaoObjHdrTbl.CD_OWNERID.getName()
            + "," + getOwnershipTableName() + "." +
            AcsDaoObjHdrTbl.CD_UPDUSRID.getName() + "," +
            getOwnershipTableName() + "." + AcsDaoObjHdrTbl.CD_UPDTS.getName();
      */
	/*
	 * @SF-SEVILLA Modificacion para compatibilidad con postgresql
	 * 02-may-2006 / antmaria
	 */
      val = AcsDaoObjHdrTbl.CD_OWNERID.getName() +
      		"," + AcsDaoObjHdrTbl.CD_UPDUSRID.getName() +
      		"," + AcsDaoObjHdrTbl.CD_UPDTS.getName();

      return val;
   }

   /**
    * Devuelve la columna del identificador del propietario (administrador) de
    * un objeto.
    *
    * @return Las columnas mencionadas.
    */

   public String getOwnerIdColumnName()
   {
      String val;

      val = getOwnershipTableName() + "." + AcsDaoObjHdrTbl.CD_OWNERID.getName();

      return val;
   }

   public String getLoadBaseByIdsUser(int aplicacion, int idsUser[],
			boolean superusuarios) {
		StringBuffer qual = new StringBuffer();

		qual.append("WHERE " + UasDaoLdapUserTbl.TN + "."
				+ UasDaoLdapUserTbl.CD_ID.getName() + " IN(");
		for (int i = 0; i < idsUser.length; i++) {
			qual.append(idsUser[i]);
			if (i != idsUser.length - 1)
				qual.append(",");
		}
		qual.append(")");

		qual.append(" AND ").append(AcsDaoUserTypeTbl.TN).append(".").append(
				AcsDaoUserTypeTbl.CD_PRODID.getName()).append(" = ").append(
				aplicacion);
		qual.append(" AND ").append(AcsDaoUserTypeTbl.TN).append(".").append(
				AcsDaoUserTypeTbl.CD_USERID.getName()).append(" = ").append(
				UasDaoLdapUserTbl.TN).append(".").append(
				UasDaoLdapUserTbl.CD_ID.getName());
		qual.append(" AND (");
		if (superusuarios)
			qual.append(AcsDaoUserTypeTbl.TN).append(".").append(
					AcsDaoUserTypeTbl.CD_TYPE.getName()).append(" = 3");
		else
			qual.append(AcsDaoUserTypeTbl.TN).append(".").append(
					AcsDaoUserTypeTbl.CD_TYPE.getName()).append(" = 1");
		qual.append(")");

		if (_logger.isDebugEnabled())
			_logger.debug("getLoadBaseByIdsUser: " + qual.toString());

		return qual.toString();
	}

   public static String TN_NEXTID = "IUSERNEXTID";

   private static final Logger _logger = Logger.getLogger(LdapUsersTable.class);
}