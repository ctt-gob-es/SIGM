//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.12 at 12:22:50 PM GMT 
//
package eu.stork.peps.complex.attributes.eu.stork.names.tc.stork._1_0.assertion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for acTitleType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType name="acTitleType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="titleNormalised" type="{urn:eu:stork:names:tc:STORK:1.0:assertion}titleNormalisedType"/>
 *         &lt;element name="AQAA" type="{urn:eu:stork:names:tc:STORK:1.0:assertion}QualityAuthenticationAssuranceLevelType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "acTitleType", propOrder = {
    "titleNormalised",
    "aqaa"
})
public class AcTitleType {

    @XmlElement(required = true)
    protected String titleNormalised;
    @XmlElement(name = "AQAA")
    protected int aqaa;

    /**
     * Gets the value of the titleNormalised property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getTitleNormalised() {
        return titleNormalised;
    }

    /**
     * Sets the value of the titleNormalised property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setTitleNormalised(String value) {
        this.titleNormalised = value;
    }

    /**
     * Gets the value of the aqaa property.
     *
     */
    public int getAQAA() {
        return aqaa;
    }

    /**
     * Sets the value of the aqaa property.
     *
     */
    public void setAQAA(int value) {
        this.aqaa = value;
    }

}
