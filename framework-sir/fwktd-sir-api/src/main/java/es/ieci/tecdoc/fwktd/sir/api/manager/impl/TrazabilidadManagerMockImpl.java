package es.ieci.tecdoc.fwktd.sir.api.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import es.ieci.tecdoc.fwktd.sir.api.manager.TrazabilidadManager;
import es.ieci.tecdoc.fwktd.sir.core.vo.TrazabilidadVO;

/**
 * Implementaci�n mock del manager de trazabilidad para pruebas.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public class TrazabilidadManagerMockImpl implements TrazabilidadManager {

	/**
	 * Logger de la clase.
	 */
	private static final Logger logger = LoggerFactory.getLogger(TrazabilidadManagerMockImpl.class);

	
	/**
	 * Constructor.
	 */
	public TrazabilidadManagerMockImpl() {
		super();
	}


	/**
	 * Consulta los estados de trazabilidad insertados asociados a un
	 * intercambio.
	 *
	 * @param codEntReg
	 *            C�digo de la Entidad Registral.
	 * @param codigoIntercambio
	 *            C�digo �nico de intercambio de registro.
	 * @param isRegistro
	 *            Flag que indica si se trata de un registro o un mensaje.
	 *            True-Fichero de intercambio, False-Fichero de mensaje.
	 * @param soloEstadoFinal
	 *            Flag que indica si se desean recuperar todos los estados, o
	 *            �nicamente los finales (Enviado, Reenviado, Rechazado o
	 *            Confirmado). True: indica que se quieren recuperar solo los
	 *            estados finales. False: se recuperar�n todos los estados.
	 * @return Informaci�n de la trazabilidad.
	 */
	public List<TrazabilidadVO> getTrazabilidad(String codEntReg,
			String codigoIntercambio, boolean isRegistro,
			boolean soloEstadoFinal) {

		logger.warn("Se est� utilizando la implementaci�n MOCK de TrazabilidadManager !!!");
		logger.info(
				"Llamada a getTrazabilidad: codEntReg=[{}], codigoIntercambio=[{}], isRegistro=[{}], soloEstadoFinal=[{}]",
				new Object[] { codEntReg, codigoIntercambio, isRegistro, soloEstadoFinal });

		Assert.notNull(codigoIntercambio, "'codigoIntercambio' must not be null");

		return new ArrayList<TrazabilidadVO>();
	}


	/**
	 * Inserta una traza asociada a un intercambio.
	 * 
	 * @param traza
	 *            Informaci�n de la trazabilidad.
	 * @return
	 */
	public void insertarTrazabilidad(TrazabilidadVO traza) {

		logger.warn("Se est� utilizando la implementaci�n MOCK de TrazabilidadManager !!!");
		logger.info("Llamada a insertarTrazabilidad: traza=[{}]", traza);

		Assert.notNull(traza, "'traza' must not be null");
	}
}
