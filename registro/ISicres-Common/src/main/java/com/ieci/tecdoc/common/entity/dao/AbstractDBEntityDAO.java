package com.ieci.tecdoc.common.entity.dao;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipInputStream;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.ieci.tecdoc.common.extension.StringClobType;
import com.ieci.tecdoc.common.invesdoc.Idocvtblctlg;
import com.ieci.tecdoc.common.invesicres.ScrAddrtel;
import com.ieci.tecdoc.common.invesicres.ScrReport;
import com.ieci.tecdoc.common.isicres.AxSf;
import com.ieci.tecdoc.common.isicres.AxSfIn;
import com.ieci.tecdoc.common.isicres.AxSfOut;
import com.ieci.tecdoc.common.isicres.AxSfQuery;
import com.ieci.tecdoc.common.isicres.AxSfQueryField;
import com.ieci.tecdoc.common.isicres.Keys;
import com.ieci.tecdoc.common.utils.BBDDUtils;
import com.ieci.tecdoc.common.utils.ScrRegisterInter;

/**
 * @author LMVICENTE
 * @creationDate 28-may-2004 10:13:06
 * @version
 * @since
 */
public abstract class AbstractDBEntityDAO extends DBEntityDAOKeys implements
		DBEntityDAO {

	/***************************************************************************
	 * Attributes
	 **************************************************************************/

	private static final Logger log = Logger
			.getLogger(AbstractDBEntityDAO.class);

	protected static final String IGUAL = "=";
	protected static final String MAYOR = ">";
	protected static final String MENOR_IGUAL = "<=";
	protected static final String DISTINTO = "!=";
	protected static final String ENTRE = "..";
	protected static final String QUERY_OR = "|";
	protected static final String MENOR = "<";
	protected static final String MAYOR_IGUAL = ">=";

	protected static final String MIN_TIME = " 00:00:00";
	protected static final String MAX_TIME = " 23:59:59";

	protected static final String MIN_TIME_QUOTE = " 00:00:00'";
	protected static final String MAX_TIME_QUOTE = " 23:59:59'";

	protected static final String UPPER = "UPPER";
	protected static final String REPLACE = "TRANSLATE";

	private static final String TILDES = "���������������";
	private static final String NOTILDES = "AAAEEEIIIOOOUUU";
	/***************************************************************************
	 * Constructors
	 **************************************************************************/

	public AbstractDBEntityDAO() {
	}

	/***************************************************************************
	 * Public methods
	 **************************************************************************/

	/*
	 * (non-Javadoc)
	 *
	 * @see com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getDataBaseType()
	 */
	public abstract String getDataBaseType();

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getVersion(java.lang.String
	 * )
	 */
	public abstract String getVersion(String entidad);

	/*
	 * (non-Javadoc)
	 *
	 * @see com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getLikeCharacter()
	 */
	public abstract String getLikeCharacter();

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getNextIdForInter(java.
	 * lang.Integer, java.lang.String)
	 */
	public abstract int getNextIdForInter(Integer userId, String entidad)
			throws SQLException;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#deleteIdsGenerationTable
	 * (Integer, String)
	 */
	public abstract void deleteIdsGenerationTable(Integer userId, String entidad);

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getReportInsert(String,
	 * Integer, String, String)
	 */
	public String getReportInsert(String tableName, Integer bookId,
			String fieldList, String where) {
		return "INSERT INTO " + tableName + " SELECT " + bookId + ","
				+ fieldList + " FROM A" + bookId + "SF " + where;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getReportInsert(String,
	 * Integer, String)
	 */
	public String getReportInsert(String tableName, Integer bookId,
			String fieldList) {
		return "INSERT INTO " + tableName + " SELECT " + bookId + ","
				+ fieldList + " FROM A" + bookId + "SF ";
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getAditionFields(int)
	 */
	public String getAditionFields(int bookType) {
		String result = null;
		if (bookType == 1) {
			result = ",FLD5_TEXT,FLD7_TEXT,FLD8_TEXT,FLD13_TEXT,FLD16_TEXT";
		} else {
			result = ",FLD5_TEXT,FLD7_TEXT,FLD8_TEXT,FLD12_TEXT";
		}
		return result.toString();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getRelationsTupla(String,
	 * int, String)
	 */
	public Object[][] getRelationsTupla(String tableName, int opcion,
			String entidad) throws SQLException {
		Statement statement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		String selectSentence = null;
		Object[][] result = null;
		try {
			if (opcion == 4 || opcion == 6) {
				selectSentence = "SELECT FLD4, FLD8  FROM " + tableName
						+ " ORDER BY FLD4, FLD8";
			} else {
				selectSentence = "SELECT FLD4, FLD7  FROM " + tableName
						+ " ORDER BY FLD4, FLD7";

			}
			connection = bbddUtils.getConnection(entidad);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectSentence);

			int size = getTableOrViewSize(tableName, entidad);
			result = new Object[size][2];
			int count = 0;
			while (resultSet.next()) {
				result[count][0] = resultSet.getDate(1);
				if (resultSet.getString(2) != null) {
					result[count][1] = new Integer(resultSet.getString(2));
				} else {
					result[count][1] = null;
				}
				count++;
			}

		} catch (SQLException e) {
			log.warn("Error ejecutando [" + selectSentence + "]", e);
			throw e;
		} catch (Throwable e) {
			log.warn("Error ejecutando [" + selectSentence + "]", e);
			throw new SQLException("Error ejecutando [" + selectSentence + "]");
		} finally {
			bbddUtils.close(statement);
			bbddUtils.close(resultSet);
			bbddUtils.close(connection);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getNewNumRelations(int,
	 * int, int, int, int, String)
	 */
	public int getNewNumRelations(int typebook, int typerel, int idofic,
			int idunit, int relyear, String entidad) throws SQLException {
		Statement statement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		int result = 0;
		StringBuffer query = new StringBuffer();
		try {
			query.append("SELECT MAX(NREL)  FROM SCR_RELATIONS ");
			query.append(" scr WHERE scr.typebook=" + typebook
					+ " AND scr.typerel=" + typerel + " AND scr.idofic="
					+ idofic);
			query.append(" AND scr.idunit=" + idunit + " AND scr.relyear="
					+ relyear);

			connection = bbddUtils.getConnection(entidad);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query.toString());

			if (resultSet.next()) {
				result = resultSet.getInt(1);
			}

		} catch (SQLException e) {
			log.warn("Error ejecutando [" + query.toString() + "]", e);
			throw e;
		} catch (Throwable e) {
			log.warn("Error ejecutando [" + query.toString() + "]", e);
			throw new SQLException("Error ejecutando [" + query.toString()
					+ "]");
		} finally {
			bbddUtils.close(statement);
			bbddUtils.close(resultSet);
			bbddUtils.close(connection);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getPrivOrgs(int,
	 * String)
	 */
	public List getPrivOrgs(int idofic, String entidad) throws SQLException {
		Statement statement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		List privOrgs = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		StringBuffer query = new StringBuffer();
		try {
			query.append("SELECT IDORGS FROM SCR_PRIVORGS WHERE IDOFIC != "
					+ idofic);
			query
					.append(" AND IDORGS NOT IN (SELECT IDORGS FROM SCR_PRIVORGS WHERE IDOFIC = "
							+ idofic + ")");

			connection = bbddUtils.getConnection(entidad);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query.toString());

			privOrgs = new ArrayList();
			while (resultSet.next()) {
				privOrgs.add(new Integer(resultSet.getInt(1)));
			}

		} catch (SQLException e) {
			log.warn("Error ejecutando [" + query.toString() + "]", e);
			throw e;
		} catch (Throwable e) {
			log.warn("Error ejecutando [" + query.toString() + "]", e);
			throw new SQLException("Error ejecutando [" + query.toString()
					+ "]");
		} finally {
			bbddUtils.close(statement);
			bbddUtils.close(resultSet);
			bbddUtils.close(connection);
		}
		return privOrgs;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getOtherOffice(int,
	 * String)
	 */
	public int getOtherOffice(int userId, String entidad) throws SQLException {
		Statement statement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		int result = 0;
		StringBuffer query = new StringBuffer();
		try {
			query.append("SELECT COUNT(*) FROM SCR_OFIC WHERE ");
			query.append("ID IN (SELECT IDOFIC FROM SCR_USROFIC WHERE IDUSER="
					+ userId + ")");

			connection = bbddUtils.getConnection(entidad);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query.toString());

			if (resultSet.next()) {
				result = resultSet.getInt(1);
			}

		} catch (SQLException e) {
			log.warn("Error ejecutando [" + query.toString() + "]", e);
			throw e;
		} catch (Throwable e) {
			log.warn("Error ejecutando [" + query.toString() + "]", e);
			throw new SQLException("Error ejecutando [" + query.toString()
					+ "]");
		} finally {
			bbddUtils.close(statement);
			bbddUtils.close(resultSet);
			bbddUtils.close(connection);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getSizeIncompletRegister
	 * (Integer, Integer, String)
	 */
	public int getSizeIncompletRegister(Integer bookId, Integer oficId,
			String entidad) throws SQLException {
		Statement statement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		int result = 0;
		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT COUNT(*) FROM A"
					+ bookId.intValue() + "SF WHERE FLD6=1 AND FLD5=" + oficId);

			if (resultSet.next()) {
				result = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			log.warn("Error ejecutando [SELECT COUNT(*) FROM A"
					+ bookId.intValue() + "SF WHERE FLD6=1 AND FLD5=" + oficId
					+ "]", e);
			throw e;
		} catch (Throwable e) {
			log.warn("Error ejecutando [SELECT COUNT(*) FROM A"
					+ bookId.intValue() + "SF WHERE FLD6=1 AND FLD5=" + oficId
					+ "]", e);
			throw new SQLException("Error ejecutando [SELECT COUNT(*) FROM A"
					+ bookId.intValue() + "SF WHERE FLD6=1 AND FLD5=" + oficId
					+ "]");
		} finally {
			bbddUtils.close(statement);
			bbddUtils.close(resultSet);
			bbddUtils.close(connection);
		}

		return result;

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getTableOrViewSize(String,
	 * String)
	 */
	public int getTableOrViewSize(String tableName, String entidad)
			throws SQLException {
		Statement statement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		int result = 0;
		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT COUNT(*) FROM "
					+ tableName);

			if (resultSet.next()) {
				result = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			log.warn("Error ejecutando [SELECT COUNT(*) FROM " + tableName
					+ "]", e);
			throw e;
		} catch (Throwable e) {
			log.warn("Error ejecutando [SELECT COUNT(*) FROM " + tableName
					+ "]", e);
			throw new SQLException("Error ejecutando [SELECT COUNT(*) FROM "
					+ tableName + "]");
		} finally {
			bbddUtils.close(statement);
			bbddUtils.close(resultSet);
			bbddUtils.close(connection);
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#insertTableOrView(String,
	 * String)
	 */
	public void insertTableOrView(String sentence, String entidad)
			throws SQLException {
		Statement statement = null;
		Connection connection = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection.createStatement();
			statement.executeUpdate(sentence);
		} catch (SQLException e) {
			log.warn("Error ejecutando [" + sentence + "]", e);
			throw e;
		} catch (Throwable e) {
			log.warn("Error ejecutando [" + sentence + "]", e);
			throw new SQLException("Error ejecutando [" + sentence + "]");
		} finally {
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#createTableOrView(String,
	 * String)
	 */
	public void createTableOrView(String sentence, String entidad)
			throws SQLException {
		Statement statement = null;
		Connection connection = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection.createStatement();
			statement.executeUpdate(sentence);
		} catch (SQLException e) {
			log.warn("Error ejecutando [" + sentence + "]", e);
			throw e;
		} catch (Throwable e) {
			log.warn("Error ejecutando [" + sentence + "]", e);
			throw new SQLException("Error ejecutando [" + sentence + "]");
		} finally {
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#insertTableOrView(String,
	 * AxSf, AxSfQuery, String)
	 */
	public void insertTableOrView(String insert, AxSf axsf,
			AxSfQuery axsfQuery, String entidad) throws SQLException {
		PreparedStatement pstatement = null;
		Statement statement = null;
		Connection connection = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		try {
			connection = bbddUtils.getConnection(entidad);

			pstatement = connection.prepareStatement(insert);
			assignAxSFPreparedStatement(axsfQuery, axsf, pstatement);
			pstatement.executeUpdate();
		} catch (SQLException e) {
			log.warn("Error ejecutando [" + insert + "]", e);
			throw e;
		} catch (Throwable e) {
			log.warn("Error ejecutando [" + insert + "]", e);
			throw new SQLException("Error ejecutando [" + insert + "]");
		} finally {
			bbddUtils.close(pstatement);
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#createTableOrView(String,
	 * String, AxSf, AxSfQuery, String)
	 */
	public void createTableOrView(String create, String insert, AxSf axsf,
			AxSfQuery axsfQuery, String entidad) throws SQLException {
		PreparedStatement pstatement = null;
		Statement statement = null;
		Connection connection = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection.createStatement();
			statement.executeUpdate(create);

			pstatement = connection.prepareStatement(insert);
			assignAxSFPreparedStatement(axsfQuery, axsf, pstatement);
			pstatement.executeUpdate();
		} catch (SQLException e) {
			log.warn("Error ejecutando [" + create + "] [" + insert + "]", e);
			throw e;
		} catch (Throwable e) {
			log.warn("Error ejecutando [" + create + "] [" + insert + "]", e);
			throw new SQLException("Error ejecutando [" + create + "] ["
					+ insert + "]");
		} finally {
			bbddUtils.close(pstatement);
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#createTableOrView(String,
	 * AxSf, AxSfQuery, String)
	 */
	public void createTableOrView(String create, AxSf axsf,
			AxSfQuery axsfQuery, String entidad) throws SQLException {
		PreparedStatement pstatement = null;
		Statement statement = null;
		Connection connection = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection.createStatement();
			statement.executeUpdate(create);

		} catch (SQLException e) {
			log.warn("Error ejecutando [" + create + "] ", e);
			throw e;
		} catch (Throwable e) {
			log.warn("Error ejecutando [" + create + "] ", e);
			throw new SQLException("Error ejecutando [" + create + "] ");
		} finally {
			bbddUtils.close(pstatement);
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#createTableOrView(String,
	 * Date, Date, int, String)
	 */
	public void createTableOrView(String insert, Date beginDate, Date endDate,
			int unit, String entidad) throws SQLException {
		PreparedStatement pstatement = null;
		Connection connection = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		try {
			connection = bbddUtils.getConnection(entidad);
			pstatement = connection.prepareStatement(insert);
			pstatement.setTimestamp(1, bbddUtils.getTimestamp(beginDate));
			pstatement.setTimestamp(2, bbddUtils.getTimestamp(endDate));
			if (unit != -1) {
				pstatement.setInt(3, unit);
			}
			pstatement.executeUpdate();
		} catch (SQLException e) {
			log.warn("Error ejecutando [" + insert + "]", e);
			throw e;
		} catch (Throwable e) {
			log.warn("Error ejecutando [" + insert + "]", e);
			throw new SQLException("Error ejecutando [" + insert + "]");
		} finally {
			bbddUtils.close(pstatement);
			bbddUtils.close(connection);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#insertAudit(java.lang.Integer
	 * , java.lang.Object, java.lang.Object, java.lang.String)
	 */
	public void insertAudit(Integer id, Object oldValue, Object newValue,
			String entidad) throws SQLException {
		PreparedStatement statement = null;
		Connection connection = null;
		String query = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		try {
			connection = bbddUtils.getConnection(entidad);

			Object valueToInspect = oldValue;
			if (valueToInspect == null) {
				valueToInspect = newValue;
			}

			if (valueToInspect != null) {
				log.info("AUDITANDO CLASE "
						+ valueToInspect.getClass().getName());
				if (valueToInspect instanceof String) {
					query = "INSERT INTO SCR_VALSTR(ID,VALUE,OLDVALUE) VALUES (?,?,?)";
					statement = connection.prepareStatement(query);
					statement.setInt(1, id.intValue());
					statement.setString(2, (String) newValue);
					statement.setString(3, (String) oldValue);
				}
				if (valueToInspect instanceof Date) {
					query = "INSERT INTO SCR_VALDATE(ID,VALUE,OLDVALUE) VALUES (?,?,?)";
					statement = connection.prepareStatement(query);
					statement.setInt(1, id.intValue());
					statement.setTimestamp(2, bbddUtils
							.getTimestamp((Date) newValue));
					statement.setTimestamp(3, bbddUtils
							.getTimestamp((Date) oldValue));
				}
				if (valueToInspect instanceof Timestamp) {
					query = "INSERT INTO SCR_VALDATE(ID,VALUE,OLDVALUE) VALUES (?,?,?)";
					statement = connection.prepareStatement(query);
					statement.setInt(1, id.intValue());
					statement.setTimestamp(2, (Timestamp) newValue);
					statement.setTimestamp(3, (Timestamp) oldValue);
				}
				if (valueToInspect instanceof Integer) {
					query = "INSERT INTO SCR_VALNUM(ID,VALUE,OLDVALUE) VALUES (?,?,?)";
					statement = connection.prepareStatement(query);
					statement.setInt(1, id.intValue());
					if (newValue != null) {
						statement.setInt(2, Integer.parseInt(newValue
								.toString()));
					} else {
						statement.setInt(2, Types.NULL);
					}
					if (oldValue != null) {
						statement.setInt(3, Integer.parseInt(oldValue
								.toString()));
					} else {
						statement.setInt(3, Types.NULL);
					}
				}
				if (valueToInspect instanceof Long) {
					query = "INSERT INTO SCR_VALNUM(ID,VALUE,OLDVALUE) VALUES (?,?,?)";
					statement = connection.prepareStatement(query);
					statement.setInt(1, id.intValue());
					if (newValue != null) {
						statement.setLong(2, Long
								.parseLong(newValue.toString()));
					} else {
						statement.setInt(2, Types.NULL);
					}
					if (oldValue != null) {
						statement.setLong(3, Long
								.parseLong(oldValue.toString()));
					} else {
						statement.setInt(3, Types.NULL);
					}
				}

				if (valueToInspect instanceof BigDecimal) {
					query = "INSERT INTO SCR_VALNUM(ID,VALUE,OLDVALUE) VALUES (?,?,?)";
					statement = connection.prepareStatement(query);
					statement.setInt(1, id.intValue());
					if (newValue != null) {
						statement.setInt(2, Integer.parseInt(newValue
								.toString()));
					} else {
						statement.setInt(2, Types.NULL);
					}
					if (oldValue != null) {
						statement.setInt(3, Integer.parseInt(oldValue
								.toString()));
					} else {
						statement.setInt(3, Types.NULL);
					}
				}
				statement.executeUpdate();
			} else {
				query = "INSERT INTO SCR_VALSTR(ID,VALUE,OLDVALUE) VALUES (?,?,?)";
				statement = connection.prepareStatement(query);
				statement.setInt(1, id.intValue());
				statement.setString(2, null);
				statement.setString(3, null);
			}
		} catch (SQLException e) {
			log.warn("Resulta imposible auditar [" + query + "]", e);
		} catch (Throwable e) {
			log.warn("Resulta imposible iauditar [" + query + "]", e);
		} finally {
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#createScrOficinaRow(int,
	 * int, int, java.lang.String)
	 */
	public int createScrOficinaRow(int year, int bookType, int ofic,
			String entidad) throws SQLException {
		PreparedStatement statement = null;
		Connection connection = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection.prepareStatement(INSERT_SCR_CNTOFICINA_OFIC);
			statement.setInt(1, year);
			statement.setInt(2, ofic);
			statement.setInt(3, bookType);

			statement.executeUpdate();
		} catch (SQLException e) {
			log.warn("Resulta imposible insertar scr_cntcentral ["
					+ INSERT_SCR_CNTOFICINA_OFIC + "]", e);
			throw e;
		} catch (Throwable e) {
			log.warn("Resulta imposible insertar scr_cntcentral ["
					+ INSERT_SCR_CNTOFICINA_OFIC + "]", e);
			throw new SQLException(e.getMessage());
		} finally {
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}

		return 1;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#insertScrRelations(int,
	 * int, int, int, int, int, java.util.Date, int, int, java.lang.String)
	 */
	public int insertScrRelations(int typebook, int typerel, int relyear,
			int relmonth, int relday, int idofic, Date reldate, int idunit,
			int nrel, String entidad) throws SQLException {
		PreparedStatement statement = null;
		Connection connection = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection.prepareStatement(INSERT_SCR_RELATIONS);
			statement.setInt(1, typebook);
			statement.setInt(2, typerel);
			statement.setInt(3, relyear);
			statement.setInt(4, relmonth);
			statement.setInt(5, relday);
			statement.setInt(6, idofic);
			statement.setDate(7, bbddUtils.getDate(reldate));
			statement.setInt(8, idunit);
			statement.setInt(9, nrel);

			statement.executeUpdate();
		} catch (SQLException e) {
			log.warn("Resulta imposible insertar scr_relations ["
					+ INSERT_SCR_RELATIONS + "]", e);
			throw e;
		} catch (Throwable e) {
			log.warn("Resulta imposible insertar scr_relations ["
					+ INSERT_SCR_RELATIONS + "]", e);
			throw new SQLException(e.getMessage());
		} finally {
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}

		return 1;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#deleteDistributeForUpdate
	 * (int, int, int, java.lang.String)
	 */
	public void deleteDistributeForUpdate(int idArch, int idFdr, int idOrg,
			String entidad) throws SQLException {
		PreparedStatement statement = null;
		Connection connection = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		String where = "FROM SCR_DISTREG WHERE ID_ARCH=? AND ID_FDR=? AND STATE=1 AND TYPE_ORIG=2 AND ID_ORIG=?";
		StringBuffer query = null;
		try {
			query = new StringBuffer();
			query.append("DELETE FROM SCR_PROCREG WHERE ID_DIST IN ");
			query.append("(SELECT ID ");
			query.append(where);
			query.append(")");
			connection = bbddUtils.getConnection(entidad);
			statement = connection.prepareStatement(query.toString());
			statement.setInt(1, idArch);
			statement.setInt(2, idFdr);
			statement.setInt(3, idOrg);
			statement.executeUpdate();
			bbddUtils.close(statement);

			query = new StringBuffer();
			query.append("DELETE FROM SCR_DISTREGSTATE WHERE ID_DIST IN ");
			query.append("(SELECT ID ");
			query.append(where);
			query.append(")");
			connection = bbddUtils.getConnection(entidad);
			statement = connection.prepareStatement(query.toString());
			statement.setInt(1, idArch);
			statement.setInt(2, idFdr);
			statement.setInt(3, idOrg);
			statement.executeUpdate();
			bbddUtils.close(statement);

			query = new StringBuffer();
			query.append("DELETE ");
			query.append(where);
			connection = bbddUtils.getConnection(entidad);
			statement = connection.prepareStatement(query.toString());
			statement.setInt(1, idArch);
			statement.setInt(2, idFdr);
			statement.setInt(3, idOrg);
			statement.executeUpdate();
			bbddUtils.close(statement);
		} catch (SQLException e) {
			log.warn("Resulta imposible deleteDistributeForUpdate [" + query
					+ "]", e);
		} catch (Throwable e) {
			log.warn("Resulta imposible deleteDistributeForUpdate [" + query
					+ "]", e);
		} finally {
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#deleteDistributeForUpdate
	 * (int, int, int, java.lang.String, int)
	 */
	public void deleteDistributeForUpdate(int idArch, int idFdr, int idOrg,
			String entidad, int state) throws SQLException {
		PreparedStatement statement = null;
		Connection connection = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		String where = "FROM SCR_DISTREG WHERE ID_ARCH=? AND ID_FDR=? AND STATE=? AND TYPE_ORIG=2 AND ID_ORIG=?";
		StringBuffer query = null;
		try {
			query = new StringBuffer();
			query.append("DELETE FROM SCR_PROCREG WHERE ID_DIST IN ");
			query.append("(SELECT ID ");
			query.append(where);
			query.append(")");
			connection = bbddUtils.getConnection(entidad);
			statement = connection.prepareStatement(query.toString());
			statement.setInt(1, idArch);
			statement.setInt(2, idFdr);
			statement.setInt(3, state);
			statement.setInt(4, idOrg);
			statement.executeUpdate();
			bbddUtils.close(statement);

			query = new StringBuffer();
			query.append("DELETE FROM SCR_DISTREGSTATE WHERE ID_DIST IN ");
			query.append("(SELECT ID ");
			query.append(where);
			query.append(")");
			connection = bbddUtils.getConnection(entidad);
			statement = connection.prepareStatement(query.toString());
			statement.setInt(1, idArch);
			statement.setInt(2, idFdr);
			statement.setInt(3, state);
			statement.setInt(4, idOrg);
			statement.executeUpdate();
			bbddUtils.close(statement);

			query = new StringBuffer();
			query.append("DELETE ");
			query.append(where);
			connection = bbddUtils.getConnection(entidad);
			statement = connection.prepareStatement(query.toString());
			statement.setInt(1, idArch);
			statement.setInt(2, idFdr);
			statement.setInt(3, state);
			statement.setInt(4, idOrg);
			statement.executeUpdate();
			bbddUtils.close(statement);
		} catch (SQLException e) {
			log.warn("Resulta imposible deleteDistributeForUpdate [" + query
					+ "]", e);
		} catch (Throwable e) {
			log.warn("Resulta imposible deleteDistributeForUpdate [" + query
					+ "]", e);
		} finally {
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#createScrCentralRow(int,
	 * int, java.lang.String)
	 */
	public int createScrCentralRow(int year, int bookType, String entidad)
			throws SQLException {
		PreparedStatement statement = null;
		Connection connection = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection.prepareStatement(INSERT_SCR_CNTCENTRAL);
			statement.setInt(1, year);
			statement.setInt(2, bookType);

			statement.executeUpdate();
		} catch (SQLException e) {
			log.warn("Resulta imposible insertar scr_cntcentral ["
					+ INSERT_SCR_CNTCENTRAL + "]", e);
			throw e;
		} catch (Throwable e) {
			log.warn("Resulta imposible insertar scr_cntcentral ["
					+ INSERT_SCR_CNTCENTRAL + "]", e);
			throw new SQLException(e.getMessage());
		} finally {
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}

		return 1;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.ieci.tecdoc.common.entity.dao.DBEntityDAO#lockScrDistReg(int,
	 * java.lang.String)
	 */
	public void lockScrDistReg(int id, String entidad) throws SQLException {
		PreparedStatement statement = null;
		Connection connection = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection.prepareStatement(LOCK_SCR_DISTREG);
			statement.setInt(1, id);

			statement.executeUpdate();
		} catch (SQLException e) {
			log.warn("Resulta imposible bloquear SCR_DISTREG ["
					+ LOCK_SCR_DISTREG + "]", e);
		} catch (Throwable e) {
			log.warn("Resulta imposible bloquear SCR_DISTREG ["
					+ LOCK_SCR_DISTREG + "]", e);
		} finally {
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.ieci.tecdoc.common.entity.dao.DBEntityDAO#lockScrCentral(int,
	 * java.lang.String)
	 */
	public void lockScrCentral(int year, String entidad) throws SQLException {
		PreparedStatement statement = null;
		Connection connection = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection.prepareStatement(LOCK_SCR_CNTCENTRAL);
			statement.setInt(1, year);

			statement.executeUpdate();
		} catch (SQLException e) {
			log.warn("Resulta imposible bloquear scr_cntcentral ["
					+ LOCK_SCR_CNTCENTRAL + "]", e);
		} catch (Throwable e) {
			log.warn("Resulta imposible bloquear scr_cntcentral ["
					+ LOCK_SCR_CNTCENTRAL + "]", e);
		} finally {
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.ieci.tecdoc.common.entity.dao.DBEntityDAO#lockScrOficina(int,
	 * java.lang.String)
	 */
	public void lockScrOficina(int year, String entidad) throws SQLException {
		PreparedStatement statement = null;
		Connection connection = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection.prepareStatement(LOCK_SCR_CNTOFICINA);
			statement.setInt(1, year);

			statement.executeUpdate();
		} catch (SQLException e) {
			log.warn("Resulta imposible bloquear scr_cntoficina ["
					+ LOCK_SCR_CNTCENTRAL + "]", e);
			throw e;
		} catch (Throwable e) {
			log.warn("Resulta imposible bloquear scr_cntoficina ["
					+ LOCK_SCR_CNTCENTRAL + "]", e);
			throw new SQLException(e.getMessage());
		} finally {
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.ieci.tecdoc.common.entity.dao.DBEntityDAO#lockScrRelations(int,
	 * int, int, java.lang.String)
	 */
	public void lockScrRelations(int typeBook, int typeRel, int idofic,
			String entidad) throws SQLException {
		PreparedStatement statement = null;
		Connection connection = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection.prepareStatement(SCR_LOCK_RELATIONS);
			statement.setInt(1, typeBook);
			statement.setInt(2, typeRel);
			statement.setInt(3, idofic);

			statement.executeUpdate();
			// log.info("======= > bloqueo de lockScrRelations " + " typebook: "
			// + typeBook + " typeRel: " + typeRel + " idofic: " + idofic);
		} catch (SQLException e) {
			log.warn("Resulta imposible bloquear scr_lockrelation ["
					+ SCR_LOCK_RELATIONS + "]", e);
			throw e;
		} catch (Throwable e) {
			log.warn("Resulta imposible bloquear scr_lockrelation ["
					+ SCR_LOCK_RELATIONS + "]", e);
			throw new SQLException(e.getMessage());
		} finally {
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#updateScrCntCentral(int,
	 * int, java.lang.String)
	 */
	public void updateScrCntCentral(int year, int bookType, String entidad)
			throws SQLException {
		PreparedStatement statement = null;
		Connection connection = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection.prepareStatement(UPDATE_SCR_CNTCENTRAL);
			statement.setInt(1, year);
			statement.setInt(2, bookType);

			statement.executeUpdate();
		} catch (SQLException e) {
			log.warn("Resulta imposible actualizar scr_cntcentral ["
					+ UPDATE_SCR_CNTCENTRAL + "]", e);
		} catch (Throwable e) {
			log.warn("Resulta imposible actualizar scr_cntcentral ["
					+ UPDATE_SCR_CNTCENTRAL + "]", e);
		} finally {
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#updateScrCntOficina(int,
	 * int, int, java.lang.String)
	 */
	public void updateScrCntOficina(int year, int bookType, int ofic,
			String entidad) throws SQLException {
		PreparedStatement statement = null;
		Connection connection = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection.prepareStatement(UPDATE_SCR_CNTOFICINA);
			statement.setInt(1, year);
			statement.setInt(2, bookType);
			statement.setInt(3, ofic);

			statement.executeUpdate();
		} catch (SQLException e) {
			log.warn("Resulta imposible actualizar scr_cntoficina ["
					+ UPDATE_SCR_CNTOFICINA + "]", e);
		} catch (Throwable e) {
			log.warn("Resulta imposible actualizar scr_cntoficina ["
					+ UPDATE_SCR_CNTOFICINA + "]", e);
		} finally {
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getNumRegFromScrCntCentral
	 * (int, int, java.lang.String)
	 */
	public int getNumRegFromScrCntCentral(int year, int bookType, String entidad)
			throws SQLException {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		int id = -1;

		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection
					.prepareStatement(SELECT_NUMREG_SCR_CNTCENTRAL);
			statement.setInt(1, year);
			statement.setInt(2, bookType);

			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				id = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			log.warn("Resulta imposible obtener el num_reg de scr_central ["
					+ SELECT_NUMREG_SCR_CNTCENTRAL + "]", e);
			throw e;
		} catch (Throwable e) {
			log.warn("Resulta imposible obtener el num_reg de scr_central ["
					+ SELECT_NUMREG_SCR_CNTCENTRAL + "]", e);
			throw new SQLException(e.getMessage());
		} finally {
			bbddUtils.close(resultSet);
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}

		return id;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.ieci.tecdoc.common.entity.dao.DBEntityDAO#deleteUserConfig(int,
	 * java.lang.String)
	 */
	public void deleteUserConfig(int userId, String entidad)
			throws SQLException {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection.prepareStatement(DELETE_USER_CONFIG);
			statement.setInt(1, userId);
			statement.executeUpdate();

		} catch (SQLException e) {
			log.warn("Resulta imposible eliminar los campos persistentes ["
					+ DELETE_USER_CONFIG + "]", e);
			throw e;
		} catch (Throwable e) {
			log.warn("Resulta imposible eliminar los campos persistentes ["
					+ DELETE_USER_CONFIG + "]", e);
			throw new SQLException(e.getMessage());
		} finally {
			bbddUtils.close(resultSet);
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getNumRegFromScrCntOficina
	 * (int, int, int, java.lang.String)
	 */
	public int getNumRegFromScrCntOficina(int year, int bookType, int ofic,
			String entidad) throws SQLException {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		int id = -1;

		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection
					.prepareStatement(SELECT_NUMREG_SCR_CNTOFICINA);
			statement.setInt(1, year);
			statement.setInt(2, bookType);
			statement.setInt(3, ofic);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				id = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			log.warn("Resulta imposible obtener el num_reg de scr_oficina ["
					+ SELECT_NUMREG_SCR_CNTOFICINA + "]", e);
			throw e;
		} catch (Throwable e) {
			log.warn("Resulta imposible obtener el num_reg de scr_oficina ["
					+ SELECT_NUMREG_SCR_CNTOFICINA + "]", e);
			throw new SQLException(e.getMessage());
		} finally {
			bbddUtils.close(resultSet);
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}

		return id;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getNextIdForRegister(java
	 * .lang.Integer, java.lang.String)
	 */
	public int getNextIdForRegister(Integer bookID, String entidad)
			throws SQLException {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		int id = -1;

		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection.prepareStatement(UPDATE_LOCK_NEXT_ID_3);
			statement.setInt(1, bookID.intValue());
			int affected = statement.executeUpdate();
			bbddUtils.close(statement);

			if (affected == 0) {
				statement = connection.prepareStatement(INSERT_NEXT_ID_3);
				statement.setInt(1, bookID.intValue());
				affected = statement.executeUpdate();
				bbddUtils.close(statement);
			}

			statement = connection.prepareStatement(SELECT_NEXT_ID_3);
			statement.setInt(1, bookID.intValue());
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				id = resultSet.getInt(1);
			}
			bbddUtils.close(statement);

			statement = connection.prepareStatement(UPDATE_NEXT_ID_3);
			statement.setInt(1, bookID.intValue());
			statement.executeUpdate();
			bbddUtils.close(statement);
		} catch (SQLException e) {
			log.warn("Resulta imposible obtener el nuevo id de registro.", e);
		} catch (Throwable e) {
			log.warn("Resulta imposible obtener el nuevo id de registro.", e);
		} finally {
			bbddUtils.close(resultSet);
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}

		return id;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getNextIdForUser(java.lang
	 * .String, java.lang.String, java.lang.String)
	 */
	public int getNextIdForUser(String guid, String fullName, String entidad)
			throws SQLException {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		int id = -1;

		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection.prepareStatement(UPDATE_NEXT_ID_IUSER);
			statement.executeUpdate();
			bbddUtils.close(statement);

			statement = connection.prepareStatement(SELECT_NEXT_ID_IUSER);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				id = resultSet.getInt(1);
			}
			if (id <= 0) {
				id = 1;
			} else {
				id = id - 1;
			}
			bbddUtils.close(statement);

			statement = connection.prepareStatement(INSERT_NEXT_ID_IUSER);
			statement.setInt(1, id);
			statement.setString(2, guid);
			statement.setString(3, fullName);
			// statement.executeQuery();
			statement.executeUpdate();
			bbddUtils.close(statement);
		} catch (SQLException e) {
			log.warn("Resulta imposible obtener el nuevo id de usuario.", e);
		} catch (Throwable e) {
			log.warn("Resulta imposible obtener el nuevo id de usuario.", e);
		} finally {
			bbddUtils.close(resultSet);
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}

		return id;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getNextDocID(java.lang.
	 * Integer, java.lang.String)
	 */
	public int getNextDocID(Integer bookID, String entidad) throws SQLException {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		int id = -1;

		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection.prepareStatement(UPDATE_LOCK_NEXT_ID_7);
			statement.setInt(1, bookID.intValue());
			int affected = statement.executeUpdate();
			bbddUtils.close(statement);

			if (affected == 0) {
				statement = connection.prepareStatement(INSERT_NEXT_ID_7);
				statement.setInt(1, bookID.intValue());
				affected = statement.executeUpdate();
				bbddUtils.close(statement);
			}

			statement = connection.prepareStatement(SELECT_NEXT_ID_7);
			statement.setInt(1, bookID.intValue());
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				id = resultSet.getInt(1);
			}
			bbddUtils.close(statement);

			statement = connection.prepareStatement(UPDATE_NEXT_ID_7);
			statement.setInt(1, bookID.intValue());
			statement.executeUpdate();
			bbddUtils.close(statement);
		} catch (SQLException e) {
			log.warn("Resulta imposible obtener el nuevo id de registro.", e);
		} catch (Throwable e) {
			log.warn("Resulta imposible obtener el nuevo id de registro.", e);
		} finally {
			bbddUtils.close(resultSet);
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}

		return id;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getNextIdForExtendedField
	 * (java.lang.Integer, java.lang.String)
	 */
	public int getNextIdForExtendedField(Integer bookID, String entidad)
			throws SQLException {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		int id = -1;

		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection.prepareStatement(UPDATE_LOCK_NEXT_ID_5);
			statement.setInt(1, bookID.intValue());
			int affected = statement.executeUpdate();
			bbddUtils.close(statement);

			if (affected == 0) {
				statement = connection.prepareStatement(INSERT_NEXT_ID_5);
				statement.setInt(1, bookID.intValue());
				affected = statement.executeUpdate();
				bbddUtils.close(statement);
			}

			statement = connection.prepareStatement(SELECT_NEXT_ID_5);
			statement.setInt(1, bookID.intValue());
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				id = resultSet.getInt(1);
			}
			bbddUtils.close(statement);

			statement = connection.prepareStatement(UPDATE_NEXT_ID_5);
			statement.setInt(1, bookID.intValue());
			statement.executeUpdate();
			bbddUtils.close(statement);
		} catch (SQLException e) {
			log.warn("Resulta imposible obtener el nuevo id de registro.", e);
		} catch (Throwable e) {
			log.warn("Resulta imposible obtener el nuevo id de registro.", e);
		} finally {
			bbddUtils.close(resultSet);
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}

		return id;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getUserLastConnection(java
	 * .lang.Integer, java.lang.String)
	 */
	public Timestamp getUserLastConnection(Integer idUser, String entidad) {
		Timestamp date = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection.prepareStatement(SELECT_USER_LASTCONNECTION);
			statement.setInt(1, idUser.intValue());
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				date = resultSet.getTimestamp(1);
				bbddUtils.close(statement);

				statement = connection
						.prepareStatement(DELETE_USER_LASTCONNECTION);
				statement.setInt(1, idUser.intValue());
				statement.executeUpdate();
				bbddUtils.close(statement);

			} else {
				bbddUtils.close(statement);
				date = getDBServerDate(entidad);
			}

			statement = connection.prepareStatement(INSERT_USER_LASTCONNECTION);
			statement.setInt(1, idUser.intValue());
			statement.setTimestamp(2, getDBServerDate(entidad));
			statement.executeUpdate();
			bbddUtils.close(statement);

			log.info("LAST CONNECTION: " + date);

		} catch (SQLException e) {
			log
					.warn(
							"Resulta imposible obtener la fecha de �ltima conexi�n del usuario.",
							e);
		} catch (Throwable e) {
			log
					.warn(
							"Resulta imposible obtener la fecha de �ltima conexi�n del usuario.",
							e);
		} finally {
			bbddUtils.close(resultSet);
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}

		return date;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getDistAccept(Integer,
	 * int, Integer, String)
	 */
	public boolean getDistAccept(Integer bookId, int fdrid, Integer idOfic,
			String entidad) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		boolean lock = false;
		int officeId = 0;
		int state = 0;
		BBDDUtils bbddUtils = new BBDDUtils();
		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection.prepareStatement(SELECT_DIST_DISTACCEPT);
			statement.setInt(1, bookId.intValue());
			statement.setInt(2, fdrid);
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				officeId = resultSet.getInt(OFFICEID_FIELD);
				state = resultSet.getInt(STATE_FIELD);
				if (officeId != idOfic.intValue() || state != 0) {
					lock = true;
				}
			}
			log.info("DIST ACCEPT: " + bookId.intValue() + " " + fdrid + " "
					+ idOfic.intValue() + " " + officeId + " " + state + " "
					+ lock);

		} catch (SQLException e) {
			log
					.warn(
							"Resulta imposible obtener la informaci�n del registro bloqueado aceptado tras una distribuci�n.",
							e);
		} catch (Throwable e) {
			log
					.warn(
							"Resulta imposible obtener la informaci�n del registro bloqueado aceptado tras una distribuci�n.",
							e);
		} finally {
			bbddUtils.close(resultSet);
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}

		return lock;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getDistAcceptExist(Integer,
	 * int, String)
	 */
	public boolean getDistAcceptExist(Integer bookId, int fdrid, String entidad) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		boolean exist = false;
		BBDDUtils bbddUtils = new BBDDUtils();
		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection.prepareStatement(SELECT_DIST_DISTACCEPT);
			statement.setInt(1, bookId.intValue());
			statement.setInt(2, fdrid);
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				exist = true;
			}
			log.info("DIST ACCEPT EXIST: " + bookId.intValue() + " " + fdrid
					+ " " + exist);

		} catch (SQLException e) {
			log
					.warn(
							"Resulta imposible obtener la informaci�n del registro bloqueado aceptado tras una distribuci�n.",
							e);
		} catch (Throwable e) {
			log
					.warn(
							"Resulta imposible obtener la informaci�n del registro bloqueado aceptado tras una distribuci�n.",
							e);
		} finally {
			bbddUtils.close(resultSet);
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}

		return exist;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#updateInsertDistAccept(
	 * boolean, Integer, int, int, int, String, Date, Date, String)
	 */
	public void updateInsertDistAccept(boolean exist, Integer bookId,
			int fdrId, int officeId, int state, String accUser, Date accDate,
			Date distDate, String entidad) {
		PreparedStatement statement = null;
		Connection connection = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		try {
			connection = bbddUtils.getConnection(entidad);
			if (exist) {
				statement = connection.prepareStatement(UPDATE_DIST_DISTACCEPT);
				statement.setInt(1, officeId);
				statement.setInt(2, state);
				statement.setString(3, accUser.toUpperCase());
				statement.setDate(4, bbddUtils.getDate(accDate));
				statement.setInt(5, bookId.intValue());
				statement.setInt(6, fdrId);
				statement.executeUpdate();
				log.info("DIST ACCEPT UPDATE: " + bookId.intValue() + " "
						+ fdrId + " " + officeId + " " + state + " " + accUser
						+ " " + accDate + " " + distDate);
			} else {
				statement = connection.prepareStatement(INSERT_DIST_DISTACCEPT);
				statement.setInt(1, bookId.intValue());
				statement.setInt(2, fdrId);
				statement.setInt(3, officeId);
				statement.setTimestamp(4, bbddUtils.getTimestamp(distDate));
				statement.setTimestamp(5, bbddUtils.getTimestamp(accDate));
				statement.setString(6, accUser.toUpperCase());
				statement.setInt(7, state);
				statement.executeUpdate();
				log.info("DIST ACCEPT INSERT: " + bookId.intValue() + " "
						+ fdrId + " " + officeId + " " + state + " " + accUser
						+ " " + accDate + " " + distDate);

			}

		} catch (SQLException e) {
			log
					.warn(
							"Resulta imposible actualizar o insertar en SCR_DISTACCEPT. ",
							e);
		} catch (Throwable e) {
			log
					.warn(
							"Resulta imposible actualizar o insertar en SCR_DISTACCEPT. ",
							e);
		} finally {
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.ieci.tecdoc.common.entity.dao.DBEntityDAO#updateRole(int, int,
	 * int, String)
	 */
	public void updateRole(int userId, int prodId, int type, String entidad) {
		PreparedStatement statement = null;
		Connection connection = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection.prepareStatement(UPDATE_IUSERUSERTYPE);
			statement.setInt(1, type);
			statement.setInt(2, userId);
			statement.setInt(3, prodId);
			statement.executeUpdate();
			log.info("UPDATE ROLE: " + type + " " + userId + " " + prodId);

		} catch (SQLException e) {
			log
					.warn(
							"Resulta imposible actualizar o insertar en IUSERUSERHDR. ",
							e);
		} catch (Throwable e) {
			log
					.warn(
							"Resulta imposible actualizar o insertar en IUSERUSERHDR. ",
							e);
		} finally {
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#updateLdapFullName(int,
	 * String, String)
	 */
	public void updateLdapFullName(int id, String ldapFullName, String entidad) {
		PreparedStatement statement = null;
		Connection connection = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection.prepareStatement(UPDATE_IUSERLDAPUSERHDR);
			statement.setString(1, ldapFullName);
			statement.setInt(2, id);
			statement.executeUpdate();
			log.info("UPDATE LDAPFULLNAME: " + ldapFullName + " " + id);

		} catch (SQLException e) {
			log.warn("Resulta imposible actualizar en IUSERLDAPUSERHDR. ", e);
		} catch (Throwable e) {
			log.warn("Resulta imposible actualizar en IUSERLDAPUSERHDR. ", e);
		} finally {
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#deleteDistAccept(Integer,
	 * int, String)
	 */
	public void deleteDistAccept(Integer bookId, int fdrid, String entidad) {
		PreparedStatement statement = null;
		Connection connection = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection.prepareStatement(DELETE_DIST_DISTACCEPT);
			statement.setInt(1, bookId.intValue());
			statement.setInt(2, fdrid);
			statement.executeUpdate();

			log.info("DELETE DIST ACCEPT: " + bookId.intValue() + " " + fdrid);

		} catch (SQLException e) {
			log.warn(
					"Resulta imposible borrar la informaci�n de distribuci�n ["
							+ DELETE_DIST_DISTACCEPT + "]", e);
		} catch (Throwable e) {
			log.warn(
					"Resulta imposible borrar la informaci�n de distribuci�n ["
							+ DELETE_DIST_DISTACCEPT + "]", e);
		} finally {
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#lastRegister(java.lang.
	 * Integer, java.lang.Integer, java.lang.Integer, java.lang.String)
	 */
	public int lastRegister(Integer fdrid, Integer idUser, Integer bookId,
			String entidad) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		int lastFdrid = 0;
		BBDDUtils bbddUtils = new BBDDUtils();
		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection.prepareStatement(SELECT_USER_LASTREGISTER);
			statement.setInt(1, bookId.intValue());
			statement.setInt(2, idUser.intValue());
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				lastFdrid = resultSet.getInt(FDRID_FIELD);
				bbddUtils.close(statement);
				if (fdrid != null) {
					statement = connection
							.prepareStatement(UPDATE_USER_LASTREGISTER);
					statement.setInt(1, fdrid.intValue());
					statement.setInt(2, bookId.intValue());
					statement.setInt(3, idUser.intValue());
					statement.executeUpdate();
					bbddUtils.close(statement);
				}

			} else if (fdrid != null) {
				bbddUtils.close(statement);
				statement = connection
						.prepareStatement(INSERT_USER_LASTREGISTER);
				statement.setInt(1, bookId.intValue());
				statement.setInt(2, fdrid.intValue());
				statement.setInt(3, idUser.intValue());
				statement.executeUpdate();
				bbddUtils.close(statement);
			}

			log.info("LAST REGISTER: " + bookId.intValue() + " " + fdrid + " "
					+ idUser.intValue() + " " + lastFdrid);

		} catch (SQLException e) {
			log
					.warn(
							"Resulta imposible obtener la informaci�n del �ltimo registro creado por el usuario.",
							e);
		} catch (Throwable e) {
			log
					.warn(
							"Resulta imposible obtener la informaci�n del �ltimo registro creado por el usuario.",
							e);
		} finally {
			bbddUtils.close(resultSet);
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}

		return lastFdrid;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getDBServerDate(java.lang
	 * .String)
	 */
	public Timestamp getDBServerDate(String entidad) {
		Timestamp date = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(getDateQuery());

			while (resultSet.next()) {
				date = resultSet.getTimestamp(1);

				log.info("CURRENT DATE RECOVERED: " + date);

			}
		} catch (SQLException e) {
			log.warn("Resulta imposible obtener la fecha del sistema.", e);
		} catch (Throwable e) {
			log.warn("Resulta imposible obtener la fecha del sistema.", e);
		} finally {
			bbddUtils.close(resultSet);
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}

		return date;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#findAxSFLastForUserSENTENCE
	 * (java.lang.String, java.lang.String, boolean)
	 */
	public String findAxSFLastForUserSENTENCE(String tableName, String filter,
			boolean orderby) {
		String where = createWhereClausule(null, null, filter, orderby);
		String sentence = MessageFormat.format(AXSF_FIND_LASTFORUSER,
				new String[] { tableName, where });

		if (log.isDebugEnabled()) {
			log.debug("findAxSFLastForUserSENTENCE QUERY :" + sentence);
		}

		return sentence;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#findAxSFAllSENTENCE(com
	 * .ieci.tecdoc.common.isicres.AxSf, java.lang.String,
	 * com.ieci.tecdoc.common.isicres.AxSfQuery, int, int, java.lang.String,
	 * boolean)
	 */
	public String findAxSFAllSENTENCE(AxSf axsf, String tableName,
			AxSfQuery axsfQuery, int begin, int end, String filter,
			boolean orderby) {
		String where = createWhereClausule(axsf, axsfQuery, filter, orderby);

		String sentence = MessageFormat.format(AXSF_FINDALL_SENTENCE,
				new String[] { tableName, where });

		if (log.isDebugEnabled()) {
			log.debug("findAxSFAllSENTENCE QUERY :" + sentence);
		}

		return sentence;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#findAxSFAllSizeSENTENCE
	 * (com.ieci.tecdoc.common.isicres.AxSf, java.lang.String,
	 * com.ieci.tecdoc.common.isicres.AxSfQuery, java.lang.String, boolean)
	 */
	public String findAxSFAllSizeSENTENCE(AxSf axsf, String tableName,
			AxSfQuery axsfQuery, String filter, boolean orderby) {
		String where = createWhereClausule(axsf, axsfQuery, filter, orderby);
		String sentence = MessageFormat.format(AXSF_FINDALL_SIZE_SENTENCE,
				new String[] { tableName, where });

		if (log.isDebugEnabled()) {
			log.debug("findAxSFAllSizeSENTENCE QUERY :" + sentence);
		}

		return sentence;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#assignAxSFPreparedStatement
	 * (com.ieci.tecdoc.common.isicres.AxSfQuery,
	 * com.ieci.tecdoc.common.isicres.AxSf, java.sql.PreparedStatement)
	 */
	public void assignAxSFPreparedStatement(AxSfQuery axsfQuery, AxSf axsfP,
			PreparedStatement ps) throws SQLException {
	    BBDDUtils bbddUtils = new BBDDUtils();
		if (axsfQuery != null && axsfQuery.getFields() != null
				&& !axsfQuery.getFields().isEmpty()) {
			AxSfQueryField field = null;
			int index = 1;
			for (Iterator it = axsfQuery.getFields().iterator(); it.hasNext();) {
				field = (AxSfQueryField) it.next();
				if (field.getFldId().equals("fld9")) {
					field.setBookId(axsfQuery.getBookId());
				}
				if (field.getOperator().equals(Keys.QUERY_OR_TEXT_VALUE)
						|| field.getOperator().equals(
								Keys.QUERY_BETWEEN_TEXT_VALUE)) {
					if (!field.getFldId().equals("fld9")) {
						List list = (List) field.getValue();
						int i = 0;
						for (Iterator it2 = list.iterator(); it2.hasNext();) {
							if (!field.getOperator().equals(
									Keys.QUERY_BETWEEN_TEXT_VALUE)) {
								assignAttribute(field, axsfP, ps, index, it2
										.next());
								if ((axsfP.getAttributeClass(field.getFldId())
										.equals(Date.class))
										&& ((field.getOperator()
												.equals(QUERY_OR)))) {
									index++;
								}
							} else {
								if (axsfP.getAttributeClass(field.getFldId())
										.equals(Date.class)
										&& i == 1) {
									GregorianCalendar gc = new GregorianCalendar();
									Date datetemp = (Date) it2.next();
									gc.setTime(datetemp);
									Calendar calendar = Calendar.getInstance();
									calendar.setTime(datetemp);
									/*int hours = calendar.get(Calendar.HOUR_OF_DAY);
									int minutes = calendar.get(Calendar.MINUTE);
									int seconds = calendar.get(Calendar.SECOND);
									
									
									if (field.getOperator().equals(
											Keys.QUERY_OR_TEXT_VALUE)) {
									  
										gc.set(Calendar.HOUR_OF_DAY, 0);
										gc.set(Calendar.MINUTE, 0);
										gc.set(Calendar.MILLISECOND, 0);
										gc.set(Calendar.SECOND, 0);
									 
									} else {
										gc.set(Calendar.HOUR_OF_DAY, 23);
										gc.set(Calendar.MINUTE, 59);
										gc.set(Calendar.SECOND, 59);
										gc.set(Calendar.MILLISECOND, 999);
									   
									}*/
									ps.setObject(index, bbddUtils
											.getTimestamp(gc.getTime()));
								} else 
										assignAttribute(field, axsfP, ps, index,it2.next());
							}

							index++;
							i++;
						}
					} else {
						assignAttribute(field, axsfP, ps, index, field
								.getBookId());
						index++;
					}
				}else if (field.getOperator().equals(Keys.QUERY_LIKE_TEXT_VALUE)){
					String likeFormat = Keys.QUERY_LIKE_TEXT_VALUE;
					if (field.getValue() instanceof String)
						likeFormat += ((String)field.getValue()).toUpperCase().replace(
							"�", "A").replace(
								"�", "E").replace("�", "I").replace(
								"�", "O").replace("�", "U").replace(
								"�", "A").replace("�", "A").replace(
								"�", "E").replace("�", "E").replace(
								"�", "I").replace("�", "I").replace(
								"�", "O").replace("�", "O").replace(
								"�", "U").replace("�", "U");
					else likeFormat += field.getValue();
					likeFormat += Keys.QUERY_LIKE_TEXT_VALUE;
					field.setValue(likeFormat);
					assignAttribute(field, axsfP, ps, index);
					index++;
				} else{
					assignAttribute(field, axsfP, ps, index);
					// si el operador es = o != y el field es de tipo fecha
					// incrementar dos veces i porque en assignAttribute
					// setearemos 2 valores
					if ((axsfP.getAttributeClass(field.getFldId()) != null && axsfP.getAttributeClass(field.getFldId())
							.equals(Date.class))
							&& ((field.getOperator().equals(IGUAL)) || (field
									.getOperator().equals(DISTINTO)))) {
						index++;
					}
					index++;

				}

			}
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getContador4PERSONS(java
	 * .lang.Integer, java.lang.String)
	 */
	public abstract int getContador4PERSONS(Integer userId, String entidad)
			throws SQLException;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getContador4SCRADDRESS(
	 * java.lang.Integer, java.lang.String)
	 */
	public abstract int getContador4SCRADDRESS(Integer userId, String entidad)
			throws SQLException;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#createWhereClausuleReport
	 * (com.ieci.tecdoc.common.isicres.AxSf,
	 * com.ieci.tecdoc.common.isicres.AxSfQuery, java.lang.String)
	 */
	public String createWhereClausuleReport(AxSf axsf, AxSfQuery axsfQuery,
			String filter) {
		StringBuffer buffer = new StringBuffer();

		buffer.append(ESPACIO);
		if (filter != null) {
			buffer.append(WHERE);
			buffer.append(ESPACIO);
			buffer.append(filter);
			buffer.append(ESPACIO);
		}

		AxSfQueryField field = null;

		if (axsfQuery != null && axsfQuery.getFields() != null
				&& !axsfQuery.getFields().isEmpty()) {
			if (filter == null) {
				buffer.append(WHERE);
				buffer.append(ESPACIO);
			} else {
				buffer.append(AND);
				buffer.append(ESPACIO);
			}

			int i = 0;
			for (Iterator it = axsfQuery.getFields().iterator(); it.hasNext();) {
				field = (AxSfQueryField) it.next();
				if (field.getOperator().equals(Keys.QUERY_OR_TEXT_VALUE)) {
					// Desde la entrada del usuario del estilo: xxx;xxx;xxxx
					// Se genera (fld=? OR....)
					List list = (List) field.getValue();
					if (!list.isEmpty()) {
						int j = 0;
						int size = list.size();
						buffer.append(PAR_IZQ);
						if (!field.getFldId().equals("fld9")) {
							for (Iterator it2 = list.iterator(); it2.hasNext();) {
								// buffer.append(field.getFldId());
								// buffer.append(IGUAL);
								String aux = null;
								if (axsf != null
										&& axsf.getAttributeClass(
												field.getFldId()).equals(
												Date.class)) {
									aux = getDateField(field.getFldId(), IGUAL,
											2, FORMATTER.format((Date) it2
													.next()));
									// aux = aux.substring(0,aux.indexOf("?")) +
									// "'" + FORMATTER.format((Date) it2.next())
									// + "'";
									buffer.append(aux);
									/*
									 * } else { if (axsf != null &&
									 * axsf.getAttributeClass
									 * (field.getFldId()).equals(Date.class)) {
									 * aux = "'" + FORMATTER.format((Date)
									 * it2.next()) + "'"; buffer.append(aux);
									 */
								} else {
									buffer.append(field.getFldId());
									buffer.append(IGUAL);
									aux = field.getFldId()
											+ field.getOperator()
											+ field.getValue();
									if (field.getValue().getClass().equals(
											Integer.class)) {
										buffer.append(it2.next());
									} else {
										buffer.append("'" + it2.next() + "'");
									}
								}
								if (j < size - 1) {
									buffer.append(ESPACIO);
									buffer.append(OR);
									buffer.append(ESPACIO);
								}
								j++;
								// it2.next();
							}
						} else {
							for (Iterator it2 = list.iterator(); it2.hasNext();) {
								if (j == 0) {
									buffer.append(axsfQuery.getWhereField9());
									buffer.append(IGUAL);
								}
								axsfQuery.setSentenceField9OrBetween(
										(String) it2.next(), OR);
								j++;
							}
							buffer.append(axsfQuery
									.getSentenceField9OrBetween());
							buffer.append(axsfQuery.getWhereIdarchField9());
							buffer.append(axsfQuery.getBookId().toString());
							buffer.append(PAR_DER);
							axsfQuery.initializeSentenceField9OrBetween();
						}
						buffer.append(PAR_DER);
					}
				} else if (field.getOperator().equals(
						Keys.QUERY_BETWEEN_TEXT_VALUE)) {
					// Desde la entrada del usuario del estilo: xxx;xxx
					// Se genera (BETWEEN fld=? AND fld=?)
					List list = (List) field.getValue();
					if (!list.isEmpty()) {
						int j = 0;
						int size = list.size();
						buffer.append(PAR_IZQ);
						if (!field.getFldId().equals("fld9")) {
							buffer.append(field.getFldId());
							buffer.append(ESPACIO);
							buffer.append(BETWEEN);
							buffer.append(ESPACIO);
							for (Iterator it2 = list.iterator(); it2.hasNext();) {
								String aux = null;
								if (axsf != null
										&& axsf.getAttributeClass(
												field.getFldId()).equals(
												Date.class)) {
									if (j > 0) {
										aux = getTimeStampField((Date) it2
												.next(), 4);
									} else {
										aux = getTimeStampField((Date) it2
												.next(), 3);
									}
									// aux = getTimeStampFormat(aux);
									// aux = "'" + FORMATTER.format((Date)
									// it2.next()) + "'";

									buffer.append(aux);
								} else {
									aux = field.getFldId()
											+ field.getOperator()
											+ field.getValue();
									if (field.getValue().getClass().equals(
											Integer.class)) {
										buffer.append(it2.next());
									} else {
										buffer.append("'" + it2.next() + "'");
									}
								}
								if (j < size - 1) {
									buffer.append(ESPACIO);
									buffer.append(AND);
									buffer.append(ESPACIO);
								}
								j++;
							}
						} else {
							buffer.append(axsfQuery.getWhereField9());
							buffer.append(ESPACIO);
							buffer.append(BETWEEN);
							buffer.append(ESPACIO);
							for (Iterator it2 = list.iterator(); it2.hasNext();) {
								axsfQuery.setSentenceField9OrBetween(
										(String) it2.next(), BETWEEN);
							}
							buffer.append(axsfQuery
									.getSentenceField9OrBetween());
							buffer.append(axsfQuery.getWhereIdarchField9());
							buffer.append(axsfQuery.getBookId().toString());
							buffer.append(PAR_DER);
							axsfQuery.initializeSentenceField9OrBetween();
						}
						buffer.append(PAR_DER);
						/*
						 * buffer.append(INTERROGACION); buffer.append(ESPACIO);
						 * buffer.append(AND); buffer.append(ESPACIO);
						 * buffer.append(INTERROGACION); buffer.append(PAR_DER);
						 */
					}
				} else if (field.getOperator().equals(
						Keys.QUERY_LIKE_TEXT_VALUE)) {
					buffer.append(PAR_IZQ);
					if (field.getFldId().equals("fld9")) {
						buffer.append(axsfQuery.getWhereField9());
					} else {
						buffer.append(field.getFldId());
					}
					buffer.append(ESPACIO);
					buffer.append(LIKE);
					buffer.append(ESPACIO);
					if (field.getFldId().equals("fld9")) {
						axsfQuery.setSentenceField9((String) field.getValue());
						buffer.append(axsfQuery.getSentenceField9());
						buffer.append(axsfQuery.getBookId().toString());
						buffer.append(")");
					} else {
						buffer.append("'" + field.getValue() + "'");
					}
					buffer.append(PAR_DER);
				} else if (field.getOperator().equals(
						Keys.QUERY_DEPEND_OF_TEXT_VALUE)) {
					buffer.append(PAR_IZQ);
					buffer.append(field.getFldId());
					buffer.append(ESPACIO);
					buffer.append(axsfQuery.getWhereOprDependOfIn());
					buffer.append("'" + field.getValue() + "'");
					buffer.append(axsfQuery.getWhereOprDependOfConnect());
					buffer.append(")");
					buffer.append(PAR_DER);
				} else {
					String aux = null;
					if (axsf != null
							&& axsf.getAttributeClass(field.getFldId()).equals(
									Date.class)) {
						aux = getDateField(field.getFldId(), field
								.getOperator(), 2, FORMATTER
								.format((Date) field.getValue()));
						// aux = aux.substring(0,aux.indexOf("?")) + "'" +
						// FORMATTER.format((Date) field.getValue()) + "'";
						buffer.append(aux);
					} else {
						aux = field.getFldId() + field.getOperator()
								+ field.getValue();
						if (!field.getFldId().equals("fld9")) {
							buffer.append(field.getFldId());
							buffer.append(field.getOperator());
							if (field.getValue().getClass().equals(
									Integer.class)) {
								buffer.append(field.getValue());
							} else {
								buffer.append("'" + field.getValue() + "'");
							}
						} else {
							buffer.append(axsfQuery.getWhereField9());
							buffer.append(field.getOperator());
							axsfQuery.setSentenceField9((String) field
									.getValue());
							buffer.append(axsfQuery.getSentenceField9());
							buffer.append(axsfQuery.getBookId().toString());
							buffer.append(")");
						}
					}
				}
				if (i < axsfQuery.getFields().size() - 1) {
					buffer.append(ESPACIO);
					buffer.append(AND);
					buffer.append(ESPACIO);
				}
				i++;
				buffer.append(ESPACIO);
			}
			buffer.append(ESPACIO);
		}

		if (log.isDebugEnabled()) {
			log.debug("createWhereClausuleReport WHERE :" + buffer);
		}

		return buffer.toString();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#createWhereClausule(com
	 * .ieci.tecdoc.common.isicres.AxSf,
	 * com.ieci.tecdoc.common.isicres.AxSfQuery, java.lang.String, boolean)
	 */
	public String createWhereClausule(AxSf axsf, AxSfQuery axsfQuery,
			String filter, boolean orderby) {

		StringBuffer buffer = new StringBuffer();
		boolean fld32 = true;

		buffer.append(ESPACIO);
		if (filter != null) {
			buffer.append(WHERE);
			buffer.append(ESPACIO);
			buffer.append(filter);
			buffer.append(ESPACIO);
		}
		if (axsfQuery != null && axsfQuery.getSelectDefWhere2() != null) {
			if (filter != null) {
				buffer.append(ESPACIO);
				buffer.append(AND);
				buffer.append(ESPACIO);
				buffer.append(axsfQuery.getSelectDefWhere2());
				buffer.append(ESPACIO);
			} else {
				buffer.append(WHERE);
				buffer.append(ESPACIO);
				buffer.append(axsfQuery.getSelectDefWhere2());
				buffer.append(ESPACIO);
			}
		}

		AxSfQueryField field = null;

		if (axsfQuery != null && axsfQuery.getFields() != null
				&& !axsfQuery.getFields().isEmpty()) {
			if (filter == null && axsfQuery.getSelectDefWhere2() == null) {
				buffer.append(WHERE);
				buffer.append(ESPACIO);
			} else {
				buffer.append(AND);
				buffer.append(ESPACIO);
			}

			int i = 0;
			for (Iterator it = axsfQuery.getFields().iterator(); it.hasNext();) {
				field = (AxSfQueryField) it.next();
				if (field.getOperator().equals(Keys.QUERY_OR_TEXT_VALUE)) {
					// Desde la entrada del usuario del estilo: xxx;xxx;xxxx
					// Se genera (fld=? OR....)
					List list = (List) field.getValue();
					if (!list.isEmpty()) {
						int j = 0;
						int size = list.size();
						buffer.append(PAR_IZQ);
						for (Iterator it2 = list.iterator(); it2.hasNext();) {
							if (field.getFldId().equals("fld9")) {
								if (j == 0) {
									buffer.append(axsfQuery.getWhereField9());
									buffer.append(IGUAL);
								}
								axsfQuery.setSentenceField9OrBetween(
										(String) it2.next(), OR);
							} else {
								if (axsf != null
										&& axsf.getAttributeClass(
												field.getFldId()).equals(
												Date.class)) {
									buffer.append(getDateField(
											field.getFldId(), IGUAL, 1, null));
								} else {
									buffer.append(field.getFldId());
									buffer.append(IGUAL);
									buffer.append(INTERROGACION);
								}
								if (j < size - 1) {
									buffer.append(ESPACIO);
									buffer.append(OR);
									buffer.append(ESPACIO);
								}
							}
							j++;
							if (!field.getFldId().equals("fld9")) {
								it2.next();
							}
						}
						if (field.getFldId().equals("fld9")) {
							buffer.append(axsfQuery
									.getSentenceField9OrBetween());
							buffer.append(axsfQuery.getWhereIdarchField9());
							buffer.append(INTERROGACION);
							buffer.append(PAR_DER);
							axsfQuery.initializeSentenceField9OrBetween();
						}
						buffer.append(PAR_DER);
					}
				} else if (field.getOperator().equals(
						Keys.QUERY_BETWEEN_TEXT_VALUE)) {
					// Desde la entrada del usuario del estilo: xxx;xxx
					// Se genera (BETWEEN fld=? AND fld=?)
					List list = (List) field.getValue();
					if (!list.isEmpty()) {
						if (!field.getFldId().equals("fld9")) {
							buffer.append(PAR_IZQ);
							buffer.append(field.getFldId());
							buffer.append(ESPACIO);
							buffer.append(BETWEEN);
							buffer.append(ESPACIO);
							buffer.append(INTERROGACION);
							buffer.append(ESPACIO);
							buffer.append(AND);
							buffer.append(ESPACIO);
							buffer.append(INTERROGACION);
							buffer.append(PAR_DER);
						} else {
							buffer.append(axsfQuery.getWhereField9());
							buffer.append(ESPACIO);
							buffer.append(BETWEEN);
							buffer.append(ESPACIO);
							for (Iterator it2 = list.iterator(); it2.hasNext();) {
								axsfQuery.setSentenceField9OrBetween(
										(String) it2.next(), BETWEEN);
							}
							buffer.append(axsfQuery
									.getSentenceField9OrBetween());
							buffer.append(axsfQuery.getWhereIdarchField9());
							buffer.append(INTERROGACION);
							buffer.append(PAR_DER);
							axsfQuery.initializeSentenceField9OrBetween();
						}
					}
				} else if (field.getOperator().equals(
						Keys.QUERY_LIKE_TEXT_VALUE)) {
					buffer.append(PAR_IZQ);
					if (field.getFldId().equals("fld9")) {
						buffer.append(axsfQuery.getWhereField9());
					} else {
					    if (field.getFldId().equals("fld507")) {
						buffer.append(axsfQuery.getWhereField507_01());
						 buffer.append(axsfQuery.getBookId());
						buffer.append(axsfQuery.getWhereField507_02());
        					} else {
        					    if (axsf instanceof AxSfIn  && field.getFldId().equals("fld18")) {
        						buffer.append(axsfQuery.getWhereFieldExtend_01());
        						buffer.append(axsfQuery.getBookId());
        						buffer.append(axsfQuery.getWhereFieldExtend_02());
        						buffer.append("18");
        						buffer.append(axsfQuery.getWhereFieldExtend_03());
        					    }else{
        						if (axsf instanceof AxSfOut  && field.getFldId().equals("fld14")) {
                						buffer.append(axsfQuery.getWhereFieldExtend_01());
                						buffer.append(axsfQuery.getBookId());
                						buffer.append(axsfQuery.getWhereFieldExtend_02());
                						buffer.append("14");
                						buffer.append(axsfQuery.getWhereFieldExtend_03());
            					    	}else{
                						buffer.append(REPLACE);
                						buffer.append(PAR_IZQ);
                						buffer.append(UPPER);
                						buffer.append(PAR_IZQ);
                						buffer.append(field.getFldId());
                						buffer.append(PAR_DER);
                						buffer.append(",'"+TILDES+"', '"+NOTILDES+"'");
                						buffer.append(PAR_DER);
            					    	}
        					    }
        					}
					}
					buffer.append(ESPACIO);
					buffer.append(LIKE);
					buffer.append(ESPACIO);
					if (field.getFldId().equals("fld9")) {
						axsfQuery.setSentenceField9((String) field.getValue());
						buffer.append( REPLACE + 
								PAR_IZQ +"UPPER('%"+(String) field.getValue()+"%'),'"+TILDES
								+"', '"+NOTILDES+"'"+PAR_DER + " and id_arch=");
					}
					buffer.append(INTERROGACION);
					if (field.getFldId().equals("fld9") || field.getFldId().equals("fld507") 
						|| (axsf instanceof AxSfIn  && field.getFldId().equals("fld18"))
						|| (axsf instanceof AxSfOut  && field.getFldId().equals("fld14"))) {
						buffer.append(")");
					}
					buffer.append(PAR_DER);
				} else if (field.getOperator().equals(
						Keys.QUERY_DEPEND_OF_TEXT_VALUE)) {
					buffer.append(PAR_IZQ);
					buffer.append(field.getFldId());
					buffer.append(ESPACIO);
					buffer.append(axsfQuery.getWhereOprDependOfIn());
					buffer.append(INTERROGACION);
					buffer.append(axsfQuery.getWhereOprDependOfConnect());
					buffer.append(")");
					buffer.append(PAR_DER);
				} else {

					//comprobamos el operador de busqueda
					if((Keys.QUERY_NOT_EQUAL_TEXT_VALUE).equals(field.getOperator())){
						// Cuando realizamos una b�squeda con un valor distinto
						// de [...] debemos tener en cuenta que los valores nulos
						// del campo tambi�n entran dentro del criterio de b�squeda
						buffer.append(PAR_IZQ);
						buffer.append(field.getFldId());
						buffer.append(ESPACIO);
						buffer.append(IS_NULL);
						buffer.append(ESPACIO);
						buffer.append(OR);
						buffer.append(ESPACIO);
						//generamos la consulta para el campo indicado
						fld32 = generateQueryByField(axsf, axsfQuery, buffer,
								fld32, field);
						buffer.append(PAR_DER);
					}else{
						//cualquier operador a excepci�n de distinto
						//generamos la consulta para el campo indicado
						fld32 = generateQueryByField(axsf, axsfQuery, buffer,
								fld32, field);
					}
				}
				if (i < axsfQuery.getFields().size() - 1) {
					if (!field.getFldId().equals("fld32")
							|| (field.getFldId().equals("fld32") && fld32)) {
						buffer.append(ESPACIO);
						if (StringUtils.isNotEmpty(field.getNexo()))
							buffer.append(field.getNexo());
						else
							buffer.append(AND);
						buffer.append(ESPACIO);
					}
				}
				i++;
				buffer.append(ESPACIO);
			}
			buffer.append(ESPACIO);
			if (orderby) {
				buffer.append(axsfQuery.getOrderBy());
			}
		} else if (axsfQuery != null) {
			if (orderby) {
				buffer.append(axsfQuery.getOrderBy());
			}
		}
		if (log.isDebugEnabled()) {
			log.debug("createWhereClausule WHERE :" + buffer);
		}

		return buffer.toString();
	}

	/**
	 * Genera la cadena con el criterio indicado para el campo
	 * @param axsf
	 * @param axsfQuery
	 * @param buffer - String con la consulta a realizar
	 * @param fld32
	 * @param field
	 * @return
	 */
	private boolean generateQueryByField(AxSf axsf, AxSfQuery axsfQuery,
			StringBuffer buffer, boolean fld32, AxSfQueryField field) {
		if (axsf != null && axsf.getAttributeClass(field.getFldId()) != null 
				&& axsf.getAttributeClass(field.getFldId()).equals(
						Date.class)) {
			buffer.append(getDateField(field.getFldId(), field
					.getOperator(), 1, null));
		} else {
			if (!field.getFldId().equals("fld32")) {
			    if (field.getFldId().equals("fld1001")){
				if (((String) field.getValue()).equals("S")){
				    buffer.append(axsfQuery.getWhereField1001_01_S());
				    buffer.append(axsfQuery.getBookId());
				    buffer.append(axsfQuery.getWhereField1001_02());
				}
				else {
				    buffer.append(axsfQuery.getWhereField1001_01_N());
				    buffer.append(axsfQuery.getBookId());
				    buffer.append(axsfQuery.getWhereField1001_02());
				}
			    }else {
				 if (field.getFldId().equals("fld503") && 
					 ((String) field.getValue()).equals("0")){
					 buffer.append(field.getFldId());
					 buffer.append(" IS NULL ");
				 }
				 else {
        				if (field.getFldId().equals("fld9")) {
        					buffer.append(axsfQuery.getWhereField9());
        				} else {
        					buffer.append(field.getFldId());
        				}
        				buffer.append(field.getOperator());
        				if (field.getFldId().equals("fld9")) {
        					axsfQuery.setSentenceField9((String) field
        							.getValue());
        					buffer.append(axsfQuery.getSentenceField9());
        				}
        				buffer.append(INTERROGACION);
        				if (field.getFldId().equals("fld9")) {
        					buffer.append(")");
        				}
				    
				 }
			    }
				fld32 = false;
			} else {
				if (((String) field.getValue()).equals("xxx")) {
					buffer.append(axsfQuery
							.getWhereDistNotRegister());
					buffer.append(field.getOperator());
					buffer.append(INTERROGACION);
					buffer.append(")");
					fld32 = true;
				}
			}
		}
		return fld32;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getTimeStampField(java.
	 * util.Date, int)
	 */
	public String getTimeStampField(Date date, int index) {
		String resultString = null;
		if (index == 0) {
			resultString = getTimeStampFormat(FORMATTERSTAMP.format(date)
					+ ":00");
		} else if (index == 1) {
			resultString = getTimeStampFormat(FORMATTERSTAMP.format(date)
					+ ":59");
		} else if (index == 2) {
			resultString = getTimeStampFormat(FORMATTERSTAMPAL.format(date));
		} else if (index == 3) {
			resultString = getTimeStampFormat(FORMATTER.format(date)
					+ " 00:00:00");
		} else {
			resultString = getTimeStampFormat(FORMATTER.format(date)
					+ " 23:59:00");
		}

		return resultString;
	}

	/***************************************************************************
	 * Protected methods
	 **************************************************************************/

	/**
	 * M�todo que formetea un valor en formato timestamp
	 *
	 * @param date
	 *            fecha a formatear
	 * @return
	 */
	protected abstract String getTimeStampFormat(String date);

	/**
	 * M�todo que nos devuelve una clausula where para tratar una fecha
	 *
	 * @param fld
	 *            fecha
	 * @param operator
	 *            operador sobre la fecha
	 * @param type
	 *            tipo de ejecucion del metodo
	 * @param formatedField
	 *            fecha formateada
	 * @return
	 */
	protected abstract String getDateField(String fld, String operator,
			int type, String formatedField);

	/**
	 * M�todo que nos devuelve una sentencia sql con la obtener la fecha del
	 * sistema del gestor de bases de datos
	 *
	 * @return
	 */
	protected abstract String getDateQuery();

	/**
	 * M�todo para componer una consulta jdbc
	 *
	 * @param field
	 * @param axsfP
	 * @param ps
	 * @param index
	 * @throws SQLException
	 */
	protected void assignAttribute(AxSfQueryField field, AxSf axsfP,
			PreparedStatement ps, int index) throws SQLException {
		if (field.getFldId().equals("fld9")) {
			assignAttribute(field, axsfP, ps, index, field.getBookId());
		} else if (field.getFldId().equals("fld32")) {
			assignAttribute(field, axsfP, ps, index, new Integer(0));
		} else {
		    if (field.getFldId().equals("fld503") && 
					 ((String) field.getValue()).equals("0")){
			
		    }else {
        		    if (field.getFldId().equals("fld1001")) {
        			assignAttribute(field, axsfP, ps, index, "1");
        		    } else {
        			assignAttribute(field, axsfP, ps, index, field.getValue());
        		    }
		    }
		}
	}

	/**
	 * M�todo para componer una consulta jdbc
	 *
	 * @param field
	 * @param axsfP
	 * @param ps
	 * @param index
	 * @param value
	 * @throws SQLException
	 */
	protected void assignAttribute(AxSfQueryField field, AxSf axsfP,
			PreparedStatement ps, int index, Object value) throws SQLException {
	    BBDDUtils bbddUtils = new BBDDUtils();
		if ((axsfP.getAttributeClass(field.getFldId()) != null && axsfP.getAttributeClass(field.getFldId()).equals(Date.class))
				&& ((field.getOperator().equals(IGUAL))
						|| (field.getOperator().equals(DISTINTO)) || (field
						.getOperator().equals(QUERY_OR)))) {

			Date date = null;
			if (field.getOperator().equals(QUERY_OR)) {
				date = (Date) value;
			} else {
				date = (Date) field.getValue();
			}

			String dateFormatter = FORMATTER.format((Date) date) + MIN_TIME;
			ps.setObject(index, dateFormatter);
			index++;

			dateFormatter = FORMATTER.format((Date) date) + MAX_TIME;
			ps.setObject(index, dateFormatter);

		} else if ((axsfP.getAttributeClass(field.getFldId()) != null && axsfP.getAttributeClass(field.getFldId())
				.equals(Date.class))
				&& ((field.getOperator().equals(ENTRE)))) {
			GregorianCalendar gc = new GregorianCalendar();

			Calendar calendar = Calendar.getInstance();
			calendar.setTime((Date) value);
			int hours = calendar.get(Calendar.HOUR_OF_DAY);
			int minutes = calendar.get(Calendar.MINUTE);
			int seconds = calendar.get(Calendar.SECOND);
			
			gc.setTime((Date) value);
			if (hours == 0 && minutes == 0 && seconds ==0 ){
        			gc.set(Calendar.SECOND, 0);
        			gc.set(Calendar.MILLISECOND, 0);
        			gc.set(Calendar.HOUR_OF_DAY, 0);
        			gc.set(Calendar.MINUTE, 0);
			}
			ps.setObject(index, bbddUtils.getTimestamp(gc.getTime()));

		} else if ((axsfP.getAttributeClass(field.getFldId()) != null && axsfP.getAttributeClass(field.getFldId())
				.equals(Date.class))
				&& ((field.getOperator().equals(MAYOR)) || (field.getOperator()
						.equals(MENOR_IGUAL)))) {
		    	Calendar calendar = Calendar.getInstance();
			calendar.setTime((Date) field.getValue());
			int hours = calendar.get(Calendar.HOUR_OF_DAY);
			int minutes = calendar.get(Calendar.MINUTE);
			int seconds = calendar.get(Calendar.SECOND);
			
			String dateFormatter = null;
			if (hours == 0 && minutes == 0 && seconds == 0){
			    dateFormatter =  FORMATTER.format((Date) field.getValue()) + MAX_TIME;
			}else {
			    dateFormatter = FORMATTERSTAMPAL.format((Date) field.getValue());
			}
			ps.setObject(index, dateFormatter);

		} else if (axsfP.getAttributeClass(field.getFldId()) != null && axsfP.getAttributeClass(field.getFldId()).equals(Date.class)) {
		    	Calendar calendar = Calendar.getInstance();
			calendar.setTime((Date) field.getValue());
			int hours = calendar.get(Calendar.HOUR_OF_DAY);
			int minutes = calendar.get(Calendar.MINUTE);
			int seconds = calendar.get(Calendar.SECOND);
			
		    String dateFormatter = null;
		    if (hours == 0 && minutes == 0 && seconds == 0){
			dateFormatter = FORMATTER.format((Date) field.getValue())
					+ MIN_TIME;
		    }else {
			dateFormatter = FORMATTERSTAMPAL.format((Date) field.getValue());
		    }
			ps.setObject(index, dateFormatter);

		} else ps.setObject(index, value );
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getDistributionSize(String,
	 * String)
	 */
	public int getDistributionSize(String sentence, String entidad)
			throws SQLException {
		Statement statement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		int result = 0;
		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sentence);

			if (resultSet.next()) {
				result = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			log.warn("Error ejecutando [" + sentence + "]", e);
			throw e;
		} catch (Throwable e) {
			log.warn("Error ejecutando [" + sentence + "]", e);
			throw new SQLException("Error ejecutando [" + sentence + "]");
		} finally {
			bbddUtils.close(statement);
			bbddUtils.close(resultSet);
			bbddUtils.close(connection);
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getPersonListSize(String,
	 * String)
	 */
	public int getPersonListSize(String sentence, String entidad)
			throws SQLException {
		Statement statement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		int result = 0;
		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sentence);

			if (resultSet.next()) {
				result = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			log.warn("Error ejecutando [" + sentence + "]", e);
			throw e;
		} catch (Throwable e) {
			log.warn("Error ejecutando [" + sentence + "]", e);
			throw new SQLException("Error ejecutando [" + sentence + "]");
		} finally {
			bbddUtils.close(statement);
			bbddUtils.close(resultSet);
			bbddUtils.close(connection);
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getIdArchDistribution(String
	 * , String)
	 */
	public List getIdArchDistribution(String query, String entidad)
			throws SQLException {
		Statement statement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		List idArchs = new ArrayList();
		BBDDUtils bbddUtils = new BBDDUtils();
		try {

			connection = bbddUtils.getConnection(entidad);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				idArchs.add(new Integer(resultSet.getInt(1)));
			}

		} catch (SQLException e) {
			log.warn("Error ejecutando [" + query + "]", e);
			throw e;
		} catch (Throwable e) {
			log.warn("Error ejecutando [" + query + "]", e);
			throw new SQLException("Error ejecutando [" + query.toString()
					+ "]");
		} finally {
			bbddUtils.close(statement);
			bbddUtils.close(resultSet);
			bbddUtils.close(connection);
		}
		return idArchs;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#insertScrSharedFiles(int,
	 * int, int, int, int, String)
	 */
	public int insertScrSharedFiles(int fileId, int ownerBookId,
			int ownerRegId, int bookId, int regId, String entidad)
			throws SQLException {
		PreparedStatement statement = null;
		Connection connection = null;
		BBDDUtils bbddUtils = new BBDDUtils();
    		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection.prepareStatement(INSERT_SCR_SHAREDFILES);
			statement.setInt(1, fileId);
			statement.setInt(2, ownerBookId);
			statement.setInt(3, ownerRegId);
			statement.setInt(4, bookId);
			statement.setInt(5, regId);

			statement.executeUpdate();
		} catch (SQLException e) {
			log.warn("Resulta imposible insertar scr_sharedfiles ["
					+ INSERT_SCR_SHAREDFILES + "]", e);
			throw e;
		} catch (Throwable e) {
			log.warn("Resulta imposible insertar scr_sharedfiles ["
					+ INSERT_SCR_SHAREDFILES + "]", e);
			throw new SQLException(e.getMessage());
		} finally {
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}

		return 1;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getHashDocument(Integer,
	 * int, int, String, boolean, String)
	 */
	public String getHashDocument(Integer bookId, int fdrid, int pageId,
			String hash, boolean selDel, String entidad) {
		PreparedStatement statement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		String result = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		try {
			connection = bbddUtils.getConnection(entidad);
			if (selDel) {
				statement = connection.prepareStatement(SELECT_HASH_PAGE);
				statement.setInt(1, bookId.intValue());
				statement.setInt(2, fdrid);
				statement.setInt(3, pageId);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					StringClobType stringClobType = new StringClobType();
					String[] names = { "HASH" };
					Object o = stringClobType.nullSafeGet(resultSet, names,
							null);
					if (o != null) {
						result = (String) o;
					}
				}

				log.info("SELECT HASH FROM SCR_PAGEINFO: " + bookId.intValue()
						+ " " + fdrid + " " + pageId);
			} else {
				statement = connection.prepareStatement(UPDATE_HASH_PAGE);
				statement.setInt(2, bookId.intValue());
				statement.setInt(3, fdrid);
				statement.setInt(4, pageId);
				StringClobType stringClobType = new StringClobType();
				stringClobType.nullSafeSet(statement, hash, 1);
				statement.executeUpdate();

				log.info("UPDATE HASH FROM SCR_PAGEINFO: " + bookId.intValue()
						+ " " + fdrid + " " + pageId);

			}

		} catch (SQLException e) {
			if (selDel) {
				log.warn("Resulta imposible obtener el hash del documento ["
						+ SELECT_HASH_PAGE + "]", e);
			} else {
				log.warn("Resulta imposible actualizar el hash del documento ["
						+ DELETE_HASH_PAGE + "]", e);
			}
		} catch (Throwable e) {
			if (selDel) {
				log.warn("Resulta imposible obtener el hash del documento ["
						+ SELECT_HASH_PAGE + "]", e);
			} else {
				log.warn("Resulta imposible actualizar el hash del documento ["
						+ DELETE_HASH_PAGE + "]", e);
			}
		} finally {
			bbddUtils.close(statement);
			bbddUtils.close(resultSet);
			bbddUtils.close(connection);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getReportData(int,
	 * String, String)
	 */
	public ZipInputStream getReportData(int reportId, String temporalDirectory,
			String entidad) throws SQLException {
		Statement statement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		byte[] buffer = null;
		StringBuffer query = new StringBuffer();
		int size = 0;
		try {
			InputStream fin = null;
			query.append("SELECT DATA FROM SCR_REPORTS WHERE ID=" + reportId);

			connection = bbddUtils.getConnection(entidad);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query.toString());

			buffer = new byte[4096];

			FileOutputStream output = new FileOutputStream(temporalDirectory);
			while (resultSet.next()) {
				fin = resultSet.getBinaryStream(1);
				for (;;) {
					size = fin.read(buffer);
					if (size == -1) {
						break;
					}
					output.write(buffer, 0, size);
				}
			}
			output.close();

			// Leemos el fichero para dejarlo disponible como Stream
			ZipInputStream zis = new ZipInputStream(new BufferedInputStream(
					new FileInputStream(temporalDirectory)));

			return zis;

		} catch (SQLException e) {
			log.warn("Error ejecutando [" + query.toString() + "]", e);
			throw e;
		} catch (Throwable e) {
			log.warn("Error ejecutando [" + query.toString() + "]", e);
			throw new SQLException("Error ejecutando [" + query.toString()
					+ "]");
		} finally {
			bbddUtils.close(statement);
			bbddUtils.close(resultSet);
			bbddUtils.close(connection);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#saveOrUpdateUserConfig(
	 * String, Integer, int, String)
	 */
	public void saveOrUpdateUserConfig(String result, Integer idUser, int type,
			String entidad) {
		PreparedStatement statement = null;
		Connection connection = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		try {
			connection = bbddUtils.getConnection(entidad);
			if (type == 0) {
				statement = connection.prepareStatement(INSERT_USER_CONFIG);
				statement.setInt(1, idUser.intValue());
				statement.setString(2, result);
				statement.executeUpdate();
			} else {
				statement = connection.prepareStatement(UPDATE_USER_CONFIG);
				statement.setString(1, result);
				statement.setInt(2, idUser.intValue());
				statement.executeUpdate();
			}

			log.info("USER_CONF: " + idUser.intValue() + " " + result);

		} catch (SQLException e) {
			log
					.warn(
							"Resulta imposible actualizar la configuraci�n del usuario.",
							e);
		} catch (Throwable e) {
			log
					.warn(
							"Resulta imposible actualizar la configuraci�n del usuario.",
							e);
		} finally {
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getUsrEmail(Integer,
	 * String)
	 */
	public String getUsrEmail(Integer idUser, String entidad) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		String userEmail = "";
		BBDDUtils bbddUtils = new BBDDUtils();
		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection.prepareStatement(SELECT_SCR_EMAIL_USRLOC);
			statement.setInt(1, idUser.intValue());
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				userEmail = resultSet.getString(1);
			}

			log.info("User id: " + idUser.intValue() + " email:" + userEmail);

		} catch (SQLException e) {
			log.warn(
					"Resulta imposible obtener la direcci�n de correo del usuario."
							+ idUser.intValue(), e);
		} catch (Throwable e) {
			log.warn(
					"Resulta imposible obtener la direcci�n de correo del usuario."
							+ idUser.intValue(), e);
		} finally {
			bbddUtils.close(resultSet);
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}

		return userEmail;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getOficEmail(Integer,
	 * String)
	 */
	public String getOficEmail(Integer idOfic, String entidad) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		String oficEmail = "";
		BBDDUtils bbddUtils = new BBDDUtils();
		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection.prepareStatement(SELECT_SCR_EMAIL_OFIC);
			statement.setInt(1, idOfic.intValue());
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				oficEmail = resultSet.getString(1);
			}

			log.info("Ofic id: " + idOfic.intValue() + " email:" + oficEmail);

		} catch (SQLException e) {
			log.warn(
					"Resulta imposible obtener la direcci�n de correo de la oficina."
							+ idOfic.intValue(), e);
		} catch (Throwable e) {
			log.warn(
					"Resulta imposible obtener la direcci�n de correo de la oficina."
							+ idOfic.intValue(), e);
		} finally {
			bbddUtils.close(resultSet);
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}

		return oficEmail;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getListAddrTel(String,
	 * int)
	 */
	public List getListAddrTel(String entidad, int idAddress) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List result = new ArrayList();
		BBDDUtils bbddUtils = new BBDDUtils();
		try {

			con = bbddUtils.getConnection(entidad);
			ps = con.prepareStatement("select * from scr_addrtel where id="
					+ idAddress);
			rs = ps.executeQuery();

			while (rs.next()) {
				ScrAddrtel scrAddrtel = new ScrAddrtel();
				scrAddrtel.setId(rs.getInt("id"));
				scrAddrtel.setAddress(rs.getString("address"));
				scrAddrtel.setPreference(rs.getInt("preference"));

				result.add(scrAddrtel);
			}

		} catch (Exception e) {
			log.warn("Resulta imposible obtener la direcci�n de correo: "
					+ idAddress, e);
		} finally {
			bbddUtils.close(ps);
			bbddUtils.close(rs);
			bbddUtils.close(con);

		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#findAxSFToCloseSentence
	 * (String, String)
	 */
	public String findAxSFToCloseSentence(String tableName, String filter) {

		String where = createWhereClausule(null, null, filter, false);

		String sentence = MessageFormat.format(AXSF_FINDALL_SENTENCE,
				new String[] { tableName, where });

		if (log.isDebugEnabled()) {
			log.debug("findAxSFToCloseSentence QUERY :" + sentence);
		}

		return sentence;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#updateUserConfigIdOficPref
	 * (Integer, Integer, String)
	 */
	public void updateUserConfigIdOficPref(Integer idUser, Integer idOficPref,
			String entidad) {
		PreparedStatement statement = null;
		Connection connection = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		int idOP = idOficPref == null ? 0 : idOficPref.intValue();

		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection
					.prepareStatement(UPDATE_USER_CONFIG_IDOFICPREF);
			statement.setInt(1, idOP);
			statement.setInt(2, idUser.intValue());
			statement.executeUpdate();

			log.info("USER_OFIC_PREF: " + idUser.intValue() + " " + idOP);

		} catch (SQLException e) {
			log
					.warn(
							"Resulta imposible actualizar la oficina preferente del usuario.",
							e);
		} catch (Throwable e) {
			log
					.warn(
							"Resulta imposible actualizar la oficina preferente del usuario.",
							e);
		} finally {
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getScrRegisterInter(Integer
	 * , int, boolean, String)
	 */
	public List getScrRegisterInter(Integer bookId, int fdrid,
			boolean orderByOrd, String entidad) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		ScrRegisterInter scrRegisterInter = null;
		List scrRegInts = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		try {
			connection = bbddUtils.getConnection(entidad);
			String query = SELECT_SCR_REGINT;
			if (orderByOrd) {
				query = query + ORDER_SCR_REGINT;
			}
			statement = connection.prepareStatement(query);
			statement.setInt(1, bookId.intValue());
			statement.setInt(2, fdrid);
			resultSet = statement.executeQuery();

			scrRegInts = new ArrayList();
			while (resultSet.next()) {
				scrRegisterInter = new ScrRegisterInter();
				scrRegisterInter.setId(new Integer(resultSet.getInt(1)));
				scrRegisterInter.setArchId(new Integer(resultSet.getInt(2)));
				scrRegisterInter.setFdrId(new Integer(resultSet.getInt(3)));
				scrRegisterInter.setName(resultSet.getString(4));
				scrRegisterInter.setPersonId(new Integer(resultSet.getInt(5)));
				scrRegisterInter.setAddressId(new Integer(resultSet.getInt(6)));
				scrRegisterInter.setOrder(new Integer(resultSet.getInt(7)));
				scrRegInts.add(scrRegisterInter);
			}

		} catch (SQLException e) {
			log.warn("Error ejecutando SELECT_SCR_REGINT [" + SELECT_SCR_REGINT
					+ "]", e);
		} catch (Throwable e) {
			log.warn("Error ejecutando SELECT_SCR_REGINT [" + SELECT_SCR_REGINT
					+ "]", e);
		} finally {
			bbddUtils.close(resultSet);
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}

		return scrRegInts;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.ieci.tecdoc.common.entity.dao.DBEntityDAO#insertScrRegInt(int,
	 * int, int, String, int, int, int, String)
	 */
	public int insertScrRegInt(int id, int archId, int fdrId, String name,
			int personId, int addressId, int ord, String entidad)
			throws SQLException {
		PreparedStatement statement = null;
		Connection connection = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection.prepareStatement(INSERT_SCR_REGINT);
			statement.setInt(1, id);
			statement.setInt(2, archId);
			statement.setInt(3, fdrId);
			statement.setString(4, name);
			statement.setInt(5, personId);
			if (addressId != 0) {
				statement.setInt(6, addressId);
			} else {
				statement.setNull(6, Types.INTEGER);
			}
			statement.setInt(7, ord);

			statement.executeUpdate();
		} catch (SQLException e) {
			log.warn("Resulta imposible insertar scr_regint ["
					+ INSERT_SCR_REGINT + "]", e);
			throw e;
		} catch (Throwable e) {
			log.warn("Resulta imposible insertar scr_regint ["
					+ INSERT_SCR_REGINT + "]", e);
			throw new SQLException(e.getMessage());
		} finally {
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}

		return 1;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.ieci.tecdoc.common.entity.dao.DBEntityDAO#deleteScrRegInt(int,
	 * int, String)
	 */
	public void deleteScrRegInt(int bookId, int fdrId, String entidad)
			throws SQLException {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection.prepareStatement(DELETE_SCR_REGINT);
			statement.setInt(1, bookId);
			statement.setInt(2, fdrId);
			statement.executeUpdate();

		} catch (SQLException e) {
			log.warn("Resulta imposible eliminar los campos persistentes ["
					+ DELETE_SCR_REGINT + "]", e);
			throw e;
		} catch (Throwable e) {
			log.warn("Resulta imposible eliminar los campos persistentes ["
					+ DELETE_SCR_REGINT + "]", e);
			throw new SQLException(e.getMessage());
		} finally {
			bbddUtils.close(resultSet);
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getDescriptionByLocale(
	 * Integer, boolean, boolean, String, String, String)
	 */
	public String getDescriptionByLocale(Integer id, boolean isScrTypeAdm,
			boolean isScrCa, String language, String tableNameAux,
			String entidad) throws SQLException {
		Statement statement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		String selectSentence = null;
		String description = null;
		String tableName = null;
		if (!language.equals("ca")) {
			tableName = tableNameAux + language.toUpperCase();
		} else {
			tableName = tableNameAux + "CT";
		}

		try {
			if (isScrTypeAdm) {
				selectSentence = "SELECT DESCRIPTION FROM " + tableName
						+ " WHERE  id=" + id;
			} else if (isScrCa) {
				selectSentence = "SELECT MATTER FROM " + tableName
						+ " WHERE  id=" + id;
			} else {
				selectSentence = "SELECT NAME FROM " + tableName
						+ " WHERE  id=" + id;
			}

			connection = bbddUtils.getConnection(entidad);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectSentence);

			if (resultSet.next()) {
				description = resultSet.getString(1);
			}
		} catch (SQLException e) {
			log.warn("Error ejecutando [" + selectSentence + "]", e);
			throw e;
		} catch (Throwable e) {
			log.warn("Error ejecutando [" + selectSentence + "]", e);
			throw new SQLException("Error ejecutando [" + selectSentence + "]");
		} finally {
			bbddUtils.close(resultSet);
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}
		return description;

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getReportsListByLocale(int,
	 * int, String, String, String)
	 */
	public List getReportsListByLocale(int reportType, int bookType,
			String language, String tableNameAux, String entidad)
			throws SQLException {
		Statement statement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		List scrReportList = new ArrayList();
		BBDDUtils bbddUtils = new BBDDUtils();
		String selectSentence = null;
		String tableName = null;
		if (!language.equals("ca")) {
			tableName = tableNameAux + language.toUpperCase();
		} else {
			tableName = tableNameAux + "CT";
		}

		try {
			selectSentence = "SELECT * FROM " + tableName
					+ " WHERE  TYPE_REPORT=" + reportType + " AND TYPE_ARCH="
					+ bookType;

			connection = bbddUtils.getConnection(entidad);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectSentence);

			while (resultSet.next()) {
				ScrReport scrReport = new ScrReport();
				scrReport.setId(new Integer(resultSet.getInt(1)));
				scrReport.setTypeReport(resultSet.getInt(3));
				scrReport.setTypeArch(resultSet.getInt(4));
				scrReport.setAllArch(resultSet.getInt(5));
				scrReport.setAllOfics(resultSet.getInt(6));
				scrReport.setAllPerfs(resultSet.getInt(7));
				scrReport.setDescription(resultSet.getString(8));
				scrReportList.add(scrReport);
			}
		} catch (SQLException e) {
			log.warn("Error ejecutando [" + selectSentence + "]", e);
			throw e;
		} catch (Throwable e) {
			log.warn("Error ejecutando [" + selectSentence + "]", e);
			throw new SQLException("Error ejecutando [" + selectSentence + "]");
		} finally {
			bbddUtils.close(resultSet);
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}
		return scrReportList;

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getIdocvtblctlg(int,
	 * String, String, String)
	 */
	public Idocvtblctlg getIdocvtblctlg(int id, String language,
			String tableNameAux, String entidad) throws SQLException {
		Statement statement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		Idocvtblctlg idocvtblctlg = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		String selectSentence = null;
		String tableName = null;
		if (!language.equals("ca")) {
			tableName = tableNameAux + language.toUpperCase();
		} else {
			tableName = tableNameAux + "CT";
		}

		try {
			selectSentence = "SELECT * FROM " + tableName + " WHERE  ID=" + id;

			connection = bbddUtils.getConnection(entidad);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectSentence);

			if (resultSet.next()) {
				idocvtblctlg = new Idocvtblctlg();
				idocvtblctlg.setId(new Integer(resultSet.getInt(1)));
				idocvtblctlg.setName(resultSet.getString(2));
				idocvtblctlg.setBtblid(resultSet.getInt(3));
				idocvtblctlg.setType(resultSet.getInt(4));
				idocvtblctlg.setInfo(resultSet.getString(5));
				idocvtblctlg.setFlags(resultSet.getInt(6));
				idocvtblctlg.setRemarks(resultSet.getString(7));
				idocvtblctlg.setCrtrid(resultSet.getInt(8));
			}
		} catch (SQLException e) {
			log.warn("Error ejecutando [" + selectSentence + "]", e);
			throw e;
		} catch (Throwable e) {
			log.warn("Error ejecutando [" + selectSentence + "]", e);
			throw new SQLException("Error ejecutando [" + selectSentence + "]");
		} finally {
			bbddUtils.close(resultSet);
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}
		return idocvtblctlg;

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getDocUID(Integer,
	 * Integer, Integer, String)
	 */
	public String getDocUID(Integer bookId, Integer fdrId, Integer pageId,
			String entidad) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		String docUID = "";
		BBDDUtils bbddUtils = new BBDDUtils();
		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection.prepareStatement(SELECT_SCR_PAGEREPOSITORY);
			statement.setInt(1, bookId.intValue());
			statement.setInt(2, fdrId.intValue());
			statement.setInt(3, pageId.intValue());
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				docUID = resultSet.getString(1);
			}

			log.info(" docUID:" + docUID);

		} catch (SQLException e) {
			log.warn(
					"Resulta imposible obtener el DOCUID del documento con bookId= "
							+ bookId.intValue() + "fdrId= " + fdrId.intValue()
							+ "pageId= " + pageId.intValue(), e);
		} catch (Throwable e) {
			log.warn(
					"Resulta imposible obtener el DOCUID del documento con bookId= "
							+ bookId.intValue() + "fdrId= " + fdrId.intValue()
							+ "pageId= " + pageId.intValue(), e);
		} finally {
			bbddUtils.close(resultSet);
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}

		return docUID;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#insertScrPageRepository
	 * (int, int, int, String, String)
	 */
	public int insertScrPageRepository(int bookID, int fdrID, int pageID,
			String docUID, String entidad) throws SQLException {
		PreparedStatement statement = null;
		Connection connection = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection.prepareStatement(INSERT_SCR_PAGEREPOSITORY);
			statement.setInt(1, bookID);
			statement.setInt(2, fdrID);
			statement.setInt(3, pageID);
			statement.setString(4, docUID);

			statement.executeUpdate();
		} catch (SQLException e) {
			log.warn("Resulta imposible insertar scr_pagerepository ["
					+ INSERT_SCR_PAGEREPOSITORY + "]", e);
			throw e;
		} catch (Throwable e) {
			log.warn("Resulta imposible insertar scr_pagerepository ["
					+ INSERT_SCR_PAGEREPOSITORY + "]", e);
			throw new SQLException(e.getMessage());
		} finally {
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}

		return 1;
	}

	public String getDocumentRepositoryUID(String isicresDocUID, String entidad)
			throws SQLException {
		PreparedStatement statement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		String documentRepositoryUID = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection
					.prepareStatement(SELECT_REPOSITORY_DOCUMENT_ID);
			statement.setInt(1, Integer.parseInt(isicresDocUID));
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				documentRepositoryUID = resultSet.getString(1);
			}

		} catch (SQLException e) {
			log.warn("Resulta imposible ejecutar ["
					+ SELECT_REPOSITORY_DOCUMENT_ID + "]", e);
			throw e;
		} catch (Throwable e) {
			log.warn("Resulta imposible ejecutat ["
					+ SELECT_REPOSITORY_DOCUMENT_ID + "]", e);
			throw new SQLException(e.getMessage());
		} finally {
			bbddUtils.close(resultSet);
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}
		return documentRepositoryUID;

	}

	public String insertScrDocumentRepository(String documentRepositoryUID,
			String entidad) throws SQLException {
		PreparedStatement statement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		String isicresDocUID = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection
					.prepareStatement(SELECT_NEXT_ID_SCR_DOCUMENTREPOSITORY);
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				isicresDocUID = String.valueOf(resultSet.getInt(1));
			}

		} catch (SQLException e) {
			log.warn("Resulta imposible ejecutar ["
					+ SELECT_NEXT_ID_SCR_DOCUMENTREPOSITORY + "]", e);
			throw e;
		} catch (Throwable e) {
			log.warn("Resulta imposible ejecutar ["
					+ SELECT_NEXT_ID_SCR_DOCUMENTREPOSITORY + "]", e);
			throw new SQLException(e.getMessage());
		} finally {
			bbddUtils.close(resultSet);
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}

		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection
					.prepareStatement(INSERT_SCR_DOCUMENTREPOSITORY);
			statement.setInt(1, Integer.parseInt(isicresDocUID));
			statement.setString(2, documentRepositoryUID);
			statement.executeUpdate();
		} catch (SQLException e) {
			log.warn("Resulta imposible ejecutar ["
					+ INSERT_SCR_DOCUMENTREPOSITORY + "]", e);
			throw e;
		} catch (Throwable e) {
			log.warn("Resulta imposible ejecutar ["
					+ INSERT_SCR_DOCUMENTREPOSITORY + "]", e);
			throw new SQLException(e.getMessage());
		} finally {
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}
		return isicresDocUID;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getRepositoryByBookType
	 * (java.lang.Integer, java.lang.String)
	 */
	public Integer getRepositoryByBookType(Integer bookType, String entidad)
			throws SQLException {
		PreparedStatement statement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		Integer result = null;

		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection
					.prepareStatement(SELECT_REPOSITORY_BOOK_TYPE);
			statement.setInt(1, bookType.intValue());
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				result = new Integer(resultSet.getInt(1));
			}

			bbddUtils.close(resultSet);
		} catch (SQLException e) {
			log.warn("Resulta imposible ejecutar ["
					+ SELECT_NEXT_ID_SCR_DOCUMENTREPOSITORY + "]", e);
			throw e;
		} catch (Throwable e) {
			log.warn("Resulta imposible ejecutar ["
					+ SELECT_NEXT_ID_SCR_DOCUMENTREPOSITORY + "]", e);
			throw new SQLException(e.getMessage());
		} finally {
			bbddUtils.close(resultSet);
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getRepositoryConfiguration
	 * (java.lang.Integer, java.lang.String)
	 */
	public String getRepositoryConfiguration(Integer id, String entidad)
			throws SQLException {
		PreparedStatement statement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		String result = null;

		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection
					.prepareStatement(SELECT_REPOSITORY_CONFIGURATION_DATA);
			statement.setInt(1, id.intValue());
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				result = resultSet.getString(1);
			}

		} catch (SQLException e) {
			log.warn("Resulta imposible ejecutar ["
					+ SELECT_NEXT_ID_SCR_DOCUMENTREPOSITORY + "]", e);
			throw e;
		} catch (Throwable e) {
			log.warn("Resulta imposible ejecutar ["
					+ SELECT_NEXT_ID_SCR_DOCUMENTREPOSITORY + "]", e);
			throw new SQLException(e.getMessage());
		} finally {
			bbddUtils.close(resultSet);
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#insertScrDocLocator(int,
	 * int, int, String, String)
	 */
	public int insertScrDocLocator(int bookId, int folderId, int pageID,
			String locator, String entidad) throws SQLException {

		PreparedStatement statement = null;
		Connection connection = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection.prepareStatement(INSERT_SCR_DOCLOCATOR);
			statement.setInt(1, bookId);
			statement.setInt(2, folderId);
			statement.setInt(3, pageID);
			statement.setString(4, locator);

			statement.executeUpdate();
		} catch (SQLException e) {
			log.warn("Resulta imposible insertar scr_doclocator ["
					+ INSERT_SCR_DOCLOCATOR + "]", e);
			throw e;
		} catch (Throwable e) {
			log.warn("Resulta imposible insertar scr_doclocator ["
					+ INSERT_SCR_DOCLOCATOR + "]", e);
			throw new SQLException(e.getMessage());
		} finally {
			bbddUtils.close(statement);
			bbddUtils.close(connection);
		}

		return 1;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ieci.tecdoc.common.entity.dao.DBEntityDAO#getMaxDateClose(Integer,
	 * String, Integer)
	 */
	public Timestamp getMaxDateClose(Integer bookId, String entidad,
			Integer oficId) throws SQLException {
		Statement statement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		BBDDUtils bbddUtils = new BBDDUtils();
		Timestamp result = null;
		try {
			connection = bbddUtils.getConnection(entidad);
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT MAX(FLD2) FROM A"
					+ bookId.intValue() + "SF WHERE FLD6=5 and FLD5=" + oficId);

			if (resultSet.next()) {
				result = resultSet.getTimestamp(1);
			}
		} catch (SQLException e) {
			log.warn("Error ejecutando [SELECT MAX(FLD2) FROM A"
					+ bookId.intValue() + "SF WHERE FLD6=5 and FLD5=" + oficId
					+ " ]", e);
			throw e;
		} catch (Throwable e) {
			log.warn("Error ejecutando [SELECT MAX(FLD2) FROM A"
					+ bookId.intValue() + "SF WHERE FLD6=5]", e);
			throw new SQLException("Error ejecutando [SELECT MAX(FLD2) FROM A"
					+ bookId.intValue() + "SF WHERE FLD6=5 and FLD5=" + oficId
					+ " ]");
		} finally {
			bbddUtils.close(statement);
			bbddUtils.close(resultSet);
			bbddUtils.close(connection);
		}

		return result;
	}

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
