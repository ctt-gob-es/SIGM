package ieci.tecdoc.sgm.core.services.geolocalizacion;

import java.util.ArrayList;
import java.util.List;

/**
 * Contenedor de provincias
 * 
 * @author Jose Antonio Nogales
 *
 * Fecha de Creaci�n: 14-may-2007
 */
public class Provincias {
	
	private List provincias;

	/**
	 * Constructor de clase
	 *
	 */
	public Provincias() {
		provincias = new ArrayList();
	}

	public List getProvincias() {
		return provincias;
	}

	public void setProvincias(List provincias) {
		this.provincias = provincias;
	}

	/**
	 * Devuelve el n�mero de provincias de la colecci�n.
	 * @return int N�mero de provincias de la colecci�n.
	 */
	public int count() {
		return provincias.size();
	}

	/**
	 * Devuelve el provincia de la posici�n indicada dentro de la colecci�n
	 * @param index Posici�n del provincia a recuperar.
	 * @return Mapa.
	 */
	public Object get(int index) {
		return (Provincia) provincias.get(index);
	}

	/**
	 * A�ade un nuevo provincia a la colecci�n.
	 * @param mapa Nuevo provincia a a�adir.
	 */
	public void add(Provincia provincia) {
		provincias.add(provincia);
	}

}
