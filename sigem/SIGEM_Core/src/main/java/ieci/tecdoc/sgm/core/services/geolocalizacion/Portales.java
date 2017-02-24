package ieci.tecdoc.sgm.core.services.geolocalizacion;

import java.util.ArrayList;
import java.util.List;

/**
 * Contenedor de portales
 * 
 * @author Jose Antonio Nogales
 *
 * Fecha de Creaci�n: 14-may-2007
 */
public class Portales {
	
	private List portales;

	/**
	 * Constructor de clase
	 *
	 */
	public Portales() {
		portales = new ArrayList();
	}

	public List getPortales() {
		return portales;
	}

	public void setPortales(List portales) {
		this.portales = portales;
	}

	/**
	 * Devuelve el n�mero de portales de la colecci�n.
	 * @return int N�mero de portales de la colecci�n.
	 */
	public int count() {
		return portales.size();
	}

	/**
	 * Devuelve el portal de la posici�n indicada dentro de la colecci�n
	 * @param index Posici�n del portal a recuperar.
	 * @return Mapa.
	 */
	public Object get(int index) {
		return (Portal) portales.get(index);
	}

	/**
	 * A�ade una nuevo portal a la colecci�n.
	 * @param portal Nuevo portal a a�adir.
	 */
	public void add(Portal portal) {
		portales.add(portal);
	}

}
