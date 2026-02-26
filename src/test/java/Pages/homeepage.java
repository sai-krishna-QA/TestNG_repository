package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AT.TestngFramework.ElementUtils;
import Pages.SearchPage;
import Pages.Registerpage;

public class homeepage {

	WebDriver driver;
	ElementUtils elementutils;

	public homeepage(WebDriver driver) {
		this.driver = driver;
		elementutils = new ElementUtils(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='My Account']")
	WebElement myaccountdropdownmenu;

	@FindBy(xpath = "//a[contains(text(),'Login')]")
	WebElement loginbutton;

	@FindBy(xpath = "//a[contains(text(),'Register')]")
	WebElement registeroption;

	@FindBy(name = "search")
	WebElement searchBoxField;

	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	WebElement searchButton;

	public Registerpage navigateToRegisterPage() {

		Clickonmyaccountdropdownmenu();
		return Selectregisteroption();
	}

	public void Clickonmyaccountdropdownmenu() {
		elementutils.clickOnElement(myaccountdropdownmenu);
		// myaccountdropdownmenu.click();
	}

	public loginpage navigate_to_login_page() {
		Clickonmyaccountdropdownmenu();
		return clickonloginbutton();
	}

	public loginpage clickonloginbutton() {
		elementutils.clickOnElement(loginbutton);
		// loginbutton.click();
		return new loginpage(driver);
	}

	public Registerpage Selectregisteroption() {
		elementutils.clickOnElement(registeroption);
		// registeroption.click();
		return new Registerpage(driver);
	}

	public void enterProductIntoSearchBoxField(String productText) {
		//searchBoxField.sendKeys(productText);
		elementutils.enterTextIntoTheElement(searchBoxField, productText);

	}

	public SearchPage clickOnSearchButton() {
		elementutils.clickOnElement(searchButton);
		// searchButton.click();
		return new SearchPage(driver);

	}

}
