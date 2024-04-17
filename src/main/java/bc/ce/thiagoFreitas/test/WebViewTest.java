package bc.ce.thiagoFreitas.test;

import org.junit.Assert;
import org.junit.Test;

import appium.core.BaseTest;
import bc.ce.thiagoFreitas.page.MenuPage;
import bc.ce.thiagoFreitas.page.WebViewPage;

public class WebViewTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private WebViewPage webViewPage =  new WebViewPage();
	
	@Test
	public void deveFazerLogin() {
		//acessar o menu
		menuPage.acessarSeuBarrigaHibrido();
		esperar(3000);
		webViewPage.entrarContextoWeb();
		
		//preencher email
		webViewPage.setEmail("tf@email.com");
		
		//preencher senha
		webViewPage.setPassword("1234");
		
		//entrar
		webViewPage.clickButtonEntrar();
		
		//verificar mensagem de sucesso
		Assert.assertEquals("Bem vindo, TF!", webViewPage.getTextSuccess());
	}
}
