package com.wibmo.page;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wibmo.base.BasePage;
import com.wibmo.util.Testutil;

public class DataCardRechargePayPage extends BasePage{
	
    public Testutil testutil;

	
	@FindBy(id="phoneTypeSpinner")
	private WebElement prepaidPostpaidSpinner;  
	
	@FindBy(id="operatorSpinner")
	private WebElement operatorSpinner;   
	
	@FindBy(id="input_amount")
	private WebElement amount;
	
	@FindBy(name="Pay")
	private WebElement payBtn;    
	

	/*=================constructor====================*/
	public DataCardRechargePayPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void selectPrepaidOrPostpaidService(String service)
	{
		prepaidPostpaidSpinner.click();
		Testutil.scroll(driver, service).click();
	}
	
	public void selectOperator(String operator)
	{
		operatorSpinner.click();
		Testutil.scroll(driver, operator).click();
	
	}
	
	public void enterAmount() throws IOException
	{
        amount.click();
        amount.clear();
        amount.sendKeys("10");
        
		System.out.println("recharge amount= "+amount.getText());
		
		driver.navigate().back();
		
	}
	
	public void clickOnPayButton() throws InterruptedException
	{
		payBtn.click();
		
	    Thread.sleep(3000);
		
	}
	
	public void takeIAPScreenShot() throws IOException
	{
		testutil.takeScreenShot(); 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
