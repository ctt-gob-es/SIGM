/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.dir3.core.vo;

/**
 * Informaci�n b�sica de una oficina.
 * 
 * @author cmorenog
 * 
 */
public class BasicDataOffice extends Entity {

    private static final long serialVersionUID = 5515960788820716930L;

    /**
     * Datos Identificativos y Estructurales.
     */

    private String name;

    /**
     * Tipo de oficina.
     */
    private String officeType;

    /**
     * Descripci�n del tipo de oficina.
     */
    private String officeTypeName;

    /**
     * Unidad responsable (de la que depende la oficina).
     */
    private String responsibleUnitId;

    /**
     * Denominaci�n de la unidad responsable (de la que depende la oficina).
     */
    private String responsibleUnitName;

    /**
     * Estado de la entidad.
     */
    private String status;

    /**
     * Obtiene el valor del par�metro name.
     * 
     * @return name valor del campo a obtener.
     */
    public String getName() {
	return name;
    }

    /**
     * Guarda el valor del par�metro name.
     * 
     * @param name
     *            valor del campo a guardar.
     */
    public void setName(
	String name) {
	this.name = name;
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

    /**
     * Obtiene el valor del par�metro officeType.
     * 
     * @return officeType valor del campo a obtener.
     */
    public String getOfficeType() {
	return officeType;
    }

    /**
     * Guarda el valor del par�metro officeType.
     * 
     * @param officeType
     *            valor del campo a guardar.
     */
    public void setOfficeType(
	String officeType) {
	this.officeType = officeType;
    }

    /**
     * Obtiene el valor del par�metro officeTypeName.
     * 
     * @return officeTypeName valor del campo a obtener.
     */
    public String getOfficeTypeName() {
	return officeTypeName;
    }

    /**
     * Guarda el valor del par�metro officeTypeName.
     * 
     * @param officeTypeName
     *            valor del campo a guardar.
     */
    public void setOfficeTypeName(
	String officeTypeName) {
	this.officeTypeName = officeTypeName;
    }

    /**
     * Obtiene el valor del par�metro responsibleUnitId.
     * 
     * @return responsibleUnitId valor del campo a obtener.
     */
    public String getResponsibleUnitId() {
	return responsibleUnitId;
    }

    /**
     * Guarda el valor del par�metro responsibleUnitId.
     * 
     * @param responsibleUnitId
     *            valor del campo a guardar.
     */
    public void setResponsibleUnitId(
	String responsibleUnitId) {
	this.responsibleUnitId = responsibleUnitId;
    }

    /**
     * Obtiene el valor del par�metro responsibleUnitName.
     * 
     * @return responsibleUnitName valor del campo a obtener.
     */
    public String getResponsibleUnitName() {
	return responsibleUnitName;
    }

    /**
     * Guarda el valor del par�metro responsibleUnitName.
     * 
     * @param responsibleUnitName
     *            valor del campo a guardar.
     */
    public void setResponsibleUnitName(
	String responsibleUnitName) {
	this.responsibleUnitName = responsibleUnitName;
    }

}
