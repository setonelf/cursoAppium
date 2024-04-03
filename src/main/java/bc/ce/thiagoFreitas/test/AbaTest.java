package bc.ce.thiagoFreitas.test;

import org.junit.Assert;
import org.junit.Test;

import appium.core.BaseTest;
import bc.ce.thiagoFreitas.page.AbaPage;
import bc.ce.thiagoFreitas.page.MenuPage;

public class AbaTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private AbaPage abaPage = new AbaPage();
	
	@Test
	public void deveInteragirComAbas() {
		//Acessar menu abas
		menuPage.acessarAbas();
		
		//Verificar que está na aba 1
		Assert.assertTrue(abaPage.isAba1());
		
		//Acessar aba 2
		abaPage.clicaEmAbaDois();
		
		//Verificar que está na aba 2
		Assert.assertTrue(abaPage.isAba2());
	}
}
