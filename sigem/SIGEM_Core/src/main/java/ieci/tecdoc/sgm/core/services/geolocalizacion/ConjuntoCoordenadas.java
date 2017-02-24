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
public class ConjuntoCoordenadas {
	
	private List conjuntoCoordenadas;

	/**
	 * Constructor de clase
	 *
	 */
	public ConjuntoCoordenadas() {
		conjuntoCoordenadas = new ArrayList();
	}

	public List getConjuntoCoordenadas() {
		return conjuntoCoordenadas;
	}

	public void setConjuntoCoordenadas(List conjuntoCoordenadas) {
		this.conjuntoCoordenadas = conjuntoCoordenadas;
	}

	/**
	 * Devuelve el n�mero de conjunto coordenadas de la colecci�n.
	 * @return int N�mero de conjunto Coordenadas  de la colecci�n.
	 */
	public int count() {
		return conjuntoCoordenadas.size();
	}

	/**
	 * Devuelve el conjunto Coordenadas indicada dentro de la colecci�n
	 * @param index Posici�n del conjunto Coordenadas a recuperar.
	 * @return Coorodenadas.
	 */
	public Object get(int index) {
		return (Coordenadas) conjuntoCoordenadas.get(index);
	}

	/**
	 * A�ade un nuevo conjunto Coordenadas a la colecci�n.
	 * @param coordenadas Nuevas coordenadas a a�adir.
	 */
	public void add(Coordenadas coordenadas) {
		conjuntoCoordenadas.add(coordenadas);
	}

}
