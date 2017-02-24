package ieci.tecdoc.sgm.core.services.consulta;

import java.util.ArrayList;
import java.util.List;

public class FicherosHito {

	private String guidHito;
	
	private List ficheros;

	/**
	 * Constructor de clase
	 *
	 */
	public FicherosHito() {
		ficheros = new ArrayList();
	}

	/**
	 * Devuelve el n�mero de interesados de la colecci�n.
	 * @return int N�mero de interesados de la colecci�n.
	 */
	public int count() {
		return ficheros.size();
	}

	/**
	 * Devuelve el interesado de la posici�n indicada dentro de la colecci�n
	 * @param index Posici�n del interesado a recuperar.
	 * @return Interesado asociado a registro.
	 */
	public FicheroHito get(int index) {
		return (FicheroHito) ficheros.get(index);
	}

	/**
	 * A�ade un nuevo interesado a la colecci�n.
	 * @param fichero Nuevo interesado a a�adir.
	 */
	public void add(FicheroHito fichero) {
		ficheros.add(fichero);
	}

	public List getFicheros() {
		return ficheros;
	}

	public void setFicheros(List ficheros) {
		this.ficheros = ficheros;
	}

	public String getGuidHito() {
		return guidHito;
	}

	public void setGuidHito(String guidHito) {
		this.guidHito = guidHito;
	}

	
}
