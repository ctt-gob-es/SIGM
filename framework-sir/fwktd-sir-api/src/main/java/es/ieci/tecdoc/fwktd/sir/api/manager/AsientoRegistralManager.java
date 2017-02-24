package es.ieci.tecdoc.fwktd.sir.api.manager;

import java.util.Date;
import java.util.List;

import es.ieci.tecdoc.fwktd.server.manager.BaseManager;
import es.ieci.tecdoc.fwktd.sir.api.vo.FicheroIntercambioVO;
import es.ieci.tecdoc.fwktd.sir.core.vo.AsientoRegistralFormVO;
import es.ieci.tecdoc.fwktd.sir.core.vo.AsientoRegistralVO;
import es.ieci.tecdoc.fwktd.sir.core.vo.CriteriosVO;
import es.ieci.tecdoc.fwktd.sir.core.vo.EstadoAsientoRegistraVO;
import es.ieci.tecdoc.fwktd.sir.core.vo.InfoRechazoVO;
import es.ieci.tecdoc.fwktd.sir.core.vo.InfoReenvioVO;

/**
 * Interfaz para los managers de asientos registrales.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public interface AsientoRegistralManager extends
		BaseManager<AsientoRegistralVO, String> {

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
	 * Guarda el asiento registral junto con los interesados y anexos.
	 *
	 * @param asientoForm
	 *            Informaci�n del asiento registral.
	 * @return Informaci�n del asiento registral creado.
	 */
	public AsientoRegistralVO saveAsientoRegistral(
			AsientoRegistralFormVO asientoForm);

	/**
	 * Guarda el asiento registral junto con los interesados y anexos del fichero de intercambio.
	 *
	 * @param ficheroIntercambio
	 *            Informaci�n del fichero de intercambio.
	 * @return Informaci�n del asiento registral creado.
	 */
	public AsientoRegistralVO saveAsientoRegistral(FicheroIntercambioVO ficheroIntercambio);
	
	/**
	 * Elimina el asiento registral junto con sus interesados y anexos.
	 *
	 * @param id
	 *            Identificador del asiento registral.
	 */
	public void deleteAsientoRegistral(String id);

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
	 * Env�o del fichero de datos de intercambio al nodo distribuido asociado.
	 *
	 * @param asientoForm
	 *            Informaci�n del asiento registral.
	 * @return Asiento registral creado.
	 */
	public AsientoRegistralVO enviarAsientoRegistral(
			AsientoRegistralFormVO asientoForm);

	/**
	 * Env�o del fichero de datos de intercambio al nodo distribuido asociado.
	 *
	 * @param id
	 *            Identificador del asiento registral.
	 */
	public void enviarAsientoRegistral(String id);

	/**
	 * Valida un asiento registral recibido.
	 *
	 * @param id
	 *            Identificador del asiento registral.
	 * @param numeroRegistro
	 *            N�mero de registro.
	 * @param fechaRegistro
	 *            Fecha de registro.
	 */
	public void validarAsientoRegistral(String id, String numeroRegistro,
			Date fechaRegistro);

	/**
	 * Reenv�a un asiento registral recibido o devuelto.
	 *
	 * @param id
	 *            Identificador del asiento registral.
	 */
	public void reenviarAsientoRegistral(String id);

	/**
	 * Reenv�a un asiento registral recibido.
	 * 
	 * @param id
	 *            Identificador del asiento registral.
	 * @param infoReenvio
	 *            Informaci�n del reenv�o.
	 */
	public void reenviarAsientoRegistral(String id, InfoReenvioVO infoReenvio);

	/**
	 * Rechaza un asiento registral recibido.
	 *
	 * @param id
	 *            Identificador del asiento registral.
	 * @param infoRechazo
	 *            Informaci�n sobre el rechazo.
	 */
	public void rechazarAsientoRegistral(String id,
			InfoRechazoVO infoRechazo);	

	/**
	 * Anula un asiento registral devuelto.
	 *
	 * @param id
	 *            Identificador del asiento registral.
	 */
	public void anularAsientoRegistral(String id);

	/**
	 * Comprueba el time-out de la recepci�n de mensajes (ACK o ERROR) tras los
	 * env�os de ficheros de datos de intercambio.
	 */
	public void comprobarTimeOutEnvios();
	
	/**
	 * Obtiene la descripcion del tipo de anotacion de un asiento registral.
	 *
	 * @param id
	 *            Identificador del asiento registral.
	 * @return Decripcion del tipo de anotacion
	 */
	public String getDescripcionTipoAnotacion(String id);

	/**
	 * Obtiene el estado de un asiento registral.
	 *
	 * @param code
	 *            codigo del asiento registral.
	 * @return Estado de un asiento registral.
	 */
	public EstadoAsientoRegistraVO getEstadoByCode(String code);
}
