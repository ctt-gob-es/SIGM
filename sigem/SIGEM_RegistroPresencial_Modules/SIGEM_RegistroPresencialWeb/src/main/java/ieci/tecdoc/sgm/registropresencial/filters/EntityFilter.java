package ieci.tecdoc.sgm.registropresencial.filters;

import ieci.tecdoc.sgm.core.admin.web.AutenticacionBackOffice;
import ieci.tecdoc.sgm.core.services.gestion_backoffice.ConstantesGestionUsuariosBackOffice;
import ieci.tecdoc.sgm.sesiones.backoffice.ws.client.Sesion;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import es.ieci.tecdoc.fwktd.core.spring.configuration.jdbc.datasource.MultiEntityContextHolder;

/**
 * Filtro que setea la Entidad en una variable MultiEntityContextHolder
 *
 * @author Blimea
 *
 */

public class EntityFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * Metodo que comprueba si existe la variable de la entidad sino para incluirla como ThreadLocal.
	 *
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {

		HttpServletRequest httpRequest =  (HttpServletRequest) request;

		String entidad = null;

		if(AutenticacionBackOffice.autenticar(httpRequest)) {
			Sesion sesion = AutenticacionBackOffice.obtenerDatos(httpRequest);
			entidad = sesion.getIdEntidad();
		}

		if(entidad != null){
			httpRequest.getSession().setAttribute(ConstantesGestionUsuariosBackOffice.PARAMETRO_ID_ENTIDAD, entidad);
		}

		String oEntidad = (String) httpRequest.getSession().getAttribute(ConstantesGestionUsuariosBackOffice.PARAMETRO_ID_ENTIDAD);

		//seteamos al thread local
		MultiEntityContextHolder.setEntity(oEntidad);

		filterChain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}

}
