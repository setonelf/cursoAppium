package bc.ce.thiagoFreitas.page;



import static appium.core.DriverFactory.getDriver;

import java.util.Set;

import org.openqa.selenium.By;

import appium.core.BasePage;

public class WebViewPage extends BasePage {
	
	public void entrarContextoWeb() {
		Set<String> contextoHandles = getDriver().getContextHandles();
		
//		for(String valor : contextoHandles) {
//			System.out.println(valor);
//		}
		getDriver().context((String) contextoHandles.toArray()[1]);
	}

	public void setEmail(String valor) {
		getDriver().findElement(By.id("email")).sendKeys(valor);;
	}
	
	public void setPassword(String valor) {
		getDriver().findElement(By.id("senha")).sendKeys(valor);;
	}
	
	public void clickButtonEntrar() {
		getDriver().findElement(By.xpath("//button[contains(., 'Entrar')]")).click();
	}
	
	public String getTextSuccess() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
		
	}
	
	public void sairContextoWeb() {
		getDriver().context((String) getDriver().getContextHandles().toArray()[0]);
	}
}
