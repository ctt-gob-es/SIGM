package com.ieci.tecdoc.common.conf;

import java.io.Serializable;
import java.util.Map;

/**
 * @author 79426599
 *
 */
public class BookTypeConf implements Serializable {

	//Tipo de libro (1 entrada, 2 salida)
    private int bookType = 0;
    private String stringBookType = "";
    //Fuente y tama�o de caracteres
    private String fontName = "";
    private String fontSize = "";
	//Informaci�n de los campos id de campo y coordenadas y etiqueta
    private Map fieldsInfoMap = null;
    //Los campos
    private String registerNumber = "";
    private String registerDate = "";
    private String user = "";
    private String codeOfic = "";
    private String registerType = "";
    private String pageNumber = "";
    
    private String onlyFirstPage = ""; //Si se imprime la firma solo en la primera p�gina
    
	public BookTypeConf() {
	}

	
    public String toString() {
        StringBuffer buffer = new StringBuffer();

        buffer.append("\n\t\t BookTypeConf bookType[");
        buffer.append(bookType);
        buffer.append("] fontName [");
        buffer.append(fontName);
        buffer.append("] fontSize [");
        buffer.append(fontSize);
        buffer.append("] fieldsInfoList [");
        buffer.append(fieldsInfoMap);
        buffer.append("]");
        
        return buffer.toString();
    }
	
	/**
	 * @return Returns the bookType.
	 */
	public int getBookType() {
		return bookType;
	}
	/**
	 * @param bookType The bookType to set.
	 */
	public void setBookType(int bookType) {
		this.bookType = bookType;
	}
	/**
	 * @return Returns the fieldsInfo.
	 */
	public Map getFieldsInfo() {
		return fieldsInfoMap;
	}
	/**
	 * @param fieldsInfo The fieldsInfo to set.
	 */
	public void setFieldsInfo(Map fieldsInfoMap) {
		this.fieldsInfoMap = fieldsInfoMap;
	}
	/**
	 * @return Returns the fontName.
	 */
	public String getFontName() {
		return fontName;
	}
	/**
	 * @param fontName The fontName to set.
	 */
	public void setFontName(String fontName) {
		this.fontName = fontName;
	}
	/**
	 * @return Returns the fontSize.
	 */
	public String getFontSize() {
		return fontSize;
	}
	/**
	 * @param fontSize The fontSize to set.
	 */
	public void setFontSize(String fontSize) {
		this.fontSize = fontSize;
	}
	/**
	 * @return Returns the codeOfic.
	 */
	public String getCodeOfic() {
		return codeOfic;
	}
	/**
	 * @param codeOfic The codeOfic to set.
	 */
	public void setCodeOfic(String codeOfic) {
		this.codeOfic = codeOfic;
	}
	/**
	 * @return Returns the pageNumber.
	 */
	public String getPageNumber() {
		return pageNumber;
	}
	/**
	 * @param pageNumber The pageNumber to set.
	 */
	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}
	/**
	 * @return Returns the registerDate.
	 */
	public String getRegisterDate() {
		return registerDate;
	}
	/**
	 * @param registerDate The registerDate to set.
	 */
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	/**
	 * @return Returns the registerNumber.
	 */
	public String getRegisterNumber() {
		return registerNumber;
	}
	/**
	 * @param registerNumber The registerNumber to set.
	 */
	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}
	/**
	 * @return Returns the registerType.
	 */
	public String getRegisterType() {
		return registerType;
	}
	/**
	 * @param registerType The registerType to set.
	 */
	public void setRegisterType(String registerType) {
		this.registerType = registerType;
	}
	/**
	 * @return Returns the user.
	 */
	public String getUser() {
		return user;
	}
	/**
	 * @param user The user to set.
	 */
	public void setUser(String user) {
		this.user = user;
	}
	/**
	 * @return Returns the stringBookType.
	 */
	public String getStringBookType() {
		return stringBookType;
	}
	/**
	 * @param stringBookType The stringBookType to set.
	 */
	public void setStringBookType(String stringBookType) {
		this.stringBookType = stringBookType;
	}


	/**
	 * @return el onlyFirstPage
	 */
	public String getOnlyFirstPage() {
		return onlyFirstPage;
	}


	/**
	 * @param onlyFirstPage el onlyFirstPage a fijar
	 */
	public void setOnlyFirstPage(String onlyFirstPage) {
		this.onlyFirstPage = onlyFirstPage;
	}
	
	
	
}
