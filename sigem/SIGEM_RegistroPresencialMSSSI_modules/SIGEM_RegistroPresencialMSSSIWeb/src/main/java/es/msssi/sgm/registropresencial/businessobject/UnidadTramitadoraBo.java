/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.sgm.registropresencial.businessobject;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import com.ieci.tecdoc.common.exception.SessionException;
import com.ieci.tecdoc.common.exception.ValidationException;
import com.ieci.tecdoc.common.keys.HibernateKeys;
import com.ieci.tecdoc.isicres.usecase.UseCaseConf;

import es.ieci.tecdoc.isicres.api.business.manager.IsicresManagerProvider;
import es.ieci.tecdoc.isicres.api.intercambioregistral.business.manager.IntercambioRegistralManager;
import es.ieci.tecdoc.isicres.api.intercambioregistral.business.vo.EntidadRegistralDCO;
import es.ieci.tecdoc.isicres.api.intercambioregistral.business.vo.UnidadTramitacionIntercambioRegistralSIRVO;
import es.msssi.sgm.registropresencial.beans.QueryCompactSearchOrg;
import es.msssi.sgm.registropresencial.beans.SearchUnitsBean;
import es.msssi.sgm.registropresencial.beans.UnitsTramResultsBean;
import es.msssi.sgm.registropresencial.config.RegistroPresencialMSSSIWebSpringApplicationContext;
import es.msssi.sgm.registropresencial.daos.UnidadTramitadoraDAO;
import es.msssi.sgm.registropresencial.errors.ErrorConstants;
import es.msssi.sgm.registropresencial.errors.RPRegistralExchangeErrorCode;
import es.msssi.sgm.registropresencial.errors.RPRegistralExchangeException;

/**
 * Clase q implementa IGenericBo que contiene los m�todos relacionados con las
 * unidades tramitadoras.
 * 
 * @author cmorenog
 * 
 */
public class UnidadTramitadoraBo implements IGenericBo, HibernateKeys, Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(UnidadTramitadoraBo.class);
    private static IntercambioRegistralManager intercambioManager;
    private static ApplicationContext appContext;
    private UnidadTramitadoraDAO unidadTramitadoraDAO;

    static {
	intercambioManager = IsicresManagerProvider.getInstance().getIntercambioRegistralManager();
	appContext =
	    RegistroPresencialMSSSIWebSpringApplicationContext.getInstance()
		.getApplicationContext();
    }

    public UnidadTramitadoraBo() {
	unidadTramitadoraDAO = (UnidadTramitadoraDAO) appContext.getBean("unidadTramitadoraDAO");
    }

    /**
     * Devuelve una lista de entidades del DIR.
     * 
     * @param code
     *            C�digo de la entidad a buscar.
     * @param name
     *            nombre de la entidad a buscar.
     * @return result Listado entidades del DIR.
     * 
     * @throws RPRegistralExchangeException
     *             si ha habido alg�n problema.
     */
    public List<EntidadRegistralDCO> getListaEntidadesDCO(
	String code, String name)
	throws RPRegistralExchangeException {
	LOG.trace("Entrando en UnidadTramitadoraBo.getListaEntidadesDCO()");

	List<EntidadRegistralDCO> listaEntidadesDCO = null;
	try {
	    listaEntidadesDCO = intercambioManager.buscarEntidadesRegistralesDCO(
		code, name);
	}
	catch (Exception exception) {
	    LOG.error(
		ErrorConstants.GET_LIST_ENTID_REGISTER_ERROR_MESSAGE, exception);
	    throw new RPRegistralExchangeException(
		RPRegistralExchangeErrorCode.GET_ENTITYLIST_REG_INTERCHANGE_ERROR_MESSAGE,
		ErrorConstants.GET_LIST_ENTID_REGISTER_ERROR_MESSAGE, exception);
	}
	return listaEntidadesDCO;
    }

    /**
     * Devuelve una lista de unidades tramitadoras del DIR.
     * 
     * @param code
     *            C�digo de la unidades a buscar.
     * @param name
     *            nombre de la entidad a buscar.
     * @return result Listado unidades del DIR.
     * 
     * @throws RPRegistralExchangeException
     *             si ha habido alg�n problema.
     */
    public List<UnidadTramitacionIntercambioRegistralSIRVO> getListaUnidadesTramitadoras(
	String code, String name)
	throws RPRegistralExchangeException {
	LOG.trace("Entrando en UnidadTramitadoraBo.getListaUnidadesTramitadoras()");

	List<UnidadTramitacionIntercambioRegistralSIRVO> listaUnidadesTramitacion = null;
	try {
	    listaUnidadesTramitacion = intercambioManager.buscarUnidadesTramitacion(
		code, name);
	}
	catch (Exception exception) {
	    LOG.error(
		ErrorConstants.GET_LIST_UNID_REGISTER_ERROR_MESSAGE, exception);
	    throw new RPRegistralExchangeException(
		RPRegistralExchangeErrorCode.GET_UNIDLIST_REG_INTERCHANGE_ERROR_MESSAGE,
		ErrorConstants.GET_LIST_UNID_REGISTER_ERROR_MESSAGE, exception);
	}
	return listaUnidadesTramitacion;
    }

    /**
     * Devuelve una lista de unidades tramitadoras.
     * 
     * @param useCaseConf
     *            Usuario que realiza la petici�n.
     * @param query
     *            criterio de b�squeda.
     * @param queryCompactSearchUnitTram
     *            nivel de b�squeda y ordenaci�n sobre el que se realiza la
     *            b�squeda r�pida.
     * @return result Listado de organismos disponibles.
     * 
     * @throws exception
     *             si ha habido alg�n problema.
     */
    public List<UnidadTramitacionIntercambioRegistralSIRVO> buscarUnidadesTramitadoras(
	String query, QueryCompactSearchOrg queryCompactSearchUnitTram)
	throws RPRegistralExchangeException {
	LOG.trace("Entrando en UnidadTramitadoraBo.getListaUnidadesTramitadoras()");

	List<UnidadTramitacionIntercambioRegistralSIRVO> listaUnidadesTramitacion = null;
	try {
	    listaUnidadesTramitacion = unidadTramitadoraDAO.buscarUnidadesTramitacion(
		query, queryCompactSearchUnitTram);
	}
	catch (Exception exception) {
	    LOG.error(
		ErrorConstants.GET_LIST_UNID_REGISTER_ERROR_MESSAGE, exception);
	    throw new RPRegistralExchangeException(
		RPRegistralExchangeErrorCode.GET_UNIDLIST_REG_INTERCHANGE_ERROR_MESSAGE,
		ErrorConstants.GET_LIST_UNID_REGISTER_ERROR_MESSAGE, exception);
	}
	return listaUnidadesTramitacion;
    }

    /**
     * M�todo que construye la query y controla los permisos para la b�squeda de
     * las unidades.
     * 
     * @param useCaseConf
     *            configuraci�n de la aplicaci�n.
     * @param UnitsTramResultsBean
     *            par�metros de b�squeda.
     * @param firstRow
     *            primera fila.
     * @param pageSize
     *            tama�o b�squeda.
     * @return objeto con los datos necesarios para la b�squeda.
     * @throws ValidationException
     *             error en la validaci�n
     * @throws SessionException
     *             error de sesi�n
     * @throws RPRegistralExchangeException 
     * 
     * */
    public UnitsTramResultsBean searchUnitsTram(
	UseCaseConf useCaseConf, SearchUnitsBean searchUnitsBean, int firstRow, int pageSize)
	throws  RPRegistralExchangeException {
	LOG.trace("Entrando en UnidadTramitadoraBo.searchUnits()");
	UnitsTramResultsBean result = null;
	List<UnidadTramitacionIntercambioRegistralSIRVO> listaUnidadesTramitacion = null;
	int count = 0;
	try {
	    result = new UnitsTramResultsBean();
	    count = unidadTramitadoraDAO.countUnidadesTramitacion(searchUnitsBean);
	    result.setTotalSize(count);
	    if (count > 0) {
		listaUnidadesTramitacion = unidadTramitadoraDAO.buscarUnidadesTramitacionPag(
		    searchUnitsBean, firstRow, pageSize);
		result.setRows(listaUnidadesTramitacion);
	    }
	}
	catch (Exception exception) {
	    LOG.error(
		ErrorConstants.GET_LIST_UNID_REGISTER_ERROR_MESSAGE, exception);
	    throw new RPRegistralExchangeException(
		RPRegistralExchangeErrorCode.GET_UNIDLIST_REG_INTERCHANGE_ERROR_MESSAGE,
		ErrorConstants.GET_LIST_UNID_REGISTER_ERROR_MESSAGE, exception);
	}
	return result;
    }

    /**
     * Devuelve una unidad tramitadora.
     * 
     * @param id
     *            id de la unidad a recuperar.
     * @return result la unidad tramitadora recuperada.
     * 
     * @throws exception
     *             si ha habido alg�n problema.
     */
    public UnidadTramitacionIntercambioRegistralSIRVO getUnidadTramitadora(
	Integer id)
	throws RPRegistralExchangeException {
	LOG.trace("Entrando en UnidadTramitadoraBo.getUnidadTramitadora()");

	UnidadTramitacionIntercambioRegistralSIRVO UnidadTramitacion = null;
	try {
	    UnidadTramitacion = unidadTramitadoraDAO.getUnidadTramitadora(id);
	}
	catch (Exception exception) {
	    LOG.error(
		ErrorConstants.GET_UNID_REGISTER_ERROR_MESSAGE, exception);
	    throw new RPRegistralExchangeException(
		RPRegistralExchangeErrorCode.GET_UNID_REG_INTERCHANGE_ERROR_MESSAGE,
		ErrorConstants.GET_UNID_REGISTER_ERROR_MESSAGE, exception);
	}
	return UnidadTramitacion;
    }

}
