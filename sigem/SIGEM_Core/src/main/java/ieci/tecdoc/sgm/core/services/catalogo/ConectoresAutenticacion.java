package ieci.tecdoc.sgm.core.services.catalogo;

import java.util.ArrayList;


/**
 * Contenedor de conectores de autenticaci�n.
 * 
 * @author IECISA
 *
 */
public class ConectoresAutenticacion
{
   private ArrayList conectoresAutenticacion;

   public ConectoresAutenticacion()
   {
	   conectoresAutenticacion = new ArrayList();
   }

   /**
    * Devuelve el n�mero de conectores de autenticaci�n de la colecci�n
    * @return
    */
   public int count() {
      return conectoresAutenticacion.size();
   }

   /**
    * Devuelve el conector de autenticaci�n que se encuentra 
    * en la posici�n indicada.
    * @param index Posici�n del conector de autenticaci�n dentro de la colecci�n.
    * @return ConectorAutenticacion Conector de autenticaci�n.
    */
   public ConectorAutenticacion get(int index) {
      return (ConectorAutenticacion) conectoresAutenticacion.get(index);
   }

   /**
    * A�ade un nuevo conector de autenticaci�n a la colecci�n
    * @param document Nuevo conector de autenticaci�n a a�adir.
    */
   public void add(ConectorAutenticacion conectorAutenticacion) {
	   conectoresAutenticacion.add(conectorAutenticacion);
   }
   
}