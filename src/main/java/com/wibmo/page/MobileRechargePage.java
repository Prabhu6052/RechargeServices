package com.wibmo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.wibmo.base.BasePage;
import com.wibmo.util.Testutil;

public class MobileRechargePage extends BasePage {
	
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
	
	@FindBy(name="Enter data card number")
	private WebElement enterDataCardNumber;
	
	
	public MobileRechargePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	/*==========================Selects the connection type (postpaid)========================== */
	public void selectPostPaidService()
	{
		log.info("=============postpaid connection type===============");
		Assert.assertTrue(postpaidRadioBtn.isDisplayed(), "Postpaid radio button is not displayed");
		postpaidRadioBtn.click();
	}
	
	
	
	/*==========================Selects mobile number from dropdown========================== */
	public void selectMobileNumbersFromDropdown()
	{
		log.info("===============selecting mobile number from dropdown=============");
		myNumber.click();
		//testutil.scroll(driver, "8867321471");
	    driver.findElement(By.name("8867321471")).click();
	    
	}
	
	
	public MobileRechargePayPage clickOnMyContacts()
	{
		selectFromContacts.click();
		
		return new MobileRechargePayPage();
	}
	
	public void enterMobileNumber()
	{
		enterMobileNumber.click();
	
		enterMobileNumber.sendKeys("8867321471"); 
		
	}
	
	
	public void enterDataCardNumber()
	{
		enterDataCardNumber.click();
		enterDataCardNumber.sendKeys("8867321471"); 
		
	}
	
	
	
	
	

}
