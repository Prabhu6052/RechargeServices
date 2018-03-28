package com.wibmo.page;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wibmo.base.BasePage;

public class RechargeServicesPage extends BasePage{
	
	
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
		Assert.assertTrue("Mobile icon is not displayed", mobileRecharge.isDisplayed());
		element = (new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(mobileRecharge));
		element.click();	

	}
	
	public void selectDataCardRecharge() throws Exception
	{
		Thread.sleep(3000);
		Assert.assertTrue("Datacard icon is not displayed", datacardRecharge.isDisplayed());
		datacardRecharge.click();
	}
	
	public void selectDthRecharge() throws Exception
	{
		Thread.sleep(5000);
		Assert.assertTrue("Dth icon is not displayed", dthRecharge.isDisplayed());
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
