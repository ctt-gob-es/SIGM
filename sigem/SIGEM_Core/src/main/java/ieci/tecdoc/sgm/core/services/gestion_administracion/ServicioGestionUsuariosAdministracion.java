package ieci.tecdoc.sgm.core.services.gestion_administracion;

public interface ServicioGestionUsuariosAdministracion {

	/**
	 * M�todo que obtiene la URL de login para una aplicacion de back office
	 * @throws GestionUsuariosAdministracionException En caso de producirse alg�n error
	 */
	public String obtenerDireccionLogado()  throws GestionUsuariosAdministracionException;
		
	/**
	 * M�todo que obtiene la URL de desconexi�n para una aplicacion de back office
	 * @throws GestionUsuariosAdministracionException En caso de producirse alg�n error
	 */
	public String obtenerDireccionDeslogado()  throws GestionUsuariosAdministracionException;
}
