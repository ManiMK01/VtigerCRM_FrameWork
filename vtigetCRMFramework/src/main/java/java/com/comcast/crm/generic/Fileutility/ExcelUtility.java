package java.com.comcast.crm.generic.Fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	/**
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("./testdata/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).toString();
		wb.close();
		return data;
	}
	
	/**
	 * 
	 * @param sheetName
	 * @return int
	 * @throws Throwable
	 */
	
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream("./testdata/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowCount;
		
	}
	
	/**
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws Throwable
	 * @throws IOException
	 */
	public void setDataIntoExcel(String sheetName, int rowNum, int cellNum, String data) throws Throwable, IOException {
		FileInputStream fis = new FileInputStream("./testdata/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		//wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./testdata/TestScriptData.xlsx");
		wb.write(fos);
		wb.close();
	}
}
