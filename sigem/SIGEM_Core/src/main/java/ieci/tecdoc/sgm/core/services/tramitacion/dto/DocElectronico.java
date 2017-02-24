package ieci.tecdoc.sgm.core.services.tramitacion.dto;


/**
 * Informaci�n de un documento electr�nico.
 */
public class DocElectronico extends DocFisico {

	/** Repositorio del documento. */
	protected String repositorio = null;

	/** Localizador del documento. */
	protected String localizador = null;

	/** Extensi�n del fichero. */
	protected String extension = null;

	/**
	 * Constructor.
	 */
	public DocElectronico() {
		super();
	}

	/**
	 * Obtiene el localizador del documento.
	 * @return Localizador del documento.
	 */
	public String getLocalizador() {
		return localizador;
	}

	/**
	 * Establece el localizador del documento.
	 * @param localizador Localizador del documento.
	 */
	public void setLocalizador(String localizador) {
		this.localizador = localizador;
	}

	/**
	 * Obtiene el repositorio del documento.
	 * @return Repositorio del documento.
	 */
	public String getRepositorio() {
		return repositorio;
	}

	/**
	 * Establece el tepositorio del documento.
	 * @param repositorio Repositorio del documento.
	 */
	public void setRepositorio(String repositorio) {
		this.repositorio = repositorio;
	}

	/**
	 * Obtiene la extensi�n del fichero.
	 * @return Extensi�n del fichero.
	 */
	public String getExtension() {
		return extension;
	}

	/**
	 * Establece la extensi�n del fichero.
	 * @param extensionFichero Extensi�n del fichero.
	 */
	public void setExtension(String extensionFichero) {
		this.extension = extensionFichero;
	}

}
