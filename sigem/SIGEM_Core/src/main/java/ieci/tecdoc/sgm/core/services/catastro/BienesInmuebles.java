package ieci.tecdoc.sgm.core.services.catastro;

import java.util.ArrayList;
import java.util.List;

/**
 * Contenedor de bienes inmuebles
 * 
 * @author Jose Antonio Nogales
 *
 * Fecha de Creaci�n: 14-may-2007
 */
public class BienesInmuebles {
	
	private List bienesInmuebles;

	/**
	 * Constructor de clase
	 *
	 */
	public BienesInmuebles() {
		bienesInmuebles = new ArrayList();
	}

	public List getBienesInmuebles() {
		return bienesInmuebles;
	}

	public void setBienesInmuebles(List bienesInmuebles) {
		this.bienesInmuebles = bienesInmuebles;
	}

	/**
	 * Devuelve el n�mero de bienes inmuebles de la colecci�n.
	 * @return int N�mero de bienes inmuebles de la colecci�n.
	 */
	public int count() {
		return bienesInmuebles.size();
	}

	/**
	 * Devuelve el bien inmueble de la posici�n indicada dentro de la colecci�n
	 * @param index Posici�n del bien inmueble a recuperar.
	 * @return BienInmueble
	 */
	public Object get(int index) {
		return (BienInmueble) bienesInmuebles.get(index);
	}

	/**
	 * A�ade un nuev bien inmueble a la colecci�n.
	 * @param bienInmueble Nuevo bien inmueble a a�adir.
	 */
	public void add(BienInmueble bienInmueble) {
		bienesInmuebles.add(bienInmueble);
	}

}
