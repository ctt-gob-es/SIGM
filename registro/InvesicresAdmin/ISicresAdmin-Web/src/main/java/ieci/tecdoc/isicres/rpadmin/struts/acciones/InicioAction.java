package ieci.tecdoc.isicres.rpadmin.struts.acciones;

import ieci.tecdoc.isicres.rpadmin.struts.util.SesionHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.ieci.tecdoc.fwktd.core.spring.configuration.jdbc.datasource.MultiEntityContextHolder;
import es.ieci.tecdoc.isicres.admin.beans.Entidad;
import es.ieci.tecdoc.isicres.admin.core.manager.DBSessionManager;





/*$Id*/

public class InicioAction extends RPAdminWebAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		//Se obtiene la entidad
		Entidad entidad = new Entidad();
		entidad.setIdentificador(MultiEntityContextHolder.getEntity());

		String sEntidad = entidad.getIdentificador();
		DBSessionManager dBSessionManager = new DBSessionManager();
		String caseSensitive = dBSessionManager.getDBCaseSensitive(sEntidad);

		SesionHelper.guardarCaseSensitive(request, caseSensitive);

		return mapping.findForward("success");
	}

}
