package dataprovider;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public static String getreaddata(int rownum, int colnum, int sheetnum) 
	{
		String value="";
		String path="C:\\Users\\Jimmy\\eclipse-workspace\\TestingBabaProject\\src\\test\\resources\\TestData\\testdataa.xlsx";
		try 
		{
			FileInputStream fis=new FileInputStream(path);
			XSSFWorkbook wb= new XSSFWorkbook(fis);
			XSSFSheet sheet= wb.getSheetAt(sheetnum);
			
			value=sheet.getRow(rownum).getCell(colnum).getStringCellValue();			
			
		} catch (Exception e) 
		{
         System.out.println("Error in Data Fetching"+e);
		}
		return value;
	}
}
