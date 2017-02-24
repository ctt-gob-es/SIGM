/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.sgm.registropresencial.daos;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.ieci.tecdoc.common.isicres.AxPKById;

import es.msssi.sgm.registropresencial.beans.ibatis.Axdoch;
import es.msssi.sgm.registropresencial.beans.ibatis.Axpageh;
import es.msssi.sgm.registropresencial.dao.SqlMapClientBaseDao;

/**
 * Clase que contiene los m�todos para recuperar los documentos de los
 * registros.
 * 
 * @author jortizs
 * 
 */
public class DocumentDAO extends SqlMapClientBaseDao {
    private static final Logger LOG = Logger.getLogger(DocumentDAO.class.getName());
    private String typePK = null;

    /**
     * Obtiene el nombre de tabla de documentos a partir del libro donde se
     * busca.
     * 
     * @return tableName El nombre de la tabla donde buscar.
     */
    protected String getDocTableName() {
	String tableName = "A" +
	    typePK + "DOCH";
	return tableName;
    }

    /**
     * Obtiene el nombre de tabla de p�ginas a partir del libro donde se busca.
     * 
     * @return tableName El nombre de la tabla donde buscar.
     */
    protected String getPageTableName() {
	String tableName = "A" +
	    typePK + "PAGEH";
	return tableName;
    }

    /**
     * Obtiene la informaci�n b�sica de un documento anexo a un registro, para
     * mostrarla en el listado.
     * 
     * @param axPKById
     *            La informaci�n principal sobre la que buscar.
     * @return resultDoc La informaci�n del documento.
     */
    public Axdoch getDocBasicInfo(AxPKById axPKById) {
	LOG.trace("Entrando en DocumentDAO.getDocBasicInfo");
	typePK = axPKById.getType();
	Axdoch axdoch = new Axdoch();
	HashMap<String, Object> docSqlParameters = new HashMap<String, Object>();
	docSqlParameters.put("tableName", getDocTableName());
	docSqlParameters.put("id", axPKById.getId());
	docSqlParameters.put("fdrid", axPKById.getFdrId());
	axdoch =
		(Axdoch) getSqlMapClientTemplate().queryForObject("Axdoch.selectAxdoch",
			docSqlParameters);
	/*for (Axdoch axdoch : axdochList) {
	    resultDoc.setId(axdoch.getId());
	    resultDoc.setFdrId(axdoch.getFdrid());
	    resultDoc.setName(axdoch.getName());
	    resultDoc.setCrtnDate(axdoch.getCrtndate());
	}*/
	LOG.trace("Saliendo de DocumentDAO.getDocBasicInfo");
	return axdoch;
    }

    /**
     * Obtiene la informaci�n b�sica de una p�gina de un documento anexo a un
     * registro, para mostrarla en el listado.
     * 
     * @param axPKById
     *            La informaci�n principal sobre la que buscar.
     * @return pageDoc La informaci�n de la p�gina.
     */
    public Axpageh getPageBasicInfo(AxPKById axPKById) {
	LOG.trace("Entrando en DocumentDAO.getPageBasicInfo");
	typePK = axPKById.getType();

	Axpageh axpageh = new Axpageh();
	HashMap<String, Object> pageSqlParameters = new HashMap<String, Object>();
	pageSqlParameters.put("tableName", getPageTableName());
	pageSqlParameters.put("id", axPKById.getId());
	pageSqlParameters.put("fdrid", axPKById.getFdrId());
	pageSqlParameters.put("idBook", axPKById.getType());
	axpageh =
		(Axpageh) getSqlMapClientTemplate().queryForObject("Axpageh.selectAxpageh",
			pageSqlParameters);
	/*for (Axpageh axpageh : axpagehList) {
	    resultPage.setId(axpageh.getId());
	    resultPage.setFdrId(axpageh.getFdrid());
	    resultPage.setName(axpageh.getName());
	    resultPage.setDocId(axpageh.getDocId());
	    resultPage.setCrtnDate(axpageh.getCrtndate());
	    resultPage.setLoc(axpageh.getLoc());
	}*/
	LOG.trace("Saliendo de DocumentDAO.getPageBasicInfo");
	return axpageh;
    }

    /**
     * Obtiene la informaci�n b�sica de las p�ginas de un documento anexo a un
     * registro, para mostrarla en el listado.
     * 
     * @param axPKByIdDoc
     *            La informaci�n principal sobre la que buscar.
     * @param flag
     * 		indicador de si es un fichero interno no imprimible en los acuses.
     * @return pageDoc La informaci�n de la p�gina.
     */
    @SuppressWarnings("unchecked")
    public List<Axpageh> getPagesBasicInfo(AxPKById axPKByIdDoc, Integer flag) {
	LOG.trace("Entrando en DocumentDAO.getPagesBasicInfo");
	typePK = axPKByIdDoc.getType();
	List<Axpageh> axpagehList = null;
	HashMap<String, Object> pageSqlParameters = new HashMap<String, Object>();
	pageSqlParameters.put("tableName", getPageTableName());
	pageSqlParameters.put("docid", axPKByIdDoc.getId());
	pageSqlParameters.put("fdrid", axPKByIdDoc.getFdrId());
	pageSqlParameters.put("idBook", axPKByIdDoc.getType());
	if (flag != null){
	    pageSqlParameters.put("flag", flag);
	}
	axpagehList =
		(List<Axpageh>) getSqlMapClientTemplate().queryForList("Axpageh.listAxpageh",
			pageSqlParameters);
	
	LOG.trace("Saliendo de DocumentDAO.getPagesBasicInfo");
	return axpagehList;
    }
    
    /**
     * Obtiene la informaci�n b�sica de las p�ginas de un documento anexo a un
     * registro, para mostrarla en el listado.
     * 
     * @param axPKByIdDoc
     *            La informaci�n principal sobre la que buscar.
     * @return pageDoc La informaci�n de la p�gina.
     */
    public List<Axpageh> getPagesBasicInfo(AxPKById axPKByIdDoc) {
	LOG.trace("Entrando en DocumentDAO.getPagesBasicInfo");
	List<Axpageh> axpagehList = null;
	axpagehList = getPagesBasicInfo(axPKByIdDoc, null);
	LOG.trace("Saliendo de DocumentDAO.getPagesBasicInfo");
	return axpagehList;
    }
    
    /**
     * Borra un documento incluyendo sus p�ginas.
     * 
     * @param axPKByIdDoc
     *            La informaci�n principal sobre la que buscar.
     */
    public void deleteDocument(AxPKById axPKByIdDoc) {
	LOG.trace("Entrando en DocumentDAO.deleteDocument");
	typePK = axPKByIdDoc.getType();
	int delete = 0;
	HashMap<String, Object> pageSqlParameters = new HashMap<String, Object>();
	pageSqlParameters.put("tableNamePag", getPageTableName());
	pageSqlParameters.put("tableNameDoc", getDocTableName());
	pageSqlParameters.put("docid", axPKByIdDoc.getId());
	pageSqlParameters.put("fdrid", axPKByIdDoc.getFdrId());
	pageSqlParameters.put("idBook", axPKByIdDoc.getType());
	delete = getSqlMapClientTemplate().update("SrcPageRepository.deleteSrcPageRepository",
		pageSqlParameters);
	delete = getSqlMapClientTemplate().delete("Axpageh.deleteAxpageh",
			pageSqlParameters);
	delete = getSqlMapClientTemplate().delete("Axdoch.deleteAxdoch",
				pageSqlParameters);
	LOG.trace("Saliendo de DocumentDAO.deleteDocument");
    }
    
    /**
     * Obtiene el valor del par�metro typePK.
     * 
     * @return typePK valor del campo a obtener.
     */
    public String getTypePK() {
	return typePK;
    }

    /**
     * Guarda el valor del par�metro typePK.
     * 
     * @param typePK
     *            valor del campo a guardar.
     */
    public void setTypePK(
	String typePK) {
	this.typePK = typePK;
    }

    /**
     * Obtiene la informaci�n b�sica de una p�gina de un documento anexo a un
     * registro, para mostrarla en el listado.
     * 
     * @param axPKById
     *            La informaci�n principal sobre la que buscar.
     * @return pageDoc La informaci�n de la p�gina.
     */
    public Integer countPageReport(AxPKById axPKById) {
	LOG.trace("Entrando en DocumentDAO.countPageReport");
	typePK = axPKById.getType();
	Integer count = 0;
	HashMap<String, Object> pageSqlParameters = new HashMap<String, Object>();
	pageSqlParameters.put("tableName", getPageTableName());
	pageSqlParameters.put("id", axPKById.getId());
	pageSqlParameters.put("fdrid", axPKById.getFdrId());
	pageSqlParameters.put("idBook", axPKById.getType());
	count =
		(Integer) getSqlMapClientTemplate().queryForObject("Axpageh.countAxpagehReport",
			pageSqlParameters);

	LOG.trace("Saliendo de DocumentDAO.countPageReport");
	return count;
    }

    /**
     * Marca el documento como acuse.
     * 
     * @param axPKByIdDoc
     *            La informaci�n principal sobre la que buscar.
     * @param	idpage
     * 			id pagina.
     * @param numAcuse
     * 		n�mero de acuse.
     */
    public void updateFlag(AxPKById axPKByIdDoc, int idpage, Integer numAcuse) {
	LOG.trace("Entrando en DocumentDAO.updateFlag");
	typePK = axPKByIdDoc.getType();
	HashMap<String, Object> pageSqlParameters = new HashMap<String, Object>();
	pageSqlParameters.put("tableNamePag", getPageTableName());
	pageSqlParameters.put("tableName", getDocTableName());
	pageSqlParameters.put("fdrid", axPKByIdDoc.getFdrId());
	pageSqlParameters.put("idBook", axPKByIdDoc.getType());
	pageSqlParameters.put("idPage", idpage);
	pageSqlParameters.put("flag", numAcuse);
	getSqlMapClientTemplate().update("SrcPageRepository.updateFlagSrcPageRepository",
		pageSqlParameters);
	LOG.trace("Saliendo de DocumentDAO.updateFlag");
    }


    
}