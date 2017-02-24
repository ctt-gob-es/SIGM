package es.ieci.tecdoc.fwktd.sir.api.manager.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.ieci.tecdoc.fwktd.sir.api.manager.AuditoriaMensajeManager;
import es.ieci.tecdoc.fwktd.sir.api.manager.MensajeManager;
import es.ieci.tecdoc.fwktd.sir.api.manager.SicresXMLManager;
import es.ieci.tecdoc.fwktd.sir.api.types.BandejaEnum;
import es.ieci.tecdoc.fwktd.sir.api.vo.MensajeVO;
import es.ieci.tecdoc.fwktd.sir.core.util.ToStringLoggerHelper;

/**
 * Implementaci�n abstracta del manager de env�o de ficheros de datos de control
 * en formato SICRES 3.0 generado por la aplicaci�n de registro.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public abstract class MensajeManagerImpl implements MensajeManager {

	/**
	 * Logger de la clase.
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(MensajeManagerImpl.class);

	/**
	 * Gestor de XML de SICRES.
	 */
	private SicresXMLManager sicresXMLManager = null;

    /**
     * Gestor de auditor�a de mensajes.
     */
    private AuditoriaMensajeManager auditoriaMensajeManager = null;

	/**
	 * Constructor.
	 */
	public MensajeManagerImpl() {
		super();
	}

	public SicresXMLManager getSicresXMLManager() {
		return sicresXMLManager;
	}

	public void setSicresXMLManager(SicresXMLManager sicresXMLManager) {
		this.sicresXMLManager = sicresXMLManager;
	}

	public AuditoriaMensajeManager getAuditoriaMensajeManager() {
		return auditoriaMensajeManager;
	}

	public void setAuditoriaMensajeManager(
			AuditoriaMensajeManager auditoriaMensajeManager) {
		this.auditoriaMensajeManager = auditoriaMensajeManager;
	}

	/**
	 * {@inheritDoc}
	 * @see es.ieci.tecdoc.fwktd.sir.api.manager.MensajeManager#enviarMensaje(es.ieci.tecdoc.fwktd.sir.api.vo.MensajeVO)
	 */
	public void enviarMensaje(MensajeVO mensaje) {

		if (logger.isInfoEnabled()){
			logger.info("Llamada a enviarMensaje: [{}]", ToStringLoggerApiHelper.toStringLogger(mensaje));
		}

		// Validar la informaci�n del mensaje
		getSicresXMLManager().validarMensaje(mensaje);

		// Env�a el mensaje
		enviar(mensaje);

        // Audita el mensaje
    	getAuditoriaMensajeManager().audita(mensaje, BandejaEnum.ENVIADOS);
	}

	/**
	 * Env�a un fichero de datos de control.
	 *
	 * @param mensaje
	 *            Informaci�n de mensaje SICRES 3.0.
	 */
	protected abstract void enviar(MensajeVO mensaje);
}
