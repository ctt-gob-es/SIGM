package ieci.tecdoc.sgm.usuarios_backoffice.exception;

import java.util.Locale;
import java.util.ResourceBundle;

public class GestionUsuariosBackOfficeException extends Exception {

	private static String RESOURCE_FILE = "ieci.tecdoc.sgm.gestion_backoffice.exception.GestionUsuariosBackOfficeExceptionMessages";
	
	protected long errorCode;
	protected String errorMessage;


	   /**
	    * Construye un objeto de la clase.
	    * 
	    * @param errorCode
	    *           C�digo de error.
	    */

	   public GestionUsuariosBackOfficeException(long errorCode) {

	      this(errorCode, null);
	   }

	   /**
	    * Construye un objeto de la clase.
	    * 
	    * @param message
	    *           Mensaje de error.
	    */

	   public GestionUsuariosBackOfficeException(String message) {

	      this(message, null);
	   }

	   /**
	    * Construye un objeto de la clase.
	    * 
	    * @param cause
	    *           Excepci�n que ha causado �sta.
	    */

	   public GestionUsuariosBackOfficeException(Throwable cause) {

	      this(0, cause);
	   }

	   public GestionUsuariosBackOfficeException(long errorCode, String message, Throwable cause){
	     super(message,cause);
	     this.errorCode = errorCode;
	     errorMessage = loadMessage(Locale.getDefault());
	   }
	   
	   /**
	    * Construye un objeto de la clase.
	    * 
	    * @param errorCode
	    *           C�digo de error.
	    * @param cause
	    *           Excepci�n que ha causado �sta.
	    */

	   public GestionUsuariosBackOfficeException(long errorCode, Throwable cause) {

	      super(cause);
	      this.errorCode = errorCode;
	      errorMessage = loadMessage(Locale.getDefault());
	   }

	   /**
	    * Construye un objeto de la clase.
	    * 
	    * @param message
	    *           Mensaje de error.
	    * @param cause
	    *           Excepci�n que ha causado �sta.
	    */

	   public GestionUsuariosBackOfficeException(String message, Throwable cause) {

	      super(message, cause);
	      errorMessage = message;
	   }

	   /**
	    * Devuelve el c�digo de error. <br>
	    * El valor del c�digo de error es 0 si �ste no se ha establecido
	    * 
	    * @return El c�digo de error mencionado.
	    */

	   public long getErrorCode() {

	      return errorCode;
	   }

	   /**
	    * Devuelve el mensaje de error.
	    * 
	    * @return El mensaje de error mencionado.
	    */

	   public String getMessage() {

	      return errorMessage;
	   }

	   /**
	    * Carga un mensaje de error del archivo de recursos en el idioma
	    * especificiado.
	    * 
	    * @param locale
	    *           C�digo de localizaci�n con el idioma especificado.
	    * @return El mensaje de error mencionado.
	    */

	   public String loadMessage(Locale locale) {

	      if (getCause() == null)
	         return getExtendedMessage(locale);
	      else {
	         StringBuffer sbf = new StringBuffer();
	         sbf.append(getExtendedMessage(locale));
	         sbf.append(" {\n ");
	         sbf.append(getCause().getMessage());
	         sbf.append("\n}");
	         return sbf.toString();
	      }
	   }

	   /**
	    * Carga un mensaje de error del archivo de recursos en el idioma
	    * especificiado.
	    * 
	    * @param locale
	    *           C�digo de localizaci�n con el idioma especificado.
	    * @return El mensaje de error mencionado.
	    */

	   public String getExtendedMessage(Locale locale) {

	      String msg = null;
	      ResourceBundle resBundle;

	      if (errorCode != 0) {
	         try {
	            resBundle = ResourceBundle.getBundle(getMessagesFile(), locale);
	            msg = resBundle.getString(new Long(errorCode).toString());
	         }
	         catch (Exception exc) {
	        	 try{
	        		 resBundle = ResourceBundle.getBundle(getMessagesFile());
	        		 msg = resBundle.getString(new Long(errorCode).toString());
	        	 }catch(Exception exc2){
	 	            msg = null;
		            exc2.printStackTrace(System.err);
	        	 }
	         }
	      }
	      return msg;
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
	   
	   public final static long serialVersionUID = 1L; 
}
