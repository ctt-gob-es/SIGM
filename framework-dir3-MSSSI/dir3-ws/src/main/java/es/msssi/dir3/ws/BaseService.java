/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.dir3.ws;

import javax.annotation.Resource;
import javax.xml.ws.WebServiceContext;

/**
 * Clase abstracta de la que extenderan los servicios web de dir3.
 * 
 * @author cmorenog
 * 
 */
public abstract class BaseService {

    @Resource
    private WebServiceContext wsContext;

    /**
     * Obtiene el valor del par�metro wsContext.
     * 
     * @return wsContext valor del campo a obtener.
     * 
     */
    public WebServiceContext getWsContext() {
        return wsContext;
    }
    /**
     * Guarda el valor del par�metro wsContext.
     * 
     * @param wsContext
     *            valor del campo a guardar.
     */
    public void setWsContext(
        WebServiceContext wsContext) {
        this.wsContext = wsContext;
    }

    
}
