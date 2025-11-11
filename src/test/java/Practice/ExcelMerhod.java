package Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelMerhod {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		FileInputStream file= new FileInputStream("C:\\Users\\Hp\\Documents\\CamapignTestcase1.xlsx");
		Workbook wb = WorkbookFactory.create(file);

		String campaignname = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		System.out.println(campaignname);
	}

}
