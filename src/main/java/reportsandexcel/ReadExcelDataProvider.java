package reportsandexcel;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelDataProvider {
	
	public Object[][] readExcel(String fileName) throws IOException {
		
		//Open the excel
		XSSFWorkbook wrkBook = new XSSFWorkbook("./Excel data/"+fileName+".xlsx");
		
		//open the sheet
//		XSSFSheet sheet = wrkBook.getSheet("Sheet1");
		XSSFSheet sheet = wrkBook.getSheetAt(0);
		
		//Find the total row
		int lastRowNum = sheet.getLastRowNum();
				
		//Find the last cell value
		int lastCellNum = sheet.getRow(0).getLastCellNum();
		System.out.println(lastCellNum);
		
		//Creating 2d object for data providers
		Object[][] data = new Object[lastRowNum][lastCellNum];
		
		//Read the cell value
		for(int i=1;i<=lastRowNum;i++)
		{
			XSSFRow row = sheet.getRow(i);
			for(int j=0;j<lastCellNum;j++)
			{
				try {
					XSSFCell cell = row.getCell(j);
					data[i-1][j]=cell.getStringCellValue();
				} catch (NullPointerException e) {

					data[i-1][j]="";
					
				}
			}
		}
		wrkBook.close();
		return data;
		
	}

}
