package es.ieci.tecdoc.isicres.api.business.vo;

import es.ieci.tecdoc.isicres.api.business.vo.enums.EstadoDistribucionEnum;

public class CriterioBusquedaDistribucionVO extends BaseCriterioBusquedaVO {

	private static final long serialVersionUID = 4690902250366280316L;

	/**
	 * Constructor por defecto de la clase.
	 */
	public CriterioBusquedaDistribucionVO() {
		super();
	}

	/**
	 * Constructor con par�metros de la clase.
	 * 
	 * @param limit
	 *            n�mero m�ximo de resultados
	 * @param offset
	 *            valor inicial de la p�gina de resultados
	 */
	public CriterioBusquedaDistribucionVO(Long limit, Long offset) {
		super(limit, offset);
	}

	/**
	 * Constructor con par�metros de la clase.
	 * 
	 * @param limit
	 *            n�mero m�ximo de resultados
	 * @param offset
	 *            valor inicial de la p�gina de resultados
	 * @param estado
	 *            estado en que se encuentran las distribuciones a buscar
	 */
	public CriterioBusquedaDistribucionVO(Long limit, Long offset,
			EstadoDistribucionEnum estado) {
		super(limit, offset);
		setEstado(estado);
	}

	/**
	 * Constructor con par�metros de la clase.
	 * 
	 * @param limit
	 *            n�mero m�ximo de resultados
	 * @param offset
	 *            valor inicial de la p�gina de resultados
	 * @param estado
	 *            estado en que se encuentran las distribuciones a buscar
	 * @param user
	 *            usuario destino de las distribuciones
	 */
	public CriterioBusquedaDistribucionVO(Long limit, Long offset,
			EstadoDistribucionEnum estado, String user) {
		super(limit, offset);
		setEstado(estado);
		setUser(user);
	}

	public EstadoDistribucionEnum getEstado() {
		return estado;
	}

	public void setEstado(EstadoDistribucionEnum estado) {
		this.estado = estado;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	// Members
	protected EstadoDistribucionEnum estado;
	protected String user;

}
