package com.ieci.tecdoc.isicres.servlets;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.io.DocumentSource;

import com.ieci.tecdoc.isicres.desktopweb.Keys;
import com.ieci.tecdoc.isicres.desktopweb.utils.RBUtil;
import com.ieci.tecdoc.isicres.desktopweb.utils.RequestUtils;
import com.ieci.tecdoc.isicres.desktopweb.utils.ResponseUtils;
import com.ieci.tecdoc.isicres.usecase.UseCaseConf;
import com.ieci.tecdoc.isicres.usecase.distribution.DistributionUseCase;

import es.ieci.tecdoc.fwktd.core.config.web.ContextUtil;

/**
 * @author 79426599
 * Created on 01-jun-2006
 */
public class GetSearchDist extends HttpServlet {
	
    private static Logger _logger = Logger.getLogger(GetSearchDist.class);

    private DistributionUseCase distributionUseCase = null;

    private TransformerFactory factory = null;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
        distributionUseCase = new DistributionUseCase();
        factory = TransformerFactory.newInstance();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
        doWork(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
        doWork(request, response);
	}
    private void doWork(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        
        response.setContentType("text/html; charset=UTF-8"); 

        //Tipo de distribucion (entrada o salida).
        Integer lnTypeDistr = RequestUtils.parseRequestParameterAsInteger(request, "TypeDistr");
         // Obtenemos la sesi�n asociada al usuario.
        HttpSession session = request.getSession();
        // Texto del idioma. Ej: EU_
        String idioma = (String) session.getAttribute(Keys.J_IDIOMA);
        // N�mero del idioma. Ej: 10
        Long numIdioma = (Long) session.getAttribute(Keys.J_NUM_IDIOMA);
        // Obtenemos el objeto de configuraci�n del servidor de aplicaciones y
        // el identificador
        // de sesi�n para este usuario en el servidor de aplicaciones.
        UseCaseConf useCaseConf = (UseCaseConf) session.getAttribute(Keys.J_USECASECONF);
        //response.getWriter().write(ACTIVATE_DTR);
        PrintWriter writer = response.getWriter();
        try {
            // Transformamos el xml mediante la xsl en html.
            // Los errores pueden ser de comunicaci�n, de validaci�n, de
            // transformaci�n, etc...
            Document xmlDocument = distributionUseCase.getDistributionSearch(useCaseConf, lnTypeDistr.intValue());

            String xslPath = ContextUtil.getRealPath(session.getServletContext(), Keys.XSL_DISTRIBUTIONSEARCH_RELATIVE_PATH);            
            Transformer transformer = factory.newTransformer(new StreamSource(new InputStreamReader(
                    new BufferedInputStream(new FileInputStream(xslPath)))));
            DocumentSource source = new DocumentSource(xmlDocument);
            StreamResult result = new StreamResult(writer);
            transformer.transform(source, result);
        } catch (TransformerConfigurationException e) {
            _logger.fatal("Error en di�logo de busqueda de distribuci�n", e);
            //writer.write(Keys.SEARCH_DTR);
            ResponseUtils.generateJavaScriptLogGetSearchDist(writer, RBUtil.getInstance(useCaseConf.getLocale()).getProperty(
                    Keys.I18N_ISICRESSRV_ERR_CREATING_DTR_DIALOG ));
        } catch (TransformerFactoryConfigurationError e) {
            _logger.fatal("Error en di�logo de busqueda de distribuci�n", e);
            //writer.write(Keys.SEARCH_DTR);
            ResponseUtils.generateJavaScriptLogGetSearchDist(writer, RBUtil.getInstance(useCaseConf.getLocale()).getProperty(
                    Keys.I18N_ISICRESSRV_ERR_CREATING_DTR_DIALOG ));
        } catch (TransformerException e) {
            _logger.fatal("Error en di�logo de busqueda de distribuci�n", e);
            //writer.write(Keys.SEARCH_DTR);
            ResponseUtils.generateJavaScriptLogGetSearchDist(writer, RBUtil.getInstance(useCaseConf.getLocale()).getProperty(
                    Keys.I18N_ISICRESSRV_ERR_CREATING_DTR_DIALOG ));
        } catch (Exception e) {
            _logger.fatal("Error en di�logo de busqueda de distribuci�n", e);
            //writer.write(Keys.SEARCH_DTR);
            ResponseUtils.generateJavaScriptLogGetSearchDist(writer, RBUtil.getInstance(useCaseConf.getLocale()).getProperty(
                    Keys.I18N_ISICRESSRV_ERR_CREATING_DTR_DIALOG ));
        }

    }
	
}
