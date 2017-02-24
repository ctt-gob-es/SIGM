package ieci.tecdoc.sgm.core.services.telematico;

import java.util.ArrayList;

/**
 * Contenedor de documentos adjuntos a la solicitud de registro.
 * 
 * @author IECISA
 *
 */
public class PeticionDocumentos
{
   private ArrayList documents;

   public PeticionDocumentos()
   {
      documents = new ArrayList();
   }
   
   /**
    * Devuelve el n�mero de documentos contenidos en la colecci�n.
    * @return int N�mero de documentos de la colecci�n.
    */   
   public int count()
   {
      return documents.size();
   }
   
   /**
    * Devuelve el documento de la posici�n indicada.
    * @param index Posici�n del documento dentro de la colecci�n.
    * @return RequestDocument Documento solicitado.
    */   
   public PeticionDocumento get(int index)
   {
      return (PeticionDocumento)documents.get(index);
   }
   
   /**
    * A�ade un nuevo documento adjunto a la solicitud de registro a la colecci�n.
    * @param document Nuevo documento a a�adir a la colecci�n.
    */   
   public void add(PeticionDocumento document) 
   {
      documents.add(document);
   }
    
}