
package ieci.tecdoc.sbo.idoc.api;

import ieci.tecdoc.sbo.idoc.folder.base.FolderTokenFdrLinks;

/**
 * Esta clase encapsula una colecci�n de enlaces a carpetas y 
 * m�todos para obtener cada uno de sus enlaces 
 */

public final class FolderFdrLinkObjects 
{
   
   /**
    * Colecci�n de enlaces a carpetas
    */
   FolderTokenFdrLinks m_fdrLinks;
   
   
   /**
    * Constructor
    * @param fdrLinks colecci�n de enlaces a carpetas
    */
   protected FolderFdrLinkObjects(FolderTokenFdrLinks fdrLinks)
   {
      m_fdrLinks = fdrLinks;    
   } 

   /**
    * Devuelve el n�mero de enlaces a carpetas
    * @return
    */
   public int count()
   {
      return m_fdrLinks.count();
   }   
   
   /**
    * Devuelve el enlace i-�simo de la colecci�n 
    * @param index �ndice del enlace dentro de la colecci�n
    * @return referencia a un objeto de tipo FolderFdrLinkObject que contiene
    * informaci�n sobre un enlace a una carpeta
    */
   public FolderFdrLinkObject get(int index)
   {
      FolderFdrLinkObject fdrLink = new FolderFdrLinkObject(m_fdrLinks.get(index));
      
      return fdrLink;
   } 
   
      
} // class
