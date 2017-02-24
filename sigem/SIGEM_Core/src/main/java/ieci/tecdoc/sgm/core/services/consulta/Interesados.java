package ieci.tecdoc.sgm.core.services.consulta;

import java.util.ArrayList;

public class Interesados {

	private ArrayList interesados;

	/**
	 * Constructor de clase
	 */
	public Interesados() {
		interesados = new ArrayList();
	}

	/**
	 * Devuelve el n�mero de interesados de la colecci�n.
	 * @return int N�mero de interesados de la colecci�n.
	 */
	public int count() {
		return interesados.size();
	}

	/**
	 * Devuelve el interesado de la posici�n indicada dentro de la colecci�n
	 * @param index Posici�n del interesado a recuperar.
	 * @return Interesado asociado a registro.
	 */
	public Interesado get(int index) {
		return (Interesado) interesados.get(index);
	}

	/**
	 * A�ade un nuevo interesado a la colecci�n.
	 * @param interesado Nuevo interesado a a�adir.
	 */
	public void add(Interesado interesado) {
		interesados.add(interesado);
	}

	public ArrayList getInteresados() {
		return interesados;
	}

	public void setInteresados(ArrayList interesados) {
		this.interesados = interesados;
	}

}
