package es.ieci.tecdoc.fwktd.dir3.api.manager;

import java.util.List;
/**
 * Interfaz para la generaci�n de ficheros con el proceso de actualizaci�n o inicializaci�n.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public interface GenerateScriptSQLManager {

	/**
	 * M�todo que genera un fichero SQL con los sentencias de inicializaci�n del sistema
	 * @param fileXMLData - XML con los objetos a insertar en BBDD
	 *
	 */
	public void generateScriptInicializacion(String fileXMLData);

	/**
	 * M�todo que genera un fichero SQL con las sentencias de actualizacion
	 * @param fileXMLDataUpdate - XML con los objetos a actualizar
	 */
	public void generateScriptActualizacion(String fileXMLDataUpdate);

	/**
	 * M�todo que genera un array con las sentencias a realizar en un proceso de actualizaci�n
	 * @param fileXMLDataUpdate - XML con los objetos a actualizar
	 * @return Listado de sentencias (INSERT, UPDATE o DELETE) segun la operativa del objeto a tratar
	 */
	public List<String> generateSententesSQLUpdate(String fileXMLDataUpdate);
}
