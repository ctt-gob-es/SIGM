package es.ieci.tecdoc.isicres.admin.estructura.keys;

import es.ieci.tecdoc.isicres.admin.sbo.acs.base.AcsPermission;
import es.ieci.tecdoc.isicres.admin.sbo.acs.base.AcsProduct;
import es.ieci.tecdoc.isicres.admin.sbo.acs.std.AcsMdoProfile;

/**
 * Proporciona las definiciones de todos los identificadores relativos a la
 * administraci�n de usuarios.
 */

public class ISicresAdminUserDefsKeys
{
   /**
    * Identificador de producto de las <b>Herramientas de Sistema</b>.
    */
   public static final int PRODUCT_SYSTEM = AcsProduct.ISYS;

   /**
    * Identificador de producto del <b>Administrador de Usuarios</b>.
    */
   public static final int PRODUCT_USER = AcsProduct.IUSER;

   /**
    * Identificador de producto de la <b>Aplicaci�n de Consulta</b>.
    */
   public static final int PRODUCT_IDOC = AcsProduct.IDOC;

   /**
    * Identificador de producto de <b>invesFlow</b>.
    */
   public static final int PRODUCT_IFLOW = AcsProduct.IFLOW;

   /**
    * Identificador de producto de <b>inveSicres</b>.
    */
   public static final int PRODUCT_ISICRES = AcsProduct.ISICRES;

   /**
    * Identificador de producto del <b>Administrador de Vol�menes</b>.
    */
   public static final int PRODUCT_VOLUME = AcsProduct.IVOL;

   /**
    * Identificador del producto del <b>Catalogo de Tramites</b>
    */
   public static final int PRODUCT_CATALOG = AcsProduct.SIGEM_CATALOGO;

   /**
    * Identificador del <b>portal</b>
    */
   public static final int PRODUCT_PORTAL = AcsProduct.SIGEM_PORTAL;

   /**
    * Identificador de perfil <b>Sin Derechos</b>.
    */
   public static final int PROFILE_NONE = AcsMdoProfile.USER_TYPE_NONE;

   /**
    * Identificador de perfil <b>Est�ndar</b>.
    */
   public static final int PROFILE_STANDARD = AcsMdoProfile.USER_TYPE_STANDARD;

   /**
    * Identificador de perfil <b>Administrador</b>.
    */
   public static final int PROFILE_MANAGER = AcsMdoProfile.USER_TYPE_MANAGER;

   /**
    * Identificador de perfil <b>Superusuario</b>.
    */
   public static final int PROFILE_SUPERUSER = AcsMdoProfile.USER_TYPE_SUPERUSER;

   /**
    * Ning�n permiso.
    */
   public static final int PERMISSION_NONE = AcsPermission.NONE;

   /**
    * Permiso de b�squeda.
    */
   public static final int PERMISSION_QUERY = AcsPermission.QUERY;

   /**
    * Permiso de actualizaci�n.
    */
   public static final int PERMISSION_UPDATE = AcsPermission.UPDATE;

   /**
    * Permiso de creaci�n.
    */
   public static final int PERMISSION_CREATION = AcsPermission.CREATION;

   /**
    * Permiso de borrado.
    */
   public static final int PERMISSION_DELETION = AcsPermission.DELETION;

   /**
    * Permiso de impresi�n.
    */
   public static final int PERMISSION_PRINTING = AcsPermission.PRINTING;

   /**
    * Todos los permisos.
    */
   public static final int PERMISSION_ALL = AcsPermission.ALL;

   /**
    * Estado del usuario por definici�n.
    */
   public static final int USER_STAT_DEF = 0;

   /**
    * Estado del usuario bloqueado.
    */
   public static final int USER_STAT_LOCKED = 1;

   private ISicresAdminUserDefsKeys()
   {
   }
}