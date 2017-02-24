
package ieci.tecdoc.sgm.core.services.estructura_organizativa;

/**
 * Bean de �ndices. 
 */

import java.util.ArrayList;

public class ArchiveIdxs{

	private ArrayList archiveIndxsList;

	public ArchiveIdxs(){
		archiveIndxsList = new ArrayList();      
	}

	/**
	 * Inicializa la estructura de �ndices
	 */
	public void clear(){
		archiveIndxsList.clear();
	}

	/**
	 * Obtiene el n�mero de �ndices en la estructura. 
	 * 
	 * @return N�mero de �ndices
	 */
	public int count(){
		return archiveIndxsList.size();
	}

	/**
	 * A�ade la definici�n de un �ndice.
	 * 
	 * @param item Definici�n del �ndice
	 */
	public void addIdx(ArchiveIdx item){      
		ArchiveIdx idx = null;
		ArrayList idsFld = new ArrayList();
		ArrayList fldsId = item.getFldsId();

		for (int i = 0; i < fldsId.size(); i++){
			Integer id = (Integer)fldsId.get(i);
			idsFld.add(new Integer(id.intValue()));
		}

		idx = new ArchiveIdx(item.getId(),item.getName(),item.isUnique(),idsFld);

		archiveIndxsList.add(idx);      
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
			ArrayList idsFld) throws EstructuraOrganizativaException{

		ArchiveIdx idx;
		int idxId;


		if (name.length() == 0)
			throw new EstructuraOrganizativaException(EstructuraOrganizativaException.EXC_GENERIC_EXCEPCION);

		if (!isValidName(name))      
			throw new EstructuraOrganizativaException(EstructuraOrganizativaException.EXC_GENERIC_EXCEPCION);


		idxId  = getNextIdxId();
		idx = new ArchiveIdx(idxId, name, isUnique,idsFld); 

		archiveIndxsList.add(idx);

	}

	/**
	 * Obtiene la definici�n del �ndice. 
	 * 
	 * @param index �ndice de la estructura
	 * @return Errores
	 */
	public ArchiveIdx get(int index){
		return (ArchiveIdx) archiveIndxsList.get(index);
	} 

	/**
	 * Obtiene el identificador del �ndice por su nombre.
	 * 
	 * @param name Nombre del �ndice
	 * @return Identificador del �ndice
	 * @throws Exception Errores
	 */
	public int getIdxIdByName(String name) throws EstructuraOrganizativaException{
		int count,i;
		boolean find = false;
		ArchiveIdx idxDef = null;
		int idxId = Integer.MAX_VALUE - 1;;

		count = archiveIndxsList.size();

		for(i=0; i<count; i++){
			idxDef = (ArchiveIdx)archiveIndxsList.get(i);
			if (idxDef.getName().equals(name)){
				find = true;
				idxId = idxDef.getId();
				break;
			}           
		}

		if (!find){
			throw new EstructuraOrganizativaException(EstructuraOrganizativaException.EXC_GENERIC_EXCEPCION); 
		}

		return idxId; 
	}

	/**
	 * Obtiene si el nombre del �ndice es v�lido � no
	 * 
	 * @param name - nombre del �ndice
	 * @return true / false
	 */
	private boolean isValidName(String name){
		boolean valid = true;

		for (int i = 0; i < archiveIndxsList.size(); i++){
			ArchiveIdx idxDef = (ArchiveIdx)archiveIndxsList.get(i);
			if (idxDef.getName().equals(name)){
				valid = false;
			}         
		}

		return valid;
	}

	/**
	 * Obtiene el identificador del �ndice
	 * @return El identificador
	 */
	private int getNextIdxId(){
		int nextId;
		int count,i;
		ArchiveIdx idxDef = null;

		nextId = 0;
		count = archiveIndxsList.size();

		for(i=0; i<count; i++){
			idxDef = (ArchiveIdx)archiveIndxsList.get(i);

			if (nextId < idxDef.getId() )
				nextId = idxDef.getId();
		}

		nextId = nextId + 1;

		return(nextId);
	}


}

