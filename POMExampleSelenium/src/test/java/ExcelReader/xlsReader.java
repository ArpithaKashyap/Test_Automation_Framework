package ExcelReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class xlsReader {
	
	@Test
	public void  dataReadSheet() throws IOException {
	File src=new File("D:\\Login_TestData.xlsx");
	
	FileInputStream fis=new FileInputStream(src);
	
	XSSFWorkbook xsf=new XSSFWorkbook(fis);
	
	XSSFSheet sheet=xsf.getSheetAt(0);
	
	String entry1=sheet.getRow(1).getCell(1).getStringCellValue();
	
	System.out.println("The data in the box is"+entry1);
	
	
	
//	xsf.close();
	}
	
	

}
