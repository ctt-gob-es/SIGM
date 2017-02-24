/*
* Copyright 2014 Ministerio de Industria, Energía y Turismo 
* Licencia con arreglo a la EUPL, Versión 1.1 o –en cuanto sean aprobadas por laComisión Europea– versiones posteriores de la EUPL (la <<Licencia>>); 
* Solo podrá usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislación aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye «TAL CUAL», SIN GARANTÍAS NI CONDICIONES DE NINGÚN TIPO, ni expresas ni implícitas. 
* Véase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

var active = null;
//var activebgcolor = "#639ACE";
//var activetextcolor = "white";
//
//
//var inactivebgcolor = "white";
//var inactivetextcolor = "#639ACE";
//
//var overbgcolor = "#E6E6E6";
//var overtextcolor = "#639ACE";

var tabArray = new Array(6);
tabArray[0] = null;
tabArray[1] = getStyleObj('tab1');
tabArray[2] = getStyleObj('tab2');
tabArray[3] = getStyleObj('tab3');

// Set up array of tabmiddle td element style property strings

var tabTextArray = new Array(6);
tabTextArray[0] = null;
tabTextArray[1] = getStyleObj('tabmiddle1');
tabTextArray[2] = getStyleObj('tabmiddle2');
tabTextArray[3] = getStyleObj('tabmiddle3');

function tabover(tabnum) {
if (tabnum != active) {
 tabcolor(tabnum,overbgcolor,overtextcolor);
  }
}

function tabout(tabnum) {

if (tabnum != active) {
tabcolor(tabnum,inactivebgcolor,inactivetextcolor);
 }
}

function tabcolor(tabnum,color1,color2) {
tab = eval(tabArray[tabnum]);
tabtext = eval(tabTextArray[tabnum]);
tab.backgroundColor = color1;
tabtext.color = color2;

if (document.all) {
 tabtext.cursor = 'hand';
 }
else {
 tabtext.cursor = 'pointer';
 }
}

function choosebox(num, perfiles ) {
if (perfiles == null )
	perfiles = 1;
if (document.all || document.getElementById) {
		if (active) {
			activetablayer = eval(tabArray[active]);
			activetabtext = eval(tabTextArray[active]);
			activetablayer.zIndex = 0;
			tabcolor(active,inactivebgcolor, inactivetextcolor);
	    }

	tablayer = eval(tabArray[num]);
	tabtext = eval(tabTextArray[num]);
	tablayer.zIndex = 11;
	tabcolor(num,activebgcolor, activetextcolor);

	active = num;

  }
} // fin choosebox

function getStyleObj(elem,parent) {
	if (document.layers) {
	    if (parent) {
	     return "document."+parent+".document."+elem;
	      }
	    else {
		return "document."+elem + ".style";
		     }

	  }
	    else if (document.all) {
		return "document.all."+elem + ".style";
	  }
	    else if (document.getElementById) {
		return "document.getElementById('"+elem+"').style";

	}
}