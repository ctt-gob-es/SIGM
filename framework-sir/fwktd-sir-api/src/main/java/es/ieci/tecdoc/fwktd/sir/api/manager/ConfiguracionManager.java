package es.ieci.tecdoc.fwktd.sir.api.manager;

import es.ieci.tecdoc.fwktd.server.manager.BaseManager;
import es.ieci.tecdoc.fwktd.sir.api.vo.ConfiguracionVO;

/**
 * Interfaz para los managers de par�metros de configuraci�n.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public interface ConfiguracionManager extends BaseManager<ConfiguracionVO, String> {

	/**
	 * Obtiene el valor de un par�metro de configuraci�n.
	 * 
	 * @param nombre
	 *            Nombre del par�metro.
	 * @return Valor del par�metro de configuraci�n.
	 */
	public String getValorConfiguracion(String nombre);

	/**
	 * Obtiene el valor de un par�metro de configuraci�n. Comprueba los
	 * par�metros por orden de lista y devuelve el primer valor no vac�o.
	 * 
	 * @param nombres
	 *            Nombres de par�metros.
	 * @param valorPorDefecto
	 *            Valor por defecto.
	 * @return Valor del par�metro de configuraci�n.
	 */
	public String getValorConfiguracion(String[] nombres);

}
