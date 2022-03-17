package Udemy.Shetty;


import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class base {
	public WebDriver driver;
	public Properties prop= new Properties();
	
	
	public WebDriver initializeDriver() throws IOException 
	{
		
		FileInputStream fis= new FileInputStream(("user.dir")+"\\eclipse-workspace\\E2EProject\\src\\main\\java\\Resources\\data.properties");
		prop.load(fis);
		
		String browserName=prop.getProperty("browser");
		
		if (browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver",(("user.dir")+"\\Selenium\\chromedriver.exe"));
			driver= new ChromeDriver();
		} 
		
		else if (browserName.equals("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		else if (browserName.equals("IE"))
		{
			driver= new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}
	
	
	public void getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
			
	}

}