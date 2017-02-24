/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.sgm.registropresencial.beans.ibatis;

/**
 * Clase para manejar los datos de la tabla SCR_DIRORGS desde Ibatis, referentes
 * a la obtenci�n de la direcci�n de un organismo.
 * 
 * @author jortizs
 */
public class DirOrgs {
    // Id de la oficina de Registro
    private Integer id_orgs;
    // Direcci�n oficina de registro
    private String address;
    // Ciudad oficina de registro
    private String city;
    // Cod. postal oficina de registro
    private String zip;
    // Pa�s (provincia) oficina de registro
    private String country;
    // Tel�fono oficina de registro
    private String telephone;
    // Fax oficina de registro
    private String fax;
    // Email oficina de registro
    private String email;

    /**
     * Obtiene el valor del par�metro id_orgs.
     * 
     * @return id_orgs valor del campo a obtener.
     */
    public Integer getId_orgs() {
	return id_orgs;
    }

    /**
     * Guarda el valor del par�metro id_orgs.
     * 
     * @param id_orgs
     *            valor del campo a guardar.
     */
    public void setId_orgs(Integer id_orgs) {
	this.id_orgs = id_orgs;
    }

    /**
     * Obtiene el valor del par�metro address.
     * 
     * @return address valor del campo a obtener.
     */
    public String getAddress() {
	return address;
    }

    /**
     * Guarda el valor del par�metro address.
     * 
     * @param address
     *            valor del campo a guardar.
     */
    public void setAddress(String address) {
	this.address = address;
    }

    /**
     * Obtiene el valor del par�metro city.
     * 
     * @return city valor del campo a obtener.
     */
    public String getCity() {
	return city;
    }

    /**
     * Guarda el valor del par�metro city.
     * 
     * @param city
     *            valor del campo a guardar.
     */
    public void setCity(String city) {
	this.city = city;
    }

    /**
     * Obtiene el valor del par�metro zip.
     * 
     * @return zip valor del campo a obtener.
     */
    public String getZip() {
	return zip;
    }

    /**
     * Guarda el valor del par�metro zip.
     * 
     * @param zip
     *            valor del campo a guardar.
     */
    public void setZip(String zip) {
	this.zip = zip;
    }

    /**
     * Obtiene el valor del par�metro country.
     * 
     * @return country valor del campo a obtener.
     */
    public String getCountry() {
	return country;
    }

    /**
     * Guarda el valor del par�metro country.
     * 
     * @param country
     *            valor del campo a guardar.
     */
    public void setCountry(String country) {
	this.country = country;
    }

    /**
     * Obtiene el valor del par�metro telephone.
     * 
     * @return telephone valor del campo a obtener.
     */
    public String getTelephone() {
	return telephone;
    }

    /**
     * Guarda el valor del par�metro telephone.
     * 
     * @param telephone
     *            valor del campo a guardar.
     */
    public void setTelephone(String telephone) {
	this.telephone = telephone;
    }

    /**
     * Obtiene el valor del par�metro fax.
     * 
     * @return fax valor del campo a obtener.
     */
    public String getFax() {
	return fax;
    }

    /**
     * Guarda el valor del par�metro fax.
     * 
     * @param fax
     *            valor del campo a guardar.
     */
    public void setFax(String fax) {
	this.fax = fax;
    }

    /**
     * Obtiene el valor del par�metro email.
     * 
     * @return email valor del campo a obtener.
     */
    public String getEmail() {
	return email;
    }

    /**
     * Guarda el valor del par�metro email.
     * 
     * @param email
     *            valor del campo a guardar.
     */
    public void setEmail(String email) {
	this.email = email;
    }
}