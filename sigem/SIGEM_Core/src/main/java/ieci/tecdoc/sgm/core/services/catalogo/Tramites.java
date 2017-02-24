package ieci.tecdoc.sgm.core.services.catalogo;

import java.util.ArrayList;


/**
 * Colecci�n de procedimientos.
 * 
 * @author IECISA
 *
 */
public class Tramites 
{
   private ArrayList procedures;

   public Tramites()
   {
      procedures = new ArrayList();
   }
   
   /**
    * Devuelve el n�mero de procedimientos de la colecci�n.
    * @return int N�mero de procedimientos.
    */   
   public int count()
   {
      return procedures.size();
   }
   
   /**
    * Recupera el procedimiento de la posici�n indicada.
    * @param index Posici�n del procedimiento a recuperar.
    * @return Procedure Procedimiento.
    */   
   public Tramite get(int index)
   {
      return (Tramite)procedures.get(index);
   }
   
   /**
    * A�ade un nuevo procedimiento a la colecci�n.
    * @param procedure Nuevo procedimiento a a�adir.
    */   
   public void add(Tramite procedure) 
   {
      procedures.add(procedure);
   }
   
}