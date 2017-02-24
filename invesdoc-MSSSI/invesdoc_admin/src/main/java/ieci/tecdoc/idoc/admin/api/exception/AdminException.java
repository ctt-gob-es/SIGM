
package ieci.tecdoc.idoc.admin.api.exception;

import ieci.tecdoc.core.exception.IeciTdException;
import ieci.tecdoc.idoc.core.exception.ResourceMessage;

public class AdminException 
{

   /**
    * Lanza una excepci�n espec�fica del sistema llamante.
    * 
    * @param errorCode C�digo de error de la excepci�n.
    * @throws ieci.tecdoc.core.exception.IeciTdException Excepci�n generada.
    */
    
   public static void throwException(long errorCode) throws IeciTdException
   {
      throw new IeciTdException(Long.toString(errorCode), 
                                ResourceMessage.getMessage(errorCode,
                                AdminResourceFile.ADMIN_RESOURCE_FILE));
   }

   private AdminException()
   {
   }
}