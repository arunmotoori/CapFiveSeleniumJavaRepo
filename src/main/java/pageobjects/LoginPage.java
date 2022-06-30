package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="input-email")
	private WebElement emailAddressField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(css="input[value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[contains(text(),'Warning: No match for E-Mail Address and/or Password.')]")
	private WebElement warningMessage;
	
	public void enterEmailAddress(String emailText) {
		
		emailAddressField.sendKeys(emailText);
		
	}
	
	public void enterPassword(String passwordText) {
		
		passwordField.sendKeys(passwordText);
		
	}
	
	public AccountPage clickOnLoginButton() {
		
		loginButton.click();
		
		return new AccountPage(driver);
	}
	
	public boolean isUnsuccessfullLogingMessageDisplayed() {
		
		return warningMessage.isDisplayed();
		
	}

}
