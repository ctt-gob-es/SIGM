package ieci.tdw.ispac.api.rule.procedures.urbanismo;

import ieci.tdw.ispac.api.errors.ISPACRuleException;
import ieci.tdw.ispac.api.rule.IRuleContext;

public class InitPropuestaIlegalParalizacionRule extends InitPropuestaIlegalRule {

	public boolean init(IRuleContext rulectx) throws ISPACRuleException
	{
		STR_entidad = "URB_ILEGAL";
		STR_extracto = "Resoluci�n de paralizaci�n de obras";
		STR_estado = "ESTADO_PARALIZACION";
		STR_queryDocumento = "DESCRIPCION = 'Decreto de paralizaci�n de obra - Obra ilegal'";		
        return true;
    }
}