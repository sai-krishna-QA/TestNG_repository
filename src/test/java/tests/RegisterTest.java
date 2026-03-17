package tests;

import java.time.Duration;
import java.util.Properties;
import AT.TestngFramework.ElementUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import AT.TestngFramework.commonUtils;
import Pages.AccountPage;
import Pages.Accountsuccesspage;
import Pages.Newsletter_Subscription_page;
import Pages.homeepage;
import base.Base;

public class RegisterTest extends Base {

	public WebDriver driver;

	

	// =========================
	// Setup
	// =========================
	@BeforeMethod
	public void setup() {
		
		driver = openApplicationURLInTheBrowser();
		homeepage = new homeepage(driver);
		homeepage.Clickonmyaccountdropdownmenu();
		Registerpage = homeepage.Selectregisteroption();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		
		/*
		  prop = commonUtils.loadPropertiesFile();
		  driver = new ChromeDriver(); driver.get(prop.getProperty("url"));
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		 */
	}

	// =========================
	// Teardown
	// =========================
	@AfterMethod
	public void teardown() {
		closeBrowser(driver);
		}

	// =========================
	// Test 1
	// =========================
	@Test(priority = 1)
	public void Verify_RegisterAccount_using_Mandatory_fields() {

		Registerpage.Enterfirstname(prop.getProperty("firstname"));
		//Registerpage.Enterlastname(myXLSReader.getCellData("DataSheet",2,3));
		Registerpage.Enterlastname(prop.getProperty("lastname"));
		Registerpage.Enteremail(commonUtils.generatenewemail());
		Registerpage.Entertelephone(prop.getProperty("telephone"));
		Registerpage.EnterValidpassword(prop.getProperty("validpassword"));
		Registerpage.Enterconfirmpassword(prop.getProperty("Confirmpassword"));
		Registerpage.ClickonAgreebutton();
		Accountsuccesspage = Registerpage.ClickonContinuebutton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Assert.assertTrue(Accountsuccesspage.logout_option_is_displayed());
		Assert.assertEquals(driver.getTitle(), "Your Account Has Been Created!");

		// Accountsuccesspage.click_on_continue_button();

		// Assert.assertEquals(driver.getTitle(), "My Account");
	}

	// =========================
	// Test 2
	// =========================
	@Test(priority = 2)
	public void VerifyRegisterAccountusingallrequiredfields() {

		Registerpage.Enterfirstname(prop.getProperty("firstname"));
		Registerpage.Enterlastname(prop.getProperty("lastname"));
		Registerpage.Enteremail(commonUtils.generatenewemail());
		Registerpage.Entertelephone(prop.getProperty("telephone"));
		Registerpage.EnterValidpassword(prop.getProperty("validpassword"));
		Registerpage.Enterconfirmpassword(prop.getProperty("Confirmpassword"));
		Registerpage.Click_yes_on_newsletter_button();
		Registerpage.ClickonAgreebutton();
		Accountsuccesspage = Registerpage.ClickonContinuebutton();

		Assert.assertTrue(Accountsuccesspage.logout_option_is_displayed());
		Assert.assertEquals(driver.getTitle(), "Your Account Has Been Created!");

		Accountsuccesspage.click_on_continue_button();

		Assert.assertEquals(driver.getTitle(), "My Account");
	}

	// =========================
	// Test 3
	// =========================
	@Test(priority = 3)
	public void VerifyRegisteringBysubscribingtoothenewsletter() {

		//Registerpage Registerpage = new Registerpage(driver);

		Registerpage.Enterfirstname(prop.getProperty("firstname"));
		Registerpage.Enterlastname(prop.getProperty("lastname"));
		Registerpage.Enteremail(commonUtils.generatenewemail());
		Registerpage.Entertelephone(prop.getProperty("telephone"));
		Registerpage.EnterValidpassword(prop.getProperty("validpassword"));
		Registerpage.Enterconfirmpassword(prop.getProperty("Confirmpassword"));
		Registerpage.Click_yes_on_newsletter_button();
		Registerpage.ClickonAgreebutton();

		Accountsuccesspage = Registerpage.ClickonContinuebutton();

		Assert.assertTrue(Accountsuccesspage.logout_option_is_displayed());
		Assert.assertEquals(driver.getTitle(), "Your Account Has Been Created!");

		AccountPage = Accountsuccesspage.click_on_continue_button();

		Assert.assertEquals(driver.getTitle(), "My Account");

		Newsletter_Subscription_page = AccountPage.click_on_Subscribe_unsubscribe_to_newsletter_Link();

		Assert.assertEquals(driver.getTitle(), "Newsletter Subscription");

		Newsletter_Subscription_page = new Newsletter_Subscription_page(driver);

		Assert.assertTrue(Newsletter_Subscription_page.yes_option_in_neewsletter_sub());
	}

	// =========================
	// Test 4
	// =========================
	@Test(priority = 4)
	public void VerifyRegisteringBynotsubscribingtoothenewsletter() {

	//	Registerpage Registerpage = new Registerpage(driver);

		Registerpage.Enterfirstname(prop.getProperty("firstname"));
		Registerpage.Enterlastname(prop.getProperty("lastname"));
		Registerpage.Enteremail(commonUtils.generatenewemail());
		Registerpage.Entertelephone(prop.getProperty("telephone"));
		Registerpage.EnterValidpassword(prop.getProperty("validpassword"));
		Registerpage.Enterconfirmpassword(prop.getProperty("Confirmpassword"));
		Registerpage.Click_no_on_newsletter_button();
		Registerpage.ClickonAgreebutton();
		Registerpage.ClickonContinuebutton();

		Accountsuccesspage Accountsuccesspage = new Accountsuccesspage(driver);

		Accountsuccesspage.click_on_continue_button();
		Accountsuccesspage.click_on_Subscribe_unsubscribe_to_newsletter_Link();

		Assert.assertEquals(driver.getTitle(), "Newsletter Subscription");

		Newsletter_Subscription_page Newsletter_Subscription_page = new Newsletter_Subscription_page(driver);

		Assert.assertTrue(Newsletter_Subscription_page.no_option_in_neewsletter_sub());
	}

	// =========================
	// Utility
	// =========================
	
}
