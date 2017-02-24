package ieci.tecdoc.sgm.core.services.repositorio;

import java.util.ArrayList;

/**
 * Contenedor de elementos mime.
 * 
 * @author IECISA
 *
 */
public class TiposMime
{
   private ArrayList mimeTypes;

   public TiposMime()
   {
      mimeTypes = new ArrayList();
   }
   
   /**
    * Devuelve el n�mero de mime types de la colecci�n.
    * @return int N�mero de mime types de la colecci�n.
    */   
   public int count()
   {
      return mimeTypes.size();
   }
   
   /**
    * Devuelve el mime type de la posici�n indicada dentro de la colecci�n
    * @param index Posici�n del mime type a recuperar.
    * @return MimeType MimeType asociado a registro.
    */   
   public TipoMime get(int index)
   {
      return (TipoMime)mimeTypes.get(index);
   }
   /**
    * A�ade un nuevo mime type a la colecci�n.
    * @param mimeType Nuevo mime type a a�adir.
    */   
   public void add(TipoMime mimeType) 
   {
      mimeTypes.add(mimeType);
   }
    
}