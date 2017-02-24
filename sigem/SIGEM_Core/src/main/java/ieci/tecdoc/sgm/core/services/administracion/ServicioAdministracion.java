package ieci.tecdoc.sgm.core.services.administracion;

import ieci.tecdoc.sgm.core.services.entidades.Entidad;


/*
 * $Id: ServicioAdministracion.java,v 1.1.2.11 2008/04/22 18:47:59 afernandez Exp $
 */
public interface ServicioAdministracion {

	/**
	 * Da de alta un usuario de admimnistracion
	 * @param usuario Datos del usuario
	 * @throws AdministracionException Si se produce alg�n error
	 */
	public void altaUsuario(Usuario usuario) throws AdministracionException;
	
	/**
	 * Da de baja un usuario de admimnistracion
	 * @param usuario Datos del usuario
	 * @throws AdministracionException Si se produce alg�n error
	 */	
	public void bajaUsuario(Usuario usuario) throws AdministracionException;
	
	/**
	 * Obtiene los datos de un usuario de admimnistracion
	 * @param usuario Nombre de usuario
	 * @throws AdministracionException Si se produce alg�n error
	 */	
	public Usuario obtenerUsuario(String usuario) throws AdministracionException;
	
	/**
	 * Actualiza un usuario de admimnistracion
	 * @param usuario Datos del usuario
	 * @throws AdministracionException Si se produce alg�n error
	 */	
	public void actualizaUsuario(Usuario usuario) throws AdministracionException;

	/**
	 * Auntentica un usuario de admimnistracion
	 * @param usuario C�digo de usuario
	 * @param password contrase�a de usuario
	 * @throws AdministracionException Si se produce alg�n error
	 */	
	public boolean autenticaUsuario(String usuario, String password) throws AdministracionException;

	/**
	 * Actualiza la contrase�ade un usuario de admimnistracion
	 * @param usuario C�digo de usuario
	 * @param password contrase�a de usuario
	 * @throws AdministracionException Si se produce alg�n error
	 */	
	public void actualizaPasswordUsuario(Usuario usuario, String password) throws AdministracionException;

	/**
	 * Da de alta permisos de administraci�n para una aplicaci�n 
	 * sobre un usuario de administraci�n
	 * @param perfil Datos de los permisos
	 * @throws AdministracionException Si se produce alg�n error
	 */	
	public void altaPerfil(Perfil perfil) throws AdministracionException;
	
	/**
	 * Da de baja permisos de administraci�n para una aplicaci�n 
	 * sobre un usuario de administraci�n
	 * @param perfil Datos de los permisos
	 * @throws AdministracionException Si se produce alg�n error
	 */	
	public void bajaPerfil(Perfil perfil) throws AdministracionException;
	
	/**
	 * Elimina los permisos de administraci�n de un usuario para una entidad
	 * @param idEntidad Identificador de entidad
	 * @param idUsuario Identificador de usuario
	 * @throws AdministracionException Si se produce alg�n error
	 */
	public void bajaPerfil(String idEntidad, String  idUsuario) throws AdministracionException;
	
	/**
	 * Elimina todos los permisos de administraci�n para un usuario
	 * @param idEntidad Identificador de entidad
	 * @param idUsuario Identificador de usuario
	 * @throws AdministracionException Si se produce alg�n error
	 */
	public void bajaPerfil(String  idUsuario) throws AdministracionException;
	
	/**
	 * Actualiza los permisos de administraci�n sobre las aplicaciones para un usuario 
	 * en una entidad
	 * @param idAplicacion Listado de aplicaciones para los que el usuario tiene permisos
	 * @param idUsuario Identificador de usuario
	 * @param idEntidad Identificador de entidad
	 * @throws AdministracionException Si se produce alg�n error
	 */
	public void actualizaPerfiles(String[] idAplicacion, String idUsuario, String idEntidad) throws AdministracionException;
	
	/**
	 * Recupera toda la informaci�n de permisos de administraci�n de un usuario
	 * @param usuario Identificador de usuario
	 * @return Perfil[] Listado con los datos de los permisos
	 * @throws AdministracionException Si se produce alg�n error
	 */
	public Perfil[] getPerfiles(String usuario) throws AdministracionException;

	/**
	 * Recupera la informaci�n de los permisos de administracion para un usuario
	 * en una entidad
	 * @param usuario Identificador de usuario
	 * @param entidad Identificador de entidad
	 * @return Perfil[] Listado con los datos de los permisos
	 * @throws AdministracionException Si se produce alg�n error
	 */
	public Perfil[] getPerfiles(String usuario, String entidad) throws AdministracionException;

	/**
	 * Recupera el listado de entidades para las que tiene permisos de 
	 * administraci�n un usuario
	 * @param usuario Identificador de usuario
	 * @return Entidad[] Listado con los datos de las entidades
	 * @throws AdministracionException Si se produce alg�n error
	 */
	public Entidad[] getEntidades(String usuario) throws AdministracionException;
	

	/**
	 * Recupera la informaci�n de las aplicaciones para las que un usuario
	 * tiene permisos de administraci�n en una entidad
	 * @param usuario Identificador de usuario
	 * @param entidad Identificador de entidad
	 * @return Aplicacion[] Listado con los datos de las aplicaciones
	 * @throws AdministracionException Si se produce alg�n error
	 */
	public Aplicacion[] getAplicaciones(String usuario, String entidad) throws AdministracionException;
	
	/**
	 * Recupera la informaci�n de las aplicaciones para las que un usuario
	 * tiene permisos de administraci�n en una entidad
	 * @return Aplicacion[] Listado con los datos de las aplicaciones
	 * @throws AdministracionException Si se produce alg�n error
	 */
	public Aplicacion[] getAplicaciones() throws AdministracionException;

	
	/**
	 * Devuelve los datos de una aplicaci�n
	 * @param idAplicacion Identificador de la aplicaci�n
	 * @return Datos de la aplicaci�n 
	 * @throws AdministracionException Si se produce alg�n error
	 */
	public Aplicacion getAplicacion(String idAplicacion) throws AdministracionException;

	/**
	 * Devuelve el listado de usuarios de administraci�n de una entidad
	 * @param idEntidad Identificador de entidad	
	 * @return Usuario[] Listado de usuarios administradores
	 * @throws AdministracionException Si se produce alg�n error
	 */
	public Usuario[] getUsuariosEntidad(String idEntidad) throws AdministracionException;
	
	/**
	 * Devuelve el listado de acciones de multientidad
	 * @return AccionMultientidad[] Listado de acciones de multientidad
	 * @throws AdministracionException Si se produce alg�n error
	 */
	public AccionMultientidad[] getAccionesMultientidad() throws AdministracionException;
	
	/**
	 * Devuelve una accion de multientidad a partir de su identificador
	 * @param idAccion identificador de la accion de multientidad
	 * @return Datos de la accion de multientidad
	 * @throws AdministracionException Si se produce alg�n error
	 */
	public AccionMultientidad getAccionMultientidad(String idAccion) throws AdministracionException;

}
