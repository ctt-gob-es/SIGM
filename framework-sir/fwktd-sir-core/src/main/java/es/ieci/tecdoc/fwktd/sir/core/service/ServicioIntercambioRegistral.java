package es.ieci.tecdoc.fwktd.sir.core.service;

import java.util.Date;
import java.util.List;

import es.ieci.tecdoc.fwktd.sir.core.types.EstadoAsientoRegistralEnum;
import es.ieci.tecdoc.fwktd.sir.core.vo.AnexoFormVO;
import es.ieci.tecdoc.fwktd.sir.core.vo.AnexoVO;
import es.ieci.tecdoc.fwktd.sir.core.vo.AsientoRegistralFormVO;
import es.ieci.tecdoc.fwktd.sir.core.vo.AsientoRegistralVO;
import es.ieci.tecdoc.fwktd.sir.core.vo.CriteriosVO;
import es.ieci.tecdoc.fwktd.sir.core.vo.EstadoAsientoRegistraVO;
import es.ieci.tecdoc.fwktd.sir.core.vo.InfoBAsientoRegistralVO;
import es.ieci.tecdoc.fwktd.sir.core.vo.InfoRechazoVO;
import es.ieci.tecdoc.fwktd.sir.core.vo.InfoReenvioVO;
import es.ieci.tecdoc.fwktd.sir.core.vo.InteresadoFormVO;
import es.ieci.tecdoc.fwktd.sir.core.vo.InteresadoVO;
import es.ieci.tecdoc.fwktd.sir.core.vo.TrazabilidadVO;

/**
 * Interfaz del servicio de intercambio registral en formato SICRES 3.0.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public interface ServicioIntercambioRegistral {

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
	 * Obtiene el estado de un asiento registral.
	 *
	 * @param id
	 *            Identificador del asiento registral.
	 * @return Estado de un asiento registral.
	 */
	public EstadoAsientoRegistraVO getEstadoAsientoRegistral(String id);

	/**
	 * Obtiene la informaci�n de un asiento registral.
	 *
	 * @param id
	 *            Identificador del asiento registral.
	 * @return Informaci�n del asiento registral.
	 */
	public AsientoRegistralVO getAsientoRegistral(String id);

	/**
	 * Crea un asiento registral.
	 *
	 * @param asientoForm
	 *            Informaci�n inicial del asiento registral.
	 * @return Asiento registral creado.
	 */
	public AsientoRegistralVO saveAsientoRegistral(
			AsientoRegistralFormVO asientoForm);

	/**
	 * Actualiza la informaci�n del asiento registral.
	 *
	 * @param infoBAsiento
	 *            Informaci�n b�sica del asiento registral (no incluye
	 *            interesados ni anexos).
	 */
	public void updateAsientoRegistral(InfoBAsientoRegistralVO infoBAsiento);

	/**
	 * Elimina la informaci�n de un asiento registral junto con sus interesados
	 * y anexos.
	 *
	 * @param id
	 *            Identificador del asiento registral.
	 */
	public void deleteAsientoRegistral(String id);

	/**
	 * A�ade un anexo a un asiento registral.
	 *
	 * @param idAsientoRegistral
	 *            Identificador del asiento registral.
	 * @param anexoForm
	 *            Informaci�n del anexo.
	 * @return Anexo creado.
	 */
	public AnexoVO addAnexo(String idAsientoRegistral, AnexoFormVO anexoForm);

	/**
	 * Modifica un anexo de un asiento registral.
	 *
	 * @param anexo
	 *            Informaci�n del anexo.
	 * @return Anexo modificado.
	 */
	public AnexoVO updateAnexo(AnexoVO anexo);

	/**
	 * Elimina un anexo de un asiento registral.
	 *
	 * @param idAnexo
	 *            Identificador del anexo.
	 */
	public void removeAnexo(String idAnexo);

	/**
	 * A�ade un interesado a un asiento registral.
	 *
	 * @param idAsientoRegistral
	 *            Identificador del asiento registral.
	 * @param interesadoForm
	 *            Informaci�n del interesado.
	 * @return Interesado creado.
	 */
	public InteresadoVO addInteresado(String idAsientoRegistral,
			InteresadoFormVO interesadoForm);

	/**
	 * Modifica un interesado de un asiento registral.
	 *
	 * @param interesado
	 *            Informaci�n del interesado.
	 * @return Interesado modificado.
	 */
	public InteresadoVO updateInteresado(InteresadoVO interesado);

	/**
	 * Elimina un interesado de un asiento registral.
	 *
	 * @param idInteresado
	 *            Identificador del interesado.
	 */
	public void removeInteresado(String idInteresado);

	/**
	 * Obtiene el contenido de un anexo.
	 *
	 * @param id
	 *            Identificador del anexo.
	 * @return Contenido del anexo.
	 */
	public byte[] getContenidoAnexo(String id);

	/**
	 * Establece el contenido de un anexo
	 *
	 * @param id
	 *            Identificador del anexo.
	 * @param contenido
	 *            Contenido del anexo.
	 */
	public void setContenidoAnexo(String id, byte[] contenido);

	/**
	 * Obtiene el hist�rico de un asiento registral.
	 *
	 * @param id
	 *            Identificador del asiento registral.
	 * @return Hist�rico del asiento registral.
	 */
	public List<TrazabilidadVO> getHistoricoAsientoRegistral(String id);
	
	/**
	 * Obtiene el hist�rico de un mensajes de control de un asiento registral.
	 *
	 * @param id
	 *            Identificador del asiento registral.
	 * @return Hist�rico del asiento registral.
	 */
	public List<TrazabilidadVO> getHistoricoMensajeIntercambioRegistral(String id);
	
	/**
	 * Obtiene el hist�rico de tanto mensajes como estados del asiento de un intercambio registral
	 *
	 * @param id
	 *            Identificador del asiento registral.
	 * @return Hist�rico del asiento registral.
	 */
	public List<TrazabilidadVO> getHistoricoCompletoAsientoRegistral(String id);

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

//	/**
//	 * Valida los anexos de un asiento registral.
//	 *
//	 * @param id
//	 *            Identificador del asiento registral.
//	 * @return Informaci�n de la validez de los anexos del asiento registral.
//	 */
//	public List<ValidacionAnexoVO> validarAnexos(String id);

	/**
	 * Recibe un fichero de datos de intercambio del nodo distribuido asociado.
	 *
	 * @param xmlFicheroIntercambio
	 *            XML con la informaci�n del fichero de datos de intercambio en
	 *            formato SICRES 3.0.
	 * @param documentos
	 *            Documentos del intercambio.
	 * @return Informaci�n del asiento registral creado.
	 */
	public AsientoRegistralVO recibirFicheroIntercambio(
			String xmlFicheroIntercambio, List<byte[]> documentos);

	/**
	 * Recibe un fichero de datos de control del nodo distribuido asociado.
	 *
	 * @param xmlMensaje
	 *            XML con la informaci�n del mensaje en formato SICRES 3.0.
	 */
	public void recibirMensaje(String xmlMensaje);

	/**
	 * Procesa los ficheros de datos de intercambio y de control recibidos
	 * mediante el sistema de ficheros.
	 */
	public void procesarFicherosRecibidos();

	/**
	 * Comprueba el time-out de la recepci�n de mensajes (ACK o ERROR) tras los
	 * env�os de ficheros de datos de intercambio.
	 */
	public void comprobarTimeOutEnvios();

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

	/**
	 * Obtiene el estado de un asiento registral.
	 *
	 * @param code
	 *            codigo del asiento registral.
	 * @return Estado de un asiento registral.
	 */
	public EstadoAsientoRegistraVO getEstadoAsientoRegistralByCode(String code);
}
