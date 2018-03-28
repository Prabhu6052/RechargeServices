package com.wibmo.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wibmo.base.BasePage;
import com.wibmo.page.HomePage;
import com.wibmo.page.LoginPage;

public class HomePageTest extends BasePage{
	
	LoginPage loginpage;
    HomePage homepage;
    
    public HomePageTest() 
	{
    	  homepage=PageFactory.initElements(BasePage.driver, HomePage.class);	
	}

    @BeforeClass
    public void initialization() throws InterruptedException
    {
    	loginpage=new LoginPage(driver);
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
    	String title=homepage.verifyHomePageTitle();
    	Assert.assertEquals(title, "PayZapp Home");
    	
    //	homepage.dashBoard();
    //	System.out.println("====tapped twice on dashboard====");
    	
    	
    	homepage.clickOnRechargeIcon();
    	System.out.println("====clicked on recharge service====");
    	
    }
    
}
