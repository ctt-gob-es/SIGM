/**
 * LICENCIA LGPL:
 * 
 * Esta librer�a es Software Libre; Usted puede redistribuirla y/o modificarla
 * bajo los t�rminos de la GNU Lesser General Public License (LGPL) tal y como 
 * ha sido publicada por la Free Software Foundation; o bien la versi�n 2.1 de 
 * la Licencia, o (a su elecci�n) cualquier versi�n posterior.
 * 
 * Esta librer�a se distribuye con la esperanza de que sea �til, pero SIN 
 * NINGUNA GARANT�A; tampoco las impl�citas garant�as de MERCANTILIDAD o 
 * ADECUACI�N A UN PROP�SITO PARTICULAR. Consulte la GNU Lesser General Public 
 * License (LGPL) para m�s detalles
 * 
 * Usted debe recibir una copia de la GNU Lesser General Public License (LGPL) 
 * junto con esta librer�a; si no es as�, escriba a la Free Software Foundation 
 * Inc. 51 Franklin Street, 5� Piso, Boston, MA 02110-1301, USA o consulte
 * <http://www.gnu.org/licenses/>.
 *
 * Copyright 2011 Agencia de Tecnolog�a y Certificaci�n Electr�nica
 */
package es.accv.arangi.base.exception;

/**
 * Excepci�n debida a que no se ha podido cargar el proveedor criptogr�fico de
 * Arangi.
 * 
 * @author <a href="mailto:jgutierrez@accv.es">Jos� M Guti�rrez</a>
 *
 */
public class NoSuchProviderException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchProviderException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoSuchProviderException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NoSuchProviderException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NoSuchProviderException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}


}
