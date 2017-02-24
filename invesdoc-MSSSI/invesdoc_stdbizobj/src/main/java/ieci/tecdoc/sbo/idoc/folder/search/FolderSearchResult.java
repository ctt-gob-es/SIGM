package ieci.tecdoc.sbo.idoc.folder.search;

import java.io.Serializable;

import ieci.tecdoc.core.collections.IeciTdLongIntegerArrayList;
import ieci.tecdoc.core.exception.IeciTdException;


import org.apache.log4j.Logger;

/**
 * Este m�todo encapsula los resultados de una b�squeda de carpetas. Los
 * resultados corresponden con los identificadores de las carpetas
 * @author
 */

public final class FolderSearchResult implements Serializable
{      
   /**
    * Coleccion de identificadores de carpetas
    */
   private IeciTdLongIntegerArrayList m_fdrIds;
   
   /**
    * Logger
    */
   private static Logger logger = Logger.getLogger( FolderSearchResult.class );
    
   /**
    * Constructor
    */
   public FolderSearchResult()
   {   
      m_fdrIds = new IeciTdLongIntegerArrayList();         
   }
      
   /**
    * A�ade un nuevo identificador de carpeta a la colecci�n
    * @param fdrId identificador de carpeta
    */
   protected void addFolder(int fdrId) 
   {
      m_fdrIds.add(fdrId);      
   }
      
   /**
    * Elimina un identificador de carpeta de la colecci�n
    * @param folderId identificador de carpeta
    * @throws Exception si no encuentra el identificador de la carpeta 
    */
   public void removeFolderId(int folderId) throws Exception 
   {
       int idx = this.m_fdrIds.indexOf(folderId);
       if(idx == -1) 
       {
          throw new IeciTdException(FolderSearchError.EC_INVALID_PARAM, 
                   FolderSearchError.EM_INVALID_PARAM);
       }
       this.m_fdrIds.remove(idx);
       
   }
   
   /**
    * devuelte el n�mero de carpetas que pertenecen al resultado de la b�squeda
    * @return n�mero de carpetas que pertenecen al resultado de la b�squeda
    */
   public int count()
   {
      return m_fdrIds.count();
   } 
   
   /**
    * Devuelve el identificador de la carpeta i-�simo de la colecci�n
    * @param idx �ndice
    * @return identificador de la carpeta
    * @throws Exception si el �ndice no se encuentra en los l�mites de la colecci�n
    */
   public int getFolderId(int idx) throws Exception
   {
      int fdrId ;
      
      if ( (idx + 1) > m_fdrIds.count() || (idx < 0) )
      {
         throw new IeciTdException(FolderSearchError.EC_INVALID_PARAM, 
                                   FolderSearchError.EM_INVALID_PARAM);
      
      }
      
      fdrId = m_fdrIds.get(idx);
      
      return fdrId;
   }

   /**
    * Devuelve la colecci�n de identificadores de carpetas que son resultado de una b�squeda
    * @return referencia a un objeto de tipo IeciTdLongIntegerArrayList que es una colecci�n de
    * identificadores de carpetas
    * @see IeciTdLongIntegerArrayList
    */
   public IeciTdLongIntegerArrayList getFolderIds() 
   {
      return m_fdrIds;
   }   
   
   /**
    * Devuelve un string con la representaci�n del objeto, es decir, la colecci�n de identificador
    * de carpetas
    * @return representaci�n del objeto, es decir, la colecci�n de identificadores de carpeta
    */
   public String toString() {
      StringBuffer buffer = new StringBuffer();
      
      buffer.append("FolderSearchResult[");
      
      for(int i = 0; i < m_fdrIds.count(); i++)
      {

          buffer.append(" [folderId").append(i+1);
          buffer.append(" = ").append((m_fdrIds.get(i)));
          buffer.append("] ");

      }
      
      buffer.append("]");
      
      return buffer.toString();
   }
} // class
