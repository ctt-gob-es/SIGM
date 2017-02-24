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

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.ieci.tecdoc.fwktd.sir.core.exception.SIRException;

/**
 * Implementaci�n del manager de generaci�n de c�digos hash.
 * 
 * @author cmorenog
 * 
 */
public class UtilsHash {

    private static final Logger logger = LoggerFactory.getLogger(UtilsHash.class);

    private static final String DEFAULT_ALGORITMO = "SHA-1";

    /** 
     */
    public byte[] generarHash(byte[] contenido) {

	byte[] hash = null;

	logger.info("Generando c�digo hash");

	if (contenido != null) {

	    String algoritmoHash = null;

	    try {

		logger.info("Algorimo para el hash: [{}]", algoritmoHash);

		MessageDigest md = MessageDigest.getInstance(DEFAULT_ALGORITMO);
		md.update(contenido);
		hash = md.digest();

		if (logger.isInfoEnabled()) {
		    logger.info("C�digo hash generado [{}]: {}", algoritmoHash,
			    Base64.encodeBase64String(hash));
		}
	    }
	    catch (NoSuchAlgorithmException e) {
		logger.error("Error al generar el c�digo hash", e);
		throw new SIRException("error.sir.generarHash", new String[] { algoritmoHash },
			e.getMessage());
	    }
	}

	return hash;
    }

    public static String getBase64Sring(byte[] dato) {
	String result = null;
	if (dato != null){
	    result = Base64.encodeBase64String(dato);
	}
	return result;
    }
}
