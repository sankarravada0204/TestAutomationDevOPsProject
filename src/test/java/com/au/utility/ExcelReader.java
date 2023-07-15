package com.au.utility;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	/*
	 * file
	 * workbook
	 * sheet
	 * 
	 */
	
	static String filepath = "C://Users//ravada-sankar//OneDrive//Desktop//TestData.xlsx";
	public static Map<String, String> GetSingleData(String fileName, String sheetName, String dataSet) {
		
	Map<String, String> testDataSet = new HashMap<String,String>();
		
 try {
	 FileInputStream file = new FileInputStream(fileName);
	 XSSFWorkbook wb = new XSSFWorkbook(file);
	 XSSFSheet sheet = wb.getSheet(sheetName);
	 Row headerRow=sheet.getRow(0);
	 int dataRowIndex = 0;
	 int noOfColumns = headerRow.getPhysicalNumberOfCells();
	 Row testDataRow = null;
	 String value;
	 
	 for(Row row:sheet) {
		 for(Cell cell:row) {
			 if(cell.getStringCellValue().equalsIgnoreCase(dataSet)) {
				 dataRowIndex = cell.getRowIndex();
				 testDataRow = sheet.getRow(dataRowIndex);
				 break;
			 }
		 }
	 }
	 
	 if(testDataRow != null) {
		 for(int cell=0; cell<noOfColumns; cell++) {
			 // header columns name
			 String colName = headerRow.getCell(cell).getStringCellValue();
			 String key = sheetName+"."+colName;
			 
			 try {
				 value = testDataRow.getCell(cell).getStringCellValue();
			 }catch(NullPointerException e) {
				 value="";
			 }
			 
			testDataSet.put(key, value) ;
		 }
	 }
	 
			 
				  
			  
		 }catch(Exception e) {
			 e.printStackTrace(); 
		 }
		return testDataSet;
			
			}

}
