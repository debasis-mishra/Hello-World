package parameterizationutils;

import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class ParameterizationTest1 {

	WebDriver driver;
	
	@Test
	@Parameters({"author", "searchKey"})
	public void verifyTestNGParameterization(String param1, String param2) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "/SeleniumReporting/testngutils/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
		
		WebElement el1 = driver.findElement(By.name("q"));
		el1.sendKeys(param2);
		
		System.out.println("Welcome ->"+ param1 +" Your search key is->"+ param2);
        System.out.println("Thread will sleep now");
        Thread.sleep(3000);
        
        System.out.println("Value in Google Search Box = "+el1.getAttribute("value") +" ::: Value given by input = "+ param2);
        
        Thread.sleep(5000);
        driver.quit();
	}
}
