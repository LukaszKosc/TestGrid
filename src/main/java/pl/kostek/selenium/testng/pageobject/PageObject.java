package pl.kostek.selenium.testng.pageobject;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {
	protected WebDriver driver;
	
	@FindBy(xpath="(//A[@href='javascript:void(0);'])[2]")
	protected WebElement dropdown;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div[2]/ul/li[2]/a")
	protected WebElement logOutField;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div[2]/ul/li[2]/ul/li[2]/a")
	protected WebElement logOutButton;
	
	@FindBy(className="RTL")
	protected WebElement hiUser;

	@FindBy(id="currency")
	protected WebElement currencyChanger;

	@FindBy(id="loginfrm")
	protected WebElement loginForm;
	
	@FindBy(name="username")
	protected WebElement usernameField;
	
	@FindBy(name="password")
	protected WebElement passwordField;
	
	@FindBy(xpath="//*[@id='loginfrm']/div[4]/button")
	protected WebElement loginButton;

	@FindBy(id="Carousel")
	protected WebElement carousel;
	//	
	@FindBy(xpath="//a[@href='http://www.phptravels.net/login'][text()='  Login']")
	protected WebElement menuToLoginButton;
	
	@FindBy(className="grey-box")
	protected WebElement mainGrayBox;
	
	@FindBy(className="resultlogin")
	protected WebElement resultLogin;
		
	protected String userLoggedInAttrKey;
	public String getUserLoggedInAttrKey() {
		return userLoggedInAttrKey;
	}

	public void setUserLoggedInAttrKey(String userLoggedInAttrKey) {
		this.userLoggedInAttrKey = userLoggedInAttrKey;
	}
	protected String userLoggedInAttrVal = "";
	
	public String getUserLoggedInAttrVal() {
		return userLoggedInAttrVal;
	}

	public void setUserLoggedInAttrVal(String userLoggedInAttrVal) {
		this.userLoggedInAttrVal = userLoggedInAttrVal;
	}

	public PageObject(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	protected boolean foundElement(Integer howLong, Integer howFrequent, final WebElement searchedElement, final String parameter, final String value){
		boolean result = new WebDriverWait(driver, howLong)
		.pollingEvery(howFrequent, TimeUnit.SECONDS)
		.ignoring(Exception.class)
		.until(new Function<WebDriver, Boolean>() {
	        public Boolean apply(WebDriver driver) {
	        	Boolean isElementFound = Boolean.FALSE;
            	if (null != searchedElement){
            		if (parameter.equals("getText")){
            			String text = searchedElement.getText();
            			if (text.contains(value)){
		                	isElementFound = Boolean.TRUE;
            			}
            		}
            		else if (parameter.equals("") && value.equals("")){
            			isElementFound = Boolean.TRUE;
            		}
                }
	            return isElementFound;
	        }
	    });
		return result;
	}
	protected boolean foundElementIe(Integer howLong, Integer howFrequent, final By locator, final String parameter, final String value){
		boolean result = new WebDriverWait(driver, howLong)
		.pollingEvery(howFrequent, TimeUnit.SECONDS)
		.ignoring(Exception.class)
		.until(new Function<WebDriver, Boolean>() {
	        public Boolean apply(WebDriver driver) {
	        	Boolean isElementFound = Boolean.FALSE;
            	WebElement searchedElement = driver.findElement(locator);
            	if (null != searchedElement){
            		if (parameter.equals("getText")){
            			String text = searchedElement.getText();
            			if (text.contains(value)){
		                	isElementFound = Boolean.TRUE;
            			}
            		}
            		else if (parameter.equals("") && value.equals("")){
            			isElementFound = Boolean.TRUE;
            		}
                }
	            return isElementFound;
	        }
		    });
		return result;
	}
}