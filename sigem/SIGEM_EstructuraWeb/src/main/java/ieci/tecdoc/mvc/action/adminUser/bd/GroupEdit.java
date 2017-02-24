/*
 * Created on 22-mar-2005
 *
 */
package ieci.tecdoc.mvc.action.adminUser.bd;

import ieci.tecdoc.core.exception.IeciTdException;
import ieci.tecdoc.idoc.admin.api.ObjFactory;
import ieci.tecdoc.idoc.admin.api.user.Group;
import ieci.tecdoc.idoc.admin.api.user.UserAccess;
import ieci.tecdoc.mvc.action.BaseAction;
import ieci.tecdoc.mvc.dto.common.ListDTO;
import ieci.tecdoc.mvc.error.MvcError;
import ieci.tecdoc.mvc.form.adminUser.bd.BasicForm;
import ieci.tecdoc.mvc.service.adminUser.ServiceCommon;
import ieci.tecdoc.mvc.util.Constantes;
import ieci.tecdoc.mvc.util.SessionHelper;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Antonio Mar�a
 *
 */
public class GroupEdit extends BaseAction{
    int userId;
    
    public ActionForward executeLogic(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception{

    	String entidad=SessionHelper.getEntidad(request);
    	
        BasicForm basicForm = (BasicForm) form;
        if (isCancelled(request))
            return mapping.findForward("cancel");
        
        String submited = request.getParameter("submitted");
        userId = getUserId(request);
        
        String objId = request.getParameter("id");
        int id = Integer.parseInt(objId);
        
        // Recuperar la lista de administradores
        List adminUsers = ServiceCommon.getAdminUsers(id,Constantes.GROUP, entidad);
        ListDTO listDTO = new ListDTO();
        listDTO.setList(adminUsers);
        request.setAttribute("adminUsersDTO", listDTO );
        if (submited == null )
        {
            cargarGrupo(basicForm , id, entidad);
            return mapping.findForward("success");
        }
        else
        {
            UserAccess userAccess = ObjFactory.createUserAccess(); 
        	boolean userCanEditGroup = userAccess.userCanEditGroup(userId, id, entidad);
            if (!userCanEditGroup)
                throw new IeciTdException(String.valueOf(MvcError.EC_NOT_CAN_EDIT_GROUP), null);
            
            guardarDatos(basicForm, entidad);
            request.setAttribute("tipo","Grupo");
            request.setAttribute("id", objId);
            return mapping.findForward("ok");
        }
        
        
    }

    public void guardarDatos(BasicForm form, String entidad ) throws Exception {
        
        Group group = ObjFactory.createGroup(userId);
        int id = form.getId();
        group.load(id, entidad);
        
        group.setName(form.getNombre());
        group.setDescription(form.getDescripcion());
        group.setManagerId(Integer.parseInt(form.getManagerId()));
        
        group.store(entidad);        
    }
    
    public void cargarGrupo(BasicForm form, int id, String entidad) throws Exception
    {
        Group group = ObjFactory.createGroup(userId);
        group.load(id, entidad);
        
        form.setId(id);
        // General
        form.setNombre(group.getName());
        form.setDescripcion(group.getDescription());

        int managerId = group.getManagerId();
        form.setManagerId(String.valueOf(managerId));
    }

}
