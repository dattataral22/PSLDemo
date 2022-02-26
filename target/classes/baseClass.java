package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class baseClass 
{
  public static WebDriver driver;
  public static Properties prop;
  public static FileInputStream fis;
  public static Logger log=LogManager.getLogger(baseClass.class.getName());
	
	public WebDriver startBrowser() throws IOException
	{
		
		prop=new Properties();
		fis=new FileInputStream("D:\\Seleninum\\Udemy_Selenium\\PSLFramework\\src\\main\\java\\Utility\\common.properties");
		prop.load(fis);
		
	//	String browserName=prop.getProperty("browser");
		String browserName=System.getProperty("browser");
		System.out.println(browserName);
		
		//if(browserName.equalsIgnoreCase("chrome"))
		if(browserName.contains("chrome"))
		{
			// if you want headless execution mechanism means without opening the browser need to use chromeoptions.
			System.setProperty("webdriver.chrome.driver", "D:/Seleninum/Udemy_Selenium/BrowserDrivers/chromedriver_win32/chromedriver.exe/");
			
			log.info("browserinitiated successffully");
			ChromeOptions option=new ChromeOptions();// for headless execution
			if(browserName.contains("headless"))
			{
			option.addArguments("headless");// this is heart of headless execution.
			}
			driver=new ChromeDriver(option);// need to pass the instance of chromeOptions
			
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.chrome.driver", "D:/Seleninum/Udemy_Selenium/BrowserDrivers/chromedriver_win32/chromedriver.exe/");
			driver=new FirefoxDriver();		
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.chrome.driver", "D:/Seleninum/Udemy_Selenium/BrowserDrivers/chromedriver_win32/chromedriver.exe/");
			driver=new InternetExplorerDriver();
		}
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		log.info("screen maximize successfully");
		driver.manage().deleteAllCookies();
		log.info("cookies deleted successfully");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	public String getScreenshot(String testname, WebDriver driver) throws IOException
	{
		File screenshotfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		
		String destination=System.getProperty("user.dir")+"\\reports\\"+testname+".png";
		FileUtils.copyFile(screenshotfile, new File(destination));
		
		
		return destination;
		
	}
	
	
	
	
	
}
