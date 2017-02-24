/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.dir3.ws.response;

import javax.xml.bind.annotation.XmlType;

import es.msssi.dir3.core.vo.Office;

/**
 * Datos salida del servicio web de recuperar OF.
 * 
 * @author cmorenog
 * 
 */
@XmlType(name = "getOFResponse", namespace = "http://es.msssi.dir3.ws.ConsultService/getOFResponse")
public class GetOFResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

    private Office office;

    /**
     * Obtiene el valor del par�metro office.
     * 
     * @return office valor del campo a obtener.
     * 
     */
    public Office getOffice() {
	return office;
    }

    /**
     * Guarda el valor del par�metro office.
     * 
     * @param office
     *            valor del campo a guardar.
     */
    public void setOffice(
	Office office) {
	this.office = office;
    }
}
