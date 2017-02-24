package es.ieci.tecdoc.fwktd.sir.api.dao;

import java.util.Map;

import es.ieci.tecdoc.fwktd.server.dao.BaseDao;
import es.ieci.tecdoc.fwktd.sir.api.vo.ConfiguracionVO;

/**
 * Interfaz de los DAOs de par�metros de configuraci�n.
 * 
 * @author Iecisa
 * @version $Revision$
 * 
 */
public interface ConfiguracionDao extends BaseDao<ConfiguracionVO, String> {

	/**
	 * Obtiene el valor de un par�metro de configuraci�n.
	 * 
	 * @param nombre
	 *            Nombre del par�metro.
	 * @return Valor del par�metro de configuraci�n.
	 */
	public String getValorConfiguracion(String nombre);

	/**
	 * Obtiene los valores de unos par�metros de configuraci�n.
	 * 
	 * @param nombres
	 *            Nombres de par�metros de configuraci�n.
	 * @return Valores de los par�metros de configuraci�n.
	 */
	public Map<String, String> getValoresConfiguracion(String[] nombres);
}
