/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.dir3.services;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPBinding;

import consultservice.ws.dir3.msssi.es.consultbasicdataofresponse.ConsultBasicDataOFResponse;
import consultservice.ws.dir3.msssi.es.consultbasicdatauoresponse.ConsultBasicDataUOResponse;
import consultservice.ws.dir3.msssi.es.consultofrequest.ConsultOFRequest;
import consultservice.ws.dir3.msssi.es.consultofresponse.ConsultOFResponse;
import consultservice.ws.dir3.msssi.es.consultuorequest.ConsultUORequest;
import consultservice.ws.dir3.msssi.es.consultuoresponse.ConsultUOResponse;
import consultservice.ws.dir3.msssi.es.countofrequest.CountOFRequest;
import consultservice.ws.dir3.msssi.es.countresponse.CountResponse;
import consultservice.ws.dir3.msssi.es.countuorequest.CountUORequest;
import consultservice.ws.dir3.msssi.es.getofrequest.GetOFRequest;
import consultservice.ws.dir3.msssi.es.getofresponse.GetOFResponse;
import consultservice.ws.dir3.msssi.es.getuorequest.GetUORequest;
import consultservice.ws.dir3.msssi.es.getuoresponse.GetUOResponse;
import es.msssi.dir3.ws.ConsultService;
import es.msssi.dir3.ws.ConsultServiceService;
import es.msssi.dir3.ws.Dir3WSException_Exception;

/**
 * Clase que implementa los metodos que ofrece el servicio dir3.
 * 
 * @author cmorenog
 * 
 */
public class ConsultServiceImpl extends ServiceBaseImpl {

    private static ConsultServiceService service;

    /**
     * Inicializacion de la implementacion del servicio. Carga la configuracion
     * del servicio que hay desplegada en el servidor de aplicaciones a traves
     * del nombre jndi de la misma
     */
    static {
	service = (ConsultServiceService) getCtxService(DIR3SERVICE);
    }

    /**
     * Metodo que devuelve el puerto de conexion con el servicio.
     * 
     * @return InformationService el puerto de conexion con el servicio.
     */
    private static ConsultService getPort() {
	ConsultService port = service.getConsultServicePort();
	BindingProvider bp = (BindingProvider) port;
	SOAPBinding binding = (SOAPBinding) bp.getBinding();
	binding.setMTOMEnabled(false);
	return port;
    }

    /**
     * Devuelve el n�mero de oficinas que cumplen los criterios de entrada.
     * 
     * @param request
     *            criterios de b�squeda que deben cumplir las oficinas.
     * 
     * @return CountResponse el n�mero de oficinas que cumplen con los criterios
     *         indicados.
     * @throws Dir3WSException_Exception.
     */
    public static CountResponse countOffices(
	CountOFRequest request)
	throws Dir3WSException_Exception {
	return (CountResponse) getPort().countOffices(
	    request);
    }

    /**
     * Devuelve el n�mero de unidades org�nicas que cumplen los criterios de
     * entrada.
     * 
     * @param request
     *            criterios de b�squeda que deben cumplir las unidades
     *            org�nicas.
     * 
     * @return CountResponse el n�mero de unidades org�nicas que cumplen con los
     *         criterios indicados.
     * @throws Dir3WSException_Exception.
     */
    public static CountResponse countUnits(
	CountUORequest request)
	throws Dir3WSException_Exception {
	return (CountResponse) getPort().countUnits(
	    request);
    }

    /**
     * Devuelve la lista de unidades org�nicas que cumplen los criterios de
     * entrada.
     * 
     * @param request
     *            criterios de b�squeda que deben cumplir las unidades
     *            org�nicas.
     * @return ConsultUOResponse lista de unidades org�nicas que cumplen los
     *         criterios indicados.
     * @throws Dir3WSException_Exception.
     */
    public static ConsultUOResponse findUnits(
	ConsultUORequest request)
	throws Dir3WSException_Exception {
	return (ConsultUOResponse) getPort().findUnits(
	    request);
    }

    /**
     * Devuelve una lista con los datos b�sicos de las unidades org�nicas que
     * cumplen los criterios de entrada.
     * 
     * @param request
     *            criterios de b�squeda que deben cumplir las unidades
     *            org�nicas.
     * 
     * @return ConsultBasicDataUOResponse lista con los datos b�sicos de
     *         unidades org�nicas que cumplen los criterios indicados.
     * @throws Dir3WSException_Exception.
     */
    public static ConsultBasicDataUOResponse findBasicDataUnits(
	ConsultUORequest request)
	throws Dir3WSException_Exception {
	return (ConsultBasicDataUOResponse) getPort().findBasicDataUnits(
	    request);
    }

    /**
     * Devuelve la lista de las oficinas que cumplen los criterios de entrada.
     * 
     * @param request
     *            criterios de b�squeda que deben cumplir las oficinas.
     * @return ConsultOFResponse lista de oficinas que cumplen los criterios
     *         indicados.
     * @throws Dir3WSException_Exception.
     */
    public static ConsultOFResponse findOffices(
	ConsultOFRequest request)
	throws Dir3WSException_Exception {
	return (ConsultOFResponse) getPort().findOffices(
	    request);
    }

    /**
     * Devuelve una lista con los datos b�sicos de las oficinas que cumplen los
     * criterios de entrada.
     * 
     * @param request
     *            criterios de b�squeda que deben cumplir las oficinas.
     * 
     * @return ConsultBasicDataOFResponse lista con los datos b�sicos de
     *         oficinas que cumplen los criterios indicados.
     * @throws Dir3WSException_Exception.
     */
    public static ConsultBasicDataOFResponse findBasicDataOffices(
	ConsultOFRequest request)
	throws Dir3WSException_Exception {
	return (ConsultBasicDataOFResponse) getPort().findBasicDataOffices(
	    request);
    }

    /**
     * Devuelve la unidad org�nica con el id introducido.
     * 
     * @param request
     *            El identificador de la unidad org�nica a recuperar.
     * 
     * @return GetUOResponse la unidad org�nica con el id establecido.
     * @throws Dir3WSException_Exception.
     */
    public static GetUOResponse getUnit(
	GetUORequest request)
	throws Dir3WSException_Exception {
	return (GetUOResponse) getPort().getUnit(
	    request);
    }

    /**
     * Devuelve una oficina con el id introducido.
     * 
     * @param request
     *            El identificador de la oficina a recuperar.
     * 
     * @return GetOFResponse la oficina con el id establecido.
     * @throws Dir3WSException_Exception.
     */
    public static GetOFResponse getOffice(
	GetOFRequest request)
	throws Dir3WSException_Exception {
	return (GetOFResponse) getPort().getOffice(
	    request);
    }
}
