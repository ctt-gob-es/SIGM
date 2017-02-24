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

import org.apache.log4j.Logger;

import com.ieci.tecdoc.common.exception.SessionException;
import com.ieci.tecdoc.common.exception.ValidationException;
import com.ieci.tecdoc.isicres.session.validation.ValidationSessionEx;
import com.ieci.tecdoc.isicres.usecase.UseCaseConf;

import es.msssi.sgm.registropresencial.errors.ErrorConstants;
import es.msssi.sgm.registropresencial.errors.RPGenericErrorCode;
import es.msssi.sgm.registropresencial.errors.RPGenericException;

/**
 * Clase que implementa la interfaz IGenericBo que contiene los m�todos
 * relacionados con el cambio de oficina.
 * 
 * @author cmorenog
 */
public class ChangeOfficeBo implements IGenericBo, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(ChangeOfficeBo.class);

    /**
     * Devuelve una excepcion si la oficina no es v�lida.
     * 
     * @param useCaseConf
     *            Usuario que realiza la petici�n.
     * @param code
     *            C�digo de oficina.
     * 
     * @throws RPGenericException
     *             si se ha producido un error gen�rico en el proceso.
     */
    public void validateOfficeCode(
	UseCaseConf useCaseConf, String code)
	throws RPGenericException {
	LOG.trace("Entrando en ChangeOfficeBo.validateOfficeCode()");
	try {
	    LOG.info("Se va a validar el c�digo de oficina " +
		code + " para el usuario con Id " + useCaseConf.getSessionID() +
		" e Id de Entidad " + useCaseConf.getEntidadId());
	    ValidationSessionEx.validateOfficeCode(
		useCaseConf.getSessionID(), code, useCaseConf.getEntidadId());
	}
	catch (ValidationException validationException) {
	    LOG.error(
		ErrorConstants.VALIDATION_OFFICE_CODE_ERROR_MESSAGE, validationException);
	    throw new RPGenericException(
		RPGenericErrorCode.PARAMETER_VALIDATION_ERROR,
		ErrorConstants.PARAMETERS_VALIDATION_ERROR_MESSAGE, validationException);
	}
	catch (SessionException sessionException) {
	    LOG.error(
		ErrorConstants.VALIDATION_OFFICE_CODE_ERROR_MESSAGE, sessionException);
	    throw new RPGenericException(
		RPGenericErrorCode.SESSION_ERROR, ErrorConstants.SESSION_ERROR_MESSAGE,
		sessionException);
	}
    }
}