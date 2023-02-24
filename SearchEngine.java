import java.io.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.*;
//package testFile.xlsx;

@SuppressWarnings("unused")
public class SearchEngine{
	
	String itemType = "";
	String[] data = null;
	
	@SuppressWarnings("resource")
	public static void main(String[]args) {
	 try
     {
         FileInputStream file = new FileInputStream(new File("testSheet.xlsx"));

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
              
             while (cellIterator.hasNext()) 
             {
                 Cell cell = cellIterator.next();
                 //Check the cell type and format accordingly
                 switch (cell.getCellType()) //------------------------------------------- should output the file's contents
                 {
                     case NUMERIC:
                         System.out.print(cell.getNumericCellValue() + "t");
                         break;
                     case STRING:
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
}
