package ieci.tecdoc.sgm.core.services.catastro;

import java.util.ArrayList;
import java.util.List;

/**
 * Contenedor de parcelas
 * 
 * @author Jose Antonio Nogales
 *
 * Fecha de Creaci�n: 14-may-2007
 */
public class Parcelas {
	
	private List parcelas;

	/**
	 * Constructor de clase
	 *
	 */
	public Parcelas() {
		parcelas = new ArrayList();
	}

	public List getParcelas() {
		return parcelas;
	}

	public void setParcelas(List parcelas) {
		this.parcelas = parcelas;
	}

	/**
	 * Devuelve el n�mero de parcelas de la colecci�n.
	 * @return int N�mero de parcelas de la colecci�n.
	 */
	public int count() {
		return parcelas.size();
	}

	/**
	 * Devuelve la parcela de la posici�n indicada dentro de la colecci�n
	 * @param index Posici�n de la parcela a recuperar.
	 * @return Parcela.
	 */
	public Object get(int index) {
		return (Parcela) parcelas.get(index);
	}

	/**
	 * A�ade una nueva parcelas a la colecci�n.
	 * @param parcelas Nueva parcelas a a�adir.
	 */
	public void add(Parcela parcela) {
		parcelas.add(parcela);
	}

}
