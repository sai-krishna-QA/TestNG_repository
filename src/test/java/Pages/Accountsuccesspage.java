package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AT.TestngFramework.ElementUtils;

public class Accountsuccesspage {
	
	WebDriver driver;
	ElementUtils elementutils;


	public Accountsuccesspage(WebDriver driver) {
		this.driver = driver;
		elementutils = new ElementUtils(driver);
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//aside[@id='column-right']//a[text()='Logout']")
	WebElement logoutoption;
	
	public boolean logout_option_is_displayed() {
		return elementutils.isElementDisplayed(logoutoption);
		 //return logoutoption.isDisplayed();
	}
	
	@FindBy(linkText="Continue")
	WebElement continuebutton;
	
	public AccountPage click_on_continue_button() { 
  		elementutils.clickOnElement(continuebutton);
		//continuebutton.click();
		return new AccountPage(driver);
}
	

	@FindBy(linkText="Subscribe / unsubscribe to newsletter")
	WebElement newsletterlink;
	
	public void click_on_Subscribe_unsubscribe_to_newsletter_Link() { 
		//newsletterlink.click();
  		elementutils.clickOnElement(newsletterlink);

		
	}
}