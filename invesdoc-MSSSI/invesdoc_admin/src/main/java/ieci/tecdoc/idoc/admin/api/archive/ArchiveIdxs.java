package ieci.tecdoc.idoc.admin.api.archive;

/**
 * Proporciona toda la funcionalidad necesaria para manejar �ndices. 
 */
import java.util.ArrayList;


public interface ArchiveIdxs
{
   
   /**
    * Inicializa la estructura de �ndices
    *
    */
   public void clear();
   
   /**
    * Obtiene el n�mero de �ndices en la estructura. 
    * 
    * @return N�mero de �ndices
    */
   public int count();
   
   /**
    * A�ade la definici�n de un �ndice.
    * 
    * @param item Definici�n del �ndice
    */
   public void addIdx(ArchiveIdx item) throws Exception;
   
   /**
    * A�ade la definici�n de un �ndice.
    * 
    * @param name Nombre del �ndice
    * @param isUnique true/false
    * @param idsFld Lista con los identificadores de los campos que
    * componen el �ndice
    */
   public void add(String name, boolean isUnique,
         ArrayList idsFld) throws Exception;
   
   /**
    * Obtiene la definici�n del �ndice. 
    * 
    * @param index �ndice de la estructura
    * @return Errores
    */
   public ArchiveIdx get(int index);
   
   /**
    * Obtiene el identificador del �ndice por su nombre.
    * 
    * @param name Nombre del �ndice
    * @return Identificador del �ndice
    * @throws Exception Errores
    */
   public int getIdxIdByName(String name) throws Exception;
   
   /**
    * Obtiene la informaci�n de los �ndices en formato XML.
    *
    * @return La informaci�n mencionada.
    */

   public String toXML(); 

   /**
    * Muestra una representaci�n de los valores de la clase en formato XML.
    *  
    * @return La representaci�n mencionada.
    */

	public String toString();
}
