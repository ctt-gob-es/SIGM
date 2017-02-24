
package es.ieci.tecdoc.isicres.admin.exception;

import es.ieci.tecdoc.isicres.admin.core.exception.IeciTdException;
import es.ieci.tecdoc.isicres.admin.estructura.keys.ISicresAdminResourceFile;
import es.ieci.tecdoc.isicres.admin.utils.ISicresAdminResourceMessage;

public class ISicresAdminBasicException
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
                                ISicresAdminResourceMessage.getMessage(errorCode,
                                ISicresAdminResourceFile.ADMIN_RESOURCE_FILE));
   }

   private ISicresAdminBasicException()
   {
   }
}