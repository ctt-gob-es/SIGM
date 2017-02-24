
package es.ieci.tecdoc.isicres.admin.estructura.dao;

/**
 * Maneja los permisos de un usuario, grupo o departamento. Cada permiso es una 
 * terna compuesta por: <br> [Identificador de objeto, Identificador de 
 * producto, Permiso]. <br> El establecemiento de varios permisos se realiza 
 * mediante la uni�n de todos los valores a trav�s de la sentencia <b>|</b>.
 * @see ISicresAdminUserDefsKeys 
 */

public interface Permission 
{
   /**
    * Devuelve el identificador del objeto.
    * 
    * @return El identificador mencionado.
    */

   public int getId();
   
   /**
    * Devuelve el identificador del destinatario de los permisos.
    * 
    * @return El destinatario mencionado.
    *  
    */

   public int getDestination();
   
   /**
    * Devuelve el identificador del producto al que se asigna el permiso.
    * 
    * @return El identificador mencionado.
    */

   public int getProduct();
   
   /**
    * Devuelve el permiso.
    * 
    * @return El permiso mencionado.
    */

   public int getPermission();
   
   /**
    * Establece el permiso.
    * 
    * @param permission El permiso mencionado.
    *  
    */

   public void setPermission(int permission); 

   /**
    * Obtiene la informaci�n del permiso en formato XML.
    *  
    * @param header Indica si hay que incluir la cabecera xml o no.
    * @return La informaci�n mencionada.
    */

   public String toXML(boolean header); 
   
   /**
    * Muestra una representaci�n de los valores de la clase en formato XML.
    *  
    * @return La representaci�n mencionada.
    */

	public String toString();

}