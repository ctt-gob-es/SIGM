package ieci.tecdoc.sgm.core.services.tramitacion.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Informaci�n de un �rgano productor.
 */
public class OrganoProductor implements Serializable {

	/** Identificador del �rgano productor. */
	private String id = null;

	/** Fecha desde la que el �rgano es productor. */
	private Date inicioProduccion = null;

	/**
	 * Constructor.
	 */
	public OrganoProductor() {
		super();
	}

	/**
	 * Constructor.
	 * @param id Identificador del �rgano.
	 * @param inicioProduccion Fecha desde la que el �rgano es productor.
	 */
	public OrganoProductor(String id, Date inicioProduccion) {
		this();
		setId(id);
		setInicioProduccion(inicioProduccion);
	}

	/**
	 * Obtiene el identificador del �rgano. 
	 * @return Identificador del �rgano.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Establece el identificador del �rgano.
	 * @param id Identificador del �rgano.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Obtiene la fecha desde la que el �rgano es productor.
	 * @return Fecha desde la que el �rgano es productor.
	 */
	public Date getInicioProduccion() {
		return inicioProduccion;
	}

	/**
	 * Establece la fecha desde la que el �rgano es productor.
	 * @param inicioProduccion Fecha desde la que el �rgano es productor.
	 */
	public void setInicioProduccion(Date inicioProduccion) {
		this.inicioProduccion = inicioProduccion;
	}
}
