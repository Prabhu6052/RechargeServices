package com.wibmo.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wibmo.base.TestBase;

public class RechargeServicesPage extends TestBase{
	
	
	@FindBy(id="image_mobile")
	private WebElement mobileRecharge;
	
	@FindBy(id="image_datacard")
	private WebElement datacardRecharge;
	
	@FindBy(id="image_dth")
	private WebElement dthRecharge;
	
	@FindBy(name="Quick Repeat")
	private WebElement quickRepeatWindow;
	
	@FindBy(name="New")
	private WebElement newWindow;
	
	

	public RechargeServicesPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void selectMobileRecharge() throws Exception
	{
		Thread.sleep(5000);
		mobileRecharge.click();
		
	}
	
	public void selectDataCardRecharge() throws Exception
	{
		Thread.sleep(5000);
		datacardRecharge.click();
	}
	
	public void selectDthRecharge() throws Exception
	{
		Thread.sleep(5000);
		dthRecharge.click();
	}
	
	public void clickOnQuickRepeat() throws Exception
	{
		Thread.sleep(5000);
		quickRepeatWindow.click();
	}
	
	
	public void clickOnNewWindow() throws Exception
	{
		Thread.sleep(5000);
		newWindow.click();
	}
	
	
	
	
}
