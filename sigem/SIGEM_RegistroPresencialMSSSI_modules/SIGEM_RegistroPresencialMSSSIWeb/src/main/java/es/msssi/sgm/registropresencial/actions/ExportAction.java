/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.sgm.registropresencial.actions;

import java.io.IOException;
import java.util.Date;

import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.export.PDFExporter;

import es.msssi.sgm.registropresencial.businessobject.EXCELExporterBo;
import es.msssi.sgm.registropresencial.businessobject.PDFExporterBo;
import es.msssi.sgm.registropresencial.errors.ErrorConstants;

/**
 * Action con acciones sobre la exportaci�n de datos en pdf y excel.
 * 
 * @author cmorenog
 */
public class ExportAction extends GenericActions {
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(ExportAction.class);

    /** Implementaci�n de la exportaci�n a pdf. */
    private PDFExporter exporter;
    /** Implementaci�n de la exportaci�n a excel. */
    private EXCELExporterBo excelExporterBo;

    /**
     * Constructor.
     */
    public ExportAction() {
	exporter = new PDFExporterBo();
	excelExporterBo = new EXCELExporterBo();
    }

    /**
     * Procesa el excel de exportaci�n de datos a excel con los resultados de la
     * b�squeda de registros.
     * 
     * @throws NullPointerException
     *             Si la tabla de datos est� vac�a.
     */
    public void exportXLS()
	throws NullPointerException {
	LOG.trace("Entrando en ExportAction.exportXLS()");
	FacesContext context = FacesContext.getCurrentInstance();
	UIViewRoot root = context.getViewRoot();
	Date now = new Date();
	DataTable table = (DataTable) root.findComponent("form:books");

	if (table == null) {
	    throw new NullPointerException(
		ErrorConstants.NULL_DATA_TABLE_ERROR_MESSAGE);
	}
	excelExporterBo.export(
	    context, table, "BusquedaRegistros_" +
		now.getTime(), false, false, "iso-8859-1", null, null);
	context.responseComplete();
    }

    /**
     * Procesar el pdf de exportaci�n de datos a excel con los resultados de la
     * b�squeda de registros.
     * 
     * @throws NullPointerException
     *             Si la tabla de datos est� vac�a.
     * @throws IOException
     *             Si se produce un error de entrada/salida en la exportaci�n.
     */
    public void exportPDF()
	throws NullPointerException, IOException {
	LOG.trace("Entrando en ExportAction.exportPDF()");
	FacesContext context = FacesContext.getCurrentInstance();
	UIViewRoot root = context.getViewRoot();
	Date now = new Date();
	DataTable table = (DataTable) root.findComponent("form:books");

	if (table == null) {
	    throw new NullPointerException(
		ErrorConstants.NULL_DATA_TABLE_ERROR_MESSAGE);
	}

	exporter.export(
	    context, table, "BusquedaRegistros_" +
		now.getTime(), false, false, "iso-8859-1", null, null);
	context.responseComplete();
    }
}