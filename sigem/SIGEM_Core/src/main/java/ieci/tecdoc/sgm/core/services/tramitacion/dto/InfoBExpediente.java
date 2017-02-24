package ieci.tecdoc.sgm.core.services.tramitacion.dto;

import java.io.Serializable;

/**
 * Informaci�n b�sica de un expediente.
 */
public class InfoBExpediente implements Serializable {

	/** Identificador del expediente. */
	private String id = null;

	/** N�mero de expediente. */
	private String numExp = null;

	/** Datos que identifican al expediente. */
	private String datosIdentificativos = null;

	/**
	 * Constructor.
	 */
	public InfoBExpediente() {
		super();
	}

	/**
	 * Obtiene los datos que identifican al expediente.
	 * @return Datos que identifican al expediente.
	 */
	public String getDatosIdentificativos() {
		return datosIdentificativos;
	}

	/**
	 * Establece los datos que identifican al expediente.
	 * @param datosIdentificativos Datos que identifican al expediente.
	 */
	public void setDatosIdentificativos(String datosIdentificativos) {
		this.datosIdentificativos = datosIdentificativos;
	}

	/**
	 * Obtiene el identificador del expediente.
	 * @return Identificador del expediente.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Establece el identificador del expediente.
	 * @param id Identificador del expediente.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Obtiene el n�mero de expediente.
	 * @return N�mero de expediente.
	 */
	public String getNumExp() {
		return numExp;
	}

	/**
	 * Establece el n�mero de expediente.
	 * @param numExp N�mero de expediente.
	 */
	public void setNumExp(String numExp) {
		this.numExp = numExp;
	}

}
