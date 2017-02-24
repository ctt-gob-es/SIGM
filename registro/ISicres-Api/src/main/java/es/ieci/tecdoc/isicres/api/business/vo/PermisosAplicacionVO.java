package es.ieci.tecdoc.isicres.api.business.vo;

/**
 * Clase que representa los permisos a nivel de aplicacion y se asocian a nivel
 * de usuario:
 * 
 * Alta de personas f�sicas/jur�dicas Aceptaci�n de registros distribuidos
 * Modificaci�n de personas f�sicas/juridicas Rechazo de registros distribuidos
 * Introducci�n de fecha de registro Archivo de registros distribuidos
 * Modificaci�n de fecha de registro Cambio de destino de registros distribuidos
 * Modificaci�n de campos protegidos Cambio de destino de registros rechazados
 * Acceso a operaciones de intercambio registral Distribuci�n Manual Consultar
 * documentaci�n anexa Superusuario
 * 
 * @author Iecisa
 * 
 */
public class PermisosAplicacionVO extends BasePermisosVO {

	private static final long serialVersionUID = 7930859743003356252L;

	/**
	 * permiso superUsuario
	 */
	protected boolean superUsuario;

	protected boolean altaTerceros;
	protected boolean modificacionTerceros;

	protected boolean distribucionManual;
	protected boolean aceptarDistribucion;
	protected boolean rechazarDistribucion;
	protected boolean archivarDistribucion;
	protected boolean cambiarDestinoDistribucion;
	protected boolean cambiarDestinoDistribucionRechazada;

	protected boolean altaFechaRegistro;
	protected boolean modificarFechaRegistro;

	protected boolean modificarCamposProtegidos;

	protected boolean consultarDocuAnexa;

	protected boolean operacionesIntercambioRegistral;

	public boolean isSuperUsuario() {
		return superUsuario;
	}

	public void setSuperUsuario(boolean superUsuario) {
		this.superUsuario = superUsuario;
	}

	public boolean isAltaTerceros() {
		return altaTerceros;
	}

	public void setAltaTerceros(boolean altaTerceros) {
		this.altaTerceros = altaTerceros;
	}

	public boolean isModificacionTerceros() {
		return modificacionTerceros;
	}

	public void setModificacionTerceros(boolean modificacionTerceros) {
		this.modificacionTerceros = modificacionTerceros;
	}

	public boolean isDistribucionManual() {
		return distribucionManual;
	}

	public void setDistribucionManual(boolean distribucionManual) {
		this.distribucionManual = distribucionManual;
	}

	public boolean isAceptarDistribucion() {
		return aceptarDistribucion;
	}

	public void setAceptarDistribucion(boolean aceptarDistribucion) {
		this.aceptarDistribucion = aceptarDistribucion;
	}

	public boolean isRechazarDistribucion() {
		return rechazarDistribucion;
	}

	public void setRechazarDistribucion(boolean rechazarDistribucion) {
		this.rechazarDistribucion = rechazarDistribucion;
	}

	public boolean isArchivarDistribucion() {
		return archivarDistribucion;
	}

	public void setArchivarDistribucion(boolean archivarDistribucion) {
		this.archivarDistribucion = archivarDistribucion;
	}

	public boolean isCambiarDestinoDistribucion() {
		return cambiarDestinoDistribucion;
	}

	public void setCambiarDestinoDistribucion(boolean cambiarDestinoDistribucion) {
		this.cambiarDestinoDistribucion = cambiarDestinoDistribucion;
	}

	public boolean isCambiarDestinoDistribucionRechazada() {
		return cambiarDestinoDistribucionRechazada;
	}

	public void setCambiarDestinoDistribucionRechazada(
			boolean cambiarDestinoDistribucionRechazada) {
		this.cambiarDestinoDistribucionRechazada = cambiarDestinoDistribucionRechazada;
	}

	public boolean isAltaFechaRegistro() {
		return altaFechaRegistro;
	}

	public void setAltaFechaRegistro(boolean altaFechaRegistro) {
		this.altaFechaRegistro = altaFechaRegistro;
	}

	public boolean isModificarFechaRegistro() {
		return modificarFechaRegistro;
	}

	public void setModificarFechaRegistro(boolean modificarFechaRegistro) {
		this.modificarFechaRegistro = modificarFechaRegistro;
	}

	public boolean isModificarCamposProtegidos() {
		return modificarCamposProtegidos;
	}

	public void setModificarCamposProtegidos(boolean modificarCamposProtegidos) {
		this.modificarCamposProtegidos = modificarCamposProtegidos;
	}

	public boolean isConsultarDocuAnexa() {
		return consultarDocuAnexa;
	}

	public void setConsultarDocuAnexa(boolean consultarDocuAnexa) {
		this.consultarDocuAnexa = consultarDocuAnexa;
	}

	public boolean isOperacionesIntercambioRegistral() {
		return operacionesIntercambioRegistral;
	}

	public void setOperacionesIntercambioRegistral(
			boolean operacionesIntercambioRegistral) {
		this.operacionesIntercambioRegistral = operacionesIntercambioRegistral;
	}

}
