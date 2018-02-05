package com.wibmo.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.wibmo.base.TestBase;

public class MobileRechargePage extends TestBase {
	
	public Select select;
	
	@FindBy(name="Prepaid")
	private WebElement prepaidRadioBtn;
	
	@FindBy(name="Postpaid")
	private WebElement postpaidRadioBtn; 
	
	@FindBy(name="Postpaid")
	private WebElement myNumber;
	
	@FindBy(name="Select From Contacts")
	private WebElement selectFromContacts; 
	
	@FindBy(name="Enter mobile number")
	private WebElement enterMobileNumber;
	
	public MobileRechargePage()
	{
		PageFactory.initElements(driver, this); 
	}
	
	public MobileRechargePayPage selectMobileNumbersFromDropdown()
	{
		myNumber.click();
		
		select=new Select(myNumber);
		select.selectByVisibleText("8867321471");
		
		return new MobileRechargePayPage();
	}
	
	public MobileRechargePayPage clickOnMyContacts()
	{
		selectFromContacts.click();
		
		return new MobileRechargePayPage();
	}
	
	public MobileRechargePayPage enterMobileNumber()
	{
		enterMobileNumber.click();
		enterMobileNumber.sendKeys("8867321471");
		
		return new MobileRechargePayPage();
	}
	
	
    
	
	
	
	

}
