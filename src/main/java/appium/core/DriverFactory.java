package appium.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class DriverFactory {
	
	private static AndroidDriver driver;
	
	public static AndroidDriver getDriver() {
		if(driver ==null) {
			createDriver();
		}
		return driver;
	}
	
	private static void createDriver() {
	DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	desiredCapabilities.setCapability("platformName", "Android");
	desiredCapabilities.setCapability("deviceName", "NQTL2N0057");
	desiredCapabilities.setCapability("automationName", "uiautomator2");
	desiredCapabilities.setCapability("appPackage", "com.ctappium");
	desiredCapabilities.setCapability("appActivity", "com.ctappium.MainActivity");
	
	try {
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), desiredCapabilities);
	} catch (MalformedURLException e) {
		e.printStackTrace();
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	
	public static void killDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
