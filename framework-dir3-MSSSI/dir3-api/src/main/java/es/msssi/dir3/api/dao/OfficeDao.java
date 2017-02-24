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

import es.msssi.dir3.api.type.OfficeCriterionEnum;
import es.msssi.dir3.api.vo.BasicDataOfficeVO;
import es.msssi.dir3.api.vo.Criteria;
import es.msssi.dir3.api.vo.Criterion;
import es.msssi.dir3.api.vo.OfficeVO;

/**
 * Interfaz de los DAOs de datos b�sicos de oficinas.
 * 
 * @author cmorenog
 * 
 */
public interface OfficeDao extends BaseDao<OfficeVO, String, OfficeCriterionEnum> {


    /**
     * M�todo gen�rico para recuperar todas las oficinas y que
     * cumplan los criterios introducidos.
     * 
     * @param criteria
     *            Criterios de b�squeda.
     * @return la lista de oficinas.
     * @throws SQLException .
     */
    public List<OfficeVO> find(
	Criteria<OfficeCriterionEnum> criteria)
	throws SQLException;

    /**
     * M�todo gen�rico para recuperar los datos b�sicos de todas las oficinas y que
     * cumplan los criterios introducidos.
     * 
     * @param criteria
     *            Criterios de b�squeda.
     * @return la lista de datos b�sicos de oficinas.
     * @throws SQLException .
     */
    public List<BasicDataOfficeVO> findBasicData(
	Criteria<OfficeCriterionEnum> criteria)
	throws SQLException;

    /**
     * Devuelve el n�mero de oficinas existentes que cumplan los
     * criterios introducidos.
     * 
     * @param criteria
     *            Criterios de b�squeda de tipo C.
     * @return n�mero de entidades.
     * @throws SQLException .
     */
    public int count(
	List<Criterion<OfficeCriterionEnum>> criteria)
	throws SQLException;

}
