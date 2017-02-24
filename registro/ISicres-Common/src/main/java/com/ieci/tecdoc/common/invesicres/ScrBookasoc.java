package com.ieci.tecdoc.common.invesicres;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** 
 *        @hibernate.class
 *         table="SCR_BOOKASOC"
 *     
*/
public class ScrBookasoc implements Serializable {

    /** identifier field */
    private int idBook;

    /** identifier field */
    private int idBooksec;

    /** identifier field */
    private int type;

    /** full constructor */
    public ScrBookasoc(int idBook, int idBooksec, int type) {
        this.idBook = idBook;
        this.idBooksec = idBooksec;
        this.type = type;
    }

    /** default constructor */
    public ScrBookasoc() {
    }

    /** 
     *                @hibernate.property
     *                 column="ID_BOOK"
     *                 length="10"
     *             
     */
    public int getIdBook() {
        return this.idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    /** 
     *                @hibernate.property
     *                 column="ID_BOOKSEC"
     *                 length="10"
     *             
     */
    public int getIdBooksec() {
        return this.idBooksec;
    }

    public void setIdBooksec(int idBooksec) {
        this.idBooksec = idBooksec;
    }

    /** 
     *                @hibernate.property
     *                 column="TYPE"
     *                 length="10"
     *             
     */
    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("idBook", getIdBook())
            .append("idBooksec", getIdBooksec())
            .append("type", getType())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ScrBookasoc) ) return false;
        ScrBookasoc castOther = (ScrBookasoc) other;
        return new EqualsBuilder()
            .append(this.getIdBook(), castOther.getIdBook())
            .append(this.getIdBooksec(), castOther.getIdBooksec())
            .append(this.getType(), castOther.getType())
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
            .append(getIdBook())
            .append(getIdBooksec())
            .append(getType())
            .toHashCode();
    }

}
