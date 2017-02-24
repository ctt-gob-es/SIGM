package ieci.tecdoc.sgm.core.services.cripto.validacion;

public interface ServicioCriptoValidacion {
	
	/**
	 * M�todo que obtiene el resumen de un documento
	 * @param psBase64Document Contendido del documento
	 * @return Resumen
	 * @throws CriptoValidacionException
	 */
	public String createHash(String psBase64Document) throws CriptoValidacionException;;
	
	/**
	 * M�todo que valida el resumen de un documento
	 * @param psBase64Document Contenido del documento
	 * @param psB64Hash Valor del resumen a validar 
	 * @return true si el resumen es correcto, false si no lo es 
	 * @throws CriptoValidacionException
	 */
    public boolean validateHash(String psBase64Document, String psB64Hash) throws CriptoValidacionException;
    
    /**
     * M�todo que valida un certificado
     * @param psB64Certificate Contenido del certificado
     * @return Datos del resultado de la validaci�n
     * @throws CriptoValidacionException
     */
    public ResultadoValidacion validateCertificate(String psB64Certificate) throws CriptoValidacionException;
    
}
