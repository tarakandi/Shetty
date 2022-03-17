package Udemy.Shetty;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table
{
	static String dir = System.getProperty("user.dir");
	public static void main(String args[])
	{
		System.setProperty("webdriver.chrome.driver", dir+"/Driver/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		driver.manage().window().maximize();
		
		WebElement table = driver.findElement(By.id("product"));
		int rowCount =  table.findElements(By.tagName("tr")).size();
		int colCount = table.findElements(By.tagName("th")).size();
		
		for(int i = 2; i <= rowCount; i++)
		{
			for(int j = 1; j <= colCount; j++)
			{
				System.out.println(driver.findElement(By.xpath("//table[@id='product']/tbody/tr["+i+"]/td["+j+"]")).getText());
			}
		}
		driver.quit();
	}

}
