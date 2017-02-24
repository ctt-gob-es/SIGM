/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.sgm.registropresencial.beans;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Contiene los par�metros de inicializaci�n del web.xml.
 * 
 * @author cmorenog
 */
public class WebParameter implements Serializable {
	private static final long serialVersionUID = 1L;
	/** parametros de contexto del web.xml. */
	private static HashMap<String, String> initParameters = new HashMap<String, String>();
	/** parametro env-entry del web.xml. */
	private static HashMap<String, Object> entryParameters =
			new HashMap<String, Object>();
	
	/**
	 * Devuelve los par�metros de contexto de web.xml.
	 * 
	 * @return hashMap con los par�metros
	 */
	public HashMap<String, String> getInitParameters() {
		return initParameters;
	}
	
	/**
	 * Introduce los par�metros de inicializaci�n del contexto.
	 * 
	 * @param initParameters
	 *            hashMap con los par�metros de inicializaci�n.
	 */
	public static void setInitParameters(HashMap<String, String> initParameters) {
		WebParameter.initParameters = initParameters;
	}
	
	/**
	 * Devuelve los par�metros de env-entry de web.xml.
	 * 
	 * @return hashMap con los par�metros.
	 */
	public HashMap<String, Object> getEntryParameters() {
		return entryParameters;
	}
	
	/**
	 * Introduce los par�metros de env-entry del contexto.
	 * 
	 * @param entryParameters
	 *            hashMap con los par�metros env-entry.
	 */
	public static void setEntryParameters(HashMap<String, Object> entryParameters) {
		WebParameter.entryParameters = entryParameters;
	}
	
	/**
	 * Retorna un par�metro de contexto del web.xml.
	 * 
	 * @param key
	 *            String con el nombre del par�metro.
	 * 
	 * @return String con el valor.
	 */
	public static String getInitParameter(String key) {
		return initParameters.get(key);
	}
	
	/**
	 * Retorna un par�metro env-entry del web.xml.
	 * 
	 * @param key
	 *            String con el nombre del par�metro.
	 * @return String con el valor.
	 */
	public static Object getEntryParameter(String key) {
		return entryParameters.get(key);
	}
}