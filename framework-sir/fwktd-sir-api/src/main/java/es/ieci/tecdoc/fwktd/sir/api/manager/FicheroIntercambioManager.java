package es.ieci.tecdoc.fwktd.sir.api.manager;

import es.ieci.tecdoc.fwktd.sir.core.vo.AsientoRegistralVO;

/**
 * Interfaz para los managers de env�o de ficheros de datos de intercambio en
 * formato SICRES 3.0 generado por la aplicaci�n de registro.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public interface FicheroIntercambioManager {

	/**
	 * Env�a el fichero de datos de intercambio al nodo distribuido asociado.
	 *
	 * @param asiento
	 *            Informaci�n del asiento registral.
	 */
	public void enviarFicheroIntercambio(AsientoRegistralVO asiento);

	/**
	 * Reenv�a el fichero de datos de intercambio al nodo distribuido asociado.
	 *
	 * @param asiento
	 *            Informaci�n del asiento registral.
	 */
	public void reenviarFicheroIntercambio(AsientoRegistralVO asiento);

	/**
	 * Rechaza el fichero de datos de intercambio.
	 *
	 * @param asiento
	 *            Informaci�n del asiento registral.
	 */
	public void rechazarFicheroIntercambio(AsientoRegistralVO asiento);

}
