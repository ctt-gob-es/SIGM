package ieci.tecdoc.idoc.admin.api.volume;

import ieci.tecdoc.idoc.admin.internal.VolumeListsImpl;

/**
 * Maneja la lista de la lista de vol�menes de invesDoc.
 */
public class VolumeLists
{
	/**
    * Construye un objeto de la clase.
    *  
    */

   public VolumeLists()
   {
   	_volumeListsImpl = new VolumeListsImpl();
   }

   /**
    * Devuelve el n�mero de lista de vol�menes.
    * 
    * @return El n�mero de lista de vol�menes mencionado.
    */

   public int count() 
   {
      return _volumeListsImpl.count();
   }

   /**
    * Carga la lista de vol�menes con su informaci�n b�sica.
    * 
    * @throws Exception Si se produce alg�n error en la carga de 
    * las listas de vol�menes.
    */

   public void load() throws Exception 
   {
   	_volumeListsImpl.load();
   }

   /**
    * Devuelve una lista de vol�menes de la lista.
    * 
    * @param index Indice de la lista de vol�menes que se desea recuperar.
    * 
    * @return La lista de vol�menes mencionada.
    */

   public VolumeList getVolumeList(int index) throws Exception 
   {
      return _volumeListsImpl.get(index);
   }
   
   /**
    * Obtiene la informaci�n de la lista de la lista de vol�menes en formato XML.
    *  
    * @return La lista mencionada.
    */

   public String toXML()
   {
      return _volumeListsImpl.toXML(true);
   }

   /**
    * Muestra una representaci�n de los valores de la clase en formato XML.
    *  
    * @return La representaci�n mencionada.
    */

	public String toString()
   {
      return _volumeListsImpl.toString();
   }


   private VolumeListsImpl _volumeListsImpl;
}
