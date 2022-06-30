package stepdefinitions;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
import pageobjects.AccountSuccessPage;
import pageobjects.HomePage;
import pageobjects.RegisterPage;
import resources.Base;

public class Register extends Base {
	
	WebDriver driver;
	HomePage homePage;
	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;
	
	@Before("@register")
	public void setup() throws IOException {
		
		driver = initializeBrowser();
		
	}
	
	@After("@register")
	public void tearDown(){
		
		driver.quit();
		
	}
	
	@Given("^I navigate to register page$")
    public void i_navigate_to_register_page() {
        
		driver.get(prop.getProperty("url"));
		homePage = new HomePage(driver);
		homePage.clickOnMyAccountDropMenu();
		registerPage = homePage.selectRegisterOption();
    }

    @When("^I enter all the below details into the fields$")
    public void i_enter_all_the_below_details_into_the_fields(DataTable dataTable)  {
        
    	Map<String, String> map = dataTable.asMap(String.class,String.class);
    	
    	registerPage.enterFirstName(map.get("firstName"));
    	registerPage.enterLastName(map.get("lastName"));
    	registerPage.enterEmailAddress("amotoori"+generateTimeStamp()+"@gmail.com");
    	registerPage.enterTelephone(map.get("telephone"));
    	registerPage.enterPassword(map.get("password"));
    	registerPage.enterPasswordConfirm(map.get("password"));
    	
    }

    @Then("^User should get successfully registered$")
    public void user_should_get_successfully_registered() {
    	
    	Assert.assertEquals(accountSuccessPage.getAccountCreatedMessage(),prop.getProperty("accountcreatedmessage"));
        
    }

    @And("^I select privacy policy checkbox field$")
    public void i_select_privacy_policy_checkbox_field()  {
    	
    	registerPage.selectAgreeCheckBoxField();
        
    }

    @And("^I click on Continue button$")
    public void i_click_on_continue_button() {
        
    	accountSuccessPage = registerPage.clickOnContinueButton();
    	
    }

}
