package es.ieci.tecdoc.fwktd.sir.core.vo;

import java.util.Date;

import es.ieci.tecdoc.fwktd.core.model.Entity;
import es.ieci.tecdoc.fwktd.sir.core.types.DocumentacionFisicaEnum;
import es.ieci.tecdoc.fwktd.sir.core.types.EstadoAsientoRegistralEnum;
import es.ieci.tecdoc.fwktd.sir.core.types.IndicadorPruebaEnum;
import es.ieci.tecdoc.fwktd.sir.core.types.TipoAnotacionEnum;
import es.ieci.tecdoc.fwktd.sir.core.types.TipoRegistroEnum;
import es.ieci.tecdoc.fwktd.sir.core.types.TipoTransporteEnum;

/**
 * Informaci�n b�sica de un asiento registral intercambiado.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public class InfoBAsientoRegistralVO extends Entity {

	private static final long serialVersionUID = 8405161685856026267L;

	/**
	 * C�digo �nico de la entidad registral propietaria del asiento registral
	 * obtenido del directorio com�n.
	 */
	private String codigoEntidadRegistral;

	/**
	 * C�digo �nico de la entidad registral origen obtenido del directorio
	 * com�n.
	 */
	private String codigoEntidadRegistralOrigen;

	/**
	 * Descripci�n de la entidad registral origen.
	 */
	private String descripcionEntidadRegistralOrigen;

	/**
	 * N�mero de registro en la entidad registral origen.
	 */
	private String numeroRegistro;

	/**
	 * Fecha y hora de registro en la entidad registral origen.
	 */
	private Date fechaRegistro;

	/**
	 * Sello de tiempo del registro de entrada en origen.
	 */
	private byte[] timestampRegistro;

	/**
	 * N�mero del registro inicial.
	 */
	private String numeroRegistroInicial;

	/**
	 * Fecha y hora del registro inicial.
	 */
	private Date fechaRegistroInicial;

	/**
	 * Sello de tiempo del registro inicial.
	 */
	private byte[] timestampRegistroInicial;

	/**
	 * C�digo �nico de la unidad de tramitaci�n de origen obtenido del
	 * directorio com�n.
	 */
	private String codigoUnidadTramitacionOrigen;

	/**
	 * Descripci�n de la unidad de tramitaci�n de origen.
	 */
	private String descripcionUnidadTramitacionOrigen;

	/**
	 * C�digo �nico de la entidad registral de destino obtenido del directorio
	 * com�n.
	 */
	private String codigoEntidadRegistralDestino;

	/**
	 * Descripci�n de la entidad registral de destino.
	 */
	private String descripcionEntidadRegistralDestino;

	/**
	 * C�digo �nico de la unidad de tramitaci�n de destino obtenido del
	 * directorio com�n.
	 */
	private String codigoUnidadTramitacionDestino;

	/**
	 * Descripci�n de la unidad de tramitaci�n de destino.
	 */
	private String descripcionUnidadTramitacionDestino;

	/**
	 * Abstract o resumen.
	 */
	private String resumen;

	/**
	 * C�digo de asunto seg�n destino.
	 */
	private String codigoAsunto;

	/**
	 * Referencia externa.
	 */
	private String referenciaExterna;

	/**
	 * N�mero de expediente objeto de la tramitaci�n administrativa.
	 */
	private String numeroExpediente;

	/**
	 * Tipo de transporte de entrada.
	 */
	private TipoTransporteEnum tipoTransporte;

	/**
	 * N�mero de transporte de entrada.
	 */
	private String numeroTransporte;

	/**
	 * Nombre del usuario de origen.
	 */
	private String nombreUsuario;

	/**
	 * Contacto del usuario de origen (tel�fono o direcci�n de correo
	 * electr�nico).
	 */
	private String contactoUsuario;

	/**
	 * Identificador de intercambio �nico de la operaci�n.
	 */
	private String identificadorIntercambio;

	/**
	 * Estado del asiento registral.
	 */
	private EstadoAsientoRegistralEnum estado;

	/**
	 * Fecha de estado del asiento registral.
	 */
	private Date fechaEstado;

	/**
	 * Fecha de env�o del asiento registral.
	 */
	private Date fechaEnvio;

	/**
	 * Fecha de recepci�n del asiento registral.
	 */
	private Date fechaRecepcion;

	/**
	 * N�mero de reintentos de env�o.
	 */
	private int numeroReintentos;

	/**
	 * Aplicaci�n y versi�n emisora.
	 */
	private String aplicacion;
	
	/**
	 * Tipo de anotaci�n.
	 */
	private TipoAnotacionEnum tipoAnotacion;
	
	/**
	 * Descripci�n del tipo de anotaci�n.
	 */
	private String descripcionTipoAnotacion;

	/**
	 * Tipo de registro.
	 */
	private TipoRegistroEnum tipoRegistro;

	/**
	 * Documentaci�n f�sica que acompa�a al fichero.
	 */
	private DocumentacionFisicaEnum documentacionFisica;

	/**
	 * Observaciones del registro de datos de intercambio recogidos por el
	 * funcionario de registro.
	 */
	private String observacionesApunte;

	/**
	 * Indicador de prueba
	 */
	private IndicadorPruebaEnum indicadorPrueba = IndicadorPruebaEnum.NORMAL;

	/**
	 * C�digo �nico de la entidad registral de inicio obtenido del directorio
	 * com�n.
	 */
	private String codigoEntidadRegistralInicio;

	/**
	 * Descripci�n de la entidad registral de inicio.
	 */
	private String descripcionEntidadRegistralInicio;

	/**
	 * Exposici�n de los hechos y antecedentes relacionados con la solicitud.
	 */
	private String expone;

	/**
	 * Descripci�n del objeto de la solicitud.
	 */
	private String solicita;

	/**
	 * C�digo del error producido.
	 */
	private String codigoError;

	/**
	 * Descripci�n del error producido.
	 */
	private String descripcionError;

	/**
	 * Constructor.
	 */
	public InfoBAsientoRegistralVO() {
		super();
	}

	public String getCodigoEntidadRegistralOrigen() {
		return codigoEntidadRegistralOrigen;
	}

	public void setCodigoEntidadRegistralOrigen(
			String codigoEntidadRegistralOrigen) {
		this.codigoEntidadRegistralOrigen = codigoEntidadRegistralOrigen;
	}

	public String getDescripcionEntidadRegistralOrigen() {
		return descripcionEntidadRegistralOrigen;
	}

	public void setDescripcionEntidadRegistralOrigen(
			String descripcionEntidadRegistralOrigen) {
		this.descripcionEntidadRegistralOrigen = descripcionEntidadRegistralOrigen;
	}

	public String getNumeroRegistro() {
		return numeroRegistro;
	}

	public void setNumeroRegistro(String numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public byte[] getTimestampRegistro() {
		return timestampRegistro;
	}

	public void setTimestampRegistro(byte[] timestampRegistro) {
		this.timestampRegistro = timestampRegistro;
	}

	public String getNumeroRegistroInicial() {
		return numeroRegistroInicial;
	}

	public void setNumeroRegistroInicial(String numeroRegistroInicial) {
		this.numeroRegistroInicial = numeroRegistroInicial;
	}

	public Date getFechaRegistroInicial() {
		return fechaRegistroInicial;
	}

	public void setFechaRegistroInicial(Date fechaRegistroInicial) {
		this.fechaRegistroInicial = fechaRegistroInicial;
	}

	public byte[] getTimestampRegistroInicial() {
		return timestampRegistroInicial;
	}

	public void setTimestampRegistroInicial(byte[] timestampRegistroInicial) {
		this.timestampRegistroInicial = timestampRegistroInicial;
	}

	public String getCodigoUnidadTramitacionOrigen() {
		return codigoUnidadTramitacionOrigen;
	}

	public void setCodigoUnidadTramitacionOrigen(
			String codigoUnidadTramitacionOrigen) {
		this.codigoUnidadTramitacionOrigen = codigoUnidadTramitacionOrigen;
	}

	public String getDescripcionUnidadTramitacionOrigen() {
		return descripcionUnidadTramitacionOrigen;
	}

	public void setDescripcionUnidadTramitacionOrigen(
			String descripcionUnidadTramitacionOrigen) {
		this.descripcionUnidadTramitacionOrigen = descripcionUnidadTramitacionOrigen;
	}

	public String getCodigoEntidadRegistralDestino() {
		return codigoEntidadRegistralDestino;
	}

	public void setCodigoEntidadRegistralDestino(
			String codigoEntidadRegistralDestino) {
		this.codigoEntidadRegistralDestino = codigoEntidadRegistralDestino;
	}

	public String getDescripcionEntidadRegistralDestino() {
		return descripcionEntidadRegistralDestino;
	}

	public void setDescripcionEntidadRegistralDestino(
			String descripcionEntidadRegistralDestino) {
		this.descripcionEntidadRegistralDestino = descripcionEntidadRegistralDestino;
	}

	public String getCodigoUnidadTramitacionDestino() {
		return codigoUnidadTramitacionDestino;
	}

	public void setCodigoUnidadTramitacionDestino(
			String codigoUnidadTramitacionDestino) {
		this.codigoUnidadTramitacionDestino = codigoUnidadTramitacionDestino;
	}

	public String getDescripcionUnidadTramitacionDestino() {
		return descripcionUnidadTramitacionDestino;
	}

	public void setDescripcionUnidadTramitacionDestino(
			String descripcionUnidadTramitacionDestino) {
		this.descripcionUnidadTramitacionDestino = descripcionUnidadTramitacionDestino;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public String getCodigoAsunto() {
		return codigoAsunto;
	}

	public void setCodigoAsunto(String codigoAsunto) {
		this.codigoAsunto = codigoAsunto;
	}

	public String getReferenciaExterna() {
		return referenciaExterna;
	}

	public void setReferenciaExterna(String referenciaExterna) {
		this.referenciaExterna = referenciaExterna;
	}

	public String getNumeroExpediente() {
		return numeroExpediente;
	}

	public void setNumeroExpediente(String numeroExpediente) {
		this.numeroExpediente = numeroExpediente;
	}

	public TipoTransporteEnum getTipoTransporte() {
		return tipoTransporte;
	}

	public void setTipoTransporte(TipoTransporteEnum tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}

	public String getNumeroTransporte() {
		return numeroTransporte;
	}

	public void setNumeroTransporte(String numeroTransporte) {
		this.numeroTransporte = numeroTransporte;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContactoUsuario() {
		return contactoUsuario;
	}

	public void setContactoUsuario(String contactoUsuario) {
		this.contactoUsuario = contactoUsuario;
	}

	public String getIdentificadorIntercambio() {
		return identificadorIntercambio;
	}

	public void setIdentificadorIntercambio(String identificadorIntercambio) {
		this.identificadorIntercambio = identificadorIntercambio;
	}

	public EstadoAsientoRegistralEnum getEstado() {
		return estado;
	}

	public void setEstado(EstadoAsientoRegistralEnum estado) {
		this.estado = estado;
	}

	public Date getFechaEstado() {
		return fechaEstado;
	}

	public void setFechaEstado(Date fechaEstado) {
		this.fechaEstado = fechaEstado;
	}

	public Date getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public String getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
	}

	public TipoRegistroEnum getTipoRegistro() {
		return tipoRegistro;
	}

	public void setTipoRegistro(TipoRegistroEnum tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public DocumentacionFisicaEnum getDocumentacionFisica() {
		return documentacionFisica;
	}

	public void setDocumentacionFisica(
			DocumentacionFisicaEnum documentacionFisica) {
		this.documentacionFisica = documentacionFisica;
	}

	public String getObservacionesApunte() {
		return observacionesApunte;
	}

	public void setObservacionesApunte(String observacionesApunte) {
		this.observacionesApunte = observacionesApunte;
	}

	public IndicadorPruebaEnum getIndicadorPrueba() {
		return indicadorPrueba;
	}

	public void setIndicadorPrueba(IndicadorPruebaEnum indicadorPrueba) {
		this.indicadorPrueba = indicadorPrueba;
	}

	public String getCodigoEntidadRegistralInicio() {
		return codigoEntidadRegistralInicio;
	}

	public void setCodigoEntidadRegistralInicio(
			String codigoEntidadRegistralInicio) {
		this.codigoEntidadRegistralInicio = codigoEntidadRegistralInicio;
	}

	public String getDescripcionEntidadRegistralInicio() {
		return descripcionEntidadRegistralInicio;
	}

	public void setDescripcionEntidadRegistralInicio(
			String descripcionEntidadRegistralInicio) {
		this.descripcionEntidadRegistralInicio = descripcionEntidadRegistralInicio;
	}

	public String getExpone() {
		return expone;
	}

	public void setExpone(String expone) {
		this.expone = expone;
	}

	public String getSolicita() {
		return solicita;
	}

	public void setSolicita(String solicita) {
		this.solicita = solicita;
	}

	public String getCodigoError() {
		return codigoError;
	}

	public void setCodigoError(String codigoError) {
		this.codigoError = codigoError;
	}

	public String getDescripcionError() {
		return descripcionError;
	}

	public void setDescripcionError(String descripcionError) {
		this.descripcionError = descripcionError;
	}

	public int getNumeroReintentos() {
		return numeroReintentos;
	}

	public void setNumeroReintentos(int numeroReintentos) {
		this.numeroReintentos = numeroReintentos;
	}

	public String getCodigoEntidadRegistral() {
		return codigoEntidadRegistral;
	}

	public void setCodigoEntidadRegistral(String codigoEntidadRegistral) {
		this.codigoEntidadRegistral = codigoEntidadRegistral;
	}

	public TipoAnotacionEnum getTipoAnotacion() {
		return tipoAnotacion;
	}

	public void setTipoAnotacion(TipoAnotacionEnum tipoAnotacion) {
		this.tipoAnotacion = tipoAnotacion;
	}

	public String getDescripcionTipoAnotacion() {
		return descripcionTipoAnotacion;
	}

	public void setDescripcionTipoAnotacion(String descripcionTipoAnotacion) {
		this.descripcionTipoAnotacion = descripcionTipoAnotacion;
	}
}
