package es.ieci.tecdoc.fwktd.sir.api.dao;

import java.util.List;

import es.ieci.tecdoc.fwktd.server.dao.BaseDao;
import es.ieci.tecdoc.fwktd.sir.core.types.EstadoAsientoRegistralEnum;
import es.ieci.tecdoc.fwktd.sir.core.vo.AsientoRegistralVO;
import es.ieci.tecdoc.fwktd.sir.core.vo.CriteriosVO;
import es.ieci.tecdoc.fwktd.sir.core.vo.EstadoAsientoRegistraVO;

/**
 * Interfaz de los DAOs de asientos registrales.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public interface AsientoRegistralDao extends
		BaseDao<AsientoRegistralVO, String> {

	/**
	 * Obtiene el n�mero de asientos registrales encontrados seg�n los criterios
	 * de b�squeda.
	 *
	 * @param criterios
	 *            Criterios de b�squeda.
	 * @return N�mero de asientos registrales encontrados.
	 */
	public int countAsientosRegistrales(CriteriosVO criterios);

	/**
	 * Realiza una b�squeda de asientos registrales.
	 *
	 * @param criterios
	 *            Criterios de b�squeda.
	 * @return Asientos registrales encontrados.
	 */
	public List<AsientoRegistralVO> findAsientosRegistrales(
			CriteriosVO criterios);

	/**
	 * Obtiene el c�digo de intercambio de un asiento registral.
	 *
	 * @param id
	 *            Identificador del asiento registral.
	 * @return C�digo de intercambio de un asiento registral.
	 */
	public String getCodigoIntercambio(String id);

	/**
	 * Obtiene el estado de un asiento registral.
	 *
	 * @param id
	 *            Identificador del asiento registral.
	 * @return Estado de un asiento registral.
	 */
	public EstadoAsientoRegistraVO getEstado(String id);
	
	/**
	 * Obtiene la descripcion del tipo de anotacion de un asiento registral.
	 *
	 * @param id
	 *            Identificador del asiento registral.
	 * @return Decripcion del tipo de anotacion
	 */
	public String getDescripcionTipoAnotacion(String id);

	/**
	 * Obtener la informaci�n del asiento registral a partir de su c�digo de
	 * entidad registral e identificador de intercambio.
	 * 
	 * @param codigoEntidadRegistral
	 *            C�digo de la Entidad Registral.
	 * @param identificadorIntercambio
	 *            Identificador de intercambio.
	 * @return Informaci�n del asiento registral.
	 */
	public AsientoRegistralVO getAsientoRegistral(
			String codigoEntidadRegistral, String identificadorIntercambio);

	/**
	 * Obtiene el estado de un asiento registral.
	 *
	 * @param code
	 *            code del asiento registral.
	 * @return Estado de un asiento registral.
	 */
	public EstadoAsientoRegistraVO getEstadoByCode(String code);

}
