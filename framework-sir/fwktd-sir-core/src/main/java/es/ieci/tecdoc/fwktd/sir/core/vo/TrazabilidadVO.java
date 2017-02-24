package es.ieci.tecdoc.fwktd.sir.core.vo;

import java.util.Date;

import es.ieci.tecdoc.fwktd.core.model.BaseValueObject;

/**
 * Informaci�n de trazabilidad de un asiento registral, conforme a los estados
 * descritos en SICRES 3.0.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public class TrazabilidadVO extends BaseValueObject {

	private static final long serialVersionUID = -6816910449702223021L;

	/**
	 * C�digo
	 */
	private String codigo;
	
	/**
	 * Descripci�n.
	 */
	private String descripcion;
	
	/**
	 * En caso de tratarse de un error, c�digo del error producido.
	 */
	private String codigoError;

	/**
	 * En caso de tratarse de un error, en este campo se informar� del motivo
	 * del mismo.
	 */
	private String descripcionErrorAlternativa;

	/**
	 * C�digo de error de servicio.
	 */
	private String codigoErrorServicio;
	
	/**
	 * Descripci�n del error de servicio.
	 */
	private String descripcionErrorServicio;
	
	/**
	 * C�digo �nico de intercambio de registro.
	 */
	private String codigoIntercambio;

	/**
	 * C�digo centralizado del organismo origen del registro.
	 */
	private String codigoEntidadRegistralOrigen;

	/**
	 * Descripci�n del organismo origen del registro.
	 */
	private String descripcionEntidadRegistralOrigen;

	/**
	 * C�digo centralizado del organismo destino del registro.
	 */
	private String codigoEntidadRegistralDestino;

	/**
	 * Descripci�n del organismo destino del registro.
	 */
	private String descripcionEntidadRegistralDestino;

	/**
	 * C�digo centralizado de la unidad de tramitaci�n origen del registro.
	 */
	private String codigoUnidadTramitacionOrigen;

	/**
	 * Descripci�n de la unidad de tramitaci�n origen del registro.
	 */
	private String descripcionUnidadTramitacionOrigen;

	/**
	 * C�digo centralizado de la unidad de tramitaci�n de destino del registro.
	 */
	private String codigoUnidadTramitacionDestino;

	/**
	 * Descripci�n de la unidad de tramitaci�n destino del registro.
	 */
	private String descripcionUnidadTramitacionDestino;

	/**
	 * C�digo del estado de la trazabilidad.
	 */
	private String codigoEstado;

	/**
	 * C�digo del nodo territorial desde donde se est� insertando en
	 * trazabilidad.
	 */
	private String codigoNodo;

	/**
	 * Nombre del xml de intercambio.
	 */
	private String nombreFicheroIntercambio;

	/**
	 * Descripci�n asociada al estado de la trazabilidad correspondiente.
	 */
	private String motivoRechazo;

	/**
	 * Fecha y hora de alta del fichero de intercambio.
	 */
	private Date fechaAlta;

	/**
	 * Fecha y hora de modificaci�n del fichero de intercambio.
	 */
	private Date fechaModificacion;

	/**
	 * Flag que indica si se trata de un registro o un mensaje. True-Fichero de
	 * intercambio, False-Fichero de mensaje.
	 */
	private boolean registro = true;

	/**
	 * Tama�o total de los documentos anexos.
	 */
	private long tamanyoDocs;

	/**
	 * Constructor.
	 */
	public TrazabilidadVO() {
		super();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCodigoError() {
		return codigoError;
	}

	public void setCodigoError(String codigoError) {
		this.codigoError = codigoError;
	}

	public String getDescripcionErrorAlternativa() {
		return descripcionErrorAlternativa;
	}

	public void setDescripcionErrorAlternativa(String descripcionErrorAlternativa) {
		this.descripcionErrorAlternativa = descripcionErrorAlternativa;
	}

	public String getCodigoErrorServicio() {
		return codigoErrorServicio;
	}

	public void setCodigoErrorServicio(String codigoErrorServicio) {
		this.codigoErrorServicio = codigoErrorServicio;
	}

	public String getDescripcionErrorServicio() {
		return descripcionErrorServicio;
	}

	public void setDescripcionErrorServicio(String descripcionErrorServicio) {
		this.descripcionErrorServicio = descripcionErrorServicio;
	}

	public String getCodigoIntercambio() {
		return codigoIntercambio;
	}

	public void setCodigoIntercambio(String codigoIntercambio) {
		this.codigoIntercambio = codigoIntercambio;
	}

	public String getCodigoEntidadRegistralOrigen() {
		return codigoEntidadRegistralOrigen;
	}

	public void setCodigoEntidadRegistralOrigen(String codigoEntidadRegistralOrigen) {
		this.codigoEntidadRegistralOrigen = codigoEntidadRegistralOrigen;
	}

	public String getDescripcionEntidadRegistralOrigen() {
		return descripcionEntidadRegistralOrigen;
	}

	public void setDescripcionEntidadRegistralOrigen(
			String descripcionEntidadRegistralOrigen) {
		this.descripcionEntidadRegistralOrigen = descripcionEntidadRegistralOrigen;
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

	public String getCodigoEstado() {
		return codigoEstado;
	}

	public void setCodigoEstado(String codigoEstado) {
		this.codigoEstado = codigoEstado;
	}

	public String getCodigoNodo() {
		return codigoNodo;
	}

	public void setCodigoNodo(String codigoNodo) {
		this.codigoNodo = codigoNodo;
	}

	public String getNombreFicheroIntercambio() {
		return nombreFicheroIntercambio;
	}

	public void setNombreFicheroIntercambio(String nombreFicheroIntercambio) {
		this.nombreFicheroIntercambio = nombreFicheroIntercambio;
	}

	public String getMotivoRechazo() {
		return motivoRechazo;
	}

	public void setMotivoRechazo(String motivoRechazo) {
		this.motivoRechazo = motivoRechazo;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public boolean isRegistro() {
		return registro;
	}

	public void setRegistro(boolean registro) {
		this.registro = registro;
	}

	public long getTamanyoDocs() {
		return tamanyoDocs;
	}

	public void setTamanyoDocs(long tamanyoDocs) {
		this.tamanyoDocs = tamanyoDocs;
	}

}
