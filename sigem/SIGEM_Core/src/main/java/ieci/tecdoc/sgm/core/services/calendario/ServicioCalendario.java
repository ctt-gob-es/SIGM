package ieci.tecdoc.sgm.core.services.calendario;

import java.util.Date;

import ieci.tecdoc.sgm.core.services.dto.Entidad;

/**
 * EJB sin estado que proporciona las operaciones sobre el calendario
 * 
 * @author IECISA
 * 
 */
public interface ServicioCalendario {
	
		/**
		 * M�todo que obtiene el calendario
		 * @param entidad Entidad sobre la que realizar operaciones
		 * @throws CatalogoTramitesExcepcion
		 * @return Datos del calenario obtenido
		 */
		public Calendario obtenerCalendario(Entidad entidad) throws CalendarioExcepcion;
	
		/**
		 * M�todo que da de alta el calendario
		 * @param calendario Datos del calendario
		 * @param entidad Entidad sobre la que realizar operaciones
		 * @throws CatalogoTramitesExcepcion
		 */
		public void nuevoCalendario(Calendario calendario, Entidad entidad) throws CalendarioExcepcion;
		
		/**
		 * M�todo que actualiza el calendario
		 * @param calendario Datos actualizados del calendario
		 * @param entidad Entidad sobre la que realizar operaciones
		 * @throws CatalogoTramitesExcepcion
		 */
		public void actualizarCalendario(Calendario calendario, Entidad entidad) throws CalendarioExcepcion;
		
		/**
		 * M�todo que elimina el calendario
		 * @param borrarDias especifica si se eliminan los d�as festivos definidos para el calendario
		 * @param entidad Entidad sobre la que realizar operaciones
		 * @throws CatalogoTramitesExcepcion
		 */
		public void eliminarCalendario(boolean borrarDias, Entidad entidad) throws CalendarioExcepcion;
		
		/**
		 * M�todo que obtiene un d�a del calendario
		 * @param id Identificador del dia del calendario
		 * @param entidad Entidad sobre la que realizar operaciones
		 * @return Datos del d�a obtenido
		 * @throws CatalogoTramitesExcepcion
		 */
		public CalendarioDia obtenerDiaCalendario(String id, Entidad entidad) throws CalendarioExcepcion;
		
		/**
		 * M�todo que da de alta un d�a en el calendario
		 * @param dia Datos del d�a a dar de alta
		 * @param entidad Entidad sobre la que realizar operaciones
		 * @throws CatalogoTramitesExcepcion
		 */
		public CalendarioDia nuevoDiaCalendario(CalendarioDia dia, Entidad entidad) throws CalendarioExcepcion;
		
		/**
		 * M�todo que actualiza un d�a del calendario
		 * @param dia Datos del d�a a actualizar
		 * @param entidad Entidad sobre la que realizar operaciones
		 * @throws CatalogoTramitesExcepcion
		 */
		public void actualizarDiaCalendario(CalendarioDia dia, Entidad entidad) throws CalendarioExcepcion;
		
		/**
		 * M�todo que elimina un d�a del calendario
		 * @param id Identificador del d�a a eliminar
		 * @param entidad Entidad sobre la que realizar operaciones
		 * @throws CatalogoTramitesExcepcion
		 */
		public void eliminarDiaCalendario(String id, Entidad entidad) throws CalendarioExcepcion;
	
		/**
		 * M�todo que obtiene el listado de d�as de un calendario
		 * @param tipo Tipo de festivo (-1 todos, 0 fijos, 1 variables)
		 * @return Listado de d�as festivos (fijos y/o variables)
		 * @throws CatalogoTramitesExcepcion
		 */
		public CalendarioDias obtenerDiasCalendario(int tipo, Entidad entidad) throws CalendarioExcepcion;
	
		/**
		 * M�todo que obtiene el listado de d�as de un calendario
		 * @param tipo Tipo de festivo (-1 todos, 0 fijos, 1 variables)
		 * @return Listado de d�as festivos (fijos y/o variables)
		 * @throws CatalogoTramitesExcepcion
		 */
		public RetornoCalendario proximoLaborable(Date fecha, Entidad entidad) throws CalendarioExcepcion;
	
}