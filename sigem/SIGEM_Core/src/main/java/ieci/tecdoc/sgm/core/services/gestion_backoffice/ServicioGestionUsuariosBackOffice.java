package ieci.tecdoc.sgm.core.services.gestion_backoffice;

import ieci.tecdoc.sgm.core.services.dto.Entidad;
import ieci.tecdoc.sgm.core.services.sesion.SesionUsuarioException;

import java.security.cert.X509Certificate;

public interface ServicioGestionUsuariosBackOffice {

	/**
	 * M�todo que obtiene los datos de un determinado usuario.
	 * Comprueba que el nombre de usuario y contrase�a sean correctos.
	 * @param usuario Nombre de usuario
	 * @param password Contrase�a.
	 * @return User Datos del usuario.
	 * @throws GestionUsuariosBackOfficeException En caso de producirse alguna excepci�n.
	 */
	public DatosUsuario authenticateUser(DatosUsuario user, Entidad entidad) throws GestionUsuariosBackOfficeException;
	
	/**
	 * M�todo que obtiene los datos de un determinado usuario a partir del certificado digital
	 * 
	 * @param certificate	Certificado digital
	 * @param entidad	Identificador de la entidad
	 * @return	Datos del usuario
	 * @throws GestionUsuariosBackOfficeException	En caso de producirse alg�n error
	 * @throws SesionUsuarioException 
	 */
	public DatosUsuario authenticateUser (X509Certificate certificate, Entidad entidad) throws GestionUsuariosBackOfficeException, SesionUsuarioException;
	
	
	/**
	 * M�todo que recupera los datos de un usuario.
	 * @param user Nombre de usuario.
	 * @return Datos del usuario
	 * @throws GestionUsuariosBackOfficeException En caso de producirse alg�n error.
	 */
	public DatosUsuario getUser(DatosUsuario user, Entidad entidad ) throws GestionUsuariosBackOfficeException;
	
	/**
	 * Elimina la informaci�n de un usuario
	 * @param user Usuario de acceso.
	 * @return User Datos de usuario.
	 * @throws GestionUsuariosBackOfficeException Si se produce alg�n error.
	 */
	public void deleteUser(DatosUsuario user, Entidad entidad) throws GestionUsuariosBackOfficeException;

	/**
	 * Devuelve una lista de usuarios que cumplen el criterio de b�squeda que llega como par�metro
	 * @param criteria Criterio de b�squeda.
	 * @return Array de DatosUsuario.
	 * @throws GestionUsuariosBackOfficeException En caso de producirse alg�n error.
	 */
	public DatosUsuario[] findUsers(CriterioBusquedaUsuarios criteria, Entidad entidad) throws GestionUsuariosBackOfficeException;
	
	/**
	 * Actualiza los datos de un usuario.
	 * @param user Datos del usuario.
	 * @throws GestionUsuariosBackOfficeException En caso de producirse alg�n error.
	 */
	public void updateUser(DatosUsuario user, Entidad entidad) throws GestionUsuariosBackOfficeException;
	
	/**
	 * M�todo que da da alta en el sistema un nuevo usuario.
	 * @param user Datos de usuario.
	 * @throws GestionUsuariosBackOfficeException En caso de producirse alg�n error.
	 */
	public void createUser(DatosUsuario user, Entidad entidad) throws GestionUsuariosBackOfficeException;
	
	/**
	 * M�todo que obtiene la URL de vuelta para una aplicacion
	 * @param idAplicacion Identificador de la aplicacion (IDs definidos en ConstantesGestionBackOffice)
	 * @throws GestionUsuariosBackOfficeException En caso de producirse alg�n error
	 */
	public String obtenerDireccionAplicacion(String idAplicacion)  throws GestionUsuariosBackOfficeException;
	
	/**
	 * M�todo que obtiene la URL de login para una aplicacion de back office
	 * @throws GestionUsuariosBackOfficeException En caso de producirse alg�n error
	 */
	public String obtenerDireccionLogado()  throws GestionUsuariosBackOfficeException;
		
	/**
	 * M�todo que obtiene la URL de desconexi�n para una aplicacion de back office
	 * @throws GestionUsuariosBackOfficeException En caso de producirse alg�n error
	 */
	public String obtenerDireccionDeslogado()  throws GestionUsuariosBackOfficeException;
}
