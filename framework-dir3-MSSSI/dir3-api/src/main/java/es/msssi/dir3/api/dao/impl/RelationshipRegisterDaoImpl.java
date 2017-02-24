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

import es.msssi.dir3.api.dao.RelationshipRegisterDao;
import es.msssi.dir3.api.dao.SqlMapClientBaseDao;
import es.msssi.dir3.api.vo.RelationshipOFIUOVO;
import es.msssi.dir3.core.vo.UnidadRegistralVO;
import es.msssi.dir3.core.vo.UnitRegistro;

/**
 * DAO de datos b�sicos de una relaci�n sir de oficinas y unidades.
 * 
 * @author cmorenog
 * 
 */
public class RelationshipRegisterDaoImpl extends SqlMapClientBaseDao implements RelationshipRegisterDao {

    /**
     * Nombre de la query.
     * */
    protected static final String GETRELATION = "RelationshipRegistroVO.getRelationshipSIRRegistroVO";
    protected static final String INSERTRELATION = "RelationshipRegistroVO.addRelationshipSIRRegistroVO";
    protected static final String UPDATERELATION = "RelationshipRegistroVO.updateRelationshipSIRRegistroVO";
    protected static final String DELETERELATION = "RelationshipRegistroVO.deleteRelationshipSIRRegistroVO";
    protected static final String EXISTS = "RelationshipRegistroVO.getExistsRelationshipSIRRegistroVO";
    protected static final String GETIDUNITTARM = "RelationshipRegistroVO.idOrgCodeTram";
    /**
     * Logger de la clase.
     */
    private static final Logger logger = Logger.getLogger(RelationshipRegisterDaoImpl.class);
   

    /**
     * Constructor.
     * 
     */
    public RelationshipRegisterDaoImpl() {
	super();
    }

    /**
     * M�todo gen�rico para recuperar una relaci�n SIR bas�ndonos en su
     * identificador.
     * 
     * @param ids
     *             identificadores de la relaci�n, officeId y unitId.
     * @return el objeto recuperado.
     * @throws SQLException.
     */
    public RelationshipOFIUOVO get(
	Map<String, String> ids)
	throws SQLException {
	logger.info("Obteniendo una relaci�n SIR: ");
	RelationshipOFIUOVO rel;
	rel = (RelationshipOFIUOVO) getSqlMapClientTemplate().queryForObject(
	    GETRELATION, ids);

	return rel;
    }

    /**
     * Comprueba la existencia de una relaci�n SIR con el identificador dado.
     * 
     * @param ids
     *            identificadores de la relaci�n, officeId y unitId.
     * @return <code>true</code> si el objeto existe, <code>false</code> en caso
     *         contrario.
     * @throws SQLException .
     */
    public boolean exists(
	Map<String, String> ids)
	throws SQLException {
	logger.info("Obteniendo si existe una relaci�n SIR");
	boolean exist = false;
	String rel;
	rel = (String) getSqlMapClientTemplate().queryForObject(
	    EXISTS, ids);
	if (rel != null) {
	    exist = true;
	}
	return exist;
    }

    /**
     * M�todo  para guardar una relaci�n SIR.
     * 
     * @param entity
     *            relaci�n a guardar.
     * @throws SQLException.
     */
    public void save(
	RelationshipOFIUOVO entity)
	throws SQLException {
	logger.info("Guardar una relaci�n SIR");
	UnidadRegistralVO registro =  mappingUnidadRegistral (entity);
	if(registro.getCode_tramunit() != null){
	    Object obj = getSqlMapClient().queryForObject(GETIDUNITTARM,registro.getCode_tramunit());
	    if (obj != null) {
		registro.setId_orgs((Integer) obj);
		getSqlMapClient().insert(
			    INSERTRELATION, registro);
	    }
	}
	
    }

    /**
     * M�todo gen�rico para actualizar una relaci�n SIR de la clase dada.
     * 
     * @param entity
     *            objeto a actualizar.
     * @throws SQLException.
     */
    public void update(
	RelationshipOFIUOVO entity)
	throws SQLException {
	logger.info("Modifico una relaci�n SIR:" +
	    entity.getId());
	UnidadRegistralVO registro =  mappingUnidadRegistral (entity);
	if(registro.getCode_tramunit() != null){
	    Object obj = getSqlMapClient().queryForObject(GETIDUNITTARM,registro.getCode_tramunit());
	    if (obj != null) {
		registro.setId_orgs((Integer) obj);
		getSqlMapClient().insert(
			    INSERTRELATION, registro);
	    }
	}
	getSqlMapClient().update(
	    UPDATERELATION, registro);
    }

    /**
     * M�todo gen�rico para borrar una relaci�n SIR de la clase dada.
     * 
     * @param entity
     *            objeto a actualizar.
     * @throws SQLException.
     */
    public void delete(
	    RelationshipOFIUOVO entity)
	throws SQLException {
	logger.info("Modifico una relaci�n SIR:" +
	    entity.getId());
	getSqlMapClient().update(
	    DELETERELATION, mappingUnidadRegistral(entity));
    }
    
    private UnidadRegistralVO mappingUnidadRegistral (RelationshipOFIUOVO entity){
	UnidadRegistralVO result = new UnidadRegistralVO();
	result.setCode_entity(entity.getOfficeId());
	result.setCode_tramunit(entity.getUnitId());
	result.setName_entity(entity.getOfficeName());
	result.setName_tramunit(entity.getUnitName());
	return result;
    }

}
