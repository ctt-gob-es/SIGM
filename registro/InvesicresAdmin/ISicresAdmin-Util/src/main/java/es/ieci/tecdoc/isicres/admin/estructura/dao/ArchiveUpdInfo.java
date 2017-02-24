package es.ieci.tecdoc.isicres.admin.estructura.dao;
/**
 * Proporciona toda la funcionalidad necesaria para manejar la actualizaci�n
 * de la informaci�n de un archivador. 
 */

import java.util.ArrayList;


public interface ArchiveUpdInfo
{

   /**
    * Establece el nombre del archivador.
    * 
    * @param name Nombre
    */
   public void setName(String name);
   
   /**
    * Obtiene el nombre del archivador.
    * 
    * @return Nombre
    */
   public String getName();
   
   /**
    * Establece la descripci�n del archivador.
    * 
    * @param remarks Descripci�n
    */
   public void setRemarks(String remarks);
   
   /**
    * Obtiene la descripci�n del archivador.
    * 
    * @return Descripci�n
    */
   public String getRemarks();
   
   /**
    * Establece el administrador del archivador.
    * 
    * @param adminUserId Identificador
    */
   public void setAdminUserId(int adminUserId);
   
   /**
    * Obtiene el administrador del archivador.
    * 
    * @return Identificador
    */
   public int getAdminUserId();
   
   /**
    * Obtiene si hay b�squeda en contenido de fichero en el archivador.
    * 
    * @return true / false
    */
   public boolean isFtsInContents();
   
      
   /**
    * Establece la existencia o no de b�squeda en contenidoc de fichero en
    * el archivador.
    * 
    * @param ftsInContents true / false
    */
	public void setFtsInContents(boolean ftsInContents);
	
	/**
	 * Establece la estructura de la definici�n de campos debe contener
	 * la informaci�n de los antiguos y los nuevos.
	 * 
	 * @param fldsDef Estructura de campos.
	 * @see ArchiveFlds
	 */
   public void setFldsDef(ArchiveFlds fldsDef) throws Exception;
   
   /**
    * Obtiene la estructura de la definici�n de los campos del archivador.
    * 
    * @return Estructura de campos
    */
   public ArchiveFlds getFldsDef();
   
   /**
    * Establece la estructura de la definici�n de �ndices del archivador, debe
    * contener la informaci�n de loa antiguos y de los nuevos.
    * 
    * @param idxsDef Estructura de �ndices
    */
   public void setIdxsDef(ArchiveIdxs idxsDef);
   
   
   /**
    * Obtiene la estructura de la definici�n de �ndices.
    * 
    * @return Estructura de �ndices
    */
   public ArchiveIdxs getIdxsDef();
   
   /**
    * Establece la informaci�n del t�tulo de carpetas y lista de vol�menes 
    * asociada, si no se cambia debe contener la informaci�n antigua.
    * 
    * @param miscDef Informaci�n mencionada
    */
   public void setMiscDef(ArchiveMisc miscDef);
   
   /**
    * Obtiene la informaci�n del t�tulo de carpetas y lista de vol�menes 
    * asociada.
    * 
    * @return Informaci�n
    */
   public ArchiveMisc getMiscDef();
   
   /**
    * Obtiene los identificadores de los �ndices eliminados.
    * 
    * @return Lita con los identificadores
    */
   public ArrayList getDeleteIdxs();
   
   /**
    * Obtiene los identificadores de los �ndices a�adidos.
    * 
    * @return Lista con los identificadores
    */
   public ArrayList getNewIdx();
   
   /**
    * Obtiene los identificadores de los campos eliminados.
    * 
    * @return Lista con los identificadores
    */
   public ArrayList getDeleteFlds();
   
   /**
    * Obtiene los identificadores de los campos a�adidos.
    * 
    * @return Lista con los identificadores
    */
   public ArrayList getNewFlds();
   
   
   /**
    * Establece un array de campos creador, otro de campos eliminados,
    * Si se ha modificado la definici�n de campos referente a tipo, longitud,
    * documental,obligatorio � multivalor el par�metro isModifyDefFlds deber�a se
    * true.
    * 
    * @param newFldsId Lista con identificadores de campos nuevos
    * @param delFldsId Lista con identificadores de campos eliminados
    * @param isModifyDefFlds true / false
    */
   public void setUpdateFlds(ArrayList newFldsId, ArrayList delFldsId, boolean isModifyDefFlds);
   
   
   /**
    * Establece un array de �ndices creados, otro de �ndices eliminados.
    * 
    * @param newIdxsId Lista con los identificadores de los �ndices nuevos.
    * @param delIdxsId Lista con los identificadores de los �ndices eliminados.
    */
   public void setUpdateIdxs(ArrayList newIdxsId, ArrayList delIdxsId);
   
   /**
    * Establece si se ha modificado � no la definici�n de los campos referente a
    * tipo, longitud, documental, obligatorio � multivalor, si alguno de estos valores
    * se ha modificador el par�metro deber�a ser true.
    * 
    * @param modify - true / false
    */
   public void ModifyDefFlds(boolean modify);
   
   
   /**
    * Obtiene si se ha modificado la definici�n de los campos.
    * 
    * @return true / false
    */
   public boolean isModifyDefFlds();
   
   /**
    * Establece si se ha modificado � no la lista de vol�menes asociada
    * al archivador.
    * 
    * @param modify true / false
    */
   public void ModifyListVols(boolean modify);
   
   /**
    * Obtiene si la lista de v�lumenes ha sido modificada.
    * 
    * @return true / false 
    */
   public boolean isModifyListVols();
   
}
