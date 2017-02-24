package es.ieci.tecdoc.fwktd.sir.api.manager.impl;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.ieci.tecdoc.fwktd.sir.api.manager.ConfiguracionManager;

/**
 * @author Iecisa
 * @version $Revision$
 * 
 */
public abstract class AuditoriaManagerBaseImpl {

    private static final Logger logger = LoggerFactory
            .getLogger(AuditoriaManagerBaseImpl.class);

	/**
	 * Gestor de configuraci�n.
	 */
	private ConfiguracionManager configuracionManager = null;

	/**
	 * Indica si la auditor�a est� activada (por defecto)
	 */
	private boolean defaultActivado = false;

	/**
	 * Identificador del tipo de contenido en el m�dulo de gesti�n documental.
	 */
	private String defaultContentTypeId = null;

	/**
	 * Indica si se est� ejecutando en un test.
	 */
	private boolean test = false;

	/**
	 * Constructor.
	 */
	public AuditoriaManagerBaseImpl() {
		super();
	}

	public ConfiguracionManager getConfiguracionManager() {
		return configuracionManager;
	}

	public void setConfiguracionManager(ConfiguracionManager configuracionManager) {
		this.configuracionManager = configuracionManager;
	}

	public boolean isDefaultActivado() {
		return defaultActivado;
	}

	public void setDefaultActivado(boolean defaultActivado) {
		this.defaultActivado = defaultActivado;
	}

	public String getDefaultContentTypeId() {
		return defaultContentTypeId;
	}

	public void setDefaultContentTypeId(String defaultContentTypeId) {
		this.defaultContentTypeId = defaultContentTypeId;
	}

	public boolean isTest() {
		return test;
	}

	public void setTest(boolean test) {
		this.test = test;
	}
	
	public boolean isActivado() {
		
		boolean activado = isDefaultActivado();
		
		if (getConfiguracionManager() != null) {
			
			// Nombre del par�metro de configuraci�n
			String paramName = getActivadoParamName();
			
			// Comprobar la configuraci�n en base de datos
			String valor = getConfiguracionManager().getValorConfiguracion(
					paramName);
			logger.info("Valor de {} en base de datos: [{}]", paramName,
					valor);
			
			activado = Boolean.valueOf(valor);
		}

		return activado;
	}
	
	public String getContentTypeId() {

		String contentTypeId = getDefaultContentTypeId();
		
		if (getConfiguracionManager() != null) {
			
			// Nombre del par�metro de configuraci�n
			String paramName = getContentTypeIdParamName();
			
			// Comprobar la configuraci�n en base de datos
			String valor = getConfiguracionManager().getValorConfiguracion(
					paramName);
			logger.info("Valor de {} en base de datos: [{}]", paramName,
					valor);
			
			if (StringUtils.isNotBlank(valor)) {
				contentTypeId = valor;
			}
		}

		return contentTypeId;

	}

	/**
	 * Obtiene el nombre del par�metro de configuraci�n que indica si la
	 * auditor�a est� activada,
	 * 
	 * @return Nombre del par�metro.
	 */
	protected abstract String getActivadoParamName();
	
	/**
	 * Obtiene el nombre del par�metro de configuraci�n que indica el nombre del
	 * repositorio documental para guardar los ficheros de intercambio o
	 * mensajes,
	 * 
	 * @return Nombre del par�metro.
	 */
	protected abstract String getContentTypeIdParamName();
	
}
