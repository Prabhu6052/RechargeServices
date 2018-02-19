package com.wibmo.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.wibmo.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(id="image_bill_pay")
	private WebElement rechargeIcon;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
		
	public void dashBoard() 
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int i=0;i<2;i++)
		{   
			driver.navigate().back(); 
		}
			
	}
	
	public RechargeServicesPage clickOnRechargeIcon()
	{
		rechargeIcon.click();
		
		return new RechargeServicesPage();
		
	}


	
	

}
