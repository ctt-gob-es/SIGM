package es.ieci.tecdoc.fwktd.sir.api.manager;

import es.ieci.tecdoc.fwktd.sir.api.vo.MensajeVO;
import es.ieci.tecdoc.fwktd.sir.core.vo.AsientoRegistralVO;

/**
 * Interfaz para los managers de codificaci�n de ficheros.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public interface CodificacionFicherosManager {

	/**
	 * Obtiene el identificador de intercambio �nico.
	 *
	 * @param asiento
	 *            Informaci�n del asiento registral.
	 * @return Identificador de intercambio �nico.
	 */
	public String getIdentificadorIntercambio(AsientoRegistralVO asiento);

	/**
	 * Obtiene la codificaci�n para un fichero de datos de control.
	 *
	 * @param mensaje
	 *            Informaci�n del mensaje.
	 * @return Codificaci�n del fichero.
	 */
	public String getCodificacionMensaje(MensajeVO mensaje);
}
