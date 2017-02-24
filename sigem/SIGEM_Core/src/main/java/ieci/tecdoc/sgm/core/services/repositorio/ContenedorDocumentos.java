package ieci.tecdoc.sgm.core.services.repositorio;

import java.util.ArrayList;

/**
 * Contenedor de documentos asociados a un registro.
 * 
 * @author IECISA
 *
 */
public class ContenedorDocumentos
{
   private ArrayList documents;

   public ContenedorDocumentos()
   {
      documents = new ArrayList();
   }
   
   /**
    * Devuelve el n�mero de documentos de la colecci�n.
    * @return int N�mero de documentos de la colecci�n.
    */   
   public int count()
   {
      return documents.size();
   }
   
   /**
    * Devuelve el documento de la posici�n indicada dentro de la colecci�n
    * @param index Posici�n del documento a recuperar.
    * @return Document Documento asociado a registro.
    */   
   public ContenedorDocumento get(int index)
   {
      return (ContenedorDocumento)documents.get(index);
   }
   /**
    * A�ade un nuevo documento a la colecci�n.
    * @param document Nuevo documento a a�adir.
    */   
   public void add(ContenedorDocumento document) 
   {
      documents.add(document);
   }
    
}
    
