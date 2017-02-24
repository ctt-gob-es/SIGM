package ieci.tecdoc.sgm.core.services.catastro;

public interface ServicioCatastro {
	
	/**
	 * M�todo que comprueba si una referencia catastral est� dada de alta
	 * @param referenciaCatastral Valor de la referencia catastral
	 * @return Verdadero si est� dada de alta la referencia castastral, Falso si no lo est�
	 * @throws CatastroServicioException En caso de producirse alg�n error
	 */
	public  boolean validarReferenciaCatastral(String referenciaCatastral) throws CatastroServicioException;
	
	/**
	 * M�todo que obtiene la informaci�n asociada a una refrencia catastral
	 * @param referenciaCatastral Valor de la referencia catastral
	 * @return Datos de la referencia catastral
	 * @throws CatastroServicioException En caso de producirse alg�n error
	 */
	public  Parcelas consultarCatastro(String referenciaCatastral) throws CatastroServicioException;

}
