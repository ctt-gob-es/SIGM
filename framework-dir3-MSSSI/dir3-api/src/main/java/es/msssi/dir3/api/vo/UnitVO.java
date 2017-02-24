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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Informaci�n de una unidad org�nica.
 * 
 * @author cmorenog
 * 
 */
public class UnitVO extends BasicDataUnitVO {

    private static final long serialVersionUID = 5515960788820716930L;

    /**
     * Datos Identificativos y Estructurales
     */

    /**
     * Siglas de la unidad.
     */
    private String acronyms;

    /**
     * Unidad ra�z (m�ximo nivel jer�rquico en la entidad p�blica a la que
     * pertenece la unidad).
     */
    private String principalUnitId;

    /**
     * Denominaci�n de la unidad ra�z (m�ximo nivel jer�rquico en la entidad
     * p�blica a la que pertenece la unidad).
     */
    private String principalUnitName;

    /**
     * Nivel jer�rquico en la estructura de la entidad p�blica (secuencial).
     */
    private Integer publicEntityLevel;

    /**
     * Indicador de si la unidad pertenece a una Entidad de Derecho P�blico.
     */
    private String entityPublicLawIndicator;

    /**
     * C�digo del nivel de administraci�n (Estatal, Auton�mica o Local)
     */
    private String administrationLevelId;

    /**
     * Descripci�n del nivel de administraci�n.
     */
    private String administrationLevelName;

    /**
     * Id de tipo de entidad p�blica.
     */
    private String publicEntityTypeId;

    /**
     * Descripci�n de tipo de entidad p�blica.
     */
    private String publicEntityTypeName;
    /**
     * 
     * Id de tipo de unidad.
     */
    private String unitTypeId;

    /**
     * Descripci�n de tipo de unidad.
     */
    private String unitTypeName;

    /**
     * Unidad ra�z que representa a la Administraci�n a la que est� vinculada
     * una Entidad de Derecho P�blico.
     */
    private String entityUnitOfPublicLawId;

    /**
     * Denominaci�n de la unidad ra�z que representa a la Administraci�n a la
     * que est� vinculada una Entidad de Derecho P�blico.
     */
    private String entityUnitOfPublicLawName;

    /**
     * Id del poder.
     */
    private Integer authorityId;

    /**
     * Descripci�n del poder.
     */
    private String authorityName;

    /**
     * �mbito Territorial de Ejercicio de Competencias
     */

    /**
     * Id del �mbito Territorial de Ejercicio de Competencias.
     */
    private String territorialScopeOfCompetenceId;

    /**
     * Descripci�n del �mbito Territorial de Ejercicio de Competencias.
     */
    private String territorialScopeOfCompetenceName;

    /**
     * Id de la entidad geogr�fica.
     */
    private String geographicalEntityId;

    /**
     * Descripci�n de la entidad geogr�fica.
     */
    private String geographicalEntityName;

    /**
     * Id del pa�s.
     */
    private String countryId;
    /**
     * Descripci�n del pa�s.
     */
    private String countryName;

    /**
     * Id de la CCAA.
     */
    private String autonomousCommunityId;

    /**
     * Descripci�n de la CCAA.
     */
    private String autonomousCommunityName;

    /**
     * Id de la provincia.
     */
    private String provinceId;

    /**
     * Descripci�n de la provincia.
     */
    private String provinceName;

    /**
     * Id de la isla.
     */
    private String islandId;
    /**
     * Descripci�n de la isla.
     */
    private String islandName;

    /**
     * Id del municipio.
     */
    private String cityId;

    /**
     * Descripci�n del municipio.
     */
    private String cityName;

    /**
     * Id de la entidad local menor.
     */
    private String minorLocalEntityId;

    /**
     * Descripci�n de la entidad local menor.
     */
    private String minorLocalEntityName;

    /**
     * Id de la localidad extranjera.
     */
    private String foreignLocation;

    /**
     * Descripci�n de las funciones que corresponden a la Unidad Org�nica.
     */
    private String competencesOfUnit;

    /**
     * Identificaci�n de la Disposici�n Legal que regula las competencias de la
     * Unidad.
     */
    private String legalProvisionOfCompetencesOfUnit;

    /**
     * Datos de Locaclizaci�n de la Unidad Org�nica
     */
    /**
     * Si tiene la misma direcci�n que su unidad superior.
     */
    private String bSameAddressFatherUnit;
    /**
     * Direcci�n de la unidad.
     */
    private AddressVO address;

    /**
     * Datos de Vigencia de la Unidad Org�nica
     */

    /**
     * Fecha de creaci�n oficial.
     */
    private Date addOfficialDate;

    /**
     * Fecha de supresi�n oficial.
     */
    private Date deleteOfficialDate;

    /**
     * Fecha de extinci�n final.
     */
    private Date extinctionDate;

    /**
     * Fecha de anulaci�n.
     */
    private Date annulationDate;

    /**
     * Datos de auditor�a y control
     */

    /**
     * C�digo externo utilizado por la entidad p�blica que aporta los datos al
     * Directorio Com�n.
     */
    private String externalId;

    /**
     * Fecha de alta en el sistema.
     */
    private Date systemCreationDate;
    /**
     * Fecha de la �ltima actualizaci�n.
     */
    private Date lastUpdateDate;

    /**
     * Id del organismo raiz.
     */
    private String rootUnit;

    /**
     * el cif de la unidad.
     */
    private String cif;

    /**
     * C�digo del dioma.
     */
    private Integer language;

    /**
     * Lista de datos de contacto de la unidad.
     */
    private List<ContactUOVO> contacts;

    /**
     * Datos de observaciones
     */

    /**
     * Observaciones generales.
     */
    private String generalObservations;

    /**
     * Observaciones de baja.
     */
    private String deleteObservations;

    /**
     * Observaciones de contacto.
     */
    private String contactObservations;
    /**
     * Oficina que da servicio de sir a la unidad.
     */
    private BasicDataOfficeVO relationshipsSIRUO;
    /**
     * Lista de oficinas relacionadas con la unidad.
     */
    private List<BasicDataOfficeVO> organizationalRelationshipsUO;

    /**
     * tipo unidad no organica.
     */
    private Integer unoUnitTypeId;
    

    /**
     * unidad responsable no organica.
     */
    private String unoCodUOResponsable;
    

    /**
     * unidad responsable  no organica.
     */
    private String unoDescUOResponsable;

    /**
     * observaciones  no organica.
     */
    private String unoobservations;
    
    /**
     * 1 si es una unidad organica; 0 si es una unidad no organica
     */
    private Integer typeUnit = 1;
    /**
     * Constructor.
     */
    public UnitVO() {
	super();
    }

    /**
     * Obtiene el valor del par�metro acronyms.
     * 
     * @return acronyms valor del campo a obtener.
     */
    public String getAcronyms() {
	return acronyms;
    }

    /**
     * Guarda el valor del par�metro acronyms.
     * 
     * @param acronyms
     *            valor del campo a guardar.
     */
    public void setAcronyms(
	String acronyms) {
	this.acronyms = acronyms;
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
     * Obtiene el valor del par�metro entityPublicLawIndicator.
     * 
     * @return entityPublicLawIndicator valor del campo a obtener.
     */
    public String getEntityPublicLawIndicator() {
	return entityPublicLawIndicator;
    }

    /**
     * Guarda el valor del par�metro entityPublicLawIndicator.
     * 
     * @param entityPublicLawIndicator
     *            valor del campo a guardar.
     */
    public void setEntityPublicLawIndicator(
	String entityPublicLawIndicator) {
	this.entityPublicLawIndicator = entityPublicLawIndicator;
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
     * Obtiene el valor del par�metro principalUnitId.
     * 
     * @return principalUnitId valor del campo a obtener.
     */
    public String getPrincipalUnitId() {
	return principalUnitId;
    }

    /**
     * Guarda el valor del par�metro principalUnitId.
     * 
     * @param principalUnitId
     *            valor del campo a guardar.
     */
    public void setPrincipalUnitId(
	String principalUnitId) {
	this.principalUnitId = principalUnitId;
    }

    /**
     * Obtiene el valor del par�metro principalUnitName.
     * 
     * @return principalUnitName valor del campo a obtener.
     */
    public String getPrincipalUnitName() {
	return principalUnitName;
    }

    /**
     * Guarda el valor del par�metro principalUnitName.
     * 
     * @param principalUnitName
     *            valor del campo a guardar.
     */
    public void setPrincipalUnitName(
	String principalUnitName) {
	this.principalUnitName = principalUnitName;
    }

    /**
     * Obtiene el valor del par�metro entityUnitOfPublicLawId.
     * 
     * @return entityUnitOfPublicLawId valor del campo a obtener.
     */
    public String getEntityUnitOfPublicLawId() {
	return entityUnitOfPublicLawId;
    }

    /**
     * Guarda el valor del par�metro entityUnitOfPublicLawId.
     * 
     * @param entityUnitOfPublicLawId
     *            valor del campo a guardar.
     */
    public void setEntityUnitOfPublicLawId(
	String entityUnitOfPublicLawId) {
	this.entityUnitOfPublicLawId = entityUnitOfPublicLawId;
    }

    /**
     * Obtiene el valor del par�metro entityUnitOfPublicLawName.
     * 
     * @return entityUnitOfPublicLawName valor del campo a obtener.
     */
    public String getEntityUnitOfPublicLawName() {
	return entityUnitOfPublicLawName;
    }

    /**
     * Guarda el valor del par�metro entityUnitOfPublicLawName.
     * 
     * @param entityUnitOfPublicLawName
     *            valor del campo a guardar.
     */
    public void setEntityUnitOfPublicLawName(
	String entityUnitOfPublicLawName) {
	this.entityUnitOfPublicLawName = entityUnitOfPublicLawName;
    }

    /**
     * Obtiene el valor del par�metro publicEntityLevel.
     * 
     * @return publicEntityLevel valor del campo a obtener.
     */
    public Integer getPublicEntityLevel() {
	return publicEntityLevel;
    }

    /**
     * Guarda el valor del par�metro publicEntityLevel.
     * 
     * @param publicEntityLevel
     *            valor del campo a guardar.
     */
    public void setPublicEntityLevel(
	Integer publicEntityLevel) {
	this.publicEntityLevel = publicEntityLevel;
    }

    /**
     * Obtiene el valor del par�metro publicEntityTypeId.
     * 
     * @return publicEntityTypeId valor del campo a obtener.
     */
    public String getPublicEntityTypeId() {
	return publicEntityTypeId;
    }

    /**
     * Guarda el valor del par�metro publicEntityTypeId.
     * 
     * @param publicEntityTypeId
     *            valor del campo a guardar.
     */
    public void setPublicEntityTypeId(
	String publicEntityTypeId) {
	this.publicEntityTypeId = publicEntityTypeId;
    }

    /**
     * Obtiene el valor del par�metro publicEntityTypeName.
     * 
     * @return publicEntityTypeName valor del campo a obtener.
     */
    public String getPublicEntityTypeName() {
	return publicEntityTypeName;
    }

    /**
     * Guarda el valor del par�metro publicEntityTypeName.
     * 
     * @param publicEntityTypeName
     *            valor del campo a guardar.
     */
    public void setPublicEntityTypeName(
	String publicEntityTypeName) {
	this.publicEntityTypeName = publicEntityTypeName;
    }

    /**
     * Obtiene el valor del par�metro unitTypeId.
     * 
     * @return unitTypeId valor del campo a obtener.
     */
    public String getUnitTypeId() {
	return unitTypeId;
    }

    /**
     * Guarda el valor del par�metro unitTypeId.
     * 
     * @param unitTypeId
     *            valor del campo a guardar.
     */
    public void setUnitTypeId(
	String unitTypeId) {
	this.unitTypeId = unitTypeId;
    }

    /**
     * Obtiene el valor del par�metro unitTypeName.
     * 
     * @return unitTypeName valor del campo a obtener.
     */
    public String getUnitTypeName() {
	return unitTypeName;
    }

    /**
     * Guarda el valor del par�metro unitTypeName.
     * 
     * @param unitTypeName
     *            valor del campo a guardar.
     */
    public void setUnitTypeName(
	String unitTypeName) {
	this.unitTypeName = unitTypeName;
    }

    /**
     * Obtiene el valor del par�metro authorityId.
     * 
     * @return authorityId valor del campo a obtener.
     */
    public Integer getAuthorityId() {
	return authorityId;
    }

    /**
     * Guarda el valor del par�metro authorityId.
     * 
     * @param authorityId
     *            valor del campo a guardar.
     */
    public void setAuthorityId(
	Integer authorityId) {
	this.authorityId = authorityId;
    }

    /**
     * Obtiene el valor del par�metro authorityName.
     * 
     * @return authorityName valor del campo a obtener.
     */
    public String getAuthorityName() {
	return authorityName;
    }

    /**
     * Guarda el valor del par�metro authorityName.
     * 
     * @param authorityName
     *            valor del campo a guardar.
     */
    public void setAuthorityName(
	String authorityName) {
	this.authorityName = authorityName;
    }

    /**
     * Obtiene el valor del par�metro bSameAddressFatherUnit.
     * 
     * @return bSameAddressFatherUnit valor del campo a obtener.
     */
    public String getBSameAddressFatherUnit() {
	return bSameAddressFatherUnit;
    }

    /**
     * Guarda el valor del par�metro bSameAddressFatherUnit.
     * 
     * @param bSameAddressFatherUnit
     *            valor del campo a guardar.
     */
    public void setBSameAddressFatherUnit(
	String bSameAddressFatherUnit) {
	this.bSameAddressFatherUnit = bSameAddressFatherUnit;
    }

    /**
     * Obtiene el valor del par�metro address.
     * 
     * @return address valor del campo a obtener.
     */
    public AddressVO getAddress() {
	return address;
    }

    /**
     * Guarda el valor del par�metro address.
     * 
     * @param address
     *            valor del campo a guardar.
     */
    public void setAddress(
	AddressVO address) {
	this.address = address;
    }

    /**
     * Obtiene el valor del par�metro addOfficialDate.
     * 
     * @return addOfficialDate valor del campo a obtener.
     */
    public Date getAddOfficialDate() {
	return addOfficialDate;
    }

    /**
     * Guarda el valor del par�metro addOfficialDate.
     * 
     * @param addOfficialDate
     *            valor del campo a guardar.
     */
    public void setAddOfficialDate(
	Date addOfficialDate) {
	this.addOfficialDate = addOfficialDate;
    }

    /**
     * Obtiene el valor del par�metro deleteOfficialDate.
     * 
     * @return deleteOfficialDate valor del campo a obtener.
     */
    public Date getDeleteOfficialDate() {
	return deleteOfficialDate;
    }

    /**
     * Guarda el valor del par�metro deleteOfficialDate.
     * 
     * @param deleteOfficialDate
     *            valor del campo a guardar.
     */
    public void setDeleteOfficialDate(
	Date deleteOfficialDate) {
	this.deleteOfficialDate = deleteOfficialDate;
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
     * Obtiene el valor del par�metro territorialScopeOfCompetenceId.
     * 
     * @return territorialScopeOfCompetenceId valor del campo a obtener.
     */
    public String getTerritorialScopeOfCompetenceId() {
	return territorialScopeOfCompetenceId;
    }

    /**
     * Guarda el valor del par�metro territorialScopeOfCompetenceId.
     * 
     * @param territorialScopeOfCompetenceId
     *            valor del campo a guardar.
     */
    public void setTerritorialScopeOfCompetenceId(
	String territorialScopeOfCompetenceId) {
	this.territorialScopeOfCompetenceId = territorialScopeOfCompetenceId;
    }

    /**
     * Obtiene el valor del par�metro territorialScopeOfCompetenceName.
     * 
     * @return territorialScopeOfCompetenceName valor del campo a obtener.
     */
    public String getTerritorialScopeOfCompetenceName() {
	return territorialScopeOfCompetenceName;
    }

    /**
     * Guarda el valor del par�metro territorialScopeOfCompetenceName.
     * 
     * @param territorialScopeOfCompetenceName
     *            valor del campo a guardar.
     */
    public void setTerritorialScopeOfCompetenceName(
	String territorialScopeOfCompetenceName) {
	this.territorialScopeOfCompetenceName = territorialScopeOfCompetenceName;
    }

    /**
     * Obtiene el valor del par�metro geographicalEntityId.
     * 
     * @return geographicalEntityId valor del campo a obtener.
     */
    public String getGeographicalEntityId() {
	return geographicalEntityId;
    }

    /**
     * Guarda el valor del par�metro geographicalEntityId.
     * 
     * @param geographicalEntityId
     *            valor del campo a guardar.
     */
    public void setGeographicalEntityId(
	String geographicalEntityId) {
	this.geographicalEntityId = geographicalEntityId;
    }

    /**
     * Obtiene el valor del par�metro geographicalEntityName.
     * 
     * @return geographicalEntityName valor del campo a obtener.
     */
    public String getGeographicalEntityName() {
	return geographicalEntityName;
    }

    /**
     * Guarda el valor del par�metro geographicalEntityName.
     * 
     * @param geographicalEntityName
     *            valor del campo a guardar.
     */
    public void setGeographicalEntityName(
	String geographicalEntityName) {
	this.geographicalEntityName = geographicalEntityName;
    }

    /**
     * Obtiene el valor del par�metro countryId.
     * 
     * @return countryId valor del campo a obtener.
     */
    public String getCountryId() {
	return countryId;
    }

    /**
     * Guarda el valor del par�metro countryId.
     * 
     * @param countryId
     *            valor del campo a guardar.
     */
    public void setCountryId(
	String countryId) {
	this.countryId = countryId;
    }

    /**
     * Obtiene el valor del par�metro countryName.
     * 
     * @return countryName valor del campo a obtener.
     */
    public String getCountryName() {
	return countryName;
    }

    /**
     * Guarda el valor del par�metro countryName.
     * 
     * @param countryName
     *            valor del campo a guardar.
     */
    public void setCountryName(
	String countryName) {
	this.countryName = countryName;
    }

    /**
     * Obtiene el valor del par�metro autonomousCommunityId.
     * 
     * @return autonomousCommunityId valor del campo a obtener.
     */
    public String getAutonomousCommunityId() {
	return autonomousCommunityId;
    }

    /**
     * Guarda el valor del par�metro autonomousCommunityId.
     * 
     * @param autonomousCommunityId
     *            valor del campo a guardar.
     */
    public void setAutonomousCommunityId(
	String autonomousCommunityId) {
	this.autonomousCommunityId = autonomousCommunityId;
    }

    /**
     * Obtiene el valor del par�metro autonomousCommunityName.
     * 
     * @return autonomousCommunityName valor del campo a obtener.
     */
    public String getAutonomousCommunityName() {
	return autonomousCommunityName;
    }

    /**
     * Guarda el valor del par�metro autonomousCommunityName.
     * 
     * @param autonomousCommunityName
     *            valor del campo a guardar.
     */
    public void setAutonomousCommunityName(
	String autonomousCommunityName) {
	this.autonomousCommunityName = autonomousCommunityName;
    }

    /**
     * Obtiene el valor del par�metro provinceId.
     * 
     * @return provinceId valor del campo a obtener.
     */
    public String getProvinceId() {
	return provinceId;
    }

    /**
     * Guarda el valor del par�metro provinceId.
     * 
     * @param provinceId
     *            valor del campo a guardar.
     */
    public void setProvinceId(
	String provinceId) {
	this.provinceId = provinceId;
    }

    /**
     * Obtiene el valor del par�metro provinceName.
     * 
     * @return provinceName valor del campo a obtener.
     */
    public String getProvinceName() {
	return provinceName;
    }

    /**
     * Guarda el valor del par�metro provinceName.
     * 
     * @param provinceName
     *            valor del campo a guardar.
     */
    public void setProvinceName(
	String provinceName) {
	this.provinceName = provinceName;
    }

    /**
     * Obtiene el valor del par�metro islandId.
     * 
     * @return islandId valor del campo a obtener.
     */
    public String getIslandId() {
	return islandId;
    }

    /**
     * Guarda el valor del par�metro islandId.
     * 
     * @param islandId
     *            valor del campo a guardar.
     */
    public void setIslandId(
	String islandId) {
	this.islandId = islandId;
    }

    /**
     * Obtiene el valor del par�metro islandName.
     * 
     * @return islandName valor del campo a obtener.
     */
    public String getIslandName() {
	return islandName;
    }

    /**
     * Guarda el valor del par�metro islandName.
     * 
     * @param islandName
     *            valor del campo a guardar.
     */
    public void setIslandName(
	String islandName) {
	this.islandName = islandName;
    }

    /**
     * Obtiene el valor del par�metro cityId.
     * 
     * @return cityId valor del campo a obtener.
     */
    public String getCityId() {
	return cityId;
    }

    /**
     * Guarda el valor del par�metro cityId.
     * 
     * @param cityId
     *            valor del campo a guardar.
     */
    public void setCityId(
	String cityId) {
	this.cityId = cityId;
    }

    /**
     * Obtiene el valor del par�metro cityName.
     * 
     * @return cityName valor del campo a obtener.
     */
    public String getCityName() {
	return cityName;
    }

    /**
     * Guarda el valor del par�metro cityName.
     * 
     * @param cityName
     *            valor del campo a guardar.
     */
    public void setCityName(
	String cityName) {
	this.cityName = cityName;
    }

    /**
     * Obtiene el valor del par�metro minorLocalEntityId.
     * 
     * @return minorLocalEntityId valor del campo a obtener.
     */
    public String getMinorLocalEntityId() {
	return minorLocalEntityId;
    }

    /**
     * Guarda el valor del par�metro minorLocalEntityId.
     * 
     * @param minorLocalEntityId
     *            valor del campo a guardar.
     */
    public void setMinorLocalEntityId(
	String minorLocalEntityId) {
	this.minorLocalEntityId = minorLocalEntityId;
    }

    /**
     * Obtiene el valor del par�metro minorLocalEntityName.
     * 
     * @return minorLocalEntityName valor del campo a obtener.
     */
    public String getMinorLocalEntityName() {
	return minorLocalEntityName;
    }

    /**
     * Guarda el valor del par�metro minorLocalEntityName.
     * 
     * @param minorLocalEntityName
     *            valor del campo a guardar.
     */
    public void setMinorLocalEntityName(
	String minorLocalEntityName) {
	this.minorLocalEntityName = minorLocalEntityName;
    }

    /**
     * Obtiene el valor del par�metro foreignLocation.
     * 
     * @return foreignLocation valor del campo a obtener.
     */
    public String getForeignLocation() {
	return foreignLocation;
    }

    /**
     * Guarda el valor del par�metro foreignLocation.
     * 
     * @param foreignLocation
     *            valor del campo a guardar.
     */
    public void setForeignLocation(
	String foreignLocation) {
	this.foreignLocation = foreignLocation;
    }

    /**
     * Obtiene el valor del par�metro competencesOfUnit.
     * 
     * @return competencesOfUnit valor del campo a obtener.
     */
    public String getCompetencesOfUnit() {
	return competencesOfUnit;
    }

    /**
     * Guarda el valor del par�metro competencesOfUnit.
     * 
     * @param competencesOfUnit
     *            valor del campo a guardar.
     */
    public void setCompetencesOfUnit(
	String competencesOfUnit) {
	this.competencesOfUnit = competencesOfUnit;
    }

    /**
     * Obtiene el valor del par�metro legalProvisionOfCompetencesOfUnit.
     * 
     * @return legalProvisionOfCompetencesOfUnit valor del campo a obtener.
     */
    public String getLegalProvisionOfCompetencesOfUnit() {
	return legalProvisionOfCompetencesOfUnit;
    }

    /**
     * Guarda el valor del par�metro legalProvisionOfCompetencesOfUnit.
     * 
     * @param legalProvisionOfCompetencesOfUnit
     *            valor del campo a guardar.
     */
    public void setLegalProvisionOfCompetencesOfUnit(
	String legalProvisionOfCompetencesOfUnit) {
	this.legalProvisionOfCompetencesOfUnit = legalProvisionOfCompetencesOfUnit;
    }

    /**
     * Obtiene el valor del par�metro rootUnit.
     * 
     * @return rootUnit valor del campo a obtener.
     */
    public String getRootUnit() {
	return rootUnit;
    }

    /**
     * Guarda el valor del par�metro rootUnit.
     * 
     * @param rootUnit
     *            valor del campo a guardar.
     */
    public void setRootUnit(
	String rootUnit) {
	this.rootUnit = rootUnit;
    }

    /**
     * Obtiene el valor del par�metro cif.
     * 
     * @return cif valor del campo a obtener.
     */
    public String getCif() {
	return cif;
    }

    /**
     * Guarda el valor del par�metro cif.
     * 
     * @param cif
     *            valor del campo a guardar.
     */
    public void setCif(
	String cif) {
	this.cif = cif;
    }

    /**
     * Obtiene el valor del par�metro language.
     * 
     * @return language valor del campo a obtener.
     */
    public Integer getLanguage() {
	return language;
    }

    /**
     * Guarda el valor del par�metro language.
     * 
     * @param language
     *            valor del campo a guardar.
     */
    public void setLanguage(
	Integer language) {
	this.language = language;
    }

    /**
     * Obtiene el valor del par�metro relationshipsSIRUO.
     * 
     * @return relationshipsSIRUO valor del campo a obtener.
     */
    public BasicDataOfficeVO getRelationshipsSIRUO() {
	return relationshipsSIRUO;
    }

    /**
     * Guarda el valor del par�metro relationshipsSIRUO.
     * 
     * @param relationshipsSIRUO
     *            valor del campo a guardar.
     */
    public void setRelationshipsSIRUO(
	BasicDataOfficeVO relationshipsSIRUO) {
	this.relationshipsSIRUO = relationshipsSIRUO;
    }

    /**
     * Obtiene el valor del par�metro organizationalRelationshipsUO.
     * 
     * @return organizationalRelationshipsUO valor del campo a obtener.
     */
    public List<BasicDataOfficeVO> getOrganizationalRelationshipsUO() {
	return organizationalRelationshipsUO;
    }

    /**
     * Guarda el valor del par�metro organizationalRelationshipsUO.
     * 
     * @param organizationalRelationshipsUO
     *            valor del campo a guardar.
     */
    public void setOrganizationalRelationshipsUO(
	List<BasicDataOfficeVO> organizationalRelationshipsUO) {
	this.organizationalRelationshipsUO = organizationalRelationshipsUO;
    }

    /**
     * a�ade el contacto a las lista de contactos.
     * 
     * @param contacto
     *            el contacto a guardar.
     */
    public void addContact(
	ContactUOVO contact) {
	if (this.contacts == null) {
	    this.contacts = new ArrayList<ContactUOVO>();
	}
	this.contacts.add(contact);
    }

    /**
     * Obtiene el valor del par�metro systemCreationDate.
     * 
     * @return systemCreationDate valor del campo a obtener.
     */
    public Date getSystemCreationDate() {
	return systemCreationDate;
    }

    /**
     * Guarda el valor del par�metro systemCreationDate.
     * 
     * @param systemCreationDate
     *            valor del campo a guardar.
     */
    public void setSystemCreationDate(
	Date systemCreationDate) {
	this.systemCreationDate = systemCreationDate;
    }

    /**
     * Obtiene el valor del par�metro lastUpdateDate.
     * 
     * @return lastUpdateDate valor del campo a obtener.
     */
    public Date getLastUpdateDate() {
	return lastUpdateDate;
    }

    /**
     * Guarda el valor del par�metro lastUpdateDate.
     * 
     * @param lastUpdateDate
     *            valor del campo a guardar.
     */
    public void setLastUpdateDate(
	Date lastUpdateDate) {
	this.lastUpdateDate = lastUpdateDate;
    }

    /**
     * Obtiene el valor del par�metro contacts.
     * 
     * @return contacts valor del campo a obtener.
     */
    public List<ContactUOVO> getContacts() {
	return contacts;
    }

    /**
     * Guarda el valor del par�metro contacts.
     * 
     * @param contacts
     *            valor del campo a guardar.
     */
    public void setContacts(
	List<ContactUOVO> contacts) {
	this.contacts = contacts;
    }
    /**
     * Obtiene el valor del par�metro unoUnitTypeId.
     * 
     * @return unoUnitTypeId valor del campo a obtener.
     */
    public Integer getUnoUnitTypeId() {
        return unoUnitTypeId;
    }
    /**
     * Guarda el valor del par�metro unoUnitTypeId.
     * 
     * @param unoUnitTypeId
     *            valor del campo a guardar.
     */
    public void setUnoUnitTypeId(Integer unoUnitTypeId) {
	this.unoUnitTypeId = unoUnitTypeId;
    }
    /**
     * Obtiene el valor del par�metro unoCodUOResponsable.
     * 
     * @return unoCodUOResponsable valor del campo a obtener.
     */
    public String getUnoCodUOResponsable() {
        return unoCodUOResponsable;
    }
    /**
     * Guarda el valor del par�metro unoCodUOResponsable.
     * 
     * @param unoCodUOResponsable
     *            valor del campo a guardar.
     */
    public void setUnoCodUOResponsable(String unoCodUOResponsable) {
	this.unoCodUOResponsable = unoCodUOResponsable;
    }
    /**
     * Obtiene el valor del par�metro unoDescUOResponsable.
     * 
     * @return unoDescUOResponsable valor del campo a obtener.
     */
    public String getUnoDescUOResponsable() {
        return unoDescUOResponsable;
    }
    /**
     * Guarda el valor del par�metro unoDescUOResponsable.
     * 
     * @param unoDescUOResponsable
     *            valor del campo a guardar.
     */
    public void setUnoDescUOResponsable(String unoDescUOResponsable) {
	this.unoDescUOResponsable = unoDescUOResponsable;
    }
    /**
     * Obtiene el valor del par�metro unoobservations.
     * 
     * @return unoobservations valor del campo a obtener.
     */
    public String getUnoobservations() {
        return unoobservations;
    }
    /**
     * Guarda el valor del par�metro UNOobservations.
     * 
     * @param UNOobservations
     *            valor del campo a guardar.
     */
    public void setUnoobservations(String unoobservations) {
	this.unoobservations = unoobservations;
    }
    /**
     * Obtiene el valor del par�metro typeUnit.
     * 
     * @return typeUnit valor del campo a obtener.
     */
    public Integer getTypeUnit() {
        return typeUnit;
    }
    /**
     * Guarda el valor del par�metro typeUnit.
     * 
     * @param typeUnit
     *            valor del campo a guardar.
     */
    public void setTypeUnit(Integer typeUnit) {
        this.typeUnit = typeUnit;
    }

}
