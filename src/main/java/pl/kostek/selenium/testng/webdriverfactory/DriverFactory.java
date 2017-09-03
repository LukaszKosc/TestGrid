package pl.kostek.selenium.testng.webdriverfactory;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	private String driverName;
	public static final String DRIVER_LOCATION = "D:/Tools/";
	public DriverFactory(String driverName){
		this.driverName = driverName;
	}
	public WebDriver getDriver(){
		if (null == this.driverName){
			return null;
		}
		else if (this.driverName.equalsIgnoreCase("chrome")){
			return new Chrome().getDriver();
		}
		else if (this.driverName.equalsIgnoreCase("firefox")){
			return new Firefox().getDriver();
		}
		else if (this.driverName.equalsIgnoreCase("ie")){
			return new IE().getDriver();
		}
		else if (this.driverName.equalsIgnoreCase("opera")){
			return new Opera().getDriver();
		}
		else
			return null;
	}
}
