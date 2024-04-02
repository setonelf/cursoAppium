package bc.ce.thiagoFreitas.page;

import appium.core.DSL;

public class MenuPage {
	private DSL dsl = new DSL();
	
	public void acessarFormulario() {
		dsl.clicarPorTexto("Formulário");
	}
}
