import java.io.*;
import org.apache.poi.ss.*;
import org.apache.poi.xssf.usermodel.*;
import java.util.*;

public class UserSearchEngine {
	
	static String itemType = "";
	String material = "";
	double price = 0.0;
	int x = 0;
	int y = 0;
	int z = 0;
	String location = "";
	String color = "";

	/**
	 * @param args
	 */
	public static void main(String[]args) {
		GrabData SE = new GrabData();
		String[][] FD = SE.getArray();
		try{
			Scanner user = new Scanner(System.in);
    		System.out.println("Furniture Type?");
			String furniture = user.nextLine();
			furniture.toLowerCase();
			for (int i = 1; i < FD.length; i++){
				if(FD[i][0].equals(furniture)){
					System.out.println(FD[i]);
				}
			}
			//list or array thing .search for furniture
			//prints all instances in the list to the screen
			//the user can then click on links that bring them to the page of the item.
			// maybe a while loop before they type exit or sommin
		}
		catch (Exception e) {
            System.out.println("Exception thrown:\n" + e);
        }
	}
}
