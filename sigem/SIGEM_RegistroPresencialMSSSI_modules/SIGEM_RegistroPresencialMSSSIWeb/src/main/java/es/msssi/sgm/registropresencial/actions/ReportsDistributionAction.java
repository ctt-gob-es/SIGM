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

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.model.StreamedContent;

import com.ieci.tecdoc.common.invesicres.ScrOrg;

import es.msssi.sgm.registropresencial.beans.DistributionResultsBean;
import es.msssi.sgm.registropresencial.beans.SearchDistributionBean;
import es.msssi.sgm.registropresencial.businessobject.ReportsDistributionBo;
import es.msssi.sgm.registropresencial.utils.Utils;

/**
 * Clase que genera los informes relacionados con registros de entrada de la
 * aplicaci�n.
 * 
 * @author jortizs
 */
public class ReportsDistributionAction extends GenericActions implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(ReportsDistributionAction.class.getName());

    /** Bean con los criterios del buscador. */
    private SearchDistributionBean searchDistributionBean = new SearchDistributionBean();
    /** Clase con la l�gica de negocio. */
    private ReportsDistributionBo reportsBo;
    /**
     * objeto que contiene el fichero.
     */
    private StreamedContent file;
    
    /**
     * Constructor.
     */
    public ReportsDistributionAction() {
	reportsBo = new ReportsDistributionBo();
    }

    /**
     * Construye los informes de la aplicaci�n correspondientes a relaciones,
     * por origen y destino, de distribuciones de registros seg�n una fecha
     * marcada.
     */
    public void buildRelationsReport() {
	LOG.trace("Entrando en ReportsDistributionAction.buildRelationsReport()");
	try {
	    init();
	    DistributionResultsBean distributionList =
		reportsBo.getRegistersForRelationReports(searchDistributionBean);
	    LOG.info("Obtenidos " +
		distributionList.getTotalSize() + " registros.");
	    if (distributionList == null ||
		distributionList.getTotalSize() <= 0) {
		FacesContext.getCurrentInstance().addMessage(
		    null,
		    new FacesMessage(
			FacesMessage.SEVERITY_WARN, "Generaci�n de informe ",
			"No hay registros que cumplan con los requisitos de b�squeda"));
	    }
	    else {
		// Se construye y devuelve el informe
		file = reportsBo.buildJasperReport(distributionList);
	    }
	}
	catch (Exception exception) {
	    LOG.error(
		"Error al generar el informe: ", exception);
	    Utils.redirectToErrorPage(
		null, null, exception);
	}
    }

    /**
     * Devuelve el searchDistributionBean.
     * 
     * @return searchDistributionBean el objeto searchDistributionBean.
     */
    public SearchDistributionBean getSearchDistributionBean() {
	return searchDistributionBean;
    }

    /**
     * Recibe el objeto searchDistributionBean.
     * 
     * @param searchDistributionBean
     *            el objeto searchDistributionBean.
     */
    public void setSearchDistributionBean(
	SearchDistributionBean searchDistributionBean) {
	this.searchDistributionBean = searchDistributionBean;
    }
    
    /**
     * M�todo que actualiza el campo origen con el valor seleccionado en la
     * b�squeda avanzada de organismos.
     */
    public void updateOrigin() {
	ScrOrg unidad = null;
	if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(
	    "UNITSDIALOG") != null) {
	    unidad =
		(ScrOrg) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
		    .get(
			"UNITSDIALOG");
	    getSearchDistributionBean().setFld7(
		unidad);
	}
    }

    /**
     * M�todo que actualiza el campo destino con el valor seleccionado en la
     * b�squeda avanzada de organismos.
     */
    public void updateDestination() {
	ScrOrg unidad = null;
	if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(
	    "UNITSDIALOG") != null) {
	    unidad =
		(ScrOrg) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
		    .get(
			"UNITSDIALOG");
	    getSearchDistributionBean().setFld8(
		unidad);
	}
    }
    
    
    /**
     * Devuelve el file.
     * 
     * @return file el objeto file.
     */
    public StreamedContent getFile() {
        return file;
    }
    
    /**
     * M�todo resetea los mensajes.
     */
    public void reset(){
	
    }
}