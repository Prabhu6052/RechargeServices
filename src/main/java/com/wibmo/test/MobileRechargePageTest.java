package com.wibmo.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wibmo.base.TestBase;
import com.wibmo.page.HomePage;
import com.wibmo.page.LoginPage;
import com.wibmo.page.MobileRechargePage;
import com.wibmo.page.RechargeServicesPage;

public class MobileRechargePageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	RechargeServicesPage rechargeservicespage;
	MobileRechargePage mobilerechargepage;
	
	public MobileRechargePageTest()
	{
		mobilerechargepage=PageFactory.initElements(TestBase.driver, MobileRechargePage.class);
	}
	
	@BeforeClass
	public void initialization() throws Exception
	{
		loginpage=new LoginPage();
		mobilerechargepage=new MobileRechargePage();
		loginpage.login();
		homepage=loginpage.clickOnLoginBtn();
		homepage.dashBoard();
		rechargeservicespage=homepage.clickOnRechargeIcon();
		rechargeservicespage.selectMobileRecharge();
				
	}
	
	@Test
	public void clickOnMyNumber()
	{
		mobilerechargepage.enterMobileNumber();
		
	}
	
	
	

}
