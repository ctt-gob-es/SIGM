
package ieci.tecdoc.sbo.idoc.archive.std;


import ieci.tecdoc.core.textutil.UtilX;
import ieci.tecdoc.sbo.acs.base.AcsAccessToken;
import ieci.tecdoc.sbo.acs.base.AcsAccessType;
import ieci.tecdoc.sbo.idoc.acs.AcsMdoArchive;
import ieci.tecdoc.sbo.idoc.acs.AcsTokenArchive;
import ieci.tecdoc.sbo.idoc.archive.base.ArchiveToken;
import ieci.tecdoc.sbo.idoc.archive.base.ArchiveTokenDivider;
import ieci.tecdoc.sbo.idoc.archive.base.ArchiveTokenFld;
import ieci.tecdoc.sbo.idoc.archive.base.ArchiveTokenFldVld;
import ieci.tecdoc.sbo.idoc.archive.base.ArchiveTokenFlds;
import ieci.tecdoc.sbo.idoc.archive.base.ArchiveTokenValidation;
import ieci.tecdoc.sbo.idoc.archive.base.ArchiveValidationType;
import ieci.tecdoc.sbo.idoc.archive.base.ArchiveVolListType;
import ieci.tecdoc.sbo.idoc.dao.DaoArchDetRow;
import ieci.tecdoc.sbo.idoc.dao.DaoArchDetRows;
import ieci.tecdoc.sbo.idoc.dao.DaoArchDetTbl;
import ieci.tecdoc.sbo.idoc.dao.DaoArchDetType;
import ieci.tecdoc.sbo.idoc.dao.DaoArchHdrTbl;
import ieci.tecdoc.sbo.idoc.vldtable.base.VldTblToken;
import ieci.tecdoc.sbo.idoc.vldtable.base.VldTblUtil;
import ieci.tecdoc.sbo.idoc.vldtable.base.VldTblVInfo;
import ieci.tecdoc.sbo.idoc.vldtable.base.VldTblVInfoHierarchical;
import ieci.tecdoc.sbo.idoc.vldtable.std.VldMdoVldTable;
import ieci.tecdoc.sbo.util.types.SboType;
import ieci.tecdoc.sgm.base.collections.IeciTdLongIntegerArrayList;
import ieci.tecdoc.sgm.base.dbex.DbConnection;

import java.text.StringCharacterIterator;

public class ArchiveMdoToken
{
   
   private static final String MISC_VERS1_0_0    = "01.00";  
   private static final String MISC_CURRENT_VERS = "01.01";   
   
   private ArchiveMdoToken()
   {      
   }
   
   public static ArchiveToken createArchiveToken(DbConnection dbConn, AcsAccessToken accToken, 
                                                 int archId)
                              throws Exception
   {
      
      ArchiveToken               token; 
      ArchiveDaoArchHdrTokenRow  row       = null;
      DaoArchDetRows             detRows   = null;
      DaoArchDetRow              detRow    = null;        
      int                        i, numRows, count;      
      AcsTokenArchive            acsToken  = null;

      token = new ArchiveToken(); 
      
      row = new ArchiveDaoArchHdrTokenRow();
      
      DaoArchHdrTbl.selectRow(dbConn, archId, row);
      
      token.setArchHdr(row.m_id, row.m_name, row.m_tblPrefix, 
                       row.m_flags, row.m_accessType, row.m_acsId);
           
      detRows = DaoArchDetTbl.selectAllColumnRows(dbConn, archId);
      
      numRows = detRows.count();
      
      for (i = 0; i < numRows; i++)
      {
         detRow = detRows.getRecord(i);
         
         switch(detRow.m_detType)
         {
            case DaoArchDetType.DET_TYPE_FLD_DEF:
               
               fillArchiveTokenFlds(token, detRow.m_detVal);              
               break; 
               
            case DaoArchDetType.DET_TYPE_CLF_DEF:
               
               fillArchiveTokenDividers(token, detRow.m_detVal);              
               break; 
               
            case DaoArchDetType.DET_TYPE_VLD_DEF:
               
               fillArchiveTokenValidation(token, detRow.m_detVal);              
               break;
               
            case DaoArchDetType.DET_TYPE_MISC_DEF:
               
               fillArchiveTokenMisc(token, detRow.m_detVal);              
               break; 
         }         
         
      }
      
      adjustHierarchicalVldTokens (dbConn, token);
      
      if ( (accToken != null) && 
           (row.m_accessType == AcsAccessType.ACS_PROTECTED) )
      {
         acsToken = AcsMdoArchive.createAcsToken(dbConn, accToken, row.m_acsId);                  
         
         token.setAcs(acsToken);         
      }
      
      return token;    
      
   }
   
   /**
    * Se reajustan los token de tipo validaci�n jer�rquica, de manera que queden 
    * estas validaciones contenidas en la validaci�n del propio campo.
    * 
    * @param archiveToken
    * @throws Exception
    */
   private static void adjustHierarchicalVldTokens (DbConnection dbConn, ArchiveToken archiveToken) throws Exception {
      //VldMdoVldTable.loadValidationTable(tableId) ;
      ArchiveTokenValidation archiveTokenValidation = archiveToken.getArchValidation ();
      ArchiveTokenFldVld archiveTokenFldVld,  childArchiveTokenFldVld;
      VldTblToken vldTblToken; 
      VldTblVInfoHierarchical vldTblVInfoHierarchical;
      VldTblVInfo vldTblVInfo;
      
      for (int i = 0; i < archiveTokenValidation.numFldsValidation(); i++) {
         archiveTokenFldVld = archiveTokenValidation.getFldValidation (i);
         
         if (archiveTokenFldVld.getVldType() == VldTblUtil.VLD_TBL_JERAR) {
            // Obtenemos la informaci�n sobre la validaci�n jer�rquica
            vldTblToken = VldMdoVldTable.loadValidationTable (dbConn, archiveTokenFldVld.getVldParam1 ());
            
            vldTblVInfoHierarchical = (VldTblVInfoHierarchical) vldTblToken.getVInfo().restoreInfo();
            
            // Obtenemos la informaci�n sobre la validaci�n "hija" de la jerarquica
            vldTblToken = VldMdoVldTable.loadValidationTable (dbConn, vldTblVInfoHierarchical.getChildVTblId());
            
            vldTblVInfo = vldTblToken.getVInfo().restoreInfo();
            
            
            childArchiveTokenFldVld = new ArchiveTokenFldVld (
                     	archiveTokenFldVld.getId(), 
                     	archiveTokenFldVld.getFmtInfo(), 
                      vldTblToken.getVInfo().getType(),
                      vldTblVInfoHierarchical.getChildVTblId(),
                      0, 
                      archiveTokenFldVld.isRequired (), 
                      archiveTokenFldVld);
            
            archiveTokenValidation.setFldValidation (i, childArchiveTokenFldVld);
         }
      }
   }
   
   
   public static ArchiveTokenFlds createArchiveTokenFlds(DbConnection dbConn, int archId)
                                  throws Exception
   {
      
      ArchiveToken     token; 
      DaoArchDetRow    detRow = null; 
      String           detVal;       
           
      token = new ArchiveToken();     
      
      detVal = DaoArchDetTbl.selectDetVal(dbConn, archId, DaoArchDetType.DET_TYPE_FLD_DEF);
      
      fillArchiveTokenFlds(token, detVal);       
      
      return token.getFlds();    
      
   }
   
   private static void fillArchiveTokenFlds(ArchiveToken token,
                                            String detVal)
                       throws Exception
   { 
      StringCharacterIterator iterator  = new StringCharacterIterator(detVal);
      char                    sep       = '|';
      String                  vers;
      int                     numFlds, i;
      ArchiveTokenFld         fld = null;
      
      //versi�n
      vers = UtilX.parseString(iterator);       
      UtilX.iteratorIncrementIndex(iterator, 1);
      
      //N�mero de campos
      numFlds = UtilX.parseInteger(iterator, sep);
      
      for(i = 0; i < numFlds; i++)
      {
         UtilX.iteratorIncrementIndex(iterator, 1); 
         
         fld = createTokenFld(iterator);
         
         token.addFld(fld);         
      }

   }

   private static ArchiveTokenFld createTokenFld(StringCharacterIterator iterator)
                                  throws Exception
   { 
      
      ArchiveTokenFld fld = null;
      int             id, type, len, nulls, doc, mult;
      String          name, colName, remarks;
      boolean         isNullable, isDoc, isMult;
      char            sep = ',';
      
      id = UtilX.parseInteger(iterator, sep);
      UtilX.iteratorIncrementIndex(iterator, 1);
      
      name = UtilX.parseString(iterator);       
      UtilX.iteratorIncrementIndex(iterator, 1);
      
      type = UtilX.parseInteger(iterator, sep);
      UtilX.iteratorIncrementIndex(iterator, 1);
      
      len = UtilX.parseInteger(iterator, sep);
      UtilX.iteratorIncrementIndex(iterator, 1);
      
      nulls = UtilX.parseInteger(iterator, sep);
      UtilX.iteratorIncrementIndex(iterator, 1);
      
      if (nulls == 0)
         isNullable = false;
      else
         isNullable = true;
      
      colName = UtilX.parseString(iterator);       
      UtilX.iteratorIncrementIndex(iterator, 1);
      
      doc = UtilX.parseInteger(iterator, sep);
      UtilX.iteratorIncrementIndex(iterator, 1);
      
      if (doc == 0)
         isDoc = false;
      else
         isDoc = true;
      
      mult = UtilX.parseInteger(iterator, sep);
      UtilX.iteratorIncrementIndex(iterator, 1);
      
      if (mult == 0)
         isMult = false;
      else
         isMult = true;
      
      remarks = UtilX.parseString(iterator);
      
      fld = new ArchiveTokenFld(id, name, type, len, isNullable,
                                colName, isDoc, isMult, remarks);
      
      return fld;
      
   }
   
   private static void fillArchiveTokenDividers(ArchiveToken token,
                                                String detVal)
                       throws Exception
   { 
      StringCharacterIterator iterator  = new StringCharacterIterator(detVal);
      char                    sep       = '|';
      String                  vers;
      int                     numDivs, i;
      ArchiveTokenDivider     div = null;
      
      //versi�n
      vers = UtilX.parseString(iterator);       
      UtilX.iteratorIncrementIndex(iterator, 1);
      
      //N�mero de clasificadores
      numDivs = UtilX.parseInteger(iterator, sep);
      
      for(i = 0; i < numDivs; i++)
      {
         UtilX.iteratorIncrementIndex(iterator, 1); 
         
         div = createTokenDivider(iterator);
         
         token.addDivider(div);         
      }

   }
   
   private static ArchiveTokenDivider createTokenDivider(StringCharacterIterator iterator)
                                      throws Exception
   { 
      
      ArchiveTokenDivider div = null;
      int                 id, type, parentId, info;
      String              name, remarks;
      char                sep = ',';
      
      id = UtilX.parseInteger(iterator, sep);
      UtilX.iteratorIncrementIndex(iterator, 1);
      
      name = UtilX.parseString(iterator);       
      UtilX.iteratorIncrementIndex(iterator, 1);
      
      parentId = UtilX.parseInteger(iterator, sep);
      UtilX.iteratorIncrementIndex(iterator, 1);
      
      type = UtilX.parseInteger(iterator, sep);
      UtilX.iteratorIncrementIndex(iterator, 1); 
      
      info = UtilX.parseInteger(iterator, sep);       
      UtilX.iteratorIncrementIndex(iterator, 1);      
      
      remarks = UtilX.parseString(iterator);
      
      div = new ArchiveTokenDivider(id, name, parentId, type);
      
      return div;
      
   }
   
   private static void fillArchiveTokenValidation(ArchiveToken token,
                                                  String detVal)
                       throws Exception
   { 
      StringCharacterIterator     iterator  = new StringCharacterIterator(detVal);
      char                        sep       = '|';
      char                        reqSep;
      String                      vers;
      int                         fdrVldMacroId;
      int                         numReqFlds, i, reqFldId;
      int                         numFldsVld;
      ArchiveTokenFldVld          fldVld  = null;
      IeciTdLongIntegerArrayList  reqFlds = new IeciTdLongIntegerArrayList();
      
      //versi�n
      vers = UtilX.parseString(iterator);       
      UtilX.iteratorIncrementIndex(iterator, 1);
      
      fdrVldMacroId = UtilX.parseInteger(iterator, sep);
      UtilX.iteratorIncrementIndex(iterator, 1);
      
      //N�mero de campos obligatorios
      numReqFlds = UtilX.parseInteger(iterator, sep);
      
      UtilX.iteratorIncrementIndex(iterator, 1); 
      
      for(i = 0; i < numReqFlds; i++)
      {    
         if ((i +1) < numReqFlds)
            reqSep = ',';
         else
            reqSep = '|';
         
         reqFldId = UtilX.parseInteger(iterator, reqSep);
         UtilX.iteratorIncrementIndex(iterator, 1);
         
         reqFlds.add(reqFldId);
      }
      
      //    N�mero de campos con validaci�n
      numFldsVld = UtilX.parseInteger(iterator, sep);
            
      for(i = 0; i < numFldsVld; i++)
      {
         UtilX.iteratorIncrementIndex(iterator, 1); 
         
         fldVld = createTokenFldValidation(iterator, reqFlds);
         
         token.addFldValidation(fldVld);         
      }

   }
   
   private static ArchiveTokenFldVld createTokenFldValidation(StringCharacterIterator iterator,
                                                              IeciTdLongIntegerArrayList reqFlds)
                                     throws Exception
   { 
      
      ArchiveTokenFldVld  fldVld = null;
      int                 id, vldType, vldParam1, vldParam2;
      String              fmtInfo;
      boolean             isRequired = false;      
      char                sep    = '|';
      char                vldSep = ',';
      
      id = UtilX.parseInteger(iterator, sep);
      UtilX.iteratorIncrementIndex(iterator, 1);
      
      fmtInfo = UtilX.parseString(iterator, sep);       
      UtilX.iteratorIncrementIndex(iterator, 1);
      
      vldType = UtilX.parseInteger(iterator, vldSep);
      UtilX.iteratorIncrementIndex(iterator, 1);
      
      if (vldType == ArchiveValidationType.TBL_HIERARCHIC)
      {
      
         vldParam1 = UtilX.parseInteger(iterator, vldSep);
         UtilX.iteratorIncrementIndex(iterator, 1); 
      
         vldParam2 = UtilX.parseInteger(iterator, sep);          
      }
      else
      {
         vldParam1 = UtilX.parseInteger(iterator, sep);
         vldParam2 = 0;  
      }
         
      if (reqFlds.indexOf(id) != -1)
         isRequired = true;
      else
         isRequired = false;   
      
      fldVld = new ArchiveTokenFldVld(id, fmtInfo, vldType, vldParam1, 
                                      vldParam2, isRequired);
      
      return fldVld;
      
   }
   
   private static void fillArchiveTokenMisc(ArchiveToken token,
                                            String detVal)
                       throws Exception
   { 
      StringCharacterIterator iterator  = new StringCharacterIterator(detVal);
      char                    sep       = ',';
      String                  vers;
      String                  fdrName;
      int                     volListType;
      int                     volListId = SboType.NULL_ID;
      
           
      //versi�n
      vers = UtilX.parseString(iterator);       
      UtilX.iteratorIncrementIndex(iterator, 1);
      
      //Nombre de carpeta
      fdrName = UtilX.parseString(iterator);
      
      if (vers.equals(MISC_VERS1_0_0))
         volListType = ArchiveVolListType.NONE;
      else
      {      
         UtilX.iteratorIncrementIndex(iterator, 1); 
         volListType = UtilX.parseInteger(iterator, sep);
      
         if (volListType != ArchiveVolListType.NONE)
         {
            UtilX.iteratorIncrementIndex(iterator, 1);
            volListId = UtilX.parseInteger(iterator, sep);
         }
      }
      
      token.setMisc(fdrName, volListType, volListId);

   }
   
} // class
