package es.ieci.tecdoc.fwktd.sir.api.vo;

import es.ieci.tecdoc.fwktd.core.model.BaseValueObject;
import es.ieci.tecdoc.fwktd.sir.core.types.ValidacionCertificadoEnum;
import es.ieci.tecdoc.fwktd.sir.core.types.ValidacionFirmaEnum;
import es.ieci.tecdoc.fwktd.sir.core.vo.AnexoVO;

/**
 * Informaci�n de la validez de un anexo.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public class ValidacionAnexoVO extends BaseValueObject {

	private static final long serialVersionUID = 241341370095354932L;

	/**
	 * Informaci�n del anexo.
	 */
	private AnexoVO anexo = null;

	/**
	 * Indica si el hash es correcto.
	 */
	private boolean hashValidado = false;

    /**
     * Validaci�n del certificado.
     */
    private ValidacionCertificadoEnum validacionCertificado = ValidacionCertificadoEnum.SIN_CERTIFICADO;

    /**
     * Descripci�n del error en la validaci�n del certificado.
     */
    private String descripcionErrorValidacionCertificado = null;

    /**
     * Indica si la validaci�n OCSP del certificado es correcta.
     */
    private boolean validacionOCSPCertificado = false;

	/**
	 * Validaci�n de la firma digital.
	 */
    private ValidacionFirmaEnum validacionFirma = ValidacionFirmaEnum.SIN_FIRMA;

	/**
	 * Constructor.
	 */
	public ValidacionAnexoVO() {
		super();
	}

	public AnexoVO getAnexo() {
		return anexo;
	}

	public void setAnexo(AnexoVO anexo) {
		this.anexo = anexo;
	}

	public boolean isHashValidado() {
		return hashValidado;
	}

	public void setHashValidado(boolean hashValidado) {
		this.hashValidado = hashValidado;
	}

	public ValidacionCertificadoEnum getValidacionCertificado() {
		return validacionCertificado;
	}

	public void setValidacionCertificado(
			ValidacionCertificadoEnum validacionCertificado) {
		this.validacionCertificado = validacionCertificado;
	}

	public String getDescripcionErrorValidacionCertificado() {
		return descripcionErrorValidacionCertificado;
	}

	public void setDescripcionErrorValidacionCertificado(
			String descripcionErrorValidacionCertificado) {
		this.descripcionErrorValidacionCertificado = descripcionErrorValidacionCertificado;
	}

	public boolean isValidacionOCSPCertificado() {
		return validacionOCSPCertificado;
	}

	public void setValidacionOCSPCertificado(boolean validacionOCSPCertificado) {
		this.validacionOCSPCertificado = validacionOCSPCertificado;
	}

	public ValidacionFirmaEnum getValidacionFirma() {
		return validacionFirma;
	}

	public void setValidacionFirma(ValidacionFirmaEnum validacionFirma) {
		this.validacionFirma = validacionFirma;
	}
}
