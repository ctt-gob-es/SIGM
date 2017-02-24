package ieci.tecdoc.sgm.core.services.tramitacion.dto;

import java.io.Serializable;

/**
 * Informaci�n de un �rgano.
 */
public class Organo implements Serializable {

	/** Identificador del �rgano. */
	public String id = null;

	/** Nombre del �rgano. */
	public String nombre = null;

	/** C�digo del �rgano. */
	public String codigo = null;

	/** Nivel jer�rquico al que pertenece el �rgano. */
	public int nivel = 0;

	/** Identificador del �rgano padre. */
	public String idPadre = null;

	/**
	 * Constructor.
	 */
	public Organo() {
		super();
	}

	/**
	 * Obtiene el identificador del �rgano. 
	 * @return Identificador del �rgano.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Obtiene el nombre del �rgano. 
	 * @return Nombre del �rgano.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Obtiene el c�digo del �rgano.
	 * @return C�digo del �rgano.
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Obtiene el nivel jer�rquico al que pertenece el �rgano. 
	 * @return Nivel jer�rquico.
	 */
	public int getNivel() {
		return nivel;
	}

	/**
	 * Obtiene el identificador del �rgano padre al que pertenece el �rgano. 
	 * @return Identificador del �rgano padre.
	 */
	public String getIdPadre() {
		return idPadre;
	}

	/**
	 * Establece el c�digo del �rgano.
	 * @param codigo C�digo del �rgano.
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Establece el identificador del �rgano.
	 * @param id Identificador del �rgano.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Establece el identificador del �rgano padre.
	 * @param idPadre Identificador del �rgano padre.
	 */
	public void setIdPadre(String idPadre) {
		this.idPadre = idPadre;
	}

	/**
	 * Establece el nivel jer�rquico al que pertenece el �rgano.
	 * @param nivel Nivel jer�rquico al que pertenece el �rgano.
	 */
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	/**
	 * Establece el nombre del �rgano.
	 * @param nombre Nombre del �rgano.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
