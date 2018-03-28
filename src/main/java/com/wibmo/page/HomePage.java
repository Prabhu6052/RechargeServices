package com.wibmo.page;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.wibmo.base.BasePage;

public class HomePage extends BasePage{
	
	@FindBy(id="image_bill_pay")
	private WebElement rechargeIcon;
	
	@FindBy(name="PayZapp Home")
	private WebElement homepageTitle;  //More options
	
	@FindBy(xpath="//android.widget.ImageView[@content-desc='More options']")
	private WebElement moreOptions;
	
	@FindBy(name="Logout")
	private WebElement logout;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
		
/*	public void dashBoard() 
	{
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int i=0;i<2;i++)
		{   
			driver.navigate().back(); 
		}
			
	}
*/
	public void verifyHomePageTitle()
    {
	
		Assert.assertTrue("PayZapp home page title is not displayed", homepageTitle.isDisplayed());
    	
    }
    
	
	public RechargeServicesPage clickOnRechargeIcon()
	{
		 Assert.assertTrue("Recharge Icon is not displayed", rechargeIcon.isDisplayed());
		 element = (new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(rechargeIcon));
		 element.click();
		
		return new RechargeServicesPage();
		
	}
	
	//logout from the app
	public void clickOnLogoutLink()
	{
		moreOptions.click();
		logout.click();
	}
	



	
	

}
