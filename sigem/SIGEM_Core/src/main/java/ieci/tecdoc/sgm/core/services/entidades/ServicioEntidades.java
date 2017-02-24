package ieci.tecdoc.sgm.core.services.entidades;

import java.util.List;

public interface ServicioEntidades {

	/**
	 * M�todo que da de alta una nueva entidad
	 * @param poEntidad Datos de la entidad
	 * @return Entidad
	 * @throws EntidadesException En caso de producirse alg�n error
	 */
	public Entidad nuevaEntidad(Entidad poEntidad) throws EntidadesException;
	
	/**
	 * M�todo que elimina una entidad
	 * @param poEntidad Datos de la entidad a eliminar
	 * @throws EntidadesException En caso de producirse alg�n error
	 */
	public void eliminarEntidad(Entidad poEntidad) throws EntidadesException;
	
	/**
	 * M�todo que actualiza los datos de una entidad
	 * @param poEntidad Datos de la entidad a actualizar
	 * @return Entidad
	 * @throws EntidadesException En caso de producirse alg�n error
	 */
	public Entidad actualizarEntidad(Entidad poEntidad) throws EntidadesException;
	
	/**
	 * M�todo que obtiene los datos de una entidad a partir de su c�digo
	 * @param identificador Identificador de la entidad a obtener
	 * @return Datos de la entidad
	 * @throws EntidadesException En caso de producirse alg�n error
	 */
	public Entidad obtenerEntidad(String identificador) throws EntidadesException;
	
	/**
	 * M�todo que obtiene un listado de entidad a partir de un criterio de b�squeda
	 * @param poCriterio Criterio de b�squeda
	 * @return Listado de entidades
	 * @throws EntidadesException En caso de producirse alg�n error
	 */
	public List buscarEntidades(CriterioBusquedaEntidades poCriterio) throws EntidadesException;

	/**
	 * M�todo que obtiene un listado de todas las entidades del sistema
	 * @return Listado de entidades
	 * @throws EntidadesException En caso de producirse alg�n error
	 */
	public List obtenerEntidades() throws EntidadesException;
	
	/**
	 * M�todo que obtiene el siguiente identificador de entidad
	 * @return Identificador de la nueva entidad
	 * @throws EntidadesException En caso de producirse alg�n error
	 */
	public String obtenerIdentificadorEntidad() throws EntidadesException;
}
