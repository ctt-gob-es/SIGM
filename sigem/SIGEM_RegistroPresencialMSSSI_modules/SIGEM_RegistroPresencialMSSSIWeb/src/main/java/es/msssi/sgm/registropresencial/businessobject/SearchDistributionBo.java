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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import com.ieci.tecdoc.common.exception.DistributionException;
import com.ieci.tecdoc.common.exception.SessionException;
import com.ieci.tecdoc.common.exception.ValidationException;
import com.ieci.tecdoc.common.keys.ConfigurationKeys;
import com.ieci.tecdoc.common.utils.Configurator;
import com.ieci.tecdoc.isicres.desktopweb.Keys;
import com.ieci.tecdoc.isicres.usecase.UseCaseConf;
import com.ieci.tecdoc.utils.Validator;
import es.msssi.sgm.registropresencial.beans.DistributionResultsBean;
import es.msssi.sgm.registropresencial.beans.RowSearchDistributionBean;
import es.msssi.sgm.registropresencial.beans.SearchDistributionBean;
import es.msssi.sgm.registropresencial.errors.ErrorConstants;
import es.msssi.sgm.registropresencial.errors.RPDistributionException;
import es.msssi.sgm.registropresencial.errors.RPGenericErrorCode;
import es.msssi.sgm.registropresencial.errors.RPGenericException;

/**
 * Clase q implementa IGenericBo que contiene los m�todos relacionados con la
 * b�squeda de registros distribuidos.
 * 
 * @author cmorenog
 */
public class SearchDistributionBo extends LazyDataModel<RowSearchDistributionBean> implements
    IGenericBo {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(SearchDistributionBo.class.getName());
    private static final int LENGTHMINUS = 7;
    private static final String ESPACIO = " ";
    /** Variable con la configuraci�n de la aplicaci�n. */
    private UseCaseConf useCaseConf = null;
    /** contexto de faces. */
    private FacesContext facesContext;
    /** Bean con los criterios del buscador. */
    private SearchDistributionBean searchDistributionRegister = null;
    /** p�gina actual. */
    private int page;
    /** objeto clase de negocio. */
    private DistributionBo distributionBo;

    /**
     * Constructor.
     */
    public SearchDistributionBo() {
	super();
	searchDistributionRegister = new SearchDistributionBean();
	this.setRowCount(0);
	this.setPage(0);
    }

    /**
     * Inicializa el contexto de faces.
     */
    private void init() {
	if (facesContext == null) {
	    facesContext = FacesContext.getCurrentInstance();
	    Map<String, Object> map = facesContext.getExternalContext().getSessionMap();
	    useCaseConf = (UseCaseConf) map.get(Keys.J_USECASECONF);
	}
    }

    /**
     * Sobreescribe el load de LazyDataModel y gestiona la carga del datatable.
     * 
     * @param first
     *            identificador primer registro de la paginaci�n.
     * @param pageSize
     *            n�mero de registro que se ense�a en la paginaci�n.
     * @param sortField
     *            campo por el que se ordena.
     * @param sortOrder
     *            Criterio de ordenaci�n.
     * @param filters
     *            filtros de b�squeda.
     * 
     * @return lista de los resultados de la b�squeda.
     */
    @Override
    public List<RowSearchDistributionBean>
	load(
	    int first, int pageSize, String sortField, SortOrder sortOrder,
	    Map<String, String> filters) {
	List<RowSearchDistributionBean> data = null;
	int firstVar = first;
	data = new ArrayList<RowSearchDistributionBean>();
	init();
	String orderBy = " STATE_DATE DESC";

	/*
	 * if (FacesContext.getCurrentInstance().getMessageList() != null &&
	 * FacesContext.getCurrentInstance().getMessageList().size() > 0) {
	 * RequestContext.getCurrentInstance().addCallbackParam("isErrors",
	 * true); this.setRowCount(0); return new
	 * ArrayList<RowSearchDistributionBean>(); } else {
	 */
	if (sortField != null) {
	    orderBy = sortField;
	    if (sortOrder != null) {
		orderBy += ESPACIO +
		    sortOrder.name().substring(
			sortOrder.name().length() -
			    LENGTHMINUS, sortOrder.name().length() - 1) + ESPACIO;
	    }
	}

	/*
	 * if (firstVar != 0) { firstVar++; }
	 */
	try {
	    DistributionResultsBean result = getDistribution(
		useCaseConf, firstVar, orderBy);
	    this.setRowCount(result.getTotalSize());
	    data = result.getRows();
	}
	catch (DistributionException distributionException) {
	    LOG.error(
		ErrorConstants.GET_DISTRIBUTION_ERROR_MESSAGE, distributionException);
	    // Utils.redirectToErrorPage(null, distributionException, null);
	}
	catch (SessionException sessionException) {
	    LOG.error(
		ErrorConstants.GET_DISTRIBUTION_ERROR_MESSAGE, sessionException);
	    // Utils.redirectToErrorPage(null, sessionException, null);
	}
	catch (ValidationException validationException) {
	    LOG.error(
		ErrorConstants.GET_DISTRIBUTION_ERROR_MESSAGE, validationException);
	    // Utils.redirectToErrorPage(null, validationException, null);
	}
	// }
	return data;
    }

    /**
     * Devuelve con un identificador el objeto fila correspondiente del
     * datatable.
     * 
     * @param rowKey
     *            Identificador de la fila a devolver.
     * 
     * @return Fila del datatable con el identificador solicitado.
     */
    @Override
    public RowSearchDistributionBean getRowData(
	String rowKey) {
	@SuppressWarnings("unchecked")
	List<RowSearchDistributionBean> rowSearchDistributionBeans =
	    (List<RowSearchDistributionBean>) getWrappedData();
	RowSearchDistributionBean result = null;

	Iterator<RowSearchDistributionBean> iterator = rowSearchDistributionBeans.iterator();
	RowSearchDistributionBean rowSearchDistributionBean;
	while (iterator.hasNext() &&
	    result == null) {
	    rowSearchDistributionBean = iterator.next();
	    if (rowSearchDistributionBean.getId().equals(
		new Integer(
		    rowKey))) {
		result = rowSearchDistributionBean;
	    }
	}
	return result;
    }

    /**
     * Devuelve el identificador de la fila pasada como par�metro.
     * 
     * @param rowSearchDistributionBean
     *            objeto fila.
     * 
     * @return rowSearchDistributionBean.getFdrid() El identificador de la fila.
     */
    @Override
    public Object getRowKey(
	RowSearchDistributionBean rowSearchDistributionBean) {
	return rowSearchDistributionBean.getId();
    }

    /**
     * Introduce el n�mero de fila seleccionada.
     * 
     * @param rowIndex
     *            fila seleccionada.
     */
    @Override
    public void setRowIndex(
	int rowIndex) {
	if (rowIndex == -1 ||
	    getPageSize() == 0) {
	    super.setRowIndex(-1);
	}
	else {
	    super.setRowIndex(rowIndex %
		getPageSize());
	}
    }

    /**
     * M�todo que construye la query y controla los permisos para la b�squeda de
     * la distribuci�n.
     * 
     * @param useCaseConf
     *            configuraci�n de la aplicaci�n.
     * @param firstRow
     *            primera fila.
     * @param sortField
     *            campo que ordena.
     * @return objeto con los datos necesarios para la b�squeda.
     * @throws ValidationException
     *             error en la validaci�n.
     * @throws DistributionException
     *             error en la distribuci�n.
     * @throws SessionException
     *             error de sesi�n
     */
    public DistributionResultsBean getDistribution(
	UseCaseConf useCaseConf, int firstRow, String sortField)
	throws ValidationException, DistributionException, SessionException {

	Validator.validate_String_NotNull_LengthMayorZero(
	    useCaseConf.getSessionID(), ValidationException.ATTRIBUTE_SESSION);
	distributionBo = new DistributionBo();

	boolean isOfficeAsoc = Boolean.valueOf(
	    Configurator.getInstance().getProperty(
		ConfigurationKeys.KEY_DESKTOP_DISTRIBUTION_OFFICE_ASOC)).booleanValue();

	int pageSize = Integer.parseInt(Configurator.getInstance().getProperty(
	    ConfigurationKeys.KEY_DESKTOP_DEFAULT_PAGE_TABLE_RESULTS_SIZE));

	DistributionResultsBean distributionResults = distributionBo.getDistribution(
	    useCaseConf, searchDistributionRegister, firstRow, pageSize, isOfficeAsoc, sortField);

	LOG.debug("distributionResults.getTotalSize():" +
	    distributionResults.getTotalSize());
	return distributionResults;
    }

    /**
     * Obtiene el valor del par�metro page.
     * 
     * @return page valor del campo a obtener.
     */
    public int getPage() {
	return page;
    }

    /**
     * Guarda el valor del par�metro page.
     * 
     * @param page
     *            valor del campo a guardar.
     */
    public void setPage(
	int page) {
	this.page = page;
    }

    /**
     * Obtiene el valor del par�metro searchDistributionRegister.
     * 
     * @return searchDistributionRegister valor del campo a obtener.
     */
    public SearchDistributionBean getSearchDistributionRegister() {
	return searchDistributionRegister;
    }

    /**
     * Guarda el valor del par�metro searchDistributionRegister.
     * 
     * @param searchDistributionRegister
     *            valor del campo a guardar.
     */
    public void setSearchDistributionRegister(
	SearchDistributionBean searchDistributionRegister) {
	this.searchDistributionRegister = searchDistributionRegister;
    }

    /**
     * Obtiene en n�mero de resultados de la b�squeda.
     * 
     * @return int el n�mero de resultados.
     * @throws RPDistributionException
     *             error en la distribuci�n.
     * @throws RPGenericException
     *             error gen�rico.
     */
    public int countSearchDistributionRegister()
	throws RPDistributionException, RPGenericException {
	try {
	    Validator.validate_String_NotNull_LengthMayorZero(
		useCaseConf.getSessionID(), ValidationException.ATTRIBUTE_SESSION);
	}
	catch (ValidationException validationException) {
	    LOG.error(
		ErrorConstants.ATTRIBUTES_ERROR_MESSAGE, validationException);
	    throw new RPGenericException(
		RPGenericErrorCode.ATTRIBUTES_ERROR, ErrorConstants.ATTRIBUTES_ERROR_MESSAGE,
		validationException);
	}
	distributionBo = new DistributionBo();

	boolean isOfficeAsoc = Boolean.valueOf(
	    Configurator.getInstance().getProperty(
		ConfigurationKeys.KEY_DESKTOP_DISTRIBUTION_OFFICE_ASOC)).booleanValue();

	int totalDistr = distributionBo.countSearchDistributionRegister(
	    useCaseConf, searchDistributionRegister, isOfficeAsoc);

	LOG.debug("countSearchDistributionRegister():" +
	    totalDistr);
	return totalDistr;

    }


}