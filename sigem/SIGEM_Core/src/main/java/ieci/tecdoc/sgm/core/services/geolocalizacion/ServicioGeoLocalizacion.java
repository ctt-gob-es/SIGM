package ieci.tecdoc.sgm.core.services.geolocalizacion;

public interface ServicioGeoLocalizacion {
	
	/**
	 * M�todo que obtiene un plano a partir de unas coordenadas
	 * @param datosLocalizacion Datos de la localizaci�n
	 * @return Url de la imagen del plano generado
	 * @throws GeoLocalizacionServicioException En caso de producirse alg�n error
	 */
	public URLsPlano verPlanoPorCoordenadas(PeticionPlanoCoordenadas datosLocalizacion) throws GeoLocalizacionServicioException;

	/**
	 * M�todo que obtiene un plano a partir de un n�mero de referencia de catastro
	 * @param datosLocalizacion Datos de la localizaci�n
	 * @return Url de la imagen del plano generado
	 * @throws GeoLocalizacionServicioException En caso de producirse alg�n error
	 */
	public URLsPlano verPlanoPorReferenciaCatastral(PeticionPlanoReferenciaCatastral datosLocalizacion) throws GeoLocalizacionServicioException;
	
	/**
	 * M�todo que obtiene un plano a partir de un idntificador de v�a
	 * @param datosLocalizacion Datos de la localizaci�n
	 * @return Url de la imagen del plano generado
	 * @throws GeoLocalizacionServicioException En caso de producirse alg�n error
	 */
	public URLsPlano verPlanoPorIdVia(PeticionPlanoVia datosLocalizacion) throws GeoLocalizacionServicioException;
	
	/**
	 * M�todo que obtiene un plano a partir de un n�mero de portal
	 * @param datosLocalizacion Datos de la localizaci�n
	 * @return Url de la imagen del plano generado
	 * @throws GeoLocalizacionServicioException En caso de producirse alg�n error
	 */
	public URLsPlano verPlanoPorIdNumeroPolicia(PeticionPlanoPortal datosLocalizacion) throws GeoLocalizacionServicioException;
	
	/**
	 * M�todo que obtiene los planos publicados de un municipio
	 * @param idEntidadMunicipal Identificador de la entidad de agrupaci�n de municipios del que obtener los planos
	 * @return mapas[] Datos del los planos publicados
	 * @throws GeoLocalizacionServicioException En caso de producirse alg�n error
	 */
	public Mapas verPlanosPublicados(int idEntidadMunicipal) throws GeoLocalizacionServicioException;
	
	/**
	 * M�todo que obtiene un listado de v�as coincidentes con la v�a de entrada
	 * @param nombreVia Nombre de la v�a a consultar
	 * @param codigoINEMunicipio C�digo de municipio
	 * @return Listado de v�as coincidentes
	 * @throws GeoLocalizacionServicioException En caso de producirse alg�n error
	 */
	public Vias validarVia(String nombreVia, int codigoINEMunicipio) throws GeoLocalizacionServicioException;
	
	/**
	 * M�todo que obtiene los datos asociados a un portal a partir de su identificador
	 * @param idPortal Identificador del portal
	 * @return Datos del portal
	 * @throws GeoLocalizacionServicioException En caso de producirse alg�n error
	 */
	public Portal obtenerPortal(int idPortal) throws GeoLocalizacionServicioException;
	
	/**
	 * M�todo que obtiene un listado de portales coincidentes para una v�a
	 * @param idVia Identificador de la v�a
	 * @param numeroPortal N�mero del portal
	 * @return Listado de portales coincidentes
	 * @throws GeoLocalizacionServicioException En caso de producirse alg�n error
	 */
	public Portales validarPortal(int idVia, String numeroPortal) throws GeoLocalizacionServicioException;
	
	/**
	 * M�todo que valida una direcci�n postal completa
	 * @param tipoVia Tipo de v�a
	 * @param nombreVia Nombre de la v�a
	 * @param numeroPortal N�mero del portal
	 * @param codigoINEMunicipio C�digo de municipio
	 * @return true si existe, false si no existe
	 * @throws GeoLocalizacionServicioException En caso de producirse alg�n error
	 */
	public boolean validarDireccionPostal(String tipoVia, String nombreVia, String numeroPortal, int codigoINEMunicipio) throws GeoLocalizacionServicioException;
	
	/**
	 * M�todo que valida una direcci�n postal completa
	 * @param tipoVia Tipo de v�a
	 * @param nombreVia Nombre de la v�a
	 * @param numeroPortal N�mero del portal
	 * @param codigoINEMunicipio C�digo de municipio
	 * @return true si existe, false si no existe
	 * @throws GeoLocalizacionServicioException En caso de producirse alg�n error
	 */
	public Via validarDireccionPostalCompleta(String tipoVia, String nombreVia, String numeroPortal, int codigoINEMunicipio) throws GeoLocalizacionServicioException;
	
	/**
	 * M�todo que obtiene los municipios pertenecientes a una provincia
	 * @param idProvincia Identificador de la provincia
	 * @return Listado de municipios de la provincia
	 * @throws GeoLocalizacionServicioException En caso de producirse alg�n error
	 */
	public Municipios obtenerMunicipios(int idProvincia) throws GeoLocalizacionServicioException;;
	
	/**
	 * M�todo que obtiene las provincias
	 * @return Listado de provincias
	 * @throws GeoLocalizacionServicioException En caso de producirse alg�n error
	 */
	public Provincias obtenerProvincias() throws GeoLocalizacionServicioException;;
	
	/**
	 * M�todo que obtiene los tipos de v�as
	 * @return Listado de tipos de v�as
	 * @throws GeoLocalizacionServicioException
	 */
	public TiposVia obtenerTiposDeVia() throws GeoLocalizacionServicioException;;
}
