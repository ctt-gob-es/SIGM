package ieci.tecdoc.sgm.core.services.geolocalizacion;

import java.util.ArrayList;
import java.util.List;

/**
 * Contenedor de coordenadas
 * 
 * @author Jose Antonio Nogales
 *
 * Fecha de Creaci�n: 14-may-2007
 */
public class Coordenadas {
	
	private List coordenadas;

	/**
	 * Constructor de clase
	 *
	 */
	public Coordenadas() {
		coordenadas = new ArrayList();
	}

	public List getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(List coordenadas) {
		this.coordenadas = coordenadas;
	}

	/**
	 * Devuelve el n�mero de coordenadas de la colecci�n.
	 * @return int N�mero de coordenadas de la colecci�n.
	 */
	public int count() {
		return coordenadas.size();
	}

	/**
	 * Devuelve la via de la coordenada indicada dentro de la colecci�n
	 * @param index Posici�n de la coordenada a recuperar.
	 * @return Mapa.
	 */
	public Object get(int index) {
		return (Coordenada) coordenadas.get(index);
	}

	/**
	 * A�ade una nueva coordenada a la colecci�n.
	 * @param coordenada Nueva coordenada a a�adir.
	 */
	public void add(Coordenada coordenada) {
		coordenadas.add(coordenada);
	}

}
