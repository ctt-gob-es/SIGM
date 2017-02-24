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

import es.msssi.dir3.api.dao.ContactOFIDao;
import es.msssi.dir3.api.dao.SqlMapClientBaseDao;
import es.msssi.dir3.api.vo.ContactOFIVO;

/**
 * DAO de datos b�sicos de contactos de oficina.
 * 
 * @author cmorenog
 * 
 */
public class ContactOFIDaoImpl extends SqlMapClientBaseDao implements ContactOFIDao {

    /**
     * Nombre de la query
     * */
    protected static final String GETCONTACT = "ContactOFIVO.getContactOFIVO";
    protected static final String LISTCONTACTS = "ContactOFIVO.getActiveContactOFIVOs";
    protected static final String INSERTCONTACT = "ContactOFIVO.addContactOFIVO";
    protected static final String UPDATECONTACT = "ContactOFIVO.updateContactOFIVO";
    protected static final String DELETECONTACT = "ContactOFIVO.deleteContactOFIVO";
    /**
     * Logger de la clase.
     */
    private static final Logger logger = Logger.getLogger(ContactOFIDaoImpl.class);

    /**
     * Constructor.
     * 
     */
    public ContactOFIDaoImpl() {
	super();
    }

    /**
     * M�todo para recuperar un contacto bas�ndonos en su identificador.
     * 
     * @param id
     *            identificador del objeto a recuperar
     * @return el objeto recuperado.
     * @throws SQLException.
     */
    public ContactOFIVO get(
	Integer id)
	throws SQLException {
	logger.info("Obteniendo una contacto con el id: " +
	    id);
	ContactOFIVO contact;
	contact = (ContactOFIVO) getSqlMapClientTemplate().queryForObject(
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
	ContactOFIVO contact;
	contact = (ContactOFIVO) getSqlMapClientTemplate().queryForObject(
	    GETCONTACT, id);
	if (contact != null) {
	    exist = true;
	}
	return exist;
    }

    /**
     * M�todo para guardar un contacto.
     * 
     * @param contact
     *            contacto a guardar.
     * @throws SQLException.
     */
    public void save(
	ContactOFIVO contact)
	throws SQLException {
	logger.info("Guardar un contacto");
	getSqlMapClient().insert(
	    INSERTCONTACT, contact);
    }

    /**
     * M�todo para actualizar un contacto de la clase dada.
     * 
     * @param contact
     *            objeto a actualizar.
     * @throws SQLException .
     */
    public void update(
	ContactOFIVO contact)
	throws SQLException {
	logger.info("Modifico el contacto");
	getSqlMapClient().update(
	    UPDATECONTACT, contact);
    }

    /**
     * Se eliminan los contactos de la oficina que pasa como par�metro.
     * 
     * @param id
     *            c�digo de la oficina.
     * @throws SQLException .
     */
    public void deleteContactsOfi(
	String id)
	throws SQLException {
	logger.info("Borrar los contactos de la oficina:" +
	    id);
	getSqlMapClient().update(
	    DELETECONTACT, id);
    }

    /**
     * Se devuelven los contactos de la oficina que pasa como par�metro.
     * 
     * @param codigo
     *            c�digo de la oficina.
     * @throws SQLException .
     */
    @SuppressWarnings("unchecked")
    public List<ContactOFIVO> getContacts(
	String codigo)
	throws SQLException {
	logger.info("Obteniendo los contactos de la oficina: " +
	    codigo);
	List<ContactOFIVO> list;
	list = (List<ContactOFIVO>) getSqlMapClientTemplate().queryForList(
	    LISTCONTACTS, codigo);

	return list;
    }
}
