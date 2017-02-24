package es.ieci.tecdoc.fwktd.sir.api.manager.impl;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import es.ieci.tecdoc.fwktd.test.db.AbstractDbUnitTransactionalJUnit4SpringContextTests;
import es.ieci.tecdoc.fwktd.test.db.annotation.DatasetLocation;

@DatasetLocation("data/dataset.xml")
@ContextConfiguration({ 
	"/beans/fwktd-sir-test-beans-initial-custom.xml",
	"/beans/fwktd-sir-api-applicationContext.xml",
	"/beans/fwktd-sir-test-beans-custom.xml" })
public class ValidacionAnexosManagerImplTest extends
		AbstractDbUnitTransactionalJUnit4SpringContextTests {

//	@Autowired
//	private AsientoRegistralManager fwktd_sir_asientoRegistralManager;
//
//	@Autowired
//	private ValidacionAnexosManager fwktd_sir_validacionAnexosManagerImpl;
//
//	public ValidacionAnexosManager getValidacionAnexosManager() {
//		return fwktd_sir_validacionAnexosManagerImpl;
//	}

	@Test
	public void testManager() {
//		Assert.assertNotNull("ValidacionAnexosManager nulo", getValidacionAnexosManager());
	}

//	@Test
//	public void testValidarAnexos() {
//
//		AsientoRegistralVO asiento = null;
//
//		try {
//
//			// Crear el asiento registral con sus documentos
//			asiento = fwktd_sir_asientoRegistralManager.saveAsientoRegistral(TestUtils.createDefaultAsientoRegistralFormVO());
//
//			List<ValidacionAnexoVO> validaciones = getValidacionAnexosManager().validarAnexos(asiento.getId());
//			Assert.assertNotNull("Listado de validaciones nulo", validaciones);
//			Assert.assertTrue("El n�mero de validaciones no es correcto", validaciones.size() == 4);
//
//			// Anexo con firma
//			ValidacionAnexoVO validacionAnexo = validaciones.get(0);
//			Assert.assertNotNull("Validaci�n nula", validacionAnexo);
//			Assert.assertNotNull("No se ha encontrado el anexo", validacionAnexo.getAnexo());
//			Assert.assertTrue("El hash no es v�lido", validacionAnexo.isHashValidado());
//			Assert.assertTrue("El certificado no es v�lido", ValidacionCertificadoEnum.CERTIFICADO_EXPIRADO == validacionAnexo.getValidacionCertificado());
//			Assert.assertTrue("Validaci�n OCSP del certificado no es v�lida", validacionAnexo.isValidacionOCSPCertificado());
//			Assert.assertTrue("La firma no es v�lida", ValidacionFirmaEnum.FIRMA_VALIDA == validacionAnexo.getValidacionFirma());
//
//			// Anexo con firma embebida
//			validacionAnexo = validaciones.get(1);
//			Assert.assertNotNull("Validaci�n nula", validacionAnexo);
//			Assert.assertNotNull("No se ha encontrado el anexo", validacionAnexo.getAnexo());
//			Assert.assertTrue("El hash no es v�lido", validacionAnexo.isHashValidado());
//			Assert.assertTrue("El certificado no es v�lido", ValidacionCertificadoEnum.CERTIFICADO_EXPIRADO == validacionAnexo.getValidacionCertificado());
//			Assert.assertTrue(!validacionAnexo.isValidacionOCSPCertificado());
//			Assert.assertTrue("La firma no es v�lida", ValidacionFirmaEnum.FIRMA_EMBEBIDA == validacionAnexo.getValidacionFirma());
//
//			// Anexo con firma externa
//			validacionAnexo = validaciones.get(2);
//			Assert.assertNotNull("Validaci�n nula", validacionAnexo);
//			Assert.assertNotNull("No se ha encontrado el anexo", validacionAnexo.getAnexo());
//			Assert.assertTrue("El hash no es v�lido", validacionAnexo.isHashValidado());
//			Assert.assertTrue("El certificado no es v�lido", ValidacionCertificadoEnum.CERTIFICADO_EXPIRADO == validacionAnexo.getValidacionCertificado());
//			Assert.assertTrue(!validacionAnexo.isValidacionOCSPCertificado());
//			Assert.assertTrue("La firma no es v�lida", ValidacionFirmaEnum.FIRMA_VALIDA == validacionAnexo.getValidacionFirma());
//
//			// Anexo con la firma del anexo anterior
//			validacionAnexo = validaciones.get(3);
//			Assert.assertNotNull("Validaci�n nula", validacionAnexo);
//			Assert.assertNotNull("No se ha encontrado el anexo", validacionAnexo.getAnexo());
//			Assert.assertTrue("El hash no es v�lido", validacionAnexo.isHashValidado());
//			Assert.assertTrue("El certificado no es v�lido", ValidacionCertificadoEnum.SIN_CERTIFICADO == validacionAnexo.getValidacionCertificado());
//			Assert.assertTrue(!validacionAnexo.isValidacionOCSPCertificado());
//			Assert.assertTrue("La firma no es v�lida", ValidacionFirmaEnum.SIN_FIRMA == validacionAnexo.getValidacionFirma());
//
//		} finally {
//			if (asiento != null) {
//				fwktd_sir_asientoRegistralManager.deleteAsientoRegistral(asiento.getId());
//			}
//		}
//	}
}
