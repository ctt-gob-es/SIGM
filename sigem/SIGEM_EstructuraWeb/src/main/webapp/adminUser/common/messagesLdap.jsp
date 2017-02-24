<%@ page contentType="text/html;charset=ISO-8859-1" language="java" %>
<%@ taglib uri="/WEB-INF/ieci.tld" prefix="ieci"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.Context" %>
<html>
<head>
<ieci:baseInvesDoc/>
<link rel="stylesheet" type="text/css" href="<%=((Context) new InitialContext().lookup("java:comp/env")).lookup("URLRoot")%>/include/css/adminApp.css"/>
<link rel="stylesheet" type="text/css" href="<%=((Context) new InitialContext().lookup("java:comp/env")).lookup("URLRoot")%>/include/css/estilos.css"/>

</head>

<body>
	<div class="contenedora">
		<table height="60%">
			<tr>
				<td>
					<div class="encabezado1">
						<html:messages id="msg" message="true">
							<bean:write name="msg"/>
						</html:messages>
					</div>
				</td>
			</tr>
		</table>
	</div>
</body>

</html>