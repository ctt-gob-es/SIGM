package es.ieci.tecdoc.fwktd.sir.core.vo;

import es.ieci.tecdoc.fwktd.core.model.Entity;
import es.ieci.tecdoc.fwktd.sir.core.types.CanalNotificacionEnum;
import es.ieci.tecdoc.fwktd.sir.core.types.TipoDocumentoIdentificacionEnum;

/**
 * Informaci�n de un interesado de un asiento registral.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public class InteresadoVO extends Entity {

	private static final long serialVersionUID = 3150773828183428655L;

	/**
	 * Identificador del asiento registral.
	 */
	private String idAsientoRegistral = null;

	/**
	 * Tipo de documento de identificacion del interesado.
	 */
	private TipoDocumentoIdentificacionEnum tipoDocumentoIdentificacionInteresado;

	/**
	 * Documento de identificaci�n del interesado.
	 */
	private String documentoIdentificacionInteresado;

	/**
	 * Raz�n social del interesado (si es persona jur�dica).
	 */
	private String razonSocialInteresado;

	/**
	 * Nombre del interesado.
	 */
	private String nombreInteresado;

	/**
	 * Primer apellido del interesado.
	 */
	private String primerApellidoInteresado;

	/**
	 * Segundo apellido del interesado.
	 */
	private String segundoApellidoInteresado;

	/**
	 * C�digo del pa�s del interesado. Codificado seg�n el directorio com�n.
	 */
	private String codigoPaisInteresado;

	/**
	 * C�digo de la provincia del interesado. Codificado seg�n el directorio
	 * com�n.
	 */
	private String codigoProvinciaInteresado;

	/**
	 * C�digo del municipio del interesado. Codificado seg�n el directorio
	 * com�n.
	 */
	private String codigoMunicipioInteresado;

	/**
	 * Direccion postal del interesado.
	 */
	private String direccionInteresado;

	/**
	 * Codigo postal del interesado.
	 */
	private String codigoPostalInteresado;

	/**
	 * Correo electr�nico del interesado.
	 */
	private String correoElectronicoInteresado;

	/**
	 * Tel�fono de contacto del interesado.
	 */
	private String telefonoInteresado;

	/**
	 * Direccion electr�nica habilitada del interesado.
	 */
	private String direccionElectronicaHabilitadaInteresado;

	/**
	 * Canal preferente de notificaci�n del interesado.
	 */
	private CanalNotificacionEnum canalPreferenteComunicacionInteresado;

	/**
	 * Tipo de documento de identificacion del representante.
	 */
	private TipoDocumentoIdentificacionEnum tipoDocumentoIdentificacionRepresentante;

	/**
	 * Documento de identificaci�n del representante.
	 */
	private String documentoIdentificacionRepresentante;

	/**
	 * Raz�n social del representante (si es persona jur�dica).
	 */
	private String razonSocialRepresentante;

	/**
	 * Nombre del representante.
	 */
	private String nombreRepresentante;

	/**
	 * Primer apellido del representante.
	 */
	private String primerApellidoRepresentante;

	/**
	 * Segundo apellido del representante.
	 */
	private String segundoApellidoRepresentante;

	/**
	 * C�digo del pa�s del representante. Codificado seg�n el directorio com�n.
	 */
	private String codigoPaisRepresentante;

	/**
	 * C�digo de la provincia del representante. Codificado seg�n el directorio
	 * com�n.
	 */
	private String codigoProvinciaRepresentante;

	/**
	 * C�digo del municipio del representante. Codificado seg�n el directorio
	 * com�n.
	 */
	private String codigoMunicipioRepresentante;

	/**
	 * Direccion postal del representante.
	 */
	private String direccionRepresentante;

	/**
	 * Codigo postal del representante.
	 */
	private String codigoPostalRepresentante;

	/**
	 * Correo electr�nico del representante.
	 */
	private String correoElectronicoRepresentante;

	/**
	 * Tel�fono de contacto del representante.
	 */
	private String telefonoRepresentante;

	/**
	 * Direccion electr�nica habilitada del representante.
	 */
	private String direccionElectronicaHabilitadaRepresentante;

	/**
	 * Canal preferente de notificaci�n del representante.
	 */
	private CanalNotificacionEnum canalPreferenteComunicacionRepresentante;

	/**
	 * Observaciones del interesado y/o del representante.
	 */
	private String observaciones;

	/**
	 * Constructor.
	 */
	public InteresadoVO() {
		super();
	}

	public String getIdAsientoRegistral() {
		return idAsientoRegistral;
	}

	public void setIdAsientoRegistral(String idAsientoRegistral) {
		this.idAsientoRegistral = idAsientoRegistral;
	}

	public TipoDocumentoIdentificacionEnum getTipoDocumentoIdentificacionInteresado() {
		return tipoDocumentoIdentificacionInteresado;
	}

	public void setTipoDocumentoIdentificacionInteresado(
			TipoDocumentoIdentificacionEnum tipoDocumentoIdentificacionInteresado) {
		this.tipoDocumentoIdentificacionInteresado = tipoDocumentoIdentificacionInteresado;
	}

	public String getDocumentoIdentificacionInteresado() {
		return documentoIdentificacionInteresado;
	}

	public void setDocumentoIdentificacionInteresado(
			String documentoIdentificacionInteresado) {
		this.documentoIdentificacionInteresado = documentoIdentificacionInteresado;
	}

	public String getRazonSocialInteresado() {
		return razonSocialInteresado;
	}

	public void setRazonSocialInteresado(String razonSocialInteresado) {
		this.razonSocialInteresado = razonSocialInteresado;
	}

	public String getNombreInteresado() {
		return nombreInteresado;
	}

	public void setNombreInteresado(String nombreInteresado) {
		this.nombreInteresado = nombreInteresado;
	}

	public String getPrimerApellidoInteresado() {
		return primerApellidoInteresado;
	}

	public void setPrimerApellidoInteresado(String primerApellidoInteresado) {
		this.primerApellidoInteresado = primerApellidoInteresado;
	}

	public String getSegundoApellidoInteresado() {
		return segundoApellidoInteresado;
	}

	public void setSegundoApellidoInteresado(String segundoApellidoInteresado) {
		this.segundoApellidoInteresado = segundoApellidoInteresado;
	}

	public String getCodigoPaisInteresado() {
		return codigoPaisInteresado;
	}

	public void setCodigoPaisInteresado(String codigoPaisInteresado) {
		this.codigoPaisInteresado = codigoPaisInteresado;
	}

	public String getCodigoProvinciaInteresado() {
		return codigoProvinciaInteresado;
	}

	public void setCodigoProvinciaInteresado(String codigoProvinciaInteresado) {
		this.codigoProvinciaInteresado = codigoProvinciaInteresado;
	}

	public String getCodigoMunicipioInteresado() {
		return codigoMunicipioInteresado;
	}

	public void setCodigoMunicipioInteresado(String codigoMunicipioInteresado) {
		this.codigoMunicipioInteresado = codigoMunicipioInteresado;
	}

	public String getDireccionInteresado() {
		return direccionInteresado;
	}

	public void setDireccionInteresado(String direccionInteresado) {
		this.direccionInteresado = direccionInteresado;
	}

	public String getCodigoPostalInteresado() {
		return codigoPostalInteresado;
	}

	public void setCodigoPostalInteresado(String codigoPostalInteresado) {
		this.codigoPostalInteresado = codigoPostalInteresado;
	}

	public String getCorreoElectronicoInteresado() {
		return correoElectronicoInteresado;
	}

	public void setCorreoElectronicoInteresado(
			String correoElectronicoInteresado) {
		this.correoElectronicoInteresado = correoElectronicoInteresado;
	}

	public String getTelefonoInteresado() {
		return telefonoInteresado;
	}

	public void setTelefonoInteresado(String telefonoInteresado) {
		this.telefonoInteresado = telefonoInteresado;
	}

	public String getDireccionElectronicaHabilitadaInteresado() {
		return direccionElectronicaHabilitadaInteresado;
	}

	public void setDireccionElectronicaHabilitadaInteresado(
			String direccionElectronicaHabilitadaInteresado) {
		this.direccionElectronicaHabilitadaInteresado = direccionElectronicaHabilitadaInteresado;
	}

	public CanalNotificacionEnum getCanalPreferenteComunicacionInteresado() {
		return canalPreferenteComunicacionInteresado;
	}

	public void setCanalPreferenteComunicacionInteresado(
			CanalNotificacionEnum canalPreferenteComunicacionInteresado) {
		this.canalPreferenteComunicacionInteresado = canalPreferenteComunicacionInteresado;
	}

	public TipoDocumentoIdentificacionEnum getTipoDocumentoIdentificacionRepresentante() {
		return tipoDocumentoIdentificacionRepresentante;
	}

	public void setTipoDocumentoIdentificacionRepresentante(
			TipoDocumentoIdentificacionEnum tipoDocumentoIdentificacionRepresentante) {
		this.tipoDocumentoIdentificacionRepresentante = tipoDocumentoIdentificacionRepresentante;
	}

	public String getDocumentoIdentificacionRepresentante() {
		return documentoIdentificacionRepresentante;
	}

	public void setDocumentoIdentificacionRepresentante(
			String documentoIdentificacionRepresentante) {
		this.documentoIdentificacionRepresentante = documentoIdentificacionRepresentante;
	}

	public String getRazonSocialRepresentante() {
		return razonSocialRepresentante;
	}

	public void setRazonSocialRepresentante(String razonSocialRepresentante) {
		this.razonSocialRepresentante = razonSocialRepresentante;
	}

	public String getNombreRepresentante() {
		return nombreRepresentante;
	}

	public void setNombreRepresentante(String nombreRepresentante) {
		this.nombreRepresentante = nombreRepresentante;
	}

	public String getPrimerApellidoRepresentante() {
		return primerApellidoRepresentante;
	}

	public void setPrimerApellidoRepresentante(
			String primerApellidoRepresentante) {
		this.primerApellidoRepresentante = primerApellidoRepresentante;
	}

	public String getSegundoApellidoRepresentante() {
		return segundoApellidoRepresentante;
	}

	public void setSegundoApellidoRepresentante(
			String segundoApellidoRepresentante) {
		this.segundoApellidoRepresentante = segundoApellidoRepresentante;
	}

	public String getCodigoPaisRepresentante() {
		return codigoPaisRepresentante;
	}

	public void setCodigoPaisRepresentante(String codigoPaisRepresentante) {
		this.codigoPaisRepresentante = codigoPaisRepresentante;
	}

	public String getCodigoProvinciaRepresentante() {
		return codigoProvinciaRepresentante;
	}

	public void setCodigoProvinciaRepresentante(
			String codigoProvinciaRepresentante) {
		this.codigoProvinciaRepresentante = codigoProvinciaRepresentante;
	}

	public String getCodigoMunicipioRepresentante() {
		return codigoMunicipioRepresentante;
	}

	public void setCodigoMunicipioRepresentante(
			String codigoMunicipioRepresentante) {
		this.codigoMunicipioRepresentante = codigoMunicipioRepresentante;
	}

	public String getDireccionRepresentante() {
		return direccionRepresentante;
	}

	public void setDireccionRepresentante(String direccionRepresentante) {
		this.direccionRepresentante = direccionRepresentante;
	}

	public String getCodigoPostalRepresentante() {
		return codigoPostalRepresentante;
	}

	public void setCodigoPostalRepresentante(String codigoPostalRepresentante) {
		this.codigoPostalRepresentante = codigoPostalRepresentante;
	}

	public String getCorreoElectronicoRepresentante() {
		return correoElectronicoRepresentante;
	}

	public void setCorreoElectronicoRepresentante(
			String correoElectronicoRepresentante) {
		this.correoElectronicoRepresentante = correoElectronicoRepresentante;
	}

	public String getTelefonoRepresentante() {
		return telefonoRepresentante;
	}

	public void setTelefonoRepresentante(String telefonoRepresentante) {
		this.telefonoRepresentante = telefonoRepresentante;
	}

	public String getDireccionElectronicaHabilitadaRepresentante() {
		return direccionElectronicaHabilitadaRepresentante;
	}

	public void setDireccionElectronicaHabilitadaRepresentante(
			String direccionElectronicaHabilitadaRepresentante) {
		this.direccionElectronicaHabilitadaRepresentante = direccionElectronicaHabilitadaRepresentante;
	}

	public CanalNotificacionEnum getCanalPreferenteComunicacionRepresentante() {
		return canalPreferenteComunicacionRepresentante;
	}

	public void setCanalPreferenteComunicacionRepresentante(
			CanalNotificacionEnum canalPreferenteComunicacionRepresentante) {
		this.canalPreferenteComunicacionRepresentante = canalPreferenteComunicacionRepresentante;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
}
