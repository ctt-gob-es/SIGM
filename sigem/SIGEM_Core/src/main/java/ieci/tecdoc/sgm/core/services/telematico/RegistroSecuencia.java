package ieci.tecdoc.sgm.core.services.telematico;

/**
 * Bean con las propiedades de un n�mero de secuencia de registro.
 * 
 * @author IECISA
 *
 */
public class RegistroSecuencia 
{
   public RegistroSecuencia()
   {
   }
   
	/**
	 * Devuelve el a�o del n�mero de secuencia.
	 * @return String A�o del n�mero de secuencia.
	 */      
   public String getYear()
   {
      return year;
   }
	
   /**
    * Devuelve la etiqueta del n�mero de secuencia.
    * @return String Etiqueta del n�mero de secuencia.
    */		   
   public String getLabel()
   {
      return label;
   }
		
   /**
    * N�mero de secuencia
    * @return int N�mero de secuencia.
    */   		   
   public int getSequence()
   {
      return sequence;
   }
	
   /**
    * Establece el a�o del n�mero de secuencia.
    * @param year A�o del n�mero de secuencia.
    */   	
   public void setYear(String year)
   {
      this.year = year;
   }
   
   /**
    * Establece la etiqueta del n�mero de secuencia.
    * @param label Etiqueta del n�mero de secuencia.
    */      
   public void setLabel(String label)
   {
      this.label = label;
   }

   /**
    * Establece el n�mero de secuencia.
    * @param sequence N�mero de secuencia.
    */   
   public void setSequence(int sequence)
   {
      this.sequence = sequence;
   }

   protected String year;
   protected String label;
   protected int sequence;

   
}