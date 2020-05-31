package com.HRMS.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public static Workbook book;
	public static Sheet sheet;
	
	public static void openExcel(String filePath) {
		try {
			FileInputStream file = new FileInputStream(filePath);
			book = new XSSFWorkbook(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void getSheet(String sheetName) {
		sheet = book.getSheet(sheetName);
	}
	
	public static int rowCount() {
		int numberOfRows = sheet.getPhysicalNumberOfRows();
		return numberOfRows;
	}
	
	public static int cellCount(int cellIndex) {
		int cellCount =sheet.getRow(cellIndex).getLastCellNum();
		return cellCount;
	}
	
	public static String cellData(int rowIndex,int cellIndex) {
		String cellData = sheet.getRow(rowIndex).getCell(cellIndex).toString();
		return cellData;
	}
	
	public static Object[][] getDataFromExcel(String filePath,String sheetName){
		
		openExcel(filePath);
		getSheet(sheetName);
		
		int rowSize = rowCount();
		int cellSize = cellCount(0);
		Object [][] data = new Object[rowSize-1][cellSize];
		//iterate rows
		for(int i = 1; i < rowSize; i++) {
			//iterate cell
			for(int j = 0; j < cellSize; j++) {
				data[i-1][j] = cellData(i, j);
			}
		}
		
		return data;
		
	}
	
	
}
