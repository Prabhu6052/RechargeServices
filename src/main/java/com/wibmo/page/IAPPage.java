package com.wibmo.page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wibmo.base.TestBase;
import com.wibmo.config.EnvironmentVariables;
import com.wibmo.util.Testutil;

public class IAPPage extends TestBase{
	
	Testutil testutil;
	
	
	@FindBy(name="Approve")
	private WebElement approveBtn; 

	@FindBy(name="Cancel")
	private WebElement cancelBtn; 
	
	@FindBy(name="corp Card xxx-9785")
	private WebElement corpCard;
	
	@FindBy(name="Proceed")
	private WebElement proceedBtn;
	
	@FindBy(id="txn_card_arrow")
	private WebElement editCards;
	
	
	public IAPPage()
	{
		PageFactory.initElements(driver, this);
	  //	testutil=new Testutil();
	}
	
	public void clickOnApproveBtn() throws Exception
	{
		element = (new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(editCards));
		element.click();	
		
		corpCard.click();
		
		approveBtn.click();
		
		proceedBtn.click();
		
	}
	
	
	
}
