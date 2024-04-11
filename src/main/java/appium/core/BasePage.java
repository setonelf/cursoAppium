package appium.core;

import static appium.core.DriverFactory.getDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

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
	
	public void cliqueLongoPorElemento(By by) {
		((JavascriptExecutor) getDriver()).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) getDriver().findElement(by)).getId(),
			    "duration", 1000
			));
	}
	
	public void scrollDown(){
		scroll(0.1, 0.9);
	}
	
	public void scrollUp(){
		scroll(0.9, 0.1);
	}
	
	public void swipeLeft() {
		swipe(0.1, 0.9);
	}
	
	public void swipeRight() {
		swipe(0.9, 0.1);
	}
	public void scroll(double inicio, double fim) {
		Dimension size = getDriver().manage().window().getSize();
		
		int x = size.width / 2;
		
		int start_y = (int) (size.height * inicio);
		int end_y = (int) (size.height * fim);
		
		genericSwipe(x, start_y, x, end_y);
	}
	
	public void genericSwipe(int startX, int startY, int endX, int endY) {
		PointerInput FINGER = new PointerInput(Kind.TOUCH, "finger");
		Sequence drag = new Sequence(FINGER, 1)
                .addAction(FINGER.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), 
                		startX, startY))
                .addAction(FINGER.createPointerDown(MouseButton.LEFT.asArg()))
                .addAction(new Pause(FINGER, Duration.ofMillis(500)))
                .addAction(FINGER.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), 
                		endX, endY))
                .addAction(FINGER.createPointerUp(MouseButton.LEFT.asArg()));
        getDriver().perform(Arrays.asList(drag));
	}
	
	public String obterTituloAlerta() {
		return obterTexto(By.id("android:id/alertTitle"));
	}
	
	public String obterTextoAlerta() {
		return obterTexto(By.id("android:id/message"));
	}
	
	public void swipe(double inicio, double fim) {
		Dimension size = getDriver().manage().window().getSize();
		
		int y = size.height / 2;
		
		int start_x = (int) (size.width * inicio);
		int end_x = (int) (size.width * fim);
		
		genericSwipe(start_x, y, end_x, y);
	}
}
