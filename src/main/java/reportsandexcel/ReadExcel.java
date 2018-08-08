package reportsandexcel;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel {
	
	@Test
	public void readExcel() throws IOException {
		
		//Open the excel
		XSSFWorkbook wrkBook = new XSSFWorkbook("./Excel data/data.xlsx");
		
		//open the sheet
		XSSFSheet sheet = wrkBook.getSheet("Sheet1");
		
		//Find the total row
		int lastRowNum = sheet.getLastRowNum();
				
		//Find the last cell value
		int lastCellNum = sheet.getRow(0).getLastCellNum();
		System.out.println(lastCellNum);
		
		//Read the cell value
		for(int i=1;i<=lastRowNum;i++)
		{
			XSSFRow row = sheet.getRow(i);
			for(int j=0;j<lastCellNum;j++)
			{
				XSSFCell cell = row.getCell(j);
				String stringCellValue = cell.getStringCellValue();
				
//				if(stringCellValue.eq) {
//					System.out.println(" no value in cell"+i+","+j);
//				}else
//				{
//				System.out.println(stringCellValue);
//				}
			}
		}
		wrkBook.close();
		
	}

}
