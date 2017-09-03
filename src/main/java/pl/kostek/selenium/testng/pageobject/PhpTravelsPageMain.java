package pl.kostek.selenium.testng.pageobject;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;


public class PhpTravelsPageMain extends PageObject{
	
	public PhpTravelsPageMain(WebDriver driver){
		super(driver);
	}
	
	public boolean isInitialized(){
		return (dropdown.isDisplayed() && carousel.isDisplayed()) ? true : false;
	}
	
	public PhpTravelsPageLogin goToLogin(){
		try{
			if (dropdown.isDisplayed()){
				dropdown.click();
				if (menuToLoginButton.isDisplayed()){
					menuToLoginButton.click();
				}
			}
		    if (foundElement(10, 2, resultLogin, "", "")){
		    	return new PhpTravelsPageLogin(driver);	
	    	}
	    	else
	    		return null;
		}catch(NoSuchElementException nsee){
			if (dropdown.isDisplayed()){
				dropdown.click();
				if (menuToLoginButton.isDisplayed()){
					menuToLoginButton.click();
				}
			}
		    if (foundElement(10, 2, resultLogin, "", "")){
		    	return new PhpTravelsPageLogin(driver);	
	    	}
			return null;
		}
	}
}
