package ieci.tecdoc.sgm.core.services.consulta;

import java.util.ArrayList;
import java.util.List;

public class Expedientes {

	private List expedientes;
	
	public Expedientes(){
		expedientes = new ArrayList();
	}
	
	public int count() {
		return expedientes.size();
	}

	/**
	 * Devuelve el expediente de la posici�n indicada dentro de la colecci�n
	 * @param index Posici�n del expediente a recuperar.
	 * @return Expediente asociado a registro.
	 */
	public Expediente get(int index) {
		return (Expediente)expedientes.get(index);
	}

	/**
	 * A�ade un nuevo expediente a la colecci�n.
	 * @param expediente Nuevo expediente a a�adir.
	 */
	public void add(Expediente expediente) {
		expedientes.add(expediente);
	}

	public List getExpedientes() {
		return expedientes;
	}

	public void setExpedientes(List expedientes) {
		this.expedientes = expedientes;
	}

}
