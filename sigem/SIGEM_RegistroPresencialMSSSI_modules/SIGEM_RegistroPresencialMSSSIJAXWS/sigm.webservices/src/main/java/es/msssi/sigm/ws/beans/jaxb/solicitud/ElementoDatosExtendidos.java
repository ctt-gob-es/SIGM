/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/


package es.msssi.sigm.ws.beans.jaxb.solicitud;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for elementoDatosExtendidos complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="elementoDatosExtendidos">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="datoExtendido" type="{http://www.msssi.es/Regtel/2015/1}ElementoDatoExtendido" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "elementoDatosExtendidos", namespace = "http://www.msssi.es/Regtel/2015/1", propOrder = {
    "datoExtendido"
})
public class ElementoDatosExtendidos {

    @XmlElement(required = true)
    protected List<ElementoDatoExtendido> datoExtendido;

    /**
     * Gets the value of the datoExtendido property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the datoExtendido property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDatoExtendido().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ElementoDatoExtendido }
     * 
     * 
     */
    public List<ElementoDatoExtendido> getDatoExtendido() {
        if (datoExtendido == null) {
            datoExtendido = new ArrayList<ElementoDatoExtendido>();
        }
        return this.datoExtendido;
    }

}
