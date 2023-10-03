package utils;
import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.FileConstants;

public class ExcelUtils {
	
	public void readExcelFile(String filePath,int row , int col) {
		
	}

	

	public static String[] readLoginTestData(int row) throws InvalidFormatException, IOException {
		
		XSSFWorkbook loginWorkBook = new XSSFWorkbook(new File(FileConstants.LOGIN_TESTDATA_FILE_PATH));
		XSSFSheet logincreds = loginWorkBook.getSheet("UserCredentials");
		XSSFRow rows = logincreds.getRow(row);
		String[] creds = new String[rows.getLastCellNum()];
		for(int ro = row; ro <= rows.getLastCellNum(); ro++) {
			creds[ro] = rows.getCell(ro+1).getStringCellValue();
		}
		
		return creds;
		
		
		
		
	}

}
