<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.Context" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="es" xml:lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta name="author" content="IECISA" />
<title><bean:message key="ieci.tecdoc.sgm.pgadmin.title.aplication"/> - <bean:message key="ieci.tecdoc.sgm.rpadmin.unidades.distribucion.seleccionar.destino"/></title>
<link href="<%=((Context) new InitialContext().lookup("java:comp/env")).lookup("URLRoot")%>/css/estilos.css" rel="stylesheet" type="text/css" />
<link href="<%=((Context) new InitialContext().lookup("java:comp/env")).lookup("URLRoot")%>/css/adminApp.css" rel="stylesheet" type="text/css" />
<script language="Javascript">
	var skipcycle = false;
	var idSelect;
	var idTipo;
	var nombreSel;
	var codigoSel;
	var nodoSeleccionable;

	function init() {
		mytimer = setTimeout('fcsOnMe()', 50);
	}

	function fcsOnMe(){

		if (!skipcycle){
			window.focus();
		}
		mytimer = setTimeout('fcsOnMe()', 50);
	}

	function llamadaActionAceptarPopup() {
		if( idTipo == undefined && idSelect == undefined &&
		    nombreSel == undefined) {
			alert("<bean:message key="ieci.tecdoc.sgm.rpadmin.error.mensaje.required.select.usuario.departamento"/>");
			return;
		} else {

			if ((nodoSeleccionable==null)||(nodoSeleccionable!="1")){
				alert("<bean:message key="ieci.tecdoc.sgm.rpadmin.error.mensaje.select.tipo.grupo.no.valido"/>");
				return;
			}

			window.opener.selectTreeNode(nombreSel, idSelect);
			window.close();

		}
	}

	function detectKey() {
		if(window.event && window.event.keyCode == 116){
			window.event.keyCode = 0;
			return false;
		}
	}


	function clickIE4(){
		if (event.button==2){
			return false;
		}
	}

	function clickNS4(e){
		if (document.layers||document.getElementById&&!document.all){
			if (e.which==2||e.which==3){
				return false;
			}
		}
	}

	if (document.layers){
		document.captureEvents(Event.MOUSEDOWN);
		document.onmousedown=clickNS4;
	}
	else if (document.all && !document.getElementById){
		document.onmousedown=clickIE4;
	}

	document.oncontextmenu=new Function("return false");
	document.onkeydown = detectKey;


	function loadingDept() {
		if( document.getElementById('iframeDept').src != "null") {
			document.getElementById('capaCargandoDept').style.display = "none";
			document.getElementById('capaDept').style.display = "block";
		} else {
			setTimeout("loadingDept()", 100);
		}
	}

	function redirect( url ) {
		window.opener.redirectAnadir(url);
		window.close();
	}

</script>
</head>

<body onload="init();loadingDept();">

<table cellpadding="0" cellspacing="0" border="0" width="360">
<tr>
	<td valign="top">
	  <!-- Inicio Contenido -->
			<table cellspacing="2" cellpadding="2" border="0" width="100%">
				<tr>
					<td width="100%" align="left">
						<jsp:include page="includes/errores.jsp"/>
					</td>
					<td align="right" class="col_guardar" onclick="llamadaActionAceptarPopup()"><bean:message key="ieci.tecdoc.sgm.rpadmin.botones.guardar"/></td>
					<td align="right" class="col_nuevo" onclick="javascript:window.close()"><bean:message key="ieci.tecdoc.sgm.rpadmin.botones.cancelar"/></td>
				</tr>
			</table>
			<table cellspacing="2" cellpadding="2" border="0" width="100%">
				<tr>
					<td valign="top" colspan="5">
						<table cellspacing="0" cellpadding="0" border="0" width="350">
							<tr>
								<td valign="top">
									<table cellpadding="0" cellspacing="0" border="0" width="100%">

										<tr>
											<td class="txt">
												<b><bean:message key="ieci.tecdoc.sgm.rpadmin.unidades.distribucion.grupos"/></b>
											</td>
										</tr>
										<tr>
											<td height="3" class="col">
										</tr>
										<tr>
											<td>
												<div id="capaCargandoDept" style="width:100px; height:100px;display:block">
													<table cellpadding="0" cellspacing="0" border="0" width="350">
														<tr>
															<td><bean:message key="cargando"/></td>
															<td align="center">
																<img src="<%=((Context) new InitialContext().lookup("java:comp/env")).lookup("URLRoot")%>/img/loading.gif" />
															</td>
														</tr>
													</table>
												</div>
											</td>
										</tr>
										<tr>
											<td>
												<div id="capaDept" style="display:none">
													<table cellpadding="0" cellspacing="0" border="0" width="100%">
														<tr>
															<td class="cuadro">
																<iframe src="<html:rewrite page="/ldapUserGroupTree.do"/>" id="iframeDept" frameborder='0' width="400" height="280"></iframe>
															</td>
														</tr>
													</table>
												</div>
											</td>
										</tr>
										<tr>
											<td height="10">
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	</table>
</body>
</html>