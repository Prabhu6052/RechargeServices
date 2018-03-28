package com.wibmo.util;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.collect.Table.Cell;
import com.wibmo.base.BasePage;

public class Testutil extends BasePage{
	
	public static Workbook book;
	public static Sheet sheet;
	public static WebElement element1;
	
	public static String sheetPath="C:\\Users\\prabhu.basavaraj\\workspace\\RechargeServices\\src\\main\\java\\com\\wibmo\\testdata\\operatorstestdata.xls";
	
	
	
	/*===========================screenshot method======================================*/
	public static void takeScreenShot() throws IOException
	{
		
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrFile, new File("D:\\ouptputscreenshots\\screenshot.png"));
	
	}
	
	
	/*===========================scroll method======================================*/
	public static WebElement scroll(WebDriver driver,String text) 
    {
               
       String scrollable="new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().textContains(\""+text+"\"))"; 

       return ((AndroidDriver)driver).findElementByAndroidUIAutomator(scrollable);
       
    }
	
	
	
	//Fluent Wait
	
	
	
	/*===========================exceldata method======================================*/
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
	
	
	/*===========================exceldata method======================================*/
	public static void getTestDataFromExcel(String sheetName)
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
			
			e.printStackTrace();
		}
		
		sheet=book.getSheet(sheetName);
		
		String firstRow_1stCol=sheet.getRow(1).getCell(0).getStringCellValue(); //row and col
		System.out.print("1stRow_1stCol="+firstRow_1stCol +"\t" +"\t");
		
		String secondRow_1stCol=sheet.getRow(2).getCell(0).getStringCellValue();  //row and col
		System.out.println("2ndRow_1stCol="+secondRow_1stCol);
		

		String thirdRow_1stCol=sheet.getRow(3).getCell(0).getStringCellValue(); //row and col
		System.out.print("3rdRow_1stCol="+thirdRow_1stCol+"\t" +"\t");
		
	
	}
	
	
	
	/*======================         ============================*/
	public static String getExcelData(String filePath, String sheetName, int rowNo, int cellNo)
	{
		try
		{
			File f = new File(filePath);
			FileInputStream fileInput = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fileInput);
			Sheet st = wb.getSheet(sheetName);			
			Row r = st.getRow(rowNo); 			
			
			if(r==null)
			{
				//System.out.println("Row "+rowNo+" detected as null"); xl Diagnostic
				return " ";
			}		
			
			Cell c = r.getCell(cellNo,Row.RETURN_NULL_AND_BLANK); // Prevent NullPointerException 
			
			if(c==null)
			{
				//System.out.println("Cell "+rowNo+" detected as null"); // XL Diagnostic
				return " ";
			}
			
			String data = c.getStringCellValue();
			return data;
			
		}
		catch(Exception e)
		{
			//e.printStackTrace(); // XL Diagnostic
			return " ";
		}
	}
	
		/**
		 * Writes excel data.
		 *
		 * @param filePath the file path
		 * @param sheetName the sheet name
		 * @param rowNo the row no
		 * @param cellNo the cell no
		 * @param data the data
		 */
		public static void writeExcelData(String filePath, String sheetName, int rowNo, int cellNo, String data)
		{
			try
			{
				FileInputStream fileInput = new FileInputStream(filePath);
				Workbook wb = WorkbookFactory.create(fileInput);
				
				//---------------------------Re evaluate formulas for all sheets ------------------------------------------//
				wb.getCreationHelper().createFormulaEvaluator().evaluateAll();
				wb.setForceFormulaRecalculation(true);
				//---------------------------------------------------------------------------------------------------------//
				
				//wb.createSheet();
				Sheet st = wb.getSheet(sheetName);
				Row r = st.getRow(rowNo);
				if (r == null)
			        r = st.createRow(rowNo);
				Cell c = r.createCell(cellNo);
				if (c == null)
			        c = r.createCell(cellNo);
				c.setCellType(Cell.CELL_TYPE_STRING);
				c.setCellValue(data);
				FileOutputStream fileOut = new FileOutputStream(filePath);
				wb.write(fileOut);	
				fileOut.close();
			}
			catch(Exception e)
			{
				
			}
			
	}
		
		/**
		 * Gets the excel row count.
		 *
		 * @param filePath the file path
		 * @param sheetName the sheet name
		 * @return the excel row count
		 */
		public static int getExcelRowCount(String filePath, String sheetName)
		{
			int rowNo = 0;
			try
			{
				FileInputStream fileInput = new FileInputStream(filePath);
				Workbook wb = WorkbookFactory.create(fileInput);
				Sheet st = wb.getSheet(sheetName);
				rowNo = st.getLastRowNum();
				
			}
			catch(Exception e)
			{
				
			}
			return rowNo;
	}
		
		/**
		 * Gets the excel cell count.
		 *
		 * @param filePath the file path
		 * @param sheetName the sheet name
		 * @param rowNo the row no
		 * @return the excel cell count
		 */
		public static int getExcelCellCount(String filePath, String sheetName, int rowNo)
		{
			try
			{
				FileInputStream fileInput = new FileInputStream(filePath);
				Workbook wb = WorkbookFactory.create(fileInput);
				Sheet st = wb.getSheet(sheetName);
				Row r = st.getRow(rowNo);
				return r.getLastCellNum();
			}
			catch(Exception e)
			{
				return -1;
			}
	}
		
		
		/**
		 * Hides the Keyboard if the Keyboard is displayed.
		 *
		 * @param driver the driver
		 */
		public static void hideKeyBoard(WebDriver driver)
		{
			if(checkWebView(driver)) return;
			try
			{
				((AndroidDriver)driver).hideKeyboard();			
			}
			catch (Exception e){com.libraries.Log.info("== Hide Keyboard Delay ==");}
		}




}
