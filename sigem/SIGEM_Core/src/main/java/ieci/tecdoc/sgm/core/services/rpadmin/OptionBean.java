package ieci.tecdoc.sgm.core.services.rpadmin;

/**
 * Operador sobre un campo de registro
 * 
 * Se utiliza principalmente para la gesti�n de filtros
 * 
 */
public class OptionBean {

	private String codigo;
	private String descripcion;

	/**
	 * @return
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
