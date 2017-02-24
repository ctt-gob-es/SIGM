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

import org.apache.log4j.Logger;

import es.msssi.dir3.api.dao.ContactUODao;
import es.msssi.dir3.api.dao.SqlMapClientBaseDao;
import es.msssi.dir3.api.vo.ContactUOVO;

/**
 * DAO de datos b�sicos de contactos de unidades org�nicas.
 * 
 * @author cmorenog
 * 
 */
public class ContactUODaoImpl extends SqlMapClientBaseDao implements ContactUODao {

    /**
     * Nombre de la query
     * */
    protected static final String GETCONTACT = "ContactUOVO.getContactUOVO";
    protected static final String LISTCONTACTS = "ContactUOVO.getActiveContactUOVOs";
    protected static final String INSERTCONTACT = "ContactUOVO.addContactUOVO";
    protected static final String UPDATECONTACT = "ContactUOVO.updateContactUOVO";
    protected static final String DELETECONTACT = "ContactUOVO.deleteContactUOVO";

    /**
     * Logger de la clase.
     */
    private static final Logger logger = Logger.getLogger(ContactUODaoImpl.class);

    /**
     * Constructor.
     * 
     */
    public ContactUODaoImpl() {
	super();
    }

    /**
     * M�todo para recuperar un contacto bas�ndonos en su
     * identificador.
     * 
     * @param id
     *            identificador del objeto a recuperar
     * @return el objeto recuperado.
     * @throws SQLException.
     */
    public ContactUOVO get(
	Integer id)
	throws SQLException {
	logger.info("Obteniendo una contacto con el id: " +
	    id);
	ContactUOVO contact;
	contact = (ContactUOVO) getSqlMapClientTemplate().queryForObject(
	    GETCONTACT, id);

	return contact;
    }

    /**
     * Comprueba la existencia de un contacto con el identificador dado.
     * 
     * @param id
     *            identificador del objeto
     * @return <code>true</code> si el objeto existe, <code>false</code> en caso
     *         contrario
     * @throws SQLException.
     */
    public boolean exists(
	Integer id)
	throws SQLException {
	logger.info("Obteniendo si existe un contacto con el id: " +
	    id);
	boolean exist = false;
	ContactUOVO contact;
	contact = (ContactUOVO) getSqlMapClientTemplate().queryForObject(
	    GETCONTACT, id);
	if (contact != null) {
	    exist = true;
	}
	return exist;
    }

    /**
     * M�todo para guardar un contacto. Maneja tanto la inserci�n como
     * la actualizaci�n.
     * 
     * @param entity
     *            contacto a guardar.
     * @throws SQLException.
     */
    public void save(
	ContactUOVO entity)
	throws SQLException {
	logger.info("Guardar un contacto");
	getSqlMapClient().insert(
	    INSERTCONTACT, entity);
    }

    /**
     * M�todo gen�rico para actualizar un contacto de la clase dada.
     * 
     * @param entity
     *            objeto a actualizar.
     * @throws SQLException.
     */
    public void update(
	ContactUOVO entity)
	throws SQLException {
	logger.info("Modifico un contacto");
	getSqlMapClient().update(
	    UPDATECONTACT, entity);
    }

    /**
     * Se eliminan los contactos de la unidad que pasa como par�metro.
     * @param id
     * 	c�digo de la unidad.
     * @throws SQLException .
     */
    public void deleteContactsOrg(
	String id)
	throws SQLException {
	logger.info("Borrar los contactos del organismo:" +
	    id);
	getSqlMapClient().update(
	    DELETECONTACT, id);
    }

    /**
     * Se devuelven los contactos de la oficina que pasa como par�metro.
     * @param codigo
     * 	c�digo de la oficina.
     * @throws SQLException .
     */
    @SuppressWarnings("unchecked")
    public List<ContactUOVO> getContacts(
	String codigo)
	throws SQLException {
	logger.info("Obteniendo los contactos de la unidad: " +
	    codigo);
	List<ContactUOVO> list = null;
	list = (List<ContactUOVO>) getSqlMapClientTemplate().queryForList(
	    LISTCONTACTS, codigo);

	return list;
    }

}
