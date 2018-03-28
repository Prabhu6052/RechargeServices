package com.wibmo.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.wibmo.base.BasePage;

public class LoginPage extends BasePage{
	
	@FindBy(name="1")
	private WebElement one;
	
	@FindBy(name="2")
	private WebElement two;
	
	@FindBy(name="3")
	private WebElement three;
	
	@FindBy(name="4")
	private WebElement four;
	
	@FindBy(name="Login")
	private WebElement loginBtn;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void login() throws Exception
	{	
		Thread.sleep(5000);
		one.click();
		
		two.click();
		
		three.click();
		
		four.click();
		
		
	}
    
    public HomePage clickOnLoginBtn() throws InterruptedException
    {
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
    	
    	Assert.assertTrue(loginBtn.isDisplayed(), "Login Button is not displayed");
    	loginBtn.click();
    	Thread.sleep(3000);

    	
		return new HomePage(); 
    }
    
   
    

}
