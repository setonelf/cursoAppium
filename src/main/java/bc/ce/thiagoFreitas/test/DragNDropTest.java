package bc.ce.thiagoFreitas.test;

import org.junit.Assert;
import org.junit.Test;

import appium.core.BaseTest;
import bc.ce.thiagoFreitas.page.DragNDropPage;
import bc.ce.thiagoFreitas.page.MenuPage;

public class DragNDropTest extends BaseTest {
	
	private MenuPage menuPage =  new MenuPage();
	private DragNDropPage dragNDropPage = new DragNDropPage();
	
	private String[] estadoInicial = new String[]{"Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "qualquer local desejado."};
	private String[] estadoIntermediario = new String[]{ "é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "Esta", "qualquer local desejado."};
	private String[] estadoFinal = new String[]{ "Faça um clique longo,", "é uma lista", "Drag em Drop!",  "e arraste para", "Esta", "qualquer local desejado."};
	
	@Test
	public void deveInteragirComDragNDrop() {
		//acessar menu
		menuPage.acessarDragNDrop();
		
		// verificar estado inicial
		esperar(1000);
		Assert.assertArrayEquals(estadoInicial, dragNDropPage.obterLista());
		
		//Arrastar esta para e arraste para
		dragNDropPage.arrastar("Esta", "e arraste para");
		
		
		//verificar estado intermediario
		Assert.assertArrayEquals(estadoIntermediario, dragNDropPage.obterLista());
		
		//arrastar faca clique longo para e uma lista
		dragNDropPage.arrastar("Faça um clique longo,", "é uma lista");
		
		//verificar estado final
		Assert.assertArrayEquals(estadoFinal, dragNDropPage.obterLista());
	}

}
