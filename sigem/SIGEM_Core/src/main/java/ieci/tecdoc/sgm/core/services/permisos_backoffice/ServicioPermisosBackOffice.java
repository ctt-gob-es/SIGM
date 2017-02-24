package ieci.tecdoc.sgm.core.services.permisos_backoffice;


public interface ServicioPermisosBackOffice {

	/**
	 * Este m�todo devuelve un array con todos los usuarios con permisos en cualquiera de 
	 * las aplicaciones de administraci�n.
	 * @param entidad Nombre de la entidad 
	 * @return DatosUsuario[] Array con todos los usuarios con permisos en cualquiera de 
	 * las aplicaciones de administraci�n.
	 * @throws PermisosBackOfficeException En caso de producirse alguna excepci�n.
	 */
	public DatosUsuario[] obtenerUsuarios(String entidad) throws PermisosBackOfficeException;
	
	/**
	 * Este m�todo devuelve un array con todos los usuarios que respondan al criterio de b�squeda.
	 * @param criterio Contiene (al menos) los siguientes valores de b�squeda: usuario, nombre y apellidos.
	 * @param idEntidad Nombre de la entidad
	 * @return DatosUsuario[] Array con todos los usuarios que respondan al criterio de b�squeda
	 * @throws PermisosBackOfficeExceiption
	 */
	public DatosUsuario[] busquedaUsuarios(CriterioBusqueda criterio, String idEntidad) throws PermisosBackOfficeException;
	
	/**
	 * Este m�todo devuelve los datos del usuario que corresponda al id pasado por par�metro
	 * @param idUsuario Identificador del usuario que queremos buscar
	 * @param idEntidad Nombre de la entidad
	 * @return DatosUsuario Usuario que corresponda al identificador
	 * @throws PermisosBackOfficeExceiption
	 */
	public DatosUsuario obtenerDatosUsuario (int idUsuario, String idEntidad) throws PermisosBackOfficeException;
	
	
}
