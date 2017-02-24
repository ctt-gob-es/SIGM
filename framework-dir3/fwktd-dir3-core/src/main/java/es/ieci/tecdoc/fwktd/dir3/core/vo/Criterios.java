package es.ieci.tecdoc.fwktd.dir3.core.vo;

import java.util.ArrayList;
import java.util.List;

import es.ieci.tecdoc.fwktd.core.model.BaseValueObject;
import es.ieci.tecdoc.fwktd.dir3.core.type.CriterioEnum;
import es.ieci.tecdoc.fwktd.server.pagination.PageInfo;

/**
 * Informaci�n de los criterios de b�squeda.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public class Criterios<ExtendedCriterioEnum extends CriterioEnum> extends BaseValueObject {

	private static final long serialVersionUID = 8350286656586969423L;

	/**
	 * Lista de criterios.
	 */
	private List<Criterio<ExtendedCriterioEnum>> criterios = new ArrayList<Criterio<ExtendedCriterioEnum>>();

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
	public Criterios() {
		super();
	}

	/**
	 * Constructor.
	 *
	 * @param criterios
	 *            Lista de criterios de b�squeda.
	 */
	public Criterios(List<Criterio<ExtendedCriterioEnum>> criterios) {
		super();
		setCriterios(criterios);
	}

	public List<Criterio<ExtendedCriterioEnum>> getCriterios() {
		return criterios;
	}

	public void setCriterios(List<Criterio<ExtendedCriterioEnum>> criterios) {
		this.criterios.clear();
		if (criterios != null) {
			this.criterios.addAll(criterios);
		}
	}

	public Criterios<ExtendedCriterioEnum> addCriterio(Criterio<ExtendedCriterioEnum> criterio) {
		if (criterio != null) {
			criterios.add(criterio);
		}
		return this;
	}

	public List<ExtendedCriterioEnum> getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(List<ExtendedCriterioEnum> orderBy) {
		this.orderBy.clear();
		if (orderBy != null) {
			this.orderBy.addAll(orderBy);
		}
	}

	public Criterios<ExtendedCriterioEnum> addOrderBy(ExtendedCriterioEnum criterio) {
		if (criterio != null) {
			orderBy.add(criterio);
		}
		return this;
	}

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public Criterios<ExtendedCriterioEnum> setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
		return this;
	}
}
