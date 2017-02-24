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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import consultservice.ws.dir3.msssi.es.consultofrequest.ConsultOFRequest;
import consultservice.ws.dir3.msssi.es.consultuorequest.ConsultUORequest;
import consultservice.ws.dir3.msssi.es.countofrequest.CountOFRequest;
import consultservice.ws.dir3.msssi.es.countuorequest.CountUORequest;
import consultservice.ws.dir3.msssi.es.getofrequest.GetOFRequest;
import consultservice.ws.dir3.msssi.es.getuorequest.GetUORequest;

/**
 * <p>
 * Java class for commonRequest complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="commonRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "commonRequest")
@XmlSeeAlso({ GetOFRequest.class, CountUORequest.class, GetUORequest.class, CountOFRequest.class,
    ConsultOFRequest.class, ConsultUORequest.class })
public class CommonRequest {

}
