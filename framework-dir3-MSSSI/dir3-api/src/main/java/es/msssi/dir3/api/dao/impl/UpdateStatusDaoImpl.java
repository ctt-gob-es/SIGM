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

import es.msssi.dir3.api.dao.SqlMapClientBaseDao;
import es.msssi.dir3.api.dao.UpdateStatusDAO;
import es.msssi.dir3.api.vo.UpdateStatusVO;

/**
 * DAO de datos de las actualizaciones.
 * 
 * @author cmorenog
 * 
 */
public class UpdateStatusDaoImpl extends SqlMapClientBaseDao implements UpdateStatusDAO {

    protected static final String GETLASTSUCCESSUPDATE = "UpdateStatusVO.getLastSuccessUpdate";
    protected static final String INSERTLASTSUCCESSUPDATE = "UpdateStatusVO.addUpdateStatusVO";
    protected static final String GETSTATE = "UpdateStatusVO.getUpdateStatusVO";
    protected static final String UPDATESTATE = "UpdateStatusVO.updateUpdateStatusVO";
    protected static final String COUNTSTATE = "UpdateStatusVO.countUpdateStatusVO";
    protected static final String EXISTSSTATE = "UpdateStatusVO.existsUpdateStatusVO";

    /**
     * Constructor.
     */
    public UpdateStatusDaoImpl() {
	super();
    }

    /**
     * 
     * Obtiene la informaci�n con la fecha de la �ltima actualizaci�n correcta.
     * 
     * @return EstadoActualizacionDcoVO la �ltima actualizaci�n.
     * @throws SQLException .
     */
    public UpdateStatusVO getLastSuccessUpdate()
	throws SQLException {
	return (UpdateStatusVO) getSqlMapClientTemplate().queryForObject(
	    GETLASTSUCCESSUPDATE);
    }

    /**
     * M�todo gen�rico para recuperar una actualizaci�n bas�ndonos en su
     * identificador.
     * 
     * @param anId
     *            identificador del objeto a recuperar
     * @return el objeto recuperado.
     * @throws SQLException.
     */
    public UpdateStatusVO get(
	String anId)
	throws SQLException {
	return (UpdateStatusVO) getSqlMapClientTemplate().queryForObject(
	    GETSTATE, anId);
    }

    /**
     * Comprueba la existencia de una actualizaci�n con el identificador dado.
     * 
     * @param id
     *            identificador del objeto.
     * @return <code>true</code> si el objeto existe, <code>false</code> en caso
     *         contrario
     * @throws SQLException .
     */
    public boolean exists(
	String id)
	throws SQLException {
	boolean result = false;
	Integer state = (Integer) getSqlMapClientTemplate().queryForObject(
	    EXISTSSTATE, id);
	if (!Integer.valueOf(
	    0).equals(
	    state)) {
	    result = true;
	}
	return result;
    }

    /**
     * M�todo para guardar una actualizaci�n.
     * 
     * @param entity
     *            unidad org�nica a guardar.
     * @throws SQLException.
     */
    public void save(
	UpdateStatusVO entity)
	throws SQLException {
	getSqlMapClient().insert(
	    INSERTLASTSUCCESSUPDATE, entity);
    }

    /**
     * M�todo gen�rico para actualizar una actualizaci�n de la clase dada.
     * 
     * @param entity
     *            objeto a actualizar.
     * @throws SQLException.
     */
    public void update(
	UpdateStatusVO entity)
	throws SQLException {
	getSqlMapClient().update(
	    UPDATESTATE, entity);
    }

}