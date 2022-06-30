package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageobjects.OmayoHomePage;
import resources.Base;

public class OmayoLogin extends Base {
	
	@Before("@omayologin")
	public void setup() throws IOException {
		
		driver = initializeBrowser();
		
	}
	
	@After("@omayologin")
	public void tearDown() {
		
		driver.quit();
		
	}
	
	
	WebDriver driver;
	OmayoHomePage omayoHomePage;
	
    @Given("^I navigate to Omayo website$")
    public void i_navigate_to_omayo_website() throws IOException {
    	
        driver.get(prop.getProperty("omayourl"));   
        
    }

    @When("^I enter username as (.+) and password as (.+) into the fields$")
    public void i_enter_username_as_and_password_as_into_the_fields(String username, String password)  {
        
    	omayoHomePage = new OmayoHomePage(driver);
    	omayoHomePage.enterUsername(username);
    	omayoHomePage.enterPassword(password);
    	
    }

    @Then("^User should get logged in based on expected (.+) status$")
    public void user_should_get_logged_in_based_on_expected_status(String loginstatus) {
        
    	Assert.assertEquals(omayoHomePage.isUserLoggedIn(),loginstatus);
    	
    	
    }

    @And("^I click on Login button$")
    public void i_click_on_login_button()  {
    	
    	omayoHomePage.clickOnLoginButton();
        
    }

}
