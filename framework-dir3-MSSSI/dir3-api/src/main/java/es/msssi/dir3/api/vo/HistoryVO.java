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
 * Datos de contacto de una oficina.
 * 
 * @author cmorenog
 * 
 */
public class HistoryVO extends Entity {

    private static final long serialVersionUID = 4502717489198772621L;

    /**
     * c�digo anterior.
     */
    private String previousId;

    /**
     * nombre anterior.
     */
    private String previousName;

    /**
     * c�digo de la �ltima entidad.
     */
    private String lastId;

    /**
     * nombre de la �ltima entidad.
     */
    private String lastName;

    /**
     * id del motivo.
     */
    private String causeId;

    /**
     * observaciones del motivo de baja.
     */
    private String observations;

    /**
     * estado del elemento anterior.
     */
    private String previousStatus;

    /**
     * estado del elemento �ltimo.
     */
    private String lastStatus;

    /**
     * estado de la relaci�n.
     */
    private String status;

    /**
     * fecha extinci�n.
     */
    private String extinctionDate;

    /**
     * Obtiene el valor del par�metro previousId.
     * 
     * @return previousId valor del campo a obtener.
     */
    public String getPreviousId() {
	return previousId;
    }

    /**
     * Guarda el valor del par�metro previousId.
     * 
     * @param previousId
     *            valor del campo a guardar.
     */
    public void setPreviousId(
	String previousId) {
	this.previousId = previousId;
    }

    /**
     * Obtiene el valor del par�metro previousName.
     * 
     * @return previousName valor del campo a obtener.
     */
    public String getPreviousName() {
	return previousName;
    }

    /**
     * Guarda el valor del par�metro previousName.
     * 
     * @param previousName
     *            valor del campo a guardar.
     */
    public void setPreviousName(
	String previousName) {
	this.previousName = previousName;
    }

    /**
     * Obtiene el valor del par�metro lastId.
     * 
     * @return lastId valor del campo a obtener.
     */
    public String getLastId() {
	return lastId;
    }

    /**
     * Guarda el valor del par�metro lastId.
     * 
     * @param lastId
     *            valor del campo a guardar.
     */
    public void setLastId(
	String lastId) {
	this.lastId = lastId;
    }

    /**
     * Obtiene el valor del par�metro lastName.
     * 
     * @return lastName valor del campo a obtener.
     */
    public String getLastName() {
	return lastName;
    }

    /**
     * Guarda el valor del par�metro lastName.
     * 
     * @param lastName
     *            valor del campo a guardar.
     */
    public void setLastName(
	String lastName) {
	this.lastName = lastName;
    }

    /**
     * Obtiene el valor del par�metro causeId.
     * 
     * @return causeId valor del campo a obtener.
     */
    public String getCauseId() {
	return causeId;
    }

    /**
     * Guarda el valor del par�metro causeId.
     * 
     * @param causeId
     *            valor del campo a guardar.
     */
    public void setCauseId(
	String causeId) {
	this.causeId = causeId;
    }

    /**
     * Obtiene el valor del par�metro observations.
     * 
     * @return observations valor del campo a obtener.
     */
    public String getObservations() {
	return observations;
    }

    /**
     * Guarda el valor del par�metro observations.
     * 
     * @param observations
     *            valor del campo a guardar.
     */
    public void setObservations(
	String observations) {
	this.observations = observations;
    }

    /**
     * Obtiene el valor del par�metro previousStatus.
     * 
     * @return previousStatus valor del campo a obtener.
     */
    public String getPreviousStatus() {
	return previousStatus;
    }

    /**
     * Guarda el valor del par�metro previousStatus.
     * 
     * @param previousStatus
     *            valor del campo a guardar.
     */
    public void setPreviousStatus(
	String previousStatus) {
	this.previousStatus = previousStatus;
    }

    /**
     * Obtiene el valor del par�metro lastStatus.
     * 
     * @return lastStatus valor del campo a obtener.
     */
    public String getLastStatus() {
	return lastStatus;
    }

    /**
     * Guarda el valor del par�metro lastStatus.
     * 
     * @param lastStatus
     *            valor del campo a guardar.
     */
    public void setLastStatus(
	String lastStatus) {
	this.lastStatus = lastStatus;
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
     * Obtiene el valor del par�metro extinctionDate.
     * 
     * @return extinctionDate valor del campo a obtener.
     */
    public String getExtinctionDate() {
	return extinctionDate;
    }

    /**
     * Guarda el valor del par�metro extinctionDate.
     * 
     * @param extinctionDate
     *            valor del campo a guardar.
     */
    public void setExtinctionDate(
	String extinctionDate) {
	this.extinctionDate = extinctionDate;
    }

}
