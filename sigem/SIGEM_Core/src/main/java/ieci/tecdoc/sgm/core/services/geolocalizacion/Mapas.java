package ieci.tecdoc.sgm.core.services.geolocalizacion;

import java.util.ArrayList;
import java.util.List;

/**
 * Contenedor de mapas
 * 
 * @author Jose Antonio Nogales
 *
 * Fecha de Creaci�n: 14-may-2007
 */
public class Mapas {
	
	private List mapas;

	/**
	 * Constructor de clase
	 *
	 */
	public Mapas() {
		mapas = new ArrayList();
	}

	public List getMapas() {
		return mapas;
	}

	public void setMapas(List mapas) {
		this.mapas = mapas;
	}

	/**
	 * Devuelve el n�mero de mapas de la colecci�n.
	 * @return int N�mero de mapas de la colecci�n.
	 */
	public int count() {
		return mapas.size();
	}

	/**
	 * Devuelve el mapa de la posici�n indicada dentro de la colecci�n
	 * @param index Posici�n del mapas a recuperar.
	 * @return Mapa.
	 */
	public Object get(int index) {
		return (Mapa) mapas.get(index);
	}

	/**
	 * A�ade un nuevo mapa a la colecci�n.
	 * @param mapa Nuevo mapa a a�adir.
	 */
	public void add(Mapa mapa) {
		mapas.add(mapa);
	}

}
