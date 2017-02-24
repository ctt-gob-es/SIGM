/**
 * 
 * @author jcebrien
 * 
 */

package com.ieci.tecdoc.isicres.servlets;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.transform.Templates;
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

import com.ieci.tecdoc.common.exception.AttributesException;
import com.ieci.tecdoc.common.exception.BookException;
import com.ieci.tecdoc.common.exception.SecurityException;
import com.ieci.tecdoc.common.exception.SessionException;
import com.ieci.tecdoc.common.exception.ValidationException;
import com.ieci.tecdoc.isicres.desktopweb.Keys;
import com.ieci.tecdoc.isicres.desktopweb.utils.RBUtil;
import com.ieci.tecdoc.isicres.desktopweb.utils.RequestUtils;
import com.ieci.tecdoc.isicres.desktopweb.utils.ResponseUtils;
import com.ieci.tecdoc.isicres.usecase.UseCaseConf;
import com.ieci.tecdoc.isicres.usecase.book.BookUseCase;

import es.ieci.tecdoc.fwktd.core.config.web.ContextUtil;

/**
 * Genera el formulario de consulta de los libros. Una vez mostrada la lista de libros, cuando
 * se hace click en uno de ellos se invoca a este servlet para generar el formulario de consulta.
 * 
 * Este formulario se construye mediante una transformaci�n de un xml con los campos del libro
 * y una xsl en html.
 * 
 * @author LMVICENTE
 * @creationDate 12-may-2004 9:00:28
 * @version
 * @since
 */

public class Qryfmtmp extends HttpServlet implements Keys {

	private static Logger _logger = Logger.getLogger(Qryfmtmp.class);
    public static long archPId = 1;
    private TransformerFactory factory = null;
    private BookUseCase bookUseCase = null;

    public void init() throws ServletException {
        super.init();

        factory = TransformerFactory.newInstance();
        bookUseCase = new BookUseCase();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doWork(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        doWork(request, response);
    }

    private void doWork(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        
        response.setContentType("text/html; charset=UTF-8"); 
        
        // ArchiveId es el identificador del libro: A<ArchiveId><sufijo invesdoc>
        Integer archiveId = RequestUtils.parseRequestParameterAsInteger(request, "ArchiveId");
        Integer archivePId = RequestUtils.parseRequestParameterAsInteger(request, "ArchivePId");
        // Obtenemos la sesi�n asociada al usuario.
        HttpSession session = request.getSession();
        // Texto del idioma. Ej: EU_
        String idioma = (String) session.getAttribute(Keys.J_IDIOMA);
        // N�mero del idioma. Ej: 10
        Long numIdioma = (Long) session.getAttribute(Keys.J_NUM_IDIOMA);
        // Obtenemos el objeto de configuraci�n del servidor de aplicaciones y el identificador
        // de sesi�n para este usuario en el servidor de aplicaciones.
        UseCaseConf useCaseConf = (UseCaseConf) session.getAttribute(J_USECASECONF);

        // Guardamos el libro
        session.setAttribute(Keys.J_BOOK, archiveId);
        PrintWriter writer = response.getWriter();
        try {
            Integer bookID = (Integer) session.getAttribute(Keys.J_BOOK);
            // Hay que cerrar la consulta anterior si existe
            if (bookID != null) {
                bookUseCase.closeTableResults(useCaseConf, bookID);
            }

            // Transformamos el xml mediante la xsl en html.
            // Los errores pueden ser de comunicaci�n, de validaci�n, de transformaci�n, etc...
            Document xmlDocument = bookUseCase.getQueryFormat(useCaseConf, archiveId, archPId, archPId++);
            String xslPath = ContextUtil.getRealPath(session.getServletContext(), XSL_QRYFMTMP_RELATIVE_PATH);
            Templates cachedXSLT = factory.newTemplates(new StreamSource(new InputStreamReader(new BufferedInputStream(
                    new FileInputStream(xslPath)))));
            Transformer transformer = cachedXSLT.newTransformer();
            DocumentSource source = new DocumentSource(xmlDocument);

            StreamResult result = new StreamResult(writer);
            transformer.transform(source, result);
        } catch (SecurityException e) {
            _logger.fatal("Error de seguridad", e);
            writer.write(ACTIVATE_TREE);
            ResponseUtils.generateJavaScriptError(writer, e, useCaseConf.getLocale());
        } catch (ValidationException e) {
            _logger.fatal("Error de validacion", e);
            writer.write(ACTIVATE_TREE);
            ResponseUtils.generateJavaScriptLog(writer, RBUtil.getInstance(useCaseConf.getLocale())
                    .getProperty(Keys.I18N_EXCEPTION_VALIDATIONEXCEPTION));
        } catch (AttributesException e) {
            _logger.fatal("Error en los atributos", e);
            writer.write(ACTIVATE_TREE);
            ResponseUtils.generateJavaScriptError(writer, e, useCaseConf.getLocale());
       } catch (BookException e) {
       		_logger.fatal("Error en el libro", e);
            writer.write(ACTIVATE_TREE);
            ResponseUtils.generateJavaScriptError(writer, e);
        } catch (SessionException e) {
            _logger.fatal("Error en la sesion", e);
            writer.write(ACTIVATE_TREE);
            ResponseUtils.generateJavaScriptErrorSessionExpired(writer, e, idioma, numIdioma);
            //ResponseUtils.generateJavaScriptError(response, e);
        } catch (TransformerConfigurationException e) {
            _logger.fatal("Error al recuperar el formulario", e);
            writer.write(ACTIVATE_TREE);
            ResponseUtils.generateJavaScriptLog(writer, RBUtil.getInstance(useCaseConf.getLocale())
                    .getProperty(Keys.I18N_ISICRESSRV_ERR_CREATING_FDRQRY_OBJ));
        } catch (TransformerFactoryConfigurationError e) {
            _logger.fatal("Error al recuperar el formulario", e);
            writer.write(ACTIVATE_TREE);
            ResponseUtils.generateJavaScriptLog(writer, RBUtil.getInstance(useCaseConf.getLocale())
                    .getProperty(Keys.I18N_ISICRESSRV_ERR_CREATING_FDRQRY_OBJ));
        } catch (TransformerException e) {
            _logger.fatal("Error al recuperar el formulario", e);
            writer.write(ACTIVATE_TREE);
            ResponseUtils.generateJavaScriptLog(writer, RBUtil.getInstance(useCaseConf.getLocale())
                    .getProperty(Keys.I18N_ISICRESSRV_ERR_CREATING_FDRQRY_OBJ));
        } catch (Exception e) {
            _logger.fatal("Error al recuperar el formulario", e);
            writer.write(ACTIVATE_TREE);
            ResponseUtils.generateJavaScriptLog(writer, RBUtil.getInstance(useCaseConf.getLocale())
                    .getProperty(Keys.I18N_ISICRESSRV_ERR_CREATING_FDRQRY_OBJ));
        }
    }

}