package ieci.tecdoc.sgm.core.services.tramitacion.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Informaci�n de un documento.
 */
public class Documento implements Serializable {

	/** GUID del documento. */
	protected String guid = null;

	/** Nombre del documento. */
	protected String nombre = null;

	/** Extensi�n del documento. */
	protected String extension = null;

	/** Fecha de alta del documento. */
	protected Date fechaAlta = null;

	/** Firmas digitales del documento. */
	protected String[] firmas = null;

	/**
	 * Constructor.
	 */
	public Documento() {
		super();
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String ext) {
		this.extension = ext;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String name) {
		this.nombre = name;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String[] getFirmas() {
		return firmas;
	}

	public void setFirmas(String[] firmas) {
		this.firmas = firmas;
	}

}
