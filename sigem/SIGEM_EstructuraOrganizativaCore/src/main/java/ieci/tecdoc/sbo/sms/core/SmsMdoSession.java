
package ieci.tecdoc.sbo.sms.core;

import java.util.Date;
import ieci.tecdoc.core.exception.IeciTdException;
import ieci.tecdoc.core.db.DbError;
import ieci.tecdoc.core.datetime.DateTimeUtil;
import ieci.tecdoc.core.base64.Base64Util;
import ieci.tecdoc.core.crypto.CryptoUtil;
import ieci.tecdoc.core.textutil.Util;
import ieci.tecdoc.sgm.base.dbex.DbConnection;

public final class SmsMdoSession
{
   
   private SmsMdoSession()
   {
   }
   
   // NO poner transacci�n, ya que al insertar sesi�n se necesita obtener
   // un id y para ello se abre y cierra una transacci�n.

   public static String beginSession(DbConnection dbConn, String appId, int userId, String entidad) throws Exception
   {
      
      String encSessId;
      int    decSessId;      
      
      deletePreviousSession(dbConn, appId, userId);  

      decSessId = insertSession(dbConn, appId, userId, entidad);
         
      encSessId = encodeSessionId(decSessId, appId, userId);
         
      return encSessId;
      
   }
   
   // NO poner transacci�n, ya que al insertar sesi�n se necesita obtener
   // un id y para ello se abre y cierra una transacci�n.
   // Permite conexi�n simult�nea del mismo usuario

   public static String beginGenericSession(DbConnection dbConn, int userId, String entidad) throws Exception
   {
      
      String encSessId;
      int    decSessId;
      String appId = SmsApp.GENERIC;

      decSessId = insertSession(dbConn, appId, userId, entidad);
         
      encSessId = encodeSessionId(decSessId, appId, userId);
         
      return encSessId;
      
   }

   public static void endSession(DbConnection dbConn, String sessId)
                      throws Exception
   {
      
      int decSessId;
      
      decSessId = getDecodedSessionId(sessId);
      
      deleteSession(dbConn, decSessId);
      
   }

   // Si aInfo es null, no se chequea.
   
   public static boolean isValidSession(DbConnection dbConn, String sessId)
                         throws Exception
   {
      
      boolean         valid = true;
      int             decSessId, userId;
      SmsDaoSessRecAc rec;
      
      decSessId = getDecodedSessionId(sessId);
      
      rec = selectSessionRow(dbConn, decSessId);
      
      if (rec == null)      
         return false;         
      
      valid = validateSessionId(decSessId, rec.m_appId, rec.m_userId, sessId);
      
      return valid;
                                            
   }   
   
   // **************************************************************************
  
   // Fuera de transacci�n
   
   private static int insertSession(DbConnection dbConn, String appId, int userId, String entidad)
                      throws Exception
   {
      
      int             sessId;
      Date            cdt;
      SmsDaoSessRecAc recAc;
      
      sessId = SmsNextId.generateNextId(entidad);
      cdt    = DateTimeUtil.getCurrentDateTime();
      
      recAc = new SmsDaoSessRecAc();
      
      recAc.m_id     = sessId;
      recAc.m_appId  = appId;
      recAc.m_userId = userId;      
      recAc.m_crtTs  = cdt;

      SmsDaoSessTbl.insertRow(dbConn, recAc);

      return sessId;
      
   }
   
   private static void deletePreviousSession(DbConnection dbConn, String appId, int userId)
                       throws Exception
   {
      SmsDaoSessTbl.deleteRow(dbConn, appId, userId);
   }
   
   private static void deleteSession(DbConnection dbConn, int id)
                       throws Exception
   {
      SmsDaoSessTbl.deleteRow(dbConn, id);
   }
   
   private static SmsDaoSessRecAc selectSessionRow(DbConnection dbConn, int sessId)
                                 throws Exception
   {      
     
      try
      {         
         return SmsDaoSessTbl.selectRow(dbConn, sessId);
      }
      catch (IeciTdException e)
      {
         if (e.getErrorCode() == DbError.EC_NOT_FOUND)
            return null;
         else
            throw e;
      }
      
   }
   
   // **************************************************************************

   private static String formatSessionId(int id) 
                         throws Exception
   {
      
      String       formatId;
      String       strId, aux;
      int          len;
           
      strId  = Util.formatLongInteger(id);
      len    = strId.length();
       
      aux = new String(strId);     
      
      while(len < 32)
      {
         aux = "0" + aux;
         len = len + 1;         
      }      
            
      formatId = new String(aux);      
      
      return formatId;
      
   }
   private static String encodeSessionId(int decId, String appId, int userId) 
                         throws Exception
   {
      
      String encId;
      byte[] hash;
      String encHash;
      String strDecId, strUserId;
      
      strDecId  = Util.formatLongInteger(decId);
      strUserId = Util.formatLongInteger(userId);
     
      hash    = CryptoUtil.generateSha1Hash(strDecId + appId + strUserId);
      encHash = Base64Util.encode(hash);
      encHash = encHash.replace('=', '_'); // Para que se pueda pasar por url.
      encHash = encHash.replace('+', '_'); // Para que se pueda pasar por url.
      encHash = encHash.replace('/', '_'); // Para que se pueda pasar por url.
      encId   = formatSessionId(decId) + encHash;
      
      return encId;
      
   }
   
   private static boolean validateSessionId(int decId, String appId, 
                                            int userId, String encId)
                          throws Exception
   {
      
      boolean valid = false;
      String  encId1;
      
      encId1 = encodeSessionId(decId, appId, userId);
      
      if (encId1.equals(encId))
         valid = true;
      
      return valid;
      
   }
   
   private static int getDecodedSessionId(String encId)
   {
      String strDecId;
      int    decSessId;
      
      strDecId = encId.substring(0, 32);
     
      decSessId = Integer.parseInt(strDecId);
      
      return decSessId;
   }
   
} // class
