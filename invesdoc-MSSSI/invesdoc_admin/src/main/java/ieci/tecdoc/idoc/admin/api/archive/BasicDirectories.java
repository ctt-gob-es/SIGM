package ieci.tecdoc.idoc.admin.api.archive;

public interface BasicDirectories
{

   /**
    * Devuelve el n�mero de directorios.
    * 
    * @return El n�mero de directorios mencionado.
    */
   
   public int count(); 

   /**
    * Devuelve un directorio de la lista.
    * 
    * @param index Indice del directorio que se desea recuperar.
    * 
    * @return El directorio mencionado.
    */
    
   public BasicDirectory get(int index); 
}
