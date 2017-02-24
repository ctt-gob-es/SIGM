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

import es.msssi.dir3.api.type.CriterionEnum;
import es.msssi.dir3.api.vo.UpdateStatusVO;
import es.msssi.dir3.core.errors.DIR3Exception;

/**
 * Interfaz para los managers de datos b�sicos de las actualizaciones.
 * 
 * @author cmorenog
 * 
 */
public interface UpdateStatusManager extends BaseManager<UpdateStatusVO, String, CriterionEnum> {

    /**
     * 
     * Obtiene la informaci�n de la �ltima actualizaci�n correcta.
     * 
     * @return EstadoActualizacionDcoVO
     * 		La �ltima actualizaci�n del sistema.
     * @throws DIR3Exception .
     */
    public UpdateStatusVO getLastSuccessUpdate()
	throws DIR3Exception;

}
