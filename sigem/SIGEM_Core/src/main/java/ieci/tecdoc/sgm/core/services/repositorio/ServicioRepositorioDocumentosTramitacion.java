package ieci.tecdoc.sgm.core.services.repositorio;

import ieci.tecdoc.sgm.core.services.dto.Entidad;

import java.io.InputStream;
import java.util.Vector;

public interface ServicioRepositorioDocumentosTramitacion {

  /**
   * Recupera la informaci�n del documento cuyo guid es el pasado como par�metro
   * @param sessionId Identificador de sesi�n de la aplicaci�n llamante
   * @param guid Identificador del documento a recuperar
   * @param path Directorio en el que se quiere almacenar el fichero recuperado de la BBDD
   * @return String Ruta completa donde se ha almacenado el fichero recuperado
   * @throws GuidIncorrectoRdeExcepcion
   * @throws RepositorioDocumentosRdeExcepcion
   */
  public String retrieveDocument(String sessionId, String guid, String path, Entidad entidad) throws GuidIncorrectoRdeExcepcion, RepositorioDocumentosRdeExcepcion;
  
  /**
   * Recupera la informaci�n del documento cuyo guid es el pasado como par�metro
   * @param sessionId Identificador de sesi�n de la aplicaci�n llamante
   * @param guid Identificador del documento a recuperar
   * @return DocumentInfo Objeto que contiene el documento (en binario), la extensi�n
   *   y el tipo MIME asociado a esa extensi�n (en caso de estar definida)
   * @throws GuidIncorrectoRdeExcepcion
   * @throws RepositorioDocumentosRdeExcepcion
   */
  public DocumentoInfo retrieveDocument(String sessionId, String guid, Entidad entidad) throws GuidIncorrectoRdeExcepcion, RepositorioDocumentosRdeExcepcion;  
  
  /**
   * Recupera la informaci�n del documento cuyo guid es el pasado como par�metro
   * @param sessionId Identificador de sesi�n de la aplicaci�n llamante
   * @param guid Identificador del documento a recuperar
   * @return ContenedorDocument Objeto que contiene el documento (en binario), la extensi�n
   *   y el tipo MIME asociado a esa extensi�n (en caso de estar definida)
   * @throws GuidIncorrectoRdeExcepcion
   * @throws RepositorioDocumentosRdeExcepcion
   */
  public ContenedorDocumento retrieveDocumentInfo(String sessionId, String guid, Entidad entidad) throws GuidIncorrectoRdeExcepcion, RepositorioDocumentosRdeExcepcion;
  
  /**
   * Almacena un documento
   * @param sessionId Identificador de sesi�n de la aplicaci�n llamante
   * @param path Documento a almacenar (ruta del fichero)
   * @param extension Extensi�n del documento
   * @return String Identificador �nico asignado al documento
   * @throws RepositorioDocumentosRdeExcepcion
   */
  public String storeDocument(String sessionId, String path, String extension, Entidad entidad) throws RepositorioDocumentosRdeExcepcion;
  
  /**
   * Almacena un documento
   * @param sessionId Identificador de sesi�n de la aplicaci�n llamante
   * @param document Documento a almacenar (contenido binario)
   * @param extension Extensi�n del documento
   * @return String Identificador �nico asignado al documento
   * @throws RepositorioDocumentosRdeExcepcion
   */
  public String storeDocument(String sessionId, InputStream document, String extension, Entidad entidad) throws RepositorioDocumentosRdeExcepcion;  

  /**
   * Almacena un documento
   * @param sessionId Identificador de sesi�n de la aplicaci�n llamante
   * @param document Documento a almacenar (contenido binario)
   * @param extension Extensi�n del documento
   * @return String Identificador �nico asignado al documento
   * @throws RepositorioDocumentosRdeExcepcion
   */
  public String storeDocument(String sessionId, byte[] document, String extension, Entidad entidad) throws RepositorioDocumentosRdeExcepcion;
  
  /**
   * Almacena un documento con un determinado identificador
   * @param sessionId Identificador de sesi�n de la aplicaci�n llamante
   * @param guid Identificador del documento
   * @param document Documento a almacenar (contenido binario)
   * @param extension Extensi�n del documento
   * @return String Identificador �nico asignado al documento
   * @throws RepositorioDocumentosRdeExcepcion
   */
  public String storeDocumentGuid(String sessionId, String guid, byte[] document, String extension, Entidad entidad) throws RepositorioDocumentosRdeExcepcion;
  
  /**
   * Elimina un documento del RDE
   * @param sessionId Identificador de sesi�n de la aplicaci�n llamante
   * @param guid Identificador del documento que se quiere eliminar del RDE
   * @throws GuidIncorrectoRdeExcepcion
   * @throws RepositorioDocumentosRdeExcepcion
   */
  public void deleteDocument(String sessionId, String guid, Entidad entidad) throws GuidIncorrectoRdeExcepcion, RepositorioDocumentosRdeExcepcion;
  
  /**
   * Obtiene el hash del documento cuyo guid es el pasado como parametro
   * @param sessionId Identificador de la sesi�n de la aplicaci�n llamante
   * @param guid Identificador del documento del que se quiere obtener el hash
   * @return String Hash del documento
   * @throws GuidIncorrectoRdeExcepcion
   * @throws RepositorioDocumentosRdeExcepcion
   */
  public String getHash(String sessionId, String guid, Entidad entidad) throws GuidIncorrectoRdeExcepcion, RepositorioDocumentosRdeExcepcion;  
  
  /**
   * Almacena los documentos del vector y devuelve sus guids y sus hashes
   * @param sessionId Identificador de la sesi�n de la apliaci�n llamante
   * @param docsHashInfo Vector de objetos DocumentHashInfo. �nicamente se pasan con 
   *   informaci�n los campos correspondientes al path y a la extensi�n del documento
   * @throws RepositorioDocumentosRdeExcepcion
   */
  public void storeDocumentsAndGetHashes(String sessionId, Vector docsHashInfo, Entidad entidad) throws RepositorioDocumentosRdeExcepcion;  
  
  /**
   * Almacena un documento temporal
   * @param sessionId Identificador de sesi�n de la aplicaci�n llamante
   * @param guid Identificador �nico asignado al documento
   * @throws RepositorioDocumentosRdeExcepcion
   */
  public void storeDocumentTmp(String sessionId, String guid, Entidad entidad) throws RepositorioDocumentosRdeExcepcion;
  
  /**
   * Elimina los documentos temporales del RDE asociados a un sessionId
   * @param sessionId Identificador de sesi�n de la aplicaci�n llamante
   * @throws GuidIncorrectoRdeExcepcion
   * @throws RepositorioDocumentosRdeExcepcion
   */
  public void deleteDocumentTmp(String sessionId, Entidad entidad) throws GuidIncorrectoRdeExcepcion, RepositorioDocumentosRdeExcepcion;
  
  /**
   * Obtiene los documentos temporales asociados a un sessionId
   * @param sessionId Identificador de sesi�n de la aplicaci�n llamante
   * @return DocumentTmps Documentos temporales asociados a un sessionId
   * @throws RepositorioDocumentosRdeExcepcion
   */
  public DocumentosTemporales getDocumentTmp(String sessionId, Entidad entidad) throws RepositorioDocumentosRdeExcepcion;
  
  /**
   * Obtiene los documentos temporales caducados
   * @param timeout Tiempo m�ximo de sesi�n
   * @return DocumentTmps Documentos temporales caducados
   * @throws RepositorioDocumentosRdeExcepcion
   */
  public DocumentosTemporales getDocumentTmp(int timeout, Entidad entidad) throws RepositorioDocumentosRdeExcepcion;
  
}
