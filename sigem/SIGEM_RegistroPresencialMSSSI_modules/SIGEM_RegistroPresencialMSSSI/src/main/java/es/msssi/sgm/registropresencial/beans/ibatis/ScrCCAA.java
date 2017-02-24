/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.sgm.registropresencial.beans.ibatis;

/**
 * Clase para manejar los datos de la tabla SCR_CCAA desde Ibatis, referentes
 * a la obtenci�n de comunidades aut�nomas.
 * 
 * @author cmorenog
 */
public class ScrCCAA {
    // Id de la CCAA
    private String id;
    // Nombre de la CCAA
    private String name;

    /**
     * Obtiene el valor del par�metro id.
     * 
     * @return id valor del campo a obtener.
     */
    public String getId() {
        return id;
    }
    /**
     * Guarda el valor del par�metro id.
     * 
     * @param id
     *            valor del campo a guardar.
     */
    public void setId(
        String id) {
        this.id = id;
    }
    /**
     * Obtiene el valor del par�metro name.
     * 
     * @return name valor del campo a obtener.
     */
    public String getName() {
        return name;
    }
    /**
     * Guarda el valor del par�metro name.
     * 
     * @param name
     *            valor del campo a guardar.
     */
    public void setName(
        String name) {
        this.name = name;
    }

}