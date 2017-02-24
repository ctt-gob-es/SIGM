/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.sgm.registropresencial.dao;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import es.msssi.sgm.registropresencial.errors.ErrorConstants;


/**
 * Clase que implementa utilizadas de SqlMapClientDaoSupport.
 * 
 * @author cmorenog
 * 
 */
public class SqlMapClientBaseDao extends SqlMapClientDaoSupport {
    /**
     * Logger de la clase.
     */
    private static final Logger logger = Logger.getLogger(SqlMapClientBaseDao.class);

    /**
     * Inicio de una transacci�n.
     * 
     * @throws SQLException.
     */
    public void startTransaction()
	throws SQLException {
	try {
	    getSqlMapClient().startTransaction();
	}
	catch (SQLException sqlException) {
	    logger.error(
		ErrorConstants.START_TRANSACTION_ERROR, sqlException);
	    throw sqlException;
	}
    }

    /**
     * Commit de una transacci�n.
     * 
     * @throws SQLException.
     */
    public void commitTransaction()
	throws SQLException {
	try {
	    getSqlMapClient().commitTransaction();
	}
	catch (SQLException sqlException) {
	    logger.error(
		ErrorConstants.COMMIT_TRANSACTION_ERROR, sqlException);
	}
    }

    /**
     * Fin de una transacci�n.
     * 
     * @throws SQLException.
     */
    public void endTransaction() {
	try {
	    getSqlMapClient().endTransaction();
	}
	catch (SQLException sqlException) {
	    logger.error(
		ErrorConstants.END_TRANSACTION_ERROR, sqlException);
	}
    }

}
