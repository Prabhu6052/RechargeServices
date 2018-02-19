package com.wibmo.page;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import com.wibmo.base.TestBase;
import com.wibmo.util.Testutil;

public class MobileRechargePayPage extends TestBase{
	
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
	
	public void selectViewPlan() throws IOException
	{
		viewPlans.click();

		selectPlan.click();
		System.out.println("recharge amount= "+amount.getText());
		
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
