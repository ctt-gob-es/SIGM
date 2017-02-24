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

import java.util.Date;
import java.util.List;

/**
 * Datos b�sicos de una oficina.
 * 
 * @author cmorenog
 * 
 */
public class Office extends BasicDataOffice {

    private static final long serialVersionUID = 7499231693966687664L;

    /*
     * =======================================================================
     * Datos identificativos
     * 
     * El campo "id" heredado de la clase Entity es el c�digo �nico.
     * =======================================================================
     */

    /**
     * C�digo externo utilizado por la entidad p�blica que aporta los datos para
     * el alta de la oficina en el Directorio Com�n.
     */
    private String externalId;

    /**
     * Indicador abierto a futuras necesidades.
     */
    private String genericIndicator;

    /**
     * Descripci�n que aporta informaci�n sobre el uso del Indicador gen�rico.
     */
    private String genericIndicatorUse;
    /*
     * =======================================================================
     * Datos de dependencia jer�rquica.
     * =======================================================================
     */

    /**
     * C�digo del nivel de administraci�n (Estatal, Auton�mica o Local).
     */
    private String administrationLevelId;

    /**
     * Descripci�n del nivel de administraci�n.
     */
    private String administrationLevelName;

    /**
     * Id de la oficina de la que depende.
     */
    private String dependentOfficeId;
    /*
     * =======================================================================
     * Datos de operativos.
     * =======================================================================
     */

    /**
     * Designa si una oficina se encuentra adherida a la plataforma de
     * intercambio registral del SIR.
     */
    private String sirOfficeIndicator;

    /**
     * Designa si la oficina tiene competencias de REGISTRO.
     */
    private String registerOfficeIndicator;

    /**
     * Designa si la oficina tiene competencias de informaci�n.
     */
    private String informationOfficeIndicator;

    /**
     * Designa si la oficina tiene competencias de tramitaci�n.
     */
    private String processingOfficeIndicator;

    /**
     * Designa si se trata de una oficina de registro que realiza el servicio
     * v�a medios electr�nicos (Registro Electr�nico).
     */
    private String electronicRegisterIndicator;

    /**
     * Designa si una oficina puede registrar documentos destinados a Unidades
     * de cualquier �mbito de la Administraci�n p�blica.
     */
    private String interchangeWithoutRestrictionIndicator;

    /**
     * Designa si una oficina de �mbito local puede registrar documentos
     * destinados a Unidades de la AGE.
     */
    private String interchangeLocalStateIndicator;

    /**
     * Designa si una oficina de �mbito local puede registrar documentos
     * destinados a Unidades de su Administraci�n Auton�mica, es decir de la
     * Comunidad Aut�noma donde opera la oficina.
     */
    private String interchangeWithRestrictionLocalAutonomousIndicator;

    /**
     * Designa si una oficina de �mbito local puede registrar documentos
     * destinados a Unidades de cualquier Administraci�n Auton�mica.
     */
    private String interchangeLocalGeneralAutonomousIndicator;

    /**
     * Designa si una oficina de �mbito local puede registrar documentos
     * destinados a otras entidades locales de la Comunidad Aut�noma donde opera
     * la oficina.
     */
    private String interchangeWithRestrictionLocalLocalIndicator;

    /**
     * Designa si una oficina de �mbito local puede registrar documentos
     * destinados a cualquier otra entidad local.
     */
    private String interchangeLocalGeneralLocalIndicator;

    /**
     * Designa si una oficina de un ayuntamiento puede registrar documentos
     * destinados a otros ayuntamientos de su misma Comunidad Aut�noma.
     */
    private String interchangeWithRestrictionCityHallCityHallIndicator;

    /*
     * =======================================================================
     * Datos de vigencia.
     * =======================================================================
     */

    /**
     * Fecha de creaci�n oficial.
     */
    private Date creationDate;

    /**
     * Fecha de extinci�n final.
     */
    private Date extinctionDate;

    /**
     * Fecha de anulaci�n.
     */
    private Date annulationDate;

    /*
     * =======================================================================
     * Datos de observacion.
     * =======================================================================
     */
    /**
     * Observaciones generales de la oficina.
     */
    private String generalObservations;
    /**
     * Observaciones de baja de la oficina.
     */
    private String deleteObservations;
    /**
     * Observaciones de contacto de la oficina.
     */
    private String contactObservations;

    /*
     * =======================================================================
     * Datos de localizacion.
     * =======================================================================
     */

    /**
     * Indica si la Oficina comparte la misma direcci�n que la Unidad de la que
     * depende org�nicamente.
     */
    private String bSameAddress;

    /**
     * Horarios de la oficina.
     */
    private String businessHours;

    /**
     * D�as inhabiles de la oficina.
     */
    private String inhabiliesDays;

    /**
     * Direcci�n de la oficina.
     */
    private Address address;

    /**
     * Lista de datos de contacto de la oficina.
     */
    private List<Contact> contacts;

    /**
     * Lista de servicios de la oficina.
     */
    private List<Service> services;

    /**
     * Lista de unidades org�nicas de las que la oficina da servicios de SIR.
     */
    private List<BasicDataUnit> relationshipsSIROFI;
    /**
     * Lista de unidades org�nicas relacionadas con la oficina.
     */
    private List<BasicDataUnit> organizationalRelationshipsOFI;

    /**
     * Constructor.
     */
    public Office() {
	super();
    }

    /**
     * Obtiene el valor del par�metro externalId.
     * 
     * @return externalId valor del campo a obtener.
     */
    public String getExternalId() {
	return externalId;
    }

    /**
     * Guarda el valor del par�metro externalId.
     * 
     * @param externalId
     *            valor del campo a guardar.
     */
    public void setExternalId(
	String externalId) {
	this.externalId = externalId;
    }

    /**
     * Obtiene el valor del par�metro genericIndicator.
     * 
     * @return genericIndicator valor del campo a obtener.
     */
    public String getGenericIndicator() {
	return genericIndicator;
    }

    /**
     * Guarda el valor del par�metro genericIndicator.
     * 
     * @param genericIndicator
     *            valor del campo a guardar.
     */
    public void setGenericIndicator(
	String genericIndicator) {
	this.genericIndicator = genericIndicator;
    }

    /**
     * Obtiene el valor del par�metro genericIndicatorUse.
     * 
     * @return genericIndicatorUse valor del campo a obtener.
     */
    public String getGenericIndicatorUse() {
	return genericIndicatorUse;
    }

    /**
     * Guarda el valor del par�metro genericIndicatorUse.
     * 
     * @param genericIndicatorUse
     *            valor del campo a guardar.
     */
    public void setGenericIndicatorUse(
	String genericIndicatorUse) {
	this.genericIndicatorUse = genericIndicatorUse;
    }

    /**
     * Obtiene el valor del par�metro administrationLevelId.
     * 
     * @return administrationLevelId valor del campo a obtener.
     */
    public String getAdministrationLevelId() {
	return administrationLevelId;
    }

    /**
     * Guarda el valor del par�metro administrationLevelId.
     * 
     * @param administrationLevelId
     *            valor del campo a guardar.
     */
    public void setAdministrationLevelId(
	String administrationLevelId) {
	this.administrationLevelId = administrationLevelId;
    }

    /**
     * Obtiene el valor del par�metro administrationLevelName.
     * 
     * @return administrationLevelName valor del campo a obtener.
     */
    public String getAdministrationLevelName() {
	return administrationLevelName;
    }

    /**
     * Guarda el valor del par�metro administrationLevelName.
     * 
     * @param administrationLevelName
     *            valor del campo a guardar.
     */
    public void setAdministrationLevelName(
	String administrationLevelName) {
	this.administrationLevelName = administrationLevelName;
    }

    /**
     * Obtiene el valor del par�metro dependentOfficeId.
     * 
     * @return dependentOfficeId valor del campo a obtener.
     */
    public String getDependentOfficeId() {
	return dependentOfficeId;
    }

    /**
     * Guarda el valor del par�metro dependentOfficeId.
     * 
     * @param dependentOfficeId
     *            valor del campo a guardar.
     */
    public void setDependentOfficeId(
	String dependentOfficeId) {
	this.dependentOfficeId = dependentOfficeId;
    }

    /**
     * Obtiene el valor del par�metro sirOfficeIndicator.
     * 
     * @return sirOfficeIndicator valor del campo a obtener.
     */
    public String getSirOfficeIndicator() {
	return sirOfficeIndicator;
    }

    /**
     * Guarda el valor del par�metro sirOfficeIndicator.
     * 
     * @param sirOfficeIndicator
     *            valor del campo a guardar.
     */
    public void setSirOfficeIndicator(
	String sirOfficeIndicator) {
	this.sirOfficeIndicator = sirOfficeIndicator;
    }

    /**
     * Obtiene el valor del par�metro registerOfficeIndicator.
     * 
     * @return registerOfficeIndicator valor del campo a obtener.
     */
    public String getRegisterOfficeIndicator() {
	return registerOfficeIndicator;
    }

    /**
     * Guarda el valor del par�metro registerOfficeIndicator.
     * 
     * @param registerOfficeIndicator
     *            valor del campo a guardar.
     */
    public void setRegisterOfficeIndicator(
	String registerOfficeIndicator) {
	this.registerOfficeIndicator = registerOfficeIndicator;
    }

    /**
     * Obtiene el valor del par�metro informationOfficeIndicator.
     * 
     * @return informationOfficeIndicator valor del campo a obtener.
     */
    public String getInformationOfficeIndicator() {
	return informationOfficeIndicator;
    }

    /**
     * Guarda el valor del par�metro informationOfficeIndicator.
     * 
     * @param informationOfficeIndicator
     *            valor del campo a guardar.
     */
    public void setInformationOfficeIndicator(
	String informationOfficeIndicator) {
	this.informationOfficeIndicator = informationOfficeIndicator;
    }

    /**
     * Obtiene el valor del par�metro processingOfficeIndicator.
     * 
     * @return processingOfficeIndicator valor del campo a obtener.
     */
    public String getProcessingOfficeIndicator() {
	return processingOfficeIndicator;
    }

    /**
     * Guarda el valor del par�metro processingOfficeIndicator.
     * 
     * @param processingOfficeIndicator
     *            valor del campo a guardar.
     */
    public void setProcessingOfficeIndicator(
	String processingOfficeIndicator) {
	this.processingOfficeIndicator = processingOfficeIndicator;
    }

    /**
     * Obtiene el valor del par�metro electronicRegisterIndicator.
     * 
     * @return electronicRegisterIndicator valor del campo a obtener.
     */
    public String getElectronicRegisterIndicator() {
	return electronicRegisterIndicator;
    }

    /**
     * Guarda el valor del par�metro electronicRegisterIndicator.
     * 
     * @param electronicRegisterIndicator
     *            valor del campo a guardar.
     */
    public void setElectronicRegisterIndicator(
	String electronicRegisterIndicator) {
	this.electronicRegisterIndicator = electronicRegisterIndicator;
    }

    /**
     * Obtiene el valor del par�metro interchangeWithoutRestrictionIndicator.
     * 
     * @return interchangeWithoutRestrictionIndicator valor del campo a obtener.
     */
    public String getInterchangeWithoutRestrictionIndicator() {
	return interchangeWithoutRestrictionIndicator;
    }

    /**
     * Guarda el valor del par�metro interchangeWithoutRestrictionIndicator.
     * 
     * @param interchangeWithoutRestrictionIndicator
     *            valor del campo a guardar.
     */
    public void setInterchangeWithoutRestrictionIndicator(
	String interchangeWithoutRestrictionIndicator) {
	this.interchangeWithoutRestrictionIndicator = interchangeWithoutRestrictionIndicator;
    }

    /**
     * Obtiene el valor del par�metro interchangeLocalStateIndicator.
     * 
     * @return interchangeLocalStateIndicator valor del campo a obtener.
     */
    public String getInterchangeLocalStateIndicator() {
	return interchangeLocalStateIndicator;
    }

    /**
     * Guarda el valor del par�metro interchangeLocalStateIndicator.
     * 
     * @param interchangeLocalStateIndicator
     *            valor del campo a guardar.
     */
    public void setInterchangeLocalStateIndicator(
	String interchangeLocalStateIndicator) {
	this.interchangeLocalStateIndicator = interchangeLocalStateIndicator;
    }

    /**
     * Obtiene el valor del par�metro
     * interchangeWithRestrictionLocalAutonomousIndicator.
     * 
     * @return interchangeWithRestrictionLocalAutonomousIndicator valor del
     *         campo a obtener.
     */
    public String getInterchangeWithRestrictionLocalAutonomousIndicator() {
	return interchangeWithRestrictionLocalAutonomousIndicator;
    }

    /**
     * Guarda el valor del par�metro
     * interchangeWithRestrictionLocalAutonomousIndicator.
     * 
     * @param interchangeWithRestrictionLocalAutonomousIndicator
     *            valor del campo a guardar.
     */
    public void setInterchangeWithRestrictionLocalAutonomousIndicator(
	String interchangeWithRestrictionLocalAutonomousIndicator) {
	this.interchangeWithRestrictionLocalAutonomousIndicator =
	    interchangeWithRestrictionLocalAutonomousIndicator;
    }

    /**
     * Obtiene el valor del par�metro
     * interchangeLocalGeneralAutonomousIndicator.
     * 
     * @return interchangeLocalGeneralAutonomousIndicator valor del campo a
     *         obtener.
     */
    public String getInterchangeLocalGeneralAutonomousIndicator() {
	return interchangeLocalGeneralAutonomousIndicator;
    }

    /**
     * Guarda el valor del par�metro interchangeLocalGeneralAutonomousIndicator.
     * 
     * @param interchangeLocalGeneralAutonomousIndicator
     *            valor del campo a guardar.
     */
    public void setInterchangeLocalGeneralAutonomousIndicator(
	String interchangeLocalGeneralAutonomousIndicator) {
	this.interchangeLocalGeneralAutonomousIndicator =
	    interchangeLocalGeneralAutonomousIndicator;
    }

    /**
     * Obtiene el valor del par�metro
     * interchangeWithRestrictionLocalLocalIndicator.
     * 
     * @return interchangeWithRestrictionLocalLocalIndicator valor del campo a
     *         obtener.
     */
    public String getInterchangeWithRestrictionLocalLocalIndicator() {
	return interchangeWithRestrictionLocalLocalIndicator;
    }

    /**
     * Guarda el valor del par�metro
     * interchangeWithRestrictionLocalLocalIndicator.
     * 
     * @param interchangeWithRestrictionLocalLocalIndicator
     *            valor del campo a guardar.
     */
    public void setInterchangeWithRestrictionLocalLocalIndicator(
	String interchangeWithRestrictionLocalLocalIndicator) {
	this.interchangeWithRestrictionLocalLocalIndicator =
	    interchangeWithRestrictionLocalLocalIndicator;
    }

    /**
     * Obtiene el valor del par�metro interchangeLocalGeneralLocalIndicator.
     * 
     * @return interchangeLocalGeneralLocalIndicator valor del campo a obtener.
     */
    public String getInterchangeLocalGeneralLocalIndicator() {
	return interchangeLocalGeneralLocalIndicator;
    }

    /**
     * Guarda el valor del par�metro interchangeLocalGeneralLocalIndicator.
     * 
     * @param interchangeLocalGeneralLocalIndicator
     *            valor del campo a guardar.
     */
    public void setInterchangeLocalGeneralLocalIndicator(
	String interchangeLocalGeneralLocalIndicator) {
	this.interchangeLocalGeneralLocalIndicator = interchangeLocalGeneralLocalIndicator;
    }

    /**
     * Obtiene el valor del par�metro
     * interchangeWithRestrictionCityHallCityHallIndicator.
     * 
     * @return interchangeWithRestrictionCityHallCityHallIndicator valor del
     *         campo a obtener.
     */
    public String getInterchangeWithRestrictionCityHallCityHallIndicator() {
	return interchangeWithRestrictionCityHallCityHallIndicator;
    }

    /**
     * Guarda el valor del par�metro
     * interchangeWithRestrictionCityHallCityHallIndicator.
     * 
     * @param interchangeWithRestrictionCityHallCityHallIndicator
     *            valor del campo a guardar.
     */
    public void setInterchangeWithRestrictionCityHallCityHallIndicator(
	String interchangeWithRestrictionCityHallCityHallIndicator) {
	this.interchangeWithRestrictionCityHallCityHallIndicator =
	    interchangeWithRestrictionCityHallCityHallIndicator;
    }

    /**
     * Obtiene el valor del par�metro creationDate.
     * 
     * @return creationDate valor del campo a obtener.
     */
    public Date getCreationDate() {
	return creationDate;
    }

    /**
     * Guarda el valor del par�metro creationDate.
     * 
     * @param creationDate
     *            valor del campo a guardar.
     */
    public void setCreationDate(
	Date creationDate) {
	this.creationDate = creationDate;
    }

    /**
     * Obtiene el valor del par�metro extinctionDate.
     * 
     * @return extinctionDate valor del campo a obtener.
     */
    public Date getExtinctionDate() {
	return extinctionDate;
    }

    /**
     * Guarda el valor del par�metro extinctionDate.
     * 
     * @param extinctionDate
     *            valor del campo a guardar.
     */
    public void setExtinctionDate(
	Date extinctionDate) {
	this.extinctionDate = extinctionDate;
    }

    /**
     * Obtiene el valor del par�metro annulationDate.
     * 
     * @return annulationDate valor del campo a obtener.
     */
    public Date getAnnulationDate() {
	return annulationDate;
    }

    /**
     * Guarda el valor del par�metro annulationDate.
     * 
     * @param annulationDate
     *            valor del campo a guardar.
     */
    public void setAnnulationDate(
	Date annulationDate) {
	this.annulationDate = annulationDate;
    }

    /**
     * Obtiene el valor del par�metro generalObservations.
     * 
     * @return generalObservations valor del campo a obtener.
     */
    public String getGeneralObservations() {
	return generalObservations;
    }

    /**
     * Guarda el valor del par�metro generalObservations.
     * 
     * @param generalObservations
     *            valor del campo a guardar.
     */
    public void setGeneralObservations(
	String generalObservations) {
	this.generalObservations = generalObservations;
    }

    /**
     * Obtiene el valor del par�metro deleteObservations.
     * 
     * @return deleteObservations valor del campo a obtener.
     */
    public String getDeleteObservations() {
	return deleteObservations;
    }

    /**
     * Guarda el valor del par�metro deleteObservations.
     * 
     * @param deleteObservations
     *            valor del campo a guardar.
     */
    public void setDeleteObservations(
	String deleteObservations) {
	this.deleteObservations = deleteObservations;
    }

    /**
     * Obtiene el valor del par�metro contactObservations.
     * 
     * @return contactObservations valor del campo a obtener.
     */
    public String getContactObservations() {
	return contactObservations;
    }

    /**
     * Guarda el valor del par�metro contactObservations.
     * 
     * @param contactObservations
     *            valor del campo a guardar.
     */
    public void setContactObservations(
	String contactObservations) {
	this.contactObservations = contactObservations;
    }

    /**
     * Obtiene el valor del par�metro bSameAddress.
     * 
     * @return bSameAddress valor del campo a obtener.
     */
    public String getBSameAddress() {
	return bSameAddress;
    }

    /**
     * Guarda el valor del par�metro bSameAddress.
     * 
     * @param bSameAddress
     *            valor del campo a guardar.
     */
    public void setBSameAddress(
	String bSameAddress) {
	this.bSameAddress = bSameAddress;
    }

    /**
     * Obtiene el valor del par�metro businessHours.
     * 
     * @return businessHours valor del campo a obtener.
     */
    public String getBusinessHours() {
	return businessHours;
    }

    /**
     * Guarda el valor del par�metro businessHours.
     * 
     * @param businessHours
     *            valor del campo a guardar.
     */
    public void setBusinessHours(
	String businessHours) {
	this.businessHours = businessHours;
    }

    /**
     * Obtiene el valor del par�metro inhabiliesDays.
     * 
     * @return inhabiliesDays valor del campo a obtener.
     */
    public String getInhabiliesDays() {
	return inhabiliesDays;
    }

    /**
     * Guarda el valor del par�metro inhabiliesDays.
     * 
     * @param inhabiliesDays
     *            valor del campo a guardar.
     */
    public void setInhabiliesDays(
	String inhabiliesDays) {
	this.inhabiliesDays = inhabiliesDays;
    }

    /**
     * Obtiene el valor del par�metro address.
     * 
     * @return address valor del campo a obtener.
     */
    public Address getAddress() {
	return address;
    }

    /**
     * Guarda el valor del par�metro address.
     * 
     * @param address
     *            valor del campo a guardar.
     */
    public void setAddress(
	Address address) {
	this.address = address;
    }

    /**
     * Obtiene el valor del par�metro contacts.
     * 
     * @return contacts valor del campo a obtener.
     */
    public List<Contact> getContacts() {
	return contacts;
    }

    /**
     * Guarda el valor del par�metro contacts.
     * 
     * @param contacts
     *            valor del campo a guardar.
     */
    public void setContacts(
	List<Contact> contacts) {
	this.contacts = contacts;
    }

    /**
     * Obtiene el valor del par�metro services.
     * 
     * @return services valor del campo a obtener.
     */
    public List<Service> getServices() {
	return services;
    }

    /**
     * Guarda el valor del par�metro services.
     * 
     * @param services
     *            valor del campo a guardar.
     */
    public void setServices(
	List<Service> services) {
	this.services = services;
    }

    /**
     * Obtiene el valor del par�metro relationshipsSIROFI.
     * 
     * @return relationshipsSIROFI valor del campo a obtener.
     */
    public List<BasicDataUnit> getRelationshipsSIROFI() {
	return relationshipsSIROFI;
    }

    /**
     * Guarda el valor del par�metro relationshipsSIROFI.
     * 
     * @param relationshipsSIROFI
     *            valor del campo a guardar.
     */
    public void setRelationshipsSIROFI(
	List<BasicDataUnit> relationshipsSIROFI) {
	this.relationshipsSIROFI = relationshipsSIROFI;
    }

    /**
     * Obtiene el valor del par�metro organizationalRelationshipsOFI.
     * 
     * @return organizationalRelationshipsOFI valor del campo a obtener.
     */
    public List<BasicDataUnit> getOrganizationalRelationshipsOFI() {
	return organizationalRelationshipsOFI;
    }

    /**
     * Guarda el valor del par�metro organizationalRelationshipsOFI.
     * 
     * @param organizationalRelationshipsOFI
     *            valor del campo a guardar.
     */
    public void setOrganizationalRelationshipsOFI(
	List<BasicDataUnit> organizationalRelationshipsOFI) {
	this.organizationalRelationshipsOFI = organizationalRelationshipsOFI;
    }

}
