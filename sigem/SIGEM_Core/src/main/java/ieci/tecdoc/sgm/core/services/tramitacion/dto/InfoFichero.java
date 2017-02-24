package ieci.tecdoc.sgm.core.services.tramitacion.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Informaci�n de un procedimiento.
 */
public class InfoFichero implements Serializable {

	/** Nombre del fichero. */
	protected String nombre = null;

	/** Fecha de alta en el repositorio. */
	protected Date fechaAlta = null;

	/** Lista de firmas digitales del fichero. */
	protected Firma[] firmas = null;

	/**
	 * Constructor.
	 */
	public InfoFichero() {
		super();
	}

	/**
	 * Obtiene la fecha de alta en el repositorio.
	 * @return Fecha de alta en el repositorio.
	 */
	public Date getFechaAlta() {
		return fechaAlta;
	}

	/**
	 * Establece la fecha de alta en el repositorio.
	 * @param fechaAlta Fecha de alta en el repositorio.
	 */
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	/**
	 * Obtiene el nombre del fichero.
	 * @return Nombre del fichero.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del fichero.
	 * @param nombre Nombre del fichero.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la lista de firmas digitales del fichero.
	 * @return Lista de firmas digitales del fichero.
	 */
	public Firma[] getFirmas() {
		return firmas;
	}

	/**
	 * Establece la Lista de firmas digitales del fichero.
	 * @param firmas Lista de firmas digitales del fichero.
	 */
	public void setFirmas(Firma[] firmas) {
		this.firmas = firmas;
	}

}