package es.ieci.tecdoc.fwktd.sir.api.manager;

import es.ieci.tecdoc.fwktd.sir.api.types.BandejaEnum;
import es.ieci.tecdoc.fwktd.sir.api.vo.FicheroIntercambioVO;
import es.ieci.tecdoc.fwktd.sir.core.vo.AsientoRegistralVO;

/**
 * Interfaz para los managers de auditor�a de ficheros de datos de intercambio.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public interface AuditoriaFicheroIntercambioManager {

	/**
	 * Audita la informaci�n de un fichero de datos de intercambio
	 *
	 * @param asientoRegistral
	 *            Informaci�n del asiento registral.
	 * @param bandeja
	 *            Bandeja del mensaje.
	 */
	public void audita(AsientoRegistralVO asientoRegistral,
			BandejaEnum bandeja);

	/**
	 * Audita la informaci�n de un fichero de datos de intercambio
	 *
	 * @param ficheroIntercambio
	 *            Informaci�n del fichero de datos de intercambio.
	 * @param xml
	 *            XML del mensaje.
	 * @param bandeja
	 *            Bandeja del mensaje.
	 */
	public void audita(FicheroIntercambioVO ficheroIntercambio, String xml,
			BandejaEnum bandeja);
}
