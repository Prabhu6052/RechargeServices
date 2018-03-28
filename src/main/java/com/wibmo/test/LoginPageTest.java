package com.wibmo.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.wibmo.base.BasePage;
import com.wibmo.base.BaseTest;
import com.wibmo.page.HomePage;
import com.wibmo.page.LoginPage;


public class LoginPageTest extends BaseTest{
	
    LoginPage loginpage;
	
    HomePage homepage;
    
    public LoginPageTest() 
	{
    	
		loginpage=PageFactory.initElements(BasePage.driver, LoginPage.class);
		
	}
    
    @Test(priority=1)
    public void enterLoginCredentials() throws Exception
    {
    	loginpage=new LoginPage(driver);
    	loginpage.login();
    	homepage=loginpage.clickOnLoginBtn();
    	log.info("==========succesfully logged in============");
    }
    
    
    
    
    
    
    
    
 

}
