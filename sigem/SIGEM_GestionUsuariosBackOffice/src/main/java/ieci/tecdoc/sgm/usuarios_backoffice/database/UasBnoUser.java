package ieci.tecdoc.sgm.usuarios_backoffice.database;

import ieci.tecdoc.sgm.base.dbex.DbConnection;

import java.util.ArrayList;
import java.util.List;

/**
 * M�todos para el acceso a la informaci�n de usuarios.
 */
public class UasBnoUser {

	/**
	 * Obtiene la informaci�n de un usuario a partir del identificador.
	 * @param conn Conexi�n a la base de datos.
	 * @param userId Identificador del usuario.
	 * @return Informaci�n del usuario.
	 * @throws Exception si ocurre alg�n error.
	 */
	public static UasDaoUserRecO findUserById(int userId, String entidad)
			throws Exception {
		
		UasDaoUserRecO userRecO = null;

		try {
			userRecO = UasDaoUserTblEx.selectRecO(userId, entidad);
		} catch (Exception e) {
			throw e;
		}

		return userRecO;
	}

	/**
	 * Obtiene una lista de usuarios a partir de un nombre.
	 * @param conn Conexi�n a la base de datos.
	 * @param username Nombre del usuario.
	 * @return Lista de usuarios.
	 * @throws Exception si ocurre alg�n error.
	 */
	public static List findUsersByName(String username, String entidad)
			throws Exception {
		List users = new ArrayList();

		try {
			users.addAll(UasDaoUserTblEx.selectRecOList(username, entidad));
		} catch (Exception e) {
			throw e;
		}

		return users;
	}

}
