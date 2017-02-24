package ieci.tecdoc.sgm.core.services.tramitacion.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Informaci�n de un expediente.
 */
public class Expediente implements Serializable {

	/** Informaci�n b�sica del expediente. */
	private InfoBExpediente informacionBasica = new InfoBExpediente();

	/** Fecha de inicio del expediente. */
	private Date fechaInicio = null;

	/** Fecha de finalizaci�n del expediente. */
	private Date fechaFinalizacion = null;

	/** Identificador del �rgano productor del expediente. */
	private String idOrgProductor = null;

	/** Nombre del �rgano productor del expediente. */
	private String nombreOrgProductor = null;

	/** Asunto del expediente. */
	private String asunto = null;

	/** Documentos f�sicos del expediente. */
	private DocFisico[] documentosFisicos = new DocFisico[0];

	/** Documentos electr�nicos del expediente. */
	private DocElectronico[] documentosElectronicos = new DocElectronico[0];

	/** Interesados del expediente. */
	private Interesado[] interesados = new Interesado[0];

	/** Emplazamientos del expediente. */
	private Emplazamiento[] emplazamientos = new Emplazamiento[0];

	/**
	 * Constructor.
	 */
	public Expediente() {
		super();
	}

	/**
	 * Obtiene el asunto del expediente.
	 * @return Asunto del expediente.
	 */
	public String getAsunto() {
		return asunto;
	}

	/**
	 * Establece el asunto del expediente.
	 * @param asunto Asunto del expediente.
	 */
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	/**
	 * Obtiene los documentos f�sicos del expediente.
	 * @return Documentos f�sicos del expediente.
	 */
	public DocFisico[] getDocumentosFisicos() {
		return documentosFisicos;
	}

	/**
	 * Establece los documentos f�sicos del expediente.
	 * @param documentosFisicos Documentos f�sicos del expediente.
	 */
	public void setDocumentosFisicos(DocFisico[] documentosFisicos) {
		this.documentosFisicos = documentosFisicos;
	}

	/**
	 * Obtiene los documentos electr�nicos del expediente.
	 * @return Documentos electr�nicos del expediente.
	 */
	public DocElectronico[] getDocumentosElectronicos() {
		return documentosElectronicos;
	}

	/**
	 * Establece los documentos electr�nicos del expediente.
	 * @param documentosElectronicos Documentos electr�nicos del expediente.
	 */
	public void setDocumentosElectronicos(
			DocElectronico[] documentosElectronicos) {
		this.documentosElectronicos = documentosElectronicos;
	}

	/**
	 * Obtiene los Emplazamientos del expediente.
	 * @return Emplazamientos del expediente.
	 */
	public Emplazamiento[] getEmplazamientos() {
		return emplazamientos;
	}

	/**
	 * Establece los emplazamientos del expediente.
	 * @param emplazamientos Emplazamientos del expediente.
	 */
	public void setEmplazamientos(Emplazamiento[] emplazamientos) {
		this.emplazamientos = emplazamientos;
	}

	/**
	 * Obtiene la fecha de finalizaci�n del expediente.
	 * @return Fecha de finalizaci�n del expediente.
	 */
	public Date getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	/**
	 * Establece la decha de finalizaci�n del expediente.
	 * @param fechaFinalizacion Fecha de finalizaci�n del expediente.
	 */
	public void setFechaFinalizacion(Date fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	/**
	 * Obtiene la fecha de inicio del expediente.
	 * @return Fecha de inicio del expediente.
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * Establece la fecha de inicio del expediente.
	 * @param fechaInicio Fecha de inicio del expediente.
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * Obtiene el identificador del �rgano productor.
	 * @return Identificador del �rgano productor.
	 */
	public String getIdOrgProductor() {
		return idOrgProductor;
	}

	/**
	 * Establece el identificador del �rgano productor.
	 * @param idOrgProductor Identificador del �rgano productor.
	 */
	public void setIdOrgProductor(String idOrgProductor) {
		this.idOrgProductor = idOrgProductor;
	}

	/**
	 * Obtiene la informaci�n b�sica del expediente.
	 * @return Informaci�n b�sica del expediente.
	 */
	public InfoBExpediente getInformacionBasica() {
		return informacionBasica;
	}

	/**
	 * Establece la informaci�n b�sica del expediente.
	 * @param informacionBasica Informaci�n b�sica del expediente.
	 */
	public void setInformacionBasica(InfoBExpediente informacionBasica) {
		this.informacionBasica = informacionBasica;
	}

	/**
	 * Obtiene los interesados del expediente.
	 * @return Interesados del expediente.
	 */
	public Interesado[] getInteresados() {
		return interesados;
	}

	/**
	 * Establece los interesados del expediente.
	 * @param interesados Interesados del expediente.
	 */
	public void setInteresados(Interesado[] interesados) {
		this.interesados = interesados;
	}

	/**
	 * Obtiene el nombre del �rgano productor.
	 * @return Nombre del �rgano productor.
	 */
	public String getNombreOrgProductor() {
		return nombreOrgProductor;
	}

	/**
	 * Establece el nombre del �rgano productor.
	 * @param nombreOrgProductor Nombre del �rgano productor.
	 */
	public void setNombreOrgProductor(String nombreOrgProductor) {
		this.nombreOrgProductor = nombreOrgProductor;
	}

}
