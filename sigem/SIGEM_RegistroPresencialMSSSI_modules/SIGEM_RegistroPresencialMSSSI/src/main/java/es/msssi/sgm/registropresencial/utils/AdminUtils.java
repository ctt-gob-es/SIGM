/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.sgm.registropresencial.utils;

import java.util.ArrayList;
import java.util.List;
 
import es.msssi.sgm.registropresencial.beans.ibatis.Permission;
import es.msssi.sgm.registropresencial.beans.ibatis.Profile;
import es.msssi.sgm.registropresencial.beans.ibatis.User;
 
public class AdminUtils {
    /**
     * Establece los permisos del elemento invesDoc por defecto.
     * 
     * @return lista de permisos.
     */

    public List<Permission> setDefaultPerms() {
	Permission perm;
	List<Permission> permissions = new ArrayList<Permission>();

	perm =
	    new Permission(
		SIGMADMINConstants.DESTINATION_USER, -1, SIGMADMINConstants.PRODUCT_IDOC,
		SIGMADMINConstants.PERMISSION_NONE);
	permissions.add(perm);
	perm =
	    new Permission(
		SIGMADMINConstants.DESTINATION_USER, -1, SIGMADMINConstants.PRODUCT_ISICRES,
		SIGMADMINConstants.PERMISSION_NONE);
	permissions.add(perm);
	perm =
	    new Permission(
		SIGMADMINConstants.DESTINATION_USER, -1, SIGMADMINConstants.PRODUCT_IFLOW,
		SIGMADMINConstants.PERMISSION_NONE);
	permissions.add(perm);
	return permissions;
    }
    
    /**
     * Establece los perfiles del elemento invesDoc por defecto.
     * 
     * @return lista de perfiles.
     */

    public List<Profile> setDefaultProfile(User selectedUser) {
	Profile profile;
	List<Profile> profiles = new ArrayList<Profile>();

	profile = new Profile(
	    -1, SIGMADMINConstants.APLICACION_ADMINISTRACION, SIGMADMINConstants.PROFILE_NONE);
	profiles.add(profile);
	profile =
	    new Profile(
		-1, SIGMADMINConstants.APLICACION_ESTRUCTURA_ORGANIZATIVA,
		SIGMADMINConstants.PROFILE_NONE);
	profiles.add(profile);

	profile =
	    new Profile(
		-1, SIGMADMINConstants.APLICACION_CATALOGO_PROCEDIMIENTOS,
		SIGMADMINConstants.PROFILE_STANDARD);
	profiles.add(profile);
	profile = new Profile(
	    -1, SIGMADMINConstants.APLICACION_ARCHIVO, SIGMADMINConstants.PROFILE_STANDARD);
	profiles.add(profile);
	profile = new Profile(
	    -1, SIGMADMINConstants.APLICACION_REGISTRO, selectedUser.getUserProfileType());
	profiles.add(profile);
	profile =
	    new Profile(
		-1, SIGMADMINConstants.APLICACION_REPOSITORIOS_DOCUMENTALES,
		SIGMADMINConstants.PROFILE_NONE);
	profiles.add(profile);
	profile = new Profile(
	    -1, SIGMADMINConstants.APLICACION_CATALOGO_TRAMITES, SIGMADMINConstants.PROFILE_NONE);
	profiles.add(profile);
	profile = new Profile(
	    -1, SIGMADMINConstants.APLICACION_USUARIOS_PORTAL, SIGMADMINConstants.PROFILE_NONE);
	profiles.add(profile);
	profile =
	    new Profile(
		-1, SIGMADMINConstants.APLICACION_CONSULTA_EXPEDIENTES,
		SIGMADMINConstants.PROFILE_NONE);
	profiles.add(profile);
	profile =
	    new Profile(
		-1, SIGMADMINConstants.APLICACION_CONSULTA_REGISTROS_TELEMATICOS,
		SIGMADMINConstants.PROFILE_NONE);
	profiles.add(profile);
	return profiles;
    }
    
}
