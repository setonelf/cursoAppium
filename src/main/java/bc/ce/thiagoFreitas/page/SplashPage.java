package bc.ce.thiagoFreitas.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import appium.core.BasePage;
import appium.core.DriverFactory;

public class SplashPage extends BasePage {
	
	public boolean isTelaSplashVisible() {
		return existeElementoPorTexto("Splash!");
	}
	
	public void isTelaSplashNotVisible() {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofMillis(10000));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='Splash!']")));
	}
}
