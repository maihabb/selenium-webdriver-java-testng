package Exercise;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_Web_Browser_Exercise {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	@Test (enabled = false)
	public void TC_01_ValidateCurrentUrl() {
		driver.get("http://live.demoguru99.com/");
		//Click on My Account at footer
		driver.findElement(By.xpath("//div[@class=\"footer\"]//a[@title=\"My Account\"]")).click();
		//Verify URL http://live.demoguru99.com/index.php/customer/account/login/
		String MyAccountURL = driver.getCurrentUrl();
		Assert.assertEquals(MyAccountURL, "http://live.demoguru99.com/index.php/customer/account/login/");
		//should not use variable if the variable used once
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.demoguru99.com/index.php/customer/account/login/");
		//Click on Create Account
		driver.findElement(By.xpath("//a[@class=\"button\"]")).click();
		//Verify URL http://live.demoguru99.com/index.php/customer/account/create/
		String CreateAccountURL = driver.getCurrentUrl();
		Assert.assertEquals(CreateAccountURL, "http://live.demoguru99.com/index.php/customer/account/create/");
		
	}

	@Test  (enabled = false)
	public void TC_02_ValidatePageTitle() {
		driver.get("http://live.demoguru99.com/");
		driver.findElement(By.xpath("//div[@class=\"footer\"]//a[@title=\"My Account\"]")).click();
		//Verify Title
		Assert.assertEquals(driver.getTitle(), "Customer Login");
		driver.findElement(By.xpath("//a[@class=\"button\"]")).click();
		//Verify Title
		Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
		
	}

	@Test (enabled = false)
	public void TC_03_LoginFormDisplayed() {
		driver.get("http://live.demoguru99.com/");
		//Click on My Account at footer
		driver.findElement(By.xpath("//div[@class=\"footer\"]//a[@title=\"My Account\"]")).click();		
		//Click on Create Account
		driver.findElement(By.xpath("//a[@class=\"button\"]")).click();
		//back
		driver.navigate().back();
		//Verify URL
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.demoguru99.com/index.php/customer/account/login/");
		
		//forward
		driver.navigate().forward();
		//Verify URL
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.demoguru99.com/index.php/customer/account/create/");
	
	}
	
	@Test (enabled = false)
	public void TC_04_Page_Source() {
		driver.get("http://live.demoguru99.com/");
		//Click on My Account at footer
		driver.findElement(By.xpath("//div[@class=\"footer\"]//a[@title=\"My Account\"]")).click();	
		//Verify page include text Login or Create an Account
		Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));
		//Click on Create Account
		driver.findElement(By.xpath("//a[@class=\"button\"]")).click();
		// Verify page include text Create an Account
		Assert.assertTrue(driver.getPageSource().contains("Create an Account"));
	}

	@Test
	public void TC_05_Create_Account() {
		driver.get("http://live.demoguru99.com/");
		//Click on My Account at footer
		driver.findElement(By.xpath("//div[@class=\"footer\"]//a[@title=\"My Account\"]")).click();	
		//Click on Create Account
		driver.findElement(By.xpath("//a[@class=\"button\"]")).click();
		//Fill information
		driver.findElement(By.id("firstname")).sendKeys("Ha");
		driver.findElement(By.id("lastname")).sendKeys("Mai");
		driver.findElement(By.id("email_address")).sendKeys("hamai" + getRandomNum() + "@mailinator.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("confirmation")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@title=\"Register\"]")).click();
		Assert.assertTrue(driver.getPageSource().contains("Thank you for registering with Main Website Store."));
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class=\"success-msg\"]//span")).getText(), "Thank you for registering with Main Website Store.");
		
	
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	public int getRandomNum() {
		Random Rand = new Random();
		return Rand.nextInt();
	}

}
