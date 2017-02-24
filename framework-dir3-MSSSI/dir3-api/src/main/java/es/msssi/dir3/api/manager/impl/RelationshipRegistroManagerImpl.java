/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.dir3.api.manager.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

import es.msssi.dir3.api.dao.RelationshipDao;
import es.msssi.dir3.api.dao.RelationshipRegisterDao;
import es.msssi.dir3.api.manager.RelationshipRegistroManager;
import es.msssi.dir3.api.vo.RelationshipOFIUOVO;
import es.msssi.dir3.api.vo.RelationshipsOFIUOVO;
import es.msssi.dir3.api.vo.ServiceVO;
import es.msssi.dir3.api.vo.ServicesVO;
import es.msssi.dir3.core.errors.DIR3ErrorCode;
import es.msssi.dir3.core.errors.DIR3Exception;
import es.msssi.dir3.core.errors.ErrorConstants;

/**
 * Implementaci�n del manager de la relaciones entre oficinas y unidades.
 * 
 * @author cmorenog
 * 
 */
public class RelationshipRegistroManagerImpl implements RelationshipRegistroManager, Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -1647188278639651806L;
    /**
     * Logger de la clase.
     */
    private static final Logger LOG = Logger.getLogger(RelationshipRegistroManagerImpl.class);
    private RelationshipRegisterDao relationshipDao;
    private RelationshipDao relationshipSIRDao;
    /**
     * Constructor.
     * 
     */
    public RelationshipRegistroManagerImpl() {

    }

    /**
     * Actualiza o inserta los datos de las relaciones obtenidas del DCO.
     * 
     * @param relationshipsVO
     *            listado de relaciones a actualizar.
     * @throws DIR3Exception .
     */
    public void updateRelationships(
	RelationshipsOFIUOVO relationshipsVO, ServicesVO servicesDCO)
	throws DIR3Exception {
	if (relationshipsVO != null) {
	    Map<String, String> ids = null;
	    for (RelationshipOFIUOVO relation : relationshipsVO.getRelationships()) {
		try{
    		ids = new HashMap<String, String>();
    		ids.put(
    		    "unitId", relation.getUnitId());
    		ids.put(
    		    "officeId", relation.getOfficeId());
    		boolean exist = exists(ids);
    		if (exist) {
    		    if (relation.getStatus().equals("E")){
			delete (relation);
		    } else {
			if (!isSIR(relation)){
			    delete (relation);
			}else {
    		    		update(relation);
			}
		    }
    		}
    		else {
    		    delete (relation);
    		    if (!relation.getStatus().equals("E")){
    			if (isSIR(relation)){
    			    save(relation);
    			}
    		    }
    		   }
		}catch(DIR3Exception exception){
		    LOG.error(
			    ErrorConstants.INSERT_RELATIONSHIP_ERROR_MESSAGE +
				"OfficeId:" + relation.getOfficeId() + " UnitId:" +
				relation.getUnitId() + "; ", exception);
		}
	    }
	}
	if (servicesDCO != null) {
	    RelationshipOFIUOVO relation = null;
	    for (ServiceVO service : servicesDCO.getServices()) {
		relation = new RelationshipOFIUOVO();
		relation.setOfficeId(service.getOfficeId());
		if (!isSIR(relation)){
		    delete (relation);
		} else {
		    List<RelationshipOFIUOVO> relations = null;
		    relations =  getUnitsDir(service.getOfficeId());
		    Map<String, String> ids = null;
		    for (RelationshipOFIUOVO rel :relations){
			ids = new HashMap <String, String>();
			ids.put("unitId", rel.getUnitId());
			ids.put("officeId", rel.getOfficeId());
			if (!exists(ids)){
			    save (rel);
			}
			
		    }
		}
	    }
	}

    }

    /**
     * Inserta una relaci�n.
     * 
     * @param relaci�n
     *            relaci�n a insertar.
     * @throws DIR3Exception
     * 
     */
    public void save(
	RelationshipOFIUOVO relation)
	throws DIR3Exception {
	try {
	    if (relation != null) {
		relationshipDao.startTransaction();
		relationshipDao.save(relation);
		relationshipDao.commitTransaction();
	    }
	}
	catch (SQLException sqlException) {
	    LOG.error(
		ErrorConstants.INSERT_RELATIONSHIP_ERROR_MESSAGE, sqlException);
	    LOG.error("ERROR Insertando la relaci�n: unitId" +
		    relation.getUnitId() + "; officeId: " + relation.getOfficeId());
	/*    throw new DIR3Exception(
		DIR3ErrorCode.INSERT_RELATIONSHIP_ERROR,
		ErrorConstants.INSERT_RELATIONSHIP_ERROR_MESSAGE, sqlException);*/
	}
	finally {
	    relationshipDao.endTransaction();
	}
    }

    /**
     * Comprueba si una relacion es SIR.
     * 
     * @param relaci�n
     *            relaci�n a comprobar.
     * @throws DIR3Exception
     * 
     */
    public boolean isSIR(
	RelationshipOFIUOVO relation)
	throws DIR3Exception {
	boolean result = true;
	try {
	    if (relation != null) {
		relationshipSIRDao.startTransaction();
		result = relationshipSIRDao.isSIR(relation);
		relationshipSIRDao.commitTransaction();
	    }
	}
	catch (SQLException sqlException) {
	    LOG.error(
		ErrorConstants.INSERT_RELATIONSHIP_ERROR_MESSAGE, sqlException);
	    LOG.error("ERROR Insertando la relaci�n: unitId" +
		    relation.getUnitId() + "; officeId: " + relation.getOfficeId());

	}
	finally {
	    relationshipDao.endTransaction();
	}
	 return result ;
    }

    /**
     * Comprueba si una relacion es SIR.
     * 
     * @param relaci�n
     *            relaci�n a comprobar.
     * @throws DIR3Exception
     * 
     */
    public List<RelationshipOFIUOVO> getUnitsDir(
	String idEntity)
	throws DIR3Exception {
	List<RelationshipOFIUOVO> relation = null;
	try {
	    relation = new ArrayList<RelationshipOFIUOVO>();
	    relationshipSIRDao.startTransaction();
	    relation = relationshipSIRDao.getUnitDir(idEntity);
	    relationshipSIRDao.commitTransaction();
	}
	catch (SQLException sqlException) {
	    LOG.error(
		ErrorConstants.INSERT_RELATIONSHIP_ERROR_MESSAGE, sqlException);
	   

	}
	finally {
	    relationshipDao.endTransaction();
	}
	 return relation ;
    }

    
    /**
     * Modifica una relaci�n.
     * 
     * @param relaci�n
     *            relaci�n a modificar.
     * @throws DIR3Exception .
     * 
     */
    public void update(
	RelationshipOFIUOVO relation)
	throws DIR3Exception {
	try {
	    if (relation != null) {
		LOG.info("Modificamos la relaci�n: unitId" +
		    relation.getUnitId() + "; officeId: " + relation.getOfficeId());
		relationshipDao.startTransaction();
		relationshipDao.update(relation);
		relationshipDao.commitTransaction();
	    }
	}
	catch (SQLException sqlException) {
	    LOG.error(
		ErrorConstants.UPDATE_RELATIONSHIP_ERROR_MESSAGE, sqlException);
	    LOG.error("ERROR Modificando la relaci�n: unitId" +
		    relation.getUnitId() + "; officeId: " + relation.getOfficeId());
	    /*throw new DIR3Exception(
		DIR3ErrorCode.UPDATE_RELATIONSHIP_ERROR,
		ErrorConstants.UPDATE_RELATIONSHIP_ERROR_MESSAGE, sqlException);*/
	}
	finally {
	    relationshipDao.endTransaction();
	}
    }

    /**
     * borra una relaci�n.
     * 
     * @param relaci�n
     *            relaci�n a insertar.
     * @throws DIR3Exception
     * 
     */
    public void delete(
	RelationshipOFIUOVO relation)
	throws DIR3Exception {
	try {
	    if (relation != null) {
		relationshipDao.startTransaction();
		relationshipDao.delete(relation);
		relationshipDao.commitTransaction();
	    }
	}
	catch (SQLException sqlException) {
	    LOG.error(
		ErrorConstants.DELETE_RELATIONSHIPREGISTER_ERROR_MESSAGE, sqlException);
	    LOG.error("ERROR Borrando la relaci�n: unitId" +
		    relation.getUnitId() + "; officeId: " + relation.getOfficeId());
	    throw new DIR3Exception(
		DIR3ErrorCode.DELETE_RELATIONSHIPREGISTER_ERROR,
		ErrorConstants.DELETE_RELATIONSHIPREGISTER_ERROR_MESSAGE, sqlException);
	}
	finally {
	    relationshipDao.endTransaction();
	}
    }

    
    /**
     * M�todo gen�rico para recuperar una relaci�n.
     * 
     * @param ids
     *            identificador de la unidad org�nica a recuperar.
     * @return el objeto recuperado.
     * @throws DIR3Exception .
     */
    public RelationshipOFIUOVO get(
	Map<String, String> ids)
	throws DIR3Exception {
	RelationshipOFIUOVO result = null;
	try {
	    if (ids != null &&
		(ids.get("unitId") != null && ids.get("officeId") != null)) {
		LOG.info("Recuperando una relaci�n: unitId: " +
		    ids.get("unitId") + "; officeId: " + ids.get("officeId"));
		// Buscamos datos basicos de la unidad organica
		result = (RelationshipOFIUOVO) relationshipDao.get(ids);
	    }
	}
	catch (SQLException sqlException) {
	    LOG.error(
		ErrorConstants.GET_RELATIONSHIP_ERROR_MESSAGE, sqlException);
	    throw new DIR3Exception(
		DIR3ErrorCode.GET_RELATIONSHIP_ERROR,
		ErrorConstants.GET_RELATIONSHIP_ERROR_MESSAGE, sqlException);
	}
	return result;
    }

    /**
     * Comprueba la existencia de una relaci�n con los identificadores dados.
     * 
     * @param anId
     *            identificadores del objeto.
     * @return <code>true</code> si el objeto existe, <code>false</code> en caso
     *         contrario.
     * @throws DIR3Exception .
     */
    public boolean exists(
	Map<String, String> anId)
	throws DIR3Exception {
	boolean result = false;
	try {
	    LOG.info("Comprobando la existencia de una relaci�n.");
	    // Buscamos datos sobre la unidad org�nica
	    result = relationshipDao.exists(anId);
	}
	catch (SQLException sqlException) {
	    LOG.error(
		ErrorConstants.EXISTS_RELATIONSHIP_ERROR_MESSAGE, sqlException);
	    throw new DIR3Exception(
		DIR3ErrorCode.EXISTS_RELATIONSHIP_ERROR,
		ErrorConstants.EXISTS_RELATIONSHIP_ERROR_MESSAGE, sqlException);
	}
	return result;
    }

    /**
     * Obtiene el valor del par�metro relationshipDao.
     * 
     * @return relationshipDao valor del campo a obtener.
     */
    public RelationshipRegisterDao getRelationshipDao() {
	return relationshipDao;
    }

    /**
     * Guarda el valor del par�metro relationshipDao.
     * 
     * @param relationshipDao
     *            valor del campo a guardar.
     */
    public void setRelationshipDao(
	    RelationshipRegisterDao relationshipDao) {
	this.relationshipDao = relationshipDao;
    }

    public RelationshipDao getRelationshipSIRDao() {
        return relationshipSIRDao;
    }

    public void setRelationshipSIRDao(RelationshipDao relationshipSIRDao) {
        this.relationshipSIRDao = relationshipSIRDao;
    }

}
