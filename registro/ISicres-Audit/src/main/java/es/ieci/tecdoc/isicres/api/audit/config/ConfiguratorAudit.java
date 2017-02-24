package es.ieci.tecdoc.isicres.api.audit.config;

import gnu.trove.THashMap;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;

/**
 * Esta clase sirve valores de configuraci�n presentes en el archivo ISicres-Audit-Configuration.xml (eventos de distribuci�n). Patr�n Singleton.
 *
 * @author IECISA
 */

public class ConfiguratorAudit {

	private static final Logger log = Logger.getLogger(ConfiguratorAudit.class);

	private static ConfiguratorAudit _instance = null;

	private Document _document = null;

	private Map _attributes = new THashMap();

	private String isicresAuditConfigurationPath;

	private ConfiguratorAudit() {
		initPath();
		initConfigurator();
	}

	private void initPath(){
		//Obtenemos el path del fichero ISicres-Audit-Configuration.xml
		isicresAuditConfigurationPath = ConfigFilePathResolverIsicresAudit
				.getInstance().resolveFullPath(
						ConfigurationAuditFileKeys.ISICRES_AUDIT_CONFIGURATION);
	}

	public synchronized static ConfiguratorAudit getInstance() {
		if (_instance == null) {
			_instance = new ConfiguratorAudit();
		}

		return _instance;
	}

	private void initConfigurator() {
		try {
			InputStream stream = getClass().getResourceAsStream(
					isicresAuditConfigurationPath);
			if (stream == null) {
				stream = getClass().getClassLoader().getResourceAsStream(
						isicresAuditConfigurationPath);
			}
			if (stream == null) {
				stream = ClassLoader
						.getSystemResourceAsStream(isicresAuditConfigurationPath);
			}

			SAXReader reader = new SAXReader();

			if (stream != null) {
				_document = reader.read(stream);
			} else {
				_document = reader.read(new File(isicresAuditConfigurationPath));
			}
		} catch (Throwable t) {
			log.fatal("Imposible cargar el fichero de configuracion ["
					+ isicresAuditConfigurationPath + "]", t);
		}
	}

	/**
	 * Metodo para obtener la informaci�n del a key pasada como par�metro
	 *
	 * @param key
	 * @return String - valor de la key
	 */
	public String getProperty(String key) {
		String result = null;
		if (_attributes.containsKey(key)) {
			result = (String) _attributes.get(key);
		} else {
			result = getQueryValue(key);
			_attributes.put(key, result);

			StringBuffer buffer = new StringBuffer();
			buffer.append("Configurator ISicres key [");
			buffer.append(key);
			buffer.append("] value [");
			buffer.append(result);
			buffer.append("]");
			log.info(buffer.toString());
		}
		return result;
	}

	/**
	 * Metodo para obtener la informaci�n booleana del a key pasada como par�metro
	 *
	 * @param key
	 * @return boolean - valor de la key en booleano
	 */
	public boolean getPropertyBoolean(String key) {
		boolean result = false;
		String type = null;

		if (_attributes.containsKey(key)) {
			type = (String) _attributes.get(key);
			result = new Boolean(type).booleanValue();
		} else {
			type = getQueryValue(key);
			_attributes.put(key, type);
			result = new Boolean(type).booleanValue();

			StringBuffer buffer = new StringBuffer();
			buffer.append("Configurator ISicres key [");
			buffer.append(key);
			buffer.append("] value [");
			buffer.append(result);
			buffer.append("]");

			log.info(buffer.toString());
		}
		return result;
	}

	/**
	 * Metodo que busca en el XML la query pasada como par�metro
	 *
	 * @param query
	 * @return String - valor obtenido del XML
	 */
	protected String getQueryValue(String query) {
		String value = null;

		// Distinguimos si queremos un atributo o un nodo, ya que su forma de
		// recuperacion es distinta
		if (query.lastIndexOf("@") == -1) {
			if (_document.selectSingleNode(query) != null) {
				value = (_document.selectSingleNode(query)).getText();
			}
		} else {
			List list = _document.selectNodes(query);
			if (list != null && !list.isEmpty()) {
				Attribute attribute = (Attribute) list.get(0);
				value = attribute.getValue();
			}
		}

		// Quitamos los espacios al final y al principio.
		if (value != null && value.length() > 0) {
			value = value.trim();
		}
		return value;
	}


}
