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
import java.util.List;
import java.util.Map;

import es.msssi.dir3.api.type.CriterionEnum;
import es.msssi.dir3.api.vo.RelationshipOFIUOVO;

/**
 * Interfaz de los DAOs de datos b�sicos de las relaciones de oficinas y
 * organismos.
 * 
 * @author cmorenog
 * 
 */
public interface RelationshipDao extends
    BaseDao<RelationshipOFIUOVO, Map<String, String>, CriterionEnum> {

    public boolean isSIR(
	    RelationshipOFIUOVO anEntity)
	throws SQLException;

    public List<RelationshipOFIUOVO> getUnitDir(String idEntity);
}
