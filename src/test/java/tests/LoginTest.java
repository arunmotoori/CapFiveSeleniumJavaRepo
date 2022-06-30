package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {
	
	//Sample comment
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() throws IOException {
		
		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}
	
	@Test(priority=1)
	public void loginWithValidCredentials() {
		
		HomePage homePage = new HomePage(driver);
		
		homePage.clickOnMyAccountDropMenu();
		LoginPage loginPage = homePage.selectLoginOption();
		
		loginPage.enterEmailAddress(prop.getProperty("validemail"));
		loginPage.enterPassword(prop.getProperty("validpassword"));
		AccountPage accountPage = loginPage.clickOnLoginButton();
		
		Assert.assertTrue(accountPage.isLoginSuccessfull());

	}
	
	@Test(priority=2)
	public void loginWithValidUsernameAndInvalidPassword() {
		
		HomePage homePage = new HomePage(driver);
		
		homePage.clickOnMyAccountDropMenu();
		LoginPage loginPage = homePage.selectLoginOption();
		loginPage.enterEmailAddress(prop.getProperty("validemail"));
		loginPage.enterPassword(prop.getProperty("invalidpassword"));
		loginPage.clickOnLoginButton();
	
		Assert.assertTrue(loginPage.isUnsuccessfullLogingMessageDisplayed());
	
	}
	
	@Test(priority=3)
	public void loginWithInvalidUsernameAndValidPassword() {
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccountDropMenu();
		LoginPage loginPage = homePage.selectLoginOption();
		loginPage.enterEmailAddress("amotooricap"+generateTimeStamp()+"@gmail.com");
		loginPage.enterPassword(prop.getProperty("validpassword"));
		loginPage.clickOnLoginButton();
		
		Assert.assertTrue(loginPage.isUnsuccessfullLogingMessageDisplayed());
		Assert.fail("Intentionally failing");
	
	}

}
