package ieci.tecdoc.sgm.rpadmin.beans;


public class SicresOrganizacionesImpl  extends ColeccionGeneralImpl{

	public SicresOrganizacionImpl get(int index) {
		return (SicresOrganizacionImpl)lista.get(index);
	}

	public void add(SicresOrganizacionImpl organizacion) {
		lista.add(organizacion);
	}
}
