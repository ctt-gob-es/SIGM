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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for elementoDatosInteresados complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="elementoDatosInteresados">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="interesadoJuridico" type="{http://www.msssi.es/Regtel/2015/1}interesadoJuridico" maxOccurs="unbounded"/>
 *           &lt;element name="interesadoFisico" type="{http://www.msssi.es/Regtel/2015/1}interesadoFisico" maxOccurs="unbounded"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "elementoDatosInteresados", namespace = "http://www.msssi.es/Regtel/2015/1", propOrder = {
    "interesadoJuridico",
    "interesadoFisico"
})
public class ElementoDatosInteresados {

    protected List<InteresadoJuridico> interesadoJuridico;
    protected List<InteresadoFisico> interesadoFisico;

    /**
     * Gets the value of the interesadoJuridico property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the interesadoJuridico property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInteresadoJuridico().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InteresadoJuridico }
     * 
     * 
     */
    public List<InteresadoJuridico> getInteresadoJuridico() {
        if (interesadoJuridico == null) {
            interesadoJuridico = new ArrayList<InteresadoJuridico>();
        }
        return this.interesadoJuridico;
    }

    /**
     * Gets the value of the interesadoFisico property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the interesadoFisico property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInteresadoFisico().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InteresadoFisico }
     * 
     * 
     */
    public List<InteresadoFisico> getInteresadoFisico() {
        if (interesadoFisico == null) {
            interesadoFisico = new ArrayList<InteresadoFisico>();
        }
        return this.interesadoFisico;
    }

    public void setInteresadoFisico(List<InteresadoFisico> interesadoFisico) {
		this.interesadoFisico = interesadoFisico;
	}
    public void setInteresadoJuridico(List<InteresadoJuridico> interesadoJuridico) {
		this.interesadoJuridico = interesadoJuridico;
	}
}
