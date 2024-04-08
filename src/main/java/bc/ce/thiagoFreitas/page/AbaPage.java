package bc.ce.thiagoFreitas.page;

import appium.core.BasePage;

public class AbaPage extends BasePage {
	
	public boolean isAba1() {
		return existeElementoPorTexto("Este é o conteúdo da Aba 1");
	}
	
	public boolean isAba2() {
		return existeElementoPorTexto("Este é o conteúdo da Aba 2");
	}
	
	public void clicaEmAbaDois() {
		clicarPorTexto("Aba 2");
	}

}
