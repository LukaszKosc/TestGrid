package pl.kostek.selenium.testng.pageobject;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PhpTravelsPageLogin extends PageObject{

	private By isLoggedIn = By.xpath("(//A[@href='javascript:void(0);'])[2]");

	public PhpTravelsPageLogin(WebDriver driver){
		super(driver);
		super.setUserLoggedInAttrKey("getText");
		super.setUserLoggedInAttrVal("John");
	}

	public boolean isPresent(){
		boolean result = false;
		if (driver.toString().contains("Internet")){
			result = new WebDriverWait(driver, 30)
			.pollingEvery(1, TimeUnit.SECONDS)
			.ignoring(Exception.class)
			.until(new Function<WebDriver, Boolean>() {
		        public Boolean apply(WebDriver driver) {
				    Boolean isElementFound = Boolean.FALSE;
	        		loginForm = driver.findElement(By.id("loginfrm"));
	            	if (null != loginForm){
	        		    	isElementFound = Boolean.TRUE;
	                }else{
	                	isElementFound = Boolean.FALSE;
	                }
	            	if (isElementFound)
	    				return isElementFound;
		            return isElementFound;
		        }
		    });
			if (result)
				return result;
		}
		if (loginForm.isDisplayed()){
			result = true;
		}
		return result;
	}
	
	public PhpTravelsPageLoggedIn LogIn(String username, String password){
		PhpTravelsPageLoggedIn page = null;
		if (driver.toString().contains("Internet")){
			page = new WebDriverWait(driver, 30)
			.pollingEvery(250, TimeUnit.MILLISECONDS)
			.ignoring(Exception.class)
			.until(new Function<WebDriver, PhpTravelsPageLoggedIn>() {
		        public PhpTravelsPageLoggedIn apply(WebDriver driver) {
		        	WebElement usernameField  = null;
				    Boolean isElementFound = Boolean.FALSE;
        			usernameField = driver.findElement(By.name("username"));
	        		if (null != usernameField){
	        			isElementFound = Boolean.TRUE;
	            	}
		            if (isElementFound){
		            	return new PhpTravelsPageLoggedIn(driver);
		            }
		            return null;
		        }
		    });
		}
		this.usernameField.clear();
		this.usernameField.sendKeys(username);
		
		this.passwordField.clear();
		this.passwordField.sendKeys(password);
		
		this.loginButton.click();
		if (isLoggedIn()){
			page = new PhpTravelsPageLoggedIn(driver);
		}
		return page;
	}
	private boolean isLoggedIn(){
		return driver.toString().contains("Internet") ?
				foundElementIe(15, 1, isLoggedIn, getUserLoggedInAttrKey(), getUserLoggedInAttrVal())
				: foundElement(15, 1, dropdown, getUserLoggedInAttrKey(), getUserLoggedInAttrVal());
	}
}
