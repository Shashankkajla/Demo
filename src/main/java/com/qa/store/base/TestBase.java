package com.qa.store.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.session.FirefoxFilter;

import com.qa.store.util.TestUtil;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;

	public TestBase()
	{
		prop = new Properties();
		
		try{
		FileInputStream ip = new FileInputStream(".\\src\\main\\java\\com\\qa\\store\\config\\config.properties");
		prop.load(ip);
		}
	    catch(FileNotFoundException e){
	    e.printStackTrace();
	    }
	    catch(IOException e){
	    e.printStackTrace();
	    }
	}

	public void initilization()
	{
		String browsername = prop.getProperty("browser");
	   
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ".\\libs\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browsername.equals("FF"))
		{
			/*System.setProperty("webdriver.gecko.driver", "D:\\Driv\\geckodriver.exe");
			driver = new FirefoxDriver();
			*/
		}
	    
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	    driver.get(prop.getProperty("url"));
	    
	}
		
}
