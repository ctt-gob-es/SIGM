package es.ieci.tecdoc.isicres.admin.estructura.dao;


/**
 * Maneja la lista de volumenes de invesDoc.
 */
public interface Volumes
{

   /**
    * Devuelve el n�mero de vol�menes.
    *
    * @return El n�mero de vol�menes mencionado.
    */

   public int count();

   /**
    * Carga la lista de vol�menes de un repositorio con su informaci�n b�sica.
    *
    * @throws Exception Si se produce alg�n error en la carga de los vol�menes.
    */

   public void loadByRep(int repId, String entidad) throws Exception;

   /**
    * Carga la lista de vol�menes de una lista de vol�menes con su informaci�n b�sica.
    *
    * @throws Exception Si se produce alg�n error en la carga de los vol�menes.
    */

   public void loadByVolumeList(int listId, String entidad) throws Exception;

   /**
    * Devuelve un volumen de la lista.
    *
    * @param index Indice del volumen que se desea recuperar.
    *
    * @return El volumen mencionado.
    */

   public Volume getVolume(int index) throws Exception;

   /**
    * Obtiene la informaci�n de la lista de vol�menes en formato XML.
    *
    * @return La lista de vol�menes mencionada.
    */

   public String toXML();

   /**
    * Muestra una representaci�n de los valores de la clase en formato XML.
    *
    * @return La representaci�n mencionada.
    */

	public String toString();

	/**
	 * A�ade un volumen a la lista.
	 *
	 * @param volume Volumen que se quiere a�adir.
	 */
	public void add(Volume volume);

	/**
    * Elimina un volumen de la lista.
    *
    * @param volId Identificador del volumen a eliminar.
    */
   public void remove(int volId) throws Exception;


}
