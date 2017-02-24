package es.msssi.tecdoc.fwktd.dir.ws.object;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Informaci�n de los criterios de b�squeda.
 *
 * @author cmorenog
 *
 */
public class CriteriosUO implements Serializable {
	private static final long serialVersionUID = -508373998996142816L;
	
	/**
	 * Lista de criterios.
	 */

	private List<CriterioUO> criterio = null;

	/**
	 * Criterios por los que se van a ordenar los resultados
	 */
	private List<CriterioUOEnum> orderBy = null;

	/**
	 * Informaci�n de la p�gina para la paginaci�n de resultados
	 */
	private PageInfoUO pageInfo = null;


	/**
	 * Constructor.
	 */
	public CriteriosUO() {
		super();
	}

	/**
	 * Constructor.
	 *
	 * @param criterios
	 *            Lista de criterios de b�squeda.
	 */
	public CriteriosUO(List<CriterioUO> criterios) {
		setCriterio(criterios);
	}

	/**
	 * Obtiene el valor del par�metro criterio.
	 * 
	 * @return criterio valor del campo a obtener.
	 *
	 */
	public List<CriterioUO> getCriterio() {
		return criterio;
	}
	
	/**
	 * Guarda el valor del par�metro criterio.
	 * 
	 * @param criterio
	 *            valor del campo a guardar.
	 */
	public void setCriterio(List<CriterioUO> criterio) {
		this.criterio = new ArrayList<CriterioUO>();
		if (criterio != null) {
			this.criterio.addAll(criterio);
		}
	}
	
	/**
	 * A�ade un valor a la lista criterio.
	 * 
	 * @param criterio
	 *            valor del campo a guardar.
	 */
	public void addCriterio(CriterioUO criterio) {
		if (criterio != null) {
			this.criterio.add(criterio);
		}
	}
	
	/**
	 * Obtiene el valor del par�metro orderBy.
	 * 
	 * @return orderBy valor del campo a obtener.
	 *
	 */
	public List<CriterioUOEnum> getOrderBy() {
		return orderBy;
	}
	
	/**
	 * Guarda el valor del par�metro orderBy.
	 * 
	 * @param orderBy
	 *            valor del campo a guardar.
	 */
	public void setOrderBy(List<CriterioUOEnum> orderBy) {
		this.orderBy = new ArrayList<CriterioUOEnum>();
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
	public void addOrderBy(CriterioUOEnum order) {
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
	public PageInfoUO getPageInfo() {
		return pageInfo;
	}
	
	/**
	 * Guarda el valor del par�metro pageInfo.
	 * 
	 * @param pageInfo
	 *            valor del campo a guardar.
	 */
	public void setPageInfo(PageInfoUO pageInfo) {
		this.pageInfo = pageInfo;
	}

	
}
