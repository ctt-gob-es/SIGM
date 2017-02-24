
package es.ieci.tecdoc.isicres.admin.estructura.dao.impl;

/**
 * Proporciona toda la funcionalidad necesaria para manejar �ndices.
 */

import java.util.ArrayList;

import es.ieci.tecdoc.isicres.admin.core.xml.lite.XmlTextBuilder;
import es.ieci.tecdoc.isicres.admin.estructura.dao.ArchiveIdx;
import es.ieci.tecdoc.isicres.admin.estructura.dao.ArchiveIdxs;
import es.ieci.tecdoc.isicres.admin.estructura.keys.ISicresAdminArchiveKeys;
import es.ieci.tecdoc.isicres.admin.estructura.keys.ISicresAdminDefsKeys;
import es.ieci.tecdoc.isicres.admin.exception.ISicresAdminBasicException;

public class ArchiveIdxsImpl implements ArchiveIdxs
{

   public ArchiveIdxsImpl()
   {
      m_al = new ArrayList();
   }

   /**
    * Inicializa la estructura de �ndices
    */
   public void clear()
   {
      m_al.clear();
   }

   /**
    * Obtiene el n�mero de �ndices en la estructura.
    *
    * @return N�mero de �ndices
    */
   public int count()
   {
      return m_al.size();
   }

   /**
    * A�ade la definici�n de un �ndice.
    *
    * @param item Definici�n del �ndice
    */
   public void addIdx(ArchiveIdx item)
   {
      ArchiveIdxImpl idx = null;
      ArrayList      idsFld = new ArrayList();
      ArrayList      fldsId = item.getFldsId();

      for (int i = 0; i < fldsId.size(); i++)
      {
         Integer id = (Integer)fldsId.get(i);
         idsFld.add(new Integer(id.intValue()));
      }

      idx = new ArchiveIdxImpl(item.getId(),item.getName(),item.isUnique(),idsFld);

      m_al.add(idx);
   }

   /**
    * A�ade la definici�n de un �ndice.
    *
    * @param name Nombre del �ndice
    * @param isUnique true/false
    * @param idsFld Lista con los identificadores de los campos que
    * componen el �ndice
    */
   public void add(String name, boolean isUnique,
                   ArrayList idsFld) throws Exception
   {

      ArchiveIdxImpl idx;
      int            idxId;


      if (name.length() == 0)
         ISicresAdminBasicException.throwException(ISicresAdminArchiveKeys.EC_IDX_NAME_NO_VALID);

      if (!isValidName(name))
         ISicresAdminBasicException.throwException(ISicresAdminArchiveKeys.EC_IDX_EXISTS);


      idxId  = getNextIdxId();
      idx = new ArchiveIdxImpl(idxId, name, isUnique,idsFld);

      m_al.add(idx);

   }

   /**
    * Obtiene la definici�n del �ndice.
    *
    * @param index �ndice de la estructura
    * @return Errores
    */
   public ArchiveIdx get(int index)
   {
      return (ArchiveIdx) m_al.get(index);
   }

   /**
    * Obtiene el identificador del �ndice por su nombre.
    *
    * @param name Nombre del �ndice
    * @return Identificador del �ndice
    * @throws Exception Errores
    */
   public int getIdxIdByName(String name) throws Exception
   {
      int            count,i;
      boolean        find = false;
      ArchiveIdxImpl idxDef = null;
      int           idxId = ISicresAdminDefsKeys.NULL_ID;

      count = m_al.size();

      for(i=0; i<count; i++)
      {
         idxDef = (ArchiveIdxImpl)m_al.get(i);
         if (idxDef.getName().equals(name))
         {
            find = true;
            idxId = idxDef.getId();
            break;
         }
      }

      if (!find)
      {
         ISicresAdminBasicException.throwException(ISicresAdminArchiveKeys.EC_IDX_NO_EXISTS);

      }

      return idxId;
   }

   /**
    * Obtiene la informaci�n de los �ndices en formato XML.
    *
    * @return La informaci�n mencionada.
    */
   public String toXML()
   {
      return toXML(true);
   }

   /**
    * Obtiene la informaci�n e los �ndices en formato XML.
    * @param header true / false
    * @return La informaci�n mencionada.
    */
   public String toXML(boolean header)
   {
      XmlTextBuilder bdr;
      String tagName = "Indexs";
      ArchiveIdxImpl idx;

      bdr = new XmlTextBuilder();
      if (header)
         bdr.setStandardHeader();

      bdr.addOpeningTag(tagName);

      for (int i = 0; i < count(); i++)
      {
         idx = (ArchiveIdxImpl)get(i);
         bdr.addFragment(idx.toXML(false));
      }

      bdr.addClosingTag(tagName);

      return bdr.getText();
   }

   /**
    * Muestra una representaci�n de los valores de la clase en formato XML.
    *
    * @return La representaci�n mencionada.
    */

	public String toString()
	{
      return toXML(false);
   }

   /**
    * Obtiene si el nombre del �ndice es v�lido � no
    *
    * @param name - nombre del �ndice
    * @return true / false
    */
   private boolean isValidName(String name)
   {
      boolean valid = true;

      for (int i = 0; i < m_al.size(); i++)
      {
         ArchiveIdxImpl idxDef = (ArchiveIdxImpl)m_al.get(i);
         if (idxDef.getName().equals(name))
         {
            valid = false;
         }
      }

      return valid;
   }

   /**
    * Obtiene el identificador del �ndice
    * @return El identificador
    */
   private int getNextIdxId()
   {
      int            nextId;
      int            count,i;
      ArchiveIdxImpl idxDef = null;

      nextId = 0;
      count = m_al.size();

      for(i=0; i<count; i++)
      {
         idxDef = (ArchiveIdxImpl)m_al.get(i);

         if (nextId < idxDef.getId() )
            nextId = idxDef.getId();
      }

      nextId = nextId + 1;

      return(nextId);
   }

   private ArrayList m_al;
}

