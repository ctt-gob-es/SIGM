package ieci.tecdoc.sgm.registropresencial.ws.server;

/**
 * Almacena valores, su significado depende del contexto. Al rechazar una
 * distribuci�n ser� el motivo del rechazo y al cambiar el destino de esta ser�
 * el nuevo destino
 * 
 */
public class DistributionOptions {

	/**
	 * Almacena el motivo del rechazo
	 */
	private String remarks;

	/**
	 * Almacena el c�digo del nuevo destino
	 */
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
