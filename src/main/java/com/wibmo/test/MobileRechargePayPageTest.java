package com.wibmo.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.wibmo.base.BasePage;
import com.wibmo.page.HomePage;
import com.wibmo.page.IAPPage;
import com.wibmo.page.LoginPage;
import com.wibmo.page.MobileRechargePage;
import com.wibmo.page.MobileRechargePayPage;
import com.wibmo.page.PaymentPage;
import com.wibmo.page.RechargeServicesPage;
import com.wibmo.util.Testutil;

public class MobileRechargePayPageTest extends BasePage {
	
	String sheetName1="Sheet1"; 
	
	Logger log;
	
	LoginPage loginpage;
	HomePage homepage;
	RechargeServicesPage rechargeservicespage;
	MobileRechargePage mobilerechargepage;
	MobileRechargePayPage mobilerechargepaypage;
	IAPPage iappage;
	PaymentPage paymentpage;
	MobileRechargePayPageTest rechrage;
	
	
	public MobileRechargePayPageTest()
	{
		mobilerechargepaypage=PageFactory.initElements(BasePage.driver, MobileRechargePayPage.class);
	}
	
	
	
	public void initialization() throws Exception
	{
		System.out.println("=====start of  Initialization method=====");
		iappage=new IAPPage();
		paymentpage=new PaymentPage();
		loginpage=new LoginPage();
		mobilerechargepaypage=new MobileRechargePayPage();
		mobilerechargepage=new MobileRechargePage();
		loginpage.login();
		homepage=loginpage.clickOnLoginBtn();
	//	homepage.dashBoard();
		rechargeservicespage=homepage.clickOnRechargeIcon();
		rechargeservicespage.selectMobileRecharge();
		mobilerechargepage.enterMobileNumber();
				
	}
	
	
  	@DataProvider
	public Object[][] getOperatorTestData()
	{
		Object[][] data=Testutil.getTestData(sheetName1);
		
		return data;
		
	}
  
	
	
/*	@DataProvider
	public Object[][] getOperatorTestData()
	{
		Object[][] data=Testutil.getTestDataFromExcel(sheetName1);
		
		return data;
	}
  
*/	
	
  	/*==========================Prepaid recharge===================== */
	@Test(priority=1, dataProvider="getOperatorTestData")
	public void TC_01(String firstRow_1stCol) throws Exception
	{
			
		initialization();
		
		System.out.println("=====first Initialization method called=====");
	
		
		mobilerechargepaypage.selectOperator(firstRow_1stCol);
		System.out.println("=====operator has been selected=====");
		
		mobilerechargepaypage.selectViewPlan();
		System.out.println("======plans displayed=====");
		
		mobilerechargepaypage.clickOnPayButton();
		System.out.println("======clicked on pay button=====");
		
		iappage.clickOnApproveBtn();
		Thread.sleep(5000);
		
		paymentpage.enterPasswordAndClickOnSubmit();
	
		Thread.sleep(5000);
		
		Testutil.takeScreenShot();
		
		homepage.clickOnLogoutLink();
		
		Thread.sleep(5000);
		
	}
	
	
	/*==========================Postpaid recharge===================== */
	@Test(priority=2)
	public void TC_02() throws Exception
	{
		Thread.sleep(2000);
		initialization();
		
		System.out.println("=====second Initialization method called=====");
		
		mobilerechargepaypage.selectPrepaidOrPostpaidService("Postpaid");
		
		mobilerechargepaypage.selectOperator("Airtel");
		System.out.println("=====operator has been selected=====");
		
		mobilerechargepaypage.selectViewPlan();
		System.out.println("======plans displayed=====");
		
		mobilerechargepaypage.clickOnPayButton();
		System.out.println("======clicked on pay button=====");
		
		iappage.clickOnApproveBtn();
		Thread.sleep(5000);
		
		paymentpage.enterPasswordAndClickOnSubmit();
		
        Thread.sleep(5000);
		
		Testutil.takeScreenShot();
		
		homepage.clickOnLogoutLink();
		
		Thread.sleep(5000);
		
	}
	
	
	/*==========================Postpaid recharge===================== */
	@Test(priority=3)
	public void TC_03() throws Exception
	{
		Thread.sleep(2000);
		initialization();
		
		System.out.println("=====third Initialization method called=====");
		
        mobilerechargepaypage.selectPrepaidOrPostpaidService("Postpaid");
		
		mobilerechargepaypage.selectOperator("Tata Docomo");
		System.out.println("=====operator has been selected=====");
		
		mobilerechargepaypage.selectViewPlan();
		
		System.out.println("======plans displayed=====");
		
		mobilerechargepaypage.clickOnPayButton();
		System.out.println("======clicked on pay button=====");
		
		iappage.clickOnApproveBtn();
		Thread.sleep(5000);
		
		paymentpage.enterPasswordAndClickOnSubmit();
		
		
	}

	
	
/*	@AfterTest
	public void close() throws Exception
	{
		//Thread.sleep(000);
		driver.close();
	}
	*/

}
