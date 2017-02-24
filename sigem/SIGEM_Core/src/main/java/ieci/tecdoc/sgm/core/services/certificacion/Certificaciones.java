package ieci.tecdoc.sgm.core.services.certificacion;

import java.util.ArrayList;

/**
 * Contenedor de elementos mime.
 * 
 * @author IECISA
 *
 */
public class Certificaciones
{
   private ArrayList certificaciones;

   public Certificaciones()
   {
	   certificaciones = new ArrayList();
   }
   
   /**
    * Devuelve el n�mero de certificaciones de la colecci�n.
    * @return int N�mero de certificaciones de la colecci�n.
    */   
   public int count()
   {
      return certificaciones.size();
   }
   
   /**
    * Devuelve la certificacion de la posici�n indicada dentro de la colecci�n
    * @param index Posici�n de la certificacion a recuperar.
    * @return Certificacion Certificacion de la posicion indicada.
    */   
   public Certificacion get(int index)
   {
      return (Certificacion)certificaciones.get(index);
   }
   /**
    * A�ade una nueva certificacion a la colecci�n.
    * @param certificacion Nueva certificacion a a�adir.
    */   
   public void add(Certificacion certificacion) 
   {
	   certificaciones.add(certificacion);
   }
    
}