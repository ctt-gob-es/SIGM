package ieci.tecdoc.sgm.core.services.geolocalizacion;

import java.util.ArrayList;
import java.util.List;

/**
 * Contenedor de tipos de vias
 * 
 * @author Jose Antonio Nogales
 *
 * Fecha de Creaci�n: 14-may-2007
 */
public class TiposVia {
	
	private List tipoVias;

	/**
	 * Constructor de clase
	 *
	 */
	public TiposVia() {
		tipoVias = new ArrayList();
	}

	public List getTipoVias() {
		return tipoVias;
	}

	public void setTipoVias(List tipoVias) {
		this.tipoVias = tipoVias;
	}

	/**
	 * Devuelve el n�mero de tipos de vias de la colecci�n.
	 * @return int N�mero de tipos de vias de la colecci�n.
	 */
	public int count() {
		return tipoVias.size();
	}

	/**
	 * Devuelve el tipo de via de la posici�n indicada dentro de la colecci�n
	 * @param index Posici�n del tipo de via a recuperar.
	 * @return Mapa.
	 */
	public Object get(int index) {
		return (TipoVia) tipoVias.get(index);
	}

	/**
	 * A�ade un nuevo tipo de via a la colecci�n.
	 * @param mapa Nuevo tipo de via a a�adir.
	 */
	public void add(TipoVia tipoVia) {
		tipoVias.add(tipoVia);
	}

}
