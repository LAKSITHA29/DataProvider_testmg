package com.tests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DPExcel {
    @DataProvider(name = "excelData")
    public Object[][] excelDataProvider() throws IOException {
        Object[][] arrobj = getExcelData("C:\\Users\\ADMIN\\workspace-db-mvn\\com.dp\\src\\test\\resources\\testng_webshop.xlsx", "Sheet1");
        return arrobj;
    }

    public Object[][] getExcelData(String fileName, String sheetName) throws IOException {
        Object[][] data = null;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            XSSFRow row = sheet.getRow(0);
            int noOfRows = sheet.getPhysicalNumberOfRows();
            int noOfCols = row.getLastCellNum();
            XSSFCell cell;
            data = new Object[noOfRows][noOfCols];
            for (int i = 0; i < noOfRows; i++) {
                for (int j = 0; j < noOfCols; j++) {
                    row = sheet.getRow(i);
                    cell = row.getCell(j);
                    if (cell != null) {
                        switch (cell.getCellType()) {
                            case STRING:
                                data[i][j] = cell.getStringCellValue();
                                break;
                            case NUMERIC:
                                data[i][j] = String.valueOf(cell.getNumericCellValue());
                                break;
                            default:
                                data[i][j] = "";
                        }
                    } else {
                        data[i][j] = "";
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("The exception is: " + e.getMessage());
        }
        return data;
    }
}