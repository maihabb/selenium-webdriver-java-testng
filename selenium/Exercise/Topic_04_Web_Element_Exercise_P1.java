package Exercise;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;



public class Topic_04_Web_Element_Exercise_P1 {
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		//timeout and size
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
		
		
	}
	
	@Test (enabled = false)
	public void TC01_isDisplayed () {
		driver.get("https://automationfc.github.io/basic-form/");
		//check element isDisplayed Email, Age <18, Education
		Assert.assertTrue(driver.findElement(By.id("email")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id("under_18")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id("edu")).isDisplayed());
		//check not display Name, user5
		//Assert.assertFalse(driver.findElement(By.id("name")).isDisplayed());
		//Assert.assertFalse(driver.findElement(By.id("user5")).isDisplayed());
		//If is display then sendKeys Automation Test for Email and Education, Age= under18, log console
	}
	
	@Test (enabled = false)
	public void TC02_isEnabled() {
		driver.get("https://automationfc.github.io/basic-form/");
		//email, age, Education, Job Role01/02, Interest checkbox, Slider
		Assert.assertTrue(driver.findElement(By.id("email")).isEnabled());
		Assert.assertTrue(driver.findElement(By.id("under_18")).isEnabled());
		Assert.assertTrue(driver.findElement(By.id("edu")).isEnabled());
		Assert.assertTrue(driver.findElement(By.id("job1")).isEnabled());
		Assert.assertTrue(driver.findElement(By.id("job2")).isEnabled());
		Assert.assertTrue(driver.findElement(By.id("development")).isEnabled());
		Assert.assertTrue(driver.findElement(By.id("slider-1")).isEnabled());
		//Disabled Password, Age, Biography, Job role 03, Interest, Slider 02
		Assert.assertFalse(driver.findElement(By.id("password")).isEnabled());
		Assert.assertFalse(driver.findElement(By.id("radio-disabled")).isEnabled());
		Assert.assertFalse(driver.findElement(By.id("bio")).isEnabled());
		Assert.assertFalse(driver.findElement(By.id("job3")).isEnabled());
		Assert.assertFalse(driver.findElement(By.id("check-disbaled")).isEnabled());
		Assert.assertFalse(driver.findElement(By.id("slider-2")).isEnabled());
		//Log console
		
		
	}
	
	@Test (enabled = false)
	public void TC03_isSelected() {
		driver.get("https://automationfc.github.io/basic-form/");
		//click Age under 18, language Java
		WebElement under18 = driver.findElement(By.id("under_18"));
		WebElement over18 = driver.findElement(By.id("over_18"));
		WebElement java = driver.findElement(By.id("java"));	
		under18.click();
		java.click();
	
		//test if elements selected
		Assert.assertTrue(under18.isSelected());
		Assert.assertTrue(java.isSelected());
		//uncheck element by checked on Over 18
		over18.click();
		java.click();
		//test
		Assert.assertFalse(under18.isSelected());
		Assert.assertFalse(java.isSelected());
		//Log console
	}
	
	@Test
	public void TC04_Mailchimp() {
		driver.get("https://login.mailchimp.com/signup/");
		//Enter valid value for Username and Email
		driver.findElement(By.id("email")).sendKeys("maihabb" + getRandomNum() + "@mailinator.com");
		driver.findElement(By.id("new_username")).sendKeys("maihabb");
		//Validate pass format and SignUp button is disable if password invalid
		//Number
		WebElement newpass = driver.findElement(By.id("new_password"));
		WebElement btn_Create = driver.findElement(By.id("create-account"));
		newpass.sendKeys("123456");
		Assert.assertFalse(btn_Create.isEnabled());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class=\"number-char completed\"]")).isEnabled());
		
		
		newpass.clear();
		//lowercase
		newpass.sendKeys("tingting");
		Assert.assertFalse(btn_Create.isEnabled());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class=\"lowercase-char completed\"]")).isEnabled());
		
		
		newpass.clear();
		//uppercase
		newpass.sendKeys("TINGTING");
		Assert.assertFalse(btn_Create.isEnabled());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class=\"uppercase-char completed\"]")).isEnabled());
		
		newpass.clear();
		//specific character
		newpass.sendKeys("##$$%%^");
		Assert.assertFalse(btn_Create.isEnabled());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class=\"special-char completed\"]")).isEnabled());
		
		newpass.clear();
		//more than 8 characters
		newpass.sendKeys("TINGTINGgrfseyg");
		Assert.assertFalse(btn_Create.isEnabled());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class=\"8-char completed\"]")).isEnabled());
		newpass.clear();
		
		//valid pass
		newpass.sendKeys("Ting@1234");
		Assert.assertTrue(btn_Create.isEnabled());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class=\"number-char completed\"]")).isEnabled());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class=\"lowercase-char completed\"]")).isEnabled());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class=\"uppercase-char completed\"]")).isEnabled());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class=\"special-char completed\"]")).isEnabled());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class=\"8-char completed\"]")).isEnabled());
		
		
		//test checkbox if selected
		WebElement check_mar = driver.findElement(By.id("marketing_newsletter"));
		check_mar.click();
		Assert.assertTrue(check_mar.isSelected());
		
	}
	
	public int getRandomNum() {
		Random rand = new Random();
		return rand.nextInt();
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
		
	}

}
