package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AT.TestngFramework.ElementUtils;

public class Newsletter_Subscription_page {
	
	WebDriver driver;
    ElementUtils elementUtils;


	public Newsletter_Subscription_page(WebDriver driver) {
		this.driver = driver;
        elementUtils = new ElementUtils(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='newsletter'][@value=1]")
	WebElement yesoption;
	
	public boolean  yes_option_in_neewsletter_sub() {
		return elementUtils.isElementInSelectedState(yesoption);
		 // return yesoption.isSelected();
	}
	
	@FindBy(xpath = "//input[@name='newsletter'][@value=0]")
	WebElement nooption;
	
	public boolean no_option_in_neewsletter_sub() {
		return elementUtils.isElementInSelectedState(nooption);
		 // return nooption.isSelected();
	}
	

}