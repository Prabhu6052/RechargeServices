package com.wibmo.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wibmo.base.BasePage;
import com.wibmo.page.HomePage;
import com.wibmo.page.LoginPage;
import com.wibmo.page.RechargeServicesPage;

public class RechargeServicesPageTest extends BasePage{
	
	LoginPage loginpage;
	HomePage homepage;
	RechargeServicesPage rechargeservicespage;
	
	public RechargeServicesPageTest()
	{
		rechargeservicespage=PageFactory.initElements(BasePage.driver, RechargeServicesPage.class);
	}
	
	@BeforeClass
	public void initialization() throws Exception
	{
		loginpage=new LoginPage();
		loginpage.login();
		homepage=loginpage.clickOnLoginBtn();
	//	homepage.dashBoard();
		rechargeservicespage=homepage.clickOnRechargeIcon();
		
	}
	
	@Test(priority=1)
	public void clickOnMobileRecharge() throws Exception
	{
		rechargeservicespage.selectMobileRecharge();
	}
	
	
}

