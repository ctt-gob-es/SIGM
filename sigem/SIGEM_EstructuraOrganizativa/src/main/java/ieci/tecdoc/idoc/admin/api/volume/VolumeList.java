package ieci.tecdoc.idoc.admin.api.volume;

import java.util.Date;

/**
 * Proporciona toda la funcionalidad necesaria para manejar listas de
 * vol�menes en invesDoc.
 */
public interface VolumeList
{	
	/**
	 * Carga una lista de vol�menes de invesDoc.
	 * 
	 * @param listId Identificador de la lista.	 
	 * @throws Exception Si se produce alg�n error al leer la informaci�n de 
	 *         la lista.
	 */
	public void load(int listId, String entidad) throws Exception;
	
	/**
	 * Guarda la lista. Se utiliza tanto para inserciones como para
	 * actualizaciones.
	 * 
	 * @throws Exception Si se produce alg�n error al guardar. Por ejemplo, 
	 * la lista ya existe.
	 */
	public void store(String entidad) throws Exception;
	
	/**
	 * Elimina la lista.
	 * 
	 * @throws Exception Si se produce alg�n error al eliminar.
	 */
	public void delete(String entidad) throws Exception;
	
	/**
	 * A�ade un volumen a la lista de vol�menes.
	 * 
	 * @param volId El identificador del volumen.
	 * @throws Exception Si se produce alg�n error al a�adir.
	 */
	public void add(int volId, String entidad) throws Exception;
	
	/**
	 * Elimina un volumen de la lista de vol�menes.
	 * 
	 * @param volId El identificador del volumen.
	 * @throws Exception Si se produce alg�n error al eliminar.
	 */
	public void deleteVolume(int volId, String entidad) throws Exception;
	
	/**
	 * Establece el orden de un volumen detro de una lista de vol�menes
	 * 
	 * @param listId Idenficador de la lista de vol�menes
	 * @param volId  Identificador del volumen
	 * @param sortOrder Orden a establece
	 * @throws Exception Si se produce error
	 */
	public void setVolumeSortOrder(int listId, int volId, int sortOrder, String entidad) throws Exception;
	
	/**
	 * Obtiene el orden del volumen dentro de una lista de vol�menes
	 * 
	 * @param listId Identificador de la lista de vol�menes
	 * @param volId Identificador del volumen
	 * @return  Orden del volument dentro de la lista de vol�menes
	 * @throws Exception Si se produce error
	 */
	public int getVolumeSortOrder(int listId, int volId, String entidad) throws Exception;
	
	/**
	 * Obtine el identificador de la lista de vol�menes
	 * 
	 * @return El identificador mencionado
	 */
	public int getId();
	
	/**
    * Obtiene el nombre de la lista de vol�menes.
    *
    * @return El nombre mencionado.
    */
	public String getName();
	/**
	 * Establece el nombre de la lista de vol�menes.
	 * 
	 * @param name Nombre de la lista.
	 */
	public void setName(String name);
	
	/**
    * Obtiene los flags de la lista de vol�menes.
    *
    * @return El dato mencionado.
    */
	public int getFlags();
	
	/**
    * Obtiene el estado de la lista de vol�menes.
    *
    * @return El dato mencionado.
    */
	public int getState();
	
	/**
	 * Establece el estado de la lista de vol�menes.
	 * 
	 * @param state El estado de la lista.
	 */
	public void setState(int state);
	
	/**
	 * Obtiene los comentarios de la lista de vol�menes.
	 * 
	 * @return El dato mencionado.
	 */
	public String getRemarks();
	
	/**
	 * Establece los comentarios de la lista de vol�menes.
	 * 
	 * @param remarks Los comentarios de la lista.
	 */
	public void setRemarks(String remarks);
	
	/**
	 * Obtiene el identificador del usuario que ha creado 
	 * la lista de vol�menes. 
	 * 
	 * @return El identificador mencionado.
	 */
	public int getCreatorId();
	
	/**
    * Obtiene la fecha de creaci�n de la lista de vol�menes.
    *
    * @return La fecha mencionada.
    */
   public Date getCreationDate();
   
   /**
    * Obtiene el identificador del usuario que ha actualizado 
    * la lista de vol�menes.
    *
    * @return El identificador mencionado.
    */
   public int getUpdaterId();
   
   /**
    * Obtiene la fecha de actualizaci�n de la lista de vol�menes.
    *
    * @return La fecha mencionada.
    */
   public Date getUpdateDate();
   
   /**
    * Obtiene una lista de identificadores de vol�menes.
    * No es necesario cargar el objeto antes.
    * 
    * @param id Identificador de la lista de vol�menes.
    * @return La lista mencionada.
    */
   public Volumes getVolumes(int id, String entidad) throws Exception;
   
   /**
	 * Obtiene la informaci�n de la lista de vol�menes en formato XML.
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
