<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.Context" %>
<%@page import="ieci.tecdoc.sgm.core.web.locale.LocaleFilterHelper"%>
<script>
	function abreAyuda( url ) {
	
		var features = "directories=0,top=50px,left=50px,height=520px,width=930px,location=0,menubar=0";
		features +="resizable=0,scrollbars=0,status=no,titlebar=no,toolbar=no";

		window.open(url, "ventanaAyuda", features);
	}
</script>

<div id="cabecera">
	<div id="logo">
		<img src="<%=((Context) new InitialContext().lookup("java:comp/env")).lookup("URLRoot")%>/img/minetur.jpg" alt="GOBIERNO DE ESPAёA. MINISTERIO DE INDUSTRIA, ENERG͍A Y TURISMO " />
		<img src="<%=((Context) new InitialContext().lookup("java:comp/env")).lookup("URLRoot")%>/img/logo.gif" alt="sigem" />
	</div>
	<div class="salir">
		<img src="<%=((Context) new InitialContext().lookup("java:comp/env")).lookup("URLRoot")%>/img/exit.gif" alt="salir" width="26" height="20" class="icono" />
		<span class="titular"><a href='<html:rewrite page="/logout.do" />'><bean:message key="ieci.tecdoc.sgm.rpadmin.logout"/></a></span>
	</div>
</div>

<div class="usuario">
    <div class="usuarioleft">
    	<p> <bean:message key="ieci.tecdoc.sgm.rpadmin.titulo"/> </p>
    </div>
    <div class="usuarioright">
 		<table>
	   		<tr>
				<td>
				   	<p>	<bean:write name="datosSesion" property="usuario"/>	</p>
				</td>	
				<td>
					<p>
					  <% String ayuda = ((Context) new InitialContext().lookup("java:comp/env")).lookup("URLRoot")+"/ayuda/" + LocaleFilterHelper.getCurrentLocale(request).getLanguage() + "/index.html";%>
				      	<img src="<%=((Context) new InitialContext().lookup("java:comp/env")).lookup("URLRoot")%>/img/help.gif" border="0" alt="sigem" onclick="abreAyuda('<%=ayuda%>')" style="cursor:hand"/>
				     </p>
				</td>
			</tr>
		</table>
    </div>
</div><br>