package es.ieci.tecdoc.isicres.admin.estructura.dao.impl;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import es.ieci.tecdoc.isicres.admin.base.dbex.DbConnection;
import es.ieci.tecdoc.isicres.admin.base.dbex.DynamicFns;
import es.ieci.tecdoc.isicres.admin.base.dbex.DynamicRow;
import es.ieci.tecdoc.isicres.admin.base.dbex.DynamicRows;
import es.ieci.tecdoc.isicres.admin.base.dbex.DynamicTable;
import es.ieci.tecdoc.isicres.admin.core.db.DBSessionManager;
import es.ieci.tecdoc.isicres.admin.core.xml.lite.XmlTextBuilder;
import es.ieci.tecdoc.isicres.admin.database.DepartmentsTable;
import es.ieci.tecdoc.isicres.admin.estructura.dao.Department;

/**
 * Implementaci�n de la clase Departaments.  Maneja la lista de departamentos invesDoc.
 */
public class DepartmentsImpl
{
	public DepartmentsImpl()
   {
      _list = new ArrayList();
   }

   public int count()
   {
      return _list.size();
   }

   public Department get(int index)
   {
      return (Department)_list.get(index);
   }

   public void load(int parentId, String entidad) throws Exception
   {
      DynamicTable tableInfo = new DynamicTable();
      DynamicRows rowsInfo = new DynamicRows();
      DynamicRow rowInfo = new DynamicRow();
      DepartmentsTable table = new DepartmentsTable();
      String qual;
      int counter;
      DepartmentImpl department;

      if (_logger.isDebugEnabled())
         _logger.debug("load from parentId = " + parentId);

      DbConnection dbConn=new DbConnection();
		try
		{
			dbConn.open(DBSessionManager.getSession());
			//dbConn.open("org.postgresql.Driver", "jdbc:postgresql://127.0.0.1/registro_000", "postgres", "postgres");

	         tableInfo.setTableObject(table);
	         tableInfo.setClassName(DepartmentsTable.class.getName());
	         tableInfo.setTablesMethod("getBaseTableName");
	         tableInfo.setColumnsMethod("getLoadBaseIdNameParentColumnNames");

	         rowInfo.setClassName(DepartmentImpl.class.getName());
	         rowInfo.setValuesMethod("loadIdNameParentValues");
	         rowsInfo.add(rowInfo);

	         qual = table.getParentIdQual(parentId);

	         DynamicFns.selectMultiple(dbConn, qual, false, tableInfo,
	                                 rowsInfo);

	         for (counter = 0; counter < rowInfo.getRowCount(); counter++)
	         {
	         	department = (DepartmentImpl)rowInfo.getRow(counter);
	            add(department);
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

   public void load(String entidad) throws Exception
   {
      DynamicTable tableInfo = new DynamicTable();
      DynamicRows rowsInfo = new DynamicRows();
      DynamicRow rowInfo = new DynamicRow();
      DepartmentsTable table = new DepartmentsTable();
      int counter;
      DepartmentImpl department;

      if (_logger.isDebugEnabled())
         _logger.debug("load");

      DbConnection dbConn=new DbConnection();
		try
		{
			dbConn.open(DBSessionManager.getSession());

         tableInfo.setTableObject(table);
         tableInfo.setClassName(DepartmentsTable.class.getName());
         tableInfo.setTablesMethod("getBaseTableName");
         tableInfo.setColumnsMethod("getLoadBaseIdNameParentColumnNames");

         rowInfo.setClassName(DepartmentImpl.class.getName());
         rowInfo.setValuesMethod("loadIdNameParentValues");
         rowsInfo.add(rowInfo);

         DynamicFns.selectMultiple(dbConn, "", false, tableInfo,
                                 rowsInfo);

         for (counter = 0; counter < rowInfo.getRowCount(); counter++)
         {
         	department = (DepartmentImpl)rowInfo.getRow(counter);
            add(department);
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
      String tagName = "Departments";
      DepartmentImpl department;

      bdr = new XmlTextBuilder();
      if (header)
         bdr.setStandardHeader();

      bdr.addOpeningTag(tagName);

      for (int i = 0; i < count(); i++)
      {
      	department = getImpl(i);
         bdr.addFragment(department.toXML(false));
      }

      bdr.addClosingTag(tagName);

      return bdr.getText();
   }

	public String toString()
	{
      return toXML(false);
   }

    /**
    * Devuelve un departamento de la lista.
    *
    * @param index Indice del departamento que se desea recuperar.
    *
    * @return El departamento mencionado.
    */

   private DepartmentImpl getImpl(int index)
   {
      return (DepartmentImpl)_list.get(index);
   }

   /**
    * A�ade un departamento a la lista.
    *
    * @param department El departamento mencionado.
    *
    */

   protected void add(DepartmentImpl department)
   {
      _list.add(department);
   }


   private ArrayList _list;
   private static final Logger _logger = Logger.getLogger(DepartmentsImpl.class);
}
