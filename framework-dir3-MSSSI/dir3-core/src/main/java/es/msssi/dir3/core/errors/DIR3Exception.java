/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.dir3.core.errors;

/**
 * Clase para controlar excepciones que puedan darse en las operaciones del
 * dir3.
 * 
 * @author jortizs
 */
public class DIR3Exception extends BaseException {
    private static final long serialVersionUID = 1L;

    /**
     * Constructor con c�digo de error, mensaje y excepci�n capturada.
     * 
     * @param code
     *            C�digo de error
     * @param message
     *            Mensaje de error
     * @param throwable
     *            Excepci�n capturada
     */
    public DIR3Exception(DIR3ErrorCode code, String message, Throwable throwable) {
	super(code, message, throwable);
    }

    /**
     * Constructor con c�digo de error y mensaje.
     * 
     * @param code
     *            C�digo de error
     * @param message
     *            Mensaje
     */
    public DIR3Exception(DIR3ErrorCode code, String message) {
	super(code, message);
    }

    /**
     * Constructor con c�digo de error y excepci�n capturada.
     * 
     * @param code
     *            C�digo de error
     * @param throwable
     *            Excepci�n capturada
     */
    public DIR3Exception(DIR3ErrorCode code, Throwable throwable) {
	super(code, throwable);
    }
}