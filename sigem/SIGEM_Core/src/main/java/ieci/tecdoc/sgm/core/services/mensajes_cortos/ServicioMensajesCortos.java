package ieci.tecdoc.sgm.core.services.mensajes_cortos;

import ieci.tecdoc.sgm.core.services.mensajes_cortos.dto.Attachment;

/**
 * Interfaz para el servicio de mensajes cortos.
 * 
 */
public interface ServicioMensajesCortos {

	/*
	 * Estados de env�o de los mensajes SMS.
	 */
	
	/** El mensaje a�n no ha sido procesado. */
	public static final int SMS_STATUS_NEW 			= 1;
	/** El mensaje a�n no ha sido enviado. */
	public static final int SMS_STATUS_PENDING 		= 2;
	/** El mensaje ha sido enviado. */
	public static final int SMS_STATUS_SENT 		= 3;
	/** El mensaje ha sido entregado al destinatario. */
	public static final int SMS_STATUS_DELIVERED 	= 4;
	/** El mensaje ha sido entregado a la operadora pero a�n no al destinatario*/
	public static final int SMS_STATUS_BUFFERED 	= 5;
	/** El mensaje no ha sido entregado. */
	public static final int SMS_STATUS_FAILED 		= 6;
	/** El mensaje es inv�lido. */
	public static final int SMS_STATUS_INVALID 		= 7;
	/** La entrega del mensaje ha sido cancelada. */
	public static final int SMS_STATUS_CANCELLED 	= 8;
	/** El mensaje est� programado y a�n no se ha entregado. */
	public static final int SMS_STATUS_SCHEDULED 	= 9;

	/**
	 * Estados de la firma de un mensaje certificado
	 */
	/**El servidor de firma electr�onica se esta inicializando o el servicio del 
	 tercero no esta temporalmente disponible por algun motivo. Fichero pendiente de generaci�n.*/
	public static final int SIGNATURE_STATUS_WAITING_FOR_SERVICE 	   = 1;
	/*Generando el contenido y cursando la petici�on de firma electr�onica del contenido.Fichero pendiente de generaci�n.*/
	public static final int SIGNATURE_STATUS_QUERY_DONE			 	   = 2;
	/*Incrustando la firma en el fichero PDF. Fichero pendiente de generaci�n.*/
	public static final int SIGNATURE_STATUS_GENERATING_CONTENT  	   = 3;
	/*Notificando al usuario a trav�s del correo electr�nico.Fichero no disponible todav�a*/
	public static final int SIGNATURE_STATUS_SENDING_MAIL_NOTIFICATION = 4;
	/*Proceso de firma finalizado.Fichero temporalmente disponible en el repositorio.*/
	public static final int SIGNATURE_STATUS_FINISHED_PDF			   = 5;	
	/** En otro caso informamos que hubo error*/
	public static final int SIGNATURE_STATUS_ERROR						=-1;
	/**Proceso de firma finalizado. Fichero disponible en el repositorio*/
	public static final int SIGNATURE_STATUS_FINISHED_EXIST_PDF			=50;
	/**Proceso de firma finalizado. Fichero no disponible en el repositorio*/
	public static final int SIGNATURE_STATUS_FINISHED_NOT_EXIST_PDF		=51;
	
	/**
	 * Env�a un mensaje SMS.
	 * 
	 * @param user
	 *            Usuario del conector.
	 * @param pwd
	 *            Clave del usuario del conector.
	 * @param src
	 *            Remitente del mensaje
	 * @param dst
	 *            Destinatario del mensaje en formato internacional.
	 * @param txt
	 *            Texto a enviar.
	 * 
	 * @return Identificador del mensaje enviado.
	 * 
	 * @throws MensajesCortosException
	 *             si ocurre alg�n error.
	 */
	public String sendSMS(String user, String pwd, String src, String dst,
			String txt) throws MensajesCortosException;

	/**
	 * Env�a un mensaje SMS.
	 * 
	 * @param user
	 *            Usuario del conector.
	 * @param pwd
	 *            Clave del usuario del conector.
	 * @param src
	 *            Remitente del mensaje
	 * @param dst
	 *            Destinatarios del mensaje en formato internacional.
	 * @param txt
	 *            Texto a enviar.
	 * 
	 * @return Identificadores de los mensajes enviados.
	 * 
	 * @throws MensajesCortosException
	 *             si ocurre alg�n error.
	 */
	public String[] sendSMS(String user, String pwd, String src, String[] dst,
			String txt) throws MensajesCortosException;


	/**
	 * Obtiene el estado de un mensaje SMS enviado.
	 * 
	 * @param user
	 *            Usuario del conector.
	 * @param pwd
	 *            Clave del usuario del conector.
	 * @param id
	 *            Identificador del SMS enviado.
	 *            
	 * @return Estado del mensaje.
	 * 
	 * @throws MensajesCortosException
	 *             si ocurre alg�n error.
	 */
	public int getSMSStatus(String user, String pwd, String id)
			throws MensajesCortosException;

	/**
	 * Env�a un mensaje SMS certificado.
	 * 
	 * @param user
	 *            Usuario del conector.
	 * @param pwd
	 *            Clave del usuario del conector.
	 * @param src
	 *            Remitente del mensaje
	 * @param dst
	 *            Destinatarios del mensaje en formato internacional.
	 * @param txt
	 *            Texto a enviar.
	 * 
	 * @param lang
	 *            Lenguaje del resguardo del mensaje.
	 * 
	 * @return Identificador del mensaje certificado.
	 * 
	 * @throws MensajesCortosException
	 *             si ocurre alg�n error.
	 */
	public String sendCertSMS(String user, String pwd, String src, String dst,
			String txt, String lang) throws MensajesCortosException;
	
	/**
	 * Obtiene el estado del proceso de firma del resguardo del env�o de un SMS
	 * certificado.
	 * 
	 * @param user
	 *            Usuario del conector.
	 *            
	 * @param pwd
	 *            Clave del usuario del conector.
	 *            
	 * @param id
	 *            Identificador del SMS certificado.
	 *            
	 * @return Estado del proceso de firma.
	 * 
	 * @throws MensajesCortosException
	 *             si ocurre alg�n error.
	 */
	public int getCertSMSSignatureStatus(String user, String pwd, String id)
			throws MensajesCortosException;

	/**
	 * Obtiene el resguardo del env�o de un SMS certificado en formato XML.
	 * 
	 * @param user
	 *            Usuario del conector.
	 * 
	 * @param pwd
	 *            Clave del usuario del conector.
	 * 
	 * @param id
	 *            Identificador del SMS certificado.
	 * 
	 * @return XML con el resguardo.
	 * 
	 * @throws MensajesCortosException
	 *             si ocurre alg�n error.
	 */
	public String getCertSMSSignatureXML(String user, String pwd, String id)
			throws MensajesCortosException;

	/**
	 * Obtiene el resguardo del env�o de un SMS certificado en formato binario.
	 * 
	 * @param user
	 *            Usuario del conector.
	 * 
	 * @param pwd
	 *            Clave del usuario del conector.
	 * 
	 * @param id
	 *            Identificador del SMS certificado.
	 * 
	 * @return Binario con el resguardo.
	 * 
	 * @throws MensajesCortosException
	 *             si ocurre alg�n error.
	 */
	public byte[] getCertSMSSignatureDocument(String user, String pwd, String id)
			throws MensajesCortosException;
	
	/**
	 * Env�a un correo electr�nico.
	 * 
	 * @param from
	 *            Direcci�n de correo elentr�nico del remitente.
	 * @param to
	 *            Direcci�n de correo electr�nico del destinatario.
	 * @param cc
	 *            Direcci�n de correo electr�nico de destinatarios en copia.
	 * @param bcc
	 *            Direcci�n de correo electr�nico de destinatarios en copia
	 *            oculta.
	 * @param subject
	 *            Asunto del mensaje.
	 * @param content
	 *            Contenido del mensaje.
	 * @param attachments
	 *            Array de objetos Attachment con el nombre del fichero adjunto
	 *            y el contenido en binario.
	 * @throws MensajesCortosException
	 *             si ocurre alg�n error.
	 */
	public void sendMail(String from, String[] to, String[] cc, String[] bcc, String subject,
			String content, Attachment[] attachments) throws MensajesCortosException;

}
