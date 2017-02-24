package es.ieci.tecdoc.fwktd.dir3.api.manager;

import java.util.List;

import es.ieci.tecdoc.fwktd.dir3.api.vo.DatosBasicosOficinaVO;
import es.ieci.tecdoc.fwktd.dir3.api.vo.oficina.OficinasVO;
import es.ieci.tecdoc.fwktd.dir3.core.type.CriterioOficinaEnum;
import es.ieci.tecdoc.fwktd.dir3.core.vo.Criterios;
import es.ieci.tecdoc.fwktd.server.manager.BaseManager;

/**
 * Interfaz para los managers de datos b�sicos de oficinas.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public interface DatosBasicosOficinaManager extends
		BaseManager<DatosBasicosOficinaVO, String> {

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

	/**
	 * Metodo que obtiene la informaci�n de la oficina seg�n su codigo
	 * @param codeOficina - C�digo de la oficina a buscar
	 * @return {@link DatosBasicosOficinaVO} o NULO en caso de no encontrar nada
	 */
	public DatosBasicosOficinaVO getDatosBasicosOficinaByCode(String codeOficina);

	/**
	 * Guarda los datos basicos de las oficinas obtenidas del DCO
	 * @param oficinasDCO
	 */
	public void saveDatosBasicosOficinas(OficinasVO oficinasDCO);

	/**
	 * Actualiza los datos basicos de las oficinas obtenidas del DCO
	 * @param oficinasDCO
	 */
	public void updateDatosBasicosOficinas(OficinasVO oficinasDCO);
}
