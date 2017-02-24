package es.ieci.tecdoc.fwktd.sir.api.manager;

/**
 * Interfaz para los managers de generaci�n de c�digos hash.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public interface HashManager {

	/**
	 * Genera el c�digo hash de un contenido.
	 * @param contenido Contenido.
	 * @return C�digo hash del contenido.
	 */
	public byte[] generarHash(byte[] contenido);

}
