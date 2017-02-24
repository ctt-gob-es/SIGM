package ieci.tecdoc.sgm.core.services.certificacion;

/**
 * Clase que almacena la informaci�n relativa al usuario
 * @author Jos� Antonio Nogales
 */
public class Usuario {
	String nombre;
	String apellidos;
	String nif;
	String telefono;
	String email;
	String domicilio;
	String localidad;
	String provincia;
	String cp;
	String idioma;
	
	/**
	 * Constructor de la clase
	 * @param nombre Nombre del ciudadano
	 * @param apellidos Apellidos del ciudadano
	 * @param nif Documento de identidad del ciudadano
	 * @param telefono Tel�fono del ciudadano
	 * @param email Correo electr�nico del ciudadano
	 * @param domicilio Dominilio del ciudadano
	 * @param localidad Localidad del ciudadano
	 * @param provincia Provincia del ciudadano
	 * @param cp C�digo postal del ciudadano
	 */
	public Usuario(String nombre, String apellidos, String nif, String telefono, String email, String domicilio, String localidad, String provincia, String cp, String idioma) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nif = nif;
		this.telefono = telefono;
		this.email = email;
		this.domicilio = domicilio;
		this.localidad = localidad;
		this.provincia = provincia;
		this.cp = cp;
		this.idioma = idioma;
	}
	
	/**
	 * Constructor de la clase sin par�metros
	 */
	public Usuario() {
		this.nombre = null;
		this.apellidos = null;
		this.nif = null;
		this.telefono = null;
		this.email = null;
		this.domicilio = null;
		this.localidad = null;
		this.provincia = null;
		this.cp = null;
		this.idioma = null;
	}

	/**
	 * M�todos get y set de la clase
	 */
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
}
