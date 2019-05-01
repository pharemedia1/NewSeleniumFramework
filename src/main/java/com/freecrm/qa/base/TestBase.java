package com.freecrm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import com.freecrm.qa.util.TestUtil;

public class TestBase 
{
	public static WebDriver driver; // Initialize webdriver with a static variable and import from selenium
	public static Properties prop;  // Create one more class variable, Properties prop 
	
	
	public TestBase() // Create test base class constructor
	{
		//Read the properties files 
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:/Users/phare/eclipse-workspace/FreeCRMTest_Hybride/src/main/java/com/freecrm/"
					+ "qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	//Create one browser initialization method
	public static void initialization() 
	{
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C://Users//phare//eclipse-workspace//FreeCRMTest_Hybride//src//main//java//com//freecrm//"
					+ "qa//drivers//chrome//chromedriver.exe");
			driver = new ChromeDriver();
		}	
			
		else if (browserName.equals("firefox"))
		{
			System.setProperty("webdriver.firefox.driver", "C:/Users/phare/eclipse-workspace/FreeCRMTest_Hybride/src/main/java/com/freecrm/"
						+ "qa/drivers/firefox/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else if (browserName.equals("opera"))
		{
			System.setProperty("webdriver.operadriver.driver", "C://Users//phare//eclipse-workspace//FreeCRMTest_Hybride//src//main//java//com//freecrm//"
						+ "qa//drivers//opera//operadriver.exe");
			driver = new OperaDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		String urlName = prop.getProperty("url");
		driver.get(urlName);
	

	}
	
}
