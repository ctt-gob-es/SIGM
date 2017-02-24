/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.dir3.api.vo;

import java.io.Serializable;

import es.msssi.dir3.api.type.CriterionEnum;
import es.msssi.dir3.api.type.OperatorCriterionEnum;

/**
 * Informaci�n de un criterio en las b�squedas.
 * 
 * @author cmorenog
 * 
 */
public class Criterion<ExtendedCriterioEnum extends CriterionEnum> implements Serializable {

    private static final long serialVersionUID = 5164807099767853323L;

    /**
     * Nombre del criterio
     */
    private ExtendedCriterioEnum name = null;

    /**
     * Operador
     */
    private OperatorCriterionEnum operator = OperatorCriterionEnum.EQUAL;

    /**
     * Valor
     */
    private Object value = null;

    /**
     * Constructor.
     */
    public Criterion() {
	super();
    }

    /**
     * Constructor.
     * 
     * @param name
     *            Nombre del criterio.
     * @param value
     *            Valor.
     */
    public Criterion(ExtendedCriterioEnum name, Object value) {
	this(name, OperatorCriterionEnum.EQUAL, value);
    }

    /**
     * Constructor.
     * 
     * @param name
     *            Nombre del criterio.
     * @param operator
     *            Operador.
     * @param value
     *            Valor.
     */
    public Criterion(ExtendedCriterioEnum name, OperatorCriterionEnum operator, Object value) {
	this();
	setName(name);
	setOperator(operator);
	setValue(value);
    }

    /**
     * Obtiene el valor del par�metro name.
     * 
     * @return name valor del campo a obtener.
     */
    public ExtendedCriterioEnum getName() {
	return name;
    }

    /**
     * Guarda el valor del par�metro name.
     * 
     * @param name
     *            valor del campo a guardar.
     */
    public void setName(
	ExtendedCriterioEnum name) {
	this.name = name;
    }

    /**
     * Obtiene el valor del par�metro operator.
     * 
     * @return operator valor del campo a obtener.
     */
    public OperatorCriterionEnum getOperator() {
	return operator;
    }

    /**
     * Guarda el valor del par�metro operator.
     * 
     * @param operator
     *            valor del campo a guardar.
     */
    public void setOperator(
	OperatorCriterionEnum operator) {
	this.operator = operator;
    }

    /**
     * Obtiene el valor del par�metro value.
     * 
     * @return value valor del campo a obtener.
     */
    public Object getValue() {
	return value;
    }

    /**
     * Guarda el valor del par�metro value.
     * 
     * @param value
     *            valor del campo a guardar.
     */
    public void setValue(
	Object value) {
	this.value = value;
    }
}
