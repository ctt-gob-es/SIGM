/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.sigm.ws.services;

import java.util.List;

import org.apache.log4j.Logger;

import es.msssi.sigm.core.connector.SigmConnector;
import es.msssi.sigm.core.exception.SigmWSException;
import es.msssi.sigm.core.util.Constants;
import es.msssi.sigm.core.util.XmlUtil;
import es.msssi.sigm.ws.beans.PeticionBusqueda;
import es.msssi.sigm.ws.beans.Registro;
import es.msssi.sigm.ws.beans.Registros;
import es.msssi.sigm.ws.beans.RespuestaBusqueda;
import es.msssi.sigm.ws.beans.SigmRequest;
import es.msssi.sigm.ws.beans.SigmResponse;

public class BuscarService extends SigmServiceBase implements SigmServiceI {

	private Logger log = Logger.getLogger(BuscarService.class.getName());
	private String peticionValidada;
	
	public BuscarService(SigmRequest request) {
		super(request);
	}
	
	@Override
	public void printRequest(SigmRequest request) {
		log.error("Petici�n err�nea: \n "+peticionValidada);
	}
	
	@Override
	public void validate() throws SigmWSException {
		log.debug("BuscarService... validando");
		
		PeticionBusqueda peticion = (PeticionBusqueda) request;
		peticionValidada = XmlUtil.validarPeticion(peticion);
				

		tipoRegistro = peticion.getTipoRegistro();
		if (tipoRegistro.equals(Constants.REGISTRO_ENTRADA))
			idBook = Constants.REGISTRO_ELECTRONICO_ENTRADA; 
		else if (tipoRegistro.equals(Constants.REGISTRO_SALIDA))
			idBook = Constants.REGISTRO_ELECTRONICO_SALIDA;
		 
		if(peticion.getFechaDesde() != null){
			
			if(peticion.getFechaHasta() == null){
				throw new SigmWSException("err.validacion.fechahasta.requerido");
			}
		}			
	}
		 

	@Override
	public SigmResponse internalExecute() throws SigmWSException {

		PeticionBusqueda peticion = (PeticionBusqueda) request;
		
		List<Registro> listRegistro = null;		
		
		
		SigmConnector connector = new SigmConnector();
		listRegistro = connector.buscar(user, pass, idBook, peticion);
			
		
		// GENERAR Respuesta
		log.debug("Procesando GENERANDO RESPUESTA...");
		
		RespuestaBusqueda result = new RespuestaBusqueda();
		result.setEstadoRespuesta(Constants.RESPONSE_OK);
		
		if(listRegistro != null && listRegistro.size() != 0) {
			Registros regs = new Registros();
			regs.setRegistro(listRegistro);
			result.setRegistros(regs);
			
		}
		
		return result;
		
	
	}


}
