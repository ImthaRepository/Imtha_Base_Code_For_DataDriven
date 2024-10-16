package Print_Excel_Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Fetch_Data_Using_Iteration {
public static void main(String[] args) throws IOException {
	String FilePath="C:\\Users\\Ram prathees\\Downloads\\ApachiPoi\\ExcelData-ApachiPOi\\ExcelFile\\fortest.xlsx";
	FileInputStream input=new FileInputStream(FilePath);
	
	XSSFWorkbook workbook=new XSSFWorkbook(input);
	XSSFSheet sheet=workbook.getSheetAt(0); 
	//XSSFSheet sheet =workbook.getSheet("Sheet1");//for sheet Name
	
	 
	Iterator<Row> iterator=sheet.iterator();
	
	while(iterator.hasNext()) {
	 	XSSFRow row=(XSSFRow) iterator.next();
		 Iterator<Cell> celliterator=row.cellIterator();
		
		 while(celliterator.hasNext()) {
			XSSFCell cell=(XSSFCell) celliterator.next();
			
			switch (cell.getCellType())
			{
			case STRING: System.out.print(cell.getStringCellValue());break;
			case NUMERIC: System.out.print(cell.getNumericCellValue());break;
			case BOOLEAN: System.out.print(cell.getBooleanCellValue());break;
			}
		System.out.print(" | ");	
		}
		System.out.println();
		}
	}
}

