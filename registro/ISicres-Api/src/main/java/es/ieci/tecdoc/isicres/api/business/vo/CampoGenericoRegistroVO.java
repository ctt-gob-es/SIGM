package es.ieci.tecdoc.isicres.api.business.vo;

/**
 * @author Iecisa
 * 
 *         Clase que representar� cualquier campo del registro (equivale a campo
 *         de archivador) Los registros tienen campos fijos modelados y campos
 *         adicionales personalizables. Este vo se usar� para representar tanto
 *         unos como otros en un proceso de actualizaci�n de valores de un
 *         registro
 * 
 */
public class CampoGenericoRegistroVO extends BaseCampoRegistroVO {

	private static final long serialVersionUID = -7880479066427054825L;

	public CampoGenericoRegistroVO() {
		super();
	}

	public CampoGenericoRegistroVO(String aName, String aValue) {
		super(aName, aValue);
	}

}
