package Udemy.Shetty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ShettyPracticePage {
	static String dir = System.getProperty("user.dir");

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", dir + "/Driver/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		driver.findElement(By.id("name")).sendKeys("Omar");
		// driver.findElement(By.id("alertbtn")).click();
		// System.out.println(driver.switchTo().alert().getText());
		// Thread.sleep(2000);
		// driver.switchTo().alert().accept();

		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(2000);

		driver.switchTo().alert().dismiss();

		Select obj = new Select(driver.findElement(By.id("dropdown-class-example")));
		obj.selectByVisibleText("Option3");
		Thread.sleep(2000);

		driver.quit();
	}

}
