/*
 * Created on 13-may-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package ieci.tecdoc.sbo.idoc.api;

import ieci.tecdoc.sbo.idoc.documental.search.DocumentalSearchQuery;


/**
 * Clase que encapusula la b�squeda documental (en todos los archivadores)
 * 
 */
public final class DocumentalSearchQueryObject
{
   private DocumentalSearchQuery m_documentalSearchQuery;

   /**
    * Constructor 
    * @param arch archivador sobre el que se va a realizar la 
    * b�squeda
    */
   public DocumentalSearchQueryObject()
   {
      m_documentalSearchQuery = new DocumentalSearchQuery ();
   }
   
   /**
    * A�ade una condici�n de b�squeda en contenido de documentos
    * @param condition expresi�n de b�squeda documental   
    */   
   public void addFTSSearchCondition(String condition) 
   {
      m_documentalSearchQuery.addFTSSearchCondition (condition);
   }

   public DocumentalSearchQuery getDocumentalSearchQuery()
   {
      return m_documentalSearchQuery;
   }
}
