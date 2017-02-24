/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

//
// FileName: BBDDUtils.java
//
package com.ieci.tecdoc.common.utils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

import javax.naming.NamingException;

import net.sf.hibernate.HibernateException;

import org.apache.log4j.Logger;

import com.ieci.tecdoc.common.isicres.AxSf;
import com.ieci.tecdoc.common.isicres.AxSfIn;
import com.ieci.tecdoc.common.isicres.AxSfOut;
import com.ieci.tecdoc.utils.HibernateUtil;

/**
 * @author lmvicente
 * @version
 * @since
 * @creationDate 05-abr-2004
 */

public class BBDDUtilsStatic {

	/***************************************************************************
	 * Attributes
	 **************************************************************************/

	private static final Logger log = Logger.getLogger(BBDDUtilsStatic.class);

	// Declaraci�n de tama�os de campos de BBDD que se utilizan para truncar en caso de que se
	// exceda su tama�o. Se han a�adido estas constantes para evitar llamar al m�todo getTableColumnSize
	// que sobrecarga mucho la BBDD y hacerlo s�lo si es estrictamente necesario
	public static final int SCR_MODIFREG_USR_FIELD_LENGTH = 32;
	public static final int SCR_DISTREGSTATE_USERNAME_FIELD_LENGTH = 32;

	/***************************************************************************
	 * Constructors
	 **************************************************************************/

	/***************************************************************************
	 * Public methods
	 **************************************************************************/

	public static Connection getConnection(String entidad)
			throws NamingException, SQLException {
	    HibernateUtil hibernateUtil = new HibernateUtil();
		try {
			return hibernateUtil.currentSession(entidad).connection();
		} catch (HibernateException e) {
			log.error("No se puede obtener una conexi�n a BBDD.", e);
			return null;
		}
	}

	public static void close(Statement stat) {
		if (stat != null) {
			try {
				stat.close();
			} catch (SQLException e) {
				log.error("Error cerrando un Statement.", e);
			}
		}
	}

	
	public static void close(String entidad) {
	    	HibernateUtil hibernateUtil = new HibernateUtil();
		hibernateUtil.closeSession(entidad);
	}
	
	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				log.error("Error cerrando un ResultSet.", e);
			}
		}
	}

	public static void close(Connection con) {
		// Se han detectado problemas cerrando la conexi�n.
		// En teoria si se cerrase, deber�a ser devuelta al pool o continuar
		// con la transacci�n, pero no es as�.

		 if (con != null) {
		 try {
		     con.close();
		 } catch (SQLException e) {
		     log.error("Error cerrando una conexion.", e);
		 }
		 }
	}

	public static AxSf getTableSchemaFromDatabase(String index, String entidad)
			throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ResultSetMetaData rsmt = null;

		AxSf auxAxSF = null;
		try {
			if (Repository.getInstance(entidad).isInBook(index).equals(
					Boolean.TRUE)) {
				auxAxSF = new AxSfIn();
			} else {
				auxAxSF = new AxSfOut();
			}
		} catch (Exception e1) {
			log.error("Impossible to determine if a book [" + index
					+ "] is an in book or an out book.", e1);
			auxAxSF = new AxSf();
		}

		try {
			con = BBDDUtilsStatic.getConnection(entidad);
			ps = con.prepareStatement("select * from A" + index
					+ "SF where 1 = 0");
			rs = ps.executeQuery();
			rsmt = rs.getMetaData();
			String name = null;
			String className = null;
			for (int i = 1; i <= rsmt.getColumnCount(); i++) {
				name = rsmt.getColumnName(i).toLowerCase();
				auxAxSF.addAttributeName(name);
				className = rsmt.getColumnClassName(i);
				if (className.equals(Timestamp.class.getName())) {
					auxAxSF.addAttributeClass(name, Date.class.getName());
				} else {
					auxAxSF.addAttributeClass(name, className);
				}
				// if (rsmt.isNullable(i) == 1) {
				// auxAxSF.addAttributeNullable(name, Boolean.TRUE);
				// } else {
				// auxAxSF.addAttributeNullable(name, Boolean.FALSE);
				// }
				auxAxSF.addAttributeSQLType(name, new Integer(rsmt
						.getColumnType(i)));
				// auxAxSF.addAttributeSQLName(name, rsmt.getColumnTypeName(i));
				// auxAxSF.addAttributeSQLScale(name, new
				// Integer(rsmt.getScale(i)));
				auxAxSF.addPrecision(name, rsmt.getPrecision(i));

				// if (log.isDebugEnabled()) {
				// log.debug("Name [" + name + "] SQLType [" +
				// rsmt.getColumnTypeName(i) + "] Scale ["
				// + rsmt.getScale(i) + "] Precision ["+rsmt.getPrecision(i)+"]
				// ["+rsmt.getColumnDisplaySize(i)+"]");
				// }
			}
		} catch (Exception e) {
			log
					.error("Impossible to load the schema for [A" + index
							+ "SF]", e);
			throw new SQLException(e.getMessage());
		} finally {
		    BBDDUtilsStatic.close(rs);
		    BBDDUtilsStatic.close(ps);
		    BBDDUtilsStatic.close(con);
		}

		return auxAxSF;
	}

	public static AxSf getTableSchemaFromDatabaseWithSQLName(String index,
			String entidad) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ResultSetMetaData rsmt = null;

		AxSf auxAxSF = null;
		try {
			if (Repository.getInstance(entidad).isInBook(index).equals(
					Boolean.TRUE)) {
				auxAxSF = new AxSfIn();
			} else {
				auxAxSF = new AxSfOut();
			}
		} catch (Exception e1) {
			log.error("Impossible to determine if a book [" + index
					+ "] is an in book or an out book.", e1);
			auxAxSF = new AxSf();
		}

		try {
			con = BBDDUtilsStatic.getConnection(entidad);
			ps = con.prepareStatement("select * from A" + index
					+ "SF where 1 = 0");
			rs = ps.executeQuery();
			rsmt = rs.getMetaData();
			String name = null;
			String className = null;
			for (int i = 1; i <= rsmt.getColumnCount(); i++) {
				name = rsmt.getColumnName(i).toLowerCase();
				auxAxSF.addAttributeName(name);
				className = rsmt.getColumnClassName(i);
				if (className.equals(Timestamp.class.getName())) {
					auxAxSF.addAttributeClass(name, Date.class.getName());
				} else {
					auxAxSF.addAttributeClass(name, className);
				}
				// if (rsmt.isNullable(i) == 1) {
				// auxAxSF.addAttributeNullable(name, Boolean.TRUE);
				// } else {
				// auxAxSF.addAttributeNullable(name, Boolean.FALSE);
				// }
				auxAxSF.addAttributeSQLType(name, new Integer(rsmt
						.getColumnType(i)));
				auxAxSF.getAttributesSQLNames().put(name,
						rsmt.getColumnTypeName(i));
				auxAxSF.addAttributeSQLScale(name,
						new Integer(rsmt.getScale(i)));

				// if (log.isDebugEnabled()) {
				// log.debug("Name [" + name + "] SQLType [" +
				// rsmt.getColumnTypeName(i) + "] Scale ["
				// + rsmt.getScale(i) + "] Precision
				// ["+rsmt.getPrecision(i)+"]");
				// }

				auxAxSF.addAttributeSQLScale(name,
						new Integer(rsmt.getScale(i)));
			}
		} catch (Exception e) {
			log
					.error("Impossible to load the schema for [A" + index
							+ "SF]", e);
			throw new SQLException(e.getMessage());
		} finally {
		    BBDDUtilsStatic.close(rs);
		    BBDDUtilsStatic.close(ps);
		    BBDDUtilsStatic.close(con);
		}

		return auxAxSF;
	}

	// SLuna-2009-01-09-Inicio
	// Gabriel Saiz - 13/01/2009
	/**
	 * M�todo que devuelve el tama�o de una columna de una tabla de la base de
	 * datos
	 * 
	 * @param tableName
	 *            Nombre de la tabla
	 * @param columnName
	 *            Nombre de la columna
	 * @param entidad
	 *            Entidad
	 * @return Integer Tama�o de la columna
	 * @throws SQLException
	 *             Error de SQL
	 */
	public static Integer getTableColumnSize(String tableName,
			String columnName, String entidad) throws SQLException {

		Integer result = null;
		Connection con = null;
		ResultSet resultSet = null;

		if (tableName != null) {
			try {

				con = BBDDUtilsStatic.getConnection(entidad);
				DatabaseMetaData metadata = con.getMetaData();
				String tableNameAux = tableName.toLowerCase();
				resultSet = metadata.getColumns(null, null,
						tableName, null);

				while (resultSet.next()) {

					String name = resultSet.getString("COLUMN_NAME");
					// Si la columna es la que buscamos (independientemente de
					// mayusculas o minusculas) obtenemos su tama�o
					if (name.equalsIgnoreCase(columnName)) {
						int size = resultSet.getInt("COLUMN_SIZE");
						result = new Integer(size);
						break;
					}

				}
				if (result == null) {
					resultSet = metadata.getColumns(null, null, tableNameAux,
							null);
					while (resultSet.next()) {

						String name = resultSet.getString("COLUMN_NAME");
						// Si la columna es la que buscamos (independientemente
						// de
						// mayusculas o minusculas) obtenemos su tama�o
						if (name.equalsIgnoreCase(columnName)) {
							int size = resultSet.getInt("COLUMN_SIZE");
							result = new Integer(size);
							break;
						}

					}
				}

			} catch (Exception e) {

				log.error("Impossible to get column size for [" + columnName
						+ "] from table [" + tableName + "]", e);

				throw new SQLException(e.getMessage());

			} finally {

			    BBDDUtilsStatic.close(resultSet);
			    BBDDUtilsStatic.close(con);

			}
		}
		return result;

	}

	/*
	 * public static Integer getTableColumnSize(String tableName, String
	 * columnName, String entidad) throws SQLException {
	 * 
	 * Integer result = null; Connection con = null;
	 * 
	 * if (tableName != null) { try {
	 * 
	 * con = BBDDUtils.getConnection(entidad); DatabaseMetaData metadata =
	 * con.getMetaData();
	 *  // Obtenemos todas las tablas y buscamos la que queremos //
	 * independientemente de si es mayuscula o minuscula ResultSet
	 * resultSetTable = metadata.getTables(null, null, null, null); String
	 * nameTable = null; while (resultSetTable.next()) { String name =
	 * resultSetTable.getString("TABLE_NAME"); if
	 * (tableName.equalsIgnoreCase(name)) { nameTable = name; break; } } //
	 * Buscamos las columnas de la tabla que queremos ResultSet resultSet =
	 * metadata.getColumns(null, null, nameTable, null);
	 * 
	 * while (resultSet.next()) {
	 * 
	 * String name = resultSet.getString("COLUMN_NAME"); // Si la columna es la
	 * que buscamos (independientemente de // mayusculas o minusculas) obtenemos
	 * su tama�o if (name.equalsIgnoreCase(columnName)) { int size =
	 * resultSet.getInt("COLUMN_SIZE"); result = new Integer(size); break; }
	 *  }
	 *  } catch (Exception e) {
	 * 
	 * log.error("Impossible to get column size for [" + columnName + "] from
	 * table [" + tableName + "]", e);
	 * 
	 * throw new SQLException(e.getMessage());
	 *  } finally {
	 * 
	 * BBDDUtils.close(con); } }
	 * 
	 * return result;
	 *  }
	 */
	// SLuna-2009-01-09-Fin
	public static java.sql.Date getDate(java.util.Date date) {
		if (date != null) {
			return new java.sql.Date(date.getTime());
		} else {
			return null;
		}
	}

	public static java.sql.Date getDate(Timestamp date) {
		if (date != null) {
			return new java.sql.Date(date.getTime());
		} else {
			return null;
		}
	}

	public static java.util.Date getDateFromTimestamp(Timestamp date) {
		if (date != null) {
			return new java.util.Date(date.getTime());
		} else {
			return null;
		}
	}

	public static Timestamp getTimestamp(java.util.Date date) {
		if (date != null) {
			return new Timestamp(date.getTime());
		} else {
			return null;
		}
	}

	/***************************************************************************
	 * Protected methods
	 **************************************************************************/

	/***************************************************************************
	 * Private methods
	 **************************************************************************/

	/***************************************************************************
	 * Inner classes
	 **************************************************************************/

	/***************************************************************************
	 * Test brench
	 **************************************************************************/

}