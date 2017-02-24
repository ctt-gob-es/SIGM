package es.ieci.tecdoc.isicres.api.intercambioregistral.business.manager;

import java.util.List;

import es.ieci.tecdoc.fwktd.sir.core.vo.AsientoRegistralVO;
import es.ieci.tecdoc.fwktd.sir.core.vo.CriteriosVO;
import es.ieci.tecdoc.fwktd.sir.core.vo.TrazabilidadVO;
import es.ieci.tecdoc.isicres.api.business.vo.IdentificadorRegistroVO;
import es.ieci.tecdoc.isicres.api.business.vo.UsuarioVO;
import es.ieci.tecdoc.isicres.api.intercambioregistral.business.vo.BandejaEntradaItemVO;
import es.ieci.tecdoc.isicres.api.intercambioregistral.business.vo.BandejaSalidaItemVO;
import es.ieci.tecdoc.isicres.api.intercambioregistral.business.vo.EntidadRegistralDCO;
import es.ieci.tecdoc.isicres.api.intercambioregistral.business.vo.EntidadRegistralVO;
import es.ieci.tecdoc.isicres.api.intercambioregistral.business.vo.IntercambioRegistralEntradaVO;
import es.ieci.tecdoc.isicres.api.intercambioregistral.business.vo.IntercambioRegistralSalidaVO;
import es.ieci.tecdoc.isicres.api.intercambioregistral.business.vo.UnidadAdministrativaIntercambioRegistralVO;
import es.ieci.tecdoc.isicres.api.intercambioregistral.business.vo.UnidadTramitacionDCO;
import es.ieci.tecdoc.isicres.api.intercambioregistral.business.vo.UnidadTramitacionIntercambioRegistralSIRVO;
import es.ieci.tecdoc.isicres.api.intercambioregistral.business.vo.UnidadTramitacionIntercambioRegistralVO;

/**
 * Interfaz fachada de las operaciones relacionadas con el intercambio registral
 * 
 */
public interface IntercambioRegistralManager {

	/**
	 * metodo que verifica si un registro tiene configurado un intercambio
	 * registral a traves de la unidad destino
	 * 
	 * @param idUnidadTramitacionDestino
	 * @return
	 */
	public boolean isIntercambioRegistral(String idUnidadTramitacionDestino);

	/**
	 * metodo que verifica si un registro YA EST� en la bandeja de salida de
	 * intercambio registral
	 * 
	 * @param registro
	 * @return
	 */
	public boolean isInBandejasalidaIntercambioRegistral(String idRegistro,
			String idLibro);

	/**
	 * metodo que si un registro tiene como destino una unidad que tiene
	 * configurado intercambio registral, env�a el registro hacia la bandeja de
	 * salida de intercambio registral
	 * 
	 */
	public void toIntercambioRegistral(String idLibro, String idRegistro,
			String idOfic, String tipoOrigen,
			String idUnidadTramitacionDestino, String user);

	/**
	 * Metodo que envia a la bandeja de salida de intercambio registral N
	 * registros. Se diferencia principalmente de
	 * <code>toIntercambioRegistral</code> en que no comprueba si el destino es
	 * intercambio registral.
	 * 
	 */
	public void toIntercambioRegistralManual(List<String> idRegistros,
			String idLibro, String idOfic, String tipoOrigen, String user);

	/**
	 * Guardar el intercambio registral en scr_exregaccept indicando que ya se
	 * ha aceptado el intermcabio y se ha creado el registro correspondiente
	 */
	public void guardarIntercambioRegistralEnAceptados(
			IntercambioRegistralEntradaVO intercambioRegistralEntrada);

	/**
	 * metodo que a partir de un identificador obtiene la informaci�n del
	 * intercambio registral de salida
	 * 
	 * @param id
	 */
	public IntercambioRegistralSalidaVO getIntercambioRegistralSalidaById(
			String id);

	/**
	 * metodo que a partir de un identificador de intercambio faciliado por el
	 * sir obtiene del modulo intermedio la informaci�n en detalle del
	 * intercambio registral
	 * 
	 * @param idIntercambio
	 */
	public AsientoRegistralVO getIntercambioRegistralByIdIntercambio(
			String idIntercambio);

	public String enviarIntercambioRegistralSalida(String idLibro,
			String idRegistro, String idOfic, String username,
			String tipoOrigen,
			UnidadTramitacionIntercambioRegistralVO unidadDestino);

	public String enviarIntercambioRegistralSalida(String idLibro,
		String idRegistro, String idOfic, String username, String UserContact,
		String tipoOrigen,
		UnidadTramitacionIntercambioRegistralVO unidadDestino);
	/**
	 * metodo que si el registro se encuentra en la bandeja de salida de
	 * intercambio registral en estado pendientes de envio, puede ser anulado
	 * 
	 * @param id
	 */
	public void anularIntercambioRegistralSalidaById(String id);

	/**
	 * metodo que si en la bandeja salida hay algun registro en estado anulado,
	 * lo pasa a estado pendiente de envio
	 * 
	 * @param id
	 */
	public void undoAnularIntercambioRegistral(String id);

	/**
	 * metodo que obtiene la bandeja de salida de intercambio registral para un
	 * estado y una oficina
	 * 
	 * @param estado
	 * @param idOficina
	 * @return
	 */
	public List<BandejaSalidaItemVO> getBandejaSalidaIntercambioRegistral(
			Integer estado, Integer idOficina);

	/**
	 * metodo que obtiene la bandeja de salida de intercambio registral para un
	 * estado, una oficina y un libro
	 * 
	 * @param estado
	 * @param idOficina
	 * @param idLibro
	 * @return
	 */
	public List<BandejaSalidaItemVO> getBandejaSalidaIntercambioRegistral(
			Integer estado, Integer idOficina, Integer idLibro);

	/**
	 * metodo que obtiene los intercambios registrales completos (listos para
	 * envio) de una bandeja de salida
	 * 
	 * @return
	 */
	public List<BandejaSalidaItemVO> getBandejaSalidaIntercambioRegistralCompletos(
			List<BandejaSalidaItemVO> bandejaSalida);

	/**
	 * metodo que obtiene los intercambios registrales sin ER destino (se pueden
	 * enviar pero no directamente) de una bandeja de salida
	 * 
	 * @return
	 */
	public List<BandejaSalidaItemVO> getBandejaSalidaIntercambioRegistralSinERDestino(
			List<BandejaSalidaItemVO> bandejaSalida);

	/**
	 * metodo que obtiene los intercambios registrales sin ER de origen (no se
	 * pueden enviar) de una bandeja de salida
	 * 
	 * @return
	 */
	public List<BandejaSalidaItemVO> getBandejaSalidaIntercambioRegistralSinEROrigen(
			List<BandejaSalidaItemVO> bandejaSalida);

	/**
	 * metodo que acepta un intercambio registral de entrada
	 * 
	 * @param idIntercambioRegistralEntrada
	 * @param idLibro
	 * @param user
	 * @param idOficina
	 * @param codOficina
	 * @param llegoDocFisica
	 */
	public void aceptarIntercambioRegistralEntradaById(
			String idIntercambioRegistralEntrada, String idLibro, String user,
			Integer idOficina, String codOficina, boolean llegoDocFisica);

	/**
	 * metodo que acepta un intercambio registral de entrada
	 * 
	 * @param idIntercambioRegistralEntrada
	 * @param idLibro
	 * @param user
	 * @param idOficina
	 * @param codOficina
	 * @param llegoDocFisica
	 */
	public void aceptarIntercambioRegistralEntradaById(
			String idIntercambioRegistralEntrada, String idLibro, UsuarioVO user,
			Integer idOficina, String codOficina, boolean llegoDocFisica);

	
	/**
	 * M�todo que rechaza un intercambio registral de entrada
	 * 
	 * @param idIntercambioRegistralEntrada
	 * @param tipoREchazo
	 * @param observaciones
	 */
	public void rechazarIntercambioRegistralEntradaById(
			String idIntercambioRegistralEntrada, String tipoRechazo,
			String observaciones);

	/**
	 * M�todo que reenvia un intercambio registral hacia el SIR a partir de su
	 * ID.
	 * 
	 * Tambi�n lo almacena en la tabla de intercambios de los asientos
	 * registrales
	 * 
	 * @param id
	 */
	public void reenviarIntercambioRegistralEntradaById(
			String idIntercambioRegistralEntrada, 
			UnidadTramitacionIntercambioRegistralVO nuevoDestino,
			String observaciones);

	/**
	 * Metodo que obtiene la bandeja de entrada para el usuario y siguiendo los
	 * criterios que se le facilitan
	 * 
	 * @param estado
	 * @param idOficina
	 * @return
	 */
	public List<BandejaEntradaItemVO> getBandejaEntradaIntercambioRegistral(
			Integer estado, Integer idOficina);

	/**
	 * Metodo que obtiene la bandeja de entrada para el usuario y siguiendo los
	 * criterios que se le facilitan
	 * 
	 * @param estado
	 * @param idOficina
	 * @param  CriteriosVO criterios
	 * @return
	 */
	public List<BandejaEntradaItemVO> getBandejaEntradaIntercambioRegistral(
			Integer estado, Integer idOficina, CriteriosVO criterios);



	/**
	 * Metodo que obtiene el numero de registros de la bandeja de entrada para el usuario y siguiendo los
	 * criterios que se le facilitan
	 * 
	 * @param estado
	 * @param idOficina
	 * @param  CriteriosVO criterios
	 * @return
	 */
	public int getCountBandejaEntradaIntercambioRegistral(
			Integer estado, Integer idOficina, CriteriosVO criterios);

	
	
	/**
	 * Metodo que a partir de un elemento de la bandeja de salida con los datos
	 * de SCR_EXREG, completa los datos necesarios de otras tablas (AXSF) como
	 * numero de registro o unidad de destino.
	 * 
	 * @param bandejaSalidaItemVO
	 * @return
	 */
	public BandejaSalidaItemVO completarBandejaSalidaItem(
			BandejaSalidaItemVO bandejaSalidaItemVO);

	/**
	 * Metodo que a partir de un elemento de la bandeja de entrada con los datos
	 * de SCR_EXREGACCEPT, completa los datos necesarios de otras tablas (AXSF)
	 * como numero de registro o unidad de origen.
	 * 
	 * @param bandejaEntradaItemVO
	 * @return
	 */
	public BandejaEntradaItemVO completarBandejaEntradaItem(
			BandejaEntradaItemVO bandejaEntradaItemVO);

	/**
	 * Elimina un intercambio registral de salida. Deber� estar en estado
	 * PENDIENTE
	 * 
	 * @param idLibro
	 * @param idRegistro
	 * @param idOficina
	 */
	public void deleteIntercambioRegistralSalida(Integer idLibro,
			Integer idRegistro, Integer idOficina);

	/**
	 * Obtiene la unidad administrativa a la que pertenecen los codigos del
	 * directorio comun pasados como parametro En caso de que este mapeada la
	 * unidad de tramitacion, se obtiene ese, si no, el de entidad registral.
	 * 
	 * @param codeEntidadRegistral
	 * @param codeUnidadTramitacion
	 * @return
	 */
	public UnidadAdministrativaIntercambioRegistralVO getUnidadAdministrativaByCodigosComunes(
			String codeEntidadRegistral, String codeUnidadTramitacion);

	/**
	 * Obtiene la entidad registral mapeada en el modulo comun para este
	 * <code>idScrOfic</code>
	 * 
	 * @param idSrcOfic
	 * @return
	 */
	public EntidadRegistralVO getEntidadRegistralVOByIdScrOfic(String idOfic);

	/**
	 * Obtiene la unidad de tramitacion mapeada en el modulo comun para este
	 * <code>idScrOrgs</code>
	 * 
	 * @param idScrOrgs
	 * @return
	 */
	public UnidadTramitacionIntercambioRegistralVO getUnidadTramitacionIntercambioRegistralVOByIdScrOrgs(
			String idScrOrgs);

	/**
	 * Obtiene la unidad de tramitacion mapeada en el modulo comun para este
	 * <code>codeScrOrgs</code>
	 * 
	 * @param codeScrOrgs
	 * @return
	 */
	public UnidadTramitacionIntercambioRegistralVO getUnidadTramitacionIntercambioRegistralVOByCodeScrOrgs(
			String codeScrOrgs);

	/**
	 * Metodo que obtiene el historial del intercambio registral de Salida para
	 * un registro
	 * 
	 * @param idLibro
	 * @param idRegistro
	 * @return Listado de objetos {@link IntercambioRegistralSalidaVO}
	 */
	public List<IntercambioRegistralSalidaVO> getHistorialIntercambioRegistralSalida(
			String idLibro, String idRegistro, String idOficina);

	/**
	 * Metodo que obtiene el historial del intercambio registral de Entrada para
	 * un registro
	 * 
	 * @param idLibro
	 * @param idRegistro
	 * @return Listado de objetos {@link IntercambioRegistralEntradaVO}
	 */
	public List<IntercambioRegistralEntradaVO> getHistorialIntercambioRegistralEntrada(
			String idLibro, String idRegistro, String idOficina);
	
	/**
	 * Metodo que obtiene el historial del intercambio registral de Entrada para
	 * un registro
	 * 
	 * @param idLibro
	 * @param idRegistro
	 * @return Listado de objetos {@link IntercambioRegistralEntradaVO}
	 */
	public List<IntercambioRegistralEntradaVO> getHistorialIntercambioRegistralEntradaResumen(
			String idLibro, String idRegistro, String idOficina);

	/**
	 * Metodo que obtiene el historial del intercambio registral de Salida para
	 * un registro
	 * 
	 * @param idLibro
	 * @param idRegistro
	 * @return Listado de objetos {@link IntercambioRegistralSalidaVO}
	 */
	public List<IntercambioRegistralSalidaVO> getHistorialIntercambioRegistralSalidaResumen(
			String idLibro, String idRegistro, String idOficina);

	
	public List<EntidadRegistralDCO> buscarEntidadesRegistralesDCO(String code,
			String nombre);

	public List<UnidadTramitacionDCO> buscarUnidadesTramitacionDCO(String code,
			String nombre);

	/**
	 * M�todo que devuelve el contenido de un fichero anexo de un intercambio
	 * registral
	 * 
	 * @param idAnexo
	 * @return
	 */
	public byte[] getContenidoAnexo(String idAnexo);

	/**
	 * Devuelve un listado del hist�rico completo del asiento registral.
	 * Incluidas las trazas de mensajes
	 * 
	 * @param id
	 * @return
	 */
	public List<TrazabilidadVO> getTrazasIntercambioRegistral(String id);

	/**
	 * Devuelve un listado del hist�rico del asiento registral
	 * 
	 * @param id
	 * @return
	 */
	public List<TrazabilidadVO> getHistoricoCompletoAsientoRegistral(String id);

	/**
	 * Obtiene la lista de unidades de tramitacion mapeada en el modulo comun para este
	 * c�digo y/o nombre.
	 * 
	 * @param code
	 * 	codigo del organismo
	 * @param name
	 * 	nombre del organismo
	 * @return
	 */
	public List<UnidadTramitacionIntercambioRegistralSIRVO> buscarUnidadesTramitacion(
	    String code, String name);

	/**
	 * M�todo que rechaza un intercambio registral de entrada
	 * 
	 * @param idIntercambioRegistralEntrada
	 * @param tipoREchazo
	 * @param observaciones
	 * @param user
	 * @param idOficina
	 * @param codOficina
	 */
	public void rechazarIntercambioRegistralEntradaById(String valueOf, String tipoRechazo,
		String motivo, UsuarioVO user, Integer idOficina, String codOficina);

	/**
	 * M�todo que reenvia un intercambio registral hacia el SIR a partir de su
	 * ID.
	 * Tambi�n lo almacena en la tabla de intercambios de los asientos
	 * registrales
	 * 
	 * @param user
	 * @param idOficina
	 * @param codOficina
	 */
	public void reenviarIntercambioRegistralEntradaById(String valueOf,
		UnidadTramitacionIntercambioRegistralVO unidadTramitacionDestino,
		String observaciones, UsuarioVO user, Integer idOficina, String codOficina);

	public void reenviarIntercambioRegistralSalidaById(String valueOf,
		UnidadTramitacionIntercambioRegistralVO unidadTramitacionDestino,
		String observaciones, UsuarioVO user, Integer idOficina, String codOficina);

	public void rectificarIntercambioRegistralSalidaById(String string ,IdentificadorRegistroVO  identificadorRegistroVO);

	
}
