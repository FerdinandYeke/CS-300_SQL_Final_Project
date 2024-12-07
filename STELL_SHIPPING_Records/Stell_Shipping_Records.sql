USE `STELL_SHIPPING`;
/*
This is where the STELL SHIPPING script is modified to
include some records (at least 5) to populate this database
*/
/*
First John Doe, Tom Jerr, Mary Adams, Jane Doe, and Elijah 
hill will be here in this database. (Note: These names are
just made up in the purpose for this database.) John, Tom,
Mary, Jane, & Elijah will have their own customer ID, DOB,
having their first and last name being inputted, 
*/
/*
After filling up the database values, queries will also be used here.
*/
#INSERT INTO customerID VALUES("jD00000","tJ00218","mA23431","JaD00001","eH82912");
#John doe is born on May 5th, 1981, in the format YYYY-MM-DD.
INSERT INTO CUSTOMER VALUES("jD00000","John","Doe","1981-05-01");
INSERT INTO CONTAINER_SHIP VALUES("SHLS-00019","2024-11-30 04:04:08.48888",12,2.00,"2024-12-04 04:04:08.48888","2024-12-01 04:04:08.48888");
INSERT INTO FEE VALUES('jD00000','SHLS-00019',1.25);
INSERT INTO TRANSACTION VALUES("jD00001","56.00");
#INSERT INTO cust_fName VALUES("John","Tom","Mary","Jane","Elijah");

/*
Selects the customerID that is equal to jD00000 which is John
Doe.
*/
SELECT customerID, cust_fName, cust_lName
FROM CUSTOMER
WHERE customerID = 'jD00000';

/*
Same for Tom Jerr, where he is added to the INITIAL Records.
*/
INSERT INTO CUSTOMER VALUES("tJ00200","Tom","Jerr","1984-02-04");
INSERT INTO CONTAINER_SHIP VALUES("SHLS-35091","2024-11-23 04:06:08.48888",11,2.00,"2024-12-01 04:04:08.48888","2024-11-28 04:05:07.48888");
INSERT INTO FEE VALUES('tJ00200','SHLS-35091',1.40);
INSERT INTO TRANSACTION VALUES("tJ00200","56.00");

/*
Same for Mary Adams, where she is added to the INITIAL Records.
*/
INSERT INTO CUSTOMER VALUES("mA23578","Mary","Adams","1986-03-04");
INSERT INTO CONTAINER_SHIP VALUES("SHLS-43097","2024-11-23 03:07:08.48888",11,2.00,"2024-11-27 03:05:08.48888","2024-11-25 04:05:07.48888");
INSERT INTO FEE VALUES('mA23578','SHLS-43097',1.43);
INSERT INTO TRANSACTION VALUES("mA23578","55.00");

/*
Same for Jane Doe, where she is added to the INITIAL Records.
*/
INSERT INTO CUSTOMER VALUES("jD33679","Jane","Doe","1984-03-04");
INSERT INTO CONTAINER_SHIP VALUES("SHLS-54366","2024-11-21 05:08:08.48888",14,2.00,"2024-11-25 12:06:08.48888","2024-11-23 04:02:07.48888");
INSERT INTO FEE VALUES('jD33679','SHLS-54366',1.46);
INSERT INTO TRANSACTION VALUES("jD33679","52.00");


/*
Same for Elijah Hill, where he is added to the INITIAL Records.
*/
INSERT INTO CUSTOMER VALUES("eH44825","Elijah","Hill","1989-09-12");
INSERT INTO CONTAINER_SHIP VALUES("SHLS-64364","2024-11-19 05:08:08.48888",14,2.00,"2024-11-23 15:08:08.48888","2024-11-20 10:04:07.48888");
INSERT INTO FEE VALUES('eH44825','SHLS-64364',1.46);
INSERT INTO TRANSACTION VALUES("eH44825","52.00");

/*
Now with this query, this selects from all the customers based on id, where
ID is not null.
*/
SELECT customerID, cust_fName, cust_lName
FROM CUSTOMER
WHERE customerID IS NOT NULL;

/*
With the stored procedures query in Java, there should be options
displayed first to see if the user wants to add, delete, or 
update a record, while having at least one stored procedure
output argument and input argument, and the ability to execute
at least five queries written for the database.
*/