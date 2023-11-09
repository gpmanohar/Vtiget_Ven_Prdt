package Basic_Scenarios;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ReadDataFromExcelFile {

	public static void main(String[] args) throws Throwable {
		// Step1 Open the document in java readable format 
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		
		// step2 create a workbook 
		Workbook book = WorkbookFactory.create(fis);
		
		// step3 Navigate to required sheet 
		Sheet sh = book.getSheet("organization");
		
		//Step 4 From sheet Navigate to required row 
		Row rw = sh.getRow(1);
		
		// step 5 from row navigate to required cell 
		Cell cel = rw.getCell(2);
		//Step 6 capture the data in the cell 
		String value = cel.getStringCellValue();
		System.out.println(value);

	}

}
