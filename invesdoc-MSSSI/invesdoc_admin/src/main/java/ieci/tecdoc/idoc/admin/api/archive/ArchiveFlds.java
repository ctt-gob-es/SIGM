package ieci.tecdoc.idoc.admin.api.archive;

/**
 * Proporciona toda la funcionalidad necesaria para manejar campos de un archivador. 
 */

import ieci.tecdoc.idoc.admin.internal.ArchiveFldsImpl;
import ieci.tecdoc.sbo.idoc.archive.base.ArchiveFldType;

public interface ArchiveFlds
{   
   
   /**
    * Inicializa la estructura de campos
    *
    */
   public void clear();
   
   /**
    * Obtiene el n�mero de campos.
    * 
    * @return N�mero mencionado
    */
   public int count();
   
   /**
    * A�ade una definici�n de campo. 
    * 
    * @param fld Definici�n del campo.
    */
   public void addFld(ArchiveFld fld) throws Exception;
   
   /**
    * A�ade una definici�n de campo.
    * (el c�lculo del identificador es interno, nunca tiene que se
    * establecido)
    * 
    * @param name Nombre del campo
    * @param type Tipo del campo (ArchiveFldType)
    * 
    *   
    * @see ArchiveFldType
    * @param len  Longitud del campo en caso de texto y texto largo en
    * otro caso es = 0
    * @param isNullable true /false (posibilidad de tener valores nulos)
    * @param isDoc true / false (documental)
    * @param isMult true /false (multivalor)
    * @param remarks Descripci�n
    * @throws Exception - Errores
    */
   public void add(String name, int type, int len, boolean isNullable,
         			boolean isDoc, boolean isMult, String remarks) throws Exception;
   
   /**
    * Obtiene el identificador del campo a partir del nombre.
    * 
    * @param name Nombre del campo
    * @return Identificador del campo
    * @throws Exception Si no existe el campo
    */
   public int getFldIdByName(String name) throws Exception;
   
   /**
    * Obtiene la definici�n de un campo a partir del identificador.
    * 
    * @param fldId Identificador del campo
    * @return La definici�n mencionada.
    * @throws Exception Si el campo no exite
    */
   public ArchiveFld getFldDefById(int fldId) throws Exception;
   
   /**
    * Obtiene la definici�n de un campo a partir de un �ndice de la colecci�n.
    * 
    * @param index Indice
    * @return La estructura mencionada.
    */
   public ArchiveFld get(int index);
   
   /**
    * Obtiene el n�mero de campos relacionales en la colecci�n.
    * 
    * @return N�mero de campos relacionales
    */
   public int getRelFldsCount();
   
   /**
    * Obtiene el n�mero de campos documentales en la colecci�n.
    * 
    * @return N�mero de campos documentales
    */
   public int getFtsFldsCount();
   
   /**
    * Obtiene una colecci�n con las definiciones de los campos documentales.
    * 
    * @return Colecci�n de campos documentales
    * @throws Exception Errores
    */
   public ArchiveFldsImpl getFtsFlds() throws Exception;
   
   /**
    * Obtiene el n�mero de campos multivalores en la colecci�n.
    * 
    * @return N�mero de campos multivalores
    */
   public int getMultFldsCount();
   
   /**
    * Obtiene la informaci�n de los campos en formato XML.
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
