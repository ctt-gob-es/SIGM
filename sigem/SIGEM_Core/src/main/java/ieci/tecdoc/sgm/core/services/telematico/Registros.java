
package ieci.tecdoc.sgm.core.services.telematico;

import java.util.ArrayList;

/**
 * Contenedor de beans de registro.
 */
public class Registros {
    
   private ArrayList regs;

   /**
    * Constructor de la clase Registros
    *
    */
   public Registros()
   {
      regs = new ArrayList();
   }
   
   /**
    * Devuelve el n�mero de registro de la colecci�n.
    * @return int N�mero de registros de la colecci�n.
    */   
   public int count()
   {
      return regs.size();
   }
   
   /**
    * Devuelve el registro de la posici�n indicada.
    * @param index Posici�n del registro en la colecci�n.
    * @return Registry Registro.
    */   
   public Registro get(int index)
   {
      return (Registro)regs.get(index);
   }
   
   /**
    * A�ade un nuevo registro a la colecci�n.
    * @param registry Nuevo registro a a�adir.
    */   
   public void add(Registro registry) 
   {
   	  regs.add(registry);
   }

}
