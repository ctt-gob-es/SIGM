package es.ieci.tecdoc.fwktd.sir.api.manager;

import es.ieci.tecdoc.fwktd.sir.api.vo.FicheroIntercambioVO;
import es.ieci.tecdoc.fwktd.sir.api.vo.MensajeVO;
import es.ieci.tecdoc.fwktd.sir.core.vo.AsientoRegistralVO;

/**
 * Interfaz para los gestores de XML de SICRES.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public interface SicresXMLManager {

	/**
	 * Valida el contenido de un fichero de intercambio conforme a la normativa
	 * SICRES 3.0.
	 *
	 * @param ficheroIntercambio
	 *            Fichero de intercambio.
	 */
	public void validarFicheroIntercambio(FicheroIntercambioVO ficheroIntercambio);

	/**
	 * Valida el contenido de un asiento registral conforme a la normativa
	 * SICRES 3.0.
	 *
	 * @param asiento
	 *            Informaci�n del asiento registral.
	 */
	public void validarAsientoRegistral(AsientoRegistralVO asiento);

	/**
	 * Valida la informaci�n del fichero de datos de control.
	 *
	 * @param mensaje
	 *            Informaci�n de mensaje SICRES 3.0.
	 */
	public void validarMensaje(MensajeVO mensaje);

	/**
	 * Devuelve un XML con el fichero de datos de intercambio.
	 *
	 * @param asiento
	 *            Informaci�n del asiento registral.
	 * @param attached
	 *            Indica si los documentos van incluidos en el XML (attached) o
	 *            en ficheros aparte (detached).
	 * @return XML de fichero de intercambio
	 */
	public String createXMLFicheroIntercambio(AsientoRegistralVO asiento,
			boolean docsAttached);

	/**
	 * Devuelve un XML con el mensaje de prop�sito general con el objetivo de
	 * realizar tareas de avisos y gesti�n de flujo del intercambio.
	 *
	 * @param mensaje
	 *            Informaci�n del mensaje.
	 * @return XML de mensaje.
	 */
	public String createXMLMensaje(MensajeVO mensaje);

	/**
	 * Carga la informaci�n del fichero de datos de intercambio.
	 *
	 * @param xml
	 *            XML con la informaci�n del fichero de datos de intercambio.
	 * @return Informaci�n del fichero de datos de intercambio.
	 */
	public FicheroIntercambioVO parseXMLFicheroIntercambio(String xml);

	/**
	 * Carga la informaci�n del mensaje de datos de control.
	 *
	 * @param xml
	 *            XML con la informaci�n del fichero de datos de control.
	 * @return Informaci�n del mensaje.
	 */
	public MensajeVO parseXMLMensaje(String xml);

}
