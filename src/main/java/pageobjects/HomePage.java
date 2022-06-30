package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(css="a[title='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy(name="search")
	private WebElement searchBoxField;
	
	@FindBy(css="button[class='btn btn-default btn-lg']")
	private WebElement searchButton;
	
	public void clickOnMyAccountDropMenu() {
		
		myAccountDropMenu.click();
		
	}
	
	public LoginPage selectLoginOption() {
		
		loginOption.click();
		
		return new LoginPage(driver);
		
	}
	
	public RegisterPage selectRegisterOption() {
		
		registerOption.click();
		
		return new RegisterPage(driver);
		
	}
	
	public void enterProuductIntoSearchBoxField(String productText) {
		
		searchBoxField.sendKeys(productText);
		
	}
	
	public SearchResultsPage clickOnSearchButton() {
		
		searchButton.click();
		
		return new SearchResultsPage(driver);
	}

}
