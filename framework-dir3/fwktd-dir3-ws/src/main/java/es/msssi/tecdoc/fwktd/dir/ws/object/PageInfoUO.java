package es.msssi.tecdoc.fwktd.dir.ws.object;

import java.io.Serializable;
/**
 * Datos de paginaci�n de la b�squeda de UO.
 *
 * @author cmorenog
 *
 */
public class PageInfoUO implements Serializable{
	
	private static final long serialVersionUID = 3453986001873009595L;

	private static final int DEFAULT_PAGE_NUMBER = 0;
	private static final int DEFAULT_OBJECTS_PER_PAGE = 0;
	private static final int DEFAULT_MAX_NUM_ITEMS = 0;

	/**
	 * N�mero de p�gina.
	 */
	private int pageNumber = DEFAULT_PAGE_NUMBER;

	/**
	 * N�mero de registros por p�gina.
	 */
	private int objectsPerPage = DEFAULT_OBJECTS_PER_PAGE;

	/**
	 * N�mero m�ximo de resultados.
	 */
	private int maxNumItems = DEFAULT_MAX_NUM_ITEMS;

	/**
	 * Constructor.
	 */
	public PageInfoUO() {
		super();
	}

	/**
	 * Constructor.
	 * @param maxNumItems N�mero m�ximo de resultados.
	 */
	public PageInfoUO(int maxNumItems) {
		super();
		setMaxNumItems(maxNumItems);
	}

	/**
	 * Constructor.
	 * @param pageNumber N�mero de p�gina.
	 * @param objectsPerPage N�mero de registros por p�gina.
	 * @param maxNumItems N�mero m�ximo de resultados.
	 */
	public PageInfoUO(int pageNumber, int objectsPerPage) {
		super();
		setPageNumber(pageNumber);
		setObjectsPerPage(objectsPerPage);
	}
	/**
	 * Obtiene el valor del par�metro pageNumber.
	 * 
	 * @return pageNumber valor del campo a obtener.
	 *
	 */
	public int getPageNumber() {
		return pageNumber;
	}
	/**
	 * Guarda el valor del par�metro pageNumber.
	 * 
	 * @param pageNumber
	 *            valor del campo a guardar.
	 */
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	/**
	 * Obtiene el valor del par�metro objectsPerPage.
	 * 
	 * @return objectsPerPage valor del campo a obtener.
	 *
	 */
	public int getObjectsPerPage() {
		return objectsPerPage;
	}
	/**
	 * Guarda el valor del par�metro objectsPerPage.
	 * 
	 * @param objectsPerPage
	 *            valor del campo a guardar.
	 */
	public void setObjectsPerPage(int objectsPerPage) {
		this.objectsPerPage = objectsPerPage;
	}
	/**
	 * Obtiene el valor del par�metro maxNumItems.
	 * 
	 * @return maxNumItems valor del campo a obtener.
	 *
	 */
	public int getMaxNumItems() {
		return maxNumItems;
	}
	/**
	 * Guarda el valor del par�metro maxNumItems.
	 * 
	 * @param maxNumItems
	 *            valor del campo a guardar.
	 */
	public void setMaxNumItems(int maxNumItems) {
		this.maxNumItems = maxNumItems;
	}
	
}
