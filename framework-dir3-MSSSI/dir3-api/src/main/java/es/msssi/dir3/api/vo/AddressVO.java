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
 * Datos b�sicos de la direcci�n una oficina.
 * 
 * @author cmorenog
 * 
 */
public class AddressVO extends Entity {

    private static final long serialVersionUID = 5515960788820716930L;
    /**
     * Id del tipo de v�a.
     */
    private String streetTypeId;

    /**
     * Descripci�n del tipo de v�a.
     */
    private String streetTypeName;

    /**
     * Nombre de la v�a.
     */
    private String streetName;

    /**
     * N�mero de la v�a.
     */
    private String addressNum;

    /**
     * Informaci�n complementar�a de la direcci�n.
     */
    private String addessInformation;

    /**
     * C�digo postal de la direcci�n.
     */
    private String postalCode;

    /**
     * Id del pa�s de la direcci�n.
     */
    private String countryId;

    /**
     * Nombre del pa�s de la direcci�n.
     */
    private String countryName;

    /**
     * Id de la CCAA de la direcci�n.
     */
    private String autonomousCommunityId;

    /**
     * Nombre de la CCAA de la direcci�n.
     */
    private String autonomousCommunityName;

    /**
     * Id de la entidad geogr�fica de la direcci�n.
     */
    private String geographicalEntityId;

    /**
     * Descripci�n de la entidad geogr�fica de la direcci�n.
     */
    private String geographicalEntityName;

    /**
     * Id de la provincia de la direcci�n.
     */
    private String provinceId;

    /**
     * Descripci�n de la provincia de la direcci�n.
     */
    private String provinceName;

    /**
     * Id de la localidad de la direcci�n.
     */
    private String cityId;

    /**
     * Descripci�n de la direcci�n.
     */
    private String cityName;

    /**
     * Localidad en la que ejerce las competencias la UNIDAD, cuando el Pa�s no
     * es Espa�a.
     */
    private String foreignLocation;

    /**
     * Direcci�n no normalizada para Unidades con sede ubicada en el extranjero.
     */
    private String foreignAddress;

    /**
     * Observaciones de la direcci�n.
     */
    private String observations;

    /**
     * Obtiene el valor del par�metro streetTypeId.
     * 
     * @return streetTypeId valor del campo a obtener.
     */
    public String getStreetTypeId() {
	return streetTypeId;
    }

    /**
     * Guarda el valor del par�metro streetTypeId.
     * 
     * @param streetTypeId
     *            valor del campo a guardar.
     */
    public void setStreetTypeId(
	String streetTypeId) {
	this.streetTypeId = streetTypeId;
    }

    /**
     * Obtiene el valor del par�metro streetTypeName.
     * 
     * @return streetTypeName valor del campo a obtener.
     */
    public String getStreetTypeName() {
	return streetTypeName;
    }

    /**
     * Guarda el valor del par�metro streetTypeName.
     * 
     * @param streetTypeName
     *            valor del campo a guardar.
     */
    public void setStreetTypeName(
	String streetTypeName) {
	this.streetTypeName = streetTypeName;
    }

    /**
     * Obtiene el valor del par�metro streetName.
     * 
     * @return streetName valor del campo a obtener.
     */
    public String getStreetName() {
	return streetName;
    }

    /**
     * Guarda el valor del par�metro streetName.
     * 
     * @param streetName
     *            valor del campo a guardar.
     */
    public void setStreetName(
	String streetName) {
	this.streetName = streetName;
    }

    /**
     * Obtiene el valor del par�metro addressNum.
     * 
     * @return addressNum valor del campo a obtener.
     */
    public String getAddressNum() {
	return addressNum;
    }

    /**
     * Guarda el valor del par�metro addressNum.
     * 
     * @param addressNum
     *            valor del campo a guardar.
     */
    public void setAddressNum(
	String addressNum) {
	this.addressNum = addressNum;
    }

    /**
     * Obtiene el valor del par�metro addessInformation.
     * 
     * @return addessInformation valor del campo a obtener.
     */
    public String getAddessInformation() {
	return addessInformation;
    }

    /**
     * Guarda el valor del par�metro addessInformation.
     * 
     * @param addessInformation
     *            valor del campo a guardar.
     */
    public void setAddessInformation(
	String addessInformation) {
	this.addessInformation = addessInformation;
    }

    /**
     * Obtiene el valor del par�metro postalCode.
     * 
     * @return postalCode valor del campo a obtener.
     */
    public String getPostalCode() {
	return postalCode;
    }

    /**
     * Guarda el valor del par�metro postalCode.
     * 
     * @param postalCode
     *            valor del campo a guardar.
     */
    public void setPostalCode(
	String postalCode) {
	this.postalCode = postalCode;
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
     * Obtiene el valor del par�metro foreignAddress.
     * 
     * @return foreignAddress valor del campo a obtener.
     */
    public String getForeignAddress() {
	return foreignAddress;
    }

    /**
     * Guarda el valor del par�metro foreignAddress.
     * 
     * @param foreignAddress
     *            valor del campo a guardar.
     */
    public void setForeignAddress(
	String foreignAddress) {
	this.foreignAddress = foreignAddress;
    }

}
