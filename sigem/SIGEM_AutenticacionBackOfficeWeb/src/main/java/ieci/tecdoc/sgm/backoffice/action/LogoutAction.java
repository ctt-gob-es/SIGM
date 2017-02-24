package ieci.tecdoc.sgm.backoffice.action;

import ieci.tecdoc.sgm.backoffice.utils.Utilidades;
import ieci.tecdoc.sgm.core.services.LocalizadorServicios;
import ieci.tecdoc.sgm.core.services.admsesion.backoffice.ServicioAdministracionSesionesBackOffice;
import ieci.tecdoc.sgm.core.services.gestion_backoffice.ConstantesGestionUsuariosBackOffice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LogoutAction extends Action{
	
	private static final Logger logger = Logger.getLogger(LogoutAction.class);
			
	public ActionForward execute(ActionMapping mapping , ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		
		String desconectar = (String)request.getParameter(ConstantesGestionUsuariosBackOffice.PARAMETRO_DESCONECTAR);
		
		try{
			
			
			String idEntidad = (String)request.getParameter(ConstantesGestionUsuariosBackOffice.PARAMETRO_ID_ENTIDAD);
			String idAplicacion = (String)request.getParameter(ConstantesGestionUsuariosBackOffice.PARAMETRO_ID_APLICACION);
			
			if (!Utilidades.isNuloOVacio(desconectar)) {
				HttpSession session = request.getSession();
				
				// SLuna-20081217-I
				
				// Quitamos la 'llave' que introducimos con el usuario
				// codificado, por si se entraba en el m�dulo de Registro
				// Presencial
				if (session.getAttribute("keySesionUsuarioRP") != null) {

					session.removeAttribute("keySesionUsuarioRP");

				}
				
				if(Utilidades.isNuloOVacio(idEntidad))
					session.removeAttribute(ConstantesGestionUsuariosBackOffice.PARAMETRO_ID_ENTIDAD);
				else
					session.setAttribute(ConstantesGestionUsuariosBackOffice.PARAMETRO_ID_ENTIDAD,idEntidad);
				
				if(Utilidades.isNuloOVacio(idAplicacion))
					session.removeAttribute(ConstantesGestionUsuariosBackOffice.PARAMETRO_ID_APLICACION);
				else
					session.setAttribute(ConstantesGestionUsuariosBackOffice.PARAMETRO_ID_APLICACION,idAplicacion);
				
				session.removeAttribute(ConstantesGestionUsuariosBackOffice.PARAMETRO_PASSWORD);
				session.removeAttribute(ConstantesGestionUsuariosBackOffice.PARAMETRO_USUARIO);
				
				session.removeAttribute(ConstantesGestionUsuariosBackOffice.PARAMETRO_KEY_SESION_USUARIO);
					
				
				/*
				 String key = (String)session.getAttribute(ConstantesGestionUsuariosBackOffice.PARAMETRO_KEY_SESION_USUARIO);
				
				if (!Utilidades.isNuloOVacio(key)) {
					ServicioAdministracionSesionesBackOffice oClient = LocalizadorServicios.getServicioAdministracionSesionesBackOffice();
					oClient.caducarSesion(key);
				}*/
			}
		
			
		}catch(Exception e){
			logger.error("Se ha producido un error al deslogar.", e.fillInStackTrace());
			request.setAttribute("error_logout", e.getCause());
			return mapping.findForward("success");
	   	}
		
		if (!Utilidades.isNuloOVacio(desconectar) && desconectar.equalsIgnoreCase("sede"))
			return mapping.findForward("sede");
		else
			return mapping.findForward("success");
	}
}
