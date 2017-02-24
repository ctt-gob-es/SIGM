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

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;

import es.msssi.sgm.registropresencial.beans.WebParameter;
import es.msssi.sgm.registropresencial.errors.ErrorConstants;
import es.msssi.sgm.registropresencial.utils.UtilExporter;
import es.msssi.sgm.registropresencial.utils.Utils;

/**
 * Clase que implementa la cabecera de los pdfs con la paginaci�n.
 * 
 * @author cmorenog
 */
public class PDFExporterTableHeader extends PdfPageEventHelper {

    private static final Logger LOG = Logger.getLogger(PDFExporterTableHeader.class.getName());

    /* n�mero total de p�ginas de la paginaci�n */
    private PdfTemplate total;
    /* texto de la cabecera */
    private String header;
    /* fecha */
    private String fecha;
    /** Ruta absoluta de las plantillas de informes. */
    private static String REPORT_TEMPLATE_PATH = null;
    
    static {
   	if (REPORT_TEMPLATE_PATH == null) {
   	    REPORT_TEMPLATE_PATH = (String) WebParameter.getEntryParameter("PATH_REPO") +
   		(String) WebParameter.getEntryParameter("PathReports");
   	}
      }
    
    /**
     * Constuctor.
     * 
     * @param header
     *            T�tulo de la cabecera.
     */
    public PDFExporterTableHeader(String header) {
	super();
	this.header = header;
    }

    /**
     * Evento que se lanza en la apertura del documento e inicializa los valores
     * de paginaci�n.
     * 
     * @param writer
     *            outputstream con el documento que se est� escribiendo.
     * @param document
     *            el documento.
     */
    @Override
    public void onOpenDocument(
	PdfWriter writer, Document document) {
	LOG.trace("Entrando en PDFExporterTableHeader.onOpenDocument()");
	total = writer.getDirectContent().createTemplate(
	    UtilExporter.PDF_TEMPLATE_WIDTH, UtilExporter.PDF_TEMPLATE_HEIGHT);
	fecha = new SimpleDateFormat(
	    "dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
	BaseFont bf;
	bf = UtilExporter.PDFPAGINACION.getCalculatedBaseFont(false);
	total.setFontAndSize(
	    bf, UtilExporter.FONTSIZE_9);
    }

    /**
     * Evento que se lanza al final de cada p�gina y escribe la cabecera de cada
     * p�gina.
     * 
     * @param writer
     *            outputstream con el documento que se est� escribiendo.
     * @param document
     *            el documento.
     */
    @Override
    public void onEndPage(
	PdfWriter writer, Document document) {
	LOG.trace("Entrando en PDFExporterTableHeader.onEndPage()");
	PdfPTable table = new PdfPTable(
	    UtilExporter.PDF_TABLE_COLUMNS);
	try {
	    table.setWidths(new int[] { UtilExporter.PDF_TABLE_RELATIVE_WIDTH_1,
		UtilExporter.PDF_TABLE_RELATIVE_WIDTH_2, UtilExporter.PDF_TABLE_RELATIVE_WIDTH_3 });
	    table.setTotalWidth(document.getPageSize().getWidth() -
		document.leftMargin() - document.rightMargin());
	    table.setLockedWidth(true);

	    table.getDefaultCell().setFixedHeight(
		UtilExporter.PDF_TABLE_FIXED_HEIGHT);
	    table.getDefaultCell().setBorder(
		Rectangle.BOTTOM);
	    table.getDefaultCell().setHorizontalAlignment(
		Element.ALIGN_RIGHT);
	    table.getDefaultCell().setVerticalAlignment(
		Element.ALIGN_MIDDLE);
	    PdfPCell cell;

	    /* imagen de cabecera */
	    table.addCell(createPdfPCell(
		Rectangle.BOTTOM, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 1, getImageCabecera(),
		null));

	    /* T�tulo del documento */
	    table.addCell(createPdfPCell(
		Rectangle.BOTTOM, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER, 1, null, new Phrase(
		    header, UtilExporter.FNTTITULO)));
	    PdfPTable tableFch = new PdfPTable(
		2);
	    table.setWidthPercentage(UtilExporter.PDF_TABLE_WIDTH_PERCENTAGE);
	    tableFch.setWidths(new int[] { UtilExporter.PDF_TITLE_WIDTH_1,
		UtilExporter.PDF_TITLE_WIDTH_2 });
	    /* caracter restringido */
	   
	    Paragraph textRes = new Paragraph(
		String.format(
		    "Car�cter Restringido"), UtilExporter.PDFPAGINACION);
	    textRes.setAlignment(2);
	    cell = createPdfPCell(
		Rectangle.NO_BORDER, Element.ALIGN_BOTTOM, Element.ALIGN_RIGHT, 2, textRes, null);
	    cell.setPaddingBottom(UtilExporter.PDF_TABLE_CELL_PADDING_BOTTOM);
	    tableFch.addCell(cell);
	    
	    /* Fecha del documento */
	    Paragraph textFch = new Paragraph(
		fecha, UtilExporter.PDFFECHA);
	    textFch.setAlignment(2);
	    tableFch.addCell(createPdfPCell(
		Rectangle.NO_BORDER, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 2, textFch, null));
	    
	    /* P�gina actual del documento */
	    Paragraph textPag = new Paragraph(
		String.format(
		    "P�gina %d de ", writer.getPageNumber()), UtilExporter.PDFPAGINACION);
	    textPag.setAlignment(2);
	    cell = createPdfPCell(
		Rectangle.NO_BORDER, Element.ALIGN_BOTTOM, Element.ALIGN_RIGHT, 1, textPag, null);
	    cell.setPaddingBottom(UtilExporter.PDF_TABLE_CELL_PADDING_BOTTOM);
	    tableFch.addCell(cell);

	    /* N�mero total de p�ginas */
	    tableFch.addCell(createPdfPCell(
		Rectangle.NO_BORDER, Element.ALIGN_BOTTOM, Element.ALIGN_LEFT, 1,
		Image.getInstance(total), null));

	    cell = new PdfPCell(
		tableFch);
	    cell.setBorder(Rectangle.BOTTOM);
	    table.addCell(cell);
	    table.writeSelectedRows(
		0, -1, document.leftMargin(), document.getPageSize().getHeight() -
		    UtilExporter.PDF_TABLE_NEGATIVE_ROW_HEIGHT, writer.getDirectContent());
	}
	catch (IOException ioException) {
	    LOG.error(
		ErrorConstants.PDF_DOCUMENT_EXPORT_ERROR_MESSAGE, ioException);
	    Utils.redirectToErrorPage(
		null, null, ioException);
	}
	catch (DocumentException documentException) {
	    LOG.error(
		ErrorConstants.PDF_DOCUMENT_EXPORT_ERROR_MESSAGE, documentException);
	    Utils.redirectToErrorPage(
		null, null, documentException);
	}
    }

    /**
     * Evento que se lanza en el cierre del documento e Introduce el texto de
     * n�mero de p�gina.
     * 
     * @param writer
     *            outputstream con el documento que se est� escribiendo.
     * @param document
     *            el documento.
     */
    @Override
    public void onCloseDocument(
	PdfWriter writer, Document document) {
	LOG.trace("Entrando en PDFExporterTableHeader.onCloseDocument()");
	ColumnText.showTextAligned(
	    total, Element.ALIGN_LEFT, new Phrase(
		String.valueOf(writer.getPageNumber() - 1)), 2, 2, 0);
    }

    /**
     * Devuelve la imagen de la cabecera en un objecto Image.
     * 
     * @return La imagen de cabecera.
     * 
     * @throws IOException
     *             si ha ocurrido un error de entrada/salida.
     * @throws BadElementException
     *             si el elemento que se esperaba no es el correcto.
     */
    private Image getImageCabecera()
	throws IOException, BadElementException {
	LOG.trace("Entrando en PDFExporterTableHeader.getImageCabecera()");
	String logo = REPORT_TEMPLATE_PATH +
	    UtilExporter.LOGO;
	return com.lowagie.text.Image.getInstance(logo);
    }

    /**
     * Crea una celda de una tabla de un documento PDF.
     * 
     * @param border
     *            borde la celda.
     * @param verticalAlignment
     *            alineaci�n vertical.
     * @param horizontalAlignment
     *            alineaci�n horizontal.
     * @param colspan
     *            el colspan de la celda.
     * @param element
     *            el elemento que contiene la celda.
     * @param phrase
     *            el objecto phrase con que se inicializa la celda.
     * 
     * @return cell La celda creada.
     */
    private PdfPCell createPdfPCell(
	int border, int verticalAlignment, int horizontalAlignment, int colspan, Element element,
	Phrase phrase) {
	LOG.trace("Entrando en PDFExporterTableHeader.createPdfPCell()");
	PdfPCell cell;
	if (phrase != null) {
	    cell = new PdfPCell(
		phrase);
	}
	else {
	    cell = new PdfPCell();
	}

	cell.setBorder(border);
	if (element != null) {
	    cell.addElement(element);
	}
	cell.setColspan(colspan);
	cell.setVerticalAlignment(verticalAlignment);
	cell.setHorizontalAlignment(horizontalAlignment);
	return cell;
    }
}