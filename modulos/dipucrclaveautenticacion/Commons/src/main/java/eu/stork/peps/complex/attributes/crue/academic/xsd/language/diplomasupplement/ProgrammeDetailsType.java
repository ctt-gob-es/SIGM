//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.12 at 12:22:50 PM GMT 
//
package eu.stork.peps.complex.attributes.crue.academic.xsd.language.diplomasupplement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Programme details
 *
 * <p>
 * Java class for ProgrammeDetailsType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType name="ProgrammeDetailsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CourseStructureDiagram" type="{urn:crue:academic:xsd:language:diplomasupplement}CourseStructureDiagramType"/>
 *         &lt;element name="CoursesAttendedInOtherInstitutionInMobilityPrograms" type="{urn:crue:academic:xsd:language:diplomasupplement}CoursesAttendedInOtherInstitutionInMobilityProgramsType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProgrammeDetailsType", propOrder = {
    "courseStructureDiagram",
    "coursesAttendedInOtherInstitutionInMobilityPrograms"
})
public class ProgrammeDetailsType {

    @XmlElement(name = "CourseStructureDiagram", required = true)
    protected CourseStructureDiagramType courseStructureDiagram;
    @XmlElement(name = "CoursesAttendedInOtherInstitutionInMobilityPrograms")
    protected CoursesAttendedInOtherInstitutionInMobilityProgramsType coursesAttendedInOtherInstitutionInMobilityPrograms;

    /**
     * Gets the value of the courseStructureDiagram property.
     *
     * @return possible object is {@link CourseStructureDiagramType }
     *
     */
    public CourseStructureDiagramType getCourseStructureDiagram() {
        return courseStructureDiagram;
    }

    /**
     * Sets the value of the courseStructureDiagram property.
     *
     * @param value allowed object is {@link CourseStructureDiagramType }
     *
     */
    public void setCourseStructureDiagram(CourseStructureDiagramType value) {
        this.courseStructureDiagram = value;
    }

    /**
     * Gets the value of the coursesAttendedInOtherInstitutionInMobilityPrograms
     * property.
     *
     * @return possible object is
     *     {@link CoursesAttendedInOtherInstitutionInMobilityProgramsType }
     *
     */
    public CoursesAttendedInOtherInstitutionInMobilityProgramsType getCoursesAttendedInOtherInstitutionInMobilityPrograms() {
        return coursesAttendedInOtherInstitutionInMobilityPrograms;
    }

    /**
     * Sets the value of the coursesAttendedInOtherInstitutionInMobilityPrograms
     * property.
     *
     * @param value allowed object is
     *     {@link CoursesAttendedInOtherInstitutionInMobilityProgramsType }
     *
     */
    public void setCoursesAttendedInOtherInstitutionInMobilityPrograms(CoursesAttendedInOtherInstitutionInMobilityProgramsType value) {
        this.coursesAttendedInOtherInstitutionInMobilityPrograms = value;
    }

}
