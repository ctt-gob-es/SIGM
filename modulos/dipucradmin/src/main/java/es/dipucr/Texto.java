package es.dipucr;

public class Texto {

	public static String dameContenido(String entidad){
		String cadena = "";
		
		cadena = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>";
		cadena += "\n<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">";
		cadena += "\n<xsl:output encoding=\"ISO-8859-1\" method=\"html\"/>";
		cadena += "\n	<xsl:variable name=\"lang.titulo\" select=\"'SUBSANACI�N DE DEFECTOS Y TRAMITACI�N DE INCIDENTES EN UN EXPEDIENTE INICIADO'\"/>";
		cadena += "\n	";
		cadena += "\n	<xsl:variable name=\"lang.id_nif\" select=\"'Documento de identidad'\"/>";
		cadena += "\n	<xsl:variable name=\"lang.id_nombre\" select=\"'Nombre'\"/>";
		cadena += "\n	";
		cadena += "\n	";
		cadena += "\n	<xsl:variable name=\"lang.datosRepresentante\" select=\"'Datos de la persona f�sica o del representante de la persona jur�dica'\"/>";
		cadena += "\n	<xsl:variable name=\"lang.datosInteresado\" select=\"'Datos del solicitante o del representado'\"/>";
		cadena += "\n	<xsl:variable name=\"lang.datosSolicitud\" select=\"'Datos de la Solicitud'\"/>";
		cadena += "\n	<xsl:variable name=\"lang.datosDeclarativos\" select=\"'Declaraciones Preceptivas que formula el solicitante'\"/>";
		cadena += "\n	";
		cadena += "\n	<xsl:variable name=\"lang.representante\" select=\"'En representaci�n de:'\"/>";
		cadena += "\n	<xsl:variable name=\"lang.cif\" select=\"'CIF'\"/>";
		cadena += "\n";
		cadena += "\n	<xsl:variable name=\"lang.anio\" select=\"'A�o de inicio del expediente:*'\"/>";
		cadena += "\n";
		cadena += "\n	<xsl:variable name=\"lang.selecSol\" select=\"'Seleccione el expediente que desea subsanar, justificar o modificar.'\"/>";
		cadena += "\n	<xsl:variable name=\"lang.asunto\" select=\"'Asunto'\"/>";
		cadena += "\n	<xsl:variable name=\"lang.numexp\" select=\"'N�mero de Registro de Entrada en Diputaci�n de la solicitud'\"/>";
		cadena += "\n	<xsl:variable name=\"lang.expone\" select=\"'Expone'\"/>";
		cadena += "\n	<xsl:variable name=\"lang.solicita\" select=\"'Solicita'\"/>	";
		cadena += "\n";
		cadena += "\n	<xsl:variable name=\"lang.declaro\" select=\"'Asimismo, declaro bajo mi Responsabilidad (obligatorio marcar con una x cada cuadro para poder seguir el tr�mite)'\"/>";
		cadena += "\n	";
		cadena += "\n	<xsl:variable name=\"lang.declaro1\" select=\"'Que la entidad solicitante no se encuentra incursa en ninguna de las circunstancias de prohibici�n para la obtenci�n de la condici�n de beneficiario de ayuda o subvenci�n, as� como que se encuentra al corriente en el cumplimiento de sus obligaciones fiscales con la Diputaci�n Provincial de Ciudad Real.'\"/>";
		cadena += "\n	<xsl:variable name=\"lang.declaro2\" select=\"'Que esta entidad se encuentra al corriente en el cumplimiento de sus obligaciones tributarias y frente a la Seguridad Social, y no es deudora por resoluci�n de procedencia de reintegro de subvenciones.'\"/>";
		cadena += "\n	<xsl:variable name=\"lang.declaro3\" select=\"'Que la persona o entidad solicitante autoriza expresamente a la Diputaci�n de Ciudad Real para consultar las expresadas circunstancias ante las entidades se�aladas.'\"/>	";
		cadena += "\n";
		cadena += "\n	<xsl:variable name=\"lang.anexar\" select=\"'Ficheros que se Anexan'\"/>";
		cadena += "\n	<xsl:variable name=\"lang.anexarInfo1\" select=\"'1.- Debe anexar la documentaci�n en cada caso seg�n lo dispuesto en la convocatoria.'\"/>";
		cadena += "\n	<xsl:variable name=\"lang.anexarInfo2\" select=\"'2.-  Para adjuntar los ficheros, pulse el bot�n examinar. Seleccione el fichero que desee anexar a la solicitud. Recuerde que debe anexar copia de la Memoria o proyecto al que se refiere la presente solicitud y de cualquier otro que considere conveniente. Si el documento est� en soporte papel, debe escanearlo con car�cter previo.'\"/>";
		cadena += "\n	<xsl:variable name=\"lang.documentoTipo\" select=\"'Archivo ZIP'\"/>";
		cadena += "\n	<xsl:variable name=\"lang.documentoTipo_DOC_ODT\" select=\"'Archivo ODT/DOC'\"/>";
		cadena += "\n	<xsl:variable name=\"lang.documentoTipoPDF\" select=\"'Archivo PDF'\"/>";
		cadena += "\n	<xsl:variable name=\"lang.documentoTipoJPEG\" select=\"'Archivo JPG'\"/>";
		cadena += "\n	";
		cadena += "\n	<xsl:variable name=\"lang.mensajePopUps\" select=\"'Si est� viendo este mensaje debe &lt;b&gt;deshabilitar&lt;/b&gt; el bloqueador de elementos emergentes de su navegador para &lt;b&gt;permitir los PopUps en Diputaci�n de Ciudad Real&lt;/b&gt;.'\"/>";
		cadena += "\n	<xsl:variable name=\"lang.mensajeAlert\" select=\"'Debe deshabilitar el bloqueador de elementos emergentes de su navegador para permitir los PopUps en Diputaci�n de Ciudad Real y poder comprobar sus representados antes de continuar.'\"/>";
		cadena += "\n		";
		cadena += "\n	<xsl:template match=\"/\"  xmlns:java=\"http://xml.apache.org/xslt/java\">";
		cadena += "\n		<script language=\"Javascript\">";
		cadena += "\n			//array de campos obligatorios -> ('id_campo','nombre_campo')";
		cadena += "\n			//----------------------------";
		cadena += "\n			var validar = new Array(4);";
		cadena += "\n			";
		cadena += "\n			validar[0] = new Array('documentoIdentidad', '<xsl:value-of select=\"$lang.id_nif\"/>');";
		cadena += "\n			validar[1] = new Array('nombreSolicitante','<xsl:value-of select=\"$lang.id_nombre\"/>');				";
		cadena += "\n			validar[2] = new Array('expone','<xsl:value-of select=\"$lang.expone\"/>');";
		cadena += "\n			validar[3] = new Array('solicita','<xsl:value-of select=\"$lang.solicita\"/>');";
		cadena += "\n";
		cadena += "\n";
		cadena += "\n			//Array con los datos especificos del formilario -> -> ('id_campo','tag_xml')";
		cadena += "\n			//----------------------------------------------";
		cadena += "\n			var especificos = new Array(8);";
		cadena += "\n			";
		cadena += "\n			especificos[0] = new Array('ayuntamiento','ayuntamiento');			";
		cadena += "\n			especificos[1] = new Array('asunto','asunto');";
		cadena += "\n			especificos[2] = new Array('numExpediente','numExpediente');						";
		cadena += "\n			especificos[3] = new Array('documentoIdentidad','documentoIdentidad');";
		cadena += "\n			especificos[4] = new Array('nombreSolicitante','nombreSolicitante');				";
		cadena += "\n			especificos[5] = new Array('expone','expone');";
		cadena += "\n			especificos[6] = new Array('solicita','solicita');			";
		cadena += "\n			especificos[7] = new Array('emailSolicitante','emailSolicitante');";
		cadena += "\n			";
		cadena += "\n			";
		cadena += "\n			";
		cadena += "\n			//Array de validaciones";
		cadena += "\n			//----------------------------------------------";
		cadena += "\n			var validarNumero;";
		cadena += "\n			function verificacionesEspecificas() {";
		cadena += "\n				if(document.getElementById('asociaciones_div').style.display == ''){";
		cadena += "\n					alert('<xsl:value-of select=\"$lang.mensajeAlert\"/>');";
		cadena += "\n					return false;";
		cadena += "\n				}";
		cadena += "\n				if(document.getElementById('numExpediente').value == ''){";
		cadena += "\n					alert('Debe seleccionar el expediente que va a subsanar, justificar o modificar');";
		cadena += "\n					document.getElementById('expedientes').focus();";
		cadena += "\n					return false;";
		cadena += "\n				}";
		cadena += "\n				if(document.getElementById('numExpediente').value == '-------'){";
		cadena += "\n					alert('Debe seleccionar el expediente que va a subsanar, justificar o modificar');";
		cadena += "\n					document.getElementById('expedientes').focus();";
		cadena += "\n					return false;";
		cadena += "\n				}";
		cadena += "\n				";
		cadena += "\n				return true;";
		cadena += "\n			}";
		cadena += "\n			function getDatosObligado(nif){";
		cadena += "\n				window.open('tramites/" + entidad + "/SUBSANACION_JUST_REPRESENT/buscaObligado.jsp?valor='+nif+';" + entidad + "','','width=3,height=3');";
		cadena += "\n			}";
		cadena += "\n			";
		cadena += "\n			function abrirDocumento(){ ";
		cadena += "\n				v=window.open(\"documentos/MODELO.odt\"); ";
		cadena += "\n			} ";
		cadena += "\n			function getDatosRepre(cifRepre){";
		cadena += "\n				document.getElementById('anio').value='----';";
		cadena += "\n				document.getElementById('expedientes').value='-------';";
		cadena += "\n				document.getElementById('cif').value = cifRepre;";
		cadena += "\n			}";
		cadena += "\n			";
		cadena += "\n			function getAsuntoNumexp(numExpediente){";
		cadena += "\n				window.open('tramites/" + entidad + "/SUBSANACION_JUST_REPRESENT/buscaAsuntoNumExp.jsp?valor='+numExpediente+';" + entidad + "','','width=700,height=300,resizable=1');";
		cadena += "\n			}";
		cadena += "\n			function getDatosObligadoEntidad(nif){";
		cadena += "\n				window.open('tramites/" + entidad + "/SUBSANACION_JUST_REPRESENT/buscaObligadoEntidad.jsp?valor='+nif+';" + entidad + "','','width=3,height=3');";
		cadena += "\n			}";
		cadena += "\n			function getDatos(anio){";
		cadena += "\n				var dni = document.getElementById('cif').value;";
		cadena += "\n				if(dni==\"-------\" || dni==\"\"){<!-- Compruebo que el cif no sea vacio -->";
		cadena += "\n					dni = document.getElementById('documentoIdentidad').value;";
		cadena += "\n				}";
		cadena += "\n				window.open('tramites/" + entidad + "/SUBSANACION_JUST_REPRESENT/dameExpedientes.jsp?valor='+dni+';'+anio.value+';" + entidad + "','','width=3,height=3,left=10000,top=10000');";
		cadena += "\n			}";
		cadena += "\n			";
		cadena += "\n			function getRepresentados(){";
		cadena += "\n				window.open('tramites/" + entidad + "/SUBSANACION_JUST_REPRESENT/dameRepresentantes.jsp?valor='+document.getElementById('documentoIdentidad').value+';" + entidad + "','','width=3,height=3,left=10000,top=10000');";
		cadena += "\n			}";
		cadena += "\n";
		cadena += "\n";
		cadena += "\n		</script>";
		cadena += "\n		<h1><xsl:value-of select=\"$lang.titulo\"/></h1>";
		cadena += "\n   		<br/>";
		cadena += "\n   		";
		cadena += "\n   		<div class=\"cuadro\" style=\"\">	";
		cadena += "\n			<div class=\"col\">";
		cadena += "\n				<label class=\"gr\">";
		cadena += "\n					<xsl:attribute name=\"style\">width:150px;</xsl:attribute>";
		cadena += "\n					<xsl:value-of select=\"$lang.id_nif\"/>:";
		cadena += "\n				</label>";
		cadena += "\n				<input type=\"text\">";
		cadena += "\n					<xsl:attribute name=\"style\">width:490px;</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"name\">documentoIdentidad</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"id\">documentoIdentidad</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"value\"><xsl:value-of select=\"Datos_Registro/Remitente/Documento_Identificacion/Numero\"/></xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"disabled\"></xsl:attribute>";
		cadena += "\n				</input>";
		cadena += "\n			</div>";
		cadena += "\n			<div class=\"col\">";
		cadena += "\n				<label class=\"gr\">";
		cadena += "\n					<xsl:attribute name=\"style\">width:150px;</xsl:attribute>";
		cadena += "\n					<xsl:value-of select=\"$lang.id_nombre\"/>:";
		cadena += "\n				</label>";
		cadena += "\n				<input type=\"text\">";
		cadena += "\n					<xsl:attribute name=\"style\">width:490px; </xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"name\">nombreSolicitante</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"id\">nombreSolicitante</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"value\"><xsl:value-of select=\"Datos_Registro/Remitente/Nombre\"/></xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"disabled\"></xsl:attribute>";
		cadena += "\n				</input>";
		cadena += "\n			</div>";
		cadena += "\n				";
		cadena += "\n		</div>";
		cadena += "\n   		";
		cadena += "\n   		<div class=\"submenu\">";
		cadena += "\n   			<h1><xsl:value-of select=\"$lang.datosInteresado\"/></h1>";
		cadena += "\n   		</div>";
		cadena += "\n   		";
		cadena += "\n   		<div class=\"cuadro\" style=\"\">	";
		cadena += "\n   		";
		cadena += "\n			<div id=\"asociaciones_div\" class=\"col\">";
		cadena += "\n				<img>";
		cadena += "\n					<xsl:attribute name=\"src\">img/close.png</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"id\">aviso_img</xsl:attribute>";
		cadena += "\n				</img>";
		cadena += "\n				<label>					";
		cadena += "\n					<xsl:attribute name=\"style\">color:#006699; width:100%; line-height:15px; padding-left:20px;</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"name\">asociaciones_lbl</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"id\">asociaciones_lbl</xsl:attribute>";
		cadena += "\n				</label>					";
		cadena += "\n			</div>";
		cadena += "\n			<div id=\"ayuntamiento_div\" class=\"col\" style=\"display:none\">";
		cadena += "\n				<label class=\"gr\">";
		cadena += "\n					<xsl:attribute name=\"style\">position: relative; width:150px;</xsl:attribute>";
		cadena += "\n					<xsl:value-of select=\"$lang.representante\"/>*";
		cadena += "\n				</label>";
		cadena += "\n				<select onchange=\"getDatosRepre(this.value)\">";
		cadena += "\n					<xsl:attribute name=\"style\">width:400px;color:#006699;</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"name\">ayuntamiento</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"id\">ayuntamiento</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"value\"><xsl:value-of select=\"Datos_Registro/datos_especificos/ayuntamiento\"/></xsl:attribute>";
		cadena += "\n					<option>";
		cadena += "\n						<xsl:attribute name=\"value\">-------</xsl:attribute>----------------------------------------------------";
		cadena += "\n					</option>";
		cadena += "\n				</select>					";
		cadena += "\n			</div>	    ";
		cadena += "\n			<div id=\"remitente_div\" class=\"col\" style=\"display:none\">";
		cadena += "\n				<label class=\"gr\">";
		cadena += "\n					<xsl:attribute name=\"style\">position: relative; width:150px;</xsl:attribute>";
		cadena += "\n					<xsl:value-of select=\"$lang.cif\"/>:*";
		cadena += "\n				</label>";
		cadena += "\n				<input type=\"text\">";
		cadena += "\n					<xsl:attribute name=\"style\">position: relative; width:490px; </xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"name\">cif</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"id\">cif</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"value\"><xsl:value-of select=\"Datos_Registro/Remitente/cif\"/></xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"disabled\"></xsl:attribute>";
		cadena += "\n				</input>";
		cadena += "\n			</div>";
		cadena += "\n			";
		cadena += "\n		</div>";
		cadena += "\n		<br/>";
		cadena += "\n   		<div class=\"submenu\">";
		cadena += "\n   			<h1><xsl:value-of select=\"$lang.datosSolicitud\"/></h1>";
		cadena += "\n   		</div>";
		cadena += "\n		<div class=\"cuadro\" style=\"\">";
		cadena += "\n			<div class=\"col\">";
		cadena += "\n				<label class=\"gr\">";
		cadena += "\n					<xsl:attribute name=\"style\">width:150px;</xsl:attribute>";
		cadena += "\n					<xsl:value-of select=\"$lang.anio\"/>:";
		cadena += "\n				</label>";
		cadena += "\n				<select>";
		cadena += "\n					<xsl:attribute name=\"style\">color:#006699;</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"name\">anio</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"id\">anio</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"value\"><xsl:value-of select=\"Datos_Registro/datos_especificos/anio\"/></xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"onchange\">getDatos(anio)</xsl:attribute>";
		cadena += "\n					<options>";
		cadena += "\n						<option value='----'>----</option>";
		cadena += "\n					</options>";
		cadena += "\n				</select>";
		cadena += "\n				<script>";
		cadena += "\n					var anio = 2009;";
		cadena += "\n					var f = new Date();";
		cadena += "\n					var anioAc = f.getFullYear();";
		cadena += "\n					for (var i=1; (anio+i)&lt;=anioAc; i++){";
		cadena += "\n						document.getElementById('anio').options[i] = new Option (anio+i,anio+i);";
		cadena += "\n					}";
		cadena += "\n				</script>";
		cadena += "\n				<br/>	";
		cadena += "\n			</div>	";
		cadena += "\n";
		cadena += "\n	<!-- MQE Cargamos los expedientes sobre los que puede subsanar-->	";
		cadena += "\n			<div class=\"col\">";
		cadena += "\n				<label class=\"gr\">";
		cadena += "\n					<xsl:attribute name=\"style\">position: relative; width:100%;</xsl:attribute>";
		cadena += "\n					<xsl:value-of select=\"$lang.selecSol\"/>:";
		cadena += "\n				</label>";
		cadena += "\n			</div>";
		cadena += "\n	";
		cadena += "\n			<select class=\"gr\">";
		cadena += "\n				<xsl:attribute name=\"style\">border:none; width:650px;color:#006699;</xsl:attribute>";
		cadena += "\n				<xsl:attribute name=\"name\">expedientes</xsl:attribute>";
		cadena += "\n				<xsl:attribute name=\"id\">expedientes</xsl:attribute>";
		cadena += "\n				<xsl:attribute name=\"onblur\"> document.getElementById('asunto').value = this.options[this.selectedIndex].text; document.getElementById('numExpediente').value = this.value;</xsl:attribute>";
		cadena += "\n					<option>";
		cadena += "\n						<xsl:attribute name=\"value\">-------</xsl:attribute>----------------------------------------------------";
		cadena += "\n					</option>";
		cadena += "\n			</select>";
		cadena += "\n		</div>  ";
		cadena += "\n	<!-- MQE fin modificaciones -->";
		cadena += "\n";
		cadena += "\n";
		cadena += "\n   		<div class=\"cuadro\" style=\"\">";
		cadena += "\n			<div class=\"col\" style=\"display:none;\">";
		cadena += "\n				<label class=\"gr\">";
		cadena += "\n					<xsl:attribute name=\"style\">position: relative; width:150px;</xsl:attribute>";
		cadena += "\n					<xsl:value-of select=\"$lang.numexp\"/>:*";
		cadena += "\n				</label>";
		cadena += "\n				<input type=\"text\">";
		cadena += "\n					<xsl:attribute name=\"style\">position: relative; width:200px;</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"name\">numExpediente</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"id\">numExpediente</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"value\"><xsl:value-of select=\"Datos_Registro/datos_especificos/numExpediente\"/></xsl:attribute>";
		cadena += "\n				</input>";
		cadena += "\n				<img onclick=\"getAsuntoNumexp(document.getElementById('numExpediente').value);\" src=\"img/search-mg.gif\"/>";
		cadena += "\n			</div>";
		cadena += "\n";
		cadena += "\n			<br/>";
		cadena += "\n	";
		cadena += "\n   			<div class=\"col\" style=\"display:none;\">";
		cadena += "\n				<label class=\"gr\">";
		cadena += "\n					<xsl:attribute name=\"style\">position: relative; width:150px;</xsl:attribute>";
		cadena += "\n					<xsl:value-of select=\"$lang.asunto\"/>:*";
		cadena += "\n				</label>";
		cadena += "\n				<input type=\"text\">";
		cadena += "\n					<xsl:attribute name=\"style\">position: relative; width:500px; </xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"name\">asunto</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"id\">asunto</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"value\"><xsl:value-of select=\"Datos_Registro/datos_especificos/asunto\"/></xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"disabled\"></xsl:attribute>";
		cadena += "\n				</input>";
		cadena += "\n			</div>";
		cadena += "\n			";
		cadena += "\n			<div class=\"col\">";
		cadena += "\n				<label class=\"gr\">";
		cadena += "\n					<xsl:attribute name=\"style\">position: relative; width:150px;</xsl:attribute>";
		cadena += "\n					<xsl:value-of select=\"$lang.expone\"/>:*";
		cadena += "\n				</label>";
		cadena += "\n				<textarea type=\"gr\">";
		cadena += "\n					<xsl:attribute name=\"style\">position: relative; width:490px; font:normal 100%/normal 'Arial', Tahoma, Helvetica, sans-serif;</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"name\">expone</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"id\">expone</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"rows\">7</xsl:attribute>";
		cadena += "\n					<xsl:value-of select=\"Datos_Registro/datos_especificos/expone\"/>";
		cadena += "\n				</textarea>";
		cadena += "\n			</div>";
		cadena += "\n			<div class=\"col\">";
		cadena += "\n				<label class=\"gr\">";
		cadena += "\n					<xsl:attribute name=\"style\">position: relative; width:150px;</xsl:attribute>";
		cadena += "\n					<xsl:value-of select=\"$lang.solicita\"/>:*	";
		cadena += "\n				</label>";
		cadena += "\n				<textarea class=\"gr\">";
		cadena += "\n					<xsl:attribute name=\"style\">position: relative; width:490px; font:normal 100%/normal 'Arial', Tahoma, Helvetica, sans-serif;</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"name\">solicita</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"id\">solicita</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"rows\">7</xsl:attribute>";
		cadena += "\n					<xsl:value-of select=\"Datos_Registro/datos_especificos/solicita\"/>";
		cadena += "\n				</textarea>";
		cadena += "\n			</div>	";
		cadena += "\n			";
		cadena += "\n			<br/>";
		cadena += "\n";
		cadena += "\n			</div>";
		cadena += "\n			<div class=\"submenu\">";
		cadena += "\n   				<h1><xsl:value-of select=\"$lang.datosDeclarativos\"/></h1>";
		cadena += "\n   			</div>";
		cadena += "\n   			<div class=\"cuadro\" style=\"\">	";
		cadena += "\n				<input type=\"checkbox\" id=\"declaro1\" checked=\"Yes\" style=\"border:none;color:#006699;position: relative; width:20px;\" DISABLED=\"Yes\"/>";
		cadena += "\n				<xsl:value-of select=\"$lang.declaro1\"/>";
		cadena += "\n				";
		cadena += "\n				<br/>";
		cadena += "\n				";
		cadena += "\n				<input type=\"checkbox\" id=\"declaro2\" checked=\"Yes\" style=\"border:none;color:#006699;position: relative; width:20px;\" DISABLED=\"Yes\"/>";
		cadena += "\n				<xsl:value-of select=\"$lang.declaro2\"/>";
		cadena += "\n				<br/>";
		cadena += "\n				";
		cadena += "\n				<input type=\"checkbox\" id=\"declaro3\" checked=\"Yes\" style=\"border:none;color:#006699;position: relative; width:20px;\" DISABLED=\"Yes\"/>";
		cadena += "\n				<xsl:value-of select=\"$lang.declaro3\"/>";
		cadena += "\n				<br/>";
		cadena += "\n			</div>";
		cadena += "\n		";
		cadena += "\n   			<br/>";
		cadena += "\n			<div class=\"submenu\">";
		cadena += "\n   			<h1><xsl:value-of select=\"$lang.anexar\"/></h1>";
		cadena += "\n   			</div>";
		cadena += "\n   			<div class=\"cuadro\" style=\"\">";
		cadena += "\n				<label class=\"gr\">";
		cadena += "\n			   		<xsl:attribute name=\"style\">position: relative; width:650px;</xsl:attribute>";
		cadena += "\n		   			<xsl:value-of select=\"$lang.anexarInfo1\"/>";
		cadena += "\n		   			<!-- <a style=\"text-decoration:underline; color:red\" href=\"javascript:abrirDocumento();\">Modelo orientativo de acuerdo</a><br/>  -->";
		cadena += "\n		   			<br/>";
		cadena += "\n		   			<xsl:value-of select=\"$lang.anexarInfo2\"/><br/>";
		cadena += "\n				</label>";
		cadena += "\n			<br/><br/>";
		cadena += "\n			";
		cadena += "\n			<div class=\"col\">";
		cadena += "\n				<label class=\"gr\">";
		cadena += "\n					<xsl:attribute name=\"style\">position: relative; width:200px; text-indent:40px</xsl:attribute>";
		cadena += "\n					<b><xsl:value-of select=\"$lang.documentoTipo\"/>:<font color=\"#950000\"></font></b>";
		cadena += "\n				</label>";
		cadena += "\n				<input type=\"file\">";
		cadena += "\n					<xsl:attribute name=\"style\">position: relative; width:400px; size:400px;</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"name\">CR_SUBJUSREPRE_D1</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"id\">CR_SUBJUSREPRE_D1</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"value\"></xsl:attribute>";
		cadena += "\n				</input>";
		cadena += "\n				<input type=\"hidden\">";
		cadena += "\n					<xsl:attribute name=\"name\">CR_SUBJUSREPRE_D1_Tipo</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"id\">CR_SUBJUSREPRE_D1_Tipo</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"value\">zip,rar</xsl:attribute>";
		cadena += "\n				</input>";
		cadena += "\n				";
		cadena += "\n				<label class=\"gr\">";
		cadena += "\n					<xsl:attribute name=\"style\">position: relative; width:200px; text-indent:40px</xsl:attribute>";
		cadena += "\n					<b><xsl:value-of select=\"$lang.documentoTipo_DOC_ODT\"/>:<font color=\"#950000\"></font></b>";
		cadena += "\n				</label>";
		cadena += "\n				<input type=\"file\">";
		cadena += "\n					<xsl:attribute name=\"style\">position: relative; width:400px; size:400px;</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"name\">CR_SUBJUSREPRE_D2</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"id\">CR_SUBJUSREPRE_D2</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"value\"></xsl:attribute>";
		cadena += "\n				</input>";
		cadena += "\n				<input type=\"hidden\">";
		cadena += "\n					<xsl:attribute name=\"name\">CR_SUBJUSREPRE_D2_Tipo</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"id\">CR_SUBJUSREPRE_D2_Tipo</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"value\">odt,doc</xsl:attribute>";
		cadena += "\n				</input>";
		cadena += "\n				<label class=\"gr\">";
		cadena += "\n					<xsl:attribute name=\"style\">position: relative; width:200px; text-indent:40px</xsl:attribute>";
		cadena += "\n					<b><xsl:value-of select=\"$lang.documentoTipoPDF\"/>:<font color=\"#950000\"></font></b>";
		cadena += "\n				</label>";
		cadena += "\n				<input type=\"file\">";
		cadena += "\n					<xsl:attribute name=\"style\">position: relative; width:400px; size:400px;</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"name\">CR_SUBJUSREPRE_D3</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"id\">CR_SUBJUSREPRE_D3</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"value\"></xsl:attribute>";
		cadena += "\n				</input>";
		cadena += "\n				<input type=\"hidden\">";
		cadena += "\n					<xsl:attribute name=\"name\">CR_SUBJUSREPRE_D3_Tipo</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"id\">CR_SUBJUSREPRE_D3_Tipo</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"value\">PDF</xsl:attribute>";
		cadena += "\n				</input>";
		cadena += "\n				<label class=\"gr\">";
		cadena += "\n					<xsl:attribute name=\"style\">position: relative; width:200px; text-indent:40px</xsl:attribute>";
		cadena += "\n					<b><xsl:value-of select=\"$lang.documentoTipoJPEG\"/>:<font color=\"#950000\"></font></b>";
		cadena += "\n				</label>";
		cadena += "\n				<input type=\"file\">";
		cadena += "\n					<xsl:attribute name=\"style\">position: relative; width:400px; size:400px;</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"name\">CR_SUBJUSREPRE_D4</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"id\">CR_SUBJUSREPRE_D4</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"value\"></xsl:attribute>";
		cadena += "\n				</input>";
		cadena += "\n				<input type=\"hidden\">";
		cadena += "\n					<xsl:attribute name=\"name\">CR_SUBJUSREPRE_D4_Tipo</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"id\">CR_SUBJUSREPRE_D4_Tipo</xsl:attribute>";
		cadena += "\n					<xsl:attribute name=\"value\">JPG</xsl:attribute>";
		cadena += "\n				</input>";
		cadena += "\n			</div>";
		cadena += "\n			<br/>";
		cadena += "\n			<div style=\"color: grey; text-align:justify\">";
		cadena += "\n				<label class=\"gr\">";
		cadena += "\n					<xsl:attribute name=\"style\">position: relative; width:650px;</xsl:attribute>";
		cadena += "\n					Los datos personales, identificativos y de contacto, aportados mediante esta comunicaci�n se entienden facilitados voluntariamente, y ser�n incorporados a un fichero cuya finalidad es la de mantener con Vd. relaciones dentro del �mbito de las competencias de esta Administraci�n P�blica as� como informarle de nuestros servicios presentes y futuros ya sea por correo ordinario o por medios telem�ticos y enviarle invitaciones para eventos y felicitaciones en fechas se�aladas. Entenderemos que presta su consentimiento t�cito para este tratamiento de datos si en el plazo de un mes no expresa su voluntad en contra. Podr� ejercer sus derechos de acceso, rectificaci�n, cancelaci�n y oposici�n ante el Responsable del Fichero, la Diputaci�n Provincial de Ciudad Real en C/ Toledo, 17, 13071 Ciudad Real - Espa�a, siempre acreditando conforme a Derecho su identidad en la comunicaci�n. En cumplimiento de la L.O. 34/2002 le informamos de que puede revocar en cualquier momento el consentimiento que nos otorga dirigi�ndose a la direcci�n citada ut supra o bien al correo electr�nico lopd@dipucr.es o bien por telefono al numero gratuito 900 714 080.	";
		cadena += "\n				</label>";
		cadena += "\n			</div>";
		cadena += "\n   		</div>";
		cadena += "\n   		<br/>";
		cadena += "\n   		<input type=\"hidden\">";
		cadena += "\n			<xsl:attribute name=\"name\">datosEspecificos</xsl:attribute>";
		cadena += "\n			<xsl:attribute name=\"id\">datosEspecificos</xsl:attribute>";
		cadena += "\n			<xsl:attribute name=\"value\"></xsl:attribute>";
		cadena += "\n		</input>";
		cadena += "\n		<input type=\"hidden\">";
		cadena += "\n			<xsl:attribute name=\"name\">emailSolicitante</xsl:attribute>";
		cadena += "\n			<xsl:attribute name=\"id\">emailSolicitante</xsl:attribute>";
		cadena += "\n			<xsl:attribute name=\"value\"></xsl:attribute>";
		cadena += "\n		</input>";
		cadena += "\n		<script language=\"Javascript\">";
		cadena += "\n			document.getElementById('asociaciones_lbl').innerHTML = '<xsl:value-of select=\"$lang.mensajePopUps\"/>';";
		cadena += "\n			getRepresentados();";
		cadena += "\n		</script>";
		cadena += "\n	</xsl:template>";
		cadena += "\n</xsl:stylesheet>";

		return cadena;
	}
}
