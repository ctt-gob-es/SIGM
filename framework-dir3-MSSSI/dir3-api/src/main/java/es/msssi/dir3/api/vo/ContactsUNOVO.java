/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.dir3.api.vo;

import java.util.List;

import es.msssi.dir3.core.vo.Entity;

/**
 * Datos de contactos de las unidades.
 * 
 * @author cmorenog
 * 
 */
public class ContactsUNOVO extends Entity {

    private static final long serialVersionUID = 4502717489198772621L;

    private List<ContactUOVO> contacts;

    /**
     * Obtiene el valor del par�metro contacts.
     * 
     * @return contacts valor del campo a obtener.
     */
    public List<ContactUOVO> getContacts() {
	return contacts;
    }

    /**
     * Guarda el valor del par�metro contacts.
     * 
     * @param contacts
     *            valor del campo a guardar.
     */
    public void setContacts(
	List<ContactUOVO> contacts) {
	this.contacts = contacts;
    }

}
