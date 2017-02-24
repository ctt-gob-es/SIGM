package ieci.tecdoc.sgm.core.services.cripto.firma;

import java.security.PublicKey;
import java.security.cert.X509Certificate;

public interface ServicioFirmaDigital {

	/**
	 * M�todo que firma un conjunto de datos
	 * @param pbaB64Source Datos firmar
	 * @return Datos firmados
	 * @throws FirmaDigitalException
	 */
	 public String firmar(byte[] pbaB64Source) throws FirmaDigitalException;
	 
	 /**
	  * M�todo que valida la firma de datos
	  * @param pabB64SourceSigned Firma
	  * @param signedContentB64 Datos 
	  * @return Datos del resultado de la validaci�n
	  * @throws FirmaDigitalException
	  */
	 public ResultadoValidacionFirma validarFirma(byte[] pabB64SourceSigned , byte [] signedContentB64) throws FirmaDigitalException;

	 /**
	  * Recoge la informaci�n de un certificado de servidor
	  * @return certificado tipo X509
	  * @throws FirmaDigitalException Si se produce alg�n error
	  */
	 public CertificadoX509Info getcertInfo() throws FirmaDigitalException;
	 
	 
	 /**
	  * El usuario, mediante el Componente Cliente de Firma, 
	  * selecciona en su m�quina el documento a firmar, llev�ndose a cabo el 
	  * proceso de firma en la propia m�quina del usuario, usando su certificado 
	  * de usuario. Esta fase es la primera. Posteriormente (fase 2)- se env�a la 
	  * informaci�n pertinente a la plataforma que finalizar� dicha transacci�n
	  * de firma
	  * @param signatureValue Firma realizada por el applet de @firma
	  * @param signCertificateValue Certificado del usuario con el que se ha realizado la firma
	  * @param hash Hash del documento .
	  * @return Identificador de la transacci�n de la firma
	  * @throws FirmaDigitalException
	  */
	public String registrarFirma(byte[] signatureValue, byte[]  signCertificateValue, byte[] hash) throws FirmaDigitalException;
}
