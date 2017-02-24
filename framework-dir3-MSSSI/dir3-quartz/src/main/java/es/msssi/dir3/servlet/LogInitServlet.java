/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.dir3.servlet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.xml.parsers.FactoryConfigurationError;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Servlet para inicializacion del sistema de log.
 * 
 * @author cmorenog
 * 
 */
public class LogInitServlet extends HttpServlet {

    private static final long serialVersionUID = 3670060639612458896L;

    /**
     * Fichero de log de la aplicacion.
     */
    private static final String FILECONFIG = "FILECONFIG";

    /**
     * Path de repositorio.
     */
    private static final String PATHREPO = "PATH_REPO";

    /**
     * Path de config.
     */
    private static final String SUBDIRCONFIG = "SUBDIRCONFIG";
    /**
     * Path de logs.
     */
    private static final String SUBDIRLOGS = "SUBDIRLOGS";

    private static final String SLASH = "/";

    /**
     * Crea un nuevo LogInitServlet.
     */
    public LogInitServlet() {
    }

    /**
     * En el arranque de la aplicacion se carga la configuracion de log de la
     * aplicacion.
     * 
     * @throws ServletException
     *             Si se produce un error en la inicializaci�n del sistema.
     */
    public void init()
	throws ServletException {
	try {

	    String fileName = getServletConfig().getInitParameter(
		FILECONFIG);
	    String subDirConfig = getServletConfig().getInitParameter(
		SUBDIRCONFIG);
	    String pathRepo = getPathRepo();
	    String pathLogs = pathRepo +
		getServletConfig().getInitParameter(
		    SUBDIRLOGS);
	    // init log4j
	    initLog4j(
		pathRepo, subDirConfig, pathLogs, fileName);
	    Logger.getLogger(
		LogInitServlet.class).info(
		"Log4j cargado [" +
		    fileName + "]");
	    super.init();
	}
	catch (Throwable t) {
	    Logger.getLogger(
		LogInitServlet.class).info(
		"Log4j error en la inicializaci�n");
	}
    }

    /**
     * Inicializa el log4j.
     * @param pathRepo
     * 		path del repositorio.
     * @param subDirConfig
     * 		ruta relativa de los archivos de configuraci�n.
     * @param pathLogs
     * 		path de los logs.
     * @param fileName
     * 		fichero de log.
     * @throws FactoryConfigurationError .
     */
    private static void initLog4j(
	String pathRepo, String subDirConfig, String pathLogs, String fileName)
	throws FactoryConfigurationError {
	String log4jConfigFile = new StringBuilder(
	    pathRepo).append(
	    subDirConfig).append(
	    SLASH).append(
	    fileName).toString();
	System.setProperty(
	    "sigm.log.path.quartz", pathLogs);
	DOMConfigurator.configure(log4jConfigFile);
    }

    /**
     * Ruta del repositorio.
     * @return ruta del repositorio.
     * @throws NamingException .
     */
    private String getPathRepo()
	throws NamingException {
	Context env;
	String path = null;
	env = (Context) new InitialContext().lookup("java:comp/env");
	path = (String) env.lookup(PATHREPO);
	return path;
    }
}