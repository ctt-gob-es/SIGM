/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.sgm.registropresencial.beans.ibatis;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;

/**
 * Clase para manejar los datos de las tablas AxPAGEH desde Ibatis, a la hora de
 * mostrarlos en el listado de documentos anexos de un registro.
 * 
 * @author jortizs
 */
public class Axpageh {
    public static final double SPACE_KB = 1024;
    // Id. de la p�gina.
    private Integer id;
    // Id. del registro.
    private Integer fdrid;
    // Nombre del documento.
    private String name;
    // Id. del documento.
    private Integer docId;
    // Fecha de creaci�n.
    private Date crtndate;
    // Tipo de documento.
    private String loc;
    // id fichero
    private Integer fileId;
    //id volumen
    private Integer volId;
    //size del fichero
    private Integer fileSize;
    //id page
    private Integer pageId;
    //comentarios
    private String comments;
    //mime
    private String mimeType;
    //tipo validacion
    private Integer validityType;
    //tipo document
    private Integer documentType;
    //tipo validacion
    private String nameValidityType;
    //tipo document
    private String  nameDocumentType;
    //hash
    private byte[] hash;
    //hash algorithm
    private String hashAlg;
    //id pagina de quien es firma
    private Integer pageSignedId;
    //page de la firma
    private Axpageh pageSigned;
    //ID Flag
    private Integer flag;
    /**
     * Constructor.
     * 
     */
    public Axpageh() {

    }

    /**
     * Obtiene el valor del par�metro id.
     * 
     * @return id valor del campo a guardar.
     */
    public Integer getId() {
	return id;
    }

    /**
     * Obtiene el valor del par�metro id.
     * 
     * @param id
     *            valor del campo a obtener.
     */
    public void setId(Integer id) {
	this.id = id;
    }

    /**
     * Obtiene el valor del par�metro fdrid.
     * 
     * @return fdrid valor del campo a obtener.
     */
    public Integer getFdrid() {
	return fdrid;
    }

    /**
     * Guarda el valor del par�metro fdrid.
     * 
     * @param fdrid
     *            valor del campo a guardar.
     */
    public void setFdrid(Integer fdrid) {
	this.fdrid = fdrid;
    }

    /**
     * Obtiene el valor del par�metro name.
     * 
     * @return name valor del campo a obtener.
     */
    public String getName() {
	return name;
    }

    /**
     * Guarda el valor del par�metro name.
     * 
     * @param name
     *            valor del campo a guardar.
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * Obtiene el valor del par�metro docId.
     * 
     * @return docId valor del campo a guardar.
     */
    public Integer getDocId() {
	return docId;
    }

    /**
     * Obtiene el valor del par�metro docId.
     * 
     * @param docId
     *            valor del campo a obtener.
     */
    public void setDocId(Integer docId) {
	this.docId = docId;
    }
    
    /**
     * Obtiene el valor del par�metro crtndate.
     * 
     * @return crtndate valor del campo a obtener.
     */
    public Date getCrtndate() {
	return crtndate;
    }

    /**
     * Guarda el valor del par�metro crtndate.
     * 
     * @param crtndate
     *            valor del campo a guardar.
     */
    public void setCrtndate(Date crtndate) {
	this.crtndate = crtndate;
    }
    
    /**
     * Obtiene el valor del par�metro loc.
     * 
     * @return loc valor del campo a obtener.
     */
    public String getLoc() {
	return loc;
    }

    /**
     * Guarda el valor del par�metro loc.
     * 
     * @param loc
     *            valor del campo a guardar.
     */
    public void setLoc(String loc) {
	this.loc = loc;
    }
    
    /**
     * Obtiene el valor del par�metro fileId.
     * 
     * @return fileId valor del campo a obtener.
     */
    public Integer getFileId() {
        return fileId;
    }
    /**
     * Guarda el valor del par�metro fileId.
     * 
     * @param fileId
     *            valor del campo a guardar.
     */
    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    /**
     * Obtiene el valor del par�metro volId.
     * 
     * @return volId valor del campo a obtener.
     */
    public Integer getVolId() {
        return volId;
    }
    /**
     * Guarda el valor del par�metro volId.
     * 
     * @param volId
     *            valor del campo a guardar.
     */
    public void setVolId(Integer volId) {
        this.volId = volId;
    }
    /**
     * Obtiene el valor del par�metro fileSize.
     * 
     * @return fileSize valor del campo a obtener.
     */
    public Integer getFileSize() {
        return fileSize;
    }
    /**
     * Guarda el valor del par�metro fileSize.
     * 
     * @param fileSize
     *            valor del campo a guardar.
     */
    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }
    /**
     * Obtiene el valor del par�metro fileSize en kB.
     * 
     * @return fileSize valor del campo a obtener.
     */
    public String getFileSizeKB (){
	String fileSizeKB = null;
	if (fileSize != null){
	    NumberFormat nf = new DecimalFormat();
	    nf.setMaximumFractionDigits(2);
	    nf.setMinimumFractionDigits(2);
	    nf.setRoundingMode(RoundingMode.HALF_UP);
	    fileSizeKB = nf.format(fileSize/SPACE_KB).replace(",",".");
	}
	return fileSizeKB;
    }
    /**
     * Obtiene el valor del par�metro pageId.
     * 
     * @return pageId valor del campo a obtener.
     */
    public Integer getPageId() {
        return pageId;
    }
    /**
     * Guarda el valor del par�metro pageId.
     * 
     * @param pageId
     *            valor del campo a guardar.
     */
    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }
    /**
     * Obtiene el valor del par�metro comments.
     * 
     * @return comments valor del campo a obtener.
     */
    public String getComments() {
        return comments;
    }
    /**
     * Guarda el valor del par�metro comments.
     * 
     * @param comments
     *            valor del campo a guardar.
     */
    public void setComments(String comments) {
        this.comments = comments;
    }
    /**
     * Obtiene el valor del par�metro mimeType.
     * 
     * @return mimeType valor del campo a obtener.
     */
    public String getMimeType() {
        return mimeType;
    }
    /**
     * Guarda el valor del par�metro mimeType.
     * 
     * @param mimeType
     *            valor del campo a guardar.
     */
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }
    /**
     * Obtiene el valor del par�metro validityType.
     * 
     * @return validityType valor del campo a obtener.
     */
    public Integer getValidityType() {
        return validityType;
    }
    /**
     * Guarda el valor del par�metro validityType.
     * 
     * @param validityType
     *            valor del campo a guardar.
     */
    public void setValidityType(Integer validityType) {
        this.validityType = validityType;
    }
    /**
     * Obtiene el valor del par�metro documentType.
     * 
     * @return documentType valor del campo a obtener.
     */
    public Integer getDocumentType() {
        return documentType;
    }
    /**
     * Guarda el valor del par�metro documentType.
     * 
     * @param documentType
     *            valor del campo a guardar.
     */
    public void setDocumentType(Integer documentType) {
        this.documentType = documentType;
    }
    /**
     * Obtiene el valor del par�metro hash.
     * 
     * @return hash valor del campo a obtener.
     */
    public byte[] getHash() {
        return hash;
    }
    /**
     * Guarda el valor del par�metro hash.
     * 
     * @param hash
     *            valor del campo a guardar.
     */
    public void setHash(byte[] hash) {
        this.hash = hash;
    }
    
    /**
     * Obtiene el valor del par�metro hashAlg.
     * 
     * @return hashAlg valor del campo a obtener.
     */
	public String getHashAlg() {
		return hashAlg;
	}
	
    /**
     * Guarda el valor del par�metro hashAlg.
     * 
     * @param hashAlg
     *            valor del campo a guardar.
     */
	public void setHashAlg(String hashAlg) {
		this.hashAlg = hashAlg;
	}
	
    /**
     * Obtiene el valor del par�metro pageSignedId.
     * 
     * @return pageSignedId valor del campo a obtener.
     */
    public Integer getPageSignedId() {
        return pageSignedId;
    }
    /**
     * Guarda el valor del par�metro pageSignedId.
     * 
     * @param pageSignedId
     *            valor del campo a guardar.
     */
    public void setPageSignedId(Integer pageSignedId) {
        this.pageSignedId = pageSignedId;
    }
    /**
     * Obtiene el valor del par�metro pageSigned.
     * 
     * @return pageSigned valor del campo a obtener.
     */
    public Axpageh getPageSigned() {
        return pageSigned;
    }
    /**
     * Guarda el valor del par�metro pageSigned.
     * 
     * @param pageSigned
     *            valor del campo a guardar.
     */
    public void setPageSigned(Axpageh pageSigned) {
        this.pageSigned = pageSigned;
    }
    /**
     * Obtiene el valor del par�metro nameValidityType.
     * 
     * @return nameValidityType valor del campo a obtener.
     */
    public String getNameValidityType() {
        return nameValidityType;
    }
    /**
     * Guarda el valor del par�metro nameValidityType.
     * 
     * @param nameValidityType
     *            valor del campo a guardar.
     */
    public void setNameValidityType(String nameValidityType) {
        this.nameValidityType = nameValidityType;
    }
    /**
     * Obtiene el valor del par�metro nameDocumentType.
     * 
     * @return nameDocumentType valor del campo a obtener.
     */
    public String getNameDocumentType() {
        return nameDocumentType;
    }
    /**
     * Guarda el valor del par�metro nameDocumentType.
     * 
     * @param nameDocumentType
     *            valor del campo a guardar.
     */
    public void setNameDocumentType(String nameDocumentType) {
        this.nameDocumentType = nameDocumentType;
    }
    /**
     * Obtiene el valor del par�metro nameDocumentType.
     * 
     * @return nameDocumentType valor del campo a obtener.
     */
    public Integer getFlag() {
        return flag;
    }
    /**
     * Guarda el valor del par�metro flag.
     * 
     * @param flag
     *            valor del campo a guardar.
     */
    public void setFlag(Integer flag) {
        this.flag = flag;
    }
    
}