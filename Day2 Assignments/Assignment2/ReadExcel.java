package week5.serviceassign;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] readExcel(String setFileName) throws IOException {
		
		XSSFWorkbook wb = new XSSFWorkbook("./incidentdata/"+setFileName+".xlsx");
		
		XSSFSheet ws = wb.getSheetAt(0);
		
		int rowCount = ws.getLastRowNum();
		
		int columnCount = ws.getRow(0).getLastCellNum();
		
		String [][] incidentdata = new String [rowCount][columnCount];
		
		for(int i=1; i<=rowCount; i++) {
			
			for(int j=0; j<columnCount;j++) {
				
				XSSFRow row = ws.getRow(i);
				
				XSSFCell cell = row.getCell(j);
				
				String cellValues = cell.getStringCellValue();
				
				incidentdata[i-1][j]= cellValues;
				
				System.out.println(cellValues);
				
			}	
		}
	
		wb.close();
		return incidentdata;
		
		
	}

	
	}
	

