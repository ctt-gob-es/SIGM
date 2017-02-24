/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.dir3.api.type;

/**
 * Enumerados para las constantes de los organismos raiz.
 * 
 * @author cmorenog
 * 
 */
public class UOTypeEnum extends StringValuedEnum {
    /**
     */
    public static final UOTypeEnum E = new UOTypeEnum(
	"E", "2");
    /**
     */
    public static final UOTypeEnum A = new UOTypeEnum(
	"A", "3");
    /**
     */
    public static final UOTypeEnum L = new UOTypeEnum(
	"L", "4");
    /**
     */
    public static final UOTypeEnum O = new UOTypeEnum(
	"O", "8");
    private static final long serialVersionUID = -5427563304712979383L;

    /**
     * Constructor.
     * 
     * @param name
     *            Nombre del enumerado.
     * @param value
     *            Valor del enumerado.
     */
    protected UOTypeEnum(String name, String value) {
	super(name, value);
    }

    /**
     * Obtiene la constante asociada al valor.
     * 
     * @param codigo
     *            el codigo de un organismo.
     * @return Constante.
     */
    public static UOTypeEnum getRaiz(
	String codigo) {
	String cod = codigo.substring(0, 1); 

	UOTypeEnum result = null;
	result = (UOTypeEnum) StringValuedEnum.getEnumName(
		UOTypeEnum.class, cod);
	if (result == null){
	    result = UOTypeEnum.O;
	}
	return result;
    }
}
