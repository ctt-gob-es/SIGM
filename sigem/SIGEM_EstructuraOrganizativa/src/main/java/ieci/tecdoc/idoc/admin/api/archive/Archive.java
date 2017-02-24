
package ieci.tecdoc.idoc.admin.api.archive;

import java.util.Date;
import ieci.tecdoc.idoc.admin.api.user.BasicUsers;

/**
 * Proporciona toda la funcionalidad necesaria para manejar un archivador. 
 */

public interface Archive 
{
      
   /**
    * Carga un archivador.
    * 
    * @param id Identificador del archivador.
    * @throws Exception Si se produce alg�n error al leer la informaci�n del 
    * archivador.
    */

   public void load(int id, String entidad) throws Exception;
   
   
   /**
    * Crea el archivador.
    * 
    * @throws Exception Si se produce alg�n error al crear. Por ejemplo, 
    * el archivador ya existe.
    */

   public void create(String entidad) throws Exception;
   
   /**
    * Elimina el archivador cargado    
    * 
    * @throws Exception Si se produce alg�n error al eliminar
    */
   public void delete(String entidad) throws Exception;
   
   /**
    * Elimina el archivador indicado
    * 
    * @param archiveId Identificador del archivador 
    * @throws Exception
    */
   public void delete(int archiveId, String entidad) throws Exception;
      
   /**
    * Actualiza la informaci�n del archivador. 
    * 
    * @param updInfo Estructura con la totalidad de la informaci�n
    * @throws Exception Si se produce alg�n error al actualizar
    */   
   public void update(ArchiveUpdInfo updInfo, String entidad) throws Exception;
   
   
   /**
    * Actualiza el padre para el archivador indicado
    * no hace falta que se realice una carga del archivador.
    * 
    * @param parentId Identificador del padre
    * @param archiveId Identificador del archivador
    * @throws Exception Si se produce alg�n error al actualizar
    */
   public void updateParentId(int parentId, int archiveId, String entidad) throws Exception;
   
    /**
    * Indica si se est� trabando con usuarios de un repositorio Ldap (true) o
    * no (false).
    *
    * @param ldap Si se trata de usuarios Ldap o no.
    */
    
   public void setLdap(boolean ldap);
   

   /**
    * Obtiene el identificador del archivador.
    *
    * @return El identificador mencionado.
    */
   public int getId();
   
   /**
    * Establece el identificador del archivador.
    *
    * @param name El identificador del archivador.
    */
   public void setId(int archId);
   
   /**
    * Obtiene el tipo del archivador.
    *
    * @return El tipo mencionado.
    */
   public int getType();
   
   /**
    * Establece el tipo del archivador.
    *
    * @param name El tipo del archivador.
    */
   public void setType(int archType);
      
   /**
    * Obtiene el nombre del archivador.
    *
    * @return El nombre mencionado.
    */    
   public String getName();
   
   /**
    * Establece el nombre del archivador.
    *
    * @param name El nombre mencionado.
    */    
   public void setName(String name);
   
   /**
    * Obtiene el identificador del directorio padre del archivador cargado
    * 
    * @return El identificador del directorio padre
    */
   public int getParentId();
   
   /**
    * Obtiene el identificador del directorio padre del archivador
    * 
    * @param archiveId Identificador del archivador
    * 
    * @return El identificador del directorio padre
    * @throws Exception
    */
   public int getParentId(int archiveId, String entidad) throws Exception;

   /**
    * Obtiene la descripci�n del archivador.
    *
    * @return La descripci�n mencionada.
    */    
   public String getRemarks();
   
   
   /**
    * Establece la descripci�n del archivador.
    *
    * @param remarks La descripci�n mencionada.
    */
    
   public void setRemarks(String remarks);
   
   /**
    * Obtiene el identificador del administrador del archivador
    * 
    * @return El identificador mencionado.
    */
   public int getAdminUserId();
   
      
   /**
    * Obtiene si hay b�squeda en contenido de fichero para el archivador
    * 
    * @return true / false
    */
   public boolean isFtsInContents();
   
   
   /**
    * Estable la existencia o no de b�squeda en contenido de fichero para
    * el archivador
    * 
    * @param ftsInContents (true /false)
    */
   public void setFtsInContents(boolean ftsInContents);
   
   
   /**
    * Obtiene el tipo de acceso del archivador.
    *
    * @return El tipo de acceso mencionado.
    */
    
   public int getAccessType();
   
   
   /**
    * Obtiene el identificador de acceso del archivador.
    * 
    * @return El identificador mencionado.
    */   
   public int getAcsId();
   
   
   /**
    * Obtiene el identificador del usuario que ha creado del archivador.
    *
    * @return El identificador mencionado.
    */    
   public int getCreatorId();
   
   /**
    * Obtiene la fecha de creaci�n del archivador.
    *
    * @return La fecha mencionada.
    */    
   public Date getCreationDate();
   
   /**
    * Obtiene el identificador del usuario que ha actualizado el archivador.
    *
    * @return El identificador mencionado.
    */    
   public int getUpdaterId();
   
   /**
    * Obtiene la fecha de actualizaci�n del archivador.
    *
    * @return La fecha mencionada.
    */    
   public Date getUpdateDate();
   
   
   /**
    * Establece informaci�n referente a la definici�n de campos
    * del archivador
    *
    *  @param Estructura con la informaci�n mencionada.
    */
   public void setFldsDef(ArchiveFlds fldsArch);
	
   
   /**
    * Obtiene informaci�n referente a la definici�n de campos 
    * del archivador.
    * 
    * @return Estructura con la informaci�n mencionada.
    */
   public ArchiveFlds getFldsDef();
   
	
   /**
    * Establece informaci�n referente a la definici�n de �ndices
    * del archivador.
    *
    * @param Estructura con la informaci�n mencionada. 
    */   
	public void setIdxsDef(ArchiveIdxs idxsArch);
	
	
	/**
	 * Obtiene informaci�n referente a la definici�n de �ndices del
	 * archivador.
	 * 
	 * @return Estructura con la informaci�n mencionada.
	 */
	public ArchiveIdxs getIdxsDef();
	
		
	/**
    * Establece informaci�n referente a lista de vol�menes
    * y t�tulo de carpeta del archivador.
    *
    * @param Estructura con la informaci�n mencionada.
    */
	public void setMiscDef(ArchiveMisc miscArch);
	

	/**
	 * Obtiene informaci�n referente a lista de vol�menes
	 * y t�tulo de carpeta del archivador.
	 * 
	 * @return Estructura con la informaci�n mencionada.
	 */
   public ArchiveMisc getMiscDef();
   
   
   /**
    * Obtiene la lista de usuarios (identificadores y nombres) que pueden ser
    * administradores de este archivador.
    * 
    * @return La lista mencionada. 
    */    
   public BasicUsers getAdminUsers();
   
      
   /**
    * Obtiene si existen carpetas dadas de alta en el archivador
    * 
    * @return true / false
    * @throws Exception
    */
   public boolean existsFdrsInArch(String entidad) throws Exception;
   
   /**
    * Obtiene la informaci�n del directorio en formato XML.
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