package tests;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import AT.TestngFramework.ElementUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.AccountLogoutPage;
import Pages.AccountPage;
import Pages.homeepage;
import Pages.loginpage;
import base.Base;

public class LogoutTest extends Base {

	public WebDriver driver;
	
	
	@BeforeMethod
	public void setup() {
		
		driver = openApplicationURLInTheBrowser();
		homeepage = new homeepage(driver);
		homeepage.navigate_to_login_page(); 
		loginpage = new loginpage(driver);
		loginpage.loginToApplication(prop.getProperty("emailid"), prop.getProperty("validpassword"));
		
		/*prop = commonUtils.loadPropertiesFile();
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		homeepage = new homeepage(driver);
		*/

		// Assert.assertTrue(AccountPage.isUserLoggedIn());
		// Assert.assertEquals(driver.getTitle(), "My Account");

		/*
		 * prop = commonUtils.loadPropertiesFile(); driver = new ChromeDriver();
		 * driver.get(prop.getProperty("url")); driver.manage().window().maximize(); //
		 * driver.findElement(By.className("dropdown-toggle")).click();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 * driver.findElement(By.xpath("//a[@title='My Account']")).click();
		 * driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		 * Assert.assertEquals(driver.getTitle(), "Account Login");
		 * driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(prop.
		 * getProperty("emailid"));
		 * driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.
		 * getProperty("validpassword"));
		 * driver.findElement(By.xpath("//input[@value='Login']")).click();
		 * Assert.assertTrue(
		 * driver.findElement(By.xpath("//aside[@id='column-right']//a[text()='Logout']"
		 * )).isDisplayed()); Assert.assertEquals(driver.getTitle(), "My Account");
		 */

	}

	@AfterMethod
	public void teardown() {
		closeBrowser(driver);
		}

	@Test(priority = 1)
	public void logout_from_myaccount_dropmenu() {

		AccountPage AccountPage = new AccountPage(driver);
		AccountLogoutPage = AccountPage.selectLogoutOption();
		Assert.assertEquals(driver.getTitle(), "Account Logout");
		AccountLogoutPage.clickOnContinueButton();
		Assert.assertEquals(driver.getTitle(), "Your Store");

		/*
		 * loginpage loginpage = new loginpage(driver);
		 * loginpage.loginToApplication(prop.getProperty("emailid"),prop.getProperty(
		 * "validpassword"));
		 */

		// driver.findElement(By.linkText("Continue")).click();

	}

	@Test(priority = 2)
	public void logout_from_right_dropmenu() {

		AccountPage AccountPage = new AccountPage(driver);
		AccountLogoutPage = AccountPage.selectRightColumnLogoutOption();
		Assert.assertEquals(driver.getTitle(), "Account Logout");
		AccountLogoutPage.clickOnContinueButton();
		Assert.assertEquals(driver.getTitle(), "Your Store");

		/*
		 * loginpage loginpage = new loginpage(driver);
		 * loginpage.loginToApplication(prop.getProperty("emailid"),prop.getProperty(
		 * "validpassword"));
		 */
        //driver.findElement(By.xpath("//div[@class='list-group']/a[text()='Logout']")).click();

	}
}
