package com.wibmo.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {
	
    public static WebDriver driver;
	
	//Set up desired capabilities 
	DesiredCapabilities capabilities = new DesiredCapabilities();
	
	AppiumDriverLocalService service;
	
	
	public TestBase()
	{
		this.driver=driver;
		
	}
	
	@BeforeClass
	public void setUp()
	{
	    service = AppiumDriverLocalService.buildDefaultService();
		service.start();

		capabilities.setCapability("BROWSER_NAME", "");
		capabilities.setCapability("platformVersion", "6.0"); 
		capabilities.setCapability("deviceName","Cloud Fame 4G");
		capabilities.setCapability("platformName", "Android");
		
		//package name of app 
	    capabilities.setCapability("appPackage", "com.enstage.wibmo.staging.hdfc"); 
		capabilities.setCapability("appActivity","com.enstage.wibmo.main.MainActivity"); 
		
		//It will launch the App in Android Device using the configurations specified in Desired Capabilities
			try {
				driver =   new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
				
			   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}

	
	@AfterClass
	public void close() throws Exception
	 {
		 System.out.println("=====stop driver=====");
		 Thread.sleep(5000);
		 driver.quit();
		 
		 System.out.println("=====stop server=====");
		 service.stop();
	 }
}
