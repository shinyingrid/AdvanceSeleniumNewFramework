package DataProviderConcept;

import java.awt.print.Book;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.python.antlr.PythonParser.file_input_return;
import org.python.antlr.PythonParser.return_stmt_return;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Generic_Utilities_AS.Excel_Utility;

import jnr.ffi.Struct.int16_t;

public class DataProviderFromExcel
{
	@Test(dataProvider = "dataProvider_SrcAndDestName")
	public void firstAndLastName(String src,String dest)
	{
		System.out.println("Source name is : "+src+"| Destination Name is : "+dest+"");
	}
	
	@DataProvider
	public Object[][] dataProvider_SrcAndDestName() throws Throwable
	{
		FileInputStream fes = new FileInputStream("D:\\AdvancedSelenium\\EmailData.xlsx");
		 Workbook Book = WorkbookFactory.create(fes);
		 Sheet Sheet1 = Book.getSheet("Tickets");
		 int LastRow1 = Sheet1.getLastRowNum()+1;
		 short LastCell1 = Sheet1.getRow(0).getLastCellNum();
		 
		 Object[][] obj1 = new Object[LastRow1][LastCell1];
		 
		 for(int i=0;i<LastRow1;i++)
		 {
			 for(int j=0;j<LastCell1;j++)
			 {
				 obj1[i][j]=Sheet1.getRow(i).getCell(j).getStringCellValue();
				 System.out.println(obj1[i][j]);
				 
			 }
		 }
		 
		 return obj1;
		
	}

	@DataProvider
	public Object[][] getData() throws Throwable
	{
	Excel_Utility elib=new Excel_Utility();
	Object[][] value = elib.readMultipleData("DataProvider");
	
		return value;
		
	
}



}
