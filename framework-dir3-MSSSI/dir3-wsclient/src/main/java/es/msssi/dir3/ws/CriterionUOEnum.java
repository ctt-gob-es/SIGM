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
 * Java class for CriterionUOEnum.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="CriterionUOEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="UO_ID"/>
 *     &lt;enumeration value="UO_NOMBRE"/>
 *     &lt;enumeration value="UO_ID_EXTERNO_FUENTE"/>
 *     &lt;enumeration value="UO_ESTADO"/>
 *     &lt;enumeration value="UO_ID_UNIDAD_ORGANICA_SUPERIOR"/>
 *     &lt;enumeration value="UO_NOMBRE_UNIDAD_ORGANICA_SUPERIOR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CriterionUOEnum")
@XmlEnum
public enum CriterionUOEnum {

    UO_ID, UO_NOMBRE, UO_ID_EXTERNO_FUENTE, UO_ESTADO, UO_ID_UNIDAD_ORGANICA_SUPERIOR,
    UO_NOMBRE_UNIDAD_ORGANICA_SUPERIOR;

    public String value() {
	return name();
    }

    public static CriterionUOEnum fromValue(
	String v) {
	return valueOf(v);
    }

}
