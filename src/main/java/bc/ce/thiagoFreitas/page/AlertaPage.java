package bc.ce.thiagoFreitas.page;

import org.openqa.selenium.By;

import appium.core.BasePage;

public class AlertaPage extends BasePage {
	
	public void clicarAlertaConfirm() {
		clicarPorTexto("ALERTA CONFIRM");
	}
	
	public String obterTituloAlerta() {
		return obterTexto(By.id("android:id/alertTitle"));
	}
	
	public String obterTextoAlerta() {
		return obterTexto(By.id("android:id/message"));
	}
	
	public void clicarConfirmarNoAlerta() {
		clickElement(By.id("android:id/button2"));
	}
	
	public void clicarSairNoAlerta() {
		clickElement(By.id("android:id/button1"));
	}
}
