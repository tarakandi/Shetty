package Udemy.Shetty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SpiceJet 
{
	static String dir = System.getProperty("user.dir");
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", dir+"/Driver/chromedriver");
		WebDriver driver = new ChromeDriver();
	
		
		driver.get("http://www.spicejet.com");
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Bengaluru (BLR)')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id = 'glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value = 'MAA']")).click();;
		
		
		
		//Select Senior
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).click();
		int cb = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
		System.out.println(cb);
		Assert.assertEquals(cb, 6);
		
		boolean scd = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected();
		System.out.println(scd);
		Assert.assertTrue(scd);
		
		//One Way, return date is disabled.
		driver.findElement(By.id("ctl00_mainContent_view_date2"));
		
		Thread.sleep(5000);
		driver.quit();
	}

}
	
