package com.wibmo.page;

import java.io.IOException;

import junit.framework.Assert;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wibmo.base.BasePage;
import com.wibmo.util.Testutil;

public class DTHRechargePayPage extends BasePage{
	
	@FindBy(id="edtTxtSubscriberId")
	private WebElement subscriberID;   
	
	@FindBy(id="operatorSpinner")
	private WebElement operatorDropdown;   
	
	@FindBy(id="input_amount") 
	private WebElement amountTextField;  
	
	@FindBy(id="main_btn_pay") 
	private WebElement payButton; 
	
	@FindBy(name="DTH") 
	private WebElement dthHeaderText;
	
	/*=================constructor====================*/
	public DTHRechargePayPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void verifyDTHLogo()
	{
		Assert.assertEquals("DTH", dthHeaderText);
	}
	
	public void enterSubscriberID()
	{
		subscriberID.clear();
		subscriberID.click();
		subscriberID.sendKeys("41011141201");
	    driver.navigate().back();
	}
		
	public void selectOperator(String operator)
	{
		operatorDropdown.click();
		Testutil.scroll(driver, operator).click();
	
	}
	
	public void enterAmount() throws IOException
	{
		amountTextField.click();
		amountTextField.clear();
		amountTextField.sendKeys("10");
		System.out.println("recharge amount= "+amountTextField.getText());
		driver.navigate().back();
		
	}
	
	public void clickOnPayButton() throws InterruptedException
	{
		payButton.click();
		
	    Thread.sleep(3000);
	}
	
	

}
