package ieci.tecdoc.sgm.core.services.consulta;

import java.util.ArrayList;
import java.util.List;


public class HitosExpediente {

	private List hitosExpediente;
	/**
	 * Constructor de clase
	 */

	public HitosExpediente() {
		hitosExpediente = new ArrayList();
	}

	/**
	 * Devuelve el n�mero de hitos de la colecci�n.
	 * @return int N�mero de hitos de la colecci�n.
	 */
	public int count() {
		return hitosExpediente.size();
	}

	/**
	 * Devuelve el hito de la posici�n indicada dentro de la colecci�n
	 * @param index Posici�n del hito a recuperar.
	 * @return Hito asociado a registro.
	 */
	public HitoExpediente get(int index) {
		return (HitoExpediente)hitosExpediente.get(index);
	}

	/**
	 * A�ade un nuevo hito a la colecci�n.
	 * @param hito Nuevo expediente a a�adir.
	 */
	public void add(HitoExpediente hito) {
		hitosExpediente.add(hito);
	}

	public List getHitosExpediente() {
		return hitosExpediente;
	}

	public void setHitosExpediente(List hitosExpediente) {
		this.hitosExpediente = hitosExpediente;
	}

}
