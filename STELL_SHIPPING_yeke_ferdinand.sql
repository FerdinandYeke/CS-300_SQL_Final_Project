CREATE DATABASE STELL_SHIPPING;

CREATE TABLE CUSTOMER(
customerID VARCHAR(50),
cust_fName VARCHAR(50),
cust_lName VARCHAR(50),
DOB DATE,
PRIMARY KEY(customerID),
foreign key (TID) REFERENCES TRANSACTION(TID)
);

CREATE TABLE CONTAINER_SHIP(
shipID VARCHAR(10),
SAIL_SCHEDULE DATETIME,
Port_List INT NOT NULL,
Daily_Charge FLOAT NOT NULL,
ARRIVAL DATETIME,
DEPARTURE DATETIME,
PRIMARY KEY (shipID),
TID VARCHAR(25),
foreign key (TID) REFERENCES TRANSACTION(TID)
);

CREATE TABLE FEE(
customerID VARCHAR(50),
shipID VARCHAR(10),
foreign key(customerID) REFERENCES CUSTOMER(customerID),
foreign key(shipID) REFERENCES CONTAINER_SHIP(shipID),
fee FLOAT NOT NULL,
PRIMARY KEY (fee)
);

CREATE TABLE TRANSACTION(
TID VARCHAR(25),
purchase FLOAT NOT NULL,
PRIMARY KEY (TID)
);


/*
Down here, this will have stored procedures, where you can add information,
delete information, and update information in the database.
*/

/*
First one is adding a new customer. (Also, remember to put a 
space between the delimiter and the semicolon.)
*/

DELIMITER &&
CREATE PROCEDURE addCustomer (IN customerID VARCHAR(50),
	IN cust_fName VARCHAR(50), IN cust_lName VARCHAR(50), IN DOB DATE)
BEGIN
	INSERT INTO stell_shipping.customer
    VALUES
    (customerID, cust_fName, cust_lName, DOB);
END&& 
DELIMITER ;

/*
Next, since a new customer is added and a ship is tied to the
customer, we would also add a new ship. same as above.
*/
DELIMITER &&
CREATE PROCEDURE addShip (IN shipID VARCHAR(10),
	IN SAIL_SCHEDULE DATETIME, IN Port_List INT, IN Daily_Charge FLOAT,
    IN ARRIVAL DATETIME, IN DEPARTURE DATETIME)
BEGIN
	INSERT INTO stell_shipping.CONTAINER_SHIP
    VALUES
    (SAIL_SCHEDULE, Port_List, Daily_Charge, ARRIVAL, DEPARTURE);
END&& 
DELIMITER ;

/*
Next is the fee, where it has the input parameter and output 
fee, while also having input parameters customerID and shipID.
*/
DELIMITER &&
CREATE PROCEDURE addFee (INOUT fee float, 
INOUT customerID VARCHAR(50), INOUT shipID VARCHAR(10))
BEGIN
	INSERT INTO stell_shipping.FEE
    VALUES
	(fee,customerID,shipID);
END&& 
DELIMITER ;

/*
Finally, the stored procedure addTranaction is made here, wheree
it has input parameters TID and purchase, while also having
out parameters which is TID and purchase
*/
DELIMITER &&
CREATE PROCEDURE addTransaction (INOUT TID VARCHAR(25),
INOUT purchase FLOAT)
BEGIN
	INSERT INTO stell_shipping.TRANSACTION
    VALUES
	(TID,purchase);
END&& 
DELIMITER ;

/*
Next, the update procedures will be made here (NOTE: ideally in
this context, the two tables appropriate for updates are the
customer table and the CONTAINER_SHIP table.
*/

/*
The customer table will have the same parameters, HOWEVER, all
of them must also have an out parameters for the values, so
that it is confirmed that the customer's value has been updated, same
thing for the CONTAINER_SHIP table.
*/
DELIMITER &&
CREATE PROCEDURE updateCustomer (INOUT customerID VARCHAR(50),
	INOUT cust_fName VARCHAR(50), IN cust_lName VARCHAR(50), INOUT DOB DATE)
BEGIN
UPDATE CUSTOMER
	SET customerID= customerID;
    SET cust_fName= cust_fName;
    SET cust_lName= cust_lName;
    SET DOB= DOB;
END&& 
DELIMITER ;

/*
Same for ship (again, U for updated).
*/
DELIMITER &&
CREATE PROCEDURE updateShip (INOUT shipID VARCHAR(10),
	INOUT SAIL_SCHEDULE DATETIME, INOUT Port_List INT, INOUT Daily_Charge FLOAT,
    INOUT ARRIVAL DATETIME, INOUT DEPARTURE DATETIME)
BEGIN
UPDATE SHIP
    SET shipID = shipID;
    SET SAIL_SCHEDULE = SAIL_SCHEDULE;
    SET Port_List = Port_List;
    SET Daily_Charge = Daily_Charge;
    SET ARRIVAL = ARRIVAL;
    SET DEPARTURE = DEPARTURE;
END&& 
DELIMITER ;

/*
Next, there will be a stored procedure for join tables of
customer and ship.
*/

DELIMITER &&
CREATE PROCEDURE joinCustomerSHIP(IN shipID VARCHAR(10),
	IN SAIL_SCHEDULE DATETIME, IN Port_List INT, IN Daily_Charge FLOAT,
    IN ARRIVAL DATETIME, IN DEPARTURE DATETIME, IN customerID VARCHAR(50),
	IN cust_fName VARCHAR(50), IN cust_lName VARCHAR(50), IN DOB DATE)
    BEGIN
		SET 
		shipID = shipID,
		SAIL_SCHEDULE = SAIL_SCHEDULE,
		Port_List = Port_List,
		Daily_Charge = Daily_Charge,
		ARRIVAL = ARRIVAL,
		DEPARTURE = DEPARTURE,
		customerID = customerID,
		cust_fName = cust_fName,
		cust_lName = cust_lName,
		DOB = DOB;
    
    SELECT shipID, SAIL_SCHEDULE, Port_List, Daily_Charge, ARRIVAL, DEPARTURE,
    customerID, cust_fName, cust_lName, DOB
    FROM CUSTOMER JOIN CONTAINER_SHIP;
END&&
DELIMITER ;

/*
Next, there will be a stored procedure for deleting a record
of customer, ship, transaction, and fee.
*/
DELIMITER &&
CREATE PROCEDURE delCustomer(IN customerID VARCHAR(50),
	IN cust_fName VARCHAR(50), IN cust_lName VARCHAR(50), IN DOB DATE)
    BEGIN
		DELETE from CUSTOMER
        WHERE customerID=customerID AND cust_fName=cust_fName 
        AND cust_lName=cust_lName AND DOB = DOB;
	END &&
DELIMITER ;
/*
Same for ship.
*/   

DELIMITER &&
CREATE PROCEDURE delSHIP(IN shipID VARCHAR(10),
	IN SAIL_SCHEDULE DATETIME, IN Port_List INT, IN Daily_Charge FLOAT,
    IN ARRIVAL DATETIME, IN DEPARTURE DATETIME)
    BEGIN
		DELETE from CONTAINER_SHIP
        WHERE shipID=shipID AND SAIL_SCHEDULE=SAIL_SCHEDULE 
        AND Port_List=Port_List AND Daily_Charge = Daily_Charge AND ARRIVAL = ARRIVAL
        AND DEPARTURE = DEPARTURE;
	END &&
DELIMITER ;

/*
Same for fee.
*/ 
DELIMITER &&
CREATE PROCEDURE delFee(IN fee float, 
IN customerID VARCHAR(50), IN shipID VARCHAR(10))
    BEGIN
		DELETE from FEE
        WHERE shipID=shipID AND fee=Fee AND customerID=customerID;
	END &&
DELIMITER ;

/*
Same for transaction.
*/
DELIMITER &&
CREATE PROCEDURE delTransaction(IN TID VARCHAR(25),
IN dPurchase FLOAT)
    BEGIN
		DELETE from TRANSACTION
        WHERE TID=TID AND purchase=Purchase;
	END &&
DELIMITER ;

/*
Stored Procedures for STELL_SHIPPING ends here.
*/

