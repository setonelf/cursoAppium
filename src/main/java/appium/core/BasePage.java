package appium.core;

import static appium.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {
	
	public void escrever(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);
	}
	
	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public void clicarPorTexto(String texto) {
		getDriver().findElement(By.xpath("//*[@text='"+texto+"']")).click();
	}
	
	public void clicarNoCombo(By byCombo, String valor) {
		 getDriver().findElement(byCombo).click();
		 clicarPorTexto(valor);
	}
	
	public boolean isCheckMarcado(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals("true");
	}
	
	public void clickElement(By by) {
		getDriver().findElement(by).click();;
	}
	
	public boolean existeElementoPorTexto(String texto) {
		 List<WebElement> elementos = getDriver().findElements(By.xpath("//*[@text='"+texto+"']"));
		 return elementos.size() > 0;
	}
}
