package ieci.tecdoc.sbo.idoc.documental.search;

import ieci.tecdoc.core.exception.IeciTdException;
import ieci.tecdoc.sbo.idoc.folder.search.FolderSearchError;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * Este m�todo encapsula los resultados de una b�squeda de carpetas. Los
 * resultados corresponden con los identificadores de los archivadores, 
 * carpetas y documentos.
 *  
 */

public final class DocumentalSearchResult implements Serializable
{      
   /**
    * Coleccion de identificadores de archivadores, de carpetas y de documentos 
    */
   private List m_docIds;
   
   private int m_pageViewIndex = 1;
   
   /**
    * Logger
    */
   private static Logger logger = Logger.getLogger (DocumentalSearchResult.class );
    
   /**
    * Constructor
    */
   public DocumentalSearchResult()
   {   
      m_docIds = new ArrayList ();
   }
      
   /**
    * A�ade un nuevo identificador de carpeta a la colecci�n
    * @param fdrId identificador de carpeta
    */
   protected void addDocument (int archId, int fdrId, int docId) 
   {
      m_docIds.add(new DocumentalSearchRowResult (archId, fdrId, docId));      
   }
      
   /**
    * Elimina un documento de la colecci�n.
    * @return true si ha eliminado el documento del resultado
    */
   public boolean removeDocument (int archId, int fdrId, int docId) 
   {
      return m_docIds.remove (new DocumentalSearchRowResult (archId, fdrId, docId));   
   }
   
   /**
    * Elimina un documento de la colecci�n.
    * @return true si ha eliminado el documento del resultado
    */
   public void removeDocument (int index) 
   {
      m_docIds.remove (index);   
   }
   
   /**
    * devuelte el n�mero de documentos que pertenecen al resultado de la b�squeda
    * @return n�mero de documentos que pertenecen al resultado de la b�squeda
    */
   public int count()
   {
      return m_docIds.size();
   } 
   public int getSize()
   {
      return count ();
   } 
   
   /**
    * Devuelve el identificador del archivador i-�simo de la colecci�n
    * @param idx �ndice
    * @return identificador del archivador
    * @throws Exception si el �ndice no se encuentra en los l�mites de la colecci�n
    */
   public int getArchiveId(int idx) throws Exception
   {
      return getDocumentalSearchRowResult (idx).getArchId();
   }
   
   /**
    * Devuelve el identificador de la carpeta i-�simo de la colecci�n
    * @param idx �ndice
    * @return identificador de la carpeta
    * @throws Exception si el �ndice no se encuentra en los l�mites de la colecci�n
    */
   public int getFolderId(int idx) throws Exception
   {
      return getDocumentalSearchRowResult (idx).getFdrId();
   }
   
   /**
    * Devuelve el identificador del documento i-�simo de la colecci�n
    * @param idx �ndice
    * @return identificador del documento
    * @throws Exception si el �ndice no se encuentra en los l�mites de la colecci�n
    */
   public int getDocumentId(int idx) throws Exception
   {
      return getDocumentalSearchRowResult (idx).getDocId();
   }

   /**
    * Ordena los resultados conforme al identificador del archivador,
    * de la carpeta y del documento.
    */
   public void sort () {
      Collections.sort (m_docIds);
      
      // Tambi�n hay que eliminar los duplicados.
      
      DocumentalSearchRowResult documentalSearchRowResult;
      int lastArchive = Integer.MIN_VALUE, lastFolder = Integer.MIN_VALUE, lastDocument = Integer.MIN_VALUE;
      Iterator iterator = m_docIds.iterator();
      while (iterator.hasNext ()) {
         documentalSearchRowResult = (DocumentalSearchRowResult) iterator.next ();
         
         if (lastArchive == documentalSearchRowResult.getArchId() && lastFolder == documentalSearchRowResult.getFdrId() && lastDocument == documentalSearchRowResult.getDocId()) {
            iterator.remove ();
         }
         lastArchive = documentalSearchRowResult.getArchId();
         lastFolder = documentalSearchRowResult.getFdrId();
         lastDocument = documentalSearchRowResult.getDocId();
      }
   }
   
   /**
    * Devuelve un string con la representaci�n del objeto, es decir, la colecci�n de identificador
    * de carpetas
    * @return representaci�n del objeto, es decir, la colecci�n de identificadores de carpeta
    */
   public String toString() {
      StringBuffer buffer = new StringBuffer();
      
      buffer.append("DocumentalSearchResult[");
      
      for(int i = 0; i < m_docIds.size(); i++)
      {

          buffer.append(" [doc(").append(i+1);
          buffer.append(") = ").append((m_docIds.get(i)));
          buffer.append("] ");

      }
      
      buffer.append("]");
      
      return buffer.toString();
   }
   
   public DocumentalSearchRowResult getDocumentalSearchRowResult (int idx) throws IeciTdException {
   		try {
   		   return  ((DocumentalSearchRowResult) m_docIds.get(idx));
   		} catch (IndexOutOfBoundsException e) {
   		  throw new IeciTdException(FolderSearchError.EC_INVALID_PARAM, 
                 FolderSearchError.EM_INVALID_PARAM);
   		}
   }
   
   public void addDocumentalSearchRowResult (DocumentalSearchRowResult documentalSearchRowResult)  {
   		m_docIds.add(documentalSearchRowResult);
   }
   
   public List getDocumentalSearchResults () throws IeciTdException {
   		   return  m_docIds;
   }
   
   public int getPageViewIndex()
   {
      return m_pageViewIndex;
   }
   
   public void setPageViewIndex(int pageViewIndex)
   {
      this.m_pageViewIndex = pageViewIndex;
   }
} // class
