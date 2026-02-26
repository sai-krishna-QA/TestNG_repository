package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Pages.AccountPage;
import AT.TestngFramework.ElementUtils;


public class loginpage {

	WebDriver driver;
	ElementUtils elementUtils;


	public loginpage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement Emailaddressfield;
	
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement passwordfield;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginButton;
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement warningmessage;
	
	public AccountPage loginToApplication(String emailAddressText,String passwordText) {
		Enterfirstname(emailAddressText);
		Enterpassword(passwordText);
		return Clickonloginbutton();
		} 
		
	public void Enterfirstname(String emailAddressText) {
		elementUtils.enterTextIntoTheElement(Emailaddressfield, emailAddressText);
		//Emailaddressfield.sendKeys(emailAddressText);
	}
	
	public void Enterpassword(String passwordtext) {
		elementUtils.enterTextIntoTheElement(passwordfield, passwordtext);
	//passwordfield.sendKeys(passwordtext);
	}

	public AccountPage Clickonloginbutton( ) {
		elementUtils.clickOnElement(loginButton);
		//loginButton.click();	
	return new AccountPage(driver);
	}
	
	  public String getwarningmessage() {
			return elementUtils.getTextFromElement(warningmessage);
	    //	return warningmessage.getText();
	        }
}























