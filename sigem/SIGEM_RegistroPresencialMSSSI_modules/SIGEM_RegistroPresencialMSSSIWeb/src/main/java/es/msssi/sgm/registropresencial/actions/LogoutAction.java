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

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import es.msssi.sgm.registropresencial.beans.WebParameter;
import es.msssi.sgm.registropresencial.errors.ErrorConstants;
import es.msssi.sgm.registropresencial.errors.RPGenericException;
import es.msssi.sgm.registropresencial.utils.AuthenticationHelper;
import es.msssi.sgm.registropresencial.utils.Utils;

/**
 * Action para desloguerase de la aplicaci�n.
 * 
 * @author cmorenog
 * 
 */
public class LogoutAction extends GenericActions {
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(LogoutAction.class.getName());
    private static String urlLogOut = null;

    static {
	urlLogOut = (String) WebParameter.getEntryParameter("URLLogOut");
    }

    /**
     * Obtiene el par�metro urlLogout del web.xml.
     */
    @PostConstruct
    public void create() {
	urlLogOut = (String) WebParameter.getEntryParameter("URLLogOut");
    }

    /**
     * Desloguea al usuario le redirecciona a la p�gina de desconexi�n.
     */
    public void logOut() {
	LOG.trace("Entrando en LogoutAction.logOut()");
	try {
	    AuthenticationHelper.logout((HttpServletRequest) FacesContext.getCurrentInstance()
		.getExternalContext().getRequest());
	    FacesContext.getCurrentInstance().getExternalContext().redirect(
		urlLogOut +
		    "?desconectar=S");
	}
	catch (RPGenericException rpGenericException) {
	    LOG.error(ErrorConstants.CLOSE_SESSION_ERROR_MESSAGE +
		". C�digo: " + rpGenericException.getCode().getCode() + " . Mensaje: " +
		rpGenericException.getShortMessage());
	    Utils.redirectToErrorPage(
		rpGenericException, null, null);
	}
	catch (IOException ioException) {
	    LOG.error(
		ErrorConstants.NULL_PAGE_TO_REDIRECT_ERROR_MESSAGE +
		    ": " + urlLogOut, ioException);
	}
    }

    /**
     * Obtiene el valor del par�metro urlLogOut.
     * 
     * @return urlLogOut valor del campo a obtener.
     */
    public static String getUrlLogOut() {
	return urlLogOut;
    }

    /**
     * Guarda el valor del par�metro urlLogOut.
     * 
     * @param urlLogOut
     *            valor del campo a guardar.
     */
    public static void setUrlLogOut(
	String urlLogOut) {
	LogoutAction.urlLogOut = urlLogOut;
    }
}