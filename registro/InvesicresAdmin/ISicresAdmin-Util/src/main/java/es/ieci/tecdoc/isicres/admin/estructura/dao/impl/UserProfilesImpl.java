
package es.ieci.tecdoc.isicres.admin.estructura.dao.impl;

import java.util.ArrayList;

import es.ieci.tecdoc.isicres.admin.core.xml.lite.XmlTextBuilder;
import es.ieci.tecdoc.isicres.admin.estructura.dao.UserProfile;
import es.ieci.tecdoc.isicres.admin.estructura.dao.UserProfiles;
import es.ieci.tecdoc.isicres.admin.estructura.keys.ISicresAdminUserKeys;
import es.ieci.tecdoc.isicres.admin.exception.ISicresAdminBasicException;

public class UserProfilesImpl implements UserProfiles
{

   public UserProfile getProductProfile(int productId) throws Exception
   {
      int counter;
      UserProfile profile = null;
      boolean found = false;

      for (counter = 0; counter < count(); counter++)
      {
         profile = get(counter);
         if (profile.getProduct() == productId)
         {
            found = true;
            break;
         }
      }

      if (!found)
         ISicresAdminBasicException.throwException(ISicresAdminUserKeys.
                                       EC_USER_NOT_PROFILE_FOR_PRODUCT);

      return profile;
   }

   public String toXML(boolean header)
   {
      XmlTextBuilder bdr;
      String tagName = "Profiles";
      UserProfile profile;

      bdr = new XmlTextBuilder();
      if (header)
         bdr.setStandardHeader();

      bdr.addOpeningTag(tagName);

      for (int i = 0; i < count(); i++)
      {
         profile = get(i);
         bdr.addFragment(profile.toXML(header));
      }

      bdr.addClosingTag(tagName);

      return bdr.getText();
   }

	public String toString()
	{
      return toXML(false);
   }

   /**
    * Construye un objeto de la clase.
    *
    */

   public UserProfilesImpl()
   {
      list = new ArrayList();
   }

   /**
    * Devuelve el n�mero de perfiles.
    *
    * @return El n�mero de perfiles mencionado.
    */

   public int count()
   {
      return list.size();
   }

   /**
    * Devuelve un perfil de la lista.
    *
    * @param index
    *           Indice del perfil que se desea recuperar.
    *
    * @return El perfil mencionado.
    */

   public UserProfile get(int index)
   {
      return (UserProfile)list.get(index);
   }

   /**
    * Cambia el identificador de usuario de todos los elementos de la lista.
    *
    * @param id El identificador mencionado.
    *
    */

   protected void setId(int id)
   {
      int counter;

      for (counter = 0; counter < count(); counter++)
      {
         ((UserProfileImpl)get(counter)).setId(id);
      }
   }

   /**
    * A�ade un perfiles a la lista. Uso interno. No usar.
    *
    * @param profile
    *           El perfil mencionado.
    *
    */

   public void add(UserProfile profile)
   {
      list.add(profile);
   }

   public void clear(){
	   list.clear();
   }

    private ArrayList list;
}