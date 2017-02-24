package com.ieci.tecdoc.isicres.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Filtro para que la aplicaci�n acepte codificaci�n en formato UTF-8
 * 
 * @author SLuna
 * @version 1.0
 * @since 2008/11/10
 */
public class UTF8Filter implements Filter {

	/**
	 * Cadena con la codificaci�n
	 */
	private String encoding;

	/**
	 * Recogemos el tipo de codificaci�n definido en el web.xml Si no se hubiera
	 * especificado ninguno se toma "UTF-8" por defecto
	 * 
	 * @param aFilterConfig
	 *            Filtro de configuraci�n
	 * @throws ServletException
	 *             Excepci�n lanzada por el servlet en caso de error
	 */
	public void init(FilterConfig aFilterConfig) throws ServletException {

		encoding = aFilterConfig.getInitParameter("requestEncoding");

		if (encoding == null) {

			encoding = "UTF-8";

		}

	}

	/**
	 * Metemos en la request el formato de codificacion UTF
	 * 
	 * @param aRequest
	 *            La petici�n
	 * @param aResponse
	 *            La respuesta
	 * @param aFilterChain
	 *            La cadena de filtro
	 * @throws IOException
	 *             Excepci�n lanzada en caso de error de E/S
	 * @throws ServletException
	 *             Excepci�n lanzada por el servlet en caso de error
	 */
	public void doFilter(ServletRequest aRequest, ServletResponse aResponse,
			FilterChain aFilterChain) throws IOException, ServletException {

		aRequest.setCharacterEncoding(encoding);
		aFilterChain.doFilter(aRequest, aResponse);

	}

	/**
	 * M�todo 'destroy'
	 */
	public void destroy() {
	}

}
