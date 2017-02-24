package ieci.tecdoc.sgm.core.services.catastro;

import java.util.ArrayList;
import java.util.List;

/**
 * Contenedor de construcciones
 * 
 * @author Jose Antonio Nogales
 *
 * Fecha de Creaci�n: 14-may-2007
 */
public class Construcciones {
	
	private List construcciones;

	/**
	 * Constructor de clase
	 *
	 */
	public Construcciones() {
		construcciones = new ArrayList();
	}

	public List getConstrucciones() {
		return construcciones;
	}

	public void setConstrucciones(List construcciones) {
		this.construcciones = construcciones;
	}

	/**
	 * Devuelve el n�mero de construcciones de la colecci�n.
	 * @return int N�mero de construcciones de la colecci�n.
	 */
	public int count() {
		return construcciones.size();
	}

	/**
	 * Devuelve la construccion de la posici�n indicada dentro de la colecci�n
	 * @param index Posici�n de la construccion a recuperar.
	 * @return Construccion.
	 */
	public Object get(int index) {
		return (Construccion) construcciones.get(index);
	}

	/**
	 * A�ade una nueva construccion a la colecci�n.
	 * @param construcciones Nueva construccion a a�adir.
	 */
	public void add(Construccion construccion) {
		construcciones.add(construccion);
	}

}
