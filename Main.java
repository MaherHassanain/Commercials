package snc.com;

import java.io.File;  
import java.io.FileInputStream;  
import java.util.Iterator;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 
import java.util.ArrayList; 

public class Main {
	public static void main(String[] args) {
		//	System.out.print("Program 1");
		int counter = 0;
		// Has all numbers that appear on excel cells
		ArrayList<Double> EXCELCELLS = new ArrayList<Double>();
		// has all quantities in sheet
		ArrayList<Double> Quantity = new ArrayList<Double>();
		// has all unit prices in sheet
		ArrayList<Double> UnitPriceinRiyals = new ArrayList<Double>();
		// will have updated total price 
		ArrayList<Double> TotalPriceEach = new ArrayList<Double>();
		double totalPriceForAllItems = 0;
		try {
			File file = new File("./src/snc/com/sample.xlsx");
			FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file  
			//creating Workbook instance that refers to .xlsx file  
			XSSFWorkbook wb = new XSSFWorkbook(fis);   
			XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
			Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
			while(itr.hasNext()) {
				Row row = itr.next();  
				Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
				while(cellIterator.hasNext()) {
					Cell cell = cellIterator.next();  
					switch (cell.getCellType()) {						
					case STRING: {
						// do something
//						System.out.print(cell.getStringCellValue() + "\t\t\t");
						break;
					}
					case NUMERIC: {
						// do something else
//						System.out.print(cell.getNumericCellValue() + "\t\t\t");
						EXCELCELLS.add(cell.getNumericCellValue());
						break;
					}
					default: {
						// do nothing
					}	
//					System.out.println(""); 
				}
			}
		}	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(int num = 0; num < EXCELCELLS.size(); num++) {
			num++;
			Quantity.add(EXCELCELLS.get(num));
			num++;
			UnitPriceinRiyals.add(EXCELCELLS.get(num));
			num++;
		}
		
		for(int i = 0; i < Quantity.size(); i++) {
			double temp = 0;
			temp = Quantity.get(i)*UnitPriceinRiyals.get(i);
			TotalPriceEach.add(temp);
		}
		
		for (int j = 0; j < TotalPriceEach.size(); j++) {
			totalPriceForAllItems = totalPriceForAllItems + TotalPriceEach.get(j);
		}
		
//		System.out.println(Quantity.get(0));
//		System.out.println(UnitPriceinRiyals.get(0));
//		System.out.println(Quantity.get(1));
//		System.out.println(UnitPriceinRiyals.get(1));
//		System.out.println(TotalPriceEach.get(0));
//		System.out.println(TotalPriceEach.get(1));
//		System.out.println(TotalPriceEach.get(16));
		System.out.println(totalPriceForAllItems);
		
	}
}
