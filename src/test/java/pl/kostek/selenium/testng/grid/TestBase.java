package pl.kostek.selenium.testng.grid;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import pl.kostek.selenium.testng.webdriverfactory.DriverFactory;
import pl.kostek.selenium.testng.webdriverfactory.Opera;


public class TestBase {
	protected static WebDriver driver = null;
	
	@BeforeMethod
	@Parameters("browser")
	public static void testSetUp(String browser) {
		System.out.println("Browser: " + browser);
		driver = new DriverFactory(browser).getDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	@Parameters("browser")
	public static void testTearDown(String browser){
		System.out.println("Clearing cookies");
		driver.manage().deleteAllCookies();
		if (browser.equalsIgnoreCase("opera")){
			Opera.stopService();
			driver.quit();
		}
		else if (browser.equalsIgnoreCase("firefox"))
			driver.close();
		else
			driver.quit();
	}
}