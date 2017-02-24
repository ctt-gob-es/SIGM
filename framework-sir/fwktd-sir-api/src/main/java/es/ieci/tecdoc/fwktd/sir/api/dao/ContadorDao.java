package es.ieci.tecdoc.fwktd.sir.api.dao;

import es.ieci.tecdoc.fwktd.sir.api.types.TipoContadorEnum;
import es.ieci.tecdoc.fwktd.sir.api.vo.ContadorVO;

/**
 * Interfaz de los DAOs de contadores.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public interface ContadorDao {

	/**
	 * Obtiene el n�mero de contadores.
	 * @return N�mero de contadores.
	 */
	public int count();

	/**
	 * Obtiene la informaci�n del contador.
	 * @param codigoEntidadRegistral C�digo de la entidad registral.
	 * @param tipoContador Tipo de contador.
	 * @return Informaci�n del contador.
	 */
    public ContadorVO get(String codigoEntidadRegistral, TipoContadorEnum tipoContador);

	/**
	 * Guarda la informaci�n del contador.
	 * @param contador Informaci�n del contador.
	 * @return Informaci�n del contador creado.
	 */
    public ContadorVO save(ContadorVO contador);

	/**
	 * Actualiza la informaci�n del contador.
	 * @param contador Informaci�n del contador.
	 * @return Informaci�n del contador actualizado.
	 */
    public ContadorVO update(ContadorVO contador);

	/**
	 * Elimina la informaci�n del contador.
	 * @param codigoEntidadRegistral C�digo de la entidad registral.
	 * @param tipoContador Tipo de contador.
	 */
    public void delete(String codigoEntidadRegistral, TipoContadorEnum tipoContador);

    /**
     * Elimina la informaci�n de todos los contadores.
     */
    public void deleteAll();

}
