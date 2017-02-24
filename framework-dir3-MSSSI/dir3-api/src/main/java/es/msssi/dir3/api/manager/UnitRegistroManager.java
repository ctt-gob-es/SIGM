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

import java.util.List;

import es.msssi.dir3.api.type.UOCriterionEnum;
import es.msssi.dir3.api.vo.BasicDataUnitVO;
import es.msssi.dir3.api.vo.ContactsUOVO;
import es.msssi.dir3.api.vo.Criteria;
import es.msssi.dir3.api.vo.Criterion;
import es.msssi.dir3.api.vo.HistoriesVO;
import es.msssi.dir3.api.vo.UnitVO;
import es.msssi.dir3.api.vo.UnitsVO;
import es.msssi.dir3.core.errors.DIR3Exception;

/**
 * Interfaz para los managers de datos b�sicos de unidades org�nicas.
 * 
 * @author cmorenog
 * 
 */
public interface UnitRegistroManager extends BaseManager<UnitVO, String, UOCriterionEnum> {

    /**
     * Actualiza los datos basicos de las unidades obtenidas del DCO.
     * 
     * @param unitsDCO
     * 	listado de unidades a actualizar.
     * @throws DIR3Exception .
     */
    public void insertUpdateUnits(
	List<UnitVO> unitsDCO)
	throws DIR3Exception;

    /**
     * Actualiza los datos de las unidades obtenidas del DCO.
     * 
     * @param unitsDCO
     *            listado de unidades a actualizar.
     * @param contactsUO
     *            listado de contactos.
     * @throws DIR3Exception .
     */
    public void updateUnits(
	UnitsVO unitsDCO, ContactsUOVO contactsUO)
	throws DIR3Exception;

    /**
     * M�todo gen�rico para recuperar todas las entidades de un mismo tipo.
     * Viene a ser lo mismo que recuperar todas las filas de una tabla de base
     * de datos.
     * 
     * @return la lista de objetos recuperados.
     * @throws DIR3Exception .
     */
    public List<UnitVO> getAll()
	throws DIR3Exception;

    /**
     * M�todo gen�rico para recuperar todas las entidades de un mismo tipo y que
     * cumplan con los criterios establecidos. Si criterios es nulo viene a ser
     * lo mismo que recuperar todas las filas de una tabla de base de datos.
     * 
     * @param criteria
     *            criterios de b�squeda.
     * @return la lista de objetos recuperados.
     * @throws DIR3Exception .
     */
    public List<UnitVO> find(
	Criteria<UOCriterionEnum> criteria)
	throws DIR3Exception;

    /**
     * M�todo gen�rico para recuperar datos b�sicos de todas las entidades de un
     * mismo tipo y que cumplan con los criterios establecidos. Si criterios es
     * nulo viene a ser lo mismo que recuperar todas las filas de una tabla de
     * base de datos.
     * 
     * @param criteria
     *            criterios de b�squeda.
     * @return la lista de objetos recuperados .
     * @throws DIR3Exception .
     */
    public List<BasicDataUnitVO> findBasicData(
	Criteria<UOCriterionEnum> criteria)
	throws DIR3Exception;

    /**
     * Devuelve el n�mero de entidades de tipo Entity existentes. Para obtener
     * el resultado delega en el dao asociado.
     * 
     * @return int el n�mero de entidades.
     * @throws DIR3Exception .
     */
    public int count()
	throws DIR3Exception;

    /**
     * Devuelve el n�mero de entidades de tipo Entity existentes y que cumplan
     * los criterios establecidos.
     * 
     * @param criteriaAPI
     *            criterios de b�squeda.
     * @return int el n�mero de entidades.
     * @throws DIR3Exception . 
     */
    public int count(
	List<Criterion<UOCriterionEnum>> criteriaAPI)
	throws DIR3Exception;

    /**
     * Actualiza los datos de las unidades no organicas obtenidas del DCO.
     * 
     * @param unitsDCO
     *            listado de unidades a actualizar.
     * @param contactsUO
     *            listado de contactos.
     * @param historiesUO
     *            listado de hist�ricos.
     * @throws DIR3Exception .
     */
    public void updateUNOUnits(
	UnitsVO unitsDCO, ContactsUOVO contactsUO)
	throws DIR3Exception;
}
