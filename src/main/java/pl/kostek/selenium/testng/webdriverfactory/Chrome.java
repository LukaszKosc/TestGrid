package pl.kostek.selenium.testng.webdriverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome implements DriverInterface{
	private ChromeDriver instance;
	public WebDriver getDriver(){
		System.setProperty("webdriver.chrome.driver", DriverFactory.DRIVER_LOCATION + "chromedriver.exe");
		if (null == instance)
			instance = new ChromeDriver();
		return instance;
	}
}
