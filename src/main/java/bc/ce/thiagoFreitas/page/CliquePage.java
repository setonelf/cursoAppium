package bc.ce.thiagoFreitas.page;

import org.openqa.selenium.By;

import appium.core.BasePage;

public class CliquePage extends BasePage {
	
	public void cliqueLongo() {
		cliqueLongoPorElemento(By.xpath("//*[@text='Clique Longo']"));
	}
	
	public String obterTextoResultado() {
		return obterTexto(By.xpath("(//android.widget.TextView)[3]"));
	}

}
