package pl.kostek.selenium.testng.pageobject;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PhpTravelsPageLoggedIn extends PageObject{
		
	private By hiUserLocator = By.className("RTL");
	private int attemptNumber = 5;
	
	public PhpTravelsPageLoggedIn(WebDriver driver){
		super(driver);
		super.setUserLoggedInAttrKey("getText");
		super.setUserLoggedInAttrVal("Hi, John Smith");
	}
	
	public boolean isLoaded(){
		if (isUserShown()){
			return true;
		}else 
			return false;
	}
	public boolean logOut(){
		boolean out = false;
		int attempt = 0;
		while(true && !out){
			if (attempt > attemptNumber)
				break;
			if (logOutField.isDisplayed()){
				logOutField.click();
				if (logOutButton.isDisplayed()){
					logOutButton.click();
					out = true;
					return true;
				}
			}
			attempt++;
			out = false;
			driver.findElement(By.xpath("//*/a")).sendKeys(Keys.F5);
		}
		return false;
	}
	public String changeCurrency(){
		String newValue = "";
		boolean out = false;
		int attempt = 0;
		if (driver.toString().contains("Internet")){
			String currency = new WebDriverWait(driver, 20)
			.pollingEvery(1, TimeUnit.SECONDS)
			.ignoring(Exception.class)
			.until(new Function<WebDriver, String>() {
		        public String apply(WebDriver driver) {
		        	boolean isElementFound = false;
				    String selectedCurrency = null;
					Select ob = new Select(currencyChanger);
        			ob.selectByVisibleText("EUR");
        			selectedCurrency = new Select(currencyChanger).getFirstSelectedOption().getText();
	        		if (null != selectedCurrency){
	        			isElementFound = true;
	            	}
	        		return isElementFound ? selectedCurrency : "";
		        }
		    });
			return currency;
		}else{
			while(true && !out){
				if (attempt > attemptNumber){
					System.out.println("Failed to change currency.");
					break;
				}
				if (attempt > 0)
					System.out.println(String.format("Changing currency: attempt: %1s", attempt+1));
				try{
					if (currencyChanger.isDisplayed()){
						new Select(currencyChanger).selectByVisibleText("EUR");
						new Select(currencyChanger).getFirstSelectedOption();
					}
				}
				catch(StaleElementReferenceException se){
					if (foundElement(10, 2, currencyChanger, "", "")){
						newValue = new Select(currencyChanger).getFirstSelectedOption().getText();
						out = true;
					}else{
						newValue= "";
						out = false;
					}
				}
				try{
					driver.findElement(By.xpath("//*/a")).sendKeys(Keys.F5);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}catch (Exception e){
				}
				attempt++;
			}
			return newValue;
		}
	}
	private boolean isUserShown(){
		return (driver.toString().contains("Internet")) ? 
				foundElementIe(15, 1, hiUserLocator, getUserLoggedInAttrKey(), getUserLoggedInAttrVal()) 
				: foundElement(15, 1, hiUser, getUserLoggedInAttrKey(), getUserLoggedInAttrVal());
	}
}
