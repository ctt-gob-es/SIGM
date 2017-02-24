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

import es.msssi.dir3.api.type.UOCriterionEnum;
import es.msssi.dir3.api.vo.BasicDataUnitVO;
import es.msssi.dir3.api.vo.Criteria;
import es.msssi.dir3.api.vo.Criterion;
import es.msssi.dir3.api.vo.UnitVO;

/**
 * Interfaz de los DAOs de datos b�sicos de unidades org�nicas.
 * 
 * @author cmorenog
 * 
 */
public interface UnitDao extends BaseDao<UnitVO, String, UOCriterionEnum> {



    /**
     * M�todo gen�rico para recuperar todas las entidades de un mismo tipo y que
     * cumplan los criterios introducidos.
     * 
     * @param criterios
     *            Criterios de b�squeda de tipo C.
     * @return la lista de objetos.
     * @throws SQLException
     */
    public List<UnitVO> find(
	Criteria<UOCriterionEnum> criteria)
	throws SQLException;

    /**
     * M�todo  para recuperar los datos b�sicos de todas las unidades
     *  que cumplan los criterios introducidos.
     * 
     * @param criterios
     *            Criterios de b�squeda .
     * @return la lista de unidades.
     * @throws SQLException
     */
    public List<BasicDataUnitVO> findBasicData(
	Criteria<UOCriterionEnum> criteria)
	throws SQLException;

    /**
     * Devuelve el n�mero de entidades de unidades existentes que cumplan los
     * criterios introducidos.
     * 
     * @param criterios
     *            Criterios de b�squeda.
     * @return n�mero de unidades.
     * @throws SQLException
     */
    public int count(
	List<Criterion<UOCriterionEnum>> criteria)
	throws SQLException;

}
