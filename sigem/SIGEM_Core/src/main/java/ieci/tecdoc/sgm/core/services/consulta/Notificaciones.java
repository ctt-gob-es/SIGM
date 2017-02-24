package ieci.tecdoc.sgm.core.services.consulta;

import java.util.ArrayList;

/**
 * Contenedor de interesados asociados a un expediente.
 * 
 * @author Javier Septi�n Arceredillo
 *
 * Fecha de Creaci�n: 14-may-2007
 */
public class Notificaciones{
	
	private ArrayList notificaciones;

	/**
	 * Constructor de clase
	 *
	 */
	public Notificaciones() {
		notificaciones = new ArrayList();
	}

	public ArrayList getNotificaciones() {
		return notificaciones;
	}

	public void setNotificaciones(ArrayList notificaciones) {
		this.notificaciones = notificaciones;
	}

	/**
	 * Devuelve el n�mero de interesados de la colecci�n.
	 * @return int N�mero de interesados de la colecci�n.
	 */
	public int count() {
		return notificaciones.size();
	}

	/**
	 * Devuelve el interesado de la posici�n indicada dentro de la colecci�n
	 * @param index Posici�n del interesado a recuperar.
	 * @return Interesado asociado a registro.
	 */
	public Object get(int index) {
		return (Notificacion) notificaciones.get(index);
	}

	/**
	 * A�ade un nuevo interesado a la colecci�n.
	 * @param fichero Nuevo interesado a a�adir.
	 */
	public void add(Notificacion fichero) {
		notificaciones.add(fichero);
	}

}
