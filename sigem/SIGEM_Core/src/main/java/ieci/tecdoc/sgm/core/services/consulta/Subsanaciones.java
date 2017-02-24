package ieci.tecdoc.sgm.core.services.consulta;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Contenedor de interesados asociados a un expediente.
 * 
 * @author Jose Antonio Nogales
 *
 * Fecha de Creaci�n: 14-may-2007
 */
public class Subsanaciones  {
	
	private ArrayList subsanaciones;

	/**
	 * Constructor de clase
	 *
	 */
	public Subsanaciones() {
		subsanaciones = new ArrayList();
	}

	public ArrayList getSubsanaciones() {
		return subsanaciones;
	}

	public void setSubsanaciones(ArrayList subsanaciones) {
		this.subsanaciones = subsanaciones;
	}

	/**
	 * Devuelve el n�mero de interesados de la colecci�n.
	 * @return int N�mero de interesados de la colecci�n.
	 */
	public int count() {
		return subsanaciones.size();
	}

	/**
	 * Devuelve el interesado de la posici�n indicada dentro de la colecci�n
	 * @param index Posici�n del interesado a recuperar.
	 * @return Interesado asociado a registro.
	 */
	public Object get(int index) {
		return (Subsanacion) subsanaciones.get(index);
	}

	/**
	 * A�ade un nuevo interesado a la colecci�n.
	 * @param fichero Nuevo interesado a a�adir.
	 */
	public void add(Subsanacion fichero) {
		subsanaciones.add(fichero);
	}

}
