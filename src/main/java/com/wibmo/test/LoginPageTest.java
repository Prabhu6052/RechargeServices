package com.wibmo.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.wibmo.base.TestBase;
import com.wibmo.page.HomePage;
import com.wibmo.page.LoginPage;

public class LoginPageTest extends TestBase{
	
    LoginPage loginpage;
	
    HomePage homepage;
    
    public LoginPageTest() 
	{
    	
		loginpage=PageFactory.initElements(TestBase.driver, LoginPage.class);
		
	}
    
    @Test(priority=1)
    public void enterLoginCredentials() throws Exception
    {
    	loginpage=new LoginPage();
    	loginpage.login();
    	homepage=loginpage.clickOnLoginBtn();
    	System.out.println("=====logged in=====");
    }
    
    
    
    
    
 

}
