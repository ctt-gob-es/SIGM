
package ieci.tecdoc.sbo.idoc.login;

import ieci.tecdoc.core.exception.IeciTdException;
import ieci.tecdoc.sbo.acs.base.AcsAccessToken;
import ieci.tecdoc.sbo.acs.base.AcsAccessTokenProduct;
import ieci.tecdoc.sbo.acs.base.AcsAccessTokenProducts;
import ieci.tecdoc.sbo.acs.base.AcsProduct;
import ieci.tecdoc.sbo.uas.base.UasAuthToken;
import ieci.tecdoc.sbo.uas.std.UasMdoAuth;
import ieci.tecdoc.sbo.acs.std.AcsMdoAccessToken;

public final class LoginStd
{

   private LoginStd()
   {
   }  

   public static AcsAccessToken doLogin(String name, String pwd,
												    int cntsTriesNum, String entidad)
									     throws Exception
   {
      
      UasAuthToken   authToken   = null;
      AcsAccessToken accessToken = null;  
      boolean        hasAccess;      
                                
      authToken = UasMdoAuth.authenticateUser(name, pwd, cntsTriesNum, entidad);
         
      accessToken = AcsMdoAccessToken.createiDocAccessToken(authToken, entidad);
         
      hasAccess = LoginMdoAuth.hasAuthEnteriDocApp(accessToken);
         
      if (!hasAccess)    
      {
      
         throw new IeciTdException(LoginError.EC_NOT_AUTH_ENTER_APP,
                                   LoginError.EM_NOT_AUTH_ENTER_APP);          
      }               
      
      return accessToken;
      
   }

   public static AcsAccessToken iDocAdmAppDoLogin(String name, String pwd,
												                int cntsTriesNum, String entidad)
									     throws Exception
   {
      
      UasAuthToken   authToken   = null;
      AcsAccessToken accessToken = null;  
      boolean        hasAccess;      
                                
      authToken = UasMdoAuth.authenticateUser(name, pwd, cntsTriesNum, entidad);
         
      accessToken = AcsMdoAccessToken.createiDocAccessToken(authToken, entidad);
         
      hasAccess = LoginMdoAuth.hasAuthEnteriDocAdmApp(accessToken);
         
      if (!hasAccess)    
      {
      
         throw new IeciTdException(LoginError.EC_NOT_AUTH_ENTER_APP,
                                   LoginError.EM_NOT_AUTH_ENTER_APP);          
      }               
      
      return accessToken;
      
   }

   public static AcsAccessToken iUserAdmAppDoLogin(String name, String pwd,
												                 int cntsTriesNum, String entidad)
									     throws Exception
   {
      
      UasAuthToken   authToken   = null;
      AcsAccessToken accessToken = null;  
      boolean        hasAccess;      
                                
      authToken = UasMdoAuth.authenticateUser(name, pwd, cntsTriesNum, entidad);
         
      accessToken = AcsMdoAccessToken.createiUserAccessToken(authToken, entidad);
         
      hasAccess = LoginMdoAuth.hasAuthEnteriUserAdmApp(accessToken);
         
      if (!hasAccess)    
      {
      
         throw new IeciTdException(LoginError.EC_NOT_AUTH_ENTER_APP,
                                   LoginError.EM_NOT_AUTH_ENTER_APP);          
      }               
      
      return accessToken;
      
   }

   public static AcsAccessToken iVolAdmAppDoLogin(String name, String pwd,
												                 int cntsTriesNum, String entidad)
									     throws Exception
   {
      
      UasAuthToken   authToken   = null;
      AcsAccessToken accessToken = null;  
      boolean        hasAccess;      
                                
      authToken = UasMdoAuth.authenticateUser(name, pwd, cntsTriesNum, entidad);
      
      accessToken = AcsMdoAccessToken.createiVolAccessToken(authToken, entidad);
      
      hasAccess = LoginMdoAuth.hasAuthEnteriVolAdmApp(accessToken);
         
      if (!hasAccess)    
      {
      
         throw new IeciTdException(LoginError.EC_NOT_AUTH_ENTER_APP,
                                   LoginError.EM_NOT_AUTH_ENTER_APP);          
      }               
      
      return accessToken;
      
   }
   
   public static AcsAccessTokenProducts doAdmLogin(String name,String pwd, 
         														int cntsTriesNum, String entidad)
   												throws Exception
   {
      AcsAccessTokenProducts acsTokenProducts = new AcsAccessTokenProducts();
      AcsAccessTokenProduct acsTokenProduct   = null;
      UasAuthToken   authToken   = null;
      AcsAccessToken accessToken = null;  
      boolean        hasAccess;      
                                
      authToken = UasMdoAuth.authenticateUser(name, pwd, cntsTriesNum, entidad);
            
      accessToken = AcsMdoAccessToken.createiDocAccessToken(authToken, entidad);      
      hasAccess = LoginMdoAuth.hasAuthEnteriDocAdmApp(accessToken);
      
      acsTokenProduct = new AcsAccessTokenProduct();
      acsTokenProduct.setAcsAccessToken(accessToken);
      acsTokenProduct.setProductId(AcsProduct.IDOC);
      acsTokenProduct.setHasAccess(hasAccess);
      
      acsTokenProducts.add(acsTokenProduct);
      
      
      
      accessToken = AcsMdoAccessToken.createiUserAccessToken(authToken, entidad);      
      hasAccess = LoginMdoAuth.hasAuthEnteriUserAdmApp(accessToken);
      
      acsTokenProduct = new AcsAccessTokenProduct();
      acsTokenProduct.setAcsAccessToken(accessToken);
      acsTokenProduct.setProductId(AcsProduct.IUSER);
      acsTokenProduct.setHasAccess(hasAccess);
      
      acsTokenProducts.add(acsTokenProduct);
      
   
      accessToken = AcsMdoAccessToken.createiVolAccessToken(authToken, entidad);         
      hasAccess = LoginMdoAuth.hasAuthEnteriVolAdmApp(accessToken);
      
      acsTokenProduct = new AcsAccessTokenProduct();
      acsTokenProduct.setAcsAccessToken(accessToken);
      acsTokenProduct.setProductId(AcsProduct.IVOL);
      acsTokenProduct.setHasAccess(hasAccess);
      
      acsTokenProducts.add(acsTokenProduct);
      
      return (acsTokenProducts);
   }
   
   
} // class
