package com.wibmo.util;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wibmo.base.TestBase;

public class Testutil extends TestBase{
	
	public static Workbook book;
	public static Sheet sheet;
	
	public static String sheetPath="C:\\Users\\prabhu.basavaraj\\workspace\\RechargeServices\\src\\main\\java\\com\\wibmo\\testdata\\operatorstestdata.xls";
	
	
	
	//screenshot method
	public static void takeScreenShot() throws IOException
	{
		
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrFile, new File("D:\\ouptputscreenshots\\screenshot.png"));
	
	}
	
	
	//scroll method
	public static WebElement scroll(WebDriver driver,String text) 
    {
               
       String scrollable="new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().textContains(\""+text+"\"))"; 

       return ((AndroidDriver)driver).findElementByAndroidUIAutomator(scrollable);
       
    }

	
	//exceldata method
	public static Object[][] getTestData(String sheetName)
	{
		FileInputStream fis=null;
		
		try {
			fis=new FileInputStream(sheetPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book=WorkbookFactory.create(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sheet=book.getSheet(sheetName);
		
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0; i<sheet.getLastRowNum();i++)
		{
			for(int j=0; j<sheet.getRow(0).getLastCellNum();j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		
	   return data;
		
	}

}
