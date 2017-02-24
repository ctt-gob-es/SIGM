package es.ieci.tecdoc.fwktd.sir.api.manager;

import java.io.File;
import java.util.List;

import es.ieci.tecdoc.fwktd.sir.api.vo.FicheroVO;

/**
 * Interfaz para los managers de compresi�n de contenidos.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public interface CompresionManager {

	/**
	 * Comprime un fichero.
	 *
	 * @param fichero
	 *            Informaci�n del fichero.
	 * @return Fichero comprimido.
	 */
	public File comprimirFichero(FicheroVO fichero);

	/**
	 * Comprime una lista de ficheros.
	 *
	 * @param ficheros
	 *            Lista ficheros.
	 * @return Fichero comprimido.
	 */
	public File comprimirFicheros(List<FicheroVO> ficheros);

	/**
	 * Descomprimir un fichero en un directorio.
	 *
	 * @param compressedFile
	 *            Fichero comprimido
	 * @param destDir
	 *            Directorio donde se descomprimir� el fichero.
	 */
	public void descomprimirFichero(File compressedFile, File destDir);
}
