/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.dir3.errors;

/**
 * Clase que recoge las constantes de error, que se mostrar�n en las excepciones
 * y en el log del ws.
 * 
 * @author cmorenog
 */
public class Dir3WSErrorConstants {
    /** Error consultando unidades organizativas. */
    public static final String FIND_UO_MESSAGE = "DIR3WS000001 Find UO Error";
    /** Error consultando el n�mero de unidades organizativas. */
    public static final String COUNT_UO_MESSAGE = "DIR3WS000002 Count UO Error";
    /** Error recuperando una unidad organizativa. */
    public static final String GET_UO_MESSAGE = "DIR3WS000003 Get UO Error";
    /** Error consultando oficinas. */
    public static final String FIND_OF_MESSAGE = "DIR3WS000004 Find UO Error";
    /** Error consultando el n�mero de oficinas. */
    public static final String COUNT_OF_MESSAGE = "DIR3WS000005 Count UO Error";
    /** Error recuperando una oficinas. */
    public static final String GET_OF_MESSAGE = "DIR3WS000006 Get UO Error";

}