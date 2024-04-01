package bc.ce.thiagoFreitas.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;




public class CalculadoraTeste {

	@Test
	 public void devePreencherCampoTexto() throws MalformedURLException {
		 DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		 desiredCapabilities.setCapability("platformName", "Android");
		 desiredCapabilities.setCapability("deviceName", "NQTL2N0057");
		 desiredCapabilities.setCapability("automationName", "uiautomator2");
		 desiredCapabilities.setCapability("appPackage", "com.ctappium");
		 desiredCapabilities.setCapability("appActivity", "com.ctappium.MainActivity");
		 
		 AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), desiredCapabilities);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 //Selecionar Formulário
		 WebElement elementosEncontrados = driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']"));
		 elementosEncontrados.click();
		 
		 //Escrever Nome
		 WebElement campoNome = driver.findElement(AppiumBy.accessibilityId("nome"));
		 campoNome.sendKeys("Thiago");
		 
		 //Checar nome escrito
		 String textoEscrito = campoNome.getText();
		 Assert.assertEquals("Thiago", textoEscrito);
		 		 
		 driver.quit();
	 }
	
	@Test
	 public void deveInteragirComCombo() throws MalformedURLException {
		 DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		 desiredCapabilities.setCapability("platformName", "Android");
		 desiredCapabilities.setCapability("deviceName", "NQTL2N0057");
		 desiredCapabilities.setCapability("automationName", "uiautomator2");
		 desiredCapabilities.setCapability("appPackage", "com.ctappium");
		 desiredCapabilities.setCapability("appActivity", "com.ctappium.MainActivity");
		 
		 AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), desiredCapabilities);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 //Selecionar Formulário
		 driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
		 
		 //Clicar no combo
		 driver.findElement(AppiumBy.accessibilityId("console")).click();
		 
		 //Selecionar a opção desejada
		 driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
		 
		 //Verificar a opção selecionada
		 String textoDoCombo = driver.findElement(By.id("android:id/text1")).getText();
		 Assert.assertEquals("Nintendo Switch", textoDoCombo);
		
		 
		 driver.quit();
	 }
	
	@Test
	 public void deveInteragirComSwitchECheckbox() throws MalformedURLException {
		 DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		 desiredCapabilities.setCapability("platformName", "Android");
		 desiredCapabilities.setCapability("deviceName", "NQTL2N0057");
		 desiredCapabilities.setCapability("automationName", "uiautomator2");
		 desiredCapabilities.setCapability("appPackage", "com.ctappium");
		 desiredCapabilities.setCapability("appActivity", "com.ctappium.MainActivity");
		 
		 AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), desiredCapabilities);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 //Selecionar Formulario
		 driver.findElement(By.xpath("//*[@text='Formulário']")).click();
		 
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
		 
		 driver.quit();
	 }
	
	@Test
	 public void desafioFormulario() throws MalformedURLException {
		 DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		 desiredCapabilities.setCapability("platformName", "Android");
		 desiredCapabilities.setCapability("deviceName", "NQTL2N0057");
		 desiredCapabilities.setCapability("automationName", "uiautomator2");
		 desiredCapabilities.setCapability("appPackage", "com.ctappium");
		 desiredCapabilities.setCapability("appActivity", "com.ctappium.MainActivity");
		 
		 AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), desiredCapabilities);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 
		 
		 driver.quit();
	 }
}
