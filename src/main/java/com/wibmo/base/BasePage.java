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

public class BasePage {
	
    public static WebDriver driver;
    
    public Logger log=Logger.getLogger(this.getClass());
    
    public  static WebDriverWait wait;
    
    public static  WebElement element;
    
    public static AppiumDriverLocalService service;
	public static String service_url;
	
	//Set up desired capabilities 
	DesiredCapabilities capabilities = new DesiredCapabilities();
	
	
	//constructor
	public BasePage()
	{
		this.driver=driver;
		
	}
	
	
	
}
