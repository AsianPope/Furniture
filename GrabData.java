import java.io.*;
import org.apache.poi.ss.*;
import org.apache.poi.xssf.usermodel.*;
import java.util.*;	
	@SuppressWarnings({ "resource", "unused" })
	public class GrabData{
		
		//public String itemType = "";
		//public static String[] data = null;
	    public String[][] furnatureData = null;
		
	    GrabData(){
	        try
	     {
			 File book = new File("FurnitureProjectSheet.xlsx");
	         FileInputStream file = new FileInputStream(book);
	         
	         //Create Workbook instance holding reference to .xlsx file
	         XSSFWorkbook workbook = new XSSFWorkbook(file);
	         
	         //Get first/desired sheet from the workbook
	         XSSFSheet sheet = workbook.getSheetAt(0);
	         
	         //Iterate through each rows one by one
	         Iterator<Row> rowIterator = sheet.iterator();
	         while (rowIterator.hasNext())
	         {
	             Row row = rowIterator.next();
	             //For each row, iterate through all the columns
	             Iterator<Cell> cellIterator = row.cellIterator();
	              int a = 0;int b = 0;
	             while (cellIterator.hasNext())
	             {
	                 Cell cell = cellIterator.next();
	                 //Check the cell type and format accordingly
	                 switch (cell.getCellType()) //------------------------------------------- should output the file's contents
	                 {
	                     case NUMERIC:
	                    	 b++;
	                    	 furnatureData[a][b] = Double.toString(cell.getNumericCellValue()); 
	                         System.out.print(cell.getNumericCellValue() + "t");
	                         break;
	                     case STRING:
	                    	 a++;
	                    	 b = 0;
	                    	 furnatureData[a][b] = cell.getStringCellValue();
	                         System.out.print(cell.getStringCellValue() + "t");
	                         break;
	                     default:
	                    	 System.out.println("incorrect data type");
	                    	 break;
	                 }
	             }
	             System.out.println("");
	         }
	         file.close();
	     }
	     catch (Exception e)
	     {
	         e.printStackTrace();
	     }
	    }

	    public String[][] getArray(){
	        return furnatureData;
	    }

		@SuppressWarnings("resource")
		public static void main(String[]args) {
	    }
	}