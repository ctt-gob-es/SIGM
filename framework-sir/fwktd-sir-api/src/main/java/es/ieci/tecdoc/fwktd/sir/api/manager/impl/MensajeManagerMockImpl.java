package es.ieci.tecdoc.fwktd.sir.api.manager.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.ieci.tecdoc.fwktd.sir.api.vo.MensajeVO;
import es.ieci.tecdoc.fwktd.sir.core.util.ToStringLoggerHelper;

/** 
 * Implementaci�n MOCK del manager de env�o de ficheros de datos de intercambio
 * en formato SICRES 3.0 generado por la aplicaci�n de registro.

 * @author Iecisa 
 * @version $Revision$ 
 *
 */
public class MensajeManagerMockImpl extends MensajeManagerImpl {

	/**
	 * Logger de la clase.
	 */
	private static final Logger logger = LoggerFactory.getLogger(MensajeManagerMockImpl.class);

	/**
	 * Constructor.
	 */
	public MensajeManagerMockImpl() {
		super();
	}

	/**
	 * Env�a el fichero de datos de control al nodo distribuido asociado.
	 *
	 * @param mensaje
	 *            Informaci�n de mensaje SICRES 3.0.
	 */
	protected void enviar(MensajeVO mensaje) {

		logger.warn("Se est� utilizando la implementaci�n MOCK de MensajeManager !!!");
		
		if (logger.isInfoEnabled()){
			logger.info("Llamada a enviar: [{}]", ToStringLoggerApiHelper.toStringLogger(mensaje));
		}

		// Componer el XML del mensaje en formato SICRES 3.0
		logger.debug("XML mensaje: {}",
				getSicresXMLManager().createXMLMensaje(mensaje));
	}

}
