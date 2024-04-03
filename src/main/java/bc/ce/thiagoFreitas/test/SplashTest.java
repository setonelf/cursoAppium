package bc.ce.thiagoFreitas.test;

import org.junit.Assert;
import org.junit.Test;

import appium.core.BaseTest;
import bc.ce.thiagoFreitas.page.MenuPage;
import bc.ce.thiagoFreitas.page.SplashPage;

public class SplashTest extends BaseTest{
	
	private MenuPage menuPage = new MenuPage();
	private SplashPage splashPage = new SplashPage();
	
	@Test
	public void deveAguardarSplashSumir() {
		//Acessar menu splash
		menuPage.acessarSplash();
		
		//Verificar que o splash está sendo exibido
		splashPage.isTelaSplashVisible();
		
		//Aguardar a saida do splash
		splashPage.isTelaSplashNotVisible();
		
		//Verificar que o formulário está aparecendo
		Assert.assertTrue(menuPage.existeElementoPorTexto("Formulário"));
	}
}
