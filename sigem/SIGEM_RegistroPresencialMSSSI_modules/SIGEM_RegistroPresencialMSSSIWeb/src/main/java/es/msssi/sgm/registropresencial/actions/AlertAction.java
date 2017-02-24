/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.sgm.registropresencial.actions;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.ieci.tecdoc.common.exception.DistributionException;
import com.ieci.tecdoc.common.exception.SessionException;
import com.ieci.tecdoc.common.exception.ValidationException;

import es.msssi.sgm.registropresencial.businessobject.DistributionBo;
import es.msssi.sgm.registropresencial.errors.ErrorConstants;
import es.msssi.sgm.registropresencial.utils.Utils;

/**
 * Action que contiene m�todos para la gesti�n de la distribuci�n.
 * 
 * @author cmorenog
 * */
public class AlertAction extends GenericActions {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(AlertAction.class.getName());
    /** clase de negocio de distribuci�n. */
    private DistributionBo distributionBo;
    /** alertas de distribuci�n. */
    private List<String> alertDistribution;

    /**
     * Constructor.
     */
    public AlertAction() {
    }

    /**
     * M�todo que muestra las alertas de distribuci�n y las a�ade como mensajes
     * al contexto.
     */
    public void showAlertDistribution() {
	// mostramos las alertas de la distribuci�n
	if (distributionBo == null) {
	    distributionBo = new DistributionBo();
	}
	try {
	    alertDistribution = distributionBo.getListMessageInit(useCaseConf);
	    if (alertDistribution != null &&
		alertDistribution.size() > 0) {
		for (int cont = 0; cont < alertDistribution.size(); cont++) {
		    FacesContext.getCurrentInstance().addMessage(
			null, new FacesMessage(
			    FacesMessage.SEVERITY_INFO, "", alertDistribution.get(cont)));
		}
	    }
	}
	catch (SessionException sessionException) {
	    LOG.error(
		ErrorConstants.SHOW_DISTRIBUTION_ALERTS_ERROR_MESSAGE, sessionException);
	    Utils.redirectToErrorPage(
		null, sessionException, null);
	}
	catch (ValidationException validationException) {
	    LOG.error(
		ErrorConstants.SHOW_DISTRIBUTION_ALERTS_ERROR_MESSAGE, validationException);
	    Utils.redirectToErrorPage(
		null, validationException, null);
	}
	catch (DistributionException distributionException) {
	    LOG.error(
		ErrorConstants.SHOW_DISTRIBUTION_ALERTS_ERROR_MESSAGE, distributionException);
	    Utils.redirectToErrorPage(
		null, distributionException, null);
	}
    }

    /**
     * Obtiene el valor del par�metro alertDistribution.
     * 
     * @return alertDistribution valor del campo a obtener.
     */
    public List<String> getAlertDistribution() {
	return alertDistribution;
    }

    /**
     * Guarda el valor del par�metro alertDistribution.
     * 
     * @param alertDistribution
     *            valor del campo a guardar.
     */
    public void setAlertDistribution(
	List<String> alertDistribution) {
	this.alertDistribution = alertDistribution;
    }

}
