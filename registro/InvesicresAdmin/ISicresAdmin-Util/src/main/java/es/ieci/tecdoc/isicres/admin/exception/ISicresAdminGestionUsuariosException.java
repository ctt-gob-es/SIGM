package es.ieci.tecdoc.isicres.admin.exception;

import java.util.Locale;


/**
 * Excepci�n espec�fica del cat�logo de tr�mites.
 *
 * @author IECISA
 */
public class ISicresAdminGestionUsuariosException extends ISicresAdminException{

	// Tipos de excepcion
	public static final long EC_PREFIX = 1011000000;
	public static final long EXC_GENERIC_EXCEPCION	= EC_PREFIX;


	private static String RESOURCE_FILE = "es.ieci.tecdoc.isicres.admin.exception.ISicresAdminGestionUsuarios" +
			"ExceptionMessages";


	public ISicresAdminGestionUsuariosException(long errorCode) {
		this(errorCode, null);
	}

	public ISicresAdminGestionUsuariosException(String message) {
		this(message, null);
	}

	public ISicresAdminGestionUsuariosException(Throwable cause) {
		this(0, cause);
	}

	public ISicresAdminGestionUsuariosException(long errorCode, String message, Throwable cause){
		super(message,cause);
		this.errorCode = errorCode;
		errorMessage = loadMessage(Locale.getDefault());
	}

   public ISicresAdminGestionUsuariosException(long errorCode, Throwable cause) {
	   super(cause);
	   this.errorCode = errorCode;
	   errorMessage = loadMessage(Locale.getDefault());
   }

   public ISicresAdminGestionUsuariosException(String message, Throwable cause) {
	   super(message, cause);
	   errorMessage = message;
   }

   /**
    * Devuelve el nombre del archivo de recursos que contiene los mensajes para
    * esta excepci�n.
    *
    * @return El nombre del archivo de recursos mencionado.
    */

   public String getMessagesFile() {

      return RESOURCE_FILE;
   }


}
