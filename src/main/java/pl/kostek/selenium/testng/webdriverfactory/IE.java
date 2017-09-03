package pl.kostek.selenium.testng.webdriverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IE implements DriverInterface{
	private InternetExplorerDriver instance;
	public WebDriver getDriver(){
		DesiredCapabilities capabilities =
				DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		System.setProperty("webdriver.ie.driver", DriverFactory.DRIVER_LOCATION + "IEDriverServer.exe");
		if (null == instance){
			instance = new InternetExplorerDriver(capabilities);
		}
		return instance;
	}
}
