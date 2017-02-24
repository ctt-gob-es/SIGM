/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.dir3.api.manager;

import java.util.Map;

import es.msssi.dir3.api.type.CriterionEnum;
import es.msssi.dir3.api.vo.RelationshipOFIUOVO;
import es.msssi.dir3.api.vo.RelationshipsOFIUOVO;
import es.msssi.dir3.api.vo.ServicesVO;
import es.msssi.dir3.core.errors.DIR3Exception;

/**
 * Interfaz para los managers de datos b�sicos de las relaciones del registro.
 * 
 * @author cmorenog
 * 
 */
public interface RelationshipRegistroManager extends
    BaseManager<RelationshipOFIUOVO, Map<String, String>, CriterionEnum> {

    /**
     * Actualiza o inserta los datos de las relaciones obtenidas del DCO.
     * 
     * @param relationshipsVO
     *            listado de relaciones a actualizar.
     * @throws DIR3Exception .
     */
    public void updateRelationships(
	RelationshipsOFIUOVO relationshipsVO, ServicesVO servicesDCO)
	throws DIR3Exception;
}
