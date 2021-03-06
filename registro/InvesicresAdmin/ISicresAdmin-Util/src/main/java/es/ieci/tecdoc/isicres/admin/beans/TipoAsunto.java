package es.ieci.tecdoc.isicres.admin.beans;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Gesti�n de los Tipos de Asuntos.
 */
public class TipoAsunto {
	private static DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy"); 
	
	/**
	 * Identificador del Tipo de Asunto
	 */
	private int id;
	/**
	 * C�digo del Tipo de Asunto
	 */
	private String code;
	
	/**
	 * Texto del Tipo de Asunto
	 */
	private String matter;
	
	/**
	 * Indica si el Tipo de Asunto est� habilitado para asientos de registro de Entrada
	 * 0 - No Habilitado
	 * 1 - Habilitado
	 */
	private int forEreg;
	
	/**
	 * Indica si el Tipo de Asunto est� habilitado para asientos de registro de Salida
	 * 0 - No Habilitado
	 * 1 - Habilitado
	 */
	private int forSreg;
	
	/**
	 * Indica si el Tipo de Asunto se distribuir� autom�ticamente cuando se consolide del registro telem�tico
	 * 0 - No Habilitado
	 * 1 - Habilitado
	 */
	private int forDistRT;
	
	/**
	 * Indica si el Tipo de Asunto puede usarse por todas las oficinas de registro
	 * 0 - No
	 * 1 - Si
	 */
	private int allOfics;
	
	/**
	 * Identificador del Archivador invesDoc en el que se almacenan los datos auxiliares de registro
	 * asociados al tipo de asunto
	 */
	private int idArch;
	
	/**
	 * Fecha de creaci�n del tipo de Asunto
	 */
	private Date creationDate;
	
	/**
	 * Fecha de baja del Tipo de Asunto
	 */
	private Date disableDate;
	
	/**
	 * Indica si el tipo de Asunto est� dado de baja o no 
	 * 0 - No
	 * 1 - Si
	 */
	private int enabled;
	
	/**
	 * Identificador de Unidad administrativa asociada
	 */
	private int idOrg;
	
	
	public TipoAsunto() {}
	
	/**
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return
	 */
	public String getMatter() {
		return matter;
	}
	/**
	 * @param matter
	 */
	public void setMatter(String matter) {
		this.matter = matter;
	}
	/**
	 * @return
	 */
	public int getForEreg() {
		return forEreg;
	}
	/**
	 * @param forEreg
	 */
	public void setForEreg(int forEreg) {
		this.forEreg = forEreg;
	}
	/**
	 * @return
	 */
	public int getForSreg() {
		return forSreg;
	}
	/**
	 * @param forSreg
	 */
	public void setForSreg(int forSreg) {
		this.forSreg = forSreg;
	}
	/**
	 * @return
	 */
	public int getForDistRT() {
		return forDistRT;
	}
	/**
	 * @return
	 */
	public void setForDistRT(int forDistRT) {
		this.forDistRT = forDistRT;
	}
	/**
	 * @return
	 */
	public int getAllOfics() {
		return allOfics;
	}
	/**
	 * @param allOfics
	 */
	public void setAllOfics(int allOfics) {
		this.allOfics = allOfics;
	}
	/**
	 * @return
	 */
	public int getIdArch() {
		return idArch;
	}
	/**
	 * @param idArch
	 */
	public void setIdArch(int idArch) {
		this.idArch = idArch;
	}
	/**
	 * @return
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return
	 */
	public Date getDisableDate() {
		return disableDate;
	}
	/**
	 * @param disableDate
	 */
	public void setDisableDate(Date disableDate) {
		this.disableDate = disableDate;
	}
	/**
	 * @return
	 */
	public int getEnabled() {
		return enabled;
	}
	/**
	 * @param enabled
	 */
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	/**
	 * @return
	 */
	public int getIdOrg() {
		return idOrg;
	}
	/**
	 * @param idOrg
	 */
	public void setIdOrg(int idOrg) {
		this.idOrg = idOrg;
	}
	
	
	/**
	 * @return
	 */
	public String getCreationDateVista() {
		if(this.creationDate==null){
			return "";
		} else {
			return dateFormatter.format(this.creationDate);
		}
	}
	/**
	 * @param creationDate
	 * @throws ParseException
	 */
	public void setCreationDateVista(String creationDate) throws ParseException {
		if(creationDate == null || "".equals(creationDate)) {
			this.creationDate = null;
		} else {
			this.creationDate = dateFormatter.parse(creationDate);
		}
	}
	/**
	 * @return
	 */
	public String getDisableDateVista() {
		if(this.disableDate==null){
			return "";
		} else {
			return dateFormatter.format(this.disableDate);
		}
	}
	
	/**
	 * @param disableDate
	 * @throws ParseException
	 */
	public void setDisableDateVista(String disableDate) throws ParseException {
		if(disableDate == null || "".equals(disableDate)) {
			this.disableDate = null;
		} else {
			this.disableDate = dateFormatter.parse(disableDate);
		}
	}
	
}
