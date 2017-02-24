/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.dir3.api.dao;

import java.sql.SQLException;

import es.msssi.dir3.api.type.CriterionEnum;
import es.msssi.dir3.api.vo.AddressVO;

/**
 * Interfaz de los DAOs de datos b�sicos de direcciones.
 * 
 * @author cmorenog
 * 
 */
public interface AddressDao extends BaseDao<AddressVO, Integer, CriterionEnum> {

    /**
     * M�todo para guardar una direcci�n. 
     * 
     * @param address
     *         direcci�n a insertar.
     * @return id del elemento insertado.
     * @throws SQLException .
     */
    public Integer saveReturn(
	AddressVO address)
	throws SQLException;

    /**
     * M�todo borrar una direcci�n. 
     * 
     * @param addressId
     *         direcci�n a insertar.
     * @throws SQLException .
     */
    public void delete(
	Integer addressId)
	throws SQLException;

    /**
     * M�todo  que devuelve el id de la direcci�n de la oficina.
     * 
     * @param id
     *            id de la oficina.
     * @return id de la direcci�n.
     * @throws SQLException .
     */
    public Integer getDirectionOfi(
	String id)
	throws SQLException;

    /**
     * M�todo  que devuelve el id de la direcci�n del organismo.
     * 
     * @param id
     *            id del organismo.
     * @return id de la direcci�n.
     * @throws SQLException
     */
    Integer getDirectionOrg(
	String id)
	throws SQLException;
}
