package com.wibmo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wibmo.base.BasePage;
import com.wibmo.util.Testutil;

public class PaymentPage extends BasePage{
	
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
		element = (new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(password));
	    element.click();
	    element.sendKeys("1234");
		
		
		submitBtn.click();
		
		Thread.sleep(10000);
		Testutil.takeScreenShot();
	}

}
