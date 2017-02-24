/*
 * Created on 13-may-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package ieci.tecdoc.sbo.idoc.api;

import java.util.ArrayList;

import ieci.tecdoc.sbo.idoc.folder.search.FolderSearchQuery;


/**
 * Clase que encapusula los filtros de b�squeda de carpetas dentro de un
 * archivador y el conjunto de campos por los cuales se ordena los resultados
 * de una b�squeda.
 * <p>
 * Existen los siguientes operadores:
 * <li> IN_AND: todos los valores se encuentran en la colecci�n de valores
 * de un campo multivalor
 * <li> IN_OR: algunos valores se encuentran en la colecci�n de valores
 * de un campo multivalor
 * <li> LIKE_AND: todos los valores son como alguno de la colecci�n de valores
 * de un campo multivalor
 * <li> LIKE_OR: algunos valores son como alguno de la colecci�n de valores
 * de un campo multivalor
 * <li> EQUAL: igual
 * <li> DISTINCT: distinto
 * <li> GREATER: mayor que
 * <li> GREATER_EQUAL: mayor o igual que
 * <li> LOWER: menor
 * <li> LOWER_EQUAL: menor que 
 * <li> BETWEEN: entre dos valores
 * <li> LIKE: como
 * <li> OR: o
 * <li> FULL_TEXT: b�squeda documental dentro de un campo relacional. La expresi�n
 * documental de b�squeda se cumple.
 * <li> FULL_TEXT_NOT: b�squeda documental dentro de un campo relacional. La expresi�n
 * documental de b�squeda no se cumple.   
 */
public final class FolderSearchQueryObject
{
   private FolderSearchQuery m_query;

   /**
    * Constructor 
    * @param arch archivador sobre el que se va a realizar la 
    * b�squeda
    */
   public FolderSearchQueryObject(ArchiveObject arch)
   {
      m_query = new FolderSearchQuery(arch.getArchiveToken());
   }
   /**
    * A�ade el campo identificador de la carpeta al conjunto de campos por los cuales
    * de va a ordenar la b�squeda
    * @param desc la b�squeda es descendente
    * @throws Exception si se produce alg�n error al a�adir el campo identificador
    */
   public void addFdrIdSearchOrder(boolean desc) throws Exception
   {
      m_query.addFdrIdSearchOrder(desc);
   }

   /**
    * A�ade una condici�n de b�squeda en contenido de documentos
    * @param condition expresi�n de b�squeda documental   
    * @throws Exception si se produce alg�n error al a�adir la condicion de b�squeda
    */   
   public void addFTSSearchCondition(String condition) throws Exception
   {
      m_query.addFTSSearchCondition(condition);
   }
   
   /**
    * A�ade una condici�n de b�squeda para un determinado campo del archivador 
    * @param fldId identificador del campo del archivador
    * @param opr operador de b�squeda
    * @param vals valores del campo  
    * @throws Exception si se produce alg�n error al a�adir la condicion de b�squeda
    */   
   public void addSearchCondition(int fldId, String opr, ArrayList vals)
            throws Exception
   {
      m_query.addSearchCondition(fldId, opr, vals);
   }

   /**
    * A�ade una condici�n de b�squeda para un determinado campo del archivador 
    * @param fldId identificador del campo del archivador
    * @param opr operador de b�squeda
    * @param val valor del campo  
    * @throws Exception si se produce alg�n error al a�adir la condicion de b�squeda
    */         
   public void addSearchCondition(int fldId, String opr, Object val)
            throws Exception
   {
      m_query.addSearchCondition(fldId, opr, val);
   }

   /**
    * A�ade una condici�n de b�squeda para un determinado campo del archivador 
    * @param fldId identificador del campo del archivador
    * @param opr operador de b�squeda
    * @param val valor del campo  
    * @throws Exception si se produce alg�n error al a�adir la condicion de b�squeda
    */            
   public void addSearchCondition(int fldId, String opr, String val)
            throws Exception
   {
      m_query.addSearchCondition(fldId, opr, val);
   }

   /**
    * A�ade una condici�n de b�squeda para un determinado campo del archivador 
    * @param fldId identificador del campo del archivador
    * @param opr operador de b�squeda
    * @param vals valores del campo  
    * @throws Exception si se produce alg�n error al a�adir la condicion de b�squeda
    */            
   public void addSearchCondition(int fldId, String opr, String[] vals)
            throws Exception
   {
      m_query.addSearchCondition(fldId, opr, vals);
   }

   /**
    * A�ade una condici�n de b�squeda para un determinado campo del archivador 
    * @param fldName nombre del campo del archivador
    * @param opr operador de b�squeda
    * @param vals valores del campo  
    * @throws Exception si se produce alg�n error al a�adir la condicion de b�squeda
    */
   public void addSearchCondition(String fldName, String opr, ArrayList vals)
            throws Exception
   {
      m_query.addSearchCondition(fldName, opr, vals);
   }

   /**
    * A�ade una condici�n de b�squeda para un determinado campo del archivador 
    * @param fldName nombre del campo del archivador
    * @param opr operador de b�squeda
    * @param val valor del campo  
    * @throws Exception si se produce alg�n error al a�adir la condicion de b�squeda
    */      
   public void addSearchCondition(String fldName, String opr, Object val)
            throws Exception
   {
      m_query.addSearchCondition(fldName, opr, val);
   }

   /**
    * A�ade una condici�n de b�squeda para un determinado campo del archivador 
    * @param fldName nombre del campo del archivador
    * @param opr operador de b�squeda
    * @param val valor del campo  
    * @throws Exception si se produce alg�n error al a�adir la condicion de b�squeda
    */      
   public void addSearchCondition(String fldName, String opr, String val)
            throws Exception
   {
      m_query.addSearchCondition(fldName, opr, val);
   }

   /**
    * A�ade una condici�n de b�squeda para un determinado campo del archivador 
    * @param fldName nombre del campo del archivador
    * @param opr operador de b�squeda
    * @param vals valores del campo  
    * @throws Exception si se produce alg�n error al a�adir la condicion de b�squeda
    */         
   public void addSearchCondition(String fldName, String opr, String[] vals)
            throws Exception
   {
      m_query.addSearchCondition(fldName, opr, vals);
   }

   /**
    * A�ade un campo dentro del conjunto de campos por los cuales se va a ordenar la
    * b�squeda 
    * @param fldId identificador del campo
    * @param desc la b�squeda es descendente
    * @throws Exception si se produce alg�n error al a�adir el campo
    */   
   public void addSearchOrder(int fldId, boolean desc) throws Exception
   {
      m_query.addSearchOrder(fldId, desc);
   }

   /**
    * A�ade un campo dentro del conjunto de campos por los cuales se va a ordenar la
    * b�squeda 
    * @param fldName nombre del campo
    * @param desc la b�squeda es descendente
    * @throws Exception si se produce alg�n error al a�adir el campo
    */
   public void addSearchOrder(String fldName, boolean desc) throws Exception
   {
      m_query.addSearchOrder(fldName, desc);
   }

   /**
    * Devuelve la cl�usula ORDER BY que define la ordenaci�n de las carpetas resultado
    * de una b�squeda
    * @return cl�usula ORDER BY
    * @throws Exception si se produce alg�n error en la obtenci�n de la cl�usula
    */
   public String getSqlOrderBy() throws Exception
   {
      return m_query.getSqlOrderBy();
   }

   /**
    * Devuelve una cadena que representa las condiciones de b�squeda de carpetas dentro
    * de un archivador y la cl�usula ORDER BY para la ordenaci�n de los resultados de la
    * b�squeda  
    * @param dbEngine tipo de base de datos: 
    * <li> DbEngine.SQLSERVER_STR
    * <li> DbEngine.ORACLE_STR
    * @return condici�n sql y order by 
    * @throws Exception si se produce alg�n error en la obtenci�n de la condici�n y cl�usula 
    * order by
    */   
   public String getSqlQual(int dbEngine) throws Exception
   {
      return m_query.getSqlQual(dbEngine);
   }

   /**
    * Devuelve la condici�n sql que se utilizar� como filtro en la b�squeda de carpetas
    * dentro de un archivador
    * @param dbEngine tipo de base de datos: 
    * <li> DbEngine.SQLSERVER_STR
    * <li> DbEngine.ORACLE_STR
    * @return condici�n sql 
    * @throws Exception si se produce alg�n error en la obtenci�n de la condici�n sql
    */
   public String getSqlWhere(int dbEngine) throws Exception
   {
      return m_query.getSqlWhere(dbEngine);
   }
   
   /**
    * Devuelve el atributo folderSearchQuery que contiene la informaci�n 
    * de la b�squeda 
    * 
    * @return el atributo folderSearchQuery 
    */
   public FolderSearchQuery getFolderSearchQuery() 
   {
      return m_query;
   }
   
   /**
    * @see java.lang.Object#toString()
    */
   public String toString()
   {
      return m_query.toString();
   }
}
