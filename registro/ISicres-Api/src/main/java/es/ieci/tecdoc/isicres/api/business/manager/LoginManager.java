package es.ieci.tecdoc.isicres.api.business.manager;

import es.ieci.tecdoc.isicres.api.business.vo.UsuarioVO;

public interface LoginManager {

	/**
	 * M�todo que autentica en la aplicaci�n
	 * @param usuario - {@link UsuarioVO}
	 *
	 * @return {@link UsuarioVO}
	 */
	public abstract UsuarioVO login(UsuarioVO usuario);


	/**
	 * M�todo que cierra (logout de la aplicaci�n) la sesi�n del usuario
	 *
	 * @param usuario - {@link UsuarioVO}
	 */
	public abstract void logout(UsuarioVO usuario);
}
