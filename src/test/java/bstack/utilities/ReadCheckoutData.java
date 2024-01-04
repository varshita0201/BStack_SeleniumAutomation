package bstack.utilities;

import java.io.*;

import javax.swing.text.DateFormatter;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

public class ReadCheckoutData {
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRow(String xfile,String xsheet) throws IOException {
		fis=new FileInputStream(xfile);
		wb=new XSSFWorkbook(fis);
		sheet=wb.getSheet(xsheet);
		int rowcnt=sheet.getLastRowNum();
		wb.close();
		fis.close();
		return rowcnt;
	}
	
	public static int getCol(String xfile,String xhseet,int rowNum) throws IOException {
		fis=new FileInputStream(xfile);
		wb=new XSSFWorkbook(fis);
		sheet=wb.getSheet(xhseet);
		row=sheet.getRow(rowNum);
		int colNum=row.getLastCellNum();
		wb.close();
		fis.close();
		return colNum;
	}
	
	public static String cellData(String xfile,String xsheet, int rowNum, int colNum) throws IOException {
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
