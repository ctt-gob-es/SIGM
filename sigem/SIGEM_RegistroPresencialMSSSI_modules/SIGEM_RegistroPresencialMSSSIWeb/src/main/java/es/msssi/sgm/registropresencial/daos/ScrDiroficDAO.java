/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.sgm.registropresencial.daos;

import org.apache.log4j.Logger;

import es.msssi.sgm.registropresencial.beans.ibatis.ScrDirofic;
import es.msssi.sgm.registropresencial.dao.SqlMapClientBaseDao;

/**
 * Clase que contiene los m�todos para recuperar la direcci�n de una oficina.
 * 
 * @author cmorenog
 * 
 */
public class ScrDiroficDAO extends SqlMapClientBaseDao {
    private static final Logger LOG = Logger.getLogger(ScrDiroficDAO.class.getName());

    /**
     * Obtiene la direcci�n de la oficina.
     * @param idOfic
     * 		id de la oficina.
     * @return dirofic direccion de la oficina.
     */
    @SuppressWarnings("unchecked")
    public ScrDirofic getDireccionOfic(Integer idOfic) {
	LOG.trace("Entrando en ScrDiroficDAO.getDireccionOfic");

	ScrDirofic result = null;
	result =
		(ScrDirofic) getSqlMapClientTemplate().queryForObject("ScrDirofic.selectScrDirofic", idOfic);
	
	LOG.trace("Saliendo de ScrDiroficDAO.getDireccionOfic");
	return result;
    }

}