package ieci.tecdoc.core.db;

import ieci.tecdoc.core.exception.IeciTdException;

import java.io.Serializable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.sql.DataSource;


public class DbConnection implements Serializable
{

    //~ Static fields/initializers ---------------------------------------------

    // ---------------------------------------------
   static final ThreadLocal m_tJdbc         = new ThreadLocal();
   static final ThreadLocal m_tMustBeClosed = new ThreadLocal();
   
   //Guardamos la informaci�n del motor en variables que se rellenan al hacer 
   //el open de la conexi�n porque si se le pregunta directamente a la
   //conexi�n estando con un resultSet abierto, cierra el resulSet
   private static int     m_engine;     
   private static String  m_engineVersion;    

    //~ Methods ----------------------------------------------------------------

    // ----------------------------------------------------------------
   public static synchronized void open(Connection jdbcConn)
                                   throws Exception
   {

       if((Connection)m_tJdbc.get() == null)
       {

           m_tJdbc.set(jdbcConn);
           m_tMustBeClosed.set(new Boolean(false));
           m_engine        = getConnectionEngine();
           m_engineVersion = getConnectionEngineVersion();

       }
       else
       {
       /*
        * RAUL. Lo he quitado porque a veces interesa no chequear esto. No
        * veo ning�n problema para dejarlo as�. Si alguien lee esto y lo ve,
        * que me lo cuente.
        * 
           throw new IeciTdException(DbError.EC_ALREADY_EXIST_CONN,
                                     DbError.EM_ALREADY_EXIST_CONN);
       */     
       }

   }

   public static synchronized Connection open(String ctxName) throws Exception {

		Connection jdbcConn = (Connection) m_tJdbc.get();

		if (jdbcConn == null) {

			jdbcConn = openConnection(ctxName);

			m_tJdbc.set(jdbcConn);
			m_tMustBeClosed.set(new Boolean(true));
			m_engine = getConnectionEngine();
			m_engineVersion = getConnectionEngineVersion();

		} else {

			/*
			 * RAUL. Lo he quitado porque a veces interesa no chequear esto. No
			 * veo ning�n problema para dejarlo as�. Si alguien lee esto y lo
			 * ve, que me lo cuente.
			 * 
			 * throw new IeciTdException(DbError.EC_ALREADY_EXIST_CONN,
			 * DbError.EM_ALREADY_EXIST_CONN);
			 */
		}

		return jdbcConn;

	}
   
   public static synchronized Connection open(String drvClsName, String url,
			String user, String pwd) throws Exception {

		Connection jdbcConn = (Connection) m_tJdbc.get();

		if (jdbcConn == null) {

			jdbcConn = openConnection(drvClsName, url, user, pwd);

			m_tJdbc.set(jdbcConn);
			m_tMustBeClosed.set(new Boolean(true));
			m_engine = getConnectionEngine();
			m_engineVersion = getConnectionEngineVersion();

		} else {

			/*
			 * RAUL. Lo he quitado porque a veces interesa no chequear esto. No
			 * veo ning�n problema para dejarlo as�. Si alguien lee esto y lo
			 * ve, que me lo cuente.
			 * 
			 * throw new IeciTdException(DbError.EC_ALREADY_EXIST_CONN,
			 * DbError.EM_ALREADY_EXIST_CONN);
			 */
		}

		return jdbcConn;

	}
   
   public static synchronized Connection open(String ctxName, String user,
			String pwd) throws Exception {

		Connection jdbcConn = (Connection) m_tJdbc.get();

		if (jdbcConn == null) {

			jdbcConn = openConnection(ctxName, user, pwd);

			m_tJdbc.set(jdbcConn);
			m_tMustBeClosed.set(new Boolean(true));
			m_engine = getConnectionEngine();
			m_engineVersion = getConnectionEngineVersion();

		} else {

			/*
			 * RAUL. Lo he quitado porque a veces interesa no chequear esto. No
			 * veo ning�n problema para dejarlo as�. Si alguien lee esto y lo
			 * ve, que me lo cuente.
			 * 
			 * throw new IeciTdException(DbError.EC_ALREADY_EXIST_CONN,
			 * DbError.EM_ALREADY_EXIST_CONN);
			 */
		}

		return jdbcConn;

	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param dbConConfig
	 * 
	 * @return Connection
	 * 
	 * @throws Exception
	 *             DOCUMENT ME!
	 */
	public static Connection open(DbConnectionConfig dbConConfig)
			throws Exception {

		String cntParam;
		String url;
		String user;
		String pwd;
		Connection jdbcConn = null;

		cntParam = dbConConfig.getCntParam();
		user = dbConConfig.getUser();
		pwd = dbConConfig.getPwd();

		if (dbConConfig.isCntByDriver()) {

			url = dbConConfig.getUrl();
			jdbcConn = open(cntParam, url, user, pwd);

		} else {

			if ((user == null) && (pwd == null))
				jdbcConn = open(cntParam);
			else
				jdbcConn = open(cntParam, user, pwd);

		}

		return jdbcConn;

	}
   
   /*
   public static synchronized Connection open(String ctxName, String entidad)
                                         throws Exception
   {

       Connection jdbcConn = (Connection)m_tJdbc.get();
        
       if(jdbcConn == null)
       {
    	   ctxName+=entidad;
           jdbcConn = openConnection(ctxName);
            
           m_tJdbc.set(jdbcConn);
           m_tMustBeClosed.set(new Boolean(true));
           m_engine        = getConnectionEngine();
           m_engineVersion = getConnectionEngineVersion();

       }
       else
       {
           
        // RAUL. Lo he quitado porque a veces interesa no chequear esto. No
        // veo ning�n problema para dejarlo as�. Si alguien lee esto y lo ve,
        // que me lo cuente.
         
        // throw new IeciTdException(DbError.EC_ALREADY_EXIST_CONN,
        //                             DbError.EM_ALREADY_EXIST_CONN);
                   
       }

       return jdbcConn;

   }*/

   /*
   public static synchronized Connection open(String drvClsName, String url,
                                              String user, String pwd, String entidad)
                                         throws Exception
   {

       Connection jdbcConn = (Connection)m_tJdbc.get();

       if(jdbcConn == null)
       {

           jdbcConn = openConnection(drvClsName, url, user, pwd);
           
           m_tJdbc.set(jdbcConn);
           m_tMustBeClosed.set(new Boolean(true));
           m_engine        = getConnectionEngine();
           m_engineVersion = getConnectionEngineVersion();

       }
       else
       {
           
        // RAUL. Lo he quitado porque a veces interesa no chequear esto. No
        // veo ning�n problema para dejarlo as�. Si alguien lee esto y lo ve,
        // que me lo cuente.
         
        //   throw new IeciTdException(DbError.EC_ALREADY_EXIST_CONN,
        //                             DbError.EM_ALREADY_EXIST_CONN);
                    
       }

       return jdbcConn;

   }*/

   /*
   public static synchronized Connection open(String ctxName, String user,
                                              String pwd, String entidad)
                                         throws Exception
   {

       Connection jdbcConn = (Connection)m_tJdbc.get();

       if(jdbcConn == null)
       {
    	   ctxName+=entidad;
           jdbcConn = openConnection(ctxName, user, pwd);
            
           m_tJdbc.set(jdbcConn);
           m_tMustBeClosed.set(new Boolean(true));
           m_engine        = getConnectionEngine();
           m_engineVersion = getConnectionEngineVersion();

       }
       else
       {
           
       //
       // RAUL. Lo he quitado porque a veces interesa no chequear esto. No
       // veo ning�n problema para dejarlo as�. Si alguien lee esto y lo ve,
       // que me lo cuente.
        
       // throw new IeciTdException(DbError.EC_ALREADY_EXIST_CONN,
       //                            DbError.EM_ALREADY_EXIST_CONN);
                    
       }

       return jdbcConn;

   }*/

    /**
     * DOCUMENT ME!
     *
     * @param dbConConfig
     *
     * @return Connection
     *
     * @throws Exception DOCUMENT ME!
     */
   /*
   public static Connection open(DbConnectionConfig dbConConfig, String entidad)
                            throws Exception
   {

       String     cntParam;
       String     url;
       String     user;
       String     pwd;
       Connection jdbcConn = null;
        
       cntParam = dbConConfig.getCntParam();
       user     = dbConConfig.getUser();
       pwd      = dbConConfig.getPwd();

       if(dbConConfig.isCntByDriver())
       {

           url      = dbConConfig.getUrl();
           jdbcConn = open(cntParam, url, user, pwd);

       }
       else
       {

           if((user == null) && (pwd == null))
               jdbcConn = open(cntParam, entidad);
           else
               jdbcConn = open(cntParam, user, pwd, entidad);

       }

       return jdbcConn;

   }*/

   public static void close()
                      throws Exception
   {

       boolean    mustbeClose = mustbeClose();       
       Connection jdbcConn    = (Connection)m_tJdbc.get();

       m_tJdbc.set(null);
       m_tMustBeClosed.set(null);

       try
       {

           if((jdbcConn != null) && mustbeClose)
               jdbcConn.close();

       }
      catch(Exception e)
       {

           throw new IeciTdException(DbError.EC_NOT_CLOSED_CONN,
                                     DbError.EM_NOT_CLOSED_CONN);

       }

   }
   
   public static int getEngine() throws Exception
   {

      Connection jdbcConn = (Connection)m_tJdbc.get();

      if(jdbcConn == null)
      {

         throw new IeciTdException(DbError.EC_NO_EXIST_CONN,
                                   DbError.EM_NO_EXIST_CONN);

      }



      return m_engine;

   }
   
   public static String getEngineVersion() throws Exception
   {

      Connection jdbcConn = (Connection)m_tJdbc.get();

      if(jdbcConn == null)
      {

         throw new IeciTdException(DbError.EC_NO_EXIST_CONN,
                                   DbError.EM_NO_EXIST_CONN);

      }



      return m_engineVersion;

   }

   /**
    * @autor IECISA
    * 
    * 
    * @return boolean
    * @since V1.0
    */
   private static boolean mustbeClose()
   {
      
      Boolean mustbeClose = (Boolean)m_tMustBeClosed.get();
      
      if(mustbeClose == null)
      {
          mustbeClose = new Boolean(false);    
      }
      
      return mustbeClose.booleanValue();
      
   }

   public static void beginTransaction()
                      throws Exception
   {

      Connection jdbcConn = (Connection)m_tJdbc.get();

      if(jdbcConn == null)
      {

         throw new IeciTdException(DbError.EC_NO_EXIST_CONN,
                                   DbError.EM_NO_EXIST_CONN);
            
      }

      if (getEngine() == DbEngine.POSTGRESQL ){
    	 /* 
		 * @SF-SEVILLA DESACTIVAR LAS TRANSACCIONES En Postgresql, parece no tomarselas muy bien,
		 * cuando son muchas sentencias por ej.
		 * cnd borras un archivador, no termina de hacer el commit, y no veo la causa
		 * Statement stmt = DbConnection.getJdbcConnection().createStatement();
         * stmt.executeUpdate("BEGIN");
         * SQLWarning warn = stmt.getWarnings();
         * if (warn!= null ){
         *	  System.out.print( warn.getMessage());
         *    warn.printStackTrace();  
         * }
         * stmt.close();
         * DbUtil.executeStatement("BEGIN");
		 * 02-may-2006 / antmaria
         */
      }
      else{
    	  if(!jdbcConn.getAutoCommit())
          {

              throw new IeciTdException(DbError.EC_ALREADY_IN_TRANS, DbError.EM_ALREADY_IN_TRANS);
                
          }
    	  jdbcConn.setAutoCommit(false);
      }


   }

   public static void endTransaction(boolean commit)
                      throws Exception
   {

      Connection jdbcConn = (Connection)m_tJdbc.get();

      if(jdbcConn == null)
      {

          throw new IeciTdException(DbError.EC_NO_EXIST_CONN,
                                    DbError.EM_NO_EXIST_CONN);
            
      }
      
      if (getEngine() == DbEngine.POSTGRESQL){
    	  /* 
		 * @SF-SEVILLA DESACTIVAR LAS TRANSACCIONES En Postgresql 
		 * 02-may-2006 / antmaria
		 *  if (commit){
		 *  // DbUtil.executeStatement("END");
    	 *	// DbUtil.executeStatement("COMMIT");
    	 *  Statement stmt = DbConnection.getJdbcConnection().createStatement();
         *     stmt.executeUpdate("COMMIT");
         *     SQLWarning warn = stmt.getWarnings();
         *     if (warn != null){
         *   	  System.out.print( warn.getMessage());
         *         warn.printStackTrace();  
         *    }
         *     stmt.close();
         *   }else{
         *     DbUtil.executeStatement("ROLLBACK");
         *   }
		 */
      }
      else
      {
          if(jdbcConn.getAutoCommit())
          {
              throw new IeciTdException(DbError.EC_NOT_IN_TRANS, DbError.EM_NOT_IN_TRANS);
                
          }
    	  if(commit)
              jdbcConn.commit();
          else
              jdbcConn.rollback();
    	  jdbcConn.setAutoCommit(true);
      }  
        
      

   }

   public static void ensureEndTransaction(Exception exc)
                      throws Exception
   {

      Connection jdbcConn = (Connection)m_tJdbc.get();

      try
      {

          if(jdbcConn != null)
          {

              if(!jdbcConn.getAutoCommit())
                  endTransaction(false);

          }
          throw exc;

      }
      catch(Exception e)
      {

          throw exc;

      }

   }

   public static void ensureClose(Exception exc)
                      throws Exception
   {

      Connection jdbcConn = (Connection)m_tJdbc.get();
      

      try
      {

         close();        
        
         throw exc;

      }
      catch(Exception e)
      {

         throw exc;

      }

   }

   public static Connection getJdbcConnection()
                            throws Exception
   {

      Connection jdbcConn = (Connection)m_tJdbc.get();

      if(jdbcConn == null)
      {

          throw new IeciTdException(DbError.EC_NO_EXIST_CONN,
                                    DbError.EM_NO_EXIST_CONN);
            
      }

      return jdbcConn;

   }

    /**
     * Rubene
     *
     * @return int
     *
     * @throws Exception DOCUMENT ME!
     * @throws IeciTdException DOCUMENT ME!
     */
   private static int getConnectionEngine()
                     throws Exception
   {

      Connection jdbcConn = (Connection)m_tJdbc.get();

      if(jdbcConn == null)
      {

          throw new IeciTdException(DbError.EC_NO_EXIST_CONN,
                                    DbError.EM_NO_EXIST_CONN);
            
      }

      String dbVendor = jdbcConn.getMetaData().getDatabaseProductName();

      return determineDBVendor(dbVendor);

   }

    /**
     * DOCUMENT ME!
     *
     * @param dbVendor
     *
     * @return int
     *
     * @throws Exception DOCUMENT ME!
     * @throws IeciTdException DOCUMENT ME!
     */
    private static int determineDBVendor(String dbVendor)
                                  throws Exception
    {

        if(dbVendor.indexOf(DbEngine.SQLSERVER_STR) != -1)
            return DbEngine.SQLSERVER;
        else if(dbVendor.indexOf(DbEngine.ORACLE_STR) != -1)
            return DbEngine.ORACLE;
        else if(dbVendor.indexOf(DbEngine.MYSQL_STR) != -1)
            return DbEngine.MYSQL;
        /* 
		 * @SF-SEVILLA ADICION para preguntar por PostgreSQL
		 * 02-may-2006 / antmaria
		 */
        else if(dbVendor.indexOf(DbEngine.POSTGRESQL_STR) != -1)
            return DbEngine.POSTGRESQL;
        // FIN ADICION
        
        /*
         * Modificaciones para preguntar por DB2
         * 05-feb-2009 / SLuna
         * Inicio modificaciones
         */
        else if(dbVendor.indexOf(DbEngine.DB2_STR) != -1)
        	return DbEngine.DB2;
        /*
         * Fin modificaciones SLuna        
         */         
        
        throw new IeciTdException(DbError.EC_INVALID_ENGINE,
                                  DbError.EM_INVALID_ENGINE);

    }
    
   public static String getConnectionEngineVersion()
                         throws Exception
   {

      Connection jdbcConn = (Connection)m_tJdbc.get();
      String     version;

      if(jdbcConn == null)
      {

         throw new IeciTdException(DbError.EC_NO_EXIST_CONN,
                                   DbError.EM_NO_EXIST_CONN);

      }

      version = jdbcConn.getMetaData().getDatabaseProductVersion();

      return version;

   }

    private static boolean existConnnection()
                                     throws Exception
    {

        boolean    existConnection = false;
        Connection jdbcConn        = (Connection)m_tJdbc.get();

        if(jdbcConn != null)
            existConnection = true;

        return existConnection;

    }

    private static Connection openConnection(String drvClsName, String url,
                                            String user, String pwd)
                                     throws Exception
    {

        Class.forName(drvClsName);

        Connection   jdbcConn =  drvMgrGetConnection(url, user, pwd);
        SQLWarning   warning  =  jdbcConn.getWarnings();
        
        DbUtil.manipulateWarning(warning);
        
        return jdbcConn;

    }

    private static Connection openConnection(String ctxName)
                                      throws Exception
    {
        DataSource   ds       =  DbDataSourceMgr.getInstance().getDataSource(ctxName);
        Connection   jdbcConn =  ds.getConnection(); 
        SQLWarning   warning  =  jdbcConn.getWarnings();
        
        DbUtil.manipulateWarning(warning);
        
        return jdbcConn;

    }

    private static Connection openConnection(String ctxName, String user,
                                             String pwd)
                                      throws Exception
    {

        Context      ctx;
        DataSource   ds;
        Connection   jdbcConn =  null;
        SQLWarning   warning  =  null;
        
        ctx       =  new InitialContext();
        ds        =  (DataSource)ctx.lookup(ctxName);
        jdbcConn  =  ds.getConnection(user, pwd);
        warning   =  jdbcConn.getWarnings();
        
        DbUtil.manipulateWarning(warning);
        
        return jdbcConn;

    }

    private static Connection drvMgrGetConnection(String url, String user,
                                                  String pwd)
                                           throws Exception
    {

        String       sqlState;
        Connection   jdbcConn =  null;
        SQLWarning   warning  =  null;

        try
        {

            jdbcConn =  DriverManager.getConnection(url, user, pwd);
            warning  =  jdbcConn.getWarnings();
            
            DbUtil.manipulateWarning(warning);

        }
         catch(SQLException e)
        {

            sqlState = e.getSQLState();

            if(sqlState.equals("28000"))
            {

                throw new IeciTdException(DbError.EC_INVALID_AUTH_SPEC,
                                          DbError.EM_INVALID_AUTH_SPEC, e);
                
            }
            else
                throw e;

        }

        return jdbcConn;

    }
}
