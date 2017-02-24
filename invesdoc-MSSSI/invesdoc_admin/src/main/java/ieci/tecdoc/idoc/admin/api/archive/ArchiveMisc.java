package ieci.tecdoc.idoc.admin.api.archive;

public interface ArchiveMisc
{
   
   /**
    * Obtiene el t�tulo de las carpetas.
    * 
    * @return T�tulo mencionado
    */
   public String getFdrName();
   
   /**
    * Establece el t�tulo de las carpetas
    * 
    * @param fdrName T�tulo mencionado
    */
   public void setFdrName(String fdrName);
      
   /**
    * Obtiene el identificador de la lista de vol�menes.
    * 
    * @return Identificador mencionado
    */
   public int getVolListId();   
   
   
   /**
    * Establece el identificador de la lista de vol�menes.
    * 
    * @param volListId Identificador de la lista de vol�menes
    */
   public void setVolListId(int volListId);
   
   
   /**
    * Obtiene el tipo de lista de vol�menes.
    * 
    * @return Tipo uno de: ArchiveVolListType.STATIC
    * 						  ArchiveVolListType.NONE
    *                       
    */
   public int getVolListType();
   
   /**
    * Establece el tipo de lista de vol�menes.
    * 
    * @param volListType Tipo (Ej: ArchiveVolListType.STATIC) 
    * 
    */
   public void setVolListType(int volListType);
   
   
   /**
    * Establece los datos referenciados en los par�metros.
    * 
    * @param fdrName T�tulo de las carpetas
    * @param volListId Lista de vol�menes
    * @param volListType Tipo de lista de vol�menes
    */
   public void setMisc(String fdrName, int volListId, int volListType);
   
   /**
    * Obtiene la informaci�n de miscel�nea en formato XML.
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
