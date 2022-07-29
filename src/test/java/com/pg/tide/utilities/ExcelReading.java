package com.pg.tide.utilities;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReading {

	
	
	public static String extractCell(int row, int col) throws IOException {
		if(row == 0 || col == 0) 
		{
			return "Row and col starts from index 1";
			
		}
		
		FileInputStream f = new FileInputStream("./resources/testdata.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook xls = new XSSFWorkbook(f);
		int sheetCount = xls.getNumberOfSheets();
		
		int sheetIndex = 0;
		while(sheetIndex<sheetCount)
		{
			if(xls.getSheetName(sheetIndex).equals("Tide Test data"))
				break;
			sheetIndex++;
		}
		
		XSSFSheet sheet = xls.getSheetAt(0);
		
		Iterator<Row> ir = sheet.rowIterator();
		
		
		Row ro = null;
		if((sheet.getLastRowNum()+1)<row)
		{
			return "Row exceeds total rows";
		}
		
		int r = 0;
		while(r!=row)
		{
			ro = ir.next();
			r++;
		}
		
		Iterator<Cell> ic = ro.cellIterator();
		Cell ce = null;
		if(col>(ro.getLastCellNum()))
		{
			return "Col exceeds total columns" ;
			
		}
		
		int c = 0;
		while(c!=col)
		{
			ce = ic.next();
			c++;
		}
		return ce.getStringCellValue();
		
		
		
	}

}
