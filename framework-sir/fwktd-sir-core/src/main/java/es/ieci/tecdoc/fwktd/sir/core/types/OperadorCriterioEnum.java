package es.ieci.tecdoc.fwktd.sir.core.types;

import es.ieci.tecdoc.fwktd.core.enums.StringValuedEnum;

/**
 * Enumerados para las constantes de los operadores de los criterios de las
 * b�squedas.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public class OperadorCriterioEnum extends StringValuedEnum {

	private static final long serialVersionUID = -8272936321705461648L;

	public static final OperadorCriterioEnum EQUAL = new OperadorCriterioEnum("==", "=");
	public static final OperadorCriterioEnum NOT_EQUAL = new OperadorCriterioEnum("!=", "!=");
	public static final OperadorCriterioEnum LIKE = new OperadorCriterioEnum("=", "like");
	public static final OperadorCriterioEnum LESS_THAN = new OperadorCriterioEnum("<", "<");
	public static final OperadorCriterioEnum EQUAL_OR_LESS_THAN = new OperadorCriterioEnum("<=", "<=");
	public static final OperadorCriterioEnum GREATER_THAN = new OperadorCriterioEnum(">", ">");
	public static final OperadorCriterioEnum EQUAL_OR_GREATER_THAN = new OperadorCriterioEnum(">=", ">=");
	public static final OperadorCriterioEnum IN = new OperadorCriterioEnum("in", "in");

	/**
	 * Constructor.
	 *
	 * @param name
	 *            Nombre del enumerado.
	 * @param value
	 *            Valor del enumerado.
	 */
	protected OperadorCriterioEnum(String name, String value) {
		super(name, value);
	}

	/**
	 * Obtiene la constante asociada al valor.
	 * @param value Valor de la constante
	 * @return Constante.
	 */
	public static OperadorCriterioEnum getOperadorCriterio(String value) {
		return (OperadorCriterioEnum) StringValuedEnum.getEnum(OperadorCriterioEnum.class, value);
	}
}
