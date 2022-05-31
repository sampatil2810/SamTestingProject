package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class utility 
{


	public static void capturescreenshot (WebDriver driver, String screenshotName) throws IOException
	{
		
		    TakesScreenshot ts=(TakesScreenshot)driver;

			File source=ts.getScreenshotAs(OutputType.FILE);
			
			Calendar cal =Calendar.getInstance();
			
			Date time= cal.getTime();
			
			
			SimpleDateFormat ac =new SimpleDateFormat("dd_MM_YYYY_hh mm ss");
				
			String timestamp = ac.format(cal.getTime());
				
			File destination = new File("test-output\\Screenshot\\image"+"-" +screenshotName+"-"+timestamp+".png");	

		 	FileHandler.copy(source, destination);
		
		

		
	}
	public static String getDataFromExcelsheet(String sheetname,int row,int coloum) throws EncryptedDocumentException, IOException 
	{
		
		String data = null ;
		
		 
		String path = "C:\\Users\\ASUS\\Desktop\\Sheet123.xlsx";
		 
		FileInputStream file= new FileInputStream(path);
		 
		Workbook book = WorkbookFactory.create(file);
		
		try
		{
			data = book.getSheet(sheetname).getRow(row).getCell(coloum).getStringCellValue();
		}
		catch (IllegalStateException e)
		{
			double value = book.getSheet(sheetname).getRow(row).getCell(coloum).getNumericCellValue();
			data = Double.toString(value);
		}
		return data;
		
		
		 
	}
	
}
	
	
		
		


