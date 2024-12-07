/**
 * @author Ferdinand Yeke
 *
 *CS-30-1 Database Management Systems
 *Bellarmine University
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

/*
 * Well, as you can tell here, this is a main class that actually runs the
 * Stored_Procedures_STELL_V2 Class, where it connects to the actual STELL SHIPPING
 * Database where it uses all 11 methods from the class that are for adding customers,
 * deleting customers, adding fees, transactions, container ships, and more while also
 * updating the information.
 */
public class STELL_SHIPPING_application {

/*
	public static Connection getMySqlConnection() throws Exception {
	    String driver = "com.mysql.cj.jdbc.Driver";
	    String url = "jbdc:mysql://localhost:3306/STELL_SHIPPING";
	    String username = "root";
	    String password = "kokou133321";

	    Class.forName(driver);
	    Connection conn = DriverManager.getConnection(url, username, password);
	    return conn;
	  }
*/
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		Stored_Procedures_STELL_V2 stell = new Stored_Procedures_STELL_V2();
		Scanner scan = new Scanner(System.in);
		
		/*
		 * DATABASE MUST BE CALLED HERE
		 */
		String driver ="com.mysql.cj.jdbc.Driver";
	    String url = "jdbc:mysql://localhost:3306/stell_shipping";
	    String username = "root";
	    String password = "kokou133321";

	    
	    
	    try 
	    {
	    	Class.forName(driver);
		    Connection conn = DriverManager.getConnection(url, username, password);
		    System.out.println("Successful Connection!");
	    }
	    
	    catch(SQLException e)
	    {
	    	System.out.println(e);
	    }
		
		System.out.println("Welcome to the Stell Shipping Database! Press C to continue: ");
		String c = scan.next();
		
		
		
		/*
		 * Here, there is the continuous while loop, while the user input is not equal to N, basically its body will first 
		 * contain a message about which operation to do in the database, like adding, removing, updating, and joining a table.
		 * There will also be a case (switch case will come after the choice) 4 for each choice based on a numerical input.
		 * 
		 */
		String input = "";
		while(input!="N")
		{
			System.out.println("Operation 1: Adding a Customer(1)\nOperation 2: Adding a Container Ship(2)\nOperation 3: Adding"
					+ "a fee(3).\nOperation 4: Adding a Transaction(4)\nOperation 5: Updating a Customer info(5)\nOperation 6: "
					+ "Updating a Container Ship info(6)\nOperation 7: Deleting a Customer(7)\nOperation 8: Deleting a Container Ship(8)\n"
					+ "Operation 9: Deleting a Transaction(9)\nOperation 10: Deleting a fee(10)"+"\nOperation 11: Join customer and ship(11). "
							+ "\nOperation 12: Exit(12)");
			System.out.println("Select which operation to use.");
			int num_Input = scan.nextInt();
			
			switch(num_Input)
			{
				case(1):
					{
					/*
					 * First operation calls the addCustomer method.
					 */
						stell.addCustomer();
					}break;
				
				case(2):
					{
					/*
					 * Second operation calls the add container method.
					 */
						stell.addContainer_Ship();
					}break;
				
				case(3):
					{
					/*
					 * Third operation calls the addFee method.
					 */
						stell.addFee();
					}break;
				
				case(4):
					{
					/*
					 * Forth operations calls the add transaction method.
					 */
						stell.addTransaction();
					}break;
				
				case(5):
					{
					/*
					 * Fifth operation calls the update customer info method.
					 */
						stell.updateCustomer();
					}break;
				
				case(6):
					{
					/*
					 * Sixth operation calls the update ship info method.
					 */
						stell.updateShip();
					}break;
				
				case(7):
					{
					/*
					 * Seventh operation calls the delete customer method.
					 */
						stell.delCustomer();
					}break;
				
				case(8):
					{
					/*
					 * Eighth operation calls the delete container ship method.
					 */
						stell.delContainer_SHIP();
					}break;
				
				case(9):
					{
					/*
					 * Ninth operation calls the delete transaction method.
					 */
						stell.delTransaction();
					}break;
				
				case(10):
					{
					/*
					 * Tenth operation calls the delete fee method.
					 */
						stell.delFee();
					}break;
				
				case(11):
					{
						stell.joinCustomerSHIP();
					}break;
				
				case(12):
					{
						System.exit(0);
					}
				
				default:
					{
						System.out.println("Invalid input!");
					}
			}
			
			/*
			 * After the switch statement, there will be a condition statement if they want to do more operations, with Y being yes, and N being no. If
			 * Y, then the program goes back to the start of the while loop.
			 */
			
			System.out.print("Continue using this service? (Y for yes, N for no.)");
			input = scan.next();
			
			if(input.equalsIgnoreCase("Y"))
				{
					continue;
				}
			
			else if(input.equalsIgnoreCase("N"))
				{
					break;
				}
			
			else
				{
					System.out.println("Please enter Y or N: ");
					continue;
				}
		}//While Loop ends here.
	}//Main method ends here.
}//Class ends here!
