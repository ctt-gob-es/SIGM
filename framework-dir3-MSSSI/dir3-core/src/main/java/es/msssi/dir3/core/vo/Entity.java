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

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Clase gen�rica de los beans.
 * 
 * @author cmorenog
 * 
 */
public class Entity implements Serializable {

    private static final long serialVersionUID = 5515426564073999982L;

    private String id;

    /**
     * Obtiene el valor del par�metro id.
     * 
     * @return id valor del campo a obtener.
     */
    public String getId() {
	return id;
    }

    /**
     * Obtiene el valor del par�metro id.
     * 
     * @return id valor del campo a obtener.
     */
    public Long getIdAsLong() {
	return Long.parseLong(id);
    }

    /**
     * Obtiene el valor del par�metro id.
     * 
     * @return id valor del campo a obtener.
     */
    public Integer getIdAsInteger() {
	return Integer.parseInt(id);
    }

    /**
     * Guarda el valor del par�metro id.
     * 
     * @param id
     *            valor del campo a guardar.
     */
    public void setId(
	String id) {
	this.id = id;
    }

    /**
     * Implementaci�n comparando identificadores.
     * 
     * @param o
     *            objeto a comparar.
     * @return boolean true si son iguales.
     * 
     */
    @Override
    public boolean equals(
	Object o) {
	boolean result = false;
	if ((this == o)) {
	    result = true;
	}
	if (!(o instanceof Entity)) {
	    result = false;
	}
	Entity otherEntity = (Entity) o;
	result = new EqualsBuilder().append(
	    otherEntity.getId(), this.getId()).isEquals();
	return result;
    }

    /**
     * Devuelve el hash code del objeto.
     * 
     * @return int el hash code.
     */
    @Override
    public int hashCode() {
	return new HashCodeBuilder().append(
	    id).toHashCode();
    }

    /**
     * Devuelve el id en un string.
     * 
     * @return String el id en un string..
     */

    @Override
    public String toString() {
	return "Entity con ID: " +
	    getId();
    }
}
