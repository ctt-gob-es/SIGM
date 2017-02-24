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


/**
 * Bean correspondiente a la b�squeda de registros asociados.
 * 
 * @author cmorenog
 */
public class AsocRegisterBean extends GenericBean {
	private static final long serialVersionUID = 1L;
	
	// n�mero de registro
	private String fld1;
	private Integer idLibro;
	
	/**
	 * Obtiene el valor del par�metro fld1.
	 * 
	 * @return fld1 valor del campo a obtener.
	 */
	public String getFld1() {
		return fld1;
	}
	
	/**
	 * Guarda el valor del par�metro fld1.
	 * 
	 * @param fld1
	 *            valor del campo a guardar.
	 */
	public void setFld1(String fld1) {
		this.fld1 = fld1;
	}
	
	/**
	 * Obtiene el valor del par�metro idLibro.
	 * 
	 * @return idLibro valor del campo a obtener.
	 */
	public Integer getIdLibro() {
		return idLibro;
	}
	
	/**
	 * Guarda el valor del par�metro idLibro.
	 * 
	 * @param idLibro
	 *            valor del campo a guardar.
	 */
	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
	}
	
}