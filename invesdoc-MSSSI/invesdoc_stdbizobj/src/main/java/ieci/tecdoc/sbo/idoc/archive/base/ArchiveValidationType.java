
package ieci.tecdoc.sbo.idoc.archive.base;

/**
 * Tipos de validaci�n
 * @author
 */
	
public final class ArchiveValidationType
{
   
   /**
    * Sin validaci�n
    */      
   public static final int NONE            = 0;
   
   /**
    * Validaci�n simple: el valor debe estar dentro de un conjunto de valores
    */
   public static final int TBL_SIMPLE      = 1;
   
   /**
    * Validaci�n con identificador: el valor debe estar dentro de un conjunto de valores
    * cada uno de los cuales esta relacionado con un identificador que es que realmente
    * se guarda en base de datos
    */
   public static final int TBL_ID          = 2;
   
   /**
    * Validaci�n con sustituto: el valor debe estar dentro de un conjunto de valores cada
    * uno de los cuales esta asociado con otro valor que es el que realmente se guarda
    * en base de datos
    */
   public static final int TBL_SUST        = 3;
   
   /**
    * Validaci�n jer�rquica: define una relaci�n entre los valores de dos campos a trav�s
    * de una tercera tabla que relaciona dichos valores. Un ejemplo ser�a por ejemplo
    * una tabla de paises que valida un campo, una tabla de cuidades que validad otro campo,
    * y otra tabla que relaciona los paises con las cuidades
    */
   public static final int TBL_HIERARCHIC  = 4;
   
   /**
    * Validaci�n num�rica
    */
   public static final int AUTONUM         = 7;
    
   private ArchiveValidationType()
   {
   }
   
} // class
