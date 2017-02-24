<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.Context" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="es" xml:lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta name="author" content="IECISA" />
<title><bean:message key="ieci.tecdoc.sgm.pgadmin.title.aplication"/> - <bean:message key="ieci.tecdoc.sgm.rpadmin.oficinas.titulo"/></title>
<link href="<%=((Context) new InitialContext().lookup("java:comp/env")).lookup("URLRoot")%>/css/estilos.css" rel="stylesheet" type="text/css" />
<link href="<%=((Context) new InitialContext().lookup("java:comp/env")).lookup("URLRoot")%>/css/adminApp.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=((Context) new InitialContext().lookup("java:comp/env")).lookup("URLRoot")%>/js/common.js"></script>
</head>

<body>
<form name="frmListadoOficinas" action="" method="post">
<div id="contenedora">
  <!-- Inicio Cabecera -->
  <jsp:include page="includes/cabecera.jsp"/>

  <!-- Inicio Contenido -->
  <div id="contenido" >
    <div class="cuerpo">
      <div class="cuerporight">
        <div class="cuerpomid">
	      <jsp:include page="includes/pestanas.jsp">
			<jsp:param name="pestana" value="oficinas"/>
		  </jsp:include>

          <div class="cuadro">
			<div id="migas">
				<bean:message key="ieci.tecdoc.sgm.rpadmin.botones.listado" />
			</div>
			<div class="col" style="height: 30px;">
			<table cellspacing="0" cellpadding="0" border="0">
				<tr>
					<td width="100%" align="left">
						<jsp:include page="includes/errores.jsp"/>
					</td>
					<td align="right" class="col_nuevo" onclick="llamadaAction('<html:rewrite page="/nuevaOficina.do"/>')"><bean:message key="ieci.tecdoc.sgm.rpadmin.botones.nueva"/></td>
				</tr>
			</table></div>
 			<display:table name="oficinas.lista" uid="fila"
				 requestURI="/listadoOficinas.do" class="tablaListado" sort="page" style="width:100%">
					<display:column property="codigo" titleKey="ieci.tecdoc.sgm.rpadmin.oficinas.codigo"
						 sortable="false" style="width: 15%;"/>
					<display:column property="nombre" titleKey="ieci.tecdoc.sgm.rpadmin.oficinas.nombre"
						 sortable="false" style="width: 55%"/>
					<display:column property="abreviatura" titleKey="ieci.tecdoc.sgm.rpadmin.oficinas.abreviatura"
						 sortable="false" style="width: 25%;"/>
					<display:column style="width: 5%;">
						<table><tr>
							<td class="col_usuarios" onclick="llamadaActionUsersOficina('<html:rewrite page="/usuariosOficina.do"/>','<bean:write name="fila" property="id" />')"><bean:message key="ieci.tecdoc.sgm.rpadmin.botones.usuarios"/></td>
						</tr></table>
					</display:column>
					<display:column style="width: 10%;">
						<table><tr>
							<td class="col_editar" onclick="llamadaActionIdOficina('<html:rewrite page="/editarOficina.do"/>','<bean:write name="fila" property="id" />')"><bean:message key="ieci.tecdoc.sgm.rpadmin.botones.propiedadesEditar"/></td>
						</tr></table>
					</display:column>
					<display:column style="width: 5%;">
						<table><tr>
							<c:set var="funcionllamadaAction">
								llamadaActionIdOficinaEliminar("<html:rewrite page='/eliminarOficina.do'/>","<bean:write name='fila' property='id' filter='false'/>","<bean:message key='ieci.tecdoc.sgm.rpadmin.oficinas.eliminar.oficina'/>","<bean:write name='fila' property='nombre' filter='false'/>")
							</c:set>
							<td class="col_eliminar" onclick="<c:out value="${funcionllamadaAction}"/>"><bean:message key="ieci.tecdoc.sgm.rpadmin.botones.eliminar"/></td>
						</tr></table>
					</display:column>
					<table cellpadding="0" cellspacing="0" border="0" width="100%">
						<tr><td height="8" class="col" width="100%"></td></tr>
					</table>
			</display:table>
          </div>

        </div>
      </div>
    </div>
    <div class="cuerpobt">
      <div class="cuerporightbt">
        <div class="cuerpomidbt"></div>
      </div>
    </div>
  </div>
  <!-- Fin Contenido -->
  <div id="pie"></div>
</div>
</form>
</body>
</html>
