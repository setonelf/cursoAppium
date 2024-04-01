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
}
