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
 * Enumerados para las constantes de los nombres de los criterios de las
 * b�squedas de oficinas.
 * 
 * @author cmorenog
 * 
 */
public class OfficeCriterionEnum extends CriterionEnum {

    private static final long serialVersionUID = 2532489523387703362L;
    /** Identificador de la tabla. */
    public static final String TABLE_DIR_OFICINA = "OFI";
    /** Identificador de la oficina. */
    public static final OfficeCriterionEnum OFICINA_ID = new OfficeCriterionEnum(
	TABLE_DIR_OFICINA, "OFICINA_ID", "C_ID_OFICINA");
    /** Nombre de la oficina. */
    public static final OfficeCriterionEnum OFICINA_NOMBRE = new OfficeCriterionEnum(
	TABLE_DIR_OFICINA, "OFICINA_NOMBRE", "C_DNM_OFICINA");
    /** Estado de la oficina. */
    public static final OfficeCriterionEnum OFICINA_ESTADO = new OfficeCriterionEnum(
	TABLE_DIR_OFICINA, "OFICINA_ESTADO", "C_ID_ESTADO");
    /** Unidad responsable de la oficina. */
    public static final OfficeCriterionEnum OFICINA_ID_UNIDAD_RESPONSABLE =
	new OfficeCriterionEnum(
	    TABLE_DIR_OFICINA, "OFICINA_ID_UNIDAD_RESPONSABLE", "C_ID_UNIDAD_RESPONSABLE");
    /** C�digo externo de la Entidad P�blica. */
    public static final OfficeCriterionEnum OFICINA_ID_EXTERNO_FUENTE = new OfficeCriterionEnum(
	TABLE_DIR_OFICINA, "OFICINA_ID_EXTERNO_FUENTE", "C_ID_EXTERNO_FUENTE");

    /**
     * Constructor.
     * 
     * @param table
     *            Nombre de la tabla.
     * @param name
     *            Nombre del enumerado.
     * @param value
     *            Valor del enumerado.
     */
    protected OfficeCriterionEnum(String table, String name, String value) {
	super(table, name, value);
    }

    /**
     * Obtiene la constante asociada al valor.
     * 
     * @param value
     *            Valor de la constante.
     * @return Constante.
     */
    public static OfficeCriterionEnum getCriterion(
	String value) {
	return (OfficeCriterionEnum) StringValuedEnum.getEnum(
	    OfficeCriterionEnum.class, value);
    }

    /**
     * Obtiene la constante asociada al nombre.
     * 
     * @param nombre
     *            Valor de la constante.
     * @return Constante.
     */
    public static OfficeCriterionEnum getNameCriterion(
	String nombre) {
	return (OfficeCriterionEnum) StringValuedEnum.getEnumName(
	    OfficeCriterionEnum.class, nombre);
    }
}
