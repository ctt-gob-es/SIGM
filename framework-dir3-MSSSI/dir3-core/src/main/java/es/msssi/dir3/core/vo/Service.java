/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.dir3.core.vo;

/**
 * Datos b�sicos de los servicios de una oficina.
 * 
 * @author cmorenog
 * 
 */
public class Service extends Entity {

    /**
     * 
     */
    private static final long serialVersionUID = 3022391899522441647L;

    /**
     * Descripci�n del servicio.
     */
    private String description;

    /**
     * Obtiene el valor del par�metro descripcion.
     * 
     * @return descripcion valor del campo a obtener.
     */
    public String getDescription() {
	return description;
    }

    /**
     * Guarda el valor del par�metro description.
     * 
     * @param description
     *            valor del campo a guardar.
     */
    public void setDescription(
	String description) {
	this.description = description;
    }

}
