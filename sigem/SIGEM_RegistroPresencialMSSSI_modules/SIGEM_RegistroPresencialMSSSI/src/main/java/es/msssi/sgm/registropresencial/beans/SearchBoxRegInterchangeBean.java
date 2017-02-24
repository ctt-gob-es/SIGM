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
 * Bean con el formulario de b�squeda de IR.
 * 
 * @author cmorenog
 * */
public class SearchBoxRegInterchangeBean
		extends GenericBean {
	
	private static final long serialVersionUID = 1L;
	/** estado de salida. */
	private Integer outState = 1;
	/** estado de entrada. */
	private Integer inState = 0;
	/** tipo de bandeja. */
	private String type ="1";
	/** libro seleccionado. */
	private Integer book = 1;
	private String docSupport = "0";
	private String nregistroOrg = null;
	private String codIntercambio = null;
	private String docInteresado = null;
	private String nombreInteresado = null;
	private String primerApellidoInteresado = null;
	private String segundoApellidoInteresado = null;
	private String resumen = null;
	/**
	 * Obtiene el valor del par�metro outState.
	 * 
	 * @return outState valor del campo a obtener.
	 */
	public Integer getOutState() {
		return outState;
	}
	/**
	 * Guarda el valor del par�metro outState.
	 * 
	 * @param outState
	 *            valor del campo a guardar.
	 */
	public void setOutState(Integer outState) {
		this.outState = outState;
	}
	
	/**
	 * Obtiene el valor del par�metro inState.
	 * 
	 * @return inState valor del campo a obtener.
	 */
	public Integer getInState() {
		return inState;
	}
	
	/**
	 * Guarda el valor del par�metro inState.
	 * 
	 * @param inState
	 *            valor del campo a guardar.
	 */
	public void setInState(Integer inState) {
		this.inState = inState;
	}
	
	/**
	 * Obtiene el valor del par�metro type.
	 * 
	 * @return type valor del campo a obtener.
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Guarda el valor del par�metro type.
	 * 
	 * @param type
	 *            valor del campo a guardar.
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Obtiene el valor del par�metro book.
	 * 
	 * @return book valor del campo a obtener.
	 */
	public Integer getBook() {
		return book;
	}
	
	/**
	 * Guarda el valor del par�metro book.
	 * 
	 * @param book
	 *            valor del campo a guardar.
	 */
	public void setBook(Integer book) {
		this.book = book;
	}
	
	/**
	 * Obtiene el valor del par�metro docSupport.
	 * 
	 * @return docSupport valor del campo a obtener.
	 */
	public String getDocSupport() {
	    return docSupport;
	}
	
	/**
	 * Guarda el valor del par�metro docSupport.
	 * 
	 * @param docSupport
	 *            valor del campo a guardar.
	 */
	public void setDocSupport(String docSupport) {
	    this.docSupport = docSupport;
	}
	/**
	 * Obtiene el valor del par�metro nregistroOrg.
	 * 
	 * @return nregistroOrg valor del campo a obtener.
	 */
	public String getNregistroOrg() {
	    return nregistroOrg;
	}
	/**
	 * Guarda el valor del par�metro nregistroOrg.
	 * 
	 * @param nregistroOrg
	 *            valor del campo a guardar.
	 */
	public void setNregistroOrg(String nregistroOrg) {
	    this.nregistroOrg = nregistroOrg;
	}
	/**
	 * Obtiene el valor del par�metro codIntercambio.
	 * 
	 * @return codIntercambio valor del campo a obtener.
	 */
	public String getCodIntercambio() {
	    return codIntercambio;
	}
	/**
	 * Guarda el valor del par�metro codIntercambio.
	 * 
	 * @param codIntercambio
	 *            valor del campo a guardar.
	 */
	public void setCodIntercambio(String codIntercambio) {
	    this.codIntercambio = codIntercambio;
	}
	
	/**
	 * Obtiene el valor del par�metro docInteresado.
	 * 
	 * @return docInteresado valor del campo a obtener.
	 */
	public String getDocInteresado() {
	    return docInteresado;
	}
	/**
	 * Guarda el valor del par�metro docInteresado.
	 * 
	 * @param docInteresado
	 *            valor del campo a guardar.
	 */
	public void setDocInteresado(String docInteresado) {
	    this.docInteresado = docInteresado;
	}
	/**
	 * Obtiene el valor del par�metro nombreInteresado.
	 * 
	 * @return nombreInteresado valor del campo a obtener.
	 */
	public String getNombreInteresado() {
	    return nombreInteresado;
	}
	/**
	 * Guarda el valor del par�metro nombreInteresado.
	 * 
	 * @param nombreInteresado
	 *            valor del campo a guardar.
	 */
	public void setNombreInteresado(String nombreInteresado) {
	    this.nombreInteresado = nombreInteresado;
	}
	/**
	 * Obtiene el valor del par�metro primerApellidoInteresado.
	 * 
	 * @return primerApellidoInteresado valor del campo a obtener.
	 */
	public String getPrimerApellidoInteresado() {
	    return primerApellidoInteresado;
	}
	/**
	 * Guarda el valor del par�metro primerApellidoInteresado.
	 * 
	 * @param primerApellidoInteresado
	 *            valor del campo a guardar.
	 */
	public void setPrimerApellidoInteresado(String primerApellidoInteresado) {
	    this.primerApellidoInteresado = primerApellidoInteresado;
	}
	/**
	 * Obtiene el valor del par�metro segundoApellidoInteresado.
	 * 
	 * @return segundoApellidoInteresado valor del campo a obtener.
	 */
	public String getSegundoApellidoInteresado() {
	    return segundoApellidoInteresado;
	}
	/**
	 * Guarda el valor del par�metro segundoApellidoInteresado.
	 * 
	 * @param segundoApellidoInteresado
	 *            valor del campo a guardar.
	 */
	public void setSegundoApellidoInteresado(String segundoApellidoInteresado) {
	    this.segundoApellidoInteresado = segundoApellidoInteresado;
	}
	/**
	 * Obtiene el valor del par�metro resumen.
	 * 
	 * @return resumen valor del campo a obtener.
	 */
	public String getResumen() {
	    return resumen;
	}
	/**
	 * Guarda el valor del par�metro resumen.
	 * 
	 * @param resumen
	 *            valor del campo a guardar.
	 */
	public void setResumen(String resumen) {
	    this.resumen = resumen;
	}
	
}
