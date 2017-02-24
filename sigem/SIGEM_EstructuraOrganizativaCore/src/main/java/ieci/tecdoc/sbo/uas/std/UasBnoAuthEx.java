package ieci.tecdoc.sbo.uas.std;

import java.sql.Connection;

import ieci.tecdoc.core.db.DBSessionManager;
import ieci.tecdoc.core.db.DbConnectionConfig;
import ieci.tecdoc.sbo.uas.base.UasAuthToken;
import ieci.tecdoc.sgm.base.dbex.DbConnection;


public final class UasBnoAuthEx
{

	//~ Constructors -----------------------------------------------------------

	/**
	 * DOCUMENT ME!
	 *
	 * @since V1.0
	 */
	private UasBnoAuthEx()
	{

		// Intencionadamente privado
	}

	//~ Methods ----------------------------------------------------------------

	/**
	 * DOCUMENT ME!
	 *
	 * @param name 				Login del usuario
	 * @param pwd 				Password introducida por el usuario al logarse
	 * @param cntsTriesNum 		N�mero de intentos de login que ha realizado el usuario
	 *
	 * @return UasAuthToken     Informaci�n completa del usuario
	 *
	 * @throws Exception 		Exception if the application business logic throws an exception
	 *
	 * @since V1.0
	 */
	public static UasAuthToken authenticateUser(String name, String pwd,
												           int cntsTriesNum, String entidad)
							         throws Exception
	{

		UasAuthToken uasToken = null;

		DbConnection dbConn=new DbConnection();
		try{
			dbConn.open(DBSessionManager.getSession(entidad));
			
			uasToken = UasMdoAuth.authenticateUser(name, pwd, cntsTriesNum, entidad);

			return uasToken;
		}
		 catch(Exception e)
		{
			return uasToken;

		}finally{
			dbConn.close();
		}

	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param dbConConfig 		Objeto que contiene la informaci�n de la conexi�n directa a BBDD sin
	 * 								utilizar el pool de conexiones del Servidor de Aplicaciones
	 * @param name 				Login del usuario
	 * @param pwd 				Password introducida por el usuario al logarse
	 * @param cntsTriesNum 		N�mero de intentos de login que ha realizado el usuario 
	 * @return UasAuthToken       	Informaci�n completa del usuario
	 *
	 * @throws 		 			Exception if the application business logic throws an exception
	 *
	 * @since V1.0
	 */

	public static UasAuthToken authenticateUser(DbConnectionConfig dbConConfig,
												           String name, String pwd,
												           int cntsTriesNum, String entidad)
							         throws Exception
	{

		UasAuthToken uasToken = null;

		DbConnection dbConn=new DbConnection();
		try{
			dbConn.open(DBSessionManager.getSession(entidad));
			
			uasToken = UasMdoAuth.authenticateUser(name, pwd, cntsTriesNum, entidad);

			return uasToken;

		}
		 catch(Exception e)
		{
			return uasToken;

		}finally{
			dbConn.close();
		}

	}

	/**
	 * Cambia la contrase�a del usuario, si y solo si, se cumplen los
	 * requisitos fijados en  la aplicaci�n. Lanza una excepci�n si no se ha
	 * podido cambiar la pasword indicando el motivo
	 *
	 * @param name Login del usuario
	 * @param pwd Password introducida por el usuario al logarse
	 * @param cntsTriesNum N�mero de intentos de login que ha realizado el
	 * 		  usuario
	 * @param newPwd1 Nueva password del usuario
	 * @param newPwd2 Verificaci�n de la nueva password del usuario
	 *
	 * @throws Exception Exception if the application business logic throws an
	 * 		   exception
	 *
	 * @since V1.0
	 */
	public static void changePassword(String name,
	                                  String pwd, int cntsTriesNum,
	                                  String newPwd1, String newPwd2, String entidad)
					       throws Exception
	{

		DbConnection dbConn=new DbConnection();
		try{
			dbConn.open(DBSessionManager.getSession(entidad));
			
			UasMdoAuth.changePassword(name, pwd, cntsTriesNum, 
			                          newPwd1, newPwd2, entidad);

		}
		 catch(Exception e)
		{
			 throw e;
		}finally{
			dbConn.close();
		}

	}

	/**
	 * Cambia la contrase�a del usuario, si y solo si, se cumplen los
	 * requisitos fijados en  la aplicaci�n. Lanza una excepci�n si no se ha
	 * podido cambiar la pasword indicando el motivo
	 *
	 * @param dbConConfig		Objeto que contiene la informaci�n de la conexi�n directa a BBDD sin
	 * 								utilizar el pool de conexiones del Servidor de Aplicaciones
	 * @param name 				Login del usuario
	 * @param pwd 				Password introducida por el usuario al logarse
	 * @param cntsTriesNum 		N�mero de intentos de login que ha realizado el usuario
	 * @param newPwd1 			Nueva password del usuario
	 * @param newPwd2 			Verificaci�n de la nueva password del usuario
	 *
	 * @throws Exception 		Exception if the application business logic throws an exception
	 *
	 * @since V1.0
	 */
	public static void changePassword(DbConnectionConfig dbConConfig,
									          String name, String pwd,
									          int cntsTriesNum, String newPwd1,
									          String newPwd2, String entidad)
					       throws Exception
	{

		DbConnection dbConn=new DbConnection();
		try{
			dbConn.open(DBSessionManager.getSession(entidad));	
			
			UasMdoAuth.changePassword(name, pwd, cntsTriesNum, 
			                          newPwd1, newPwd2, entidad);

		}
		 catch(Exception e)
		{
			 throw e;
		}finally{
			dbConn.close();
		}

	}

}