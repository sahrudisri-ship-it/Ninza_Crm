package Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import propertyUtility.ExcelFileUtility;

public class MultiplerecordExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream file= new FileInputStream("C:\\Users\\Hp\\Documents\\CamapignTestcase1.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		
		ExcelFileUtility efu=new ExcelFileUtility();
		int rowcount = efu.getRowCount("Mobile");
		
				for(int row=0;row<=rowcount;row++)
				{
				String Mobile =efu.readDataFromExcel("Mobile", row, 0);
				System.out.println(Mobile);
				}
		wb.close();
	}
	}


