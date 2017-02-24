package es.ieci.tecdoc.isicres.admin.estructura.dao;

import es.ieci.tecdoc.isicres.admin.sbo.idoc.archive.base.ArchiveFldType;

/**
 * Proporciona toda la funcionalidad necesaria para manejar un campo
 * del archivador.
 */

public interface ArchiveFld
{
   /**
    * Obtiene el identificador del campo
    *
    * @return dicho identificador
    */
   public int getId();

   /**
    * Obtiene el nombre del campo
    *
    * @return dicho nombre
    */
   public String getName();

   /**
    * Establece el nombre del campo
    *
    * @param name  nombre del campo
    */
   public void setName(String name);

   /**
    * Obtiene la descripci�n
    *
    * @return descripci�n
    */
   public String getRemarks();

   /**
    * Establece la descripci�n del campo
    *
    * @param remarks descripci�n
    */
   public void setRemarks(String remarks);
   /**
    * Obtiene el nombre de la columna en base de datos
    * referente al campo
    *
    * @return nombre de columna
    */
   public String getColName();

   /**
    * Obtiene el tipo de campo en base de datos
    *
    *
    * @return Tipo de campo.
    * @see ArchiveFldType
    *
    */
   public int getType();

   /**
    * Establece el tipo de campo.
    *
    *@param type tipo de campo
    */
   public void setType(int type);


   /**
    * Obtiene la longitud del campo.
    *
    * @return Longitud mencionada.
    */
   public int getLen();

   /**
    * Establece la longitud de un campo.
    *
    * @param len longitud
    */
   public void setLen(int len);

   /**
    * Obtiene la nulidad del campo.
    *
    * @return true / false
    */
   public boolean isNullable();

   /**
    * Establece si un campo es obligatorio o no
    *
    * @param nullable true / false
    */
   public void setNullable(boolean nullable);

   /**
    * Obtiene si el campo tiene b�squeda documental.
    *
    * @return true / false
    */
   public boolean isDoc();

   /**
    * Establece o no la b�squeda documental de un campo.
    *
    * @param isDoc  true / false
    */
   public void setDoc(boolean isDoc);

   /**
    * obtiene si el campo es multivalor.
    *
    * @return true / false
    */
   public boolean isMult();

   /**
    * Establece si un campo es multivalor o no
    *
    * @param mult  true / false
    */
   public void setMult(boolean mult);

   /**
    * Obtiene si el campo es relacional.
    *
    * @return true / false
    */
   public boolean isRel();

   /**
    * Obtiene si el campo es extendido.
    *
    * @return true / false
    */
   public boolean isExt();

   /**
    * Obtiene la informaci�n del campo en formato XML.
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
