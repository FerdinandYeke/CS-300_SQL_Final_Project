/**
 * @author Ferdinand Yeke
 *
 *CS-30-1 Database Management Systems
 *Bellarmine University
 */
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import java.io.*;
public class Stored_Procedures_STELL_V2 {
	/*
	 * 
	 * This a class that makes stored procedures for the STELL_SHIPPING database to add, delete, and update the customer and the 
	 * database information.
	 */
	
	/*Updated on: 12.5.2024 to 12.6.2024
	 * This a newer version of a previous class Stored_Procedures_STELL
	 * that sets up a cleaner SQL database import with a new method.
	
	/*
	 * Another unique idea is once the user is done entering the information that they need, that they can save the information to a file.
	 * But for now, let's focus on the actual, simple operations.
	 * EDIT 12.6.2024 This is technically done with the database.
	 */
	
	/*
	 * After all the methods of adding, deleting, and updating the
	 * info of whatever, there will be a main class where the methods
	 * get called for the user operations of adding, deleting, and updating
	 * the database.
	 */
	
	/*
	 * This is a method that adds a customer.
	 */
	//Connection con= null;
	Scanner scan = new Scanner(System.in);
private	String TID;
private	String newShipID;
private	String newSail_Schedule;
private	int newPort_List;
private	float newDaily_Charge;
private float fee;
private float purchase;
private	String newARRIVAL;
private	String newDEPARTURE;
private String newfName;
private String newlName;
private String newCustomerID;
private String newDOB;


/*
 * Preferred constructor stored procedures stell starts here.
 */
public Stored_Procedures_STELL_V2()
{
	this.TID=null;
	this.newShipID=null;
	this.newSail_Schedule=null;
	this.newPort_List=0;
	this.newDaily_Charge=0;
	this.newARRIVAL=null;
	this.newDEPARTURE=null;
	this.newfName=null;
	this.newlName=null;
	this.newCustomerID=null;
	this.newDOB=null;
}

Connection conn= null;
public String getTID() {
	return TID;
}

public void setTID(String tID) {
	TID = tID;
}

public String getNewShipID() {
	return newShipID;
}

public void setNewShipID(String newShipID) {
	this.newShipID = newShipID;
}

public String getNewSail_Schedule() {
	return newSail_Schedule;
}

public void setNewSail_Schedule(String newSail_Schedule) {
	this.newSail_Schedule = newSail_Schedule;
}

public int getNewPort_List() {
	return newPort_List;
}

public void setNewPort_List(int newPort_List) {
	this.newPort_List = newPort_List;
}

public float getNewDaily_Charge() {
	return newDaily_Charge;
}

public void setNewDaily_Charge(float newDaily_Charge) {
	this.newDaily_Charge = newDaily_Charge;
}

public String getNewARRIVAL() {
	return newARRIVAL;
}

public void setNewARRIVAL(String newARRIVAL) {
	this.newARRIVAL = newARRIVAL;
}

public String getNewDEPARTURE() {
	return newDEPARTURE;
}

public void setNewDEPARTURE(String newDEPARTURE) {
	this.newDEPARTURE = newDEPARTURE;
}

public String getNewfName() {
	return newfName;
}

public void setNewfName(String newfName) {
	this.newfName = newfName;
}

public String getNewlName() {
	return newlName;
}

public void setNewlName(String newlName) {
	this.newlName = newlName;
}

public String getNewCustomerID() {
	return newCustomerID;
}

public void setNewCustomerID(String newCustomerID) {
	this.newCustomerID = newCustomerID;
}

public String getNewDOB() {
	return newDOB;
}

public void setNewDOB(String newDOB) {
	this.newDOB = newDOB;
}

public float getFee() {
	return fee;
}

public void setFee(float fee) {
	this.fee = fee;
}


public float getPurchase() {
	return purchase;
}

public void setPurchase(float purchase) {
	this.purchase = purchase;
}

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

public static Connection getMySqlConnection() throws Exception {
    String driver = "com.mysql.cj.jdbc.Driver";
    
    /*
     * Updated: 12.6.2024, Fixed typo of url, where it used to be "jbdc:mysql://localhost:3306/STELL_SHIPPING." when
     * it actually should be "jdbc:mysql://localhost:3306/STELL_SHIPPING" instead. (jdbc was misspelled).
     */
    String url = "jdbc:mysql://localhost:3306/STELL_SHIPPING";
    String username = "root";
    String password = "kokou133321";

    Class.forName(driver);
    Connection conn = DriverManager.getConnection(url, username, password);
    return conn;
  }

	//addCustomer method starts here.
	public void addCustomer()throws Exception
	{
		
		//Outer try block starts here.
		try {
			System.out.println("enter the customer First Name: ");
			 newfName = scan.next();
			 setNewfName(newfName);
			
			System.out.println("enter the customer Last Name: ");
			 newlName = scan.next();
			 setNewlName(newlName);
			
			System.out.println("enter the customerID");
			 newCustomerID = scan.next();
			 setNewCustomerID(newCustomerID);
			
			System.out.println("enter the customer DOB in the"
					+ " YYYY-MM-DD format, where the dashes are"
					+ " included.");
			 newDOB = scan.next();
			 setNewDOB(newDOB);
			
			/*
			 * After this method reads the user's inputs, the stored
			 * procedures (in java's version) gets started here.
			 */
			
			/*
			 * NOTE: if customer wants to be deleted, then the ship,
			 * fee, Transaction table associated with the customer must
			 * be deleted as well.
			 */

			String addCustomer_Proc= "{call addCustomer(?,?,?,?)}";
			Connection conn = getMySqlConnection();
			java.sql.CallableStatement CS= conn.prepareCall(addCustomer_Proc);
			//Inner try block starts here
			try {
			/*
			CS.setString(1,newCustomerID);
			CS.setString(2, newfName);
			CS.setString(3, newlName);
			CS.setString(4, newDOB);
			*/
				
			CS.setString(1,getNewCustomerID());
			CS.setString(2, getNewfName());
			CS.setString(3, getNewlName());
			CS.setString(4, getNewDOB());
			CS.execute();
			conn.close();
			
			//String ref_newCustomerID= this.setNewCustomerID(newCustomerID);
			//String ref_newfName= this.setNewfName(newfName);
			//String ref_newlName= this.setNewlName(newlName);
			//String ref_newDOB= this.setNewDOB(newDOB);
			
				}//Inner try block ends here
			
			//Inner catch block starts here.
			catch(SQLException e)
			{
				System.out.println("Faulty Operation!");
				System.out.println(e);
			}//Inner catch block ends here.
		}//Outer try block ends here.
		
		//Outer catch block starts here.
		catch(Exception e)
		{
			System.out.println(e);
		}//Outer catch block ends here
		
		//Outer finally block starts here.
		finally 
		{
			System.out.println("Operation complete.");
		}//Finally Block ends here.
	}//addCustomer method ends here.
	
	/*
	 * Now, the other methods like adding a ship, Transaction, Fee, they will all
	 * share pretty much the same method body as addCustomer.
	 */

	//addContainer_Ship method starts here.
	public void addContainer_Ship() throws Exception
	{
		//Outer try block starts here.
		try {
			
			System.out.println("enter the ship id: ");
			 newShipID = scan.next();
			 setNewShipID(newShipID);
			
			System.out.println("enter the sail schedule for the ship in the"
					+ " YYYY-MM-DD format, where the dashes are"
					+ " included.");
			 newSail_Schedule = scan.next();
			 setNewSail_Schedule(newSail_Schedule);
			
			System.out.println("enter the port list: ");
			 newPort_List = scan.nextInt();
			 setNewPort_List(newPort_List);
			
			System.out.println("enter the daily_charge: ");
			 newDaily_Charge = scan.nextFloat();
			 setNewDaily_Charge(newDaily_Charge);
			
			System.out.println("enter the ARRIVAL and DEPARTURE date for the ship in the"
					+ " YYYY-MM-DD format, where the dashes are"
					+ " included.");
			 newARRIVAL = scan.next();
			 newDEPARTURE = scan.next();
			 setNewARRIVAL(newARRIVAL);
			 setNewDEPARTURE(newDEPARTURE);
			
			System.out.println("enter the TID (transactionID: ");
			setTID(scan.next());
			
			
			
			/*
			 * After this method reads the user's inputs, the stored
			 * procedures (in java's version) gets started here.
			 */
			
			/*
			 * NOTE: if customer wants to be deleted, then the ship,
			 * fee, Transaction table associated with the customer must
			 * be deleted as well.
			 */
			String addContainer_Ship_Proc= "{call addShip(?,?,?,?)}";
			Connection conn = getMySqlConnection();
			java.sql.CallableStatement CS= conn.prepareCall(addContainer_Ship_Proc);
			//Inner try block starts here
			try {
			/*
			CS.setString(1,newShipID);
			CS.setString(2, newSail_Schedule);
			CS.setInt(3, newPort_List);
			CS.setFloat(4, newDaily_Charge);
			CS.setString(5,newARRIVAL);
			CS.setString(6, newDEPARTURE);
			*/
			CS.setString(1,getNewShipID());
			CS.setString(2, getNewSail_Schedule());
			CS.setInt(3, getNewPort_List());
			CS.setFloat(4, getNewDaily_Charge());
			CS.setString(5,getNewARRIVAL());
			CS.setString(6, getNewDEPARTURE());
			CS.execute();
			/*
			 * Ref variables get made here for join customerSHip method.
			 * 
			 */
			
			/*
			String ref_newShipID = this.setNewShipID(newShipID);
			String ref_newSail_Schedule= this.setNewSail_Schedule(newSail_Schedule);
			int ref_newPort_List= this.setNewPort_List(newPort_List);
			float ref_newDaily_Charge= this.setNewDaily_Charge(newDaily_Charge);
			String ref_newARRIVAL= this.setNewARRIVAL(newARRIVAL);
			String ref_newDEPARTURE= this.setNewDEPARTURE(newDEPARTURE);
			
			concatSHIP(ref_newShipID,ref_newSail_Schedule,ref_newPort_List,
					ref_newDaily_Charge,ref_newARRIVAL,ref_newDEPARTURE);
			*/
				}//Inner try block ends here
			
			//Inner catch block starts here.
			catch(SQLException e)
			{
				System.out.println("Invalid inputs!");
			}//Inner catch block ends here.
		}//Outer try block ends here.
		
		//Outer catch block starts here.
		catch(Exception e)
		{
			System.out.println(e);
		}//Outer catch block ends here
		
		//Outer finally block starts here.
		finally 
		{
			System.out.println("Operation complete.");
		}//Finally Block ends here.
	}//addContainer_Ship method ends here.
	
	//addFee method starts here.
	public void addFee() throws Exception
	{
		//Outer try block starts here.
		try {
			System.out.println("enter the fee: ");
			fee = scan.nextFloat();
			setFee(fee);
			
			System.out.println("enter the customerID (where the customer has "
					+ "the fee): ");
			String customerID = scan.next();
			
			System.out.println("enter the shipID (the same ID for the new customer: ");
			String shipID = scan.next();
			
			/*
			 * After, the CallableStatment and its respective lines, there should
			 * also be a system.out.println that also shows the fee, customerID, and
			 * the customer's shipID.
			 */
			String addFee_Proc= "{call addFee(?,?,?)}";
			
			Connection conn = getMySqlConnection();
			java.sql.CallableStatement CS= conn.prepareCall(addFee_Proc);
			//Inner try block starts here
			try {
			CS.setFloat(1,getFee());
			CS.setString(2, customerID);
			CS.setString(3, shipID);
			CS.execute();
			
			/*
			 * Prints out the fee, customerID, and ship ID in new, separate lines.
			 */
			System.out.println("Successuful operation!");
			/*
			System.out.println("fee: "+fee);
			System.out.println("Customer's ID: "+customerID);
			System.out.println("Ship ID for the Customer: "+shipID);
			*/
			System.out.println("Fee: "+fee+"\n"+"Customer's ID: "+customerID+"\n"+
			"Ship ID for the Customer: "+shipID);
				}//Inner try block ends here
			
			//Inner catch block starts here.
			catch(SQLException e)
			{
				System.out.println("Invalid inputs!");
			}//Inner catch block ends here.
		}//Outer try block ends here.
		
		//Outer catch block starts here.
		catch(Exception e)
		{
			System.out.println(e);
		}//Outer catch block ends here
		
		//Outer finally block starts here.
		finally 
		{
			System.out.println("Operation complete.");
		}//Finally Block ends here.
	}//addFee method ends here.

	//addTransaction method starts here.
	public void addTransaction() throws Exception
	{
		
		//Outer try block starts here.
		try {
			System.out.println("enter the TransactionID: ");
			 TID= scan.next();
			 setTID(TID);
			
			System.out.println("enter the purchase amount: ");
			 purchase = scan.nextFloat();
			 setPurchase(purchase);
			 

			String addTransaction_Proc= "{call addFee(?,?,?)}";
			Connection conn = getMySqlConnection();
			java.sql.CallableStatement CS= conn.prepareCall(addTransaction_Proc);
			//Inner try block starts here
			try {
			CS.setString(1,getTID());
			CS.setFloat(2, getPurchase());
			CS.execute();
				}//Inner try block ends here
			
			//Inner catch block starts here.
			catch(SQLException e)
			{
				System.out.println("Invalid inputs!");
			}//Inner catch block ends here.
		}//Outer try block ends here.
		
		//Outer catch block starts here.
		catch(Exception e)
		{
			System.out.println(e);
		}//Outer catch block ends here
		
		//Outer finally block starts here.
		finally 
		{
			System.out.println("Operation complete.");
		}//Finally Block ends here.
	}//addFee method ends here.
	
	/*
	 * Now, this is where the update methods gets made.
	 */
	
	//updateCustomer starts here.
	public void updateCustomer()throws Exception
	{
		//Outer try block starts here.
		try {
			System.out.println("change the customer First Name to new name: ");
			String Ucust_fName = scan.next();
			
			System.out.println("change the customer Last Name to new name: ");
			String Ucust_lName = scan.next();
			
			System.out.println("enter the customerID");
			String UcustomerID = scan.next();
			
			System.out.println("change the customer DOB to new DOB in the"
					+ " YYYY-MM-DD format, where the dashes are"
					+ " included.");
			String uDOB = scan.next();
			
			/*
			 * After this method reads the user's inputs, the stored
			 * procedures (in java's version) gets started here.
			 */
			
			/*
			 * NOTE: if customer wants to be deleted, then the ship,
			 * fee, Transaction table associated with the customer must
			 * be deleted as well.
			 */

			String updateCustomer_ID= "{call updateCustomer(?,?,?,?)}";
			Connection conn = getMySqlConnection();
			java.sql.CallableStatement CS= conn.prepareCall(updateCustomer_ID);
			//Inner try block starts here
			try {
			CS.setString(1,UcustomerID);
			CS.setString(2, Ucust_fName);
			CS.setString(3, Ucust_lName);
			CS.setString(4, uDOB);
			CS.executeUpdate();
			
			/*
			 * This time, it returns the parameters in a system.out.println line.
			 */
			System.out.println("Successful operation!");
			System.out.println("Changed customer name (first and last) to: "+Ucust_fName+" "
					+Ucust_lName+"\n"+"Changed customer ID to: "+UcustomerID+"\n"+"Changed customer DOB to: "+
					""+uDOB);
				}//Inner try block ends here
			
			//Inner catch block starts here.
			catch(SQLException e)
			{
				System.out.println("Invalid inputs!");
				System.out.println(e);
			}//Inner catch block ends here.
		}//Outer try block ends here.
		
		//Outer catch block starts here.
		catch(Exception e)
		{
			System.out.println(e);
		}//Outer catch block ends here
		
		//Outer finally block starts here.
		finally 
		{
			System.out.println("Operation complete.");
		}//Finally Block ends here.
	}//updateCustomer method ends here.
	
	//updateShip starts here.
	public void updateShip()throws Exception
	{
		//Outer try block starts here.
		try {
			System.out.println("change ship id to new ship id: ");
			String UshipID = scan.next();
			
			System.out.println("change the sail schedule to new schedule"
					+ " for the ship in the"
					+ " YYYY-MM-DD format, where the dashes are"
					+ " included.");
			String uSAIL_SCHEDULE = scan.next();
			
			System.out.println("change the numerical port list to new port list: ");
			int uPort_List = scan.nextInt();
			
			System.out.println("change the daily charge to new daily_charge: ");
			float uDaily_Charge = scan.nextFloat();
			
			System.out.println("change the ARRIVAL and DEPARTURE date "
					+ "to NEW ARRIVAL and DEPARTURE date for the ship in the"
					+ " YYYY-MM-DD format, where the dashes are"
					+ " included.");
			String uARRIVAL = scan.next();
			String uDEPARTURE = scan.next();
			
			/*
			 * VIOLATION! the customer's TID MUST BE THE SAME to know it is their
			 * PURCHASE/TRANSACTION!!!
			System.out.println("change  the TID (transactionID: ");
			TID = scan.next();
			*/
			
			
			/*
			 * After this method reads the user's inputs, the stored
			 * procedures (in java's version) gets started here.
			 */
			
			/*
			 * NOTE: if customer wants to be deleted, then the ship,
			 * fee, Transaction table associated with the customer must
			 * be deleted as well.
			 */

			String updateContainer_Ship_Proc= "{call addShip(?,?,?,?)}";
			Connection conn = getMySqlConnection();
			java.sql.CallableStatement CS= conn.prepareCall(updateContainer_Ship_Proc);
			//Inner try block starts here
			try {
			CS.setString(1,UshipID);
			CS.setString(2, uSAIL_SCHEDULE);
			CS.setFloat(3, uPort_List);
			CS.setFloat(4, uDaily_Charge);
			CS.setString(5,uARRIVAL);
			CS.setString(6, uDEPARTURE);
			CS.executeUpdate();
			
			/*
			 * This time, it returns the parameters in a system.out.println line.
			 */
			System.out.println("Successful operation!");
			System.out.println("Changed shipId to: "+UshipID+"\n"+"Changed sail schedule to: "+""
			+uSAIL_SCHEDULE+"\n"+"Changed port list to: "+uPort_List+"\n"+"Changed arrival to: "
					+uARRIVAL+"\n"+"Changed departure to: "+uDEPARTURE+"\n"+"Changed daily charge to: "
			+uDaily_Charge);
				}//Inner try block ends here
			
			//Inner catch block starts here.
			catch(SQLException e)
			{
				System.out.println("Invalid inputs!");
				System.out.println(e);
			}//Inner catch block ends here.
		}//Outer try block ends here.
		
		//Outer catch block starts here.
		catch(Exception e)
		{
			System.out.println(e);
		}//Outer catch block ends here
		
		//Outer finally block starts here.
		finally 
		{
			System.out.println("Operation complete.");
		}//Finally Block ends here.
	}//addContainer_Ship method ends here.
	
	//joinCustomerShip method starts here.
	
	/*
	 * joinCustomerShip starts here, where it concatenates the values
	 * from the addShip and add customer to a toString format, while
	 * firstly having all the values in the method's parameters.
	 * This could be split into two methods where one method has parameters
	 * that refer to one add method with their own respective parameters
	 * in the methods that they are called in.
	 */
	
	/*
	 * This overridden toString method returns the summarized info of both the ship and the customer, while being used in the join
	 * stored procedure.
	 */
	@Override
	public String toString()
	{
		
		return "Summarized info of customer and ship"+"\n"+"Customer Name: "+getNewfName()+" "+getNewlName()+"\n"
				+"Customer's ID: "+getNewCustomerID()+"\n"+"Customer's DOB: "+getNewDOB()+"\n"+"Ship ID: "+getNewShipID()+"\n"+
				"Sail Schedule of Ship: "+getNewSail_Schedule()+"\n"+"Port List: "+getNewPort_List()+"\n"+"Daily charge: "+
				getNewDaily_Charge()+"\n"+"Departure Date: "+getNewDEPARTURE()+"\n"+"Arrival Date: "+getNewARRIVAL();//Rest will be filled here later.
	}
	
	/*this will just have a system.out.println statement with the toString method plugged in, BUT there is also a call to the joinCustomerSHIP
	 * stored procedure.
	 */
	
	public String joinCustomerSHIP() throws Exception
	{
		//Outer try block starts here.
		/*
		 * So, the reason why the call joinCustomerSHIP has so many question marks (registered parameters), is because
		 * the PROCEDURE in the database itself, that is the joinCustomerSHIP has that much parameters for joining two tables,
		 * which are customer and ship. In total it is ten (counting it from 1 to 10.).
		 */
		try {
			
			String joinCustomerSHIP_Proc= "{call joinCustomerSHIP(?,?,?,?,?,?,?,?,?,?)}";
			Connection conn = getMySqlConnection();
			java.sql.CallableStatement CS= conn.prepareCall(joinCustomerSHIP_Proc);
			 ;
			 //Finally, it prints the tuples that have been joined.
			 /*
			  *  CS.registerOutParameter(1,Types.VARCHAR);
			 CS.registerOutParameter(2,Types.DATE, Types.TIME);
			 CS.registerOutParameter(3, Types.INTEGER);
			 CS.registerOutParameter(4,Types.FLOAT);
			 CS.registerOutParameter(5,Types.DATE, Types.TIME);
			 CS.registerOutParameter(6, Types.DATE, Types.TIME);
			 CS.registerOutParameter(7, Types.VARCHAR);
			 CS.registerOutParameter(8, Types.VARCHAR);
			 CS.registerOutParameter(9, Types.VARCHAR);
			 CS.registerOutParameter(10, Types.DATE);
			 CS.setNString(1, "ShipID");
			  System.out.print("Summarized info of customer and ship"+"\n"+"Customer Name: "+CS.getInt(8)+" "+CS.getInt(9)+"\n"
						+"Customer's ID: "+CS.getInt(7)+"\n"+"Customer's DOB: "+CS.getInt(10)+"\n"+"Ship ID: "+CS.getInt(1)+"\n"+
						"Sail Schedule of Ship: "+CS.getInt(2)+"\n"+"Port List: "+CS.getInt(3)+"\n"+"Daily charge: "+
						CS.getInt(4)+"\n"+"Departure Date: "+CS.getInt(6)+"\n"+"Arrival Date: "+CS.getInt(5));
			  */
			 
			 
				
			
				CS.setString(1,getNewShipID());
				CS.setString(2, getNewSail_Schedule());
				CS.setInt(3, getNewPort_List());
				CS.setFloat(4, getNewDaily_Charge());
				CS.setString(5,getNewARRIVAL());
				CS.setString(6, getNewDEPARTURE());
				CS.setString(7,getNewCustomerID());
				CS.setString(8, getNewfName());
				CS.setString(9, getNewlName());
				CS.setString(10, getNewDOB());
				CS.execute();
				
			 
			 CS.execute();
			 System.out.println(toString());
		}//Outer try block ends here.
		
		//Outer catch block starts here.
		catch(SQLException e)
		{
			System.out.println(e);
		}//Outer catch block ends here.
		
		//finally block starts here.
		finally 
		{
			System.out.println("Operation complete.");
		}//Finally Block ends here.
		return toString();
	}//joinCustomerShip method ends here.

	/*
	 * Last but not least, the delete methods start here.
	 */
	
	//delCustomer starts here.
	
	public void delCustomer()throws Exception
	{
		/*
		 * THis time, this creates local variables instead of global ones since these local variables gets plugged in into the 
		 * delete stored procedure query, where the query does the rest of the job to locate and delete the values. Same goes for
		 * the rest of the delete methods.
		 */
		//Outer try block starts here.
		try {
			System.out.println("to delete, enter the customer First Name: ");
			 String dfName = scan.next();
			 //setNewfName(newfName);

			System.out.println("to delete, enter the customer Last Name: ");
			 String dlName = scan.next();
			 //setNewlName(newlName);
			
			System.out.println("to delete, enter the customerID");
			 String dCustomerID = scan.next();
			 //setNewCustomerID(newCustomerID);
			
			System.out.println("to delete, enter the customer DOB in the"
					+ " YYYY-MM-DD format, where the dashes are"
					+ " included.");
			 String dDOB = scan.next();
			 //setNewDOB(newDOB);
			
			/*
			 * After this method reads the user's inputs, the stored
			 * procedures (in java's version) gets started here.
			 */
			
			/*
			 * NOTE: if customer wants to be deleted, then the ship,
			 * fee, Transaction table associated with the customer must
			 * be deleted as well.
			 */
			String delCustomer_Proc= "{call delCustomer(?,?,?,?)}";
			Connection conn = getMySqlConnection();
			java.sql.CallableStatement CS= conn.prepareCall(delCustomer_Proc);
			//Inner try block starts here
			try {
			/*
			CS.setString(1,newCustomerID);
			CS.setString(2, newfName);
			CS.setString(3, newlName);
			CS.setString(4, newDOB);
			*/
				
			CS.setString(1,dfName);
			CS.setString(2, dlName);
			CS.setString(3, dCustomerID);
			CS.setString(4, dDOB);
			CS.execute();
				
			//String ref_newCustomerID= this.setNewCustomerID(newCustomerID);
			//String ref_newfName= this.setNewfName(newfName);
			//String ref_newlName= this.setNewlName(newlName);
			//String ref_newDOB= this.setNewDOB(newDOB);
			
				}//Inner try block ends here
			
			//Inner catch block starts here.
			catch(SQLException e)
			{
				System.out.println("Invalid inputs!");
			}//Inner catch block ends here.
		}//Outer try block ends here.
		
		//Outer catch block starts here.
		catch(Exception e)
		{
			System.out.println(e);
		}//Outer catch block ends here
		
		//Outer finally block starts here.
		finally 
		{
			System.out.println("Operation complete.");
		}//Finally Block ends here.
	}//delCustomer method ends here.
	
	//delCONTAINER_SHIP method starts here
	public void delContainer_SHIP()throws Exception
	{
		/*
		 * THis time, this creates local variables instead of global ones since these local variables gets plugged in into the 
		 * delete stored procedure query, where the query does the rest of the job to locate and delete the values. Same goes for
		 * the rest of the delete methods.
		 */
		//Outer try block starts here.
				try {
					
					System.out.println("enter the ship id: ");
					 String dShipID = scan.next();
					 //setNewShipID(newShipID);
					
					System.out.println("enter the sail schedule for the ship in the"
							+ " YYYY-MM-DD format, where the dashes are"
							+ " included.");
					 String dSail_Schedule = scan.next();
					 //setNewSail_Schedule(newSail_Schedule);
					
					System.out.println("enter the port list: ");
					 int dPort_List = scan.nextInt();
					 //setNewPort_List(newPort_List);
					
					System.out.println("enter the daily_charge: ");
					 float dDaily_Charge = scan.nextFloat();
					 //setNewDaily_Charge(newDaily_Charge);
					
					System.out.println("enter the ARRIVAL and DEPARTURE date for the ship in the"
							+ " YYYY-MM-DD format, where the dashes are"
							+ " included.");
					 String dARRIVAL = scan.next();
					 String dDEPARTURE = scan.next();
					 //setNewARRIVAL(newARRIVAL);
					 //setNewDEPARTURE(newDEPARTURE);
					
					System.out.println("enter the TID (transactionID: ");
					String dTID = scan.next();
						
					/*
					 * After this method reads the user's inputs, the stored
					 * procedures (in java's version) gets started here.
					 */
					
					/*
					 * NOTE: if customer wants to be deleted, then the ship,
					 * fee, Transaction table associated with the customer must
					 * be deleted as well.
					 */

					String delContainer_Ship_Proc= "{call delShip(?,?,?,?)}";
					Connection conn = getMySqlConnection();
					java.sql.CallableStatement CS= conn.prepareCall(delContainer_Ship_Proc);
					//Inner try block starts here
					try {
					/*
					CS.setString(1,newShipID);
					CS.setString(2, newSail_Schedule);
					CS.setInt(3, newPort_List);
					CS.setFloat(4, newDaily_Charge);
					CS.setString(5,newARRIVAL);
					CS.setString(6, newDEPARTURE);
					*/
					CS.setString(1,dShipID);
					CS.setString(2, dSail_Schedule);
					CS.setInt(3, dPort_List);
					CS.setFloat(4, dDaily_Charge);
					CS.setString(5,dARRIVAL);
					CS.setString(6, dDEPARTURE);
					CS.execute();

						}//Inner try block ends here
					
					//Inner catch block starts here.
					catch(SQLException e)
					{
						System.out.println("Invalid inputs!");
					}//Inner catch block ends here.
				}//Outer try block ends here.
				
				//Outer catch block starts here.
				catch(Exception e)
				{
					System.out.println(e);
				}//Outer catch block ends here
				
				//Outer finally block starts here.
				finally 
				{
					System.out.println("Operation complete.");
				}//Finally Block ends here.
			}//addContainer_Ship method ends here.
	
	//delTransaction method starts here.
	public void delTransaction()throws Exception
	{
		//Outer try block starts here.
		try {
			System.out.println("enter the TransactionID: ");
			 String dTID= scan.next();
			 //setTID(TID);
			
			System.out.println("enter the purchase amount: ");
			 float dPurchase = scan.nextFloat();
			 //setPurchase(purchase);
			
			String delTransaction_Proc= "{call addFee(?,?,?)}";
			Connection conn = getMySqlConnection();
			java.sql.CallableStatement CS= conn.prepareCall(delTransaction_Proc);
			//Inner try block starts here
			try {
			CS.setString(1,dTID);
			CS.setFloat(2, dPurchase);
			CS.execute();
				}//Inner try block ends here
			
			//Inner catch block starts here.
			catch(SQLException e)
			{
				System.out.println("Invalid inputs!");
			}//Inner catch block ends here.
		}//Outer try block ends here.
		
		//Outer catch block starts here.
		catch(Exception e)
		{
			System.out.println(e);
		}//Outer catch block ends here
		
		//Outer finally block starts here.
		finally 
		{
			System.out.println("Operation complete.");
		}//Finally Block ends here.
	}//addFee method ends here.

	//delFee method starts here.
	public void delFee()throws Exception{
	//Outer try block starts here.
	
			try {
				System.out.println("enter the fee: ");
				float dFee = scan.nextFloat();
				//setFee(fee);
				
				System.out.println("enter the customerID (where the customer has "
						+ "the fee): ");
				String customerID = scan.next();
				
				System.out.println("enter the shipID (the same ID for the new customer: ");
				String shipID = scan.next();
				
				/*
				 * After, the CallableStatment and its respective lines, there should
				 * also be a system.out.println that also shows the fee, customerID, and
				 * the customer's shipID.
				 */

				String delFee_Proc= "{call delFee(?,?,?)}";
				Connection conn = getMySqlConnection();
				java.sql.CallableStatement CS= conn.prepareCall(delFee_Proc);
				//Inner try block starts here
				try {
				CS.setFloat(1,dFee);
				CS.setString(2, customerID);
				CS.setString(3, shipID);
				CS.execute();

				System.out.println("Successuful operation!");
				System.out.println("Fee: "+fee+"\n"+"Customer's ID: "+customerID+"\n"+
				"Ship ID for the Customer: "+shipID);
					}//Inner try block ends here
				
				//Inner catch block starts here.
				catch(SQLException e)
				{
					System.out.println("Invalid inputs!");
				}//Inner catch block ends here.
			}//Outer try block ends here.
			
			//Outer catch block starts here.
			catch(Exception e)
			{
				System.out.println(e);
			}//Outer catch block ends here
			
			//Outer finally block starts here.
			finally 
			{
				System.out.println("Operation complete.");
			}//Finally Block ends here.
		}//addFee method ends here.
}//Class ends here
