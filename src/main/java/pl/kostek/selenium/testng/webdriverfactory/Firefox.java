package pl.kostek.selenium.testng.webdriverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements DriverInterface{
	private WebDriver instance;
	public WebDriver getDriver(){
		System.setProperty("webdriver.gecko.driver", DriverFactory.DRIVER_LOCATION + "geckodriver.exe");
		if (null == instance){
			instance = new FirefoxDriver();
		}
		return instance;
	}
}
