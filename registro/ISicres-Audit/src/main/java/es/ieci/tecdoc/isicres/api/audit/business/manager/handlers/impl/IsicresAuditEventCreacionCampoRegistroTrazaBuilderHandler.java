package es.ieci.tecdoc.isicres.api.audit.business.manager.handlers.impl;

import es.ieci.tecdoc.isicres.api.audit.business.vo.enums.IsicresEventAuditTypeEnum;
/**
 * Clase manejadora para la generaci�n de trazas de auditor�a para registra la modificaci�n de un campo de registro
 * @author IECISA
 *
 */
public class IsicresAuditEventCreacionCampoRegistroTrazaBuilderHandler extends
		IsicresAuditEventAbstractCreacionModificacionCampoRegistroTrazaBuilderHandler {

	@Override
	protected IsicresEventAuditTypeEnum getIsicresEventAuditTypeEnum() {
		return IsicresEventAuditTypeEnum.CREACION_CAMPO_REGISTRO;
	}

}
