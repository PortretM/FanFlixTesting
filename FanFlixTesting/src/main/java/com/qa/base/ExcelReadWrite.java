package com.qa.base;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelReadWrite {

	@DataProvider(name="data")
	public static void main (String [] args) throws IOException{
	//Path of the excel file
		String filePath = System.getProperty("user.dir") + "\\Files\\DataRead.xlsx";
	FileInputStream fs = new FileInputStream(filePath);
	//Creating a workbook
	XSSFWorkbook workbook = new XSSFWorkbook(fs);
	XSSFSheet sheet = workbook.getSheetAt(0);
	int rowcount=sheet.getPhysicalNumberOfRows();
	for(int i=0;i<rowcount;i++) {
		
		XSSFRow row = sheet.getRow(i);
		
		int intcellcount=row.getPhysicalNumberOfCells();
		for(int j=0;j<intcellcount;j++) {
			XSSFCell cell = row.getCell(j);
			String cellvalue=getCellvalue(cell);
			System.out.println("||"+cellvalue);
			
		}
		System.out.println();
	}
	workbook.close();
	fs.close();
	}
	public static String getCellvalue(XSSFCell cell) {
		switch (cell.getCellType()) {
		 case NUMERIC:
			 return String.valueOf(cell.getNumericCellValue())	;
			 
		 case BOOLEAN:
			 return String.valueOf(cell.getBooleanCellValue())	;
			 
		 case STRING:
			 return  cell.getStringCellValue()	;
		
		default:
		   return cell.getStringCellValue();
		
		
		}
	}

	
}
