package com.wibmo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wibmo.base.TestBase;
import com.wibmo.util.Testutil;

public class MobileRechargePage extends TestBase {
	
    public Testutil testutil;
	
	@FindBy(name="Prepaid")
	private WebElement prepaidRadioBtn;
	
	@FindBy(name="Postpaid")
	private WebElement postpaidRadioBtn; 
	
	@FindBy(name="Select mobile number")
	private WebElement myNumber;
	
	@FindBy(name="Select From Contacts")
	private WebElement selectFromContacts; 
	
	@FindBy(name="Enter mobile number")
	private WebElement enterMobileNumber;
	
	
	public MobileRechargePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void selectPostPaidService()
	{
		postpaidRadioBtn.click();
	}
	
	public void selectMobileNumbersFromDropdown()
	{
		myNumber.click();
		
		//testutil.scroll(driver, "8867321471");
	    driver.findElement(By.name("8867321471")).click();
	    
	    
	//	select=new Select(myNumber);
	//	select.selectByVisibleText("8867321471");
		
	//	return new MobileRechargePayPage();
	}
	
	public MobileRechargePayPage clickOnMyContacts()
	{
		selectFromContacts.click();
		
		return new MobileRechargePayPage();
	}
	
	public void enterMobileNumber()
	{
		enterMobileNumber.click();
		
	//	testutil.scroll(driver, "8867321471");
		
		enterMobileNumber.sendKeys("8867321471"); 
		
	//	return new MobileRechargePayPage();
	}
	
	
    
	
	
	
	

}
