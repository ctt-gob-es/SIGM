package ieci.tecdoc.sgm.autenticacion.action;
/*
 *  $Id: ObtenerTipoAccesoAction.java,v 1.4.2.6 2008/05/08 05:55:06 jnogales Exp $
 */
import ieci.tecdoc.sgm.autenticacion.AutenticacionManager;
import ieci.tecdoc.sgm.autenticacion.form.TipoAccesoForm;
import ieci.tecdoc.sgm.autenticacion.util.TipoAutenticacionCodigos;
import ieci.tecdoc.sgm.autenticacion.utils.Defs;
import ieci.tecdoc.sgm.autenticacion.utils.LectorPropiedades;
import ieci.tecdoc.sgm.base.miscelanea.Goodies;
import ieci.tecdoc.sgm.core.config.ports.PortsConfig;
import ieci.tecdoc.sgm.core.services.dto.Entidad;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ObtenerTipoAccesoAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		
		String	redireccion = (String)request.getSession().getAttribute(Defs.REDIRECCION);
		String tramiteId = (String)request.getSession().getAttribute(Defs.TRAMITE_ID);

		//INICIO [dipucr-Felipe #206 3#108]
		String xmlDataSpecific = (String)session.getAttribute(Defs.DATOS_ESPECIFICOS);
		if (!Defs.isNuloOVacio(xmlDataSpecific)){
			session.setAttribute(Defs.DATOS_ESPECIFICOS, xmlDataSpecific);
		}
		//FIN [dipucr-Felipe #206 3#108]
		
		TipoAccesoForm oform = (TipoAccesoForm)form;
		String entidadId = oform.getEntidadId();
		if(entidadId != null){
			session.setAttribute(Defs.ENTIDAD_ID, entidadId);
		}else if(Defs.isNuloOVacio(request.getSession().getAttribute(Defs.ENTIDAD_ID))) {
			request.setAttribute(Defs.MENSAJE_ERROR, Defs.MENSAJE_ERROR_OBTENER_TIPO_ACCESO);
	    	request.setAttribute(Defs.MENSAJE_ERROR_DETALLE, "No se ha seleccionado la entidad");
	   		return mapping.findForward("failure");			
		}else{
			entidadId = (String)request.getSession().getAttribute(Defs.ENTIDAD_ID);
		}

		Collection tiposAcceso = new ArrayList();
		
		try{
			int tipoAceptado = -1;
			String nombreRegistro = LectorPropiedades.getPropiedad(Defs.CONFIG_NOMBRE_REGISTRO);
			if (nombreRegistro.equals(redireccion)){
				if (Defs.isNuloOVacio(tramiteId)){
			    	request.setAttribute(Defs.MENSAJE_ERROR_DETALLE, "mensaje.acceso.no_tramite");
					return mapping.findForward("none");
				}
				Entidad oEntidad = new Entidad();
				oEntidad.setIdentificador(entidadId);
				tipoAceptado = AutenticacionManager.getAuthenticationType(tramiteId, entidadId);
			} else if (Defs.isNuloOVacio(redireccion)){
				request.setAttribute(Defs.MENSAJE_ERROR_DETALLE, "mensaje.acceso_aplicacion.no_especificado");
				return mapping.findForward("none");
			}else{
				String strTipo = LectorPropiedades.getPropiedad(redireccion + ".acceso");
				if (Defs.isNuloOVacio(strTipo))
					strTipo = "0";
				tipoAceptado = new Integer(strTipo).intValue();//TipoAutenticacionCodigos.WEB_USER_AND_CERTIFICATE;
			}
			
			if (tipoAceptado == TipoAutenticacionCodigos.NONE){
				request.setAttribute(Defs.MENSAJE_ERROR_DETALLE, "mensaje.acceso.ninguno");
				return mapping.findForward("none");
			}else if (tipoAceptado == TipoAutenticacionCodigos.WEB_USER)
				return mapping.findForward("only_login");
			else if (tipoAceptado == TipoAutenticacionCodigos.X509_CERTIFICATE)
				return mapping.findForward("only_cert");
			else if (tipoAceptado == TipoAutenticacionCodigos.WEB_USER_AND_CERTIFICATE){
				
				tiposAcceso.add(new TipoAccesoForm(TipoAutenticacionCodigos.X509_CERTIFICATE, "autenticacion.tipo_certificado"));
				tiposAcceso.add(new TipoAccesoForm(TipoAutenticacionCodigos.WEB_USER, "autenticacion.tipo_login"));
				
			}else if (tipoAceptado == TipoAutenticacionCodigos.SIN_AUTENTICACION){
				//[eCenpri-Manu Ticket #295] +* ALSIGM3 Nuevo proyecto �rbol Documental.
				session.setAttribute(Defs.SESION_ID, Goodies.getUniqueId());
				
				String url = (String)request.getSession().getServletContext().getAttribute("redir" + redireccion);
				String port = PortsConfig.getHttpPort();
				session.setAttribute(Defs.URL_REDIRECCION, url);
				session.setAttribute(Defs.URL_PUERTO, port);
				
				return mapping.findForward("sin_autenticacion");
			//[DipuCR-Agustin] #548 integrar Cl@ve autentificacion
			}else if (tipoAceptado == TipoAutenticacionCodigos.CLAVE){
				
				redireccion = (String)session.getAttribute(Defs.REDIRECCION);
				String url = (String)request.getSession().getServletContext().getAttribute("redir" + redireccion);
				String port = PortsConfig.getCertPort();
				session.setAttribute(Defs.URL_REDIRECCION, url);
				session.setAttribute(Defs.URL_PUERTO, port);
				
				return mapping.findForward("only_clave");
			}
			else if (tipoAceptado == TipoAutenticacionCodigos.CERTIFICATE_AND_CLAVE){
				
				tiposAcceso.add(new TipoAccesoForm(TipoAutenticacionCodigos.X509_CERTIFICATE, "autenticacion.tipo_certificado"));
				tiposAcceso.add(new TipoAccesoForm(TipoAutenticacionCodigos.CLAVE, "autenticacion.tipo_clave"));				
				
			}
			else if (tipoAceptado == TipoAutenticacionCodigos.WEB_USER_AND_CLAVE){
				
				tiposAcceso.add(new TipoAccesoForm(TipoAutenticacionCodigos.WEB_USER, "autenticacion.tipo_login"));
				tiposAcceso.add(new TipoAccesoForm(TipoAutenticacionCodigos.CLAVE, "autenticacion.tipo_clave"));				
				
			}
			else if (tipoAceptado == TipoAutenticacionCodigos.WEB_USER_CERT_AND_CLAVE){
				
				tiposAcceso.add(new TipoAccesoForm(TipoAutenticacionCodigos.WEB_USER, "autenticacion.tipo_login"));
				tiposAcceso.add(new TipoAccesoForm(TipoAutenticacionCodigos.X509_CERTIFICATE, "autenticacion.tipo_certificado"));
				tiposAcceso.add(new TipoAccesoForm(TipoAutenticacionCodigos.CLAVE, "autenticacion.tipo_clave"));			
				
			}
			else{
				
		    	request.setAttribute(Defs.MENSAJE_ERROR, Defs.MENSAJE_ERROR_OBTENER_TIPO_ACCESO);
		    	request.setAttribute(Defs.MENSAJE_ERROR_DETALLE, "Error: Al obtener los tipos de acceso");
				return mapping.findForward("failure");
				
			}
		}catch(Exception e){
	    	request.setAttribute(Defs.MENSAJE_ERROR, Defs.MENSAJE_ERROR_OBTENER_TIPO_ACCESO);
	    	request.setAttribute(Defs.MENSAJE_ERROR_DETALLE, e.toString());
	   		return mapping.findForward("failure");
	   	}
		request.setAttribute(Defs.TIPO_ACCESO, tiposAcceso);
		return mapping.findForward("success");
	}
}
