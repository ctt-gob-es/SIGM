<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-html-el.tld" prefix="html-el" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.Context" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="es" xml:lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta name="author" content="IECISA" />
<title><bean:message key="ieci.tecdoc.sgm.pgadmin.title.aplication"/> - <bean:message key="ieci.tecdoc.sgm.rpadmin.libros.titulo"/></title>
<link href="<%=((Context) new InitialContext().lookup("java:comp/env")).lookup("URLRoot")%>/css/estilos.css" rel="stylesheet" type="text/css" />
<link href="<%=((Context) new InitialContext().lookup("java:comp/env")).lookup("URLRoot")%>/css/adminApp.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=((Context) new InitialContext().lookup("java:comp/env")).lookup("URLRoot")%>/js/common.js"></script>
<script type="text/javascript"><!--
	function asociar(accion, idLibro) {
		var encontrado = false;
		var i = 0;
		while(!encontrado){
			var elemento = document.getElementById("ids" + i);
			if(elemento){
				if(elemento.checked){
					encontrado = true;
					break;
				}
			}
			else
				break;
			i++;
		}

		if(encontrado)
			llamadaAction(accion + '?idLibro=' + idLibro + '&accion=ASOCIAR');
		else
			alert("<bean:message key="ieci.tecdoc.sgm.rpadmin.libros.asociar.oficinas"/>");
	}

	function chequearConsulta(){
		var len = <bean:write name="oficinas" property="size"/>;
		for(var i=0; i<len; i++){
			document.getElementById('consultarCheck_'+ i).checked = true;
			getFirstElementByName('permisos['+ i +'].consultar').value = true;
		}
	}
--></script>
</head>

<body onload="chequearConsulta()">

<html:form action="/asociarOficinas.do">
<div id="contenedora">
  <!-- Inicio Cabecera -->
  <jsp:include page="includes/cabecera.jsp"/>

  <!-- Inicio Contenido -->
  <div id="contenido" >
    <div class="cuerpo">
      <div class="cuerporight">
        <div class="cuerpomid">
	      <jsp:include page="includes/pestanas.jsp">
			<jsp:param name="pestana" value="libros"/>
		  </jsp:include>

          <div class="cuadro">
          	<div id="migas">
				<bean:message key="ieci.tecdoc.sgm.rpadmin.botones.asociar.oficinas"/>
			</div>
			<div class="col">
			<table cellspacing="0" cellpadding="0" border="0">
				<tr>
					<td width="100%" align="left">
						<jsp:include page="includes/errores.jsp"/>
					</td>
					<td align="right" class="col_nuevo" onclick="asociar('<html:rewrite page="/asociarOficinas.do"/>','<bean:write name="libro" property="id"/>')"><bean:message key="ieci.tecdoc.sgm.rpadmin.botones.asociar"/></td>
					<td align="right" class="col_eliminar" onclick="llamadaAction('<html:rewrite page="/editarLibro.do"/>' + '?idLibro=' + '<bean:write name="libro" property="id"/>')"><bean:message key="ieci.tecdoc.sgm.rpadmin.botones.cancelar"/></td>
				</tr>
			</table></div>
			<table cellpadding="0" cellspacing="0" border="0">
				<tr>
					<td height="40">
						<logic:equal name="libro" property="tipo" value="1">
							<font color="#950101" ><b>>> <bean:message key="ieci.tecdoc.sgm.rpadmin.libros.tipo.libro.entrada"/></b>:</font>&nbsp;&nbsp;<bean:write name="libro" property="nombre"/>
						</logic:equal>
						<logic:notEqual name="libro" property="tipo" value="1">
							<font color="#006699" ><b>>> <bean:message key="ieci.tecdoc.sgm.rpadmin.libros.tipo.libro.salida"/></b>:</font>&nbsp;&nbsp;<bean:write name="libro" property="nombre"/>
						</logic:notEqual>
					</td>
				</tr>
			</table>
			<table cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr>
					<td>
						<display:table name="oficinas.lista" uid="fila"
					     requestURI="/asociarOficinas.do" class="tablaListado" sort="page" style="width:100%">
					     	<display:setProperty name="basic.msg.empty_list">
								<bean:message key="ieci.tecdoc.sgm.rpadmin.oficinas.asociar.sin.usuarios"/>
							</display:setProperty>
						 	<display:column style="width:30px" titleKey="ieci.tecdoc.sgm.rpadmin.libros.asociacion.select">
						 		<table cellpadding="0" cellspacing="0" border="0" align="center">
						 			<tr>
						 				<td>
						 					<input type="checkbox" id="ids<c:out value="${fila_rowNum-1}"/>" name="ids[<c:out value="${fila_rowNum-1}"/>]" style="width:20px"
						 					value='<bean:write name="fila" property="id"/>' />
						 				</td>
						 			</tr>
						 		</table>
						 	</display:column>
							<display:column property="codigo" titleKey="ieci.tecdoc.sgm.rpadmin.oficinas.codigo"
								 sortable="false" style="width: 10px;"/>
							<display:column property="nombre" titleKey="ieci.tecdoc.sgm.rpadmin.libros.oficina"
								 sortable="false" style="width: 80%"/>
							<display:column style="width: 7%;" titleKey="ieci.tecdoc.sgm.rpadmin.libros.asociacion.editar.consultar">
								<table cellspacing="0" cellpadding="0" border="0" align="center">
									<tr>
										<td>
											<input type="checkbox" name="consultarCheck_<c:out value="${fila_rowNum-1}"/>" style="width:20px"
												id="consultarCheck_<c:out value="${fila_rowNum-1}"/>"
												onclick="changePermisoConsultar(this)"
											/>
											<html-el:hidden property="permisos[${fila_rowNum-1}].consultar" />
										</td>
									</tr>
								</table>
							</display:column>
							<display:column style="width: 4%;" titleKey="ieci.tecdoc.sgm.rpadmin.libros.asociacion.editar.crear">
								<table cellspacing="0" cellpadding="0" border="0" align="center">
									<tr>
										<td>
											<input type="checkbox" name="crearCheck_<c:out value="${fila_rowNum-1}"/>" style="width:20px"
												id="crearCheck_<c:out value="${fila_rowNum-1}"/>"
												onclick="changePermisoCrear(this)"/>
											<html-el:hidden property="permisos[${fila_rowNum-1}].crear" />
										</td>
									</tr>
								</table>
							</display:column>
							<display:column style="width: 7%;" titleKey="ieci.tecdoc.sgm.rpadmin.libros.asociacion.editar.modificar">
								<table cellspacing="0" cellpadding="0" border="0" align="center">
									<tr>
										<td>
											<input type="checkbox" name="modificarCheck_<c:out value="${fila_rowNum-1}"/>" style="width:20px" id="modificarCheck_<c:out value="${fila_rowNum-1}"/>"
												onclick="changePermisoModificar(this)"/>
											<html-el:hidden property="permisos[${fila_rowNum-1}].modificar" />

											<html-el:hidden property="permisos[${fila_rowNum-1}].id" value="${fila.id}"/>
											<html-el:hidden property="permisos[${fila_rowNum-1}].idBook" value="${libro.id}"/>
											<html-el:hidden property="permisos[${fila_rowNum-1}].nombre" value="${fila.nombre}"/>
											<html-el:hidden property="permisos[${fila_rowNum-1}].numeracion" value="${libro.numeracion}"/>
											<html-el:hidden property="permisos[${fila_rowNum-1}].tipo" value="2"/>
										</td>
									</tr>
								</table>
							</display:column>
						</display:table>
					</td>
				</tr>
			</table>
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
</html:form>
</body>
</html>
