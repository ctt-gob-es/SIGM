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

import java.util.Date;

import es.msssi.dir3.core.vo.Entity;

/**
 * Informaci�n b�sica de una actualizaci�n.
 * 
 * @author cmorenog
 * 
 */
public class UpdateStatusVO extends Entity {

    private static final long serialVersionUID = 1763557309106784979L;
    /**
     * Fecha de la actualizaci�n.
     */
    private Date updateDate;
    /**
     * Estado de la actualizaci�n.
     */
    private String status;

    /**
     * Obtiene el valor del par�metro updateDate.
     * 
     * @return updateDate valor del campo a obtener.
     */
    public Date getUpdateDate() {
	return updateDate;
    }

    /**
     * Guarda el valor del par�metro updateDate.
     * 
     * @param updateDate
     *            valor del campo a guardar.
     */
    public void setUpdateDate(
	Date updateDate) {
	this.updateDate = updateDate;
    }

    /**
     * Obtiene el valor del par�metro status.
     * 
     * @return status valor del campo a obtener.
     */
    public String getStatus() {
	return status;
    }

    /**
     * Guarda el valor del par�metro status.
     * 
     * @param status
     *            valor del campo a guardar.
     */
    public void setStatus(
	String status) {
	this.status = status;
    }

}
