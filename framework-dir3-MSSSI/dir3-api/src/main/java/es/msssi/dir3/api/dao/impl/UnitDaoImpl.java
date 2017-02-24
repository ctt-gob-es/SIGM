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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;

import com.ibatis.sqlmap.engine.execution.SqlExecutor;

import es.msssi.dir3.api.dao.SqlMapClientBaseDao;
import es.msssi.dir3.api.dao.UnitDao;
import es.msssi.dir3.api.type.UOCriterionEnum;
import es.msssi.dir3.api.vo.BasicDataUnitVO;
import es.msssi.dir3.api.vo.Criteria;
import es.msssi.dir3.api.vo.Criterion;
import es.msssi.dir3.api.vo.UnitVO;
import es.msssi.dir3.core.vo.PageInfo;

/**
 * DAO de datos b�sicos de unidades org�nicas.
 * 
 * @author cmorenog
 * 
 */
public class UnitDaoImpl extends SqlMapClientBaseDao implements UnitDao {

    protected static final String COUNTFINDUNITS = "UnitVO.countFindUnits";
    protected static final String FINDUNITS = "UnitVO.findUnits";
    protected static final String GETUNIT = "UnitVO.getUnitVO";
    protected static final String EXISTSUNIT = "UnitVO.existsUnit";
    protected static final String INSERTUNIT = "UnitVO.addUnitVO";
    protected static final String UPDATEUNIT = "UnitVO.updateUnitVO";
    protected static final String FINDBASICDATAUNITS = "UnitVO.findBasicDataUnits";
    /**
     * Logger de la clase.
     */
    private static final Logger logger = Logger.getLogger(UnitDaoImpl.class);

    /**
     * Constructor.
     */
    public UnitDaoImpl() {
	super();
    }

    /**
     * Devuelve el n�mero de unidades org�nicas existentes que cumplan los
     * criterios introducidos.
     * 
     * @param criteria
     *            Criterios de b�squeda de tipo CriterioUnidadOrganicaEnum.
     * @return n�mero de unidades org�nicas.
     * @throws SQLException.
     */
    public int count(
	List<Criterion<UOCriterionEnum>> criteria)
	throws SQLException {
	int count = 0;
	// Comprobar si se han definido criterios
	if ((criteria == null) ||
	    CollectionUtils.isEmpty(criteria)) {
	    logger.info("Obteniendo el n�mero de unidades org�nicas sin criterios");
	    count = (Integer) getSqlMapClientTemplate().queryForObject(
		COUNTFINDUNITS);
	}
	else {
	    logger
		.info("Obteniendo el n�mero de unidades org�nicas en base a los siguientes criterios: {}");
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put(
		"criteria", criteria);

	    count = (Integer) getSqlMapClientTemplate().queryForObject(
		COUNTFINDUNITS, map);
	}
	return count;
    }

    /**
     * M�todo gen�rico para recuperar todas las unidades org�nicas y que cumplan
     * los criterios introducidos.
     * 
     * @param criteria
     *            Criterios de b�squeda de tipo CriterioUnidadOrganicaEnum.
     * @return la lista de unidades org�nicas.
     * @throws SQLException.
     */
    @SuppressWarnings("unchecked")
    public List<UnitVO> find(
	Criteria<UOCriterionEnum> criteria)
	throws SQLException {
	List<UnitVO> result;
	// Comprobar si se han definido criterios
	if (criteria == null) {
	    logger.info("Realizando b�squeda de unidades org�nicas sin criterios");
	    result = (List<UnitVO>) getSqlMapClientTemplate().queryForList(
		FINDUNITS);
	}
	else {
	    logger.info("Realizando b�squeda de unidades org�nicas en base a criterios: {}");

	    Map<String, Object> map = new HashMap<String, Object>();
	    if (!CollectionUtils.isEmpty(criteria.getCriteria())) {
		map.put(
		    "criteria", criteria.getCriteria());
	    }
	    if (!CollectionUtils.isEmpty(criteria.getOrderBy())) {
		map.put(
		    "orden", criteria.getOrderBy());
	    }

	    // Comprobar si hay que paginar los resultados
	    PageInfo pageInfo = criteria.getPageInfo();
	    if (pageInfo != null) {

		// N�mero de resultados a ignorar
		int skipResults = SqlExecutor.NO_SKIPPED_RESULTS;

		// N�mero m�ximo de resultados.
		int maxResults = SqlExecutor.NO_MAXIMUM_RESULTS;

		if ((pageInfo.getPageNumber() > 0) &&
		    (pageInfo.getObjectsPerPage() > 0)) {
		    skipResults = (pageInfo.getPageNumber() - 1) *
			pageInfo.getObjectsPerPage();
		    maxResults = pageInfo.getObjectsPerPage();
		}
		else if (pageInfo.getMaxNumItems() > 0) {
		    maxResults = pageInfo.getMaxNumItems();
		}

		// Obtener los resultados a mostrar en la p�gina
		result = (List<UnitVO>) getSqlMapClientTemplate().queryForList(
		    FINDUNITS, map, skipResults, maxResults);

	    }
	    else {
		result = (List<UnitVO>) getSqlMapClientTemplate().queryForList(
		    FINDUNITS, map);
	    }
	}
	return result;
    }

    /**
     * M�todo  para recuperar una unidad bas�ndonos en su identificador.
     * 
     * @param id
     *            identificador de la unidad org�nica a recuperar
     * @return unidade org�nica recuperado.
     * @throws SQLException.
     */
    public UnitVO get(
	String id)
	throws SQLException {
	logger.info("Obteniendo una unidad con el id: " +
	    id);
	UnitVO unit;
	unit = (UnitVO) getSqlMapClientTemplate().queryForObject(
	    GETUNIT, id);
	return unit;
    }

    /**
     * Comprueba la existencia de una unidad org�nica con el identificador dado.
     * 
     * @param id
     *            identificador de la unidade org�nica.
     * @return <code>true</code> si el objeto existe, <code>false</code> en caso
     *         contrario
     * @throws SQLException.
     */
    public boolean exists(
	String id)
	throws SQLException {
	logger.info("Obteniendo si existe una unidad con el id: " +
	    id);
	boolean exist = false;
	Integer count = (Integer) getSqlMapClientTemplate().queryForObject(
	    EXISTSUNIT, id);
	if (!Integer.valueOf(
	    0).equals(
	    count)) {
	    exist = true;
	}
	return exist;
    }

    /**
     * M�todo para guardar una unidad org�nica. 
     * 
     * @param entity
     *            unidad org�nica a guardar.
     * @throws SQLException.
     */
    public void save(
	UnitVO entity)
	throws SQLException {
	logger.info("Guardar una unidad org�nica");
	getSqlMapClient().insert(
	    INSERTUNIT, entity);
    }

    /**
     * M�todo  para actualizar una unidad org�nica.
     * 
     * @param entity
     *            unidad org�nica a actualizar.
     * @throws SQLException.
     */
    public void update(
	UnitVO entity)
	throws SQLException {
	logger.info("Modifico una unidad org�nica");
	getSqlMapClient().update(
	    UPDATEUNIT, entity);
    }


    /**
     * M�todo  para recuperar los datos b�sicos de todas las unidades
     *  que cumplan los criterios introducidos.
     * 
     * @param criterios
     *            Criterios de b�squeda .
     * @return la lista de unidades.
     * @throws SQLException
     */
    @SuppressWarnings("unchecked")
    public List<BasicDataUnitVO> findBasicData(
	Criteria<UOCriterionEnum> criteria)
	throws SQLException {
	List<BasicDataUnitVO> result;
	// Comprobar si se han definido criterios
	if (criteria == null) {
	    logger
		.info("Realizando b�squeda de los datos b�sicos de unidades org�nicas sin criterios");
	    result = (List<BasicDataUnitVO>) getSqlMapClientTemplate().queryForList(
		FINDBASICDATAUNITS);
	}
	else {
	    logger
		.info("Realizando b�squeda de los datos b�sicos de unidades org�nicas en base a criterios: {}");

	    Map<String, Object> map = new HashMap<String, Object>();
	    if (!CollectionUtils.isEmpty(criteria.getCriteria())) {
		map.put(
		    "criteria", criteria.getCriteria());
	    }
	    if (!CollectionUtils.isEmpty(criteria.getOrderBy())) {
		map.put(
		    "orden", criteria.getOrderBy());
	    }

	    // Comprobar si hay que paginar los resultados
	    PageInfo pageInfo = criteria.getPageInfo();
	    if (pageInfo != null) {

		// N�mero de resultados a ignorar
		int skipResults = SqlExecutor.NO_SKIPPED_RESULTS;

		// N�mero m�ximo de resultados.
		int maxResults = SqlExecutor.NO_MAXIMUM_RESULTS;

		if ((pageInfo.getPageNumber() > 0) &&
		    (pageInfo.getObjectsPerPage() > 0)) {
		    skipResults = (pageInfo.getPageNumber() - 1) *
			pageInfo.getObjectsPerPage();
		    maxResults = pageInfo.getObjectsPerPage();
		}
		else if (pageInfo.getMaxNumItems() > 0) {
		    maxResults = pageInfo.getMaxNumItems();
		}

		// Obtener los resultados a mostrar en la p�gina
		result = (List<BasicDataUnitVO>) getSqlMapClientTemplate().queryForList(
		    FINDBASICDATAUNITS, map, skipResults, maxResults);

	    }
	    else {
		result = (List<BasicDataUnitVO>) getSqlMapClientTemplate().queryForList(
		    FINDBASICDATAUNITS, map);
	    }
	}
	return result;
    }

}
