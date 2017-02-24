package ieci.tecdoc.sgm.core.services.notificaciones;

import java.util.Date;

import ieci.tecdoc.sgm.core.services.dto.Entidad;

public interface ServicioNotificaciones {
	
	/**
	 * M�todo que actualiza el estado de las notificaciones
	 * @throws ServicioNotificacionesException
	 */
	 public void actualizaEstados(Entidad entidad) throws ServicioNotificacionesException;

	/**
	 * M�todo que actualiza el estado de una notificacion
	 * @param numeroExpediente N�mero de expediente de la notificacion
	 * @param estado Estado nuevo de la notificacion
	 * @param fechaActualizacion Fecha en la que se actualiza la notificacion
	 * @param nifDestino Nif del destinatario de la notificaci�n
	 * @throws ServicioNotificacionesException
	 */
	public void actualizaEstado(String numeroExpediente, Integer estado, 
    		Date fechaActualizacion, String nifDestino, String notiId, Entidad entidad) throws ServicioNotificacionesException;

	 /**
	  * M�todo que recupera un documento a partir de unos par�metros de b�suqueda
	  * @param poCriterio Par�metros de b�squeda
	  * @return Datos del documento
	  * @throws ServicioNotificacionesException
	  */
	 public InfoDocumento recuperaDocumento(CriterioBusquedaDocumentos poCriterio, Entidad entidad)	throws ServicioNotificacionesException;
	 
	 /**
	  * M�todo que devuelve el detalle de una notificaci�n
	  * @param poIdentificador Identificador de la notificaci�n
	  * @return Datos de la notificaci�n
	  * @throws ServicioNotificacionesException
	  */
	 public Notificacion detalleNotificacion (IdentificadorNotificacion poIdentificador, Entidad entidad) throws ServicioNotificacionesException;
	 public Notificacion detalleNotificacionByNotiId (String notiId, Entidad entidad) throws ServicioNotificacionesException;
	 
	 /**
	  * M�todo que devuelve una lista de notificaciones a partir de unos par�metros de b�squeda
	  * @param poCriterio Par�metros de b�squeda
	  * @param pbConDetalle Determina el detalle de los datos devueltos (true para mayor detalle)
	  * @return Lista de notificaciones
	  * @throws ServicioNotificacionesException
	  */
	 public Notificaciones consultarNotificaciones (CriterioBusquedaNotificaciones poCriterio, boolean pbConDetalle, Entidad entidad) throws ServicioNotificacionesException;
	 
	 /**
	  * M�todo que obtiene el estado de una notificaci�n
	  * @param psIdNotificacion Identificador de la notificaci�n
	  * @return Estado de la notificaci�n
	  * @throws ServicioNotificacionesException
	  */
	 public EstadoNotificacion obtenerEstado(String psIdNotificacion, Entidad entidad) throws ServicioNotificacionesException;
	 
	 /**
	  * M�todo que obtiene los datos de un estado de notificaci�n
	  * @param idEstado Identificador del estado de notificaci�n
	  * @return Estado de una notificacion
	  * @throws ServicioNotificacionesException
	  */
	 public EstadoNotificacionBD obtenerEstadoBD(Integer idEstado, Entidad entidad) throws ServicioNotificacionesException;
	 
	 /**
	  * M�todo que da de alta una notificaci�n
	  * @param poNotificacion Datos de la notificaci�n
	  * @return Identificador de la notificaci�n
	  * @throws ServicioNotificacionesException
	  */
	 public IdentificadorNotificacion altaNotificacion(Notificacion poNotificacion, Entidad entidad) throws ServicioNotificacionesException;
	
}
