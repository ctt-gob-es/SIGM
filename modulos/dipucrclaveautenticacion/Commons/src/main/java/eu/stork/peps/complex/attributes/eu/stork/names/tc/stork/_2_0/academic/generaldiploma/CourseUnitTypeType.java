//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.12 at 12:22:50 PM GMT 
//
package eu.stork.peps.complex.attributes.eu.stork.names.tc.stork._2_0.academic.generaldiploma;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for CourseUnitTypeType.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * <
 * pre>
 * &lt;simpleType name="CourseUnitTypeType"> &lt;restriction
 * base="{http://www.w3.org/2001/XMLSchema}string"> &lt;enumeration
 * value="Compulsory"/> &lt;enumeration value="Optional"/> &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "CourseUnitTypeType")
@XmlEnum
public enum CourseUnitTypeType {

    @XmlEnumValue("Compulsory")
    COMPULSORY("Compulsory"),
    @XmlEnumValue("Optional")
    OPTIONAL("Optional");
    private final String value;

    CourseUnitTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CourseUnitTypeType fromValue(String v) {
        for (CourseUnitTypeType c : CourseUnitTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}