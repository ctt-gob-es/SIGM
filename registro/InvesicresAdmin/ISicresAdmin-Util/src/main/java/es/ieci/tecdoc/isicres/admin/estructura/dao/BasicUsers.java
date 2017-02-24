
package es.ieci.tecdoc.isicres.admin.estructura.dao;

public interface BasicUsers 
{

   /**
    * Devuelve el n�mero de usuarios.
    * 
    * @return El n�mero de usuarios mencionado.
    */
   
   public int count(); 

   /**
    * Devuelve un usuario de la lista.
    * 
    * @param index Indice del usuario que se desea recuperar.
    * 
    * @return El usuario mencionado.
    */
    
   public BasicUser get(int index); 

}