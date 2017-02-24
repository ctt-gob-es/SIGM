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
import es.msssi.dir3.core.vo.AddressRegistroVO;

/**
 * Interfaz de los DAOs de datos b�sicos de direcciones.
 * 
 * @author cmorenog
 * 
 */
public interface AddressRegistroDao extends BaseDao<AddressRegistroVO, String, CriterionEnum> {

    /**
     * M�todo borrar una direcci�n. 
     * 
     * @param orgId
     *         direcci�n a insertar.
     * @throws SQLException .
     */
    public void delete(
	String orgId)
	throws SQLException;


}
