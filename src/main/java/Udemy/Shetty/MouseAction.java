package Udemy.Shetty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseAction 
{
	static String dir = System.getProperty("user.dir");
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", dir+"/Driver/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/droppable/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		System.out.println(driver.getTitle());

		Actions m = new Actions(driver);
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		WebElement status = driver.findElement(By.xpath("//div[@id='droppable']/p"));
		System.out.println(status.getText());
		m.dragAndDrop(drag, drop).build().perform();
		if(status.getText().contains("Dropped!"))
		{
			System.out.println("Test Passed");
		}
		
		driver.switchTo().defaultContent();
		System.out.println(driver.getTitle());
		
		driver.quit();
	}

}
