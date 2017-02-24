package com.ieci.tecdoc.isicres.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.transform.TransformerFactory;

import org.apache.log4j.Logger;

import com.ieci.tecdoc.isicres.desktopweb.Keys;
import com.ieci.tecdoc.isicres.desktopweb.utils.RBUtil;
import com.ieci.tecdoc.isicres.desktopweb.utils.RequestUtils;
import com.ieci.tecdoc.isicres.desktopweb.utils.ResponseUtils;
import com.ieci.tecdoc.isicres.usecase.UseCaseConf;
import com.ieci.tecdoc.isicres.usecase.book.BookUseCase;

/**
 * 
 * @author 66575267
 * 
 * @date 04/06/2009
 * 
 */
public class ValidateSearchAsociacionRegistros extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static Logger _logger = Logger
			.getLogger(ValidateSearchAsociacionRegistros.class);

	private BookUseCase bookUseCase = null;

	private TransformerFactory factory = null;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		bookUseCase = new BookUseCase();
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

	private void doWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setContentType("text/xml; charset=UTF-8");

		// Criterio de busqueda para datos de registro
		String regWhere = RequestUtils.parseRequestParameterAsString(request,
				"regWhere");
		// Libro de Registro
		String registerBook = RequestUtils.parseRequestParameterAsString(
				request, "registerBook");
		// fila de inicio de busqueda.
		Integer inicio = RequestUtils.parseRequestParameterAsInteger(request,
				"InitValue");
		// identificador de archivo de usuario.
		Integer archiveId = RequestUtils.parseRequestParameterAsInteger(
				request, "ArchiveId");
		// Identificador de carpeta.
		Integer folderId = RequestUtils.parseRequestParameterAsInteger(request,
				"FolderId");
		// Obtenemos el tipo de validacion
		Integer validationType = RequestUtils.parseRequestParameterAsInteger(
				request, "ValidationType");
		// Obtenemos la sesi�n asociada al usuario.
		HttpSession session = request.getSession();

		// Obtenemos el objeto de configuraci�n del servidor de aplicaciones y
		// el identificador
		// de sesi�n para este usuario en el servidor de aplicaciones.
		UseCaseConf useCaseConf = (UseCaseConf) session
				.getAttribute(Keys.J_USECASECONF);

		PrintWriter writer = response.getWriter();
		try {
			if ((validationType != null) && (validationType.intValue() == 1)) {
				writer.write(bookUseCase.getValidatedAsocRegsBook(useCaseConf,
						registerBook));
			} else {
				writer.write(bookUseCase.getValidateAsocRegsSearch(useCaseConf,
						regWhere, inicio, registerBook, folderId, archiveId));
			}
			writer.flush();
			writer.close();

		} catch (Exception e) {
			// writer.write(Keys.SEARCH_DTR);
			_logger
					.fatal(
							"Error en validaci�n de busqueda de asociaci�n de registros",
							e);
			ResponseUtils.generateJavaScriptLogValidateSearchAsocRegs(writer,
					RBUtil.getInstance(useCaseConf.getLocale()).getProperty(
							Keys.I18N_ISICRESSRV_ERR_CREATING_ASOCSREG_OBJ));
		}

	}

	public TransformerFactory getFactory() {
		return factory;
	}

	public void setFactory(TransformerFactory factory) {
		this.factory = factory;
	}

}
