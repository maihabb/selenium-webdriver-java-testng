package Exercise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_XPath_CSS {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://live.demoguru99.com/");
		driver.findElement(By.xpath("//div[@class=\"footer\"]//a[@title=\"My Account\"]")).click();
	}

	@Test
	public void TC_01_EmptyEmailPass() {
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.id("pass")).sendKeys("");
		driver.findElement(By.xpath("//button[@id='send2']")).click();
		String message_email = driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText();
		Assert.assertEquals(message_email, "This is a required field.");
		String message_pass = driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText();
		Assert.assertEquals(message_pass, "This is a required field.");
		//or
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).isDisplayed());
	}

	@Test
	public void TC_02_InvalidEmail() {
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@id='pass']")).clear();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("1234@1234");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("12345678");
		driver.findElement(By.xpath("//button[@id='send2']")).click();
		String message_email = driver.findElement(By.xpath("//div[contains(text(),\"valid email address\")]")).getText();
		Assert.assertEquals(message_email, "Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test
	public void TC_03_InvalidPass() {
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@id='pass']")).clear();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmail.com");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("1234");
		driver.findElement(By.xpath("//button[@id='send2']")).click();
		String message_pass = driver.findElement(By.xpath("//div[starts-with(@id, \"advice-validate-password\")]")).getText();
		Assert.assertEquals(message_pass, "Please enter 6 or more characters without leading or trailing spaces.");
	}
	
	@Test
	public void TC_04_IncorrectPass() {
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@id='pass']")).clear();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmail.com");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123456789");
		driver.findElement(By.xpath("//button[@id='send2']")).click();
		String message_pass = driver.findElement(By.xpath("//li[@class=\"error-msg\"]//span")).getText();
		//Assert.assertEquals(message_pass, "Invalid login or password.");
		System.out.println(message_pass);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
