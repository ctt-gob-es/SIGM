package ieci.tecdoc.sgm.core.services.pago;

import java.util.Date;

public class Liquidacion {

	// Estados del pago
	public static final String ESTADO_PENDIENTE = "00";
	public static final String ESTADO_PAGADO = "01";
	
	// Discriminante de periodo
	public static final String DISCRIMINANTE_UN_PERIODO = "1";
	public static final String DISCRIMINANTE_DOS_PERIODOS_PRIMER_IMPORTE = "5";
	public static final String DISCRIMINANTE_DOS_PERIODOS_SEGUNDO_IMPORTE = "9";

	private String referencia;
	private String idEntidadEmisora;
	private String idTasa;
	private String ejercicio;
	private String vencimiento;
	private String discriminante;
	private String remesa;
	private String importe;
	private String nif;
	private String nrc;
	private String estado;
	private Tasa tasa;
	private String nombre;
	private String datosEspecificos;
	private Date inicioPeriodo;
	private Date finPeriodo;
	private byte[] solicitud;
	private Date fechaPago;
	
	public String getDatosEspecificos() {
		return datosEspecificos;
	}
	public void setDatosEspecificos(String datosEspecificos) {
		this.datosEspecificos = datosEspecificos;
	}
	public String getDiscriminante() {
		return discriminante;
	}
	public void setDiscriminante(String discriminante) {
		this.discriminante = discriminante;
	}
	public String getEjercicio() {
		return ejercicio;
	}
	public void setEjercicio(String ejercicio) {
		this.ejercicio = ejercicio;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	public Date getFinPeriodo() {
		return finPeriodo;
	}
	public void setFinPeriodo(Date finPeriodo) {
		this.finPeriodo = finPeriodo;
	}
	public String getIdEntidadEmisora() {
		return idEntidadEmisora;
	}
	public void setIdEntidadEmisora(String idEntidadEmisora) {
		this.idEntidadEmisora = idEntidadEmisora;
	}
	public String getIdTasa() {
		return idTasa;
	}
	public void setIdTasa(String idTasa) {
		this.idTasa = idTasa;
	}
	public String getImporte() {
		return importe;
	}
	public void setImporte(String importe) {
		this.importe = importe;
	}
	public Date getInicioPeriodo() {
		return inicioPeriodo;
	}
	public void setInicioPeriodo(Date inicioPeriodo) {
		this.inicioPeriodo = inicioPeriodo;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNrc() {
		return nrc;
	}
	public void setNrc(String nrc) {
		this.nrc = nrc;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getRemesa() {
		return remesa;
	}
	public void setRemesa(String remesa) {
		this.remesa = remesa;
	}
	public byte[] getSolicitud() {
		return solicitud;
	}
	public void setSolicitud(byte[] solicitud) {
		this.solicitud = solicitud;
	}
	public Tasa getTasa() {
		return tasa;
	}
	public void setTasa(Tasa tasa) {
		this.tasa = tasa;
	}
	public String getVencimiento() {
		return vencimiento;
	}
	public void setVencimiento(String vencimiento) {
		this.vencimiento = vencimiento;
	}

}
