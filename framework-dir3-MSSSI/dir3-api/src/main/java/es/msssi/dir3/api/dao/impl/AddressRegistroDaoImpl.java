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

import org.apache.log4j.Logger;

import es.msssi.dir3.api.dao.AddressRegistroDao;
import es.msssi.dir3.api.dao.SqlMapClientBaseDao;
import es.msssi.dir3.core.vo.AddressRegistroVO;

/**
 * DAO de datos b�sicos de direcciones.
 * 
 * @author cmorenog
 * 
 */
public class AddressRegistroDaoImpl extends SqlMapClientBaseDao implements AddressRegistroDao {

    /**
     * Nombre de la query
     * */
    protected static final String GETADDRESS = "AddressRegistroVO.getAddressRegistroVO";
    protected static final String INSERTADDRESS = "AddressRegistroVO.addAddressRegistroVO";
    protected static final String UPDATEADDRESS = "AddressRegistroVO.updateAddressRegistroVO";
    protected static final String DELETEADDRESS = "AddressRegistroVO.deleteAddressRegistroVO";
    protected static final String EXISTSADDRESS = "AddressRegistroVO.existsAddress";
    protected static final String IDORGADDRESS = "AddressRegistroVO.IdOrgDirec";
    /**
     * Logger de la clase.
     */
    private static final Logger logger = Logger.getLogger(AddressRegistroDaoImpl.class);

    /**
     * Constructor.
     * 
     */
    public AddressRegistroDaoImpl() {
	super();
    }

    /**
     * M�todo gen�rico para recuperar una direccion bas�ndonos en su
     * identificador.
     * 
     * @param idorg
     *            identificador del objeto a recuperar.
     * @return el objeto recuperado.
     * @throws SQLException .
     */
    public AddressRegistroVO get(
	    String idorg)
	throws SQLException {
	logger.info("Obteniendo una direcci�n con el id: " +
		idorg);
	AddressRegistroVO address;
	address = (AddressRegistroVO) getSqlMapClientTemplate().queryForObject(
	    GETADDRESS, idorg);

	return address;
    }

    /**
     * Comprueba la existencia de una direcci�n con el identificador dado.
     * 
     * @param idorg
     *            identificador del objeto.
     * @return <code>true</code> si el objeto existe, <code>false</code> en caso
     *         contrario.
     * @throws SQLException .
     */
    public boolean exists(
	String idorg)
	throws SQLException {
	logger.info("Obteniendo si existe una direccion con el id: " +
		idorg);
	boolean exist = false;
	Integer count = (Integer) getSqlMapClientTemplate().queryForObject(
	    EXISTSADDRESS, idorg);
	if (!Integer.valueOf(
	    0).equals(
	    count)) {
	    exist = true;
	}
	return exist;
    }

    /**
     * M�todo para guardar una direccion. 
     * 
     * @param address
     *            direcci�n a guardar.
     * @throws SQLException.
     */
    public void save(
	    AddressRegistroVO address)
	throws SQLException {
	logger.info("Guardar una direcci�n");
	address.setIdOrganismo((Integer)getSqlMapClient().queryForObject(IDORGADDRESS, address.getId_orgs()));
	getSqlMapClient().insert(
	    INSERTADDRESS, address);
    }

    /**
     * M�todo para actualizar una direcci�n.
     * 
     * @param address
     *            direcci�n a actualizar.
     * @throws SQLException .
     */
    public void update(
	AddressRegistroVO address)
	throws SQLException {
	logger.info("Modifico una direccion: "+address.getId());
	getSqlMapClient().update(
	    UPDATEADDRESS, address);
    }


    /**
     * M�todo borrar una direcci�n. 
     * 
     * @param orgId
     *         direcci�n a insertar.
     * @throws SQLException .
     */
    public void delete(
	String orgId)
	throws SQLException {
	logger.info("Borro una direccion: "+orgId);
	getSqlMapClient().delete(
	    DELETEADDRESS, orgId);
    }

}
