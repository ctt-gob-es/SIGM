package ieci.tdw.ispac.api.rule.procedures.secretaria;

import ieci.tdw.ispac.api.errors.ISPACRuleException;
import ieci.tdw.ispac.api.rule.IRuleContext;

public class GenerateActaConDebatesRule extends GenerateActaRule {

	public boolean init(IRuleContext rulectx) throws ISPACRuleException {
		STR_docName = "Borrador de Acta de Sesi�n con debates";
		STR_footerDocName = "Borrador de Acta de Sesi�n - Propuesta - Pie con debate";
		return true;
	}
}
