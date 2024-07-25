package test;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

import base.BaseClass;

public class TestData extends BaseClass {

public static Object[][] SignIndatas() throws IOException {
		
		Object[][] data = new Object[readValueFromExcel("Sheet1").getPhysicalNumberOfRows()-1][readValueFromExcel("Sheet1").getRow(0).getPhysicalNumberOfCells()];
		for (int i = 1; i < readValueFromExcel("Sheet1").getPhysicalNumberOfRows(); i++) {	
			XSSFRow row = readValueFromExcel("Sheet1").getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				XSSFCell cell = row.getCell(j);
				data[i-1][j] = cell.toString();
			} }

		return data;
}
}
