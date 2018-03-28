package com.wibmo.config;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.wibmo.base.BasePage;

public class EnvironmentVariables extends BasePage{
	
	@FindBy(name="Your wallet card has sufficient balance to proceed with this request. Would you like to proceed with current card selected or change card?")
	public static WebElement insufficientWalletBalance;

}
