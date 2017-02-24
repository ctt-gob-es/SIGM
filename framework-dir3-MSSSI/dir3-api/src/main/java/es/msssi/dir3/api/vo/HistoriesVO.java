/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.dir3.api.vo;

import java.util.List;

import es.msssi.dir3.core.vo.Entity;

/**
 * lista de hist�ricos.
 * 
 * @author cmorenog
 * 
 */
public class HistoriesVO extends Entity {

    /**
     * 
     */
    private static final long serialVersionUID = 3022391899522441647L;
    /**
     * Descripci�n del servicio.
     */
    private List<HistoryVO> histories;

    /**
     * Obtiene el valor del par�metro histories.
     * 
     * @return histories valor del campo a obtener.
     */
    public List<HistoryVO> getHistories() {
	return histories;
    }

    /**
     * Guarda el valor del par�metro histories.
     * 
     * @param histories
     *            valor del campo a guardar.
     */
    public void setHistories(
	List<HistoryVO> histories) {
	this.histories = histories;
    }

}
