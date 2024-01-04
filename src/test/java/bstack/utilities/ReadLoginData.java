package bstack.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadLoginData {
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public  static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRow(String xfile, String xsheet) throws IOException {
		fis=new FileInputStream(xfile);
		wb=new XSSFWorkbook(fis);
		sheet=wb.getSheet(xsheet);
		int rowcnt=sheet.getLastRowNum();
		wb.close();
		fis.close();
		return rowcnt;	
	}
	
	public static int getCol(String xfile,String xsheet,int rowNum) throws IOException {
		fis=new FileInputStream(xfile);
		wb=new XSSFWorkbook(fis);
		sheet=wb.getSheet(xsheet);
		row=sheet.getRow(rowNum);
		int colCnt=row.getLastCellNum();
		wb.close();
		fis.close();
		return colCnt;
	}
	
	public static String cellData(String xfile,String xsheet,int rowNum,int colNum) throws IOException {
		fis=new FileInputStream(xfile);
		wb=new XSSFWorkbook(fis);
		sheet=wb.getSheet(xsheet);
		row=sheet.getRow(rowNum);
		cell=row.getCell(colNum);
		String data;
		try {
			DataFormatter f=new DataFormatter();
			String cellData=f.formatCellValue(cell);
			return cellData;
		}catch(Exception e) {
			data="No data entered";
		}
		wb.close();
		fis.close();
		return data;
	}
}
