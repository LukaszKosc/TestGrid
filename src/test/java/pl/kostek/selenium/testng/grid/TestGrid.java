package pl.kostek.selenium.testng.grid;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;

import pl.kostek.selenium.testng.pageobject.PhpTravelsPageLoggedIn;
import pl.kostek.selenium.testng.pageobject.PhpTravelsPageLogin;
import pl.kostek.selenium.testng.pageobject.PhpTravelsPageMain;


public class TestGrid extends TestBase{
	@Test(priority=1)
	public void testLogin() {
		driver.get("http://www.phptravels.net");
		PhpTravelsPageMain phpPage = new PhpTravelsPageMain(driver);
		assertNotNull(phpPage);
		PhpTravelsPageLogin phpLoginPage = phpPage.goToLogin();
		assertNotNull(phpLoginPage);
		assertEquals(true, phpLoginPage.isPresent());
		PhpTravelsPageLoggedIn phpTravelsPageLoggedIn = phpLoginPage.LogIn("user@phptravels.com", "demouser");
		assertNotNull(phpTravelsPageLoggedIn);
		assertEquals(true, phpTravelsPageLoggedIn.isLoaded());
		assertEquals(true, phpTravelsPageLoggedIn.logOut());
		assertEquals(true, phpLoginPage.isPresent());
	}
	
    @Test(priority=2)
    public void testCurrency(){
		driver.get("http://www.phptravels.net");
		PhpTravelsPageMain phpPage = new PhpTravelsPageMain(driver);
		assertNotNull(phpPage);
		PhpTravelsPageLogin phpLoginPage = phpPage.goToLogin();
		assertNotNull(phpLoginPage);
		assertEquals(true, phpLoginPage.isPresent());
		PhpTravelsPageLoggedIn phpTravelsPageLoggedIn = phpLoginPage.LogIn("user@phptravels.com", "demouser");
		assertNotNull(phpTravelsPageLoggedIn);
		assertEquals(true, phpTravelsPageLoggedIn.isLoaded());
		assertEquals(true, phpTravelsPageLoggedIn.changeCurrency().equals("EUR"));
		assertEquals(true, phpTravelsPageLoggedIn.logOut());
		assertEquals(true, phpLoginPage.isPresent());
   }   
}