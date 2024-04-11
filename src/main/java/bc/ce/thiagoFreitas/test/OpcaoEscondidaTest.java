package bc.ce.thiagoFreitas.test;

import java.time.Duration;
import static appium.core.DriverFactory.getDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import appium.core.BaseTest;
import bc.ce.thiagoFreitas.page.MenuPage;

public class OpcaoEscondidaTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	
	@Test
	public void deveEncontrarOpcaoEscondida() {
		//scroll down
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
		System.out.println("Começando");
		
		menuPage.scrollUp();
		
		//clicar menu
		
		menuPage.clicarPorTexto("Opção bem escondida");
		
		//verificar mensagem
		Assert.assertEquals("Você achou essa opção", menuPage.obterTextoAlerta());
		
		//sair
		menuPage.clicarPorTexto("OK");
	}

}
