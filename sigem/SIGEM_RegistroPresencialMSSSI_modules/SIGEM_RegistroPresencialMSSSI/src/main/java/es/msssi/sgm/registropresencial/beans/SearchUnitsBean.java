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
 * Bean con el formulario de b�squeda de unidades.
 * 
 * @author cmorenog
 * */
public class SearchUnitsBean
		extends GenericBean {
	
	private static final long serialVersionUID = 1L;

    /** Nivel de b�squeda. */
    private int searchType = 1;
    /** texto de b�squeda. */
    private String searchText = "";
    /** ccaa de b�squeda. */
    private String ccaaId = null;
    /** provincia de b�squeda. */
    private Integer provId = null;
    
    /**
     * Obtiene el valor del par�metro searchType.
     * 
     * @return searchType valor del campo a obtener.
     */
    public int getSearchType() {
        return searchType;
    }

    /**
     * Guarda el valor del par�metro searchType.
     * 
     * @param searchType
     *            valor del campo a guardar.
     */
    public void setSearchType(
	int searchType) {
        this.searchType = searchType;
    }
    
    /**
     * Obtiene el valor del par�metro searchText.
     * 
     * @return searchText valor del campo a obtener.
     */
    public String getSearchText() {
        return searchText;
    }

    /**
     * Guarda el valor del par�metro searchText.
     * 
     * @param searchText
     *            valor del campo a guardar.
     */
    public void setSearchText(
        String searchText) {
        this.searchText = searchText;
    }

    /**
     * Obtiene el valor del par�metro ccaaId.
     * 
     * @return ccaaId valor del campo a obtener.
     */
    public String getCcaaId() {
        return ccaaId;
    }
    /**
     * Guarda el valor del par�metro ccaaId.
     * 
     * @param ccaaId
     *            valor del campo a guardar.
     */
    public void setCcaaId(
        String ccaaId) {
        this.ccaaId = ccaaId;
    }
    /**
     * Obtiene el valor del par�metro provId.
     * 
     * @return provId valor del campo a obtener.
     */
    public Integer getProvId() {
        return provId;
    }
    /**
     * Guarda el valor del par�metro provId.
     * 
     * @param provId
     *            valor del campo a guardar.
     */
    public void setProvId(
        Integer provId) {
        this.provId = provId;
    }	
    
}
