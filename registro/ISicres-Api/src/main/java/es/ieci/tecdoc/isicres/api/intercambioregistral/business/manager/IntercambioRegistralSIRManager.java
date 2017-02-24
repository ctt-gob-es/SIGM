package es.ieci.tecdoc.isicres.api.intercambioregistral.business.manager;

import java.util.Date;
import java.util.List;

import es.ieci.tecdoc.fwktd.sir.core.types.TipoRechazoEnum;
import es.ieci.tecdoc.fwktd.sir.core.vo.AsientoRegistralFormVO;
import es.ieci.tecdoc.fwktd.sir.core.vo.AsientoRegistralVO;
import es.ieci.tecdoc.fwktd.sir.core.vo.CriteriosVO;
import es.ieci.tecdoc.fwktd.sir.core.vo.EstadoAsientoRegistraVO;
import es.ieci.tecdoc.fwktd.sir.core.vo.TrazabilidadVO;
import es.ieci.tecdoc.isicres.api.intercambioregistral.business.vo.UnidadTramitacionIntercambioRegistralVO;

/**
 * Manager que comunica con el m�dulo del SIR
 * @author iecisa
 *
 */
public interface IntercambioRegistralSIRManager {

	public void validarAsientoRegistral(String id, String numeroRegistro, Date fechaRegistro);

	public byte[] getContenidoAnexo(String idAnexo);

	public EstadoAsientoRegistraVO getEstadoAsientoRegistral(String identificadorIntercambio);

	public List<AsientoRegistralVO> findAsientosRegistrales(CriteriosVO criterios);

	public void rechazarAsientoRegistral(String identificadorIntercambio, TipoRechazoEnum tipoRechazoEnum, String motivo);
	
	public void rechazarAsientoRegistral(String identificadorIntercambio, String usuario, String contacto, TipoRechazoEnum tipoRechazoEnum, String motivo);
	
	public AsientoRegistralVO getAsientoRegistral(String identificadorIntercambio);

	public AsientoRegistralVO enviarAsientoRegistral(AsientoRegistralFormVO asiento);

	public void reenviarAsientoRegistral(String identificadorIntercambio, String usuario, String contacto, String descripcionReenvio, UnidadTramitacionIntercambioRegistralVO nuevoDestino);
	
	/**
	 * Devuelve un listado del hist�rico completo del asiento registral. Incluida informaci�n de los mensajes
	 * @param id
	 * @return
	 */
	public List<TrazabilidadVO> getHistoricoCompletoAsientoRegistral(String id);
	
	/**
	 * Devuelve un listado del hist�rico del asiento registral.
	 * @param id
	 * @return
	 */
	public List<TrazabilidadVO> getHistoricoAsientoRegistral(String id);

	public int countAsientosRegistrales(CriteriosVO criteriosVO);
	/**
	 * Obtiene el hist�rico de un asiento registral.
	 *
	 * @param entity
	 *            Identificador de la entidad.
	 * @param code
	 *            codigo del asiento registral.
	 * @return Hist�rico del asiento registral.
	 */
	public List<TrazabilidadVO> getHistoricoAsientoRegistralCode(String entity, String code);

	public EstadoAsientoRegistraVO
		getEstadoAsientoRegistralByCode(String codigoIntercambioRegistral);


}
