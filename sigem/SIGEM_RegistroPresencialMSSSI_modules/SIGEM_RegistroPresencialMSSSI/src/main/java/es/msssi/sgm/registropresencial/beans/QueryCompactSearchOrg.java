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
 * Bean que guarda los datos de la query de la b�squeda r�pida de organismos.
 * 
 * @author cmorenog
 */
public class QueryCompactSearchOrg extends GenericBean {

    private static final long serialVersionUID = 4907664550675804289L;
    /** where de la consulta. */
    private String where;
    /** orderby de la consulta. */
    private String orderBy;

    /**
     * Obtiene el valor del par�metro where.
     * 
     * @return where valor del campo a obtener.
     */
    public String getWhere() {
	return where;
    }

    /**
     * Guarda el valor del par�metro where.
     * 
     * @param where
     *            valor del campo a guardar.
     */
    public void setWhere(
	String where) {
	this.where = where;
    }

    /**
     * Obtiene el valor del par�metro orderBy.
     * 
     * @return orderBy valor del campo a obtener.
     */
    public String getOrderBy() {
	return orderBy;
    }

    /**
     * Guarda el valor del par�metro orderBy.
     * 
     * @param orderBy
     *            valor del campo a guardar.
     */
    public void setOrderBy(
	String orderBy) {
	this.orderBy = orderBy;
    }

}
