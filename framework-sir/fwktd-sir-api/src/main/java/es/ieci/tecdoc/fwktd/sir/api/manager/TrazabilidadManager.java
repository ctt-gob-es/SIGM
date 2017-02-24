package es.ieci.tecdoc.fwktd.sir.api.manager;

import java.util.List;

import es.ieci.tecdoc.fwktd.sir.core.vo.TrazabilidadVO;

public interface TrazabilidadManager {

	/**
	 * Consulta los estados de trazabilidad insertados asociados a un
	 * intercambio.
	 *
	 * @param codEntReg
	 *            C�digo de la Entidad Registral.
	 * @param codigoIntercambio
	 *            C�digo �nico de intercambio de registro.
	 * @param isRegistro
	 *            Flag que indica si se trata de un registro o un mensaje.
	 *            True-Fichero de intercambio, False-Fichero de mensaje.
	 * @param soloEstadoFinal
	 *            Flag que indica si se desean recuperar todos los estados, o
	 *            �nicamente los finales (Enviado, Reenviado, Rechazado o
	 *            Confirmado). True: indica que se quieren recuperar solo los
	 *            estados finales. False: se recuperar�n todos los estados.
	 * @return Informaci�n de la trazabilidad.
	 */
	public List<TrazabilidadVO> getTrazabilidad(String codEntReg,
			String codigoIntercambio, boolean isRegistro,
			boolean soloEstadoFinal);

	/**
	 * Inserta una traza asociada a un intercambio.
	 * 
	 * @param traza
	 *            Informaci�n de la trazabilidad.
	 * @return
	 */
	public void insertarTrazabilidad(TrazabilidadVO traza);

}
