/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.sigm.core.init;

import java.util.Enumeration;
import java.util.HashMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.springframework.web.context.support.WebApplicationContextUtils;

import core.Core;
import core.security.BouncyCastle;
import es.msssi.sgm.registropresencial.beans.WebParameter;

/**
 * Clase inicial que carga las propiedades para los servicios web.
 * 
 * @author jortizs
 */
public class ApplicationListener implements ServletContextListener {
    private static final Logger LOG = Logger.getLogger(ApplicationListener.class.getName());
    private static String propertiesPath = null;

    /**
     * Carga las propiedades en el contexto de la aplicaci�n.
     * 
     * @param arg0
     *            Contexto de la aplicaci�n.
     */
    public void contextInitialized(ServletContextEvent arg0) {
	LOG.trace("Inicializando contexto y cargando los archivos de propiedades");
	ServletContext sc = arg0.getServletContext();
	initParameters(sc);
//	propertiesPath =
//		(String) WebParameter.getEntryParameter("PATH_REPO")
//			+ (String) WebParameter
//				.getEntryParameter("MSSSIPATH_regtel.properties.path");
//	if (PropertiesLoader.getInstance().getPropertiesDir() == null) {
//	    PropertiesLoader.getInstance().setPropertiesDir(propertiesPath);
//	}
	
//	new ClassPathXmlApplicationContext("classpath*:spring-config.xml");
	
	LOG.info("Carga el proveedor de Bouncy Castle");
	BouncyCastle.removeAndInsert();
    }

    /**
     * M�todo no utilizado, v�lido en el momento de la destrucci�n del contexto
     * de la aplicaci�n.
     * 
     * @param arg0
     *            Contexto de la aplicaci�n.
     */
    public void contextDestroyed(ServletContextEvent arg0) {
    }

    /**
     * Inicia con el contexto de aplicaci�n.
     * 
     * @param context
     *            ServletContext principal de la aplicaci�n web.
     * 
     * @throws NamingException.
     */
    @SuppressWarnings("unchecked")
    private void initParameters(ServletContext context) {
	LOG.trace("Entrando en Utils.initParameters()"
		+ " para iniciar el contexto de la aplicaci�n");
	Enumeration<String> e = context.getInitParameterNames();
	HashMap<String, String> initParameters = new HashMap<String, String>();
	String key = null;
	while (e.hasMoreElements()) {
	    key = e.nextElement();
	    initParameters.put(key, context.getInitParameter(key));
	}
	WebParameter.setInitParameters(initParameters);
	try {
	    Context inicial = new InitialContext();
	    Context miCtx = (Context) inicial.lookup("java:comp/env");
	    HashMap<String, Object> entryParameters = new HashMap<String, Object>();
	    Enumeration<NameClassPair> namingE = miCtx.list("");
	    while (namingE.hasMoreElements()) {
		key = ((NameClassPair) namingE.nextElement()).getName();
		entryParameters.put(key, miCtx.lookup(key));
	    }
	    WebParameter.setEntryParameters(entryParameters);
	}
	catch (NamingException namingException) {
	    LOG.error("Error al crear el contexto principal de la aplicaci�n", namingException);
	}
    }
}