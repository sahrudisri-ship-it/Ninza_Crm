package Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDatabacktoExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream file= new FileInputStream("C:\\Users\\Hp\\Documents\\CamapignTestcase1.xlsx");
		Workbook wb = WorkbookFactory.create(file);

		Sheet sh = wb.getSheet("Mobile");
		sh.getRow(1).createCell(1,CellType.STRING).setCellValue("Iphone 15");
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Hp\\Documents\\CamapignTestcase1.xlsx");
		wb.write(fos);
		wb.close();
	}

	
}
