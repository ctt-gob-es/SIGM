
package ieci.tecdoc.idoc.admin.api.user;
import ieci.tecdoc.idoc.admin.internal.LoginImpl;
import ieci.tecdoc.sbo.acs.base.AcsAccessToken;
import ieci.tecdoc.sbo.acs.base.AcsAccessTokenProducts;

/**
 * Proporciona funcionalidad de acceso a la administraci�n de invesDoc. 
 */
 
public class Login 
{
   
   private Login()
   {
   }
   
   /**
    * Realiza la conexi�n a una aplicaci�n. Valida los permisos del usuario
    * para utilizar dicha aplicaci�n y le proporciona un token de acceso.
    * 
    * @param name Nombre del usuario.
    * @param password Contrase�a.
    * @param productId Identificador de la aplicaci�n que desea hacer login.
    * @param numTries N�mero de intentos incorrectos de usuario-contrase�a.
    * @return El token de acceso.
    * @throws java.lang.Exception Si se produce alg�n error en el login del
    * usuario.
    */
    
   public static AcsAccessToken doLogin(String name, String password, 
                                        int productId, int numTries) 
                                        throws Exception
   {
      return LoginImpl.doLogin(name, password, productId, numTries);
   }
   
   /**
    * Realiza la conexi�n a las aplicaciones de Administraci�n (Archivos, Usuarios y Vol�menes).
    * Valida los permisos del usuario para utilizar dichas aplicaci�nen 
    * y le proporciona un token de acceso para cada una de ellas.
    * 
    * @param name Nombre del usuario.
    * @param password Contrase�a. 
    * @param numTries N�mero de intentos incorrectos de usuario-contrase�a.
    * @return Objeto con array de tokens de acceso.
    * @throws java.lang.Exception Si se produce alg�n error en el login del
    * usuario.
    */
   public static AcsAccessTokenProducts doAdmLogin(String name ,String password,
         														int numTries)
   												 throws Exception
   {
      return LoginImpl.doAdmLogin(name,password,numTries);
   }
}