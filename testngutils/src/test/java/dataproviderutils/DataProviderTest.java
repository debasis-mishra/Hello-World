package dataproviderutils;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class DataProviderTest {

	WebDriver driver;
	
	@Test(dataProvider = "Authentication",dataProviderClass=testngutils.SampleTestngDataProvider.class)
	public void verifyUserLogin(String uname, String passwd)
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
		el2.sendKeys(passwd);
		
		driver.quit();
	}
}
