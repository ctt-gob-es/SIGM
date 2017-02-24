package com.ieci.tecdoc.common.invesicres;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** 
 *        @hibernate.class
 *         table="SCR_DIRORGS"
 *     
*/
public class ScrDirorg implements Serializable {

    /** identifier field */
    private int idOrgs;

    /** identifier field */
    private String address;

    /** identifier field */
    private String city;

    /** identifier field */
    private String zip;

    /** identifier field */
    private String country;

    /** identifier field */
    private String telephone;

    /** identifier field */
    private String fax;

    /** identifier field */
    private String email;

    /** full constructor */
    public ScrDirorg(int idOrgs, String address, String city, String zip, String country, String telephone, String fax, String email) {
        this.idOrgs = idOrgs;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.country = country;
        this.telephone = telephone;
        this.fax = fax;
        this.email = email;
    }

    /** default constructor */
    public ScrDirorg() {
    }

    /** 
     *                @hibernate.property
     *                 column="ID_ORGS"
     *                 length="10"
     *             
     */
    public int getIdOrgs() {
        return this.idOrgs;
    }

    public void setIdOrgs(int idOrgs) {
        this.idOrgs = idOrgs;
    }

    /** 
     *                @hibernate.property
     *                 column="ADDRESS"
     *                 length="255"
     *             
     */
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /** 
     *                @hibernate.property
     *                 column="CITY"
     *                 length="100"
     *             
     */
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    /** 
     *                @hibernate.property
     *                 column="ZIP"
     *                 length="10"
     *             
     */
    public String getZip() {
        return this.zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    /** 
     *                @hibernate.property
     *                 column="COUNTRY"
     *                 length="100"
     *             
     */
    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    /** 
     *                @hibernate.property
     *                 column="TELEPHONE"
     *                 length="160"
     *             
     */
    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /** 
     *                @hibernate.property
     *                 column="FAX"
     *                 length="160"
     *             
     */
    public String getFax() {
        return this.fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    /** 
     *                @hibernate.property
     *                 column="EMAIL"
     *                 length="255"
     *             
     */
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("idOrgs", getIdOrgs())
            .append("address", getAddress())
            .append("city", getCity())
            .append("zip", getZip())
            .append("country", getCountry())
            .append("telephone", getTelephone())
            .append("fax", getFax())
            .append("email", getEmail())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ScrDirorg) ) return false;
        ScrDirorg castOther = (ScrDirorg) other;
        return new EqualsBuilder()
            .append(this.getIdOrgs(), castOther.getIdOrgs())
            .append(this.getAddress(), castOther.getAddress())
            .append(this.getCity(), castOther.getCity())
            .append(this.getZip(), castOther.getZip())
            .append(this.getCountry(), castOther.getCountry())
            .append(this.getTelephone(), castOther.getTelephone())
            .append(this.getFax(), castOther.getFax())
            .append(this.getEmail(), castOther.getEmail())
            .isEquals();
    }

    
         
                                       
//************************************
// Incluido pos ISicres-Common Oracle 9i


public String toXML() {
       String className = getClass().getName();
       className = className.substring(className.lastIndexOf(".") + 1, className.length()).toUpperCase();
       StringBuffer buffer = new StringBuffer();
       buffer.append("<");
       buffer.append(className);
       buffer.append(">");
       try {
           java.lang.reflect.Field[] fields = getClass().getDeclaredFields();
           java.lang.reflect.Field field = null;
           String name = null;
           int size = fields.length;
           for (int i = 0; i < size; i++) {
               field = fields[i];
               name = field.getName();
               buffer.append("<");
               buffer.append(name.toUpperCase());
               buffer.append(">");
               if (field.get(this) != null) {
                   buffer.append(field.get(this));
               }
               buffer.append("</");
               buffer.append(name.toUpperCase());
               buffer.append(">");
           }
       } catch (Exception e) {
           e.printStackTrace(System.err);
       }
       buffer.append("</");
       buffer.append(className);
       buffer.append(">");
       return buffer.toString();
}
                               
//************************************  
                                                                                                                                                                   
public int hashCode() {
      
        return new HashCodeBuilder()
            .append(getIdOrgs())
            .append(getAddress())
            .append(getCity())
            .append(getZip())
            .append(getCountry())
            .append(getTelephone())
            .append(getFax())
            .append(getEmail())
            .toHashCode();
    }

}
