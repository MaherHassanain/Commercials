package snc.com;

import java.io.File;  
import java.io.FileInputStream;  
import java.util.Iterator;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 
import java.util.ArrayList; 
import java.util.Scanner;

public class Main {
	
	// Has all numbers that appear on excel cells
			static ArrayList<Double> EXCELCELLS = new ArrayList<Double>();
			// has all quantities in sheet
			static ArrayList<Double> Quantity = new ArrayList<Double>();
			// has all unit prices in sheet
			static ArrayList<Double> UnitPriceinRiyals = new ArrayList<Double>();
			// will have updated total price 
			static ArrayList<Double> TotalPriceEach = new ArrayList<Double>();
			static double totalPriceForAllItems = 0;

	
	static void riyalsFunction() {
	    System.out.println("Unit price in Riyals");
				
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
	
	static void nonRiyalsFunction() {
		// put code here
	}
	
	public static void main(String[] args) {
		
			System.out.print("Program 1 started\n");
		 Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		    System.out.println("Enter Exchange rate, 0 if already in Saudi Riyals");

		    String rate = myObj.nextLine();  // Read user input
		    System.out.println("Exchange rate is: " + rate);  // Output user input
		    int cRate = Integer.parseInt(rate);
		    if(cRate == 0) {
		    	// means that its in saudi riyals
		    	riyalsFunction();
		    	
		    } else {
		    	// means it is not in Saudi riyals
		    	nonRiyalsFunction();
		    }		
	}
}
