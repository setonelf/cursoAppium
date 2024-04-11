package bc.ce.thiagoFreitas.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import appium.core.BaseTest;
import bc.ce.thiagoFreitas.page.MenuPage;

public class SwipeTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	
	
	@Test
	public void deveRealizarSwipe() {
		//Acessar menu
		menuPage.acessarSwipe();
		
		// Verificar Texto 'a esquerda'
		Assert.assertTrue(menuPage.existeElementoPorTexto("a esquerda"));
		
		//Swipe para direita
		menuPage.swipeRight();;
		
		//Verificar texto 'e veja se consegue'
		Assert.assertTrue(menuPage.existeElementoPorTexto("E veja se"));
		
		//clicar botao direita
		menuPage.clicarPorTexto("›");
		
		//validar frase final 'chegar ate o fim!'
		Assert.assertTrue(menuPage.existeElementoPorTexto("Chegar até o fim!"));
		
		// swipe esquerda
		menuPage.swipeLeft();;
		
		// clicar no botao da esquerda
		menuPage.clicarPorTexto("‹");
		
		// Verificar primeira frase 'a esquerda'
		Assert.assertTrue(menuPage.existeElementoPorTexto("a esquerda"));
	}
}
