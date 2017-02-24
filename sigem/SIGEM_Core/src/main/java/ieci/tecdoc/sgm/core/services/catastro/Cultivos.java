package ieci.tecdoc.sgm.core.services.catastro;

import java.util.ArrayList;
import java.util.List;

/**
 * Contenedor de cultivos
 * 
 * @author Jose Antonio Nogales
 *
 * Fecha de Creaci�n: 14-may-2007
 */
public class Cultivos {
	
	private List cultivos;

	/**
	 * Constructor de clase
	 *
	 */
	public Cultivos() {
		cultivos = new ArrayList();
	}

	public List getCultivos() {
		return cultivos;
	}

	public void setCultivos(List cultivos) {
		this.cultivos = cultivos;
	}

	/**
	 * Devuelve el n�mero de cultivos de la colecci�n.
	 * @return int N�mero de cultivos de la colecci�n.
	 */
	public int count() {
		return cultivos.size();
	}

	/**
	 * Devuelve el cultivo de la posici�n indicada dentro de la colecci�n
	 * @param index Posici�n del cultivo a recuperar.
	 * @return Cultivo.
	 */
	public Object get(int index) {
		return (Cultivo) cultivos.get(index);
	}

	/**
	 * A�ade un nuevo cultivo a la colecci�n.
	 * @param cultivos Nuevo cultivo a a�adir.
	 */
	public void add(Cultivo cultivo) {
		cultivos.add(cultivo);
	}

}
