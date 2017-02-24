package ieci.tecdoc.sgm.core.services.geolocalizacion;

import java.util.ArrayList;
import java.util.List;

/**
 * Contenedor de vias
 * 
 * @author Jose Antonio Nogales
 *
 * Fecha de Creaci�n: 14-may-2007
 */
public class Vias {
	
	private List vias;

	/**
	 * Constructor de clase
	 *
	 */
	public Vias() {
		vias = new ArrayList();
	}

	public List getVias() {
		return vias;
	}

	public void setVias(List vias) {
		this.vias = vias;
	}

	/**
	 * Devuelve el n�mero de vias de la colecci�n.
	 * @return int N�mero de vias de la colecci�n.
	 */
	public int count() {
		return vias.size();
	}

	/**
	 * Devuelve la via de la posici�n indicada dentro de la colecci�n
	 * @param index Posici�n de la via a recuperar.
	 * @return Mapa.
	 */
	public Object get(int index) {
		return (Via) vias.get(index);
	}

	/**
	 * A�ade una nueva via a la colecci�n.
	 * @param via Nueva via a a�adir.
	 */
	public void add(Via via) {
		vias.add(via);
	}

}
