package es.ieci.tecdoc.isicres.api.business.exception;

/**
 * Excepci�n que se lanza en caso de que se produzca una situaci�n erronea
 * durante la operativa de distribuci�n de registros.
 * 
 * @author IECISA
 * 
 */
public class DistributionException extends RuntimeException {

	public DistributionException() {
		super();
	}

	public DistributionException(String message, Throwable cause) {
		super(message, cause);
	}

	public DistributionException(String message) {
		super(message);
	}

	public DistributionException(Throwable cause) {
		super(cause);
	}

	private static final long serialVersionUID = 2374110498606610075L;

}
