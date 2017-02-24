
package ieci.tecdoc.sbo.idoc.api;

import ieci.tecdoc.sbo.idoc.folder.base.FolderTokenDocuments;

/**
 * Esta clase encapsula la lista de documentos que forman parte
 * del arbol de nodos de la carpeta
 * 
 * @author 
 *
 */
public final class FolderDocumentObjects 
{
   /** Contiene la l�gica de negocio de la lista */
   FolderTokenDocuments m_docs;
   
   /**
    * Constructor
    * 
    * @param docs el objeto FolderTokenDocuments
    */
   protected FolderDocumentObjects(FolderTokenDocuments docs)
   {
      m_docs = docs;    
   } 

   /**
    * Devuelve el numero de documentos de la lista
    * 
    * @return el numero de documentos de la lista
    */
   public int count()
   {
      return m_docs.count();
   }   
   
   /**
    * Devuelve el documento con el �ndice especificado
    * 
    * @param index �ndice del documento
    * @return el documento buscado
    */
   public FolderDocumentObject get(int index)
   {
      FolderDocumentObject doc = new FolderDocumentObject(m_docs.get(index));
      
      return doc;
   } 
   
      
} // class
