package ieci.tecdoc.isicres.rpadmin.struts.acciones.unidades;

import ieci.tecdoc.isicres.rpadmin.struts.acciones.RPAdminWebAction;
import ieci.tecdoc.isicres.rpadmin.struts.forms.UnidadForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import es.ieci.tecdoc.fwktd.core.spring.configuration.jdbc.datasource.MultiEntityContextHolder;
import es.ieci.tecdoc.isicres.admin.beans.Entidad;
import es.ieci.tecdoc.isicres.admin.beans.OrganizacionBean;
import es.ieci.tecdoc.isicres.admin.estructura.adapter.ISicresServicioRPAdminAdapter;
import es.ieci.tecdoc.isicres.admin.service.ISicresServicioRPAdmin;

public class GuardarEdicionUnidadRootAction extends RPAdminWebAction {

	private static final Logger logger = Logger.getLogger(GuardarEdicionUnidadRootAction.class);

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		    ActionForward af = null;

		    try {
		    	ISicresServicioRPAdmin oServicio = new ISicresServicioRPAdminAdapter();

				// Guardamos los datos de la Unidad desde la opci�n de guardar de la
			    // pagina de Edici�n si el idUnidad viene relleno
				String idUnidad = (String)request.getParameter("idUnidad");
				String nodoRaiz = (String)request.getParameter("nodoRaiz");
				if( idUnidad != null && !idUnidad.equals("")) {

					UnidadForm unidadForm = (UnidadForm)form;
					unidadForm.toUpperCase(request);

					OrganizacionBean unidad = new OrganizacionBean();

					BeanUtils.copyProperties(unidad, unidadForm);
					unidad.setId(Integer.parseInt( idUnidad ));
					//Se obtiene la entidad
					Entidad entidad = new Entidad();
					entidad.setIdentificador(MultiEntityContextHolder.getEntity());

					oServicio.editarOrganizacion(unidad, entidad);
					request.setAttribute("nodoRaiz", nodoRaiz);

					ActionMessages messages = new ActionMessages();
					ActionMessage mesage = new ActionMessage("ieci.tecdoc.sgm.rpadmin.unidades.resultado.editadoOK");
					messages.add("Result: ", mesage);
					saveMessages(request, messages);
					af = mapping.findForward("success");
				}

			}
		    catch ( Exception e )
		    {

				logger.error("Error en la aplicacion", e);
				ActionErrors errores = new ActionErrors();
				ActionError error = new ActionError("ieci.tecdoc.sgm.rpadmin.error.mensaje", e.getMessage());
				errores.add("Error interno", error);
				saveErrors(request, errores);
				af = mapping.findForward("error");
			}

			return af;
	}

}
