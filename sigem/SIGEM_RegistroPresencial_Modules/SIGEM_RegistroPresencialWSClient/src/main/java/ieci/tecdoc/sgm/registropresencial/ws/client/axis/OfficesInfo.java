/**
 * OfficesInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package ieci.tecdoc.sgm.registropresencial.ws.client.axis;


public class OfficesInfo  extends ieci.tecdoc.sgm.registropresencial.ws.client.axis.RetornoServicio  implements java.io.Serializable {
    private ieci.tecdoc.sgm.registropresencial.ws.client.axis.OfficeInfo[] officesInfo;

    public OfficesInfo() {
    }

    public OfficesInfo(
           java.lang.String errorCode,
           java.lang.String returnCode,
           ieci.tecdoc.sgm.registropresencial.ws.client.axis.OfficeInfo[] officesInfo) {
        super(
            errorCode,
            returnCode);
        this.officesInfo = officesInfo;
    }


    /**
     * Gets the officesInfo value for this OfficesInfo.
     * 
     * @return officesInfo
     */
    public ieci.tecdoc.sgm.registropresencial.ws.client.axis.OfficeInfo[] getOfficesInfo() {
        return officesInfo;
    }


    /**
     * Sets the officesInfo value for this OfficesInfo.
     * 
     * @param officesInfo
     */
    public void setOfficesInfo(ieci.tecdoc.sgm.registropresencial.ws.client.axis.OfficeInfo[] officesInfo) {
        this.officesInfo = officesInfo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OfficesInfo)) return false;
        OfficesInfo other = (OfficesInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.officesInfo==null && other.getOfficesInfo()==null) || 
             (this.officesInfo!=null &&
              java.util.Arrays.equals(this.officesInfo, other.getOfficesInfo())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getOfficesInfo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOfficesInfo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOfficesInfo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OfficesInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.ws.registropresencial.sgm.tecdoc.ieci", "OfficesInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("officesInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://server.ws.registropresencial.sgm.tecdoc.ieci", "officesInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://server.ws.registropresencial.sgm.tecdoc.ieci", "OfficeInfo"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://server.ws.registropresencial.sgm.tecdoc.ieci", "item"));
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
