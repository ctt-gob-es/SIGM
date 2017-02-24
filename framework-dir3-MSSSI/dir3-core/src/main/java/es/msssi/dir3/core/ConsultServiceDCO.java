/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.dir3.core;

import java.util.List;

import es.msssi.dir3.core.errors.DIR3Exception;
import es.msssi.dir3.core.vo.CriteriaOF;
import es.msssi.dir3.core.vo.CriteriaUO;
import es.msssi.dir3.core.vo.CriterionOF;
import es.msssi.dir3.core.vo.CriterionUO;
import es.msssi.dir3.core.vo.Office;
import es.msssi.dir3.core.vo.Unit;

/**
 * Interfaz del servicio de consulta del Directorio Com�n (DIR3).
 * 
 * @author cmorenog
 * 
 */
public interface ConsultServiceDCO {

    /**
     * Obtiene el n�mero de oficinas encontradas seg�n los criterios de
     * b�squeda.
     * 
     * @param criteria
     *            Criterios de b�squeda.
     * @return N�mero de oficinas encontradas.
     * @throws DIR3Exception .
     */
    public int countOffices(
	List<CriterionOF> criteria)
	throws DIR3Exception;

    /**
     * Realiza una b�squeda de oficinas que cumplan con los criterios
     * establecidos.
     * 
     * @param criteria
     *            Criterios de b�squeda.
     * @return Oficinas encontradas.
     * @throws DIR3Exception .
     */
    public List<Office> findOffices(
	CriteriaOF criteria)
	throws DIR3Exception;

    /**
     * Obtiene los datos b�sicos de una oficina.
     * 
     * @param id
     *            Identificador de la oficina.
     * @return Datos b�sicos de la oficina.
     * @throws DIR3Exception .
     */
    public Office getOffice(
	String id)
	throws DIR3Exception;

    /**
     * Obtiene el n�mero de unidades org�nicas encontradas seg�n los criterios
     * de b�squeda.
     * 
     * @param criteria
     *            Criterios de b�squeda.
     * @return N�mero de unidades Oorg�nicas encontradas.
     * @throws DIR3Exception .
     */
    public int countUnits(
	List<CriterionUO> criteria)
	throws DIR3Exception;

    /**
     * Realiza una b�squeda de unidades org�nicas que cumplan con los criterios
     * establecidos.
     * 
     * @param criteria
     *            Criterios de b�squeda.
     * @return Unidades org�nicas encontradas.
     * @throws DIR3Exception .
     */
    public List<Unit> findUnits(
	CriteriaUO criteria)
	throws DIR3Exception;

    /**
     * Obtiene los datos b�sicos de una unidad org�nica.
     * 
     * @param id
     *            Identificador de la unidad org�nica.
     * @return Datos b�sicos de la unidad org�nica.
     * @throws DIR3Exception .
     */
    public Unit getUnit(
	String id)
	throws DIR3Exception;

}
