package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_Web_Browser_Run_Browser {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
//
//	@BeforeClass
//	public void beforeClass() {
//		driver = new FirefoxDriver();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		driver.get("");
//	}

	@Test
	public void TC_01_Run_On_Firefox() {
		driver = new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.quit();		
	}
	
	@Test
	public void TC_02_Run_On_Chrome_Windows() {
		//Windows
		System.setProperty("webdriver.chrome.driver", projectPath + "\\BrowserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.quit();		
	}
	
	//@Test
	public void TC_03_Run_On_Chrome_Mac() {
		// Step 1
		// Step 2 Set permission
		System.setProperty("webdriver.chrome.driver", projectPath + "//BrowserDrivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.quit();		
	}
	
	@Test
	public void TC_04_Run_On_Egde_Windows() {
		System.setProperty("webdriver.edge.driver", projectPath + "\\BrowserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.quit();		
	}
	
	//@Test
	public void TC_05_Run_On_Egde_Mac() {
		System.setProperty("webdriver.edge.driver", projectPath + "//BrowserDrivers//msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.quit();		
	}



//	@AfterClass
//	public void afterClass() {
//		driver.quit();
//	}

}
