/**
 * DistributionSearchCriteria.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package ieci.tecdoc.sgm.registropresencial.ws.client.axis;

public class DistributionSearchCriteria implements java.io.Serializable {
	private java.lang.String firstRow;

	private java.lang.String maxResults;

	private java.lang.String state;

	private java.lang.String typeBookRegisterDist;

	private java.lang.String oficAsoc;

	public DistributionSearchCriteria() {
	}

	public DistributionSearchCriteria(java.lang.String firstRow,
			java.lang.String maxResults, java.lang.String state,
			java.lang.String typeBookRegisterDist, java.lang.String oficAsoc) {
		this.firstRow = firstRow;
		this.maxResults = maxResults;
		this.state = state;
	}

	/**
	 * Gets the firstRow value for this DistributionSearchCriteria.
	 * 
	 * @return firstRow
	 */
	public java.lang.String getFirstRow() {
		return firstRow;
	}

	/**
	 * Sets the firstRow value for this DistributionSearchCriteria.
	 * 
	 * @param firstRow
	 */
	public void setFirstRow(java.lang.String firstRow) {
		this.firstRow = firstRow;
	}

	/**
	 * Gets the maxResults value for this DistributionSearchCriteria.
	 * 
	 * @return maxResults
	 */
	public java.lang.String getMaxResults() {
		return maxResults;
	}

	/**
	 * Sets the maxResults value for this DistributionSearchCriteria.
	 * 
	 * @param maxResults
	 */
	public void setMaxResults(java.lang.String maxResults) {
		this.maxResults = maxResults;
	}

	/**
	 * Gets the state value for this DistributionSearchCriteria.
	 * 
	 * @return state
	 */
	public java.lang.String getState() {
		return state;
	}

	/**
	 * Sets the state value for this DistributionSearchCriteria.
	 * 
	 * @param state
	 */
	public void setState(java.lang.String state) {
		this.state = state;
	}

	/**
	 * 
	 * @return
	 */
	public java.lang.String getTypeBookRegisterDist() {
		return typeBookRegisterDist;
	}

	/**
	 * 
	 * @param typeBookRegisterDist
	 */
	public void setTypeBookRegisterDist(java.lang.String typeBookRegisterDist) {
		this.typeBookRegisterDist = typeBookRegisterDist;
	}

	/**
	 * 
	 * @return
	 */
	public java.lang.String getOficAsoc() {
		return oficAsoc;
	}

	/**
	 * 
	 * @param oficAsoc
	 */
	public void setOficAsoc(java.lang.String oficAsoc) {
		this.oficAsoc = oficAsoc;
	}

	private java.lang.Object __equalsCalc = null;

	public synchronized boolean equals(java.lang.Object obj) {
		if (!(obj instanceof DistributionSearchCriteria))
			return false;
		DistributionSearchCriteria other = (DistributionSearchCriteria) obj;
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (__equalsCalc != null) {
			return (__equalsCalc == obj);
		}
		__equalsCalc = obj;
		boolean _equals;
		_equals = true
				&& ((this.firstRow == null && other.getFirstRow() == null) || (this.firstRow != null && this.firstRow
						.equals(other.getFirstRow())))
				&& ((this.maxResults == null && other.getMaxResults() == null) || (this.maxResults != null && this.maxResults
						.equals(other.getMaxResults())))
				&& ((this.state == null && other.getState() == null) || (this.state != null && this.state
						.equals(other.getState())))
				&& ((this.typeBookRegisterDist == null && other
						.getTypeBookRegisterDist() == null) || (this.typeBookRegisterDist != null && this.typeBookRegisterDist
						.equals(other.getTypeBookRegisterDist())))
				&& ((this.oficAsoc == null && other.getOficAsoc() == null) || (this.oficAsoc != null && this.oficAsoc
						.equals(other.getOficAsoc())));
		__equalsCalc = null;
		return _equals;
	}

	private boolean __hashCodeCalc = false;

	public synchronized int hashCode() {
		if (__hashCodeCalc) {
			return 0;
		}
		__hashCodeCalc = true;
		int _hashCode = 1;
		if (getFirstRow() != null) {
			_hashCode += getFirstRow().hashCode();
		}
		if (getMaxResults() != null) {
			_hashCode += getMaxResults().hashCode();
		}
		if (getState() != null) {
			_hashCode += getState().hashCode();
		}
		if (getTypeBookRegisterDist() != null) {
			_hashCode += getTypeBookRegisterDist().hashCode();
		}
		if (getOficAsoc() != null) {
			_hashCode += getOficAsoc().hashCode();
		}
		__hashCodeCalc = false;
		return _hashCode;
	}

	// Type metadata
	private static org.apache.axis.description.TypeDesc typeDesc = new org.apache.axis.description.TypeDesc(
			DistributionSearchCriteria.class, true);

	static {
		typeDesc.setXmlType(new javax.xml.namespace.QName(
				"http://server.ws.registropresencial.sgm.tecdoc.ieci",
				"DistributionSearchCriteria"));
		org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("firstRow");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"http://server.ws.registropresencial.sgm.tecdoc.ieci",
				"firstRow"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(true);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("maxResults");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"http://server.ws.registropresencial.sgm.tecdoc.ieci",
				"maxResults"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(true);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("state");
		elemField
				.setXmlName(new javax.xml.namespace.QName(
						"http://server.ws.registropresencial.sgm.tecdoc.ieci",
						"state"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(true);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("typeBookRegisterDist");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"http://server.ws.registropresencial.sgm.tecdoc.ieci",
				"typeBookRegisterDist"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(true);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("oficAsoc");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"http://server.ws.registropresencial.sgm.tecdoc.ieci",
				"oficAsoc"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(true);
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
			java.lang.String mechType, java.lang.Class _javaType,
			javax.xml.namespace.QName _xmlType) {
		return new org.apache.axis.encoding.ser.BeanSerializer(_javaType,
				_xmlType, typeDesc);
	}

	/**
	 * Get Custom Deserializer
	 */
	public static org.apache.axis.encoding.Deserializer getDeserializer(
			java.lang.String mechType, java.lang.Class _javaType,
			javax.xml.namespace.QName _xmlType) {
		return new org.apache.axis.encoding.ser.BeanDeserializer(_javaType,
				_xmlType, typeDesc);
	}

}
