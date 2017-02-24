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
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import es.msssi.dir3.api.dao.RelationshipDao;
import es.msssi.dir3.api.dao.SqlMapClientBaseDao;
import es.msssi.dir3.api.vo.RelationshipOFIUOVO;

/**
 * DAO de datos b�sicos de una relaci�n org�nica de oficinas y unidades.
 * 
 * @author cmorenog
 * 
 */
public class RelationshipOFIUOORGDaoImpl extends SqlMapClientBaseDao implements RelationshipDao {

    /**
     * Nombre de la query.
     * */
    protected static final String GETRELATION = "RelationshipOFIUOVO.getRelationshipORGVO";
    protected static final String INSERTRELATION = "RelationshipOFIUOVO.addRelationshipORGVO";
    protected static final String UPDATERELATION = "RelationshipOFIUOVO.updateRelationshipORGVO";
    protected static final String EXISTS = "RelationshipOFIUOVO.getExistsRelationshipORGVO";

    
    /**
     * Logger de la clase.
     */
    private static final Logger logger = Logger.getLogger(RelationshipOFIUOORGDaoImpl.class);

    /**
     * Constructor.
     * 
     */
    public RelationshipOFIUOORGDaoImpl() {
	super();
    }

    /**
     * M�todo gen�rico para recuperar una relaci�n org�nica bas�ndonos en su
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
	logger.info("Obteniendo una relaci�n org�nica con el id");
	RelationshipOFIUOVO rel;
	rel = (RelationshipOFIUOVO) getSqlMapClientTemplate().queryForObject(
	    GETRELATION, ids);

	return rel;
    }

    /**
     * Comprueba la existencia de una relaci�n org�nica con el identificador
     * dado.
     * 
     * @param ids
     *          identificadores de la relaci�n, officeId y unitId.
     * @return <code>true</code> si el objeto existe, <code>false</code> en caso
     *         contrario
     * @throws SQLException.
     */
    public boolean exists(
	Map<String, String> ids)
	throws SQLException {
	logger.info("Obteniendo si existe una relaci�n org�nica" );
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
     * M�todo para guardar una relaci�n org�nica.
     * 
     * @param entity
     *            relaci�n a guardar.
     * @throws SQLException.
     */
    public void save(
	RelationshipOFIUOVO entity)
	throws SQLException {
	logger.info("Guardar una relaci�n org�nica");
	getSqlMapClient().insert(
	    INSERTRELATION, entity);
    }

    /**
     * M�todo para actualizar una relaci�n org�nica de la clase dada.
     * 
     * @param entity
     *            relaci�n a actualizar.
     * @throws SQLException.
     */
    public void update(
	RelationshipOFIUOVO entity)
	throws SQLException {
	logger.info("Modifico una relaci�n org�nica:" +
	    entity.getId());
	getSqlMapClient().update(
	    UPDATERELATION, entity);
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
    public boolean isSIR(
	    RelationshipOFIUOVO entity)
	throws SQLException {
	logger.info("Obteniendo si una una relaci�n es SIR");
	boolean exist = true;
	
	return exist;
    }

    public List<RelationshipOFIUOVO> getUnitDir(String idEntity) {
	// TODO Auto-generated method stub
	return null;
    }
}
