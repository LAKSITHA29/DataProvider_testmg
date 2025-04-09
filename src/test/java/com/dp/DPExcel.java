package com.dp;
//
//import org.testng.annotations.DataProvider;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import java.io.FileInputStream;
//import java.io.IOException;
//
//public class DPExcel {
//
//    @DataProvider(name = "excelData",parallel=true)
//    public Object[][] excelDataProvider() throws IOException {
//        return getExcelData("C:\\Users\\ADMIN\\Documents\\testng_selenium.xlsx", "Sheet1");
//    }
//    
//// Method to read Excel data
//public String[][] getExcelData(String fileName, String sheetName) throws IOException {
//    String[][] data = null;
//    try (FileInputStream fis = new FileInputStream(fileName);
//         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//        
//        XSSFSheet sheet = workbook.getSheet(sheetName);
//        int noOfRows = sheet.getPhysicalNumberOfRows();
//        int noOfCols = sheet.getRow(0).getLastCellNum();
//        
//        data = new String[noOfRows-1][noOfCols];
//
//        for (int i = 0; i <noOfRows; i++) {
//            XSSFRow row = sheet.getRow(i);
//            for (int j = 0; j <noOfCols; j++) {
//                Cell cell = row.getCell(j);
//                   data[i-1][j] = cell.getStringCellValue(); 
//                  //data[i-1][j] = (cell == null) ? "" : cell.getStringCellValue();
//
//                } 
//            }
//        }
//     catch (Exception e) {
//        System.out.println("The exception is: " + e.getMessage());
//    }
//    return data;
//}
//}
//package DataProviders;
//
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;




public class DPExcel {
	@DataProvider(name="excelData",parallel=true)
	public Object[][] excelDataprovider() throws IOException
	{
		Object[][] arrobj=getExcelData("C:\\Users\\ADMIN\\Documents\\testng_selenium.xlsx", "Sheet1");
		return arrobj;
		
	}
	public String[][] getExcelData(String filename,String Sheetname) throws IOException
	{
		String[][] data= null;
		try
		{
			FileInputStream fis=new FileInputStream(filename);
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			XSSFSheet sheet=workbook.getSheet(Sheetname);
			XSSFRow row= sheet.getRow(0);
			int noOfRows=sheet.getPhysicalNumberOfRows();
			int noOfCols=row.getLastCellNum();
			XSSFCell cell;
			data=new String[noOfRows-1][noOfCols];
			for(int i=1;i<noOfRows;i++)
			{
				for(int j=0;j<noOfCols;j++)
				{
					row=sheet.getRow(i);
					cell=row.getCell(j);
					data[i-1][j]=cell.getStringCellValue();
				}
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println("the exception is :"+e.getMessage());
		}
		return data;
	}
}