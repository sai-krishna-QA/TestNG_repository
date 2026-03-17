package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AT.TestngFramework.ElementUtils;

public class  AccountPage{

    WebDriver driver;
    ElementUtils elementUtils;

    // =========================
    // Constructor
    // =========================
    public AccountPage(WebDriver driver) {
        this.driver = driver;
        elementUtils = new ElementUtils(driver);
        PageFactory.initElements(driver, this);
    }

    // =========================
    // Locators
    // =========================
    @FindBy(linkText = "Subscribe / unsubscribe to newsletter")
    WebElement newsletterlink;

    @FindBy(xpath = "//*[@id='column-right']//a[text()='Logout']")
    WebElement logoutOption;

    @FindBy(xpath = "//span[text()='My Account']")
    WebElement myAccountDropMenu;

    @FindBy(linkText = "Logout")
    WebElement MenuLogoutOption;
    
    
    
    
    
    // =========================
    // Actions / Methods
    // =========================

    public AccountLogoutPage selectLogoutOption() {
        elementUtils.clickOnElement(MenuLogoutOption);
        return new AccountLogoutPage(driver);
    }

    public void clickOnMyAccountDropMenu() {
        elementUtils.clickOnElement(myAccountDropMenu);
    }

    public Newsletter_Subscription_page click_on_Subscribe_unsubscribe_to_newsletter_Link() {
        elementUtils.clickOnElement(newsletterlink);
        return new Newsletter_Subscription_page(driver);
    }

    public boolean isUserLoggedIn() {
        return elementUtils.isElementDisplayed(logoutOption);
    }

    public AccountLogoutPage selectRightColumnLogoutOption() {
        elementUtils.clickOnElement(logoutOption);
        return new AccountLogoutPage(driver);
    }
    
  
}
