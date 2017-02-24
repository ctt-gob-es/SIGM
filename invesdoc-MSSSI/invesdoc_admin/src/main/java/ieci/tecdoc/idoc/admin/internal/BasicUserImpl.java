
package ieci.tecdoc.idoc.admin.internal;

import ieci.tecdoc.core.db.DbOutputStatement;
import ieci.tecdoc.idoc.admin.api.user.BasicUser;
import org.apache.log4j.Logger;

/**
 * Implementaci�n de la clase BasicUser.
 */

public class BasicUserImpl implements BasicUser
{

   /**
    * Construye un objeto de la clase.
    *
    * @param id Identificador del usuario.
    * @param name Nombre del usuario.
    */
    
   protected BasicUserImpl(int id, String name)
   {
      _id = id;
      _name = name;
   }
   
   /**
    * Construye un objeto de la clase.
    *
    */
    
   public BasicUserImpl()
   {
      _id = Defs.NULL_ID;
      _name = "(Vacio)";
   }
   
   public int getId()
   {
      return _id;      
   }
   
   public String getName()
   {
      return _name;
   }

   /**
    * Recupera de la base de datos informaci�n asociada al usuario. 
    * 
    * @param statement
    * @param idx
    * @return 
    * @throws java.lang.Exception
    */
    
   public Integer loadValues(DbOutputStatement statement, Integer idx) 
                  throws Exception 
   {
      int index = idx.intValue();

      if (_logger.isDebugEnabled())
         _logger.debug("loadValues");

      _id = statement.getLongInteger(index++);
      _name = statement.getShortText(index++);

      return new Integer(index);
   }

   private String _name;
   private int _id;

   private static final Logger _logger = Logger.getLogger(BasicUserImpl.class);
}