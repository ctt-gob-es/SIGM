package com.ieci.tecdoc.isicres.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ieci.tecdoc.common.conf.FieldConf;
import com.ieci.tecdoc.common.conf.UserConf;
import com.ieci.tecdoc.common.exception.BookException;
import com.ieci.tecdoc.common.exception.SecurityException;
import com.ieci.tecdoc.common.exception.SessionException;
import com.ieci.tecdoc.common.exception.ValidationException;
import com.ieci.tecdoc.common.isicres.AxSf;
import com.ieci.tecdoc.isicres.desktopweb.Keys;
import com.ieci.tecdoc.isicres.desktopweb.utils.RBUtil;
import com.ieci.tecdoc.isicres.desktopweb.utils.RequestUtils;
import com.ieci.tecdoc.isicres.desktopweb.utils.ResponseUtils;
import com.ieci.tecdoc.isicres.session.book.BookSession;
import com.ieci.tecdoc.isicres.usecase.UseCaseConf;
import com.ieci.tecdoc.isicres.usecase.book.BookUseCase;

public class SavePersonValidation extends HttpServlet implements Keys{

	private static Logger _logger = Logger.getLogger(SavePersonValidation.class);
	private BookUseCase bookUseCase = null;

    public void init() throws ServletException {
        super.init();

        bookUseCase = new BookUseCase();
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
        response.setContentType("text/xml; charset=UTF-8");
        
        int enabledImp = 1;
        // Identificador de libro.
        Integer bookId = RequestUtils.parseRequestParameterAsInteger(request, "BookId");
        // Lista de campos persistentes.
        String fields = "";
        // Lista de parametros de configuraci�n.
        String params = "";
        // Valor que tomara PersonValidation
        Integer IntValidation = RequestUtils.parseRequestParameterAsInteger(request, "IntValidation");
        // Obtenemos la sesi�n asociada al usuario.
        HttpSession session = request.getSession();
        // Texto del idioma. Ej: EU_
        String idioma = (String) session.getAttribute(Keys.J_IDIOMA);
        // N�mero del idioma. Ej: 10
        Long numIdioma = (Long) session.getAttribute(Keys.J_NUM_IDIOMA);
        // Obtenemos el objeto de configuraci�n del servidor de aplicaciones y el identificador
        // de sesi�n para este usuario en el servidor de aplicaciones.
        UseCaseConf useCaseConf = (UseCaseConf) session.getAttribute(J_USECASECONF);
        PrintWriter writer = response.getWriter();
        try {
        	AxSf axsfQ = BookSession.getFormFormat(useCaseConf.getSessionID(),
    				bookId, useCaseConf.getEntidadId());
        	
        	UserConf usrConf = BookSession.getUserConfig(
    				useCaseConf.getSessionID(), bookId, axsfQ, false, useCaseConf
    						.getLocale(), useCaseConf.getEntidadId());
        	
        	usrConf.setPersonValidation(IntValidation.intValue());
        	
        	//generamos un array con los campos seleccionados
        	Iterator it = usrConf.getFieldConf().iterator();
        	while(it.hasNext()){
        		FieldConf field = (FieldConf) it.next();
        		if(field.getFieldCheck()==1){
        			fields += field.getFieldId();
        			if (it.hasNext()){
            			fields +=";";
            		}
        		}
        	}
        	
        	//generamos un array con las opciones seleccionadas (id. 1: PersonValidation, id. 2: ShowScanDlg)
        	if (usrConf.getPersonValidation()==1){
        		params = Integer.toString(1);
        	}
        	if(usrConf.getShowScanDlg()==1){
        		if(params.trim()!=""){
        			params += ";" + Integer.toString(2);
        		}
        		else{
        			params = Integer.toString(2);
        		}
        	}
        	
        	writer.write(bookUseCase.saveUserConfig(useCaseConf, bookId, fields, params));
        	writer.flush();
        	writer.close();
        } catch (ValidationException e) {
            _logger.fatal("Error de validacion", e);
            ResponseUtils.generateJavaScriptErrorForPersistFields(writer);
            ResponseUtils.generateJavaScriptLog(writer, RBUtil.getInstance(useCaseConf.getLocale())
                    .getProperty(Keys.I18N_EXCEPTION_VALIDATIONEXCEPTION));
        } catch (BookException e) {
            _logger.fatal("Error en el libro", e);
            ResponseUtils.generateJavaScriptErrorForPersistFields(writer);
            ResponseUtils.generateJavaScriptError(writer, e);
        } catch (SecurityException e) {
            _logger.fatal("Error de seguridad", e);
            ResponseUtils.generateJavaScriptErrorForPersistFields(writer);
            ResponseUtils.generateJavaScriptError(writer, e, useCaseConf.getLocale());
        } catch (SessionException e) {
            _logger.fatal("Error de sesion", e);
            ResponseUtils.generateJavaScriptLogSessionExpiredVldRes(writer, e.getMessage(), idioma, numIdioma, enabledImp);
            //ResponseUtils.generateJavaScriptError(response, e);
        } catch (Exception e) {
            _logger.fatal("Error al obtener los campos", e);
            ResponseUtils.generateJavaScriptErrorForPersistFields(writer);
            ResponseUtils.generateJavaScriptLog(writer, RBUtil.getInstance(useCaseConf.getLocale())
                    .getProperty(Keys.I18N_ISICRESSRV_ERR_CREATING_FRMPERSIST_OBJ));
        }
    }
	
}
