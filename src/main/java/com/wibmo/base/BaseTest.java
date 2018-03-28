package com.wibmo.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.log4testng.Logger;

public class BaseTest {
	
    public static WebDriver driver;
    
    public Logger log=Logger.getLogger(this.getClass());
    
    public  static WebDriverWait wait;
    
    public static  WebElement element;
    
    public static AppiumDriverLocalService service;
	public static String service_url;
	
	//Set up desired capabilities 
	DesiredCapabilities capabilities = new DesiredCapabilities();
	
	
	//constructor
	public BaseTest()
	{
		this.driver=driver;
		
	}
	
	
	@BeforeClass
	public void setUp() throws IOException
	{   
	
		service = AppiumDriverLocalService
	    		   .buildService(new AppiumServiceBuilder().withIPAddress("127.0.0.1").usingAnyFreePort()
	    		   .withAppiumJS(new File("C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js")));
	      
	       System.out.println("Starting Service ... ");
	       service.start();
	       
	       service_url = service.getUrl().toString();
	       System.out.println(" : "+ service_url);
	       
	       
		capabilities.setCapability("BROWSER_NAME", "");
		capabilities.setCapability("platformVersion", "6.0"); 
		capabilities.setCapability("deviceName","Cloud Fame 4G");
		capabilities.setCapability("platformName", "Android");
		
		//package name of app 
	    capabilities.setCapability("appPackage", "com.enstage.wibmo.staging.hdfc"); 
		capabilities.setCapability("appActivity","com.enstage.wibmo.main.MainActivity"); 
		
			try 
			{
				driver =   new AndroidDriver(new URL(service_url), capabilities);
			} 
			
			catch (Exception e) 
			{
				e.printStackTrace();
			}
				
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}

	
	@AfterClass
	public void close() throws Exception
	 {
		 System.out.println("=====stop driver=====");
		 Thread.sleep(2000);
		 service.stop();
		 
	 }

}
