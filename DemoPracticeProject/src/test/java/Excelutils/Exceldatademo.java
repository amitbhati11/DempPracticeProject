package Excelutils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldatademo {
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	
	public Exceldatademo(String xlpath,String sheetname) throws Exception {
		workbook=new XSSFWorkbook(xlpath);
		sheet=workbook.getSheet(sheetname);
		
		
	}
	
	public int getrowcount() {
		int rowcount=sheet.getPhysicalNumberOfRows();
		
		return rowcount;
	}
	
	public int getcellcount() {
		int cellcount=sheet.getRow(0).getPhysicalNumberOfCells();
		return cellcount;
	}
	
	public String getcellstringdata(int rownum,int colnum) {
		
		DataFormatter format=new DataFormatter();
	String value=	format.formatCellValue(sheet.getRow(rownum).getCell(colnum));
		
		return value;
	}

}
