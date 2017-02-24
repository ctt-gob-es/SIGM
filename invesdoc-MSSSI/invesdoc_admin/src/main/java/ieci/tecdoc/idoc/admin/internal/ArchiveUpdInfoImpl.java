package ieci.tecdoc.idoc.admin.internal;

import ieci.tecdoc.idoc.admin.api.archive.ArchiveDefs;
import ieci.tecdoc.idoc.admin.api.archive.ArchiveFld;
import ieci.tecdoc.idoc.admin.api.archive.ArchiveFlds;
import ieci.tecdoc.idoc.admin.api.archive.ArchiveIdxs;
import ieci.tecdoc.idoc.admin.api.archive.ArchiveMisc;
import ieci.tecdoc.idoc.admin.api.archive.ArchiveUpdInfo;
import ieci.tecdoc.sbo.idoc.archive.base.ArchiveVolListType;

import java.util.ArrayList;

public class ArchiveUpdInfoImpl implements ArchiveUpdInfo
{
   public ArchiveUpdInfoImpl()
   {
      init();
   }
   /**
    * Informaci�n necesario para la actualizaci�n del archivador
    * 
    * @param name   - nombre 
    * @param remarks - descripci�n 
    * @param adminUserId - Idenficador del usuario
    * @param ftsInContents - si se utiliza b�squeda en contenido de fichero
    * @param flds - definici�n de campos (antiguos y nuevos)
    * @param idxs - definici�n de �ndices (antiguos y nuevos)
    * @param misc - definici�n de t�tulo de carpeta y lista de vol�menes asociada
    */
   public ArchiveUpdInfoImpl(String name, String remarks, int adminUserId, boolean ftsInContents,
         					ArchiveFldsImpl flds, ArchiveIdxsImpl idxs, ArchiveMiscImpl misc)
   {
      
      init();
      
      _name        = name;
      _remarks     = remarks;
      _adminUserId = adminUserId;      
      //hay que copiar las estructuras
      copyFldsDef(flds);
      copyIdxsDef(idxs);
      copyMiscDef(misc);
      
      setFtsInContents(ftsInContents);
   }
   /**
    * Establece el nombre del archivador
    * 
    * @param name - nombre
    */
   public void setName(String name)
   {
      _name = name;
   }
   
   /**
    * Obtiene el nombre del archivador
    * 
    * @return - nombre
    */
   public String getName()
   {
      return _name;
   }
   
   /**
    * Establece la descripci�n del archivador
    * 
    * @param remarks - descripci�n
    */
   public void setRemarks(String remarks)
   {
      _remarks = remarks;
   }
   
   
   /**
    * Obtiene la descripci�n del archivador
    * 
    * @return - descripci�n
    */
   public String getRemarks()
   {
      return _remarks;
   }
   
  
   /**
    * Establece el administrador del archivador
    * 
    * @param adminUserId - identificador
    */
   public void setAdminUserId(int adminUserId)
   {
      _adminUserId = adminUserId;
   }
   
   /**
    * Obtiene el administrador del archivador
    * 
    * @return - identificador
    */
   public int getAdminUserId()
   {
      return _adminUserId;
   }
   
   public int getFlags()
   {
      return _flags;
   }
   
   /**
    * Obtiene si hay b�squeda en contenido de fichero en el archivador
    * 
    * @return true / false
    */
   public boolean isFtsInContents()
	{
	   boolean ftsInContents = false;
	   
	   if ((_flags & ArchiveDefs.ARCH_FLAG_FTSINCONTENTS) != 0)
	      ftsInContents = true;
	   
	   return(ftsInContents);
	      
	}
	
   /**
    * Establece la existencia o no de b�squeda en contenidoc de fichero en
    * el archivador
    * 
    * @param ftsInContents true / false
    */
	public void setFtsInContents(boolean ftsInContents)
	{
	   if (ftsInContents)
	      _flags = _flags | ArchiveDefs.ARCH_FLAG_FTSINCONTENTS;
	   else
	      _flags = _flags & ~ArchiveDefs.ARCH_FLAG_FTSINCONTENTS;
	}
   
	/**
	 * Establece la estructura de la definici�n de campos debe contener
	 * la informaci�n de los antiguos y los nuevos
	 * 
	 * @param fldsDef - estructura de campos
	 */
   public void setFldsDef(ArchiveFlds fldsDef) throws Exception
   {
      _flds.clear();
      copyFldsDef((ArchiveFldsImpl)fldsDef);
   }
   
   /**
    * Obtiene la estructura de la definici�n de los campos del archivador
    * 
    * @return - estructura de campos
    */
   public ArchiveFlds getFldsDef()
   {
      return _flds;
   }
   
   /**
    * Establece la estructura de la definici�n de �ndices del archivador, debe
    * contener la informaci�n de loa antiguos y de los nuevos
    * 
    * @param idxsDef - estructura de �ndices
    */
   public void setIdxsDef(ArchiveIdxs idxsDef)
   {
      _idxs.clear();
      copyIdxsDef((ArchiveIdxsImpl)idxsDef);
   }
   
   /**
    * Obtiene la estructura de la definici�n de �ndices
    * 
    * @return - estructura de �ndices
    */
   public ArchiveIdxs getIdxsDef()
   {
      return _idxs;
   }
   
   /**
    * Establece la informaci�n del t�tulo de carpetas y lista de vol�menes 
    * asociada, si no se cambia debe contener la informaci�n antigua
    * 
    * @param miscDef - informaci�n
    */
   public void setMiscDef(ArchiveMisc miscDef)
   {
      copyMiscDef((ArchiveMiscImpl)miscDef);
   }
   
   /**
    * Obtiene la informaci�n del t�tulo de carpetas y lista de vol�menes 
    * asociada
    * 
    * @return - informaci�n
    */
   public ArchiveMisc getMiscDef()
   {
      return _misc;
   }
   
   /**
    * Obtiene los identificadores de los �ndices eliminados
    * 
    * @return
    */
   public ArrayList getDeleteIdxs()
   {
      return _delIdxsId;
   }
   
   /**
    * Obtiene los identificadores de los �ndices a�adidos
    * 
    * @return
    */
   public ArrayList getNewIdx()
   {
      return _newIdxsId;
   }
   
   /**
    * Obtiene los identificadores de los campos eliminados
    * 
    * @return
    */
   public ArrayList getDeleteFlds()
   {
      return _delFldsId;
   }
   
   /**
    * Obtiene los identificadores de los campos a�adidos
    * 
    * @return
    */
   public ArrayList getNewFlds()
   {
      return _newFldsId;
   }
   
   /**
    * Establece un array de campos creador, otro de campos eliminados,
    * Si se ha modificado la definici�n de campos referente a tipo, longitud,
    * documental,obligatorio � multivalor el par�metro isModifyDefFlds deber�a se
    * true.
    * 
    * @param newFldsId
    * @param delFldsId
    * @param isModifyDefFlds true / false
    */
   public void setUpdateFlds(ArrayList newFldsId, ArrayList delFldsId, boolean isModifyDefFlds)
   {
      _newFldsId.clear();
      _delFldsId.clear();
      
      if (newFldsId != null)
         _newFldsId = newFldsId;
      
      if (delFldsId != null)
         _delFldsId = delFldsId;
      
      _isModifyDefFlds = isModifyDefFlds;
   }
   
   /**
    * Establece un array de �ndices creados, otro de �ndices eliminados
    * 
    * @param newIdxsId
    * @param delIdxsId
    */
   public void setUpdateIdxs(ArrayList newIdxsId, ArrayList delIdxsId)
   {
      _newIdxsId.clear();
      _newIdxsId.clear();
      
      if (newIdxsId != null)
         _newIdxsId = newIdxsId;
      
      if (delIdxsId != null)
         _delIdxsId = delIdxsId;
   }
   
   /**
    * Establece si se ha modificado � no la definici�n de los campos referente a
    * tipo, longitud, documental, obligatorio � multivalor, si alguno de estos valores
    * se ha modificador el par�metro deber�a ser true
    * 
    * @param modify - true/false
    */
   public void ModifyDefFlds(boolean modify)
   {
      _isModifyDefFlds = modify;
   }
   
   /**
    * Obtiene si se ha modificado la definici�n de los campos
    * @return
    */
   public boolean isModifyDefFlds()
   {
      return _isModifyDefFlds;
   }
   
   /**
    * Establece si se ha modificado � no la lista de vol�menes asociada
    * al archivador
    * 
    * @param modify - true / false
    */
   public void ModifyListVols(boolean modify)
   {
      _isModifyListVols = modify;
   }
   
   /**
    * Obtiene si la lista de v�lumenes ha sido modificada
    * 
    * @return
    */
   public boolean isModifyListVols()
   {
      return _isModifyListVols;
   }
   
   /**
    * Realiza una copia de la estructura de campos del archivador
    * 
    * @param flds - campos
    */
   private void copyFldsDef(ArchiveFldsImpl flds) 
   {
      ArchiveFldImpl nfld = null;
      
      for (int i = 0; i < flds.count(); i++)
      {
         ArchiveFldImpl fld = (ArchiveFldImpl)flds.get(i);
         nfld = new ArchiveFldImpl(fld.getId(),fld.getName(),fld.getType(),
                                   fld.getLen(), fld.isNullable(),fld.getColName(),
                                   fld.isDoc(),fld.isMult(),fld.getRemarks());
         try
         {
            _flds.addFld((ArchiveFld)nfld);
         }
         catch(Exception e)
         {
            
         }
         
      }
   }
   
   /**
    * Realiza una copia de la estructura de �ndices
    * 
    * @param idxs - �ndices
    */
   private void copyIdxsDef(ArchiveIdxsImpl idxs)
   {
      ArchiveIdxImpl nidx = null;
      ArrayList      fldsId = null;
      
      for (int i = 0; i < idxs.count(); i++)
      {
         ArchiveIdxImpl idx = (ArchiveIdxImpl)idxs.get(i);
         ArrayList      ids = idx.getFldsId();
         
         fldsId = new ArrayList();
         for (int j = 0; j < ids.size(); j++)
         {
            Integer id = (Integer)ids.get(j);
            fldsId.add(new Integer(id.intValue()));
         }
         
         nidx = new ArchiveIdxImpl(idx.getId(),idx.getName(),idx.isUnique(), fldsId);
         try
         {
            _idxs.addIdx(nidx);
         }
         catch(Exception e)
         {
            
         }
         
      }
   }
   
   
   /**
    * Realiza una copia de la estructura con informaci�n extra del archivador
    * 
    * @param misc - informaci�n
    */
   private void copyMiscDef(ArchiveMiscImpl misc)
   {
      _misc.setMisc(misc.getFdrName(),misc.getVolListId(),misc.getVolListType());
   }
   
   private void init()
   {
      _name = "";      
      _remarks = "";          
      _flags = ArchiveDefs.ARCH_FLAG_NONE;
      _adminUserId = Defs.NULL_ID;
      _flds = new ArchiveFldsImpl();
      _idxs = new ArchiveIdxsImpl();
      _misc = new ArchiveMiscImpl("",ArchiveVolListType.NONE,Defs.NULL_ID);
      _newFldsId = new ArrayList();
      _delFldsId = new ArrayList();
      _newIdxsId = new ArrayList();
      _delIdxsId = new ArrayList();
      _isModifyDefFlds = false;   
      _isModifyListVols = false;
   }   
   
   private String          _remarks;
   private String          _name;
   private int             _flags;
   private int             _adminUserId;
   private ArchiveFldsImpl _flds;
   private ArchiveIdxsImpl _idxs;
   private ArchiveMiscImpl _misc;
   private ArrayList       _newFldsId;
   private ArrayList       _delFldsId;
   private boolean         _isModifyDefFlds; //tipo de campo � longitud
   private boolean         _isModifyListVols; 
   private ArrayList       _delIdxsId;
   private ArrayList       _newIdxsId;
   
}

