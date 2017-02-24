package es.ieci.tecdoc.isicres.admin.rpadmin.manager;


import org.apache.log4j.Logger;

import es.ieci.tecdoc.isicres.admin.estructura.dao.SystemCfg;
import es.ieci.tecdoc.isicres.admin.estructura.factory.ISicresAdminObjectFactory;
import es.ieci.tecdoc.isicres.admin.exception.ISicresRPAdminDAOException;
import es.ieci.tecdoc.isicres.admin.sbo.config.CfgLdapConfig;

/**
 * Clase encargada de manejar la modificaci�n de la configuraci�n de LDAP
 * @author Iecisa
 * @version $Revision$
 *
 */
public class ISicresRPAdminConfigLdapManager {

	public static final Logger logger = Logger
			.getLogger(ISicresRPAdminConfigLdapManager.class);


	/**
	 * M�todo que recupera la configuraci�n LDAP actual
	 * @param entidad - entidad de BBDD
	 * @return - la configuraci�n de LDAP actual
	 * @throws ISicresRPAdminDAOException
	 */
	public static CfgLdapConfig getLdapConfig(String entidad) throws ISicresRPAdminDAOException {

		CfgLdapConfig result = null;

		try {
			SystemCfg systemCfg = ISicresAdminObjectFactory.createSystem();
			result = systemCfg.getLdapConfig(entidad);
		} catch (Exception e) {
			logger.error("Error obteniendo configuraci�n LDAP.");
			throw new ISicresRPAdminDAOException(ISicresRPAdminDAOException.EXC_GENERIC_EXCEPCION, e);
		}

		return result;
	}

	/**
	 * M�todo que actualiza la configuraci�n LDAP de BBDD a la indicada como par�metro
	 * @param entidad - entidad de BBDD
	 * @param ldapConfig - nueva configuraci�n LDAP
	 * @throws ISicresRPAdminDAOException
	 */
	public static void updateLdapConfig(String entidad, CfgLdapConfig ldapConfig) throws ISicresRPAdminDAOException {

		try {
			SystemCfg systemCfg = ISicresAdminObjectFactory.createSystem();
			systemCfg.updateMiscLdapConfig(entidad, ldapConfig);
		} catch (Exception e) {
			logger.error("Error actualizando configuraci�n LDAP.");
			throw new ISicresRPAdminDAOException(ISicresRPAdminDAOException.EXC_GENERIC_EXCEPCION, e);
		}

	}

	/**
	 * M�todo que hace el intento de conexi�n al LDAP con los datos configurados
	 * @return TRUE - Si no se producen excepciones de validaci�n de los datos LDAP
	 * @throws ISicresRPAdminDAOException
	 */
	public static boolean testLdapConfig (CfgLdapConfig ldapConfig) throws ISicresRPAdminDAOException{

		try {
			SystemCfg systemCfg = ISicresAdminObjectFactory.createSystem();
			systemCfg.ldapConnectionTest(ldapConfig);
		} catch (Exception e) {
			logger.error("Error haciendo test de conexi�n con LDAP.");
			throw new ISicresRPAdminDAOException(ISicresRPAdminDAOException.EXC_GENERIC_EXCEPCION, e);
		}

		return Boolean.TRUE;
	}
}