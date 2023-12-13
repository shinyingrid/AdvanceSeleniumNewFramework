package DataProviderConcept;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataProviderPractice {

	public static void main(String[] args) throws Throwable, Throwable
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
	}

	}

