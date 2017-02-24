package es.msssi.tecdoc.fwktd.dir.ws.object;

import java.io.Serializable;
import java.util.Date;

/**
 * Datos b�sicos de una unidad org�nica.
 *
 * @author cmorenog
 *
 */
public class DatosUnidadOrganica  implements Serializable {
	
	private static final long serialVersionUID = 2776750599101372424L;
	private String id;

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
	 * Constructor
	 */
	public DatosUnidadOrganica() {
	}

	/**
	 * Obtiene el valor del par�metro id.
	 * 
	 * @return id valor del campo a obtener.
	 *
	 */
	public String getId() {
		return id;
	}

	/**
	 * Guarda el valor del par�metro id.
	 * 
	 * @param id
	 *            valor del campo a guardar.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Obtiene el valor del par�metro nombre.
	 * 
	 * @return nombre valor del campo a obtener.
	 *
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Guarda el valor del par�metro nombre.
	 * 
	 * @param nombre
	 *            valor del campo a guardar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el valor del par�metro nivelAdministracion.
	 * 
	 * @return nivelAdministracion valor del campo a obtener.
	 *
	 */
	public String getNivelAdministracion() {
		return nivelAdministracion;
	}

	/**
	 * Guarda el valor del par�metro nivelAdministracion.
	 * 
	 * @param nivelAdministracion
	 *            valor del campo a guardar.
	 */
	public void setNivelAdministracion(String nivelAdministracion) {
		this.nivelAdministracion = nivelAdministracion;
	}

	/**
	 * Obtiene el valor del par�metro descripcionNivelAdministracion.
	 * 
	 * @return descripcionNivelAdministracion valor del campo a obtener.
	 *
	 */
	public String getDescripcionNivelAdministracion() {
		return descripcionNivelAdministracion;
	}

	/**
	 * Guarda el valor del par�metro setDescripcionNivelAdministracion.
	 * 
	 * @param setDescripcionNivelAdministracion
	 *            valor del campo a guardar.
	 */
	public void setDescripcionNivelAdministracion(
			String descripcionNivelAdministracion) {
		this.descripcionNivelAdministracion = descripcionNivelAdministracion;
	}

	/**
	 * Obtiene el valor del par�metro indicadorEntidadDerechoPublico.
	 * 
	 * @return indicadorEntidadDerechoPublico valor del campo a obtener.
	 *
	 */
	public String getIndicadorEntidadDerechoPublico() {
		return indicadorEntidadDerechoPublico;
	}

	/**
	 * Guarda el valor del par�metro indicadorEntidadDerechoPublico.
	 * 
	 * @param indicadorEntidadDerechoPublico
	 *            valor del campo a guardar.
	 */
	public void setIndicadorEntidadDerechoPublico(
			String indicadorEntidadDerechoPublico) {
		this.indicadorEntidadDerechoPublico = indicadorEntidadDerechoPublico;
	}

	/**
	 * Obtiene el valor del par�metro idExternoFuente.
	 * 
	 * @return idExternoFuente valor del campo a obtener.
	 *
	 */
	public String getIdExternoFuente() {
		return idExternoFuente;
	}

	/**
	 * Guarda el valor del par�metro idExternoFuente.
	 * 
	 * @param idExternoFuente
	 *            valor del campo a guardar.
	 */
	public void setIdExternoFuente(String idExternoFuente) {
		this.idExternoFuente = idExternoFuente;
	}

	/**
	 * Obtiene el valor del par�metro idUnidadOrganicaSuperior.
	 * 
	 * @return idUnidadOrganicaSuperior valor del campo a obtener.
	 *
	 */
	public String getIdUnidadOrganicaSuperior() {
		return idUnidadOrganicaSuperior;
	}

	/**
	 * Guarda el valor del par�metro idUnidadOrganicaSuperior.
	 * 
	 * @param idUnidadOrganicaSuperior
	 *            valor del campo a guardar.
	 */
	public void setIdUnidadOrganicaSuperior(String idUnidadOrganicaSuperior) {
		this.idUnidadOrganicaSuperior = idUnidadOrganicaSuperior;
	}

	/**
	 * Obtiene el valor del par�metro nombreUnidadOrganicaSuperior.
	 * 
	 * @return nombreUnidadOrganicaSuperior valor del campo a obtener.
	 *
	 */
	public String getNombreUnidadOrganicaSuperior() {
		return nombreUnidadOrganicaSuperior;
	}

	/**
	 * Guarda el valor del par�metro nombreUnidadOrganicaSuperior.
	 * 
	 * @param nombreUnidadOrganicaSuperior
	 *            valor del campo a guardar.
	 */
	public void
			setNombreUnidadOrganicaSuperior(String nombreUnidadOrganicaSuperior) {
		this.nombreUnidadOrganicaSuperior = nombreUnidadOrganicaSuperior;
	}

	/**
	 * Obtiene el valor del par�metro idUnidadOrganicaPrincipal.
	 * 
	 * @return idUnidadOrganicaPrincipal valor del campo a obtener.
	 *
	 */
	public String getIdUnidadOrganicaPrincipal() {
		return idUnidadOrganicaPrincipal;
	}

	/**
	 * Guarda el valor del par�metro idUnidadOrganicaPrincipal.
	 * 
	 * @param idUnidadOrganicaPrincipal
	 *            valor del campo a guardar.
	 */
	public void setIdUnidadOrganicaPrincipal(String idUnidadOrganicaPrincipal) {
		this.idUnidadOrganicaPrincipal = idUnidadOrganicaPrincipal;
	}

	/**
	 * Obtiene el valor del par�metro nombreUnidadOrganicaPrincipal.
	 * 
	 * @return nombreUnidadOrganicaPrincipal valor del campo a obtener.
	 *
	 */
	public String getNombreUnidadOrganicaPrincipal() {
		return nombreUnidadOrganicaPrincipal;
	}

	/**
	 * Guarda el valor del par�metro nombreUnidadOrganicaPrincipal.
	 * 
	 * @param nombreUnidadOrganicaPrincipal
	 *            valor del campo a guardar.
	 */
	public void setNombreUnidadOrganicaPrincipal(
			String nombreUnidadOrganicaPrincipal) {
		this.nombreUnidadOrganicaPrincipal = nombreUnidadOrganicaPrincipal;
	}

	/**
	 * Obtiene el valor del par�metro idUnidadOrganicaEntidadDerechoPublico.
	 * 
	 * @return idUnidadOrganicaEntidadDerechoPublico valor del campo a obtener.
	 *
	 */
	public String getIdUnidadOrganicaEntidadDerechoPublico() {
		return idUnidadOrganicaEntidadDerechoPublico;
	}

	/**
	 * Guarda el valor del par�metro idUnidadOrganicaEntidadDerechoPublico.
	 * 
	 * @param idUnidadOrganicaEntidadDerechoPublico
	 *            valor del campo a guardar.
	 */
	public void setIdUnidadOrganicaEntidadDerechoPublico(
			String idUnidadOrganicaEntidadDerechoPublico) {
		this.idUnidadOrganicaEntidadDerechoPublico =
				idUnidadOrganicaEntidadDerechoPublico;
	}

	/**
	 * Obtiene el valor del par�metro nombreUnidadOrganicaEntidadDerechoPublico.
	 * 
	 * @return nombreUnidadOrganicaEntidadDerechoPublico valor del campo a obtener.
	 *
	 */
	public String getNombreUnidadOrganicaEntidadDerechoPublico() {
		return nombreUnidadOrganicaEntidadDerechoPublico;
	}

	/**
	 * Guarda el valor del par�metro nombreUnidadOrganicaEntidadDerechoPublico.
	 * 
	 * @param nombreUnidadOrganicaEntidadDerechoPublico
	 *            valor del campo a guardar.
	 */
	public void setNombreUnidadOrganicaEntidadDerechoPublico(
			String nombreUnidadOrganicaEntidadDerechoPublico) {
		this.nombreUnidadOrganicaEntidadDerechoPublico =
				nombreUnidadOrganicaEntidadDerechoPublico;
	}

	/**
	 * Obtiene el valor del par�metro nivelJerarquico.
	 * 
	 * @return nivelJerarquico valor del campo a obtener.
	 *
	 */
	public Integer getNivelJerarquico() {
		return nivelJerarquico;
	}

	/**
	 * Guarda el valor del par�metro nivelJerarquico.
	 * 
	 * @param nivelJerarquico
	 *            valor del campo a guardar.
	 */
	public void setNivelJerarquico(Integer nivelJerarquico) {
		this.nivelJerarquico = nivelJerarquico;
	}

	/**
	 * Obtiene el valor del par�metro estado.
	 * 
	 * @return estado valor del campo a obtener.
	 *
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Guarda el valor del par�metro estado.
	 * 
	 * @param estado
	 *            valor del campo a guardar.
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * Obtiene el valor del par�metro descripcionEstado.
	 * 
	 * @return descripcionEstado valor del campo a obtener.
	 *
	 */
	public String getDescripcionEstado() {
		return descripcionEstado;
	}

	/**
	 * Guarda el valor del par�metro descripcionEstado.
	 * 
	 * @param descripcionEstado
	 *            valor del campo a guardar.
	 */
	public void setDescripcionEstado(String descripcionEstado) {
		this.descripcionEstado = descripcionEstado;
	}

	/**
	 * Obtiene el valor del par�metro fechaAltaOficial.
	 * 
	 * @return fechaAltaOficial valor del campo a obtener.
	 *
	 */
	public Date getFechaAltaOficial() {
		return fechaAltaOficial;
	}

	/**
	 * Guarda el valor del par�metro fechaAltaOficial.
	 * 
	 * @param fechaAltaOficial
	 *            valor del campo a guardar.
	 */
	public void setFechaAltaOficial(Date fechaAltaOficial) {
		this.fechaAltaOficial = fechaAltaOficial;
	}

	/**
	 * Obtiene el valor del par�metro fechaBajaOficial.
	 * 
	 * @return fechaBajaOficial valor del campo a obtener.
	 *
	 */
	public Date getFechaBajaOficial() {
		return fechaBajaOficial;
	}

	/**
	 * Guarda el valor del par�metro fechaBajaOficial.
	 * 
	 * @param fechaBajaOficial
	 *            valor del campo a guardar.
	 */
	public void setFechaBajaOficial(Date fechaBajaOficial) {
		this.fechaBajaOficial = fechaBajaOficial;
	}

	/**
	 * Obtiene el valor del par�metro fechaExtincion.
	 * 
	 * @return fechaExtincion valor del campo a obtener.
	 *
	 */
	public Date getFechaExtincion() {
		return fechaExtincion;
	}

	/**
	 * Guarda el valor del par�metro fechaExtincion.
	 * 
	 * @param fechaExtincion
	 *            valor del campo a guardar.
	 */
	public void setFechaExtincion(Date fechaExtincion) {
		this.fechaExtincion = fechaExtincion;
	}

	/**
	 * Obtiene el valor del par�metro fechaAnulacion.
	 * 
	 * @return fechaAnulacion valor del campo a obtener.
	 *
	 */
	public Date getFechaAnulacion() {
		return fechaAnulacion;
	}

	/**
	 * Guarda el valor del par�metro fechaAnulacion.
	 * 
	 * @param fechaAnulacion
	 *            valor del campo a guardar.
	 */
	public void setFechaAnulacion(Date fechaAnulacion) {
		this.fechaAnulacion = fechaAnulacion;
	}
}
