package bc.ce.thiagoFreitas.page;

import static appium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appium.core.BasePage;

public class SwipeListPage extends BasePage {
	
	public void arrastarParaEsquerda(String opcao) {
		swipeElement(getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")), 0.9, 0.1);
		//swipeLeftElement("//*[contains(@text, 'Opção 1')/..]");
	}
	
	public void arrastarParaDireita(String opcao) {
		swipeElement(getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")), 0.1, 0.9);
		//swipeLeftElement("//*[contains(@text, 'Opção 1')/..]");
	}
	
	public void clicarBotaoMais() {
		WebElement botao = getDriver().findElement(By.xpath("//android.widget.TextView[@text='(+)']/.."));
		tap(botao.getLocation().getX() + 50, botao.getLocation().getY());
	}
}
