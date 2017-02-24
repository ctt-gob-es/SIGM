/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.sgm.registropresencial.config;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Clase que inicializa el contexto de spring.
 * 
 * @author jortizs
 * 
 */
public class RegistroPresencialMSSSIWebSpringApplicationContext {

    private static final String DEFAULT_CONFIG_FILE = "classpath:beans/SIGEM_RegistroPresencialMSSSIWeb/applicationContext.xml";

    private static final Logger logger = Logger
	    .getLogger(RegistroPresencialMSSSIWebSpringApplicationContext.class);

    private ApplicationContext contenedor;

    protected static RegistroPresencialMSSSIWebSpringApplicationContext _instance = null;

    /**
     * Constructor.
     */
    public RegistroPresencialMSSSIWebSpringApplicationContext() {
	try {
	    // Instanciamos el contenedor de Spring
	    contenedor = new ClassPathXmlApplicationContext(DEFAULT_CONFIG_FILE);
	}
	catch (Throwable e) {
	    logger.error("Error cargando propiedades de configuraci�n iniciales.", e);
	}
    }

    /**
     * Devuelve la instacia del objecto.
     * 
     * @return Dir3WSSpringApplicationContext instancia del objecto.
     */
    public synchronized static RegistroPresencialMSSSIWebSpringApplicationContext getInstance() {
	if (_instance == null) {
	    _instance = new RegistroPresencialMSSSIWebSpringApplicationContext();
	}

	return _instance;
    }

    /**
     * Devuelve el contexto de la aplicaci�n.
     * 
     * @return ApplicationContext contexto de la aplicaci�n.
     */
    public ApplicationContext getApplicationContext() {
	return contenedor;
    }

    /**
     * Recoge el contexto de la aplicaci�n.
     * 
     * @param appContext
     *            contexto de la aplicaci�n.
     */
    public void setApplicationContext(ApplicationContext appContext) {
	contenedor = appContext;
    }
}