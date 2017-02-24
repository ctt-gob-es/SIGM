package es.ieci.tecdoc.isicres.api.business.manager.impl;

import java.util.List;

import net.sf.hibernate.Session;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.ieci.tecdoc.common.AuthenticationUser;
import com.ieci.tecdoc.common.invesdoc.Iuseruserhdr;
import com.ieci.tecdoc.common.invesdoc.Iuserusertype;
import com.ieci.tecdoc.common.invesicres.ScrOfic;
import com.ieci.tecdoc.common.isicres.SessionInformation;
import com.ieci.tecdoc.common.keys.HibernateKeys;
import com.ieci.tecdoc.common.keys.IDocKeys;
import com.ieci.tecdoc.common.keys.ServerKeys;
import com.ieci.tecdoc.common.utils.ISicresGenPerms;
import com.ieci.tecdoc.idoc.authentication.InvesDocAuthenticationPolicy;
import com.ieci.tecdoc.idoc.utils.ConfiguratorInvesicres;
import com.ieci.tecdoc.isicres.session.security.SecuritySession;
import com.ieci.tecdoc.isicres.session.utils.UtilsSession;
import com.ieci.tecdoc.utils.HibernateUtil;
import com.ieci.tecdoc.utils.cache.CacheBag;
import com.ieci.tecdoc.utils.cache.CacheFactory;

import es.ieci.tecdoc.fwktd.core.spring.configuration.jdbc.datasource.MultiEntityContextHolder;
import es.ieci.tecdoc.isicres.api.business.exception.LoginException;
import es.ieci.tecdoc.isicres.api.business.helper.UsuarioHelper;
import es.ieci.tecdoc.isicres.api.business.manager.ContextoAplicacionManager;
import es.ieci.tecdoc.isicres.api.business.manager.ContextoAplicacionManagerFactory;
import es.ieci.tecdoc.isicres.api.business.manager.LoginManager;
import es.ieci.tecdoc.isicres.api.business.manager.impl.mapper.ScrOficToOficinaVOMapper;
import es.ieci.tecdoc.isicres.api.business.vo.BaseOficinaVO;
import es.ieci.tecdoc.isicres.api.business.vo.PermisosAplicacionVO;
import es.ieci.tecdoc.isicres.api.business.vo.PermisosUsuarioVO;
import es.ieci.tecdoc.isicres.api.business.vo.UsuarioVO;

public class LoginLegacyManagerImpl implements LoginManager {

	private static final Logger logger = Logger
			.getLogger(LoginLegacyManagerImpl.class);

	protected ContextoAplicacionManager getContextoAplicacionManager() {
		return ContextoAplicacionManagerFactory.getInstance();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * es.ieci.tecdoc.isicres.api.business.manager.LoginManager#login(es.ieci
	 * .tecdoc.isicres.api.business.vo.UsuarioVO)
	 */
	public UsuarioVO login(UsuarioVO usuario) {
		usuario = UsuarioHelper.validateUsusario(usuario);
		try {
			String sessionID = SecuritySession.login(usuario.getLoginName(),
					usuario.getPassword(), usuario.getConfiguracionUsuario()
							.getOficina().getCodigoOficina(), usuario
							.getConfiguracionUsuario().getLocale(), usuario
							.getConfiguracionUsuario().getIdEntidad());

			usuario.getConfiguracionUsuario().setSessionID(sessionID);

			CacheBag cacheBag = CacheFactory.getCacheInterface().getCacheEntry(
					sessionID);

			ScrOfic scrOfic = (ScrOfic) cacheBag
					.get(HibernateKeys.HIBERNATE_ScrOfic);


			// Si el usuario no tiene oficina hay que comprobar que no se le
			// pasa ninguna oficina en el login
			if (scrOfic == null) {
				if (StringUtils.isNotEmpty(usuario.getConfiguracionUsuario()
						.getOficina().getCodigoOficina())) {
					StringBuffer sb = new StringBuffer("El usuario [")
							.append(usuario.getLoginName())
							.append("] no ha podido hacer login en la oficina con codigo [")
							.append(usuario.getConfiguracionUsuario()
									.getOficina().getCodigoOficina())
							.append("]");
					throw new LoginException(sb.toString(),
							new IllegalArgumentException(
									"El c�digo de oficina ["
											+ usuario.getConfiguracionUsuario()
													.getOficina()
													.getCodigoOficina()
											+ "] no esta asociado al usuario ["
											+ usuario.getLoginName() + "]."));
				}

			} else {
				// Si no se le pasa oficina en el m�todo entonces establecemos
				// la
				// oficina por defecto en la configuraci�n del usuario.
				if (StringUtils.isEmpty(usuario.getConfiguracionUsuario()
						.getOficina().getCodigoOficina())) {
					usuario.getConfiguracionUsuario().getOficina()
							.setCodigoOficina(scrOfic.getCode());
				}

				// La oficina asociada al usuario debe ser la misma que la que
				// se
				// indique en el parametro de llamada al metodo de login
				if (StringUtils.equals(scrOfic.getCode(), usuario
						.getConfiguracionUsuario().getOficina()
						.getCodigoOficina())) {

					usuario.getConfiguracionUsuario().setOficina(
							new ScrOficToOficinaVOMapper().map(scrOfic));
				} else {
					StringBuffer sb = new StringBuffer("El usuario [")
							.append(usuario.getLoginName())
							.append("] no ha podido hacer login en la oficina con codigo [")
							.append(usuario.getConfiguracionUsuario()
									.getOficina().getCodigoOficina())
							.append("]");
					throw new LoginException(sb.toString(),
							new IllegalArgumentException(
									"El c�digo de oficina ["
											+ usuario.getConfiguracionUsuario()
													.getOficina()
													.getCodigoOficina()
											+ "] no esta asociado al usuario ["
											+ usuario.getLoginName() + "]."));
				}
			}

			AuthenticationUser userLogin = SecuritySession
					.getUserLogin(sessionID);

			usuario.setId(String.valueOf(userLogin.getId().intValue()));

			// Extraemos la informacion de la session para sacar el nombre
			// completo
			SessionInformation sessionInformation = UtilsSession
					.getSessionInformation(sessionID, usuario
							.getConfiguracionUsuario().getLocale(), usuario
							.getConfiguracionUsuario().getIdEntidad());
			usuario.setFullName(sessionInformation.getUserName());

			usuario.getConfiguracionUsuario().setProfile(
					String.valueOf(((Iuserusertype) cacheBag
							.get(HibernateKeys.HIBERNATE_Iuserusertype))
							.getType()));

			//
			// if (scrtmzofic != null) {
			// cacheBag.put(HIBERNATE_ScrTmzofic, scrtmzofic);
			// }
			// cacheBag.put(HIBERNATE_Iuserusertype, userType);

			// TODO setear usuario y oficina actual, permisos, etc etc
			MultiEntityContextHolder.setEntity(usuario
					.getConfiguracionUsuario().getIdEntidad());

			ContextoAplicacionManager contextoAplicacionManager = getContextoAplicacionManager();

			contextoAplicacionManager.setUsuarioActual(usuario);
			BaseOficinaVO oficinaActual = usuario.getConfiguracionUsuario()
					.getOficina();
			contextoAplicacionManager.setOficinaActual(oficinaActual);

			// permisos de aplicacion
			PermisosAplicacionVO permisosAplicacion = new PermisosAplicacionVO();
			ISicresGenPerms perms = (ISicresGenPerms) cacheBag
					.get(ServerKeys.GENPERMS_USER);

			// superusuario
			Iuserusertype userType = (Iuserusertype) cacheBag
					.get(HibernateKeys.HIBERNATE_Iuserusertype);
			boolean superUsuario = userType.getType() == IDocKeys.IUSERUSERTYPE_USER_TYPE_ADMIN;
			permisosAplicacion.setSuperUsuario(superUsuario);

			// terceros
			boolean altaTerceros = perms.canCreatePersons();
			permisosAplicacion.setAltaTerceros(altaTerceros);

			boolean modificacionTerceros = perms.canUpdatePersons();
			permisosAplicacion.setModificacionTerceros(modificacionTerceros);

			// distribucion
			boolean distribucionManual = perms.isCanDistRegisters();
			permisosAplicacion.setDistribucionManual(distribucionManual);

			boolean aceptarDistribucion = perms.isCanAcceptRegisters();
			permisosAplicacion.setAceptarDistribucion(aceptarDistribucion);

			boolean rechazarDistribucion = perms.isCanRejectRegisters();
			permisosAplicacion.setRechazarDistribucion(rechazarDistribucion);

			boolean archivarDistribucion = perms.isCanArchiveRegisters();
			permisosAplicacion.setArchivarDistribucion(archivarDistribucion);

			boolean cambiarDestinoDistribucion = perms
					.isCanChangeDestRegisters();
			permisosAplicacion
					.setCambiarDestinoDistribucion(cambiarDestinoDistribucion);

			boolean cambiarDestinoDistribucionRechazada = perms
					.isCanChangeDestRejectRegisters();
			permisosAplicacion
					.setCambiarDestinoDistribucionRechazada(cambiarDestinoDistribucionRechazada);

			// fechas de registro
			boolean altaFechaRegistro = perms.canIntroRegDate();
			permisosAplicacion.setAltaFechaRegistro(altaFechaRegistro);

			boolean modificarFechaRegistro = perms.canUpdateRegDate();
			permisosAplicacion
					.setModificarFechaRegistro(modificarFechaRegistro);

			// actualizar campos protegidos
			boolean modificarCamposProtegidos = perms
					.canUpdateProtectedFields();
			permisosAplicacion
					.setModificarCamposProtegidos(modificarCamposProtegidos);

			// consultar documentacion anexa
			boolean consultarDocuAnexa = perms.isCanShowDocuments();
			permisosAplicacion.setConsultarDocuAnexa(consultarDocuAnexa);

			// intercambio registral
			boolean operacionesIntercambioRegistral = perms.canAccessRegInterchange();
			permisosAplicacion
					.setOperacionesIntercambioRegistral(operacionesIntercambioRegistral);

			PermisosUsuarioVO permisosUsuario = new PermisosUsuarioVO();
			permisosUsuario.setPermisosAplicacion(permisosAplicacion);
			usuario.setPermisos(permisosUsuario);

			// XXX: Hace falta hacer esto para evitar que la clase
			// ConfiguratorInvesicres cierre conexiones cuando no debe
			ConfiguratorInvesicres.getInstance(usuario
					.getConfiguracionUsuario().getIdEntidad());

		} catch (Exception e) {
			logger.error("Error en el login del usuario ["
					+ usuario.getLoginName() + "]", e);
			throw new LoginException("Error en el login del usuario ["
					+ usuario.getLoginName() + "]", e);
		}

		return usuario;
	}

	/**
	 *
	 * @param id
	 * @param entidad
	 * @return
	 *
	 * @deprecated se desaconseja el uso de este m�todo. Se ha tenido que hacer
	 *             �nicamente para dar soporte a una funcionalidad de los
	 *             servicios Web.
	 */
	public AuthenticationUser getUserInfo(String id, String entidad) {
		AuthenticationUser authenticationUser = null;
		HibernateUtil hibernateUtil = new HibernateUtil();
		try {
			Session session = hibernateUtil.currentSession(entidad);

			Iuseruserhdr user = (Iuseruserhdr) session.load(Iuseruserhdr.class,
					Integer.valueOf(id));

			authenticationUser = new AuthenticationUser();
			authenticationUser.setId(user.getId());
			authenticationUser.setName(user.getName());
			authenticationUser.setDeptid(new Integer(user.getDeptid()));

			InvesDocAuthenticationPolicy authenticationPolicy = new InvesDocAuthenticationPolicy();
			List deptList = authenticationPolicy.getUserDeptList(Integer
					.valueOf(id), entidad);
			authenticationUser.setDeptList(deptList);

		} catch (Exception e) {
			StringBuffer sb = new StringBuffer(
					"No se ha podido cargar la informaci�n del usuario con identificador [")
					.append(id).append("]");
			logger.error(sb.toString(), e);

			throw new LoginException(sb.toString());
		} finally {
			hibernateUtil.closeSession(entidad);
			
		}

		return authenticationUser;

	}

	public void logout(UsuarioVO usuario) {

		try {

			SecuritySession.logout(usuario.getConfiguracionUsuario()
					.getSessionID(), usuario.getConfiguracionUsuario()
					.getIdEntidad());

		} catch (Exception e) {
			logger.error(
					"Error en el logout del usuario [" + usuario.getLoginName()
							+ "]", e);

			throw new LoginException("Error en el logout del usuario ["
					+ usuario.getLoginName() + "]", e);
		}
	}

}
