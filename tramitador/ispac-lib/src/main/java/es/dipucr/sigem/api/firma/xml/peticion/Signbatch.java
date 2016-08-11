//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.09.11 at 10:06:22 AM CEST 
//


package es.dipucr.sigem.api.firma.xml.peticion;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="singlesign" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="datasource" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="format">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="XAdES"/>
 *                         &lt;enumeration value="CAdES"/>
 *                         &lt;enumeration value="PAdES"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="suboperation">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="sign"/>
 *                         &lt;enumeration value="cosign"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="extraparams">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}base64Binary">
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="signsaver">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="class" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="config">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}base64Binary">
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="concurrenttimeout" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="stoponerror">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="true"/>
 *             &lt;enumeration value="false"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="algorithm" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="SHA1withRSA"/>
 *             &lt;enumeration value="SHA256withRSA"/>
 *             &lt;enumeration value="SHA384withRSA"/>
 *             &lt;enumeration value="SHA512withRSA"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "singlesign"
})
@XmlRootElement(name = "signbatch")
public class Signbatch {

    @XmlElement(required = true)
    protected List<Signbatch.Singlesign> singlesign;
    @XmlAttribute(name = "concurrenttimeout")
    protected BigInteger concurrenttimeout;
    @XmlAttribute(name = "stoponerror")
    protected String stoponerror;
    @XmlAttribute(name = "algorithm", required = true)
    protected String algorithm;

    /**
     * Gets the value of the singlesign property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the singlesign property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSinglesign().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Signbatch.Singlesign }
     * 
     * 
     */
    public List<Signbatch.Singlesign> getSinglesign() {
        if (singlesign == null) {
            singlesign = new ArrayList<Signbatch.Singlesign>();
        }
        return this.singlesign;
    }

    /**
     * Gets the value of the concurrenttimeout property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getConcurrenttimeout() {
        return concurrenttimeout;
    }

    /**
     * Sets the value of the concurrenttimeout property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setConcurrenttimeout(BigInteger value) {
        this.concurrenttimeout = value;
    }

    /**
     * Gets the value of the stoponerror property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStoponerror() {
        return stoponerror;
    }

    /**
     * Sets the value of the stoponerror property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStoponerror(String value) {
        this.stoponerror = value;
    }

    /**
     * Gets the value of the algorithm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlgorithm() {
        return algorithm;
    }

    /**
     * Sets the value of the algorithm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlgorithm(String value) {
        this.algorithm = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="datasource" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="format">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="XAdES"/>
     *               &lt;enumeration value="CAdES"/>
     *               &lt;enumeration value="PAdES"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="suboperation">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="sign"/>
     *               &lt;enumeration value="cosign"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="extraparams">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}base64Binary">
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="signsaver">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="class" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="config">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}base64Binary">
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "datasource",
        "format",
        "suboperation",
        "extraparams",
        "signsaver"
    })
    public static class Singlesign {

        @XmlElement(required = true)
        protected String datasource;
        @XmlElement(required = true)
        protected String format;
        @XmlElement(required = true)
        protected String suboperation;
        @XmlElement(required = true)
        protected byte[] extraparams;
        @XmlElement(required = true)
        protected Signbatch.Singlesign.Signsaver signsaver;
        @XmlAttribute(name = "Id", required = true)
        protected String id;

        /**
         * Gets the value of the datasource property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDatasource() {
            return datasource;
        }

        /**
         * Sets the value of the datasource property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDatasource(String value) {
            this.datasource = value;
        }

        /**
         * Gets the value of the format property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFormat() {
            return format;
        }

        /**
         * Sets the value of the format property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFormat(String value) {
            this.format = value;
        }

        /**
         * Gets the value of the suboperation property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSuboperation() {
            return suboperation;
        }

        /**
         * Sets the value of the suboperation property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSuboperation(String value) {
            this.suboperation = value;
        }

        /**
         * Gets the value of the extraparams property.
         * 
         * @return
         *     possible object is
         *     byte[]
         */
        public byte[] getExtraparams() {
            return extraparams;
        }

        /**
         * Sets the value of the extraparams property.
         * 
         * @param value
         *     allowed object is
         *     byte[]
         */
        public void setExtraparams(byte[] value) {
            this.extraparams = ((byte[]) value);
        }

        /**
         * Gets the value of the signsaver property.
         * 
         * @return
         *     possible object is
         *     {@link Signbatch.Singlesign.Signsaver }
         *     
         */
        public Signbatch.Singlesign.Signsaver getSignsaver() {
            return signsaver;
        }

        /**
         * Sets the value of the signsaver property.
         * 
         * @param value
         *     allowed object is
         *     {@link Signbatch.Singlesign.Signsaver }
         *     
         */
        public void setSignsaver(Signbatch.Singlesign.Signsaver value) {
            this.signsaver = value;
        }

        /**
         * Gets the value of the id property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getId() {
            return id;
        }

        /**
         * Sets the value of the id property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setId(String value) {
            this.id = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="class" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="config">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}base64Binary">
         *             &lt;/restriction>
         *           &lt;/simpleType>
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
        @XmlType(name = "", propOrder = {
            "clazz",
            "config"
        })
        public static class Signsaver {

            @XmlElement(name = "class", required = true)
            protected String clazz;
            @XmlElement(required = true)
            protected byte[] config;

            /**
             * Gets the value of the clazz property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getClazz() {
                return clazz;
            }

            /**
             * Sets the value of the clazz property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setClazz(String value) {
                this.clazz = value;
            }

            /**
             * Gets the value of the config property.
             * 
             * @return
             *     possible object is
             *     byte[]
             */
            public byte[] getConfig() {
                return config;
            }

            /**
             * Sets the value of the config property.
             * 
             * @param value
             *     allowed object is
             *     byte[]
             */
            public void setConfig(byte[] value) {
                this.config = ((byte[]) value);
            }

        }

    }

}