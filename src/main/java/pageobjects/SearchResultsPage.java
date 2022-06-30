package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
	
	WebDriver driver;
	
	public SearchResultsPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(linkText="HP LP3065")
	private WebElement hpProduct;
	
	@FindBy(xpath="//div[@id='content']/p[2]")
	private WebElement noProductSearchMessage;
	
	public boolean isHPProductDisplayed() {
		
		return hpProduct.isDisplayed();
	}
	
	public String getSearchResultsMessage() {
		
		return noProductSearchMessage.getText();
		
	}

}
