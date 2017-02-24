package ieci.tecdoc.sgm.registropresencial.ws.server;

/**
 * 
 * Informaci�n del usuario que realiza la petici�n
 *
 */
public class UserInfo{

	/**
	 * Login del Usuario
	 */
	private String userName = null;

	/**
	 * Contrase�a del usuario.
	 */
	private String password = null;

	/**
	 * Idioma del usuario.
	 */
	private String locale = null;

	/**
	 * @return
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * @param locale
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}

	/**
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	
}
