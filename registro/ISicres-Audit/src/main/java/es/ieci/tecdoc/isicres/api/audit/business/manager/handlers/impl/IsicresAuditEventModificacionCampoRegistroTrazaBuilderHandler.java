package es.ieci.tecdoc.isicres.api.audit.business.manager.handlers.impl;

import es.ieci.tecdoc.isicres.api.audit.business.vo.enums.IsicresEventAuditTypeEnum;
/**
 * Clase manejadora para la generaci�n de trazas de auditor�a en la modificaci�n de un campo de registro
 * @author IECISA
 *
 */
public class IsicresAuditEventModificacionCampoRegistroTrazaBuilderHandler  extends
		IsicresAuditEventAbstractCreacionModificacionCampoRegistroTrazaBuilderHandler {

	@Override
	protected IsicresEventAuditTypeEnum getIsicresEventAuditTypeEnum() {
		return IsicresEventAuditTypeEnum.MODIFICACION_CAMPO_REGISTRO;
	}



}
