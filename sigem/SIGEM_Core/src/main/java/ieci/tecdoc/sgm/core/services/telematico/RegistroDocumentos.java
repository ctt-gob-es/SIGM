package ieci.tecdoc.sgm.core.services.telematico;

import java.util.ArrayList;

/**
 * Contenedor de documentos asociados a un registro.
 * 
 * @author IECISA
 *
 */
public class RegistroDocumentos
{
   private ArrayList registryDocuments;

   /**
    * Constructor de la clase RegistoDocumentos
    *
    */
   public RegistroDocumentos()
   {
     registryDocuments = new ArrayList();
   }
   
   /**
    * Devuelve el n�mero de documentos de la colecci�n.
    * @return int N�mero de documentos de la colecci�n.
    */   
   public int count()
   {
      return registryDocuments.size();
   }
   
   /**
    * Devuelve el documento de la posici�n indicada dentro de la colecci�n
    * @param index Posici�n del documento a recuperar.
    * @return Document Documento asociado a registro.
    */   
   public RegistroDocumento get(int index)
   {
      return (RegistroDocumento)registryDocuments.get(index);
   }
   /**
    * A�ade un nuevo documento a la colecci�n.
    * @param document Nuevo documento a a�adir.
    */   
   public void add(RegistroDocumento document) 
   {
     registryDocuments.add(document);
   }
  
}
    
