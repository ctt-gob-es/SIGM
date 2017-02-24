/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.dir3.api.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import es.msssi.dir3.api.type.CriterionEnum;
import es.msssi.dir3.core.vo.PageInfo;

/**
 * Informaci�n de los criterios de b�squeda.
 * 
 * @author cmorenog
 * 
 */
public class Criteria<ExtendedCriterioEnum extends CriterionEnum> implements Serializable {

    private static final long serialVersionUID = 8350286656586969423L;

    /**
     * Lista de criterios.
     */
    private List<Criterion<ExtendedCriterioEnum>> criteria =
	new ArrayList<Criterion<ExtendedCriterioEnum>>();

    /**
     * Criterios por los que se van a ordenar los resultados
     */
    private List<ExtendedCriterioEnum> orderBy = new ArrayList<ExtendedCriterioEnum>();

    /**
     * Informaci�n de la p�gina para la paginaci�n de resultados
     */
    private PageInfo pageInfo = null;

    /**
     * Constructor.
     */
    public Criteria() {
	super();
    }

    /**
     * Constructor.
     * 
     * @param criteria
     *            Lista de criterios de b�squeda.
     */
    public Criteria(List<Criterion<ExtendedCriterioEnum>> criteria) {
	super();
	setCriteria(criteria);
    }

    /**
     * Obtiene el valor del par�metro criteria.
     * 
     * @return criteria valor del campo a obtener.
     */
    public List<Criterion<ExtendedCriterioEnum>> getCriteria() {
	return criteria;
    }

    /**
     * Guarda el valor del par�metro criteria.
     * 
     * @param criteria
     *            valor del campo a guardar.
     */
    public void setCriteria(
	List<Criterion<ExtendedCriterioEnum>> criteria) {
	this.criteria.clear();
	if (criteria != null) {
	    this.criteria.addAll(criteria);
	}
    }

    /**
     * A�ade al par�metro orderBy un nuevo criterio.
     * 
     * @param criterion
     *            nuevo criterio de ordenaci�n.
     * @return criterios.
     */
    public Criteria<ExtendedCriterioEnum> addCriterion(
	Criterion<ExtendedCriterioEnum> criterion) {
	if (criterion != null) {
	    criteria.add(criterion);
	}
	return this;
    }

    /**
     * Obtiene el valor del par�metro orderBy.
     * 
     * @return orderBy valor del campo a obtener.
     */
    public List<ExtendedCriterioEnum> getOrderBy() {
	return orderBy;
    }

    /**
     * Guarda el valor del par�metro orderBy.
     * 
     * @param orderBy
     *            valor del campo a guardar.
     */
    public void setOrderBy(
	List<ExtendedCriterioEnum> orderBy) {
	this.orderBy.clear();
	if (orderBy != null) {
	    this.orderBy.addAll(orderBy);
	}
    }

    /**
     * A�ade al par�metro orderBy un nuevo criterio de ordenaci�n.
     * 
     * @param criterio
     *            nuevo criterio de ordenaci�n.
     * @return criterios.
     */
    public Criteria<ExtendedCriterioEnum> addOrderBy(
	ExtendedCriterioEnum criterio) {
	if (criterio != null) {
	    orderBy.add(criterio);
	}
	return this;
    }

    /**
     * Obtiene el valor del par�metro pageInfo.
     * 
     * @return pageInfo valor del campo a obtener.
     */
    public PageInfo getPageInfo() {
	return pageInfo;
    }

    /**
     * Guarda el valor del par�metro pageInfo.
     * 
     * @param pageInfo
     *            valor del campo a guardar.
     * @return criterios.
     */
    public Criteria<ExtendedCriterioEnum> setPageInfo(
	PageInfo pageInfo) {
	this.pageInfo = pageInfo;
	return this;
    }
}
