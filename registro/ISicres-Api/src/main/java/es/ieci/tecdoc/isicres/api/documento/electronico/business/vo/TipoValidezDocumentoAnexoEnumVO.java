package es.ieci.tecdoc.isicres.api.documento.electronico.business.vo;

import org.apache.commons.lang.enums.ValuedEnum;

/**
 *  Indica la categor�a de autenticidad del documento:
		- �01� = Copia (el documento adjunto en el proceso de intercambio es una copia del original sin estar cotejada por ning�n organismo oficial y por tanto, sin validez jur�dica).
		- �02� = Copia compulsada (el documento adjunto en el proceso de intercambio es una copia del original y cotejada por un organismo oficial, y por tanto, con validez jur�dica).
		- �03� = Copia original (el documento adjunto en el proceso de intercambio es una copia del documento pero con exactamente la misma validez jur�dica que el original).
		- �04� = Original (el documento adjunto en el proceso de intercambio es original electr�nico).
 * 
 * @author Iecisa
 *
 */
public class TipoValidezDocumentoAnexoEnumVO extends ValuedEnum {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5780172255654304346L;
	
	 public static final int  COPIA_VALUE  = 1;
	 public static final int  COPIA_COMPULSADA_VALUE  = 2;
	 public static final int  COPIA_ORIGINAL_VALUE  = 3;
	 public static final int  ORIGINAL_VALUE  = 4;
	 
	 public static final String  COPIA_NAME= "01";
	 public static final String  COPIA_COMPULSADA_NAME  = "02";
	 public static final String COPIA_ORIGINAL_NAME  = "03";
	 public static final String  ORIGINAL_NAME  = "04";
	 
	 public static final TipoValidezDocumentoAnexoEnumVO COPIA= new TipoValidezDocumentoAnexoEnumVO(COPIA_NAME, COPIA_VALUE);
	 public static final TipoValidezDocumentoAnexoEnumVO COPIA_COMPULSADA= new TipoValidezDocumentoAnexoEnumVO(COPIA_COMPULSADA_NAME, COPIA_COMPULSADA_VALUE);
	 public static final TipoValidezDocumentoAnexoEnumVO COPIA_ORIGINAL = new TipoValidezDocumentoAnexoEnumVO(COPIA_ORIGINAL_NAME, COPIA_ORIGINAL_VALUE);
	 public static final TipoValidezDocumentoAnexoEnumVO ORIGINAL= new TipoValidezDocumentoAnexoEnumVO(ORIGINAL_NAME, ORIGINAL_VALUE);
	 
	
	protected TipoValidezDocumentoAnexoEnumVO(String name, int value) {
		super(name, value);
	}
	
	 public static TipoValidezDocumentoAnexoEnumVO getEnum(int valor) {
		return (TipoValidezDocumentoAnexoEnumVO) getEnum(TipoValidezDocumentoAnexoEnumVO.class,
				valor);
	}
}
