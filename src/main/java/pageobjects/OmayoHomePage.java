package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OmayoHomePage {
	
	WebDriver driver;
	
	public OmayoHomePage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(name="userid")
	private WebElement usernameField;
	
	@FindBy(name="pswrd")
	private WebElement passwordField;
	
	@FindBy(css="input[value='Login']")
	private WebElement loginButton;
	
	public void enterUsername(String usernameText) {
		
		usernameField.sendKeys(usernameText);
		
	}
	
	public void enterPassword(String passwordText) {
		
		passwordField.sendKeys(passwordText);
		
	}
	
	public void clickOnLoginButton() {
		
		loginButton.click();
		
	}
	
	public String isUserLoggedIn() {
		
		try {
		   Alert alert = driver.switchTo().alert();
		   return "failure";
		}catch(NoAlertPresentException e) {
			return "success";
		}
	
	}

}
