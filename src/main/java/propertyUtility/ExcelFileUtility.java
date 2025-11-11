package propertyUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	
	public String readDataFromExcel (String SheetName, int rownum, int cellnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis =new FileInputStream("./src/test/resources/CamapignTestcase1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(SheetName).getRow(rownum).getCell(cellnum).getStringCellValue();
		return data;
	}
	
	public int getRowCount(String SheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis =new FileInputStream("./src/test/resources/CamapignTestcase1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int rowcount = sh.getLastRowNum();
		return  rowcount;
	}
	
	}


