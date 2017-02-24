package ieci.tecdoc.sgm.core.services.calendario;

import java.util.Locale;

import ieci.tecdoc.sgm.core.exception.SigemException;

/**
 * Excepci�n espec�fica del cat�logo de tr�mites.
 * 
 * @author IECISA
 */
public class CalendarioExcepcion extends SigemException {

	private static String RESOURCE_FILE = "ieci.tecdoc.sgm.core.services.calendario.CalendarioExceptionMessages";
	
	public static final long EC_PREFIX = 2000050000;
	public static final long EXC_GENERIC_EXCEPCION	= EC_PREFIX; 
  /**
   * Construye un objeto de la clase.
   * 
   * @param errorCode
   *           C�digo de error.
   */

  public CalendarioExcepcion(long errorCode) {
     super(errorCode);
  }

  /**
   * Construye un objeto de la clase.
   * 
   * @param errorCode
   *           C�digo de error.
   * @param cause
   *           Excepci�n que ha causado �sta.
   */

  public CalendarioExcepcion(long errorCode, Throwable cause) {
     super(errorCode, cause);
  }

  public CalendarioExcepcion(long errorCode, String message, Throwable cause){
		super(message,cause);
		this.errorCode = errorCode;
		errorMessage = loadMessage(Locale.getDefault());
	}
  
  /**
   * Devuelve la ruta del fichero de mensajes de error
   * @return Ruta del fichero de mensajes de error 
   */
  public String getMessagesFile() {
     return RESOURCE_FILE;
  }
  
  private static final long serialVersionUID = 1L;
}
