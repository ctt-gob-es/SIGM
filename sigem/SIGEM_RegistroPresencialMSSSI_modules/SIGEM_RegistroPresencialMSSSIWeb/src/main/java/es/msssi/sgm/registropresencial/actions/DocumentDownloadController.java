/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.sgm.registropresencial.actions;

import java.io.ByteArrayInputStream;

import org.apache.log4j.Logger;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.ieci.tecdoc.common.exception.BookException;
import com.ieci.tecdoc.common.exception.SessionException;
import com.ieci.tecdoc.common.exception.ValidationException;
import com.ieci.tecdoc.common.invesicres.ScrRegstate;
import com.ieci.tecdoc.isicres.usecase.book.BookUseCase;

import es.msssi.sgm.registropresencial.beans.ContentTypeEnum;
import es.msssi.sgm.registropresencial.beans.ibatis.Axpageh;
import es.msssi.sgm.registropresencial.errors.ErrorConstants;
import es.msssi.sgm.registropresencial.errors.RPRegistralExchangeErrorCode;
import es.msssi.sgm.registropresencial.errors.RPRegistralExchangeException;
import es.msssi.sgm.registropresencial.utils.KeysRP;

/**
 * Clase que implementa la descarga de documentos de un registro.
 * 
 * @author cmorenog
 * 
 */
public class DocumentDownloadController extends GenericActions {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(DocumentDownloadController.class.getName());
    /** fichero. */
    private StreamedContent file;
    private ScrRegstate book;
    private BookUseCase bookUseCase = null;

    /** P�gina a descargar. */
    private Axpageh page = null;

    /**
     * constructor.
     */
    public DocumentDownloadController() {
	bookUseCase = new BookUseCase();
    }

    /**
     * devuelve el contenido del documento a descargar.
     * 
     * @return Contenido.
     * @throws SessionException
     *             errores de sesi�n.
     * @throws RPRegistralExchangeException
     *             error de descarga.
     */
    public StreamedContent getFileDownload()
	throws SessionException, RPRegistralExchangeException {
	if (page == null) {
	    throw new SessionException(
		SessionException.ERROR_SESSION_EXPIRED);
	}
	init();
	book = (ScrRegstate) facesContext.getExternalContext().getSessionMap().get(
	    KeysRP.J_BOOK);
	if (book == null) {
	    throw new SessionException(
		SessionException.ERROR_SESSION_EXPIRED);
	}
	byte[] content = null;
	try {
	    content = bookUseCase.getFile(
		useCaseConf, book.getId(), page.getFdrid(), page.getDocId(), page.getId());
	}
	catch (ValidationException e) {
	    LOG.error(RPRegistralExchangeErrorCode.DOWNLOADFILE_ERROR_MESSAGE);
	    throw new RPRegistralExchangeException(
		RPRegistralExchangeErrorCode.DOWNLOADFILE_ERROR_MESSAGE,
		ErrorConstants.DOWNLOADFILE_ERROR_MESSAGE);
	}
	catch (BookException e) {
	    LOG.error(RPRegistralExchangeErrorCode.DOWNLOADFILE_ERROR_MESSAGE);
	    throw new RPRegistralExchangeException(
		RPRegistralExchangeErrorCode.DOWNLOADFILE_ERROR_MESSAGE,
		ErrorConstants.DOWNLOADFILE_ERROR_MESSAGE);
	}
	file = new DefaultStreamedContent(
	    new ByteArrayInputStream(
		content), getContentType(page.getLoc()), page.getName());
	return file;
    }

    /**
     * M�todo que devuelve el content-type con la extensi�n del fichero.
     * 
     * @param loc
     *            extensi�n del fichero
     * @return content-type el content-type del fichero
     */
    private String getContentType(
	String loc) {
	String contentType = "DEFAULT";
	if (loc != null &&
	    !"".equals(loc)) {
	    try{
		contentType = ContentTypeEnum.valueOf(
			loc.toUpperCase()).getContentType();
	    }catch (Exception e){
		contentType = "DEFAULT";
	    }
	}
	return contentType;
    }

    /**
     * Obtiene el valor del par�metro page.
     * 
     * @return page valor del campo a obtener.
     */
    public Axpageh getPage() {
	return page;
    }

    /**
     * Guarda el valor del par�metro page.
     * 
     * @param page
     *            del campo a guardar.
     */
    public void setPage(
	Axpageh page) {
	this.page = page;
    }
}
