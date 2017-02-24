package ieci.tecdoc.sgm.core.services.terceros.dto;

import java.io.Serializable;

/**
 * Informaci�n de la direcci�n electr�nica de un tercero.
 *
 */
public class DireccionElectronica implements Serializable {

	/**
	 * La direcci�n electr�nica es una direcci�n de correo electr�nico.
	 */
	public final int MAIL_TYPE = 1;
	
	/**
	 * La direcci�n electr�nica es un n�mero de tel�fono.
	 */
	public final int PHONE_TYPE = 2; 


	/**
	 * Identificador de la direcci�n electr�nica.
	 */
	private String id;
	
	/**
	 * Tipo de direcci�n electr�nica:
	 */
	private int tipo;
	
	/**
	 * Direcci�n electr�nica.
	 */
	private String direccion;

	
	/**
	 * Constructor.
	 */
	public DireccionElectronica() {
		super();
	}
	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
