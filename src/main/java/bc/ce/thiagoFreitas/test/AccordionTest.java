package bc.ce.thiagoFreitas.test;

import org.junit.Assert;
import org.junit.Test;

import appium.core.BaseTest;
import bc.ce.thiagoFreitas.page.AccordionPage;
import bc.ce.thiagoFreitas.page.MenuPage;

public class AccordionTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private AccordionPage accordionPage = new AccordionPage();
	
	@Test
	public void verificaAccordion() {
		//Acessar menu Accordion
		menuPage.acessarAccordion();
		
		// Clicar na opção 1
		accordionPage.clickOpcao1();
		
		//Verificar texto
		Assert.assertTrue(accordionPage.isTextoOpacao1Visivel());
	}
}
