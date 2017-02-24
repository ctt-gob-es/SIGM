package es.ieci.tecdoc.isicres.admin.estructura.keys;

import es.ieci.tecdoc.isicres.admin.sbo.fss.core.FssMdoUtil;


/**
 * Proporciona las definiciones de todos los identificadores relativos a la
 * administraci�n de vol�menes.
 */
public class ISicresAdminVolumeDefsKeys
{
	/**
	 * Valor por defecto del puerto para conectarse por FTP.
	 */
	public static final int FTP_PORT_DEFAULT = 21;
	/**
	 * Identificador del repositorio de tipo FTP.
	 */
	public static final int REP_TYPE_FTP = FssMdoUtil.RT_FTP;
	/**
	 * Identificador del repositorio de tipo PFS.
	 */
	public static final int REP_TYPE_PFS = FssMdoUtil.RT_PFS;
	/**
	 * Identificador del repositorio de tipo DB.
	 */
	public static final int REP_TYPE_DB = FssMdoUtil.RT_DB;
	/**
	 * Identificador del repositorio de tipo Centera
	 */
	public static final int REP_TYPE_CENTERA = FssMdoUtil.RT_CENTERA;
	/**
	 * Identificador del Sistema operativo de repositorio <b>Windows</b>.
	 */
	public static final int OS_WINDOWS = FssMdoUtil.OS_WINDOWS;
	/**
	 * Identificador del Sistema operativo de repositorio <b>Windows NT</b>.
	 */
	public static final int OS_NT = FssMdoUtil.OS_NT;
	/**
	 * Identificador del Sistema operativo de repositorio <b>Unix</b>.
	 */
	public static final int OS_UNIX = FssMdoUtil.OS_UNIX;
	/**
	 * Identificador del estado de repositorio <b>Disponible</b>.
	 */
	public static final int REP_STAT_OFFLINE   = FssMdoUtil.REP_STAT_OFFLINE;
	/**
	 * Identificador del estado de repositorio <b>S�lo lectura</b>.
	 */
   public static final int REP_STAT_READONLY  = FssMdoUtil.REP_STAT_READONLY;
   /**
	 * Identificador del estado de volumen <b>Disponible</b>.
	 */
   public static final int VOL_STAT_NOT_READY = FssMdoUtil.VOL_STAT_NOT_READY;
   /**
	 * Identificador del estado de volumen <b>S�lo lectura</b>.
	 */
   public static final int VOL_STAT_READONLY  = FssMdoUtil.VOL_STAT_READONLY;
   /**
	 * Identificador del estado de volumen <b>Lleno</b>
	 */
   public static final int VOL_STAT_FULL = FssMdoUtil.VOL_STAT_FULL;


}
