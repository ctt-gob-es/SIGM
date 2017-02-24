package es.ieci.tecdoc.fwktd.sir.ws.manager;

import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import es.ieci.tecdoc.fwktd.sir.core.vo.EstadoAsientoRegistraVO;
import es.ieci.tecdoc.fwktd.sir.ws.service.AnexoDTO;
import es.ieci.tecdoc.fwktd.sir.ws.service.AnexoFormDTO;
import es.ieci.tecdoc.fwktd.sir.ws.service.AsientoRegistralDTO;
import es.ieci.tecdoc.fwktd.sir.ws.service.AsientoRegistralFormDTO;
import es.ieci.tecdoc.fwktd.sir.ws.service.CriteriosDTO;
import es.ieci.tecdoc.fwktd.sir.ws.service.EstadoAsientoRegistralDTO;
import es.ieci.tecdoc.fwktd.sir.ws.service.InfoBAsientoRegistralDTO;
import es.ieci.tecdoc.fwktd.sir.ws.service.InfoRechazoDTO;
import es.ieci.tecdoc.fwktd.sir.ws.service.InfoReenvioDTO;
import es.ieci.tecdoc.fwktd.sir.ws.service.InteresadoDTO;
import es.ieci.tecdoc.fwktd.sir.ws.service.InteresadoFormDTO;
import es.ieci.tecdoc.fwktd.sir.ws.service.TrazabilidadDTO;


/**
 * Interfaz para el gestor de intercambio registral que utilizar�n las
 * aplicaciones de registro de backoffice.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public interface IntercambioRegistralManager {

	/**
	 * Obtiene el n�mero de asientos registrales encontrados
	 * seg�n los criterios de b�squeda.
	 *
	 * @param criterios
	 *            Criterios de b�squeda.
	 * @return N�mero de asientos registrales encontrados.
	 */
	public int countAsientosRegistrales(CriteriosDTO criterios);

	/**
	 * Realiza una b�squeda de asientos registrales.
	 *
	 * @param criterios
	 *            Criterios de b�squeda.
	 * @return Asientos registrales encontrados.
	 */
	public List<AsientoRegistralDTO> findAsientosRegistrales(
			CriteriosDTO criterios);

	/**
	 * Obtiene el estado de un asiento registral.
	 *
	 * @param id
	 *            Identificador del asiento registral.
	 * @return Estado de un asiento registral.
	 */
	public EstadoAsientoRegistralDTO getEstadoAsientoRegistral(String id);
	

	/**
	 * Obtiene la informaci�n de un asiento registral.
	 *
	 * @param id
	 *            Identificador del asiento registral.
	 * @return Informaci�n del asiento registral.
	 */
	public AsientoRegistralDTO getAsientoRegistral(String id);

	/**
	 * Crea un asiento registral.
	 *
	 * @param asiento
	 *            Informaci�n inicial del asiento registral.
	 * @return Asiento registral creado.
	 */
	public AsientoRegistralDTO saveAsientoRegistral(AsientoRegistralFormDTO asiento);

	/**
	 * Actualiza la informaci�n del asiento registral.
	 *
	 * @param infoBAsiento
	 *            Informaci�n b�sica del asiento registral (no incluye
	 *            interesados ni anexos).
	 */
	public void updateAsientoRegistral(InfoBAsientoRegistralDTO infoBAsiento);

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
	 * @param anexo
	 *            Informaci�n del anexo.
	 * @return Anexo creado.
	 */
	public AnexoDTO addAnexo(String idAsientoRegistral, AnexoFormDTO anexo);

	/**
	 * Modifica un anexo de un asiento registral.
	 *
	 * @param anexo
	 *            Informaci�n del anexo.
	 * @return Anexo modificado.
	 */
	public AnexoDTO updateAnexo(AnexoDTO anexo);

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
	 * @param interesado
	 *            Informaci�n del interesado.
	 * @return Interesado creado.
	 */
	public InteresadoDTO addInteresado(String idAsientoRegistral,
			InteresadoFormDTO interesado);

	/**
	 * Modifica un interesado de un asiento registral.
	 *
	 * @param interesado
	 *            Informaci�n del interesado.
	 * @return Interesado modificado.
	 */
    public InteresadoDTO updateInteresado(InteresadoDTO interesado);

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
	public List<TrazabilidadDTO> getHistoricoAsientoRegistral(String id);
	
	/**
	 * Obtiene el hist�rico de mensajes de un asiento registral.
	 *
	 * @param id
	 *            Identificador del asiento registral.
	 * @return Hist�rico del asiento registral.
	 */
	public List<TrazabilidadDTO> getHistoricoMensajeIntercambioRegistral(String id);
	
	/**
	 * Obtiene el hist�rico de un asiento registral tanto de estados de registro como de mensajes.
	 *
	 * @param id
	 *            Identificador del asiento registral.
	 * @return Hist�rico del asiento registral.
	 */
	public List<TrazabilidadDTO> getHistoricoCompletoAsientoRegistral(String id);

	/**
	 * Env�o del fichero de datos de intercambio al nodo distribuido asociado.
	 *
	 * @param asientoForm
	 *            Informaci�n del asiento registral.
	 * @return Asiento registral creado.
	 */
	public AsientoRegistralDTO enviarAsientoRegistral(AsientoRegistralFormDTO asientoForm);

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
	public void validarAsientoRegistral(String id,
			String numeroRegistro, XMLGregorianCalendar fechaRegistro);

	/**
	 * Reenv�a un asiento registral recibido o devuelto.
	 *
	 * @param id
	 *            Identificador del asiento registral.
	 */
	public void reenviarAsientoRegistral(String id);
	
	/**
	 * Reenv�a un asiento registral recibido o devuelto.
	 *
	 * @param id
	 *            Identificador del asiento registral.
	 * @param infoReenvio
	 *            Informaci�n sobre el reenv�o.
	 */
	public void reenviarAsientoRegistral(String id, InfoReenvioDTO infoReenvio);


	/**
	 * Rechaza un asiento registral recibido.
	 *
	 * @param id
	 *            Identificador del asiento registral.
	 * @param infoRechazo
	 *            Informaci�n sobre el rechazo.
	 */
	public void rechazarAsientoRegistral(String id, InfoRechazoDTO infoRechazo);

	/**
	 * Anula un asiento registral devuelto.
	 *
	 * @param id
	 *            Identificador del asiento registral.
	 */
	public void anularAsientoRegistral(String id);

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
	public AsientoRegistralDTO recibirFicheroIntercambio(
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

	public List<TrazabilidadDTO> getHistoricoAsientoRegistralCode(String entity, String code);

//	/**
//	 * Valida los anexos de un asiento registral.
//	 *
//	 * @param id
//	 *            Identificador del asiento registral.
//	 * @return Informaci�n de la validez de los anexos del asiento registral.
//	 */
//	public List<ValidacionAnexoDTO> validarAnexos(String id);
}
