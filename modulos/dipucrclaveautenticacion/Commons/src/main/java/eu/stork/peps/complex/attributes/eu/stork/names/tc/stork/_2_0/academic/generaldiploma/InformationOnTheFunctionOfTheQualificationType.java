//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.12 at 12:22:50 PM GMT 
//
package eu.stork.peps.complex.attributes.eu.stork.names.tc.stork._2_0.academic.generaldiploma;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for InformationOnTheFunctionOfTheQualificationType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType name="InformationOnTheFunctionOfTheQualificationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AccessToFurtherStudy" type="{urn:eu:stork:names:tc:STORK:2.0:academic:generaldiploma}RichTextTagType" minOccurs="0"/>
 *         &lt;element name="ProfessionalStatus" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{urn:eu:stork:names:tc:STORK:2.0:academic:generaldiploma}RichTextTagType">
 *                 &lt;attribute name="isRegulatedProfession" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InformationOnTheFunctionOfTheQualificationType", propOrder = {
    "accessToFurtherStudy",
    "professionalStatus"
})
public class InformationOnTheFunctionOfTheQualificationType {

    @XmlElement(name = "AccessToFurtherStudy")
    protected RichTextTagType accessToFurtherStudy;
    @XmlElement(name = "ProfessionalStatus")
    protected InformationOnTheFunctionOfTheQualificationType.ProfessionalStatus professionalStatus;

    /**
     * Gets the value of the accessToFurtherStudy property.
     *
     * @return possible object is {@link RichTextTagType }
     *
     */
    public RichTextTagType getAccessToFurtherStudy() {
        return accessToFurtherStudy;
    }

    /**
     * Sets the value of the accessToFurtherStudy property.
     *
     * @param value allowed object is {@link RichTextTagType }
     *
     */
    public void setAccessToFurtherStudy(RichTextTagType value) {
        this.accessToFurtherStudy = value;
    }

    /**
     * Gets the value of the professionalStatus property.
     *
     * @return possible object is
     *     {@link InformationOnTheFunctionOfTheQualificationType.ProfessionalStatus }
     *
     */
    public InformationOnTheFunctionOfTheQualificationType.ProfessionalStatus getProfessionalStatus() {
        return professionalStatus;
    }

    /**
     * Sets the value of the professionalStatus property.
     *
     * @param value allowed object is
     *     {@link InformationOnTheFunctionOfTheQualificationType.ProfessionalStatus }
     *
     */
    public void setProfessionalStatus(InformationOnTheFunctionOfTheQualificationType.ProfessionalStatus value) {
        this.professionalStatus = value;
    }

    /**
     * <p>
     * Java class for anonymous complex type.
     *
     * <p>
     * The following schema fragment specifies the expected content contained
     * within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{urn:eu:stork:names:tc:STORK:2.0:academic:generaldiploma}RichTextTagType">
     *       &lt;attribute name="isRegulatedProfession" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class ProfessionalStatus
            extends RichTextTagType {

        @XmlAttribute(name = "isRegulatedProfession")
        protected Boolean isRegulatedProfession;

        /**
         * Gets the value of the isRegulatedProfession property.
         *
         * @return possible object is {@link Boolean }
         *
         */
        public Boolean isIsRegulatedProfession() {
            return isRegulatedProfession;
        }

        /**
         * Sets the value of the isRegulatedProfession property.
         *
         * @param value allowed object is {@link Boolean }
         *
         */
        public void setIsRegulatedProfession(Boolean value) {
            this.isRegulatedProfession = value;
        }

    }

}