package Generic_Utilities_AS;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class Excel_Utility
{
	/*
	 * This method is used to fetch data from excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param CellNum
	 * @return
	 * @throws Throwable
	 * @Author Shiny
	 */
	
	//Excel location- resources folder in NewFramework project
	
	public String getExcelData(String sheetName,int rowNum,int cellNum)throws Throwable
	{
		FileInputStream fes = new FileInputStream("./TestData.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet(sheetName);
		Row row=sheet.createRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String ExcelData = cell.getStringCellValue();
		return ExcelData;
		
	}
	
	
	public String getDataFormatterData(String sheetName,int rowNum,int cellNum)throws Throwable
	{
		FileInputStream fes = new FileInputStream("./TestData.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet(sheetName);
		Row row=sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		
		DataFormatter format = new DataFormatter();
		String ExcelData = format.formatCellValue(cell);
		return ExcelData;
		
	}
	
	
	public Object[][] readMultipleData(String SheetName) throws Throwable{
		FileInputStream fis1=new FileInputStream("D:\\AdvancedSelenium\\EmailData.xlsx");
        Workbook book=WorkbookFactory.create(fis1);

        Sheet sheet = book.getSheet(SheetName);
      int lastRow = sheet.getLastRowNum()+1;//num of rows
      int lastCell = sheet.getRow(0).getLastCellNum();

      Object[][] obj = new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				obj[i][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		return obj;
		}
	
}
