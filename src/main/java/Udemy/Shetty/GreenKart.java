package Udemy.Shetty;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class GreenKart 
{
	//Added To Github chsnge
	static String dir = System.getProperty("user.dir");

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", dir + "/Driver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		System.out.println(driver.getWindowHandle());
		
		WebElement cart = driver.findElement(By.cssSelector("img[alt='Cart']"));
		WebElement checkout = driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']"));
		

		List<WebElement> grnK =  driver.findElements(By.cssSelector("h4[class='product-name']"));
		String[] items = {"Cucumber", "Water Melon", "Tomato", "Brocolli"};
		int[] itemsQuantity = {4, 2, 7, 3};
		
		//j is used to click the WebElement in j index
		int j = 0;
		//k is used to get the index of items, to able to update Quantity and to break out of loop.
		for(WebElement i: grnK)
		{ 
			List al = Arrays.asList(items);
			String[] itemArr= i.getText().split("-");
			//My name is Omar
			String itemName = itemArr[0].trim();
			//System.out.println(i.getText());
			//if(i.getText().equalsIgnoreCase("Beans - 1 Kg"))
			if(al.contains(itemName))
			{
				
				//System.out.println(i.getText());
				int k = al.indexOf(itemName);
				k = itemsQuantity[k];
				for(int m=0; m<k-1; m++)
				{
					driver.findElements(By.xpath("//a[@class='increment']")).get(j).click();
				}
				driver.findElements(By.xpath("//button[text() = 'ADD TO CART']")).get(j).click();
				j--;
				
				/*if(k == items.length)
				{
					break;
				}*/
				
				Thread.sleep(5000);
				
			}
			j++;
		}
		
		cart.click();
		Thread.sleep(5000);
		checkout.click();
		driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button[class='promoBtn']")).click();
		WebElement promo = driver.findElement(By.xpath("//span[@class='promoInfo']"));
		System.out.println(promo.getText());
		Assert.assertTrue(promo.isDisplayed());
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		
		Select food = new Select(driver.findElement(By.cssSelector("select[style='width: 200px;']")));
		food.selectByVisibleText("Bangladesh");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();

		//System.out.println(driver.findElement(By.cssSelector("h4[class='product-name']")).getText());
		driver.quit();
	}

}
