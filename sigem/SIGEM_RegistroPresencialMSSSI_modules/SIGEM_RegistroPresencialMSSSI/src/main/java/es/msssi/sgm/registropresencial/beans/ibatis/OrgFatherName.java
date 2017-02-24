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
 * Clase para manejar los datos de la tabla SCR_ORGS desde Ibatis, referentes a
 * la obtenci�n del nombre del organismo padre de un organismo.
 * 
 * @author jortizs
 */
public class OrgFatherName {
    // Nombre del organismo padre
    String fatherName;

    /**
     * Obtiene el valor del par�metro fatherName.
     * 
     * @return fatherName valor del campo a obtener.
     */
    public String getFatherName() {
	return fatherName;
    }

    /**
     * Guarda el valor del par�metro fatherName.
     * 
     * @param fatherName
     *            valor del campo a guardar.
     */
    public void setFatherName(String fatherName) {
	this.fatherName = fatherName;
    }
}