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
 * Informaci�n b�sica de una unidad org�nica.
 * 
 * @author cmorenog
 * 
 */
public class BasicDataUnit extends Entity {

    private static final long serialVersionUID = 5515960788820716930L;

    /*
     * Datos Identificativos y Estructurales
     */
    /**
     * Denominaci�n de la unidad.
     */
    private String name;

    /**
     * 
     * Unidad superior jer�rquica (de la que depende directamente la unidad).
     */
    private String fatherUnitId;

    /**
     * Denominaci�n de la unidad superior jer�rquica (de la que depende
     * directamente la unidad).
     */
    private String fatherUnitName;

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
     * Obtiene el valor del par�metro fatherUnitId.
     * 
     * @return fatherUnitId valor del campo a obtener.
     */
    public String getFatherUnitId() {
	return fatherUnitId;
    }

    /**
     * Guarda el valor del par�metro fatherUnitId.
     * 
     * @param fatherUnitId
     *            valor del campo a guardar.
     */
    public void setFatherUnitId(
	String fatherUnitId) {
	this.fatherUnitId = fatherUnitId;
    }

    /**
     * Obtiene el valor del par�metro fatherUnitName.
     * 
     * @return fatherUnitName valor del campo a obtener.
     */
    public String getFatherUnitName() {
	return fatherUnitName;
    }

    /**
     * Guarda el valor del par�metro fatherUnitName.
     * 
     * @param fatherUnitName
     *            valor del campo a guardar.
     */
    public void setFatherUnitName(
	String fatherUnitName) {
	this.fatherUnitName = fatherUnitName;
    }
}
