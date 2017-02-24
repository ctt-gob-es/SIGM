/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.sgm.registropresencial.beans;

import java.io.Serializable;

/**
 * Clase que implementa clave-valor.
 * 
 * @author cmorenog
 * */
public class ItemBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Object clave;
	private String valor;
	
	/**
	 * Constructor.
	 * 
	 * @param clave
	 *            Objeto clave.
	 * @param valor
	 *            String valor.
	 */
	public ItemBean(Object clave, String valor) {
		this.clave = clave;
		this.valor = valor;
	}
	
	/**
	 * Obtiene el valor del par�metro clave.
	 * 
	 * @return clave valor del campo a obtener.
	 */
	public Object getClave() {
		return clave;
	}
	
	/**
	 * Guarda el valor del par�metro clave.
	 * 
	 * @param clave
	 *            valor del campo a guardar.
	 */
	public void setClave(Object clave) {
		this.clave = clave;
	}
	
	/**
	 * Obtiene el valor del par�metro valor.
	 * 
	 * @return valor valor del campo a obtener.
	 */
	public String getValor() {
		return valor;
	}
	
	/**
	 * Guarda el valor del par�metro valor.
	 * 
	 * @param valor
	 *            valor del campo a guardar.
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}
}