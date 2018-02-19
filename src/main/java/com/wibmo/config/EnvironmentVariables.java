package com.wibmo.config;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.wibmo.base.TestBase;

public class EnvironmentVariables extends TestBase{
	
	@FindBy(name="Your wallet card has sufficient balance to proceed with this request. Would you like to proceed with current card selected or change card?")
	public static WebElement insufficientWalletBalance;

}
