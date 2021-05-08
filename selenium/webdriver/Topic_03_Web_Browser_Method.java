package webdriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_Web_Browser_Method {
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		//...
	}
	
	@Test
	public void TC_01() {
		driver.get("https://demo.nopcommerce.com/");
		driver.close();
		driver.quit();
		String homePageUrl = driver.getCurrentUrl();
		String homePageTitle = driver.getTitle();
		String homePageSource = driver.getPageSource();
		String homePageTabID = driver.getWindowHandle();
		//all tab and window
		Set<String> allWindowIDs = driver.getWindowHandles();
		
		//wait for element
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//wait for page: it dung
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		//wait for script: it dung
		driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
		
		//Ctrl + Space for instruction, set for Mac set key
		// Phong to
		driver.manage().window().maximize();
		
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		
		//History: Save status better for back/forward
		driver.navigate().to("https://demo.nopcommerce.com/");
		
		//Switch to work with Alert, Window,Frame
		driver.switchTo().alert();
		driver.switchTo().frame(1);
		driver.switchTo().window("");
		
		//windows, size, position, cookie
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
		
		
		
	}
	

}
