/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.sgm.registropresencial.businessobject;

import java.io.Serializable;
import java.util.List;

import net.sf.hibernate.Criteria;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.expression.Expression;

import org.apache.log4j.Logger;

import com.ieci.tecdoc.common.exception.AttributesException;
import com.ieci.tecdoc.common.exception.SessionException;
import com.ieci.tecdoc.common.exception.ValidationException;
import com.ieci.tecdoc.common.invesicres.ScrTt;
import com.ieci.tecdoc.common.utils.EntityByLanguage;
import com.ieci.tecdoc.isicres.usecase.UseCaseConf;
import com.ieci.tecdoc.utils.HibernateUtil;
import com.ieci.tecdoc.utils.cache.CacheFactory;

import es.msssi.sgm.registropresencial.errors.ErrorConstants;

/**
 * Clase que implementa IGenericBo que contiene los m�todos relacionados con los
 * transportes.
 * 
 * @author cmorenog
 */
public class TransportBo implements IGenericBo, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(TransportBo.class.getName());

    /**
     * Devuelve una lista de tipos de transporte.
     * 
     * @param useCaseConf
     *            Usuario que realiza la petici�n.
     * 
     * @return result Listado de tipos de transporte disponibles.
     * 
     * @throws AttributesException
     *             si ha habido alg�n problema con los atributos.
     * @throws SessionException
     *             si ha habido alg�n problema con la sesi�n.
     * @throws ValidationException
     *             si ha habido alg�n problema con en la validaci�n.
     */
    @SuppressWarnings("unchecked")
    public String getScrttNameById(
	UseCaseConf useCaseConf, String id) {
	LOG.trace("Entrando en ValidationListBo.getScrttNameById()");

	HibernateUtil hibernateUtil = new HibernateUtil();
	Transaction tran = null;
	String result = null;
	try {
	    if (id != null && !"".equals(id)){
        	    Session session = hibernateUtil.currentSession(useCaseConf.getEntidadId());
        	    tran = session.beginTransaction();
        	    // Recuperamos la sesi�n
        	    CacheFactory.getCacheInterface().getCacheEntry(
        		useCaseConf.getSessionID());
        
        	    Criteria criteriaResults =
        		session.createCriteria(EntityByLanguage.getScrTtLanguage(useCaseConf.getLocale()
        		    .getLanguage()));
        	    if (id.startsWith("0")){
        		id = id.substring(1);
        	    }
        	    criteriaResults.add(Expression.eq(
    			"id", Integer.parseInt(id)));
        	    List<ScrTt> list = (List<ScrTt>) criteriaResults.list();
        	    if (list != null && list.size() ==1){
        		result = list.get(0).getTransport();
        	    }
        	    hibernateUtil.commitTransaction(tran);
	    }
	}
	catch (SessionException sessionException) {
	    LOG.error(
		ErrorConstants.GET_TRANSPORT_TYPES_LIST_ERROR_MESSAGE +
		    " [" + useCaseConf.getSessionID() + "]", sessionException);
	    result = null;
	}
	catch (Exception exception) {
	    LOG.error(
		ErrorConstants.GET_TRANSPORT_TYPES_LIST_ERROR_MESSAGE +
		    " [" + useCaseConf.getSessionID() + "]", exception);
	    result = null;
	    hibernateUtil.rollbackTransaction(tran);
	}
	finally {
	    hibernateUtil.closeSession(useCaseConf.getEntidadId());
	}
	return result;
    }
}