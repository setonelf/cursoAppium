package bc.ce.thiagoFreitas.test;

import org.junit.Assert;
import org.junit.Test;

import appium.core.BaseTest;
import bc.ce.thiagoFreitas.page.AlertaPage;
import bc.ce.thiagoFreitas.page.MenuPage;

public class AlertTeste extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private AlertaPage alertaPage = new AlertaPage();
	
	@Test
	public void deveConfirmarAlerta() {
		// Deve acessar menu alerta
		menuPage.acessarAlertas();		
		
		// Clicar em alerta confirm
		alertaPage.clicarAlertaConfirm();
		
		// Verificar os textos
		Assert.assertEquals("Info", alertaPage.obterTituloAlerta());
		Assert.assertEquals("Confirma a operação?", alertaPage.obterTextoAlerta());
		
		// Confirmar o alerta
		alertaPage.clicarConfirmarNoAlerta();
		
		// Verificar nova mensagem
		Assert.assertEquals("Info", alertaPage.obterTituloAlerta());
		Assert.assertEquals("Confirmado", alertaPage.obterTextoAlerta());
		
		// sair
		alertaPage.clicarSairNoAlerta();
	}
}
