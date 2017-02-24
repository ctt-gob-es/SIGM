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

import java.util.List;

import javax.xml.bind.annotation.XmlType;

import es.msssi.dir3.core.vo.Unit;

/**
 * Datos salida del servicio web de consulta de UO.
 * 
 * @author cmorenog
 * 
 */
@XmlType(name = "consultUOResponse",
    namespace = "http://es.msssi.dir3.ws.ConsultService/consultUOResponse")
public class ConsultUOResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

    private List<Unit> units;

    /**
     * Obtiene el valor del par�metro unidades.
     * 
     * @return units valor del campo a obtener.
     * 
     */
    public List<Unit> getUnits() {
	return units;
    }

    /**
     * Guarda el valor del par�metro unidades.
     * 
     * @param units
     *            valor del campo a guardar.
     */
    public void setUnits(
	List<Unit> units) {
	this.units = units;
    }
}
