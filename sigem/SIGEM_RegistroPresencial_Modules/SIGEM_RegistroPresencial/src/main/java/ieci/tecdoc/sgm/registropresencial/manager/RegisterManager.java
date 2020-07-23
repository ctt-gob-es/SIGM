package ieci.tecdoc.sgm.registropresencial.manager;

import ieci.tecdoc.sgm.core.services.registro.Interested;
import ieci.tecdoc.sgm.registropresencial.autenticacion.Login;
import ieci.tecdoc.sgm.registropresencial.autenticacion.User;
import ieci.tecdoc.sgm.registropresencial.info.InfoBook;
import ieci.tecdoc.sgm.registropresencial.info.InfoOffice;
import ieci.tecdoc.sgm.registropresencial.info.InfoRegister;
import ieci.tecdoc.sgm.registropresencial.register.RegisterServices;
import ieci.tecdoc.sgm.registropresencial.utils.Keys;
import ieci.tecdoc.sgm.registropresencial.utils.RBUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.ieci.tecdoc.common.exception.AttributesException;
import com.ieci.tecdoc.common.exception.BookException;
import com.ieci.tecdoc.common.exception.SecurityException;
import com.ieci.tecdoc.common.exception.SessionException;
import com.ieci.tecdoc.common.exception.TecDocException;
import com.ieci.tecdoc.common.exception.ValidationException;
import com.ieci.tecdoc.common.isicres.AxSfQueryField;
import com.ieci.tecdoc.idoc.flushfdr.FlushFdrDocument;
import com.ieci.tecdoc.idoc.flushfdr.FlushFdrField;
import com.ieci.tecdoc.idoc.flushfdr.FlushFdrPage;

import es.dipucr.metadatos.beans.MetadatosDocumentoBean;
import es.dipucr.metadatos.bussinessobject.MetadatosBo;

public class RegisterManager {
    private static Logger LOGGER = Logger.getLogger(RegisterManager.class);

    /**
     * Metodo que crea un nuevo registro
     * @param user - Datos del usuario
     * @param bookId - ID del libro
     * @param atts - Campos con la informacion del nuevo registro
     * @param inter - Listado de Interesados
     * @param documents - Coleccion de Documentos anexados al registro
     * @param entidad
     *
     * @return {@link InfoRegister}
     *
     * @throws ValidationException
     * @throws SecurityException
     * @throws BookException
     * @throws SessionException
     * @throws AttributesException
     */
    public InfoRegister createFolder(User user, Integer bookId, List<?> atts, List<?> inter, Map<?, ?> documents, String entidad) throws ValidationException, SecurityException, BookException, SessionException, AttributesException {
        InfoRegister result = null;
        try {
            result = RegisterServices.createFolder(user, bookId, atts, inter, documents, entidad, false);
            
            String sessionID = new String();
            try{
            	sessionID = Login.login(user, entidad);
            	
            	String folderId = result.getFolderId();
            	String fechaCaptura = result.getDate();
   			
            	SimpleDateFormat longFormatter = new SimpleDateFormat(RBUtil.getInstance(user.getLocale()).getProperty(Keys.I18N_DATE_LONGFORMAT));
            
	        	for(Entry<?, ?> entryDocumento : documents.entrySet()){
					
					FlushFdrDocument documento = (FlushFdrDocument) entryDocumento.getValue();
					
					String tipoDocumental = documento.getTipoDocumental();
					String tipoFirma = documento.getTipoFirma();
					String csv = documento.getCsv();
					
					if(null != documento.getPages()){
						for (int i = 0; i < documento.getPages().size(); i++){							
							FlushFdrPage page = (FlushFdrPage) documento.getPages().get(i);
							
							String pageId = page.getFile().getPageID();
							String fileId = page.getFile().getFileID();
							String extension = page.getFile().getExtension();

							// Adaptaci�n a Alfresco. El identificador de alfresco es alfanum�rico y no entero.
							try {
								Integer.parseInt(fileId);
							} catch (NumberFormatException e) {
								fileId = calculateFileIDAlfresco(folderId, Integer.parseInt(pageId));
							}
			
							if( null == page.getMetadatosDocumento()){
								MetadatosBo.insertaMetadatosCrearRegistroSW(sessionID, bookId, Integer.parseInt(folderId), Integer.parseInt(pageId), Integer.parseInt(fileId), entidad, longFormatter.parse(fechaCaptura), extension, tipoDocumental, tipoFirma, csv);
								
							} else {
								MetadatosDocumentoBean metadatosDocumentoBean = new MetadatosDocumentoBean(bookId, Integer.parseInt(folderId), Integer.parseInt(pageId), Integer.parseInt(fileId), entidad, "");
								metadatosDocumentoBean.setIdEspecificoDocumento("" + fileId);
						        
						        metadatosDocumentoBean.setVersionNTI(page.getMetadatosDocumento().getVersionNTI());
						        metadatosDocumentoBean.setFechaCaptura(page.getMetadatosDocumento().getFechaCaptura());
						        
						        metadatosDocumentoBean.setOrigen(page.getMetadatosDocumento().getOrigen());
						        metadatosDocumentoBean.setEstadoElaboracion(page.getMetadatosDocumento().getEstadoElaboracion());
						        
						        metadatosDocumentoBean.setNombreFormato(page.getMetadatosDocumento().getNombreFormato());        
						        metadatosDocumentoBean.setTipoDocumental(page.getMetadatosDocumento().getTipoDocumental());
						        metadatosDocumentoBean.setTipoFirma(page.getMetadatosDocumento().getTipoFirma());
						        metadatosDocumentoBean.setCsv(page.getMetadatosDocumento().getCsv());
		
						        MetadatosBo.insertaMetadatos(sessionID, metadatosDocumentoBean);
							}
						}
					}
	        	}
			} catch (Exception e){
				LOGGER.error("ERROR al insertar error los metadatos. " + e.getMessage(), e);
			}
            
        } catch (TecDocException e) {
            LOGGER.error("Impossible create new folder on book: " + bookId, e);
            throw new BookException( BookException.ERROR_CANNOT_CREATE_NEW_FOLDER);
            
        } catch (ParseException e) {
            LOGGER.error("Impossible create new folder on book: " + bookId, e);
            throw new BookException( BookException.ERROR_CANNOT_CREATE_NEW_FOLDER);
            
        } catch (Exception e) {
            LOGGER.error("Impossible create new folder on book: " + bookId, e);
            throw new BookException( BookException.ERROR_CANNOT_CREATE_NEW_FOLDER);
        }

        return result;
    }

    /**
     * Metodo que consolida un registro
     * @param user - Usuario
     * @param bookId - ID del libro
     * @param atts - Campos con la informaci�n del nuevo registro
     * @param inter - Interesados
     * @param documents - Documentos anexados al registro
     * @param entidad
     * @return {@link InfoRegister}
     * @throws ValidationException
     * @throws SecurityException
     * @throws BookException
     * @throws SessionException
     * @throws AttributesException
     */
    public InfoRegister consolidateFolder(User user, Integer bookId, List<?> atts, List<?> inter, Map<?, ?> documents, String entidad) throws ValidationException, SecurityException, BookException, SessionException, AttributesException {
    	
        InfoRegister result = null;
        try {

            FlushFdrField flushFdrField = null;
            String numReg = null;

            //obtenemos el numero de registro a tratar
            for (Iterator<?> it = atts.iterator(); it.hasNext();) {
                flushFdrField = (FlushFdrField) it.next();
                if (flushFdrField.getFldid()==1){
                    numReg = flushFdrField.getValue();
                }
            }

            //componemos una consulta, para consultar por el numero de registro
            AxSfQueryField axSfQueryField = new AxSfQueryField();
            axSfQueryField.setFldId("1");
            axSfQueryField.setBookId(bookId);
            axSfQueryField.setOperator("=");
            axSfQueryField.setValue(numReg);
            List<AxSfQueryField> query = new ArrayList<AxSfQueryField>();
            query.add(axSfQueryField);

            InfoRegister[] registerInfo = null;

            try{
                //buscamos el registro
                registerInfo = RegisterServices.findFolder(user, bookId, query, entidad);
            } catch (BookException e){
                if(LOGGER.isDebugEnabled()){
                    LOGGER.debug("No se recupera informaci�n para el registro registro [" + numReg +"]", e);
                }
                // no existe el registro
                registerInfo = null;
            }

            //comprobamos la operativa a seguir segun exista o no el registro
            if(registerInfo == null){
                //sino existe el registro lo creamos
                result = RegisterServices.createFolder(user, bookId, atts, inter, documents, entidad, true);
            } else {
                LOGGER.warn("El registro [" + registerInfo[0].getFolderId() + "] con numero de Registro [" + numReg + "] ya ha sido consolidado con lo que actualizamos la documentaci�n que falta");
                // si ya existe el registro actualizamos el registro
                Integer folderId = new Integer(registerInfo[0].getFolderId());

                //actualizamos registro
                result = RegisterServices.updateFolder(user, bookId, folderId, atts, inter, documents, entidad);
            }
            
            String sessionID = new String();
            try{
            	sessionID = Login.login(user, entidad);
            	
            	String folderId = result.getFolderId();
            	String fechaCaptura = result.getDate();
   			
            	SimpleDateFormat longFormatter = new SimpleDateFormat(RBUtil.getInstance(user.getLocale()).getProperty(Keys.I18N_DATE_LONGFORMAT));
            
	        	for(Entry<?, ?> entryDocumento : documents.entrySet()){
					
					FlushFdrDocument documento = (FlushFdrDocument) entryDocumento.getValue();
					
					FlushFdrPage page = (FlushFdrPage) documento.getPages().get(0);
					String pageId = page.getFile().getPageID();
					String fileId = page.getFile().getFileID();
					String extension = page.getFile().getExtension();
	
					// Adaptaci�n a Alfresco. El identificador de alfresco es alfanum�rico y no entero.
					try {
						Integer.parseInt(fileId);
					} catch (NumberFormatException e) {
						fileId = calculateFileIDAlfresco(folderId, Integer.parseInt(pageId));
					}					
		        	MetadatosBo.insertaMetadatosConsolidacion(sessionID, bookId, Integer.parseInt(folderId), Integer.parseInt(pageId), Integer.parseInt(fileId), entidad, longFormatter.parse(fechaCaptura), extension);
	        	}
			} catch (Exception e){
				LOGGER.error("ERROR al insertar error los metadatos. " + e.getMessage(), e);
			}
            
        } catch (TecDocException e) {
            LOGGER.error( "Impossible to consolidate folder on book: " + bookId, e);
            throw new BookException( BookException.ERROR_CANNOT_CREATE_NEW_FOLDER);
        } catch (ParseException e) {
            LOGGER.error( "Impossible to consolidate folder on book: " + bookId, e);
            throw new BookException( BookException.ERROR_CANNOT_CREATE_NEW_FOLDER);
        } catch (Exception e) {
            LOGGER.error( "Impossible to consolidate folder on book: " + bookId, e);
            throw new BookException( BookException.ERROR_CANNOT_CREATE_NEW_FOLDER);
        }

        return result;
    }

    /**
     * Actualizamos un registro
     *
     * @param user - Usuario
     * @param bookId - ID del libro
     * @param folderId - ID del Registro
     * @param atts - Campos modificados
     * @param inter - Interesados
     * @param documents - Documentos adjuntados
     * @param entidad
     *
     * @return {@link InfoRegister}
     *
     * @throws ValidationException
     * @throws SecurityException
     * @throws BookException
     * @throws SessionException
     * @throws AttributesException
     */
    public InfoRegister updateFolder(User user, Integer bookId, Integer folderId, List<?> atts, List<?> inter, Map<?, ?> documents, String entidad) throws ValidationException, SecurityException, BookException, SessionException, AttributesException {
    	
    	InfoRegister result = null;
        try {
            result = RegisterServices.updateFolder(user, bookId, folderId, atts, inter, documents, entidad);
            
        } catch (TecDocException e) {
            LOGGER.error("Impossible to update folder on book: " + bookId, e);
            throw new BookException(BookException.ERROR_UPDATE_FOLDER);
            
        } catch (ParseException e) {
            LOGGER.error("Impossible to update folder on book: " + bookId, e);
            throw new BookException(BookException.ERROR_UPDATE_FOLDER);
            
        } catch (Exception e) {
            LOGGER.error("Impossible to update folder on book: " + bookId, e);
            throw new BookException(BookException.ERROR_UPDATE_FOLDER);
        }

        return result;
    }

    /**
     * Metodo que importa un registro
     *
     * @param user - Datos del usuario
     * @param bookId - ID del libro
     * @param atts - Campos con la informacion del registro a importar
     * @param inter - Listado de interesados del registro
     * @param documents - Coleccion de documentos anexados al registro
     * @param entidad
     *
     * @return {@link InfoRegister}
     *
     * @throws ValidationException
     * @throws SecurityException
     * @throws BookException
     * @throws SessionException
     * @throws AttributesException
     */
    public InfoRegister importFolder(User user, Integer bookId, List<?> atts, List<?> inter, Map<?, ?> documents, String entidad) throws ValidationException, SecurityException, BookException, SessionException, AttributesException {
    	
        InfoRegister result = null;
        try {
            result = RegisterServices.importFolder(user, bookId, atts, inter, documents, entidad);
            
        } catch (TecDocException e) {
            LOGGER.error("Impossible create new folder on book: " + bookId, e);
            throw new BookException( BookException.ERROR_CANNOT_CREATE_NEW_FOLDER);
            
        } catch (ParseException e) {
            LOGGER.error("Impossible create new folder on book: " + bookId, e);
            throw new BookException( BookException.ERROR_CANNOT_CREATE_NEW_FOLDER);
            
        } catch (Exception e) {
            LOGGER.error("Impossible create new folder on book: " + bookId, e);
            throw new BookException( BookException.ERROR_CANNOT_CREATE_NEW_FOLDER);
        }

        return result;
    }

    /**
     * Metodo que busca registros
     *
     * @param user - Datos del usuario
     * @param bookId - ID del libro
     * @param atts - Listado de {@link axSfQueryField} con la informacion con la que se realiza la busqueda
     * @param entidad
     *
     * @return Array de objetos {@link InfoRegister}
     *
     * @throws ValidationException
     * @throws SecurityException
     * @throws BookException
     * @throws SessionException
     * @throws AttributesException
     */
    public InfoRegister[] findFolder(User user, Integer bookId, List<AxSfQueryField> atts, String entidad) throws ValidationException, SecurityException, BookException, SessionException, AttributesException {
    	
        InfoRegister[] result = null;
        try {
            result = RegisterServices.findFolder(user, bookId, atts, entidad);
            
        } catch (TecDocException e) {
            LOGGER.error("Impossible to find folder on book: " + bookId, e);
            throw new BookException( BookException.ERROR_CANNOT_CREATE_NEW_FOLDER);
        } catch (ParseException e) {
            LOGGER.error("Impossible to find folder on book: " + bookId, e);
            throw new BookException( BookException.ERROR_CANNOT_CREATE_NEW_FOLDER);
        } catch (Exception e) {
            LOGGER.error("Impossible to find folder on book: " + bookId, e);
            throw new BookException( BookException.ERROR_CANNOT_CREATE_NEW_FOLDER);
        }

        return result;
    }

    /**
     * Metodo que devuelve un objeto Map con toda la informaci�n del registro de
     * entrada solicitado.
     *
     * @param user - Datos del usuario
     * @param folderNumber - Numero de Registro a buscar
     * @param oficAsoc - Oficina
     * @param entidad
     *
     * @return Coleccion de objetos con los datos del Registro
     *
     * @throws ValidationException
     * @throws SecurityException
     * @throws BookException
     * @throws SessionException
     * @throws AttributesException
     */
    public Map<?, ?> getInputFolderForNumber(User user, String folderNumber, boolean oficAsoc, String entidad) throws ValidationException, SecurityException, BookException, SessionException, AttributesException {
        Map<?, ?> result = null;
        
        try {
            result = RegisterServices.getFolderForNumber(user, folderNumber, 1, oficAsoc, entidad);
        } catch (TecDocException e) {
            LOGGER.error("Impossible obtain the folder: " + folderNumber, e);
            throw new BookException(BookException.ERROR_CANNOT_FIND_REGISTERS);
        } catch (Exception e) {
            LOGGER.error("Impossible obtain the folder: " + folderNumber + e.getMessage(), e);
            throw new BookException(BookException.ERROR_CANNOT_FIND_REGISTERS);
        }
        return result;
    }

    /**
     * Devuelve un objeto Map con toda la informaci�n del registro de salida solicitado
     *
     * @param user - Datos del usuario
     * @param folderNumber - Numero de registro
     * @param oficAsoc - Oficina
     * @param entidad
     *
     * @return Coleccion de objetos con los datos del Registro
     *
     * @throws ValidationException
     * @throws SecurityException
     * @throws BookException
     * @throws SessionException
     * @throws AttributesException
     */
    public Map<?, ?> getOutputFolderForNumber(User user, String folderNumber, boolean oficAsoc, String entidad) throws ValidationException, SecurityException, BookException, SessionException, AttributesException {
        Map<?, ?> result = null;
        
        try {
            result = RegisterServices.getFolderForNumber(user, folderNumber, 2, oficAsoc, entidad);
        } catch (TecDocException e) {
            LOGGER.error("Impossible obtain the folder: " + folderNumber, e);
            throw new BookException(BookException.ERROR_CANNOT_FIND_REGISTERS);
        } catch (Exception e) {
            LOGGER.error("Impossible obtain the folder: " + folderNumber, e);
            throw new BookException(BookException.ERROR_CANNOT_FIND_REGISTERS);
        }
        return result;
    }

    /**
     * Devuelve un array de bytes correspondiente al documento solicitado
     *
     * @param user - Datos del usuario
     * @param bookID - Id del libro
     * @param folderId - Id del registro
     * @param docID - Id del documento a buscar
     * @param pageID - Id de la pagina a buscar
     * @param entidad
     *
     * @return Array de bytes con el documento buscado
     *
     * @throws ValidationException
     * @throws SecurityException
     * @throws BookException
     * @throws SessionException
     */
    public byte[] getDocumentFolder(User user, Integer bookID, Integer folderId, int docID, int pageID, String entidad) throws ValidationException, SecurityException, BookException, SessionException {
        byte[] result = null;
        try {
            result = RegisterServices.getDocumentFromFolder(user, bookID, folderId, docID, pageID, entidad);
        } catch (TecDocException e) {
            LOGGER.error("Impossible to obtain the document for book: " + bookID + " and folder: " + folderId, e);
            throw new BookException(BookException.ERROR_CANNOT_ACCESS_DOCUMENT);
        } catch (Exception e) {
            LOGGER.error("Impossible to obtain the document for book: " + bookID + " and folder: " + folderId, e);
            throw new BookException(BookException.ERROR_CANNOT_ACCESS_DOCUMENT);
        }
        return result;
    }

    /**
     *
     * Metodo que a�ade un documento (y sus paginas) al registro indicado
     *
     * @param user - Datos del usuario
     * @param bookId - Id del libro
     * @param folderId - Id del registro
     * @param documents - Listado de documentos para anexar al registro
     * @param entidad
     *
     * @throws ValidationException
     * @throws SecurityException
     * @throws BookException
     * @throws SessionException
     * @throws AttributesException
     */
    public void addDocumentFolder(User user, Integer bookId, Integer folderId, Map<?, ?> documents, String entidad) throws ValidationException, SecurityException, BookException, SessionException, AttributesException {
        try {
            RegisterServices.addDocument(user, bookId, folderId, documents, entidad);
            
        } catch (TecDocException e) {
            LOGGER.error("Impossible to add documento on book: " + bookId + " and folder: " + folderId, e);
            throw new BookException(BookException.ERROR_CANNOT_ADD_DOCUMENT);
        } catch (ParseException e) {
            LOGGER.error("Impossible to add documento on book: " + bookId + " and folder: " + folderId, e);
            throw new BookException(BookException.ERROR_CANNOT_ADD_DOCUMENT);
        } catch (Exception e) {
            LOGGER.error("Impossible to add documento on book: " + bookId + " and folder: " + folderId, e);
            throw new BookException(BookException.ERROR_CANNOT_ADD_DOCUMENT);
        }
    }

    /**
     * Metodo que obtiene los interesados de un registro
     *
     * @param user - Datos del usuario
     * @param bookId - Id del libro
     * @param folderId - Id del registro
     * @param entidad
     *
     * @return Listado de interesados {@link Interested}
     *
     * @throws ValidationException
     * @throws SecurityException
     * @throws BookException
     * @throws SessionException
     * @throws AttributesException
     */
    public Interested[] getInterestedRegister(User user, Integer bookId, Integer folderId, String entidad) throws ValidationException, SecurityException, BookException, SessionException, AttributesException {
        Interested[] result = null;
        try {
            result = RegisterServices.getInterestedRegister(user, bookId, folderId, entidad);
        } catch (TecDocException e) {
            LOGGER.error("Impossible to obtain the folder: " + folderId, e);
            throw new BookException(BookException.ERROR_CANNOT_FIND_REGISTERS);
        } catch (Exception e) {
            LOGGER.error("Impossible to obtain the folder: " + folderId, e);
            throw new BookException(BookException.ERROR_CANNOT_FIND_REGISTERS);
        }
        return result;
    }

    /**
     * Metodo que comprueba los permisos de creaccion de registros
     *
     * @param user - Datos del usuario
     * @param type - indica el tipo de libro (1-Entrada / 2-Salida)
     * @param oficAsoc - Oficina
     * @param onlyOpenBooks - Indica si el libro debe estar abierto (0-Abierto) o en otro estado (1-Cerrado)
     * @param entidad
     *
     * @return boolean - TRUE: Si tiene permisos para crear registros
     * 					FALSE: No tiene permisos para crear registros
     *
     * @throws ValidationException
     * @throws SecurityException
     * @throws BookException
     * @throws SessionException
     * @throws AttributesException
     */
    public Boolean canCreateRegister(User user, int type, boolean oficAsoc, boolean onlyOpenBooks, String entidad) throws ValidationException, SecurityException, BookException, SessionException, AttributesException {
        Boolean result = Boolean.FALSE;
        try {
            List<?> books = RegisterServices.getBooksCanCreateFolder(user, type, oficAsoc, onlyOpenBooks, entidad);

            if (books != null && !books.isEmpty()) {
                result = Boolean.TRUE;
            }
        } catch (Exception e) {
            LOGGER.error("Impossible obtain book ", e);
            throw new BookException(BookException.ERROR_CANNOT_FIND_REGISTERS);
        }
        return result;
    }

    /**
     * Metodo que obtiene los libros en lo que el usuario puede crear registros
     *
     * @param user - Datos del usuario
     * @param type - indica el tipo de libro (1-Entrada / 2-Salida)
     * @param oficAsoc - Oficina
     * @param onlyOpenBooks - Indica si el libro debe estar abierto (0-Abierto) o en otro estado (1-Cerrado)
     * @param entidad
     *
     * @return Listado de objeto {@link InfoBook}
     *
     * @throws ValidationException
     * @throws SecurityException
     * @throws BookException
     * @throws SessionException
     * @throws AttributesException
     */
    public List<?> getBooksCanCreateRegister(User user, int type, boolean oficAsoc, boolean onlyOpenBooks, String entidad) throws ValidationException, SecurityException, BookException, SessionException, AttributesException {
        List<?> result = null;
        try {
            result = RegisterServices.getBooksCanCreateFolder(user, type, oficAsoc, onlyOpenBooks, entidad);

        } catch (Exception e) {
            LOGGER.error("Impossible obtain book ", e);
            throw new BookException(BookException.ERROR_CANNOT_FIND_REGISTERS);
        }
        return result;
    }

    /**
     * Metodo que obtiene las oficinas del usuario donde tiene permisos para crear registros
     *
     * @param user - Datos del usuario
     * @param bookID - Id del libro a buscar
     * @param entidad
     *
     * @return Listado de objetos {@link InfoOffice}
     *
     * @throws ValidationException
     * @throws SecurityException
     * @throws BookException
     * @throws SessionException
     * @throws AttributesException
     */
    public List<?> getOfficesCanCreateRegister(User user, Integer bookID, String entidad) throws ValidationException, SecurityException, BookException, SessionException, AttributesException {
        List<?> result = null;
        try {
            result = RegisterServices.getOfficesCanCreateFolder(user, bookID, entidad);

        } catch (Exception e) {
            LOGGER.error("Impossible obtain book ", e);
            throw new BookException(BookException.ERROR_CANNOT_FIND_REGISTERS);
        }
        return result;
    }

    /**
     * Metodo que comprueba si un tipo de asunto pertenece a una oficina
     *
     * @param user - Datos del usuario
     * @param matterTypeCode - indica el tipo de asunto
     * @param officeCode - Codigo de oficina
     * @param entidad
     *
     * @return boolean - TRUE: Si pertenece a la oficina
     * 					FALSE: No pertenece a la oficina
     *
     * @throws ValidationException
     * @throws SecurityException
     * @throws SessionException
     * @throws AttributesException
     */
	public boolean getMatterTypeInOffice(User user, String matterTypeCode, String officeCode, String entidad)throws ValidationException, SecurityException, SessionException {
		try {
			return RegisterServices.existMatterTypeInOffice(user, matterTypeCode, officeCode, entidad);
			
		} catch (SecurityException e) {
			throw e;
			
		} catch (SessionException e) {
			throw e;
			
		} catch (ValidationException e) {
			throw e;
			
		} catch (Exception e) {
			LOGGER.error("Impossible verify matterType in office ", e);
			throw new ValidationException( ValidationException.ERROR_GET_MATTER_FOR_OFFIC, new String[] { matterTypeCode, officeCode });
		}
	}

	
	/** Se toma como identificador para Alfresco el fdrId seguido por un id de tres d�gitos 
	 * 
	 * @param fdrId
	 * @param id Identificador de p�gina del fichero
	 * @return identificador con formato para alfresco.
	 */
	private static String calculateFileIDAlfresco(String fdrId, int id) {
	
		String newFileId = fdrId;
		String idAux = Integer.toString(id);
		for (int i=idAux.length(); i < 3 ;i++) {
			newFileId = newFileId + "0";
		}
		newFileId = newFileId + idAux;
		return newFileId;

	}
	
	
}
