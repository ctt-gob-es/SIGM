package ieci.tecdoc.sgm.core.services.certificacion;

/**
 * Clase que almacena los datos relativos a una entidad
 * @author Jos� Antonio Nogales
 */
public class Entidad {
	String codigo;
	String descripcion;
	
	/**
	 * Constructor de la clase entidad
	 * @param codigo C�digo de la entidad 
	 * @param descripcion Descripci�n de la entidad
	 */
	public Entidad(String codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
	
	/**
	 * Constructor de la clase sin par�metros
	 */
	public Entidad() {
		this.codigo = null;
		this.descripcion = null;
	}
	
	/**
	 * M�todos get y set de la clase 
	 */
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
