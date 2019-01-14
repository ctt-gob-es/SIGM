//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.12 at 12:22:50 PM GMT 
//
package eu.stork.peps.complex.attributes.crue.academic.xsd.language.diplomasupplement;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Courses groups
 *
 * <p>
 * Java class for CoursesGroupsType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType name="CoursesGroupsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{urn:crue:academic:xsd:language:diplomasupplement}PlainTextType" minOccurs="0"/>
 *         &lt;element name="HeaderInformation" type="{urn:crue:academic:xsd:language:diplomasupplement}RichTextTagType" minOccurs="0"/>
 *         &lt;element name="CoursesGroup" type="{urn:crue:academic:xsd:language:diplomasupplement}CoursesGroupType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="FooterInformation" type="{urn:crue:academic:xsd:language:diplomasupplement}RichTextTagType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CoursesGroupsType", propOrder = {
    "name",
    "headerInformation",
    "coursesGroup",
    "footerInformation"
})
public class CoursesGroupsType {

    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "HeaderInformation")
    protected RichTextTagType headerInformation;
    @XmlElement(name = "CoursesGroup")
    protected List<CoursesGroupType> coursesGroup;
    @XmlElement(name = "FooterInformation")
    protected RichTextTagType footerInformation;

    /**
     * Gets the value of the name property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the headerInformation property.
     *
     * @return possible object is {@link RichTextTagType }
     *
     */
    public RichTextTagType getHeaderInformation() {
        return headerInformation;
    }

    /**
     * Sets the value of the headerInformation property.
     *
     * @param value allowed object is {@link RichTextTagType }
     *
     */
    public void setHeaderInformation(RichTextTagType value) {
        this.headerInformation = value;
    }

    /**
     * Gets the value of the coursesGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the coursesGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCoursesGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CoursesGroupType }
     *
     *
     */
    public List<CoursesGroupType> getCoursesGroup() {
        if (coursesGroup == null) {
            coursesGroup = new ArrayList<CoursesGroupType>();
        }
        return this.coursesGroup;
    }

    /**
     * Gets the value of the footerInformation property.
     *
     * @return possible object is {@link RichTextTagType }
     *
     */
    public RichTextTagType getFooterInformation() {
        return footerInformation;
    }

    /**
     * Sets the value of the footerInformation property.
     *
     * @param value allowed object is {@link RichTextTagType }
     *
     */
    public void setFooterInformation(RichTextTagType value) {
        this.footerInformation = value;
    }

}
