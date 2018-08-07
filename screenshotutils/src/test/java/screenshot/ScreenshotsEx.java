package screenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ScreenshotsEx {

	static WebDriver driver;
	WebElement element;
	
	@BeforeMethod
	public void launchDriver()
	{
		 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + 
				 "/drivers/geckodriver.exe");
		 driver = new FirefoxDriver();
		 driver.manage().window().maximize();
		 driver.get("https://www.guru99.com/");
	}
	
	@Test
	public void verifyHomePage()
	{
		element = driver.findElement(By.xpath("Testing"));
		element.click();
		//Assert.fail("failed...");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
