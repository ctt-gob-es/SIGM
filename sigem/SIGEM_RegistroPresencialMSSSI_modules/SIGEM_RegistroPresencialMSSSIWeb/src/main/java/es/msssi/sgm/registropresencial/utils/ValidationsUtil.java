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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

/**
 * Clase para gestionar las validaciones realizadas sobre las pantallas.
 * 
 */
public class ValidationsUtil {

    public enum TipoUltCaracter {
        NUMERO, LETRA, AMBOS
    };

    public enum TipoIdentificador {
        NIF, NIE, CIF, Pasaporte, Desconocido
    };

    /**
     * Método que valida el tipo de identificación, en el caso de encontrar
     * incidencias o errores lanza excepciones del tipo LibraeException para
     * mostrarlas mediante mensajes popup en la pantalla.
     * 
     * @param tipoIdentificador
     *            tipo de identificación a validar
     * @param identificador
     *            cadena alfanumérica asociada al tipo de identificación a
     *            validar
     */
    public static void validarIdentificador(String tipoIdentificador,
            String identificador) {
        if (tipoIdentificador != null) {
            switch (TipoIdentificador.valueOf(tipoIdentificador)) {
                case NIF:
                    if (null != identificador) {
                        String ident = identificador.toUpperCase();
                        ValidationsUtil.validarNIF(ident);
                    }
                    break;
                case NIE:
                    if (null != identificador) {
                        String ident = identificador.toUpperCase();
                        ValidationsUtil.validarNIE(ident);
                    }
                    break;
                case CIF:
                    if (null != identificador) {
                        String ident = identificador.toUpperCase();
                        ValidationsUtil.validarCIF(ident);
                    }
                    break;
                default:
                    break;
            }

        }
    }

    /**
     * Método que valida el tipo de documento NIE.
     * 
     * @param nie
     *            cadena alfanumérica asociada al tipo de identificación a
     *            validar
     */
    private static void validarNIE(String nie) {

        if (null != nie) {

            // Se comprueba la validez del primer caracter {X,Y,Z}
            if ("XYZ".indexOf(nie.charAt(0)) == -1) {
                throw new ValidatorException(new FacesMessage(
			"El n�mero de identificaci�n no es v�lido"));
            }

            // Se comprueba la longitud correcta del NIE
            if (nie.length() != 9) {
                throw new ValidatorException(new FacesMessage(
			"El n�mero de identificaci�n no es v�lido"));
            }

            String nieUP = nie.toUpperCase();
            String nieval = nieUP.substring(1, 9);
            Pattern mask = Pattern.compile("[0-9]{7}[A-Z]?");
            Matcher matcher = mask.matcher(nieval);

            // Se comprueba la validez del formato
            if (!matcher.matches()) {
                throw new ValidatorException(new FacesMessage(
			"El n�mero de identificaci�n no es v�lido"));
            }

            // Se genera un documento NIF considerando la letra X de comienzo
            if (nieUP.charAt(0) == 'X') {
                nieval = "0".concat(nieval);
            }

            // Se genera un documento NIF considerando la letra Y de comienzo
            if (nieUP.charAt(0) == 'Y') {
                nieval = "1".concat(nieval);
            }

            // Se genera un documento NIF considerando la letra Z de comienzo
            if (nieUP.charAt(0) == 'Z') {
                nieval = "2".concat(nieval);
            }

            // Se realiza la misma validación que para el NIF
            ValidationsUtil.validarNIF(nieval);
        }
    }

    /**
     * Método que valida el tipo de documento NIF.
     * 
     * @param nif
     *            cadena alfanumérica asociada al tipo de identificación a
     *            validar
     */
    private static void validarNIF(String nif) {

        if (null != nif) {
            String nifUP = nif.toUpperCase();
            Pattern mask = Pattern.compile("[0-9]{8}[A-Z]?");
            Matcher matcher = mask.matcher(nifUP);

            // Se comprueba la validez del formato
            if (!matcher.matches()) {
                throw new ValidatorException(new FacesMessage(
			"El n�mero de identificaci�n no es v�lido"));
            }

            char ultimoCar = nifUP.charAt(nifUP.length() - 1);

            // Se comprueba que el último caracter sea una letra
            if (ultimoCar >= 'A' && ultimoCar <= 'Z') {
                // Se establece el conjunto de letras válidos
                String letras = "TRWAGMYFPDXBNJZSQVHLCKE";

                String dni = nifUP.substring(0, 8);
                String digitoControl = nifUP.substring(8, 9);

                // Se calcula la letra de control
                int posicion_modulo = Integer.parseInt(dni) % 23;

                String digitoControlCalculado = letras.substring(
                        posicion_modulo, posicion_modulo + 1);

                // Se comprueba la validez de la letra de control
                if (!digitoControl.equalsIgnoreCase(digitoControlCalculado)) {
                    throw new ValidatorException(new FacesMessage(
    			"El n�mero de identificaci�n no es v�lido"));
                }
            }else {
                throw new ValidatorException(new FacesMessage(
			"El n�mero de identificaci�n no es v�lido"));
            }
        }
    }


    /**
     * Realiza la validacion si la cadena representa un CIF
     * 
     * @param strCadena
     *            la cadena a comprobar
     * @return true si la cadena representa un CIF del tipo indicado
     */
    private static void validarCIF(String cif) {
	try{
	    if (cif != null && !"".equals(cif)){
        	Validador val = new Validador();
        	int ret = val.checkNif(cif);
        	if (ret <= 0){
        	    throw new ValidatorException(new FacesMessage(
    			"El n�mero de identificaci�n no es v�lido"));
        	}
	    }
	}catch (Exception e){
	    throw new ValidatorException(new FacesMessage(
			"El n�mero de identificaci�n no es v�lido"));
	}
    }
}