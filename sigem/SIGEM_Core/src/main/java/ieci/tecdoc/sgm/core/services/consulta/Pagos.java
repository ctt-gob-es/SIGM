package ieci.tecdoc.sgm.core.services.consulta;

import java.util.ArrayList;

/**
 * Contenedor de interesados asociados a un expediente.
 * 
 * @author Javier Septi�n Arceredillo
 *
 * Fecha de Creaci�n: 14-may-2007
 */
public class Pagos {
	
	private ArrayList pagos;

	/**
	 * Constructor de clase
	 *
	 */
	public Pagos() {
		pagos = new ArrayList();
	}

	public ArrayList getPagos() {
		return pagos;
	}

	public void setPagos(ArrayList pagos) {
		this.pagos = pagos;
	}

	/**
	 * Devuelve el n�mero de interesados de la colecci�n.
	 * @return int N�mero de interesados de la colecci�n.
	 */
	public int count() {
		return pagos.size();
	}

	/**
	 * Devuelve el interesado de la posici�n indicada dentro de la colecci�n
	 * @param index Posici�n del interesado a recuperar.
	 * @return Interesado asociado a registro.
	 */
	public Object get(int index) {
		return (Pago) pagos.get(index);
	}

	/**
	 * A�ade un nuevo interesado a la colecci�n.
	 * @param fichero Nuevo interesado a a�adir.
	 */
	public void add(Pago fichero) {
		pagos.add(fichero);
	}

}
