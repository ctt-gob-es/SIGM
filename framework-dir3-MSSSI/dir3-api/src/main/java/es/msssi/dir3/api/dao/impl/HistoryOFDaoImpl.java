/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.dir3.api.dao.impl;

import java.sql.SQLException;
import java.util.Map;

import org.apache.log4j.Logger;

import es.msssi.dir3.api.dao.HistoryDao;
import es.msssi.dir3.api.dao.SqlMapClientBaseDao;
import es.msssi.dir3.api.vo.HistoryVO;

/**
 * DAO de datos b�sicos de hist�rico de oficinas.
 * 
 * @author cmorenog
 * 
 */
public class HistoryOFDaoImpl extends SqlMapClientBaseDao implements HistoryDao {

    /**
     * Nombre de la query
     * */
    protected static final String GETHISTORY = "HistoryVO.getHistoryOFVO";
    protected static final String INSERTHISTORY = "HistoryVO.addHistoryOFVO";
    protected static final String UPDATEHISTORY = "HistoryVO.updateHistoryOFVO";
    protected static final String GETCAUSE = "HistoryVO.getCauseVO";
    protected static final String EXISTS = "HistoryVO.getExistsOFVO";

    /**
     * Logger de la clase.
     */
    private static final Logger logger = Logger.getLogger(HistoryOFDaoImpl.class);

    /**
     * Constructor.
     * 
     */
    public HistoryOFDaoImpl() {
	super();
    }

    /**
     * M�todo  para recuperar un hist�rico bas�ndonos en su
     * identificador.
     * 
     * @param ids
     *            identificadores del hist�rico: previousId y lastId.
     * @return el hist�rico recuperado.
     * @throws SQLException.
     */
    public HistoryVO get(
	Map<String,String> ids)
	throws SQLException {
	logger.info("Obteniendo el hist�rico con el id ultimo: " +
	    ids.get("lastId") +" ; id antiguo: "+  ids.get("previousId"));
	HistoryVO history;
	history = (HistoryVO) getSqlMapClientTemplate().queryForObject(
	    GETHISTORY, ids);

	return history;
    }

    /**
     * Comprueba la existencia de un hist�rico con el identificador dado.
     * 
     * @param ids
     *            identificadores del hist�rico: previousId y lastId.
     * @return <code>true</code> si el objeto existe, <code>false</code> en caso
     *         contrario.
     * @throws SQLException .
     */
    public boolean exists(
	Map<String,String> ids)
	throws SQLException {
	logger.info("Obteniendo si existe un hist�rico con el id ultimo: " +
	    ids.get("lastId") +" ; id antiguo: "+  ids.get("previousId"));
	boolean exist = false;
	String exists = null;
	exists = (String) getSqlMapClientTemplate().queryForObject(
	    EXISTS, ids);
	if (exists != null) {
	    exist = true;
	}
	return exist;
    }

    /**
     * M�todo  para guardar un hist�rico.
     * 
     * @param entity
     *            hist�rico a guardar.
     * @throws SQLException.
     */
    public void save(
	HistoryVO entity)
	throws SQLException {
	logger.info("Guardar un hist�rico");
	getSqlMapClient().insert(
	    INSERTHISTORY, entity);
    }

    /**
     * M�todo  para actualizar un hist�rico de la clase dada.
     * 
     * @param entity
     *            hist�rico a actualizar.
     * @throws SQLException.
     */
    public void update(
	HistoryVO entity)
	throws SQLException {
	logger.info("Modifico un hist�rico:" +
	    entity.getId());
	getSqlMapClient().update(
	    UPDATEHISTORY, entity);
    }

    /**
     * Devuelve el c�digo de la causa de baja que corresponde a la descripci�n
     * que entra como par�metro.
     * 
     * @param cause
     *            descripci�n de la causa.
     * @return C�digo de la causa de baja.
     * @throws SQLException
     */
    public String getCauseId(
	String cause)
	throws SQLException {
	logger.info("Cojo el id de la causa de baja:" +
	    cause);
	String code = null;
	code = (String) getSqlMapClientTemplate().queryForObject(
	    GETCAUSE, cause);
	return code;
    }


}
