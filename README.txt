Author: Ferdinand Yeke
Written on: 12/6/2024

Welcome to the README Docs of the STELL_SHIPPING Database! Here in this folder contains the Updated STELL SHIPPING SQL
file with slight improvements, the STELL SHIPPING PROCEDURE class, and the main method class that runs the code, both of which are written
in java. The Stell shipping procedure class contains about 13 methods for the stored procedures, while the 
rest is about 23 which are getters and setters for the related tuples in the database. 



First off, the connection method, getMySqlConnection gets the connection from the STELL_SHIPPING database using
the mysql-connector-j-9.1.0.jar file and uses it to actually connect to the base.
 
Next is the addCustomer method, where it calls the stored procedure addCustomer, while reading inputs from the
keyboard for each tuple/attribute.

After that, is the addContainer_Ship method, where it calls the stored procedure addShip, while reading inputs from the
keyboard for each tuple/attribute.

Next is the addFee method, where it calls the stored procedure addFee, while reading inputs from the
keyboard for each tuple/attribute.

Next is the addTransaction method, where it calls the stored procedure addTransaction while reading inputs from the
keyboard for each tuple/attribute.

Next is the updateCustomer, where it calls the stored procedure updateCustomer, while reading inputs from the
keyboard for each tuple/attribute.

Next is the updateShip, where it calls the stored procedure updateShip, while reading inputs from the
keyboard for each tuple/attribute.

Next is the overridden method toString, where it overrides the original toString method to get all the tuples
and put them in a string format.

Next is the joinCustomerSHIP method, where it calls the stored procedure joinCustomerSHIP, while reading inputs from the
keyboard for each tuple/attribute.

Next is the delCustomer method, where it calls the stored procedure delCustomer, while reading inputs from the
keyboard for each tuple/attribute.

Next is the delContainer_SHIP method, where it calls the stored procedure delSHIP while reading inputs from the
keyboard for each tuple/attribute.

Next is the delTransaction method, where it calls the stored procedure delTransaction, while reading inputs from the
keyboard for each tuple/attribute.

Last but not least is the delFee method, where it calls the stored procedure delFee, while reading 
inputs from the keyboard for each tuple/attribute.

Finally, the main method, where it uses all these methods while still connecting to the database, puts them in a
while loop with a switch case for the user to choose what operation to use for this database.

