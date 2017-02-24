/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.sgm.registropresencial.beans;

import java.util.ArrayList;
import java.util.List;

import es.ieci.tecdoc.isicres.api.intercambioregistral.business.vo.UnidadTramitacionIntercambioRegistralSIRVO;

/**
 * Bean que guarda los datos que devuelve la consulta de unidades tramitadoras.
 * 
 * @author cmorenog
 */
public class UnitsTramResultsBean
		extends GenericBean {
	
	private static final long serialVersionUID = 4907664550675804289L;
	/** Total de resultados de la consulta. */
	private int totalSize = 0;
	/** Filas resultantes de de la consulta. */
	private List<UnidadTramitacionIntercambioRegistralSIRVO> rows =
			new ArrayList<UnidadTramitacionIntercambioRegistralSIRVO>();
	
	/**
	 * Constructor.
	 */
	public UnitsTramResultsBean() {
	}
	
	/**
	 * Obtiene el valor del parameter totalSize.
	 * 
	 * @return totalSize valor del campo a obtener.
	 */
	public int getTotalSize() {
		return totalSize;
	}
	
	/**
	 * Guarda el valor del par�metro totalSize.
	 * 
	 * @param totalSize
	 *            valor del campo a guardar.
	 */
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	
	/**
	 * Obtiene el valor del par�metro rows.
	 * 
	 * @return rows valor del campo a obtener.
	 */
	public List<UnidadTramitacionIntercambioRegistralSIRVO> getRows() {
		return rows;
	}
	
	/**
	 * Guarda el valor del par�metro rows.
	 * 
	 * @param rows
	 *            valor del campo a guardar.
	 */
	public void setRows(List<UnidadTramitacionIntercambioRegistralSIRVO> rows) {
		this.rows = rows;
	}
	
}
