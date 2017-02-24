package com.ieci.tecdoc.common.invesicres;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** 
 *        @hibernate.class
 *         table="SCR_VALNUM"
 *     
*/
public class ScrValnum implements Serializable {

    /** identifier field */
    private int id;

    /** identifier field */
    private Integer value;

    /** identifier field */
    private Integer oldvalue;

    /** full constructor */
    public ScrValnum(int id, Integer value, Integer oldvalue) {
        this.id = id;
        this.value = value;
        this.oldvalue = oldvalue;
    }

    /** default constructor */
    public ScrValnum() {
    }

    /** 
     *                @hibernate.property
     *                 column="ID"
     *                 length="10"
     *             
     */
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /** 
     *                @hibernate.property
     *                 column="VALUE"
     *                 length="10"
     *             
     */
    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    /** 
     *                @hibernate.property
     *                 column="OLDVALUE"
     *                 length="10"
     *             
     */
    public Integer getOldvalue() {
        return this.oldvalue;
    }

    public void setOldvalue(Integer oldvalue) {
        this.oldvalue = oldvalue;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .append("value", getValue())
            .append("oldvalue", getOldvalue())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ScrValnum) ) return false;
        ScrValnum castOther = (ScrValnum) other;
        return new EqualsBuilder()
            .append(this.getId(), castOther.getId())
            .append(this.getValue(), castOther.getValue())
            .append(this.getOldvalue(), castOther.getOldvalue())
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
            .append(getId())
            .append(getValue())
            .append(getOldvalue())
            .toHashCode();
    }

}
