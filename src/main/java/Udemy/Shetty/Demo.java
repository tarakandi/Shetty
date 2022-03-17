package Udemy.Shetty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Demo 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "/Users/omarfaroque/eclipse-workspace/PNT/Driver/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.amazon.com");
		System.out.println(driver.getTitle());
		
		System.out.println(driver.getCurrentUrl());
		
		driver.get("https://www.facebook.com");
		driver.findElement(By.xpath("//a[contains(text(),'Forgot Password?')]")).click();
		driver.findElement(By.xpath("//input[@id='identify_email']")).sendKeys("5916094567");
		driver.findElement(By.name("did_submit")).click();
		Thread.sleep(4000);
		System.out.println(driver.findElement(By.xpath("//div[contains(text(),'No Search Results')]")).isDisplayed());
		
		//This is a change
		System.out.println("My name is Omar");
		driver.close();
		
		
		

	}

}
