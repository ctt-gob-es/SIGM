package es.ieci.tecdoc.fwktd.dir3.api.dao;

import java.util.List;

import es.ieci.tecdoc.fwktd.dir3.api.vo.DatosBasicosOficinaVO;
import es.ieci.tecdoc.fwktd.dir3.core.type.CriterioOficinaEnum;
import es.ieci.tecdoc.fwktd.dir3.core.vo.Criterios;
import es.ieci.tecdoc.fwktd.server.dao.BaseDao;

/**
 * Interfaz de los DAOs de datos b�sicos de oficinas.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public interface DatosBasicosOficinaDao extends
		BaseDao<DatosBasicosOficinaVO, String> {

	/**
	 * Obtiene el n�mero de oficinas encontradas seg�n los criterios de
	 * b�squeda.
	 *
	 * @param criterios
	 *            Criterios de b�squeda.
	 * @return N�mero de oficinas encontradas.
	 */
	public int countOficinas(Criterios<CriterioOficinaEnum> criterios);

	/**
	 * Realiza una b�squeda de oficinas.
	 *
	 * @param criterios
	 *            Criterios de b�squeda.
	 * @return Oficinas encontradas.
	 */
	public List<DatosBasicosOficinaVO> findOficinas(
			Criterios<CriterioOficinaEnum> criterios);

}
