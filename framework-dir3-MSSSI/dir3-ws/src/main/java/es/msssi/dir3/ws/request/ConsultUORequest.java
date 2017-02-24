/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.dir3.ws.request;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlType;

import es.msssi.dir3.core.type.UOCriterionEnum;
import es.msssi.dir3.core.vo.CriterionUO;
import es.msssi.dir3.core.vo.PageInfo;

/**
 * Datos entrada del servicio web de consulta de UO.
 * 
 * @author cmorenog
 * 
 */
@XmlType(name = "consultUORequest",
    namespace = "http://es.msssi.dir3.ws.ConsultService/consultUORequest")
public class ConsultUORequest extends CommonRequest {

    private static final long serialVersionUID = 1L;
    /**
     * Lista de criterios.
     */

    private List<CriterionUO> criteria = null;

    /**
     * Criterios por los que se van a ordenar los resultados.
     */
    private List<UOCriterionEnum> orderBy = null;

    /**
     * Informaci�n de la p�gina para la paginaci�n de resultados.
     */
    private PageInfo pageInfo = null;

    /**
     * Obtiene el valor del par�metro criteria.
     * 
     * @return criteria valor del campo a obtener.
     * 
     */
    public List<CriterionUO> getCriteria() {
	return criteria;
    }

    /**
     * Guarda el valor del par�metro criteria.
     * 
     * @param criteria
     *            valor del campo a guardar.
     */
    public void setCriteria(
	List<CriterionUO> criteria) {
	this.criteria = new ArrayList<CriterionUO>();
	if (criteria != null) {
	    this.criteria.addAll(criteria);
	}
    }

    /**
     * A�ade un valor a la lista criterion.
     * 
     * @param criterion
     *            valor del campo a guardar.
     */
    public void addCriterion(
	CriterionUO criterion) {
	if (criterion != null) {
	    this.criteria.add(criterion);
	}
    }

    /**
     * Obtiene el valor del par�metro orderBy.
     * 
     * @return orderBy valor del campo a obtener.
     * 
     */
    public List<UOCriterionEnum> getOrderBy() {
	return orderBy;
    }

    /**
     * Guarda el valor del par�metro orderBy.
     * 
     * @param orderBy
     *            valor del campo a guardar.
     */
    public void setOrderBy(
	List<UOCriterionEnum> orderBy) {
	this.orderBy = new ArrayList<UOCriterionEnum>();
	if (orderBy != null) {
	    this.orderBy.addAll(orderBy);
	}
    }

    /**
     * A�ade un valor a la lista orderBy.
     * 
     * @param order
     *            valor del campo a guardar.
     */
    public void addOrderBy(
	UOCriterionEnum order) {
	if (orderBy != null) {
	    orderBy.add(order);
	}
    }

    /**
     * Obtiene el valor del par�metro pageInfo.
     * 
     * @return pageInfo valor del campo a obtener.
     * 
     */
    public PageInfo getPageInfo() {
	return pageInfo;
    }

    /**
     * Guarda el valor del par�metro pageInfo.
     * 
     * @param pageInfo
     *            valor del campo a guardar.
     */
    public void setPageInfo(
	PageInfo pageInfo) {
	this.pageInfo = pageInfo;
    }

}
