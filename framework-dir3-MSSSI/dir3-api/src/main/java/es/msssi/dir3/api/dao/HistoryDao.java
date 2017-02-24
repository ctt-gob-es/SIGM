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
import java.util.Map;

import es.msssi.dir3.api.type.CriterionEnum;
import es.msssi.dir3.api.vo.HistoryVO;

/**
 * Interfaz de los DAOs de datos b�sicos del hist�rico de oficinas y unidades.
 * 
 * @author cmorenog
 * 
 */
public interface HistoryDao extends BaseDao<HistoryVO, Map<String,String>, CriterionEnum> {

    /**
     * Devuelve el c�digo de la causa de baja que corresponde a la descripci�n
     * que entra como par�metro.
     * 
     * @param cause
     *            descripci�n de la causa.
     * @return C�digo de la causa de baja.
     * @throws SQLException
     */
    public String getCauseId(
	String cause)
	throws SQLException;


}
