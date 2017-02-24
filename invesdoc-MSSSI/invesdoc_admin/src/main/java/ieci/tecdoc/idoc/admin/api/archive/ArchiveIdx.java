package ieci.tecdoc.idoc.admin.api.archive;

/**
 * Proporciona toda la funcionalidad necesaria para manejar �ndice. 
 */
import java.util.ArrayList;

public interface ArchiveIdx
{
   /**
    * Obtiene el identificador del �ndice
    * 
    * @return El identificador
    */
   public int getId();
   
   /**
    * Obtiene el nombre del �ndice
    * 
    * @return El nombre
    */
   public String getName();
   
   
   /**
    * Obtiene si el �ndice es �nico � no
    * 
    * @return (true/false)
    */
   public boolean isUnique();
   
   /**
    * Obtiene una lista de enteros (Integer) con los identificadores
    * de los campos que componen el �ndice
    * 
    * @return Lista de identificadores de campos
    */
   public ArrayList getFldsId();
   
   /**
    * Establece una lista de enteros (Integer) con los identificadores
    * de los campos que componene el �ndice
    * 
    * @param idsFld Lista de identificadores de campos
    */
   public void setFldsId(ArrayList fldsId);
   
   /**
    * Obtiene la informaci�n del �ndice en formato XML.
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
