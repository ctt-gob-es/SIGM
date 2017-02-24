package ieci.tecdoc.sbo.idoc.api;

import java.io.File;
import java.io.FileOutputStream;

import ieci.tecdoc.core.db.DbConnection;
import ieci.tecdoc.core.db.DbConnectionConfig;
import ieci.tecdoc.sbo.config.CfgMdoConfig;
import ieci.tecdoc.sbo.idoc.report.std.ReportManager;

/**
 * @author egonzalez
 */
public final class Report
{
  /** Configuraci�n de la conexi�n de base de datos */
  DbConnectionConfig m_dbConnConfig;
  
  /** Ruta donde se encuentra el fichero de configuraci�n de base de datos */
  String m_configDir;
  
  public Report() throws Exception
  {
     m_dbConnConfig = null;
     m_configDir    = null;
  }

  /**
   * Constructor 
   * 
   * @param configDir Ruta donde se encuentra el fichero de configuraci�n 
   * de base de datos
   * @throws Exception
   */
  public Report(String configDir) throws Exception
  { 
     m_dbConnConfig = null;
     m_configDir    = configDir; 
  }
  
  /**
   * Establece la configuraci�n de la conexi�n de base de datos
   * 
   * @param dbConnConfig Configuraci�n de la conexi�n de base de datos
   * @throws Exception
   */
  public void setConnectionConfig(DbConnectionConfig dbConnConfig)
              throws Exception
  {
     m_dbConnConfig = dbConnConfig;
  }
  
  /**
   * Devuelve la conexi�n a base de datos. Si la conexi�n es nula la crea 
   * a trav�s del fichero de configuraci�n de base de datos. 
   * 
   * @return Conexi�n con la base de datos
   * @throws Exception
   */
  private DbConnectionConfig getDbConfig() throws Exception
  {
     if (m_dbConnConfig == null)
     {
        if (m_configDir == null)
        {
           m_dbConnConfig = CfgMdoConfig.getDbConfig();
        }
        else
        {
           m_dbConnConfig = CfgMdoConfig.getDbConfig(m_configDir);
        }
     }
     
     return  m_dbConnConfig;
  }
  
  /**
   * Crea un objeto ReportObject con la informaci�n de un informe 
   * concreto. Antes de crearlo verifica si el usuario que trata de 
   * obtener dicho ArchiveObject tiene permisos sobre el archivador.  
   * 
   * @param acs Objeto AcsAccessObject con los permisos del usuario.
   * Si se recibe <tt>null</tt> no se chequean permisos
   * @param archId Identificador del informe
   * @return ReportObject con la informaci�n del informe.
   * @throws Exception arroja una IeciTdException en caso de que el
   * usuario no tenga permisos de acceso sobre el informe
   */
  public ReportObject loadReport(AcsAccessObject acs, int reportId)
                               throws Exception
  {
     
     ReportToken   token = null;
     ReportObject report = null;
     
     try
     {
        
        DbConnection.open(getDbConfig());
        
        if (acs == null)
           token = ReportManager.loadReport(null, reportId);
        else
           token = ReportManager.loadReport(acs.getAccessToken(), reportId);

        DbConnection.close();

        report = new ReportObject(token);
        
        return report;
                                         
     }
     catch (Exception e)
     {
        DbConnection.ensureClose(e);  
        return null;
     }           
  }
  
  /**
   * Devuelve <tt>true</tt> si el usuario tiene permisos de acceso sobre 
   * el informe
   * 
   * @param acs Objeto AcsAccessObject con los permisos del usuario. 
   * Si se recibe <tt>null</tt> no se chequean permisos
   * @param reportId Identificador del informe
   * @return <tt>true</tt> si el usuario tiene permisos de acceso sobre 
   * el informe. <tt>false</tt> en caso contrario
   * @throws Exception
   */
  public boolean canLoadReport(AcsAccessObject acs,
                                int reportId) throws Exception
  {
     boolean can = false;
     
     try
     {
        
        DbConnection.open(getDbConfig());               

        can = ReportManager.canLoadReport(acs.getAccessToken(), reportId);

        DbConnection.close();
        
        return can;
                                         
     }
     catch (Exception e)
     {
        DbConnection.ensureClose(e);  
        return can;
     }
           
  }
  
  public String attachFdrIds (int[] folderIds, int userId) throws Exception
  {
    String tablename = null;
    
    try
    {
       DbConnection.open(getDbConfig());       
       tablename = ReportManager.attachFdrIds(folderIds, userId);
       DbConnection.close();
                               
    }
    catch (Throwable e)
    {
       DbConnection.ensureClose(new Exception(e));  
    }
    
    return tablename;
  }
  
  public void detachFdrIds (int userId, String tablename) throws Exception
  {
    try
    {
       DbConnection.open(getDbConfig());       
       ReportManager.detachFdrIds(userId, tablename);
       DbConnection.close();
                               
    }
    catch (Throwable e)
    {
       DbConnection.ensureClose(new Exception(e));  
    }
  }
  
  public static void main (String args[])
  {
    try
    {
      int reportId = 2;
      
      String drv = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
      String url = "jdbc:microsoft:sqlserver://egonzaleze:1066;databasename=idoc9";
      String usr = "sa";
      String pwd = "manager";         
      
      String iDocUsr = "consulta";
      String iDocPwd = "consulta"; 

      DbConnectionConfig dbConConfig = new DbConnectionConfig(drv, url, usr, pwd);
      
      Login loginApi = new Login ();
      loginApi.setConnectionConfig(dbConConfig);
      AcsAccessObject acs = loginApi.doLoginStd(iDocUsr, iDocPwd, 1);
      
      Report reportApi = new Report ();
      reportApi.setConnectionConfig(dbConConfig);
      
      ReportObject report = reportApi.loadReport(acs, reportId);
      
      int[] fdrIds = {1,6,4,9};
      
      String tablename = reportApi.attachFdrIds(fdrIds, acs.getUserId());
      reportApi.detachFdrIds(acs.getUserId(), tablename);
      
      System.out.println(report);
      
      File file = new File ("C:\\miReport.txt");
      if (file.exists())
        file.delete();
      FileOutputStream fos = new FileOutputStream (file);     
      fos.write(report.getData());
      fos.close();
                  
    }
    catch (Throwable e)
    {
      e.printStackTrace();
    }
  }
  
}
