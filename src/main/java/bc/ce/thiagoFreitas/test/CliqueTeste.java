package bc.ce.thiagoFreitas.test;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import appium.core.BaseTest;
import bc.ce.thiagoFreitas.page.CliquePage;
import bc.ce.thiagoFreitas.page.MenuPage;

public class CliqueTeste extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private CliquePage cliquePage = new CliquePage();
	
	@Before
	public void inicializarAppium(){		
		menuPage.acessarCliques();
	}				
	
	@Test
	public void deveRealizarCliqueLongo() {

		//clique longo
		cliquePage.cliqueLongo();
		//verificar texto
		Assert.assertEquals("Clique Longo", cliquePage.obterTextoResultado());
	}
	
	@Test
	public void deveRealizarCliqueDuplo() {
		
		cliquePage.clicarPorTexto("Clique duplo");
		cliquePage.clicarPorTexto("Clique duplo");
		
		//verificar texto
		Assert.assertEquals("Duplo Clique", cliquePage.obterTextoResultado());
	}
	

}
