package es.ieci.tecdoc.isicres.api.business.vo;

public class CriterioBusquedaUnidadAdministrativaVO extends
		BaseCriterioBusquedaVO {

	private static final long serialVersionUID = 2739070168101701750L;

	/**
	 * Constructor por defecto de la clase.
	 */
	public CriterioBusquedaUnidadAdministrativaVO() {
		super();
	}

	/**
	 * Constructor con par�metros de la clase.
	 * 
	 * @param limit
	 *            n�mero m�ximo de resultados
	 * @param offset
	 *            posici�n inicial de la p�gina de resultados
	 */
	public CriterioBusquedaUnidadAdministrativaVO(Long limit, Long offset) {
		super(limit, offset);
	}

}
