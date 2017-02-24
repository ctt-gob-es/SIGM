package es.ieci.tecdoc.fwktd.sir.ws.manager;

import java.util.List;


/**
 * Interfaz para el gestor de env�os de ficheros de intercambio y mensajes de
 * datos de control a la aplicaci�n.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public interface EnvioManager {

	/**
	 * Env�a un fichero de intercambio a la aplicaci�n.
	 *
	 * @param ficheroIntercambio
	 *            Fichero de intercambio SICRES 3.0 en formato String.
	 * @param firmaFicheroIntercambio
	 *            Firma del contenido del registro.
	 * @param documentos
	 *            Documentos anexos al registro.
	 */
	public void envioFichero(String ficheroIntercambio,
			String firmaFicheroIntercambio, List<byte[]> documentos);

	/**
	 * Env�a un mensaje de datos de control a la aplicaci�n.
	 *
	 * @param mensaje
	 *            Fichero de mensaje SICRES 3.0 en formato String.
	 * @param firma
	 *            Firma del contenido del mensaje.
	 */
	public void envioMensaje(String mensaje, String firma);

}
