/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.sgm.registropresencial.utils;

import ieci.tecdoc.sgm.core.admin.web.AutenticacionBackOffice;
import ieci.tecdoc.sgm.core.services.gestion_backoffice.ConstantesGestionUsuariosBackOffice;
import ieci.tecdoc.sgm.sesiones.backoffice.ws.client.Sesion;

import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.ieci.tecdoc.common.exception.BookException;
import com.ieci.tecdoc.common.exception.SecurityException;
import com.ieci.tecdoc.common.exception.SessionException;
import com.ieci.tecdoc.common.exception.TecDocException;
import com.ieci.tecdoc.common.exception.ValidationException;
import com.ieci.tecdoc.common.isicres.SessionInformation;
import com.ieci.tecdoc.common.keys.ConfigurationKeys;
import com.ieci.tecdoc.common.keys.ServerKeys;
import com.ieci.tecdoc.common.utils.Configurator;
import com.ieci.tecdoc.common.utils.ISicresGenPerms;
import com.ieci.tecdoc.isicres.desktopweb.Keys;
import com.ieci.tecdoc.isicres.session.book.BookSession;
import com.ieci.tecdoc.isicres.usecase.UseCaseConf;
import com.ieci.tecdoc.isicres.usecase.security.SecurityUseCase;
import com.ieci.tecdoc.utils.cache.CacheBag;
import com.ieci.tecdoc.utils.cache.CacheFactory;

import es.ieci.tecdoc.fwktd.core.spring.configuration.jdbc.datasource.MultiEntityContextHolder;
import es.msssi.sgm.registropresencial.errors.ErrorConstants;
import es.msssi.sgm.registropresencial.errors.RPBookErrorCode;
import es.msssi.sgm.registropresencial.errors.RPBookException;
import es.msssi.sgm.registropresencial.errors.RPGenericErrorCode;
import es.msssi.sgm.registropresencial.errors.RPGenericException;

/**
 * Clase con m�todos de apoyo para la autenticaci�n del usuario y la entidad.
 * 
 * @author cmorenog
 */
public class AuthenticationHelper {
    private static final Logger LOG = Logger.getLogger(AuthenticationHelper.class);
    private static final long NUMIDIOMA = 10;

    /**
     * Autentica a un usuario para poder acceder a la aplicaci�n.
     * 
     * @param request
     *            Petici�n HTTP con todos los datos necesarios para
     *            autenticarse.
     * 
     * @return booleano si la autenticaci�n es correcta.
     * 
     * @throws RPGenericException
     *             Si se ha producido un error gen�rico.
     * 
     * @throws RPBookException
     *             Si se ha producido un error al tratar el libro.
     */
    public static boolean authenticate(
	HttpServletRequest request)
	throws RPGenericException, RPBookException {
	LOG.trace("Entrando en AuthenticationHelper.authenticate()");
	boolean isAuthenticated = false;
	String entidad = null;
	UseCaseConf ucc = (UseCaseConf) request.getSession().getAttribute(
	    Keys.J_USECASECONF);
	if (ucc == null) {
	    ucc = new UseCaseConf();
	}
	// Synchronized Si mandamos m�s de una petici�n para la misma sesi�n
	// pueden haber problemas de concurrencia en el Servicio Web

	String keySession = (String) request.getSession().getAttribute(
	    ConstantesGestionUsuariosBackOffice.PARAMETRO_KEY_SESION_USUARIO);

	if (keySession == null) {
	    keySession = request.getSession().getId();
	}

	synchronized (keySession) {
	    if (autenticar(request)) {
		if (ucc.getUserName() == null) {
		    Sesion sesion = obtenerDatos(request);
		    entidad = sesion.getIdEntidad();
		    if (entidad != null) {
			request.getSession().setAttribute(
			    ConstantesGestionUsuariosBackOffice.PARAMETRO_ID_ENTIDAD, entidad);
		    }
		    else {
			ucc.setEntidadId("000");
		    }
		    ucc.setSessionID(sesion.getIdSesion());
		    ucc.setLocale(new Locale ("es","ES",""));
		    ucc.setEntidadId(sesion.getIdEntidad());
		    ucc.setUserName(sesion.getUsuario());

		    // Texto del idioma. Ej: EU_
		    String idioma = "ES_";

		    // Obtenemos el locale java para el c�digo de idioma
		    // seleccionado por el usuario.
		    // (Locale) microsoftLocalesID2DefaultLocales
		    // .get(numIdioma);
		    Locale locale;
		    locale = new Locale ("es","ES","");
		    ucc.setLocale(locale);
		    // True se usa LDAP.
		    ucc.setUseLdap(Boolean.FALSE);
		    // True se usa LDAP SSO.
		    ucc.setUsingOSAuth(Boolean.FALSE);
		    // ucc.setEntidadId("000");
		    // Nombre del usuario.
		    String name = null;
		    name = ucc.getUserName();
		    if (ucc != null &&
			name.length() != 0) {
			try {
			    ucc.setUserName(name);

			    SecurityUseCase securityUseCase = new SecurityUseCase();
			    // Validaci�n del usuario.
			    securityUseCase.login(
				ucc, name, "");
			    CacheBag cacheBag = CacheFactory.getCacheInterface().getCacheEntry(
				ucc.getSessionID());
			    ISicresGenPerms permisos =
				(ISicresGenPerms) cacheBag.get(ServerKeys.GENPERMS_USER);

			    if ((ucc.getSessionID() != null) &&
				(ucc.getEntidadId() != null)) {

				SessionInformation sessionInformation =
				    BookSession.getSessionInformation(
					ucc.getSessionID(), ucc.getLocale(), ucc.getEntidadId());

				request.getSession().setAttribute(
				    KeysRP.J_SESSIONINF, sessionInformation);
				if (cacheBag.get(ServerKeys.LAST_CONNECTION_USER)!= null){
				    request.getSession().setAttribute(
					ServerKeys.LAST_CONNECTION_USER, (Date)cacheBag.get(ServerKeys.LAST_CONNECTION_USER));
				}
			    }
			    request
				.getSession()
				.setAttribute(
				    KeysRP.J_ENABLEDINTREGISTRAL,
				    Configurator
					.getInstance()
					.getProperty(
					    ConfigurationKeys.KEY_INTERCAMBIO_ENABLE_INTERCAMBIO_REGISTRAL));
			    request.getSession().setAttribute(
				Keys.J_USECASECONF, ucc);
			    request.getSession().setAttribute(
				KeysRP.J_PERMSUSER, permisos);

			    request.getSession().setAttribute(
				Keys.J_IDIOMA, idioma);
			    request.getSession().setAttribute(
				Keys.J_NUM_IDIOMA, Long.valueOf(NUMIDIOMA));
			  
			    // seteamos al thread local
			    MultiEntityContextHolder.setEntity((String) request.getSession()
				.getAttribute(
				    ConstantesGestionUsuariosBackOffice.PARAMETRO_ID_ENTIDAD));
			}
			catch (ValidationException validationException) {
			    LOG.error(
				ErrorConstants.AUTHENTICATION_ERROR_MESSAGE, validationException);
			    throw new RPGenericException(
				RPGenericErrorCode.PARAMETER_VALIDATION_ERROR,
				ErrorConstants.PARAMETERS_VALIDATION_ERROR_MESSAGE,
				validationException);
			}
			catch (BookException bookException) {
			    LOG.error(
				ErrorConstants.AUTHENTICATION_ERROR_MESSAGE, bookException);
			    throw new RPBookException(
				RPBookErrorCode.GET_SESSION_BOOK_ERROR,
				ErrorConstants.GET_SESSION_INFORMATION_BOOK_ERROR_MESSAGE,
				bookException);
			}
			catch (SessionException sessionException) {
			    LOG.error(
				ErrorConstants.AUTHENTICATION_ERROR_MESSAGE, sessionException);
			    throw new RPGenericException(
				RPGenericErrorCode.SESSION_ERROR,
				ErrorConstants.SESSION_ERROR_MESSAGE, sessionException);
			}
			catch (TecDocException tecDocException) {
			    LOG.error(
				ErrorConstants.AUTHENTICATION_ERROR_MESSAGE, tecDocException);
			    if(tecDocException instanceof SecurityException)
			    	throw new RPGenericException(RPGenericErrorCode.SESSION_ERROR,ErrorConstants.WITHOUT_PERMITS_ERROR_MESSAGE, tecDocException);
			    else
			    	throw new RPGenericException(RPGenericErrorCode.SESSION_ERROR,ErrorConstants.SESSION_ERROR_MESSAGE, tecDocException);
			}
			catch (Throwable throwable) {
			    LOG.error(
				ErrorConstants.AUTHENTICATION_ERROR_MESSAGE, throwable);
			    throw new RPGenericException(
				RPGenericErrorCode.SESSION_ERROR,
				ErrorConstants.SESSION_ERROR_MESSAGE, throwable);
			}
		    }
		}
		isAuthenticated = true;
	    }
	}
	return isAuthenticated;
    }

    /**
     * Desloguea al usuario en la aplicaci�n.
     * 
     * @param request
     *            Respuesta HTTP con los datos para cerrar la sesi�n del
     *            usuario.
     * 
     * @throws RPGenericException
     *             Si se ha producido un error gen�rico.
     */
    public static void logout(
	HttpServletRequest request)
	throws RPGenericException {
	LOG.trace("Entrando en AuthenticationHelper.logout()");
	SecurityUseCase securityUseCase = new SecurityUseCase();
	// Salida de la sesi�n
	UseCaseConf useCaseConf = (UseCaseConf) request.getSession().getAttribute(
	    Keys.J_USECASECONF);
	try {
	    securityUseCase.logout(useCaseConf);
	    request.getSession().invalidate();
	}
	catch (SecurityException securityException) {
	    LOG.error(
		ErrorConstants.CLOSE_SESSION_ERROR_MESSAGE, securityException);
	    throw new RPGenericException(
		RPGenericErrorCode.SESSION_ERROR, ErrorConstants.CLOSE_SESSION_ERROR_MESSAGE,
		securityException);
	}
    }

    /**
     * Autentica al usuario.
     * 
     * @param request
     *            Petici�n HTTP con los datos necesarios para hacer login.
     * 
     * @return true si el usuario est� autenticado.
     */
    private static boolean autenticar(
	HttpServletRequest request) {

	String key =
	    request.getParameter(ConstantesGestionUsuariosBackOffice.PARAMETRO_KEY_SESION_USUARIO);
	if (AutenticacionBackOffice.isNuloOVacio(key)) {
	    key = (String) request.getSession().getAttribute(
		ConstantesGestionUsuariosBackOffice.PARAMETRO_KEY_SESION_USUARIO);
	}
	String name = request.getParameter(ConstantesGestionUsuariosBackOffice.PARAMETRO_USUARIO);
	if (AutenticacionBackOffice.isNuloOVacio(name)) {
	    name = (String) request.getSession().getAttribute(
		ConstantesGestionUsuariosBackOffice.PARAMETRO_USUARIO);
	}
	if (AutenticacionBackOffice.isNuloOVacio(key) ||
	    AutenticacionBackOffice.isNuloOVacio(name)) {
	    return false;
	}
	else {
	    request.getSession().setAttribute(
		ConstantesGestionUsuariosBackOffice.PARAMETRO_KEY_SESION_USUARIO, key);
	    request.getSession().setAttribute(
		ConstantesGestionUsuariosBackOffice.PARAMETRO_USUARIO, name);
	    return true;
	}
    }

    /**
     * Obtiene datos de la sesi�n del usuario.
     * 
     * @param request
     *            Petici�n HTTP con los datos necesarios para hacer login.
     * 
     * @return Sesion del usuario.
     */
    public static Sesion obtenerDatos(
	HttpServletRequest request) {

	String key =
	    request.getParameter(ConstantesGestionUsuariosBackOffice.PARAMETRO_KEY_SESION_USUARIO);
	if (AutenticacionBackOffice.isNuloOVacio(key)) {
	    key = (String) request.getSession().getAttribute(
		ConstantesGestionUsuariosBackOffice.PARAMETRO_KEY_SESION_USUARIO);
	}
	String name = request.getParameter(ConstantesGestionUsuariosBackOffice.PARAMETRO_USUARIO);
	if (AutenticacionBackOffice.isNuloOVacio(name)) {
	    name = (String) request.getSession().getAttribute(
		ConstantesGestionUsuariosBackOffice.PARAMETRO_USUARIO);
	}
	if (AutenticacionBackOffice.isNuloOVacio(key) ||
	    AutenticacionBackOffice.isNuloOVacio(name)) {
	    return null;
	}
	else {
	    Sesion newSesion = new Sesion();
	    newSesion.setDatosEspecificos(null);
	    newSesion.setIdEntidad("000");
	    newSesion.setIdSesion(key);
	    newSesion.setUsuario(name);
	    return newSesion;
	}
    }

    /**
     * Obtiene la URL de login.
     * 
     * @param request
     *            Petici�n HTTP con los datos necesarios para hacer login.
     * 
     * @return String con la url de login.
     */
    public static String getWebAuthURL(
	HttpServletRequest request) {
	LOG.trace("Entrando en AuthenticationHelper.getWebAuthURL()");
	request.setAttribute(
	    ConstantesGestionUsuariosBackOffice.PARAMETRO_ID_ENTIDAD, "000");
	return AutenticacionBackOffice.obtenerUrlLogin(
	    request, "RP");
    }
}