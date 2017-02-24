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

import es.msssi.dir3.core.vo.Entity;

/**
 * Datos de relaciones entre oficinas y organismos.
 * 
 * @author cmorenog
 * 
 */
public class RelationshipOFIUOVO extends Entity {

    private static final long serialVersionUID = 4502717489198772621L;

    /**
     * C�digo oficina.
     */
    private String officeId;

    /**
     * nombre oficina.
     */
    private String officeName;

    /**
     * C�digo unidad.
     */
    private String unitId;

    /**
     * nombre unidad.
     */
    private String unitName;

    /**
     * Id de estado.
     */
    private String status;

    /**
     * Obtiene el valor del par�metro officeId.
     * 
     * @return officeId valor del campo a obtener.
     */
    public String getOfficeId() {
	return officeId;
    }

    /**
     * Guarda el valor del par�metro officeId.
     * 
     * @param officeId
     *            valor del campo a guardar.
     */
    public void setOfficeId(
	String officeId) {
	this.officeId = officeId;
    }

    /**
     * Obtiene el valor del par�metro officeName.
     * 
     * @return officeName valor del campo a obtener.
     */
    public String getOfficeName() {
	return officeName;
    }

    /**
     * Guarda el valor del par�metro officeName.
     * 
     * @param officeName
     *            valor del campo a guardar.
     */
    public void setOfficeName(
	String officeName) {
	this.officeName = officeName;
    }

    /**
     * Obtiene el valor del par�metro unitId.
     * 
     * @return unitId valor del campo a obtener.
     */
    public String getUnitId() {
	return unitId;
    }

    /**
     * Guarda el valor del par�metro unitId.
     * 
     * @param unitId
     *            valor del campo a guardar.
     */
    public void setUnitId(
	String unitId) {
	this.unitId = unitId;
    }

    /**
     * Obtiene el valor del par�metro unitName.
     * 
     * @return unitName valor del campo a obtener.
     */
    public String getUnitName() {
	return unitName;
    }

    /**
     * Guarda el valor del par�metro unitName.
     * 
     * @param unitName
     *            valor del campo a guardar.
     */
    public void setUnitName(
	String unitName) {
	this.unitName = unitName;
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
