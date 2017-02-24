package ieci.tecdoc.core.exception;

import java.io.Serializable;

/**
 * Excepci�n lanzada por los paquetes de ieci.tecdoc cuando se produce un error
 * rese�able. <br>
 * <br>
 * Adem�s de la informaci�n contenida en todos los objetos Exception (message,
 * cause y stack trace), cada instancia de esta clase contiene tambi�n un c�digo
 * de error.
 */

public final class IeciTdException extends Exception implements Serializable
{

   private static final String CLASS_FULL_NAME = "ieci.tecdoc.core.exception.IeciTdException";

   private String              m_errorCode;

   /**
    * Construye un objeto de la clase.
    * 
    * @param errorCode
    *           C�digo de error de la excepci�n.
    * @param msg
    *           Mensaje de la excepci�n.
    */

   public IeciTdException(String errorCode, String msg)
   {
      super(msg);
      m_errorCode = errorCode;
      fillInStackTrace();
   }

   /**
    * Construye un objeto de la clase.
    * 
    * @param errorCode
    *           C�digo de error de la excepci�n.
    * @param msg
    *           Mensaje de la excepci�n.
    * @param cause
    *           Causa de la excepci�n.
    */

   public IeciTdException(String errorCode, String msg, Exception cause)
   {
      super(msg, cause);
      m_errorCode = errorCode;
      fillInStackTrace();
   }

   /**
    * Construye un objeto de la clase.
    * 
    * @param errorCode
    *           C�digo de error de la excepci�n.
    * @param msg
    *           Mensaje de la excepci�n.
    * @param cause
    *           Causa de la excepci�n.
    */

   public IeciTdException(String errorCode, String msg, Error cause)
   {
      super(msg, cause);
      m_errorCode = errorCode;
      fillInStackTrace();
   }

   /**
    * Devuelve el c�digo de error de la excepci�n.
    * 
    * @return El c�digo de error mencionado.
    */

   public String getErrorCode()
   {
      return m_errorCode;
   }

   /**
    * Devuelve el mensaje extendido de la excepci�n especificada por exc.
    * 
    * @param exc
    *           La excepci�n mencionada.
    * @return El mensaje extendido mencionado.
    */

   public static String getExtendedMessage(Exception exc)
   {

      StringBuffer bdr;
      Throwable cause;

      try
      {

         bdr = new StringBuffer();

         getExtendedMessage(bdr, exc, "\n");

         cause = exc.getCause();
         if (cause != null)
         {
            bdr.append("\n\n\n");
            getExtendedMessage(bdr, cause, "\n");
         }

         return bdr.toString();

      }
      catch (Exception e)
      {
         return "Fatal error";
      }

   }

   /**
    * Devuelve el mensaje extendido de la excepci�n especificada por exc.
    * Se usa en p�ginas Jsp.
    * 
    * @param exc
    *           La excepci�n mencionada.
    * @return El mensaje extendido mencionado.
    */

   public static String getExtendedMessageForJspUse(Throwable exc)
   {

      StringBuffer bdr;
      Throwable cause;

      try
      {

         bdr = new StringBuffer();

         getExtendedMessage(bdr, exc, "<br>");

         cause = exc.getCause();
         if (cause != null)
         {
            bdr.append("<br><br><br>");
            getExtendedMessage(bdr, cause, "<br>");
         }

         return bdr.toString();

      }
      catch (Exception e)
      {
         return "Fatal error";
      }

   }

   // **************************************************************************

   private static void getExtendedMessage(StringBuffer bdr, Throwable exc, 
                                          String jumpChar)
   {

      String fullName, errorCode;
      StackTraceElement steArr[];
      int len, i;

      fullName = exc.getClass().getName();

      bdr.append(fullName).append(jumpChar + jumpChar);

      if (fullName.equals(CLASS_FULL_NAME))
      {
         errorCode = ((IeciTdException) exc).getErrorCode();
         bdr.append(errorCode).append(jumpChar + jumpChar);
      }

      bdr.append(exc.getMessage()).append(jumpChar + jumpChar);

      steArr = exc.getStackTrace();
      len = steArr.length;
      for (i = 0; i < len; i++)
         bdr.append(steArr[i].toString()).append(jumpChar);

   }

} // class
