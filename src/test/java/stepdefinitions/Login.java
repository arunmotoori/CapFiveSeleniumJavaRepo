package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import resources.Base;


public class Login extends Base {
	
	@Before("@login")
	public void setup() throws IOException {
		
		driver = initializeBrowser();
		
	}
	
	@After("@login")
	public void tearDown() {
		
		driver.quit();
		
	}
	
	
	WebDriver driver;
	HomePage homePage = null;
	LoginPage loginPage = null;
	AccountPage accountPage = null;
	
	@Given("^Open the Application URL$")
    public void open_the_application_url() throws IOException  {
	
		driver.get(prop.getProperty("url"));
		
    }

	@When("^User enter valid username and valid password into the fields$")
    public void user_enter_valid_username_and_valid_password_into_the_fields()  {
		
		loginPage.enterEmailAddress(prop.getProperty("validemail"));
		loginPage.enterPassword(prop.getProperty("validpassword"));
        
    }

	@When("^User enter valid username and invalid password into the fields$")
    public void user_enter_valid_username_and_invalid_password_into_the_fields()  {
		
		loginPage.enterEmailAddress(prop.getProperty("validemail"));
		loginPage.enterPassword(prop.getProperty("invalidpassword"));
        
    }

    @Then("^Verify user is able to successfully login$")
    public void verify_user_is_able_to_successfully_login()  {
    	
    	Assert.assertTrue(accountPage.isLoginSuccessfull());
        driver.quit();
    }

    @Then("^Verify a warning informing user to provide valid credentials is displayed$")
    public void verify_a_warning_informing_user_to_provide_valid_credentials_is_displayed()  {
    	
    	Assert.assertTrue(loginPage.isUnsuccessfullLogingMessageDisplayed());
    	driver.quit();
    }

    @And("^Navigate to Login page$")
    public void navigate_to_login_page()  {
    	
    	homePage = new HomePage(driver);
		
		homePage.clickOnMyAccountDropMenu();
		loginPage = homePage.selectLoginOption();
    	
        
    }

    @And("^User clicks on Login button$")
    public void user_clicks_on_login_button()  {
    	
    	accountPage = loginPage.clickOnLoginButton();
        
    }
    
    @When("^User enter invalid username and valid password into the fields$")
    public void user_enter_invalid_username_and_valid_password_into_the_fields()  {
    	loginPage.enterEmailAddress("amotooricap"+generateTimeStamp()+"@gmail.com");
		loginPage.enterPassword(prop.getProperty("validpassword"));
    }

}
