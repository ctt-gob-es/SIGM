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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.primefaces.context.RequestContext;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.model.UploadedFile;

import com.ieci.tecdoc.common.exception.BookException;
import com.ieci.tecdoc.common.exception.SessionException;
import com.ieci.tecdoc.common.exception.ValidationException;
import com.ieci.tecdoc.common.invesdoc.Idocarchhdr;
import com.ieci.tecdoc.common.invesdoc.Iuserdepthdr;
import com.ieci.tecdoc.common.invesicres.ScrOrg;
import com.ieci.tecdoc.common.invesicres.ScrRegstate;
import com.ieci.tecdoc.common.isicres.AxPK;
import com.ieci.tecdoc.common.isicres.AxSf;
import com.ieci.tecdoc.common.isicres.DtrFdrResults;
import com.ieci.tecdoc.common.isicres.UpdHisFdrResults;
import com.ieci.tecdoc.isicres.usecase.book.xml.AsocRegsResults;

import es.ieci.tecdoc.isicres.api.business.manager.impl.RegistroManagerImpl;
import es.ieci.tecdoc.isicres.api.business.vo.IdentificadorRegistroVO;
import es.ieci.tecdoc.isicres.api.business.vo.UsuarioVO;
import es.ieci.tecdoc.isicres.api.documento.electronico.business.vo.DocumentoElectronicoAnexoContenidoVO;
import es.ieci.tecdoc.isicres.api.documento.electronico.business.vo.DocumentoElectronicoAnexoDatosFirmaVO;
import es.ieci.tecdoc.isicres.api.documento.electronico.business.vo.DocumentoElectronicoAnexoVO;
import es.ieci.tecdoc.isicres.api.documento.electronico.business.vo.IdentificadorDocumentoElectronicoAnexoVO;
import es.ieci.tecdoc.isicres.api.documento.electronico.business.vo.TipoDocumentoAnexoEnumVO;
import es.ieci.tecdoc.isicres.api.documento.electronico.business.vo.TipoValidezDocumentoAnexoEnumVO;
import es.ieci.tecdoc.isicres.api.intercambioregistral.business.vo.IntercambioRegistralEntradaVO;
import es.ieci.tecdoc.isicres.api.intercambioregistral.business.vo.IntercambioRegistralSalidaVO;
import es.msssi.sgm.registropresencial.beans.AsocRegisterBean;
import es.msssi.sgm.registropresencial.beans.ContentTypeEnum;
import es.msssi.sgm.registropresencial.beans.Interesado;
import es.msssi.sgm.registropresencial.beans.OutputRegisterBean;
import es.msssi.sgm.registropresencial.beans.ibatis.Axdoch;
import es.msssi.sgm.registropresencial.businessobject.DistributionBo;
import es.msssi.sgm.registropresencial.businessobject.InterestedBo;
import es.msssi.sgm.registropresencial.businessobject.OutputRegisterBo;
import es.msssi.sgm.registropresencial.businessobject.RegInterchangeBo;
import es.msssi.sgm.registropresencial.businessobject.RegisterBo;
import es.msssi.sgm.registropresencial.businessobject.RegisterDocumentsBo;
import es.msssi.sgm.registropresencial.errors.ErrorConstants;
import es.msssi.sgm.registropresencial.errors.RPDistributionException;
import es.msssi.sgm.registropresencial.errors.RPGenericException;
import es.msssi.sgm.registropresencial.errors.RPOutputRegisterException;
import es.msssi.sgm.registropresencial.errors.RPRegisterException;
import es.msssi.sgm.registropresencial.errors.RPRegistralExchangeException;
import es.msssi.sgm.registropresencial.utils.KeysRP;
import es.msssi.sgm.registropresencial.utils.Utils;
import es.msssi.sgm.registropresencial.utils.UtilsHash;
import es.msssi.sgm.registropresencial.validations.ValidationBo;
import es.msssi.sgm.registropresencial.validations.ValidationListBo;

/**
 * Action de registro de salida.
 * 
 * @author cmorenog
 */
public class OutputRegisterAction extends GenericActions {
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(OutputRegisterAction.class.getName());
    private boolean readOnly = false;
    private boolean readOnlyIR = false;
    private OutputRegisterBo outputRegisterBo;
    private RegisterBo registerBo;
    private RegisterDocumentsBo registerDocumentsBo;
    private OutputRegisterBean outputRegisterBean;
    private ScrRegstate book;
    private Integer registerCopy;
    private String registerNumCopy;
    private List<UpdHisFdrResults> listUpdates;
    private List<DtrFdrResults> listHistDistribution;
    private List<IntercambioRegistralEntradaVO> listHistInputInterchange;
    private List<IntercambioRegistralSalidaVO> listHistOutputInterchange;
    private List<Axdoch> listDocuments;
    private RegInterchangeBo regInterchangeBo = null;
    /** Implementaci�n de las funcionalidades de distribuci�n. */
    private DistributionBo distributionBo;
    /** lista de departamentos para la distribuci�n. */
    private List<Iuserdepthdr> listDepartament = null;
    /**
     * Origen del formulario. B:B�squeda de registros D:Distribuci�n
     * IR:Intercambio Registral
     * */
    private String origen = "B";
    private List<AxSf> asocReg;
    private AxSf asocRegPrim;
    private Map<String, Idocarchhdr> idocs;
    private AsocRegisterBean asocRegisterBean = new AsocRegisterBean();
    private int myCurrentTab = 0;
    private String selectedDocSIR = null;
    private String validateDocument = null;
    private String contentDocument = null;
    private String signDocument = null;
    private String certificateDocument = null;
    DocumentoElectronicoAnexoVO documentoElectronico = new DocumentoElectronicoAnexoVO();
    private Axdoch selectDocument;
    private String listNameDocument = null;
    // DISTRIBUCION
    /** tipo de destino seleccionado en la distribuci�n. */
    private int typeDestinoRedis = 2;
    /** Motivo de la distribuci�n. */
    private String motivoDistribucion = null;
    /** departamento seleccionado en la distribuci�n. */
    private Iuserdepthdr selectdestinoRedisDepartamentos = null;
    private boolean canDistr = true;
    private UploadedFile fileUpload = null;
    /**
     * Constructor. Valida el registro.
     * 
     * @throws SessionException
     *             si ha habido un problema de sesi�n.
     * @throws ValidationException
     *             Si ha habido un problema de validaci�n de par�metros.
     */
    public OutputRegisterAction() throws SessionException, ValidationException {
	init();
	deleteSession ("reportsLabelAction");
	book = (ScrRegstate) facesContext.getExternalContext().getSessionMap().get(
	    KeysRP.J_BOOK);
	if (book == null) {
	    throw new SessionException(
		SessionException.ERROR_SESSION_EXPIRED);
	}
	try {
	    validateIdBook(
		book.getId(), useCaseConf);
	}
	catch (BookException bookException) {
	    LOG.error(
		ErrorConstants.GET_INFORMATION_BOOK_ERROR_MESSAGE, bookException);
	    Utils.redirectToErrorPage(
		null, bookException, null);
	}
	if (regInterchangeBo == null){
	    regInterchangeBo = new RegInterchangeBo();
	}
	if (facesContext.getExternalContext().getFlash().get(
	    "registerSelect") != null) {
	    outputRegisterBean = new OutputRegisterBean();
	    outputRegisterBean.setFdrid((Integer) FacesContext.getCurrentInstance()
		.getExternalContext().getFlash().get(
		    "registerSelect"));
	    if (facesContext.getExternalContext().getFlash().get(
		"distribucion") != null) {
		origen = "D";
	    }
	    else {
		if (facesContext.getExternalContext().getFlash().get(
		    "intercambio") != null) {
		    origen = "IR";
		}
		else {
		    if (facesContext.getExternalContext().getFlash().get(
			"intercambioR") != null) {
			origen = "I";
		    }
		}
	    }
	}

	/* EDICION O CONSULTA */
	if (outputRegisterBean != null &&
	    outputRegisterBean.getFdrid() != null) {
	    validateRegister(
		useCaseConf, book.getId(), outputRegisterBean.getFdrid());
	    loadOutputRegister();
	}
	else {
	    /* COPIAR */
	    if (facesContext.getExternalContext().getFlash().get(
		"registerCopy") != null) {

		registerCopy = ((Integer) facesContext.getExternalContext().getFlash().get(
		    "registerCopy"));
		registerNumCopy = ((String) facesContext.getExternalContext().getFlash().get(
		    "registerNumCopy"));
		try {
		    copyOutputRegister();
		}
		catch (SessionException sessionException) {
		    LOG.error(
			ErrorConstants.COPY_INPUT_REGISTER_ERROR_MESSAGE, sessionException);
		    Utils.redirectToErrorPage(
			null, sessionException, null);
		}
	    }
	}
    }

    /**
     * Borra los datos del interesado y crea uno vac�o.
     */
    public void reinit() {
	Interesado interesado = new Interesado();
	interesado.setTipo(useCaseConf.getInterestedType());
	outputRegisterBean.setInteresado(interesado);
    }
    
    @PreDestroy
    public void destroy1() {
	deleteSession ("reportsLabelAction");
	if (outputRegisterBean != null) {
	    RegistroManagerImpl registroManagerImpl = new RegistroManagerImpl();
	    UsuarioVO usuario = new UsuarioVO();
	    if (outputRegisterBean.getFdrid() != null) {
		usuario =
			(UsuarioVO) FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get("USERVO");
		IdentificadorRegistroVO identificadorRegistro =
			new IdentificadorRegistroVO(String.valueOf(outputRegisterBean.getFdrid()), String.valueOf(book.getIdocarchhdr().getId()));
		registroManagerImpl.unlockRegistro(usuario, identificadorRegistro);
	    }
	}
    }
    
    /**
     * guarda en sesion el valor por defecto del tipo de interesado.
     */
    public void saveInterestedTypeDefault() {
	if (outputRegisterBean.getInteresado() != null) {
	    useCaseConf.setInterestedType(outputRegisterBean.getInteresado().getTipo());
	    saveUseCaseConf(useCaseConf);
	}
    }

    /**
     * Crea un nuevo Bean y un nuevo Business Object de registro de salida.
     */
    @PostConstruct
    public void create() {
	if (outputRegisterBo == null) {
	    outputRegisterBo = new OutputRegisterBo();
	}
	if (outputRegisterBean == null) {
	    outputRegisterBean = new OutputRegisterBean();
	}
    }

    /**
     * Limpia el formulario y la tabla de resultados.
     */
    public void limpiar() {
	init();
	deleteSession ("reportsLabelAction");
	Application application = facesContext.getApplication();
	ViewHandler viewHandler = application.getViewHandler();
	UIViewRoot viewRoot = viewHandler.createView(
	    facesContext, facesContext.getViewRoot().getViewId());
	facesContext.setViewRoot(viewRoot);
	facesContext.renderResponse(); // Optional
    }

    /**
     * Da de alta un nuevo registro.
     * 
     * @throws BookException
     *             si ha habido alg�n problema con el libro de registro.
     * @throws SessionException
     *             si ha habido alg�n problema con la sesi�n.
     * @throws ValidationException
     *             si ha habido alg�n problema con en la validaci�n.
     */
    public void saveOutputRegister()
	throws BookException, SessionException, ValidationException {
	
	if (book == null) {
	    throw new SessionException(
		SessionException.ERROR_SESSION_EXPIRED);
	}
	// validaciones de seguridad
	try {
	    ValidationBo.validationSecurityUser(
		book.getId(), null, useCaseConf);
	}
	catch (RPGenericException rpGenericException) {
	    LOG.error(ErrorConstants.SAVE_OUTPUT_REGISTER_ERROR_MESSAGE +
		". C�digo: " + rpGenericException.getCode().getCode() + " . Mensaje: " +
		rpGenericException.getShortMessage());
	    Utils.redirectToErrorPage(
		rpGenericException, null, null);
	}
	deleteSession ("reportsLabelAction");
	loadDocSirSelected();
	if (outputRegisterBean.getFdrid() != null) {
	    try {
		OutputRegisterBo.saveOrUpdateFolder(
		    useCaseConf, book.getId(), outputRegisterBean.getFdrid(), null,
		    outputRegisterBean, outputRegisterBean.getInteresados(), null);
	    }
	    catch (RPOutputRegisterException rpOutputRegisterException) {
		LOG.error(ErrorConstants.SAVE_OUTPUT_REGISTER_ERROR_MESSAGE +
		    ". C�digo: " + rpOutputRegisterException.getCode().getCode() + " . Mensaje: " +
		    rpOutputRegisterException.getShortMessage());
		Utils.redirectToErrorPage(
		    rpOutputRegisterException, null, null);
	    }
	    catch (RPGenericException rpGenericException) {
		LOG.error(ErrorConstants.SAVE_OUTPUT_REGISTER_ERROR_MESSAGE +
		    ". C�digo: " + rpGenericException.getCode().getCode() + " . Mensaje: " +
		    rpGenericException.getShortMessage());
		Utils.redirectToErrorPage(
		    rpGenericException, null, null);
	    }
	    FacesContext.getCurrentInstance().addMessage(
		null,
		new FacesMessage(
		    FacesMessage.SEVERITY_INFO, "Se ha guardado el Registro Correctamente",
		    "Se ha guardado el Registro Correctamente"));
	}
	else {
	    try {
		outputRegisterBean.setFdrid(OutputRegisterBo.saveOrUpdateFolder(
		    useCaseConf, book.getId(), null, null, outputRegisterBean,
		    outputRegisterBean.getInteresados(), null));
	    }
	    catch (RPOutputRegisterException rpOutputRegisterException) {
		LOG.error(ErrorConstants.SAVE_OUTPUT_REGISTER_ERROR_MESSAGE +
		    ". C�digo: " + rpOutputRegisterException.getCode().getCode() + " . Mensaje: " +
		    rpOutputRegisterException.getShortMessage());
		Utils.redirectToErrorPage(
		    rpOutputRegisterException, null, null);
	    }
	    catch (RPGenericException rpGenericException) {
		LOG.error(ErrorConstants.SAVE_OUTPUT_REGISTER_ERROR_MESSAGE +
		    ". C�digo: " + rpGenericException.getCode().getCode() + " . Mensaje: " +
		    rpGenericException.getShortMessage());
		Utils.redirectToErrorPage(
		    rpGenericException, null, null);
	    }
	    FacesContext.getCurrentInstance().addMessage(
		    null,
		    new FacesMessage(FacesMessage.SEVERITY_INFO,
			    "Se ha creado el Registro Correctamente.",
			    "Se ha creado el Registro Correctamente."));
	}
	loadOutputRegister();
    }

    /**
     * Carga un registro.
     */
    public void loadOutputRegister() {
	try {
	    init();
	    deleteSession ("reportsLabelAction");
	    book = (ScrRegstate) facesContext.getExternalContext().getSessionMap().get(
		KeysRP.J_BOOK);
	    if (book == null) {
		throw new SessionException(
		    SessionException.ERROR_SESSION_EXPIRED);
	    }

	    /* MODIFICACION */
	    if (outputRegisterBean.getFdrid() != null) {
		Boolean readOnlyFlash = false;
		if (facesContext.getExternalContext().getFlash().get(
		    "readOnly") != null) {
		    readOnlyFlash = (Boolean) facesContext.getExternalContext().getFlash().get(
			"readOnly");
		}
		if (registerBo == null) {
		    registerBo = new RegisterBo();
		}
		if (outputRegisterBo == null) {
		    outputRegisterBo = new OutputRegisterBo();
		}
		try {
		    readOnly = registerBo.readOnly(
			readOnlyFlash, outputRegisterBean.getFdrid(), useCaseConf, book.getId());
		    distributionBo = new DistributionBo();
		    try {
			canDistr =
				distributionBo
					.canDistributionRegister(useCaseConf, outputRegisterBean
						.getFdrid(), book.getIdocarchhdr().getId());
		    }
		    catch (RPDistributionException e) {
			LOG.error(ErrorConstants.LOAD_INPUT_REGISTER_ERROR_MESSAGE + ". C�digo: "
				+ e.getCode().getCode() + " . Mensaje: " + e.getShortMessage());
		    }
		    LOG.info("Cargando datos del registro " +
			outputRegisterBean.getFdrid());
		    outputRegisterBean = outputRegisterBo.loadOutputRegisterBean(
			useCaseConf, book, outputRegisterBean.getFdrid());
		    loadSelectedDocSIR();
		    try {
			readOnlyIR =
				regInterchangeBo.isIntercambioRegistralNotEdit(
					Integer.toString(book.getId()),
					Integer.toString(outputRegisterBean.getFdrid()),
					String.valueOf(outputRegisterBean.getFld5().getId()));
		    }
		    catch (RPRegistralExchangeException e1) {
			LOG.error(ErrorConstants.LOAD_INPUT_REGISTER_ERROR_MESSAGE + ". C�digo: "
				+ e1.getCode().getCode() + " . Mensaje: " + e1.getShortMessage());
		    }
		}
		catch (RPOutputRegisterException rpOutputRegisterException) {
		    LOG.error(ErrorConstants.LOAD_OUTPUT_REGISTER_ERROR_MESSAGE +
			". C�digo: " + rpOutputRegisterException.getCode().getCode() +
			" . Mensaje: " + rpOutputRegisterException.getShortMessage());
		    Utils.redirectToErrorPage(
			rpOutputRegisterException, null, null);
		}
		catch (RPRegisterException rpRegisterException) {
		    LOG.error(ErrorConstants.LOAD_OUTPUT_REGISTER_ERROR_MESSAGE +
			". C�digo: " + rpRegisterException.getCode().getCode() + " . Mensaje: " +
			rpRegisterException.getShortMessage());
		    Utils.redirectToErrorPage(
			rpRegisterException, null, null);
		}
		catch (RPGenericException rpGenericException) {
		    LOG.error(ErrorConstants.LOAD_OUTPUT_REGISTER_ERROR_MESSAGE +
			". C�digo: " + rpGenericException.getCode().getCode() + " . Mensaje: " +
			rpGenericException.getShortMessage());
		    Utils.redirectToErrorPage(
			rpGenericException, null, null);
		}
	    }
	}
	catch (SessionException sessionException) {
	    LOG.error(
		ErrorConstants.LOAD_OUTPUT_REGISTER_ERROR_MESSAGE, sessionException);
	    Utils.redirectToErrorPage(
		null, sessionException, null);
	}
    }

    /**
     * Obtiene los documentos asociados a un registro.
     */
    public void getRegisterAttachedDocuments() {
	boolean openFolderDtr = ("D".equals(origen))
	    ? true : false;
	listDocuments = new ArrayList<Axdoch>();
	if (registerDocumentsBo == null) {
	    registerDocumentsBo = new RegisterDocumentsBo();
	}
	try {
	    LOG.info("Cargando documentos asociados al registro " +
		outputRegisterBean.getFdrid());
	    listDocuments = registerDocumentsBo.getDocumentsBasicInfo(
		useCaseConf, book.getId(), outputRegisterBean.getFdrid(), openFolderDtr);
	    listNameDocument = "[";
	    boolean primero = true;
	    for (Axdoch doch: listDocuments){
		if (primero){
		    primero = false; 
		}else {
		    listNameDocument += ",";
		}
		listNameDocument += "{\"NameDoc\":\""+doch.getName()+"\"}";
	    }
	    listNameDocument += "]";
	}
	catch (RPRegisterException rPRegisterException) {
	    LOG.error(
		ErrorConstants.LOAD_INPUT_REGISTER_ERROR_MESSAGE, rPRegisterException);
	}
    }

    /**
     * Obtiene el hist�rico de un registro.
     */
    public void getRegisterHistoricalUpdates() {
	listUpdates = new ArrayList<UpdHisFdrResults>();
	try {
	    LOG.info("Cargando hist�rico del registro " +
		outputRegisterBean.getFdrid());
	    listUpdates = registerBo.getUpdHisFdrResults(
		useCaseConf, book, outputRegisterBean.getFdrid(), outputRegisterBean.getFld1());
	}
	catch (RPRegisterException rpRegisterException) {
	    LOG.error(ErrorConstants.LOAD_INPUT_REGISTER_ERROR_MESSAGE +
		". C�digo: " + rpRegisterException.getCode().getCode() + " . Mensaje: " +
		rpRegisterException.getShortMessage());
	    Utils.redirectToErrorPage(
		rpRegisterException, null, null);
	}
	catch (RPGenericException rpGenericException) {
	    LOG.error(ErrorConstants.LOAD_INPUT_REGISTER_ERROR_MESSAGE +
		". C�digo: " + rpGenericException.getCode().getCode() + " . Mensaje: " +
		rpGenericException.getShortMessage());
	    Utils.redirectToErrorPage(
		rpGenericException, null, null);
	}
    }

    /**
     * Obtiene el hist�rico de distribuci�n de un registro.
     */
    public void getRegisterHistDistribution() {
	listHistDistribution = new ArrayList<DtrFdrResults>();
	try {
	    LOG.info("Cargando hist�rico de distribuci�n del registro " +
		outputRegisterBean.getFdrid());
	    distributionBo = new DistributionBo();
	    listHistDistribution = distributionBo.getHistDistribution(
		useCaseConf, book.getId(), outputRegisterBean.getFdrid());
	}
	catch (BookException bookException) {
	    LOG.error(
		ErrorConstants.LOAD_INPUT_REGISTER_ERROR_MESSAGE, bookException);
	    Utils.redirectToErrorPage(
		null, bookException, null);
	}
	catch (SessionException sessionException) {
	    LOG.error(
		ErrorConstants.LOAD_INPUT_REGISTER_ERROR_MESSAGE, sessionException);
	    Utils.redirectToErrorPage(
		null, sessionException, null);
	}
	catch (ValidationException validationException) {
	    LOG.error(
		ErrorConstants.LOAD_INPUT_REGISTER_ERROR_MESSAGE, validationException);
	    Utils.redirectToErrorPage(
		null, validationException, null);
	}
    }

    /**
     * Obtiene el hist�rico de entrada y salida del Intercambio Registral.
     */
    public void getRegisterHistInputAndOutputInterchange() {
	listHistInputInterchange = new ArrayList<IntercambioRegistralEntradaVO>();
	listHistOutputInterchange = new ArrayList<IntercambioRegistralSalidaVO>();
	try {
	    init();
	    book = (ScrRegstate) facesContext.getExternalContext().getSessionMap().get(
		KeysRP.J_BOOK);
	    if (book == null) {
		throw new SessionException(
		    SessionException.ERROR_SESSION_EXPIRED);
	    }

		if ( regInterchangeBo == null){
		    regInterchangeBo = new RegInterchangeBo();
		}
		LOG.info("Cargando hist�rico de Intecambio Registral del registro " +
		    outputRegisterBean.getFdrid());
		listHistInputInterchange =
		    regInterchangeBo.getHistorialIntercambioRegistralEntrada(
			String.valueOf(book.getId()),
			String.valueOf(outputRegisterBean.getFdrid()), String.valueOf(outputRegisterBean.getFld5().getId()));
		listHistOutputInterchange =
		    regInterchangeBo.getHistorialIntercambioRegistralSalida(
			    String.valueOf(book.getId()),
			String.valueOf(outputRegisterBean.getFdrid()), String.valueOf(outputRegisterBean.getFld5().getId()));
	}
	catch (RPRegistralExchangeException rPRegisterException) {
	    LOG.error(
		ErrorConstants.LOAD_INPUT_REGISTER_ERROR_MESSAGE, rPRegisterException);
	}
	catch (SessionException sessionException) {
	    LOG.error(
		ErrorConstants.LOAD_INPUT_REGISTER_ERROR_MESSAGE, sessionException);
	    Utils.redirectToErrorPage(
		null, sessionException, null);
	}
    }

    /**
     * Obtiene los registros asociados a un registro.
     */
    @SuppressWarnings("unchecked")
    public void getRegisterAssociatedRegisters() {
	try {
	    LOG.info("Cargando registros asociados al registro " +
		outputRegisterBean.getFdrid());
	    Object[] regAsoc = registerBo.getAsocReg(
		useCaseConf, book.getId(), outputRegisterBean.getFdrid());
	    if (regAsoc != null && (!((Map<AxPK, AxSf>) regAsoc[1]).isEmpty()
		    || !((Map<AxPK, AxSf>) regAsoc[2]).isEmpty())) {
		idocs = (Map<String, Idocarchhdr>) regAsoc[0];
		asocReg = registerBo.getListAsoReg(
		    (Map<AxPK, AxSf>) regAsoc[1], idocs);
		asocRegPrim = registerBo.getAsoReg(
		    (Map<AxPK, AxSf>) regAsoc[2], idocs);
	    }
	}
	catch (RPRegisterException rpRegisterException) {
	    LOG.error(ErrorConstants.LOAD_INPUT_REGISTER_ERROR_MESSAGE +
		". C�digo: " + rpRegisterException.getCode().getCode() + " . Mensaje: " +
		rpRegisterException.getShortMessage());
	    Utils.redirectToErrorPage(
		rpRegisterException, null, null);
	}
	catch (RPGenericException rpGenericException) {
	    LOG.error(ErrorConstants.LOAD_INPUT_REGISTER_ERROR_MESSAGE +
		". C�digo: " + rpGenericException.getCode().getCode() + " . Mensaje: " +
		rpGenericException.getShortMessage());
	    Utils.redirectToErrorPage(
		rpGenericException, null, null);
	}
    }
    private void loadDocSirSelected() {
	if (selectedDocSIR != null && !"".equals(selectedDocSIR)){
	    outputRegisterBean.setFld504(null);
	    outputRegisterBean.setFld505(null);
	    outputRegisterBean.setFld506(null);
	    if (selectedDocSIR.equals("fld504")){
		outputRegisterBean.setFld504(1);
	    }else {
		if (selectedDocSIR.equals("fld505")){
		    outputRegisterBean.setFld505(1);
		    }else {
			if (selectedDocSIR.equals("fld506")){
			    outputRegisterBean.setFld506(1);
			}
		    }
	    }
	}
    }
    private void loadSelectedDocSIR() {
	if (outputRegisterBean != null) {
	    if (outputRegisterBean.getFld504() != null) {
		selectedDocSIR = "fld504";
	    }
	    else {
		if (outputRegisterBean.getFld505() != null) {
		    selectedDocSIR = "fld505";
		}
		else {
		    if (outputRegisterBean.getFld506() != null) {
			selectedDocSIR = "fld506";
		    }
		}
	    }
	}
    }
    /**
     * Copia un registro.
     * 
     * @throws SessionException
     *             si ha habido alg�n problema con la sesi�n.
     */
    public void copyOutputRegister()
	throws SessionException {
	init();
	book = (ScrRegstate) facesContext.getExternalContext().getSessionMap().get(
	    KeysRP.J_BOOK);
	if (book == null) {
	    throw new SessionException(
		SessionException.ERROR_SESSION_EXPIRED);
	}

	if (registerCopy != null) {
	    if (outputRegisterBo == null) {
		outputRegisterBo = new OutputRegisterBo();
	    }
	    try {
		loadDocSirSelected();
		outputRegisterBean = outputRegisterBo.copyOutputRegisterBean(
		    useCaseConf, book, registerCopy);
		loadSelectedDocSIR();
		FacesContext.getCurrentInstance().addMessage(
		    "Registro Copiado", new FacesMessage(
			FacesMessage.SEVERITY_INFO, "Se han copiado los datos del registro: " +
			    registerNumCopy, "Se han copiado los datos del registro: " +
			    registerNumCopy));
	    }
	    catch (RPOutputRegisterException rpOutputRegisterException) {
		LOG.error(ErrorConstants.COPY_OUTPUT_REGISTER_ERROR_MESSAGE +
		    ". C�digo: " + rpOutputRegisterException.getCode().getCode() + " . Mensaje: " +
		    rpOutputRegisterException.getShortMessage());
		Utils.redirectToErrorPage(
		    rpOutputRegisterException, null, null);
	    }
	    catch (RPGenericException rpGenericException) {
		LOG.error(ErrorConstants.COPY_OUTPUT_REGISTER_ERROR_MESSAGE +
		    ". C�digo: " + rpGenericException.getCode().getCode() + " . Mensaje: " +
		    rpGenericException.getShortMessage());
		Utils.redirectToErrorPage(
		    rpGenericException, null, null);
	    }
	}
    }

    /**
     * borra un registro asociado.
     * 
     * @throws SessionException
     *             si ha habido alg�n problema con la sesi�n.
     */
    @SuppressWarnings("unchecked")
    public void deleteAssociation()
	throws SessionException {
	init();
	deleteSession ("reportsLabelAction");
	book = (ScrRegstate) facesContext.getExternalContext().getSessionMap().get(
	    KeysRP.J_BOOK);
	if (book == null) {
	    throw new SessionException(
		SessionException.ERROR_SESSION_EXPIRED);
	}
	Map<String, String> params = facesContext.getExternalContext().getRequestParameterMap();
	if (registerBo == null) {
	    registerBo = new RegisterBo();
	}
	Integer idReg = new Integer(
	    params.get("idReg"));
	Integer idLibro = new Integer(
	    params.get("idLibro"));
	try {
	    registerBo.deleteAssociation(
		useCaseConf, idLibro, idReg);
	    Object[] regAsoc = registerBo.getAsocReg(
		useCaseConf, book.getId(), outputRegisterBean.getFdrid());
	    if (regAsoc != null) {
		idocs = (Map<String, Idocarchhdr>) regAsoc[0];
		asocReg = registerBo.getListAsoReg(
		    (Map<AxPK, AxSf>) regAsoc[1], idocs);
		asocRegPrim = registerBo.getAsoReg(
		    (Map<AxPK, AxSf>) regAsoc[2], idocs);
	    }
	    FacesContext.getCurrentInstance().addMessage(
		"Asociar Registros",
		new FacesMessage(
		    FacesMessage.SEVERITY_INFO, "Se ha desasociado el registro correctamente",
		    "Se ha desasociado el registro correctamente"));
	}
	catch (RPRegisterException e) {
	    LOG.error(ErrorConstants.DELETE_ASOC_REGISTER_ERROR_MESSAGE +
		". C�digo: " + e.getCode().getCode() + " . Mensaje: " + e.getShortMessage());
	    Utils.redirectToErrorPage(
		e, null, null);
	}
	catch (RPGenericException rpGenericException) {
	    LOG.error(ErrorConstants.DELETE_ASOC_REGISTER_ERROR_MESSAGE +
		". C�digo: " + rpGenericException.getCode().getCode() + " . Mensaje: " +
		rpGenericException.getShortMessage());
	    Utils.redirectToErrorPage(
		rpGenericException, null, null);
	}
    }

    /**
     * asocia un registro.
     * 
     * @throws SessionException
     *             si ha habido alg�n problema con la sesi�n.
     */
    @SuppressWarnings("unchecked")
    public void saveAsocRegister()
	throws SessionException {
	init();
	deleteSession ("reportsLabelAction");
	book = (ScrRegstate) facesContext.getExternalContext().getSessionMap().get(
	    KeysRP.J_BOOK);
	if (book == null) {
	    throw new SessionException(
		SessionException.ERROR_SESSION_EXPIRED);
	}

	if (registerBo == null) {
	    registerBo = new RegisterBo();
	}
	try {
	    List<AsocRegsResults> listAsoc = registerBo.saveAssociation(
		useCaseConf, asocRegisterBean, outputRegisterBean.getFdrid(), book.getId());

	    if (listAsoc == null ||
		listAsoc.isEmpty()) {
		FacesContext.getCurrentInstance().addMessage(
		    "Asociar Registros",
		    new FacesMessage(
			FacesMessage.SEVERITY_ERROR, "No se ha encontrado el registro a asociar",
			"No se ha encontrado el registro a asociar"));
	    }

	    Object[] regAsoc = registerBo.getAsocReg(
		useCaseConf, book.getId(), outputRegisterBean.getFdrid());
	    if (regAsoc != null) {
		idocs = (Map<String, Idocarchhdr>) regAsoc[0];
		asocReg = registerBo.getListAsoReg(
		    (Map<AxPK, AxSf>) regAsoc[1], idocs);
		asocRegPrim = registerBo.getAsoReg(
		    (Map<AxPK, AxSf>) regAsoc[2], idocs);
		FacesContext.getCurrentInstance().addMessage(
		    "Asociar Registros",
		    new FacesMessage(
			FacesMessage.SEVERITY_INFO, "Se ha asociado el registro correctamente",
			"Se ha asociado el registro correctamente"));
	    }
	}
	catch (RPRegisterException e) {
	    LOG.error(ErrorConstants.SAVE_ASOC_REGISTER_ERROR_MESSAGE +
		". C�digo: " + e.getCode().getCode() + " . Mensaje: " + e.getShortMessage());
	    Utils.redirectToErrorPage(
		e, null, null);
	}
	catch (RPGenericException rpGenericException) {
	    LOG.error(ErrorConstants.SAVE_ASOC_REGISTER_ERROR_MESSAGE +
		". C�digo: " + rpGenericException.getCode().getCode() + " . Mensaje: " +
		rpGenericException.getShortMessage());
	    Utils.redirectToErrorPage(
		rpGenericException, null, null);
	}
    }

    /**
     * Redirecciona a la p�gina de intercambioRegistral.
     */
    public void goRegInterchangeForm() {
	deleteSession ("reportsLabelAction");
	if (comprobarInteresadosIR()){
	    if (comprobarSopFisicoIR()){
                	Map<String, Object> parameter = new HashMap<String, Object>();
                	parameter.put(
                	    "registerId", outputRegisterBean.getFdrid());
                	if(outputRegisterBean.getFld504() != null){
                	    parameter.put("docFisica", 1);
                	}
                	if(outputRegisterBean.getFld505() != null){
                	    parameter.put("docFisica", 2);
                	}
                	if(outputRegisterBean.getFld506() != null){
                	    parameter.put("docFisica", 3);
                	}
                	Utils.navigate(
                	    parameter, false, "searchDestinationRegInterchange.xhtml");
	    }else  {
		    FacesContext.getCurrentInstance().addMessage(
			    "Intercambio Registral",
			    new FacesMessage(FacesMessage.SEVERITY_ERROR,
				    "No se puede enviar el registro. El campo Documentaci�n Soporte es obligatorio para los env�os por intercambio registral.",
				    "No se puede enviar el registro. El campo Documentaci�n Soporte es obligatorio para los env�os por intercambio registral."));
		}	
	}else  {
	    FacesContext.getCurrentInstance().addMessage(
		    "Intercambio Registral",
		    new FacesMessage(FacesMessage.SEVERITY_ERROR,
			    "No se puede enviar el registro. No dispone de interesados v�lidos. Recuerde que debe guardar el registro si ha realizado cambios.",
			    "No se puede enviar el registro. No dispone de interesados v�lidos. Recuerde que debe guardar el registro si ha realizado cambios."));
	}
    }
    
    /**
     * Comprobar si el registro tiene interesados y si son v�lidos.
     * @return true si los interesados son v�lidos.
     */
    private boolean comprobarSopFisicoIR() {
	init();
	boolean result = true;
	if(outputRegisterBean.getFld504() == null 
		&& outputRegisterBean.getFld505() == null && outputRegisterBean.getFld506() == null){
	    result = false;
	}
	return result;
    }
    
    /**
     * Comprobar si el registro tiene interesados y si son v�lidos.
     * @return true si los interesados son v�lidos.
     */
    private boolean comprobarInteresadosIR() {
	init();
	boolean result = true;
	InterestedBo interestedBo = new InterestedBo();
	List<Interesado> interadosCon = 
		interestedBo.getAllInterested(book.getId(), outputRegisterBean.getFdrid(), useCaseConf);
	if (interadosCon != null &&
		 !interadosCon.isEmpty() ){
	    for (Interesado inter:interadosCon){
		if (inter.getDocIndentidad() == null || "".equals(inter.getDocIndentidad())
			||inter.getTipodoc() == null || "".equals(inter.getTipodoc())){
		    result = false;
		}else {
		    if (inter.getRepresentante() != null && !"N".equals(inter.getRepresentante().getTipo())){
    		    if (inter.getRepresentante().getDocIndentidad() == null 
    			    || "".equals(inter.getRepresentante().getDocIndentidad())
    				||inter.getRepresentante().getTipodoc() == null 
    				|| "".equals(inter.getRepresentante().getTipodoc())){
    			    result = false;
    			}
    		}
		}
	    }
	}
	return result;
    }

    /**
     * Adjunta un documento al registro.
     * 
     * @param event
     *            Evento de Faces con la informaci�n del proceso.
     */
    public void upload() {
	JSONParser parser = new JSONParser();

	if (registerDocumentsBo == null) {
	    registerDocumentsBo = new RegisterDocumentsBo();
	}
	deleteSession ("reportsLabelAction");
	try {
	    boolean exist = false;
	    for (Axdoch doc:listDocuments){
		 if (doc.getName().equals(documentoElectronico.getName())){
		     exist = true;
		}
	    }
	    if (!exist){
        	    if (documentoElectronico.getName().length() <= 80) {
        		AxSf registerData = Utils.mappingOutputRegisterToAxSF(outputRegisterBean);
                	    //identificadorDocumentoElectronicoAnexoVO
                	    IdentificadorDocumentoElectronicoAnexoVO identificadorDocumentoElectronicoAnexoVO = 
                		    new IdentificadorDocumentoElectronicoAnexoVO ();
                	    identificadorDocumentoElectronicoAnexoVO.setIdLibro(Long.parseLong(String.valueOf(book.getIdocarchhdr().getId())));
                	    identificadorDocumentoElectronicoAnexoVO.setIdRegistro(Long.parseLong(String.valueOf(outputRegisterBean.getFdrid())));
                	    documentoElectronico.setId(identificadorDocumentoElectronicoAnexoVO);
                	    
                	    //CODE NAME
                	    String codeName=("codeName"+documentoElectronico.getName());
                	    codeName=StringUtils.abbreviate(codeName, 21);
                	    documentoElectronico.setCodeName(codeName);
         
                	  //extension
                	    String extension=documentoElectronico.getName().substring(documentoElectronico.getName().lastIndexOf(".") + 1,
                		    documentoElectronico.getName().length());
                	    documentoElectronico.setExtension(extension);
                	
                	    //contenido
                	    DocumentoElectronicoAnexoContenidoVO contenido=new DocumentoElectronicoAnexoContenidoVO();
                	    // Contenido del fichero
                	    JSONArray arrayContent = (JSONArray)parser.parse(contentDocument);
        
                	    LinkedList<byte[]> blocksContent = new LinkedList<byte[]>();
                	    JSONObject blockContent = null;
                	    for(int i=0;i<arrayContent.size();i++){
                		blockContent = (JSONObject)arrayContent.get(i);
                		blocksContent.add(Base64.decodeBase64((String)blockContent.get("block")));
                	    }
                	    ByteArrayOutputStream osContent = new ByteArrayOutputStream();
                	        for (byte[] b : blocksContent) {
                	            osContent.write(b, 0, b.length);
                	    }
                	    byte [] content = osContent.toByteArray();
                	    osContent.close();
                	    contenido.setContent(content);
        
                	    documentoElectronico.setContenido(contenido);
                	    
                	    //TIPO MIME
                	   // MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap();
                	   // documentoElectronico.setMimeType(mimeTypesMap.getContentType());
                	   try{
                	       if (ContentTypeEnum.valueOf(extension.toUpperCase()) != null 
                        		    && ContentTypeEnum.valueOf(extension.toUpperCase()).getContentType().length() <= 20){
                		   documentoElectronico.setMimeType(ContentTypeEnum.valueOf(extension.toUpperCase()).getContentType());
                         	}
                	   }catch(Exception e){}
                	    //TIPO DOCUMENTO
                	    documentoElectronico.setTipoDocumentoAnexo(TipoDocumentoAnexoEnumVO.DOCUMENTO_ADJUNTO_FORMULARIO);
        	    
                	    if (validateDocument != null){
                		documentoElectronico.setTipoValidez(TipoValidezDocumentoAnexoEnumVO.getEnum(Integer.valueOf(validateDocument.substring(1, 2))));
                	    }
                	    
                	  //datos hash
                	    DocumentoElectronicoAnexoDatosFirmaVO datosFirmaDocumento= new DocumentoElectronicoAnexoDatosFirmaVO();
                	    
                	    UtilsHash utilHash = new UtilsHash ();
                	    String hashDocumento= UtilsHash.getBase64Sring(utilHash.generarHash(content));
                	    datosFirmaDocumento.setHash(hashDocumento);
        
                	    documentoElectronico.setDatosFirma(datosFirmaDocumento);
                	   //FIRMAS
               	    	   List<DocumentoElectronicoAnexoVO> firmas=new ArrayList<DocumentoElectronicoAnexoVO>();
               	    	   DocumentoElectronicoAnexoVO firmaDocumento= new DocumentoElectronicoAnexoVO();
               	    	   if (signDocument != null && !"".equals(signDocument)){
               	    	       	IdentificadorDocumentoElectronicoAnexoVO idFima= new IdentificadorDocumentoElectronicoAnexoVO();
                        	
                		idFima.setIdLibro(identificadorDocumentoElectronicoAnexoVO.getIdLibro());
                		idFima.setIdRegistro(identificadorDocumentoElectronicoAnexoVO.getIdRegistro());
                		firmaDocumento.setId(idFima);
                		String codeNameFirma="codeNameSign"+documentoElectronico.getName();
                		codeNameFirma=StringUtils.abbreviate(codeNameFirma, 21);
                		firmaDocumento.setCodeName(codeNameFirma);
                		
                		//contenido
                		DocumentoElectronicoAnexoContenidoVO contenidoFirma=new DocumentoElectronicoAnexoContenidoVO();
                		JSONArray arraySignContent = (JSONArray)parser.parse(signDocument);
        
                         	    LinkedList<byte[]> blocksSignContent = new LinkedList<byte[]>();
                         	   JSONObject blockSignContent = null;
                         	    for(int i=0;i<arraySignContent.size();i++){
                         		blockSignContent = (JSONObject)arraySignContent.get(i);
                         		blocksSignContent.add(Base64.decodeBase64((String)blockSignContent.get("block")));
                         	    }
                         	    ByteArrayOutputStream osSignContent = new ByteArrayOutputStream();
                         	        for (byte[] b : blocksSignContent) {
                         	       osSignContent.write(b, 0, b.length);
                         	    }
                         	byte [] signcontent = osSignContent.toByteArray();
                         	osSignContent.close();
                	    	contenidoFirma.setContent(signcontent);
                	    	firmaDocumento.setContenido(contenidoFirma);
                	    	//extension firma
                	    	String extensionFirma="csig";
                		firmaDocumento.setExtension(extensionFirma);
                		
                		//datos hash
                	    	DocumentoElectronicoAnexoDatosFirmaVO datosFirmaDocumentoFirma= new DocumentoElectronicoAnexoDatosFirmaVO();
                	    	 String hashDocumentoFirma= UtilsHash.getBase64Sring(utilHash.generarHash(signcontent));
                	    	
                	    	 datosFirmaDocumentoFirma.setHash(hashDocumentoFirma);
                                firmaDocumento.setDatosFirma(datosFirmaDocumentoFirma);
                                //NOMBRE FICHERO FIRMA
                               
                                String nameFirma= "FIRMA.csig";
                                firmaDocumento.setName(nameFirma);
                        	firmaDocumento.setTipoDocumentoAnexo(TipoDocumentoAnexoEnumVO.FICHERO_TECNICO);
                     	    	firmaDocumento.setTipoValidez(TipoValidezDocumentoAnexoEnumVO.ORIGINAL);
        
                         	if (certificateDocument != null){
                                   datosFirmaDocumentoFirma.setCertificado(certificateDocument);
                               }
                              /* if (anexoVerificado.getFirma().getFirma() != null){
                                   String firma=new String(anexoVerificado.getFirma().getFirma());
                                   datosFirmaDocumentoFirma.setFirma(firma);
                               }*/
                               firmaDocumento.setDatosFirma(datosFirmaDocumentoFirma);
                               firmas.add(firmaDocumento);
                               documentoElectronico.setFirmas(firmas);
                               
                    		
        		}
        		/*else {
        		    FacesContext.getCurrentInstance().addMessage(
        			    null,
        			    new FacesMessage(FacesMessage.SEVERITY_ERROR,
        				    "No se ha podido adjuntar el documento. Extensi�n no v�lida: "
        					    + documentoElectronico.getName(),
        				    "No se ha podido adjuntar el documento. Extensi�n no v�lida: "
        					    + documentoElectronico.getName()));
        		}*/
               	    UsuarioVO usuario =
        			(UsuarioVO) FacesContext.getCurrentInstance().getExternalContext()
        				.getSessionMap().get("USERVO");
               	    DocumentoElectronicoAnexoVO documentSaved =
        			registerDocumentsBo.saveDocuments(useCaseConf.getSessionID(), book.getId(),
        				outputRegisterBean.getFdrid(), documentoElectronico, registerData,
        				useCaseConf.getLocale(), useCaseConf.getEntidadId(),usuario);
        		if (documentSaved != null) {
        		    getRegisterAttachedDocuments();
        		    FacesContext.getCurrentInstance().addMessage(
        			    null,
        			    new FacesMessage(FacesMessage.SEVERITY_INFO,
        				    "Se ha adjuntado el documento " + documentoElectronico.getName()
        					    + " correctamente", "Se ha adjuntado el documento "
        					    + documentoElectronico.getName() + " correctamente"));
        		}
        	    }
        	    else {
        		FacesContext
        			.getCurrentInstance()
        			.addMessage(
        				null,
        				new FacesMessage(
        					FacesMessage.SEVERITY_ERROR,
        					"No se ha podido adjuntar el documento. El nombre del fichero no puede tener mas de 64 caracteres: "
        						+ documentoElectronico.getName(),
        					"No se ha podido adjuntar el documento. El nombre del fichero no puede tener mas de 64 caracteres: "
        						+ documentoElectronico.getName()));
        	    }
		}else {
		    ValidationBo.showDialog("Adjuntar", new FacesMessage(FacesMessage.SEVERITY_WARN, "",
			    "No se ha podido adjuntar el documento. El nombre del fichero ya existe"));  
	   }
	}
	catch (RPRegisterException e) {
	    LOG.error(ErrorConstants.SAVE_ASOC_REGISTER_ERROR_MESSAGE + ". C�digo: "
		    + e.getCode().getCode() + " . Mensaje: " + e.getMessage());
	    Utils.redirectToErrorPage(e, null, null);
	}
	catch (ParseException e) {
	    LOG.error(ErrorConstants.SAVE_INPUT_REGISTER_ERROR_MESSAGE + ".  Mensaje: " + e.getMessage());
	   
	}
	catch (IOException e) {
	    LOG.error(ErrorConstants.SAVE_INPUT_REGISTER_ERROR_MESSAGE + ".  Mensaje: " + e.getMessage());
	}finally{
		documentoElectronico = new DocumentoElectronicoAnexoVO ();
		validateDocument = null;
		contentDocument = null;
		signDocument = null;
		certificateDocument = null;
		    
	    }
    }
   
    
    /**
     * Alterna entre paneles del acorde�n de la p�gina mediante el evento
     * tabChangeEvent de Ajax.
     * 
     * @param tabChangeEvent
     *            Evento de cambio de panel.
     */
    public void changeListener(
	TabChangeEvent tabChangeEvent) {
	deleteSession ("reportsLabelAction");
	String tabId = tabChangeEvent.getTab().getId();
	if ("outputRegisterData".equals(tabId)) {
	    this.setMyCurrentTab(0);
	    if (outputRegisterBean == null) {
		loadOutputRegister();
	    }
	}
	else if ("outputRegisterAttachedDocuments".equals(tabId)) {
	    this.setMyCurrentTab(1);
	    if (listDocuments == null) {
		getRegisterAttachedDocuments();
	    }
	}
	else if ("outputRegisterHistorical".equals(tabId)) {
	    this.setMyCurrentTab(2);
	    // if (listUpdates == null) {
	    getRegisterHistoricalUpdates();
	    // }
	}
	else if ("outputRegisterDistributionHistorical".equals(tabId)) {
	    this.setMyCurrentTab(NUMBER3);
	    if (listHistDistribution == null) {
		getRegisterHistDistribution();
	    }
	}
	else if ("outputRegisterInterchangeHistorical".equals(tabId)) {
	    this.setMyCurrentTab(NUMBER4);
	    if (listHistInputInterchange == null &&
		listHistOutputInterchange == null) {
		getRegisterHistInputAndOutputInterchange();
	    }
	}
	else if ("outputRegisterAssociatedRegisters".equals(tabId)) {
	    this.setMyCurrentTab(NUMBER5);
	    if (asocReg == null) {
		getRegisterAssociatedRegisters();
	    }
	}
    }

    /**
     * Obtiene el valor del par�metro readOnly.
     * 
     * @return readOnly valor del campo a obtener.
     */
    public boolean isReadOnly() {
	return readOnly;
    }

    /**
     * Guarda el valor del par�metro readOnly.
     * 
     * @param readOnly
     *            valor del campo a guardar.
     */
    public void setReadOnly(
	boolean readOnly) {
	this.readOnly = readOnly;
    }

    /**
     * Obtiene el valor del par�metro registerCopy.
     * 
     * @return registerCopy valor del campo a obtener.
     */
    public Integer getRegisterCopy() {
	return registerCopy;
    }

    /**
     * Guarda el valor del par�metro registerCopy.
     * 
     * @param registerCopy
     *            valor del campo a guardar.
     */
    public void setRegisterCopy(
	Integer registerCopy) {
	this.registerCopy = registerCopy;
    }

    /**
     * Obtiene el valor del par�metro outputRegisterBo.
     * 
     * @return outputRegisterBo valor del campo a obtener.
     */
    public OutputRegisterBo getOutputRegisterBo() {
	return outputRegisterBo;
    }

    /**
     * Guarda el valor del par�metro outputRegisterBo.
     * 
     * @param outputRegisterBo
     *            valor del campo a guardar.
     */
    public void setInputRegisterBo(
	OutputRegisterBo outputRegisterBo) {
	this.outputRegisterBo = outputRegisterBo;
    }

    /**
     * Obtiene el valor del par�metro outputRegisterBean.
     * 
     * @return outputRegisterBean valor del campo a obtener.
     */
    public OutputRegisterBean getOutputRegisterBean() {
	return outputRegisterBean;
    }

    /**
     * Guarda el valor del par�metro outputRegisterBean.
     * 
     * @param outputRegisterBean
     *            valor del campo a guardar.
     */
    public void setOutputRegisterBean(
	OutputRegisterBean outputRegisterBean) {
	this.outputRegisterBean = outputRegisterBean;
    }

    /**
     * Obtiene el valor del par�metro listUpdates.
     * 
     * @return listUpdates valor del campo a obtener.
     */
    public List<UpdHisFdrResults> getListUpdates() {
	return listUpdates;
    }

    /**
     * Guarda el valor del par�metro listUpdates.
     * 
     * @param listUpdates
     *            valor del campo a guardar.
     */
    public void setListUpdates(
	List<UpdHisFdrResults> listUpdates) {
	this.listUpdates = listUpdates;
    }

    /**
     * Obtiene el valor del par�metro listHistDistribution.
     * 
     * @return listHistDistribution valor del campo a obtener.
     */
    public List<DtrFdrResults> getListHistDistribution() {
	return listHistDistribution;
    }

    /**
     * Guarda el valor del par�metro listHistDistribution.
     * 
     * @param listHistDistribution
     *            valor del campo a guardar.
     */
    public void setListHistDistribution(
	List<DtrFdrResults> listHistDistribution) {
	this.listHistDistribution = listHistDistribution;
    }

    /**
     * Obtiene el valor del par�metro origen.
     * 
     * @return origen valor del campo a obtener.
     */
    public String getOrigen() {
	return origen;
    }

    /**
     * Guarda el valor del par�metro origen.
     * 
     * @param origen
     *            valor del campo a guardar.
     */
    public void setOrigen(
	String origen) {
	this.origen = origen;
    }

    /**
     * Obtiene el valor del par�metro asocReg.
     * 
     * @return asocReg valor del campo a obtener.
     */
    public List<AxSf> getAsocReg() {
	return asocReg;
    }

    /**
     * Guarda el valor del par�metro asocReg.
     * 
     * @param asocReg
     *            valor del campo a guardar.
     */
    public void setAsocReg(
	List<AxSf> asocReg) {
	this.asocReg = asocReg;
    }

    /**
     * Obtiene el valor del par�metro asocRegPrim.
     * 
     * @return asocRegPrim valor del campo a obtener.
     */
    public AxSf getAsocRegPrim() {
	return asocRegPrim;
    }

    /**
     * Guarda el valor del par�metro asocRegPrim.
     * 
     * @param asocRegPrim
     *            valor del campo a guardar.
     */
    public void setAsocRegPrim(
	AxSf asocRegPrim) {
	this.asocRegPrim = asocRegPrim;
    }

    /**
     * Obtiene el valor del par�metro idocs.
     * 
     * @return idocs valor del campo a obtener.
     */
    public Map<String, Idocarchhdr> getIdocs() {
	return idocs;
    }

    /**
     * Guarda el valor del par�metro idocs.
     * 
     * @param idocs
     *            valor del campo a guardar.
     */
    public void setIdocs(
	Map<String, Idocarchhdr> idocs) {
	this.idocs = idocs;
    }

    /**
     * Obtiene el valor del par�metro asocRegisterBean.
     * 
     * @return asocRegisterBean valor del campo a obtener.
     */
    public AsocRegisterBean getAsocRegisterBean() {
	return asocRegisterBean;
    }

    /**
     * Guarda el valor del par�metro asocRegisterBean.
     * 
     * @param asocRegisterBean
     *            valor del campo a guardar.
     */
    public void setAsocRegisterBean(
	AsocRegisterBean asocRegisterBean) {
	this.asocRegisterBean = asocRegisterBean;
    }

    /**
     * Obtiene el valor del par�metro listHistInputInterchange.
     * 
     * @return listHistInputInterchange valor del campo a obtener.
     */
    public List<IntercambioRegistralEntradaVO> getListHistInputInterchange() {
	return listHistInputInterchange;
    }

    /**
     * Guarda el valor del par�metro listHistInputInterchange.
     * 
     * @param listHistInputInterchange
     *            valor del campo a guardar.
     */
    public void setListHistInputInterchange(
	List<IntercambioRegistralEntradaVO> listHistInputInterchange) {
	this.listHistInputInterchange = listHistInputInterchange;
    }

    /**
     * Obtiene el valor del par�metro listHistOutputInterchange.
     * 
     * @return listHistOutputInterchange valor del campo a obtener.
     */
    public List<IntercambioRegistralSalidaVO> getListHistOutputInterchange() {
	return listHistOutputInterchange;
    }

    /**
     * Guarda el valor del par�metro listHistOutputInterchange.
     * 
     * @param listHistOutputInterchange
     *            valor del campo a guardar.
     */
    public void setListHistOutputInterchange(
	List<IntercambioRegistralSalidaVO> listHistOutputInterchange) {
	this.listHistOutputInterchange = listHistOutputInterchange;
    }

    /**
     * Obtiene el valor del par�metro listDocuments.
     * 
     * @return listDocuments valor del campo a obtener.
     */
    public List<Axdoch> getListDocuments() {
	return listDocuments;
    }

    /**
     * Guarda el valor del par�metro listDocuments.
     * 
     * @param listDocuments
     *            valor del campo a guardar.
     */
    public void setListDocuments(
	List<Axdoch> listDocuments) {
	this.listDocuments = listDocuments;
    }

    /**
     * Obtiene el valor del par�metro myCurrentTab.
     * 
     * @return myCurrentTab valor del campo a obtener.
     */
    public int getMyCurrentTab() {
	return myCurrentTab;
    }

    /**
     * Guarda el valor del par�metro myCurrentTab.
     * 
     * @param myCurrentTab
     *            valor del campo a guardar.
     */
    public void setMyCurrentTab(
	int myCurrentTab) {
	this.myCurrentTab = myCurrentTab;
    }

    /**
     * Obtiene el valor del par�metro registerNumCopy.
     * 
     * @return registerNumCopy valor del campo a obtener.
     */
    public String getRegisterNumCopy() {
	return registerNumCopy;
    }

    /**
     * Guarda el valor del par�metro registerNumCopy.
     * 
     * @param registerNumCopy
     *            valor del campo a guardar.
     */
    public void setRegisterNumCopy(
	String registerNumCopy) {
	this.registerNumCopy = registerNumCopy;
    }
    
    /**
     * M�todo que actualiza el campo origen con el valor seleccionado en la
     * b�squeda avanzada de organismos.
     */
    public void updateOrigin() {
	ScrOrg unidad = null;
	if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(
	    "UNITSDIALOG") != null) {
	    unidad =
		(ScrOrg) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
		    .get(
			"UNITSDIALOG");
	    resetValues("accordion:outputRegisterDataForm:fld7");
	    getOutputRegisterBean().setFld7(unidad);
	}
    }

    /**
     * M�todo que actualiza el campo destino con el valor seleccionado en la
     * b�squeda avanzada de organismos.
     */
    public void updateDestination() {
	ScrOrg unidad = null;
	if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(
	    "UNITSDIALOG") != null) {
	    unidad =
		(ScrOrg) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
		    .get(
			"UNITSDIALOG");
	    resetValues("accordion:outputRegisterDataForm:fld8");
	    getOutputRegisterBean().setFld8(unidad);
	}
    }
    
    /**
     * Redirecciona a la p�gina de copiar desde el bot�n.
     */
    public void onRowSelectNavigateBottomCopy() {
	destroy1();
	FacesContext.getCurrentInstance().getExternalContext().getFlash().clear();
	Map<String, Object> parameter = new HashMap<String, Object>();
	parameter.put("registerCopy", outputRegisterBean.getFdrid());
	parameter.put("registerNumCopy", outputRegisterBean.getFld1());
	Utils.navigate(parameter, false, "outputRegister.xhtml");
    }

    /**
     * Redirecciona a la p�gina de nuevo desde el bot�n.
     */
    public void onRowSelectNavigateBottomNuevo() {
	clearView() ;
	FacesContext.getCurrentInstance().getExternalContext().getFlash().remove("registerCopy");
	FacesContext.getCurrentInstance().getExternalContext().getFlash().remove("registerSelect");
	FacesContext.getCurrentInstance().getExternalContext().getFlash().remove("readOnly");
	Utils.navigate("outputRegister.xhtml");
    }
    

    /**
     * borra el documento del registro.
     */
    public void deleteDocument() {
	if (registerDocumentsBo == null) {
	    registerDocumentsBo = new RegisterDocumentsBo();
	}
	try {
	    deleteSession ("reportsLabelAction");
	    LOG.info("borramos el documento registro " + outputRegisterBean.getFdrid());
	    if (selectDocument != null){
		registerDocumentsBo.deleteDocument(useCaseConf, book.getId(),
			    outputRegisterBean.getFdrid(),selectDocument.getId().intValue());
		getRegisterAttachedDocuments();
	    }
	}
	catch (RPRegisterException rPRegisterException) {
	    LOG.error(ErrorConstants.DELETE_REGISTER_DOCUMENTS_ERROR_MESSAGE, rPRegisterException);
	}
    }
    
    /**
     * Borra los datos de la distribuci�n y crea una vac�o.
     * 
     */
    @SuppressWarnings("unchecked")
    public void reinitDis() {
	try{
    	deleteSession ("reportsLabelAction");
    	if (outputRegisterBean.getFld8() != null && outputRegisterBean.getFld8().getId() != null){
    	    List<Integer> orgIds = new ArrayList<Integer>();
    	    orgIds.add(outputRegisterBean.getFld8().getId());
    	    this.listDepartament = ValidationListBo.getDeptsGroupsUsers(useCaseConf.getSessionID(),
    		typeDestinoRedis, useCaseConf.getEntidadId(), orgIds);
    	    this.setSelectdestinoRedisDepartamentos(Utils.defaultDepart(this.listDepartament,
    		outputRegisterBean.getFld8().getId()));
    	} else {
    	    this.listDepartament = ValidationListBo.getDeptsGroupsUsers(useCaseConf.getSessionID(),
    		typeDestinoRedis, useCaseConf.getEntidadId(), null);
    	    this.setSelectdestinoRedisDepartamentos(null);
    	}
	}
	catch (SessionException sessionException) {
	    LOG.error(
		ErrorConstants.GET_INFORMATION_LISTS_ERROR_MESSAGE, sessionException);
	    Utils.redirectToErrorPage(
		null, sessionException, null);
	}
	catch (ValidationException validationException) {
	    LOG.error(
		ErrorConstants.GET_INFORMATION_LISTS_ERROR_MESSAGE, validationException);
	    Utils.redirectToErrorPage(
		null, validationException, null);
	}
    }
    
    /**
     * M�todo que distribuye de los elementos seleccionados.
     * 
     * @throws SessionException
     *             errror de sessi�n.
     */
    public void distribuir() throws SessionException {
	init();
	deleteSession ("reportsLabelAction");
	ScrRegstate book =
		(ScrRegstate) facesContext.getExternalContext().getSessionMap().get(KeysRP.J_BOOK);
	if (book == null) {
	    throw new SessionException(SessionException.ERROR_SESSION_EXPIRED);
	}
	if (distributionBo == null) {
	    distributionBo = new DistributionBo();
	}
	try {

	    Integer userId = selectdestinoRedisDepartamentos.getId();

	    List<Integer> ids = new ArrayList<Integer>();
	    ids.add(outputRegisterBean.getFdrid());
	    String result =
		    distributionBo.createDistribution(useCaseConf, ids, motivoDistribucion,
			    typeDestinoRedis, userId, book.getId());
	    // distribucion
	    distributionBo = new DistributionBo();
	    listHistDistribution =
		    distributionBo.getHistDistribution(useCaseConf, book.getId(),
			    outputRegisterBean.getFdrid());
	    if ("".equals(result.trim())) {
		result = "Se han distribuido los registros correctamente.";
		canDistr = false;
		RequestContext context = RequestContext.getCurrentInstance();
		context.update("formLink");
	    }
	    result = result.replaceAll(";", "<br/>");
	    FacesContext.getCurrentInstance().addMessage(null,
		    new FacesMessage(FacesMessage.SEVERITY_INFO, result, result));
	    RequestContext.getCurrentInstance().update("messagesform:messages");
	}
	catch (RPDistributionException e) {
	    LOG.error(ErrorConstants.REDISTRIBUTION_DISTRIBUTION_ERROR_MESSAGE, e);
	    Utils.redirectToErrorPage(e, null, null);
	}
	catch (RPGenericException e) {
	    LOG.error(ErrorConstants.REDISTRIBUTION_DISTRIBUTION_ERROR_MESSAGE, e);
	    Utils.redirectToErrorPage(e, null, null);
	}
	catch (BookException bookException) {
	    LOG.error(ErrorConstants.REDISTRIBUTION_DISTRIBUTION_ERROR_MESSAGE, bookException);
	    Utils.redirectToErrorPage(null, bookException, null);
	}
	catch (SessionException sessionException) {
	    LOG.error(ErrorConstants.REDISTRIBUTION_DISTRIBUTION_ERROR_MESSAGE, sessionException);
	    Utils.redirectToErrorPage(null, sessionException, null);
	}
	catch (ValidationException validationException) {
	    LOG.error(ErrorConstants.REDISTRIBUTION_DISTRIBUTION_ERROR_MESSAGE, validationException);
	    Utils.redirectToErrorPage(null, validationException, null);
	}
    }

    
    /**
     * Obtiene el valor del par�metro canDistr.
     * 
     * @return canDistr valor del campo a obtener.
     */
    public boolean getCanDistr() {
	return canDistr;
    }

    /**
     * Guarda el valor del par�metro canDistr.
     * 
     * @param canDistr
     *            valor del campo a guardar.
     */
    public void setCanDistr(boolean canDistr) {
	this.canDistr = canDistr;
    }
    
    /**
     * Obtiene el valor del par�metro selectedDocSIR.
     * 
     * @return selectedDocSIR valor del campo a obtener.
     */
    public String getSelectedDocSIR() {
	return selectedDocSIR;
    }

    /**
     * Guarda el valor del par�metro selectedDocSIR.
     * 
     * @param selectedDocSIR
     *            valor del campo a guardar.
     */
    public void setSelectedDocSIR(String selectedDocSIR) {
	this.selectedDocSIR = selectedDocSIR;
    }
    /**
     * Guarda el valor del par�metro readOnlyIR.
     * 
     * @param readOnlyIR
     *            valor del campo a guardar.
     */
    public void setReadOnlyIR(boolean readOnlyIR) {
	this.readOnlyIR = readOnlyIR;
    }
    /**
     * Obtiene el valor del par�metro readOnlyIR.
     * 
     * @return readOnlyIR valor del campo a obtener.
     */
    public boolean isReadOnlyIR() {
	return readOnlyIR;
    }


    public String getContentDocument() {
        return contentDocument;
    }
    /**
     * Guarda el valor del par�metro contentDocument.
     * 
     * @param contentDocument
     *            valor del campo a guardar.
     */
    public void setContentDocument(String contentDocument) {
        this.contentDocument = contentDocument;
    }

    /**
     * Obtiene el valor del par�metro documentoElectronico.
     * 
     * @return documentoElectronico valor del campo a obtener.
     */
    public DocumentoElectronicoAnexoVO getDocumentoElectronico() {
        return documentoElectronico;
    }
    /**
     * Guarda el valor del par�metro documentoElectronico.
     * 
     * @param documentoElectronico
     *            valor del campo a guardar.
     */
    public void setDocumentoElectronico(DocumentoElectronicoAnexoVO documentoElectronico) {
        this.documentoElectronico = documentoElectronico;
    }
    /**
     * Obtiene el valor del par�metro validateDocument.
     * 
     * @return validateDocument valor del campo a obtener.
     */
    public String getValidateDocument() {
        return validateDocument;
    }
    /**
     * Guarda el valor del par�metro validateDocument.
     * 
     * @param validateDocument
     *            valor del campo a guardar.
     */
    public void setValidateDocument(String validateDocument) {
        this.validateDocument = validateDocument;
    }
    /**
     * Obtiene el valor del par�metro signDocument.
     * 
     * @return signDocument valor del campo a obtener.
     */
    public String getSignDocument() {
        return signDocument;
    }
    /**
     * Guarda el valor del par�metro signDocument.
     * 
     * @param signDocument
     *            valor del campo a guardar.
     */
    public void setSignDocument(String signDocument) {
        this.signDocument = signDocument;
    }
    /**
     * Obtiene el valor del par�metro certificateDocument.
     * 
     * @return certificateDocument valor del campo a obtener.
     */
    public String getCertificateDocument() {
        return certificateDocument;
    }
    /**
     * Guarda el valor del par�metro certificateDocument.
     * 
     * @param certificateDocument
     *            valor del campo a guardar.
     */
    public void setCertificateDocument(String certificateDocument) {
        this.certificateDocument = certificateDocument;
    }
    /**
     * Obtiene el valor del par�metro selectDocument.
     * 
     * @return selectDocument valor del campo a obtener.
     */
    public Axdoch getSelectDocument() {
        return selectDocument;
    }
    /**
     * Guarda el valor del par�metro selectDocument.
     * 
     * @param selectDocument
     *            valor del campo a guardar.
     */
    public void setSelectDocument(Axdoch selectDocument) {
        this.selectDocument = selectDocument;
    }
    /**
     * Obtiene el valor del par�metro listNameDocument.
     * 
     * @return listNameDocument valor del campo a obtener.
     */
    public String getListNameDocument() {
        return listNameDocument;
    }
    /**
     * Guarda el valor del par�metro listNameDocument.
     * 
     * @param listNameDocument
     *            valor del campo a guardar.
     */
    public void setListNameDocument(String listNameDocument) {
        this.listNameDocument = listNameDocument;
    }
    
    public void deleteLabel()  {
	init();
	deleteSession ("reportsLabelAction");
    }

    /**
     * Obtiene el valor del par�metro motivoDistribucion.
     * 
     * @return motivoDistribucion valor del campo a obtener.
     */
    public String getMotivoDistribucion() {
	return motivoDistribucion;
    }

    /**
     * Guarda el valor del par�metro motivoDistribucion.
     * 
     * @param motivoDistribucion
     *            valor del campo a guardar.
     */
    public void setMotivoDistribucion(String motivoDistribucion) {
	this.motivoDistribucion = motivoDistribucion;
    }

    /**
     * Obtiene el valor del par�metro selectdestinoRedisDepartamentos.
     * 
     * @return selectdestinoRedisDepartamentos valor del campo a obtener.
     */
    public Iuserdepthdr getSelectdestinoRedisDepartamentos() {
	return selectdestinoRedisDepartamentos;
    }

    /**
     * Guarda el valor del par�metro selectdestinoRedisDepartamentos.
     * 
     * @param selectdestinoRedisDepartamentos
     *            valor del campo a guardar.
     */
    public void setSelectdestinoRedisDepartamentos(Iuserdepthdr selectdestinoRedisDepartamentos) {
	this.selectdestinoRedisDepartamentos = selectdestinoRedisDepartamentos;
    }
    
    /**
     * Obtiene el valor del par�metro fileUpload.
     * 
     * @return fileUpload valor del campo a obtener.
     */
    public UploadedFile getFileUpload() {
        return fileUpload;
    }
    /**
     * Guarda el valor del par�metro fileUpload.
     * 
     * @param fileUpload
     *            valor del campo a guardar.
     */
    public void setFileUpload(UploadedFile fileUpload) {
        this.fileUpload = fileUpload;
    }
    /**
     * Obtiene el valor del par�metro listDepartament.
     * 
     * @return listDepartament valor del campo a obtener.
     */
    public List<Iuserdepthdr> getListDepartament() {
        return listDepartament;
    }
    /**
     * Guarda el valor del par�metro listDepartament.
     * 
     * @param listDepartament
     *            valor del campo a guardar.
     */
    public void setListDepartament(List<Iuserdepthdr> listDepartament) {
        this.listDepartament = listDepartament;
    }


}