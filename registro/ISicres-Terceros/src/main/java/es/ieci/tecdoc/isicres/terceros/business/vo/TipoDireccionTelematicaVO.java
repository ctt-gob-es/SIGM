package es.ieci.tecdoc.isicres.terceros.business.vo;

import es.ieci.tecdoc.fwktd.core.model.Entity;

/**
 * Clase que modela el tipo de una direcci�n telem�tica de un tercero.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public class TipoDireccionTelematicaVO extends Entity {

	private static final long serialVersionUID = 4509749706560438652L;

	/**
	 * C�digo del tipo de direcci�n telem�tica.
	 */
	protected String codigo;

	/**
	 * Descripci�n textual larga del tipo de direcci�n telem�tica.
	 */
	protected String descripcion;

	/**
	 * Constructor por defecto.
	 */
	public TipoDireccionTelematicaVO() {
		// nothing to do
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
