package base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import AT.TestngFramework.commonUtils;
import Pages.AccountLogoutPage;
import Pages.AccountPage;
import Pages.Accountsuccesspage;
import Pages.Newsletter_Subscription_page;
import Pages.Registerpage;
import Pages.SearchPage;
import Pages.homeepage;
import Pages.loginpage;

public class Base {
	WebDriver driver;
	public Properties prop; 
	public homeepage homeepage;
	public Registerpage Registerpage;
	public Accountsuccesspage Accountsuccesspage;
	public AccountPage AccountPage;
	public Newsletter_Subscription_page Newsletter_Subscription_page;
	public loginpage loginpage;
	public AccountLogoutPage AccountLogoutPage;
	public SearchPage SearchPage;

	public 	WebDriver openApplicationURLInTheBrowser() {
		
		prop = commonUtils.loadPropertiesFile();
		String browserName = prop.getProperty("browserName");
		 driver = null;
		
		if(browserName.equals("chrome")) {
			 driver = new ChromeDriver();
		} else if(browserName.equals("firefox")) {
			 driver = new FirefoxDriver();
		} else if(browserName.equals("edge")) {
			 driver = new EdgeDriver();
		} else if(browserName.equals("safari")) {
			 driver = new SafariDriver();
		}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;

		}
	
public void closeBrowser(WebDriver driver) {
		
		if(driver!=null) {
			driver.quit();
		}
		
	}
	}


