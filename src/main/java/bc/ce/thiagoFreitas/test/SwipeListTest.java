package bc.ce.thiagoFreitas.test;

import org.junit.Assert;
import org.junit.Test;
import appium.core.BaseTest;
import bc.ce.thiagoFreitas.page.MenuPage;
import bc.ce.thiagoFreitas.page.SwipeListPage;

public class SwipeListTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private SwipeListPage swipeListPage = new SwipeListPage();
	
	@Test
	public void desafioLista() {
		//clicar em swipe list
		menuPage.acessarSwipeList();
		
		//op 1 para esquerda
		swipeListPage.arrastarParaEsquerda("Opção 1");
		
		//op 1 +
		swipeListPage.clicarBotaoMais();
		
		// verificar op1
		Assert.assertTrue(menuPage.existeElementoPorTexto("Opção 1 (+)"));
		
		//op4 para equerda
		swipeListPage.arrastarParaEsquerda("Opção 4");
		
		//op4 -
		menuPage.clicarPorTexto("(-)");
		
		// verificar op4
		Assert.assertTrue(menuPage.existeElementoPorTexto("Opção 4 (-)"));
		
		//op5 direita
		swipeListPage.arrastarParaDireita("Opção 5 (-)");
		
		// verificar op5
		Assert.assertTrue(menuPage.existeElementoPorTexto("Opção 5"));
	}
}
