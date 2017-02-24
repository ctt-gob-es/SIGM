package ieci.tecdoc.sgm.core.services.geolocalizacion;

import java.util.ArrayList;
import java.util.List;

/**
 * Contenedor de municipios
 * 
 * @author Jose Antonio Nogales
 *
 * Fecha de Creaci�n: 14-may-2007
 */
public class Municipios {
	
	private List municipios;

	/**
	 * Constructor de clase
	 *
	 */
	public Municipios() {
		municipios = new ArrayList();
	}

	public List getMunicipios() {
		return municipios;
	}

	public void setMunicipios(List municipios) {
		this.municipios = municipios;
	}

	/**
	 * Devuelve el n�mero de municipios de la colecci�n.
	 * @return int N�mero de municipios de la colecci�n.
	 */
	public int count() {
		return municipios.size();
	}

	/**
	 * Devuelve el municipio de la posici�n indicada dentro de la colecci�n
	 * @param index Posici�n del municipio a recuperar.
	 * @return Mapa.
	 */
	public Object get(int index) {
		return (Municipio) municipios.get(index);
	}

	/**
	 * A�ade un nuevo municipio a la colecci�n.
	 * @param mapa Nuevo municipio a a�adir.
	 */
	public void add(Municipio municipio) {
		municipios.add(municipio);
	}

}
