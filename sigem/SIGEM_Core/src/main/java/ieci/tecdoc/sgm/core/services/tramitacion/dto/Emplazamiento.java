package ieci.tecdoc.sgm.core.services.tramitacion.dto;

import java.io.Serializable;

/**
 * Informaci�n de un emplazamiento.
 */
public class Emplazamiento implements Serializable {

	/** Pa�s. */
	private String pais = null;
	
	/** Comunidad. */
	private String comunidad = null;

	/** Concejo. */
	private String concejo = null;

	/** Poblaci�n. */
	private String poblacion = null;

	/** Localizaci�n. */
	private String localizacion = null;



	/**
	 * Constructor.
	 */
	public Emplazamiento() {
		super();
	}

	/**
	 * Obtiene el concejo
	 * @return Concejo.
	 */
	public String getConcejo() {
		return concejo;
	}

	/**
	 * Establece el concejo.
	 * @param concejo Concejo.
	 */
	public void setConcejo(String concejo) {
		this.concejo = concejo;
	}

	/**
	 * Obtiene la Localizaci�n.
	 * @return Localizaci�n.
	 */
	public String getLocalizacion() {
		return localizacion;
	}

	/**
	 * Establece la localizaci�n.
	 * @param localizacion Localizaci�n.
	 */
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	/**
	 * Obtiene la poblaci�n.
	 * @return Poblaci�n.
	 */
	public String getPoblacion() {
		return poblacion;
	}

	/**
	 * Establece la poblaci�n.
	 * @param poblacion Poblaci�n.
	 */
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	/**
	 * Obtiene la comunidad.
	 * @return Comunidad.
	 */
	public String getComunidad() {
		return comunidad;
	}

	/**
	 * Establece la comunidad.
	 * @param comunidad Comunidad.
	 */
	public void setComunidad(String comunidad) {
		this.comunidad = comunidad;
	}

	/**
	 * Obtiene el pa�s.
	 * @return Pa�s.
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * Establece el pa�s.
	 * @param pais Pa�s.
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

}
