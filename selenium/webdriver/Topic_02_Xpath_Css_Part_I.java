package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Xpath_Css_Part_I {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
	}

	
	@Test
	public void TC_01_ID() {
		driver.findElement(By.id("FirstName")).sendKeys("Ha");
		driver.findElement(By.id("LastName")).sendKeys("Mai");
		driver.findElement(By.id("Email")).sendKeys("hamai@mailinator.com");
	}
	
	@Test
	public void TC_02_Classname() {
		driver.findElement(By.className("search-box-text")).sendKeys("Laptop");
	}
	
	@Test
	public void TC_03_Name() {
		driver.findElement(By.name("Company")).sendKeys("Restaff");
	}
	
	@Test
	public void TC_04_Tagname() {
		System.out.println(driver.findElements(By.tagName("select")).size());
	}
	
	@Test
	public void TC_05_LinkText() {
		Assert.assertTrue(driver.findElement(By.linkText("Register")).isDisplayed());
	}

	@Test
	public void TC_06_Partial_LinkText() {
		Assert.assertTrue(driver.findElement(By.partialLinkText("Digital")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.partialLinkText("download")).isDisplayed());
	}

	@Test
	public void TC_07_Css() {
		driver.findElement(By.cssSelector("#Password")).sendKeys("P@ss1111");
		driver.findElement(By.cssSelector("input[name='ConfirmPassword']")).sendKeys("P@ss1111");
	}
	
	@Test
	public void TC_08_XPath() {
		driver.findElement(By.xpath("//input[@name='ConfirmPassword']")).clear();
		driver.findElement(By.xpath("//input[@name='ConfirmPassword']")).sendKeys("P@ss1111");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
