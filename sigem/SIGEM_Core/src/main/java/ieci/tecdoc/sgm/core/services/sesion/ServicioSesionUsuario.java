package ieci.tecdoc.sgm.core.services.sesion;

import ieci.tecdoc.sgm.core.services.dto.Entidad;

import java.security.cert.X509Certificate;

import javax.servlet.http.HttpSession;

public interface ServicioSesionUsuario {

		/**
		* Permite al usuario acceder al sistema si posee las credenciales adecuadas.
		* En este caso, la informaci�n debe ser previamente recuperada de la validaci�n de 
	    * los datos de usuario contra un aplicativo externo.
	    *
	    * @param actSessionId Identificador de sesi�n actual.
	    * @param user Login de usuario.
	    * @param email Correo del usuario.
	    * @param senderId Identificador del remitente (NIF).
	    * @return Un identificador de sesi�n.
	    * @throws SesionUsuarioException 
	    */
	   public String login(String actSessionId, String nombre, String apellidos, String email, String senderId, Entidad entidad) throws SesionUsuarioException;
	   
	   /**
	    * Permite al usuario acceder al sistema si posee las credenciales adecuadas.
	    * En este caso debe poseer un certificado Adem�s su
	    * certificado no debe estar revocado.
	    *
	    * @param actSessionId Identificador de sesi�n. Si no existe debe ser nulo.
	    * @param authId Identificador de autenticaci�n.
	    * @param certificate Certificado presentado (credencial).
	    * @return Un identificador de sesi�n.
	    * @throws SesionUsuarioException Si se produce alg�n error. 
	    */	   
	   public String login(String actSessionId, String authId, X509Certificate certificate, Entidad entidad) throws SesionUsuarioException; 	   

	   
	   /**
	    * Permite al usuario acceder al sistema si posee las credenciales adecuadas.
	    * En este caso debe poseer un certificado emitido por una CA de las que
	    * se encuentran en la lista de la pol�tica asociada al procedimiento que se pasa como par�metro.
	    * 
	    * @param procedureId Identificador del procedimiento.
	    * @param certificate Certificado presentado (credencial).
	    * @return Un identificador de sesi�n.
	    * @throws SesionUsuarioException Si se produce alg�n error. 
	    */
	   public String login(String procedureId, X509Certificate certificate, Entidad entidad) throws SesionUsuarioException; 
	   
	   
	   /**
	    * Permite al usuario acceder al sistema si posee las credenciales adecuadas.
	    * En este caso debe poseer un certificado Adem�s su
	    * certificado no debe estar revocado.
	    *
	    * @param session HttpSession.
	    * @param actSessionId Identificador de sesi�n. Si no existe debe ser nulo.
	    * @param authId Identificador de autenticaci�n.
	    * @param certificate Certificado presentado (credencial).
	    * @return Un identificador de sesi�n.
	    * @throws SesionUsuarioException Si se produce alg�n error. 
	    */	   
	   public String login(String idHttpSession, String actSessionId, String authId, X509Certificate certificate, Entidad entidad) throws SesionUsuarioException;
	   

	   /**
	    * Desconecta a un usuario del sistema.
	    *
	    * @param sessionId Identificador de sesi�n.
	    * @throws SesionUsuarioException Si se produce alg�n error.
	    */
	   public void logout(String sessionId, Entidad entidad) throws SesionUsuarioException;

	   /**
	    * Crea una nueva sesi�n de usuario en el sistema. Esta sesi�n de usuario es compartida
	    * por las aplicaciones de tramitaci�n de SIGEM.
	    * @param poSessionUsuario Datos de la sesi�n de usuario.
	    * @throws SesionUsuarioException En caso de producirse alg�n error.
	    */
	   public void crearSesion(SesionUsuario poSessionUsuario, Entidad entidad) throws SesionUsuarioException;
	   
	   /**
	    * Elimina una sesi�n de usuario del sistema. El usuario estar� "deslogado" de todas las
	    * aplicaciones de tramitaci�n de SIGEM.
	    * @param psIdSesion Identificador de sesi�n.
	    * @throws SesionUsuarioException En caso de producirse alg�n error.
	    */
	   public void borrarSesion(String psIdSesion, Entidad entidad) throws SesionUsuarioException;	   
	   
	   /**
	    * Elimina del sistema todas las sesiones de usuario que hayan sobrepasado el tiempo
	    * m�ximo de existencia definido por configuraci�n.
	    * @throws SesionUsuarioException En caso de producirse alg�n error.
	    */
	   public void limpiarSesiones(Entidad entidad) throws SesionUsuarioException;	
	   
	   /**
	    * Elimina del sistema todas las sesiones de usuario que hayan sobrepasado el tiempo
	    * m�ximo que llega como par�metro.
	    * @param timeout Intervalo de tiempo hasta el momento actual m�ximo para mantener sesiones.
	    * @throws SesionUsuarioException En caso de producirse alg�n error.
	    */
	   public void limpiarSesiones(int timeout, Entidad entidad) throws SesionUsuarioException;
	   
	   /**
	    * Obtiene todos los datos de la sesi�n de usuario.
	    * @param sessionId Identificador de la sesi�n de usuario.
	    * @return SesionUsuario Datos de la sesi�n de usuario.
	    * @throws SesionUsuarioException En caso de producirse alg�n error.
	    */
	   public SesionUsuario obtenerSesion(String sessionId, Entidad entidad) throws SesionUsuarioException;	
	   
	   /**
	    * Obtiene la informaci�n personal del usuario que inici� la sesi�n en el sistema.
	    * @param sessionId Identificador de sesi�n.
	    * @return InfoUsuario Informaci�n personal del usuario.
	    * @throws SesionUsuarioException En caso de producirse alg�n error.
	    */
	   public InfoUsuario getInfoUsuario(String sessionId, Entidad entidad) throws SesionUsuarioException;
	   
	   /**
	    * Obtiene el identificador del m�todo de autenticaci�n utilizado para iniciar la sesi�n
	    * en el sistema.
	    * @param sessionId Identificador de sesi�n.
	    * @return Identificador del m�todo de autenticaci�n utilizado al crear la sesi�n.
	    * @throws SesionUsuarioException En caso de producirse alg�n error.
	    */
	   public String getIdMetodoAutenticacion(String sessionId, Entidad entidad) throws SesionUsuarioException;
	   
	   /**
	    * Obtiene la informaci�n del m�todo de autenticaci�n utilizado para iniciar la sesi�n.
	    * @param sessionId Identificador de la sesi�n.
	    * @return MetodoAutenticacion Objeto con la informaci�n sobre el m�todo de autenticaci�n.
	    * @throws SesionUsuarioException En caso de producirse alg�n error.
	    */
	   public MetodoAutenticacion getMetodoAutenticacion(String sessionId, Entidad entidad) throws SesionUsuarioException;
	   
	   
}
