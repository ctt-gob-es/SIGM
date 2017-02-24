/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.sgm.registropresencial.businessobject;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import es.ieci.tecdoc.isicres.api.intercambioregistral.business.vo.BandejaEntradaItemVO;

/**
 * Clase que implementa la interfaz IGenericBo que contiene los m�todos
 * relacionados con la b�squeda de la bandeja de entrada del intercambio
 * registral.
 * 
 * @author cmorenog
 */
public class SearchInboxRegInterchangeBo extends ListDataModel<BandejaEntradaItemVO> implements
    SelectableDataModel<BandejaEntradaItemVO> {

    /**
     * Constructor.
     */
    public SearchInboxRegInterchangeBo() {
	super();

    }

    /**
     * Constructor.
     * 
     * @param data
     *            lista de datos.
     */
    public SearchInboxRegInterchangeBo(List<BandejaEntradaItemVO> data) {
	super(data);
    }

    @Override
    public BandejaEntradaItemVO getRowData(
	String rowKey) {
	@SuppressWarnings("unchecked")
	List<BandejaEntradaItemVO> list = (List<BandejaEntradaItemVO>) getWrappedData();
	BandejaEntradaItemVO result = null;
	for (BandejaEntradaItemVO bandejaEntradaItemVO : list) {
	    if (String.valueOf(
		bandejaEntradaItemVO.getIdIntercambioInterno()).equals(
		rowKey)) {
		result = bandejaEntradaItemVO;
	    }
	}
	return result;
    }

    @Override
    public Object getRowKey(
	BandejaEntradaItemVO bandejaEntradaItemVO) {
	return bandejaEntradaItemVO.getIdIntercambioInterno();
    }

}
