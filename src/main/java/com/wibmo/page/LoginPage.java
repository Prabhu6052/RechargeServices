package com.wibmo.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wibmo.base.TestBase;

public class LoginPage extends TestBase{
	
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
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void login() throws Exception
	{
	 /*	WebElement element1;
		wait=new WebDriverWait(driver,20); 
		element1=wait.until(ExpectedConditions.visibilityOfElementLocated(one));
		element1.click();  */
		
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
    	loginBtn.click();
    	Thread.sleep(3000);

    	
		return new HomePage(); 
    }
    
    public String verifyHomePageTitle()
    {
    	return driver.getTitle();
    }
    

}
