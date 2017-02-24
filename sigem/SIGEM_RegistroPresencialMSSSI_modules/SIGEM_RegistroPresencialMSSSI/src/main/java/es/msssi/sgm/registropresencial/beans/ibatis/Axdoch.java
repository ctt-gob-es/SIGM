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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase para manejar los datos de las tablas AxDOCH desde Ibatis, a la hora de
 * mostrarlos en el listado de documentos anexos de un registro.
 * 
 * @author jortizs
 */
public class Axdoch {
    // Id. del documento.
    private Integer id;
    // Id. del registro.
    private Integer fdrid;
    // Nombre del documento.
    private String name;
    // Fecha de creaci�n.
    private Date crtndate;
    private List<Axpageh> pages = new ArrayList<Axpageh>();
    /**
     * Constructor.
     * 
     */
    public Axdoch() {

    }

    /**
     * Obtiene el valor del par�metro id.
     * 
     * @return id valor del campo a guardar.
     */
    public Integer getId() {
	return id;
    }

    /**
     * Obtiene el valor del par�metro id.
     * 
     * @param id
     *            valor del campo a obtener.
     */
    public void setId(Integer id) {
	this.id = id;
    }

    /**
     * Obtiene el valor del par�metro fdrid.
     * 
     * @return fdrid valor del campo a obtener.
     */
    public Integer getFdrid() {
	return fdrid;
    }

    /**
     * Guarda el valor del par�metro fdrid.
     * 
     * @param fdrid
     *            valor del campo a guardar.
     */
    public void setFdrid(Integer fdrid) {
	this.fdrid = fdrid;
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
    public void setName(String name) {
	this.name = name;
    }

    /**
     * Obtiene el valor del par�metro crtndate.
     * 
     * @return crtndate valor del campo a obtener.
     */
    public Date getCrtndate() {
	return crtndate;
    }

    /**
     * Guarda el valor del par�metro crtndate.
     * 
     * @param crtndate
     *            valor del campo a guardar.
     */
    public void setCrtndate(Date crtndate) {
	this.crtndate = crtndate;
    }
    
    /**
     * @param pages The pages to set.
     */
    public void setPages(List<Axpageh> pages) {
        this.pages = pages;
    }
    
    public void addPage(Axpageh page) {
        if (page != null) {
            pages.add(page);
        }
    }

    public List<Axpageh> getPages() {
        return pages;
    }
    
}