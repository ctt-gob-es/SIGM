
package ieci.tecdoc.idoc.admin.database;
import ieci.tecdoc.idoc.admin.internal.Defs;
import ieci.tecdoc.sbo.idoc.dao.DaoDATNodeTbl;
import ieci.tecdoc.sbo.idoc.dao.DaoDirTbl;
import org.apache.log4j.Logger;

public class DirsTable 
{
   public DirsTable()
   {
   }

   /////////////////////////////////////////////////////////////////////////
   //                         Nombres de Tablas                           //
   /////////////////////////////////////////////////////////////////////////
   
   /**
    * Devuelve el nombre de la tabla base invesDoc de directorio.
    * 
    * @return La tabla mencionada. 
    */
    
   public String getDirTableName()
   {
      return DaoDirTbl.getTblName();
   }
   
   /**
    * Devuelve el nombre de la tabla de nodos.
    * 
    * @return La tabla mencionada. 
    */
    
   public String getNodeTableName()
   {
      return DaoDATNodeTbl.getTblName();
   }
   
   /////////////////////////////////////////////////////////////////////////
   //                         Nombres de Columnas                         //
   /////////////////////////////////////////////////////////////////////////
   
   /**
    * Devuelve todas las columnas de la tabla base de directorios.
    * 
    * @return Las columnas mencionadas. 
    */
    
   public String getAllDirColumnNames()
   {
      String val;
      /*
      val = DaoDirTbl.getIdColName(true) + "," + 
            DaoDirTbl.getNameColName(true) + "," +
            DaoDirTbl.getTypeColName(true) + "," +
            DaoDirTbl.getFlagsColName(true) + "," + 
            DaoDirTbl.getRemarksColName(true) + "," + 
            DaoDirTbl.getAccessTypeColName(true) + "," + 
            DaoDirTbl.getAcsIdColName(true) + "," +
            DaoDirTbl.getCrtUserIdColName(true) + "," +
            DaoDirTbl.getCrtTSColName(true) + "," +
            DaoDirTbl.getUpdUserIdColName(true) + "," +
            DaoDirTbl.getUpdTSColName(true);
            */
      /* 
       * @SF-SEVILLA Modificacion para postgresql
       * 02-may-2006 / antmaria
       */      
      val = DaoDirTbl.getIdColName(false) + "," + 
	      DaoDirTbl.getNameColName(false) + "," +
	      DaoDirTbl.getTypeColName(false) + "," +
	      DaoDirTbl.getFlagsColName(false) + "," + 
	      DaoDirTbl.getRemarksColName(false) + "," + 
	      DaoDirTbl.getAccessTypeColName(false) + "," + 
	      DaoDirTbl.getAcsIdColName(false) + "," +
	      DaoDirTbl.getCrtUserIdColName(false) + "," +
	      DaoDirTbl.getCrtTSColName(false) + "," +
	      DaoDirTbl.getUpdUserIdColName(false) + "," +
	      DaoDirTbl.getUpdTSColName(false);
      
      return val;
   }
   
   /**
    * Devuelve las columnas de la tabla base de directorios que se pueden
    * actualizar.
    * 
    * @return Las columnas mencionadas. 
    */
    
   public String getUpdateDirColumnNames()
   {
      String val;
      
      /*
      val = DaoDirTbl.getNameColName(true) + "," +
            DaoDirTbl.getFlagsColName(true) + "," + 
            DaoDirTbl.getRemarksColName(true) + "," + 
            DaoDirTbl.getAccessTypeColName(true) + "," + 
            DaoDirTbl.getUpdUserIdColName(true) + "," +
            DaoDirTbl.getUpdTSColName(true);
      */
      /* 
       * @SF-SEVILLA Modificacion para postgresql
       * 02-may-2006 / antmaria
       */
      val = DaoDirTbl.getNameColName(false) + "," +
            DaoDirTbl.getFlagsColName(false) + "," + 
            DaoDirTbl.getRemarksColName(false) + "," + 
            DaoDirTbl.getAccessTypeColName(false) + "," + 
            DaoDirTbl.getUpdUserIdColName(false) + "," +
            DaoDirTbl.getUpdTSColName(false);             
            
      return val;
   }
   
   /**
    * Devuelve la columna de la table base de directorios de  identificador
    * de acceso.
    * @return La columna mencionada.
    */
   public String getAcsIdDirColumnName()
   {
      String val;
      
      val = DaoDirTbl.getAcsIdColName(true);
      
      return val;
   }
   
   /**
    * Devuelve las columnas de la tabla base de directorios correspondientes al
    * identificador y al nombre.
    * 
    * @return Las columnas mencionadas. 
    */
    
   public String getLiteDirColumnNames()
   {
      String val;
      
      val = DaoDirTbl.getIdColName(true) + "," + 
            DaoDirTbl.getNameColName(true);
             
      return val;
   }
   
   /**
    * Devuelve todas las columnas de la tabla de nodos para la inserci�n del
    * directorio.
    * 
    * @return Las columnas mencionadas. 
    */
    
   public String getInsertNodeColumnNames()
   {
      String val;
      
	  /*
      val = DaoDATNodeTbl.getIdColName(true) + "," + 
            DaoDATNodeTbl.getTypeColName(true) + "," +
            DaoDATNodeTbl.getParentIdColName(true);
      */
      /* 
       * @SF-SEVILLA Modificacion para postgresql
       * 02-may-2006 / antmaria
       */
      val = DaoDATNodeTbl.getIdColName(false) + "," + 
      		DaoDATNodeTbl.getTypeColName(false) + "," +
      		DaoDATNodeTbl.getParentIdColName(false);
	  // 2005/09/09 FIN SUSTITUCION
            
      return val;
   }
   
   /**
    * Devuelve el nombre de la columna identificador del padre de la tabla de 
    * nodos.
    * 
    * @return La columna mencionada. 
    */
    
   public String getNodeParentIdColumnNames()
   {
      String val;
      
      val = DaoDATNodeTbl.getParentIdColName(true);
            
      return val;
   }
   
   /////////////////////////////////////////////////////////////////////////
   //                            Quals                                    //
   /////////////////////////////////////////////////////////////////////////
   
   /**
    * Construye una expresi�n de comprobaci�n de existencia previa de nombre de
    * directorio.
    * 
    * @param dirName El nombre del directorio.
    * @return La expresi�n mencionada. 
    */
   
   public String getCountDirQual(String dirName)
   {
      String qual;
      
      qual = "WHERE " + DaoDirTbl.getNameColName(true) + "='" + dirName + "'";

      if (_logger.isDebugEnabled())
         _logger.debug("getCountDirQual: " + qual);
            
      return qual;
   }

   /**
    * Construye una expresi�n de b�squeda de un directorio a partir de su 
    * identificador.
    * 
    * @param dirId El identificador del directorio.
    * @return La expresi�n mencionada. 
    */
   
   public String getLoadDirQual(int id)
   {
      String qual;
      
      qual = "WHERE " + DaoDirTbl.getIdColName(true) + "=" + 
             Integer.toString(id);
            
      if (_logger.isDebugEnabled())
         _logger.debug("getLoadDirQual: " + qual);
            
      return qual;
   }

   /**
    * Construye una expresi�n de comprobaci�n de existencia previa de nombre de
    * directorio a partir del id del mismo.
    * 
    * @param id El identificador del directorio.
    * @param dirName El nombre del directorio.
    * @return La expresi�n mencionada. 
    */
   
   public String getCountDirIdQual(int id, String dirName)
   {
      String qual;
      
      qual = "WHERE " + DaoDirTbl.getNameColName(true) + "='" + dirName + 
           "' AND " + DaoDirTbl.getIdColName(true) + "<>" + Integer.toString(id);
            
      if (_logger.isDebugEnabled())
         _logger.debug("getCountDirIdQual: " + qual);
            
      return qual;
   }

   /**
    * Construye una expresi�n de comprobaci�n de existencia de nodo padre de
    * directorio.
    * 
    * @param id El identificador del directorio padre.
    * @return La expresi�n mencionada. 
    */
   
   public String getCountDirNodeQual(int id)
   {
      String qual;
      
      qual = "WHERE " + DaoDATNodeTbl.getParentIdColName(true) + "=" +  
           Integer.toString(id) + " AND " + 
           DaoDATNodeTbl.getTypeColName(true) + "=" + Defs.NODE_TYPE_DIRECTORY;
            
      if (_logger.isDebugEnabled())
         _logger.debug("getCountDirNodeQual: " + qual);
            
      return qual;
   }

   /**
    * Construye una expresi�n de selecci�n del nodo directorio.
    * 
    * @param id El identificador del directorio.
    * @return La expresi�n mencionada. 
    */
   
   public String getLoadNodeDirQual(int id)
   {
      String qual;
      
      qual = "WHERE " + DaoDATNodeTbl.getIdColName(true) + "=" +  
           Integer.toString(id) + " AND " + 
           DaoDATNodeTbl.getTypeColName(true) + "=" + Defs.NODE_TYPE_DIRECTORY;
            
      if (_logger.isDebugEnabled())
         _logger.debug("getLoadParentDirQual: " + qual);
            
      return qual;
   }

   /**
    * Construye una expresi�n de selecci�n de nodos hijos directorio.
    * 
    * @param id El identificador del directorio.
    * @return La expresi�n mencionada. 
    */
   
   public String getLoadChildrenDirQual(int id)
   {
      String qual;
      
      qual = "WHERE " + DaoDATNodeTbl.getParentIdColName(true) + "=" +  
           Integer.toString(id) + " AND " + 
           DaoDATNodeTbl.getTypeColName(true) + "=" + Defs.NODE_TYPE_DIRECTORY;
            
      if (_logger.isDebugEnabled())
         _logger.debug("getLoadChildrenDirQual: " + qual);
            
      return qual;
   }
   
   /**
    * Construye una expresi�n de selecci�n de archivadores y directorios de un directorio.
    * 
    * @param id El identificador del directorio.
    * @return La expresi�n mencionada. 
    */

   public String getLoadAllChildrenDirQual(int id)
   {
      String qual;
      
      qual = "WHERE " + DaoDATNodeTbl.getParentIdColName(true) + "=" +  
           Integer.toString(id) + " AND (" + 
           DaoDATNodeTbl.getTypeColName(true) + "=" + Defs.NODE_TYPE_DIRECTORY + " OR "+DaoDATNodeTbl.getTypeColName(true) + "=" + Defs.NODE_TYPE_ARCHIVE+")";
            
      if (_logger.isDebugEnabled())
         _logger.debug("getLoadChildrenDirQual: " + qual);
            
      return qual;
   }
   
   /**
    * Construye sentencia de b�squeda  para obtener identificadores y 
    * nombres de directorios partir de un directorio padre.
    * 
    * @param Identificador del padre.    
    * @return La expresi�n de b�squeda. 
    */
   
   public String getLoadDirsParentIdQual(int parentid)
   {
      String qual;
      //
      qual ="WHERE " + DaoDirTbl.getIdColName(true) +
         	" IN (SELECT " + DaoDATNodeTbl.getIdColName(true) +  
      		" FROM " + DaoDATNodeTbl.getTblName() + 
      		" WHERE " + DaoDATNodeTbl.getParentIdColName(true) + "=" +  
      		Integer.toString(parentid) + " AND " + 
      		DaoDATNodeTbl.getTypeColName(true) + "=" + 
      		Defs.NEXT_ID_TYPE_DIRECTORY + ")"; 
      
      return qual; 
   }
   

   private static final Logger _logger = Logger.getLogger(DirsTable.class);

}