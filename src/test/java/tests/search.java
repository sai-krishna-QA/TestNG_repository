package tests;

import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import AT.TestngFramework.commonUtils;
import Pages.AccountPage;
import Pages.SearchPage;
import Pages.homeepage;
import Pages.loginpage;
import base.Base;

public class search extends Base {
	WebDriver driver;

	@BeforeMethod
	public void setup() {

		driver = openApplicationURLInTheBrowser();
		homeepage = new homeepage(driver);
		loginpage = homeepage.navigate_to_login_page();
		
		loginpage = new loginpage(driver);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		loginpage.loginToApplication(prop.getProperty("emailid"), prop.getProperty("validpassword"));
		SearchPage = new SearchPage(driver);

		/*
		 * prop = commonUtils.loadPropertiesFile(); driver = new ChromeDriver();
		 * driver.get(prop.getProperty("url")); driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 */

		// Assert.assertTrue(AccountPage.isUserLoggedIn());
		// Assert.assertEquals(driver.getTitle(), "My Account");

		// driver.get("https://tutorialsninja.com/demo/");
		// driver.findElement(By.className("dropdown-toggle")).click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// driver.findElement(By.xpath("//a[@title='My Account']")).click();
		// driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		// Assert.assertEquals(driver.getTitle(), "Account Login");

		// driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(prop.getProperty("emailid"));
		// driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("validpassword"));
		// driver.findElement(By.xpath("//input[@value='Login']")).click();
		// Assert.assertTrue(driver.findElement(By.xpath("//aside[@id='column-right']//a[text()='Logout']")).isDisplayed());
		// Assert.assertEquals(driver.getTitle(), "My Account");
		// homeepage = new homeepage(driver);

	}

	@AfterMethod
	public void teardown() {
		closeBrowser(driver);
	}

	@Test(priority = 1)
	public void searching_with_an_existing_Product_Name() throws InterruptedException {

		homeepage = new homeepage(driver);
		homeepage.enterProductIntoSearchBoxField(prop.getProperty("validproductone"));
		SearchPage = new SearchPage(driver);
		SearchPage = homeepage.clickOnSearchButton();
		Assert.assertTrue(SearchPage.isProductDisplayedInSearchResults());

		// driver.findElement(By.name("search")).sendKeys(prop.getProperty("validproductone"));
		// driver.findElement(By.xpath("//button[@class='btn btn-default
		// btn-lg']")).click();
		// Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='MacBook']")).isDisplayed());
	}

	/*
	 * @Test(priority = 2) public void searching_with_a_non_existing_Product_Name()
	 * {
	 * 
	 * homeepage = new homeepage(driver);
	 * driver.findElement(By.name("search")).clear();
	 * 
	 * homeepage.enterProductIntoSearchBoxField(prop.getProperty("nonvalidproduct"))
	 * ; homeepage.clickOnSearchButton();
	 * Assert.assertEquals(SearchPage.getMessage()
	 * ,"There is no product that matches the search criteria.");
	 */

	@Test(priority = 2)
	public void searching_with_a_non_existing_Product_Name() {

		homeepage = new homeepage(driver);
		homeepage.enterProductIntoSearchBoxField(prop.getProperty("nonvalidproduct"));
		SearchPage = homeepage.clickOnSearchButton(); // ⭐ assign
		Assert.assertEquals(SearchPage.getMessage(), "There is no product that matches the search criteria.");
	}

	// driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(prop.getProperty("nonvalidproduct"));
	// driver.findElement(By.xpath("//button[@class='btn btn-default
	// btn-lg']")).click();
	// Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']/p[2]")).getText(),"There
	// is no product that matches the search criteria.");
	// driver.findElement(By.xpath("//a[normalize-space()='imac']")).isDisplayed();

	@Test(priority = 3)
	public void searching_without_providing_any_Product_Name() throws InterruptedException {

		homeepage = new homeepage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		SearchPage = homeepage.clickOnSearchButton();
		Assert.assertEquals(SearchPage.getMessage(), "There is no product that matches the search criteria.");
		
		// driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(" ");
		// driver.findElement(By.xpath("//button[@class='btn btn-default
		// btn-lg']")).click();
		// Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']/p[2]")).getText(),
		// "There is no product that matches the search criteria.");
	}
}

//72 1.43 min 
