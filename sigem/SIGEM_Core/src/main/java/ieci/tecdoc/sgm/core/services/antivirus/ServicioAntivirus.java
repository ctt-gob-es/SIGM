package ieci.tecdoc.sgm.core.services.antivirus;

public interface ServicioAntivirus {
	
	/**
	 * M�todo que comprueba si un fichero contiene virus
	 * @param fichero Contenido del fichero a comprobar
	 * @return true en caso de no tener virus, false en caso contrario
	 * @throws AntivirusException En caso de producirse alg�n error
	 */
	public boolean comprobarFichero(byte[] fichero, boolean borrar) throws AntivirusException;
	
	/**
	 * M�todo que comprueba si un fichero contiene virus
	 * @param fichero Ruta del fichero a omprobar
	 * @return true en caso de no tener virus, false en caso contrario
	 * @throws AntivirusException En caso de producirse alg�n error
	 */
	public boolean comprobarFichero(String rutaFichero, boolean borrar) throws AntivirusException;
	
}
