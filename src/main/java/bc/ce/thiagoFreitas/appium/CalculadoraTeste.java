package bc.ce.thiagoFreitas.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;




public class CalculadoraTeste {
	AndroidDriver driver;
	
	@Before
	private void InicializarAppium() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		 desiredCapabilities.setCapability("platformName", "Android");
		 desiredCapabilities.setCapability("deviceName", "NQTL2N0057");
		 desiredCapabilities.setCapability("automationName", "uiautomator2");
		 desiredCapabilities.setCapability("appPackage", "com.ctappium");
		 desiredCapabilities.setCapability("appActivity", "com.ctappium.MainActivity");
		 
		 driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), desiredCapabilities);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 //Selecionar Formulário
		 driver.findElement(By.xpath("//*[@text='Formulário']")).click();
	}
	
	@After
	private void tearDown() {
		driver.quit();
	}

	@Test
	 public void devePreencherCampoTexto() throws MalformedURLException {
		 //Escrever Nome
		 WebElement campoNome = driver.findElement(AppiumBy.accessibilityId("nome"));
		 campoNome.sendKeys("Thiago");
		 
		 //Checar nome escrito
		 String textoEscrito = campoNome.getText();
		 Assert.assertEquals("Thiago", textoEscrito);
		 		 
	 }
	
	@Test
	 public void deveInteragirComCombo() throws MalformedURLException {
		 //Clicar no combo
		 driver.findElement(AppiumBy.accessibilityId("console")).click();
		 
		 //Selecionar a opção desejada
		 driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
		 
		 //Verificar a opção selecionada
		 String textoDoCombo = driver.findElement(By.id("android:id/text1")).getText();
		 Assert.assertEquals("Nintendo Switch", textoDoCombo);
	 }
	
	@Test
	 public void deveInteragirComSwitchECheckbox() throws MalformedURLException {
		 //Verificar status dos elementos
		 WebElement checkBox = driver.findElement(By.className("android.widget.CheckBox"));
		 WebElement switchElement = driver.findElement(AppiumBy.accessibilityId("switch"));
		 Assert.assertTrue(checkBox.getAttribute("checked").equals("false"));
		 Assert.assertTrue(switchElement.getAttribute("checked").equals("true"));
		
		 
		 //Clicar nos elementos
		 checkBox.click();
		 switchElement.click();
		 
		 //Verificar estados alterados
		 Assert.assertFalse(checkBox.getAttribute("checked").equals("false"));
		 Assert.assertFalse(switchElement.getAttribute("checked").equals("true"));
	 }
	
	@Test
	 public void desafioFormulario() throws MalformedURLException {
		 //Preencher campos
		 driver.findElement(AppiumBy.accessibilityId("nome")).sendKeys("Thiago");
		 driver.findElement(AppiumBy.accessibilityId("console")).click();
		 driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
		 driver.findElement(AppiumBy.accessibilityId("check")).click();
		 driver.findElement(AppiumBy.accessibilityId("switch")).click();
		 		 
		 //Salvar
		 driver.findElement(AppiumBy.accessibilityId("save")).click();
		 
		 //Validar Campos		 
		 Assert.assertEquals("Nome: Thiago", driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Nome:')]")).getText());
		 Assert.assertEquals("Console: switch", driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Console:')]")).getText());
		 Assert.assertEquals("Switch: Off", driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Switch:')]")).getText());
		 Assert.assertEquals("Checkbox: Marcado", driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Checkbox:')]")).getText());
	 }
}
