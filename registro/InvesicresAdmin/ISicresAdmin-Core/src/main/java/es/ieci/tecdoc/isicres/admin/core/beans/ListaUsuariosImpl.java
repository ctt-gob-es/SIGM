package es.ieci.tecdoc.isicres.admin.core.beans;

public class ListaUsuariosImpl extends ColeccionGeneralImpl{

	public ListaUsuarioImpl get(int index) {
		return (ListaUsuarioImpl)lista.get(index);
	}

	public void add(ListaUsuarioImpl usuario) {
		lista.add(usuario);
	}
}
