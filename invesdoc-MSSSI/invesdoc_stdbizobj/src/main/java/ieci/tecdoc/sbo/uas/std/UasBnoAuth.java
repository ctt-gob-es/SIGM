package ieci.tecdoc.sbo.uas.std;

import ieci.tecdoc.core.db.DbConnection;
import ieci.tecdoc.sbo.config.CfgMdoConfig;
import ieci.tecdoc.sbo.uas.base.UasAuthToken;


public final class UasBnoAuth
{

	//~ Constructors -----------------------------------------------------------

	/**
	 * DOCUMENT ME!
	 *
	 * @since V1.0
	 */
	private UasBnoAuth()
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
												           int cntsTriesNum)
							         throws Exception
	{

		UasAuthToken uasToken = null;

		try
		{

			DbConnection.open(CfgMdoConfig.getDbConfig());
			
			uasToken = UasMdoAuth.authenticateUser(name, pwd, cntsTriesNum);
			
			DbConnection.close();

			return uasToken;

		}
		 catch(Exception e)
		{

			DbConnection.ensureClose(e);

			return uasToken;

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
	public static void changePassword(String name, String pwd,
									          int cntsTriesNum, String newPwd1,
									          String newPwd2)
					       throws Exception
	{

		try
		{

			DbConnection.open(CfgMdoConfig.getDbConfig());
			
			UasMdoAuth.changePassword(name, pwd, cntsTriesNum,
                                   newPwd1, newPwd2);
			
			DbConnection.close();

		}
		 catch(Exception e)
		{

			DbConnection.ensureClose(e);

		}

	}
   
}