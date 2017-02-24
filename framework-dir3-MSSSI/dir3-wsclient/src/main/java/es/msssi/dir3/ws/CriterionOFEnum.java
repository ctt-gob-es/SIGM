/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.dir3.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for CriterionOFEnum.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="CriterionOFEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OFICINA_ID"/>
 *     &lt;enumeration value="OFICINA_NOMBRE"/>
 *     &lt;enumeration value="OFICINA_ESTADO"/>
 *     &lt;enumeration value="OFICINA_ID_UNIDAD_RESPONSABLE"/>
 *     &lt;enumeration value="OFICINA_ID_EXTERNO_FUENTE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CriterionOFEnum")
@XmlEnum
public enum CriterionOFEnum {

    OFICINA_ID, OFICINA_NOMBRE, OFICINA_ESTADO, OFICINA_ID_UNIDAD_RESPONSABLE,
    OFICINA_ID_EXTERNO_FUENTE;

    public String value() {
	return name();
    }

    public static CriterionOFEnum fromValue(
	String v) {
	return valueOf(v);
    }

}
