
package ieci.tecdoc.sbo.idoc.datree;

import ieci.tecdoc.sbo.idoc.dao.DaoDirTbl;
import ieci.tecdoc.sbo.idoc.dao.DaoOutputRows;
import ieci.tecdoc.sgm.base.dbex.DbOutputRecord;

import java.util.ArrayList;


public final class DATDaoDirNodeRows implements DaoOutputRows
{
   private ArrayList  m_al;
   
   public DATDaoDirNodeRows()
   {    
      m_al = new ArrayList();  
   }
   
   public int count()
   {
      return m_al.size();
   }
   
   public String getColumnNames() throws Exception
   {   
      
      StringBuffer tbdr;
      
      tbdr = new StringBuffer();

      tbdr.append(DaoDirTbl.getIdColName(false));      
      tbdr.append(",").append(DaoDirTbl.getNameColName(false));      

      return tbdr.toString();
      
   }
    
   public DATDaoDirNodeOutputRow getRecord(int index)
   {
      return (DATDaoDirNodeOutputRow) m_al.get(index);
   }
   
   public DbOutputRecord newRecord()
   {
      
      DATDaoDirNodeOutputRow rec = new DATDaoDirNodeOutputRow();
      
      m_al.add(rec);
      
      return rec;
      
   }
   
} // class
