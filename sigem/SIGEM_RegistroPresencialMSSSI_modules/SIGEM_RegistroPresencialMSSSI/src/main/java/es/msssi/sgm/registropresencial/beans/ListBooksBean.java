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

import java.util.List;

import com.ieci.tecdoc.common.utils.ScrRegStateByLanguage;

/**
 * Bean que contiene las listas de los libros de entrada.
 * 
 * @author cmorenog
 */
public class ListBooksBean
		extends GenericBean {
	private static final long serialVersionUID = 1L;
	/** Libros de entrada. */
	private List<ScrRegStateByLanguage> inList;
	/** Libros de salida. */
	private List<ScrRegStateByLanguage> outList;
	
	/**
	 * Obtiene el valor del par�metro inList.
	 * 
	 * @return inList valor del campo a obtener.
	 */
	public List<ScrRegStateByLanguage> getInList() {
		return inList;
	}
	
	/**
	 * Guarda el valor del par�metro inList.
	 * 
	 * @param inList
	 *            valor del campo a guardar.
	 */
	public void setInList(List<ScrRegStateByLanguage> inList) {
		this.inList = inList;
	}
	
	/**
	 * Obtiene el valor del par�metro outList.
	 * 
	 * @return outList valor del campo a obtener.
	 */
	public List<ScrRegStateByLanguage> getOutList() {
		return outList;
	}
	
	/**
	 * Guarda el valor del par�metro outList.
	 * 
	 * @param outList
	 *            valor del campo a guardar.
	 */
	public void setOutList(List<ScrRegStateByLanguage> outList) {
		this.outList = outList;
	}
}