/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package consultservice.ws.dir3.msssi.es.consultuorequest;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import es.msssi.dir3.ws.CommonRequest;
import es.msssi.dir3.ws.CriterionUO;
import es.msssi.dir3.ws.CriterionUOEnum;
import es.msssi.dir3.ws.PageInfo;

/**
 * <p>
 * Java class for consultUORequest complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="consultUORequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.dir3.msssi.es/}commonRequest">
 *       &lt;sequence>
 *         &lt;element name="criteria" type="{http://ws.dir3.msssi.es/}criterionUO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="orderBy" type="{http://ws.dir3.msssi.es/}CriterionUOEnum" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="pageInfo" type="{http://ws.dir3.msssi.es/}pageInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultUORequest", propOrder = { "criteria", "orderBy", "pageInfo" })
public class ConsultUORequest extends CommonRequest {

    @XmlElement(nillable = true)
    protected List<CriterionUO> criteria;
    @XmlElement(nillable = true)
    protected List<CriterionUOEnum> orderBy;
    protected PageInfo pageInfo;

    /**
     * Gets the value of the criteria property.
     * 
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the criteria property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getCriteria().add(
     *     newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CriterionUO }
     * 
     * 
     */
    public List<CriterionUO> getCriteria() {
	if (criteria == null) {
	    criteria = new ArrayList<CriterionUO>();
	}
	return this.criteria;
    }

    /**
     * Gets the value of the orderBy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the orderBy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getOrderBy().add(
     *     newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CriterionUOEnum }
     * 
     * 
     */
    public List<CriterionUOEnum> getOrderBy() {
	if (orderBy == null) {
	    orderBy = new ArrayList<CriterionUOEnum>();
	}
	return this.orderBy;
    }

    /**
     * Gets the value of the pageInfo property.
     * 
     * @return possible object is {@link PageInfo }
     * 
     */
    public PageInfo getPageInfo() {
	return pageInfo;
    }

    /**
     * Sets the value of the pageInfo property.
     * 
     * @param value
     *            allowed object is {@link PageInfo }
     * 
     */
    public void setPageInfo(
	PageInfo value) {
	this.pageInfo = value;
    }

}
