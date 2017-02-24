package es.ieci.tecdoc.fwktd.dir3.core.vo;

import java.util.Date;

import es.ieci.tecdoc.fwktd.core.model.Entity;

/**
 * Datos b�sicos de una unidad org�nica.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public class DatosBasicosUnidadOrganica extends Entity {

	private static final long serialVersionUID = 2776750599101372424L;

	/*
	 * =======================================================================
	 * Datos identificativos
	 *
	 * El campo "id" heredado de la clase Entity es el c�digo �nico.
	 * =======================================================================
	 */

	/**
	 * Denominaci�n de la unidad.
	 */
	private String nombre;

	/**
	 * C�digo del nivel de administraci�n (Estatal, Auton�mica o Local)
	 */
	private String nivelAdministracion;

	/**
	 * Descripci�n del nivel de administraci�n.
	 */
	private String descripcionNivelAdministracion;

	/**
	 * Indicador de si la unidad pertenece a una Entidad de Derecho P�blico.
	 */
	private String indicadorEntidadDerechoPublico;

	/**
	 * C�digo externo utilizado por la entidad p�blica que aporta los datos al
	 * Directorio Com�n.
	 */
	private String idExternoFuente;

	/*
	 * =======================================================================
	 * Datos de dependencia jer�rquica
	 * =======================================================================
	 */

	/**
	 *
	 * Unidad superior jer�rquica (de la que depende directamente la unidad).
	 */
	private String idUnidadOrganicaSuperior;

	/**
	 * Denominaci�n de la unidad superior jer�rquica (de la que depende
	 * directamente la unidad).
	 */
	private String nombreUnidadOrganicaSuperior;

	/**
	 * Unidad ra�z (m�ximo nivel jer�rquico en la entidad p�blica a la que
	 * pertenece la unidad).
	 */
	private String idUnidadOrganicaPrincipal;

	/**
	 * Denominaci�n de la unidad ra�z (m�ximo nivel jer�rquico en la entidad
	 * p�blica a la que pertenece la unidad).
	 */
	private String nombreUnidadOrganicaPrincipal;

	/**
	 * Unidad ra�z que representa a la Administraci�n a la que est� vinculada
	 * una Entidad de Derecho P�blico.
	 */
	private String idUnidadOrganicaEntidadDerechoPublico;

	/**
	 * Denominaci�n de la unidad ra�z que representa a la Administraci�n a la
	 * que est� vinculada una Entidad de Derecho P�blico.
	 */
	private String nombreUnidadOrganicaEntidadDerechoPublico;

	/**
	 * Nivel jer�rquico en la estructura de la entidad p�blica (secuencial).
	 */
	private Integer nivelJerarquico;

	/*
	 * =======================================================================
	 * Datos de vigencia
	 * =======================================================================
	 */

	/**
	 * Estado de la entidad.
	 */
	private String estado;

	/**
	 * Descripci�n del estado.
	 */
	private String descripcionEstado;

	/**
	 * Fecha de creaci�n oficial.
	 */
	private Date fechaAltaOficial;

	/**
	 * Fecha de supresi�n oficial.
	 */
	private Date fechaBajaOficial;

	/**
	 * Fecha de extinci�n final.
	 */
	private Date fechaExtincion;

	/**
	 * Fecha de anulaci�n.
	 */
	private Date fechaAnulacion;

	/**
	 * Constructor.
	 */
	public DatosBasicosUnidadOrganica() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNivelAdministracion() {
		return nivelAdministracion;
	}

	public void setNivelAdministracion(String nivelAdministracion) {
		this.nivelAdministracion = nivelAdministracion;
	}

	public String getDescripcionNivelAdministracion() {
		return descripcionNivelAdministracion;
	}

	public void setDescripcionNivelAdministracion(
			String descripcionNivelAdministracion) {
		this.descripcionNivelAdministracion = descripcionNivelAdministracion;
	}

	public String getIndicadorEntidadDerechoPublico() {
		return indicadorEntidadDerechoPublico;
	}

	public void setIndicadorEntidadDerechoPublico(
			String indicadorEntidadDerechoPublico) {
		this.indicadorEntidadDerechoPublico = indicadorEntidadDerechoPublico;
	}

	public String getIdExternoFuente() {
		return idExternoFuente;
	}

	public void setIdExternoFuente(String idExternoFuente) {
		this.idExternoFuente = idExternoFuente;
	}

	public String getIdUnidadOrganicaSuperior() {
		return idUnidadOrganicaSuperior;
	}

	public void setIdUnidadOrganicaSuperior(String idUnidadOrganicaSuperior) {
		this.idUnidadOrganicaSuperior = idUnidadOrganicaSuperior;
	}

	public String getNombreUnidadOrganicaSuperior() {
		return nombreUnidadOrganicaSuperior;
	}

	public void setNombreUnidadOrganicaSuperior(String nombreUnidadOrganicaSuperior) {
		this.nombreUnidadOrganicaSuperior = nombreUnidadOrganicaSuperior;
	}

	public String getIdUnidadOrganicaPrincipal() {
		return idUnidadOrganicaPrincipal;
	}

	public void setIdUnidadOrganicaPrincipal(String idUnidadOrganicaPrincipal) {
		this.idUnidadOrganicaPrincipal = idUnidadOrganicaPrincipal;
	}

	public String getNombreUnidadOrganicaPrincipal() {
		return nombreUnidadOrganicaPrincipal;
	}

	public void setNombreUnidadOrganicaPrincipal(
			String nombreUnidadOrganicaPrincipal) {
		this.nombreUnidadOrganicaPrincipal = nombreUnidadOrganicaPrincipal;
	}

	public String getIdUnidadOrganicaEntidadDerechoPublico() {
		return idUnidadOrganicaEntidadDerechoPublico;
	}

	public void setIdUnidadOrganicaEntidadDerechoPublico(
			String idUnidadOrganicaEntidadDerechoPublico) {
		this.idUnidadOrganicaEntidadDerechoPublico = idUnidadOrganicaEntidadDerechoPublico;
	}

	public String getNombreUnidadOrganicaEntidadDerechoPublico() {
		return nombreUnidadOrganicaEntidadDerechoPublico;
	}

	public void setNombreUnidadOrganicaEntidadDerechoPublico(
			String nombreUnidadOrganicaEntidadDerechoPublico) {
		this.nombreUnidadOrganicaEntidadDerechoPublico = nombreUnidadOrganicaEntidadDerechoPublico;
	}

	public Integer getNivelJerarquico() {
		return nivelJerarquico;
	}

	public void setNivelJerarquico(Integer nivelJerarquico) {
		this.nivelJerarquico = nivelJerarquico;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDescripcionEstado() {
		return descripcionEstado;
	}

	public void setDescripcionEstado(String descripcionEstado) {
		this.descripcionEstado = descripcionEstado;
	}

	public Date getFechaAltaOficial() {
		return fechaAltaOficial;
	}

	public void setFechaAltaOficial(Date fechaAltaOficial) {
		this.fechaAltaOficial = fechaAltaOficial;
	}

	public Date getFechaBajaOficial() {
		return fechaBajaOficial;
	}

	public void setFechaBajaOficial(Date fechaBajaOficial) {
		this.fechaBajaOficial = fechaBajaOficial;
	}

	public Date getFechaExtincion() {
		return fechaExtincion;
	}

	public void setFechaExtincion(Date fechaExtincion) {
		this.fechaExtincion = fechaExtincion;
	}

	public Date getFechaAnulacion() {
		return fechaAnulacion;
	}

	public void setFechaAnulacion(Date fechaAnulacion) {
		this.fechaAnulacion = fechaAnulacion;
	}
}
