package dataproviderutils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class DataProviderTest1 {

	WebDriver driver;
	
	/*
	 * When data provider is defined in another class and may be in another package, use 
	 * dataProviderClass attribute with Test annotation
	 */
	@Test(dataProvider = "Authentication",dataProviderClass=testngutils.SampleTestngDataProvider.class)
	public void verifyUserLogin(String uname, String passwd) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "/SeleniumReporting/testngutils/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.store.demoqa.com");
		
		WebElement el1 = driver.findElement(By.xpath("//a[@title='My Account']"));
		el1.click();
		
		WebElement el2 = driver.findElement(By.id("log"));
		el2.sendKeys(uname);
		
		WebElement el3 = driver.findElement(By.id("pwd"));
		el3.sendKeys(passwd);
		
		Thread.sleep(10000);
		driver.quit();
	}
}
