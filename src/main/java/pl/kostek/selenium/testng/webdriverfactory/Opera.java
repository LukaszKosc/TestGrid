package pl.kostek.selenium.testng.webdriverfactory;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class Opera implements DriverInterface{
	private WebDriver instance;
	private static ChromeDriverService service;
	private static DesiredCapabilities getCapabilities(){
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\Program Files (x86)\\Opera\\47.0.2631.55\\opera.exe");        
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		return capabilities;
	}
	public WebDriver getDriver(){
		if (null == instance){
			startService();
			instance = new RemoteWebDriver(service.getUrl(), getCapabilities());
		}
		return instance;
	}
	private static ChromeDriverService getService(){
		System.setProperty("webdriver.opera.driver", DriverFactory.DRIVER_LOCATION + "operadriver.exe");
		service = new ChromeDriverService.Builder()
		        .usingDriverExecutable(new File(DriverFactory.DRIVER_LOCATION + "operadriver.exe"))
		        .usingAnyFreePort()
		        .build();
		return service;
	}
	public static void startService(){
		try {
			getService().start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void stopService(){
		getService().stop();
	}

}
