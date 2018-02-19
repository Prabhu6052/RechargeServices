package com.wibmo.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wibmo.base.TestBase;
import com.wibmo.page.HomePage;
import com.wibmo.page.LoginPage;

public class HomePageTest extends TestBase{
	
	LoginPage loginpage;
    HomePage homepage;
    
    public HomePageTest() 
	{
    	  homepage=PageFactory.initElements(TestBase.driver, HomePage.class);	
	}

    @BeforeClass
    public void initialization() throws InterruptedException
    {
    	loginpage=new LoginPage();
    	try {
			loginpage.login();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	homepage=loginpage.clickOnLoginBtn();
    }
    
    @Test(priority=1)
    public void tapOnDashBoard()
    {
    	homepage.dashBoard();
    	System.out.println("====tapped twice on dashboard====");
    	
    	homepage.clickOnRechargeIcon();
    	System.out.println("====clicked on recharge service====");
    	
    }
    
}
