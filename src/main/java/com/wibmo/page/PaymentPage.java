package com.wibmo.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wibmo.base.TestBase;
import com.wibmo.util.Testutil;

public class PaymentPage extends TestBase{
	
	public PaymentPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//android.widget.EditText[@index='0']") 
	private WebElement password; 

	@FindBy(xpath="//android.widget.Button[@content-desc='Click here to submit']")
	private WebElement submitBtn; 
	
	
	@FindBy(xpath="//android.widget.Button[@content-desc='Click here to cancel']")
	private WebElement cancelBtn; 
	
	
	public void enterPasswordAndClickOnSubmit() throws Exception
	{
		password.click();
		password.sendKeys("1234");
		
		submitBtn.click();
		
		Thread.sleep(7000);
		Testutil.takeScreenShot();
	}

}
