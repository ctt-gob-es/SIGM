package ieci.tecdoc.sgm.registropresencial.ws.server;

import ieci.tecdoc.sgm.core.exception.SigemException;
import ieci.tecdoc.sgm.core.services.ConstantesServicios;
import ieci.tecdoc.sgm.core.services.LocalizadorServicios;
import ieci.tecdoc.sgm.core.services.ServiciosUtils;
import ieci.tecdoc.sgm.core.services.dto.Entidad;
import ieci.tecdoc.sgm.core.services.dto.RetornoServicio;
import ieci.tecdoc.sgm.core.services.registro.PersonInfo;
import ieci.tecdoc.sgm.core.services.registro.RegistroException;
import ieci.tecdoc.sgm.core.services.registro.ServicioRegistro;
import ieci.tecdoc.sgm.core.ws.axis.UtilAxis;
import ieci.tecdoc.sgm.registropresencial.ws.server.util.UtilsWebService;

import javax.xml.soap.SOAPException;

import org.apache.log4j.Logger;

/**
 * Clase que contiene los m�todos que son publicados en el Servicio web
 *
 */
public class ServicioRegistroWebService {

	private static final Logger logger = Logger
			.getLogger(ServicioRegistroWebService.class);

	private static final String SERVICE_NAME = ConstantesServicios.SERVICE_REGISTRY;

	/**
	 * M�todo para crear un nuevo registro.
	 *
	 * @param user
	 *            usuario que se conecta (obligatorio).
	 * @param inter
	 *            interesados (no obligatorio).
	 * @param folder
	 *            informaci�n necesaria para crear el registro (identificador de
	 *            libro, datos de los campos con los que se va a crear el
	 *            registro y opcionalmente los documentos anexos). Es
	 *            obligatorio.
	 * @param entidad
	 * @return devuelve informaci�n del registro creado (n�mero de
	 *         registro,...).
	 */
	public ieci.tecdoc.sgm.registropresencial.ws.server.RegisterInfo createFolder(
			ieci.tecdoc.sgm.registropresencial.ws.server.UserInfo user,
			ieci.tecdoc.sgm.registropresencial.ws.server.PersonInfo[] inter,
			ieci.tecdoc.sgm.registropresencial.ws.server.Folder folder,
			Entidad entidad) {
		try {
			ieci.tecdoc.sgm.registropresencial.ws.server.RegisterInfo oRegInfo = UtilsWebService
					.getRegisterInfoWS(getServicioRegistro().createFolder(
							UtilsWebService.getUserInfo(user),
							UtilsWebService.getBookId(folder),
							UtilsWebService.getFieldsInfo(folder),
							UtilsWebService.getPersonInfo(inter),
							UtilsWebService.getDocumentsInfo(folder), entidad));
			return (ieci.tecdoc.sgm.registropresencial.ws.server.RegisterInfo) ServiciosUtils
					.completeReturnOK(oRegInfo);
		} catch (RegistroException e) {
			logger.error("Error al crear un nuevo registro.", e);
			return (RegisterInfo) ServiciosUtils.completeReturnError(
					(RegisterInfo) (new RegisterInfo()), e.getErrorCode());
		} catch (SigemException e) {
			logger.error("Error al crear un nuevo registro.", e);
			return (RegisterInfo) ServiciosUtils.completeReturnError(
					(RegisterInfo) (new RegisterInfo()), e.getErrorCode());
		} catch (Throwable e) {
			logger.error("Error inesperado al crear un nuevo registro.", e);
			return (RegisterInfo) ServiciosUtils
					.completeReturnError((RetornoServicio) (new RegisterInfo()));
		}
	}

	/**
	 * Metodo para actualizar un nuevo registro
	 *
	 * @param user
	 *            usuario que se conecta (obligatorio).
	 * @param inter
	 *            interesados que se desean actualizar (no obligatorio).
	 * @param folder
	 *            informaci�n que se quiere actualizar (identificador de libro,
	 *            datos de los campos con los que se va a crear el registro y
	 *            opcionalmente los documentos anexos). Es obligatorio.
	 * @param entidad
	 * @return devuelve informaci�n del registro actualizado (n�mero de
	 *         registro,...).
	 */
	public ieci.tecdoc.sgm.registropresencial.ws.server.RegisterInfo updateFolder(
			ieci.tecdoc.sgm.registropresencial.ws.server.UserInfo user,
			ieci.tecdoc.sgm.registropresencial.ws.server.PersonInfo[] inter,
			Folder folder, Entidad entidad) {
		try {
			ieci.tecdoc.sgm.registropresencial.ws.server.RegisterInfo oRegInfo = UtilsWebService
					.getRegisterInfoWS(getServicioRegistro().updateFolder(
							UtilsWebService.getUserInfo(user),
							UtilsWebService.getBookId(folder),
							UtilsWebService.getFolderId(folder),
							UtilsWebService.getFieldsInfo(folder),
							UtilsWebService.getPersonInfo(inter),
							UtilsWebService.getDocumentsInfo(folder), entidad));
			return (ieci.tecdoc.sgm.registropresencial.ws.server.RegisterInfo) ServiciosUtils
					.completeReturnOK(oRegInfo);
		} catch (RegistroException e) {
			logger.error("Error al actualizar un registro.", e);
			return (RegisterInfo) ServiciosUtils.completeReturnError(
					(RegisterInfo) (new RegisterInfo()), e.getErrorCode());
		} catch (SigemException e) {
			logger.error("Error al actualizar un registro.", e);
			return (RegisterInfo) ServiciosUtils.completeReturnError(
					(RegisterInfo) (new RegisterInfo()), e.getErrorCode());
		} catch (Throwable e) {
			logger.error("Error inesperado al actualizar un registro.", e);
			return (RegisterInfo) ServiciosUtils
					.completeReturnError((RetornoServicio) (new RegisterInfo()));
		}
	}

	/**
	 * M�todo para importar un registro (consolidaci�n).
	 *
	 * @param user
	 *            usuario que se conecta (obligatorio).
	 * @param inter
	 *            interesados (no obligatorio).
	 * @param folder
	 *            informaci�n necesaria para crear el registro (identificador de
	 *            libro, datos de los campos con los que se va a crear el
	 *            registro y opcionalmente los documentos anexos). Es
	 *            obligatorio.
	 * @param entidad
	 * @return devuelve informaci�n del registro creado (n�mero de
	 *         registro,...).
	 */
	public ieci.tecdoc.sgm.registropresencial.ws.server.RegisterInfo importFolder(
			ieci.tecdoc.sgm.registropresencial.ws.server.UserInfo user,
			ieci.tecdoc.sgm.registropresencial.ws.server.PersonInfo[] inter,
			Folder folder, Entidad entidad) {
		try {
			ieci.tecdoc.sgm.registropresencial.ws.server.RegisterInfo oRegInfo = UtilsWebService
					.getRegisterInfoWS(getServicioRegistro().importFolder(
							UtilsWebService.getUserInfo(user),
							UtilsWebService.getBookId(folder),
							UtilsWebService.getFieldsInfo(folder),
							UtilsWebService.getPersonInfo(inter),
							UtilsWebService.getDocumentsInfo(folder), entidad));
			return (ieci.tecdoc.sgm.registropresencial.ws.server.RegisterInfo) ServiciosUtils
					.completeReturnOK(oRegInfo);
		} catch (RegistroException e) {
			logger.error("Error al importar un registro.", e);
			return (RegisterInfo) ServiciosUtils.completeReturnError(
					(RegisterInfo) (new RegisterInfo()), e.getErrorCode());
		} catch (SigemException e) {
			logger.error("Error al importar un registro.", e);
			return (RegisterInfo) ServiciosUtils.completeReturnError(
					(RegisterInfo) (new RegisterInfo()), e.getErrorCode());
		} catch (Throwable e) {
			logger.error("Error al importar un registro.", e);
			return (RegisterInfo) ServiciosUtils
					.completeReturnError((RetornoServicio) (new RegisterInfo()));
		}
	}

	/**
	 * M�todo para importar un registro (consolidaci�n).
	 *
	 * @param user
	 *            usuario que se conecta (obligatorio).
	 * @param inter
	 *            interesados (no obligatorio).
	 * @param folder
	 *            informaci�n necesaria para crear el registro (identificador de
	 *            libro, datos de los campos con los que se va a crear el
	 *            registro y opcionalmente los documentos anexos). Es
	 *            obligatorio.
	 * @param entidad
	 * @return devuelve informaci�n del registro creado (n�mero de
	 *         registro,...).
	 */
	public ieci.tecdoc.sgm.registropresencial.ws.server.RegisterInfo consolidateFolder(
			ieci.tecdoc.sgm.registropresencial.ws.server.UserInfo user,
			ieci.tecdoc.sgm.registropresencial.ws.server.PersonInfo[] inter,
			Folder folder, Entidad entidad) {
		try {
			ieci.tecdoc.sgm.registropresencial.ws.server.RegisterInfo oRegInfo = UtilsWebService
					.getRegisterInfoWS(getServicioRegistro().consolidateFolder(
							UtilsWebService.getUserInfo(user),
							UtilsWebService.getBookId(folder),
							UtilsWebService.getFieldsInfo(folder),
							UtilsWebService.getPersonInfo(inter),
							UtilsWebService.getDocumentsInfo(folder), entidad));
			return (ieci.tecdoc.sgm.registropresencial.ws.server.RegisterInfo) ServiciosUtils
					.completeReturnOK(oRegInfo);
		} catch (RegistroException e) {
			logger.error("Error al importar un registro.", e);
			return (RegisterInfo) ServiciosUtils.completeReturnError(
					(RegisterInfo) (new RegisterInfo()), e.getErrorCode());
		} catch (SigemException e) {
			logger.error("Error al importar un registro.", e);
			return (RegisterInfo) ServiciosUtils.completeReturnError(
					(RegisterInfo) (new RegisterInfo()), e.getErrorCode());
		} catch (Throwable e) {
			logger.error("Error al importar un registro.", e);
			return (RegisterInfo) ServiciosUtils
					.completeReturnError((RetornoServicio) (new RegisterInfo()));
		}
	}

	/**
	 * M�todo que realiza la busqueda de registro en funcion de los criterios de
	 * busqueda introducidos
	 *
	 * @param user
	 *            usuario que se conecta (obligatorio).
	 * @param folderQuery:
	 *            Criterios de busqueda
	 * @param entidad
	 * @return devuelve una lista con los registros que cumplen los criterios de
	 *         busqueda
	 */
	public ieci.tecdoc.sgm.registropresencial.ws.server.RegistersInfo findFolder(
			ieci.tecdoc.sgm.registropresencial.ws.server.UserInfo user,
			ieci.tecdoc.sgm.registropresencial.ws.server.FolderSearchCriteria folderQuery,
			Entidad entidad) {
		try {
			ieci.tecdoc.sgm.registropresencial.ws.server.RegistersInfo oRegsInfo = UtilsWebService
					.getRegistersInfoWS(getServicioRegistro().findFolder(
							UtilsWebService.getUserInfo(user),
							UtilsWebService.getBookId(folderQuery),
							UtilsWebService.getFieldsInfoQueries(folderQuery),
							entidad));
			return (ieci.tecdoc.sgm.registropresencial.ws.server.RegistersInfo) ServiciosUtils
					.completeReturnOK(oRegsInfo);
		} catch (RegistroException e) {
			logger.error("Error al buscar registros.", e);
			return (RegistersInfo) ServiciosUtils.completeReturnError(
					(RegistersInfo) (new RegistersInfo()), e.getErrorCode());
		} catch (SigemException e) {
			logger.error("Error al buscar registros.", e);
			return (RegistersInfo) ServiciosUtils.completeReturnError(
					(RegistersInfo) (new RegistersInfo()), e.getErrorCode());
		} catch (Throwable e) {
			logger.error("Error al buscar registros.", e);
			return (RegistersInfo) ServiciosUtils
					.completeReturnError((RetornoServicio) (new RegisterInfo()));
		}
	}

	/**
	 * M�todo para consultar un registro de entrada.
	 *
	 * @param user
	 *            usuario que se conecta (obligatorio).
	 * @param folder
	 *            informaci�n necesaria para consultar el registro (n�mero de
	 *            registro a consultar). Es obligatorio.
	 * @param entidad
	 * @return devuelve los datos del registro.
	 */
	public Folder getInputFolderForNumber(
			ieci.tecdoc.sgm.registropresencial.ws.server.UserInfo user,
			Folder folder, Entidad entidad) {
		try {
			Folder oFolder = UtilsWebService
					.getFieldsInfoWS(getServicioRegistro()
							.getInputFolderForNumber(
									UtilsWebService.getUserInfo(user),
									UtilsWebService.getBookId(folder),
									folder.getFolderNumber(), entidad));
			return (Folder) ServiciosUtils.completeReturnOK(oFolder);
		} catch (RegistroException e) {
			logger.error(
					"Error obtener la informacion de un registro de entrada.",
					e);
			return (Folder) ServiciosUtils.completeReturnError(
					(Folder) (new Folder()), e.getErrorCode());
		} catch (SigemException e) {
			logger.error(
					"Error obtener la informacion de un registro de entrada.",
					e);
			return (Folder) ServiciosUtils.completeReturnError(
					(Folder) (new Folder()), e.getErrorCode());
		} catch (Throwable e) {
			logger
					.error(
							"Error inesperado al obtener la informacion de un registro de entrada.",
							e);
			return (Folder) ServiciosUtils
					.completeReturnError((RetornoServicio) (new Folder()));
		}
	}

	/**
	 * M�todo para consultar un registro de entrada y los remitentes de este
	 *
	 * @param user
	 *            usuario que se conecta (obligatorio).
	 * @param folder
	 *            informaci�n necesaria para consultar el registro (n�mero de
	 *            registro a consultar). Es obligatorio.
	 * @param entidad
	 * @return devuelve los datos del registro y los remitentes.
	 */
	public FolderWithPersonInfo getInputRegister(
			ieci.tecdoc.sgm.registropresencial.ws.server.UserInfo user,
			Folder folder, Entidad entidad) {
		try {
			FolderWithPersonInfo oFolder = UtilsWebService
					.getFieldsInfoPersonInfoWS(getServicioRegistro()
							.getInputRegister(
									UtilsWebService.getUserInfo(user),
									folder.getFolderNumber(), entidad));

			return (FolderWithPersonInfo) ServiciosUtils
					.completeReturnOK(oFolder);
		} catch (RegistroException e) {
			logger
					.error(
							"Error al obtener la informacion de un registro de entrada.",
							e);
			return (FolderWithPersonInfo) ServiciosUtils.completeReturnError(
					(FolderWithPersonInfo) (new FolderWithPersonInfo()), e
							.getErrorCode());
		} catch (SigemException e) {
			logger
					.error(
							"Error al obtener la informacion de un registro de entrada.",
							e);
			return (FolderWithPersonInfo) ServiciosUtils.completeReturnError(
					(FolderWithPersonInfo) (new FolderWithPersonInfo()), e
							.getErrorCode());
		} catch (Throwable e) {
			logger
					.error(
							"Error inesperado al obtener la informacion de un registro de entrada.",
							e);
			return (FolderWithPersonInfo) ServiciosUtils
					.completeReturnError((RetornoServicio) (new FolderWithPersonInfo()));
		}
	}

	/**
	 * M�todo para consultar un registro de salida.
	 *
	 * @param user
	 *            usuario que se conecta (obligatorio).
	 * @param folder
	 *            informaci�n necesaria para consultar el registro (n�mero de
	 *            registro a consultar). Es obligatorio.
	 * @param entidad
	 * @return devuelve los datos del registro.
	 */
	public Folder getOutputFolderForNumber(
			ieci.tecdoc.sgm.registropresencial.ws.server.UserInfo user,
			Folder folder, Entidad entidad) {
		try {
			Folder oFolder = UtilsWebService
					.getFieldsInfoWS(getServicioRegistro()
							.getOutputFolderForNumber(
									UtilsWebService.getUserInfo(user),
									UtilsWebService.getBookId(folder),
									folder.getFolderNumber(), entidad));
			return (Folder) ServiciosUtils.completeReturnOK(oFolder);
		} catch (RegistroException e) {
			logger
					.error(
							"Error obtener la informacion de un registro de salida.",
							e);
			return (Folder) ServiciosUtils.completeReturnError(
					(Folder) (new Folder()), e.getErrorCode());
		} catch (SigemException e) {
			logger
					.error(
							"Error obtener la informacion de un registro de salida.",
							e);
			return (Folder) ServiciosUtils.completeReturnError(
					(Folder) (new Folder()), e.getErrorCode());
		} catch (Throwable e) {
			logger
					.error(
							"Error inesperado al obtener la informacion de un registro de salida.",
							e);
			return (Folder) ServiciosUtils
					.completeReturnError((RetornoServicio) (new Folder()));
		}
	}

	/**
	 * M�todo para consultar un registro de salida y los destinatarios
	 *
	 * @param user
	 *            usuario que se conecta (obligatorio).
	 * @param folder
	 *            informaci�n necesaria para consultar el registro (n�mero de
	 *            registro a consultar). Es obligatorio.
	 * @param entidad
	 * @return devuelve los datos del registro y los destinatarios
	 */
	public FolderWithPersonInfo getOutputRegister(
			ieci.tecdoc.sgm.registropresencial.ws.server.UserInfo user,
			Folder folder, Entidad entidad) {
		try {
			FolderWithPersonInfo oFolder = UtilsWebService
					.getFieldsInfoPersonInfoWS(getServicioRegistro()
							.getOutputRegister(
									UtilsWebService.getUserInfo(user),
									folder.getFolderNumber(), entidad));

			return (FolderWithPersonInfo) ServiciosUtils
					.completeReturnOK(oFolder);
		} catch (RegistroException e) {
			logger
					.error(
							"Error al obtener la informacion de un registro de salida.",
							e);
			return (FolderWithPersonInfo) ServiciosUtils.completeReturnError(
					(FolderWithPersonInfo) (new FolderWithPersonInfo()), e
							.getErrorCode());
		} catch (SigemException e) {
			logger
					.error(
							"Error al obtener la informacion de un registro de salida.",
							e);
			return (FolderWithPersonInfo) ServiciosUtils.completeReturnError(
					(FolderWithPersonInfo) (new FolderWithPersonInfo()), e
							.getErrorCode());
		} catch (Throwable e) {
			logger
					.error(
							"Error inesperado al obtener la informacion de un registro de salida.",
							e);
			return (FolderWithPersonInfo) ServiciosUtils
					.completeReturnError((RetornoServicio) (new FolderWithPersonInfo()));
		}
	}

	/**
	 * M�todo para obtener un documento anexo a un registro determinado.
	 *
	 * @param user
	 *            usuario que se conecta (obligatorio).
	 * @param document
	 *            informaci�n necesaria para obtener el documento anexo
	 *            (identificadores de libro, registro, documento y p�gina). Es
	 *            obligatorio.
	 * @param entidad
	 * @return devuelve la informaci�n del documento y su contenido.
	 */
	public Document getDocumentFolder(
			ieci.tecdoc.sgm.registropresencial.ws.server.UserInfo user,
			Document document, Entidad entidad) {
		try {
			Document oDoc = UtilsWebService
					.getDocumentInfoWS(getServicioRegistro().getDocumentFolder(
							UtilsWebService.getUserInfo(user),
							UtilsWebService.getBookId(document.getFolder()),
							UtilsWebService.getFolderId(document.getFolder()),
							UtilsWebService.getDocId(document),
							UtilsWebService.getPageId(document), entidad));
			return (Document) ServiciosUtils.completeReturnOK(oDoc);
		} catch (RegistroException e) {
			logger.error("Error al obtener un documento.", e);
			return (Document) ServiciosUtils.completeReturnError(
					(Document) (new Document()), e.getErrorCode());
		} catch (SigemException e) {
			logger.error("Error al obtener un documento.", e);
			return (Document) ServiciosUtils.completeReturnError(
					(Document) (new Document()), e.getErrorCode());
		} catch (Throwable e) {
			logger.error("Error inesperado al obtener un documento.", e);
			return (Document) ServiciosUtils
					.completeReturnError((RetornoServicio) (new Document()));
		}
	}

	/**
	 * M�todo para obtener los datos de una distribuci�n de registro
	 *
	 * @param user
	 *            usuario que se conecta (obligatorio).
	 * @param distributionInfo:
	 *            Informaci�n de la distribuci�n que se va a tratar (obligatorio
	 *            el campo dtrId)
	 * @param entidad
	 * @return devuelve la distribuci�n de registro solicitado
	 */
	public DistributionInfo getDistribution(
			ieci.tecdoc.sgm.registropresencial.ws.server.UserInfo user,
			DistributionInfo distributionInfo, Entidad entidad) {
		try {
			ieci.tecdoc.sgm.core.services.registro.DistributionInfo oDInfo = new ieci.tecdoc.sgm.core.services.registro.DistributionInfo();
			oDInfo = getServicioRegistro().getDistribution(
					UtilsWebService.getUserInfo(user),
					UtilsWebService.getDistributionInfoId(distributionInfo),
					entidad);

			DistributionInfo oDInfoResult = UtilsWebService
					.getDistributionInfoWS(oDInfo);
			return (DistributionInfo) ServiciosUtils
					.completeReturnOK(oDInfoResult);
		} catch (RegistroException e) {
			logger.error("Error al obtener la distribuci�n de entrada.", e);
			return (DistributionInfo) ServiciosUtils.completeReturnError(
					(DistributionInfo) (new DistributionInfo()), e
							.getErrorCode());
		} catch (SigemException e) {
			logger.error("Error al obtener la distribuci�n de entrada.", e);
			return (DistributionInfo) ServiciosUtils.completeReturnError(
					(DistributionInfo) (new DistributionInfo()), e
							.getErrorCode());
		} catch (Throwable e) {
			logger.error(
					"Error inesperado al obtener la distribuci�n de entrada.",
					e);
			return (DistributionInfo) ServiciosUtils
					.completeReturnError((RetornoServicio) (new DistributionInfo()));
		}

	}

	/**
	 * M�todo para recupera el contenido de la bandeja de entrada asociada a un
	 * usuario.
	 *
	 * @param user
	 *            usuario que se conecta (obligatorio).
	 * @param criteria
	 *            criterio de busqueda indice del primer registro a obtener y
	 *            n�mero m�ximo de registros a obtener desde el offset anterior.
	 * @param entidad
	 * @return devuelve la lista de distribuci�n de entrada.
	 */
	public DistributionsInfo getInputDistribution(
			ieci.tecdoc.sgm.registropresencial.ws.server.UserInfo user,
			DistributionSearchCriteria criteria, Entidad entidad) {
		try {
			DistributionsInfo oDInfo = UtilsWebService
					.getDistributionsInfoWS(getServicioRegistro()
							.getInputDistribution(
									UtilsWebService.getUserInfo(user),
									new Integer(criteria.getState()),
									new Integer(criteria.getFirstRow()),
									new Integer(criteria.getMaxResults()),
									new Integer(criteria.getTypeBookRegister()),
									new Boolean(criteria.getOficAsoc()),
									entidad));
			return (DistributionsInfo) ServiciosUtils.completeReturnOK(oDInfo);
		} catch (RegistroException e) {
			logger.error("Error al obtener la distribuci�n de entrada.", e);
			return (DistributionsInfo) ServiciosUtils.completeReturnError(
					(DistributionsInfo) (new DistributionsInfo()), e
							.getErrorCode());
		} catch (SigemException e) {
			logger.error("Error al obtener la distribuci�n de entrada.", e);
			return (DistributionsInfo) ServiciosUtils.completeReturnError(
					(DistributionsInfo) (new DistributionsInfo()), e
							.getErrorCode());
		} catch (Throwable e) {
			logger.error(
					"Error inesperado al obtener la distribuci�n de entrada.",
					e);
			return (DistributionsInfo) ServiciosUtils
					.completeReturnError((RetornoServicio) (new DistributionsInfo()));
		}
	}

	/**
	 * M�todo para recupera el contenido de la bandeja de salida asociada a un
	 * usuario.
	 *
	 * @param user
	 *            usuario que se conecta (obligatorio).
	 * @param criteria
	 *            criterio de busqueda indice del primer registro a obtener y
	 *            n�mero m�ximo de registros a obtener desde el offset anterior.
	 * @param entidad
	 * @return devuelve la lista de distribuci�n de salida.
	 */
	public DistributionsInfo getOutputDistribution(
			ieci.tecdoc.sgm.registropresencial.ws.server.UserInfo user,
			DistributionSearchCriteria criteria, Entidad entidad) {
		try {
			DistributionsInfo oDInfo = UtilsWebService
					.getDistributionsInfoWS(getServicioRegistro()
							.getOutputDistribution(
									UtilsWebService.getUserInfo(user),
									new Integer(criteria.getState()),
									new Integer(criteria.getFirstRow()),
									new Integer(criteria.getMaxResults()),
									new Integer(criteria.getTypeBookRegister()),
									new Boolean(criteria.getOficAsoc()),
									entidad));
			return (DistributionsInfo) ServiciosUtils.completeReturnOK(oDInfo);
		} catch (RegistroException e) {
			logger.error("Error al obtener la distribuci�n de salida.", e);
			return (DistributionsInfo) ServiciosUtils.completeReturnError(
					(DistributionsInfo) (new DistributionsInfo()), e
							.getErrorCode());
		} catch (SigemException e) {
			logger.error("Error al obtener la distribuci�n de salida.", e);
			return (DistributionsInfo) ServiciosUtils.completeReturnError(
					(DistributionsInfo) (new DistributionsInfo()), e
							.getErrorCode());
		} catch (Throwable e) {
			logger
					.error(
							"Error inesperado al obtener la distribuci�n de salida.",
							e);
			return (DistributionsInfo) ServiciosUtils
					.completeReturnError((RetornoServicio) (new DistributionsInfo()));
		}
	}

	/**
	 * M�todo que nos devuelve el n�mero de registros distribuidos a la bandeja
	 * de entrada del usuario en funcion de los criterios introducidos
	 *
	 * @param user
	 *            usuario que se conecta (obligatorio).
	 * @param criteria
	 *            criterio de busqueda
	 * @param entidad
	 * @return devuelve el n�mero de resultados
	 */
	public DistributionCountInfo countInputDistribution(
			ieci.tecdoc.sgm.registropresencial.ws.server.UserInfo user,
			DistributionSearchCriteria criteria, Entidad entidad) {
		try {
			DistributionCountInfo distributionCountInfo = new DistributionCountInfo();
			distributionCountInfo.setOficAsoc(new Boolean(criteria
					.getOficAsoc()));
			distributionCountInfo.setState(new Integer(criteria.getState()));
			distributionCountInfo.setTypeBookRegisterDist(new Integer(criteria
					.getTypeBookRegister()));

			Integer count = getServicioRegistro().countInputDistribution(
					UtilsWebService.getUserInfo(user),
					new Integer(criteria.getState()),
					new Integer(criteria.getTypeBookRegister()),
					new Boolean(criteria.getOficAsoc()), entidad);

			distributionCountInfo.setCount(count);

			return (DistributionCountInfo) ServiciosUtils
					.completeReturnOK(distributionCountInfo);

		} catch (RegistroException e) {
			logger.error("Error al obtener la distribuci�n de entrada.", e);
			return (DistributionCountInfo) ServiciosUtils.completeReturnError(
					(DistributionCountInfo) (new DistributionCountInfo()), e
							.getErrorCode());
		} catch (SigemException e) {
			logger.error("Error al obtener la distribuci�n de entrada.", e);
			return (DistributionCountInfo) ServiciosUtils.completeReturnError(
					(DistributionCountInfo) (new DistributionCountInfo()), e
							.getErrorCode());
		} catch (Throwable e) {
			logger.error(
					"Error inesperado al obtener la distribuci�n de entrada.",
					e);
			return (DistributionCountInfo) ServiciosUtils
					.completeReturnError((RetornoServicio) (new DistributionCountInfo()));
		}
	}

	/**
	 * M�todo que nos devuelve el n�mero de registros distribuidos a la bandeja
	 * de salida del usuario en funcion de los criterios introducidos
	 *
	 * @param user
	 *            usuario que se conecta (obligatorio).
	 * @param criteria
	 *            criterio de busqueda
	 * @param entidad
	 * @return devuelve el n�mero de resultados
	 */
	public DistributionCountInfo countOutputDistribution(
			ieci.tecdoc.sgm.registropresencial.ws.server.UserInfo user,
			DistributionSearchCriteria criteria, Entidad entidad) {
		try {
			DistributionCountInfo distributionCountInfo = new DistributionCountInfo();
			distributionCountInfo.setOficAsoc(new Boolean(criteria
					.getOficAsoc()));
			distributionCountInfo.setState(new Integer(criteria.getState()));
			distributionCountInfo.setTypeBookRegisterDist(new Integer(criteria
					.getTypeBookRegister()));

			Integer count = getServicioRegistro().countOutputDistribution(
					UtilsWebService.getUserInfo(user),
					new Integer(criteria.getState()),
					new Integer(criteria.getTypeBookRegister()),
					new Boolean(criteria.getOficAsoc()), entidad);

			distributionCountInfo.setCount(count);

			return (DistributionCountInfo) ServiciosUtils
					.completeReturnOK(distributionCountInfo);

		} catch (RegistroException e) {
			logger.error("Error al obtener la distribuci�n de entrada.", e);
			return (DistributionCountInfo) ServiciosUtils.completeReturnError(
					(DistributionCountInfo) (new DistributionCountInfo()), e
							.getErrorCode());
		} catch (SigemException e) {
			logger.error("Error al obtener la distribuci�n de entrada.", e);
			return (DistributionCountInfo) ServiciosUtils.completeReturnError(
					(DistributionCountInfo) (new DistributionCountInfo()), e
							.getErrorCode());
		} catch (Throwable e) {
			logger.error(
					"Error inesperado al obtener la distribuci�n de entrada.",
					e);
			return (DistributionCountInfo) ServiciosUtils
					.completeReturnError((RetornoServicio) (new DistributionCountInfo()));
		}
	}

	/**
	 * M�todo que realiza la operaci�n de aceptar un registro de la bandeja de
	 * entrada de un usuario.
	 *
	 * @param user
	 *            usuario que se conecta (obligatorio).
	 * @param folder
	 *            informaci�n necesaria para realizar tal operaci�n
	 *            (identificador de libro y n�mero de registro a aceptar). Es
	 *            obligatorio.
	 * @param entidad
	 * @return devuelve OK si la operaci�n se ha realizado con exito o una
	 *         excepci�n si no es as�.
	 */
	public RetornoServicio acceptDistribution(
			ieci.tecdoc.sgm.registropresencial.ws.server.UserInfo user,
			Folder folder, Entidad entidad) {
		try {
			getServicioRegistro().acceptDistribution(
					UtilsWebService.getUserInfo(user),
					folder.getFolderNumber(),
					UtilsWebService.getBookId(folder), entidad);
			return ServiciosUtils.createReturnOK();
		} catch (RegistroException e) {
			logger.error("Error al aceptar distribucion.", e);
			return ServiciosUtils.createReturnError(e.getErrorCode());
		} catch (SigemException e) {
			logger.error("Error al aceptar distribucion.", e);
			return ServiciosUtils.createReturnError(e.getErrorCode());
		} catch (Throwable e) {
			logger.error("Error inesperado al aceptar distribucion.", e);
			return ServiciosUtils.createReturnError();
		}
	}

	/**
	 * M�todo que realiza la operaci�n de aceptar un registro de la bandeja de
	 * entrada de un usuario.
	 *
	 * @param user:
	 *            usuario que se conecta (obligatorio).
	 * @param distributionInfo:
	 *            Informaci�n de la distribuci�n que se va a tratar (obligatorio
	 *            el campo dtrId)
	 * @param entidad
	 * @return devuelve OK si la operaci�n se ha realizado con exito o una
	 *         excepci�n si no es as�.
	 */
	public RetornoServicio acceptDistributionEx(
			ieci.tecdoc.sgm.registropresencial.ws.server.UserInfo user,
			ieci.tecdoc.sgm.registropresencial.ws.server.DistributionInfo distributionInfo,
			Entidad entidad) {
		try {
			getServicioRegistro().acceptDistribution(
					UtilsWebService.getUserInfo(user),
					UtilsWebService.getDistributionInfoId(distributionInfo),
					entidad);
			return ServiciosUtils.createReturnOK();
		} catch (RegistroException e) {
			logger.error("Error al aceptar distribucion.", e);
			return ServiciosUtils.createReturnError(e.getErrorCode());
		} catch (SigemException e) {
			logger.error("Error al aceptar distribucion.", e);
			return ServiciosUtils.createReturnError(e.getErrorCode());
		} catch (Throwable e) {
			logger.error("Error inesperado al aceptar distribucion.", e);
			return ServiciosUtils.createReturnError();

		}
	}

	/**
	 * M�todo que realiza la operaci�n de archivar un registro de la bandeja de
	 * entrada de un usuario
	 *
	 * @param user
	 *            usuario que se conecta (obligatorio).
	 * @param folder
	 *            informaci�n necesaria para realizar tal operaci�n
	 *            (identificador de libro y n�mero de registro a archivar). Es
	 *            obligatorio.
	 * @param entidad
	 * @return devuelve OK si la operaci�n se ha realizado con exito o una
	 *         excepci�n si no es as�.
	 */
	public RetornoServicio archiveDistribution(
			ieci.tecdoc.sgm.registropresencial.ws.server.UserInfo user,
			Folder folder, Entidad entidad) {
		try {
			getServicioRegistro().archiveDistribution(
					UtilsWebService.getUserInfo(user),
					folder.getFolderNumber(),
					UtilsWebService.getBookId(folder), entidad);
			return ServiciosUtils.createReturnOK();
		} catch (RegistroException e) {
			logger.error("Error al archivar distribucion.", e);
			return ServiciosUtils.createReturnError(e.getErrorCode());
		} catch (SigemException e) {
			logger.error("Error al archivar distribucion.", e);
			return ServiciosUtils.createReturnError(e.getErrorCode());
		} catch (Throwable e) {
			logger.error("Error inesperado al archivar distribucion.", e);
			return ServiciosUtils.createReturnError();

		}
	}

	/**
	 * M�todo que realiza la operaci�n de archivar un registro de la bandeja de
	 * entrada de un usuario
	 *
	 * @param user
	 *            usuario que se conecta (obligatorio).
	 * @param distributionInfo:
	 *            Informaci�n de la distribuci�n que se va a tratar (obligatorio
	 *            el campo dtrId)
	 * @param entidad
	 * @return devuelve OK si la operaci�n se ha realizado con exito o una
	 *         excepci�n si no es as�.
	 */
	public RetornoServicio archiveDistributionEx(
			ieci.tecdoc.sgm.registropresencial.ws.server.UserInfo user,
			ieci.tecdoc.sgm.registropresencial.ws.server.DistributionInfo distributionInfo,
			Entidad entidad) {
		try {
			getServicioRegistro().archiveDistribution(
					UtilsWebService.getUserInfo(user),
					UtilsWebService.getDistributionInfoId(distributionInfo),
					entidad);
			return ServiciosUtils.createReturnOK();
		} catch (RegistroException e) {
			logger.error("Error al archivar distribucion.", e);
			return ServiciosUtils.createReturnError(e.getErrorCode());
		} catch (SigemException e) {
			logger.error("Error al archivar distribucion.", e);
			return ServiciosUtils.createReturnError(e.getErrorCode());
		} catch (Throwable e) {
			logger.error("Error inesperado al archivar distribucion.", e);
			return ServiciosUtils.createReturnError();

		}
	}

	/**
	 * M�todo que realiza la operaci�n de rechazar un registro de la bandeja de
	 * entrada de un usuario.
	 *
	 * @param user
	 *            usuario que se conecta (obligatorio).
	 * @param folder
	 *            informaci�n necesaria para realizar tal operaci�n (n�mero de
	 *            registro a rechazar)
	 * @param options
	 *            motivo del rechazo.
	 * @param entidad
	 * @return devuelve OK si la operaci�n se ha realizado con exito o una
	 *         excepci�n si no es as�.
	 */
	public RetornoServicio rejectDistribution(
			ieci.tecdoc.sgm.registropresencial.ws.server.UserInfo user,
			Folder folder, DistributionOptions options, Entidad entidad) {
		try {
			getServicioRegistro().rejectDistribution(
					UtilsWebService.getUserInfo(user),
					folder.getFolderNumber(), options.getRemarks(), entidad);
			return ServiciosUtils.createReturnOK();
		} catch (RegistroException e) {
			logger.error("Error al rechazar distribucion.", e);
			return ServiciosUtils.createReturnError(e.getErrorCode());
		} catch (SigemException e) {
			logger.error("Error al rechazar distribucion.", e);
			return ServiciosUtils.createReturnError(e.getErrorCode());
		} catch (Throwable e) {
			logger.error("Error inesperado al rechazar distribucion.", e);
			return ServiciosUtils.createReturnError();

		}
	}

	/**
	 * M�todo que realiza la operaci�n de rechazar un registro de la bandeja de
	 * entrada de un usuario.
	 *
	 * @param user
	 *            usuario que se conecta (obligatorio).
	 * @param distributionInfo:
	 *            Informaci�n de la distribuci�n que se va a tratar (obligatorio
	 *            el campo dtrId)
	 * @param options
	 *            motivo del rechazo.
	 * @param entidad
	 * @return devuelve OK si la operaci�n se ha realizado con exito o una
	 *         excepci�n si no es as�.
	 */
	public RetornoServicio rejectDistributionEx(
			ieci.tecdoc.sgm.registropresencial.ws.server.UserInfo user,
			ieci.tecdoc.sgm.registropresencial.ws.server.DistributionInfo distributionInfo,
			DistributionOptions options, Entidad entidad) {
		try {
			getServicioRegistro().rejectDistribution(
					UtilsWebService.getUserInfo(user),
					UtilsWebService.getDistributionInfoId(distributionInfo),
					options.getRemarks(), entidad);
			return ServiciosUtils.createReturnOK();
		} catch (RegistroException e) {
			logger.error("Error al rechazar distribucion.", e);
			return ServiciosUtils.createReturnError(e.getErrorCode());
		} catch (SigemException e) {
			logger.error("Error al rechazar distribucion.", e);
			return ServiciosUtils.createReturnError(e.getErrorCode());
		} catch (Throwable e) {
			logger.error("Error inesperado al rechazar distribucion.", e);
			return ServiciosUtils.createReturnError();

		}
	}

	/**
	 * M�todo que realiza la operaci�n de redistribuir un registro de la bandeja
	 * de entrada de un usuario, modificando el destino
	 *
	 * @param user
	 *            usuario que se conecta (obligatorio).
	 * @param folder
	 *            informaci�n necesaria para realizar tal operaci�n (n�mero de
	 *            registro a redistribuir)
	 * @param options
	 *            codigo del nuevo destino.
	 * @param entidad
	 * @return devuelve OK si la operaci�n se ha realizado con exito o una
	 *         excepci�n si no es as�.
	 */
	public RetornoServicio changeInputDistribution(
			ieci.tecdoc.sgm.registropresencial.ws.server.UserInfo user,
			Folder folder, DistributionOptions options, Entidad entidad) {
		try {
			getServicioRegistro().changeInputDistribution(
					UtilsWebService.getUserInfo(user),
					folder.getFolderNumber(), options.getCode(), entidad);
			return ServiciosUtils.createReturnOK();
		} catch (RegistroException e) {
			logger.error("Error al redistribuir distribucion de entrada.", e);
			return ServiciosUtils.createReturnError(e.getErrorCode());
		} catch (SigemException e) {
			logger.error("Error al redistribuir distribucion de entrada.", e);
			return ServiciosUtils.createReturnError(e.getErrorCode());
		} catch (Throwable e) {
			logger
					.error(
							"Error inesperado al redistribuir distribucion de entrada.",
							e);
			return ServiciosUtils.createReturnError();

		}
	}

	/**
	 * M�todo que realiza la operaci�n de redistribuir un registro de la bandeja
	 * de salida de un usuario, modificando el destino
	 *
	 * @param user
	 *            usuario que se conecta (obligatorio).
	 * @param folder
	 *            informaci�n necesaria para realizar tal operaci�n (n�mero de
	 *            registro a redistribuir)
	 * @param options
	 *            codigo del nuevo destino.
	 * @param entidad
	 * @return devuelve OK si la operaci�n se ha realizado con exito o una
	 *         excepci�n si no es as�.
	 */
	public RetornoServicio changeOutputDistribution(
			ieci.tecdoc.sgm.registropresencial.ws.server.UserInfo user,
			Folder folder, DistributionOptions options, Entidad entidad) {
		try {
			getServicioRegistro().changeOutputDistribution(
					UtilsWebService.getUserInfo(user),
					folder.getFolderNumber(), options.getCode(), entidad);
			return ServiciosUtils.createReturnOK();
		} catch (RegistroException e) {
			logger.error("Error al redistribuir distribucion de salida.", e);
			return ServiciosUtils.createReturnError(e.getErrorCode());
		} catch (SigemException e) {
			logger.error("Error al redistribuir distribucion de salida.", e);
			return ServiciosUtils.createReturnError(e.getErrorCode());
		} catch (Throwable e) {
			logger.error(
					"Error inesperado al redistribuir distribucion de salida.",
					e);
			return ServiciosUtils.createReturnError();

		}
	}

	/**
	 * M�todo que adjunta un documento a un registro
	 *
	 * @param user
	 *            usuario que se conecta (obligatorio).
	 * @param folder
	 *            informaci�n necesaria para realizar tal operaci�n (n�mero de
	 *            registro)
	 * @param entidad
	 * @return
	 */
	public RetornoServicio addDocument(
			ieci.tecdoc.sgm.registropresencial.ws.server.UserInfo user,
			ieci.tecdoc.sgm.registropresencial.ws.server.Folder folder,
			Entidad entidad) {
		try {
			getServicioRegistro().addDocument(
					UtilsWebService.getUserInfo(user),
					UtilsWebService.getBookId(folder),
					UtilsWebService.getFolderId(folder),
					UtilsWebService.getDocumentsInfo(folder), entidad);
			return ServiciosUtils.createReturnOK();
		} catch (RegistroException e) {
			logger.error("Error al adjuntar el documentos.", e);
			return ServiciosUtils.completeReturnError(new RetornoServicio(), e
					.getErrorCode());
		} catch (SigemException e) {
			logger.error("Error al adjuntar el documentos.", e);
			return ServiciosUtils.completeReturnError(new RetornoServicio(), e
					.getErrorCode());
		} catch (Throwable e) {
			logger.error("Error al adjuntar el documentos.", e);
			return ServiciosUtils.completeReturnError(new RetornoServicio());
		}
	}

	/**
	 * M�todo que devuelve los remitentes de un registro
	 *
	 * @param user
	 *            usuario que se conecta (obligatorio).
	 * @param folder
	 *            informaci�n necesaria para realizar tal operaci�n (n�mero de
	 *            registro)
	 * @param entidad
	 * @return
	 */
	public RetornoServicio getInterestedInputRegister(
			ieci.tecdoc.sgm.registropresencial.ws.server.UserInfo user,
			ieci.tecdoc.sgm.registropresencial.ws.server.Folder folder,
			Entidad entidad) {

		try {
			PersonInfo[] personsInfo = getServicioRegistro()
					.getInterestedInputRegister(
							UtilsWebService.getUserInfo(user),
							folder.getFolderNumber(), entidad);
			ListaPersonInfo listaPersonInfo = new ListaPersonInfo();

			listaPersonInfo.setPersonsInfo(UtilsWebService
					.getPersonInfoWS(personsInfo));

			return (ListaPersonInfo) ServiciosUtils
					.completeReturnOK(listaPersonInfo);

		} catch (RegistroException e) {
			logger
					.error(
							"Error al obtener remitentes de un registro de entrada.",
							e);
			return (ListaPersonInfo) ServiciosUtils
					.completeReturnError(
							(ListaPersonInfo) (new ListaPersonInfo()), e
									.getErrorCode());
		} catch (SigemException e) {
			logger
					.error(
							"Error al obtener remitentes de un registro de entrada.",
							e);
			return (ListaPersonInfo) ServiciosUtils
					.completeReturnError(
							(ListaPersonInfo) (new ListaPersonInfo()), e
									.getErrorCode());
		} catch (Throwable e) {
			logger
					.error(
							"Error inesperado al obtener remitentes de un registro de entrada.",
							e);
			return (FolderWithPersonInfo) ServiciosUtils
					.completeReturnError((RetornoServicio) (new FolderWithPersonInfo()));
		}

	}

	/**
	 * M�todo que devuelve los destinatatios de un registro
	 *
	 * @param user
	 *            usuario que se conecta (obligatorio).
	 * @param folder
	 *            informaci�n necesaria para realizar tal operaci�n (n�mero de
	 *            registro)
	 * @param entidad
	 * @return
	 */
	public RetornoServicio getInterestedOutputRegister(
			ieci.tecdoc.sgm.registropresencial.ws.server.UserInfo user,
			ieci.tecdoc.sgm.registropresencial.ws.server.Folder folder,
			Entidad entidad) {

		try {
			PersonInfo[] personsInfo = getServicioRegistro()
					.getInterestedOutputRegister(
							UtilsWebService.getUserInfo(user),
							folder.getFolderNumber(), entidad);
			ListaPersonInfo listaPersonInfo = new ListaPersonInfo();
			listaPersonInfo.setPersonsInfo(UtilsWebService
					.getPersonInfoWS(personsInfo));
			return (ListaPersonInfo) ServiciosUtils
					.completeReturnOK(listaPersonInfo);
		} catch (RegistroException e) {
			logger.error(
					"Error al obtener destinatarios de un registro de salida.",
					e);
			return (ListaPersonInfo) ServiciosUtils
					.completeReturnError(
							(ListaPersonInfo) (new ListaPersonInfo()), e
									.getErrorCode());
		} catch (SigemException e) {
			logger.error(
					"Error al obtener destinatarios de un registro de salida.",
					e);
			return (ListaPersonInfo) ServiciosUtils
					.completeReturnError(
							(ListaPersonInfo) (new ListaPersonInfo()), e
									.getErrorCode());
		} catch (Throwable e) {
			logger
					.error(
							"Error inesperado al obtener destinatarios de un registro de salida.",
							e);
			return (FolderWithPersonInfo) ServiciosUtils
					.completeReturnError((RetornoServicio) (new FolderWithPersonInfo()));
		}
	}

	/**
	 * M�todo que comprueba si un usuario puede crear un registro o no.
	 *
	 * @param user
	 *            usuario que se conecta (obligatorio).
	 * @param criteria
	 *            criterios de busqueda (typeBookRegister, oficAsoc,
	 *            onlyOpenBooks necesarios)
	 *
	 * @param entidad
	 * @return devuelve OK si el usuario puede crear registros para los
	 *         criterios indicados y ERROR si no puede hacerlo
	 */
	public RetornoServicio canCreateRegister(
			ieci.tecdoc.sgm.registropresencial.ws.server.UserInfo user,
			SearchCriteria criteria, Entidad entidad) {
		try {

			Boolean canCreateRegister = getServicioRegistro()
					.canCreateRegister(UtilsWebService.getUserInfo(user),
							new Integer(criteria.getTypeBookRegister()),
							new Integer(criteria.getOficAsoc()),
							new Integer(criteria.getOnlyOpenBooks()), entidad);

			if (canCreateRegister != null && canCreateRegister.booleanValue()) {
				return ServiciosUtils.createReturnOK();
			} else {
				return ServiciosUtils.createReturnError();
			}
		} catch (RegistroException e) {
			logger.error("Error al comprobar los permisos.", e);
			return ServiciosUtils.createReturnError(e.getErrorCode());
		} catch (SigemException e) {
			logger.error("Error al comprobar los permisos.", e);
			return ServiciosUtils.createReturnError(e.getErrorCode());
		} catch (Throwable e) {
			logger.error("Error inesperado al comprobar los permisos.", e);
			return ServiciosUtils.createReturnError();
		}
	}

	/**
	 * M�todo que nos devuelve los libros que existen en funci�n de los
	 * criterios de busqueda
	 *
	 * @param user
	 *            usuario que se conecta (obligatorio).
	 * @param criteria
	 *            criterios de busqueda (typeBookRegister, oficAsoc,
	 *            onlyOpenBooks necesarios)
	 *
	 * @param entidad
	 * @return devuelve informacion de los libros que coinciden con los
	 *         criterios de busqueda
	 */
	public BooksInfo getBooksForType(
			ieci.tecdoc.sgm.registropresencial.ws.server.UserInfo user,
			SearchCriteria criteria, Entidad entidad) {
		try {
			BooksInfo booksInfo = UtilsWebService
					.getBooksInfoWS(getServicioRegistro().getBooksForType(
							UtilsWebService.getUserInfo(user),
							new Integer(criteria.getTypeBookRegister()),
							new Integer(criteria.getOficAsoc()),
							new Integer(criteria.getOnlyOpenBooks()), entidad));

			return (BooksInfo) ServiciosUtils.completeReturnOK(booksInfo);
		} catch (RegistroException e) {
			logger.error("Error al obtener los libros", e);
			return (BooksInfo) ServiciosUtils.completeReturnError(
					(BooksInfo) (new BooksInfo()), e.getErrorCode());
		} catch (SigemException e) {
			logger.error("Error al obtener los libros", e);
			return (BooksInfo) ServiciosUtils.completeReturnError(
					(BooksInfo) (new BooksInfo()), e.getErrorCode());
		} catch (Throwable e) {
			logger.error("Error inesperado al obtener los libros", e);
			return (BooksInfo) ServiciosUtils
					.completeReturnError((BooksInfo) (new BooksInfo()));
		}
	}

	/**
	 * M�todo que nos devuelve las oficinas de un usuario que tienen permisos
	 * para crear un registro en un determinado libro
	 *
	 * @param user
	 *            usuario que se conecta (obligatorio).
	 * @param folder
	 *            informaci�n del registro (bookId es necesario)
	 * @param entidad
	 * @return
	 */
	public OfficesInfo getOfficeCanCreateRegisterByUser(
			ieci.tecdoc.sgm.registropresencial.ws.server.UserInfo user,
			Folder folder, Entidad entidad) {
		try {
			OfficesInfo officesInfo = UtilsWebService
					.getOfficesInfoWS(getServicioRegistro()
							.getOfficeCanCreateRegisterByUser(
									UtilsWebService.getUserInfo(user),
									UtilsWebService.getBookId(folder), entidad));
			return (OfficesInfo) ServiciosUtils.completeReturnOK(officesInfo);
		} catch (RegistroException e) {
			logger.error("Error al obtener la informacion de oficina.", e);
			return (OfficesInfo) ServiciosUtils.completeReturnError(
					(OfficesInfo) (new OfficesInfo()), e.getErrorCode());
		} catch (SigemException e) {
			logger.error("Error al obtener la informacion de oficina.", e);
			return (OfficesInfo) ServiciosUtils.completeReturnError(
					(OfficesInfo) (new OfficesInfo()), e.getErrorCode());
		} catch (Throwable e) {
			logger
					.error(
							"Error inesperado al obtener la informacion de oficina.",
							e);
			return (OfficesInfo) ServiciosUtils
					.completeReturnError((RetornoServicio) (new OfficesInfo()));
		}
	}


	/**
	 * M�todo que comprueba si un tipo de asunto est� disponible para una oficina
	 * @param user
	 *            usuario que se conecta (obligatorio).
	 * @param matterTypeCode
	 *            C�digo de Tipo de Asunto
	 * @param officeCode
	 *            Codigo de Oficina
	 * @param entidad
	 *
	 * @return
	 */
	public RetornoServicio existMatterTypeInOffice(
			ieci.tecdoc.sgm.registropresencial.ws.server.UserInfo user,
			String matterTypeCode, String officeCode , Entidad entidad) {
		try {
			Boolean existMatter = getServicioRegistro().existMatterTypeInOffice(UtilsWebService.getUserInfo(user), matterTypeCode, officeCode, entidad);
			if (existMatter != null && existMatter.booleanValue()) {
				return ServiciosUtils.createReturnOK();
			} else {
				return ServiciosUtils.createReturnError();
			}
		} catch (RegistroException e) {
			logger.error("Error al comprobar si el tipo de asunto existe para la oficina.", e);
			return ServiciosUtils.createReturnError(e.getErrorCode());
		} catch (SigemException e) {
			logger.error("Error al comprobar los permisos.", e);
			return ServiciosUtils.createReturnError(e.getErrorCode());
		} catch (Throwable e) {
			logger.error("Error inesperado al comprobar si el tipo de asunto existe para la oficina.", e);
			return ServiciosUtils.createReturnError();
		}
	}

	private ServicioRegistro getServicioRegistro() throws SOAPException,
			SigemException {
		String cImpl = UtilAxis
				.getImplementacion(org.apache.axis.MessageContext
						.getCurrentContext());
		if ((cImpl == null) || ("".equals(cImpl))) {
			return LocalizadorServicios.getServicioRegistro();
		} else {
			StringBuffer sbImpl = new StringBuffer(SERVICE_NAME).append(".")
					.append(cImpl);
			return LocalizadorServicios.getServicioRegistro(sbImpl.toString());
		}
	}

}
