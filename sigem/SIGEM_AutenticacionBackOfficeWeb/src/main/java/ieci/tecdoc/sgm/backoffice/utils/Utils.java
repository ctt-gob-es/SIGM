/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package ieci.tecdoc.sgm.backoffice.utils;

import javax.servlet.http.HttpServletRequest;


import es.ieci.tecdoc.fwktd.audit.integration.business.vo.AuditContext;
import es.ieci.tecdoc.fwktd.audit.integration.context.AuditContextHolder;
/**
 * Clase de Utilidades para la capa WEB
 * @author cmorenog
 *
 */
public class Utils {

	/**
	 * Metodo que añade a la variable de tipo ThrealLocal la informacion de IP y
	 * nombre de Host
	 *
	 * @param request
	 */
	public static void setAuditContext(HttpServletRequest request) {
		AuditContext auditContext = new AuditContext();
		auditContext.setUserHost(request.getRemoteHost());
		auditContext.setUserIP(request.getRemoteAddr());
		AuditContextHolder.setAuditContext(auditContext);
	}
	
}
