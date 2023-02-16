import java.io.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.*;
@SuppressWarnings("unused")
public class SearchEngine{
	
	static String itemType = "";
	String material = "";
	double price = 0.0;
	int x = 0;
	int y = 0;
	int z = 0;
	String location = "";
	String color = "";
	
	public String item(String input) {//-------------------- finds the item searched
		return "";
	}
	
	public String[] segustions() {//------------------------ returns a list of similar objects
		return null;
	}
	
	public String materials() {//--------------------------- returns materials used in an item (if provided)
		return "";
	}
	
	public int price() {//---------------------------------- returns the price of target item
		return 0;
	}
	
	public String location() {//---------------------------- finds the location of an item in the spreadsheet provided
		return "";
	}
	
	
	public String dimensions() {//-------------------------- uses spreadsheet to find and output the dimensions of an item if provided(in x,y,z format)
		return "";
	}
	
	
	public String ToString() {//---------------------------- front end / the output side
		String output = "";
		output += " price: "+price();
		return output;
	}
	
}
