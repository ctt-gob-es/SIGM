/*
 * Created on 22-mar-2005
 *
 */
package ieci.tecdoc.mvc.action.adminUser.bd;

import ieci.tecdoc.core.exception.IeciTdException;
import ieci.tecdoc.idoc.admin.api.ObjFactory;
import ieci.tecdoc.idoc.admin.api.user.Department;
import ieci.tecdoc.idoc.admin.api.user.UserAccess;
import ieci.tecdoc.idoc.admin.internal.Defs;
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
public class DeptEdit extends BaseAction{

    int userId;
    public ActionForward executeLogic(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception{

    	String entidad=SessionHelper.getEntidad(request);
    	
        BasicForm deptForm = (BasicForm) form;
        String objIdFather = request.getParameter("idPadre"); // Id del departamento padre
        String objId = request.getParameter("id");
        if (isCancelled(request))
            return mapping.findForward("cancel");
        userId = getUserId(request);
        
        int idDept = -1;
        if (objId != null)
            idDept = Integer.parseInt(objId);
        
        
        List adminUsers = ServiceCommon.getAdminUsers(idDept, Constantes.DEPARTAMENT, entidad);
        ListDTO listDTO = new ListDTO();
        listDTO.setList(adminUsers);
        request.setAttribute("adminUsersDTO", listDTO );
        
        String submited = request.getParameter("submitted");
        if (submited == null )
        {
            cargarDepartamento(deptForm, idDept, entidad);
            return mapping.findForward("success");
        }
        else
        {
            UserAccess userAccess = ObjFactory.createUserAccess();
            boolean userCanEditDept = userAccess.userCanEditDept(userId, idDept, entidad);
            if (!userCanEditDept)
                throw new IeciTdException(String.valueOf(MvcError.EC_NOT_CAN_EDIT_DEPT), null);
            guardarDatos(deptForm, entidad);
            request.setAttribute("tipo","Departamento");
            String sUserId=Integer.toString(idDept);
            request.setAttribute("id", sUserId);
            return mapping.findForward("ok");
        }
    }

    public void guardarDatos(BasicForm form, String entidad) throws Exception {
        
        Department dep = ObjFactory.createDepartment(userId,Defs.NULL_ID);
        
        int idDepto = form.getId();
        dep.load(idDepto, entidad);
        
        String idManager = form.getManagerId();
        dep.setManagerId(Integer.parseInt(idManager));
        
        dep.setName(form.getNombre());
        dep.setDescription(form.getDescripcion());
        dep.setIdorg(form.getIdorg());
        dep.setParentId(form.getIdPadre());
        dep.store(entidad);
    }
    
    public void cargarDepartamento(BasicForm deptForm, int id, String entidad) throws Exception
    {
        
        Department dep = ObjFactory.createDepartment(userId,Defs.NULL_ID);
        dep.load(id, entidad);
        
        deptForm.setId(id);
        // General
        deptForm.setNombre(dep.getName());
        deptForm.setIdorg(dep.getIdorg());
        deptForm.setIdPadre(dep.getParentId());
        String description = dep.getDescription();
        if (description != null)
            deptForm.setDescripcion(description);
        int idManager = dep.getManagerId();
        deptForm.setManagerId(String.valueOf(idManager));
    }    

}
