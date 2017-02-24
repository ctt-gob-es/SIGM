/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.sgm.registropresencial.beans;

import java.util.List;

import com.ieci.tecdoc.common.invesicres.ScrDistreg;
import com.ieci.tecdoc.common.isicres.AxSf;
import com.ieci.tecdoc.common.isicres.DtrFdrResults;

/**
 * Bean correspondiente a una fila en el buscador de distribucion.
 * 
 * @author cmorenog
 * */
public class RowSearchDistributionBean
		extends ScrDistreg {
	
	private static final long serialVersionUID = 1L;
	/** Nombre del libro. */
	private String nameBook;
	/** Nombre del destino de la distribuci�n. */
	private String destinoDist;
	/** Nombre del origen de la distribuci�n. */
	private String origenDist;
	/** Historial de la distribuci�n. */
	private List<DtrFdrResults> histDistribution;
	/** Datos del registro. */
	private AxSf axsf;
	
	/**
	 * Constructor.
	 * 
	 * @param dist
	 *            bean de SIGM correspondiente a una distribuci�n
	 */
	public RowSearchDistributionBean(ScrDistreg dist) {
		super(dist.getId(), dist.getIdArch(), dist.getIdFdr(), dist
				.getDistDate(), dist.getTypeOrig(), dist.getIdOrig(), dist
				.getTypeDest(), dist.getIdDest(), dist.getState(), dist
				.getStateDate(), dist.getMessage());
	}
	
	/**
	 * Obtiene el valor del par�metro nameBook.
	 * 
	 * @return nameBook valor del campo a obtener.
	 */
	public String getNameBook() {
		return nameBook;
	}
	
	/**
	 * Guarda el valor del par�metro nameBook.
	 * 
	 * @param nameBook
	 *            valor del campo a guardar.
	 */
	public void setNameBook(String nameBook) {
		this.nameBook = nameBook;
	}
	
	/**
	 * Obtiene el valor del par�metro destinoDist.
	 * 
	 * @return destinoDist valor del campo a obtener.
	 */
	public String getDestinoDist() {
		return destinoDist;
	}
	
	/**
	 * Guarda el valor del par�metro destinoDist.
	 * 
	 * @param destinoDist
	 *            valor del campo a guardar.
	 */
	public void setDestinoDist(String destinoDist) {
		this.destinoDist = destinoDist;
	}
	
	/**
	 * Obtiene el valor del par�metro origenDist.
	 * 
	 * @return origenDist valor del campo a obtener.
	 */
	public String getOrigenDist() {
		return origenDist;
	}
	
	/**
	 * Guarda el valor del par�metro origenDist.
	 * 
	 * @param origenDist
	 *            valor del campo a guardar.
	 */
	public void setOrigenDist(String origenDist) {
		this.origenDist = origenDist;
	}
	
	/**
	 * Obtiene el valor del par�metro axsf.
	 * 
	 * @return axsf valor del campo a obtener.
	 */
	public AxSf getAxsf() {
		return axsf;
	}
	
	/**
	 * Guarda el valor del par�metro axsf.
	 * 
	 * @param axsf
	 *            valor del campo a guardar.
	 */
	public void setAxsf(AxSf axsf) {
		this.axsf = axsf;
	}
	
	/**
	 * Obtiene el valor del par�metro histDistribution.
	 * 
	 * @return histDistribution valor del campo a obtener.
	 */
	public List<DtrFdrResults> getHistDistribution() {
		return histDistribution;
	}
	
	/**
	 * Guarda el valor del par�metro histDistribution.
	 * 
	 * @param histDistribution
	 *            valor del campo a guardar.
	 */
	public void setHistDistribution(List<DtrFdrResults> histDistribution) {
		this.histDistribution = histDistribution;
	}
	
	/**
	 * Realiza un cath a la clase padre.
	 * @return object
	 * 			objecto distribuci�n.
	 */
	public ScrDistreg toFather() {
		ScrDistreg copy =
			new ScrDistreg(this.getId(), this.getIdArch(), this.getIdFdr(),
				this.getDistDate(), this.getTypeOrig(),
				this.getIdOrig(), this.getTypeDest(), this.getIdDest(),
				this.getState(), this.getStateDate(), this.getMessage());
		
		return copy;
	}
}