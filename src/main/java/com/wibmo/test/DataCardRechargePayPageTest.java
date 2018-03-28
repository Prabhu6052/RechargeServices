package com.wibmo.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.wibmo.base.BasePage;
import com.wibmo.page.DataCardRechargePayPage;
import com.wibmo.page.HomePage;
import com.wibmo.page.IAPPage;
import com.wibmo.page.LoginPage;
import com.wibmo.page.MobileRechargePage;
import com.wibmo.page.MobileRechargePayPage;
import com.wibmo.page.PaymentPage;
import com.wibmo.page.RechargeServicesPage;
import com.wibmo.util.Testutil;

public class DataCardRechargePayPageTest extends BasePage{
	
    String sheetName1="Sheet1";
	
	Logger log;
	
	LoginPage loginpage;
	HomePage homepage;
	RechargeServicesPage rechargeservicespage;
	MobileRechargePage mobilerechargepage;
	DataCardRechargePayPage datacardrechargepaypage;
	IAPPage iappage;
	PaymentPage paymentpage;
	
	
	/*========================== Constructor of DataCardRechargePayPageTest===================== */
	public DataCardRechargePayPageTest()
	{
		datacardrechargepaypage=PageFactory.initElements(BasePage.driver, DataCardRechargePayPage.class);
	}

	
	public void initialization() throws Exception
	{
		log.info("=====start of  Initialization method=====");
		iappage=new IAPPage();
		paymentpage=new PaymentPage();
		loginpage=new LoginPage();
		datacardrechargepaypage=new DataCardRechargePayPage();
		mobilerechargepage=new MobileRechargePage();
		loginpage.login();
		homepage=loginpage.clickOnLoginBtn();
	//	homepage.dashBoard();
		rechargeservicespage=homepage.clickOnRechargeIcon();
		rechargeservicespage.selectDataCardRecharge();
		mobilerechargepage.enterDataCardNumber();
				
	}
	
	@DataProvider
	public Object[][] getOperatorTestData()
	{
		Object[][] data=Testutil.getTestData(sheetName1);
		
		return data;
		
	}
	
	
	/*==========================Prepaid datacardrecharge===================== */
	@Test(priority=1)
	public void TC_01() throws Exception
	{
		initialization();
		
		System.out.println("=====first Initialization method called=====");
		
		datacardrechargepaypage.selectOperator("Vodafone");
		System.out.println("=====operator has been selected=====");
		
		datacardrechargepaypage.enterAmount();
		System.out.println("======Amount entered=====");
		
		datacardrechargepaypage.clickOnPayButton();
		System.out.println("======clicked on pay button=====");
		
		iappage.clickOnApproveBtn();
		Thread.sleep(5000);
		
		paymentpage.enterPasswordAndClickOnSubmit();
	
		Thread.sleep(5000);
		
		Testutil.takeScreenShot();
		
		homepage.clickOnLogoutLink();
		
		Thread.sleep(5000);
		
	}
	
	
	/*==========================Postpaid datacardrecharge===================== */
	@Test(priority=2)
	public void TC_02() throws Exception
	{
		Thread.sleep(2000);
		initialization();
		
	    log.info("=====second Initialization method called=====");
		
		datacardrechargepaypage.selectPrepaidOrPostpaidService("Postpaid");
		
		datacardrechargepaypage.selectOperator("Vodafone");
		System.out.println("=====operator has been selected=====");
		
		datacardrechargepaypage.enterAmount();
		System.out.println("======Amount entered=====");
		
		datacardrechargepaypage.clickOnPayButton();
		System.out.println("======clicked on pay button=====");
		
		iappage.clickOnApproveBtn();
		Thread.sleep(5000);
		
		paymentpage.enterPasswordAndClickOnSubmit();
		
        Thread.sleep(5000);
		
		Testutil.takeScreenShot();
		
		homepage.clickOnLogoutLink();
		
		Thread.sleep(5000);
		
	}
	
}
