package ieci.tecdoc.sgm.core.config.impl.spring;

import ieci.tecdoc.sgm.core.config.Configuration;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Config implements Configuration {

	private static final String DEFAULT_CONFIG_FILE 	= "SIGEM_spring.xml";

	private static final Logger logger = Logger.getLogger(Config.class);

	private ApplicationContext contenedor;
	
	public Config(){
		try {
			// Instanciamos el contenedor de Spring
			contenedor = new ClassPathXmlApplicationContext(DEFAULT_CONFIG_FILE);
		} catch (Throwable e) {
			logger.error("Error cargando propiedades de configuraci�n iniciales.", e);
		}		
	}

	public Config(String psConfigFile){
		try {
			// Instanciamos el contenedor de Spring
			contenedor = new ClassPathXmlApplicationContext(psConfigFile);
		} catch (Throwable e) {
			logger.error("Error cargando propiedades de configuraci�n iniciales.", e);
		}		
	}

	public Config(String[] psConfigFiles){
		try {
			// Instanciamos el contenedor de Spring
			contenedor = new ClassPathXmlApplicationContext(psConfigFiles);
		} catch (Throwable e) {
			logger.error("Error cargando propiedades de configuraci�n iniciales.", e);
		}		
	}

	public Object getBean(String pcBeanName) throws Exception {
		Object object = null;
		try{
			object = contenedor.getBean(pcBeanName);
		}catch(BeansException e){
			StringBuffer sbError = new StringBuffer("Error obteniendo instancia del bean: ");
			sbError.append(pcBeanName);
			logger.error(sbError.toString(), e);
			throw new Exception(sbError.toString(), e);
		}
		
		return object;
	}
	
	public ApplicationContext getApplicationContext(){
		return contenedor;
	}
	
	public void setApplicationContext(ApplicationContext appContext){
		contenedor=appContext;
	}
}
