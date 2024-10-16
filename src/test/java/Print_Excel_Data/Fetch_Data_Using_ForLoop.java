package Print_Excel_Data;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Fetch_Data_Using_ForLoop {

	public static void main(String[] args) throws IOException {
		
		String FilePath="C:\\Users\\Ram prathees\\Downloads\\ApachiPoi\\ExcelData-ApachiPOi\\ExcelFile\\fortest.xlsx";
		FileInputStream input=new FileInputStream(FilePath);
		
		XSSFWorkbook workbook=new XSSFWorkbook(input);
		XSSFSheet sheet=workbook.getSheetAt(0); 
		//XSSFSheet sheet =workbook.getSheet("Sheet1");//for sheet Name
		
		int rows=sheet.getLastRowNum();//row number starts from 0
		int cols=sheet.getRow(1).getLastCellNum();//cell number starts from 1
		
		for (int i = 0; i <=rows; i++) {
			XSSFRow row=sheet.getRow(i);
			
			for (int j = 0; j <cols; j++) {
				XSSFCell cell=row.getCell(j);
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
