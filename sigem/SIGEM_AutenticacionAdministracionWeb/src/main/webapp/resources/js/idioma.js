
function cambiarIdioma(){
	var frm = document.getElementById('recargarIdioma');
	var selIdioma = document.getElementById('selIdioma');
	var idioma = selIdioma.options[selIdioma.selectedIndex].value;
	frm.src = 'jsp/RecargaIdioma.jsp?idioma=' + idioma;
}