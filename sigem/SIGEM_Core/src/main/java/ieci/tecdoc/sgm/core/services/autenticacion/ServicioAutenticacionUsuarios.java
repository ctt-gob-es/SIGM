package ieci.tecdoc.sgm.core.services.autenticacion;

import ieci.tecdoc.sgm.core.services.dto.Entidad;

public interface ServicioAutenticacionUsuarios {

	/**
	 * M�todo que obtiene los datos de un determinado usuario.
	 * Comprueba que el nombre de usuario y contrase�a sean correctos.
	 * @param usuario Nombre de usuario
	 * @param password Contrase�a.
	 * @return User Datos del usuario.
	 * @throws AutenticacionUsuarioException En caso de producirse alguna excepci�n.
	 */
	public DatosUsuario authenticateUser(DatosUsuario user, Entidad entidad) throws AutenticacionUsuarioException;
	
	/**
	 * M�todo que recupera los datos de un usuario.
	 * @param user Nombre de usuario.
	 * @return Datos del usuario
	 * @throws AutenticacionUsuarioException En caso de producirse alg�n error.
	 */
	public DatosUsuario getUser(DatosUsuario user, Entidad entidad ) throws AutenticacionUsuarioException;
	
	/**
	 * Elimina la informaci�n de un usuario
	 * @param user Usuario de acceso.
	 * @return User Datos de usuario.
	 * @throws AutenticacionUsuarioException Si se produce alg�n error.
	 */
	public void deleteUser(DatosUsuario user, Entidad entidad) throws AutenticacionUsuarioException;

	/**
	 * Devuelve una lista de usuarios que cumplen el criterio de b�squeda que llega como par�metro
	 * @param criteria Criterio de b�squeda.
	 * @return Array de DatosUsuario.
	 * @throws AutenticacionUsuarioException En caso de producirse alg�n error.
	 */
	public DatosUsuario[] findUsers(CriterioBusquedaUsuarios criteria, Entidad entidad) throws AutenticacionUsuarioException;
	
	/**
	 * Actualiza los datos de un usuario.
	 * @param user Datos del usuario.
	 * @throws AutenticacionUsuarioException En caso de producirse alg�n error.
	 */
	public void updateUser(DatosUsuario user, Entidad entidad) throws AutenticacionUsuarioException;
	
	/**
	 * M�todo que da da alta en el sistema un nuevo usuario.
	 * @param user Datos de usuario.
	 * @throws AutenticacionUsuarioException En caso de producirse alg�n error.
	 */
	public void createUser(DatosUsuario user, Entidad entidad) throws AutenticacionUsuarioException;
	
}
