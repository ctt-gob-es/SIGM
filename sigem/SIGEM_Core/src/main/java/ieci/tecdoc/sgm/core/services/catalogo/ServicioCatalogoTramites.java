package ieci.tecdoc.sgm.core.services.catalogo;

import ieci.tecdoc.sgm.core.services.dto.Entidad;

/**
 * EJB sin estado que proporciona las operaciones sobre el cat�logo de tr�mites
 * 
 * @author IECISA
 * 
 */
public interface ServicioCatalogoTramites {
	
		/**
		 * M�todo que da de alta un tr�mite
		 * @param procedure Datos del tr�mite
		 * @throws CatalogoTramitesExcepcion
		 */
		public void addProcedure(Tramite procedure, Entidad entidad) throws CatalogoTramitesExcepcion;
	
		/**
		 * M�todo que obtiene un tr�mite
		 * @param procedureId Identificador del tr�mite
		 * @param loadDocuments Determina si deben cargarse tipos de documentos asociados al tr�mite
		 * @return Datos del tr�mite
		 * @throws CatalogoTramitesExcepcion
		 */
		public Tramite getProcedure(String procedureId, boolean loadDocuments, Entidad entidad) throws CatalogoTramitesExcepcion;
		
		/**
		 * M�todo que realiza un consulta sobre los tr�mites
		 * @param query Par�metros de la consulta
		 * @return Tr�mites obtenidos en la consulta a partir de los par�mtros definidos
		 * @throws CatalogoTramitesExcepcion
		 */
		public Tramites query(TramiteConsulta query, Entidad entidad) throws CatalogoTramitesExcepcion;
		
		/**
		 * M�todo que elimina un tr�mite
		 * @param procedureId Identificador del tr�mite
		 * @throws CatalogoTramitesExcepcion
		 */
		public void deleteProcedure(String procedureId, Entidad entidad) throws CatalogoTramitesExcepcion;

		/**
		 * M�todo que actualiza la informaci�n de un tr�mite
		 * @param procedure Datos actualizados del tr�mite
		 * @throws CatalogoTramitesExcepcion
		 */
		public void updateProcedure(Tramite procedure, Entidad entidad) throws CatalogoTramitesExcepcion;
		
		/**
		 * M�todo que informa si un tipo de documento est� asociado a alg�n tr�mite
		 * @param documentId Identificador de documento
		 * @return true si est� asociado el documento a alg�n tr�mite, false si no lo est�
		 * @throws CatalogoTramitesExcepcion
		 */
		public boolean isDocumentReferenced(String documentId, Entidad entidad) throws CatalogoTramitesExcepcion;
		
		/**
		 * M�todo que da de alta la asociaci�n entre un tr�mite y un tipo documento
		 * @param procedureDocument Datos de la asociaci�n a dar de alta
		 * @throws CatalogoTramitesExcepcion
		 */
		public void addProcedureDocument(DocumentoTramite procedureDocument, Entidad entidad) throws CatalogoTramitesExcepcion;
		
		/**
		 * M�todo que elimina la sociaci�n entre un tr�mite y un tipo de documento
		 * @param procedureDocument Datos de la asociaci�n a eliminar
		 * @throws CatalogoTramitesExcepcion
		 */
		public void deleteProcedureDocument(DocumentoTramite procedureDocument, Entidad entidad) throws CatalogoTramitesExcepcion;
		
		/**
		 * M�todo que obtiene un tipo de documento
		 * @param documentId Identiicador del documento
		 * @return Datos del tipo de documento
		 * @throws CatalogoTramitesExcepcion
		 */
		public Documento getDocument(String documentId, Entidad entidad) throws CatalogoTramitesExcepcion;
		
		/**
		 * M�todo que da de alta un tipo de documento
		 * @param document Datos del documento a dar de alta
		 * @throws CatalogoTramitesExcepcion
		 */
		public void addDocument(Documento document, Entidad entidad) throws CatalogoTramitesExcepcion;
		
		/**
		 * M�todo que elimina un documento
		 * @param documentId Identificador del documento
		 * @throws CatalogoTramitesExcepcion
		 */
		public void deleteDocument(String documentId, Entidad entidad) throws CatalogoTramitesExcepcion;
		
		/**
		 * M�todo que actualiza los datos de un tipo de documento
		 * @param document Datos actualizados del documento
		 * @throws CatalogoTramitesExcepcion
		 */
		public void updateDocument(Documento document, Entidad entidad) throws CatalogoTramitesExcepcion;
		
		/**
		 * M�todos que obtiene los tipos de documentos dados de alta
		 * @return Documentos dados de alta en el sistema
		 * @throws CatalogoTramitesExcepcion
		 */
		public Documentos getDocuments(Entidad entidad) throws CatalogoTramitesExcepcion;
		
		/**
		 * M�todo que obtiene todos los tipos de documento asociados a un tr�mite
		 * @param procedureId Identificador del tr�mite
		 * @return Documentos asociados a un tr�mite
		 * @throws CatalogoTramitesExcepcion
		 */
		public Documentos getProcedureDocuments(String procedureId, Entidad entidad) throws CatalogoTramitesExcepcion;
		
		/**
		 * M�todo que obtiene los datos de la asociaci�n de un tr�mite con un tipo de documento
		 * @param procedureId Identificador del tr�mite
		 * @param documentId Identificador del documento
		 * @return Datos de la asociaci�n de un documento a un tr�mie
		 * @throws CatalogoTramitesExcepcion
		 */
		public DocumentoTramite getProcedureDocument(String procedureId, String documentId, Entidad entidad) throws CatalogoTramitesExcepcion;
	
		/**
		 * M�todo que obtiene los datos de la asociaci�n de un tr�mite con un tipo de documento
		 * @param procedureId Identificador del tr�mite
		 * @param documentId Identificador del documento
		 * @param code C�digo de documento
		 * @return Datos de la asociaci�n de un documento a un tr�mie
		 * @throws CatalogoTramitesExcepcion
		 */
		public DocumentoTramite getProcedureDocument(String procedureId, String documentId, String code, Entidad entidad) throws CatalogoTramitesExcepcion;
	
		/**
		 * M�todo que actualiza la asociaci�n entre un tr�mite y un tipo de documento
		 * @param procedure Datos actualizados de la asociaci�n
		 * @throws CatalogoTramitesExcepcion
		 */
		public void updateProcedureDocument(DocumentoTramite procedure, Entidad entidad) throws CatalogoTramitesExcepcion;
		
		/**
		 * M�todo que obtiene la lista de tr�mites dados de alta en el sistema
		 * @return Lista de tr�mites
		 * @throws CatalogoTramitesExcepcion
		 */
		public Tramites getProcedures(Entidad entidad) throws CatalogoTramitesExcepcion;
		
		/**
		 * M�todo que obtiene un documento a partir del c�digo de documento (c�digo �nico que asoci
		 * un tr�mite con un tipo de documento
		 * @param code C�digo de documento
		 * @return Datos del documento
		 * @throws CatalogoTramitesExcepcion
		 */
		public Documento getDocumentfromCode (String code, Entidad entidad) throws CatalogoTramitesExcepcion;
		
		/**
		 * M�todo que obtiene un �rgano destinatario
		 * @param addresseeId Identificador del �rgano destinatario
		 * @return Datos del �rgano destinatario
		 * @throws CatalogoTramitesExcepcion
		 */
		public OrganoDestinatario getAddressee(String addresseeId, Entidad entidad) throws CatalogoTramitesExcepcion;
		
		/**
		 * M�todo que da de alta un �rgano destinatario
		 * @param addressee Datos del �rgano destinatario
		 * @throws CatalogoTramitesExcepcion
		 */
		public void addAddressee(OrganoDestinatario addressee, Entidad entidad) throws CatalogoTramitesExcepcion;
		
		/**
		 * M�todo que elimina un �rgano destinatario
		 * @param addresseeId Identificador del �rgano destinatario
		 * @throws CatalogoTramitesExcepcion
		 */
		public void deleteAddressee(String addresseeId, Entidad entidad) throws CatalogoTramitesExcepcion;
		
		/**
		 * M�todo que actualiza un �rgano destinatario
		 * @param addressee Datos actualizados del �rgano destinatario
		 * @throws CatalogoTramitesExcepcion
		 */
		public void updateAddressee(OrganoDestinatario addressee, Entidad entidad) throws CatalogoTramitesExcepcion;
		
		/**
		 * M�todo que obtiene una lista de �rrganos destinatarios
		 * @return Lista de �rganos destinatarios
		 * @throws CatalogoTramitesExcepcion
		 */
		public OrganosDestinatarios getAddressees(Entidad entidad) throws CatalogoTramitesExcepcion;
		
		/**
		 * M�todo que obtiene un conector
		 * @param hookId Identiicador de conector
		 * @return Datos del conector
		 * @throws CatalogoTramitesExcepcion
		 */
		public Conector getHook(String hookId, Entidad entidad) throws CatalogoTramitesExcepcion;
		
		/**
		 * M�todo que da de alta un conector
		 * @param hook Datos del conector
		 * @throws CatalogoTramitesExcepcion
		 */
		public void addHook(Conector hook, Entidad entidad) throws CatalogoTramitesExcepcion;
		
		/**
		 * M�todo que elimina un conector
		 * @param hookId Identificador de conector
		 * @throws CatalogoTramitesExcepcion
		 */
		public void deleteHook(String hookId, Entidad entidad) throws CatalogoTramitesExcepcion;
		
		/**
		 * M�todo que actualiza un conector
		 * @param hook Datos actualizados del conector
		 * @throws CatalogoTramitesExcepcion
		 */
		public void updateHook(Conector hook, Entidad entidad) throws CatalogoTramitesExcepcion;
		
		/**
		 * M�todo que obtiene una lista de conectores
		 * @return Lista de conectores
		 * @throws CatalogoTramitesExcepcion
		 */
		public Conectores getHooks(Entidad entidad) throws CatalogoTramitesExcepcion;
		
		/**
		 * M�todo que obtiene una lista de conectores de un tipo determinado
		 * @param hookType Identificador de tipo de conector
		 * @return Lista de conectores del tipo despecificado
		 * @throws CatalogoTramitesExcepcion
		 */
		public Conectores getHooksByType(int hookType, Entidad entidad) throws CatalogoTramitesExcepcion;
		
		/**
		 * M�todo que obtiene un tipo de conector
		 * @param typeId Identificador del tipo de conector
		 * @return Datos del tipo de conector
		 * @throws CatalogoTramitesExcepcion
		 */
		public TipoConector getHookType(int typeId, Entidad entidad) throws CatalogoTramitesExcepcion;
		
		/**
		 * M�todo que da de alta un tipo de conector
		 * @param hookType Datos del tipo de conector
		 * @throws CatalogoTramitesExcepcion
		 */
		public void addHookType(TipoConector hookType, Entidad entidad) throws CatalogoTramitesExcepcion;
		
		/**
		 * M�todo que elimina un tipo de conector
		 * @param typeId Identificador del tipo de conector
		 * @throws CatalogoTramitesExcepcion
		 */
		public void deleteHookType(int typeId, Entidad entidad) throws CatalogoTramitesExcepcion;
		
		/**
		 * M�todo que actualiza un tipode conector
		 * @param hookType Datos actualizados del tipo de conector
		 * @throws CatalogoTramitesExcepcion
		 */
		public void updateHookType(TipoConector hookType, Entidad entidad) throws CatalogoTramitesExcepcion;
		
		/**
		 * M�todo que obtiene una lista de tipos de conectores
		 * @return Lista de tipos de conectores dados de alta en el sistema
		 * @throws CatalogoTramitesExcepcion
		 */
		public TiposConectores getHookTypes(Entidad entidad) throws CatalogoTramitesExcepcion;
		
		/**
		 * M�todo que obtiene los conectores de autenticaci�n asociados a un tr�mite
		 * @param tramiteId Identificador del tr�mite
		 * @return Datos de los conectores de autenticaci�n asociados a un tr�mite
		 * @throws CatalogoTramitesExcepcion
		 */
		public ConectoresAutenticacion getAuthHooks (String tramiteId, Entidad entidad) throws CatalogoTramitesExcepcion;
		
		/**
		 * M�todo que da de alta la asociaci�n de un conector de auteticaci�n a un tr�mite
		 * @param conectorAutenticacion Datos del conector de autenticaci�n
		 * @throws CatalogoTramitesExcepcion
		 */
		public void addAuthHooks (ConectorAutenticacion conectorAutenticacion, Entidad entidad) throws CatalogoTramitesExcepcion;
		   
		/**
		 * M�todo que elimina la asociaci�n de un conector de autenticaci�n con un tr�mite
		 * @param tramiteId Identificador del tr�mite
		 * @param conectorId Identificador del conector
		 * @throws CatalogoTramitesExcepcion
		 */
		public void deleteAuthHooks (String tramiteId, String conectorId, Entidad entidad) throws CatalogoTramitesExcepcion;
		   
		/**
		 * M�todo que actualiza la asociaci�n entre un conector de autenticaci�n y un tr�mite
		 * @param conectorAutenticacion Datos actualizados de la asociaci�n
		 * @param oldHookId Identificador del conector que se quiere modificar antes de la modificaci�n
		 * @throws CatalogoTramitesExcepcion
		 */
		public void updateAuthHooks (ConectorAutenticacion conectorAutenticacion, String oldHookId, Entidad entidad) throws CatalogoTramitesExcepcion;
		   
		/**
		 * M�todoque obtiene un conector de autenticaci�n
		 * @param tramiteId Identificador del tr�mite
		 * @param conectorId Identificador del conector
		 * @return Datos del conector de autenticaci�n
		 * @throws CatalogoTramitesExcepcion
		 */
		public ConectorAutenticacion getAuthHook (String tramiteId, String conectorId, Entidad entidad) throws CatalogoTramitesExcepcion;
}