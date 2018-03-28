package com.wibmo.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.wibmo.base.BasePage;
import com.wibmo.page.DTHRechargePayPage;
import com.wibmo.page.HomePage;
import com.wibmo.page.IAPPage;
import com.wibmo.page.LoginPage;
import com.wibmo.page.MobileRechargePage;
import com.wibmo.page.PaymentPage;
import com.wibmo.page.RechargeServicesPage;
import com.wibmo.util.Testutil;

public class DTHRechargePayPageTest extends BasePage{
	
	
    String sheetName1="Sheet1";
	
	Logger log;
	
	LoginPage loginpage;
	HomePage homepage;
	RechargeServicesPage rechargeservicespage;
	MobileRechargePage mobilerechargepage;
	DTHRechargePayPage dthrechargePayPage;
	IAPPage iappage;
	PaymentPage paymentpage;
	
	
	/*========================== Constructor of DataCardRechargePayPageTest===================== */
	public DTHRechargePayPageTest()
	{
		dthrechargePayPage=PageFactory.initElements(BasePage.driver, DTHRechargePayPage.class);
	}

	
	public void initialization() throws Exception
	{
		log.info("=====start of  Initialization method=====");
		iappage=new IAPPage();
		paymentpage=new PaymentPage();
		loginpage=new LoginPage(driver);
		dthrechargePayPage=new DTHRechargePayPage();
		mobilerechargepage=new MobileRechargePage();
		loginpage.login();
		homepage=loginpage.clickOnLoginBtn();
		rechargeservicespage=homepage.clickOnRechargeIcon();
		rechargeservicespage.selectDthRecharge();
				
	}
	
	@Test(priority=1)
	public void TC_DTH_01() throws Exception
	{
        initialization();
		log.info("=====first Initialization method called=====");
		
		dthrechargePayPage.verifyDTHLogo();
		
		dthrechargePayPage.enterSubscriberID();
		
		dthrechargePayPage.selectOperator("Sun TV DTH");
		
		dthrechargePayPage.enterAmount();
		
		dthrechargePayPage.clickOnPayButton();
		
        Thread.sleep(5000);
		
		Testutil.takeScreenShot();
		
		homepage.clickOnLogoutLink();
		
		Thread.sleep(5000);
		
		
	}

}
