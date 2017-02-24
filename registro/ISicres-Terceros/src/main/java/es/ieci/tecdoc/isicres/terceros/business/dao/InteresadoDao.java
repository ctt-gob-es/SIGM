package es.ieci.tecdoc.isicres.terceros.business.dao;

import java.util.List;

import es.ieci.tecdoc.fwktd.server.dao.BaseDao;
import es.ieci.tecdoc.isicres.terceros.business.vo.InteresadoVO;

public interface InteresadoDao extends BaseDao<InteresadoVO, String> {

	/**
	 * Devuelve todos los interesados asociados al registro cuyos datos de
	 * identificaci�n se pasan en <code>idRegistro</code>.
	 *
	 * @see IdentificadorRegistroVO
	 * @param idRegistro
	 *            datos de identificaci�n del registro para el que recuperar los
	 *            interesados
	 * @return
	 */
	public List<InteresadoVO> getInteresados(String idLibro, String idRegistro);
}
