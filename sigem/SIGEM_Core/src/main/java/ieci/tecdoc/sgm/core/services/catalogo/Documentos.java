package ieci.tecdoc.sgm.core.services.catalogo;

import java.util.ArrayList;


/**
 * Contendor de documentos.
 * 
 * @author IECISA
 *
 */
public class Documentos
{
   private ArrayList documents;

   public Documentos()
   {
      documents = new ArrayList();
   }

   /**
    * Devuelve el n�mero de docuentos de la colecci�n
    * @return
    */
   public int count() {
      return documents.size();
   }

   /**
    * Devuelve el documento que se encuentra en la posici�n indicada.
    * @param index Posici�n del documento dentro de la colecci�n.
    * @return DocumentExt Documento.
    */
   public DocumentoExtendido get(int index) {
      return (DocumentoExtendido) documents.get(index);
   }

   /**
    * A�ade un nuevo documento a la colecci�n
    * @param document Nuevo documento a a�adir.
    */
   public void add(DocumentoExtendido document) {
      documents.add(document);
   }
 
}