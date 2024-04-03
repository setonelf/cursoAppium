package bc.ce.thiagoFreitas.page;

import appium.core.BasePage;

public class AccordionPage extends BasePage {
	
	public void clickOpcao1() {
		clicarPorTexto("Opção 1");
	}
	
	public boolean isTextoOpacao1Visivel() {
		return existeElementoPorTexto("Esta é a descrição da opção 1");
	}
}
