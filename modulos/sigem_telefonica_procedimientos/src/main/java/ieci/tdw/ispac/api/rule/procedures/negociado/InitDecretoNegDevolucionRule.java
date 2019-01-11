package ieci.tdw.ispac.api.rule.procedures.negociado;

import ieci.tdw.ispac.api.errors.ISPACRuleException;
import ieci.tdw.ispac.api.rule.IRuleContext;

/**
 * 
 * @author teresa
 * @date 17/11/2009
 * @prop�sito Inicializa el expediente de decreto asociado al expediente de Convocatoria Negociado de contrataci�n actual.
 */
public class InitDecretoNegDevolucionRule extends InitDecretoNegRule {

    public boolean init(IRuleContext rulectx) throws ISPACRuleException {
        strEntidad = "SGN_NEGOCIADO";
        strExtracto = "Devoluci�n de la fianza de convocatoria de contrataci�n";
        return true;
    }
    
}