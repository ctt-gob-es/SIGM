package ieci.tecdoc.idoc.admin.api.volume;

import ieci.tecdoc.idoc.admin.internal.VolumeImpl;
import ieci.tecdoc.idoc.admin.internal.VolumesImpl;

/**
 * Maneja la lista de volumenes de invesDoc.
 */
public class Volumes
{
	/**
    * Construye un objeto de la clase.
    *  
    */

   public Volumes()
   {
   	_volumesImpl = new VolumesImpl();
   }

   /**
    * Devuelve el n�mero de vol�menes.
    * 
    * @return El n�mero de vol�menes mencionado.
    */

   public int count() 
   {
      return _volumesImpl.count();
   }

   /**
    * Carga la lista de vol�menes de un repositorio con su informaci�n b�sica.
    * 
    * @throws Exception Si se produce alg�n error en la carga de los vol�menes.
    */

   public void loadByRep(int repId, String entidad) throws Exception 
   {
   	_volumesImpl.loadByRep(repId, entidad);
   }
   
   /**
    * Carga la lista de vol�menes de una lista de vol�menes con su informaci�n b�sica.
    * 
    * @throws Exception Si se produce alg�n error en la carga de los vol�menes.
    */

   public void loadByVolumeList(int listId, String entidad) throws Exception 
   {
   	_volumesImpl.loadByVolumeList(listId, entidad);
   }

   /**
    * Devuelve un volumen de la lista.
    * 
    * @param index Indice del volumen que se desea recuperar.
    * 
    * @return El volumen mencionado.
    */

   public Volume getVolume(int index) throws Exception 
   {
      return _volumesImpl.get(index);
   }
   
   /**
    * Obtiene la informaci�n de la lista de vol�menes en formato XML.
    *  
    * @return La lista de vol�menes mencionada.
    */

   public String toXML()
   {
      return _volumesImpl.toXML(true);
   }

   /**
    * Muestra una representaci�n de los valores de la clase en formato XML.
    *  
    * @return La representaci�n mencionada.
    */

	public String toString()
   {
      return _volumesImpl.toString();
   }
	
	/**
	 * A�ade un volumen a la lista.
	 * 
	 * @param volume Volumen que se quiere a�adir.
	 */ 
	public void add(VolumeImpl volume)
	{
		_volumesImpl.add(volume);
	}
	
	/**
    * Elimina un volumen de la lista.
    * 
    * @param volId Identificador del volumen a eliminar.
    */
   public void remove(int volId) throws Exception
	{
   	_volumesImpl.remove(volId);
   }
   

   private VolumesImpl _volumesImpl;
}
