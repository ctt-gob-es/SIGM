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
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * <p>
 * Java class for AttachedType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType name="AttachedType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="FileData" type="{urn:eu:stork:names:tc:STORK:2.0:academic:generaldiploma}AttachedFileDataType"/>
 *         &lt;element name="FileURI" type="{urn:eu:stork:names:tc:STORK:2.0:academic:generaldiploma}AttachedFileURLType"/>
 *         &lt;element name="ImageData" type="{urn:eu:stork:names:tc:STORK:2.0:academic:generaldiploma}AttachedImageDataType"/>
 *         &lt;element name="ImageURI" type="{urn:eu:stork:names:tc:STORK:2.0:academic:generaldiploma}AttachedImageURLType"/>
 *       &lt;/choice>
 *       &lt;attribute name="attachedID" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AttachedType", propOrder = {
    "fileData",
    "fileURI",
    "imageData",
    "imageURI"
})
public class AttachedType {

    @XmlElement(name = "FileData")
    protected AttachedFileDataType fileData;
    @XmlElement(name = "FileURI")
    protected AttachedFileURLType fileURI;
    @XmlElement(name = "ImageData")
    protected AttachedImageDataType imageData;
    @XmlElement(name = "ImageURI")
    protected AttachedImageURLType imageURI;
    @XmlAttribute(name = "attachedID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String attachedID;

    /**
     * Gets the value of the fileData property.
     *
     * @return possible object is {@link AttachedFileDataType }
     *
     */
    public AttachedFileDataType getFileData() {
        return fileData;
    }

    /**
     * Sets the value of the fileData property.
     *
     * @param value allowed object is {@link AttachedFileDataType }
     *
     */
    public void setFileData(AttachedFileDataType value) {
        this.fileData = value;
    }

    /**
     * Gets the value of the fileURI property.
     *
     * @return possible object is {@link AttachedFileURLType }
     *
     */
    public AttachedFileURLType getFileURI() {
        return fileURI;
    }

    /**
     * Sets the value of the fileURI property.
     *
     * @param value allowed object is {@link AttachedFileURLType }
     *
     */
    public void setFileURI(AttachedFileURLType value) {
        this.fileURI = value;
    }

    /**
     * Gets the value of the imageData property.
     *
     * @return possible object is {@link AttachedImageDataType }
     *
     */
    public AttachedImageDataType getImageData() {
        return imageData;
    }

    /**
     * Sets the value of the imageData property.
     *
     * @param value allowed object is {@link AttachedImageDataType }
     *
     */
    public void setImageData(AttachedImageDataType value) {
        this.imageData = value;
    }

    /**
     * Gets the value of the imageURI property.
     *
     * @return possible object is {@link AttachedImageURLType }
     *
     */
    public AttachedImageURLType getImageURI() {
        return imageURI;
    }

    /**
     * Sets the value of the imageURI property.
     *
     * @param value allowed object is {@link AttachedImageURLType }
     *
     */
    public void setImageURI(AttachedImageURLType value) {
        this.imageURI = value;
    }

    /**
     * Gets the value of the attachedID property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getAttachedID() {
        return attachedID;
    }

    /**
     * Sets the value of the attachedID property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setAttachedID(String value) {
        this.attachedID = value;
    }

}
