/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.dir3.ws.request;

import javax.xml.bind.annotation.XmlType;

/**
 * Datos entrada del servicio web de recuperar UO.
 * 
 * @author cmorenog
 * 
 */
@XmlType(name = "getUORequest", namespace = "http://es.msssi.dir3.ws.ConsultService/getUORequest")
public class GetUORequest extends CommonRequest {

    private static final long serialVersionUID = 1L;
    private String unitId = null;

    /**
     * Obtiene el valor del par�metro unitId.
     * 
     * @return unitId valor del campo a obtener.
     * 
     */
    public String getUnitId() {
	return unitId;
    }

    /**
     * Guarda el valor del par�metro unitId.
     * 
     * @param unitId
     *            valor del campo a guardar.
     */
    public void setUnitId(
	String unitId) {
	this.unitId = unitId;
    }

}
