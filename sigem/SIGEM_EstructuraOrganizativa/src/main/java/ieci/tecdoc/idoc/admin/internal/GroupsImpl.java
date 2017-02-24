package ieci.tecdoc.idoc.admin.internal;

import ieci.tecdoc.core.db.DBSessionManager;
import ieci.tecdoc.core.xml.lite.XmlTextBuilder;
import ieci.tecdoc.idoc.admin.api.user.Group;
import ieci.tecdoc.idoc.admin.database.GroupsTable;

import ieci.tecdoc.sgm.base.dbex.DbConnection;
import ieci.tecdoc.sgm.base.dbex.DynamicFns;
import ieci.tecdoc.sgm.base.dbex.DynamicRow;
import ieci.tecdoc.sgm.base.dbex.DynamicRows;
import ieci.tecdoc.sgm.base.dbex.DynamicTable;

import java.util.ArrayList;

import org.apache.log4j.Logger;

/**
 * Implementaci�n de la clase Groups.  Maneja la lista de grupos invesDoc.
 */
public class GroupsImpl
{
	public GroupsImpl()
   {
      _list = new ArrayList();
   }

   public int count() 
   {
      return _list.size();
   }

   public Group get(int index) 
   {
      return (Group)_list.get(index);
   }
   
   public void load(String entidad) throws Exception
   {
      DynamicTable tableInfo = new DynamicTable(); 
      DynamicRows rowsInfo = new DynamicRows();
      DynamicRow rowInfo = new DynamicRow();
      GroupsTable table = new GroupsTable();
      int counter;
      GroupImpl group;
   
      if (_logger.isDebugEnabled())
         _logger.debug("load");
      
      DbConnection dbConn=new DbConnection(); 
		try
		{
			dbConn.open(DBSessionManager.getSession(entidad));
			//dbConn.open("org.postgresql.Driver", "jdbc:postgresql://127.0.0.1/registro_000", "postgres", "postgres");

         tableInfo.setTableObject(table);
         tableInfo.setClassName(GroupsTable.class.getName());
         tableInfo.setTablesMethod("getBaseTableName");
         tableInfo.setColumnsMethod("getLoadBaseIdNameColumnNames");
         
         rowInfo.setClassName(GroupImpl.class.getName());
         rowInfo.setValuesMethod("loadIdNameValues");
         rowsInfo.add(rowInfo);
         
         DynamicFns.selectMultiple(dbConn, "", false, tableInfo, 
                                 rowsInfo);
         
         for (counter = 0; counter < rowInfo.getRowCount(); counter++)
         {
            group = (GroupImpl)rowInfo.getRow(counter);
            add(group);
         }
         
		}
		catch(Exception e)
		{
         _logger.error(e);
         throw e;
		}
      finally
      {
         dbConn.close();
      }
         
   }
   
   public String toXML(boolean header) 
   {
      XmlTextBuilder bdr;
      String tagName = "Groups";
      GroupImpl group;
      
      bdr = new XmlTextBuilder();
      if (header)
         bdr.setStandardHeader();

      bdr.addOpeningTag(tagName);

      for (int i = 0; i < count(); i++)
      {
         group = getImpl(i);
         bdr.addFragment(group.toXML(false));
      }

      bdr.addClosingTag(tagName);
      
      return bdr.getText();
   }

	public String toString()
	{
      return toXML(false);
   }

    /**
    * Devuelve un grupo de la lista.
    * 
    * @param index Indice del grupo que se desea recuperar.
    * 
    * @return El grupo mencionado.
    */
    
   private GroupImpl getImpl(int index)
   {
      return (GroupImpl)_list.get(index);  
   }
 
   /**
    * A�ade un grupo a la lista.
    * 
    * @param group El grupo mencionado.
    *  
    */

   protected void add(GroupImpl group) 
   {
      _list.add(group);
   }


   private ArrayList _list;
   private static final Logger _logger = Logger.getLogger(GroupsImpl.class);
}
