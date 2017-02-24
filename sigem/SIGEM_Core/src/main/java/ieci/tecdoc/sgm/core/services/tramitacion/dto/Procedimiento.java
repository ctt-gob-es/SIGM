package ieci.tecdoc.sgm.core.services.tramitacion.dto;

import java.io.Serializable;


/**
 * Informaci�n de un procedimiento.
 */
public class Procedimiento implements Serializable {
	
	/** Informaci�n b�sica del procedimiento. */
	private InfoBProcedimiento informacionBasica = new InfoBProcedimiento();
	
	/** Objeto del procedimiento. */
	private String objeto = null;
	
	/** Tr�mites del procedimiento. */
	private String tramites = null;
	
	/** Normativa del procedimiento. */
	private String normativa = null;
	
	/** Documentos b�sicos del procedimiento. */
	private String documentosBasicos = null;
	
	/** �rganos productores del procedimiento. */
	private OrganoProductor [] organosProductores = new OrganoProductor[0];
	
	
	/**
	 * Constructor.
	 */
	public Procedimiento() {
		super();
	}
	
	
	
	/**
	 * Obtiene los documentos b�sicos del procedimiento.
	 * @return Documentos b�sicos del procedimiento.
	 */
	public String getDocumentosBasicos() {
		return documentosBasicos;
	}
	
	
	/**
	 * Establece los documentos b�sicos del procedimiento.
	 * @param documentosBasicos Documentos b�sicos del procedimiento.
	 */
	public void setDocumentosBasicos(String documentosBasicos) {
		this.documentosBasicos = documentosBasicos;
	}
	
	
	/**
	 * Obtiene la informaci�n b�sica del procedimiento.
	 * @return Informaci�n b�sica del procedimiento.
	 */
	public InfoBProcedimiento getInformacionBasica() {
		return informacionBasica;
	}
	
	
	/**
	 * Establece la informaci�n b�sica del procedimiento.
	 * @param informacionBasica Informaci�n b�sica del procedimiento.
	 */
	public void setInformacionBasica(InfoBProcedimiento informacionBasica) {
		this.informacionBasica = informacionBasica;
	}
	
	
	/**
	 * Obtiene la normativa del procedimiento.
	 * @return Normativa del procedimiento.
	 */
	public String getNormativa() {
		return normativa;
	}
	
	
	/**
	 * Establece la normativa del procedimiento.
	 * @param normativa Normativa del procedimiento.
	 */
	public void setNormativa(String normativa) {
		this.normativa = normativa;
	}
	
	
	/**
	 * Obtiene el objeto del procedimiento.
	 * @return Objeto del procedimiento.
	 */
	public String getObjeto() {
		return objeto;
	}
	
	
	/**
	 * Establece el objeto del procedimiento.
	 * @param objeto Objeto del procedimiento.
	 */
	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}
	
	
	/**
	 * Obtiene los �rganos productores del procedimiento.
	 * @return �rganos productores del procedimiento.
	 */
	public OrganoProductor [] getOrganosProductores() {
		return organosProductores;
	}
	
	
	/**
	 * Establece los �rganos productores del procedimiento.
	 * @param organosProductores �rganos productores del procedimiento.
	 */
	public void setOrganosProductores(OrganoProductor [] organosProductores) {
		this.organosProductores = organosProductores;
	}
	
	
	/**
	 * Obtiene los tr�mites del procedimiento.
	 * @return Tr�mites del procedimiento.
	 */
	public String getTramites() {
		return tramites;
	}
	
	
	/**
	 * Establece los tr�mites del procedimiento.
	 * @param tramites Tr�mites del procedimiento.
	 */
	public void setTramites(String tramites) {
		this.tramites = tramites;
	}

}