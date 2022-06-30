package tests;

import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.AccountSuccessPage;
import pageobjects.HomePage;
import pageobjects.RegisterPage;
import resources.Base;

public class RegisterTest extends Base {
	
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
	public void registerWithMandatoryFields() {
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccountDropMenu();
		RegisterPage registerPage = homePage.selectRegisterOption();
		registerPage.enterFirstName(prop.getProperty("firstname"));
		registerPage.enterLastName(prop.getProperty("lastname"));
		registerPage.enterEmailAddress("amotooricap"+generateTimeStamp()+"@gmail.com");
		registerPage.enterTelephone(prop.getProperty("telephone"));
		registerPage.enterPassword(prop.getProperty("validpassword"));
		registerPage.enterPasswordConfirm(prop.getProperty("validpassword"));
		registerPage.selectAgreeCheckBoxField();
		AccountSuccessPage accountSuccessPage = registerPage.clickOnContinueButton();
		Assert.assertEquals(accountSuccessPage.getAccountCreatedMessage(),prop.getProperty("accountcreatedmessage"));
		
	}
	
	@Test(priority=2)
	public void registerWithAllFields() {
	
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccountDropMenu();
		RegisterPage registerPage = homePage.selectRegisterOption();
		registerPage.enterFirstName(prop.getProperty("firstname"));
		registerPage.enterLastName(prop.getProperty("lastname"));
		registerPage.enterEmailAddress("amotooricap"+generateTimeStamp()+"@gmail.com");
		registerPage.enterTelephone(prop.getProperty("telephone"));
		registerPage.enterPassword(prop.getProperty("validpassword"));
		registerPage.enterPasswordConfirm(prop.getProperty("validpassword"));
		registerPage.selectYesOption();
		registerPage.selectAgreeCheckBoxField();
		AccountSuccessPage accountSuccessPage = registerPage.clickOnContinueButton();
		Assert.assertEquals(accountSuccessPage.getAccountCreatedMessage(),prop.getProperty("accountcreatedmessage"));
	}
	
	@Test(priority=3)
	public void registerWithAlreadyRegisteredEmailAddress() {
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccountDropMenu();
		RegisterPage registerPage = homePage.selectRegisterOption();
		registerPage.enterFirstName(prop.getProperty("firstname"));
		registerPage.enterLastName(prop.getProperty("lastname"));
		registerPage.enterEmailAddress(prop.getProperty("validemail"));
		registerPage.enterTelephone(prop.getProperty("telephone"));
		registerPage.enterPassword(prop.getProperty("validpassword"));
		registerPage.enterPasswordConfirm(prop.getProperty("validpassword"));
		registerPage.selectAgreeCheckBoxField();
		registerPage.clickOnContinueButton();
		Assert.assertTrue(registerPage.isAccountNotWarningMessageIsDisplayed());
	
	}
	
	
	

}
