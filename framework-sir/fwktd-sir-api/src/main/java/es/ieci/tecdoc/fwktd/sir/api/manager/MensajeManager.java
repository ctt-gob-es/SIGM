package es.ieci.tecdoc.fwktd.sir.api.manager;

import es.ieci.tecdoc.fwktd.sir.api.vo.MensajeVO;

/**
 * Interfaz para los managers de env�o del fichero de datos de control en
 * formato SICRES 3.0 generado por la aplicaci�n origen.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public interface MensajeManager {

	/**
	 * Env�a el fichero de datos de control al nodo distribuido asociado.
	 *
	 * @param mensaje
	 *            Informaci�n de mensaje SICRES 3.0.
	 */
	public void enviarMensaje(MensajeVO mensaje);

}
