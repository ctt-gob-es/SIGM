
package ieci.tecdoc.idoc.admin.api.exception;

/**
 * Proporciona los c�digos de error espec�ficos del API de acceso(login) al 
 * sistema.
 */
 
public class LoginErrorCodes 
{
   private LoginErrorCodes()
   {
   }

   /**
    * C�digo de error base.
    */
   private static final long EC_PREFIX = 3009000;

   /**
    * El identificador de aplicaci�n no es v�lido para el API de administraci�n.
    */
   public static final long EC_INVALID_PRODUCT_ID = EC_PREFIX + 1;

   /**
    * El m�todo de acceso (login) no es v�lido para el API de administraci�n.
    */
   public static final long EC_INVALID_METHOD_ID = EC_PREFIX + 1;


}