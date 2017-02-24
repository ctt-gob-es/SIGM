package es.ieci.tecdoc.fwktd.sir.api.manager.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.commons.codec.binary.Base64;

import es.ieci.tecdoc.fwktd.sir.api.manager.ConfiguracionManager;
import es.ieci.tecdoc.fwktd.sir.api.manager.HashManager;
import es.ieci.tecdoc.fwktd.sir.core.exception.SIRException;

/**
 * Implementaci�n del manager de generaci�n de c�digos hash.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public class HashManagerImpl implements HashManager {

	private static final Logger logger = LoggerFactory
			.getLogger(HashManagerImpl.class);

	private static final String ALGORITMO_PARAM_NAME = "algoritmo.hash";
	private static final String DEFAULT_ALGORITMO = "SHA-1";

	/**
	 * Algoritmo de generaci�n de c�digo hash.
	 */
	private String defaultAlgoritmo = DEFAULT_ALGORITMO;
	
	/**
	 * Gestor de configuraci�n.
	 */
	private ConfiguracionManager configuracionManager = null;

	/**
	 * Constructor.
	 */
	public HashManagerImpl() {
		super();
	}

	/**
	 * Constructor.
	 * @param algoritmo Algoritmo de generaci�n de c�digo hash.
	 */
	public HashManagerImpl(String algoritmo) {
		super();
		setDefaultAlgoritmo(algoritmo);
	}

	public String getDefaultAlgoritmo() {
		return defaultAlgoritmo;
	}

	public void setDefaultAlgoritmo(String defaultAlgoritmo) {
		this.defaultAlgoritmo = defaultAlgoritmo;
	}

	public ConfiguracionManager getConfiguracionManager() {
		return configuracionManager;
	}

	public void setConfiguracionManager(ConfiguracionManager configuracionManager) {
		this.configuracionManager = configuracionManager;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see es.ieci.tecdoc.fwktd.sir.api.manager.HashManager#generarHash(byte[])
	 */
	public byte[] generarHash(byte[] contenido) {

		byte[] hash = null;

		logger.info("Generando c�digo hash");

		if (contenido != null) {
			
			String algoritmoHash = null; 
					
			try {

				// Obtener el algoritmo para generar el c�digo hash
				algoritmoHash = getAlgoritmoHash();
				logger.info("Algorimo para el hash: [{}]", algoritmoHash);

				MessageDigest md = MessageDigest.getInstance(algoritmoHash);
				md.update(contenido);
				hash = md.digest();

				if (logger.isInfoEnabled()) {
					logger.info("C�digo hash generado [{}]: {}",
							algoritmoHash, Base64.encodeBase64String(hash));
				}

			} catch (NoSuchAlgorithmException e) {
				logger.error("Error al generar el c�digo hash", e);
				throw new SIRException("error.sir.generarHash",
						new String[] { algoritmoHash }, e.getMessage());
			}
		}

		return hash;
	}

	protected String getAlgoritmoHash() {
		
		String alg = null;
		
		if (getConfiguracionManager() != null) {
			
			// Obtener el algoritmo a partir de la configuraci�n en base de
			// datos
			alg = getConfiguracionManager().getValorConfiguracion(
					ALGORITMO_PARAM_NAME);
			logger.info("Valor de {} en base de datos: [{}]", ALGORITMO_PARAM_NAME,
					alg);
		}

		if (StringUtils.isBlank(alg)) {
			alg = getDefaultAlgoritmo();
		}

		return alg;
	}
}
