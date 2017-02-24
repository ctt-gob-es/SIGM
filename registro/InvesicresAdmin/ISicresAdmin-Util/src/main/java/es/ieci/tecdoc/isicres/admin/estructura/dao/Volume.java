package es.ieci.tecdoc.isicres.admin.estructura.dao;

import java.util.ArrayList;
import java.util.Date;

/**
 * Proporciona toda la funcionalidad necesaria para manejar 
 * vol�menes en invesDoc.
 */
public interface Volume
{
	/**
	 * Carga un volumen de invesDoc.
	 * 
	 * @param volId Identificador del volumen.
	 * @throws Exception Si se produce alg�n error al leer la informaci�n del
	 *         volumen.
	 */
	public void load(int volId, String entidad) throws Exception;

	/**
	 * Guarda el volumen. Se utiliza tanto para inserciones como para
	 * actualizaciones.
	 * 
	 * @throws Exception Si se produce alg�n error al guardar. Por ejemplo, el
	 *            volumen ya existe.
	 */
	public void store(String entidad) throws Exception;

	/**
	 * Elimina el volumen.
	 * 
	 * @throws Exception Si se produce alg�n error al eliminar.
	 */
	public void delete(String entidad) throws Exception;
	
	/**
	 * Establece el identificador del repositorio.
	 * 
	 * @param repId El identificador del repositorio.
	 */
	public void setRepId(int repId);
	
	/**
	 * Obtiene el identificador del repositorio.
	 * 
	 * @return El identificador mencionado.
	 */
	public int getRepId();
	
	/**
	 * Obtiene el identificador del repositorio.
	 * 
	 * @return El identificador mencionado.
	 */
	public int getId();
	
	/**
	 * Obtiene el nombre del volumen.
	 * 
	 * @return El nombre mencionado.
	 */
	public String getName();
	
	/**
	 * Establece el nombre del volumen.
	 * 
	 * @param name El nombre del volumen.
	 */
	public void setName(String name);
	
	/**
	 * Obtiene el identificador del tipo de repositorio donde est� 
	 * almacenado el volumen, puede ser PFS, valor 3 o FTP, valor 1.
	 * 
	 * @return El identificador mencionado.
	 */
	public int getRepType();
	
	/**
	 * Obtiene la ruta del volumen relativo a su repositorio.
	 * 
	 * @return El nombre mencionado.
	 */
	public String getPath();
	
	/**
	 * Establece la ruta del volumen relativo a su repositorio.
	 * 
	 * @param path La ruta del volumen.
	 */
	public void setPath(String path);
	
	/**
	 * Obtiene el tama�o m�ximo del volumen en bytes.
	 * 
	 * @return El dato mencionado.
	 */
	public String getMaxSize();
	
	/**
	 * Establece el tama�o m�ximo del volumen en bytes.
	 * 
	 * @param maxSize El tama�o m�ximo mencionado en bytes.
	 */
	public void setMaxSize(String maxSize);
	
	/**
	 * Obtiene la informaci�n de si el volumen es temporal(1) o no(0).
	 * 
	 * @return El valor mencionado.
	 */
	public int getTemp();
	
	/**
	 * Obtiene la ocupaci�n en curso en bytes.
	 * 
	 * @return El valor mencionado.
	 */
	public String getActSize();
	
	/**
	 * Obtiene el n�mero de ficheros en curso del volumen.
	 * 
	 * @return El valor mencionado.
	 */
	public int getNumFiles();
	
	/**
	 * Obtiene el estado del volumen.
	 * 
	 * @return El valor mencionado.
	 */
	public int getState();
	
	/**
	 * Establece el estado del volumen.
	 * 
	 * @param state El estado del volumen.
	 */
	public void setState(int state);
	
	/**
	 * Obtiene los comentarios del volumen.
	 * 
	 * @return El dato mencionado.
	 */
	public String getRemarks();
	
	/**
	 * Establece los comentarios del volumen.
	 * 
	 * @param remarks Los comentarios del volumen.
	 */
	public void setRemarks(String remarks);
	
	/**
	 * Obtiene el identificador del usuario que ha creado el volumen. 
	 * 
	 * @return El identificador mencionado.
	 */
	public int getCreatorId();
	
	/**
    * Obtiene la fecha de creaci�n del volumen.
    *
    * @return La fecha mencionada.
    */
   public Date getCreationDate();
   
   /**
    * Obtiene el identificador del usuario que ha actualizado el volumen.
    *
    * @return El identificador mencionado.
    */
   public int getUpdaterId();
   
   /**
    * Obtiene la fecha de actualizaci�n del volumen.
    *
    * @return La fecha mencionada.
    */
   public Date getUpdateDate();
   
   /**
    * Obtiene los idientificadores de las lista a las que est� asociado el
    * volumen
    * @param volId    Identificador de volumen
    * @param listIds  Array de identificadores de lista
    * @throws Exception
    */
   public void loadListIds(int volId, ArrayList listIds, String entidad) throws Exception;
   
   /**
	 * Obtiene la informaci�n del volumen en formato XML.
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
