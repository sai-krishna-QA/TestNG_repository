package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AT.TestngFramework.ElementUtils;

public class Registerpage {

	WebDriver driver;
	ElementUtils elementutils;


	public Registerpage(WebDriver driver) {

		this.driver = driver;
		elementutils = new ElementUtils(driver);
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//input[@name='firstname']")
	WebElement firstname;
	
	public void Enterfirstname(String Firstnametext) {
		elementutils.enterTextIntoTheElement(firstname, Firstnametext);
		//firstname.sendKeys(Firstnametext);
	}
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement lastname;
	
	public void Enterlastname(String lastnametext) {
		elementutils.enterTextIntoTheElement(lastname,lastnametext);
		//lastname.sendKeys(lastnametext);
	}
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement email;
	
	public void Enteremail(String emailtext) {
		elementutils.enterTextIntoTheElement(email,emailtext);
	//	email.sendKeys(emailtext);
	}
	
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement telephone;
	
	public void Entertelephone(String telephonenumber) {
		elementutils.enterTextIntoTheElement(telephone,telephonenumber);
		//telephone.sendKeys(telephonenumber);
	}
	
	@FindBy(xpath ="//input[@id='input-password']" )
	WebElement Validpassword;
	
	public void EnterValidpassword(String Validpasswordtext) {
		elementutils.enterTextIntoTheElement(Validpassword,Validpasswordtext);
	//	Validpassword.sendKeys(Validpasswordtext);
	}
	
	@FindBy(xpath ="//input[@id='input-confirm']" )
	WebElement Confirmpassword;
	
	public void Enterconfirmpassword(String Confirmpasswordtext) {
		elementutils.enterTextIntoTheElement(Confirmpassword,Confirmpasswordtext);
		//Confirmpassword.sendKeys(Confirmpasswordtext);
	}
	
	@FindBy(xpath ="//input[@name='agree']" )
	WebElement Agreebutton;
	
	public void ClickonAgreebutton() {
  		elementutils.clickOnElement(Agreebutton);
		//Agreebutton.click();
	}
	
	@FindBy(xpath ="//input[@value='Continue']" )
	WebElement Continuebutton;
	
	public Accountsuccesspage  ClickonContinuebutton() {
  		elementutils.clickOnElement(Continuebutton);
	//	Continuebutton.click();
		return new Accountsuccesspage(driver);
	}
	
	@FindBy(xpath = "//input[@name='newsletter'][@value=1]" ) 
	WebElement newsletterbutton;
	
	public void Click_yes_on_newsletter_button() {
  		elementutils.clickOnElement(newsletterbutton);
		//newsletterbutton.click();
}
	
	@FindBy(xpath = "//input[@name='newsletter'][@value=0]")
	WebElement nooption;
	
	public boolean Click_no_on_newsletter_button() {
		  return nooption.isSelected();
	}
	



}

