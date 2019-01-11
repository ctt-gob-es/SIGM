package ieci.tdw.ispac.api.rule.procedures.planeamiento;

import ieci.tdw.ispac.api.errors.ISPACRuleException;
import ieci.tdw.ispac.api.rule.IRuleContext;

/**
 * 
 * @author teresa
 * Inicia propuesta aprobaci�n inicial Procedimiento Aprobaci�n y Modificaci�n del Plan de Ordenaci�n Municipal
 *
 */

public class InitPropuestaInicialPlaneamientoRule extends InitPropuestaPlaneamientoRule {

    public boolean init(IRuleContext rulectx) throws ISPACRuleException {
        strEntidad = "PLAN_POM";
        strExtracto = "Resoluci�n de aprobaci�n inicial del procedimiento de Aprobaci�n y Modificaci�n del Plan de Ordenaci�n Municipal";
        return true;
    }
}