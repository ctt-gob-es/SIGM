package ieci.tdw.ispac.api.rule.procedures.cuenta;

import java.util.Iterator;

import ieci.tdw.ispac.api.IEntitiesAPI;
import ieci.tdw.ispac.api.errors.ISPACRuleException;
import ieci.tdw.ispac.api.item.IItem;
import ieci.tdw.ispac.api.item.IItemCollection;
import ieci.tdw.ispac.api.rule.IRuleContext;

public class InitTaskResolucionFinCuentaRule extends InitTaskResolucionCuentaRule {

    public boolean init(IRuleContext rulectx) throws ISPACRuleException {
        strEntidad = "CUEN_CUENTA";
        strQueryDocumentos = 
            "NOMBRE = 'Providencia' OR " + 
            "NOMBRE = 'Propuesta de aprobaci�n definitiva'"; 
        
        try {
            IEntitiesAPI entitiesAPI = rulectx.getClientContext().getAPI().getEntitiesAPI();
            int pcdId = rulectx.getProcedureId();

            String strQuery = "WHERE ID_PCD="+pcdId+" AND NOMBRE='Cuenta general'";
            IItemCollection col = entitiesAPI.queryEntities("SPAC_P_TRAMITES", strQuery);
            Iterator<?> it = col.iterator();
            
            if (it.hasNext()) {
                IItem tramite = (IItem)it.next();
                int tramCuentaId = tramite.getInt("ID");
            
                strQueryDocumentos += " OR " + "ID_TRAMITE_PCD = " + tramCuentaId;
            }

            strQuery = "WHERE ID_PCD = " + pcdId + " AND NOMBRE = 'Informe de intervenci�n'";
            col = entitiesAPI.queryEntities("SPAC_P_TRAMITES", strQuery);
            it = col.iterator();
            
            if (it.hasNext()) {
                IItem tramite = (IItem)it.next();
                int tramIntervencionId = tramite.getInt("ID");
            
                strQueryDocumentos += " OR " + "ID_TRAMITE_PCD="+tramIntervencionId;
            }

            strQuery = "WHERE ID_PCD = " + pcdId + " AND NOMBRE = 'Alegaciones'";
            col = entitiesAPI.queryEntities("SPAC_P_TRAMITES", strQuery);
            it = col.iterator();
            
            if (it.hasNext()) {
                IItem tramite = (IItem)it.next();
                int tramAlegacionesId = tramite.getInt("ID");
            
                strQueryDocumentos += " OR " + "ID_TRAMITE_PCD = " + tramAlegacionesId;
            }

            strQuery = "WHERE ID_PCD = " + pcdId + " AND NOMBRE = 'Certificaci�n de alegaciones'";
            col = entitiesAPI.queryEntities("SPAC_P_TRAMITES", strQuery);
            it = col.iterator();
            
            if (it.hasNext()) {
                IItem tramite = (IItem)it.next();
                int tramCertificacionId = tramite.getInt("ID");
            
                strQueryDocumentos += " OR " + "ID_TRAMITE_PCD = " + tramCertificacionId;
            }
            
        } catch(ISPACRuleException e) {
            throw new ISPACRuleException(e);

        } catch(Exception e) {
            throw new ISPACRuleException("No se ha podido iniciar el tr�mite de resoluci�n.",e);
        }
        
        return true;
    }
}