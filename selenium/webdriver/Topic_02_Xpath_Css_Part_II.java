package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Xpath_Css_Part_II {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	
	@Test
	public void TC_01_XPATH() {
		driver.get("http://live.demoguru99.com/");
		//technical 1
		//driver.findElement(By.xpath("//div[@class=\"footer\"]//a[@title=\"My Account\"]")).click();
		//technical 2
		driver.findElement(By.xpath("//*[@id='search']")).sendKeys("iphone");
		driver.findElement(By.xpath("//*[@title=\"Search\"]")).click();
		driver.findElement(By.xpath("//div[@class=\"category-products\"]//div[@class=\"actions\"]/button")).click();
		String success_msg = driver.findElement(By.xpath("//li[@class=\"success-msg\"]//span")).getText();
		Assert.assertEquals(success_msg, "IPhone was added to your shopping cart.");
		//technical 03
		//tuyệt đối
		driver.findElement(By.xpath("//span[(text()=\"IPhone was added to your shopping cart.\")]"));
		driver.findElement(By.xpath("//div[@class=\"footer-container\"]//a[(text()=\"My Account\")]"));
		
		//tương đối
		driver.findElement(By.xpath("//span[contains(text(),\"IPhone was added\")]"));
		driver.findElement(By.xpath("//div[@class=\"footer-container\"]//a[contains(text(),\"My Account\")]"));
		driver.findElement(By.xpath("//div[@class=\"footer-container\"]//a[contains(@title,\"My Account\")]"));
		
		//technical 4 starts-with 
		driver.findElement(By.xpath("//div[@class='shipping']/h2[starts-with(text(), \"Estimate\")]"));
		driver.findElement(By.xpath("//div[contains(@class, \"page-title\")]//button[starts-with(@title,\"Proceed\")]"));
		
		//technical 5
		
		
	}
	
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
