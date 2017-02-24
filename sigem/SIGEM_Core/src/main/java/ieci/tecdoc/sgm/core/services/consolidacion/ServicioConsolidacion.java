package ieci.tecdoc.sgm.core.services.consolidacion;

/**
 * Interfaz para el servicio de consolidaci�n.
 * 
 */
public interface ServicioConsolidacion {

	/**
	 * Realiza la consolidaci�n de registros telem�ticos en todas las entidades definidas.
	 * @throws ConsolidacionException si ocurre alg�n error.
	 */
	public void consolida() throws ConsolidacionException;
	
	/**
	 * Realiza la consolidaci�n de registros telem�ticos en la entidad.
	 * @param idEntidad Identificador de la entidad.
	 * @throws ConsolidacionException si ocurre alg�n error.
	 */
	public void consolida(String idEntidad) throws ConsolidacionException;

}
