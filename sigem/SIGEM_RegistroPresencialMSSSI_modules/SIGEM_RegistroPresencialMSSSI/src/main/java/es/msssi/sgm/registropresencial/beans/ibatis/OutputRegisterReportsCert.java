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

import java.util.Date;

/**
 * Clase para manejar los datos de la tabla SCR_OREGREPORTSCERT desde Ibatis.
 * 
 * @author jortizs
 */
public class OutputRegisterReportsCert {
    // id de libro
    private Integer idBook;
    // id de registro
    private Integer fdrid;
    // timestamp
    private Date timestamp;
    // n�mero de registro
    private String fld1;
    // fecha de registro
    private Date fld2;
    // usuario
    private String fld3;
    // fecha de trabajo
    private Date fld4;
    // Id de la oficina de Registro
    private Integer fld5 = null;
    // Nombre oficina de registro
    private String fld5_text = null;
    // Direcci�n oficina de registro
    private String fld5_address = null;
    // Ciudad oficina de registro
    private String fld5_city = null;
    // Cod. postal oficina de registro
    private String fld5_zip = null;
    // Pa�s (provincia) oficina de registro
    private String fld5_country = null;
    // Tel�fono oficina de registro
    private String fld5_telephone = null;
    // Fax oficina de registro
    private String fld5_fax = null;
    // Email oficina de registro
    private String fld5_email = null;
    // Id de estado
    private Integer fld6 = null;
    // Id de Origen
    private Integer fld7 = null;
    // Nombre origen
    private String fld7_text = null;
    // Id de Destino
    private Integer fld8 = null;
    // Nombre destino
    private String fld8_text = null;
    // Remitentes
    private String fld9 = null;
    // Tipos de Transporte
    private String fld10 = null;
    // Numero de Transporte
    private String fld11 = null;
    // Tipo de asunto
    private Integer fld12 = null;
    // Nombre de asunto
    private String fld12_text = null;
    // Resumen
    private String fld13 = null;
    // Fecha del documento
    private Date fld15 = null;
    // Observaciones
    private String fld14 = null;
    // expone
    private String fld501 = null;
    // solicita
    private String fld502 = null;
    // rojo
    private String fld504 = null;
    // amarillo
    private String fld505 = null;
    // verde
    private String fld506 = null;
    /**
     * Constructor.
     * 
     */
    public OutputRegisterReportsCert() {

    }

    /**
     * Obtiene el valor del par�metro idBook.
     * 
     * @return idBook valor del campo a guardar.
     */
    public Integer getIdBook() {
	return idBook;
    }

    /**
     * Obtiene el valor del par�metro idBook.
     * 
     * @param idBook
     *            valor del campo a obtener.
     */
    public void setIdBook(Integer idBook) {
	this.idBook = idBook;
    }

    /**
     * Obtiene el valor del par�metro fdrid.
     * 
     * @return fdrid valor del campo a obtener.
     */
    public Integer getFdrid() {
	return fdrid;
    }

    /**
     * Guarda el valor del par�metro fdrid.
     * 
     * @param fdrid
     *            valor del campo a guardar.
     */
    public void setFdrid(Integer fdrid) {
	this.fdrid = fdrid;
    }

    /**
     * Obtiene el valor del par�metro timestamp.
     * 
     * @return timestamp valor del campo a obtener.
     */
    public Date getTimestamp() {
	return timestamp;
    }

    /**
     * Guarda el valor del par�metro timestamp.
     * 
     * @param timestamp
     *            valor del campo a guardar.
     */
    public void setTimestamp(Date timestamp) {
	this.timestamp = timestamp;
    }

    /**
     * Obtiene el valor del par�metro fld1.
     * 
     * @return fld1 valor del campo a obtener.
     */
    public String getFld1() {
	return fld1;
    }

    /**
     * Guarda el valor del par�metro fld1.
     * 
     * @param fld1
     *            valor del campo a guardar.
     */
    public void setFld1(String fld1) {
	this.fld1 = fld1;
    }

    /**
     * Obtiene el valor del par�metro fld2.
     * 
     * @return fld2 valor del campo a obtener.
     */
    public Date getFld2() {
	return fld2;
    }

    /**
     * Guarda el valor del par�metro fld2.
     * 
     * @param fld2
     *            valor del campo a guardar.
     */
    public void setFld2(Date fld2) {
	this.fld2 = fld2;
    }

    /**
     * Obtiene el valor del par�metro fld3.
     * 
     * @return fld3 valor del campo a obtener.
     */
    public String getFld3() {
	return fld3;
    }

    /**
     * Guarda el valor del par�metro fld3.
     * 
     * @param fld3
     *            valor del campo a guardar.
     */
    public void setFld3(String fld3) {
	this.fld3 = fld3;
    }

    /**
     * Obtiene el valor del par�metro fld4.
     * 
     * @return fld4 valor del campo a obtener.
     */
    public Date getFld4() {
	return fld4;
    }

    /**
     * Guarda el valor del par�metro fld4.
     * 
     * @param fld4
     *            valor del campo a guardar.
     */
    public void setFld4(Date fld4) {
	this.fld4 = fld4;
    }

    /**
     * Obtiene el valor del par�metro fld5.
     * 
     * @return fld5 valor del campo a obtener.
     */
    public Integer getFld5() {
	return fld5;
    }

    /**
     * Guarda el valor del par�metro fld5.
     * 
     * @param fld5
     *            valor del campo a guardar.
     */
    public void setFld5(Integer fld5) {
	this.fld5 = fld5;
    }

    /**
     * Obtiene el valor del par�metro fld5_text.
     * 
     * @return fld5_text valor del campo a obtener.
     */
    public String getFld5_text() {
	return fld5_text;
    }

    /**
     * Guarda el valor del par�metro fld5_text.
     * 
     * @param fld5_text
     *            valor del campo a guardar.
     */
    public void setFld5_text(String fld5_text) {
	this.fld5_text = fld5_text;
    }

    /**
     * Obtiene el valor del par�metro fld5_address.
     * 
     * @return fld5_address valor del campo a obtener.
     */
    public String getFld5_address() {
	return fld5_address;
    }

    /**
     * Guarda el valor del par�metro fld5_address.
     * 
     * @param fld5_address
     *            valor del campo a guardar.
     */
    public void setFld5_address(String fld5_address) {
	this.fld5_address = fld5_address;
    }

    /**
     * Obtiene el valor del par�metro fld5_city.
     * 
     * @return fld5_city valor del campo a obtener.
     */
    public String getFld5_city() {
	return fld5_city;
    }

    /**
     * Guarda el valor del par�metro fld5_city.
     * 
     * @param fld5_city
     *            valor del campo a guardar.
     */
    public void setFld5_city(String fld5_city) {
	this.fld5_city = fld5_city;
    }

    /**
     * Obtiene el valor del par�metro fld5_zip.
     * 
     * @return fld5_zip valor del campo a obtener.
     */
    public String getFld5_zip() {
	return fld5_zip;
    }

    /**
     * Guarda el valor del par�metro fld5_zip.
     * 
     * @param fld5_zip
     *            valor del campo a guardar.
     */
    public void setFld5_zip(String fld5_zip) {
	this.fld5_zip = fld5_zip;
    }

    /**
     * Obtiene el valor del par�metro fld5_country.
     * 
     * @return fld5_country valor del campo a obtener.
     */
    public String getFld5_country() {
	return fld5_country;
    }

    /**
     * Guarda el valor del par�metro fld5_country.
     * 
     * @param fld5_country
     *            valor del campo a guardar.
     */
    public void setFld5_country(String fld5_country) {
	this.fld5_country = fld5_country;
    }

    /**
     * Obtiene el valor del par�metro fld5_telephone.
     * 
     * @return fld5_telephone valor del campo a obtener.
     */
    public String getFld5_telephone() {
	return fld5_telephone;
    }

    /**
     * Guarda el valor del par�metro fld5_telephone.
     * 
     * @param fld5_telephone
     *            valor del campo a guardar.
     */
    public void setFld5_telephone(String fld5_telephone) {
	this.fld5_telephone = fld5_telephone;
    }

    /**
     * Obtiene el valor del par�metro fld5_fax.
     * 
     * @return fld5_fax valor del campo a obtener.
     */
    public String getFld5_fax() {
	return fld5_fax;
    }

    /**
     * Guarda el valor del par�metro fld5_fax.
     * 
     * @param fld5_fax
     *            valor del campo a guardar.
     */
    public void setFld5_fax(String fld5_fax) {
	this.fld5_fax = fld5_fax;
    }

    /**
     * Obtiene el valor del par�metro fld5_email.
     * 
     * @return fld5_email valor del campo a obtener.
     */
    public String getFld5_email() {
	return fld5_email;
    }

    /**
     * Guarda el valor del par�metro fld5_email.
     * 
     * @param fld5_email
     *            valor del campo a guardar.
     */
    public void setFld5_email(String fld5_email) {
	this.fld5_email = fld5_email;
    }

    /**
     * Obtiene el valor del par�metro fld6.
     * 
     * @return fld6 valor del campo a obtener.
     */
    public Integer getFld6() {
	return fld6;
    }

    /**
     * Guarda el valor del par�metro fld6.
     * 
     * @param fld6
     *            valor del campo a guardar.
     */
    public void setFld6(Integer fld6) {
	this.fld6 = fld6;
    }

    /**
     * Obtiene el valor del par�metro fld7.
     * 
     * @return fld7 valor del campo a obtener.
     */
    public Integer getFld7() {
	return fld7;
    }

    /**
     * Guarda el valor del par�metro fld7.
     * 
     * @param fld7
     *            valor del campo a guardar.
     */
    public void setFld7(Integer fld7) {
	this.fld7 = fld7;
    }

    /**
     * Obtiene el valor del par�metro fld7_text.
     * 
     * @return fld7_text valor del campo a obtener.
     */
    public String getFld7_text() {
	return fld7_text;
    }

    /**
     * Guarda el valor del par�metro fld7_text.
     * 
     * @param fld7_text
     *            valor del campo a guardar.
     */
    public void setFld7_text(String fld7_text) {
	this.fld7_text = fld7_text;
    }

    /**
     * Obtiene el valor del par�metro fld8.
     * 
     * @return fld8 valor del campo a obtener.
     */
    public Integer getFld8() {
	return fld8;
    }

    /**
     * Guarda el valor del par�metro fld8.
     * 
     * @param fld8
     *            valor del campo a guardar.
     */
    public void setFld8(Integer fld8) {
	this.fld8 = fld8;
    }

    /**
     * Obtiene el valor del par�metro fld8_text.
     * 
     * @return fld8_text valor del campo a obtener.
     */
    public String getFld8_text() {
	return fld8_text;
    }

    /**
     * Guarda el valor del par�metro fld8_text.
     * 
     * @param fld8_text
     *            valor del campo a guardar.
     */
    public void setFld8_text(String fld8_text) {
	this.fld8_text = fld8_text;
    }

    /**
     * Obtiene el valor del par�metro fld9.
     * 
     * @return fld9 valor del campo a obtener.
     */
    public String getFld9() {
	return fld9;
    }

    /**
     * Guarda el valor del par�metro fld9.
     * 
     * @param fld9
     *            valor del campo a guardar.
     */
    public void setFld9(String fld9) {
	this.fld9 = fld9;
    }

    /**
     * Obtiene el valor del par�metro fld10.
     * 
     * @return fld10 valor del campo a obtener.
     */
    public String getFld10() {
	return fld10;
    }

    /**
     * Guarda el valor del par�metro fld10.
     * 
     * @param fld10
     *            valor del campo a guardar.
     */
    public void setFld10(String fld10) {
	this.fld10 = fld10;
    }

    /**
     * Obtiene el valor del par�metro fld11.
     * 
     * @return fld11 valor del campo a obtener.
     */
    public String getFld11() {
	return fld11;
    }

    /**
     * Guarda el valor del par�metro fld11.
     * 
     * @param fld11
     *            valor del campo a guardar.
     */
    public void setFld11(String fld11) {
	this.fld11 = fld11;
    }

    /**
     * Obtiene el valor del par�metro fld12.
     * 
     * @return fld12 valor del campo a obtener.
     */
    public Integer getFld12() {
	return fld12;
    }

    /**
     * Guarda el valor del par�metro fld12.
     * 
     * @param fld12
     *            valor del campo a guardar.
     */
    public void setFld12(Integer fld12) {
	this.fld12 = fld12;
    }

    /**
     * Guarda el valor del par�metro fld12_text.
     * 
     * @param fld12_text
     *            valor del campo a guardar.
     */
    public void setFld12_text(String fld12_text) {
	this.fld12_text = fld12_text;
    }

    /**
     * Obtiene el valor del par�metro fld12_text.
     * 
     * @return fld12_text valor del campo a obtener.
     */
    public String getFld12_text() {
	return fld12_text;
    }

    /**
     * Obtiene el valor del par�metro fld13.
     * 
     * @return fld13 valor del campo a obtener.
     */
    public String getFld13() {
	return fld13;
    }

    /**
     * Guarda el valor del par�metro fld13.
     * 
     * @param fld13
     *            valor del campo a guardar.
     */
    public void setFld13(String fld13) {
	this.fld13 = fld13;
    }

    /**
     * Obtiene el valor del par�metro fld15.
     * 
     * @return fld15 valor del campo a obtener.
     */
    public Date getFld15() {
	return fld15;
    }

    /**
     * Guarda el valor del par�metro fld15.
     * 
     * @param fld15
     *            valor del campo a guardar.
     */
    public void setFld15(Date fld15) {
	this.fld15 = fld15;
    }
    /**
     * Obtiene el valor del par�metro fld14.
     * 
     * @return fld14 valor del campo a obtener.
     */
    public String getFld14() {
        return fld14;
    }
    /**
     * Guarda el valor del par�metro fld14.
     * 
     * @param fld14
     *            valor del campo a guardar.
     */
    public void setFld18(String fld14) {
        this.fld14 = fld14;
    }
    /**
     * Obtiene el valor del par�metro fld502.
     * 
     * @return fld502 valor del campo a obtener.
     */
    public String getFld502() {
        return fld502;
    }
    /**
     * Guarda el valor del par�metro fld502.
     * 
     * @param fld502
     *            valor del campo a guardar.
     */
    public void setFld502(String fld502) {
        this.fld502 = fld502;
    }
    /**
     * Obtiene el valor del par�metro fld501.
     * 
     * @return fld501 valor del campo a obtener.
     */
    public String getFld501() {
        return fld501;
    }
    /**
     * Guarda el valor del par�metro fld501.
     * 
     * @param fld501
     *            valor del campo a guardar.
     */
    public void setFld501(String fld501) {
        this.fld501 = fld501;
    }
    /**
     * Obtiene el valor del par�metro fld504.
     * 
     * @return fld504 valor del campo a obtener.
     */
    public String getFld504() {
        return fld504;
    }
    /**
     * Guarda el valor del par�metro fld504.
     * 
     * @param fld504
     *            valor del campo a guardar.
     */
    public void setFld504(String fld504) {
        this.fld504 = fld504;
    }
    /**
     * Obtiene el valor del par�metro fld505.
     * 
     * @return fld505 valor del campo a obtener.
     */
    public String getFld505() {
        return fld505;
    }
    /**
     * Guarda el valor del par�metro fld505.
     * 
     * @param fld505
     *            valor del campo a guardar.
     */
    public void setFld505(String fld505) {
        this.fld505 = fld505;
    }
    /**
     * Obtiene el valor del par�metro fld506.
     * 
     * @return fld506 valor del campo a obtener.
     */
    public String getFld506() {
        return fld506;
    }
    /**
     * Guarda el valor del par�metro fld506.
     * 
     * @param fld506
     *            valor del campo a guardar.
     */
    public void setFld506(String fld506) {
        this.fld506 = fld506;
    }
}