package com.wibmo.page;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wibmo.base.BasePage;
import com.wibmo.util.Testutil;

public class MobileRechargePayPage extends BasePage{
	
	public Testutil testutil;

	
	
	@FindBy(id="phoneTypeSpinner")
	private WebElement prepaidPostpaidSpinner;  
	
	@FindBy(id="operatorSpinner")
	private WebElement operatorSpinner;   
	
	@FindBy(id="rcTypeSpinner")
	private WebElement rcTypeSpinner;
	
	@FindBy(id="input_amount")
	private WebElement amount;
	
	@FindBy(id="ll_view_plan")
	private WebElement viewPlans; 
	
	@FindBy(name="Pay")
	private WebElement payBtn;    
	
	@FindBy(id="planAmount")
	private WebElement selectPlan;
	
	
	public MobileRechargePayPage()
	{
		PageFactory.initElements(driver, this);
		
		//testutil=new Testutil();
	}
	


	public void selectOperator(String operator)
	{
		operatorSpinner.click();
		Testutil.scroll(driver, operator).click();
	
	}
	
	public void selectPrepaidOrPostpaidService(String service)
	{
		prepaidPostpaidSpinner.click();
		Testutil.scroll(driver, service).click();
	}
	
	public void selectViewPlan() throws IOException
	{
	 //	viewPlans.click();
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
