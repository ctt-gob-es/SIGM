package es.ieci.tecdoc.fwktd.dir3.api.vo;

import java.util.Date;

import es.ieci.tecdoc.fwktd.core.model.Entity;

/**
 * Datos b�sicos de una oficina.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public class DatosBasicosOficinaVO extends Entity {

	private static final long serialVersionUID = -8448407266332605669L;


	/*
	 * =======================================================================
	 * Datos identificativos
	 *
	 * El campo "id" heredado de la clase Entity es el c�digo �nico.
	 * =======================================================================
	 */

	/**
	 * Denominaci�n de la oficina.
	 */
	private String nombre;

	/**
	 * C�digo externo utilizado por la entidad p�blica que aporta los datos para
	 * el alta de la oficina en el Directorio Com�n.
	 */
	private String idExternoFuente;


	/*
	 * =======================================================================
	 * Datos de dependencia jer�rquica.
	 * =======================================================================
	 */

	/**
	 * Unidad responsable (de la que depende la oficina).
	 */
	private String idUnidadResponsable;

	/**
	 * Denominaci�n de la unidad responsable (de la que depende la oficina).
	 */
	private String nombreUnidadResponsable;

	/**
	 * C�digo del nivel de administraci�n (Estatal, Auton�mica o Local)
	 */
	private String nivelAdministracion;

	/**
	 * Descripci�n del nivel de administraci�n.
	 */
	private String descripcionNivelAdministracion;


	/*
	 * =======================================================================
	 * Datos de operativos.
	 * =======================================================================
	 */

	/**
	 * Designa si una oficina se encuentra adherida a la plataforma de
	 * intercambio registral del SIR.
	 */
	private String indicadorAdhesionSIR;

	/**
	 * Designa si la oficina tiene competencias de REGISTRO.
	 */
	private String indicadorOficinaRegistro;

	/**
	 * Designa si la oficina tiene competencias de informaci�n.
	 */
	private String indicadorOficinaInformacion;

	/**
	 * Designa si la oficina tiene competencias de tramitaci�n.
	 */
	private String indicadorOficinaTramitacion;

	/**
	 * Designa si se trata de una oficina de registro que realiza el servicio
	 * v�a medios electr�nicos (Registro Electr�nico).
	 */
	private String indicadorRegistroElectronico;

	/**
	 * Designa si una oficina puede registrar documentos destinados a Unidades
	 * de cualquier �mbito de la Administraci�n p�blica.
	 */
	private String indicadorIntercambioSinRestriccion;

	/**
	 * Designa si una oficina de �mbito local puede registrar documentos destinados a Unidades de la AGE.
	 */
	private String indicadorIntercambioLocalEstatal;

	/**
	 * Designa si una oficina de �mbito local puede registrar documentos
	 * destinados a Unidades de su Administraci�n Auton�mica, es decir de la
	 * Comunidad Aut�noma donde opera la oficina.
	 */
	private String indicadorIntercambioLocalAutonomicoRestringido;

	/**
	 * Designa si una oficina de �mbito local puede registrar documentos
	 * destinados a Unidades de cualquier Administraci�n Auton�mica.
	 */
	private String indicadorIntercambioLocalAutonomicoGeneral;

	/**
	 * Designa si una oficina de �mbito local puede registrar documentos
	 * destinados a otras entidades locales de la Comunidad Aut�noma donde opera
	 * la oficina.
	 */
	private String indicadorIntercambioLocalLocalRestringido;

	/**
	 * Designa si una oficina de �mbito local puede registrar documentos
	 * destinados a cualquier otra entidad local.
	 */
	private String indicadorIntercambioLocalLocalGeneral;

	/**
	 * Designa si una oficina de un ayuntamiento puede registrar documentos
	 * destinados a otros ayuntamientos de su misma Comunidad Aut�noma.
	 */
	private String indicadorIntercambioAytoAytoRestringido;


	/*
	 * =======================================================================
	 * Datos de vigencia.
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
	private Date fechaCreacion;

	/**
	 * Fecha de extinci�n final.
	 */
	private Date fechaExtincion;

	/**
	 * Fecha de anulaci�n.
	 */
	private Date fechaAnulacion;

	/**
	 * Provincia
	 */
	private String provincia;
	
	/**
	 * Localidad
	 */
	private String localidad;
	/**
	 * Direcci�n
	 */
	private String direccion;

	/**
	 * Constructor.
	 */
	public DatosBasicosOficinaVO() {
		super();
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getIdExternoFuente() {
		return idExternoFuente;
	}


	public void setIdExternoFuente(String idExternoFuente) {
		this.idExternoFuente = idExternoFuente;
	}


	public String getIdUnidadResponsable() {
		return idUnidadResponsable;
	}


	public void setIdUnidadResponsable(String idUnidadResponsable) {
		this.idUnidadResponsable = idUnidadResponsable;
	}


	public String getNombreUnidadResponsable() {
		return nombreUnidadResponsable;
	}


	public void setNombreUnidadResponsable(String nombreUnidadResponsable) {
		this.nombreUnidadResponsable = nombreUnidadResponsable;
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


	public String getIndicadorAdhesionSIR() {
		return indicadorAdhesionSIR;
	}


	public void setIndicadorAdhesionSIR(String indicadorAdhesionSIR) {
		this.indicadorAdhesionSIR = indicadorAdhesionSIR;
	}


	public String getIndicadorOficinaRegistro() {
		return indicadorOficinaRegistro;
	}


	public void setIndicadorOficinaRegistro(String indicadorOficinaRegistro) {
		this.indicadorOficinaRegistro = indicadorOficinaRegistro;
	}


	public String getIndicadorOficinaInformacion() {
		return indicadorOficinaInformacion;
	}


	public void setIndicadorOficinaInformacion(String indicadorOficinaInformacion) {
		this.indicadorOficinaInformacion = indicadorOficinaInformacion;
	}


	public String getIndicadorOficinaTramitacion() {
		return indicadorOficinaTramitacion;
	}


	public void setIndicadorOficinaTramitacion(String indicadorOficinaTramitacion) {
		this.indicadorOficinaTramitacion = indicadorOficinaTramitacion;
	}


	public String getIndicadorRegistroElectronico() {
		return indicadorRegistroElectronico;
	}


	public void setIndicadorRegistroElectronico(String indicadorRegistroElectronico) {
		this.indicadorRegistroElectronico = indicadorRegistroElectronico;
	}


	public String getIndicadorIntercambioSinRestriccion() {
		return indicadorIntercambioSinRestriccion;
	}


	public void setIndicadorIntercambioSinRestriccion(
			String indicadorIntercambioSinRestriccion) {
		this.indicadorIntercambioSinRestriccion = indicadorIntercambioSinRestriccion;
	}


	public String getIndicadorIntercambioLocalEstatal() {
		return indicadorIntercambioLocalEstatal;
	}


	public void setIndicadorIntercambioLocalEstatal(
			String indicadorIntercambioLocalEstatal) {
		this.indicadorIntercambioLocalEstatal = indicadorIntercambioLocalEstatal;
	}


	public String getIndicadorIntercambioLocalAutonomicoRestringido() {
		return indicadorIntercambioLocalAutonomicoRestringido;
	}


	public void setIndicadorIntercambioLocalAutonomicoRestringido(
			String indicadorIntercambioLocalAutonomicoRestringido) {
		this.indicadorIntercambioLocalAutonomicoRestringido = indicadorIntercambioLocalAutonomicoRestringido;
	}


	public String getIndicadorIntercambioLocalAutonomicoGeneral() {
		return indicadorIntercambioLocalAutonomicoGeneral;
	}


	public void setIndicadorIntercambioLocalAutonomicoGeneral(
			String indicadorIntercambioLocalAutonomicoGeneral) {
		this.indicadorIntercambioLocalAutonomicoGeneral = indicadorIntercambioLocalAutonomicoGeneral;
	}


	public String getIndicadorIntercambioLocalLocalRestringido() {
		return indicadorIntercambioLocalLocalRestringido;
	}


	public void setIndicadorIntercambioLocalLocalRestringido(
			String indicadorIntercambioLocalLocalRestringido) {
		this.indicadorIntercambioLocalLocalRestringido = indicadorIntercambioLocalLocalRestringido;
	}


	public String getIndicadorIntercambioLocalLocalGeneral() {
		return indicadorIntercambioLocalLocalGeneral;
	}


	public void setIndicadorIntercambioLocalLocalGeneral(
			String indicadorIntercambioLocalLocalGeneral) {
		this.indicadorIntercambioLocalLocalGeneral = indicadorIntercambioLocalLocalGeneral;
	}


	public String getIndicadorIntercambioAytoAytoRestringido() {
		return indicadorIntercambioAytoAytoRestringido;
	}


	public void setIndicadorIntercambioAytoAytoRestringido(
			String indicadorIntercambioAytoAytoRestringido) {
		this.indicadorIntercambioAytoAytoRestringido = indicadorIntercambioAytoAytoRestringido;
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


	public Date getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
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


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	public String getLocalidad() {
		return localidad;
	}


	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
