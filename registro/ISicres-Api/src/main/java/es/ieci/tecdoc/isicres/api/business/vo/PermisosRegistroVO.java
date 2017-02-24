package es.ieci.tecdoc.isicres.api.business.vo;

/**
 * @author Iecisa Clase que tendr� los permisos en runtime sobre un determinado
 *         registro. Los registros pueden tener unos permisos u otros en funci�n
 *         de su estado en runtime, a pesar de que el usuario pueda tener
 *         permiso sobre �l. Ejemplo: si un registro est� distribuido no se
 *         puede modificar, est� bloqueado
 * 
 */
public class PermisosRegistroVO extends BasePermisosVO {

	private static final long serialVersionUID = -3676615199955004386L;

	protected boolean consulta;

	protected boolean creacion;

	protected boolean modificacion;

	public boolean isConsulta() {
		return consulta;
	}

	public void setConsulta(boolean consulta) {
		this.consulta = consulta;
	}

	public boolean isCreacion() {
		return creacion;
	}

	public void setCreacion(boolean creacion) {
		this.creacion = creacion;
	}

	public boolean isModificacion() {
		return modificacion;
	}

	public void setModificacion(boolean modificacion) {
		this.modificacion = modificacion;
	}

}
