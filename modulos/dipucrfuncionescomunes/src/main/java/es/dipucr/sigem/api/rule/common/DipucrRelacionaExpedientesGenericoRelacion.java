package es.dipucr.sigem.api.rule.common;

import ieci.tdw.ispac.api.errors.ISPACRuleException;
import ieci.tdw.ispac.api.rule.IRuleContext;

import org.apache.log4j.Logger;

import es.dipucr.sigem.api.rule.common.DipucrRelacionaExpedientes;

public class DipucrRelacionaExpedientesGenericoRelacion extends DipucrRelacionaExpedientes{
	
	public static final Logger logger = Logger.getLogger(DipucrRelacionaExpedientesGenericoRelacion.class);
	
	public boolean init(IRuleContext rulectx) throws ISPACRuleException {
		logger.warn("DENTRO----------------------");
		relacion = "Plica";
	
		
		return true;
	}
}