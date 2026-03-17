package tests;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import AT.TestngFramework.commonUtils;
import Pages.homeepage;
import base.Base;
import AT.TestngFramework.ElementUtils;


public class loginTest extends Base {

	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver = openApplicationURLInTheBrowser();
		homeepage = new homeepage(driver);
		loginpage = homeepage.navigate_to_login_page();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		/*prop = commonUtils.loadPropertiesFile();
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		AccountPage = new AccountPage(driver);
		homeepage = new homeepage(driver); */
		
		// driver.findElement(By.className("dropdown-toggle")).click();
		// homeepage.Selectregisteroption();
		// driver.findElement(By.xpath("//a[@title='My Account']")).click();
		// driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();

	}

	@AfterMethod
	public void teardown() {
		closeBrowser(driver);
		}
		
@Test
	//@Test(priority=1,dataProvider="loginDataProvider")
	//public void Verify_login_with_valid_credentails(HashMap<String, String> hMap){
		public void Verify_login_with_valid_credentails(){

		Assert.assertEquals(driver.getTitle(), "Account Login");
		
		loginpage.Enterfirstname(prop.getProperty("emailid"));
		 //loginpage.Enterfirstname(hMap.get("Username"));
		
		loginpage.Enterpassword(prop.getProperty("validpassword"));
		// loginpage.Enterpassword(hMap.get("Password"));

		AccountPage = loginpage.Clickonloginbutton();
		Assert.assertTrue(AccountPage.isUserLoggedIn());
		Assert.assertEquals(driver.getTitle(), "My Account");

//		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(prop.getProperty("emailid"));                                                             
//		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("validpassword"));
//		driver.findElement(By.xpath("//input[@value='Login']")).click();
//		Assert.assertTrue(driver.findElement(By.xpath("//aside[@id='column-right']//a[text()='Logout']")).isDisplayed());
//		Assert.assertEquals(driver.getTitle(), "My Account");
	}

	/*
	 * @DataProvider(name="loginDataProvider") public Object[][]
	 * dataSupplierMethod() { MyXLSReader myXLSReader = new
	 * MyXLSReader("\\src\\test\\resources\\ProjectData.xlsx"); Object[][] data =
	 * CommonUtils.getTestData(myXLSReader,"Login","DataDrivenSheet"); return data;
	 	}*/
	
	@Test(priority = 2)
	public void Verify_login_with_invalid_credentails() {

		
		Assert.assertEquals(driver.getTitle(), "Account Login");
		loginpage.Enterfirstname(commonUtils.generatenewemail());
		loginpage.Enterpassword(prop.getProperty("invalidpassword"));
		AccountPage = loginpage.Clickonloginbutton();
		Assert.assertEquals(loginpage.getwarningmessage(),"Warning: No match for E-Mail Address and/or Password.");

			
        //Assert.assertEquals(loginpage.getwarningmessage(), "Warning: No match for E-Mail Address and/or Password.");
		//Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).isDisplayed());
	    //Warning: No match for E-Mail Address and/or Password.
		//driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(prop.getProperty("emailidtwo"));
		//driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("invalidpassword"));
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		// Assert.assertEquals(driver.getTitle(), "My Account");
		//Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).isDisplayed());

	}

	@Test(priority = 3)
	public void Verify_login_with_valid_email_and_invalid_pwd() {
		
		
		Assert.assertEquals(driver.getTitle(), "Account Login");
		loginpage.Enterfirstname(commonUtils.generatenewemail());
		loginpage.Enterpassword(prop.getProperty("invalidpassword"));
		AccountPage = loginpage.Clickonloginbutton();
		Assert.assertEquals(loginpage.getwarningmessage(),"Warning: No match for E-Mail Address and/or Password.");
		
//		Assert.assertEquals(driver.getTitle(), "Account Login");
//		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(prop.getProperty("emailid"));
//		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("invalidpassword"));
//		driver.findElement(By.xpath("//input[@value='Login']")).click();
//		Assert.assertEquals(driver.getTitle(), "My Account");
//		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).isDisplayed());
	}

	@Test(priority = 4)
	public void Verify_login_with_invalid_email_and_valid_pwd() {
		
		Assert.assertEquals(driver.getTitle(), "Account Login");
		loginpage.Enterfirstname(prop.getProperty("emailidtwo"));
		loginpage.Enterpassword(prop.getProperty("invalidpassword"));
		AccountPage = loginpage.Clickonloginbutton();
		Assert.assertEquals(loginpage.getwarningmessage(),"Warning: No match for E-Mail Address and/or Password.");
		
		
//		Assert.assertEquals(driver.getTitle(), "Account Login");
//		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("emailidtwo"));
//		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("validpassword"));
//		driver.findElement(By.xpath("//input[@value='Login']")).click();
//		// Assert.assertEquals(driver.getTitle(), "My Account");
//		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).isDisplayed());
	}

	@Test(priority = 5)
	public void Verifyloginwithoutanycredentials() {
		
		Assert.assertEquals(driver.getTitle(), "Account Login");
		AccountPage = loginpage.Clickonloginbutton();
		Assert.assertEquals(loginpage.getwarningmessage(),"Warning: No match for E-Mail Address and/or Password.");
		
//		Assert.assertEquals(driver.getTitle(), "Account Login");
//		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(" ");
//		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(" ");
//		driver.findElement(By.xpath("//input[@value='Login']")).click();
//		Assert.assertEquals(driver.getTitle(), "My Account");
//		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).isDisplayed());

	}

	
}


